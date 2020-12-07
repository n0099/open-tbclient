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
    private com.baidu.tieba.pb.data.f lEN;
    private com.baidu.tbadk.editortools.pb.h lHh;
    private PbFakeFloorModel lHi;
    private String lHj;
    private String lHk;
    private NewWriteModel.d lHl;
    private View.OnClickListener lHm;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bIq = relativeLayout;
        this.lHi = pbFakeFloorModel;
    }

    public void doR() {
        if (this.lHh != null) {
            this.lHh.bDv();
            if (StringUtils.isNull(this.lHj)) {
                this.lHh.onDestory();
            }
            this.lHh.bCn().bCA();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lEN = fVar;
    }

    public void doS() {
        if (this.lHh != null && this.lHh.bCn() != null) {
            this.lHh.bCn().bAK();
        }
    }

    public boolean doT() {
        if (this.lHh == null || this.lHh.bCn() == null) {
            return false;
        }
        return this.lHh.bCn().bCr();
    }

    private void aX(String str, boolean z) {
        if (this.bIq != null && this.lHh == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lHh = (com.baidu.tbadk.editortools.pb.h) iVar.eN(this.mPageContext.getPageActivity());
            this.lHh.a(this.mPageContext);
            this.lHh.b(this.lHi);
            this.lHh.setFrom(1);
            if (this.lEN != null) {
                this.lHh.setThreadData(this.lEN.dmT());
            }
            this.lHh.bCn().ks(true);
            this.lHh.bCn().setOnCancelClickListener(this.lHm);
            this.lHh.j(this.mPageContext);
            doU();
            this.lHh.b(this.lHl);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.lHj = str2;
        if (this.lHh == null) {
            aX(str3, z);
        } else {
            this.lHh.b(this.lHi);
            if (StringUtils.isNull(this.lHj)) {
                this.lHh.j(this.mPageContext);
            }
        }
        this.lHh.setReplyId(str);
        this.lHh.Ec(str2);
        this.lHh.Ed(this.lHk);
        if (this.lHh.bDj()) {
            this.lHh.a((PostWriteCallBackData) null);
        }
    }

    private void doU() {
        if (this.bIq != null && this.lHh != null && this.lHh.bCn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bIq.addView(this.lHh.bCn(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lHh != null) {
            this.lHh.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lHh != null) {
            this.lHh.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lHh != null && this.lHh.bCn() != null) {
            this.lHh.bCn().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lHl = dVar;
        if (this.lHh != null) {
            this.lHh.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h doV() {
        return this.lHh;
    }

    public void Qb(String str) {
        this.lHk = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lHm = onClickListener;
    }
}
