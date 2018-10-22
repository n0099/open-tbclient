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
    private com.baidu.tbadk.editortools.pb.g fOX;
    private PbFakeFloorModel fOY;
    private String fOZ;
    private NewWriteModel.d fPa;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dgE = relativeLayout;
        this.fOY = pbFakeFloorModel;
    }

    public void bhC() {
        if (this.fOX != null) {
            this.fOX.LD();
            if (StringUtils.isNull(this.fOZ)) {
                this.fOX.onDestory();
            }
            this.fOX.KH().KR();
        }
    }

    public void bhD() {
        if (this.fOX != null && this.fOX.KH() != null) {
            this.fOX.KH().Jg();
        }
    }

    public boolean bhE() {
        if (this.fOX == null || this.fOX.KH() == null) {
            return false;
        }
        return this.fOX.KH().KK();
    }

    private void bhF() {
        if (this.dgE != null && this.fOX == null) {
            this.fOX = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.mPageContext.getPageActivity());
            this.fOX.setContext(this.mPageContext);
            this.fOX.b(this.fOY);
            this.fOX.KH().bY(true);
            this.fOX.d(this.mPageContext);
            bhG();
            this.fOX.b(this.fPa);
        }
    }

    public void ci(String str, String str2) {
        this.fOZ = str2;
        if (this.fOX == null) {
            bhF();
        } else {
            this.fOX.b(this.fOY);
            if (StringUtils.isNull(this.fOZ)) {
                this.fOX.d(this.mPageContext);
            }
        }
        this.fOX.setReplyId(str);
        this.fOX.hF(str2);
        if (this.fOX.Lu()) {
            this.fOX.a((PostWriteCallBackData) null);
        }
    }

    private void bhG() {
        if (this.dgE != null && this.fOX != null && this.fOX.KH() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dgE.addView(this.fOX.KH(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fOX != null) {
            this.fOX.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fOX != null) {
            this.fOX.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fOX != null && this.fOX.KH() != null) {
            this.fOX.KH().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fPa = dVar;
        if (this.fOX != null) {
            this.fOX.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bhH() {
        return this.fOX;
    }
}
