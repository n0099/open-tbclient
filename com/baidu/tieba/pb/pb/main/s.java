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
    private RelativeLayout ctl;
    private com.baidu.tbadk.editortools.pb.h eXl;
    private PbFakeFloorModel eXm;
    private String eXn;
    private NewWriteModel.d eXo;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.ctl = relativeLayout;
        this.eXm = pbFakeFloorModel;
    }

    public void aUb() {
        if (this.eXl != null) {
            this.eXl.Ea();
            if (StringUtils.isNull(this.eXn)) {
                this.eXl.onDestory();
            }
            this.eXl.De().Do();
        }
    }

    private void aUc() {
        if (this.ctl != null && this.eXl == null) {
            this.eXl = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().aV(this.mPageContext.getPageActivity());
            this.eXl.a(this.mPageContext);
            this.eXl.b(this.eXm);
            this.eXl.De().by(true);
            this.eXl.e(this.mPageContext);
            aUe();
            this.eXl.b(this.eXo);
        }
    }

    public void bH(String str, String str2) {
        this.eXn = str2;
        if (this.eXl == null) {
            aUc();
        } else {
            this.eXl.b(this.eXm);
            if (StringUtils.isNull(this.eXn)) {
                this.eXl.e(this.mPageContext);
            }
        }
        this.eXl.setReplyId(str);
        this.eXl.gg(str2);
        if (this.eXl.DQ()) {
            this.eXl.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h aUd() {
        return this.eXl;
    }

    private void aUe() {
        if (this.ctl != null && this.eXl != null && this.eXl.De() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ctl.addView(this.eXl.De(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eXl != null) {
            this.eXl.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eXl != null) {
            this.eXl.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eXl != null && this.eXl.De() != null) {
            this.eXl.De().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eXo = dVar;
        if (this.eXl != null) {
            this.eXl.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h aUf() {
        return this.eXl;
    }
}
