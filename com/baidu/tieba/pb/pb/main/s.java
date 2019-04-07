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
    private RelativeLayout eCg;
    private com.baidu.tbadk.editortools.pb.g hqT;
    private PbFakeFloorModel hqU;
    private String hqV;
    private NewWriteModel.d hqW;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.eCg = relativeLayout;
        this.hqU = pbFakeFloorModel;
    }

    public void bKB() {
        if (this.hqT != null) {
            this.hqT.amM();
            if (StringUtils.isNull(this.hqV)) {
                this.hqT.onDestory();
            }
            this.hqT.alP().ama();
        }
    }

    public void bKC() {
        if (this.hqT != null && this.hqT.alP() != null) {
            this.hqT.alP().akm();
        }
    }

    public boolean bKD() {
        if (this.hqT == null || this.hqT.alP() == null) {
            return false;
        }
        return this.hqT.alP().alS();
    }

    private void zO(String str) {
        if (this.eCg != null && this.hqT == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.pa(str);
            this.hqT = (com.baidu.tbadk.editortools.pb.g) hVar.dd(this.mPageContext.getPageActivity());
            this.hqT.a(this.mPageContext);
            this.hqT.b(this.hqU);
            this.hqT.alP().eH(true);
            this.hqT.e(this.mPageContext);
            bKE();
            this.hqT.b(this.hqW);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hqV = str2;
        if (this.hqT == null) {
            zO(str3);
        } else {
            this.hqT.b(this.hqU);
            if (StringUtils.isNull(this.hqV)) {
                this.hqT.e(this.mPageContext);
            }
        }
        this.hqT.setReplyId(str);
        this.hqT.oZ(str2);
        if (this.hqT.amD()) {
            this.hqT.a((PostWriteCallBackData) null);
        }
    }

    private void bKE() {
        if (this.eCg != null && this.hqT != null && this.hqT.alP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCg.addView(this.hqT.alP(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hqT != null) {
            this.hqT.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hqT != null) {
            this.hqT.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hqT != null && this.hqT.alP() != null) {
            this.hqT.alP().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hqW = dVar;
        if (this.hqT != null) {
            this.hqT.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bKF() {
        return this.hqT;
    }
}
