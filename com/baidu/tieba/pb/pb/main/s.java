package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class s {
    private RelativeLayout aWR;
    private com.baidu.tieba.pb.data.e jqZ;
    private com.baidu.tbadk.editortools.pb.h jsV;
    private PbFakeFloorModel jsW;
    private String jsX;
    private NewWriteModel.d jsY;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aWR = relativeLayout;
        this.jsW = pbFakeFloorModel;
    }

    public void cxj() {
        if (this.jsV != null) {
            this.jsV.aXM();
            if (StringUtils.isNull(this.jsX)) {
                this.jsV.onDestory();
            }
            this.jsV.aWN().aWX();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jqZ = eVar;
    }

    public void cxk() {
        if (this.jsV != null && this.jsV.aWN() != null) {
            this.jsV.aWN().aVq();
        }
    }

    public boolean cxl() {
        if (this.jsV == null || this.jsV.aWN() == null) {
            return false;
        }
        return this.jsV.aWN().aWP();
    }

    private void az(String str, boolean z) {
        if (this.aWR != null && this.jsV == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.jsV = (com.baidu.tbadk.editortools.pb.h) iVar.dw(this.mPageContext.getPageActivity());
            this.jsV.a(this.mPageContext);
            this.jsV.b(this.jsW);
            if (this.jqZ != null) {
                this.jsV.setThreadData(this.jqZ.cvs());
            }
            this.jsV.aWN().hA(true);
            this.jsV.j(this.mPageContext);
            cxm();
            this.jsV.b(this.jsY);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.jsX = str2;
        if (this.jsV == null) {
            az(str3, z);
        } else {
            this.jsV.b(this.jsW);
            if (StringUtils.isNull(this.jsX)) {
                this.jsV.j(this.mPageContext);
            }
        }
        this.jsV.setReplyId(str);
        this.jsV.wK(str2);
        if (this.jsV.aXB()) {
            this.jsV.a((PostWriteCallBackData) null);
        }
    }

    private void cxm() {
        if (this.aWR != null && this.jsV != null && this.jsV.aWN() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aWR.addView(this.jsV.aWN(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.jsV != null) {
            this.jsV.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.jsV != null) {
            this.jsV.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jsV != null && this.jsV.aWN() != null) {
            this.jsV.aWN().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.jsY = dVar;
        if (this.jsV != null) {
            this.jsV.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cxn() {
        return this.jsV;
    }
}
