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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c iqf;
    private a iqg;
    private ArrayList<k> iqi;
    private int iqj;
    private int iqk;
    private int iql;
    private int iqm;
    private int iqn;
    private e iqo;
    private boolean iqh = false;
    private c.a iqp = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYx() {
            SecretSettingActivity.this.bYv();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYy() {
            SecretSettingActivity.this.dO("like", SecretSettingActivity.this.getPageContext().getString(d.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYz() {
            SecretSettingActivity.this.dO("group", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYA() {
            SecretSettingActivity.this.dO("live", SecretSettingActivity.this.getPageContext().getString(d.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYB() {
            SecretSettingActivity.this.bYw();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYC() {
            SecretSettingActivity.this.dO("reply", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYD() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener iqq = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    SecretSettingActivity.this.showToast(d.j.success);
                    if (!TextUtils.equals(Headers.LOCATION, operation)) {
                        SecretSettingActivity.this.iqg.bn(operation, type);
                        SecretSettingActivity.this.iqf.bp(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.iqh = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
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
                    SecretSettingActivity.this.iqg.b(aVar);
                    SecretSettingActivity.this.iqg.bYq();
                    SecretSettingActivity.this.iqf.pv(true);
                    SecretSettingActivity.this.iqf.d(SecretSettingActivity.this.iqg);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.iqg);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.iqg.bYt());
                }
            }
        }
    };
    private CustomMessageListener iqr = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.iqg.yk(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.iqf.d(SecretSettingActivity.this.iqg);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iqf = new c(this);
        this.iqg = new a();
        this.iqf.a(this.iqp);
        if (this.iqg.bYo()) {
            this.iqf.pv(true);
            this.iqf.d(this.iqg);
            c(this.iqg);
        } else {
            this.iqf.pv(false);
        }
        registerListener(this.mNetMessageListener);
        registerListener(this.iqq);
        registerListener(this.iqr);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.iqj = aVar.bYr();
        this.iqk = aVar.bYp();
        this.iql = aVar.bYs();
        this.iqm = aVar.alp();
        this.iqn = aVar.bYu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iqf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.iqf.bYE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(final String str, String str2) {
        if (this.iqh) {
            if ("group".equals(str)) {
                this.iqi = yr(this.iql);
            } else if ("post".equals(str)) {
                this.iqi = yr(this.iqk);
            } else if ("like".equals(str)) {
                this.iqi = yr(this.iqj);
            } else if ("live".equals(str)) {
                this.iqi = ys(this.iqm);
            } else if ("reply".equals(str)) {
                this.iqi = yt(this.iqn);
            }
            if (this.iqo != null) {
                this.iqo.dismiss();
            }
            this.iqo = new e(getPageContext());
            this.iqo.lB(str2);
            this.iqo.a(this.iqi, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((k) SecretSettingActivity.this.iqi.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bo(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bo(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bo(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bo(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bo(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.iqo.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.iql = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.iqk = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.iqj = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.iqm = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.iqn = i2;
                    }
                }
            }).lB(str2);
            this.iqo.aba().abb();
        }
    }

    private ArrayList<k> yr(int i) {
        ArrayList<k> arrayList = new ArrayList<>();
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<k> ys(int i) {
        ArrayList<k> arrayList = new ArrayList<>();
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<k> yt(int i) {
        ArrayList<k> arrayList = new ArrayList<>();
        arrayList.add(new k(getPageContext().getString(d.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new k(getPageContext().getString(d.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new k(getPageContext().getString(d.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYv() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYw() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iqo != null) {
            this.iqo.dismiss();
        }
    }
}
