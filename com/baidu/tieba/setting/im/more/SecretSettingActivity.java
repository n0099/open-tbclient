package com.baidu.tieba.setting.im.more;

import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c ghk;
    private a ghl;
    private ArrayList<h> ghn;
    private int gho;
    private int ghp;
    private int ghq;
    private int ghr;
    private int ghs;
    private e ght;
    private boolean ghm = false;
    private c.a ghu = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bla() {
            SecretSettingActivity.this.bkY();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void blb() {
            SecretSettingActivity.this.bU("like", SecretSettingActivity.this.getPageContext().getString(d.k.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void blc() {
            SecretSettingActivity.this.bU("group", SecretSettingActivity.this.getPageContext().getString(d.k.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bld() {
            SecretSettingActivity.this.bU("live", SecretSettingActivity.this.getPageContext().getString(d.k.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void ble() {
            SecretSettingActivity.this.bkZ();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void a(BdSwitchView.SwitchState switchState) {
            SecretSettingActivity.this.aH(Headers.LOCATION, BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
            SecretSettingActivity.this.showProgressBar();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void blf() {
            SecretSettingActivity.this.bU("reply", SecretSettingActivity.this.getPageContext().getString(d.k.privacy_setting_thread_reply));
        }
    };
    private HttpMessageListener ghv = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                SecretSettingActivity.this.hideProgressBar();
                if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    String operation = privacySettingMessage.getOperation();
                    int type = privacySettingMessage.getType();
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                        if (TextUtils.equals(Headers.LOCATION, operation)) {
                            final boolean blh = SecretSettingActivity.this.ghk.blh();
                            SecretSettingActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SecretSettingActivity.this.ghk.lN(!blh);
                                }
                            }, 500L);
                            return;
                        }
                        return;
                    }
                    SecretSettingActivity.this.showToast(d.k.success);
                    if (TextUtils.equals(Headers.LOCATION, operation)) {
                        TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.ghk.blh());
                        SecretSettingActivity.this.ghk.lN(TbadkCoreApplication.getInst().getLocationShared());
                        return;
                    }
                    SecretSettingActivity.this.ghl.aG(operation, type);
                    SecretSettingActivity.this.ghk.aI(operation, type);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.ghm = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                    return;
                }
                a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (aVar != null) {
                    SecretSettingActivity.this.ghl.b(aVar);
                    SecretSettingActivity.this.ghl.bkT();
                    SecretSettingActivity.this.ghk.lM(true);
                    SecretSettingActivity.this.ghk.d(SecretSettingActivity.this.ghl);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.ghl);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.ghl.bkW());
                }
            }
        }
    };
    private CustomMessageListener ghw = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.ghl.sh(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.ghk.d(SecretSettingActivity.this.ghl);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghk = new c(this);
        this.ghl = new a();
        this.ghk.a(this.ghu);
        if (this.ghl.bkR()) {
            this.ghk.lM(true);
            this.ghk.d(this.ghl);
            c(this.ghl);
        } else {
            this.ghk.lM(false);
        }
        this.ghk.lN(TbadkCoreApplication.getInst().getLocationShared());
        registerListener(this.mNetMessageListener);
        registerListener(this.ghv);
        registerListener(this.ghw);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gho = aVar.bkU();
        this.ghp = aVar.bkS();
        this.ghq = aVar.bkV();
        this.ghr = aVar.Df();
        this.ghs = aVar.bkX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ghk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.ghk.blg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(final String str, String str2) {
        if (this.ghm) {
            if ("group".equals(str)) {
                this.ghn = so(this.ghq);
            } else if ("post".equals(str)) {
                this.ghn = so(this.ghp);
            } else if ("like".equals(str)) {
                this.ghn = so(this.gho);
            } else if ("live".equals(str)) {
                this.ghn = sp(this.ghr);
            } else if ("reply".equals(str)) {
                this.ghn = sq(this.ghs);
            }
            if (this.ght != null) {
                this.ght.dismiss();
            }
            this.ght = new e(getPageContext());
            this.ght.de(str2);
            this.ght.a(this.ghn, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((h) SecretSettingActivity.this.ghn.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.aH(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.aH(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.aH(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.aH(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.aH(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.ght.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.ghq = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.ghp = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gho = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.ghr = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.ghs = i2;
                    }
                }
            }).de(str2);
            this.ght.tG().tH();
        }
    }

    private ArrayList<h> so(int i) {
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.add(new h(getPageContext().getString(d.k.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new h(getPageContext().getString(d.k.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new h(getPageContext().getString(d.k.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<h> sp(int i) {
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.add(new h(getPageContext().getString(d.k.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new h(getPageContext().getString(d.k.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<h> sq(int i) {
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.add(new h(getPageContext().getString(d.k.all_person), "", i == 1, "showAll"));
        arrayList.add(new h(getPageContext().getString(d.k.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new h(getPageContext().getString(d.k.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ght != null) {
            this.ght.dismiss();
        }
    }
}
