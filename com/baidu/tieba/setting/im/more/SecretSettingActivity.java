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
    private c gNV;
    private a gNW;
    private ArrayList<g> gNY;
    private int gNZ;
    private int gOa;
    private int gOb;
    private int gOc;
    private int gOd;
    private e gOe;
    private boolean gNX = false;
    private c.a gOf = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buv() {
            SecretSettingActivity.this.but();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buw() {
            SecretSettingActivity.this.cy("like", SecretSettingActivity.this.getPageContext().getString(e.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bux() {
            SecretSettingActivity.this.cy("group", SecretSettingActivity.this.getPageContext().getString(e.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buy() {
            SecretSettingActivity.this.cy("live", SecretSettingActivity.this.getPageContext().getString(e.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buz() {
            SecretSettingActivity.this.buu();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buA() {
            SecretSettingActivity.this.cy("reply", SecretSettingActivity.this.getPageContext().getString(e.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buB() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener gOg = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.gNW.aP(operation, type);
                        SecretSettingActivity.this.gNV.aR(operation, type);
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
                SecretSettingActivity.this.gNX = true;
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
                    SecretSettingActivity.this.gNW.b(aVar);
                    SecretSettingActivity.this.gNW.buo();
                    SecretSettingActivity.this.gNV.mP(true);
                    SecretSettingActivity.this.gNV.d(SecretSettingActivity.this.gNW);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gNW);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gNW.bur());
                }
            }
        }
    };
    private CustomMessageListener gOh = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gNW.tP(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gNV.d(SecretSettingActivity.this.gNW);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNV = new c(this);
        this.gNW = new a();
        this.gNV.a(this.gOf);
        if (this.gNW.bum()) {
            this.gNV.mP(true);
            this.gNV.d(this.gNW);
            c(this.gNW);
        } else {
            this.gNV.mP(false);
        }
        registerListener(this.mNetMessageListener);
        registerListener(this.gOg);
        registerListener(this.gOh);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gNZ = aVar.bup();
        this.gOa = aVar.bun();
        this.gOb = aVar.buq();
        this.gOc = aVar.Kx();
        this.gOd = aVar.bus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNV.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gNV.buC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(final String str, String str2) {
        if (this.gNX) {
            if ("group".equals(str)) {
                this.gNY = tW(this.gOb);
            } else if ("post".equals(str)) {
                this.gNY = tW(this.gOa);
            } else if ("like".equals(str)) {
                this.gNY = tW(this.gNZ);
            } else if ("live".equals(str)) {
                this.gNY = tX(this.gOc);
            } else if ("reply".equals(str)) {
                this.gNY = tY(this.gOd);
            }
            if (this.gOe != null) {
                this.gOe.dismiss();
            }
            this.gOe = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.gOe.el(str2);
            this.gOe.a(this.gNY, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gNY.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.aQ(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.aQ(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.aQ(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.aQ(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.aQ(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.gOe.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gOb = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gOa = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gNZ = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gOc = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gOd = i2;
                    }
                }
            }).el(str2);
            this.gOe.AF().AG();
        }
    }

    private ArrayList<g> tW(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> tX(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> tY(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(e.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void but() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buu() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gOe != null) {
            this.gOe.dismiss();
        }
    }
}
