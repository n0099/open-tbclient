package com.baidu.tieba.setting.im.more;

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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private a lNA;
    private ArrayList<m> lNC;
    private int lND;
    private int lNE;
    private int lNF;
    private int lNG;
    private int lNH;
    private e lNI;
    private c lNz;
    private boolean lNB = false;
    private c.a lNJ = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dpW() {
            SecretSettingActivity.this.dpU();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dpX() {
            SecretSettingActivity.this.fI("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dpY() {
            SecretSettingActivity.this.fI(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dpZ() {
            SecretSettingActivity.this.fI("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dqa() {
            SecretSettingActivity.this.dpV();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dqb() {
            SecretSettingActivity.this.fI("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dqc() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener lNK = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    SecretSettingActivity.this.showToast(R.string.success);
                    if (!TextUtils.equals("location", operation)) {
                        SecretSettingActivity.this.lNA.bD(operation, type);
                        SecretSettingActivity.this.lNz.bF(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a dOR = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.lNB = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
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
                    SecretSettingActivity.this.lNA.b(aVar);
                    SecretSettingActivity.this.lNA.dpO();
                    SecretSettingActivity.this.lNz.vy(true);
                    SecretSettingActivity.this.lNz.d(SecretSettingActivity.this.lNA);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.lNA);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.lNA.dpS());
                }
            }
        }
    };
    private CustomMessageListener lNL = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.lNA.GH(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.lNz.d(SecretSettingActivity.this.lNA);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lNz = new c(this);
        this.lNA = new a();
        this.lNz.a(this.lNJ);
        if (this.lNA.dpM()) {
            this.lNz.vy(true);
            this.lNz.d(this.lNA);
            c(this.lNA);
        } else {
            this.lNz.vy(false);
        }
        registerListener(this.dOR);
        registerListener(this.lNK);
        registerListener(this.lNL);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.lND = aVar.dpP();
        this.lNE = aVar.dpN();
        this.lNF = aVar.dpR();
        this.lNG = aVar.dpQ();
        this.lNH = aVar.dpT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lNz.onChangeSkinType(i);
        if (this.lNI != null) {
            this.lNI.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.lNz.dqd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(final String str, String str2) {
        if (this.lNB) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.lNC = GO(this.lNF);
            } else if ("post".equals(str)) {
                this.lNC = GO(this.lNE);
            } else if ("like".equals(str)) {
                this.lNC = GO(this.lND);
            } else if ("live".equals(str)) {
                this.lNC = GP(this.lNG);
            } else if ("reply".equals(str)) {
                this.lNC = GQ(this.lNH);
            }
            if (this.lNI != null) {
                this.lNI.dismiss();
            }
            this.lNI = new e(getPageContext());
            this.lNI.zB(str2);
            this.lNI.a(this.lNC, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.lNC.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.lNI.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.lNF = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.lNE = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.lND = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.lNG = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.lNH = i2;
                    }
                }
            }).zB(str2);
            this.lNI.bhj().bhk();
        }
    }

    private ArrayList<m> GO(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> GP(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> GQ(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpU() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpV() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lNI != null) {
            this.lNI.dismiss();
        }
    }
}
