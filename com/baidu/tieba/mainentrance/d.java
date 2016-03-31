package com.baidu.tieba.mainentrance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<SquareSearchActivity> {
    private SquareSearchActivity cKC;
    private a cKD;
    private List<c> cKE;
    private f mHotSearchInfo;
    private List<g> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<c> list, List<g> list2, f fVar, String str);

        void kx(String str);
    }

    public d(SquareSearchActivity squareSearchActivity, a aVar) {
        super(squareSearchActivity.getPageContext());
        this.cKC = squareSearchActivity;
        this.cKD = aVar;
    }

    public void aot() {
        sendMessage(new HotForumNetMessage());
    }

    public void aou() {
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
