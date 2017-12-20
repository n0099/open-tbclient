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
    private ForumWriteData gYz;
    private g hky;
    private com.baidu.tbadk.core.dialog.a hkz;
    public b hmL = null;
    private int hmM = 0;
    private int hmN = 0;
    private int hmO = 0;
    private WriteImagesInfo hmP = null;
    private HashMap<String, String> hmQ = new HashMap<>();
    private TbPageContext<WriteMultiImgsActivity> mPageContext;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hky = gVar;
        initData(bundle);
        initListener();
        bHZ();
    }

    public void bHZ() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.btX();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dp(List<String> list) {
        if (this.hky != null) {
            this.hky.ec(list);
        }
    }

    private void initListener() {
        if (this.hky != null) {
            if (this.hky.hmC != null) {
                this.hky.hmC.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hmL.I(Integer.parseInt(view.getTag().toString()), h.this.bId());
                        }
                    }
                });
            }
            if (this.hky.hmG != null) {
                this.hky.hmG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.hmL.of(false);
                        if (h.this.hky != null) {
                            if (h.this.hmP == null || h.this.hmP.getChosedFiles() == null || h.this.hmP.getChosedFiles().size() <= 0 || !h.this.hmP.isOriginalImg() || h.this.hmN <= 0 || !h.this.bIY()) {
                                h.this.hky.b(true, h.this.hmP);
                            } else {
                                h.this.hky.bIV();
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
            this.hmM = bundle.getInt("OutState_Write_Entrance");
            this.gYz = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hmM = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.gYz = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hmP = new WriteImagesInfo();
            this.hmP.parseJson(str);
            bIW();
            if (this.hky != null && this.hky.hmE != null) {
                this.hmL = new b(this.mPageContext.getOrignalPage(), this.hky.hmE, this.hmP.getChosedFiles(), i, this, this.hky, this.hmP.mIsFromIm);
                this.hky.hmE.setAdapter(this.hmL);
                this.hky.hmE.setCurrentItem(i, true);
                if (i == 0) {
                    this.hmL.onPageSelected(0);
                }
                this.hky.d(this.hmP);
            }
        }
    }

    private void bIW() {
        if (this.hmP != null && this.hmP.isOriginalImg() && this.hmP.getChosedFiles() != null && this.hmP.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hmP.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hmQ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIX() {
        return this.hmM;
    }

    public ForumWriteData alH() {
        return this.gYz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIY() {
        if (this.hmP == null || !this.hmP.isOriginalImg() || this.hmP.getChosedFiles() == null || this.hmP.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hmP.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hmQ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIa() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIb() {
        this.hmO++;
        if (this.hmO > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIc() {
        this.hmO--;
        if (this.hmO == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bId() {
        return (this.hky == null || this.hky.hmF == null || v.w(this.hky.hmF.getStickerViews())) ? false : true;
    }

    public void bIT() {
        this.hmN++;
    }

    public void bIU() {
        this.hmN--;
    }

    public WriteImagesInfo bIZ() {
        return this.hmP;
    }

    public void on(boolean z) {
        if (bId()) {
            this.hky.hmE.setmDisallowSlip(true);
        } else {
            this.hky.hmE.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHY() {
        bIU();
        on(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void J(int i, boolean z) {
        K(i, z);
    }

    private void K(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hkz == null) {
                this.hkz = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hkz.cd(d.j.orginal_tip);
                this.hkz.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hkz != null) {
                            h.this.hkz.dismiss();
                        }
                        if (h.this.hmL != null) {
                            h.this.hmL.I(i, z);
                        }
                    }
                });
                this.hkz.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hkz != null) {
                            h.this.hkz.dismiss();
                        }
                    }
                });
                this.hkz.b(this.mPageContext);
            }
            this.hkz.th();
        }
    }

    public boolean C(final Bitmap bitmap) {
        if (!this.hmL.bHV() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hkz == null) {
            this.hkz = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hkz.cd(d.j.orginal_tip);
            this.hkz.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hkz != null) {
                        h.this.hkz.dismiss();
                    }
                    h.this.hky.B(bitmap);
                }
            });
            this.hkz.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hkz != null) {
                        h.this.hkz.dismiss();
                    }
                }
            });
            this.hkz.b(this.mPageContext);
        }
        this.hkz.th();
        return true;
    }
}
