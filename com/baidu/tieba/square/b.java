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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.square.a.a;
/* loaded from: classes16.dex */
public class b {
    private final a lFS;
    private final ForumSquareActivity lFV;
    private com.baidu.adp.framework.listener.a lGb = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.square.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bUv();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bUv();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = b.this.lFV.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (b.this.lFS != null) {
                b.this.lFS.setSearchHint(str);
            }
        }
    };
    private final View.OnClickListener lGa = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.lFV.djg();
        }
    };
    private View.OnClickListener lGc = new View.OnClickListener() { // from class: com.baidu.tieba.square.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ap("c13654").t("uid", TbadkCoreApplication.getCurrentAccountId()));
            b.this.djt();
        }
    };
    private a.InterfaceC0748a lGd = new a.InterfaceC0748a() { // from class: com.baidu.tieba.square.b.4
        @Override // com.baidu.tieba.square.a.a.InterfaceC0748a
        public void a(View view, int i, String str) {
            b.this.lFV.Np(str);
        }
    };
    private RecyclerView.OnScrollListener lGe = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.square.b.5
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
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.square.b.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            b.this.lFV.bBi();
        }
    };

    public b(@NonNull ForumSquareActivity forumSquareActivity, @NonNull a aVar) {
        this.lFV = forumSquareActivity;
        this.lFS = aVar;
        this.lFS.ag(this.lGc);
        this.lFS.ah(this.lGa);
        this.lFS.a(this.lGd);
        this.lFS.e(this.UC);
        this.lFS.b(this.lGe);
    }

    public void djr() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.lFS.setSearchHint(hotSearch);
        } else if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.lFV.registerListener(this.lGb);
            djs();
        }
    }

    private void djs() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.lFV.sendMessage(forumrecommendrequestmessage);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.square.ForumSquareActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void djt() {
        if (!j.isNetWorkAvailable()) {
            this.lFV.showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(this.lFV.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lFV.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
        } else {
            bd.baV().b(this.lFV.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
        }
    }
}
