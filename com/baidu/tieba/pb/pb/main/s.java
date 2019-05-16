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
    private RelativeLayout epV;
    private String hIA;
    private NewWriteModel.d hIB;
    private com.baidu.tbadk.editortools.pb.g hIy;
    private PbFakeFloorModel hIz;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.epV = relativeLayout;
        this.hIz = pbFakeFloorModel;
    }

    public void bSs() {
        if (this.hIy != null) {
            this.hIy.arP();
            if (StringUtils.isNull(this.hIA)) {
                this.hIy.onDestory();
            }
            this.hIy.aqS().ard();
        }
    }

    public void bSt() {
        if (this.hIy != null && this.hIy.aqS() != null) {
            this.hIy.aqS().app();
        }
    }

    public boolean bSu() {
        if (this.hIy == null || this.hIy.aqS() == null) {
            return false;
        }
        return this.hIy.aqS().aqV();
    }

    private void Be(String str) {
        if (this.epV != null && this.hIy == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.qi(str);
            this.hIy = (com.baidu.tbadk.editortools.pb.g) hVar.cJ(this.mPageContext.getPageActivity());
            this.hIy.a(this.mPageContext);
            this.hIy.b(this.hIz);
            this.hIy.aqS().fd(true);
            this.hIy.e(this.mPageContext);
            bSv();
            this.hIy.b(this.hIB);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hIA = str2;
        if (this.hIy == null) {
            Be(str3);
        } else {
            this.hIy.b(this.hIz);
            if (StringUtils.isNull(this.hIA)) {
                this.hIy.e(this.mPageContext);
            }
        }
        this.hIy.setReplyId(str);
        this.hIy.qh(str2);
        if (this.hIy.arG()) {
            this.hIy.a((PostWriteCallBackData) null);
        }
    }

    private void bSv() {
        if (this.epV != null && this.hIy != null && this.hIy.aqS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.epV.addView(this.hIy.aqS(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hIy != null) {
            this.hIy.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hIy != null) {
            this.hIy.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIy != null && this.hIy.aqS() != null) {
            this.hIy.aqS().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hIB = dVar;
        if (this.hIy != null) {
            this.hIy.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bSw() {
        return this.hIy;
    }
}
