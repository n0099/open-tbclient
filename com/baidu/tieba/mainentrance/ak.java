package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import java.util.List;
/* loaded from: classes.dex */
class ak extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bCE = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ResponseSearchFriendMessage responseSearchFriendMessage;
        HttpMessage httpMessage;
        com.baidu.tbadk.core.view.x xVar;
        boolean z;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.bCE.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.bCE.anT;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.bCE.anT = true;
                                this.bCE.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.bCE.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bCE.getPageContext().getPageActivity(), String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.bCE.showToast(com.baidu.tieba.t.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.bCE.showToast(com.baidu.tieba.t.neterror);
                } else {
                    this.bCE.showToast(httpResponsedMessage.getErrorString());
                    this.bCE.Yy();
                    xVar = this.bCE.mNoDataView;
                    xVar.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_suggest));
                }
            }
        }
    }
}
