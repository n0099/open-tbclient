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
    private final a ldt;
    private final ForumSquareActivity ldw;
    private com.baidu.adp.framework.listener.a ldC = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.square.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bOa();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bOa();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.ldw.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (b.this.ldt != null) {
                b.this.ldt.setSearchHint(str);
            }
        }
    };
    private final View.OnClickListener ldB = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.ldw.dbr();
        }
    };
    private View.OnClickListener ldD = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c13654").s("uid", TbadkCoreApplication.getCurrentAccountId()));
            b.this.dbF();
        }
    };
    private a.InterfaceC0721a ldE = new a.InterfaceC0721a() { // from class: com.baidu.tieba.square.b.4
        @Override // com.baidu.tieba.square.a.a.InterfaceC0721a
        public void a(View view, int i, String str) {
            b.this.ldw.Me(str);
        }
    };
    private RecyclerView.OnScrollListener ldF = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.square.b.5
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
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.square.b.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            b.this.ldw.buV();
        }
    };

    public b(@NonNull ForumSquareActivity forumSquareActivity, @NonNull a aVar) {
        this.ldw = forumSquareActivity;
        this.ldt = aVar;
        this.ldt.af(this.ldD);
        this.ldt.ag(this.ldB);
        this.ldt.a(this.ldE);
        this.ldt.e(this.Uf);
        this.ldt.a(this.ldF);
    }

    public void dbD() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.ldt.setSearchHint(hotSearch);
        } else if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ldw.registerListener(this.ldC);
            dbE();
        }
    }

    private void dbE() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.ldw.sendMessage(forumrecommendrequestmessage);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dbF() {
        if (!j.isNetWorkAvailable()) {
            this.ldw.showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(this.ldw.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.ldw.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
        } else {
            ba.aUZ().b(this.ldw.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
        }
    }
}
