package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private RelativeLayout ccT;
    private com.baidu.tbadk.editortools.pb.e eFm;
    private PbFakeFloorModel eFn;
    private String eFo;
    private TbPageContext mG;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mG = tbPageContext;
        this.ccT = relativeLayout;
        this.eFn = pbFakeFloorModel;
    }

    public void aPq() {
        if (this.eFm != null) {
            this.eFm.Dx();
            if (StringUtils.isNull(this.eFo)) {
                this.eFm.onDestory();
            }
        }
    }

    private void aPr() {
        if (this.ccT != null && this.eFm == null) {
            this.eFm = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aX(this.mG.getPageActivity());
            this.eFm.a(this.mG);
            this.eFm.b(this.eFn);
            this.eFm.Cz().bC(true);
            this.eFm.e(this.mG);
            aPs();
        }
    }

    public void bG(String str, String str2) {
        this.eFo = str2;
        if (this.eFm == null) {
            aPr();
        } else {
            this.eFm.b(this.eFn);
            if (StringUtils.isNull(this.eFo)) {
                this.eFm.e(this.mG);
            }
        }
        this.eFm.setReplyId(str);
        this.eFm.fX(str2);
    }

    private void aPs() {
        if (this.ccT != null && this.eFm != null && this.eFm.Cz() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ccT.addView(this.eFm.Cz(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eFm != null) {
            this.eFm.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eFm != null) {
            this.eFm.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eFm != null && this.eFm.Cz() != null) {
            this.eFm.Cz().onChangeSkinType(i);
        }
    }
}
