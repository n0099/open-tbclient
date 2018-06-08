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
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c gsE;
    private a gsF;
    private ArrayList<g> gsH;
    private int gsI;
    private int gsJ;
    private int gsK;
    private int gsL;
    private int gsM;
    private e gsN;
    private boolean gsG = false;
    private c.a gsO = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpY() {
            SecretSettingActivity.this.bpW();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpZ() {
            SecretSettingActivity.this.cc("like", SecretSettingActivity.this.getPageContext().getString(d.k.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqa() {
            SecretSettingActivity.this.cc("group", SecretSettingActivity.this.getPageContext().getString(d.k.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqb() {
            SecretSettingActivity.this.cc("live", SecretSettingActivity.this.getPageContext().getString(d.k.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqc() {
            SecretSettingActivity.this.bpX();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void a(BdSwitchView.SwitchState switchState) {
            SecretSettingActivity.this.aK(Headers.LOCATION, BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
            SecretSettingActivity.this.showProgressBar();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqd() {
            SecretSettingActivity.this.cc("reply", SecretSettingActivity.this.getPageContext().getString(d.k.privacy_setting_thread_reply));
        }
    };
    private HttpMessageListener gsP = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                            final boolean bqf = SecretSettingActivity.this.gsE.bqf();
                            SecretSettingActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SecretSettingActivity.this.gsE.lT(!bqf);
                                }
                            }, 500L);
                            return;
                        }
                        return;
                    }
                    SecretSettingActivity.this.showToast(d.k.success);
                    if (TextUtils.equals(Headers.LOCATION, operation)) {
                        TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gsE.bqf());
                        SecretSettingActivity.this.gsE.lT(TbadkCoreApplication.getInst().getLocationShared());
                        return;
                    }
                    SecretSettingActivity.this.gsF.aJ(operation, type);
                    SecretSettingActivity.this.gsE.aL(operation, type);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.gsG = true;
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
                    SecretSettingActivity.this.gsF.b(aVar);
                    SecretSettingActivity.this.gsF.bpR();
                    SecretSettingActivity.this.gsE.lS(true);
                    SecretSettingActivity.this.gsE.d(SecretSettingActivity.this.gsF);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gsF);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gsF.bpU());
                }
            }
        }
    };
    private CustomMessageListener gsQ = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gsF.st(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gsE.d(SecretSettingActivity.this.gsF);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gsE = new c(this);
        this.gsF = new a();
        this.gsE.a(this.gsO);
        if (this.gsF.bpP()) {
            this.gsE.lS(true);
            this.gsE.d(this.gsF);
            c(this.gsF);
        } else {
            this.gsE.lS(false);
        }
        this.gsE.lT(TbadkCoreApplication.getInst().getLocationShared());
        registerListener(this.mNetMessageListener);
        registerListener(this.gsP);
        registerListener(this.gsQ);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gsI = aVar.bpS();
        this.gsJ = aVar.bpQ();
        this.gsK = aVar.bpT();
        this.gsL = aVar.GI();
        this.gsM = aVar.bpV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gsE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gsE.bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(final String str, String str2) {
        if (this.gsG) {
            if ("group".equals(str)) {
                this.gsH = sA(this.gsK);
            } else if ("post".equals(str)) {
                this.gsH = sA(this.gsJ);
            } else if ("like".equals(str)) {
                this.gsH = sA(this.gsI);
            } else if ("live".equals(str)) {
                this.gsH = sB(this.gsL);
            } else if ("reply".equals(str)) {
                this.gsH = sC(this.gsM);
            }
            if (this.gsN != null) {
                this.gsN.dismiss();
            }
            this.gsN = new e(getPageContext());
            this.gsN.dD(str2);
            this.gsN.a(this.gsH, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gsH.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.aK(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.aK(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.aK(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.aK(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.aK(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.gsN.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gsK = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gsJ = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gsI = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gsL = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gsM = i2;
                    }
                }
            }).dD(str2);
            this.gsN.xe().xf();
        }
    }

    private ArrayList<g> sA(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sB(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sC(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.k.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.k.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(d.k.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpW() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpX() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gsN != null) {
            this.gsN.dismiss();
        }
    }
}
