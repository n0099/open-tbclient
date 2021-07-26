package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectKeyData;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.entity.EffectInfo;
import com.baidu.ugc.editvideo.record.entity.TemplateInfo;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.ImportExportConfigUtil;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.baidu.ugc.utils.FileUtils;
import d.a.a0.b.a.k.c;
import d.a.w0.j.b;
import d.a.w0.t.h;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes5.dex */
public class InnerImportExportConfigUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InnerImportExportConfigUtil() {
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

    /* JADX WARN: Removed duplicated region for block: B:111:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02e7 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaTrackConfig exportConfigJson(Map<String, ShaderConfig> map, List<MediaTrack> list, MultiMediaDataTrack multiMediaDataTrack, MediaTrackConfig mediaTrackConfig, String str) {
        InterceptResult invokeLLLLL;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        char c2;
        String str2;
        String str3;
        MediaAEffect mediaAEffect;
        ArrayList arrayList4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, map, list, multiMediaDataTrack, mediaTrackConfig, str)) == null) {
            List<MediaTrack> list2 = list;
            String str4 = str;
            MediaTrackConfig mediaTrackConfig2 = new MediaTrackConfig();
            if (mediaTrackConfig != null) {
                mediaTrackConfig2 = mediaTrackConfig.m18clone();
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            if (map != null) {
                for (Map.Entry<String, ShaderConfig> entry : map.entrySet()) {
                    if (!TextUtils.equals(entry.getKey(), c.f41273b) && !TextUtils.equals(entry.getKey(), c.f41276e) && (!TextUtils.equals(entry.getKey(), c.f41274c) || !h.e(entry.getValue().textures))) {
                        ShaderConfig shaderConfig = (ShaderConfig) entry.getValue().clone();
                        if (!TextUtils.isEmpty(shaderConfig.resourcePath)) {
                            File file = new File(shaderConfig.resourcePath);
                            if (file.exists() && file.isDirectory()) {
                                File[] listFiles = file.listFiles();
                                int length = listFiles.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        break;
                                    }
                                    File file2 = listFiles[i2];
                                    if (file2.getName().endsWith(".json")) {
                                        shaderConfig.resourcePath = file2.getParent();
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            hashMap2.put(entry.getKey(), entry.getValue().resourcePath);
                        }
                        List<MediaTextureData> list3 = shaderConfig.textures;
                        if (list3 != null) {
                            for (MediaTextureData mediaTextureData : list3) {
                                if (mediaTextureData.textureId != 0) {
                                    mediaTextureData.textureId = 0;
                                }
                            }
                        }
                        hashMap.put(entry.getKey(), shaderConfig);
                    }
                }
                mediaTrackConfig2.shaderResourceMap = hashMap2;
                mediaTrackConfig2.shaderConfigMapDebug = hashMap;
            }
            if (mediaTrackConfig != null && mediaTrackConfig.effectConfigMap != null) {
                mediaTrackConfig2.effectConfigMap = new LinkedHashMap();
                for (Map.Entry<String, MediaAEffect> entry2 : mediaTrackConfig.effectConfigMap.entrySet()) {
                    mediaTrackConfig2.effectConfigMap.put(entry2.getKey(), entry2.getValue().m15clone());
                }
            }
            ArrayList arrayList5 = new ArrayList();
            if (list2 != null) {
                mediaTrackConfig2.mediaTracks = new ArrayList();
                int i3 = 0;
                while (i3 < list.size()) {
                    MediaTrack mediaTrack = list2.get(i3);
                    if (TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT) || !c.l(mediaTrack, "input_blank")) {
                        if (!TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                            if (c.l(mediaTrack, "edit_sticker")) {
                                mediaTrack.mediaSegments = null;
                                mediaTrack.mediaTransitions = null;
                            }
                            if (!h.e(mediaTrack.mediaAEffectKeyData)) {
                                for (MediaAEffectKeyData mediaAEffectKeyData : mediaTrack.mediaAEffectKeyData) {
                                    mediaAEffectKeyData.effectConfigList = null;
                                }
                            }
                        }
                        MediaTrack mediaTrack2 = (MediaTrack) mediaTrack.clone();
                        if (mediaTrack.mediaSegments != null) {
                            ArrayList arrayList6 = new ArrayList();
                            int i4 = 0;
                            boolean z = false;
                            while (i4 < mediaTrack.mediaSegments.size()) {
                                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i4);
                                MediaSegment m17clone = mediaSegment.m17clone();
                                ArrayList arrayList7 = arrayList6;
                                if (TextUtils.equals(str4, "input") || TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_ONE_INPUT)) {
                                    m17clone.start = 0L;
                                    m17clone.end = 0L;
                                    m17clone.effectStart = 0L;
                                    m17clone.effectEnd = 0L;
                                }
                                String str5 = mediaSegment.type;
                                int hashCode = str5.hashCode();
                                ArrayList arrayList8 = arrayList5;
                                MediaTrack mediaTrack3 = mediaTrack2;
                                if (hashCode == -2060497896) {
                                    if (str5.equals(SubtitleLog.TAG)) {
                                        c2 = 2;
                                    }
                                    c2 = 65535;
                                } else if (hashCode != 761324464) {
                                    if (hashCode == 808915106 && str5.equals(MediaSegment.SEG_TYPE_INPUT_HEADER)) {
                                        c2 = 0;
                                    }
                                    c2 = 65535;
                                } else {
                                    if (str5.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER)) {
                                        c2 = 1;
                                    }
                                    c2 = 65535;
                                }
                                if (c2 == 0 || c2 == 1) {
                                    if (!TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                        m17clone.start = 0L;
                                        long j = mediaSegment.end;
                                        str2 = MediaSegment.SEG_TYPE_INPUT_HEADER;
                                        str3 = MediaSegment.SEG_TYPE_INPUT_FOOTER;
                                        m17clone.end = j - mediaSegment.start;
                                        m17clone.effectStart = 0L;
                                        m17clone.effectEnd = mediaSegment.effectEnd - mediaSegment.effectStart;
                                        if (i3 == 0) {
                                            String str6 = TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT) ? mediaSegment.type : "input";
                                            if (multiMediaDataTrack != null) {
                                                if (i4 == 0 && multiMediaDataTrack.hasHeader()) {
                                                    str6 = str2;
                                                } else {
                                                    if (i4 == mediaTrack.mediaSegments.size() - 1 && multiMediaDataTrack.hasFooter()) {
                                                        str6 = str3;
                                                    }
                                                    m17clone.type = str6;
                                                    if (!TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_ONE_INPUT) && TextUtils.equals(str6, "input") && z) {
                                                        arrayList4 = arrayList7;
                                                        i4++;
                                                        arrayList6 = arrayList4;
                                                        arrayList5 = arrayList8;
                                                        mediaTrack2 = mediaTrack3;
                                                    } else if (TextUtils.equals(str6, "input") && !z) {
                                                        z = true;
                                                    }
                                                }
                                            }
                                            m17clone.type = str6;
                                            if (!TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_ONE_INPUT)) {
                                            }
                                            if (TextUtils.equals(str6, "input")) {
                                                z = true;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                                            MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                                            if (mediaAEffect2 != null) {
                                                mediaSegment.effectConfigKey = TextUtils.isEmpty(mediaAEffect2.name) ? "exportEffect" + i4 : mediaSegment.mediaAEffect.name;
                                            }
                                        } else if (mediaSegment.mediaAEffect == null) {
                                            mediaAEffect = null;
                                            mediaSegment.effectConfigKey = null;
                                            m17clone.effectConfigKey = mediaSegment.effectConfigKey;
                                            if (TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                                m17clone.mediaAEffect = mediaSegment.mediaAEffect;
                                            } else {
                                                m17clone.mediaAEffect = mediaAEffect;
                                            }
                                            arrayList4 = arrayList7;
                                            arrayList4.add(m17clone);
                                            if (TextUtils.isEmpty(mediaSegment.effectConfigKey) && mediaSegment.mediaAEffect != null) {
                                                if (mediaTrackConfig2.effectConfigMap == null) {
                                                    mediaTrackConfig2.effectConfigMap = new LinkedHashMap();
                                                }
                                                mediaTrackConfig2.effectConfigMap.put(mediaSegment.effectConfigKey, mediaSegment.mediaAEffect);
                                            }
                                            i4++;
                                            arrayList6 = arrayList4;
                                            arrayList5 = arrayList8;
                                            mediaTrack2 = mediaTrack3;
                                        }
                                        mediaAEffect = null;
                                        m17clone.effectConfigKey = mediaSegment.effectConfigKey;
                                        if (TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                        }
                                        arrayList4 = arrayList7;
                                        arrayList4.add(m17clone);
                                        if (TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                                            if (mediaTrackConfig2.effectConfigMap == null) {
                                            }
                                            mediaTrackConfig2.effectConfigMap.put(mediaSegment.effectConfigKey, mediaSegment.mediaAEffect);
                                        }
                                        i4++;
                                        arrayList6 = arrayList4;
                                        arrayList5 = arrayList8;
                                        mediaTrack2 = mediaTrack3;
                                    }
                                } else if (c2 == 2) {
                                    m17clone.start = 0L;
                                    m17clone.end = 0L;
                                    m17clone.effectStart = 0L;
                                    m17clone.effectEnd = 0L;
                                }
                                str2 = MediaSegment.SEG_TYPE_INPUT_HEADER;
                                str3 = MediaSegment.SEG_TYPE_INPUT_FOOTER;
                                if (i3 == 0) {
                                }
                                if (!TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                                }
                                mediaAEffect = null;
                                m17clone.effectConfigKey = mediaSegment.effectConfigKey;
                                if (TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                }
                                arrayList4 = arrayList7;
                                arrayList4.add(m17clone);
                                if (TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                                }
                                i4++;
                                arrayList6 = arrayList4;
                                arrayList5 = arrayList8;
                                mediaTrack2 = mediaTrack3;
                            }
                            arrayList = arrayList5;
                            mediaTrack2.mediaSegments = arrayList6;
                        } else {
                            arrayList = arrayList5;
                        }
                        if (mediaTrack.mediaTransitions != null) {
                            HashSet hashSet = new HashSet();
                            int i5 = 0;
                            while (i5 < mediaTrack.mediaTransitions.size()) {
                                MediaTransition mediaTransition = new MediaTransition();
                                MediaTransition mediaTransition2 = mediaTrack.mediaTransitions.get(i5);
                                if (TextUtils.isEmpty(mediaTransition2.name) || (!TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT) && mediaTrack.transitionMode.equals("fixed") && hashSet.contains(mediaTransition2.name))) {
                                    arrayList3 = arrayList;
                                } else {
                                    hashSet.add(mediaTransition2.name);
                                    mediaTransition.duration = mediaTransition2.duration;
                                    if (TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_TEMPLATE) || TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                        mediaTransition.start = mediaTransition2.start;
                                        mediaTransition.end = mediaTransition2.end;
                                    }
                                    mediaTransition.shaderConfigKey = mediaTransition2.shaderConfigKey;
                                    mediaTransition.tParams = mediaTransition2.tParams;
                                    mediaTransition.name = mediaTransition2.name;
                                    arrayList3 = arrayList;
                                    arrayList3.add(mediaTransition);
                                }
                                i5++;
                                arrayList = arrayList3;
                            }
                            arrayList2 = arrayList;
                            mediaTrack2.mediaTransitions = TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_DRAFT) ? mediaTrack.mediaTransitions : null;
                        } else {
                            arrayList2 = arrayList;
                        }
                        MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                        if (mediaSegment2 != null) {
                            MediaSegment m17clone2 = mediaSegment2.m17clone();
                            setSuperpositionSegment(mediaTrackConfig2.effectConfigMap, mediaTrack.superpositionFooter, m17clone2, str4);
                            mediaTrack2.superpositionFooter = m17clone2;
                        }
                        MediaSegment mediaSegment3 = mediaTrack.superpositionHeader;
                        if (mediaSegment3 != null) {
                            MediaSegment m17clone3 = mediaSegment3.m17clone();
                            setSuperpositionSegment(mediaTrackConfig2.effectConfigMap, mediaTrack.superpositionHeader, m17clone3, str4);
                            mediaTrack2.superpositionHeader = m17clone3;
                        }
                        mediaTrackConfig2.mediaTracks.add(mediaTrack2);
                    } else {
                        arrayList2 = arrayList5;
                    }
                    i3++;
                    list2 = list;
                    arrayList5 = arrayList2;
                }
            }
            mediaTrackConfig2.transitionConfigs = arrayList5;
            if (TextUtils.equals(str4, MediaTrackConfig.AE_IMPORT_ONE_INPUT)) {
                str4 = "input";
            }
            mediaTrackConfig2.importType = str4;
            return mediaTrackConfig2;
        }
        return (MediaTrackConfig) invokeLLLLL.objValue;
    }

    public static String exportEffectsWithShader(Context context, String str, MediaAEffect mediaAEffect, ShaderConfig shaderConfig) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, mediaAEffect, shaderConfig)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.mkdirs();
                File file2 = new File(file.getAbsolutePath() + File.separator + "effect_config.json");
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(new b().a(mediaAEffect).getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                ShaderConfig shaderConfig2 = new ShaderConfig();
                String parent = !TextUtils.isEmpty(shaderConfig.resourcePath) ? new File(shaderConfig.resourcePath).getParent() : "";
                String str2 = shaderConfig.fragmentShader;
                String str3 = shaderConfig.vertexShader;
                if (!TextUtils.isEmpty(str2) && !str2.contains("default")) {
                    String f2 = c.f(context, parent, str2, "");
                    if (!TextUtils.isEmpty(f2)) {
                        if (!str2.endsWith(".glsl")) {
                            str2 = str2 + ".glsl";
                        }
                        File file3 = new File(file, str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        fileOutputStream2.write(f2.getBytes());
                        fileOutputStream2.close();
                    }
                }
                if (!TextUtils.isEmpty(str3) && !str3.contains("default")) {
                    String j = c.j(context, parent, str3);
                    if (!TextUtils.isEmpty(j)) {
                        if (!str3.endsWith(".glsl")) {
                            str3 = str3 + ".glsl";
                        }
                        File file4 = new File(file, str3);
                        if (!file4.exists()) {
                            file4.createNewFile();
                        }
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file4);
                        fileOutputStream3.write(j.getBytes());
                        fileOutputStream3.close();
                    }
                }
                shaderConfig2.fragmentShader = str2;
                shaderConfig2.vertexShader = str3;
                shaderConfig2.fParams = shaderConfig.fParams;
                shaderConfig2.vParams = shaderConfig.vParams;
                shaderConfig2.resourcePath = null;
                List<MediaTextureData> mediaTextureDates = getMediaTextureDates(context, shaderConfig, file, str, null);
                if (mediaTextureDates.size() > 0) {
                    shaderConfig2.textures = mediaTextureDates;
                }
                FileOutputStream fileOutputStream4 = new FileOutputStream(new File(file, "shader_config.json"));
                fileOutputStream4.write(new b().a(shaderConfig2).getBytes());
                fileOutputStream4.close();
                File file5 = new File(file.getParent(), mediaAEffect.name + ".zip");
                file5.createNewFile();
                FileOutputStream fileOutputStream5 = new FileOutputStream(file5);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream5);
                zipFile(file, file.getName(), zipOutputStream, "");
                zipOutputStream.close();
                fileOutputStream5.close();
                String path = file5.getPath();
                FileUtils.deleteFileOrDir(file);
                return path;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String exportTempInfoZip(Context context, String str, TemplateInfo templateInfo, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        InterceptResult invokeLLLLL;
        MediaTrackConfig mediaTrackConfig2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, context, str, templateInfo, mediaTrackConfig, onExportListener)) == null) {
            if (mediaTrackConfig == null || context == null || TextUtils.isEmpty(str) || templateInfo == null || (mediaTrackConfig2 = templateInfo.trackConfig) == null) {
                return null;
            }
            String str2 = mediaTrackConfig2.name;
            String str3 = str + str2 + File.separator;
            String str4 = str3 + "shader";
            String str5 = str3 + AnimatedStateListDrawableCompat.ELEMENT_TRANSITION;
            String str6 = str3 + MediaTrackConfig.AE_TEMPLATE_TYPE_MUSIC;
            String str7 = str3 + "effect";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str4);
            if (file2.exists()) {
                file2.delete();
            } else {
                file2.mkdirs();
            }
            File file3 = new File(str5);
            if (file3.exists()) {
                file3.delete();
            }
            file3.mkdirs();
            File file4 = new File(str6);
            if (file4.exists()) {
                file4.delete();
            }
            file4.mkdirs();
            File file5 = new File(str7);
            if (file5.exists()) {
                file5.delete();
            }
            file5.mkdirs();
            TemplateInfo templateInfo2 = new TemplateInfo();
            templateInfo2.id = mediaTrackConfig.id;
            templateInfo2.name = mediaTrackConfig.name;
            String str8 = "";
            templateInfo2.resourcePath = "";
            templateInfo2.version = "v2.11.0";
            templateInfo2.filter = templateInfo.filter;
            EffectInfo.EffectMusicData effectMusicData = templateInfo.music;
            templateInfo2.music = effectMusicData;
            templateInfo2.textStyleEntity = templateInfo.textStyleEntity;
            templateInfo2.textFontEntity = templateInfo.textFontEntity;
            if (effectMusicData == null) {
                file4.delete();
            }
            Map<String, String> shaderResourceMap = getShaderResourceMap(context, str3, file2, mediaTrackConfig, onExportListener);
            if (shaderResourceMap.size() > 0) {
                mediaTrackConfig.shaderResourceMap = shaderResourceMap;
            } else {
                file2.delete();
            }
            mediaTrackConfig.shaderConfigMapDebug = null;
            List<String> transitionResourceList = getTransitionResourceList(file3, mediaTrackConfig, onExportListener);
            if (h.e(transitionResourceList)) {
                file3.delete();
            } else {
                mediaTrackConfig.transitionResourceList = transitionResourceList;
                mediaTrackConfig.transitionConfigs = null;
            }
            Map<String, String> effectResourceMap = getEffectResourceMap(file5, mediaTrackConfig, onExportListener);
            if (effectResourceMap.size() > 0) {
                mediaTrackConfig.effectResourceMap = effectResourceMap;
                mediaTrackConfig.effectConfigMap = null;
            } else {
                file5.delete();
            }
            templateInfo2.trackConfig = mediaTrackConfig;
            File file6 = new File(str3, "theme_config.json");
            try {
                if (!file6.exists()) {
                    file6.createNewFile();
                }
                String a2 = new b().a(templateInfo2);
                FileOutputStream fileOutputStream = new FileOutputStream(file6);
                fileOutputStream.write(a2.getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                if (onExportListener != null) {
                    onExportListener.onExportFail("导出theme_config.json 失败 ，msg" + e2.getLocalizedMessage());
                }
            }
            try {
                File file7 = new File(str, str2 + ".zip");
                file7.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file7);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream2);
                zipFile(file, file.getName(), zipOutputStream, "");
                zipOutputStream.close();
                fileOutputStream2.close();
                str8 = file7.getPath();
                FileUtils.deleteFileOrDir(file);
                if (onExportListener != null) {
                    onExportListener.onExportSuccess(str8);
                }
            } catch (Exception e3) {
                if (onExportListener != null) {
                    onExportListener.onExportFail("压缩" + str8 + "文件失败 , msg " + e3.getLocalizedMessage());
                }
            }
            return str8;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String exportTransitionWithShader(Context context, String str, MediaTransition mediaTransition, String str2, ShaderConfig shaderConfig) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, mediaTransition, str2, shaderConfig)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.mkdirs();
                File file2 = new File(file.getAbsolutePath() + File.separator + mediaTransition.name + ".json");
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(new b().a(mediaTransition).getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                ShaderConfig shaderConfig2 = new ShaderConfig();
                String parent = !TextUtils.isEmpty(shaderConfig.resourcePath) ? new File(shaderConfig.resourcePath).getParent() : "";
                String str3 = shaderConfig.fragmentShader;
                String str4 = shaderConfig.vertexShader;
                if (!TextUtils.isEmpty(str3) && !str3.contains("default")) {
                    String f2 = c.f(context, parent, str3, "");
                    if (!TextUtils.isEmpty(f2)) {
                        if (!str3.endsWith(".glsl")) {
                            str3 = str3 + ".glsl";
                        }
                        File file3 = new File(file, str3);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        fileOutputStream2.write(f2.getBytes());
                        fileOutputStream2.close();
                    }
                }
                if (!TextUtils.isEmpty(str4) && !str4.contains("default")) {
                    String j = c.j(context, parent, str4);
                    if (!TextUtils.isEmpty(j)) {
                        if (!str4.endsWith(".glsl")) {
                            str4 = str4 + ".glsl";
                        }
                        File file4 = new File(file, str4);
                        if (!file4.exists()) {
                            file4.createNewFile();
                        }
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file4);
                        fileOutputStream3.write(j.getBytes());
                        fileOutputStream3.close();
                    }
                }
                shaderConfig2.fragmentShader = str3;
                shaderConfig2.vertexShader = str4;
                shaderConfig2.fParams = shaderConfig.fParams;
                shaderConfig2.vParams = shaderConfig.vParams;
                shaderConfig2.resourcePath = null;
                List<MediaTextureData> mediaTextureDates = getMediaTextureDates(context, shaderConfig, file, str, null);
                if (mediaTextureDates.size() > 0) {
                    shaderConfig2.textures = mediaTextureDates;
                }
                FileOutputStream fileOutputStream4 = new FileOutputStream(new File(file, str2 + ".json"));
                fileOutputStream4.write(new b().a(shaderConfig2).getBytes());
                fileOutputStream4.close();
                File file5 = new File(file.getParent(), mediaTransition.name + ".zip");
                file5.createNewFile();
                FileOutputStream fileOutputStream5 = new FileOutputStream(file5);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream5);
                zipFile(file, file.getName(), zipOutputStream, "");
                zipOutputStream.close();
                fileOutputStream5.close();
                String path = file5.getPath();
                FileUtils.deleteFileOrDir(file);
                return path;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLLLLL.objValue;
    }

    public static Map<String, String> getEffectResourceMap(File file, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, file, mediaTrackConfig, onExportListener)) == null) {
            HashMap hashMap = new HashMap();
            Map<String, MediaAEffect> map = mediaTrackConfig.effectConfigMap;
            if (map != null) {
                for (Map.Entry<String, MediaAEffect> entry : map.entrySet()) {
                    String key = entry.getKey();
                    File file2 = new File(file, key + ".json");
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        try {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(new b().a(entry.getValue()).getBytes());
                        fileOutputStream.flush();
                        hashMap.put(key, file.getName() + File.separator + file2.getName());
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (onExportListener != null) {
                            onExportListener.onExportFail("导出 effect_config.json 失败 ，msg " + e.getLocalizedMessage());
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db A[SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<MediaTextureData> getMediaTextureDates(Context context, ShaderConfig shaderConfig, File file, String str, ImportExportConfigUtil.OnExportListener onExportListener) throws IOException {
        InterceptResult invokeLLLLL;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, shaderConfig, file, str, onExportListener)) == null) {
            ArrayList arrayList = new ArrayList();
            List<MediaTextureData> list = shaderConfig.textures;
            if (list != null) {
                for (MediaTextureData mediaTextureData : list) {
                    if (MediaTextureData.TEXTURE_VIDEO.equals(mediaTextureData.type) || TextUtils.isEmpty(mediaTextureData.path)) {
                        if (!TextUtils.isEmpty(mediaTextureData.path) && mediaTextureData.path.contains(File.separator)) {
                            File file2 = new File(mediaTextureData.path);
                            File file3 = null;
                            if (file2.exists()) {
                                file3 = new File(file, file2.getName());
                                if (!file3.exists()) {
                                    file3.createNewFile();
                                }
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr, 0, 2048);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                                bufferedInputStream.close();
                                bufferedOutputStream.close();
                            }
                            if (file3 != null) {
                                name = file3.getName();
                            }
                        }
                        if (mediaTextureData.textureId == 0) {
                            mediaTextureData.textureId = 0;
                        }
                        arrayList.add(mediaTextureData);
                    } else {
                        name = mediaTextureData.path;
                        if (name.contains(File.separator)) {
                            name = name.substring(name.lastIndexOf(File.separator) + 1);
                        }
                        if (!name.contains(".")) {
                            name = mediaTextureData.path + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
                        }
                        FileUtils.saveBitmap2PNG(file.getPath(), name, c.g(context, mediaTextureData.path), 100);
                    }
                    mediaTextureData.path = name;
                    if (mediaTextureData.textureId == 0) {
                    }
                    arrayList.add(mediaTextureData);
                }
            }
            return arrayList;
        }
        return (List) invokeLLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0100 A[Catch: IOException -> 0x0185, TryCatch #1 {IOException -> 0x0185, blocks: (B:29:0x00b1, B:31:0x00c3, B:33:0x00ce, B:34:0x00d1, B:38:0x00ea, B:40:0x00f0, B:42:0x00f6, B:44:0x0100, B:46:0x0106, B:47:0x0115, B:49:0x0120, B:50:0x0123, B:51:0x0132, B:53:0x015d, B:54:0x015f), top: B:73:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015d A[Catch: IOException -> 0x0185, TryCatch #1 {IOException -> 0x0185, blocks: (B:29:0x00b1, B:31:0x00c3, B:33:0x00ce, B:34:0x00d1, B:38:0x00ea, B:40:0x00f0, B:42:0x00f6, B:44:0x0100, B:46:0x0106, B:47:0x0115, B:49:0x0120, B:50:0x0123, B:51:0x0132, B:53:0x015d, B:54:0x015f), top: B:73:0x00b1 }] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> getShaderResourceMap(Context context, String str, File file, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        InterceptResult invokeLLLLL;
        Iterator<Map.Entry<String, ShaderConfig>> it;
        HashMap hashMap;
        List<MediaTextureData> mediaTextureDates;
        String j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, context, str, file, mediaTrackConfig, onExportListener)) == null) {
            HashMap hashMap2 = new HashMap();
            Map<String, ShaderConfig> map = mediaTrackConfig.shaderConfigMapDebug;
            if (map != null) {
                Iterator<Map.Entry<String, ShaderConfig>> it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry<String, ShaderConfig> next = it2.next();
                    String key = next.getKey();
                    File file2 = new File(file, key);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    File file3 = new File(file2, "shader_config.json");
                    if (file3.exists()) {
                        it = it2;
                    } else {
                        try {
                            file3.createNewFile();
                            ShaderConfig shaderConfig = new ShaderConfig();
                            String parent = !TextUtils.isEmpty(next.getValue().resourcePath) ? new File(next.getValue().resourcePath).getParent() : "";
                            String str2 = next.getValue().fragmentShader;
                            String str3 = next.getValue().vertexShader;
                            it = it2;
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    if (!str2.contains("default")) {
                                        String f2 = c.f(context, parent, str2, next.getKey());
                                        if (!TextUtils.isEmpty(f2)) {
                                            if (str2.endsWith(".glsl")) {
                                                hashMap = hashMap2;
                                            } else {
                                                hashMap = hashMap2;
                                                try {
                                                    str2 = str2 + ".glsl";
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    hashMap2 = hashMap;
                                                    if (onExportListener != null) {
                                                        onExportListener.onExportFail("导出 shader_config.json 失败 ，msg " + e.getLocalizedMessage());
                                                    }
                                                    it2 = it;
                                                }
                                            }
                                            File file4 = new File(file2, str2);
                                            if (!file4.exists()) {
                                                file4.createNewFile();
                                            }
                                            String str4 = str2;
                                            FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                            fileOutputStream.write(f2.getBytes());
                                            fileOutputStream.close();
                                            str2 = str4;
                                            if (!TextUtils.isEmpty(str3) && !str3.contains("default")) {
                                                j = c.j(context, parent, str3);
                                                if (!TextUtils.isEmpty(j)) {
                                                    if (!str3.endsWith(".glsl")) {
                                                        str3 = str3 + ".glsl";
                                                    }
                                                    File file5 = new File(file2, str3);
                                                    if (!file5.exists()) {
                                                        file5.createNewFile();
                                                    }
                                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file5);
                                                    fileOutputStream2.write(j.getBytes());
                                                    fileOutputStream2.close();
                                                }
                                            }
                                            shaderConfig.fragmentShader = str2;
                                            shaderConfig.vertexShader = str3;
                                            shaderConfig.fParams = next.getValue().fParams;
                                            shaderConfig.vParams = next.getValue().vParams;
                                            shaderConfig.resourcePath = null;
                                            mediaTextureDates = getMediaTextureDates(context, next.getValue(), file2, str, onExportListener);
                                            if (mediaTextureDates.size() > 0) {
                                                shaderConfig.textures = mediaTextureDates;
                                            }
                                            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                                            fileOutputStream3.write(new b().a(shaderConfig).getBytes());
                                            fileOutputStream3.close();
                                            hashMap2 = hashMap;
                                            hashMap2.put(key, file3.getPath().replace(str, ""));
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            }
                            hashMap = hashMap2;
                            if (!TextUtils.isEmpty(str3)) {
                                j = c.j(context, parent, str3);
                                if (!TextUtils.isEmpty(j)) {
                                }
                            }
                            shaderConfig.fragmentShader = str2;
                            shaderConfig.vertexShader = str3;
                            shaderConfig.fParams = next.getValue().fParams;
                            shaderConfig.vParams = next.getValue().vParams;
                            shaderConfig.resourcePath = null;
                            mediaTextureDates = getMediaTextureDates(context, next.getValue(), file2, str, onExportListener);
                            if (mediaTextureDates.size() > 0) {
                            }
                            FileOutputStream fileOutputStream32 = new FileOutputStream(file3);
                            fileOutputStream32.write(new b().a(shaderConfig).getBytes());
                            fileOutputStream32.close();
                            hashMap2 = hashMap;
                            hashMap2.put(key, file3.getPath().replace(str, ""));
                        } catch (IOException e4) {
                            e = e4;
                            it = it2;
                        }
                    }
                    it2 = it;
                }
            }
            return hashMap2;
        }
        return (Map) invokeLLLLL.objValue;
    }

    public static List<String> getTransitionResourceList(File file, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, file, mediaTrackConfig, onExportListener)) == null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            List<MediaTransition> list = mediaTrackConfig.transitionConfigs;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MediaTransition mediaTransition = mediaTrackConfig.transitionConfigs.get(i2);
                    String str = mediaTransition.name;
                    if (hashSet.contains(str)) {
                        str = str + i2;
                    }
                    hashSet.add(str);
                    File file2 = new File(file, str + ".json");
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        try {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(new b().a(mediaTransition).getBytes());
                        fileOutputStream.flush();
                        arrayList.add(file.getName() + File.separator + file2.getName());
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (onExportListener != null) {
                            onExportListener.onExportFail("导出 transition_config.json 失败 ，msg " + e.getLocalizedMessage());
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static void setSuperpositionSegment(Map<String, MediaAEffect> map, MediaSegment mediaSegment, MediaSegment mediaSegment2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65545, null, map, mediaSegment, mediaSegment2, str) == null) || mediaSegment == null || mediaSegment2 == null) {
            return;
        }
        if (!TextUtils.equals(str, MediaTrackConfig.AE_IMPORT_DRAFT)) {
            mediaSegment2.start = 0L;
            long j = mediaSegment.end;
            long j2 = mediaSegment.start;
            mediaSegment2.end = j - j2;
            mediaSegment2.effectStart = 0L;
            mediaSegment2.effectEnd = mediaSegment.effectEnd - j2;
        }
        if (!TextUtils.isEmpty(mediaSegment.effectConfigKey) && mediaSegment.mediaAEffect != null) {
            if (map == null) {
                map = new LinkedHashMap<>();
            }
            map.put(mediaSegment.effectConfigKey, mediaSegment.mediaAEffect);
        }
        mediaSegment2.mediaAEffect = TextUtils.equals(str, MediaTrackConfig.AE_IMPORT_DRAFT) ? mediaSegment.mediaAEffect : null;
    }

    public static void zipFile(File file, String str, ZipOutputStream zipOutputStream, String str2) throws IOException {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65546, null, file, str, zipOutputStream, str2) != null) {
            return;
        }
        if (file.isDirectory()) {
            ZipEntry zipEntry = str.endsWith("/") ? new ZipEntry(str) : new ZipEntry(str + "/");
            if (!str.equals(str2)) {
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.closeEntry();
            }
            String replace = str.replace(str2, "");
            for (File file2 : file.listFiles()) {
                zipFile(file2, replace + File.separator + file2.getName(), zipOutputStream, str2);
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        zipOutputStream.putNextEntry(new ZipEntry(str));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                fileInputStream.close();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }
}
