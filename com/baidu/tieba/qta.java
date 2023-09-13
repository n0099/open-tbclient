package com.baidu.tieba;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qta implements pta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoEasterEggData a;

    public qta() {
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

    @Override // com.baidu.tieba.pta
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getPopText();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getActivityID();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareTitle();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getPopImageUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareImageUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VideoEasterEggData videoEasterEggData = this.a;
            if (videoEasterEggData == null) {
                return null;
            }
            return videoEasterEggData.getShareContent();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) != null) || intent == null) {
            return;
        }
        intent.getStringExtra("from");
        if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
            this.a = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
        }
    }

    @Override // com.baidu.tieba.pta
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) && !ei.isEmpty(g())) {
            BdResourceLoader.getInstance().loadResource(g(), 10, null, bdUniqueId);
        }
    }
}
