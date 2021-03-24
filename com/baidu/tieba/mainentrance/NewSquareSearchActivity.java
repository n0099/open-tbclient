package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import com.baidu.tieba.mainentrance.view.SquareSearchViewController;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.b {
    public HotForumModel mHotForumModel;
    public HotSearchInfoData mHotSearchInfo;
    public HotSearchInfoData mTransmitHotSearchInfo;
    public SquareSearchViewController mViewController;
    public boolean hasRemindSearchResultForNet = false;
    public boolean mIsFromEnterForum = false;
    public d.b.b.c.g.a mSearchSuggestListListener = new a(CmdConfigHttp.CMD_SEARCH_LIST, 309438);
    public CustomMessageListener mCreateBarListener = new b(2001608);

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<ForumInfo> list;
            boolean z = responsedMessage instanceof SearchListHttpResMessage;
            if (z || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (NewSquareSearchActivity.this.hasRemindSearchResultForNet) {
                        return;
                    }
                    NewSquareSearchActivity newSquareSearchActivity = NewSquareSearchActivity.this;
                    newSquareSearchActivity.showToast(newSquareSearchActivity.getActivity().getString(R.string.neterror));
                    NewSquareSearchActivity.this.hasRemindSearchResultForNet = true;
                    return;
                }
                List<String> list2 = null;
                if (z) {
                    SearchListHttpResMessage searchListHttpResMessage = (SearchListHttpResMessage) responsedMessage;
                    list2 = searchListHttpResMessage.suggests;
                    list = searchListHttpResMessage.forums;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    SearchListSocketResMessage searchListSocketResMessage = (SearchListSocketResMessage) responsedMessage;
                    list2 = searchListSocketResMessage.suggests;
                    list = searchListSocketResMessage.forums;
                } else {
                    list = null;
                }
                NewSquareSearchActivity.this.mViewController.D(list2);
                NewSquareSearchActivity.this.mViewController.E(list);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            NewSquareSearchActivity.this.creatBar(customResponsedMessage.getData().toString());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.J(NewSquareSearchActivity.this.getPageContext().getPageActivity(), NewSquareSearchActivity.this.mViewController.r());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewSquareSearchActivity.this.closeActivity();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CustomMessageTask.CustomRunnable<String> {
        public e() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
            if (customMessage != null && (customMessage.getData() instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject(customMessage.getData());
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString("img");
                    String optString4 = jSONObject.optString("url");
                    String optString5 = jSONObject.optString("topic");
                    String optString6 = jSONObject.optString("wbtitle");
                    String optString7 = jSONObject.optString("wbcontent");
                    ShareItem shareItem = new ShareItem();
                    shareItem.r = optString;
                    shareItem.t = optString4;
                    shareItem.s = optString2;
                    if (!TextUtils.isEmpty(optString3)) {
                        shareItem.v = Uri.parse(optString3);
                    }
                    shareItem.N = optString5;
                    shareItem.O = optString6;
                    shareItem.P = optString7;
                    shareItem.V = jSONObject.optInt("shareimg");
                    shareItem.b0 = jSONObject.optInt("weixin_disable");
                    String optString8 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString8)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString8);
                            String optString9 = jSONObject2.optString("activityid");
                            String optString10 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString9, optString10);
                                shareItem.R = jSONObject3.toString();
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    return new CustomResponsedMessage<>(2016568, shareItem);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void creatBar(String str) {
        if (!j.z()) {
            showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mIsFromEnterForum = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
            String stringExtra = intent.getStringExtra("search");
            String stringExtra2 = intent.getStringExtra(SquareSearchActivityConfig.SEARCH_VALUE);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.mTransmitHotSearchInfo = new HotSearchInfoData();
            if (StringUtils.isNull(stringExtra2)) {
                this.mTransmitHotSearchInfo.setName(stringExtra);
            } else {
                this.mTransmitHotSearchInfo.setName(stringExtra2);
            }
            this.mTransmitHotSearchInfo.v(stringExtra);
        }
    }

    private void loadHotSearch() {
        HotSearchInfoData hotSearchInfoData = this.mTransmitHotSearchInfo;
        if (hotSearchInfoData != null && !TextUtils.isEmpty(hotSearchInfoData.s()) && !TextUtils.isEmpty(this.mTransmitHotSearchInfo.getName())) {
            this.mViewController.C(this.mTransmitHotSearchInfo);
            return;
        }
        HotSearchInfoData hotSearchInfoData2 = (HotSearchInfoData) OrmObject.objectWithJsonStr(d.b.h0.r.d0.b.i().o("hot_search_info", ""), HotSearchInfoData.class);
        this.mHotSearchInfo = hotSearchInfoData2;
        if (hotSearchInfoData2 != null && !TextUtils.isEmpty(hotSearchInfoData2.s()) && !TextUtils.isEmpty(this.mHotSearchInfo.getName())) {
            this.mViewController.C(this.mHotSearchInfo);
        } else {
            this.mHotForumModel.D();
        }
    }

    private void registerGetShareContentTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void updateHotSearchCache(HotSearchInfoData hotSearchInfoData) {
        if (this.mIsFromEnterForum || hotSearchInfoData == null) {
            return;
        }
        this.mHotSearchInfo = hotSearchInfoData;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            d.b.h0.r.a0.b.e(getPageContext().getPageActivity(), 1);
        } else {
            d.b.h0.r.a0.b.e(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a026";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mViewController.v(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        getWindow().setSoftInputMode(2);
        addGlobalLayoutListener();
        registerListener(this.mSearchSuggestListListener);
        registerListener(this.mCreateBarListener);
        this.mViewController = new SquareSearchViewController(this, this.mIsFromEnterForum);
        this.mHotForumModel = new HotForumModel(getPageContext(), this);
        loadHotSearch();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SquareSearchViewController squareSearchViewController = this.mViewController;
        if (squareSearchViewController != null) {
            squareSearchViewController.w();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
        TbPageExtraHelper.u(getCurrentPageKey());
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataFailed(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataSuccess(List<d.b.i0.n1.b> list, List<d.b.i0.n1.c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        updateHotSearchCache(hotSearchInfoData);
        this.mViewController.C(this.mHotSearchInfo);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView s = this.mViewController.s();
            if (i == 4 && s != null && s.canGoBack()) {
                this.mViewController.y();
                s.goBack();
                return true;
            }
            d.b.b.e.m.e.a().postDelayed(new d(), 200L);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterTask(2016568);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SquareSearchViewController squareSearchViewController = this.mViewController;
        if (squareSearchViewController != null) {
            squareSearchViewController.x();
        }
        registerGetShareContentTask();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        d.b.b.e.m.e.a().postDelayed(new c(), 300L);
    }
}
