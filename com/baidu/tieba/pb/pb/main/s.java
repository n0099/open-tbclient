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
    private RelativeLayout eCv;
    private com.baidu.tbadk.editortools.pb.g hrg;
    private PbFakeFloorModel hrh;
    private String hri;
    private NewWriteModel.d hrj;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.eCv = relativeLayout;
        this.hrh = pbFakeFloorModel;
    }

    public void bKE() {
        if (this.hrg != null) {
            this.hrg.amP();
            if (StringUtils.isNull(this.hri)) {
                this.hrg.onDestory();
            }
            this.hrg.alS().amd();
        }
    }

    public void bKF() {
        if (this.hrg != null && this.hrg.alS() != null) {
            this.hrg.alS().akp();
        }
    }

    public boolean bKG() {
        if (this.hrg == null || this.hrg.alS() == null) {
            return false;
        }
        return this.hrg.alS().alV();
    }

    private void zP(String str) {
        if (this.eCv != null && this.hrg == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.oZ(str);
            this.hrg = (com.baidu.tbadk.editortools.pb.g) hVar.dd(this.mPageContext.getPageActivity());
            this.hrg.a(this.mPageContext);
            this.hrg.b(this.hrh);
            this.hrg.alS().eH(true);
            this.hrg.e(this.mPageContext);
            bKH();
            this.hrg.b(this.hrj);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hri = str2;
        if (this.hrg == null) {
            zP(str3);
        } else {
            this.hrg.b(this.hrh);
            if (StringUtils.isNull(this.hri)) {
                this.hrg.e(this.mPageContext);
            }
        }
        this.hrg.setReplyId(str);
        this.hrg.oY(str2);
        if (this.hrg.amG()) {
            this.hrg.a((PostWriteCallBackData) null);
        }
    }

    private void bKH() {
        if (this.eCv != null && this.hrg != null && this.hrg.alS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCv.addView(this.hrg.alS(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hrg != null) {
            this.hrg.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hrg != null) {
            this.hrg.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hrg != null && this.hrg.alS() != null) {
            this.hrg.alS().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hrj = dVar;
        if (this.hrg != null) {
            this.hrg.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bKI() {
        return this.hrg;
    }
}
