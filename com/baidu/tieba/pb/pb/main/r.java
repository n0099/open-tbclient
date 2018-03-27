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
    private RelativeLayout dpn;
    private com.baidu.tbadk.editortools.pb.h fPi;
    private PbFakeFloorModel fPj;
    private String fPk;
    private NewWriteModel.d fPl;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dpn = relativeLayout;
        this.fPj = pbFakeFloorModel;
    }

    public void bcX() {
        if (this.fPi != null) {
            this.fPi.LX();
            if (StringUtils.isNull(this.fPk)) {
                this.fPi.onDestory();
            }
            this.fPi.Lc().Lm();
        }
    }

    public void bcY() {
        if (this.fPi != null && this.fPi.Lc() != null) {
            this.fPi.Lc().Jm();
        }
    }

    public boolean bcZ() {
        if (this.fPi == null || this.fPi.Lc() == null) {
            return false;
        }
        return this.fPi.Lc().Lf();
    }

    private void bda() {
        if (this.dpn != null && this.fPi == null) {
            this.fPi = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bd(this.mPageContext.getPageActivity());
            this.fPi.setContext(this.mPageContext);
            this.fPi.b(this.fPj);
            this.fPi.Lc().cf(true);
            this.fPi.d(this.mPageContext);
            bdc();
            this.fPi.b(this.fPl);
        }
    }

    public void bG(String str, String str2) {
        this.fPk = str2;
        if (this.fPi == null) {
            bda();
        } else {
            this.fPi.b(this.fPj);
            if (StringUtils.isNull(this.fPk)) {
                this.fPi.d(this.mPageContext);
            }
        }
        this.fPi.setReplyId(str);
        this.fPi.gG(str2);
        if (this.fPi.LO()) {
            this.fPi.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bdb() {
        return this.fPi;
    }

    private void bdc() {
        if (this.dpn != null && this.fPi != null && this.fPi.Lc() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dpn.addView(this.fPi.Lc(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fPi != null) {
            this.fPi.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fPi != null) {
            this.fPi.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fPi != null && this.fPi.Lc() != null) {
            this.fPi.Lc().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fPl = dVar;
        if (this.fPi != null) {
            this.fPi.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bdd() {
        return this.fPi;
    }
}
