package com.baidu.tieba.mainentrance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<SquareSearchActivity> {
    private SquareSearchActivity bUg;
    private a bUh;
    private List<c> bUi;
    private f mHotSearchInfo;
    private List<g> mTopicInfoList;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<c> list, List<g> list2, f fVar);

        void iU(String str);
    }

    public d(SquareSearchActivity squareSearchActivity, a aVar) {
        super(squareSearchActivity.getPageContext());
        this.bUg = squareSearchActivity;
        this.bUh = aVar;
    }

    public void aaY() {
        sendMessage(new HotForumNetMessage());
    }

    public void aaZ() {
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
