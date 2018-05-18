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
    private com.baidu.tbadk.core.util.b.a baE;
    private ForumWriteData gTm;
    private h hhf;
    private com.baidu.tbadk.core.dialog.a hhg;
    private StickerModel hjA;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hjy = null;
    private int hjz = 0;
    private int hjB = 0;
    private WriteImagesInfo hjC = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hjD = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hhf = hVar;
        initData(bundle);
        initListener();
        bCS();
    }

    public void bCS() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.k.neterror);
                    return;
                }
                return;
            }
            if (this.hjA == null) {
                this.hjA = new StickerModel(this.mPageContext);
            }
            this.hjA.LoadData();
            this.hjA.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dP(List<String> list) {
        if (this.hhf != null) {
            this.hhf.dO(list);
        }
    }

    private void initListener() {
        if (this.hhf != null) {
            if (this.hhf.hjr != null) {
                this.hhf.hjr.t(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (view2.getTag() != null) {
                            i.this.hjy.I(Integer.parseInt(view2.getTag().toString()), i.this.bCU());
                        }
                    }
                });
            }
            if (this.hhf.hju != null) {
                this.hhf.hju.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.baE == null) {
                                i.this.baE = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.baE.wt();
                            i.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.baE.v(pageActivity)) {
                                i.this.hjy.nv(false);
                                if (i.this.hhf != null) {
                                    if (i.this.hjC == null || i.this.hjC.getChosedFiles() == null || i.this.hjC.getChosedFiles().size() <= 0 || !i.this.hjC.isOriginalImg() || i.this.hjB <= 0 || !i.this.bDV()) {
                                        i.this.hhf.b(true, i.this.hjC);
                                    } else {
                                        i.this.hhf.bDS();
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
            this.hjz = bundle.getInt("OutState_Write_Entrance");
            this.gTm = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hjz = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.gTm = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hjC = new WriteImagesInfo();
            this.hjC.parseJson(str);
            bDT();
            if (this.hhf != null && this.hhf.hjs != null) {
                this.hjy = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hhf.hjs, this.hjC.getChosedFiles(), i, this, this.hhf, this.hjC.mIsFromIm);
                this.hhf.hjs.setAdapter(this.hjy);
                this.hhf.hjs.setCurrentItem(i, true);
                if (i == 0) {
                    this.hjy.onPageSelected(0);
                }
                this.hhf.d(this.hjC);
            }
        }
    }

    private void bDT() {
        if (this.hjC != null && this.hjC.isOriginalImg() && this.hjC.getChosedFiles() != null && this.hjC.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hjC.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hjD.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bDU() {
        return this.hjz;
    }

    public ForumWriteData apG() {
        return this.gTm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDV() {
        if (this.hjC == null || !this.hjC.isOriginalImg() || this.hjC.getChosedFiles() == null || this.hjC.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hjC.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hjD.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bCT() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bCU() {
        return (this.hhf == null || this.hhf.hjt == null || v.w(this.hhf.hjt.getStickerViews())) ? false : true;
    }

    public void bDR() {
        this.hjB++;
    }

    public void bDW() {
        this.hjB--;
    }

    public WriteImagesInfo bDX() {
        return this.hjC;
    }

    public void nB(boolean z) {
        if (bCU()) {
            this.hhf.hjs.setmDisallowSlip(true);
        } else {
            this.hhf.hjs.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bCR() {
        bDW();
        nB(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hhg == null) {
                this.hhg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hhg.ca(d.k.orginal_tip);
                this.hhg.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hhg != null) {
                            i.this.hhg.dismiss();
                        }
                        if (i.this.hjy != null) {
                            i.this.hjy.I(i, z);
                        }
                    }
                });
                this.hhg.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hhg != null) {
                            i.this.hhg.dismiss();
                        }
                    }
                });
                this.hhg.b(this.mPageContext);
            }
            this.hhg.tC();
        }
    }

    public boolean J(final Bitmap bitmap) {
        if (!this.hjy.bCO() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hhg == null) {
            this.hhg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hhg.ca(d.k.orginal_tip);
            this.hhg.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hhg != null) {
                        i.this.hhg.dismiss();
                    }
                    i.this.hhf.I(bitmap);
                }
            });
            this.hhg.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hhg != null) {
                        i.this.hhg.dismiss();
                    }
                }
            });
            this.hhg.b(this.mPageContext);
        }
        this.hhg.tC();
        return true;
    }

    public void destroy() {
        if (this.hjA != null) {
            this.hjA.destroy();
        }
    }
}
