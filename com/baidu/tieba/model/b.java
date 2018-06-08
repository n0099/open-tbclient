package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0100a interfaceC0100a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0100a, false);
        if (e.tH() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0100a != null) {
                        interfaceC0100a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.tH()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String acU;
        private final String fcH;
        private final a.InterfaceC0100a fcI;
        private final boolean fcJ;
        private final String mName;
        private volatile y mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0100a interfaceC0100a, boolean z) {
            this.mName = str;
            this.fcH = str2;
            this.acU = str3;
            this.fcJ = z;
            this.fcI = interfaceC0100a == null ? new a.InterfaceC0100a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0100a
                public void dc(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0100a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0100a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0100a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fcI.dc(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01b7  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            AccountData accountData;
            int i;
            JSONException e;
            JSONObject jSONObject;
            a.b a;
            this.mNetwork = new y(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.yJ().zI().mIsUseCurrentBDUSS = false;
            this.mNetwork.o("bdusstoken", this.fcH + "|" + this.acU);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.yJ().zI().arL = false;
            String yl = this.mNetwork.yl();
            if (this.mNetwork.yJ().zJ().isRequestSuccess() && yl != null) {
                af afVar = new af();
                afVar.parserJson(yl);
                AccountData accountData2 = new AccountData();
                accountData2.setAccount(afVar.getUser().getUserName());
                accountData2.setPassword("");
                accountData2.setID(afVar.getUser().getUserId());
                String str = this.fcH;
                if (this.fcJ && (a = d.a(com.baidu.tbadk.core.a.a.tA().db(str))) != null) {
                    str = a.Bg + "|" + a.acU;
                }
                accountData2.setBDUSS(str);
                accountData2.setPortrait(afVar.getUser().getPortrait());
                accountData2.setStoken(this.mStoken);
                accountData2.setIsActive(1);
                if (afVar.uo() != null) {
                    accountData2.setTbs(afVar.uo().getTbs());
                }
                accountData = accountData2;
            } else {
                accountData = null;
            }
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            yVar.yJ().zI().arL = false;
            yVar.yJ().zI().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                yVar.o("BDUSS", accountData.getBDUSS());
                yVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, e.c(accountData));
            }
            String yl2 = yVar.yl();
            if (!yVar.yJ().zJ().isRequestSuccess() || yl2 == null) {
                i = 0;
            } else {
                try {
                    jSONObject = new JSONObject(yl2);
                    JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && "check_user_name".equals(optJSONObject.optString("name"))) {
                                i = optJSONObject.optInt("type", 0);
                                break;
                            }
                        }
                    }
                    i = 0;
                } catch (JSONException e2) {
                    e = e2;
                    i = 0;
                }
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                    if (jSONObject2 != null) {
                        accountData.setNameShow(jSONObject2.optString("name_show"));
                    }
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
                    return accountData;
                }
            }
            TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
            return accountData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.xP().aE(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.yN(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.fcI.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.yN();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.data_load_error);
            }
            this.fcI.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
        }
    }
}
