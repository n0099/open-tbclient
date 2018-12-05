package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class s {
    private RelativeLayout dor;
    private com.baidu.tbadk.editortools.pb.g fXm;
    private PbFakeFloorModel fXn;
    private String fXo;
    private NewWriteModel.d fXp;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dor = relativeLayout;
        this.fXn = pbFakeFloorModel;
    }

    public void biR() {
        if (this.fXm != null) {
            this.fXm.MT();
            if (StringUtils.isNull(this.fXo)) {
                this.fXm.onDestory();
            }
            this.fXm.LX().Mh();
        }
    }

    public void biS() {
        if (this.fXm != null && this.fXm.LX() != null) {
            this.fXm.LX().Kw();
        }
    }

    public boolean biT() {
        if (this.fXm == null || this.fXm.LX() == null) {
            return false;
        }
        return this.fXm.LX().Ma();
    }

    private void biU() {
        if (this.dor != null && this.fXm == null) {
            this.fXm = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.mPageContext.getPageActivity());
            this.fXm.setContext(this.mPageContext);
            this.fXm.b(this.fXn);
            this.fXm.LX().cq(true);
            this.fXm.d(this.mPageContext);
            biV();
            this.fXm.b(this.fXp);
        }
    }

    public void cn(String str, String str2) {
        this.fXo = str2;
        if (this.fXm == null) {
            biU();
        } else {
            this.fXm.b(this.fXn);
            if (StringUtils.isNull(this.fXo)) {
                this.fXm.d(this.mPageContext);
            }
        }
        this.fXm.setReplyId(str);
        this.fXm.hX(str2);
        if (this.fXm.MK()) {
            this.fXm.a((PostWriteCallBackData) null);
        }
    }

    private void biV() {
        if (this.dor != null && this.fXm != null && this.fXm.LX() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dor.addView(this.fXm.LX(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fXm != null) {
            this.fXm.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fXm != null) {
            this.fXm.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fXm != null && this.fXm.LX() != null) {
            this.fXm.LX().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fXp = dVar;
        if (this.fXm != null) {
            this.fXm.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g biW() {
        return this.fXm;
    }
}
