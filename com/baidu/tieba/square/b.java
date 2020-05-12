package com.baidu.tieba.square;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.square.a.a;
/* loaded from: classes9.dex */
public class b {
    private final a kLd;
    private final ForumSquareActivity kLg;
    private com.baidu.adp.framework.listener.a kLm = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.square.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bHH();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bHH();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.kLg.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (b.this.kLd != null) {
                b.this.kLd.setSearchHint(str);
            }
        }
    };
    private final View.OnClickListener kLl = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.kLg.cUn();
        }
    };
    private View.OnClickListener kLn = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c13654").t("uid", TbadkCoreApplication.getCurrentAccountId()));
            b.this.cUB();
        }
    };
    private a.InterfaceC0668a kLo = new a.InterfaceC0668a() { // from class: com.baidu.tieba.square.b.4
        @Override // com.baidu.tieba.square.a.a.InterfaceC0668a
        public void a(View view, int i, String str) {
            b.this.kLg.Ks(str);
        }
    };
    private RecyclerView.OnScrollListener kLp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.square.b.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    };
    private BdListView.e TT = new BdListView.e() { // from class: com.baidu.tieba.square.b.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            b.this.kLg.bpe();
        }
    };

    public b(@NonNull ForumSquareActivity forumSquareActivity, @NonNull a aVar) {
        this.kLg = forumSquareActivity;
        this.kLd = aVar;
        this.kLd.af(this.kLn);
        this.kLd.ag(this.kLl);
        this.kLd.a(this.kLo);
        this.kLd.e(this.TT);
        this.kLd.a(this.kLp);
    }

    public void cUz() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.kLd.setSearchHint(hotSearch);
        } else if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.kLg.registerListener(this.kLm);
            cUA();
        }
    }

    private void cUA() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.kLg.sendMessage(forumrecommendrequestmessage);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cUB() {
        if (!j.isNetWorkAvailable()) {
            this.kLg.showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(this.kLg.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kLg.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
        } else {
            ba.aOV().b(this.kLg.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
        }
    }
}
