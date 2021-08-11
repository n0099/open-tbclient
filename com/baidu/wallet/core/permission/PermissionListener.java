package com.baidu.wallet.core.permission;

import androidx.annotation.NonNull;
import com.baidu.wallet.core.NoProguard;
import java.util.List;
/* loaded from: classes8.dex */
public interface PermissionListener extends NoProguard {
    void permissionDenied(@NonNull List<String> list);

    void permissionGranted(@NonNull List<String> list);
}
