package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0280a interfaceC0280a) {
        com.baidu.tbadk.core.a.d dVar = new com.baidu.tbadk.core.a.d();
        final a aVar = new a(str, str2, str3, interfaceC0280a, false);
        if (com.baidu.tbadk.core.a.d.isVerification() && StringUtils.isNull(str4)) {
            dVar.a(str2, new d.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.d.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.d.a
                public void onFailed() {
                    if (interfaceC0280a != null) {
                        interfaceC0280a.onFailure(str, 1, null);
                    }
                }
            });
        } else {
            if (com.baidu.tbadk.core.a.d.isVerification()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String hvM;
        private final a.InterfaceC0280a hvN;
        private final boolean hvO;
        private final String mName;
        private volatile x mNetwork = null;
        private final String mPtoken;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0280a interfaceC0280a, boolean z) {
            this.mName = str;
            this.hvM = str2;
            this.mPtoken = str3;
            this.hvO = z;
            this.hvN = interfaceC0280a == null ? new a.InterfaceC0280a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0280a
                public void onBeforeLogin(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0280a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0280a
                public void onFailure(String str4, int i, String str5) {
                }
            } : interfaceC0280a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hvN.onBeforeLogin(this.mName);
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
            this.mNetwork.amp().amP().mIsUseCurrentBDUSS = false;
            this.mNetwork.addPostData("bdusstoken", this.hvM + "|" + this.mPtoken);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.addPostData("stoken", this.mStoken);
            }
            this.mNetwork.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.amp().amP().mNeedBackgroundLogin = false;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.amp().amQ().isRequestSuccess() && postNetData != null) {
                ag agVar = new ag();
                agVar.parserJson(postNetData);
                AccountData accountData2 = new AccountData();
                accountData2.setAccount(agVar.getUser().getUserName());
                accountData2.setPassword("");
                accountData2.setID(agVar.getUser().getUserId());
                String str = this.hvM;
                if (this.hvO && (a = d.a(com.baidu.tbadk.core.a.a.agp().mJ(str))) != null) {
                    str = a.mBduss + "|" + a.mPtoken;
                }
                accountData2.setBDUSS(str);
                accountData2.setPortrait(agVar.getUser().getPortrait());
                accountData2.setStoken(this.mStoken);
                accountData2.setIsActive(1);
                if (agVar.getAnti() != null) {
                    accountData2.setTbs(agVar.getAnti().getTbs());
                }
                accountData = accountData2;
            } else {
                accountData = null;
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            xVar.amp().amP().mNeedBackgroundLogin = false;
            xVar.amp().amP().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                xVar.addPostData("BDUSS", accountData.getBDUSS());
                xVar.addPostData("stoken", com.baidu.tbadk.core.a.d.c(accountData));
            }
            String postNetData2 = xVar.postNetData();
            if (!xVar.amp().amQ().isRequestSuccess() || postNetData2 == null) {
                i = 0;
            } else {
                try {
                    jSONObject = new JSONObject(postNetData2);
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
            ReloginManager.alI().ej(false);
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "cslogin_result", this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.hvN.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.getServerErrorCode();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
            }
            this.hvN.onFailure(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
        }
    }
}
