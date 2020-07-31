package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes16.dex */
public class v {
    private RelativeLayout bjP;
    private com.baidu.tieba.pb.data.f klg;
    private NewWriteModel.d knA;
    private View.OnClickListener knB;
    private com.baidu.tbadk.editortools.pb.h knw;
    private PbFakeFloorModel knx;
    private String kny;
    private String knz;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bjP = relativeLayout;
        this.knx = pbFakeFloorModel;
    }

    public void cMv() {
        if (this.knw != null) {
            this.knw.bjM();
            if (StringUtils.isNull(this.kny)) {
                this.knw.onDestory();
            }
            this.knw.biJ().biU();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.klg = fVar;
    }

    public void cMw() {
        if (this.knw != null && this.knw.biJ() != null) {
            this.knw.biJ().bhl();
        }
    }

    public boolean cMx() {
        if (this.knw == null || this.knw.biJ() == null) {
            return false;
        }
        return this.knw.biJ().biL();
    }

    private void aM(String str, boolean z) {
        if (this.bjP != null && this.knw == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.knw = (com.baidu.tbadk.editortools.pb.h) iVar.dT(this.mPageContext.getPageActivity());
            this.knw.a(this.mPageContext);
            this.knw.b(this.knx);
            if (this.klg != null) {
                this.knw.setThreadData(this.klg.cKx());
            }
            this.knw.biJ().iJ(true);
            this.knw.biJ().setOnCancelClickListener(this.knB);
            this.knw.j(this.mPageContext);
            cMy();
            this.knw.b(this.knA);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.kny = str2;
        if (this.knw == null) {
            aM(str3, z);
        } else {
            this.knw.b(this.knx);
            if (StringUtils.isNull(this.kny)) {
                this.knw.j(this.mPageContext);
            }
        }
        this.knw.setReplyId(str);
        this.knw.zP(str2);
        this.knw.zQ(this.knz);
        if (this.knw.bjA()) {
            this.knw.a((PostWriteCallBackData) null);
        }
    }

    private void cMy() {
        if (this.bjP != null && this.knw != null && this.knw.biJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bjP.addView(this.knw.biJ(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.knw != null) {
            this.knw.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.knw != null) {
            this.knw.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.knw != null && this.knw.biJ() != null) {
            this.knw.biJ().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.knA = dVar;
        if (this.knw != null) {
            this.knw.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cMz() {
        return this.knw;
    }

    public void Ky(String str) {
        this.knz = str;
    }

    public void S(View.OnClickListener onClickListener) {
        this.knB = onClickListener;
    }
}
