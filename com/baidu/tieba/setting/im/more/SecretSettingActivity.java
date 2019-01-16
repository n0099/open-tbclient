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
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c gYK;
    private a gYL;
    private ArrayList<g> gYN;
    private int gYO;
    private int gYP;
    private int gYQ;
    private int gYR;
    private int gYS;
    private e gYT;
    private boolean gYM = false;
    private c.a gYU = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxK() {
            SecretSettingActivity.this.bxI();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxL() {
            SecretSettingActivity.this.cE("like", SecretSettingActivity.this.getPageContext().getString(e.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxM() {
            SecretSettingActivity.this.cE("group", SecretSettingActivity.this.getPageContext().getString(e.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxN() {
            SecretSettingActivity.this.cE("live", SecretSettingActivity.this.getPageContext().getString(e.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxO() {
            SecretSettingActivity.this.bxJ();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxP() {
            SecretSettingActivity.this.cE("reply", SecretSettingActivity.this.getPageContext().getString(e.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bxQ() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener gYV = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    SecretSettingActivity.this.showToast(e.j.success);
                    if (!TextUtils.equals(Headers.LOCATION, operation)) {
                        SecretSettingActivity.this.gYL.aR(operation, type);
                        SecretSettingActivity.this.gYK.aT(operation, type);
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
                SecretSettingActivity.this.gYM = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
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
                    SecretSettingActivity.this.gYL.b(aVar);
                    SecretSettingActivity.this.gYL.bxD();
                    SecretSettingActivity.this.gYK.mW(true);
                    SecretSettingActivity.this.gYK.d(SecretSettingActivity.this.gYL);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gYL);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gYL.bxG());
                }
            }
        }
    };
    private CustomMessageListener gYW = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gYL.uz(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gYK.d(SecretSettingActivity.this.gYL);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gYK = new c(this);
        this.gYL = new a();
        this.gYK.a(this.gYU);
        if (this.gYL.bxB()) {
            this.gYK.mW(true);
            this.gYK.d(this.gYL);
            c(this.gYL);
        } else {
            this.gYK.mW(false);
        }
        registerListener(this.mNetMessageListener);
        registerListener(this.gYV);
        registerListener(this.gYW);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gYO = aVar.bxE();
        this.gYP = aVar.bxC();
        this.gYQ = aVar.bxF();
        this.gYR = aVar.LR();
        this.gYS = aVar.bxH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gYK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gYK.bxR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(final String str, String str2) {
        if (this.gYM) {
            if ("group".equals(str)) {
                this.gYN = uG(this.gYQ);
            } else if ("post".equals(str)) {
                this.gYN = uG(this.gYP);
            } else if ("like".equals(str)) {
                this.gYN = uG(this.gYO);
            } else if ("live".equals(str)) {
                this.gYN = uH(this.gYR);
            } else if ("reply".equals(str)) {
                this.gYN = uI(this.gYS);
            }
            if (this.gYT != null) {
                this.gYT.dismiss();
            }
            this.gYT = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.gYT.eM(str2);
            this.gYT.a(this.gYN, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gYN.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.aS(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.aS(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.aS(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.aS(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.aS(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.gYT.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gYQ = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gYP = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gYO = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gYR = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gYS = i2;
                    }
                }
            }).eM(str2);
            this.gYT.BW().BX();
        }
    }

    private ArrayList<g> uG(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> uH(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> uI(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(e.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxI() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxJ() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gYT != null) {
            this.gYT.dismiss();
        }
    }
}
