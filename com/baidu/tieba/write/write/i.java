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
    private ForumWriteData gSi;
    private h hgb;
    private com.baidu.tbadk.core.dialog.a hgc;
    private StickerModel hiw;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hiu = null;
    private int hiv = 0;
    private int hix = 0;
    private WriteImagesInfo hiy = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hiz = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hgb = hVar;
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
            if (this.hiw == null) {
                this.hiw = new StickerModel(this.mPageContext);
            }
            this.hiw.LoadData();
            this.hiw.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dM(List<String> list) {
        if (this.hgb != null) {
            this.hgb.dL(list);
        }
    }

    private void initListener() {
        if (this.hgb != null) {
            if (this.hgb.hin != null) {
                this.hgb.hin.t(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (view2.getTag() != null) {
                            i.this.hiu.I(Integer.parseInt(view2.getTag().toString()), i.this.bCW());
                        }
                    }
                });
            }
            if (this.hgb.hiq != null) {
                this.hgb.hiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.hiu.nu(false);
                                if (i.this.hgb != null) {
                                    if (i.this.hiy == null || i.this.hiy.getChosedFiles() == null || i.this.hiy.getChosedFiles().size() <= 0 || !i.this.hiy.isOriginalImg() || i.this.hix <= 0 || !i.this.bDX()) {
                                        i.this.hgb.b(true, i.this.hiy);
                                    } else {
                                        i.this.hgb.bDU();
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
            this.hiv = bundle.getInt("OutState_Write_Entrance");
            this.gSi = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hiv = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.gSi = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hiy = new WriteImagesInfo();
            this.hiy.parseJson(str);
            bDV();
            if (this.hgb != null && this.hgb.hio != null) {
                this.hiu = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hgb.hio, this.hiy.getChosedFiles(), i, this, this.hgb, this.hiy.mIsFromIm);
                this.hgb.hio.setAdapter(this.hiu);
                this.hgb.hio.setCurrentItem(i, true);
                if (i == 0) {
                    this.hiu.onPageSelected(0);
                }
                this.hgb.d(this.hiy);
            }
        }
    }

    private void bDV() {
        if (this.hiy != null && this.hiy.isOriginalImg() && this.hiy.getChosedFiles() != null && this.hiy.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hiy.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hiz.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bDW() {
        return this.hiv;
    }

    public ForumWriteData apH() {
        return this.gSi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDX() {
        if (this.hiy == null || !this.hiy.isOriginalImg() || this.hiy.getChosedFiles() == null || this.hiy.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hiy.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hiz.get(next.getFilePath()))) {
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
        return (this.hgb == null || this.hgb.hip == null || v.w(this.hgb.hip.getStickerViews())) ? false : true;
    }

    public void bDT() {
        this.hix++;
    }

    public void bDY() {
        this.hix--;
    }

    public WriteImagesInfo bDZ() {
        return this.hiy;
    }

    public void nA(boolean z) {
        if (bCW()) {
            this.hgb.hio.setmDisallowSlip(true);
        } else {
            this.hgb.hio.setmDisallowSlip(false);
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
            if (this.hgc == null) {
                this.hgc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hgc.bZ(d.k.orginal_tip);
                this.hgc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hgc != null) {
                            i.this.hgc.dismiss();
                        }
                        if (i.this.hiu != null) {
                            i.this.hiu.I(i, z);
                        }
                    }
                });
                this.hgc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hgc != null) {
                            i.this.hgc.dismiss();
                        }
                    }
                });
                this.hgc.b(this.mPageContext);
            }
            this.hgc.tD();
        }
    }

    public boolean J(final Bitmap bitmap) {
        if (!this.hiu.bCQ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hgc == null) {
            this.hgc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hgc.bZ(d.k.orginal_tip);
            this.hgc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hgc != null) {
                        i.this.hgc.dismiss();
                    }
                    i.this.hgb.I(bitmap);
                }
            });
            this.hgc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hgc != null) {
                        i.this.hgc.dismiss();
                    }
                }
            });
            this.hgc.b(this.mPageContext);
        }
        this.hgc.tD();
        return true;
    }

    public void destroy() {
        if (this.hiw != null) {
            this.hiw.destroy();
        }
    }
}
