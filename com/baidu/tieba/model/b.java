package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.switchs.CheckShowNameDialogSwitch;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0558a interfaceC0558a) {
        com.baidu.tbadk.core.a.d dVar = new com.baidu.tbadk.core.a.d();
        final a aVar = new a(str, str2, str3, interfaceC0558a, false);
        if (com.baidu.tbadk.core.a.d.isVerification() && StringUtils.isNull(str4)) {
            dVar.a(str2, new d.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.d.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.d.a
                public void onFailed() {
                    if (interfaceC0558a != null) {
                        interfaceC0558a.onFailure(str, 1, null);
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
        private final String llM;
        private final a.InterfaceC0558a llN;
        private final boolean llO;
        private final String mName;
        private volatile z mNetwork = null;
        private final String mPtoken;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0558a interfaceC0558a, boolean z) {
            this.mName = str;
            this.llM = str2;
            this.mPtoken = str3;
            this.llO = z;
            this.llN = interfaceC0558a == null ? new a.InterfaceC0558a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
                public void onBeforeLogin(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
                public void onFailure(String str4, int i, String str5) {
                }
            } : interfaceC0558a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.llN.onBeforeLogin(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01e6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: V */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            AccountData accountData;
            int i;
            JSONObject jSONObject;
            a.b a2;
            this.mNetwork = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.brX().bsG().mIsUseCurrentBDUSS = false;
            this.mNetwork.addPostData("bdusstoken", this.llM + "|" + this.mPtoken);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.addPostData("stoken", this.mStoken);
            }
            this.mNetwork.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.brX().bsG().mNeedBackgroundLogin = false;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.brX().bsH().isRequestSuccess() && postNetData != null) {
                ap apVar = new ap();
                apVar.parserJson(postNetData);
                AccountData accountData2 = new AccountData();
                accountData2.setAccount(apVar.getUser().getUserName());
                accountData2.setPassword("");
                accountData2.setID(apVar.getUser().getUserId());
                String str = this.llM;
                if (this.llO && (a2 = e.a(com.baidu.tbadk.core.a.a.bkC().zq(str))) != null) {
                    str = a2.mBduss + "|" + a2.mPtoken;
                }
                accountData2.setBDUSS(str);
                accountData2.setPortrait(apVar.getUser().getPortrait());
                if (apVar.getUser() != null && apVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(apVar.getUser().getBaijiahaoInfo().avatar)) {
                    accountData2.setBjhAvatar(apVar.getUser().getBaijiahaoInfo().avatar);
                }
                accountData2.setStoken(this.mStoken);
                accountData2.setIsActive(1);
                if (apVar.getAnti() != null) {
                    accountData2.setTbs(apVar.getAnti().getTbs());
                }
                accountData = accountData2;
            } else {
                accountData = null;
            }
            z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
            zVar.brX().bsG().mNeedBackgroundLogin = false;
            zVar.brX().bsG().mIsUseCurrentBDUSS = false;
            if (accountData != null) {
                zVar.addPostData("BDUSS", accountData.getBDUSS());
                zVar.addPostData("stoken", com.baidu.tbadk.core.a.d.c(accountData));
            }
            String postNetData2 = zVar.postNetData();
            if (!zVar.brX().bsH().isRequestSuccess() || postNetData2 == null) {
                i = 0;
            } else {
                try {
                    jSONObject = new JSONObject(postNetData2);
                    JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && CheckShowNameDialogSwitch.KEY.equals(optJSONObject.optString("name"))) {
                                i = optJSONObject.optInt("type", 0);
                                break;
                            }
                        }
                    }
                    i = 0;
                } catch (JSONException e) {
                    e = e;
                    i = 0;
                }
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                    if (accountData != null && jSONObject2 != null) {
                        accountData.setNameShow(jSONObject2.optString("name_show"));
                    }
                } catch (JSONException e2) {
                    e = e2;
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
            ReloginManager.brp().jH(false);
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "cslogin_result", this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.llN.a(accountData);
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
            this.llN.onFailure(this.mName, i, str);
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
