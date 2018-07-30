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
    private RelativeLayout cSA;
    private com.baidu.tbadk.editortools.pb.g fzT;
    private PbFakeFloorModel fzU;
    private String fzV;
    private NewWriteModel.d fzW;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cSA = relativeLayout;
        this.fzU = pbFakeFloorModel;
    }

    public void bbU() {
        if (this.fzT != null) {
            this.fzT.Ip();
            if (StringUtils.isNull(this.fzV)) {
                this.fzT.onDestory();
            }
            this.fzT.Ht().HD();
        }
    }

    public void bbV() {
        if (this.fzT != null && this.fzT.Ht() != null) {
            this.fzT.Ht().FP();
        }
    }

    public boolean bbW() {
        if (this.fzT == null || this.fzT.Ht() == null) {
            return false;
        }
        return this.fzT.Ht().Hw();
    }

    private void bbX() {
        if (this.cSA != null && this.fzT == null) {
            this.fzT = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aZ(this.mPageContext.getPageActivity());
            this.fzT.setContext(this.mPageContext);
            this.fzT.b(this.fzU);
            this.fzT.Ht().bC(true);
            this.fzT.d(this.mPageContext);
            bbY();
            this.fzT.b(this.fzW);
        }
    }

    public void bO(String str, String str2) {
        this.fzV = str2;
        if (this.fzT == null) {
            bbX();
        } else {
            this.fzT.b(this.fzU);
            if (StringUtils.isNull(this.fzV)) {
                this.fzT.d(this.mPageContext);
            }
        }
        this.fzT.setReplyId(str);
        this.fzT.gV(str2);
        if (this.fzT.Ig()) {
            this.fzT.a((PostWriteCallBackData) null);
        }
    }

    private void bbY() {
        if (this.cSA != null && this.fzT != null && this.fzT.Ht() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cSA.addView(this.fzT.Ht(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fzT != null) {
            this.fzT.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fzT != null) {
            this.fzT.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fzT != null && this.fzT.Ht() != null) {
            this.fzT.Ht().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fzW = dVar;
        if (this.fzT != null) {
            this.fzT.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bbZ() {
        return this.fzT;
    }
}
