package com.baidu.ugc.editvideo.record.entity;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.ay9;
import com.baidu.tieba.lx9;
import com.baidu.tieba.su9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.record.entity.EffectInfo;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class TemplateInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TEMPLATE_FILE_NAME = "theme_config.json";
    public transient /* synthetic */ FieldHolder $fh;
    public TemplateFiler filter;
    public String id;
    public boolean isSelected;
    public EffectInfo.EffectMusicData music;
    public String name;
    public String resourcePath;
    public TextWordsEntity.TextFontEntity textFontEntity;
    public TextWordsEntity.TextStyleEntity textStyleEntity;
    public MediaTrackConfig trackConfig;
    public String version;
    public String zipPath;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(20241275, "Lcom/baidu/ugc/editvideo/record/entity/TemplateInfo;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(20241275, "Lcom/baidu/ugc/editvideo/record/entity/TemplateInfo;");
        }
    }

    /* loaded from: classes7.dex */
    public static class TemplateFiler implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bgurl;
        public String id;
        public float level;
        public String name;
        public String param;
        public Object tag;

        public TemplateFiler() {
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
            this.level = 1.0f;
        }
    }

    public TemplateInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSelected = false;
    }

    public static TemplateInfo getTemplateInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (ay9.a(str)) {
                return null;
            }
            String str2 = str + File.separator + TEMPLATE_FILE_NAME;
            if (!FileUtils.isExists(str2)) {
                return null;
            }
            try {
                TemplateInfo readConfig = readConfig(str2);
                if (readConfig != null) {
                    packageShaderConfigMap(readConfig.trackConfig, readConfig.resourcePath);
                    packageTransitionList(readConfig.trackConfig, readConfig.resourcePath);
                    packageEffectConfigMap(readConfig.trackConfig, readConfig.resourcePath);
                    packageBgRes(readConfig.trackConfig, readConfig.resourcePath);
                }
                return readConfig;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (TemplateInfo) invokeL.objValue;
    }

    public static TemplateInfo readConfig(String str) {
        InterceptResult invokeL;
        File file;
        String readText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null || "".equals(str) || (readText = FileUtils.readText((file = new File(str)))) == null || "".equals(readText)) {
                return null;
            }
            TemplateInfo templateInfo = (TemplateInfo) new su9().b(readText, TemplateInfo.class);
            if (templateInfo != null) {
                templateInfo.resourcePath = file.getParent();
            }
            return templateInfo;
        }
        return (TemplateInfo) invokeL.objValue;
    }

    public static void packageBgRes(MediaTrackConfig mediaTrackConfig, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, mediaTrackConfig, str) == null) && !TextUtils.isEmpty(str) && mediaTrackConfig != null && !TextUtils.isEmpty(mediaTrackConfig.bgRes)) {
            mediaTrackConfig.bgRes = str + File.separator + mediaTrackConfig.bgRes;
        }
    }

    public static void packageEffectConfigMap(MediaTrackConfig mediaTrackConfig, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaTrackConfig, str) == null) && !TextUtils.isEmpty(str) && mediaTrackConfig != null && !lx9.f(mediaTrackConfig.effectResourceMap)) {
            if (mediaTrackConfig.effectConfigMap == null) {
                mediaTrackConfig.effectConfigMap = new LinkedHashMap();
            }
            su9 su9Var = new su9();
            for (Map.Entry<String, String> entry : mediaTrackConfig.effectResourceMap.entrySet()) {
                mediaTrackConfig.effectConfigMap.put(entry.getKey(), (MediaAEffect) su9Var.b(FileUtils.readText(new File(str + File.separator + entry.getValue())), MediaAEffect.class));
            }
            mediaTrackConfig.effectResourceMap = null;
        }
    }

    public static void packageTransitionList(MediaTrackConfig mediaTrackConfig, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, mediaTrackConfig, str) == null) && !TextUtils.isEmpty(str) && mediaTrackConfig != null && !lx9.e(mediaTrackConfig.transitionResourceList)) {
            ArrayList arrayList = new ArrayList();
            su9 su9Var = new su9();
            int b = lx9.b(mediaTrackConfig.transitionResourceList);
            for (int i = 0; i < b; i++) {
                arrayList.add((MediaTransition) su9Var.b(FileUtils.readText(new File(str + File.separator + ((String) lx9.c(mediaTrackConfig.transitionResourceList, i)))), MediaTransition.class));
            }
            mediaTrackConfig.transitionConfigs = arrayList;
            mediaTrackConfig.transitionResourceList = null;
        }
    }

    public static void packageShaderConfigMap(MediaTrackConfig mediaTrackConfig, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, mediaTrackConfig, str) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && mediaTrackConfig != null) {
                su9 su9Var = new su9();
                Map<String, String> map = mediaTrackConfig.shaderResourceMap;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String str2 = str + File.separator + entry.getValue();
                        ShaderConfig shaderConfig = (ShaderConfig) su9Var.b(FileUtils.readText(new File(str2)), ShaderConfig.class);
                        shaderConfig.resourcePath = new File(str2).getParent();
                        hashMap.put(entry.getKey(), shaderConfig);
                        List<MediaTextureData> list = shaderConfig.textures;
                        if (list != null) {
                            for (MediaTextureData mediaTextureData : list) {
                                if (!TextUtils.isEmpty(mediaTextureData.path)) {
                                    if (mediaTextureData.path.contains(File.separator)) {
                                        mediaTextureData.path = str + File.separator + mediaTextureData.path;
                                    } else {
                                        mediaTextureData.path = shaderConfig.resourcePath + File.separator + mediaTextureData.path;
                                    }
                                }
                            }
                        }
                    }
                    mediaTrackConfig.shaderConfigMapDebug = hashMap;
                    return;
                }
                Map<String, ShaderConfig> map2 = mediaTrackConfig.shaderConfigMapDebug;
                if (map2 != null) {
                    for (Map.Entry<String, ShaderConfig> entry2 : map2.entrySet()) {
                        ShaderConfig value = entry2.getValue();
                        if (value != null) {
                            List<MediaTextureData> list2 = value.textures;
                            if (!lx9.e(list2)) {
                                for (MediaTextureData mediaTextureData2 : list2) {
                                    if (!TextUtils.isEmpty(mediaTextureData2.path) && mediaTextureData2.path.contains(File.separator)) {
                                        mediaTextureData2.path = str + mediaTextureData2.path;
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
                mediaTrackConfig.shaderConfigMapDebug = hashMap;
            }
        }
    }

    public static String toJSON(TemplateInfo templateInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, templateInfo)) == null) {
            if (templateInfo == null) {
                return null;
            }
            try {
                return new su9().a(templateInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
