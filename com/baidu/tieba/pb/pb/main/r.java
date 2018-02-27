package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class r {
    private RelativeLayout dpk;
    private com.baidu.tbadk.editortools.pb.h fOS;
    private PbFakeFloorModel fOT;
    private String fOU;
    private NewWriteModel.d fOV;
    private TbPageContext mPageContext;

    public r(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dpk = relativeLayout;
        this.fOT = pbFakeFloorModel;
    }

    public void bcW() {
        if (this.fOS != null) {
            this.fOS.LW();
            if (StringUtils.isNull(this.fOU)) {
                this.fOS.onDestory();
            }
            this.fOS.Lb().Ll();
        }
    }

    public void bcX() {
        if (this.fOS != null && this.fOS.Lb() != null) {
            this.fOS.Lb().Jl();
        }
    }

    public boolean bcY() {
        if (this.fOS == null || this.fOS.Lb() == null) {
            return false;
        }
        return this.fOS.Lb().Le();
    }

    private void bcZ() {
        if (this.dpk != null && this.fOS == null) {
            this.fOS = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bd(this.mPageContext.getPageActivity());
            this.fOS.setContext(this.mPageContext);
            this.fOS.b(this.fOT);
            this.fOS.Lb().cf(true);
            this.fOS.d(this.mPageContext);
            bdb();
            this.fOS.b(this.fOV);
        }
    }

    public void bG(String str, String str2) {
        this.fOU = str2;
        if (this.fOS == null) {
            bcZ();
        } else {
            this.fOS.b(this.fOT);
            if (StringUtils.isNull(this.fOU)) {
                this.fOS.d(this.mPageContext);
            }
        }
        this.fOS.setReplyId(str);
        this.fOS.gG(str2);
        if (this.fOS.LN()) {
            this.fOS.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bda() {
        return this.fOS;
    }

    private void bdb() {
        if (this.dpk != null && this.fOS != null && this.fOS.Lb() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dpk.addView(this.fOS.Lb(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fOS != null) {
            this.fOS.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fOS != null) {
            this.fOS.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fOS != null && this.fOS.Lb() != null) {
            this.fOS.Lb().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fOV = dVar;
        if (this.fOS != null) {
            this.fOS.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bdc() {
        return this.fOS;
    }
}
