package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public final class si7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public String d;
    public List<ForumTabItem> e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public String k;
    public ThemeColorInfo l;
    public String m;
    public aj7 n;
    public UserData o;
    public ForumTagInfo p;
    public String q;
    public int r;
    public ni7 s;
    public String t;
    public String u;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public si7() {
        this(0L, null, null, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, 0, null, 524287, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3], (List) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), ((Integer) objArr[9]).intValue(), (String) objArr[10], (ThemeColorInfo) objArr[11], (String) objArr[12], (aj7) objArr[13], (UserData) objArr[14], (ForumTagInfo) objArr[15], (String) objArr[16], ((Integer) objArr[17]).intValue(), (ni7) objArr[18], ((Integer) objArr[19]).intValue(), (DefaultConstructorMarker) objArr[20]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof si7) {
                si7 si7Var = (si7) obj;
                return this.a == si7Var.a && Intrinsics.areEqual(this.b, si7Var.b) && Intrinsics.areEqual(this.c, si7Var.c) && Intrinsics.areEqual(this.d, si7Var.d) && Intrinsics.areEqual(this.e, si7Var.e) && this.f == si7Var.f && this.g == si7Var.g && this.h == si7Var.h && this.i == si7Var.i && this.j == si7Var.j && Intrinsics.areEqual(this.k, si7Var.k) && Intrinsics.areEqual(this.l, si7Var.l) && Intrinsics.areEqual(this.m, si7Var.m) && Intrinsics.areEqual(this.n, si7Var.n) && Intrinsics.areEqual(this.o, si7Var.o) && Intrinsics.areEqual(this.p, si7Var.p) && Intrinsics.areEqual(this.q, si7Var.q) && this.r == si7Var.r && Intrinsics.areEqual(this.s, si7Var.s);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int a = ((((((((((((((((((((c.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k.hashCode()) * 31;
            ThemeColorInfo themeColorInfo = this.l;
            int hashCode = (a + (themeColorInfo == null ? 0 : themeColorInfo.hashCode())) * 31;
            String str = this.m;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            aj7 aj7Var = this.n;
            int hashCode3 = (hashCode2 + (aj7Var == null ? 0 : aj7Var.hashCode())) * 31;
            UserData userData = this.o;
            int hashCode4 = (hashCode3 + (userData == null ? 0 : userData.hashCode())) * 31;
            ForumTagInfo forumTagInfo = this.p;
            int hashCode5 = (((((hashCode4 + (forumTagInfo == null ? 0 : forumTagInfo.hashCode())) * 31) + this.q.hashCode()) * 31) + this.r) * 31;
            ni7 ni7Var = this.s;
            return hashCode5 + (ni7Var != null ? ni7Var.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return "ForumData(forumId=" + this.a + ", forumName=" + this.b + ", forumIcon=" + this.c + ", forumSlogan=" + this.d + ", tabItemList=" + this.e + ", defaultTabId=" + this.f + ", firstTabSortType=" + this.g + ", msgBubbleFrequencyLimit=" + this.h + ", unreadMsgBubbleFrequencyLimit=" + this.i + ", specialMsgBubbleFrequencyLimit=" + this.j + ", themeColor=" + this.k + ", themeColorInfo=" + this.l + ", frsCommonInfo=" + this.m + ", privateForumInfoData=" + this.n + ", userData=" + this.o + ", forumTagInfo=" + this.p + ", firstCategory=" + this.q + ", isMemberBroadcastForum=" + this.r + ", aiChatRoomGuide=" + this.s + ')';
        }
        return (String) invokeV.objValue;
    }

    public si7(long j, String forumName, String forumIcon, String forumSlogan, List<ForumTabItem> tabItemList, int i, int i2, int i3, int i4, int i5, String themeColor, ThemeColorInfo themeColorInfo, String str, aj7 aj7Var, UserData userData, ForumTagInfo forumTagInfo, String firstCategory, int i6, ni7 ni7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), forumName, forumIcon, forumSlogan, tabItemList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), themeColor, themeColorInfo, str, aj7Var, userData, forumTagInfo, firstCategory, Integer.valueOf(i6), ni7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(forumName, "forumName");
        Intrinsics.checkNotNullParameter(forumIcon, "forumIcon");
        Intrinsics.checkNotNullParameter(forumSlogan, "forumSlogan");
        Intrinsics.checkNotNullParameter(tabItemList, "tabItemList");
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        Intrinsics.checkNotNullParameter(firstCategory, "firstCategory");
        this.a = j;
        this.b = forumName;
        this.c = forumIcon;
        this.d = forumSlogan;
        this.e = tabItemList;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
        this.j = i5;
        this.k = themeColor;
        this.l = themeColorInfo;
        this.m = str;
        this.n = aj7Var;
        this.o = userData;
        this.p = forumTagInfo;
        this.q = firstCategory;
        this.r = i6;
        this.s = ni7Var;
        this.t = "";
        this.u = "";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ si7(long j, String str, String str2, String str3, List list, int i, int i2, int i3, int i4, int i5, String str4, ThemeColorInfo themeColorInfo, String str5, aj7 aj7Var, UserData userData, ForumTagInfo forumTagInfo, String str6, int i6, ni7 ni7Var, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r10, r43, r4, r17, r18, r19, (i7 & 262144) == 0 ? ni7Var : null);
        long j2;
        String str7;
        String str8;
        String str9;
        List list2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str10;
        ThemeColorInfo themeColorInfo2;
        String str11;
        aj7 aj7Var2;
        UserData userData2;
        ForumTagInfo forumTagInfo2;
        String str12;
        int i13;
        if ((i7 & 1) != 0) {
            j2 = 0;
        } else {
            j2 = j;
        }
        if ((i7 & 2) != 0) {
            str7 = "";
        } else {
            str7 = str;
        }
        if ((i7 & 4) != 0) {
            str8 = "";
        } else {
            str8 = str2;
        }
        if ((i7 & 8) != 0) {
            str9 = "";
        } else {
            str9 = str3;
        }
        if ((i7 & 16) != 0) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        if ((i7 & 32) != 0) {
            i8 = -1;
        } else {
            i8 = i;
        }
        if ((i7 & 64) != 0) {
            i9 = 0;
        } else {
            i9 = i2;
        }
        if ((i7 & 128) != 0) {
            i10 = 0;
        } else {
            i10 = i3;
        }
        if ((i7 & 256) != 0) {
            i11 = 0;
        } else {
            i11 = i4;
        }
        if ((i7 & 512) != 0) {
            i12 = 0;
        } else {
            i12 = i5;
        }
        if ((i7 & 1024) != 0) {
            str10 = "";
        } else {
            str10 = str4;
        }
        if ((i7 & 2048) != 0) {
            themeColorInfo2 = null;
        } else {
            themeColorInfo2 = themeColorInfo;
        }
        if ((i7 & 4096) != 0) {
            str11 = null;
        } else {
            str11 = str5;
        }
        if ((i7 & 8192) != 0) {
            aj7Var2 = null;
        } else {
            aj7Var2 = aj7Var;
        }
        aj7 aj7Var3 = aj7Var2;
        if ((i7 & 16384) != 0) {
            userData2 = null;
        } else {
            userData2 = userData;
        }
        if ((i7 & 32768) != 0) {
            forumTagInfo2 = null;
        } else {
            forumTagInfo2 = forumTagInfo;
        }
        if ((i7 & 65536) != 0) {
            str12 = "";
        } else {
            str12 = str6;
        }
        if ((i7 & 131072) != 0) {
            i13 = 0;
        } else {
            i13 = i6;
        }
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }
    }

    public final void C(ForumTagInfo forumTagInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumTagInfo) == null) {
            this.p = forumTagInfo;
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.r = i;
        }
    }

    public final void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
        }
    }

    public final void G(aj7 aj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aj7Var) == null) {
            this.n = aj7Var;
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.u = str;
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.j = i;
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.k = str;
        }
    }

    public final void K(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, themeColorInfo) == null) {
            this.l = themeColorInfo;
        }
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.i = i;
        }
    }

    public final void M(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, userData) == null) {
            this.o = userData;
        }
    }

    public final void u(ni7 ni7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, ni7Var) == null) {
            this.s = ni7Var;
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.f = i;
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.q = str;
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.t = str;
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }

    public final void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048617, this, j) == null) {
            this.a = j;
        }
    }

    public final ni7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.s;
        }
        return (ni7) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final ForumTagInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.p;
        }
        return (ForumTagInfo) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final aj7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.n;
        }
        return (aj7) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final List<ForumTabItem> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final ThemeColorInfo q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.l;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final UserData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.o;
        }
        return (UserData) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }
}
