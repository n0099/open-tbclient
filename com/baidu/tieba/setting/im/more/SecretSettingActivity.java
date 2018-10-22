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
    private int gMA;
    private int gMB;
    private int gMC;
    private int gMD;
    private int gME;
    private e gMF;
    private c gMw;
    private a gMx;
    private ArrayList<g> gMz;
    private boolean gMy = false;
    private c.a gMG = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void buZ() {
            SecretSettingActivity.this.buX();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bva() {
            SecretSettingActivity.this.cy("like", SecretSettingActivity.this.getPageContext().getString(e.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bvb() {
            SecretSettingActivity.this.cy("group", SecretSettingActivity.this.getPageContext().getString(e.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bvc() {
            SecretSettingActivity.this.cy("live", SecretSettingActivity.this.getPageContext().getString(e.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bvd() {
            SecretSettingActivity.this.buY();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bve() {
            SecretSettingActivity.this.cy("reply", SecretSettingActivity.this.getPageContext().getString(e.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bvf() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener gMH = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.gMx.aP(operation, type);
                        SecretSettingActivity.this.gMw.aR(operation, type);
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
                SecretSettingActivity.this.gMy = true;
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
                    SecretSettingActivity.this.gMx.b(aVar);
                    SecretSettingActivity.this.gMx.buS();
                    SecretSettingActivity.this.gMw.mE(true);
                    SecretSettingActivity.this.gMw.d(SecretSettingActivity.this.gMx);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gMx);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gMx.buV());
                }
            }
        }
    };
    private CustomMessageListener gMI = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gMx.tw(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gMw.d(SecretSettingActivity.this.gMx);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gMw = new c(this);
        this.gMx = new a();
        this.gMw.a(this.gMG);
        if (this.gMx.buQ()) {
            this.gMw.mE(true);
            this.gMw.d(this.gMx);
            c(this.gMx);
        } else {
            this.gMw.mE(false);
        }
        registerListener(this.mNetMessageListener);
        registerListener(this.gMH);
        registerListener(this.gMI);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gMA = aVar.buT();
        this.gMB = aVar.buR();
        this.gMC = aVar.buU();
        this.gMD = aVar.Kl();
        this.gME = aVar.buW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gMw.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gMw.bvg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(final String str, String str2) {
        if (this.gMy) {
            if ("group".equals(str)) {
                this.gMz = tD(this.gMC);
            } else if ("post".equals(str)) {
                this.gMz = tD(this.gMB);
            } else if ("like".equals(str)) {
                this.gMz = tD(this.gMA);
            } else if ("live".equals(str)) {
                this.gMz = tE(this.gMD);
            } else if ("reply".equals(str)) {
                this.gMz = tF(this.gME);
            }
            if (this.gMF != null) {
                this.gMF.dismiss();
            }
            this.gMF = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.gMF.el(str2);
            this.gMF.a(this.gMz, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gMz.get(i)).getTag();
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
                    SecretSettingActivity.this.gMF.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gMC = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gMB = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gMA = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gMD = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gME = i2;
                    }
                }
            }).el(str2);
            this.gMF.Ay().Az();
        }
    }

    private ArrayList<g> tD(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> tE(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> tF(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(e.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(e.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(e.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buX() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buY() {
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
        if (this.gMF != null) {
            this.gMF.dismiss();
        }
    }
}
