package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import java.util.List;
/* loaded from: classes.dex */
class ab extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.a = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ResponseSearchFriendMessage responseSearchFriendMessage;
        HttpMessage httpMessage;
        FrameLayout frameLayout;
        TextView textView;
        TextView textView2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof ResponseSearchFriendMessage) && (responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage) != null && (httpMessage = (HttpMessage) responseSearchFriendMessage.getOrginalMessage()) != null && httpMessage.getTag() == this.a.getUniqueId()) {
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo.size() > 0) {
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (String.valueOf(userInfo2.getUserId()) != null && userInfo2.getUserName() != null) {
                            RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                            requestSearchPersonHistoryWriteMessage.setData(userInfo2.getUserName());
                            this.a.sendMessage(requestSearchPersonHistoryWriteMessage);
                            this.a.sendMessage(new CustomMessage(2002003, new bg(this.a, String.valueOf(userInfo2.getUserId()), userInfo2.getUserName())));
                            return;
                        }
                        return;
                    }
                    this.a.showToast(com.baidu.tieba.x.neterror);
                } else if (TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                    this.a.showToast(com.baidu.tieba.x.neterror);
                } else {
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    frameLayout = this.a.i;
                    frameLayout.setVisibility(8);
                    textView = this.a.s;
                    textView.setVisibility(0);
                    textView2 = this.a.s;
                    textView2.setText(com.baidu.tieba.x.text_no_suggest);
                }
            }
        }
    }
}
