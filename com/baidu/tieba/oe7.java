package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class oe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public a(ThreadData threadData, long j, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadData;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageUtils.createAndSendPersonalThreadChatMessage(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public b(ForumData forumData, long j, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumData;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageUtils.createAndSendPersonalForumChatMessage(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    public static void a(@Nullable ForumData forumData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{forumData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalForumChatMessage(forumData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            zg.a().postDelayed(new b(forumData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void b(@Nullable ThreadData threadData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalThreadChatMessage(threadData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            zg.a().postDelayed(new a(threadData, j, str2, str3, str4, z), 500L);
        }
    }
}
