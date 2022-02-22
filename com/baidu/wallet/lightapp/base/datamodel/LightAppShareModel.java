package com.baidu.wallet.lightapp.base.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightAppListener;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class LightAppShareModel implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appid;
    public String content;
    public String extraParam;
    public String imageUrl;
    public String linkUrl;
    public String mediaType;
    public int menumode;
    public String title;

    public LightAppShareModel() {
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

    public Map<String, String> toMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.mediaType)) {
                hashMap.put(ILightAppListener.KEY_SHARE_MEDIATYPE, this.mediaType);
            }
            if (!TextUtils.isEmpty(this.title)) {
                hashMap.put(ILightAppListener.KEY_SHARE_TITLE, this.title);
            }
            if (!TextUtils.isEmpty(this.content)) {
                hashMap.put(ILightAppListener.KEY_SHARE_CONTENT, this.content);
            }
            if (!TextUtils.isEmpty(this.linkUrl)) {
                hashMap.put(ILightAppListener.KEY_SHARE_LINK, this.linkUrl);
            }
            if (!TextUtils.isEmpty(this.imageUrl)) {
                hashMap.put(ILightAppListener.KEY_SHARE_IMAGE, this.imageUrl);
            }
            if (!TextUtils.isEmpty(this.extraParam)) {
                hashMap.put(ILightAppListener.KEY_SHARE_EXTRA, this.extraParam);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public boolean valid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.linkUrl) : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LightAppShareModel(String str, String str2, String str3, String str4) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.title = str;
        this.content = str2;
        this.linkUrl = str3;
        this.imageUrl = str4;
    }
}
