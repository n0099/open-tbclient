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
    private RelativeLayout aqa;
    private com.baidu.tbadk.editortools.pb.g hPv;
    private PbFakeFloorModel hPw;
    private String hPx;
    private NewWriteModel.d hPy;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.aqa = relativeLayout;
        this.hPw = pbFakeFloorModel;
    }

    public void bTl() {
        if (this.hPv != null) {
            this.hPv.auT();
            if (StringUtils.isNull(this.hPx)) {
                this.hPv.onDestory();
            }
            this.hPv.atX().auh();
        }
    }

    public void bTm() {
        if (this.hPv != null && this.hPv.atX() != null) {
            this.hPv.atX().asA();
        }
    }

    public boolean bTn() {
        if (this.hPv == null || this.hPv.atX() == null) {
            return false;
        }
        return this.hPv.atX().atZ();
    }

    private void AL(String str) {
        if (this.aqa != null && this.hPv == null) {
            com.baidu.tbadk.editortools.pb.h hVar = new com.baidu.tbadk.editortools.pb.h();
            hVar.setHintText(str);
            this.hPv = (com.baidu.tbadk.editortools.pb.g) hVar.cw(this.mPageContext.getPageActivity());
            this.hPv.a(this.mPageContext);
            this.hPv.b(this.hPw);
            this.hPv.atX().fe(true);
            this.hPv.e(this.mPageContext);
            bTo();
            this.hPv.b(this.hPy);
        }
    }

    public void ab(String str, String str2, String str3) {
        this.hPx = str2;
        if (this.hPv == null) {
            AL(str3);
        } else {
            this.hPv.b(this.hPw);
            if (StringUtils.isNull(this.hPx)) {
                this.hPv.e(this.mPageContext);
            }
        }
        this.hPv.setReplyId(str);
        this.hPv.pR(str2);
        if (this.hPv.auK()) {
            this.hPv.a((PostWriteCallBackData) null);
        }
    }

    private void bTo() {
        if (this.aqa != null && this.hPv != null && this.hPv.atX() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aqa.addView(this.hPv.atX(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hPv != null) {
            this.hPv.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.hPv != null) {
            this.hPv.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hPv != null && this.hPv.atX() != null) {
            this.hPv.atX().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.hPy = dVar;
        if (this.hPv != null) {
            this.hPv.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bTp() {
        return this.hPv;
    }
}
