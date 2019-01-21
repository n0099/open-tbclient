package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class s {
    private RelativeLayout drR;
    private com.baidu.tbadk.editortools.pb.g gbc;
    private PbFakeFloorModel gbd;
    private String gbe;
    private NewWriteModel.d gbf;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.drR = relativeLayout;
        this.gbd = pbFakeFloorModel;
    }

    public void bkg() {
        if (this.gbc != null) {
            this.gbc.Nl();
            if (StringUtils.isNull(this.gbe)) {
                this.gbc.onDestory();
            }
            this.gbc.Mp().Mz();
        }
    }

    public void bkh() {
        if (this.gbc != null && this.gbc.Mp() != null) {
            this.gbc.Mp().KM();
        }
    }

    public boolean bki() {
        if (this.gbc == null || this.gbc.Mp() == null) {
            return false;
        }
        return this.gbc.Mp().Ms();
    }

    private void bkj() {
        if (this.drR != null && this.gbc == null) {
            this.gbc = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.mPageContext.getPageActivity());
            this.gbc.setContext(this.mPageContext);
            this.gbc.b(this.gbd);
            this.gbc.Mp().ct(true);
            this.gbc.d(this.mPageContext);
            bkk();
            this.gbc.b(this.gbf);
        }
    }

    public void co(String str, String str2) {
        this.gbe = str2;
        if (this.gbc == null) {
            bkj();
        } else {
            this.gbc.b(this.gbd);
            if (StringUtils.isNull(this.gbe)) {
                this.gbc.d(this.mPageContext);
            }
        }
        this.gbc.setReplyId(str);
        this.gbc.in(str2);
        if (this.gbc.Nc()) {
            this.gbc.a((PostWriteCallBackData) null);
        }
    }

    private void bkk() {
        if (this.drR != null && this.gbc != null && this.gbc.Mp() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.drR.addView(this.gbc.Mp(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gbc != null) {
            this.gbc.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.gbc != null) {
            this.gbc.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gbc != null && this.gbc.Mp() != null) {
            this.gbc.Mp().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.gbf = dVar;
        if (this.gbc != null) {
            this.gbc.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bkl() {
        return this.gbc;
    }
}
