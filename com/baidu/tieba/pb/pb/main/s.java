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
    private RelativeLayout ckd;
    private com.baidu.tbadk.editortools.pb.f eNH;
    private PbFakeFloorModel eNI;
    private String eNJ;
    private NewWriteModel.d eNK;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.ckd = relativeLayout;
        this.eNI = pbFakeFloorModel;
    }

    public void aSr() {
        if (this.eNH != null) {
            this.eNH.DG();
            if (StringUtils.isNull(this.eNJ)) {
                this.eNH.onDestory();
            }
        }
    }

    private void aSs() {
        if (this.ckd != null && this.eNH == null) {
            this.eNH = (com.baidu.tbadk.editortools.pb.f) new com.baidu.tbadk.editortools.pb.g().aW(this.mPageContext.getPageActivity());
            this.eNH.a(this.mPageContext);
            this.eNH.b(this.eNI);
            this.eNH.CI().bw(true);
            this.eNH.e(this.mPageContext);
            aSt();
            this.eNH.b(this.eNK);
        }
    }

    public void bB(String str, String str2) {
        this.eNJ = str2;
        if (this.eNH == null) {
            aSs();
        } else {
            this.eNH.b(this.eNI);
            if (StringUtils.isNull(this.eNJ)) {
                this.eNH.e(this.mPageContext);
            }
        }
        this.eNH.setReplyId(str);
        this.eNH.gd(str2);
    }

    private void aSt() {
        if (this.ckd != null && this.eNH != null && this.eNH.CI() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ckd.addView(this.eNH.CI(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eNH != null) {
            this.eNH.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eNH != null) {
            this.eNH.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eNH != null && this.eNH.CI() != null) {
            this.eNH.CI().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eNK = dVar;
        if (this.eNH != null) {
            this.eNH.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.f aSu() {
        return this.eNH;
    }
}
