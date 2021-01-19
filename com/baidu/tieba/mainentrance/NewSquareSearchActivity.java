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
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import com.baidu.tieba.mainentrance.view.SquareSearchViewController;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes7.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.a {
    private HotForumModel laF;
    private SquareSearchViewController laG;
    private HotSearchInfoData laJ;
    private HotSearchInfoData mHotSearchInfo;
    private boolean laD = false;
    private boolean laE = false;
    private com.baidu.adp.framework.listener.a laH = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<ForumInfo> list;
            List<String> list2;
            if ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (!NewSquareSearchActivity.this.laD) {
                        NewSquareSearchActivity.this.showToast(NewSquareSearchActivity.this.getActivity().getString(R.string.neterror));
                        NewSquareSearchActivity.this.laD = true;
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof SearchListHttpResMessage) {
                    SearchListHttpResMessage searchListHttpResMessage = (SearchListHttpResMessage) responsedMessage;
                    List<String> list3 = searchListHttpResMessage.suggests;
                    list = searchListHttpResMessage.forums;
                    list2 = list3;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    SearchListSocketResMessage searchListSocketResMessage = (SearchListSocketResMessage) responsedMessage;
                    List<String> list4 = searchListSocketResMessage.suggests;
                    list = searchListSocketResMessage.forums;
                    list2 = list4;
                } else {
                    list = null;
                    list2 = null;
                }
                NewSquareSearchActivity.this.laG.eQ(list2);
                NewSquareSearchActivity.this.laG.eR(list);
            }
        }
    };
    private CustomMessageListener laI = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                NewSquareSearchActivity.this.Ne(customResponsedMessage.getData().toString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        getWindow().setSoftInputMode(0);
        addGlobalLayoutListener();
        registerListener(this.laH);
        registerListener(this.laI);
        this.laG = new SquareSearchViewController(this, this.laE);
        this.laF = new HotForumModel(getPageContext(), this);
        dbN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.laG != null) {
            this.laG.onResume();
        }
        registerGetShareContentTask();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.laE = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
            String stringExtra = intent.getStringExtra("search");
            String stringExtra2 = intent.getStringExtra(SquareSearchActivityConfig.SEARCH_VALUE);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.laJ = new HotSearchInfoData();
                if (StringUtils.isNull(stringExtra2)) {
                    this.laJ.setName(stringExtra);
                } else {
                    this.laJ.setName(stringExtra2);
                }
                this.laJ.Nd(stringExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterTask(2016568);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.laG != null) {
            this.laG.onDestroy();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
        com.baidu.tbadk.pageExtra.d.CY(getCurrentPageKey());
    }

    private void dbN() {
        if (this.laJ != null && !TextUtils.isEmpty(this.laJ.ctU()) && !TextUtils.isEmpty(this.laJ.getName())) {
            this.laG.b(this.laJ);
            return;
        }
        this.mHotSearchInfo = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (this.mHotSearchInfo != null && !TextUtils.isEmpty(this.mHotSearchInfo.ctU()) && !TextUtils.isEmpty(this.mHotSearchInfo.getName())) {
            this.laG.b(this.mHotSearchInfo);
        } else {
            this.laF.dbL();
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void Nc(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        a(hotSearchInfoData);
        this.laG.b(this.mHotSearchInfo);
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (!this.laE && hotSearchInfoData != null) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.laG.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView dcJ = this.laG.dcJ();
            if (i == 4 && dcJ != null && dcJ.canGoBack()) {
                dcJ.goBack();
                return true;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    NewSquareSearchActivity.this.closeActivity();
                }
            }, 200L);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.e.b.B(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.B(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ne(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }

    private void registerGetShareContentTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(customMessage.getData());
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString("img");
                    String optString4 = jSONObject.optString("url");
                    String optString5 = jSONObject.optString(AlbumActivityConfig.FROM_TOPIC);
                    String optString6 = jSONObject.optString("wbtitle");
                    String optString7 = jSONObject.optString("wbcontent");
                    ShareItem shareItem = new ShareItem();
                    shareItem.title = optString;
                    shareItem.linkUrl = optString4;
                    shareItem.content = optString2;
                    if (!TextUtils.isEmpty(optString3)) {
                        shareItem.imageUri = Uri.parse(optString3);
                    }
                    shareItem.topic = optString5;
                    shareItem.fsL = optString6;
                    shareItem.fsM = optString7;
                    shareItem.shareType = jSONObject.optInt("shareimg");
                    shareItem.fsT = jSONObject.optInt("weixin_disable");
                    String optString8 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString8)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString8);
                            String optString9 = jSONObject2.optString("activityid");
                            String optString10 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString9, optString10);
                                shareItem.taskCompleteId = jSONObject3.toString();
                            }
                        } catch (JSONException e) {
                        }
                    }
                    return new CustomResponsedMessage<>(2016568, shareItem);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
