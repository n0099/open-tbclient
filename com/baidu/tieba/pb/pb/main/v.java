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
    private RelativeLayout bpx;
    private com.baidu.tieba.pb.data.f kAH;
    private com.baidu.tbadk.editortools.pb.h kCW;
    private PbFakeFloorModel kCX;
    private String kCY;
    private String kCZ;
    private NewWriteModel.d kDa;
    private View.OnClickListener kDb;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.bpx = relativeLayout;
        this.kCX = pbFakeFloorModel;
    }

    public void cXk() {
        if (this.kCW != null) {
            this.kCW.bsz();
            if (StringUtils.isNull(this.kCY)) {
                this.kCW.onDestory();
            }
            this.kCW.brw().brH();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kAH = fVar;
    }

    public void cXl() {
        if (this.kCW != null && this.kCW.brw() != null) {
            this.kCW.brw().bpY();
        }
    }

    public boolean cXm() {
        if (this.kCW == null || this.kCW.brw() == null) {
            return false;
        }
        return this.kCW.brw().bry();
    }

    private void aQ(String str, boolean z) {
        if (this.bpx != null && this.kCW == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.kCW = (com.baidu.tbadk.editortools.pb.h) iVar.ec(this.mPageContext.getPageActivity());
            this.kCW.a(this.mPageContext);
            this.kCW.b(this.kCX);
            if (this.kAH != null) {
                this.kCW.setThreadData(this.kAH.cVm());
            }
            this.kCW.brw().jj(true);
            this.kCW.brw().setOnCancelClickListener(this.kDb);
            this.kCW.j(this.mPageContext);
            cXn();
            this.kCW.b(this.kDa);
        }
    }

    public void g(String str, String str2, String str3, boolean z) {
        this.kCY = str2;
        if (this.kCW == null) {
            aQ(str3, z);
        } else {
            this.kCW.b(this.kCX);
            if (StringUtils.isNull(this.kCY)) {
                this.kCW.j(this.mPageContext);
            }
        }
        this.kCW.setReplyId(str);
        this.kCW.Cg(str2);
        this.kCW.Ch(this.kCZ);
        if (this.kCW.bsn()) {
            this.kCW.a((PostWriteCallBackData) null);
        }
    }

    private void cXn() {
        if (this.bpx != null && this.kCW != null && this.kCW.brw() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bpx.addView(this.kCW.brw(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.kCW != null) {
            this.kCW.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.kCW != null) {
            this.kCW.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kCW != null && this.kCW.brw() != null) {
            this.kCW.brw().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.kDa = dVar;
        if (this.kCW != null) {
            this.kCW.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h cXo() {
        return this.kCW;
    }

    public void Ns(String str) {
        this.kCZ = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.kDb = onClickListener;
    }
}
