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
    private RelativeLayout epW;
    private com.baidu.tbadk.editortools.pb.g hIC;
    private PbFakeFloorModel hID;
    private String hIE;
    private NewWriteModel.d hIF;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.epW = relativeLayout;
        this.hID = pbFakeFloorModel;
    }

    public void bSw() {
        if (this.hIC != null) {
            this.hIC.arP();
            if (StringUtils.isNull(this.hIE)) {
                this.hIC.onDestory();
            }
            this.hIC.aqS().ard();
        }
    }

    public void bSx() {
        if (this.hIC != null && this.hIC.aqS() != null) {
            this.hIC.aqS().app();
        }
    }

    public boolean bSy() {
        if (this.hIC == null || this.hIC.aqS() == null) {
            return false;
        }
        return this.hIC.aqS().aqV();
    }

    private void Bg(String str) {
        if (this.epW != null && this.hIC == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.qh(str);
            this.hIC = (com.baidu.tbadk.editortools.pb.g) hVar.cJ(this.mPageContext.getPageActivity());
            this.hIC.a(this.mPageContext);
            this.hIC.b(this.hID);
            this.hIC.aqS().fd(true);
            this.hIC.e(this.mPageContext);
            bSz();
            this.hIC.b(this.hIF);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hIE = str2;
        if (this.hIC == null) {
            Bg(str3);
        } else {
            this.hIC.b(this.hID);
            if (StringUtils.isNull(this.hIE)) {
                this.hIC.e(this.mPageContext);
            }
        }
        this.hIC.setReplyId(str);
        this.hIC.qg(str2);
        if (this.hIC.arG()) {
            this.hIC.a((PostWriteCallBackData) null);
        }
    }

    private void bSz() {
        if (this.epW != null && this.hIC != null && this.hIC.aqS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.epW.addView(this.hIC.aqS(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hIC != null) {
            this.hIC.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hIC != null) {
            this.hIC.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIC != null && this.hIC.aqS() != null) {
            this.hIC.aqS().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hIF = dVar;
        if (this.hIC != null) {
            this.hIC.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bSA() {
        return this.hIC;
    }
}
