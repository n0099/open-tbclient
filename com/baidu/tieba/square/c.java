package com.baidu.tieba.square;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.square.a.a;
/* loaded from: classes22.dex */
public class c {
    private final Context mActivity;

    /* renamed from: new  reason: not valid java name */
    private final a f6new;
    private final b ney;
    private com.baidu.adp.framework.listener.a neI = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.square.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cuS();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cuS();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = c.this.mActivity.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (c.this.ney != null) {
                c.this.ney.setSearchHint(str);
            }
        }
    };
    private final View.OnClickListener neG = new View.OnClickListener() { // from class: com.baidu.tieba.square.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f6new.dNe();
        }
    };
    private View.OnClickListener neJ = new View.OnClickListener() { // from class: com.baidu.tieba.square.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13654").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            c.this.dNr();
        }
    };
    private a.InterfaceC0864a neK = new a.InterfaceC0864a() { // from class: com.baidu.tieba.square.c.4
        @Override // com.baidu.tieba.square.a.a.InterfaceC0864a
        public void a(View view, int i, String str) {
            c.this.f6new.Tg(str);
        }
    };
    private RecyclerView.OnScrollListener neL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.square.c.5
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
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.square.c.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.f6new.bWF();
        }
    };

    public c(@NonNull Context context, a aVar, @NonNull b bVar) {
        this.mActivity = context;
        this.ney = bVar;
        this.f6new = aVar;
        this.ney.ai(this.neJ);
        this.ney.aj(this.neG);
        this.ney.a(this.neK);
        this.ney.e(this.WQ);
        this.ney.b(this.neL);
    }

    public void dNp() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.ney.setSearchHint(hotSearch);
        } else if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().registerListener(this.neI);
            dNq();
        }
    }

    private void dNq() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        MessageManager.getInstance().sendMessage(forumrecommendrequestmessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNr() {
        if (j.isNetWorkAvailable()) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(UtilHelper.getTbPageContext(this.mActivity), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mActivity, true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                bf.bua().b(UtilHelper.getTbPageContext(this.mActivity), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
            }
        }
    }
}
