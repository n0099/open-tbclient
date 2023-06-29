package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes8.dex */
public interface vn5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaLiveSdk", "IMSdkService");
    public static final Comparator<ChatMsg> b = new a();

    void a(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable io5 io5Var, @NonNull ho5 ho5Var);

    void b(long j);

    void c(@NonNull Context context, long j, @Nullable ko5 ko5Var);

    void d(@NonNull Context context, long j, @NonNull fo5 fo5Var);

    void e(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull fo5 fo5Var);

    void f(@NonNull go5 go5Var);

    void g(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull fo5 fo5Var);

    void h(@NonNull go5 go5Var);

    void i(@NonNull Context context, long j, @NonNull co5 co5Var);

    void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull eo5 eo5Var);

    void k(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jo5 jo5Var);

    void l(@NonNull Context context, long j, @NonNull fo5 fo5Var);

    void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull eo5 eo5Var);

    void n(@NonNull Context context, long j, @NonNull do5 do5Var);

    /* loaded from: classes8.dex */
    public static class a implements Comparator<ChatMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ChatMsg chatMsg, ChatMsg chatMsg2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatMsg, chatMsg2)) == null) {
                if (TextUtils.equals(chatMsg.getMsgKey(), chatMsg2.getMsgKey())) {
                    return 0;
                }
                if (chatMsg.getMsgId() - chatMsg2.getMsgId() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }
}
