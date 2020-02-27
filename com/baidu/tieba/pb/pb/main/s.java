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
    private RelativeLayout aCP;
    private com.baidu.tieba.pb.data.e iEZ;
    private com.baidu.tbadk.editortools.pb.h iGV;
    private PbFakeFloorModel iGW;
    private String iGX;
    private NewWriteModel.d iGY;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aCP = relativeLayout;
        this.iGW = pbFakeFloorModel;
    }

    public void cmh() {
        if (this.iGV != null) {
            this.iGV.aPq();
            if (StringUtils.isNull(this.iGX)) {
                this.iGV.onDestory();
            }
            this.iGV.aOr().aOB();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.iEZ = eVar;
    }

    public void cmi() {
        if (this.iGV != null && this.iGV.aOr() != null) {
            this.iGV.aOr().aMO();
        }
    }

    public boolean cmj() {
        if (this.iGV == null || this.iGV.aOr() == null) {
            return false;
        }
        return this.iGV.aOr().aOt();
    }

    private void at(String str, boolean z) {
        if (this.aCP != null && this.iGV == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.iGV = (com.baidu.tbadk.editortools.pb.h) iVar.dV(this.mPageContext.getPageActivity());
            this.iGV.a(this.mPageContext);
            this.iGV.b(this.iGW);
            if (this.iEZ != null) {
                this.iGV.setThreadData(this.iEZ.cks());
            }
            this.iGV.aOr().gB(true);
            this.iGV.g(this.mPageContext);
            cmk();
            this.iGV.b(this.iGY);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.iGX = str2;
        if (this.iGV == null) {
            at(str3, z);
        } else {
            this.iGV.b(this.iGW);
            if (StringUtils.isNull(this.iGX)) {
                this.iGV.g(this.mPageContext);
            }
        }
        this.iGV.setReplyId(str);
        this.iGV.vs(str2);
        if (this.iGV.aPf()) {
            this.iGV.a((PostWriteCallBackData) null);
        }
    }

    private void cmk() {
        if (this.aCP != null && this.iGV != null && this.iGV.aOr() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aCP.addView(this.iGV.aOr(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iGV != null) {
            this.iGV.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.iGV != null) {
            this.iGV.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iGV != null && this.iGV.aOr() != null) {
            this.iGV.aOr().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.iGY = dVar;
        if (this.iGV != null) {
            this.iGV.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cml() {
        return this.iGV;
    }
}
