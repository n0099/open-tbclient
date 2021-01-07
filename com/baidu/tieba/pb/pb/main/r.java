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
    private RelativeLayout bNf;
    private com.baidu.tieba.pb.data.f lKe;
    private String lMA;
    private NewWriteModel.d lMB;
    private View.OnClickListener lMC;
    private com.baidu.tbadk.editortools.pb.h lMx;
    private PbFakeFloorModel lMy;
    private String lMz;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bNf = relativeLayout;
        this.lMy = pbFakeFloorModel;
    }

    public void doF() {
        if (this.lMx != null) {
            this.lMx.bFR();
            if (StringUtils.isNull(this.lMz)) {
                this.lMx.onDestory();
            }
            this.lMx.bEJ().bEW();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lKe = fVar;
    }

    public void doG() {
        if (this.lMx != null && this.lMx.bEJ() != null) {
            this.lMx.bEJ().bDf();
        }
    }

    public boolean doH() {
        if (this.lMx == null || this.lMx.bEJ() == null) {
            return false;
        }
        return this.lMx.bEJ().bEN();
    }

    private void aX(String str, boolean z) {
        if (this.bNf != null && this.lMx == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lMx = (com.baidu.tbadk.editortools.pb.h) iVar.fj(this.mPageContext.getPageActivity());
            this.lMx.a(this.mPageContext);
            this.lMx.b(this.lMy);
            this.lMx.setFrom(1);
            if (this.lKe != null) {
                this.lMx.setThreadData(this.lKe.dmF());
            }
            this.lMx.bEJ().kO(true);
            this.lMx.bEJ().setOnCancelClickListener(this.lMC);
            this.lMx.j(this.mPageContext);
            doI();
            this.lMx.b(this.lMB);
        }
    }

    public void j(String str, String str2, String str3, boolean z) {
        this.lMz = str2;
        if (this.lMx == null) {
            aX(str3, z);
        } else {
            this.lMx.b(this.lMy);
            if (StringUtils.isNull(this.lMz)) {
                this.lMx.j(this.mPageContext);
            }
        }
        this.lMx.setReplyId(str);
        this.lMx.DY(str2);
        this.lMx.DZ(this.lMA);
        if (this.lMx.bFF()) {
            this.lMx.a((PostWriteCallBackData) null);
        }
    }

    private void doI() {
        if (this.bNf != null && this.lMx != null && this.lMx.bEJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bNf.addView(this.lMx.bEJ(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lMx != null) {
            this.lMx.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lMx != null) {
            this.lMx.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lMx != null && this.lMx.bEJ() != null) {
            this.lMx.bEJ().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lMB = dVar;
        if (this.lMx != null) {
            this.lMx.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h doJ() {
        return this.lMx;
    }

    public void PG(String str) {
        this.lMA = str;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lMC = onClickListener;
    }
}
