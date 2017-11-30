package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
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
    private ForumWriteData gVN;
    private g hhF;
    private com.baidu.tbadk.core.dialog.a hhG;
    public b hjT = null;
    private int hjU = 0;
    private int hjV = 0;
    private int hjW = 0;
    private WriteImagesInfo hjX = null;
    private HashMap<String, String> hjY = new HashMap<>();
    private TbPageContext<WriteMultiImgsActivity> mPageContext;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hhF = gVar;
        initData(bundle);
        initListener();
        bHn();
    }

    public void bHn() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.bts();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dq(List<String> list) {
        if (this.hhF != null) {
            this.hhF.ed(list);
        }
    }

    private void initListener() {
        if (this.hhF != null) {
            if (this.hhF.hjK != null) {
                this.hhF.hjK.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hjT.I(Integer.parseInt(view.getTag().toString()), h.this.bHr());
                        }
                    }
                });
            }
            if (this.hhF.hjO != null) {
                this.hhF.hjO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.hjT.oe(false);
                        if (h.this.hhF != null) {
                            if (h.this.hjX == null || h.this.hjX.getChosedFiles() == null || h.this.hjX.getChosedFiles().size() <= 0 || !h.this.hjX.isOriginalImg() || h.this.hjV <= 0 || !h.this.bIm()) {
                                h.this.hhF.b(true, h.this.hjX);
                            } else {
                                h.this.hhF.bIj();
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
            this.hjU = bundle.getInt("OutState_Write_Entrance");
            this.gVN = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hjU = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.gVN = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hjX = new WriteImagesInfo();
            this.hjX.parseJson(str);
            bIk();
            if (this.hhF != null && this.hhF.hjM != null) {
                this.hjT = new b(this.mPageContext.getOrignalPage(), this.hhF.hjM, this.hjX.getChosedFiles(), i, this, this.hhF, this.hjX.mIsFromIm);
                this.hhF.hjM.setAdapter(this.hjT);
                this.hhF.hjM.setCurrentItem(i, true);
                if (i == 0) {
                    this.hjT.onPageSelected(0);
                }
                this.hhF.d(this.hjX);
            }
        }
    }

    private void bIk() {
        if (this.hjX != null && this.hjX.isOriginalImg() && this.hjX.getChosedFiles() != null && this.hjX.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hjX.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hjY.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIl() {
        return this.hjU;
    }

    public ForumWriteData alz() {
        return this.gVN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIm() {
        if (this.hjX == null || !this.hjX.isOriginalImg() || this.hjX.getChosedFiles() == null || this.hjX.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hjX.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hjY.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHo() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHp() {
        this.hjW++;
        if (this.hjW > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHq() {
        this.hjW--;
        if (this.hjW == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bHr() {
        return (this.hhF == null || this.hhF.hjN == null || v.w(this.hhF.hjN.getStickerViews())) ? false : true;
    }

    public void bIh() {
        this.hjV++;
    }

    public void bIi() {
        this.hjV--;
    }

    public WriteImagesInfo bIn() {
        return this.hjX;
    }

    public void om(boolean z) {
        if (bHr()) {
            this.hhF.hjM.setmDisallowSlip(true);
        } else {
            this.hhF.hjM.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHm() {
        bIi();
        om(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void J(int i, boolean z) {
        K(i, z);
    }

    private void K(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hhG == null) {
                this.hhG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hhG.cd(d.j.orginal_tip);
                this.hhG.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hhG != null) {
                            h.this.hhG.dismiss();
                        }
                        if (h.this.hjT != null) {
                            h.this.hjT.I(i, z);
                        }
                    }
                });
                this.hhG.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hhG != null) {
                            h.this.hhG.dismiss();
                        }
                    }
                });
                this.hhG.b(this.mPageContext);
            }
            this.hhG.tk();
        }
    }

    public boolean B(final Bitmap bitmap) {
        if (!this.hjT.bHj() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hhG == null) {
            this.hhG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hhG.cd(d.j.orginal_tip);
            this.hhG.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hhG != null) {
                        h.this.hhG.dismiss();
                    }
                    h.this.hhF.A(bitmap);
                }
            });
            this.hhG.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hhG != null) {
                        h.this.hhG.dismiss();
                    }
                }
            });
            this.hhG.b(this.mPageContext);
        }
        this.hhG.tk();
        return true;
    }
}
