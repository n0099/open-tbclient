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
    private RelativeLayout epW;
    private com.baidu.tbadk.editortools.pb.g hIB;
    private PbFakeFloorModel hIC;
    private String hID;
    private NewWriteModel.d hIE;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.epW = relativeLayout;
        this.hIC = pbFakeFloorModel;
    }

    public void bSv() {
        if (this.hIB != null) {
            this.hIB.arP();
            if (StringUtils.isNull(this.hID)) {
                this.hIB.onDestory();
            }
            this.hIB.aqS().ard();
        }
    }

    public void bSw() {
        if (this.hIB != null && this.hIB.aqS() != null) {
            this.hIB.aqS().app();
        }
    }

    public boolean bSx() {
        if (this.hIB == null || this.hIB.aqS() == null) {
            return false;
        }
        return this.hIB.aqS().aqV();
    }

    private void Be(String str) {
        if (this.epW != null && this.hIB == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.qi(str);
            this.hIB = (com.baidu.tbadk.editortools.pb.g) hVar.cJ(this.mPageContext.getPageActivity());
            this.hIB.a(this.mPageContext);
            this.hIB.b(this.hIC);
            this.hIB.aqS().fd(true);
            this.hIB.e(this.mPageContext);
            bSy();
            this.hIB.b(this.hIE);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hID = str2;
        if (this.hIB == null) {
            Be(str3);
        } else {
            this.hIB.b(this.hIC);
            if (StringUtils.isNull(this.hID)) {
                this.hIB.e(this.mPageContext);
            }
        }
        this.hIB.setReplyId(str);
        this.hIB.qh(str2);
        if (this.hIB.arG()) {
            this.hIB.a((PostWriteCallBackData) null);
        }
    }

    private void bSy() {
        if (this.epW != null && this.hIB != null && this.hIB.aqS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.epW.addView(this.hIB.aqS(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hIB != null) {
            this.hIB.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hIB != null) {
            this.hIB.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIB != null && this.hIB.aqS() != null) {
            this.hIB.aqS().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hIE = dVar;
        if (this.hIB != null) {
            this.hIB.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bSz() {
        return this.hIB;
    }
}
