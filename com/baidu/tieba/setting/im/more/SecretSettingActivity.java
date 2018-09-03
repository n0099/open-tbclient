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
import com.baidu.tieba.f;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c gxG;
    private a gxH;
    private ArrayList<g> gxJ;
    private int gxK;
    private int gxL;
    private int gxM;
    private int gxN;
    private int gxO;
    private e gxP;
    private boolean gxI = false;
    private c.a gxQ = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpd() {
            SecretSettingActivity.this.bpb();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpe() {
            SecretSettingActivity.this.cd("like", SecretSettingActivity.this.getPageContext().getString(f.j.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpf() {
            SecretSettingActivity.this.cd("group", SecretSettingActivity.this.getPageContext().getString(f.j.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpg() {
            SecretSettingActivity.this.cd("live", SecretSettingActivity.this.getPageContext().getString(f.j.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bph() {
            SecretSettingActivity.this.bpc();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void a(BdSwitchView.SwitchState switchState) {
            SecretSettingActivity.this.aH(Headers.LOCATION, BdSwitchView.SwitchState.ON == switchState ? 1 : 3);
            SecretSettingActivity.this.showProgressBar();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void bpi() {
            SecretSettingActivity.this.cd("reply", SecretSettingActivity.this.getPageContext().getString(f.j.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void b(BdSwitchView.SwitchState switchState) {
            boolean z = BdSwitchView.SwitchState.ON == switchState;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
        }
    };
    private HttpMessageListener gxR = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
                        if (TextUtils.equals(Headers.LOCATION, operation)) {
                            final boolean bpk = SecretSettingActivity.this.gxG.bpk();
                            SecretSettingActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SecretSettingActivity.this.gxG.lO(!bpk);
                                }
                            }, 500L);
                            return;
                        }
                        return;
                    }
                    SecretSettingActivity.this.showToast(f.j.success);
                    if (TextUtils.equals(Headers.LOCATION, operation)) {
                        TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gxG.bpk());
                        SecretSettingActivity.this.gxG.lO(TbadkCoreApplication.getInst().getLocationShared());
                        return;
                    }
                    SecretSettingActivity.this.gxH.aG(operation, type);
                    SecretSettingActivity.this.gxG.aI(operation, type);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.gxI = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(f.j.neterror) : responsedMessage.getErrorString());
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
                    SecretSettingActivity.this.gxH.b(aVar);
                    SecretSettingActivity.this.gxH.boW();
                    SecretSettingActivity.this.gxG.lN(true);
                    SecretSettingActivity.this.gxG.d(SecretSettingActivity.this.gxH);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.gxH);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.gxH.boZ());
                }
            }
        }
    };
    private CustomMessageListener gxS = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.gxH.sB(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.gxG.d(SecretSettingActivity.this.gxH);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxG = new c(this);
        this.gxH = new a();
        this.gxG.a(this.gxQ);
        if (this.gxH.boU()) {
            this.gxG.lN(true);
            this.gxG.d(this.gxH);
            c(this.gxH);
        } else {
            this.gxG.lN(false);
        }
        this.gxG.lO(TbadkCoreApplication.getInst().getLocationShared());
        registerListener(this.mNetMessageListener);
        registerListener(this.gxR);
        registerListener(this.gxS);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.gxK = aVar.boX();
        this.gxL = aVar.boV();
        this.gxM = aVar.boY();
        this.gxN = aVar.GW();
        this.gxO = aVar.bpa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxG.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.gxG.bpj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(final String str, String str2) {
        if (this.gxI) {
            if ("group".equals(str)) {
                this.gxJ = sI(this.gxM);
            } else if ("post".equals(str)) {
                this.gxJ = sI(this.gxL);
            } else if ("like".equals(str)) {
                this.gxJ = sI(this.gxK);
            } else if ("live".equals(str)) {
                this.gxJ = sJ(this.gxN);
            } else if ("reply".equals(str)) {
                this.gxJ = sK(this.gxO);
            }
            if (this.gxP != null) {
                this.gxP.dismiss();
            }
            this.gxP = new e(getPageContext());
            this.gxP.dD(str2);
            this.gxP.a(this.gxJ, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((g) SecretSettingActivity.this.gxJ.get(i)).getTag();
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
                    SecretSettingActivity.this.gxP.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.gxM = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.gxL = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.gxK = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.gxN = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.gxO = i2;
                    }
                }
            }).dD(str2);
            this.gxP.xi().xj();
        }
    }

    private ArrayList<g> sI(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(f.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(f.j.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new g(getPageContext().getString(f.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sJ(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(f.j.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(f.j.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<g> sK(int i) {
        ArrayList<g> arrayList = new ArrayList<>();
        arrayList.add(new g(getPageContext().getString(f.j.all_person), "", i == 1, "showAll"));
        arrayList.add(new g(getPageContext().getString(f.j.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new g(getPageContext().getString(f.j.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpb() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpc() {
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
        if (this.gxP != null) {
            this.gxP.dismiss();
        }
    }
}
