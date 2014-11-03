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
class ag extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bnc = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ResponseSearchFriendMessage responseSearchFriendMessage;
        HttpMessage httpMessage;
        FrameLayout frameLayout;
        com.baidu.tbadk.core.view.o oVar;
        com.baidu.tbadk.core.view.o oVar2;
        boolean z;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.bnc.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.bnc.XM;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.bnc.XM = true;
                                this.bnc.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.bnc.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bnc, String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.bnc.showToast(com.baidu.tieba.y.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.bnc.showToast(com.baidu.tieba.y.neterror);
                } else {
                    this.bnc.showToast(httpResponsedMessage.getErrorString());
                    frameLayout = this.bnc.bmB;
                    frameLayout.setVisibility(8);
                    oVar = this.bnc.ahX;
                    oVar.setVisibility(0);
                    oVar2 = this.bnc.ahX;
                    oVar2.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_suggest));
                }
            }
        }
    }
}
