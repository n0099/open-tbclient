package com.baidu.tieba.mainentrance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<SquareSearchActivity> {
    private SquareSearchActivity byL;
    private List<e> byM;
    private h byQ;

    public f(SquareSearchActivity squareSearchActivity, h hVar) {
        super(squareSearchActivity.getPageContext());
        this.byL = squareSearchActivity;
        this.byQ = hVar;
    }

    public void WO() {
        sendMessage(new HotForumNetMessage());
    }

    public void WP() {
        registerListener(new g(this, CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116));
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
