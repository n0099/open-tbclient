package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import java.util.List;
/* loaded from: classes.dex */
class ah extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.brF = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ResponseSearchFriendMessage responseSearchFriendMessage;
        HttpMessage httpMessage;
        FrameLayout frameLayout;
        com.baidu.tbadk.core.view.x xVar;
        com.baidu.tbadk.core.view.x xVar2;
        boolean z;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.brF.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.brF.adU;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.brF.adU = true;
                                this.brF.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.brF.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.brF.getPageContext().getPageActivity(), String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.brF.showToast(com.baidu.tieba.z.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.brF.showToast(com.baidu.tieba.z.neterror);
                } else {
                    this.brF.showToast(httpResponsedMessage.getErrorString());
                    frameLayout = this.brF.bre;
                    frameLayout.setVisibility(8);
                    xVar = this.brF.mNoDataView;
                    xVar.setVisibility(0);
                    xVar2 = this.brF.mNoDataView;
                    xVar2.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.text_no_suggest));
                }
            }
        }
    }
}
