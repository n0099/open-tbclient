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
/* loaded from: classes2.dex */
public class r {
    private RelativeLayout bIt;
    private com.baidu.tieba.pb.data.f lFA;
    private com.baidu.tbadk.editortools.pb.h lHT;
    private PbFakeFloorModel lHU;
    private String lHV;
    private String lHW;
    private NewWriteModel.d lHX;
    private View.OnClickListener lHY;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bIt = relativeLayout;
        this.lHU = pbFakeFloorModel;
    }

    public void dkM() {
        if (this.lHT != null) {
            this.lHT.bBY();
            if (StringUtils.isNull(this.lHV)) {
                this.lHT.onDestory();
            }
            this.lHT.bAP().bBc();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lFA = fVar;
    }

    public void dkN() {
        if (this.lHT != null && this.lHT.bAP() != null) {
            this.lHT.bAP().bzl();
        }
    }

    public boolean dkO() {
        if (this.lHT == null || this.lHT.bAP() == null) {
            return false;
        }
        return this.lHT.bAP().bAT();
    }

    private void aX(String str, boolean z) {
        if (this.bIt != null && this.lHT == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lHT = (com.baidu.tbadk.editortools.pb.h) iVar.fh(this.mPageContext.getPageActivity());
            this.lHT.a(this.mPageContext);
            this.lHT.b(this.lHU);
            this.lHT.setFrom(1);
            if (this.lFA != null) {
                this.lHT.setThreadData(this.lFA.diN());
            }
            this.lHT.bAP().kK(true);
            this.lHT.bAP().setOnCancelClickListener(this.lHY);
            this.lHT.j(this.mPageContext);
            dkP();
            this.lHT.b(this.lHX);
        }
    }

    public void j(String str, String str2, String str3, boolean z) {
        this.lHV = str2;
        if (this.lHT == null) {
            aX(str3, z);
        } else {
            this.lHT.b(this.lHU);
            if (StringUtils.isNull(this.lHV)) {
                this.lHT.j(this.mPageContext);
            }
        }
        this.lHT.setReplyId(str);
        this.lHT.CN(str2);
        this.lHT.CO(this.lHW);
        if (this.lHT.bBL()) {
            this.lHT.a((PostWriteCallBackData) null);
        }
    }

    private void dkP() {
        if (this.bIt != null && this.lHT != null && this.lHT.bAP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bIt.addView(this.lHT.bAP(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lHT != null) {
            this.lHT.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lHT != null) {
            this.lHT.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lHT != null && this.lHT.bAP() != null) {
            this.lHT.bAP().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lHX = dVar;
        if (this.lHT != null) {
            this.lHT.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h dkQ() {
        return this.lHT;
    }

    public void Oy(String str) {
        this.lHW = str;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lHY = onClickListener;
    }
}
