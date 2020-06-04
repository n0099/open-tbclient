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
    private final a leD;
    private final ForumSquareActivity leG;
    private com.baidu.adp.framework.listener.a leM = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.square.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bOc();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bOc();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.leG.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (b.this.leD != null) {
                b.this.leD.setSearchHint(str);
            }
        }
    };
    private final View.OnClickListener leL = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.leG.dbH();
        }
    };
    private View.OnClickListener leN = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c13654").s("uid", TbadkCoreApplication.getCurrentAccountId()));
            b.this.dbU();
        }
    };
    private a.InterfaceC0722a leO = new a.InterfaceC0722a() { // from class: com.baidu.tieba.square.b.4
        @Override // com.baidu.tieba.square.a.a.InterfaceC0722a
        public void a(View view, int i, String str) {
            b.this.leG.Mf(str);
        }
    };
    private RecyclerView.OnScrollListener leP = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.square.b.5
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
            b.this.leG.buX();
        }
    };

    public b(@NonNull ForumSquareActivity forumSquareActivity, @NonNull a aVar) {
        this.leG = forumSquareActivity;
        this.leD = aVar;
        this.leD.af(this.leN);
        this.leD.ag(this.leL);
        this.leD.a(this.leO);
        this.leD.e(this.Uf);
        this.leD.b(this.leP);
    }

    public void dbS() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.leD.setSearchHint(hotSearch);
        } else if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.leG.registerListener(this.leM);
            dbT();
        }
    }

    private void dbT() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.leG.sendMessage(forumrecommendrequestmessage);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dbU() {
        if (!j.isNetWorkAvailable()) {
            this.leG.showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(this.leG.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.leG.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
        } else {
            ba.aVa().b(this.leG.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
        }
    }
}
