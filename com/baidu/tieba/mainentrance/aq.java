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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class aq extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.cwZ = squareSearchActivity;
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
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.cwZ.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.cwZ.ayG;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.cwZ.ayG = true;
                                this.cwZ.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.cwZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cwZ.getPageContext().getPageActivity(), String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.cwZ.showToast(t.j.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.cwZ.showToast(t.j.neterror);
                } else {
                    this.cwZ.showToast(httpResponsedMessage.getErrorString());
                    this.cwZ.akF();
                    this.cwZ.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_suggest));
                }
            }
        }
    }
}
