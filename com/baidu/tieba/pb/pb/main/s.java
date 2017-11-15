package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes.dex */
public class s {
    private RelativeLayout cku;
    private com.baidu.tbadk.editortools.pb.f eOb;
    private PbFakeFloorModel eOc;
    private String eOd;
    private NewWriteModel.d eOe;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.cku = relativeLayout;
        this.eOc = pbFakeFloorModel;
    }

    public void aSz() {
        if (this.eOb != null) {
            this.eOb.DS();
            if (StringUtils.isNull(this.eOd)) {
                this.eOb.onDestory();
            }
        }
    }

    private void aSA() {
        if (this.cku != null && this.eOb == null) {
            this.eOb = (com.baidu.tbadk.editortools.pb.f) new com.baidu.tbadk.editortools.pb.g().aW(this.mPageContext.getPageActivity());
            this.eOb.a(this.mPageContext);
            this.eOb.b(this.eOc);
            this.eOb.CU().bx(true);
            this.eOb.e(this.mPageContext);
            aSB();
            this.eOb.b(this.eOe);
        }
    }

    public void bC(String str, String str2) {
        this.eOd = str2;
        if (this.eOb == null) {
            aSA();
        } else {
            this.eOb.b(this.eOc);
            if (StringUtils.isNull(this.eOd)) {
                this.eOb.e(this.mPageContext);
            }
        }
        this.eOb.setReplyId(str);
        this.eOb.ge(str2);
    }

    private void aSB() {
        if (this.cku != null && this.eOb != null && this.eOb.CU() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cku.addView(this.eOb.CU(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eOb != null) {
            this.eOb.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eOb != null) {
            this.eOb.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eOb != null && this.eOb.CU() != null) {
            this.eOb.CU().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eOe = dVar;
        if (this.eOb != null) {
            this.eOb.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.f aSC() {
        return this.eOb;
    }
}
