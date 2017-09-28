package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0044a interfaceC0044a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0044a, false);
        if (e.pi() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0044a != null) {
                        interfaceC0044a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.pi()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0044a interfaceC0044a) {
        a aVar = new a(str, str2, str3, interfaceC0044a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData H(String str, String str2, String str3) {
        x xVar = new x(TbConfig.LOGIN_FULL_ADDRESS);
        xVar.uN().vJ().mIsUseCurrentBDUSS = false;
        xVar.n("bdusstoken", str2 + "|" + str3);
        xVar.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
        xVar.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
        xVar.uN().vJ().ahL = false;
        String up = xVar.up();
        if (xVar.uN().vK().isRequestSuccess() && up != null) {
            ai aiVar = new ai();
            aiVar.parserJson(up);
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.qh() != null) {
                accountData.setTbs(aiVar.qh().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Tg;
        private final String epH;
        private final a.InterfaceC0044a epI;
        private final boolean epJ;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0044a interfaceC0044a, boolean z) {
            this.mName = str;
            this.epH = str2;
            this.Tg = str3;
            this.epJ = z;
            this.epI = interfaceC0044a == null ? new a.InterfaceC0044a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
                public void cp(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0044a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.epI.cp(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.uN().vJ().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.epH + "|" + this.Tg);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.uN().vJ().ahL = false;
            String up = this.mNetwork.up();
            if (this.mNetwork.uN().vK().isRequestSuccess() && up != null) {
                ai aiVar = new ai();
                aiVar.parserJson(up);
                AccountData accountData = new AccountData();
                accountData.setAccount(aiVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aiVar.getUser().getUserId());
                String str = this.epH;
                if (this.epJ && (a = d.a(com.baidu.tbadk.core.a.a.pb().co(str))) != null) {
                    str = a.ws + "|" + a.Tg;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(aiVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aiVar.qh() != null) {
                    accountData.setTbs(aiVar.qh().getTbs());
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.tX().az(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.uR(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.epI.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.uR();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.data_load_error);
            }
            this.epI.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
        }
    }
}
