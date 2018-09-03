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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0098a interfaceC0098a) {
        com.baidu.tbadk.core.a.d dVar = new com.baidu.tbadk.core.a.d();
        final a aVar = new a(str, str2, str3, interfaceC0098a, false);
        if (com.baidu.tbadk.core.a.d.ts() && StringUtils.isNull(str4)) {
            dVar.a(str2, new d.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.d.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.d.a
                public void onFailed() {
                    if (interfaceC0098a != null) {
                        interfaceC0098a.b(str, 1, null);
                    }
                }
            });
        } else {
            if (com.baidu.tbadk.core.a.d.ts()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String acC;
        private final String fgA;
        private final a.InterfaceC0098a fgB;
        private final boolean fgC;
        private final String mName;
        private volatile y mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0098a interfaceC0098a, boolean z) {
            this.mName = str;
            this.fgA = str2;
            this.acC = str3;
            this.fgC = z;
            this.fgB = interfaceC0098a == null ? new a.InterfaceC0098a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
                public void dc(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
                public void b(String str4, int i, String str5) {
                }
            } : interfaceC0098a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fgB.dc(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01b9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
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
            this.mNetwork.yM().zK().mIsUseCurrentBDUSS = false;
            this.mNetwork.o("bdusstoken", this.fgA + "|" + this.acC);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.yM().zK().arS = false;
            String yo = this.mNetwork.yo();
            if (this.mNetwork.yM().zL().isRequestSuccess() && yo != null) {
                ae aeVar = new ae();
                aeVar.parserJson(yo);
                AccountData accountData2 = new AccountData();
                accountData2.setAccount(aeVar.getUser().getUserName());
                accountData2.setPassword("");
                accountData2.setID(aeVar.getUser().getUserId());
                String str = this.fgA;
                if (this.fgC && (a = d.a(com.baidu.tbadk.core.a.a.tk().db(str))) != null) {
                    str = a.Be + "|" + a.acC;
                }
                accountData2.setBDUSS(str);
                accountData2.setPortrait(aeVar.getUser().getPortrait());
                accountData2.setStoken(this.mStoken);
                accountData2.setIsActive(1);
                if (aeVar.ug() != null) {
                    accountData2.setTbs(aeVar.ug().getTbs());
                }
                accountData = accountData2;
            } else {
                accountData = null;
            }
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            yVar.yM().zK().arS = false;
            yVar.yM().zK().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                yVar.o("BDUSS", accountData.getBDUSS());
                yVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, com.baidu.tbadk.core.a.d.c(accountData));
            }
            String yo2 = yVar.yo();
            if (!yVar.yM().zL().isRequestSuccess() || yo2 == null) {
                i = 0;
            } else {
                try {
                    jSONObject = new JSONObject(yo2);
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
            ReloginManager.xT().aF(false);
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "cslogin_result", this.mNetwork.yQ(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.fgB.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.yQ();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(f.j.data_load_error);
            }
            this.fgB.b(this.mName, i, str);
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
