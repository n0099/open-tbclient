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
    private RelativeLayout dmk;
    private PbFakeFloorModel fLA;
    private String fLB;
    private NewWriteModel.d fLC;
    private com.baidu.tbadk.editortools.pb.h fLz;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dmk = relativeLayout;
        this.fLA = pbFakeFloorModel;
    }

    public void bbq() {
        if (this.fLz != null) {
            this.fLz.Lp();
            if (StringUtils.isNull(this.fLB)) {
                this.fLz.onDestory();
            }
            this.fLz.Ku().KE();
        }
    }

    public void bbr() {
        if (this.fLz != null && this.fLz.Ku() != null) {
            this.fLz.Ku().IE();
        }
    }

    public boolean bbs() {
        if (this.fLz == null || this.fLz.Ku() == null) {
            return false;
        }
        return this.fLz.Ku().Kx();
    }

    private void bbt() {
        if (this.dmk != null && this.fLz == null) {
            this.fLz = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bh(this.mPageContext.getPageActivity());
            this.fLz.a(this.mPageContext);
            this.fLz.b(this.fLA);
            this.fLz.Ku().ca(true);
            this.fLz.e(this.mPageContext);
            bbv();
            this.fLz.b(this.fLC);
        }
    }

    public void bG(String str, String str2) {
        this.fLB = str2;
        if (this.fLz == null) {
            bbt();
        } else {
            this.fLz.b(this.fLA);
            if (StringUtils.isNull(this.fLB)) {
                this.fLz.e(this.mPageContext);
            }
        }
        this.fLz.setReplyId(str);
        this.fLz.go(str2);
        if (this.fLz.Lg()) {
            this.fLz.a((PostWriteCallBackData) null);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bbu() {
        return this.fLz;
    }

    private void bbv() {
        if (this.dmk != null && this.fLz != null && this.fLz.Ku() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dmk.addView(this.fLz.Ku(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fLz != null) {
            this.fLz.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fLz != null) {
            this.fLz.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fLz != null && this.fLz.Ku() != null) {
            this.fLz.Ku().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fLC = dVar;
        if (this.fLz != null) {
            this.fLz.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.h bbw() {
        return this.fLz;
    }
}
