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
    private ForumWriteData gYE;
    private g hkD;
    private com.baidu.tbadk.core.dialog.a hkE;
    public b hmQ = null;
    private int hmR = 0;
    private int hmS = 0;
    private int hmT = 0;
    private WriteImagesInfo hmU = null;
    private HashMap<String, String> hmV = new HashMap<>();
    private TbPageContext<WriteMultiImgsActivity> mPageContext;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hkD = gVar;
        initData(bundle);
        initListener();
        bIa();
    }

    public void bIa() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.btY();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dp(List<String> list) {
        if (this.hkD != null) {
            this.hkD.ec(list);
        }
    }

    private void initListener() {
        if (this.hkD != null) {
            if (this.hkD.hmH != null) {
                this.hkD.hmH.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hmQ.I(Integer.parseInt(view.getTag().toString()), h.this.bIe());
                        }
                    }
                });
            }
            if (this.hkD.hmL != null) {
                this.hkD.hmL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.hmQ.of(false);
                        if (h.this.hkD != null) {
                            if (h.this.hmU == null || h.this.hmU.getChosedFiles() == null || h.this.hmU.getChosedFiles().size() <= 0 || !h.this.hmU.isOriginalImg() || h.this.hmS <= 0 || !h.this.bIZ()) {
                                h.this.hkD.b(true, h.this.hmU);
                            } else {
                                h.this.hkD.bIW();
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
            this.hmR = bundle.getInt("OutState_Write_Entrance");
            this.gYE = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hmR = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.gYE = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hmU = new WriteImagesInfo();
            this.hmU.parseJson(str);
            bIX();
            if (this.hkD != null && this.hkD.hmJ != null) {
                this.hmQ = new b(this.mPageContext.getOrignalPage(), this.hkD.hmJ, this.hmU.getChosedFiles(), i, this, this.hkD, this.hmU.mIsFromIm);
                this.hkD.hmJ.setAdapter(this.hmQ);
                this.hkD.hmJ.setCurrentItem(i, true);
                if (i == 0) {
                    this.hmQ.onPageSelected(0);
                }
                this.hkD.d(this.hmU);
            }
        }
    }

    private void bIX() {
        if (this.hmU != null && this.hmU.isOriginalImg() && this.hmU.getChosedFiles() != null && this.hmU.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hmU.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hmV.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIY() {
        return this.hmR;
    }

    public ForumWriteData alI() {
        return this.gYE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIZ() {
        if (this.hmU == null || !this.hmU.isOriginalImg() || this.hmU.getChosedFiles() == null || this.hmU.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hmU.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hmV.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIb() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIc() {
        this.hmT++;
        if (this.hmT > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bId() {
        this.hmT--;
        if (this.hmT == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bIe() {
        return (this.hkD == null || this.hkD.hmK == null || v.w(this.hkD.hmK.getStickerViews())) ? false : true;
    }

    public void bIU() {
        this.hmS++;
    }

    public void bIV() {
        this.hmS--;
    }

    public WriteImagesInfo bJa() {
        return this.hmU;
    }

    public void on(boolean z) {
        if (bIe()) {
            this.hkD.hmJ.setmDisallowSlip(true);
        } else {
            this.hkD.hmJ.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHZ() {
        bIV();
        on(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void J(int i, boolean z) {
        K(i, z);
    }

    private void K(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hkE == null) {
                this.hkE = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hkE.cd(d.j.orginal_tip);
                this.hkE.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hkE != null) {
                            h.this.hkE.dismiss();
                        }
                        if (h.this.hmQ != null) {
                            h.this.hmQ.I(i, z);
                        }
                    }
                });
                this.hkE.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hkE != null) {
                            h.this.hkE.dismiss();
                        }
                    }
                });
                this.hkE.b(this.mPageContext);
            }
            this.hkE.th();
        }
    }

    public boolean C(final Bitmap bitmap) {
        if (!this.hmQ.bHW() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hkE == null) {
            this.hkE = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hkE.cd(d.j.orginal_tip);
            this.hkE.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hkE != null) {
                        h.this.hkE.dismiss();
                    }
                    h.this.hkD.B(bitmap);
                }
            });
            this.hkE.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hkE != null) {
                        h.this.hkE.dismiss();
                    }
                }
            });
            this.hkE.b(this.mPageContext);
        }
        this.hkE.th();
        return true;
    }
}
