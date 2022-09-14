package com.baidu.ugc.editvideo.record.entity;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nd9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.MusicData;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class EffectInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String finalFilePath;
    public int fixNum;
    public String iconPath;
    public String id;
    public boolean isLocal;
    public boolean isSelected;
    public EffectMusicData music;
    public String name;
    public String resourceUrl;
    public int showSwitch;
    public String sign;
    public String sk;
    public TemplateInfo templateInfo;
    public String themeType;
    public String tips;
    public int type;
    public File unzipFile;

    /* loaded from: classes6.dex */
    public static class EffectMusicData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cover;
        public String duration;
        public String id;
        public String localAssetsPath;
        public String musicFileName;
        public int musicType;
        public String musicZipPath;
        public String name;
        public int progress;
        public String singer;
        public String sk;

        public EffectMusicData() {
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
            this.musicType = 0;
        }
    }

    public EffectInfo() {
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
        this.isSelected = false;
        this.fixNum = 0;
    }

    public static boolean isCardTheme(EffectInfo effectInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, effectInfo)) == null) ? effectInfo != null && effectInfo.type == 1 : invokeL.booleanValue;
    }

    public static boolean isNormalTheme(EffectInfo effectInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, effectInfo)) == null) ? effectInfo != null && effectInfo.type == 0 : invokeL.booleanValue;
    }

    public static EffectInfo parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (EffectInfo) new nd9().b(str, EffectInfo.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (EffectInfo) invokeL.objValue;
    }

    public static EffectMusicData parseFrom(MusicData musicData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, musicData)) == null) {
            EffectMusicData effectMusicData = new EffectMusicData();
            effectMusicData.duration = musicData.duration;
            effectMusicData.cover = musicData.icon;
            effectMusicData.id = musicData.id;
            effectMusicData.name = musicData.title;
            effectMusicData.singer = musicData.singer;
            effectMusicData.sk = musicData.sk;
            effectMusicData.localAssetsPath = musicData.localPath;
            effectMusicData.musicType = musicData.musicType;
            return effectMusicData;
        }
        return (EffectMusicData) invokeL.objValue;
    }

    public static String toJSON(EffectInfo effectInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, effectInfo)) == null) {
            if (effectInfo == null) {
                return null;
            }
            try {
                return new nd9().a(effectInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof EffectInfo) {
                EffectInfo effectInfo = (EffectInfo) obj;
                String str = effectInfo.name;
                if (str == null) {
                    str = "";
                }
                effectInfo.name = str;
                String str2 = effectInfo.themeType;
                if (str2 == null) {
                    str2 = "";
                }
                effectInfo.themeType = str2;
                String str3 = this.name;
                if (str3 == null) {
                    str3 = "";
                }
                this.name = str3;
                String str4 = this.themeType;
                this.themeType = str4 != null ? str4 : "";
                return this.name.equals(effectInfo.name) && this.themeType.equals(effectInfo.themeType);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isResourceLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            File file = this.unzipFile;
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }
}
