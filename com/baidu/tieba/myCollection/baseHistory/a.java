package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<b, BaseActivity> {
    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<b> Du() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dv() {
        return CmdConfigCustom.CMD_READ_PB_HISTORY_LIST;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dw() {
        return CmdConfigCustom.CMD_WRITE_PB_HISTORY;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dg() {
        return "tb.pb_history";
    }
}
