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
/* loaded from: classes6.dex */
public interface io5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaLiveSdk", "IMSdkService");
    public static final Comparator<ChatMsg> b = new a();

    void a(long j);

    void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull yo5 yo5Var);

    void c(@NonNull Context context, long j, @Nullable ap5 ap5Var);

    void d(@NonNull Context context, long j, @NonNull so5 so5Var);

    void e(@NonNull Context context, boolean z, int i, @NonNull xo5 xo5Var);

    void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull so5 so5Var);

    void g(@NonNull to5 to5Var);

    void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable m95<List<? extends ChatMsg>> m95Var, @NonNull wo5 wo5Var);

    void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull vo5 vo5Var);

    void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull so5 so5Var);

    void k(@NonNull to5 to5Var);

    void l(@NonNull Context context, long j, @NonNull po5 po5Var);

    void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull ro5 ro5Var);

    void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull zo5 zo5Var);

    void o(@NonNull Context context, long j, @NonNull so5 so5Var);

    void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull uo5 uo5Var);

    void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull ro5 ro5Var);

    void r(@NonNull Context context, long j, @NonNull qo5 qo5Var);

    /* loaded from: classes6.dex */
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
