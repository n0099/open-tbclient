package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface p70 {

    /* loaded from: classes7.dex */
    public interface a {
        Response a(Request request) throws IOException;

        @Nullable
        w70 connection();

        Request request();
    }

    Response a(a aVar) throws IOException;
}
