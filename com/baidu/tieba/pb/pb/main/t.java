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
public class t {
    private RelativeLayout bej;
    private com.baidu.tieba.pb.data.e jIU;
    private com.baidu.tbadk.editortools.pb.h jKY;
    private PbFakeFloorModel jKZ;
    private String jLa;
    private NewWriteModel.d jLb;
    private TbPageContext mPageContext;

    public t(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bej = relativeLayout;
        this.jKZ = pbFakeFloorModel;
    }

    public void cEu() {
        if (this.jKY != null) {
            this.jKY.bdW();
            if (StringUtils.isNull(this.jLa)) {
                this.jKY.onDestory();
            }
            this.jKY.bcX().bdh();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jIU = eVar;
    }

    public void cEv() {
        if (this.jKY != null && this.jKY.bcX() != null) {
            this.jKY.bcX().bbA();
        }
    }

    public boolean cEw() {
        if (this.jKY == null || this.jKY.bcX() == null) {
            return false;
        }
        return this.jKY.bcX().bcZ();
    }

    private void aM(String str, boolean z) {
        if (this.bej != null && this.jKY == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.jKY = (com.baidu.tbadk.editortools.pb.h) iVar.dN(this.mPageContext.getPageActivity());
            this.jKY.a(this.mPageContext);
            this.jKY.b(this.jKZ);
            if (this.jIU != null) {
                this.jKY.setThreadData(this.jIU.cCy());
            }
            this.jKY.bcX().hW(true);
            this.jKY.h(this.mPageContext);
            cEx();
            this.jKY.b(this.jLb);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.jLa = str2;
        if (this.jKY == null) {
            aM(str3, z);
        } else {
            this.jKY.b(this.jKZ);
            if (StringUtils.isNull(this.jLa)) {
                this.jKY.h(this.mPageContext);
            }
        }
        this.jKY.setReplyId(str);
        this.jKY.yq(str2);
        if (this.jKY.bdL()) {
            this.jKY.a((PostWriteCallBackData) null);
        }
    }

    private void cEx() {
        if (this.bej != null && this.jKY != null && this.jKY.bcX() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bej.addView(this.jKY.bcX(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.jKY != null) {
            this.jKY.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.jKY != null) {
            this.jKY.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jKY != null && this.jKY.bcX() != null) {
            this.jKY.bcX().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.jLb = dVar;
        if (this.jKY != null) {
            this.jKY.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cEy() {
        return this.jKY;
    }
}
