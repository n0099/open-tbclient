package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes7.dex */
public class t {
    private RelativeLayout ayz;
    private com.baidu.tieba.pb.data.f iDs;
    private com.baidu.tbadk.editortools.pb.h iFr;
    private PbFakeFloorModel iFs;
    private String iFt;
    private NewWriteModel.d iFu;
    private TbPageContext mPageContext;

    public t(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.ayz = relativeLayout;
        this.iFs = pbFakeFloorModel;
    }

    public void ckN() {
        if (this.iFr != null) {
            this.iFr.aMU();
            if (StringUtils.isNull(this.iFt)) {
                this.iFr.onDestory();
            }
            this.iFr.aLV().aMf();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.iDs = fVar;
    }

    public void ckO() {
        if (this.iFr != null && this.iFr.aLV() != null) {
            this.iFr.aLV().aKs();
        }
    }

    public boolean ckP() {
        if (this.iFr == null || this.iFr.aLV() == null) {
            return false;
        }
        return this.iFr.aLV().aLX();
    }

    private void at(String str, boolean z) {
        if (this.ayz != null && this.iFr == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.iFr = (com.baidu.tbadk.editortools.pb.h) iVar.dR(this.mPageContext.getPageActivity());
            this.iFr.a(this.mPageContext);
            this.iFr.b(this.iFs);
            if (this.iDs != null) {
                this.iFr.setThreadData(this.iDs.ciS());
            }
            this.iFr.aLV().gu(true);
            this.iFr.g(this.mPageContext);
            ckQ();
            this.iFr.b(this.iFu);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.iFt = str2;
        if (this.iFr == null) {
            at(str3, z);
        } else {
            this.iFr.b(this.iFs);
            if (StringUtils.isNull(this.iFt)) {
                this.iFr.g(this.mPageContext);
            }
        }
        this.iFr.setReplyId(str);
        this.iFr.vb(str2);
        if (this.iFr.aMJ()) {
            this.iFr.a((PostWriteCallBackData) null);
        }
    }

    private void ckQ() {
        if (this.ayz != null && this.iFr != null && this.iFr.aLV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ayz.addView(this.iFr.aLV(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iFr != null) {
            this.iFr.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.iFr != null) {
            this.iFr.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iFr != null && this.iFr.aLV() != null) {
            this.iFr.aLV().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.iFu = dVar;
        if (this.iFr != null) {
            this.iFr.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h ckR() {
        return this.iFr;
    }
}
