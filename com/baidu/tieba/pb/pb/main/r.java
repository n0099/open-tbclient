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
    private RelativeLayout cHA;
    private com.baidu.tbadk.editortools.pb.g fje;
    private PbFakeFloorModel fjf;
    private String fjg;
    private NewWriteModel.d fjh;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cHA = relativeLayout;
        this.fjf = pbFakeFloorModel;
    }

    public void aXV() {
        if (this.fje != null) {
            this.fje.EA();
            if (StringUtils.isNull(this.fjg)) {
                this.fje.onDestory();
            }
            this.fje.DF().DP();
        }
    }

    public void aXW() {
        if (this.fje != null && this.fje.DF() != null) {
            this.fje.DF().Ca();
        }
    }

    public boolean aXX() {
        if (this.fje == null || this.fje.DF() == null) {
            return false;
        }
        return this.fje.DF().DI();
    }

    private void aXY() {
        if (this.cHA != null && this.fje == null) {
            this.fje = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aO(this.mPageContext.getPageActivity());
            this.fje.setContext(this.mPageContext);
            this.fje.b(this.fjf);
            this.fje.DF().bx(true);
            this.fje.d(this.mPageContext);
            aXZ();
            this.fje.b(this.fjh);
        }
    }

    public void bG(String str, String str2) {
        this.fjg = str2;
        if (this.fje == null) {
            aXY();
        } else {
            this.fje.b(this.fjf);
            if (StringUtils.isNull(this.fjg)) {
                this.fje.d(this.mPageContext);
            }
        }
        this.fje.setReplyId(str);
        this.fje.gx(str2);
        if (this.fje.Er()) {
            this.fje.a((PostWriteCallBackData) null);
        }
    }

    private void aXZ() {
        if (this.cHA != null && this.fje != null && this.fje.DF() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cHA.addView(this.fje.DF(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fje != null) {
            this.fje.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fje != null) {
            this.fje.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fje != null && this.fje.DF() != null) {
            this.fje.DF().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fjh = dVar;
        if (this.fje != null) {
            this.fje.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g aYa() {
        return this.fje;
    }
}
