package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface ml {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "ISoProcess");

    void a(@NonNull String str);
}
