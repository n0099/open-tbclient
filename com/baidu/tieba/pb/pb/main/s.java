package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class s {
    private RelativeLayout aCR;
    private com.baidu.tieba.pb.data.e iFn;
    private com.baidu.tbadk.editortools.pb.h iHj;
    private PbFakeFloorModel iHk;
    private String iHl;
    private NewWriteModel.d iHm;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aCR = relativeLayout;
        this.iHk = pbFakeFloorModel;
    }

    public void cmk() {
        if (this.iHj != null) {
            this.iHj.aPt();
            if (StringUtils.isNull(this.iHl)) {
                this.iHj.onDestory();
            }
            this.iHj.aOu().aOE();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.iFn = eVar;
    }

    public void cml() {
        if (this.iHj != null && this.iHj.aOu() != null) {
            this.iHj.aOu().aMR();
        }
    }

    public boolean cmm() {
        if (this.iHj == null || this.iHj.aOu() == null) {
            return false;
        }
        return this.iHj.aOu().aOw();
    }

    private void at(String str, boolean z) {
        if (this.aCR != null && this.iHj == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.iHj = (com.baidu.tbadk.editortools.pb.h) iVar.dV(this.mPageContext.getPageActivity());
            this.iHj.a(this.mPageContext);
            this.iHj.b(this.iHk);
            if (this.iFn != null) {
                this.iHj.setThreadData(this.iFn.ckv());
            }
            this.iHj.aOu().gB(true);
            this.iHj.g(this.mPageContext);
            cmn();
            this.iHj.b(this.iHm);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.iHl = str2;
        if (this.iHj == null) {
            at(str3, z);
        } else {
            this.iHj.b(this.iHk);
            if (StringUtils.isNull(this.iHl)) {
                this.iHj.g(this.mPageContext);
            }
        }
        this.iHj.setReplyId(str);
        this.iHj.vt(str2);
        if (this.iHj.aPi()) {
            this.iHj.a((PostWriteCallBackData) null);
        }
    }

    private void cmn() {
        if (this.aCR != null && this.iHj != null && this.iHj.aOu() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aCR.addView(this.iHj.aOu(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iHj != null) {
            this.iHj.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.iHj != null) {
            this.iHj.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iHj != null && this.iHj.aOu() != null) {
            this.iHj.aOu().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.iHm = dVar;
        if (this.iHj != null) {
            this.iHj.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cmo() {
        return this.iHj;
    }
}
