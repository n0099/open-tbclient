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
public class s {
    private RelativeLayout dmF;
    private com.baidu.tbadk.editortools.pb.h fLU;
    private PbFakeFloorModel fLV;
    private String fLW;
    private NewWriteModel.d fLX;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dmF = relativeLayout;
        this.fLV = pbFakeFloorModel;
    }

    public void bbv() {
        if (this.fLU != null) {
            this.fLU.Lr();
            if (StringUtils.isNull(this.fLW)) {
                this.fLU.onDestory();
            }
            this.fLU.Kw().KG();
        }
    }

    public void bbw() {
        if (this.fLU != null && this.fLU.Kw() != null) {
            this.fLU.Kw().IG();
        }
    }

    public boolean bbx() {
        if (this.fLU == null || this.fLU.Kw() == null) {
            return false;
        }
        return this.fLU.Kw().Kz();
    }

    private void bby() {
        if (this.dmF != null && this.fLU == null) {
            this.fLU = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().be(this.mPageContext.getPageActivity());
            this.fLU.a(this.mPageContext);
            this.fLU.b(this.fLV);
            this.fLU.Kw().cb(true);
            this.fLU.e(this.mPageContext);
            bbA();
            this.fLU.b(this.fLX);
        }
    }

    public void bF(String str, String str2) {
        this.fLW = str2;
        if (this.fLU == null) {
            bby();
        } else {
            this.fLU.b(this.fLV);
            if (StringUtils.isNull(this.fLW)) {
                this.fLU.e(this.mPageContext);
            }
        }
        this.fLU.setReplyId(str);
        this.fLU.gx(str2);
        if (this.fLU.Li()) {
            this.fLU.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bbz() {
        return this.fLU;
    }

    private void bbA() {
        if (this.dmF != null && this.fLU != null && this.fLU.Kw() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dmF.addView(this.fLU.Kw(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fLU != null) {
            this.fLU.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fLU != null) {
            this.fLU.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fLU != null && this.fLU.Kw() != null) {
            this.fLU.Kw().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fLX = dVar;
        if (this.fLU != null) {
            this.fLU.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bbB() {
        return this.fLU;
    }
}
