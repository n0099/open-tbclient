package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import java.util.List;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bWd = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.baidu.tieba.mainentrance.SquareSearchActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List<String> likeForumData;
        SearchPageFocusBar searchPageFocusBar;
        SearchPageFocusBar searchPageFocusBar2;
        SearchPageFocusBar searchPageFocusBar3;
        SearchPageFocusBar searchPageFocusBar4;
        SearchPageFocusBar searchPageFocusBar5;
        SearchPageFocusBar searchPageFocusBar6;
        BdListView bdListView;
        SearchPageFocusBar searchPageFocusBar7;
        if ((customResponsedMessage instanceof EnterForumInfoMessage) && (likeForumData = ((EnterForumInfoMessage) customResponsedMessage).getLikeForumData()) != null && likeForumData.size() > 0) {
            searchPageFocusBar = this.bWd.bVH;
            if (searchPageFocusBar != null) {
                searchPageFocusBar2 = this.bWd.bVJ;
                if (searchPageFocusBar2 != null) {
                    if (this.bWd.mMode == 0) {
                        bdListView = this.bWd.bVo;
                        if (bdListView.getVisibility() == 8) {
                            searchPageFocusBar7 = this.bWd.bVH;
                            searchPageFocusBar7.setVisibility(0);
                            searchPageFocusBar5 = this.bWd.bVH;
                            searchPageFocusBar5.b(likeForumData, this.bWd.getPageContext());
                            searchPageFocusBar6 = this.bWd.bVJ;
                            searchPageFocusBar6.b(likeForumData, this.bWd.getPageContext());
                        }
                    }
                    searchPageFocusBar3 = this.bWd.bVH;
                    searchPageFocusBar3.setVisibility(8);
                    searchPageFocusBar4 = this.bWd.bVJ;
                    searchPageFocusBar4.setVisibility(8);
                    searchPageFocusBar5 = this.bWd.bVH;
                    searchPageFocusBar5.b(likeForumData, this.bWd.getPageContext());
                    searchPageFocusBar6 = this.bWd.bVJ;
                    searchPageFocusBar6.b(likeForumData, this.bWd.getPageContext());
                }
            }
        }
    }
}
