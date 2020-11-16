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
/* loaded from: classes21.dex */
public class v {
    private RelativeLayout bDi;
    private com.baidu.tieba.pb.data.f lre;
    private NewWriteModel.d ltA;
    private View.OnClickListener ltB;
    private com.baidu.tbadk.editortools.pb.h ltw;
    private PbFakeFloorModel ltx;
    private String lty;
    private String ltz;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bDi = relativeLayout;
        this.ltx = pbFakeFloorModel;
    }

    public void djC() {
        if (this.ltw != null) {
            this.ltw.bzV();
            if (StringUtils.isNull(this.lty)) {
                this.ltw.onDestory();
            }
            this.ltw.byN().bza();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lre = fVar;
    }

    public void djD() {
        if (this.ltw != null && this.ltw.byN() != null) {
            this.ltw.byN().bxk();
        }
    }

    public boolean djE() {
        if (this.ltw == null || this.ltw.byN() == null) {
            return false;
        }
        return this.ltw.byN().byR();
    }

    private void aW(String str, boolean z) {
        if (this.bDi != null && this.ltw == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.ltw = (com.baidu.tbadk.editortools.pb.h) iVar.ei(this.mPageContext.getPageActivity());
            this.ltw.a(this.mPageContext);
            this.ltw.b(this.ltx);
            this.ltw.setFrom(1);
            if (this.lre != null) {
                this.ltw.setThreadData(this.lre.dhH());
            }
            this.ltw.byN().kc(true);
            this.ltw.byN().setOnCancelClickListener(this.ltB);
            this.ltw.j(this.mPageContext);
            djF();
            this.ltw.b(this.ltA);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.lty = str2;
        if (this.ltw == null) {
            aW(str3, z);
        } else {
            this.ltw.b(this.ltx);
            if (StringUtils.isNull(this.lty)) {
                this.ltw.j(this.mPageContext);
            }
        }
        this.ltw.setReplyId(str);
        this.ltw.Du(str2);
        this.ltw.Dv(this.ltz);
        if (this.ltw.bzJ()) {
            this.ltw.a((PostWriteCallBackData) null);
        }
    }

    private void djF() {
        if (this.bDi != null && this.ltw != null && this.ltw.byN() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bDi.addView(this.ltw.byN(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ltw != null) {
            this.ltw.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ltw != null) {
            this.ltw.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ltw != null && this.ltw.byN() != null) {
            this.ltw.byN().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.ltA = dVar;
        if (this.ltw != null) {
            this.ltw.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h djG() {
        return this.ltw;
    }

    public void OT(String str) {
        this.ltz = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.ltB = onClickListener;
    }
}
