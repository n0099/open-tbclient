package com.baidu.ugc.editvideo.record.entity;

import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.dab;
import com.baidu.tieba.o9b;
import com.baidu.tieba.v6b;
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
/* loaded from: classes9.dex */
public class TemplateInfo implements Serializable {
    public static String TEMPLATE_FILE_NAME = "theme_config.json";
    public TemplateFiler filter;
    public String id;
    public boolean isSelected = false;
    public EffectInfo.EffectMusicData music;
    public String name;
    public String resourcePath;
    public TextWordsEntity.TextFontEntity textFontEntity;
    public TextWordsEntity.TextStyleEntity textStyleEntity;
    public MediaTrackConfig trackConfig;
    public String version;
    public String zipPath;

    /* loaded from: classes9.dex */
    public static class TemplateFiler implements Serializable {
        public String bgurl;
        public String id;
        public float level = 1.0f;
        public String name;
        public String param;
        public Object tag;
    }

    public static TemplateInfo getTemplateInfo(String str) {
        if (dab.a(str)) {
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

    public static void packageBgRes(MediaTrackConfig mediaTrackConfig, String str) {
        if (!TextUtils.isEmpty(str) && mediaTrackConfig != null && !TextUtils.isEmpty(mediaTrackConfig.bgRes)) {
            mediaTrackConfig.bgRes = str + File.separator + mediaTrackConfig.bgRes;
        }
    }

    public static void packageEffectConfigMap(MediaTrackConfig mediaTrackConfig, String str) {
        if (!TextUtils.isEmpty(str) && mediaTrackConfig != null && !o9b.f(mediaTrackConfig.effectResourceMap)) {
            if (mediaTrackConfig.effectConfigMap == null) {
                mediaTrackConfig.effectConfigMap = new LinkedHashMap();
            }
            v6b v6bVar = new v6b();
            for (Map.Entry<String, String> entry : mediaTrackConfig.effectResourceMap.entrySet()) {
                mediaTrackConfig.effectConfigMap.put(entry.getKey(), (MediaAEffect) v6bVar.b(FileUtils.readText(new File(str + File.separator + entry.getValue())), MediaAEffect.class));
            }
            mediaTrackConfig.effectResourceMap = null;
        }
    }

    public static void packageShaderConfigMap(MediaTrackConfig mediaTrackConfig, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && mediaTrackConfig != null) {
            v6b v6bVar = new v6b();
            Map<String, String> map = mediaTrackConfig.shaderResourceMap;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String str2 = str + File.separator + entry.getValue();
                    ShaderConfig shaderConfig = (ShaderConfig) v6bVar.b(FileUtils.readText(new File(str2)), ShaderConfig.class);
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
                        if (!o9b.e(list2)) {
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

    public static void packageTransitionList(MediaTrackConfig mediaTrackConfig, String str) {
        if (!TextUtils.isEmpty(str) && mediaTrackConfig != null && !o9b.e(mediaTrackConfig.transitionResourceList)) {
            ArrayList arrayList = new ArrayList();
            v6b v6bVar = new v6b();
            int b = o9b.b(mediaTrackConfig.transitionResourceList);
            for (int i = 0; i < b; i++) {
                arrayList.add((MediaTransition) v6bVar.b(FileUtils.readText(new File(str + File.separator + ((String) o9b.c(mediaTrackConfig.transitionResourceList, i)))), MediaTransition.class));
            }
            mediaTrackConfig.transitionConfigs = arrayList;
            mediaTrackConfig.transitionResourceList = null;
        }
    }

    public static TemplateInfo readConfig(String str) {
        File file;
        String readText;
        if (str == null || "".equals(str) || (readText = FileUtils.readText((file = new File(str)))) == null || "".equals(readText)) {
            return null;
        }
        TemplateInfo templateInfo = (TemplateInfo) new v6b().b(readText, TemplateInfo.class);
        if (templateInfo != null) {
            templateInfo.resourcePath = file.getParent();
        }
        return templateInfo;
    }

    public static String toJSON(TemplateInfo templateInfo) {
        if (templateInfo == null) {
            return null;
        }
        try {
            return new v6b().a(templateInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
