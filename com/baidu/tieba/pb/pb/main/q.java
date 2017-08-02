package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private TbPageContext ako;
    private RelativeLayout bXk;
    private com.baidu.tbadk.editortools.pb.e eJs;
    private PbFakeFloorModel eJt;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ako = tbPageContext;
        this.bXk = relativeLayout;
        this.eJt = pbFakeFloorModel;
    }

    public void aRe() {
        if (this.eJs != null) {
            this.eJs.DQ();
        }
    }

    private void aRf() {
        if (this.bXk != null && this.eJs == null) {
            this.eJs = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aQ(this.ako.getPageActivity());
            this.eJs.a(this.ako);
            this.eJs.b(this.eJt);
            this.eJs.CS().bE(true);
            this.eJs.g(this.ako);
            aRg();
        }
    }

    public void bL(String str, String str2) {
        aRf();
        this.eJs.setReplyId(str);
        this.eJs.ga(str2);
    }

    private void aRg() {
        if (this.bXk != null && this.eJs != null && this.eJs.CS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bXk.addView(this.eJs.CS(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eJs != null) {
            this.eJs.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eJs != null) {
            this.eJs.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eJs != null && this.eJs.CS() != null) {
            this.eJs.CS().onChangeSkinType(i);
        }
    }
}
