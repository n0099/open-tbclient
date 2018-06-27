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
    private RelativeLayout cPO;
    private com.baidu.tbadk.editortools.pb.g fzH;
    private PbFakeFloorModel fzI;
    private String fzJ;
    private NewWriteModel.d fzK;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cPO = relativeLayout;
        this.fzI = pbFakeFloorModel;
    }

    public void bdB() {
        if (this.fzH != null) {
            this.fzH.Iu();
            if (StringUtils.isNull(this.fzJ)) {
                this.fzH.onDestory();
            }
            this.fzH.Hy().HI();
        }
    }

    public void bdC() {
        if (this.fzH != null && this.fzH.Hy() != null) {
            this.fzH.Hy().FT();
        }
    }

    public boolean bdD() {
        if (this.fzH == null || this.fzH.Hy() == null) {
            return false;
        }
        return this.fzH.Hy().HB();
    }

    private void bdE() {
        if (this.cPO != null && this.fzH == null) {
            this.fzH = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aY(this.mPageContext.getPageActivity());
            this.fzH.setContext(this.mPageContext);
            this.fzH.b(this.fzI);
            this.fzH.Hy().bE(true);
            this.fzH.d(this.mPageContext);
            bdF();
            this.fzH.b(this.fzK);
        }
    }

    public void bS(String str, String str2) {
        this.fzJ = str2;
        if (this.fzH == null) {
            bdE();
        } else {
            this.fzH.b(this.fzI);
            if (StringUtils.isNull(this.fzJ)) {
                this.fzH.d(this.mPageContext);
            }
        }
        this.fzH.setReplyId(str);
        this.fzH.gZ(str2);
        if (this.fzH.Il()) {
            this.fzH.a((PostWriteCallBackData) null);
        }
    }

    private void bdF() {
        if (this.cPO != null && this.fzH != null && this.fzH.Hy() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cPO.addView(this.fzH.Hy(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fzH != null) {
            this.fzH.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fzH != null) {
            this.fzH.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fzH != null && this.fzH.Hy() != null) {
            this.fzH.Hy().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fzK = dVar;
        if (this.fzH != null) {
            this.fzH.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bdG() {
        return this.fzH;
    }
}
