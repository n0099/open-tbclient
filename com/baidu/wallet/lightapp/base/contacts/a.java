package com.baidu.wallet.lightapp.base.contacts;

import android.content.Context;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24638a = "a";

    public static ConcurrentHashMap<String, ContractInfo> a(Context context) {
        return ContactManager.getIContactsImpl().loadPhoneContracts(context);
    }

    public static ConcurrentHashMap<String, ContractInfo> b(Context context) {
        return ContactManager.getIContactsImpl().loadSimContracts(context);
    }

    public static List<ContractInfo> c(Context context) {
        return ContactManager.getIContactsImpl().loadAllPhone(context);
    }
}
