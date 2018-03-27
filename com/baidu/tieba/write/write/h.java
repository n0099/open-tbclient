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
import com.baidu.tieba.write.write.b;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements b.a, com.baidu.tieba.write.write.model.a {
    private com.baidu.tbadk.core.util.b.a bQG;
    private g hKt;
    private com.baidu.tbadk.core.dialog.a hKu;
    private ForumWriteData hxd;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public b hMJ = null;
    private int hMK = 0;
    private int hML = 0;
    private int hMM = 0;
    private WriteImagesInfo hMN = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hMO = new HashMap<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hKt = gVar;
        initData(bundle);
        initListener();
        bIi();
    }

    public void bIi() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.bJE();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dY(List<String> list) {
        if (this.hKt != null) {
            this.hKt.dX(list);
        }
    }

    private void initListener() {
        if (this.hKt != null) {
            if (this.hKt.hMA != null) {
                this.hKt.hMA.r(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hMJ.Z(Integer.parseInt(view.getTag().toString()), h.this.bIm());
                        }
                    }
                });
            }
            if (this.hKt.hME != null) {
                this.hKt.hME.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (h.this.mPageContext != null) {
                            Activity pageActivity = h.this.mPageContext.getPageActivity();
                            if (h.this.bQG == null) {
                                h.this.bQG = new com.baidu.tbadk.core.util.b.a();
                            }
                            h.this.bQG.DI();
                            h.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!h.this.bQG.v(pageActivity)) {
                                h.this.hMJ.nS(false);
                                if (h.this.hKt != null) {
                                    if (h.this.hMN == null || h.this.hMN.getChosedFiles() == null || h.this.hMN.getChosedFiles().size() <= 0 || !h.this.hMN.isOriginalImg() || h.this.hML <= 0 || !h.this.bJk()) {
                                        h.this.hKt.b(true, h.this.hMN);
                                    } else {
                                        h.this.hKt.bJh();
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
            this.hMK = bundle.getInt("OutState_Write_Entrance");
            this.hxd = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hMK = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hxd = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hMN = new WriteImagesInfo();
            this.hMN.parseJson(str);
            bJi();
            if (this.hKt != null && this.hKt.hMC != null) {
                this.hMJ = new b(this.mPageContext.getOrignalPage(), this.hKt.hMC, this.hMN.getChosedFiles(), i, this, this.hKt, this.hMN.mIsFromIm);
                this.hKt.hMC.setAdapter(this.hMJ);
                this.hKt.hMC.setCurrentItem(i, true);
                if (i == 0) {
                    this.hMJ.onPageSelected(0);
                }
                this.hKt.d(this.hMN);
            }
        }
    }

    private void bJi() {
        if (this.hMN != null && this.hMN.isOriginalImg() && this.hMN.getChosedFiles() != null && this.hMN.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hMN.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hMO.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bJj() {
        return this.hMK;
    }

    public ForumWriteData avo() {
        return this.hxd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJk() {
        if (this.hMN == null || !this.hMN.isOriginalImg() || this.hMN.getChosedFiles() == null || this.hMN.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hMN.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hMO.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIj() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIk() {
        this.hMM++;
        if (this.hMM > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIl() {
        this.hMM--;
        if (this.hMM == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bIm() {
        return (this.hKt == null || this.hKt.hMD == null || v.E(this.hKt.hMD.getStickerViews())) ? false : true;
    }

    public void bJf() {
        this.hML++;
    }

    public void bJg() {
        this.hML--;
    }

    public WriteImagesInfo bJl() {
        return this.hMN;
    }

    public void ob(boolean z) {
        if (bIm()) {
            this.hKt.hMC.setmDisallowSlip(true);
        } else {
            this.hKt.hMC.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIh() {
        bJg();
        ob(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void aa(int i, boolean z) {
        ab(i, z);
    }

    private void ab(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hKu == null) {
                this.hKu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hKu.fb(d.j.orginal_tip);
                this.hKu.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hKu != null) {
                            h.this.hKu.dismiss();
                        }
                        if (h.this.hMJ != null) {
                            h.this.hMJ.Z(i, z);
                        }
                    }
                });
                this.hKu.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hKu != null) {
                            h.this.hKu.dismiss();
                        }
                    }
                });
                this.hKu.b(this.mPageContext);
            }
            this.hKu.AV();
        }
    }

    public boolean F(final Bitmap bitmap) {
        if (!this.hMJ.bIe() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hKu == null) {
            this.hKu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hKu.fb(d.j.orginal_tip);
            this.hKu.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hKu != null) {
                        h.this.hKu.dismiss();
                    }
                    h.this.hKt.E(bitmap);
                }
            });
            this.hKu.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hKu != null) {
                        h.this.hKu.dismiss();
                    }
                }
            });
            this.hKu.b(this.mPageContext);
        }
        this.hKu.AV();
        return true;
    }
}
