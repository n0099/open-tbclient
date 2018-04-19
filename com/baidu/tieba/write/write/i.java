package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private com.baidu.tbadk.core.util.b.a baD;
    private ForumWriteData gSl;
    private h hge;
    private com.baidu.tbadk.core.dialog.a hgf;
    private StickerModel hiz;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hix = null;
    private int hiy = 0;
    private int hiA = 0;
    private WriteImagesInfo hiB = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hiC = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hge = hVar;
        initData(bundle);
        initListener();
        bCU();
    }

    public void bCU() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.k.neterror);
                    return;
                }
                return;
            }
            if (this.hiz == null) {
                this.hiz = new StickerModel(this.mPageContext);
            }
            this.hiz.LoadData();
            this.hiz.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dM(List<String> list) {
        if (this.hge != null) {
            this.hge.dL(list);
        }
    }

    private void initListener() {
        if (this.hge != null) {
            if (this.hge.hiq != null) {
                this.hge.hiq.t(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (view2.getTag() != null) {
                            i.this.hix.I(Integer.parseInt(view2.getTag().toString()), i.this.bCW());
                        }
                    }
                });
            }
            if (this.hge.hit != null) {
                this.hge.hit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.baD == null) {
                                i.this.baD = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.baD.wu();
                            i.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.baD.v(pageActivity)) {
                                i.this.hix.nu(false);
                                if (i.this.hge != null) {
                                    if (i.this.hiB == null || i.this.hiB.getChosedFiles() == null || i.this.hiB.getChosedFiles().size() <= 0 || !i.this.hiB.isOriginalImg() || i.this.hiA <= 0 || !i.this.bDX()) {
                                        i.this.hge.b(true, i.this.hiB);
                                    } else {
                                        i.this.hge.bDU();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void initData(Bundle bundle) {
        int i;
        Intent intent;
        String str = null;
        if (bundle != null) {
            String string = bundle.getString("OutState_Write_Img_Info");
            i = bundle.getInt("OutState_Current_Index");
            this.hiy = bundle.getInt("OutState_Write_Entrance");
            this.gSl = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hiy = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.gSl = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hiB = new WriteImagesInfo();
            this.hiB.parseJson(str);
            bDV();
            if (this.hge != null && this.hge.hir != null) {
                this.hix = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hge.hir, this.hiB.getChosedFiles(), i, this, this.hge, this.hiB.mIsFromIm);
                this.hge.hir.setAdapter(this.hix);
                this.hge.hir.setCurrentItem(i, true);
                if (i == 0) {
                    this.hix.onPageSelected(0);
                }
                this.hge.d(this.hiB);
            }
        }
    }

    private void bDV() {
        if (this.hiB != null && this.hiB.isOriginalImg() && this.hiB.getChosedFiles() != null && this.hiB.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hiB.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hiC.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bDW() {
        return this.hiy;
    }

    public ForumWriteData apH() {
        return this.gSl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDX() {
        if (this.hiB == null || !this.hiB.isOriginalImg() || this.hiB.getChosedFiles() == null || this.hiB.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hiB.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hiC.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bCV() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bCW() {
        return (this.hge == null || this.hge.his == null || v.w(this.hge.his.getStickerViews())) ? false : true;
    }

    public void bDT() {
        this.hiA++;
    }

    public void bDY() {
        this.hiA--;
    }

    public WriteImagesInfo bDZ() {
        return this.hiB;
    }

    public void nA(boolean z) {
        if (bCW()) {
            this.hge.hir.setmDisallowSlip(true);
        } else {
            this.hge.hir.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bCT() {
        bDY();
        nA(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hgf == null) {
                this.hgf = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hgf.bZ(d.k.orginal_tip);
                this.hgf.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hgf != null) {
                            i.this.hgf.dismiss();
                        }
                        if (i.this.hix != null) {
                            i.this.hix.I(i, z);
                        }
                    }
                });
                this.hgf.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hgf != null) {
                            i.this.hgf.dismiss();
                        }
                    }
                });
                this.hgf.b(this.mPageContext);
            }
            this.hgf.tD();
        }
    }

    public boolean J(final Bitmap bitmap) {
        if (!this.hix.bCQ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hgf == null) {
            this.hgf = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hgf.bZ(d.k.orginal_tip);
            this.hgf.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hgf != null) {
                        i.this.hgf.dismiss();
                    }
                    i.this.hge.I(bitmap);
                }
            });
            this.hgf.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hgf != null) {
                        i.this.hgf.dismiss();
                    }
                }
            });
            this.hgf.b(this.mPageContext);
        }
        this.hgf.tD();
        return true;
    }

    public void destroy() {
        if (this.hiz != null) {
            this.hiz.destroy();
        }
    }
}
