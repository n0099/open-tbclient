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
    private RelativeLayout bND;
    private com.baidu.tieba.pb.data.f lQH;
    private com.baidu.tbadk.editortools.pb.h lTe;
    private PbFakeFloorModel lTf;
    private String lTg;
    private String lTh;
    private NewWriteModel.d lTi;
    private View.OnClickListener lTj;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bND = relativeLayout;
        this.lTf = pbFakeFloorModel;
    }

    public void dnq() {
        if (this.lTe != null) {
            this.lTe.bCt();
            if (StringUtils.isNull(this.lTg)) {
                this.lTe.onDestory();
            }
            this.lTe.bBk().bBx();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lQH = fVar;
    }

    public void dnr() {
        if (this.lTe != null && this.lTe.bBk() != null) {
            this.lTe.bBk().bzG();
        }
    }

    public boolean dnt() {
        if (this.lTe == null || this.lTe.bBk() == null) {
            return false;
        }
        return this.lTe.bBk().bBo();
    }

    private void aW(String str, boolean z) {
        if (this.bND != null && this.lTe == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lTe = (com.baidu.tbadk.editortools.pb.h) iVar.ff(this.mPageContext.getPageActivity());
            this.lTe.a(this.mPageContext);
            this.lTe.b(this.lTf);
            this.lTe.setFrom(1);
            if (this.lQH != null) {
                this.lTe.setThreadData(this.lQH.dlp());
            }
            this.lTe.bBk().kN(true);
            this.lTe.bBk().setOnCancelClickListener(this.lTj);
            this.lTe.j(this.mPageContext);
            dnu();
            this.lTe.b(this.lTi);
        }
    }

    public void j(String str, String str2, String str3, boolean z) {
        this.lTg = str2;
        if (this.lTe == null) {
            aW(str3, z);
        } else {
            this.lTe.b(this.lTf);
            if (StringUtils.isNull(this.lTg)) {
                this.lTe.j(this.mPageContext);
            }
        }
        this.lTe.setReplyId(str);
        this.lTe.Dj(str2);
        this.lTe.Dk(this.lTh);
        if (this.lTe.bCg()) {
            this.lTe.a((PostWriteCallBackData) null);
        }
    }

    private void dnu() {
        if (this.bND != null && this.lTe != null && this.lTe.bBk() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bND.addView(this.lTe.bBk(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lTe != null) {
            this.lTe.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lTe != null) {
            this.lTe.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lTe != null && this.lTe.bBk() != null) {
            this.lTe.bBk().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lTi = dVar;
        if (this.lTe != null) {
            this.lTe.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h dnv() {
        return this.lTe;
    }

    public void Px(String str) {
        this.lTh = str;
    }

    public void W(View.OnClickListener onClickListener) {
        this.lTj = onClickListener;
    }
}
