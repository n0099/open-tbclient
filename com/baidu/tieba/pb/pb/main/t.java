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
    private com.baidu.tieba.pb.data.e jHO;
    private com.baidu.tbadk.editortools.pb.h jJS;
    private PbFakeFloorModel jJT;
    private String jJU;
    private NewWriteModel.d jJV;
    private TbPageContext mPageContext;

    public t(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bej = relativeLayout;
        this.jJT = pbFakeFloorModel;
    }

    public void cEe() {
        if (this.jJS != null) {
            this.jJS.bdV();
            if (StringUtils.isNull(this.jJU)) {
                this.jJS.onDestory();
            }
            this.jJS.bcW().bdg();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jHO = eVar;
    }

    public void cEf() {
        if (this.jJS != null && this.jJS.bcW() != null) {
            this.jJS.bcW().bbz();
        }
    }

    public boolean cEg() {
        if (this.jJS == null || this.jJS.bcW() == null) {
            return false;
        }
        return this.jJS.bcW().bcY();
    }

    private void aM(String str, boolean z) {
        if (this.bej != null && this.jJS == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.jJS = (com.baidu.tbadk.editortools.pb.h) iVar.dN(this.mPageContext.getPageActivity());
            this.jJS.a(this.mPageContext);
            this.jJS.b(this.jJT);
            if (this.jHO != null) {
                this.jJS.setThreadData(this.jHO.cCi());
            }
            this.jJS.bcW().hW(true);
            this.jJS.h(this.mPageContext);
            cEh();
            this.jJS.b(this.jJV);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.jJU = str2;
        if (this.jJS == null) {
            aM(str3, z);
        } else {
            this.jJS.b(this.jJT);
            if (StringUtils.isNull(this.jJU)) {
                this.jJS.h(this.mPageContext);
            }
        }
        this.jJS.setReplyId(str);
        this.jJS.yq(str2);
        if (this.jJS.bdK()) {
            this.jJS.a((PostWriteCallBackData) null);
        }
    }

    private void cEh() {
        if (this.bej != null && this.jJS != null && this.jJS.bcW() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bej.addView(this.jJS.bcW(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.jJS != null) {
            this.jJS.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.jJS != null) {
            this.jJS.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jJS != null && this.jJS.bcW() != null) {
            this.jJS.bcW().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.jJV = dVar;
        if (this.jJS != null) {
            this.jJS.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cEi() {
        return this.jJS;
    }
}
