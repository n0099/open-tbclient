package com.baidu.tieba.keepLive.sync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class AccountAuthenticatorService extends Service {
    private a accountAuthenticator;

    @Override // android.app.Service
    public void onCreate() {
        this.accountAuthenticator = new a(this);
        try {
            Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return this.accountAuthenticator.getIBinder();
        }
        return null;
    }

    /* loaded from: classes3.dex */
    private static class a extends AbstractAccountAuthenticator {
        final Context context;

        public a(Context context) {
            super(context);
            this.context = context;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public String getAuthTokenLabel(String str) {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) throws NetworkErrorException {
            return null;
        }

        @Override // android.accounts.AbstractAccountAuthenticator
        public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
            return null;
        }
    }
}
