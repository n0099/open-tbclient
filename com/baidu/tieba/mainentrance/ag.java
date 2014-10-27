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
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bmO = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
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
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.bmO.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            z = this.bmO.XI;
                            if (!z) {
                                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                                requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                                this.bmO.XI = true;
                                this.bmO.sendMessage(requestSearchPersonHistoryWriteMessage);
                            }
                            this.bmO.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bmO, String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.bmO.showToast(com.baidu.tieba.y.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.bmO.showToast(com.baidu.tieba.y.neterror);
                } else {
                    this.bmO.showToast(httpResponsedMessage.getErrorString());
                    frameLayout = this.bmO.bmn;
                    frameLayout.setVisibility(8);
                    oVar = this.bmO.ahO;
                    oVar.setVisibility(0);
                    oVar2 = this.bmO.ahO;
                    oVar2.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_suggest));
                }
            }
        }
    }
}
