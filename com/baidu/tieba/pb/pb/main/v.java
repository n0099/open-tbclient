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
    private RelativeLayout byI;
    private com.baidu.tieba.pb.data.f lkO;
    private com.baidu.tbadk.editortools.pb.h lne;
    private PbFakeFloorModel lnf;
    private String lnh;
    private String lni;
    private NewWriteModel.d lnj;
    private View.OnClickListener lnk;
    private TbPageContext mPageContext;

    public v(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.byI = relativeLayout;
        this.lnf = pbFakeFloorModel;
    }

    public void dhD() {
        if (this.lne != null) {
            this.lne.byg();
            if (StringUtils.isNull(this.lnh)) {
                this.lne.onDestory();
            }
            this.lne.bwY().bxl();
        }
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lkO = fVar;
    }

    public void dhE() {
        if (this.lne != null && this.lne.bwY() != null) {
            this.lne.bwY().bvv();
        }
    }

    public boolean dhF() {
        if (this.lne == null || this.lne.bwY() == null) {
            return false;
        }
        return this.lne.bwY().bxc();
    }

    private void aW(String str, boolean z) {
        if (this.byI != null && this.lne == null) {
            com.baidu.tbadk.editortools.pb.i iVar = new com.baidu.tbadk.editortools.pb.i(z);
            iVar.setHintText(str);
            this.lne = (com.baidu.tbadk.editortools.pb.h) iVar.ei(this.mPageContext.getPageActivity());
            this.lne.a(this.mPageContext);
            this.lne.b(this.lnf);
            this.lne.setFrom(1);
            if (this.lkO != null) {
                this.lne.setThreadData(this.lkO.dfI());
            }
            this.lne.bwY().jS(true);
            this.lne.bwY().setOnCancelClickListener(this.lnk);
            this.lne.j(this.mPageContext);
            dhG();
            this.lne.b(this.lnj);
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.lnh = str2;
        if (this.lne == null) {
            aW(str3, z);
        } else {
            this.lne.b(this.lnf);
            if (StringUtils.isNull(this.lnh)) {
                this.lne.j(this.mPageContext);
            }
        }
        this.lne.setReplyId(str);
        this.lne.DH(str2);
        this.lne.DI(this.lni);
        if (this.lne.bxU()) {
            this.lne.a((PostWriteCallBackData) null);
        }
    }

    private void dhG() {
        if (this.byI != null && this.lne != null && this.lne.bwY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.byI.addView(this.lne.bwY(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.lne != null) {
            this.lne.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.lne != null) {
            this.lne.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lne != null && this.lne.bwY() != null) {
            this.lne.bwY().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.lnj = dVar;
        if (this.lne != null) {
            this.lne.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h dhH() {
        return this.lne;
    }

    public void Pg(String str) {
        this.lni = str;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lnk = onClickListener;
    }
}
