package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.MatchCardInfo;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public final class vqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Integer b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Long j;
    public Long k;
    public List<ThreadInfo> l;
    public String m;
    public ArrayList<wqa> n;
    public String o;
    public String p;

    public vqa() {
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

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final Integer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (Integer) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final ArrayList<wqa> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final Long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return (Long) invokeV.objValue;
    }

    public final Long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return (Long) invokeV.objValue;
    }

    public final List<ThreadInfo> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public final long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public final void q(MatchCardInfo matchCardInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, matchCardInfo) != null) || matchCardInfo == null) {
            return;
        }
        this.a = matchCardInfo.name;
        this.b = matchCardInfo.status;
        this.c = matchCardInfo.card_title;
        Long l = matchCardInfo.topic_id;
        Intrinsics.checkNotNullExpressionValue(l, "matchCardInfo.topic_id");
        this.d = l.longValue();
        this.e = matchCardInfo.team_name_a;
        this.f = matchCardInfo.team_name_b;
        this.g = matchCardInfo.team_icon_a;
        this.h = matchCardInfo.team_icon_b;
        this.i = matchCardInfo.start_desc;
        this.j = matchCardInfo.team_score_a;
        this.k = matchCardInfo.team_score_b;
        this.l = matchCardInfo.thread_list;
        this.m = matchCardInfo.icon_text;
        List<MatchPlayerInfo> list = matchCardInfo.team_player_list;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.n = new ArrayList<>();
            for (MatchPlayerInfo matchPlayerInfo : matchCardInfo.team_player_list) {
                wqa wqaVar = new wqa();
                wqaVar.r(matchPlayerInfo);
                ArrayList<wqa> arrayList = this.n;
                Intrinsics.checkNotNull(arrayList);
                arrayList.add(wqaVar);
            }
        }
        this.o = matchCardInfo.match_link;
        this.p = matchCardInfo.schedule_link;
    }

    public final void r(tbclient.Personalized.MatchCardInfo matchCardInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, matchCardInfo) != null) || matchCardInfo == null) {
            return;
        }
        this.a = matchCardInfo.name;
        this.b = matchCardInfo.status;
        this.c = matchCardInfo.card_title;
        Long l = matchCardInfo.topic_id;
        Intrinsics.checkNotNullExpressionValue(l, "matchCardInfo.topic_id");
        this.d = l.longValue();
        this.e = matchCardInfo.team_name_a;
        this.f = matchCardInfo.team_name_b;
        this.g = matchCardInfo.team_icon_a;
        this.h = matchCardInfo.team_icon_b;
        this.i = matchCardInfo.start_desc;
        this.j = matchCardInfo.team_score_a;
        this.k = matchCardInfo.team_score_b;
        this.l = matchCardInfo.thread_list;
        this.m = matchCardInfo.icon_text;
        List<tbclient.Personalized.MatchPlayerInfo> list = matchCardInfo.team_player_list;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.n = new ArrayList<>();
            for (tbclient.Personalized.MatchPlayerInfo matchPlayerInfo : matchCardInfo.team_player_list) {
                wqa wqaVar = new wqa();
                wqaVar.s(matchPlayerInfo);
                ArrayList<wqa> arrayList = this.n;
                Intrinsics.checkNotNull(arrayList);
                arrayList.add(wqaVar);
            }
        }
        this.o = matchCardInfo.match_link;
        this.p = matchCardInfo.schedule_link;
    }
}
