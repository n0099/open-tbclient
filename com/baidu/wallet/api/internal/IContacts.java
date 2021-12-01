package com.baidu.wallet.api.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public interface IContacts {
    int countOfContacts(@NonNull Context context);

    List<ContractInfo> loadAllPhone(@NonNull Context context);

    List<String> loadPhoneContactsForChargeFragment(@NonNull Uri uri, @NonNull Context context);

    ConcurrentHashMap<String, ContractInfo> loadPhoneContracts(@NonNull Context context);

    List<String> loadRawPhone(@NonNull Uri uri, @NonNull Context context);

    ConcurrentHashMap<String, ContractInfo> loadSimContracts(@NonNull Context context);

    boolean pickContactsByContactsContentUri(@NonNull Activity activity, int i2);

    boolean pickContactsByPhoneContentType(@NonNull Activity activity, int i2);
}
