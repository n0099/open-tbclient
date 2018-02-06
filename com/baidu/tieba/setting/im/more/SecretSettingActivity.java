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
import com.baidu.tieba.setting.im.more.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private b gLf;
    private a gLg;
    private ArrayList<h> gLi;
    private int gLj;
    private int gLk;
    private int gLl;
    private int gLm;
    private e gLn;
    private boolean gLh = false;
    private b.a gLo = new b.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.b.a
        public void bpT() {
            SecretSettingActivity.this.bpR();
        }

        @Override // com.baidu.tieba.setting.im.more.b.a
        public void bpU() {
            SecretSettingActivity.this.bV("like", SecretSettingActivity.this.getPageContext().getString(d.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.b.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.b.a
        public void bpV() {
            SecretSettingActivity.this.bV("group", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.b.a
        public void bpW() {
            SecretSettingActivity.this.bV("live", SecretSettingActivity.this.getPageContext().getString(d.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.b.a
        public void bpX() {
            SecretSettingActivity.this.bpS();
        }

        @Override // com.baidu.tieba.setting.im.more.b.a
        public void a(BdSwitchView.SwitchState switchState) {
            SecretSettingActivity.this.aG(Headers.LOCATION, BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
            SecretSettingActivity.this.showProgressBar();
        }
    };
    private HttpMessageListener gLp = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        if (TextUtils.equals(Headers.LOCATION, operation)) {
                            final boolean bpZ = SecretSettingActivity.this.gLf.bpZ();
                            SecretSettingActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SecretSettingActivity.this.gLf.mg(!bpZ);
                                }
                            }, 500L);
                            return;
                        }
                        return;
                    }
                    SecretSettingActivity.this.showToast(d.j.success);
                    if (TextUtils.equals(Headers.LOCATION, operation)) {
                        TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gLf.bpZ());
                        SecretSettingActivity.this.gLf.mg(TbadkCoreApplication.getInst().getLocationShared());
                        return;
                    }
                    SecretSettingActivity.this.gLg.aF(operation, type);
                    SecretSettingActivity.this.gLf.aH(operation, type);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.gLh = true;
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
                    SecretSettingActivity.this.gLg.b(aVar);
                    SecretSettingActivity.this.gLg.bpN();
                    SecretSettingActivity.this.gLf.mf(true);
                    SecretSettingActivity.this.gLf.d(SecretSettingActivity.this.gLg);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gLg);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gLg.bpQ());
                }
            }
        }
    };
    private CustomMessageListener gLq = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gLg.uH(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gLf.d(SecretSettingActivity.this.gLg);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gLf = new b(this);
        this.gLg = new a();
        this.gLf.a(this.gLo);
        if (this.gLg.bpL()) {
            this.gLf.mf(true);
            this.gLf.d(this.gLg);
            c(this.gLg);
        } else {
            this.gLf.mf(false);
        }
        this.gLf.mg(TbadkCoreApplication.getInst().getLocationShared());
        registerListener(this.mNetMessageListener);
        registerListener(this.gLp);
        registerListener(this.gLq);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gLj = aVar.bpO();
        this.gLk = aVar.bpM();
        this.gLl = aVar.bpP();
        this.gLm = aVar.KB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gLf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gLf.bpY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(final String str, String str2) {
        if (this.gLh) {
            if ("group".equals(str)) {
                this.gLi = uN(this.gLl);
            } else if ("post".equals(str)) {
                this.gLi = uN(this.gLk);
            } else if ("like".equals(str)) {
                this.gLi = uN(this.gLj);
            } else if ("live".equals(str)) {
                this.gLi = uO(this.gLm);
            }
            if (this.gLn != null) {
                this.gLn.dismiss();
            }
            this.gLn = new e(getPageContext());
            this.gLn.dm(str2);
            this.gLn.a(this.gLi, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((h) SecretSettingActivity.this.gLi.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.aG(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.aG(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.aG(str, 3);
                        i2 = 3;
                    }
                    SecretSettingActivity.this.gLn.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gLl = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gLk = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gLj = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gLm = i2;
                    }
                }
            }).dm(str2);
            this.gLn.AY().AZ();
        }
    }

    private ArrayList<h> uN(int i) {
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.add(new h(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new h(getPageContext().getString(d.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new h(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<h> uO(int i) {
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.add(new h(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new h(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpR() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpS() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gLn != null) {
            this.gLn.dismiss();
        }
    }
}
