package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class r {
    private RelativeLayout cRQ;
    private com.baidu.tbadk.editortools.pb.g fvG;
    private PbFakeFloorModel fvH;
    private String fvI;
    private NewWriteModel.d fvJ;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cRQ = relativeLayout;
        this.fvH = pbFakeFloorModel;
    }

    public void bcT() {
        if (this.fvG != null) {
            this.fvG.Ic();
            if (StringUtils.isNull(this.fvI)) {
                this.fvG.onDestory();
            }
            this.fvG.Hg().Hq();
        }
    }

    public void bcU() {
        if (this.fvG != null && this.fvG.Hg() != null) {
            this.fvG.Hg().FB();
        }
    }

    public boolean bcV() {
        if (this.fvG == null || this.fvG.Hg() == null) {
            return false;
        }
        return this.fvG.Hg().Hj();
    }

    private void bcW() {
        if (this.cRQ != null && this.fvG == null) {
            this.fvG = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aY(this.mPageContext.getPageActivity());
            this.fvG.setContext(this.mPageContext);
            this.fvG.b(this.fvH);
            this.fvG.Hg().bB(true);
            this.fvG.d(this.mPageContext);
            bcX();
            this.fvG.b(this.fvJ);
        }
    }

    public void bO(String str, String str2) {
        this.fvI = str2;
        if (this.fvG == null) {
            bcW();
        } else {
            this.fvG.b(this.fvH);
            if (StringUtils.isNull(this.fvI)) {
                this.fvG.d(this.mPageContext);
            }
        }
        this.fvG.setReplyId(str);
        this.fvG.gV(str2);
        if (this.fvG.HT()) {
            this.fvG.a((PostWriteCallBackData) null);
        }
    }

    private void bcX() {
        if (this.cRQ != null && this.fvG != null && this.fvG.Hg() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cRQ.addView(this.fvG.Hg(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fvG != null) {
            this.fvG.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fvG != null) {
            this.fvG.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fvG != null && this.fvG.Hg() != null) {
            this.fvG.Hg().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fvJ = dVar;
        if (this.fvG != null) {
            this.fvG.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bcY() {
        return this.fvG;
    }
}
