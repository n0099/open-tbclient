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
    private RelativeLayout eCh;
    private com.baidu.tbadk.editortools.pb.g hqU;
    private PbFakeFloorModel hqV;
    private String hqW;
    private NewWriteModel.d hqX;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.eCh = relativeLayout;
        this.hqV = pbFakeFloorModel;
    }

    public void bKB() {
        if (this.hqU != null) {
            this.hqU.amM();
            if (StringUtils.isNull(this.hqW)) {
                this.hqU.onDestory();
            }
            this.hqU.alP().ama();
        }
    }

    public void bKC() {
        if (this.hqU != null && this.hqU.alP() != null) {
            this.hqU.alP().akm();
        }
    }

    public boolean bKD() {
        if (this.hqU == null || this.hqU.alP() == null) {
            return false;
        }
        return this.hqU.alP().alS();
    }

    private void zO(String str) {
        if (this.eCh != null && this.hqU == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.pa(str);
            this.hqU = (com.baidu.tbadk.editortools.pb.g) hVar.dd(this.mPageContext.getPageActivity());
            this.hqU.a(this.mPageContext);
            this.hqU.b(this.hqV);
            this.hqU.alP().eH(true);
            this.hqU.e(this.mPageContext);
            bKE();
            this.hqU.b(this.hqX);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hqW = str2;
        if (this.hqU == null) {
            zO(str3);
        } else {
            this.hqU.b(this.hqV);
            if (StringUtils.isNull(this.hqW)) {
                this.hqU.e(this.mPageContext);
            }
        }
        this.hqU.setReplyId(str);
        this.hqU.oZ(str2);
        if (this.hqU.amD()) {
            this.hqU.a((PostWriteCallBackData) null);
        }
    }

    private void bKE() {
        if (this.eCh != null && this.hqU != null && this.hqU.alP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCh.addView(this.hqU.alP(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hqU != null) {
            this.hqU.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hqU != null) {
            this.hqU.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hqU != null && this.hqU.alP() != null) {
            this.hqU.alP().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hqX = dVar;
        if (this.hqU != null) {
            this.hqU.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bKF() {
        return this.hqU;
    }
}
