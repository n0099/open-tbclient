package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class s {
    private RelativeLayout euU;
    private com.baidu.tbadk.editortools.pb.g hOP;
    private PbFakeFloorModel hOQ;
    private String hOR;
    private NewWriteModel.d hOS;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.euU = relativeLayout;
        this.hOQ = pbFakeFloorModel;
    }

    public void bVi() {
        if (this.hOP != null) {
            this.hOP.asV();
            if (StringUtils.isNull(this.hOR)) {
                this.hOP.onDestory();
            }
            this.hOP.arY().asj();
        }
    }

    public void bVj() {
        if (this.hOP != null && this.hOP.arY() != null) {
            this.hOP.arY().aqu();
        }
    }

    public boolean bVk() {
        if (this.hOP == null || this.hOP.arY() == null) {
            return false;
        }
        return this.hOP.arY().asb();
    }

    private void BS(String str) {
        if (this.euU != null && this.hOP == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.qy(str);
            this.hOP = (com.baidu.tbadk.editortools.pb.g) hVar.cK(this.mPageContext.getPageActivity());
            this.hOP.a(this.mPageContext);
            this.hOP.b(this.hOQ);
            this.hOP.arY().fh(true);
            this.hOP.e(this.mPageContext);
            bVl();
            this.hOP.b(this.hOS);
        }
    }

    public void Y(String str, String str2, String str3) {
        this.hOR = str2;
        if (this.hOP == null) {
            BS(str3);
        } else {
            this.hOP.b(this.hOQ);
            if (StringUtils.isNull(this.hOR)) {
                this.hOP.e(this.mPageContext);
            }
        }
        this.hOP.setReplyId(str);
        this.hOP.qx(str2);
        if (this.hOP.asM()) {
            this.hOP.a((PostWriteCallBackData) null);
        }
    }

    private void bVl() {
        if (this.euU != null && this.hOP != null && this.hOP.arY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.euU.addView(this.hOP.arY(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hOP != null) {
            this.hOP.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hOP != null) {
            this.hOP.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hOP != null && this.hOP.arY() != null) {
            this.hOP.arY().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hOS = dVar;
        if (this.hOP != null) {
            this.hOP.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bVm() {
        return this.hOP;
    }
}
