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
    private RelativeLayout dhJ;
    private com.baidu.tbadk.editortools.pb.h fJZ;
    private PbFakeFloorModel fKa;
    private String fKb;
    private NewWriteModel.d fKc;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dhJ = relativeLayout;
        this.fKa = pbFakeFloorModel;
    }

    public void bbm() {
        if (this.fJZ != null) {
            this.fJZ.LB();
            if (StringUtils.isNull(this.fKb)) {
                this.fJZ.onDestory();
            }
            this.fJZ.KF().KP();
        }
    }

    public void bbn() {
        if (this.fJZ != null && this.fJZ.KF() != null) {
            this.fJZ.KF().IP();
        }
    }

    public boolean bbo() {
        if (this.fJZ == null || this.fJZ.KF() == null) {
            return false;
        }
        return this.fJZ.KF().KI();
    }

    private void bbp() {
        if (this.dhJ != null && this.fJZ == null) {
            this.fJZ = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bh(this.mPageContext.getPageActivity());
            this.fJZ.a(this.mPageContext);
            this.fJZ.b(this.fKa);
            this.fJZ.KF().cc(true);
            this.fJZ.e(this.mPageContext);
            bbr();
            this.fJZ.b(this.fKc);
        }
    }

    public void bH(String str, String str2) {
        this.fKb = str2;
        if (this.fJZ == null) {
            bbp();
        } else {
            this.fJZ.b(this.fKa);
            if (StringUtils.isNull(this.fKb)) {
                this.fJZ.e(this.mPageContext);
            }
        }
        this.fJZ.setReplyId(str);
        this.fJZ.gn(str2);
        if (this.fJZ.Lr()) {
            this.fJZ.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bbq() {
        return this.fJZ;
    }

    private void bbr() {
        if (this.dhJ != null && this.fJZ != null && this.fJZ.KF() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dhJ.addView(this.fJZ.KF(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fJZ != null) {
            this.fJZ.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fJZ != null) {
            this.fJZ.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fJZ != null && this.fJZ.KF() != null) {
            this.fJZ.KF().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fKc = dVar;
        if (this.fJZ != null) {
            this.fJZ.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bbs() {
        return this.fJZ;
    }
}
