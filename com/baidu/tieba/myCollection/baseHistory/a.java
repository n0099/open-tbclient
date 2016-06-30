package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<b, TbPageContext> {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<b> DD() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DE() {
        return CmdConfigCustom.CMD_READ_PB_HISTORY_LIST;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DF() {
        return CmdConfigCustom.CMD_WRITE_PB_HISTORY;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dp() {
        return "tb.pb_history";
    }
}
