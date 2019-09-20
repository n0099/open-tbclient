package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class s {
    private RelativeLayout ewL;
    private com.baidu.tbadk.editortools.pb.g hRH;
    private PbFakeFloorModel hRI;
    private String hRJ;
    private NewWriteModel.d hRK;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.ewL = relativeLayout;
        this.hRI = pbFakeFloorModel;
    }

    public void bWl() {
        if (this.hRH != null) {
            this.hRH.atj();
            if (StringUtils.isNull(this.hRJ)) {
                this.hRH.onDestory();
            }
            this.hRH.asm().asx();
        }
    }

    public void bWm() {
        if (this.hRH != null && this.hRH.asm() != null) {
            this.hRH.asm().aqI();
        }
    }

    public boolean bWn() {
        if (this.hRH == null || this.hRH.asm() == null) {
            return false;
        }
        return this.hRH.asm().asp();
    }

    private void Cs(String str) {
        if (this.ewL != null && this.hRH == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.qJ(str);
            this.hRH = (com.baidu.tbadk.editortools.pb.g) hVar.cK(this.mPageContext.getPageActivity());
            this.hRH.a(this.mPageContext);
            this.hRH.b(this.hRI);
            this.hRH.asm().fk(true);
            this.hRH.e(this.mPageContext);
            bWo();
            this.hRH.b(this.hRK);
        }
    }

    public void aa(String str, String str2, String str3) {
        this.hRJ = str2;
        if (this.hRH == null) {
            Cs(str3);
        } else {
            this.hRH.b(this.hRI);
            if (StringUtils.isNull(this.hRJ)) {
                this.hRH.e(this.mPageContext);
            }
        }
        this.hRH.setReplyId(str);
        this.hRH.qI(str2);
        if (this.hRH.ata()) {
            this.hRH.a((PostWriteCallBackData) null);
        }
    }

    private void bWo() {
        if (this.ewL != null && this.hRH != null && this.hRH.asm() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ewL.addView(this.hRH.asm(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hRH != null) {
            this.hRH.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hRH != null) {
            this.hRH.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hRH != null && this.hRH.asm() != null) {
            this.hRH.asm().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hRK = dVar;
        if (this.hRH != null) {
            this.hRH.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bWp() {
        return this.hRH;
    }
}
