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
    private RelativeLayout dgE;
    private com.baidu.tbadk.editortools.pb.g fOW;
    private PbFakeFloorModel fOX;
    private String fOY;
    private NewWriteModel.d fOZ;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dgE = relativeLayout;
        this.fOX = pbFakeFloorModel;
    }

    public void bhC() {
        if (this.fOW != null) {
            this.fOW.LD();
            if (StringUtils.isNull(this.fOY)) {
                this.fOW.onDestory();
            }
            this.fOW.KH().KR();
        }
    }

    public void bhD() {
        if (this.fOW != null && this.fOW.KH() != null) {
            this.fOW.KH().Jg();
        }
    }

    public boolean bhE() {
        if (this.fOW == null || this.fOW.KH() == null) {
            return false;
        }
        return this.fOW.KH().KK();
    }

    private void bhF() {
        if (this.dgE != null && this.fOW == null) {
            this.fOW = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.mPageContext.getPageActivity());
            this.fOW.setContext(this.mPageContext);
            this.fOW.b(this.fOX);
            this.fOW.KH().bY(true);
            this.fOW.d(this.mPageContext);
            bhG();
            this.fOW.b(this.fOZ);
        }
    }

    public void ci(String str, String str2) {
        this.fOY = str2;
        if (this.fOW == null) {
            bhF();
        } else {
            this.fOW.b(this.fOX);
            if (StringUtils.isNull(this.fOY)) {
                this.fOW.d(this.mPageContext);
            }
        }
        this.fOW.setReplyId(str);
        this.fOW.hF(str2);
        if (this.fOW.Lu()) {
            this.fOW.a((PostWriteCallBackData) null);
        }
    }

    private void bhG() {
        if (this.dgE != null && this.fOW != null && this.fOW.KH() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dgE.addView(this.fOW.KH(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fOW != null) {
            this.fOW.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fOW != null) {
            this.fOW.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fOW != null && this.fOW.KH() != null) {
            this.fOW.KH().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fOZ = dVar;
        if (this.fOW != null) {
            this.fOW.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bhH() {
        return this.fOW;
    }
}
