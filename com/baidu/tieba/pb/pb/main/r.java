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
    private com.baidu.tieba.pb.data.f lKf;
    private String lMA;
    private String lMB;
    private NewWriteModel.d lMC;
    private View.OnClickListener lMD;
    private com.baidu.tbadk.editortools.pb.h lMy;
    private PbFakeFloorModel lMz;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bNf = relativeLayout;
        this.lMz = pbFakeFloorModel;
    }

    public void doE() {
        if (this.lMy != null) {
            this.lMy.bFQ();
            if (StringUtils.isNull(this.lMA)) {
                this.lMy.onDestory();
            }
            this.lMy.bEI().bEV();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lKf = fVar;
    }

    public void doF() {
        if (this.lMy != null && this.lMy.bEI() != null) {
            this.lMy.bEI().bDe();
        }
    }

    public boolean doG() {
        if (this.lMy == null || this.lMy.bEI() == null) {
            return false;
        }
        return this.lMy.bEI().bEM();
    }

    private void aX(String str, boolean z) {
        if (this.bNf != null && this.lMy == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lMy = (com.baidu.tbadk.editortools.pb.h) iVar.fj(this.mPageContext.getPageActivity());
            this.lMy.a(this.mPageContext);
            this.lMy.b(this.lMz);
            this.lMy.setFrom(1);
            if (this.lKf != null) {
                this.lMy.setThreadData(this.lKf.dmE());
            }
            this.lMy.bEI().kO(true);
            this.lMy.bEI().setOnCancelClickListener(this.lMD);
            this.lMy.j(this.mPageContext);
            doH();
            this.lMy.b(this.lMC);
        }
    }

    public void j(String str, String str2, String str3, boolean z) {
        this.lMA = str2;
        if (this.lMy == null) {
            aX(str3, z);
        } else {
            this.lMy.b(this.lMz);
            if (StringUtils.isNull(this.lMA)) {
                this.lMy.j(this.mPageContext);
            }
        }
        this.lMy.setReplyId(str);
        this.lMy.DZ(str2);
        this.lMy.Ea(this.lMB);
        if (this.lMy.bFE()) {
            this.lMy.a((PostWriteCallBackData) null);
        }
    }

    private void doH() {
        if (this.bNf != null && this.lMy != null && this.lMy.bEI() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bNf.addView(this.lMy.bEI(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lMy != null) {
            this.lMy.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lMy != null) {
            this.lMy.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lMy != null && this.lMy.bEI() != null) {
            this.lMy.bEI().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lMC = dVar;
        if (this.lMy != null) {
            this.lMy.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h doI() {
        return this.lMy;
    }

    public void PH(String str) {
        this.lMB = str;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lMD = onClickListener;
    }
}
