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
/* loaded from: classes7.dex */
public interface nn5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("AlaLiveSdk", "IMSdkService");
    public static final Comparator<ChatMsg> b = new a();

    void a(@NonNull Context context, @NonNull List<Long> list, @NonNull xn5 xn5Var);

    void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable ao5 ao5Var, @NonNull zn5 zn5Var);

    void c(@NonNull Context context, @NonNull List<Long> list, @NonNull xn5 xn5Var);

    void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull un5 un5Var);

    void e(@NonNull yn5 yn5Var);

    void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull vn5 vn5Var);

    void g(@NonNull yn5 yn5Var);

    void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list);

    void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull bo5 bo5Var);

    /* loaded from: classes7.dex */
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
