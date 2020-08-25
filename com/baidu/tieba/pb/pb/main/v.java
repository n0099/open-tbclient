package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes16.dex */
public class v {
    private RelativeLayout bpu;
    private com.baidu.tieba.pb.data.f kAA;
    private com.baidu.tbadk.editortools.pb.h kCP;
    private PbFakeFloorModel kCQ;
    private String kCR;
    private String kCS;
    private NewWriteModel.d kCT;
    private View.OnClickListener kCU;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bpu = relativeLayout;
        this.kCQ = pbFakeFloorModel;
    }

    public void cXj() {
        if (this.kCP != null) {
            this.kCP.bsy();
            if (StringUtils.isNull(this.kCR)) {
                this.kCP.onDestory();
            }
            this.kCP.brv().brG();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kAA = fVar;
    }

    public void cXk() {
        if (this.kCP != null && this.kCP.brv() != null) {
            this.kCP.brv().bpX();
        }
    }

    public boolean cXl() {
        if (this.kCP == null || this.kCP.brv() == null) {
            return false;
        }
        return this.kCP.brv().brx();
    }

    private void aQ(String str, boolean z) {
        if (this.bpu != null && this.kCP == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.kCP = (com.baidu.tbadk.editortools.pb.h) iVar.ec(this.mPageContext.getPageActivity());
            this.kCP.a(this.mPageContext);
            this.kCP.b(this.kCQ);
            if (this.kAA != null) {
                this.kCP.setThreadData(this.kAA.cVl());
            }
            this.kCP.brv().jh(true);
            this.kCP.brv().setOnCancelClickListener(this.kCU);
            this.kCP.j(this.mPageContext);
            cXm();
            this.kCP.b(this.kCT);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.kCR = str2;
        if (this.kCP == null) {
            aQ(str3, z);
        } else {
            this.kCP.b(this.kCQ);
            if (StringUtils.isNull(this.kCR)) {
                this.kCP.j(this.mPageContext);
            }
        }
        this.kCP.setReplyId(str);
        this.kCP.Cf(str2);
        this.kCP.Cg(this.kCS);
        if (this.kCP.bsm()) {
            this.kCP.a((PostWriteCallBackData) null);
        }
    }

    private void cXm() {
        if (this.bpu != null && this.kCP != null && this.kCP.brv() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bpu.addView(this.kCP.brv(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.kCP != null) {
            this.kCP.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.kCP != null) {
            this.kCP.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kCP != null && this.kCP.brv() != null) {
            this.kCP.brv().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.kCT = dVar;
        if (this.kCP != null) {
            this.kCP.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cXn() {
        return this.kCP;
    }

    public void Nr(String str) {
        this.kCS = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.kCU = onClickListener;
    }
}
