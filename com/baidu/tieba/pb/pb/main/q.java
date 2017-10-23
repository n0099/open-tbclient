package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private RelativeLayout ccH;
    private com.baidu.tbadk.editortools.pb.e eEY;
    private PbFakeFloorModel eEZ;
    private String eFa;
    private TbPageContext mH;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mH = tbPageContext;
        this.ccH = relativeLayout;
        this.eEZ = pbFakeFloorModel;
    }

    public void aPl() {
        if (this.eEY != null) {
            this.eEY.Dr();
            if (StringUtils.isNull(this.eFa)) {
                this.eEY.onDestory();
            }
        }
    }

    private void aPm() {
        if (this.ccH != null && this.eEY == null) {
            this.eEY = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aW(this.mH.getPageActivity());
            this.eEY.a(this.mH);
            this.eEY.b(this.eEZ);
            this.eEY.Ct().bB(true);
            this.eEY.e(this.mH);
            aPn();
        }
    }

    public void bF(String str, String str2) {
        this.eFa = str2;
        if (this.eEY == null) {
            aPm();
        } else {
            this.eEY.b(this.eEZ);
            if (StringUtils.isNull(this.eFa)) {
                this.eEY.e(this.mH);
            }
        }
        this.eEY.setReplyId(str);
        this.eEY.fW(str2);
    }

    private void aPn() {
        if (this.ccH != null && this.eEY != null && this.eEY.Ct() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ccH.addView(this.eEY.Ct(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eEY != null) {
            this.eEY.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eEY != null) {
            this.eEY.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eEY != null && this.eEY.Ct() != null) {
            this.eEY.Ct().onChangeSkinType(i);
        }
    }
}
