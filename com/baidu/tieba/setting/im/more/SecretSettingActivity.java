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
    private c iqA;
    private a iqB;
    private ArrayList<k> iqD;
    private int iqE;
    private int iqF;
    private int iqG;
    private int iqH;
    private int iqI;
    private e iqJ;
    private boolean iqC = false;
    private c.a iqK = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYy() {
            SecretSettingActivity.this.bYw();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYz() {
            SecretSettingActivity.this.dO("like", SecretSettingActivity.this.getPageContext().getString(d.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYA() {
            SecretSettingActivity.this.dO("group", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYB() {
            SecretSettingActivity.this.dO("live", SecretSettingActivity.this.getPageContext().getString(d.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYC() {
            SecretSettingActivity.this.bYx();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYD() {
            SecretSettingActivity.this.dO("reply", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bYE() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener iqL = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.iqB.bn(operation, type);
                        SecretSettingActivity.this.iqA.bp(operation, type);
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
                SecretSettingActivity.this.iqC = true;
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
                    SecretSettingActivity.this.iqB.b(aVar);
                    SecretSettingActivity.this.iqB.bYr();
                    SecretSettingActivity.this.iqA.pv(true);
                    SecretSettingActivity.this.iqA.d(SecretSettingActivity.this.iqB);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.iqB);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.iqB.bYu());
                }
            }
        }
    };
    private CustomMessageListener iqM = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.iqB.yo(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.iqA.d(SecretSettingActivity.this.iqB);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iqA = new c(this);
        this.iqB = new a();
        this.iqA.a(this.iqK);
        if (this.iqB.bYp()) {
            this.iqA.pv(true);
            this.iqA.d(this.iqB);
            c(this.iqB);
        } else {
            this.iqA.pv(false);
        }
        registerListener(this.mNetMessageListener);
        registerListener(this.iqL);
        registerListener(this.iqM);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.iqE = aVar.bYs();
        this.iqF = aVar.bYq();
        this.iqG = aVar.bYt();
        this.iqH = aVar.alt();
        this.iqI = aVar.bYv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iqA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.iqA.bYF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(final String str, String str2) {
        if (this.iqC) {
            if ("group".equals(str)) {
                this.iqD = yv(this.iqG);
            } else if ("post".equals(str)) {
                this.iqD = yv(this.iqF);
            } else if ("like".equals(str)) {
                this.iqD = yv(this.iqE);
            } else if ("live".equals(str)) {
                this.iqD = yw(this.iqH);
            } else if ("reply".equals(str)) {
                this.iqD = yx(this.iqI);
            }
            if (this.iqJ != null) {
                this.iqJ.dismiss();
            }
            this.iqJ = new e(getPageContext());
            this.iqJ.lA(str2);
            this.iqJ.a(this.iqD, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((k) SecretSettingActivity.this.iqD.get(i)).getTag();
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
                    SecretSettingActivity.this.iqJ.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.iqG = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.iqF = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.iqE = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.iqH = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.iqI = i2;
                    }
                }
            }).lA(str2);
            this.iqJ.abd().abe();
        }
    }

    private ArrayList<k> yv(int i) {
        ArrayList<k> arrayList = new ArrayList<>();
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<k> yw(int i) {
        ArrayList<k> arrayList = new ArrayList<>();
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new k(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<k> yx(int i) {
        ArrayList<k> arrayList = new ArrayList<>();
        arrayList.add(new k(getPageContext().getString(d.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new k(getPageContext().getString(d.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new k(getPageContext().getString(d.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYw() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYx() {
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
        if (this.iqJ != null) {
            this.iqJ.dismiss();
        }
    }
}
