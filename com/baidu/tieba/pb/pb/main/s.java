package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class s {
    private RelativeLayout cYo;
    private com.baidu.tbadk.editortools.pb.g fHv;
    private PbFakeFloorModel fHw;
    private String fHx;
    private NewWriteModel.d fHy;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cYo = relativeLayout;
        this.fHw = pbFakeFloorModel;
    }

    public void beq() {
        if (this.fHv != null) {
            this.fHv.JF();
            if (StringUtils.isNull(this.fHx)) {
                this.fHv.onDestory();
            }
            this.fHv.IJ().IT();
        }
    }

    public void ber() {
        if (this.fHv != null && this.fHv.IJ() != null) {
            this.fHv.IJ().Hf();
        }
    }

    public boolean bes() {
        if (this.fHv == null || this.fHv.IJ() == null) {
            return false;
        }
        return this.fHv.IJ().IM();
    }

    private void bet() {
        if (this.cYo != null && this.fHv == null) {
            this.fHv = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bE(this.mPageContext.getPageActivity());
            this.fHv.setContext(this.mPageContext);
            this.fHv.b(this.fHw);
            this.fHv.IJ().bP(true);
            this.fHv.d(this.mPageContext);
            beu();
            this.fHv.b(this.fHy);
        }
    }

    public void bW(String str, String str2) {
        this.fHx = str2;
        if (this.fHv == null) {
            bet();
        } else {
            this.fHv.b(this.fHw);
            if (StringUtils.isNull(this.fHx)) {
                this.fHv.d(this.mPageContext);
            }
        }
        this.fHv.setReplyId(str);
        this.fHv.hr(str2);
        if (this.fHv.Jw()) {
            this.fHv.a((PostWriteCallBackData) null);
        }
    }

    private void beu() {
        if (this.cYo != null && this.fHv != null && this.fHv.IJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cYo.addView(this.fHv.IJ(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fHv != null) {
            this.fHv.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fHv != null) {
            this.fHv.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fHv != null && this.fHv.IJ() != null) {
            this.fHv.IJ().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fHy = dVar;
        if (this.fHv != null) {
            this.fHv.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bev() {
        return this.fHv;
    }
}
