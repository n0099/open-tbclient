package com.baidu.ugc.editvideo.data;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ImageQualityData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isOpen;
    public boolean needDefog;
    public boolean needDenoise;

    public ImageQualityData() {
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

    public ImageQualityData(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isOpen = z;
        this.needDefog = z2;
        this.needDenoise = z3;
    }

    public static int isUseImageQuality(ImageQualityData imageQualityData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, imageQualityData)) == null) ? isValidStatus(imageQualityData) ? 1 : 0 : invokeL.intValue;
    }

    public static boolean isValidStatus(ImageQualityData imageQualityData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, imageQualityData)) == null) ? imageQualityData != null && imageQualityData.isOpen && (imageQualityData.needDefog || imageQualityData.needDenoise) : invokeL.booleanValue;
    }

    public static ImageQualityData parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ImageQualityData imageQualityData = new ImageQualityData();
            try {
                JSONObject jSONObject = new JSONObject(str);
                imageQualityData.isOpen = jSONObject.optBoolean("isOpen", false);
                imageQualityData.needDefog = jSONObject.optBoolean("needDefog", false);
                imageQualityData.needDenoise = jSONObject.optBoolean("needDenoise", false);
                return imageQualityData;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ImageQualityData) invokeL.objValue;
    }

    public static String toJson(ImageQualityData imageQualityData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, imageQualityData)) == null) {
            if (imageQualityData == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isOpen", imageQualityData.isOpen);
                jSONObject.put("needDefog", imageQualityData.needDefog);
                jSONObject.put("needDenoise", imageQualityData.needDenoise);
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
