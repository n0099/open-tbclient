package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0040a interfaceC0040a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0040a, false);
        if (e.pm() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0040a != null) {
                        interfaceC0040a.b(str, 1, null);
                    }
                }
            });
        } else {
            if (e.pm()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0040a interfaceC0040a) {
        a aVar = new a(str, str2, str3, interfaceC0040a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData G(String str, String str2, String str3) {
        w wVar = new w(TbConfig.LOGIN_FULL_ADDRESS);
        wVar.vl().wh().mIsUseCurrentBDUSS = false;
        wVar.n("bdusstoken", str2 + "|" + str3);
        wVar.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
        wVar.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
        wVar.vl().wh().aiO = false;
        String uO = wVar.uO();
        if (wVar.vl().wi().isRequestSuccess() && uO != null) {
            ak akVar = new ak();
            akVar.parserJson(uO);
            AccountData accountData = new AccountData();
            accountData.setAccount(akVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(akVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(akVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (akVar.qr() != null) {
                accountData.setTbs(akVar.qr().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String TM;
        private final String emW;
        private final a.InterfaceC0040a emX;
        private final boolean emY;
        private final String mName;
        private volatile w mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a, boolean z) {
            this.mName = str;
            this.emW = str2;
            this.TM = str3;
            this.emY = z;
            this.emX = interfaceC0040a == null ? new a.InterfaceC0040a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
                public void cw(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
                public void b(String str4, int i, String str5) {
                }
            } : interfaceC0040a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.emX.cw(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new w(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.vl().wh().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.emW + "|" + this.TM);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.vl().wh().aiO = false;
            String uO = this.mNetwork.uO();
            if (this.mNetwork.vl().wi().isRequestSuccess() && uO != null) {
                ak akVar = new ak();
                akVar.parserJson(uO);
                AccountData accountData = new AccountData();
                accountData.setAccount(akVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(akVar.getUser().getUserId());
                String str = this.emW;
                if (this.emY && (a = d.a(com.baidu.tbadk.core.a.a.pf().cv(str))) != null) {
                    str = a.mBduss + "|" + a.TM;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(akVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (akVar.qr() != null) {
                    accountData.setTbs(akVar.qr().getTbs());
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
            ReloginManager.uy().az(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.vp(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.emX.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.vp();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.data_load_error);
            }
            this.emX.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
        }
    }
}
