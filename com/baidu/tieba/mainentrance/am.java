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
class am extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bzG = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ResponseSearchFriendMessage responseSearchFriendMessage;
        HttpMessage httpMessage;
        FrameLayout frameLayout;
        com.baidu.tbadk.core.view.s sVar;
        com.baidu.tbadk.core.view.s sVar2;
        boolean z;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.bzG.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.bzG.amI;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.bzG.amI = true;
                                this.bzG.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.bzG.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bzG.getPageContext().getPageActivity(), String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.bzG.showToast(com.baidu.tieba.y.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.bzG.showToast(com.baidu.tieba.y.neterror);
                } else {
                    this.bzG.showToast(httpResponsedMessage.getErrorString());
                    frameLayout = this.bzG.byR;
                    frameLayout.setVisibility(8);
                    sVar = this.bzG.mNoDataView;
                    sVar.setVisibility(0);
                    sVar2 = this.bzG.mNoDataView;
                    sVar2.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_suggest));
                }
            }
        }
    }
}
