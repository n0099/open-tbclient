package com.baidu.tieba.mainentrance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<SquareSearchActivity> {
    private List<c> cLA;
    private SquareSearchActivity cLy;
    private a cLz;
    private f mHotSearchInfo;
    private List<g> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<c> list, List<g> list2, f fVar, String str);

        void kB(String str);
    }

    public d(SquareSearchActivity squareSearchActivity, a aVar) {
        super(squareSearchActivity.getPageContext());
        this.cLy = squareSearchActivity;
        this.cLz = aVar;
    }

    public void aoA() {
        sendMessage(new HotForumNetMessage());
    }

    public void aoB() {
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
