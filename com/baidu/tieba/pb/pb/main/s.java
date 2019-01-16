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
    private RelativeLayout drQ;
    private com.baidu.tbadk.editortools.pb.g gbb;
    private PbFakeFloorModel gbc;
    private String gbd;
    private NewWriteModel.d gbe;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.drQ = relativeLayout;
        this.gbc = pbFakeFloorModel;
    }

    public void bkg() {
        if (this.gbb != null) {
            this.gbb.Nl();
            if (StringUtils.isNull(this.gbd)) {
                this.gbb.onDestory();
            }
            this.gbb.Mp().Mz();
        }
    }

    public void bkh() {
        if (this.gbb != null && this.gbb.Mp() != null) {
            this.gbb.Mp().KM();
        }
    }

    public boolean bki() {
        if (this.gbb == null || this.gbb.Mp() == null) {
            return false;
        }
        return this.gbb.Mp().Ms();
    }

    private void bkj() {
        if (this.drQ != null && this.gbb == null) {
            this.gbb = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.mPageContext.getPageActivity());
            this.gbb.setContext(this.mPageContext);
            this.gbb.b(this.gbc);
            this.gbb.Mp().ct(true);
            this.gbb.d(this.mPageContext);
            bkk();
            this.gbb.b(this.gbe);
        }
    }

    public void co(String str, String str2) {
        this.gbd = str2;
        if (this.gbb == null) {
            bkj();
        } else {
            this.gbb.b(this.gbc);
            if (StringUtils.isNull(this.gbd)) {
                this.gbb.d(this.mPageContext);
            }
        }
        this.gbb.setReplyId(str);
        this.gbb.in(str2);
        if (this.gbb.Nc()) {
            this.gbb.a((PostWriteCallBackData) null);
        }
    }

    private void bkk() {
        if (this.drQ != null && this.gbb != null && this.gbb.Mp() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.drQ.addView(this.gbb.Mp(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gbb != null) {
            this.gbb.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.gbb != null) {
            this.gbb.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gbb != null && this.gbb.Mp() != null) {
            this.gbb.Mp().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.gbe = dVar;
        if (this.gbb != null) {
            this.gbb.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bkl() {
        return this.gbb;
    }
}
