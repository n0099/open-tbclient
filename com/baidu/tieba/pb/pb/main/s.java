package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class s {
    private RelativeLayout csY;
    private com.baidu.tbadk.editortools.pb.h eWd;
    private PbFakeFloorModel eWe;
    private String eWf;
    private NewWriteModel.d eWg;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.csY = relativeLayout;
        this.eWe = pbFakeFloorModel;
    }

    public void aTS() {
        if (this.eWd != null) {
            this.eWd.DZ();
            if (StringUtils.isNull(this.eWf)) {
                this.eWd.onDestory();
            }
            this.eWd.Dd().Dn();
        }
    }

    private void aTT() {
        if (this.csY != null && this.eWd == null) {
            this.eWd = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().aY(this.mPageContext.getPageActivity());
            this.eWd.a(this.mPageContext);
            this.eWd.b(this.eWe);
            this.eWd.Dd().bx(true);
            this.eWd.e(this.mPageContext);
            aTV();
            this.eWd.b(this.eWg);
        }
    }

    public void bG(String str, String str2) {
        this.eWf = str2;
        if (this.eWd == null) {
            aTT();
        } else {
            this.eWd.b(this.eWe);
            if (StringUtils.isNull(this.eWf)) {
                this.eWd.e(this.mPageContext);
            }
        }
        this.eWd.setReplyId(str);
        this.eWd.gh(str2);
        if (this.eWd.DP()) {
            this.eWd.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h aTU() {
        return this.eWd;
    }

    private void aTV() {
        if (this.csY != null && this.eWd != null && this.eWd.Dd() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.csY.addView(this.eWd.Dd(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eWd != null) {
            this.eWd.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eWd != null) {
            this.eWd.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eWd != null && this.eWd.Dd() != null) {
            this.eWd.Dd().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eWg = dVar;
        if (this.eWd != null) {
            this.eWd.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h aTW() {
        return this.eWd;
    }
}
