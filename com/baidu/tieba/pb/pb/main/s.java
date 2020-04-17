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
    private RelativeLayout aWM;
    private com.baidu.tieba.pb.data.e jqV;
    private com.baidu.tbadk.editortools.pb.h jsR;
    private PbFakeFloorModel jsS;
    private String jsT;
    private NewWriteModel.d jsU;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aWM = relativeLayout;
        this.jsS = pbFakeFloorModel;
    }

    public void cxl() {
        if (this.jsR != null) {
            this.jsR.aXO();
            if (StringUtils.isNull(this.jsT)) {
                this.jsR.onDestory();
            }
            this.jsR.aWP().aWZ();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jqV = eVar;
    }

    public void cxm() {
        if (this.jsR != null && this.jsR.aWP() != null) {
            this.jsR.aWP().aVs();
        }
    }

    public boolean cxn() {
        if (this.jsR == null || this.jsR.aWP() == null) {
            return false;
        }
        return this.jsR.aWP().aWR();
    }

    private void az(String str, boolean z) {
        if (this.aWM != null && this.jsR == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.jsR = (com.baidu.tbadk.editortools.pb.h) iVar.dI(this.mPageContext.getPageActivity());
            this.jsR.a(this.mPageContext);
            this.jsR.b(this.jsS);
            if (this.jqV != null) {
                this.jsR.setThreadData(this.jqV.cvu());
            }
            this.jsR.aWP().hA(true);
            this.jsR.j(this.mPageContext);
            cxo();
            this.jsR.b(this.jsU);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.jsT = str2;
        if (this.jsR == null) {
            az(str3, z);
        } else {
            this.jsR.b(this.jsS);
            if (StringUtils.isNull(this.jsT)) {
                this.jsR.j(this.mPageContext);
            }
        }
        this.jsR.setReplyId(str);
        this.jsR.wH(str2);
        if (this.jsR.aXD()) {
            this.jsR.a((PostWriteCallBackData) null);
        }
    }

    private void cxo() {
        if (this.aWM != null && this.jsR != null && this.jsR.aWP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aWM.addView(this.jsR.aWP(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.jsR != null) {
            this.jsR.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.jsR != null) {
            this.jsR.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jsR != null && this.jsR.aWP() != null) {
            this.jsR.aWP().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.jsU = dVar;
        if (this.jsR != null) {
            this.jsR.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cxp() {
        return this.jsR;
    }
}
