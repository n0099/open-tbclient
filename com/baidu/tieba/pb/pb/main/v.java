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
    private com.baidu.tieba.pb.data.f kli;
    private String knA;
    private String knB;
    private NewWriteModel.d knC;
    private View.OnClickListener knD;
    private com.baidu.tbadk.editortools.pb.h kny;
    private PbFakeFloorModel knz;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bjP = relativeLayout;
        this.knz = pbFakeFloorModel;
    }

    public void cMv() {
        if (this.kny != null) {
            this.kny.bjM();
            if (StringUtils.isNull(this.knA)) {
                this.kny.onDestory();
            }
            this.kny.biJ().biU();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kli = fVar;
    }

    public void cMw() {
        if (this.kny != null && this.kny.biJ() != null) {
            this.kny.biJ().bhl();
        }
    }

    public boolean cMx() {
        if (this.kny == null || this.kny.biJ() == null) {
            return false;
        }
        return this.kny.biJ().biL();
    }

    private void aM(String str, boolean z) {
        if (this.bjP != null && this.kny == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.kny = (com.baidu.tbadk.editortools.pb.h) iVar.dT(this.mPageContext.getPageActivity());
            this.kny.a(this.mPageContext);
            this.kny.b(this.knz);
            if (this.kli != null) {
                this.kny.setThreadData(this.kli.cKx());
            }
            this.kny.biJ().iJ(true);
            this.kny.biJ().setOnCancelClickListener(this.knD);
            this.kny.j(this.mPageContext);
            cMy();
            this.kny.b(this.knC);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.knA = str2;
        if (this.kny == null) {
            aM(str3, z);
        } else {
            this.kny.b(this.knz);
            if (StringUtils.isNull(this.knA)) {
                this.kny.j(this.mPageContext);
            }
        }
        this.kny.setReplyId(str);
        this.kny.zP(str2);
        this.kny.zQ(this.knB);
        if (this.kny.bjA()) {
            this.kny.a((PostWriteCallBackData) null);
        }
    }

    private void cMy() {
        if (this.bjP != null && this.kny != null && this.kny.biJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bjP.addView(this.kny.biJ(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.kny != null) {
            this.kny.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.kny != null) {
            this.kny.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kny != null && this.kny.biJ() != null) {
            this.kny.biJ().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.knC = dVar;
        if (this.kny != null) {
            this.kny.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cMz() {
        return this.kny;
    }

    public void Ky(String str) {
        this.knB = str;
    }

    public void S(View.OnClickListener onClickListener) {
        this.knD = onClickListener;
    }
}
