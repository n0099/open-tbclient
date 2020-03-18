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
    private RelativeLayout aDf;
    private com.baidu.tieba.pb.data.e iGO;
    private com.baidu.tbadk.editortools.pb.h iIK;
    private PbFakeFloorModel iIL;
    private String iIM;
    private NewWriteModel.d iIN;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aDf = relativeLayout;
        this.iIL = pbFakeFloorModel;
    }

    public void cmF() {
        if (this.iIK != null) {
            this.iIK.aPx();
            if (StringUtils.isNull(this.iIM)) {
                this.iIK.onDestory();
            }
            this.iIK.aOy().aOI();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.iGO = eVar;
    }

    public void cmG() {
        if (this.iIK != null && this.iIK.aOy() != null) {
            this.iIK.aOy().aMV();
        }
    }

    public boolean cmH() {
        if (this.iIK == null || this.iIK.aOy() == null) {
            return false;
        }
        return this.iIK.aOy().aOA();
    }

    private void at(String str, boolean z) {
        if (this.aDf != null && this.iIK == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.iIK = (com.baidu.tbadk.editortools.pb.h) iVar.dU(this.mPageContext.getPageActivity());
            this.iIK.a(this.mPageContext);
            this.iIK.b(this.iIL);
            if (this.iGO != null) {
                this.iIK.setThreadData(this.iGO.ckP());
            }
            this.iIK.aOy().gC(true);
            this.iIK.g(this.mPageContext);
            cmI();
            this.iIK.b(this.iIN);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.iIM = str2;
        if (this.iIK == null) {
            at(str3, z);
        } else {
            this.iIK.b(this.iIL);
            if (StringUtils.isNull(this.iIM)) {
                this.iIK.g(this.mPageContext);
            }
        }
        this.iIK.setReplyId(str);
        this.iIK.vs(str2);
        if (this.iIK.aPm()) {
            this.iIK.a((PostWriteCallBackData) null);
        }
    }

    private void cmI() {
        if (this.aDf != null && this.iIK != null && this.iIK.aOy() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aDf.addView(this.iIK.aOy(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iIK != null) {
            this.iIK.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.iIK != null) {
            this.iIK.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iIK != null && this.iIK.aOy() != null) {
            this.iIK.aOy().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.iIN = dVar;
        if (this.iIK != null) {
            this.iIK.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cmJ() {
        return this.iIK;
    }
}
