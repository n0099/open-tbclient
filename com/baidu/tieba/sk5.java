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
public interface sk5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaLiveSdk", "IMSdkService");
    public static final Comparator<ChatMsg> b = new a();

    void a(long j);

    void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull il5 il5Var);

    void c(@NonNull Context context, long j, @Nullable kl5 kl5Var);

    void d(@NonNull Context context, long j, @NonNull cl5 cl5Var);

    void e(@NonNull Context context, boolean z, int i, @NonNull hl5 hl5Var);

    void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull cl5 cl5Var);

    void g(@NonNull dl5 dl5Var);

    void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable b55<List<? extends ChatMsg>> b55Var, @NonNull gl5 gl5Var);

    void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull fl5 fl5Var);

    void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull cl5 cl5Var);

    void k(@NonNull dl5 dl5Var);

    void l(@NonNull Context context, long j, @NonNull zk5 zk5Var);

    void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull bl5 bl5Var);

    void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jl5 jl5Var);

    void o(@NonNull Context context, long j, @NonNull cl5 cl5Var);

    void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull el5 el5Var);

    void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull bl5 bl5Var);

    void r(@NonNull Context context, long j, @NonNull al5 al5Var);

    /* loaded from: classes8.dex */
    public class a implements Comparator<ChatMsg> {
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
