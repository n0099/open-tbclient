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
    private RelativeLayout cth;
    private com.baidu.tbadk.editortools.pb.h eXg;
    private PbFakeFloorModel eXh;
    private String eXi;
    private NewWriteModel.d eXj;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cth = relativeLayout;
        this.eXh = pbFakeFloorModel;
    }

    public void aUa() {
        if (this.eXg != null) {
            this.eXg.Ea();
            if (StringUtils.isNull(this.eXi)) {
                this.eXg.onDestory();
            }
            this.eXg.De().Do();
        }
    }

    private void aUb() {
        if (this.cth != null && this.eXg == null) {
            this.eXg = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().aV(this.mPageContext.getPageActivity());
            this.eXg.a(this.mPageContext);
            this.eXg.b(this.eXh);
            this.eXg.De().by(true);
            this.eXg.e(this.mPageContext);
            aUd();
            this.eXg.b(this.eXj);
        }
    }

    public void bH(String str, String str2) {
        this.eXi = str2;
        if (this.eXg == null) {
            aUb();
        } else {
            this.eXg.b(this.eXh);
            if (StringUtils.isNull(this.eXi)) {
                this.eXg.e(this.mPageContext);
            }
        }
        this.eXg.setReplyId(str);
        this.eXg.gg(str2);
        if (this.eXg.DQ()) {
            this.eXg.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h aUc() {
        return this.eXg;
    }

    private void aUd() {
        if (this.cth != null && this.eXg != null && this.eXg.De() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cth.addView(this.eXg.De(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eXg != null) {
            this.eXg.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eXg != null) {
            this.eXg.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eXg != null && this.eXg.De() != null) {
            this.eXg.De().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eXj = dVar;
        if (this.eXg != null) {
            this.eXg.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h aUe() {
        return this.eXg;
    }
}
