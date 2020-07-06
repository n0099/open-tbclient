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
/* loaded from: classes13.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c loS;
    private a loT;
    private ArrayList<m> loV;
    private int loW;
    private int loX;
    private int loY;
    private int loZ;
    private int lpa;
    private e lpb;
    private boolean loU = false;
    private c.a lpc = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dbw() {
            SecretSettingActivity.this.dbu();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dbx() {
            SecretSettingActivity.this.fp("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dby() {
            SecretSettingActivity.this.fp(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dbz() {
            SecretSettingActivity.this.fp("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dbA() {
            SecretSettingActivity.this.dbv();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dbB() {
            SecretSettingActivity.this.fp("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dbC() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener lpd = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.loT.bA(operation, type);
                        SecretSettingActivity.this.loS.bC(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a dzN = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.loU = true;
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
                    SecretSettingActivity.this.loT.b(aVar);
                    SecretSettingActivity.this.loT.dbo();
                    SecretSettingActivity.this.loS.uf(true);
                    SecretSettingActivity.this.loS.d(SecretSettingActivity.this.loT);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.loT);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.loT.dbs());
                }
            }
        }
    };
    private CustomMessageListener lpe = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.loT.DO(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.loS.d(SecretSettingActivity.this.loT);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.loS = new c(this);
        this.loT = new a();
        this.loS.a(this.lpc);
        if (this.loT.dbm()) {
            this.loS.uf(true);
            this.loS.d(this.loT);
            c(this.loT);
        } else {
            this.loS.uf(false);
        }
        registerListener(this.dzN);
        registerListener(this.lpd);
        registerListener(this.lpe);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.loW = aVar.dbp();
        this.loX = aVar.dbn();
        this.loY = aVar.dbr();
        this.loZ = aVar.dbq();
        this.lpa = aVar.dbt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.loS.onChangeSkinType(i);
        if (this.lpb != null) {
            this.lpb.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.loS.dbD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(final String str, String str2) {
        if (this.loU) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.loV = DV(this.loY);
            } else if ("post".equals(str)) {
                this.loV = DV(this.loX);
            } else if ("like".equals(str)) {
                this.loV = DV(this.loW);
            } else if ("live".equals(str)) {
                this.loV = DW(this.loZ);
            } else if ("reply".equals(str)) {
                this.loV = DX(this.lpa);
            }
            if (this.lpb != null) {
                this.lpb.dismiss();
            }
            this.lpb = new e(getPageContext());
            this.lpb.wg(str2);
            this.lpb.a(this.loV, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.loV.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bB(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bB(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bB(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bB(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bB(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.lpb.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.loY = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.loX = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.loW = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.loZ = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.lpa = i2;
                    }
                }
            }).wg(str2);
            this.lpb.aUP().aUQ();
        }
    }

    private ArrayList<m> DV(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> DW(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> DX(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbu() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbv() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lpb != null) {
            this.lpb.dismiss();
        }
    }
}
