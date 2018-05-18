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
public class r {
    private RelativeLayout cIJ;
    private com.baidu.tbadk.editortools.pb.g fkl;
    private PbFakeFloorModel fkm;
    private String fkn;
    private NewWriteModel.d fko;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cIJ = relativeLayout;
        this.fkm = pbFakeFloorModel;
    }

    public void aXV() {
        if (this.fkl != null) {
            this.fkl.Ey();
            if (StringUtils.isNull(this.fkn)) {
                this.fkl.onDestory();
            }
            this.fkl.DD().DN();
        }
    }

    public void aXW() {
        if (this.fkl != null && this.fkl.DD() != null) {
            this.fkl.DD().BY();
        }
    }

    public boolean aXX() {
        if (this.fkl == null || this.fkl.DD() == null) {
            return false;
        }
        return this.fkl.DD().DG();
    }

    private void aXY() {
        if (this.cIJ != null && this.fkl == null) {
            this.fkl = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aO(this.mPageContext.getPageActivity());
            this.fkl.setContext(this.mPageContext);
            this.fkl.b(this.fkm);
            this.fkl.DD().bx(true);
            this.fkl.d(this.mPageContext);
            aXZ();
            this.fkl.b(this.fko);
        }
    }

    public void bG(String str, String str2) {
        this.fkn = str2;
        if (this.fkl == null) {
            aXY();
        } else {
            this.fkl.b(this.fkm);
            if (StringUtils.isNull(this.fkn)) {
                this.fkl.d(this.mPageContext);
            }
        }
        this.fkl.setReplyId(str);
        this.fkl.gx(str2);
        if (this.fkl.Ep()) {
            this.fkl.a((PostWriteCallBackData) null);
        }
    }

    private void aXZ() {
        if (this.cIJ != null && this.fkl != null && this.fkl.DD() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cIJ.addView(this.fkl.DD(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fkl != null) {
            this.fkl.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fkl != null) {
            this.fkl.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fkl != null && this.fkl.DD() != null) {
            this.fkl.DD().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fko = dVar;
        if (this.fkl != null) {
            this.fkl.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g aYa() {
        return this.fkl;
    }
}
