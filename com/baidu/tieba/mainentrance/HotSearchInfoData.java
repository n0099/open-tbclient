package com.baidu.tieba.mainentrance;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.HotForum.HotSearch;
import tbclient.HotForum.SearchValue;
/* loaded from: classes9.dex */
public class HotSearchInfoData extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIRECT_SEARCH_TYPE = 2;
    public static final int FORUM_TYPE = 0;
    public static final int TOPIC_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f51307e;

    /* renamed from: f  reason: collision with root package name */
    public long f51308f;

    /* renamed from: g  reason: collision with root package name */
    public long f51309g;

    /* renamed from: h  reason: collision with root package name */
    public String f51310h;

    public HotSearchInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51309g : invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51310h : (String) invokeV.objValue;
    }

    public long getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51308f : invokeV.longValue;
    }

    public void setId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f51309g = j;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f51310h = str;
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51307e : (String) invokeV.objValue;
    }

    public void x(HotSearch hotSearch) {
        SearchValue searchValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotSearch) == null) || hotSearch == null || (searchValue = hotSearch.search_value) == null) {
            return;
        }
        this.f51307e = hotSearch.search_title;
        this.f51309g = searchValue.id.longValue();
        SearchValue searchValue2 = hotSearch.search_value;
        this.f51310h = searchValue2.name;
        this.f51308f = searchValue2.type.longValue();
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f51307e = str;
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f51308f = j;
        }
    }
}
