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
    private com.baidu.tieba.pb.data.f lOF;
    private com.baidu.tbadk.editortools.pb.h lRc;
    private PbFakeFloorModel lRd;
    private String lRe;
    private String lRf;
    private NewWriteModel.d lRg;
    private View.OnClickListener lRh;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bMd = relativeLayout;
        this.lRd = pbFakeFloorModel;
    }

    public void dnh() {
        if (this.lRc != null) {
            this.lRc.bCq();
            if (StringUtils.isNull(this.lRe)) {
                this.lRc.onDestory();
            }
            this.lRc.bBh().bBu();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lOF = fVar;
    }

    public void dni() {
        if (this.lRc != null && this.lRc.bBh() != null) {
            this.lRc.bBh().bzD();
        }
    }

    public boolean dnj() {
        if (this.lRc == null || this.lRc.bBh() == null) {
            return false;
        }
        return this.lRc.bBh().bBl();
    }

    private void aW(String str, boolean z) {
        if (this.bMd != null && this.lRc == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lRc = (com.baidu.tbadk.editortools.pb.h) iVar.fg(this.mPageContext.getPageActivity());
            this.lRc.a(this.mPageContext);
            this.lRc.b(this.lRd);
            this.lRc.setFrom(1);
            if (this.lOF != null) {
                this.lRc.setThreadData(this.lOF.dlg());
            }
            this.lRc.bBh().kN(true);
            this.lRc.bBh().setOnCancelClickListener(this.lRh);
            this.lRc.j(this.mPageContext);
            dnk();
            this.lRc.b(this.lRg);
        }
    }

    public void j(String str, String str2, String str3, boolean z) {
        this.lRe = str2;
        if (this.lRc == null) {
            aW(str3, z);
        } else {
            this.lRc.b(this.lRd);
            if (StringUtils.isNull(this.lRe)) {
                this.lRc.j(this.mPageContext);
            }
        }
        this.lRc.setReplyId(str);
        this.lRc.Dc(str2);
        this.lRc.Dd(this.lRf);
        if (this.lRc.bCd()) {
            this.lRc.a((PostWriteCallBackData) null);
        }
    }

    private void dnk() {
        if (this.bMd != null && this.lRc != null && this.lRc.bBh() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bMd.addView(this.lRc.bBh(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lRc != null) {
            this.lRc.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lRc != null) {
            this.lRc.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lRc != null && this.lRc.bBh() != null) {
            this.lRc.bBh().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lRg = dVar;
        if (this.lRc != null) {
            this.lRc.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h dnl() {
        return this.lRc;
    }

    public void Pr(String str) {
        this.lRf = str;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lRh = onClickListener;
    }
}
