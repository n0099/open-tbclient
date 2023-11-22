package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ForumShowInfo;
import tbclient.ForumShowInfoTag;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class kx4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public long c;
    public a d;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ThemeColorInfo a;
        public ThemeColorInfo b;
        public String c;

        public a(kx4 kx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void e(ForumShowInfoTag forumShowInfoTag) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, forumShowInfoTag) != null) || forumShowInfoTag == null) {
                return;
            }
            this.c = forumShowInfoTag.text;
            this.a = forumShowInfoTag.text_color;
            this.b = forumShowInfoTag.bg_color;
        }

        public ThemeColorInfo a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (ThemeColorInfo) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public ThemeColorInfo c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (ThemeColorInfo) invokeV.objValue;
        }

        public void d(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.c = jSONObject.optString("text");
            this.a = d1b.j(jSONObject.optJSONObject(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR));
            this.b = d1b.j(jSONObject.optJSONObject("bg_color"));
        }
    }

    public kx4() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (a) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!qd.isEmpty(this.a) && this.c > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("content");
        this.c = jSONObject.optLong("show_type", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("tag");
        if (optJSONObject != null) {
            a aVar = new a(this);
            this.d = aVar;
            aVar.d(optJSONObject);
        }
    }

    public void f(ForumShowInfo forumShowInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, forumShowInfo) != null) || forumShowInfo == null) {
            return;
        }
        this.a = forumShowInfo.content;
        this.c = forumShowInfo.show_type.longValue();
        if (forumShowInfo.tag != null) {
            a aVar = new a(this);
            this.d = aVar;
            aVar.e(forumShowInfo.tag);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b = str;
        }
    }
}
