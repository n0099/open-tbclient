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
/* loaded from: classes22.dex */
public class v {
    private RelativeLayout bIq;
    private com.baidu.tieba.pb.data.f lEP;
    private com.baidu.tbadk.editortools.pb.h lHj;
    private PbFakeFloorModel lHk;
    private String lHl;
    private String lHm;
    private NewWriteModel.d lHn;
    private View.OnClickListener lHo;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bIq = relativeLayout;
        this.lHk = pbFakeFloorModel;
    }

    public void doS() {
        if (this.lHj != null) {
            this.lHj.bDv();
            if (StringUtils.isNull(this.lHl)) {
                this.lHj.onDestory();
            }
            this.lHj.bCn().bCA();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lEP = fVar;
    }

    public void doT() {
        if (this.lHj != null && this.lHj.bCn() != null) {
            this.lHj.bCn().bAK();
        }
    }

    public boolean doU() {
        if (this.lHj == null || this.lHj.bCn() == null) {
            return false;
        }
        return this.lHj.bCn().bCr();
    }

    private void aX(String str, boolean z) {
        if (this.bIq != null && this.lHj == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lHj = (com.baidu.tbadk.editortools.pb.h) iVar.eN(this.mPageContext.getPageActivity());
            this.lHj.a(this.mPageContext);
            this.lHj.b(this.lHk);
            this.lHj.setFrom(1);
            if (this.lEP != null) {
                this.lHj.setThreadData(this.lEP.dmU());
            }
            this.lHj.bCn().ks(true);
            this.lHj.bCn().setOnCancelClickListener(this.lHo);
            this.lHj.j(this.mPageContext);
            doV();
            this.lHj.b(this.lHn);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.lHl = str2;
        if (this.lHj == null) {
            aX(str3, z);
        } else {
            this.lHj.b(this.lHk);
            if (StringUtils.isNull(this.lHl)) {
                this.lHj.j(this.mPageContext);
            }
        }
        this.lHj.setReplyId(str);
        this.lHj.Ec(str2);
        this.lHj.Ed(this.lHm);
        if (this.lHj.bDj()) {
            this.lHj.a((PostWriteCallBackData) null);
        }
    }

    private void doV() {
        if (this.bIq != null && this.lHj != null && this.lHj.bCn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bIq.addView(this.lHj.bCn(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lHj != null) {
            this.lHj.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lHj != null) {
            this.lHj.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lHj != null && this.lHj.bCn() != null) {
            this.lHj.bCn().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lHn = dVar;
        if (this.lHj != null) {
            this.lHj.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h doW() {
        return this.lHj;
    }

    public void Qb(String str) {
        this.lHm = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lHo = onClickListener;
    }
}
