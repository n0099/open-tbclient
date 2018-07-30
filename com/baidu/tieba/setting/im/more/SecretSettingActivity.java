package com.baidu.tieba.setting.im.more;

import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
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
    private c gxD;
    private a gxE;
    private ArrayList<g> gxG;
    private int gxH;
    private int gxI;
    private int gxJ;
    private int gxK;
    private int gxL;
    private e gxM;
    private boolean gxF = false;
    private c.a gxN = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpc() {
            SecretSettingActivity.this.bpa();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpd() {
            SecretSettingActivity.this.cd("like", SecretSettingActivity.this.getPageContext().getString(d.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpe() {
            SecretSettingActivity.this.cd("group", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpf() {
            SecretSettingActivity.this.cd("live", SecretSettingActivity.this.getPageContext().getString(d.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpg() {
            SecretSettingActivity.this.bpb();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void a(BdSwitchView.SwitchState switchState) {
            SecretSettingActivity.this.aH(Headers.LOCATION, BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
            SecretSettingActivity.this.showProgressBar();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bph() {
            SecretSettingActivity.this.cd("reply", SecretSettingActivity.this.getPageContext().getString(d.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void b(BdSwitchView.SwitchState switchState) {
            boolean z = BdSwitchView.SwitchState.ON == switchState;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
        }
    };
    private HttpMessageListener gxO = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                            final boolean bpj = SecretSettingActivity.this.gxD.bpj();
                            SecretSettingActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SecretSettingActivity.this.gxD.lO(!bpj);
                                }
                            }, 500L);
                            return;
                        }
                        return;
                    }
                    SecretSettingActivity.this.showToast(d.j.success);
                    if (TextUtils.equals(Headers.LOCATION, operation)) {
                        TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gxD.bpj());
                        SecretSettingActivity.this.gxD.lO(TbadkCoreApplication.getInst().getLocationShared());
                        return;
                    }
                    SecretSettingActivity.this.gxE.aG(operation, type);
                    SecretSettingActivity.this.gxD.aI(operation, type);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.gxF = true;
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
                    SecretSettingActivity.this.gxE.b(aVar);
                    SecretSettingActivity.this.gxE.boV();
                    SecretSettingActivity.this.gxD.lN(true);
                    SecretSettingActivity.this.gxD.d(SecretSettingActivity.this.gxE);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gxE);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gxE.boY());
                }
            }
        }
    };
    private CustomMessageListener gxP = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gxE.sB(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gxD.d(SecretSettingActivity.this.gxE);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxD = new c(this);
        this.gxE = new a();
        this.gxD.a(this.gxN);
        if (this.gxE.boT()) {
            this.gxD.lN(true);
            this.gxD.d(this.gxE);
            c(this.gxE);
        } else {
            this.gxD.lN(false);
        }
        this.gxD.lO(TbadkCoreApplication.getInst().getLocationShared());
        registerListener(this.mNetMessageListener);
        registerListener(this.gxO);
        registerListener(this.gxP);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gxH = aVar.boW();
        this.gxI = aVar.boU();
        this.gxJ = aVar.boX();
        this.gxK = aVar.GW();
        this.gxL = aVar.boZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gxD.bpi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(final String str, String str2) {
        if (this.gxF) {
            if ("group".equals(str)) {
                this.gxG = sI(this.gxJ);
            } else if ("post".equals(str)) {
                this.gxG = sI(this.gxI);
            } else if ("like".equals(str)) {
                this.gxG = sI(this.gxH);
            } else if ("live".equals(str)) {
                this.gxG = sJ(this.gxK);
            } else if ("reply".equals(str)) {
                this.gxG = sK(this.gxL);
            }
            if (this.gxM != null) {
                this.gxM.dismiss();
            }
            this.gxM = new e(getPageContext());
            this.gxM.dD(str2);
            this.gxM.a(this.gxG, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gxG.get(i)).getTag();
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
                    SecretSettingActivity.this.gxM.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gxJ = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gxI = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gxH = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gxK = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gxL = i2;
                    }
                }
            }).dD(str2);
            this.gxM.xj().xk();
        }
    }

    private ArrayList<g> sI(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sJ(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sK(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(d.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpa() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpb() {
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
        if (this.gxM != null) {
            this.gxM.dismiss();
        }
    }
}
