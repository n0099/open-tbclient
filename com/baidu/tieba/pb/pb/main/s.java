package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class s {
    private RelativeLayout aqs;
    private com.baidu.tbadk.editortools.pb.g hQm;
    private PbFakeFloorModel hQn;
    private String hQo;
    private NewWriteModel.d hQp;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aqs = relativeLayout;
        this.hQn = pbFakeFloorModel;
    }

    public void bTn() {
        if (this.hQm != null) {
            this.hQm.auV();
            if (StringUtils.isNull(this.hQo)) {
                this.hQm.onDestory();
            }
            this.hQm.atZ().auj();
        }
    }

    public void bTo() {
        if (this.hQm != null && this.hQm.atZ() != null) {
            this.hQm.atZ().asC();
        }
    }

    public boolean bTp() {
        if (this.hQm == null || this.hQm.atZ() == null) {
            return false;
        }
        return this.hQm.atZ().aub();
    }

    private void AL(String str) {
        if (this.aqs != null && this.hQm == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.setHintText(str);
            this.hQm = (com.baidu.tbadk.editortools.pb.g) hVar.cw(this.mPageContext.getPageActivity());
            this.hQm.a(this.mPageContext);
            this.hQm.b(this.hQn);
            this.hQm.atZ().fe(true);
            this.hQm.e(this.mPageContext);
            bTq();
            this.hQm.b(this.hQp);
        }
    }

    public void ab(String str, String str2, String str3) {
        this.hQo = str2;
        if (this.hQm == null) {
            AL(str3);
        } else {
            this.hQm.b(this.hQn);
            if (StringUtils.isNull(this.hQo)) {
                this.hQm.e(this.mPageContext);
            }
        }
        this.hQm.setReplyId(str);
        this.hQm.pR(str2);
        if (this.hQm.auM()) {
            this.hQm.a((PostWriteCallBackData) null);
        }
    }

    private void bTq() {
        if (this.aqs != null && this.hQm != null && this.hQm.atZ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aqs.addView(this.hQm.atZ(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hQm != null) {
            this.hQm.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hQm != null) {
            this.hQm.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hQm != null && this.hQm.atZ() != null) {
            this.hQm.atZ().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hQp = dVar;
        if (this.hQm != null) {
            this.hQm.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bTr() {
        return this.hQm;
    }
}
