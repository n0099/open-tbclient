package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.d;
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
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0101a interfaceC0101a) {
        com.baidu.tbadk.core.a.d dVar = new com.baidu.tbadk.core.a.d();
        final a aVar = new a(str, str2, str3, interfaceC0101a, false);
        if (com.baidu.tbadk.core.a.d.tH() && StringUtils.isNull(str4)) {
            dVar.a(str2, new d.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.d.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.d.a
                public void onFailed() {
                    if (interfaceC0101a != null) {
                        interfaceC0101a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (com.baidu.tbadk.core.a.d.tH()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String acX;
        private final boolean fgA;
        private final String fgy;
        private final a.InterfaceC0101a fgz;
        private final String mName;
        private volatile y mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0101a interfaceC0101a, boolean z) {
            this.mName = str;
            this.fgy = str2;
            this.acX = str3;
            this.fgA = z;
            this.fgz = interfaceC0101a == null ? new a.InterfaceC0101a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0101a
                public void de(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0101a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0101a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0101a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fgz.de(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01b9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
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
            this.mNetwork.yX().zX().mIsUseCurrentBDUSS = false;
            this.mNetwork.o("bdusstoken", this.fgy + "|" + this.acX);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.yX().zX().aso = false;
            String yz = this.mNetwork.yz();
            if (this.mNetwork.yX().zY().isRequestSuccess() && yz != null) {
                af afVar = new af();
                afVar.parserJson(yz);
                AccountData accountData2 = new AccountData();
                accountData2.setAccount(afVar.getUser().getUserName());
                accountData2.setPassword("");
                accountData2.setID(afVar.getUser().getUserId());
                String str = this.fgy;
                if (this.fgA && (a = d.a(com.baidu.tbadk.core.a.a.tA().dd(str))) != null) {
                    str = a.Bi + "|" + a.acX;
                }
                accountData2.setBDUSS(str);
                accountData2.setPortrait(afVar.getUser().getPortrait());
                accountData2.setStoken(this.mStoken);
                accountData2.setIsActive(1);
                if (afVar.uu() != null) {
                    accountData2.setTbs(afVar.uu().getTbs());
                }
                accountData = accountData2;
            } else {
                accountData = null;
            }
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            yVar.yX().zX().aso = false;
            yVar.yX().zX().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                yVar.o("BDUSS", accountData.getBDUSS());
                yVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, com.baidu.tbadk.core.a.d.c(accountData));
            }
            String yz2 = yVar.yz();
            if (!yVar.yX().zY().isRequestSuccess() || yz2 == null) {
                i = 0;
            } else {
                try {
                    jSONObject = new JSONObject(yz2);
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
            ReloginManager.yc().aG(false);
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "cslogin_result", this.mNetwork.zb(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.fgz.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.zb();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.data_load_error);
            }
            this.fgz.c(this.mName, i, str);
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
