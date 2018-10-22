package com.baidu.tieba.mainentrance;

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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.e;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.a {
    private HotForumModel fli;
    private com.baidu.tieba.mainentrance.a.e fll;
    private HotSearchInfoData flo;
    private HotSearchInfoData mHotSearchInfo;
    private boolean flj = false;
    private boolean flk = false;
    private com.baidu.adp.framework.listener.a flm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (!NewSquareSearchActivity.this.flj) {
                        NewSquareSearchActivity.this.showToast(NewSquareSearchActivity.this.getActivity().getString(e.j.neterror));
                        NewSquareSearchActivity.this.flj = true;
                        return;
                    }
                    return;
                }
                List<String> list = null;
                if (responsedMessage instanceof SearchListHttpResMessage) {
                    list = ((SearchListHttpResMessage) responsedMessage).suggests;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    list = ((SearchListSocketResMessage) responsedMessage).suggests;
                }
                NewSquareSearchActivity.this.fll.cV(list);
            }
        }
    };
    private CustomMessageListener fln = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                NewSquareSearchActivity.this.qM(customResponsedMessage.getData().toString());
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
        registerListener(this.flm);
        registerListener(this.fln);
        this.fll = new com.baidu.tieba.mainentrance.a.e(this);
        this.fli = new HotForumModel(getPageContext(), this);
        this.fli.aYp();
        aYs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fll != null) {
            this.fll.onResume();
        }
    }

    private void initData() {
        if (getIntent() != null) {
            this.flk = getIntent().getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fll != null) {
            this.fll.onDestroy();
        }
    }

    private void aYs() {
        this.flo = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (this.flo != null) {
            this.mHotSearchInfo = this.flo;
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void qK(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        a(hotSearchInfoData);
        this.fll.b(this.mHotSearchInfo);
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (!this.flk && hotSearchInfoData != null) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fll.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView aZl = this.fll.aZl();
            if (i == 4 && aZl != null && aZl.canGoBack()) {
                aZl.goBack();
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
            com.baidu.tbadk.core.e.b.k(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.k(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(String str) {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
