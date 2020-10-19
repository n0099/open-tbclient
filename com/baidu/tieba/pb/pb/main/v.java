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
/* loaded from: classes22.dex */
public class v {
    private RelativeLayout bwu;
    private com.baidu.tieba.pb.data.f kYp;
    private com.baidu.tbadk.editortools.pb.h laG;
    private PbFakeFloorModel laH;
    private String laI;
    private String laJ;
    private NewWriteModel.d laK;
    private View.OnClickListener laL;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bwu = relativeLayout;
        this.laH = pbFakeFloorModel;
    }

    public void dew() {
        if (this.laG != null) {
            this.laG.bwn();
            if (StringUtils.isNull(this.laI)) {
                this.laG.onDestory();
            }
            this.laG.bvf().bvs();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kYp = fVar;
    }

    public void dex() {
        if (this.laG != null && this.laG.bvf() != null) {
            this.laG.bvf().btC();
        }
    }

    public boolean dey() {
        if (this.laG == null || this.laG.bvf() == null) {
            return false;
        }
        return this.laG.bvf().bvj();
    }

    private void aU(String str, boolean z) {
        if (this.bwu != null && this.laG == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.laG = (com.baidu.tbadk.editortools.pb.h) iVar.ei(this.mPageContext.getPageActivity());
            this.laG.a(this.mPageContext);
            this.laG.b(this.laH);
            this.laG.setFrom(1);
            if (this.kYp != null) {
                this.laG.setThreadData(this.kYp.dcA());
            }
            this.laG.bvf().jF(true);
            this.laG.bvf().setOnCancelClickListener(this.laL);
            this.laG.j(this.mPageContext);
            dez();
            this.laG.b(this.laK);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.laI = str2;
        if (this.laG == null) {
            aU(str3, z);
        } else {
            this.laG.b(this.laH);
            if (StringUtils.isNull(this.laI)) {
                this.laG.j(this.mPageContext);
            }
        }
        this.laG.setReplyId(str);
        this.laG.Do(str2);
        this.laG.Dp(this.laJ);
        if (this.laG.bwb()) {
            this.laG.a((PostWriteCallBackData) null);
        }
    }

    private void dez() {
        if (this.bwu != null && this.laG != null && this.laG.bvf() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bwu.addView(this.laG.bvf(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.laG != null) {
            this.laG.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.laG != null) {
            this.laG.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.laG != null && this.laG.bvf() != null) {
            this.laG.bvf().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.laK = dVar;
        if (this.laG != null) {
            this.laG.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h deA() {
        return this.laG;
    }

    public void OI(String str) {
        this.laJ = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.laL = onClickListener;
    }
}
