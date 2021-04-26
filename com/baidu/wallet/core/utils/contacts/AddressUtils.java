package com.baidu.wallet.core.utils.contacts;

import android.content.Context;
import com.baidu.wallet.core.ContactManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class AddressUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24756a = "AddressUtils";

    public static List<ContractInfo> getAllPhone(Context context) {
        return ContactManager.getIContactsImpl().loadAllPhone(context);
    }

    public static ConcurrentHashMap<String, ContractInfo> getPhoneContracts(Context context) {
        return ContactManager.getIContactsImpl().loadPhoneContracts(context);
    }

    public static ConcurrentHashMap<String, ContractInfo> getSimContracts(Context context) {
        return ContactManager.getIContactsImpl().loadSimContracts(context);
    }
}
