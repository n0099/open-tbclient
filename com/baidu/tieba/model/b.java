package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0155a interfaceC0155a) {
        com.baidu.tbadk.core.a.d dVar = new com.baidu.tbadk.core.a.d();
        final a aVar = new a(str, str2, str3, interfaceC0155a, false);
        if (com.baidu.tbadk.core.a.d.xQ() && StringUtils.isNull(str4)) {
            dVar.a(str2, new d.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.d.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.d.a
                public void onFailed() {
                    if (interfaceC0155a != null) {
                        interfaceC0155a.b(str, 1, null);
                    }
                }
            });
        } else {
            if (com.baidu.tbadk.core.a.d.xQ()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String aop;
        private final String fGB;
        private final a.InterfaceC0155a fGC;
        private final boolean fGD;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0155a interfaceC0155a, boolean z) {
            this.mName = str;
            this.fGB = str2;
            this.aop = str3;
            this.fGD = z;
            this.fGC = interfaceC0155a == null ? new a.InterfaceC0155a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0155a
                public void ec(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0155a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0155a
                public void b(String str4, int i, String str5) {
                }
            } : interfaceC0155a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fGC.ec(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01b9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            AccountData accountData;
            int i;
            JSONException e;
            JSONObject jSONObject;
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.Dj().Eh().mIsUseCurrentBDUSS = false;
            this.mNetwork.x("bdusstoken", this.fGB + "|" + this.aop);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.x(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.Dj().Eh().aDr = false;
            String CL = this.mNetwork.CL();
            if (this.mNetwork.Dj().Ei().isRequestSuccess() && CL != null) {
                ae aeVar = new ae();
                aeVar.parserJson(CL);
                AccountData accountData2 = new AccountData();
                accountData2.setAccount(aeVar.getUser().getUserName());
                accountData2.setPassword("");
                accountData2.setID(aeVar.getUser().getUserId());
                String str = this.fGB;
                if (this.fGD && (a = d.a(com.baidu.tbadk.core.a.a.xJ().eb(str))) != null) {
                    str = a.El + "|" + a.aop;
                }
                accountData2.setBDUSS(str);
                accountData2.setPortrait(aeVar.getUser().getPortrait());
                accountData2.setStoken(this.mStoken);
                accountData2.setIsActive(1);
                if (aeVar.yE() != null) {
                    accountData2.setTbs(aeVar.yE().getTbs());
                }
                accountData = accountData2;
            } else {
                accountData = null;
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            xVar.Dj().Eh().aDr = false;
            xVar.Dj().Eh().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                xVar.x("BDUSS", accountData.getBDUSS());
                xVar.x(ISapiAccount.SAPI_ACCOUNT_STOKEN, com.baidu.tbadk.core.a.d.c(accountData));
            }
            String CL2 = xVar.CL();
            if (!xVar.Dj().Ei().isRequestSuccess() || CL2 == null) {
                i = 0;
            } else {
                try {
                    jSONObject = new JSONObject(CL2);
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
                    if (accountData != null && jSONObject2 != null) {
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
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.Ct().bp(false);
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "cslogin_result", this.mNetwork.Dn(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.fGC.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.Dn();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.data_load_error);
            }
            this.fGC.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
        }
    }
}
