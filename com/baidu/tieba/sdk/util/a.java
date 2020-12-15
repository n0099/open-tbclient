package com.baidu.tieba.sdk.util;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.account.AccountLoginCoreHelper;
import com.baidu.live.tbadk.core.data.AccountData;
/* loaded from: classes4.dex */
public class a extends AccountLoginCoreHelper {
    private static a mTe = null;

    private a() {
    }

    public static a dHJ() {
        if (mTe == null) {
            mTe = new a();
        }
        return mTe;
    }

    @Override // com.baidu.live.tbadk.core.account.AccountLoginCoreHelper
    public AccountLoginCoreHelper.OurToken parseBDUSS(String str) {
        AccountLoginCoreHelper.OurToken ourToken;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    ourToken = new AccountLoginCoreHelper.OurToken();
                    try {
                        ourToken.mBduss = split[0];
                        if (split.length >= 2) {
                            ourToken.mPtoken = split[1];
                            return ourToken;
                        }
                        return ourToken;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return ourToken;
                    }
                }
            } catch (Exception e3) {
                ourToken = null;
                e = e3;
            }
        }
        return null;
    }

    @Override // com.baidu.live.tbadk.core.account.AccountLoginCoreHelper
    public BdAsyncTask<?, ?, ?> asyncReLogin(String str, String str2, String str3, String str4, AccountLoginCoreHelper.IReLoginCallback iReLoginCallback) {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.account.AccountLoginCoreHelper
    public AccountData syncReLogin(String str, String str2, String str3, String str4) {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.account.AccountLoginCoreHelper
    public void reLoginByCacheAccount() {
    }

    @Override // com.baidu.live.tbadk.core.account.AccountLoginCoreHelper
    public BdAsyncTask<?, ?, ?> asyncReLoginForTbduss(String str, String str2, String str3, String str4, AccountLoginCoreHelper.IReLoginCallback iReLoginCallback) {
        return null;
    }
}
