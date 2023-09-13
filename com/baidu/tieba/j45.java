package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Post;
/* loaded from: classes6.dex */
public final class j45 {
    public static /* synthetic */ Interceptable $ic;
    public static final a e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833342, "Lcom/baidu/tieba/j45;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833342, "Lcom/baidu/tieba/j45;");
                return;
            }
        }
        e = new a(null);
    }

    @JvmStatic
    public static final j45 e(Post post) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, post)) == null) ? e.a(post) : (j45) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j45) {
                j45 j45Var = (j45) obj;
                return Intrinsics.areEqual(this.a, j45Var.a) && Intrinsics.areEqual(this.b, j45Var.b) && this.c == j45Var.c && Intrinsics.areEqual(this.d, j45Var.d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            boolean z = this.c;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.d.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "TopPostTagInfo(tag=" + this.a + ", color=" + this.b + ", shieldIcon=" + this.c + ", iconUrl=" + this.d + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        @JvmStatic
        public final j45 a(Post post) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, post)) == null) {
                Intrinsics.checkNotNullParameter(post, "post");
                if (!ei.isEmpty(post.toutiao_card_tag) && !ei.isEmpty(post.toutiao_card_tag_color)) {
                    String str = post.toutiao_card_tag;
                    Intrinsics.checkNotNullExpressionValue(str, "post.toutiao_card_tag");
                    String str2 = post.toutiao_card_tag_color;
                    Intrinsics.checkNotNullExpressionValue(str2, "post.toutiao_card_tag_color");
                    Integer num = post.shield_icon;
                    boolean z = true;
                    z = (num == null || num.intValue() != 1) ? false : false;
                    String str3 = post.icon_url;
                    Intrinsics.checkNotNullExpressionValue(str3, "post.icon_url");
                    return new j45(str, str2, z, str3);
                }
                return null;
            }
            return (j45) invokeL.objValue;
        }
    }

    public j45(String tag, String color, boolean z, String iconUrl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tag, color, Boolean.valueOf(z), iconUrl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.a = tag;
        this.b = color;
        this.c = z;
        this.d = iconUrl;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
