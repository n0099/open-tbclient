package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.HeadCardCover;
import tbclient.Personalized.HeaderCard;
import tbclient.Personalized.MatchCardInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class in7 extends jw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ThemeColorInfo b;
    public List<hn> c;
    public int d;
    public int e;
    public boolean f;

    @Override // com.baidu.tieba.jw4
    public hy4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (hy4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public in7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = -1;
        this.c = new ArrayList();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public ThemeColorInfo d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public List<hn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.hn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return mh6.A0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static boolean f(HeadCardCover headCardCover) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, headCardCover)) == null) {
            if (headCardCover != null && headCardCover.freq != null) {
                String[] split = p45.m().s("key_recommand_collect_cover_freq", "0-0-0").split("-");
                if (split.length == 3) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    long j = parseInt;
                    if (j == headCardCover.freq.start_time.longValue()) {
                        long j2 = parseInt2;
                        if (j2 == headCardCover.freq.end_time.longValue() && parseInt3 == headCardCover.freq.show_times.longValue()) {
                            int n = p45.m().n("key_recommand_collect_cover_show_time", 0);
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            if (n < parseInt3 && currentTimeMillis >= j && currentTimeMillis <= j2) {
                                p45.m().z("key_recommand_collect_cover_show_time", n + 1);
                                return true;
                            }
                        }
                    }
                    p45.m().B("key_recommand_collect_cover_freq", headCardCover.freq.start_time + "-" + headCardCover.freq.end_time + "-" + headCardCover.freq.show_times);
                    p45.m().z("key_recommand_collect_cover_show_time", 0);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(DataRes.Builder builder) {
        InterceptResult invokeL;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, builder)) == null) {
            if (TbadkCoreApplication.isLogin() && builder != null && (headerCard = builder.header_card) != null && (ListUtils.isNotEmpty(headerCard.thread_list) || f(builder.header_card.cover))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void h(HeaderCard headerCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, headerCard) != null) || headerCard == null) {
            return;
        }
        this.c.clear();
        this.f = false;
        HeadCardCover headCardCover = headerCard.cover;
        if (headCardCover != null) {
            this.f = true;
            MatchCardInfo matchCardInfo = headCardCover.match_info;
            if (matchCardInfo != null && !TextUtils.isEmpty(matchCardInfo.card_title)) {
                this.a = headerCard.cover.match_info.card_title;
            }
            ThemeColorInfo themeColorInfo = headerCard.cover.card_background;
            if (themeColorInfo != null) {
                this.b = themeColorInfo;
            }
            if (headerCard.cover.match_info != null) {
                jn7 jn7Var = new jn7();
                jn7Var.b(headerCard.cover.match_info);
                this.c.add(jn7Var);
                if (ListUtils.isNotEmpty(headerCard.cover.match_info.thread_list)) {
                    for (ThreadInfo threadInfo : headerCard.cover.match_info.thread_list) {
                        ThreadData threadData = new ThreadData();
                        threadData.setNeedCheckNTitle(false);
                        threadData.parserProtobuf(threadInfo);
                        if (threadData.getTitleText() != null && StringUtils.isNotNull(headerCard.cover.match_info.icon_text)) {
                            ThreadCardUtils.setUniversalPrefix(threadData.getTitleText(), headerCard.cover.match_info.icon_text, R.color.CAM_X0302, R.color.CAM_X0101);
                        }
                        this.c.add(threadData);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (ListUtils.isNotEmpty(headerCard.thread_list)) {
            for (int i = 0; i < headerCard.thread_list.size(); i++) {
                ThreadData threadData2 = new ThreadData();
                threadData2.setNeedCheckNTitle(false);
                threadData2.parserProtobuf(headerCard.thread_list.get(i));
                this.c.add(threadData2);
            }
        }
        this.a = headerCard.card_title;
        this.b = headerCard.card_background;
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e = i;
        }
    }
}
