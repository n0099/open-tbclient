package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class t {
    private RelativeLayout axQ;
    private com.baidu.tbadk.editortools.pb.h iBN;
    private PbFakeFloorModel iBO;
    private String iBP;
    private NewWriteModel.d iBQ;
    private com.baidu.tieba.pb.data.f izO;
    private TbPageContext mPageContext;

    public t(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.axQ = relativeLayout;
        this.iBO = pbFakeFloorModel;
    }

    public void cjF() {
        if (this.iBN != null) {
            this.iBN.aMB();
            if (StringUtils.isNull(this.iBP)) {
                this.iBN.onDestory();
            }
            this.iBN.aLC().aLM();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.izO = fVar;
    }

    public void cjG() {
        if (this.iBN != null && this.iBN.aLC() != null) {
            this.iBN.aLC().aJZ();
        }
    }

    public boolean cjH() {
        if (this.iBN == null || this.iBN.aLC() == null) {
            return false;
        }
        return this.iBN.aLC().aLE();
    }

    private void at(String str, boolean z) {
        if (this.axQ != null && this.iBN == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.iBN = (com.baidu.tbadk.editortools.pb.h) iVar.dR(this.mPageContext.getPageActivity());
            this.iBN.a(this.mPageContext);
            this.iBN.b(this.iBO);
            if (this.izO != null) {
                this.iBN.setThreadData(this.izO.chK());
            }
            this.iBN.aLC().gp(true);
            this.iBN.g(this.mPageContext);
            cjI();
            this.iBN.b(this.iBQ);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.iBP = str2;
        if (this.iBN == null) {
            at(str3, z);
        } else {
            this.iBN.b(this.iBO);
            if (StringUtils.isNull(this.iBP)) {
                this.iBN.g(this.mPageContext);
            }
        }
        this.iBN.setReplyId(str);
        this.iBN.uW(str2);
        if (this.iBN.aMq()) {
            this.iBN.a((PostWriteCallBackData) null);
        }
    }

    private void cjI() {
        if (this.axQ != null && this.iBN != null && this.iBN.aLC() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.axQ.addView(this.iBN.aLC(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iBN != null) {
            this.iBN.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.iBN != null) {
            this.iBN.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iBN != null && this.iBN.aLC() != null) {
            this.iBN.aLC().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.iBQ = dVar;
        if (this.iBN != null) {
            this.iBN.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cjJ() {
        return this.iBN;
    }
}
