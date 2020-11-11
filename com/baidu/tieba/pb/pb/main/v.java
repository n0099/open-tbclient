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
    private RelativeLayout bET;
    private com.baidu.tieba.pb.data.f lqP;
    private com.baidu.tbadk.editortools.pb.h ltf;
    private PbFakeFloorModel ltg;
    private String lth;
    private String lti;
    private NewWriteModel.d ltj;
    private View.OnClickListener ltk;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bET = relativeLayout;
        this.ltg = pbFakeFloorModel;
    }

    public void dkf() {
        if (this.ltf != null) {
            this.ltf.bAF();
            if (StringUtils.isNull(this.lth)) {
                this.ltf.onDestory();
            }
            this.ltf.bzx().bzK();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lqP = fVar;
    }

    public void dkg() {
        if (this.ltf != null && this.ltf.bzx() != null) {
            this.ltf.bzx().bxU();
        }
    }

    public boolean dkh() {
        if (this.ltf == null || this.ltf.bzx() == null) {
            return false;
        }
        return this.ltf.bzx().bzB();
    }

    private void aW(String str, boolean z) {
        if (this.bET != null && this.ltf == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.ltf = (com.baidu.tbadk.editortools.pb.h) iVar.ei(this.mPageContext.getPageActivity());
            this.ltf.a(this.mPageContext);
            this.ltf.b(this.ltg);
            this.ltf.setFrom(1);
            if (this.lqP != null) {
                this.ltf.setThreadData(this.lqP.dik());
            }
            this.ltf.bzx().kb(true);
            this.ltf.bzx().setOnCancelClickListener(this.ltk);
            this.ltf.j(this.mPageContext);
            dki();
            this.ltf.b(this.ltj);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.lth = str2;
        if (this.ltf == null) {
            aW(str3, z);
        } else {
            this.ltf.b(this.ltg);
            if (StringUtils.isNull(this.lth)) {
                this.ltf.j(this.mPageContext);
            }
        }
        this.ltf.setReplyId(str);
        this.ltf.DV(str2);
        this.ltf.DW(this.lti);
        if (this.ltf.bAt()) {
            this.ltf.a((PostWriteCallBackData) null);
        }
    }

    private void dki() {
        if (this.bET != null && this.ltf != null && this.ltf.bzx() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bET.addView(this.ltf.bzx(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ltf != null) {
            this.ltf.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ltf != null) {
            this.ltf.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ltf != null && this.ltf.bzx() != null) {
            this.ltf.bzx().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.ltj = dVar;
        if (this.ltf != null) {
            this.ltf.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h dkj() {
        return this.ltf;
    }

    public void Px(String str) {
        this.lti = str;
    }

    public void U(View.OnClickListener onClickListener) {
        this.ltk = onClickListener;
    }
}
