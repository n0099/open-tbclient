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
    private int gwA;
    private int gwB;
    private int gwC;
    private int gwD;
    private e gwE;
    private c gwv;
    private a gww;
    private ArrayList<g> gwy;
    private int gwz;
    private boolean gwx = false;
    private c.a gwF = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqz() {
            SecretSettingActivity.this.bqx();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqA() {
            SecretSettingActivity.this.cg("like", SecretSettingActivity.this.getPageContext().getString(d.k.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqB() {
            SecretSettingActivity.this.cg("group", SecretSettingActivity.this.getPageContext().getString(d.k.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqC() {
            SecretSettingActivity.this.cg("live", SecretSettingActivity.this.getPageContext().getString(d.k.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqD() {
            SecretSettingActivity.this.bqy();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void a(BdSwitchView.SwitchState switchState) {
            SecretSettingActivity.this.aL(Headers.LOCATION, BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
            SecretSettingActivity.this.showProgressBar();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bqE() {
            SecretSettingActivity.this.cg("reply", SecretSettingActivity.this.getPageContext().getString(d.k.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void b(BdSwitchView.SwitchState switchState) {
            boolean z = BdSwitchView.SwitchState.ON == switchState;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
        }
    };
    private HttpMessageListener gwG = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                            final boolean bqG = SecretSettingActivity.this.gwv.bqG();
                            SecretSettingActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SecretSettingActivity.this.gwv.md(!bqG);
                                }
                            }, 500L);
                            return;
                        }
                        return;
                    }
                    SecretSettingActivity.this.showToast(d.k.success);
                    if (TextUtils.equals(Headers.LOCATION, operation)) {
                        TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gwv.bqG());
                        SecretSettingActivity.this.gwv.md(TbadkCoreApplication.getInst().getLocationShared());
                        return;
                    }
                    SecretSettingActivity.this.gww.aK(operation, type);
                    SecretSettingActivity.this.gwv.aM(operation, type);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.gwx = true;
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
                    SecretSettingActivity.this.gww.b(aVar);
                    SecretSettingActivity.this.gww.bqs();
                    SecretSettingActivity.this.gwv.mc(true);
                    SecretSettingActivity.this.gwv.d(SecretSettingActivity.this.gww);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gww);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gww.bqv());
                }
            }
        }
    };
    private CustomMessageListener gwH = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gww.sD(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gwv.d(SecretSettingActivity.this.gww);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwv = new c(this);
        this.gww = new a();
        this.gwv.a(this.gwF);
        if (this.gww.bqq()) {
            this.gwv.mc(true);
            this.gwv.d(this.gww);
            c(this.gww);
        } else {
            this.gwv.mc(false);
        }
        this.gwv.md(TbadkCoreApplication.getInst().getLocationShared());
        registerListener(this.mNetMessageListener);
        registerListener(this.gwG);
        registerListener(this.gwH);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gwz = aVar.bqt();
        this.gwA = aVar.bqr();
        this.gwB = aVar.bqu();
        this.gwC = aVar.Ha();
        this.gwD = aVar.bqw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gwv.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gwv.bqF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(final String str, String str2) {
        if (this.gwx) {
            if ("group".equals(str)) {
                this.gwy = sK(this.gwB);
            } else if ("post".equals(str)) {
                this.gwy = sK(this.gwA);
            } else if ("like".equals(str)) {
                this.gwy = sK(this.gwz);
            } else if ("live".equals(str)) {
                this.gwy = sL(this.gwC);
            } else if ("reply".equals(str)) {
                this.gwy = sM(this.gwD);
            }
            if (this.gwE != null) {
                this.gwE.dismiss();
            }
            this.gwE = new e(getPageContext());
            this.gwE.dG(str2);
            this.gwE.a(this.gwy, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gwy.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.aL(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.aL(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.aL(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.aL(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.aL(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.gwE.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gwB = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gwA = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gwz = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gwC = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gwD = i2;
                    }
                }
            }).dG(str2);
            this.gwE.xr().xs();
        }
    }

    private ArrayList<g> sK(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sL(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.k.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sM(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(d.k.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(d.k.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(d.k.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqx() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqy() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gwE != null) {
            this.gwE.dismiss();
        }
    }
}
