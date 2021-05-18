package com.baidu.tieba.setting.im.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.view.BdTopToast;
import d.a.j0.r.s.n;
import d.a.k0.d3.h0.m;
import d.a.k0.v2.b.a.c;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    public static final String POSITION_FRIEND_ONLY_TAG = "friendOnly";
    public static final String POSITION_HIDE_ALL_TAG = "hideAll";
    public static final String POSITION_MYSELF_ONLY_TAG = "myselfOnly";
    public static final String POSITION_REPLY_ATTENTIONS_TAG = "my_attention_reply";
    public static final String POSITION_REPLY_FANS_TAG = "my_fans_reply";
    public static final String POSITION_SHOW_ALL_TAG = "showAll";
    public d.a.j0.r.s.e mDialog;
    public ArrayList<n> mMyBar;
    public d.a.k0.v2.b.a.a mSetting;
    public d.a.k0.v2.b.a.c mView;
    public int optionBarSelected;
    public int optionBazhuShowInside;
    public int optionBazhuShowOutside;
    public int optionForumSelected;
    public int optionGroupSelected;
    public int optionLiveSelected;
    public int optionThreadReplySelected;
    public int optionThreadReplyShowMyself;
    public boolean loadSuccess = false;
    public c.b mCallback = new a();
    public HttpMessageListener mSetPrivateHttpListener = new b(CmdConfigHttp.SET_PRIVATE_CMD, true);
    public d.a.c.c.g.a mNetMessageListener = new c(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    public CustomMessageListener markUpdateListener = new d(2921499);
    public CustomMessageListener mThreadPrivacyStatusUpdateListener = new f(2921065);

    /* loaded from: classes5.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void a() {
            SecretSettingActivity secretSettingActivity = SecretSettingActivity.this;
            secretSettingActivity.showResetSettingDialog("reply", secretSettingActivity.getPageContext().getString(R.string.privacy_setting_thread_reply_decs));
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void b() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new ForbiddenForumActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void c() {
            SecretSettingActivity secretSettingActivity = SecretSettingActivity.this;
            secretSettingActivity.showResetSettingDialog("live", secretSettingActivity.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void d() {
            PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity());
            privacyMarkActivityConfig.setMarkState(SecretSettingActivity.this.optionBazhuShowInside, SecretSettingActivity.this.optionBazhuShowOutside);
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, privacyMarkActivityConfig));
            TiebaStatic.log(new StatisticItem("c14002").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void e() {
            SecretSettingActivity secretSettingActivity = SecretSettingActivity.this;
            secretSettingActivity.showResetSettingDialog("group", secretSettingActivity.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void f() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void g() {
            SecretSettingActivity secretSettingActivity = SecretSettingActivity.this;
            secretSettingActivity.showResetSettingDialog("like", secretSettingActivity.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void h() {
            SecretSettingActivity.this.goToBlackListActivity();
        }

        @Override // d.a.k0.v2.b.a.c.b
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            SecretSettingActivity.this.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(SecretSettingActivity.this);
                    bdTopToast.i(true);
                    bdTopToast.h(SecretSettingActivity.this.getString(R.string.block_user_success));
                    bdTopToast.j((ViewGroup) SecretSettingActivity.this.findViewById(16908290));
                    if (TextUtils.equals("location", operation)) {
                        return;
                    }
                    SecretSettingActivity.this.mSetting.n(operation, type);
                    SecretSettingActivity.this.mView.t(operation, type);
                    return;
                }
                String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                BdTopToast bdTopToast2 = new BdTopToast(SecretSettingActivity.this);
                bdTopToast2.i(false);
                bdTopToast2.h(string);
                bdTopToast2.j((ViewGroup) SecretSettingActivity.this.findViewById(16908290));
                SecretSettingActivity secretSettingActivity = SecretSettingActivity.this;
                secretSettingActivity.updateSelectedOption(secretSettingActivity.mSetting);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage == null) {
                return;
            }
            SecretSettingActivity.this.loadSuccess = true;
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                d.a.k0.v2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (privacyData == null) {
                    return;
                }
                SecretSettingActivity.this.mSetting.l(privacyData);
                SecretSettingActivity.this.mSetting.m();
                SecretSettingActivity.this.mView.r(true);
                SecretSettingActivity.this.mView.u(SecretSettingActivity.this.mSetting);
                SecretSettingActivity secretSettingActivity = SecretSettingActivity.this;
                secretSettingActivity.updateSelectedOption(secretSettingActivity.mSetting);
                TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.mSetting.j());
                return;
            }
            SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
            int k = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            d.a.j0.r.d0.b j2 = d.a.j0.r.d0.b.j();
            int k2 = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            SecretSettingActivity.this.optionBazhuShowInside = k;
            SecretSettingActivity.this.optionBazhuShowOutside = k2;
            SecretSettingActivity.this.mView.s(k, k2);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20461e;

        public e(String str) {
            this.f20461e = str;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            SecretSettingActivity.this.showProgressBar();
            String b2 = ((n) SecretSettingActivity.this.mMyBar.get(i2)).b();
            int i3 = 7;
            if (SecretSettingActivity.POSITION_SHOW_ALL_TAG.equals(b2)) {
                SecretSettingActivity.this.sendSetPrivacyMessage(this.f20461e, 1);
                i3 = 1;
            } else if (SecretSettingActivity.POSITION_FRIEND_ONLY_TAG.equals(b2)) {
                SecretSettingActivity.this.sendSetPrivacyMessage(this.f20461e, 2);
                i3 = 2;
            } else if (SecretSettingActivity.POSITION_HIDE_ALL_TAG.equals(b2)) {
                SecretSettingActivity.this.sendSetPrivacyMessage(this.f20461e, 3);
                i3 = 3;
            } else if (SecretSettingActivity.POSITION_REPLY_FANS_TAG.equals(b2)) {
                SecretSettingActivity.this.sendSetPrivacyMessage(this.f20461e, 5);
                i3 = 5;
            } else if (SecretSettingActivity.POSITION_REPLY_ATTENTIONS_TAG.equals(b2)) {
                SecretSettingActivity.this.sendSetPrivacyMessage(this.f20461e, 6);
                i3 = 6;
            } else if (SecretSettingActivity.POSITION_MYSELF_ONLY_TAG.equals(b2)) {
                SecretSettingActivity.this.sendSetPrivacyMessage(this.f20461e, 7);
            } else {
                i3 = 0;
            }
            SecretSettingActivity.this.mDialog.h(i2);
            if ("group".equals(this.f20461e)) {
                SecretSettingActivity.this.optionGroupSelected = i3;
            } else if ("post".equals(this.f20461e)) {
                SecretSettingActivity.this.optionForumSelected = i3;
            } else if ("like".equals(this.f20461e)) {
                SecretSettingActivity.this.optionBarSelected = i3;
            } else if ("live".equals(this.f20461e)) {
                SecretSettingActivity.this.optionLiveSelected = i3;
            } else if ("reply".equals(this.f20461e)) {
                SecretSettingActivity.this.optionThreadReplySelected = i3;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            SecretSettingActivity.this.mSetting.y(((Integer) customResponsedMessage.getData()).intValue());
            SecretSettingActivity.this.mView.u(SecretSettingActivity.this.mSetting);
        }
    }

    private ArrayList<n> createLiveRichDialogList(int i2) {
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(new n(getPageContext().getString(R.string.info_privacy_all), "", i2 == 1, POSITION_SHOW_ALL_TAG));
        arrayList.add(new n(getPageContext().getString(R.string.info_privacy_hide), "", i2 == 3, POSITION_HIDE_ALL_TAG));
        return arrayList;
    }

    private ArrayList<n> createRichDialogList(int i2) {
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(new n(getPageContext().getString(R.string.info_privacy_all), "", i2 == 1, POSITION_SHOW_ALL_TAG));
        arrayList.add(new n(getPageContext().getString(R.string.info_privacy_friend), "", i2 == 2, POSITION_FRIEND_ONLY_TAG));
        arrayList.add(new n(getPageContext().getString(R.string.info_privacy_hide), "", i2 == 3, POSITION_HIDE_ALL_TAG));
        return arrayList;
    }

    private ArrayList<n> createThreadReplyList(int i2, int i3) {
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(new n(getPageContext().getString(R.string.all_person), "", i2 == 1, POSITION_SHOW_ALL_TAG));
        arrayList.add(new n(getPageContext().getString(R.string.my_fans), "", i2 == 5, POSITION_REPLY_FANS_TAG));
        arrayList.add(new n(getPageContext().getString(R.string.my_attentions), "", i2 == 6, POSITION_REPLY_ATTENTIONS_TAG));
        if (i3 == 1) {
            arrayList.add(new n(getPageContext().getString(R.string.myself_only), "", i2 == 7, POSITION_MYSELF_ONLY_TAG));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBlackListActivity() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(getPageContext().getPageActivity(), "UserBlacklistPage", null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToUserMuteListActivity() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetPrivacyMessage(String str, int i2) {
        sendMessage(new PrivacySettingMessage(str, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResetSettingDialog(String str, String str2) {
        if (this.loadSuccess) {
            if ("group".equals(str)) {
                this.mMyBar = createRichDialogList(this.optionGroupSelected);
            } else if ("post".equals(str)) {
                this.mMyBar = createRichDialogList(this.optionForumSelected);
            } else if ("like".equals(str)) {
                this.mMyBar = createRichDialogList(this.optionBarSelected);
            } else if ("live".equals(str)) {
                this.mMyBar = createLiveRichDialogList(this.optionLiveSelected);
            } else if ("reply".equals(str)) {
                this.mMyBar = createThreadReplyList(this.optionThreadReplySelected, this.optionThreadReplyShowMyself);
            }
            d.a.j0.r.s.e eVar = this.mDialog;
            if (eVar != null) {
                eVar.d();
            }
            d.a.j0.r.s.e eVar2 = new d.a.j0.r.s.e(getPageContext());
            this.mDialog = eVar2;
            eVar2.m(str2);
            d.a.j0.r.s.e eVar3 = this.mDialog;
            eVar3.k(this.mMyBar, new e(str));
            eVar3.m(str2);
            d.a.j0.r.s.e eVar4 = this.mDialog;
            eVar4.c();
            eVar4.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedOption(d.a.k0.v2.b.a.a aVar) {
        this.optionBarSelected = aVar.c();
        this.optionForumSelected = aVar.i();
        this.optionGroupSelected = aVar.d();
        this.optionLiveSelected = aVar.e();
        this.optionThreadReplySelected = aVar.g();
        this.optionThreadReplyShowMyself = aVar.h();
        this.optionBazhuShowInside = aVar.a();
        this.optionBazhuShowOutside = aVar.b();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
        d.a.j0.r.s.e eVar = this.mDialog;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.a.k0.v2.b.a.c(this);
        this.mSetting = new d.a.k0.v2.b.a.a();
        this.mView.q(this.mCallback);
        if (this.mSetting.k()) {
            this.mView.r(true);
            this.mView.u(this.mSetting);
            updateSelectedOption(this.mSetting);
        } else {
            this.mView.r(false);
        }
        registerListener(this.mNetMessageListener);
        registerListener(this.mSetPrivateHttpListener);
        registerListener(this.mThreadPrivacyStatusUpdateListener);
        registerListener(this.markUpdateListener);
        sendMessage(new PrivateInfoNetMessage());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.r.s.e eVar = this.mDialog;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.mView.p();
    }
}
