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
    private RelativeLayout cHD;
    private com.baidu.tbadk.editortools.pb.g fjh;
    private PbFakeFloorModel fji;
    private String fjj;
    private NewWriteModel.d fjk;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cHD = relativeLayout;
        this.fji = pbFakeFloorModel;
    }

    public void aXV() {
        if (this.fjh != null) {
            this.fjh.EA();
            if (StringUtils.isNull(this.fjj)) {
                this.fjh.onDestory();
            }
            this.fjh.DF().DP();
        }
    }

    public void aXW() {
        if (this.fjh != null && this.fjh.DF() != null) {
            this.fjh.DF().Ca();
        }
    }

    public boolean aXX() {
        if (this.fjh == null || this.fjh.DF() == null) {
            return false;
        }
        return this.fjh.DF().DI();
    }

    private void aXY() {
        if (this.cHD != null && this.fjh == null) {
            this.fjh = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aO(this.mPageContext.getPageActivity());
            this.fjh.setContext(this.mPageContext);
            this.fjh.b(this.fji);
            this.fjh.DF().bx(true);
            this.fjh.d(this.mPageContext);
            aXZ();
            this.fjh.b(this.fjk);
        }
    }

    public void bG(String str, String str2) {
        this.fjj = str2;
        if (this.fjh == null) {
            aXY();
        } else {
            this.fjh.b(this.fji);
            if (StringUtils.isNull(this.fjj)) {
                this.fjh.d(this.mPageContext);
            }
        }
        this.fjh.setReplyId(str);
        this.fjh.gx(str2);
        if (this.fjh.Er()) {
            this.fjh.a((PostWriteCallBackData) null);
        }
    }

    private void aXZ() {
        if (this.cHD != null && this.fjh != null && this.fjh.DF() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cHD.addView(this.fjh.DF(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fjh != null) {
            this.fjh.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fjh != null) {
            this.fjh.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fjh != null && this.fjh.DF() != null) {
            this.fjh.DF().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fjk = dVar;
        if (this.fjh != null) {
            this.fjh.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g aYa() {
        return this.fjh;
    }
}
