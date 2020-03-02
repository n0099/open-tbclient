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
    private RelativeLayout aCQ;
    private com.baidu.tieba.pb.data.e iFb;
    private com.baidu.tbadk.editortools.pb.h iGX;
    private PbFakeFloorModel iGY;
    private String iGZ;
    private NewWriteModel.d iHa;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aCQ = relativeLayout;
        this.iGY = pbFakeFloorModel;
    }

    public void cmj() {
        if (this.iGX != null) {
            this.iGX.aPs();
            if (StringUtils.isNull(this.iGZ)) {
                this.iGX.onDestory();
            }
            this.iGX.aOt().aOD();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.iFb = eVar;
    }

    public void cmk() {
        if (this.iGX != null && this.iGX.aOt() != null) {
            this.iGX.aOt().aMQ();
        }
    }

    public boolean cml() {
        if (this.iGX == null || this.iGX.aOt() == null) {
            return false;
        }
        return this.iGX.aOt().aOv();
    }

    private void at(String str, boolean z) {
        if (this.aCQ != null && this.iGX == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.iGX = (com.baidu.tbadk.editortools.pb.h) iVar.dV(this.mPageContext.getPageActivity());
            this.iGX.a(this.mPageContext);
            this.iGX.b(this.iGY);
            if (this.iFb != null) {
                this.iGX.setThreadData(this.iFb.cku());
            }
            this.iGX.aOt().gB(true);
            this.iGX.g(this.mPageContext);
            cmm();
            this.iGX.b(this.iHa);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.iGZ = str2;
        if (this.iGX == null) {
            at(str3, z);
        } else {
            this.iGX.b(this.iGY);
            if (StringUtils.isNull(this.iGZ)) {
                this.iGX.g(this.mPageContext);
            }
        }
        this.iGX.setReplyId(str);
        this.iGX.vs(str2);
        if (this.iGX.aPh()) {
            this.iGX.a((PostWriteCallBackData) null);
        }
    }

    private void cmm() {
        if (this.aCQ != null && this.iGX != null && this.iGX.aOt() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aCQ.addView(this.iGX.aOt(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iGX != null) {
            this.iGX.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.iGX != null) {
            this.iGX.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iGX != null && this.iGX.aOt() != null) {
            this.iGX.aOt().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.iHa = dVar;
        if (this.iGX != null) {
            this.iGX.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cmn() {
        return this.iGX;
    }
}
