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
    private RelativeLayout evb;
    private com.baidu.tbadk.editortools.pb.g hPK;
    private PbFakeFloorModel hPL;
    private String hPM;
    private NewWriteModel.d hPN;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.evb = relativeLayout;
        this.hPL = pbFakeFloorModel;
    }

    public void bVy() {
        if (this.hPK != null) {
            this.hPK.asX();
            if (StringUtils.isNull(this.hPM)) {
                this.hPK.onDestory();
            }
            this.hPK.asa().asl();
        }
    }

    public void bVz() {
        if (this.hPK != null && this.hPK.asa() != null) {
            this.hPK.asa().aqw();
        }
    }

    public boolean bVA() {
        if (this.hPK == null || this.hPK.asa() == null) {
            return false;
        }
        return this.hPK.asa().asd();
    }

    private void BT(String str) {
        if (this.evb != null && this.hPK == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.qy(str);
            this.hPK = (com.baidu.tbadk.editortools.pb.g) hVar.cK(this.mPageContext.getPageActivity());
            this.hPK.a(this.mPageContext);
            this.hPK.b(this.hPL);
            this.hPK.asa().fh(true);
            this.hPK.e(this.mPageContext);
            bVB();
            this.hPK.b(this.hPN);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hPM = str2;
        if (this.hPK == null) {
            BT(str3);
        } else {
            this.hPK.b(this.hPL);
            if (StringUtils.isNull(this.hPM)) {
                this.hPK.e(this.mPageContext);
            }
        }
        this.hPK.setReplyId(str);
        this.hPK.qx(str2);
        if (this.hPK.asO()) {
            this.hPK.a((PostWriteCallBackData) null);
        }
    }

    private void bVB() {
        if (this.evb != null && this.hPK != null && this.hPK.asa() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.evb.addView(this.hPK.asa(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hPK != null) {
            this.hPK.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hPK != null) {
            this.hPK.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hPK != null && this.hPK.asa() != null) {
            this.hPK.asa().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hPN = dVar;
        if (this.hPK != null) {
            this.hPK.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bVC() {
        return this.hPK;
    }
}
