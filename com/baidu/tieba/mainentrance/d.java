package com.baidu.tieba.mainentrance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<SquareSearchActivity> {
    private SquareSearchActivity ckU;
    private a ckV;
    private List<c> ckW;
    private f mHotSearchInfo;
    private List<g> mTopicInfoList;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<c> list, List<g> list2, f fVar);

        void jr(String str);
    }

    public d(SquareSearchActivity squareSearchActivity, a aVar) {
        super(squareSearchActivity.getPageContext());
        this.ckU = squareSearchActivity;
        this.ckV = aVar;
    }

    public void aeZ() {
        sendMessage(new HotForumNetMessage());
    }

    public void afa() {
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
