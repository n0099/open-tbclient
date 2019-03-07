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
    private RelativeLayout eCz;
    private com.baidu.tbadk.editortools.pb.g hrm;
    private PbFakeFloorModel hrn;
    private String hro;
    private NewWriteModel.d hrp;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.eCz = relativeLayout;
        this.hrn = pbFakeFloorModel;
    }

    public void bKE() {
        if (this.hrm != null) {
            this.hrm.amQ();
            if (StringUtils.isNull(this.hro)) {
                this.hrm.onDestory();
            }
            this.hrm.alT().ame();
        }
    }

    public void bKF() {
        if (this.hrm != null && this.hrm.alT() != null) {
            this.hrm.alT().akq();
        }
    }

    public boolean bKG() {
        if (this.hrm == null || this.hrm.alT() == null) {
            return false;
        }
        return this.hrm.alT().alW();
    }

    private void zQ(String str) {
        if (this.eCz != null && this.hrm == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.oZ(str);
            this.hrm = (com.baidu.tbadk.editortools.pb.g) hVar.dd(this.mPageContext.getPageActivity());
            this.hrm.a(this.mPageContext);
            this.hrm.b(this.hrn);
            this.hrm.alT().eH(true);
            this.hrm.e(this.mPageContext);
            bKH();
            this.hrm.b(this.hrp);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hro = str2;
        if (this.hrm == null) {
            zQ(str3);
        } else {
            this.hrm.b(this.hrn);
            if (StringUtils.isNull(this.hro)) {
                this.hrm.e(this.mPageContext);
            }
        }
        this.hrm.setReplyId(str);
        this.hrm.oY(str2);
        if (this.hrm.amH()) {
            this.hrm.a((PostWriteCallBackData) null);
        }
    }

    private void bKH() {
        if (this.eCz != null && this.hrm != null && this.hrm.alT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCz.addView(this.hrm.alT(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hrm != null) {
            this.hrm.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hrm != null) {
            this.hrm.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hrm != null && this.hrm.alT() != null) {
            this.hrm.alT().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hrp = dVar;
        if (this.hrm != null) {
            this.hrm.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bKI() {
        return this.hrm;
    }
}
