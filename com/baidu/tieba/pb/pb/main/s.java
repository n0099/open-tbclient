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
    private RelativeLayout dhJ;
    private com.baidu.tbadk.editortools.pb.g fQw;
    private PbFakeFloorModel fQx;
    private String fQy;
    private NewWriteModel.d fQz;
    private TbPageContext mPageContext;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mPageContext = tbPageContext;
        this.dhJ = relativeLayout;
        this.fQx = pbFakeFloorModel;
    }

    public void bgZ() {
        if (this.fQw != null) {
            this.fQw.LP();
            if (StringUtils.isNull(this.fQy)) {
                this.fQw.onDestory();
            }
            this.fQw.KT().Ld();
        }
    }

    public void bha() {
        if (this.fQw != null && this.fQw.KT() != null) {
            this.fQw.KT().Js();
        }
    }

    public boolean bhb() {
        if (this.fQw == null || this.fQw.KT() == null) {
            return false;
        }
        return this.fQw.KT().KW();
    }

    private void bhc() {
        if (this.dhJ != null && this.fQw == null) {
            this.fQw = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bJ(this.mPageContext.getPageActivity());
            this.fQw.setContext(this.mPageContext);
            this.fQw.b(this.fQx);
            this.fQw.KT().cp(true);
            this.fQw.d(this.mPageContext);
            bhd();
            this.fQw.b(this.fQz);
        }
    }

    public void ci(String str, String str2) {
        this.fQy = str2;
        if (this.fQw == null) {
            bhc();
        } else {
            this.fQw.b(this.fQx);
            if (StringUtils.isNull(this.fQy)) {
                this.fQw.d(this.mPageContext);
            }
        }
        this.fQw.setReplyId(str);
        this.fQw.hG(str2);
        if (this.fQw.LG()) {
            this.fQw.a((PostWriteCallBackData) null);
        }
    }

    private void bhd() {
        if (this.dhJ != null && this.fQw != null && this.fQw.KT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dhJ.addView(this.fQw.KT(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fQw != null) {
            this.fQw.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.fQw != null) {
            this.fQw.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fQw != null && this.fQw.KT() != null) {
            this.fQw.KT().onChangeSkinType(i);
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fQz = dVar;
        if (this.fQw != null) {
            this.fQw.b(dVar);
        }
    }

    public com.baidu.tbadk.editortools.pb.g bhe() {
        return this.fQw;
    }
}
