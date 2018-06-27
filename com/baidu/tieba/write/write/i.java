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
import com.baidu.tbadk.core.util.w;
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
    private com.baidu.tbadk.core.util.b.a bkp;
    private ForumWriteData hiU;
    private h hxk;
    private com.baidu.tbadk.core.dialog.a hxl;
    private StickerModel hzE;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hzC = null;
    private int hzD = 0;
    private int hzF = 0;
    private WriteImagesInfo hzG = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hzH = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hxk = hVar;
        initData(bundle);
        initListener();
        bIy();
    }

    public void bIy() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jD()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.k.neterror);
                    return;
                }
                return;
            }
            if (this.hzE == null) {
                this.hzE = new StickerModel(this.mPageContext);
            }
            this.hzE.LoadData();
            this.hzE.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dY(List<String> list) {
        if (this.hxk != null) {
            this.hxk.dX(list);
        }
    }

    private void initListener() {
        if (this.hxk != null) {
            if (this.hxk.hzv != null) {
                this.hxk.hzv.w(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hzC.I(Integer.parseInt(view.getTag().toString()), i.this.bIA());
                        }
                    }
                });
            }
            if (this.hxk.hzy != null) {
                this.hxk.hzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bkp == null) {
                                i.this.bkp = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bkp.Aj();
                            i.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bkp.u(pageActivity)) {
                                i.this.hzC.nL(false);
                                if (i.this.hxk != null) {
                                    if (i.this.hzG == null || i.this.hzG.getChosedFiles() == null || i.this.hzG.getChosedFiles().size() <= 0 || !i.this.hzG.isOriginalImg() || i.this.hzF <= 0 || !i.this.bJB()) {
                                        i.this.hxk.b(true, i.this.hzG);
                                    } else {
                                        i.this.hxk.bJy();
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
            this.hzD = bundle.getInt("OutState_Write_Entrance");
            this.hiU = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hzD = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hiU = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hzG = new WriteImagesInfo();
            this.hzG.parseJson(str);
            bJz();
            if (this.hxk != null && this.hxk.hzw != null) {
                this.hzC = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hxk.hzw, this.hzG.getChosedFiles(), i, this, this.hxk, this.hzG.mIsFromIm);
                this.hxk.hzw.setAdapter(this.hzC);
                this.hxk.hzw.setCurrentItem(i, true);
                if (i == 0) {
                    this.hzC.onPageSelected(0);
                }
                this.hxk.d(this.hzG);
            }
        }
    }

    private void bJz() {
        if (this.hzG != null && this.hzG.isOriginalImg() && this.hzG.getChosedFiles() != null && this.hzG.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hzG.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hzH.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bJA() {
        return this.hzD;
    }

    public ForumWriteData auc() {
        return this.hiU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJB() {
        if (this.hzG == null || !this.hzG.isOriginalImg() || this.hzG.getChosedFiles() == null || this.hzG.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hzG.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hzH.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bIz() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bIA() {
        return (this.hxk == null || this.hxk.hzx == null || w.A(this.hxk.hzx.getStickerViews())) ? false : true;
    }

    public void bJx() {
        this.hzF++;
    }

    public void bJC() {
        this.hzF--;
    }

    public WriteImagesInfo bJD() {
        return this.hzG;
    }

    public void nQ(boolean z) {
        if (bIA()) {
            this.hxk.hzw.setmDisallowSlip(true);
        } else {
            this.hxk.hzw.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bIx() {
        bJC();
        nQ(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hxl == null) {
                this.hxl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hxl.cd(d.k.orginal_tip);
                this.hxl.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hxl != null) {
                            i.this.hxl.dismiss();
                        }
                        if (i.this.hzC != null) {
                            i.this.hzC.I(i, z);
                        }
                    }
                });
                this.hxl.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hxl != null) {
                            i.this.hxl.dismiss();
                        }
                    }
                });
                this.hxl.b(this.mPageContext);
            }
            this.hxl.xn();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hzC.bIu() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hxl == null) {
            this.hxl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hxl.cd(d.k.orginal_tip);
            this.hxl.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hxl != null) {
                        i.this.hxl.dismiss();
                    }
                    i.this.hxk.H(bitmap);
                }
            });
            this.hxl.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hxl != null) {
                        i.this.hxl.dismiss();
                    }
                }
            });
            this.hxl.b(this.mPageContext);
        }
        this.hxl.xn();
        return true;
    }

    public void destroy() {
        if (this.hzE != null) {
            this.hzE.destroy();
        }
    }
}
