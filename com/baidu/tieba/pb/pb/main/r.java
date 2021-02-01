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
    private RelativeLayout bMd;
    private com.baidu.tieba.pb.data.f lOq;
    private com.baidu.tbadk.editortools.pb.h lQN;
    private PbFakeFloorModel lQO;
    private String lQP;
    private String lQQ;
    private NewWriteModel.d lQR;
    private View.OnClickListener lQS;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bMd = relativeLayout;
        this.lQO = pbFakeFloorModel;
    }

    public void dna() {
        if (this.lQN != null) {
            this.lQN.bCq();
            if (StringUtils.isNull(this.lQP)) {
                this.lQN.onDestory();
            }
            this.lQN.bBh().bBu();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lOq = fVar;
    }

    public void dnb() {
        if (this.lQN != null && this.lQN.bBh() != null) {
            this.lQN.bBh().bzD();
        }
    }

    public boolean dnc() {
        if (this.lQN == null || this.lQN.bBh() == null) {
            return false;
        }
        return this.lQN.bBh().bBl();
    }

    private void aW(String str, boolean z) {
        if (this.bMd != null && this.lQN == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lQN = (com.baidu.tbadk.editortools.pb.h) iVar.fg(this.mPageContext.getPageActivity());
            this.lQN.a(this.mPageContext);
            this.lQN.b(this.lQO);
            this.lQN.setFrom(1);
            if (this.lOq != null) {
                this.lQN.setThreadData(this.lOq.dkZ());
            }
            this.lQN.bBh().kN(true);
            this.lQN.bBh().setOnCancelClickListener(this.lQS);
            this.lQN.j(this.mPageContext);
            dnd();
            this.lQN.b(this.lQR);
        }
    }

    public void j(String str, String str2, String str3, boolean z) {
        this.lQP = str2;
        if (this.lQN == null) {
            aW(str3, z);
        } else {
            this.lQN.b(this.lQO);
            if (StringUtils.isNull(this.lQP)) {
                this.lQN.j(this.mPageContext);
            }
        }
        this.lQN.setReplyId(str);
        this.lQN.De(str2);
        this.lQN.Df(this.lQQ);
        if (this.lQN.bCd()) {
            this.lQN.a((PostWriteCallBackData) null);
        }
    }

    private void dnd() {
        if (this.bMd != null && this.lQN != null && this.lQN.bBh() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bMd.addView(this.lQN.bBh(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lQN != null) {
            this.lQN.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lQN != null) {
            this.lQN.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lQN != null && this.lQN.bBh() != null) {
            this.lQN.bBh().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lQR = dVar;
        if (this.lQN != null) {
            this.lQN.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h dne() {
        return this.lQN;
    }

    public void Pq(String str) {
        this.lQQ = str;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lQS = onClickListener;
    }
}
