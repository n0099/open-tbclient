package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.HotCard;
import tbclient.ThemeColorInfo;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class jc8 extends fw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ThemeColorInfo b;
    public ThemeColorInfo c;
    public String d;
    public String e;
    public List<ThreadData> f;
    public int g;

    @Override // com.baidu.tieba.fw4
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public jc8() {
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
        this.f = new ArrayList();
    }

    public ThemeColorInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public List<ThreadData> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return dn6.B0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static boolean h(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                ThreadData threadData = new ThreadData();
                threadData.setNeedCheckNTitle(false);
                threadData.parserProtobuf(list.get(i));
                if (TextUtils.isEmpty(threadData.getTitleText())) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("HotCard", "圈层热贴下发贴子title为空tid=" + threadData.getTid());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k(HotCard hotCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, hotCard) != null) || hotCard == null) {
            return;
        }
        this.f.clear();
        if (ListUtils.isNotEmpty(hotCard.thread_list)) {
            for (int i = 0; i < hotCard.thread_list.size(); i++) {
                ThreadData threadData = new ThreadData();
                threadData.setNeedCheckNTitle(false);
                threadData.parserProtobuf(hotCard.thread_list.get(i));
                this.f.add(threadData);
            }
        }
        this.a = hotCard.card_title;
        this.b = hotCard.card_background;
        this.c = hotCard.post_color;
        this.d = hotCard.jump_text;
        this.e = hotCard.jump_link;
        this.g = hotCard.card_offset.intValue();
    }

    public static boolean l(DataRes.Builder builder) {
        InterceptResult invokeL;
        HotCard hotCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, builder)) == null) {
            if (TbadkCoreApplication.isLogin() && builder != null && (hotCard = builder.hot_card) != null && h(hotCard.thread_list)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
