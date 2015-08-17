package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import java.util.List;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bQZ = squareSearchActivity;
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
            searchPageFocusBar = this.bQZ.bQE;
            if (searchPageFocusBar != null) {
                searchPageFocusBar2 = this.bQZ.bQG;
                if (searchPageFocusBar2 != null) {
                    if (this.bQZ.mMode == 0) {
                        bdListView = this.bQZ.bQl;
                        if (bdListView.getVisibility() == 8) {
                            searchPageFocusBar7 = this.bQZ.bQE;
                            searchPageFocusBar7.setVisibility(0);
                            searchPageFocusBar5 = this.bQZ.bQE;
                            searchPageFocusBar5.b(likeForumData, this.bQZ.getPageContext());
                            searchPageFocusBar6 = this.bQZ.bQG;
                            searchPageFocusBar6.b(likeForumData, this.bQZ.getPageContext());
                        }
                    }
                    searchPageFocusBar3 = this.bQZ.bQE;
                    searchPageFocusBar3.setVisibility(8);
                    searchPageFocusBar4 = this.bQZ.bQG;
                    searchPageFocusBar4.setVisibility(8);
                    searchPageFocusBar5 = this.bQZ.bQE;
                    searchPageFocusBar5.b(likeForumData, this.bQZ.getPageContext());
                    searchPageFocusBar6 = this.bQZ.bQG;
                    searchPageFocusBar6.b(likeForumData, this.bQZ.getPageContext());
                }
            }
        }
    }
}
