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
    private RelativeLayout bjv;
    private com.baidu.tieba.pb.data.e kcE;
    private com.baidu.tbadk.editortools.pb.h keJ;
    private PbFakeFloorModel keK;
    private String keL;
    private NewWriteModel.d keM;
    private TbPageContext mPageContext;

    public t(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bjv = relativeLayout;
        this.keK = pbFakeFloorModel;
    }

    public void cIL() {
        if (this.keJ != null) {
            this.keJ.bgb();
            if (StringUtils.isNull(this.keL)) {
                this.keJ.onDestory();
            }
            this.keJ.bfa().bfk();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.kcE = eVar;
    }

    public void cIM() {
        if (this.keJ != null && this.keJ.bfa() != null) {
            this.keJ.bfa().bdC();
        }
    }

    public boolean cIN() {
        if (this.keJ == null || this.keJ.bfa() == null) {
            return false;
        }
        return this.keJ.bfa().bfc();
    }

    private void aO(String str, boolean z) {
        if (this.bjv != null && this.keJ == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.keJ = (com.baidu.tbadk.editortools.pb.h) iVar.dO(this.mPageContext.getPageActivity());
            this.keJ.a(this.mPageContext);
            this.keJ.b(this.keK);
            if (this.kcE != null) {
                this.keJ.setThreadData(this.kcE.cGO());
            }
            this.keJ.bfa().m32if(true);
            this.keJ.k(this.mPageContext);
            cIO();
            this.keJ.b(this.keM);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.keL = str2;
        if (this.keJ == null) {
            aO(str3, z);
        } else {
            this.keJ.b(this.keK);
            if (StringUtils.isNull(this.keL)) {
                this.keJ.k(this.mPageContext);
            }
        }
        this.keJ.setReplyId(str);
        this.keJ.yJ(str2);
        if (this.keJ.bfQ()) {
            this.keJ.a((PostWriteCallBackData) null);
        }
    }

    private void cIO() {
        if (this.bjv != null && this.keJ != null && this.keJ.bfa() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bjv.addView(this.keJ.bfa(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.keJ != null) {
            this.keJ.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.keJ != null) {
            this.keJ.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.keJ != null && this.keJ.bfa() != null) {
            this.keJ.bfa().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.keM = dVar;
        if (this.keJ != null) {
            this.keJ.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cIP() {
        return this.keJ;
    }
}
