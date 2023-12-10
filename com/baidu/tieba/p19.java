package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public interface p19 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatMessageDispatchService");

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull Map<Long, ChatRoomInfo> map);
    }

    void a(@NonNull bl5 bl5Var);

    void b(@NonNull Context context, int i);

    void c(long j, @NonNull List<ChatRoomInfo> list);

    void d(@NonNull a aVar);

    void onDestroy();
}
