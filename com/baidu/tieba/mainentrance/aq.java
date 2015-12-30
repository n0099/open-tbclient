package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
class aq extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.cqu = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ResponseSearchFriendMessage responseSearchFriendMessage;
        HttpMessage httpMessage;
        boolean z;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.cqu.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.cqu.axN;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.cqu.axN = true;
                                this.cqu.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.cqu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cqu.getPageContext().getPageActivity(), String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.cqu.showToast(n.j.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.cqu.showToast(n.j.neterror);
                } else {
                    this.cqu.showToast(httpResponsedMessage.getErrorString());
                    this.cqu.agE();
                    this.cqu.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_suggest));
                }
            }
        }
    }
}
