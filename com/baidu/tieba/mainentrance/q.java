package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import java.util.List;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bVr = squareSearchActivity;
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
            searchPageFocusBar = this.bVr.bUV;
            if (searchPageFocusBar != null) {
                searchPageFocusBar2 = this.bVr.bUX;
                if (searchPageFocusBar2 != null) {
                    if (this.bVr.mMode == 0) {
                        bdListView = this.bVr.bUC;
                        if (bdListView.getVisibility() == 8) {
                            searchPageFocusBar7 = this.bVr.bUV;
                            searchPageFocusBar7.setVisibility(0);
                            searchPageFocusBar5 = this.bVr.bUV;
                            searchPageFocusBar5.b(likeForumData, this.bVr.getPageContext());
                            searchPageFocusBar6 = this.bVr.bUX;
                            searchPageFocusBar6.b(likeForumData, this.bVr.getPageContext());
                        }
                    }
                    searchPageFocusBar3 = this.bVr.bUV;
                    searchPageFocusBar3.setVisibility(8);
                    searchPageFocusBar4 = this.bVr.bUX;
                    searchPageFocusBar4.setVisibility(8);
                    searchPageFocusBar5 = this.bVr.bUV;
                    searchPageFocusBar5.b(likeForumData, this.bVr.getPageContext());
                    searchPageFocusBar6 = this.bVr.bUX;
                    searchPageFocusBar6.b(likeForumData, this.bVr.getPageContext());
                }
            }
        }
    }
}
