package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectKeyData;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.ah0;
import com.baidu.tieba.fgb;
import com.baidu.tieba.mdb;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.entity.EffectInfo;
import com.baidu.ugc.editvideo.record.entity.TemplateInfo;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.ImportExportConfigUtil;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.baidu.ugc.utils.FileUtils;
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
/* loaded from: classes9.dex */
public class InnerImportExportConfigUtil {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaTrackConfig exportConfigJson(Map<String, ShaderConfig> map, List<MediaTrack> list, MultiMediaDataTrack multiMediaDataTrack, MediaTrackConfig mediaTrackConfig, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MediaTrackConfig mediaTrackConfig2;
        MediaTrack mediaTrack;
        String str2;
        MediaAEffect mediaAEffect;
        ArrayList arrayList4;
        char c;
        List<MediaTrack> list2 = list;
        String str3 = str;
        MediaTrackConfig mediaTrackConfig3 = new MediaTrackConfig();
        if (mediaTrackConfig != null) {
            mediaTrackConfig3 = mediaTrackConfig.m50clone();
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, ShaderConfig> entry : map.entrySet()) {
                if (!TextUtils.equals(entry.getKey(), ah0.b) && !TextUtils.equals(entry.getKey(), ah0.e) && (!TextUtils.equals(entry.getKey(), ah0.c) || !fgb.e(entry.getValue().textures))) {
                    ShaderConfig shaderConfig = (ShaderConfig) entry.getValue().clone();
                    if (!TextUtils.isEmpty(shaderConfig.resourcePath)) {
                        File file = new File(shaderConfig.resourcePath);
                        if (file.exists() && file.isDirectory()) {
                            File[] listFiles = file.listFiles();
                            int length = listFiles.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                File file2 = listFiles[i];
                                if (file2.getName().endsWith(".json")) {
                                    shaderConfig.resourcePath = file2.getParent();
                                    break;
                                }
                                i++;
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
            mediaTrackConfig3.shaderResourceMap = hashMap2;
            mediaTrackConfig3.shaderConfigMapDebug = hashMap;
        }
        if (mediaTrackConfig != null && mediaTrackConfig.effectConfigMap != null) {
            mediaTrackConfig3.effectConfigMap = new LinkedHashMap();
            for (Map.Entry<String, MediaAEffect> entry2 : mediaTrackConfig.effectConfigMap.entrySet()) {
                mediaTrackConfig3.effectConfigMap.put(entry2.getKey(), entry2.getValue().m47clone());
            }
        }
        ArrayList arrayList5 = new ArrayList();
        if (list2 != null) {
            mediaTrackConfig3.mediaTracks = new ArrayList();
            int i2 = 0;
            while (i2 < list.size()) {
                MediaTrack mediaTrack2 = list2.get(i2);
                if (TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT) || !ah0.m(mediaTrack2, "input_blank")) {
                    if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                        if (ah0.m(mediaTrack2, "edit_sticker")) {
                            mediaTrack2.mediaSegments = null;
                            mediaTrack2.mediaTransitions = null;
                        }
                        if (!fgb.e(mediaTrack2.mediaAEffectKeyData)) {
                            for (MediaAEffectKeyData mediaAEffectKeyData : mediaTrack2.mediaAEffectKeyData) {
                                mediaAEffectKeyData.calculateEffectKeys = null;
                            }
                        }
                    }
                    MediaTrack mediaTrack3 = (MediaTrack) mediaTrack2.clone();
                    if (mediaTrack2.mediaSegments != null) {
                        ArrayList arrayList6 = new ArrayList();
                        int i3 = 0;
                        boolean z = false;
                        while (i3 < mediaTrack2.mediaSegments.size()) {
                            MediaSegment mediaSegment = mediaTrack2.mediaSegments.get(i3);
                            MediaSegment m49clone = mediaSegment.m49clone();
                            ArrayList arrayList7 = arrayList6;
                            if (TextUtils.equals(str3, "input") || TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_ONE_INPUT)) {
                                m49clone.start = 0L;
                                m49clone.end = 0L;
                                m49clone.effectStart = 0L;
                                m49clone.effectEnd = 0L;
                            }
                            boolean isEmpty = TextUtils.isEmpty(mediaSegment.type);
                            String str4 = MediaSegment.SEG_TYPE_INPUT_HEADER;
                            ArrayList arrayList8 = arrayList5;
                            if (isEmpty) {
                                mediaTrackConfig2 = mediaTrackConfig3;
                                mediaTrack = mediaTrack3;
                            } else {
                                String str5 = mediaSegment.type;
                                int hashCode = str5.hashCode();
                                mediaTrack = mediaTrack3;
                                mediaTrackConfig2 = mediaTrackConfig3;
                                if (hashCode == -2060497896) {
                                    if (str5.equals(SubtitleLog.TAG)) {
                                        c = 2;
                                        if (c != 0) {
                                        }
                                        if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                        }
                                    }
                                    c = 65535;
                                    if (c != 0) {
                                    }
                                    if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                    }
                                } else if (hashCode != 761324464) {
                                    if (hashCode == 808915106 && str5.equals(MediaSegment.SEG_TYPE_INPUT_HEADER)) {
                                        c = 0;
                                        if (c != 0 || c == 1) {
                                            if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                                m49clone.start = 0L;
                                                long j = mediaSegment.end;
                                                str2 = MediaSegment.SEG_TYPE_INPUT_FOOTER;
                                                m49clone.end = j - mediaSegment.start;
                                                m49clone.effectStart = 0L;
                                                m49clone.effectEnd = mediaSegment.effectEnd - mediaSegment.effectStart;
                                                if (i2 == 0) {
                                                    String str6 = TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT) ? mediaSegment.type : "input";
                                                    if (multiMediaDataTrack != null) {
                                                        if (i3 != 0 || !multiMediaDataTrack.hasHeader()) {
                                                            if (i3 == mediaTrack2.mediaSegments.size() - 1 && multiMediaDataTrack.hasFooter()) {
                                                                str4 = str2;
                                                            }
                                                        }
                                                        m49clone.type = str4;
                                                        if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_ONE_INPUT) && TextUtils.equals(str4, "input") && z) {
                                                            arrayList4 = arrayList7;
                                                            mediaTrackConfig3 = mediaTrackConfig2;
                                                            i3++;
                                                            arrayList6 = arrayList4;
                                                            arrayList5 = arrayList8;
                                                            mediaTrack3 = mediaTrack;
                                                        } else if (TextUtils.equals(str4, "input") && !z) {
                                                            z = true;
                                                        }
                                                    }
                                                    str4 = str6;
                                                    m49clone.type = str4;
                                                    if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_ONE_INPUT)) {
                                                    }
                                                    if (TextUtils.equals(str4, "input")) {
                                                        z = true;
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                                                    MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                                                    if (mediaAEffect2 != null) {
                                                        mediaSegment.effectConfigKey = TextUtils.isEmpty(mediaAEffect2.name) ? "exportEffect" + i3 : mediaSegment.mediaAEffect.name;
                                                    }
                                                } else if (mediaSegment.mediaAEffect == null) {
                                                    mediaAEffect = null;
                                                    mediaSegment.effectConfigKey = null;
                                                    m49clone.effectConfigKey = mediaSegment.effectConfigKey;
                                                    if (TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                                        m49clone.mediaAEffect = mediaSegment.mediaAEffect;
                                                    } else {
                                                        m49clone.mediaAEffect = mediaAEffect;
                                                    }
                                                    arrayList4 = arrayList7;
                                                    arrayList4.add(m49clone);
                                                    if (!TextUtils.isEmpty(mediaSegment.effectConfigKey) && mediaSegment.mediaAEffect != null) {
                                                        mediaTrackConfig3 = mediaTrackConfig2;
                                                        if (mediaTrackConfig3.effectConfigMap == null) {
                                                            mediaTrackConfig3.effectConfigMap = new LinkedHashMap();
                                                        }
                                                        mediaTrackConfig3.effectConfigMap.put(mediaSegment.effectConfigKey, mediaSegment.mediaAEffect);
                                                        i3++;
                                                        arrayList6 = arrayList4;
                                                        arrayList5 = arrayList8;
                                                        mediaTrack3 = mediaTrack;
                                                    }
                                                    mediaTrackConfig3 = mediaTrackConfig2;
                                                    i3++;
                                                    arrayList6 = arrayList4;
                                                    arrayList5 = arrayList8;
                                                    mediaTrack3 = mediaTrack;
                                                }
                                                mediaAEffect = null;
                                                m49clone.effectConfigKey = mediaSegment.effectConfigKey;
                                                if (TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                                }
                                                arrayList4 = arrayList7;
                                                arrayList4.add(m49clone);
                                                if (!TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                                                    mediaTrackConfig3 = mediaTrackConfig2;
                                                    if (mediaTrackConfig3.effectConfigMap == null) {
                                                    }
                                                    mediaTrackConfig3.effectConfigMap.put(mediaSegment.effectConfigKey, mediaSegment.mediaAEffect);
                                                    i3++;
                                                    arrayList6 = arrayList4;
                                                    arrayList5 = arrayList8;
                                                    mediaTrack3 = mediaTrack;
                                                }
                                                mediaTrackConfig3 = mediaTrackConfig2;
                                                i3++;
                                                arrayList6 = arrayList4;
                                                arrayList5 = arrayList8;
                                                mediaTrack3 = mediaTrack;
                                            }
                                        } else if (c == 2) {
                                            m49clone.start = 0L;
                                            m49clone.end = 0L;
                                            m49clone.effectStart = 0L;
                                            m49clone.effectEnd = 0L;
                                        }
                                    }
                                    c = 65535;
                                    if (c != 0) {
                                    }
                                    if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                    }
                                } else {
                                    if (str5.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER)) {
                                        c = 1;
                                        if (c != 0) {
                                        }
                                        if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                        }
                                    }
                                    c = 65535;
                                    if (c != 0) {
                                    }
                                    if (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                    }
                                }
                            }
                            str2 = MediaSegment.SEG_TYPE_INPUT_FOOTER;
                            if (i2 == 0) {
                            }
                            if (!TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                            }
                            mediaAEffect = null;
                            m49clone.effectConfigKey = mediaSegment.effectConfigKey;
                            if (TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                            }
                            arrayList4 = arrayList7;
                            arrayList4.add(m49clone);
                            if (!TextUtils.isEmpty(mediaSegment.effectConfigKey)) {
                            }
                            mediaTrackConfig3 = mediaTrackConfig2;
                            i3++;
                            arrayList6 = arrayList4;
                            arrayList5 = arrayList8;
                            mediaTrack3 = mediaTrack;
                        }
                        arrayList = arrayList5;
                        mediaTrack3.mediaSegments = arrayList6;
                    } else {
                        arrayList = arrayList5;
                    }
                    if (mediaTrack2.mediaTransitions != null) {
                        HashSet hashSet = new HashSet();
                        int i4 = 0;
                        while (i4 < mediaTrack2.mediaTransitions.size()) {
                            MediaTransition mediaTransition = new MediaTransition();
                            MediaTransition mediaTransition2 = mediaTrack2.mediaTransitions.get(i4);
                            if (TextUtils.isEmpty(mediaTransition2.name) || (!TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT) && mediaTrack2.transitionMode.equals("fixed") && hashSet.contains(mediaTransition2.name))) {
                                arrayList3 = arrayList;
                            } else {
                                hashSet.add(mediaTransition2.name);
                                mediaTransition.duration = mediaTransition2.duration;
                                if (TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_TEMPLATE) || TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT)) {
                                    mediaTransition.start = mediaTransition2.start;
                                    mediaTransition.end = mediaTransition2.end;
                                }
                                mediaTransition.shaderConfigKey = mediaTransition2.shaderConfigKey;
                                mediaTransition.tParams = mediaTransition2.tParams;
                                mediaTransition.name = mediaTransition2.name;
                                arrayList3 = arrayList;
                                arrayList3.add(mediaTransition);
                            }
                            i4++;
                            arrayList = arrayList3;
                        }
                        arrayList2 = arrayList;
                        mediaTrack3.mediaTransitions = TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_DRAFT) ? mediaTrack2.mediaTransitions : null;
                    } else {
                        arrayList2 = arrayList;
                    }
                    MediaSegment mediaSegment2 = mediaTrack2.superpositionFooter;
                    if (mediaSegment2 != null) {
                        MediaSegment m49clone2 = mediaSegment2.m49clone();
                        setSuperpositionSegment(mediaTrackConfig3.effectConfigMap, mediaTrack2.superpositionFooter, m49clone2, str3);
                        mediaTrack3.superpositionFooter = m49clone2;
                    }
                    MediaSegment mediaSegment3 = mediaTrack2.superpositionHeader;
                    if (mediaSegment3 != null) {
                        MediaSegment m49clone3 = mediaSegment3.m49clone();
                        setSuperpositionSegment(mediaTrackConfig3.effectConfigMap, mediaTrack2.superpositionHeader, m49clone3, str3);
                        mediaTrack3.superpositionHeader = m49clone3;
                    }
                    mediaTrackConfig3.mediaTracks.add(mediaTrack3);
                } else {
                    arrayList2 = arrayList5;
                }
                i2++;
                list2 = list;
                arrayList5 = arrayList2;
            }
        }
        mediaTrackConfig3.transitionConfigs = arrayList5;
        if (TextUtils.equals(str3, MediaTrackConfig.AE_IMPORT_ONE_INPUT)) {
            str3 = "input";
        }
        mediaTrackConfig3.importType = str3;
        return mediaTrackConfig3;
    }

    public static String exportEffectsWithShader(Context context, String str, MediaAEffect mediaAEffect, ShaderConfig shaderConfig) {
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
            fileOutputStream.write(new mdb().a(mediaAEffect).getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            ShaderConfig shaderConfig2 = new ShaderConfig();
            String parent = !TextUtils.isEmpty(shaderConfig.resourcePath) ? new File(shaderConfig.resourcePath).getParent() : "";
            String str2 = shaderConfig.fragmentShader;
            String str3 = shaderConfig.vertexShader;
            if (!TextUtils.isEmpty(str2) && !str2.contains("default")) {
                String f = ah0.f(context, parent, str2, "");
                if (!TextUtils.isEmpty(f)) {
                    if (!str2.endsWith(".glsl")) {
                        str2 = str2 + ".glsl";
                    }
                    File file3 = new File(file, str2);
                    if (!file3.exists()) {
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    fileOutputStream2.write(f.getBytes());
                    fileOutputStream2.close();
                }
            }
            if (!TextUtils.isEmpty(str3) && !str3.contains("default")) {
                String j = ah0.j(context, parent, str3);
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
            fileOutputStream4.write(new mdb().a(shaderConfig2).getBytes());
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String exportTempInfoZip(Context context, String str, TemplateInfo templateInfo, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        MediaTrackConfig mediaTrackConfig2;
        if (mediaTrackConfig == null || context == null || TextUtils.isEmpty(str) || templateInfo == null || (mediaTrackConfig2 = templateInfo.trackConfig) == null) {
            return null;
        }
        String str2 = mediaTrackConfig2.name;
        String str3 = str + str2 + File.separator;
        String str4 = str3 + "shader";
        String str5 = str3 + AnimatedStateListDrawableCompat.ELEMENT_TRANSITION;
        String str6 = str3 + "music";
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
        if (fgb.e(transitionResourceList)) {
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
            String a = new mdb().a(templateInfo2);
            FileOutputStream fileOutputStream = new FileOutputStream(file6);
            fileOutputStream.write(a.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            if (onExportListener != null) {
                onExportListener.onExportFail("导出theme_config.json 失败 ，msg" + e.getLocalizedMessage());
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
        } catch (Exception e2) {
            if (onExportListener != null) {
                onExportListener.onExportFail("压缩" + str8 + "文件失败 , msg " + e2.getLocalizedMessage());
            }
        }
        return str8;
    }

    public static String exportTransitionWithShader(Context context, String str, MediaTransition mediaTransition, String str2, ShaderConfig shaderConfig) {
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
            fileOutputStream.write(new mdb().a(mediaTransition).getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            ShaderConfig shaderConfig2 = new ShaderConfig();
            String parent = !TextUtils.isEmpty(shaderConfig.resourcePath) ? new File(shaderConfig.resourcePath).getParent() : "";
            String str3 = shaderConfig.fragmentShader;
            String str4 = shaderConfig.vertexShader;
            if (!TextUtils.isEmpty(str3) && !str3.contains("default")) {
                String f = ah0.f(context, parent, str3, "");
                if (!TextUtils.isEmpty(f)) {
                    if (!str3.endsWith(".glsl")) {
                        str3 = str3 + ".glsl";
                    }
                    File file3 = new File(file, str3);
                    if (!file3.exists()) {
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    fileOutputStream2.write(f.getBytes());
                    fileOutputStream2.close();
                }
            }
            if (!TextUtils.isEmpty(str4) && !str4.contains("default")) {
                String j = ah0.j(context, parent, str4);
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
            fileOutputStream4.write(new mdb().a(shaderConfig2).getBytes());
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> getEffectResourceMap(File file, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        FileOutputStream fileOutputStream;
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
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e) {
                    e = e;
                }
                try {
                    fileOutputStream.write(new mdb().a(entry.getValue()).getBytes());
                    fileOutputStream.flush();
                    hashMap.put(key, file.getName() + File.separator + file2.getName());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
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
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<MediaTextureData> getMediaTextureDates(Context context, ShaderConfig shaderConfig, File file, String str, ImportExportConfigUtil.OnExportListener onExportListener) throws IOException {
        String name;
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
                        name = mediaTextureData.path + ".png";
                    }
                    FileUtils.saveBitmap2PNG(file.getPath(), name, ah0.g(context, mediaTextureData.path), 100);
                }
                mediaTextureData.path = name;
                if (mediaTextureData.textureId == 0) {
                }
                arrayList.add(mediaTextureData);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc A[Catch: IOException -> 0x0181, TryCatch #1 {IOException -> 0x0181, blocks: (B:27:0x00ad, B:29:0x00bf, B:31:0x00ca, B:32:0x00cd, B:36:0x00e6, B:38:0x00ec, B:40:0x00f2, B:42:0x00fc, B:44:0x0102, B:45:0x0111, B:47:0x011c, B:48:0x011f, B:49:0x012e, B:51:0x0159, B:52:0x015b), top: B:67:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0159 A[Catch: IOException -> 0x0181, TryCatch #1 {IOException -> 0x0181, blocks: (B:27:0x00ad, B:29:0x00bf, B:31:0x00ca, B:32:0x00cd, B:36:0x00e6, B:38:0x00ec, B:40:0x00f2, B:42:0x00fc, B:44:0x0102, B:45:0x0111, B:47:0x011c, B:48:0x011f, B:49:0x012e, B:51:0x0159, B:52:0x015b), top: B:67:0x00ad }] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> getShaderResourceMap(Context context, String str, File file, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        Iterator<Map.Entry<String, ShaderConfig>> it;
        HashMap hashMap;
        List<MediaTextureData> mediaTextureDates;
        String j;
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
                                    String f = ah0.f(context, parent, str2, next.getKey());
                                    if (!TextUtils.isEmpty(f)) {
                                        if (str2.endsWith(".glsl")) {
                                            hashMap = hashMap2;
                                        } else {
                                            hashMap = hashMap2;
                                            try {
                                                str2 = str2 + ".glsl";
                                            } catch (IOException e) {
                                                e = e;
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
                                        fileOutputStream.write(f.getBytes());
                                        fileOutputStream.close();
                                        str2 = str4;
                                        if (!TextUtils.isEmpty(str3) && !str3.contains("default")) {
                                            j = ah0.j(context, parent, str3);
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
                                        fileOutputStream3.write(new mdb().a(shaderConfig).getBytes());
                                        fileOutputStream3.close();
                                        hashMap2 = hashMap;
                                        hashMap2.put(key, file3.getPath().replace(str, ""));
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                            }
                        }
                        hashMap = hashMap2;
                        if (!TextUtils.isEmpty(str3)) {
                            j = ah0.j(context, parent, str3);
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
                        fileOutputStream32.write(new mdb().a(shaderConfig).getBytes());
                        fileOutputStream32.close();
                        hashMap2 = hashMap;
                        hashMap2.put(key, file3.getPath().replace(str, ""));
                    } catch (IOException e3) {
                        e = e3;
                        it = it2;
                    }
                }
                it2 = it;
            }
        }
        return hashMap2;
    }

    public static List<String> getTransitionResourceList(File file, MediaTrackConfig mediaTrackConfig, ImportExportConfigUtil.OnExportListener onExportListener) {
        FileOutputStream fileOutputStream;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        List<MediaTransition> list = mediaTrackConfig.transitionConfigs;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MediaTransition mediaTransition = mediaTrackConfig.transitionConfigs.get(i);
                String str = mediaTransition.name;
                if (hashSet.contains(str)) {
                    str = str + i;
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
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e) {
                    e = e;
                }
                try {
                    fileOutputStream.write(new mdb().a(mediaTransition).getBytes());
                    fileOutputStream.flush();
                    arrayList.add(file.getName() + File.separator + file2.getName());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
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
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static void setSuperpositionSegment(Map<String, MediaAEffect> map, MediaSegment mediaSegment, MediaSegment mediaSegment2, String str) {
        if (mediaSegment == null || mediaSegment2 == null) {
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
