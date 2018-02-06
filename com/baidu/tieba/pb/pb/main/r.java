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
    private RelativeLayout dpw;
    private com.baidu.tbadk.editortools.pb.h fPd;
    private PbFakeFloorModel fPe;
    private String fPf;
    private NewWriteModel.d fPg;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dpw = relativeLayout;
        this.fPe = pbFakeFloorModel;
    }

    public void bcX() {
        if (this.fPd != null) {
            this.fPd.LX();
            if (StringUtils.isNull(this.fPf)) {
                this.fPd.onDestory();
            }
            this.fPd.Lc().Lm();
        }
    }

    public void bcY() {
        if (this.fPd != null && this.fPd.Lc() != null) {
            this.fPd.Lc().Jm();
        }
    }

    public boolean bcZ() {
        if (this.fPd == null || this.fPd.Lc() == null) {
            return false;
        }
        return this.fPd.Lc().Lf();
    }

    private void bda() {
        if (this.dpw != null && this.fPd == null) {
            this.fPd = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bd(this.mPageContext.getPageActivity());
            this.fPd.setContext(this.mPageContext);
            this.fPd.b(this.fPe);
            this.fPd.Lc().cf(true);
            this.fPd.d(this.mPageContext);
            bdc();
            this.fPd.b(this.fPg);
        }
    }

    public void bG(String str, String str2) {
        this.fPf = str2;
        if (this.fPd == null) {
            bda();
        } else {
            this.fPd.b(this.fPe);
            if (StringUtils.isNull(this.fPf)) {
                this.fPd.d(this.mPageContext);
            }
        }
        this.fPd.setReplyId(str);
        this.fPd.gG(str2);
        if (this.fPd.LO()) {
            this.fPd.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bdb() {
        return this.fPd;
    }

    private void bdc() {
        if (this.dpw != null && this.fPd != null && this.fPd.Lc() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dpw.addView(this.fPd.Lc(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fPd != null) {
            this.fPd.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fPd != null) {
            this.fPd.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fPd != null && this.fPd.Lc() != null) {
            this.fPd.Lc().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fPg = dVar;
        if (this.fPd != null) {
            this.fPd.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bdd() {
        return this.fPd;
    }
}
