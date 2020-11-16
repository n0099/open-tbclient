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
/* loaded from: classes21.dex */
public class c {
    private final Context mActivity;
    private final a mQp;
    private final b mQr;
    private com.baidu.adp.framework.listener.a mQB = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.square.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cqD();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cqD();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = c.this.mActivity.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (c.this.mQr != null) {
                c.this.mQr.setSearchHint(str);
            }
        }
    };
    private final View.OnClickListener mQz = new View.OnClickListener() { // from class: com.baidu.tieba.square.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.mQp.dHN();
        }
    };
    private View.OnClickListener mQC = new View.OnClickListener() { // from class: com.baidu.tieba.square.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13654").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            c.this.dIa();
        }
    };
    private a.InterfaceC0849a mQD = new a.InterfaceC0849a() { // from class: com.baidu.tieba.square.c.4
        @Override // com.baidu.tieba.square.a.a.InterfaceC0849a
        public void a(View view, int i, String str) {
            c.this.mQp.RS(str);
        }
    };
    private RecyclerView.OnScrollListener mQE = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.square.c.5
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
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.square.c.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.mQp.bSU();
        }
    };

    public c(@NonNull Context context, a aVar, @NonNull b bVar) {
        this.mActivity = context;
        this.mQr = bVar;
        this.mQp = aVar;
        this.mQr.ai(this.mQC);
        this.mQr.aj(this.mQz);
        this.mQr.a(this.mQD);
        this.mQr.e(this.VT);
        this.mQr.b(this.mQE);
    }

    public void dHY() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.mQr.setSearchHint(hotSearch);
        } else if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().registerListener(this.mQB);
            dHZ();
        }
    }

    private void dHZ() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        MessageManager.getInstance().sendMessage(forumrecommendrequestmessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIa() {
        if (j.isNetWorkAvailable()) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(UtilHelper.getTbPageContext(this.mActivity), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mActivity, true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                bf.bqF().b(UtilHelper.getTbPageContext(this.mActivity), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
            }
        }
    }
}
