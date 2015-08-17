package com.baidu.tieba.mainentrance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<SquareSearchActivity> {
    private SquareSearchActivity bPM;
    private a bPN;
    private List<c> bPO;

    /* loaded from: classes.dex */
    public interface a {
        void aQ(List<c> list);

        void iA(String str);
    }

    public d(SquareSearchActivity squareSearchActivity, a aVar) {
        super(squareSearchActivity.getPageContext());
        this.bPM = squareSearchActivity;
        this.bPN = aVar;
    }

    public void ZP() {
        sendMessage(new HotForumNetMessage());
    }

    public void ZQ() {
        registerListener(new e(this, CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116));
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
