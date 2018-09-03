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
public class s {
    private RelativeLayout cSx;
    private com.baidu.tbadk.editortools.pb.g fzM;
    private PbFakeFloorModel fzN;
    private String fzO;
    private NewWriteModel.d fzP;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cSx = relativeLayout;
        this.fzN = pbFakeFloorModel;
    }

    public void bbP() {
        if (this.fzM != null) {
            this.fzM.Ip();
            if (StringUtils.isNull(this.fzO)) {
                this.fzM.onDestory();
            }
            this.fzM.Ht().HD();
        }
    }

    public void bbQ() {
        if (this.fzM != null && this.fzM.Ht() != null) {
            this.fzM.Ht().FP();
        }
    }

    public boolean bbR() {
        if (this.fzM == null || this.fzM.Ht() == null) {
            return false;
        }
        return this.fzM.Ht().Hw();
    }

    private void bbS() {
        if (this.cSx != null && this.fzM == null) {
            this.fzM = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aY(this.mPageContext.getPageActivity());
            this.fzM.setContext(this.mPageContext);
            this.fzM.b(this.fzN);
            this.fzM.Ht().bD(true);
            this.fzM.d(this.mPageContext);
            bbT();
            this.fzM.b(this.fzP);
        }
    }

    public void bO(String str, String str2) {
        this.fzO = str2;
        if (this.fzM == null) {
            bbS();
        } else {
            this.fzM.b(this.fzN);
            if (StringUtils.isNull(this.fzO)) {
                this.fzM.d(this.mPageContext);
            }
        }
        this.fzM.setReplyId(str);
        this.fzM.gV(str2);
        if (this.fzM.Ig()) {
            this.fzM.a((PostWriteCallBackData) null);
        }
    }

    private void bbT() {
        if (this.cSx != null && this.fzM != null && this.fzM.Ht() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cSx.addView(this.fzM.Ht(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fzM != null) {
            this.fzM.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fzM != null) {
            this.fzM.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fzM != null && this.fzM.Ht() != null) {
            this.fzM.Ht().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fzP = dVar;
        if (this.fzM != null) {
            this.fzM.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bbU() {
        return this.fzM;
    }
}
