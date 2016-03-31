package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import java.util.List;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.cLU = squareSearchActivity;
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
            searchPageFocusBar = this.cLU.cLy;
            if (searchPageFocusBar != null) {
                searchPageFocusBar2 = this.cLU.cLA;
                if (searchPageFocusBar2 != null) {
                    if (this.cLU.mMode == 0) {
                        bdListView = this.cLU.cLe;
                        if (bdListView.getVisibility() == 8) {
                            searchPageFocusBar7 = this.cLU.cLy;
                            searchPageFocusBar7.setVisibility(0);
                            searchPageFocusBar5 = this.cLU.cLy;
                            searchPageFocusBar5.c(likeForumData, this.cLU.getPageContext());
                            searchPageFocusBar6 = this.cLU.cLA;
                            searchPageFocusBar6.c(likeForumData, this.cLU.getPageContext());
                        }
                    }
                    searchPageFocusBar3 = this.cLU.cLy;
                    searchPageFocusBar3.setVisibility(8);
                    searchPageFocusBar4 = this.cLU.cLA;
                    searchPageFocusBar4.setVisibility(8);
                    searchPageFocusBar5 = this.cLU.cLy;
                    searchPageFocusBar5.c(likeForumData, this.cLU.getPageContext());
                    searchPageFocusBar6 = this.cLU.cLA;
                    searchPageFocusBar6.c(likeForumData, this.cLU.getPageContext());
                }
            }
        }
    }
}
