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
    private c kUV;
    private a kUW;
    private ArrayList<m> kUY;
    private int kUZ;
    private int kVa;
    private int kVb;
    private int kVc;
    private int kVd;
    private e kVe;
    private boolean kUX = false;
    private c.a kVf = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXg() {
            SecretSettingActivity.this.cXe();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXh() {
            SecretSettingActivity.this.fi("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXi() {
            SecretSettingActivity.this.fi(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXj() {
            SecretSettingActivity.this.fi("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXk() {
            SecretSettingActivity.this.cXf();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXl() {
            SecretSettingActivity.this.fi("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cXm() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener kVg = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.kUW.bB(operation, type);
                        SecretSettingActivity.this.kUV.bD(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a dve = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.kUX = true;
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
                    SecretSettingActivity.this.kUW.b(aVar);
                    SecretSettingActivity.this.kUW.cWY();
                    SecretSettingActivity.this.kUV.tQ(true);
                    SecretSettingActivity.this.kUV.d(SecretSettingActivity.this.kUW);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.kUW);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.kUW.cXc());
                }
            }
        }
    };
    private CustomMessageListener kVh = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.kUW.CM(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.kUV.d(SecretSettingActivity.this.kUW);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kUV = new c(this);
        this.kUW = new a();
        this.kUV.a(this.kVf);
        if (this.kUW.cWW()) {
            this.kUV.tQ(true);
            this.kUV.d(this.kUW);
            c(this.kUW);
        } else {
            this.kUV.tQ(false);
        }
        registerListener(this.dve);
        registerListener(this.kVg);
        registerListener(this.kVh);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.kUZ = aVar.cWZ();
        this.kVa = aVar.cWX();
        this.kVb = aVar.cXb();
        this.kVc = aVar.cXa();
        this.kVd = aVar.cXd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kUV.onChangeSkinType(i);
        if (this.kVe != null) {
            this.kVe.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.kUV.cXn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(final String str, String str2) {
        if (this.kUX) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.kUY = CT(this.kVb);
            } else if ("post".equals(str)) {
                this.kUY = CT(this.kVa);
            } else if ("like".equals(str)) {
                this.kUY = CT(this.kUZ);
            } else if ("live".equals(str)) {
                this.kUY = CU(this.kVc);
            } else if ("reply".equals(str)) {
                this.kUY = CV(this.kVd);
            }
            if (this.kVe != null) {
                this.kVe.dismiss();
            }
            this.kVe = new e(getPageContext());
            this.kVe.vQ(str2);
            this.kVe.a(this.kUY, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.kUY.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bC(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bC(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bC(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bC(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bC(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.kVe.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.kVb = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.kVa = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.kUZ = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.kVc = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.kVd = i2;
                    }
                }
            }).vQ(str2);
            this.kVe.aSV().aSW();
        }
    }

    private ArrayList<m> CT(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> CU(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> CV(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXe() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXf() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kVe != null) {
            this.kVe.dismiss();
        }
    }
}
