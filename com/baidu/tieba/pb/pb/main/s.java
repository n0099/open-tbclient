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
    private com.baidu.tbadk.editortools.pb.g hrn;
    private PbFakeFloorModel hro;
    private String hrp;
    private NewWriteModel.d hrq;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.eCz = relativeLayout;
        this.hro = pbFakeFloorModel;
    }

    public void bKF() {
        if (this.hrn != null) {
            this.hrn.amQ();
            if (StringUtils.isNull(this.hrp)) {
                this.hrn.onDestory();
            }
            this.hrn.alT().ame();
        }
    }

    public void bKG() {
        if (this.hrn != null && this.hrn.alT() != null) {
            this.hrn.alT().akq();
        }
    }

    public boolean bKH() {
        if (this.hrn == null || this.hrn.alT() == null) {
            return false;
        }
        return this.hrn.alT().alW();
    }

    private void zR(String str) {
        if (this.eCz != null && this.hrn == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.oZ(str);
            this.hrn = (com.baidu.tbadk.editortools.pb.g) hVar.dd(this.mPageContext.getPageActivity());
            this.hrn.a(this.mPageContext);
            this.hrn.b(this.hro);
            this.hrn.alT().eH(true);
            this.hrn.e(this.mPageContext);
            bKI();
            this.hrn.b(this.hrq);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hrp = str2;
        if (this.hrn == null) {
            zR(str3);
        } else {
            this.hrn.b(this.hro);
            if (StringUtils.isNull(this.hrp)) {
                this.hrn.e(this.mPageContext);
            }
        }
        this.hrn.setReplyId(str);
        this.hrn.oY(str2);
        if (this.hrn.amH()) {
            this.hrn.a((PostWriteCallBackData) null);
        }
    }

    private void bKI() {
        if (this.eCz != null && this.hrn != null && this.hrn.alT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCz.addView(this.hrn.alT(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hrn != null) {
            this.hrn.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hrn != null) {
            this.hrn.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hrn != null && this.hrn.alT() != null) {
            this.hrn.alT().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hrq = dVar;
        if (this.hrn != null) {
            this.hrn.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bKJ() {
        return this.hrn;
    }
}
