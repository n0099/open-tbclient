package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.a {
    private HotSearchInfoData hnr;
    private HotForumModel hnu;
    private com.baidu.tieba.mainentrance.a.e hnv;
    private HotSearchInfoData mHotSearchInfo;
    private boolean hns = false;
    private boolean hnt = false;
    private com.baidu.adp.framework.listener.a hnw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<String> list;
            List<ForumInfo> list2 = null;
            if ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (!NewSquareSearchActivity.this.hns) {
                        NewSquareSearchActivity.this.showToast(NewSquareSearchActivity.this.getActivity().getString(R.string.neterror));
                        NewSquareSearchActivity.this.hns = true;
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof SearchListHttpResMessage) {
                    SearchListHttpResMessage searchListHttpResMessage = (SearchListHttpResMessage) responsedMessage;
                    list = searchListHttpResMessage.suggests;
                    list2 = searchListHttpResMessage.forums;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    SearchListSocketResMessage searchListSocketResMessage = (SearchListSocketResMessage) responsedMessage;
                    list = searchListSocketResMessage.suggests;
                    list2 = searchListSocketResMessage.forums;
                } else {
                    list = null;
                }
                NewSquareSearchActivity.this.hnv.ds(list);
                NewSquareSearchActivity.this.hnv.dt(list2);
            }
        }
    };
    private CustomMessageListener hnx = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                NewSquareSearchActivity.this.AN(customResponsedMessage.getData().toString());
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
        registerListener(this.hnw);
        registerListener(this.hnx);
        this.hnv = new com.baidu.tieba.mainentrance.a.e(this, this.hnt);
        this.hnu = new HotForumModel(getPageContext(), this);
        this.hnu.bMN();
        bMQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hnv != null) {
            this.hnv.onResume();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.hnt = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hnv != null) {
            this.hnv.onDestroy();
        }
    }

    private void bMQ() {
        this.hnr = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.ahU().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (this.hnr != null) {
            this.mHotSearchInfo = this.hnr;
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void AL(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        a(hotSearchInfoData);
        this.hnv.b(this.mHotSearchInfo);
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (!this.hnt && hotSearchInfoData != null) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hnv.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView bNJ = this.hnv.bNJ();
            if (i == 4 && bNJ != null && bNJ.canGoBack()) {
                bNJ.goBack();
                return true;
            }
            closeActivity();
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
            com.baidu.tbadk.core.f.b.o(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.f.b.o(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(String str) {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
