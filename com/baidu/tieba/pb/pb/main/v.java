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
/* loaded from: classes21.dex */
public class v {
    private RelativeLayout bsG;
    private com.baidu.tieba.pb.data.f kJe;
    private com.baidu.tbadk.editortools.pb.h kLu;
    private PbFakeFloorModel kLv;
    private String kLw;
    private String kLx;
    private NewWriteModel.d kLy;
    private View.OnClickListener kLz;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bsG = relativeLayout;
        this.kLv = pbFakeFloorModel;
    }

    public void daN() {
        if (this.kLu != null) {
            this.kLu.btD();
            if (StringUtils.isNull(this.kLw)) {
                this.kLu.onDestory();
            }
            this.kLu.bsv().bsI();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kJe = fVar;
    }

    public void daO() {
        if (this.kLu != null && this.kLu.bsv() != null) {
            this.kLu.bsv().bqS();
        }
    }

    public boolean daP() {
        if (this.kLu == null || this.kLu.bsv() == null) {
            return false;
        }
        return this.kLu.bsv().bsz();
    }

    private void aQ(String str, boolean z) {
        if (this.bsG != null && this.kLu == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.kLu = (com.baidu.tbadk.editortools.pb.h) iVar.eb(this.mPageContext.getPageActivity());
            this.kLu.a(this.mPageContext);
            this.kLu.b(this.kLv);
            this.kLu.setFrom(1);
            if (this.kJe != null) {
                this.kLu.setThreadData(this.kJe.cYR());
            }
            this.kLu.bsv().jh(true);
            this.kLu.bsv().setOnCancelClickListener(this.kLz);
            this.kLu.j(this.mPageContext);
            daQ();
            this.kLu.b(this.kLy);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.kLw = str2;
        if (this.kLu == null) {
            aQ(str3, z);
        } else {
            this.kLu.b(this.kLv);
            if (StringUtils.isNull(this.kLw)) {
                this.kLu.j(this.mPageContext);
            }
        }
        this.kLu.setReplyId(str);
        this.kLu.CC(str2);
        this.kLu.CD(this.kLx);
        if (this.kLu.btr()) {
            this.kLu.a((PostWriteCallBackData) null);
        }
    }

    private void daQ() {
        if (this.bsG != null && this.kLu != null && this.kLu.bsv() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bsG.addView(this.kLu.bsv(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.kLu != null) {
            this.kLu.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.kLu != null) {
            this.kLu.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kLu != null && this.kLu.bsv() != null) {
            this.kLu.bsv().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.kLy = dVar;
        if (this.kLu != null) {
            this.kLu.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h daR() {
        return this.kLu;
    }

    public void NT(String str) {
        this.kLx = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.kLz = onClickListener;
    }
}
