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
    private RelativeLayout drh;
    private com.baidu.tbadk.editortools.pb.g gae;
    private PbFakeFloorModel gaf;
    private String gag;
    private NewWriteModel.d gah;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.drh = relativeLayout;
        this.gaf = pbFakeFloorModel;
    }

    public void bjC() {
        if (this.gae != null) {
            this.gae.MU();
            if (StringUtils.isNull(this.gag)) {
                this.gae.onDestory();
            }
            this.gae.LY().Mi();
        }
    }

    public void bjD() {
        if (this.gae != null && this.gae.LY() != null) {
            this.gae.LY().Kx();
        }
    }

    public boolean bjE() {
        if (this.gae == null || this.gae.LY() == null) {
            return false;
        }
        return this.gae.LY().Mb();
    }

    private void bjF() {
        if (this.drh != null && this.gae == null) {
            this.gae = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.mPageContext.getPageActivity());
            this.gae.setContext(this.mPageContext);
            this.gae.b(this.gaf);
            this.gae.LY().cq(true);
            this.gae.d(this.mPageContext);
            bjG();
            this.gae.b(this.gah);
        }
    }

    public void cn(String str, String str2) {
        this.gag = str2;
        if (this.gae == null) {
            bjF();
        } else {
            this.gae.b(this.gaf);
            if (StringUtils.isNull(this.gag)) {
                this.gae.d(this.mPageContext);
            }
        }
        this.gae.setReplyId(str);
        this.gae.hY(str2);
        if (this.gae.ML()) {
            this.gae.a((PostWriteCallBackData) null);
        }
    }

    private void bjG() {
        if (this.drh != null && this.gae != null && this.gae.LY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.drh.addView(this.gae.LY(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gae != null) {
            this.gae.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.gae != null) {
            this.gae.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gae != null && this.gae.LY() != null) {
            this.gae.LY().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.gah = dVar;
        if (this.gae != null) {
            this.gae.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bjH() {
        return this.gae;
    }
}
