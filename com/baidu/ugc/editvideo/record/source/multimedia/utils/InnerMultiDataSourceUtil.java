package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.a0.b.a.g;
import b.a.a0.b.a.k.c;
import b.a.x0.b;
import b.a.x0.t.h;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.baidu.ugc.utils.FileUtils;
import com.faceunity.gles.GeneratedTexture;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class InnerMultiDataSourceUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InnerMultiDataSourceUtil() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public static int addMultiMediaData(MultiMediaDataTrack multiMediaDataTrack, int i2, MultiMediaData multiMediaData) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, multiMediaDataTrack, i2, multiMediaData)) == null) {
            if (multiMediaData == null || multiMediaDataTrack == null) {
                return -1;
            }
            int size = multiMediaDataTrack.multiMediaDataList.size();
            int i3 = i2;
            if (i2 <= 0) {
                i3 = hasHeader(multiMediaDataTrack);
            } else if (i2 >= size) {
                if (hasFooter(multiMediaDataTrack)) {
                    size--;
                }
                i3 = size;
            }
            multiMediaDataTrack.multiMediaDataList.add(i3, multiMediaData);
            return i3;
        }
        return invokeLIL.intValue;
    }

    public static void addOneTrack(MediaTrack mediaTrack, List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, mediaTrack, list, map, list2, onInitMultiMediaListener) == null) || mediaTrack == null) {
            return;
        }
        if (list != null) {
            list.add(mediaTrack);
        }
        MultiMediaDataTrack multiMediaDataTrack = new MultiMediaDataTrack();
        List<MediaSegment> list3 = mediaTrack.mediaSegments;
        if (list3 != null && list3.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                buildTexData(map, onInitMultiMediaListener, arrayList, mediaSegment);
            }
            multiMediaDataTrack.multiMediaDataList = arrayList;
        }
        list2.add(multiMediaDataTrack);
    }

    public static void applyHeaderAndFooterSegment(MediaTrackConfig mediaTrackConfig, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, null, mediaTrackConfig, map, list, onInitMultiMediaListener, onReleaseMultiMediaListener) == null) || mediaTrackConfig == null || h.e(list) || h.e(mediaTrackConfig.mediaTracks)) {
            return;
        }
        Iterator<MultiMediaData> it = list.get(0).multiMediaDataList.iterator();
        while (it.hasNext()) {
            MultiMediaData next = it.next();
            if (next != null && (MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(next.inputType) || MediaSegment.SEG_TYPE_INPUT_HEADER.equals(next.inputType))) {
                if (onReleaseMultiMediaListener != null) {
                    onReleaseMultiMediaListener.onReleaseMultiMedia(next);
                }
                it.remove();
            }
        }
        MediaSegment mediaSegment = null;
        MediaSegment mediaSegment2 = null;
        int i2 = 0;
        int i3 = 0;
        loop1: for (MediaTrack mediaTrack : mediaTrackConfig.mediaTracks) {
            if (mediaTrack.mediaSegments != null) {
                for (int i4 = 0; i4 < mediaTrack.mediaSegments.size(); i4++) {
                    MediaSegment mediaSegment3 = mediaTrack.mediaSegments.get(i4);
                    if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, mediaSegment3.type)) {
                        if (TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE)) {
                            i2 = i4;
                            mediaSegment = mediaSegment3;
                        } else {
                            mediaSegment = mediaSegment3;
                            i2 = 0;
                        }
                    } else if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment3.type)) {
                        i3 = TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE) ? i4 : mediaTrack.mediaSegments.size() + 1;
                        mediaSegment2 = mediaSegment3;
                    }
                    if (mediaSegment != null && mediaSegment2 != null) {
                        break loop1;
                    }
                }
                continue;
            }
        }
        applyHeaderOrFooter(map, list, mediaSegment, i2, onInitMultiMediaListener);
        applyHeaderOrFooter(map, list, mediaSegment2, i3, onInitMultiMediaListener);
    }

    public static void applyHeaderOrFooter(Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list, MediaSegment mediaSegment, int i2, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener) {
        ShaderConfig shaderConfig;
        MultiMediaData transSegment2Data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{map, list, mediaSegment, Integer.valueOf(i2), onInitMultiMediaListener}) == null) || mediaSegment == null || map == null || TextUtils.isEmpty(mediaSegment.shaderConfigKey) || (shaderConfig = map.get(mediaSegment.shaderConfigKey)) == null || h.e(shaderConfig.textures) || (transSegment2Data = transSegment2Data(mediaSegment, (MediaTextureData) h.c(shaderConfig.textures, 0))) == null) {
            return;
        }
        list.get(0).multiMediaDataList.add(i2, transSegment2Data);
        if (onInitMultiMediaListener != null) {
            onInitMultiMediaListener.onInitMultiMedia(transSegment2Data);
        }
    }

    public static void applyOtherTrack(List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, long j, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{list, map, list2, Long.valueOf(j), onInitMultiMediaListener}) == null) {
            MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) h.c(list2, 0);
            List<MultiMediaData> list3 = multiMediaDataTrack != null ? multiMediaDataTrack.multiMediaDataList : null;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 1; i3 < list.size(); i3++) {
                MediaTrack mediaTrack = list.get(i3);
                int b2 = h.b(mediaTrack.mediaSegments);
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < b2; i4++) {
                    MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i4);
                    if (mediaSegment.start == 0 && mediaSegment.end == 0) {
                        mediaSegment.end = j;
                    }
                    if (c.m(mediaTrack, "multi_input") && list3 != null) {
                        MultiMediaData multiMediaData = (MultiMediaData) h.c(list3, i2);
                        if (multiMediaData == null) {
                            z = true;
                        } else {
                            MultiMediaData multiMediaData2 = (MultiMediaData) multiMediaData.clone();
                            if (multiMediaData2 != null) {
                                mediaSegment.type = multiMediaData2.type == 0 ? "image" : "video";
                                arrayList.add(multiMediaData2);
                            }
                            if (onInitMultiMediaListener != null) {
                                onInitMultiMediaListener.onInitMultiMedia(multiMediaData2);
                            }
                            i2++;
                            z = false;
                        }
                    } else if (!c.m(mediaTrack, "edit_sticker")) {
                        buildTexData(map, onInitMultiMediaListener, arrayList, mediaSegment);
                    } else if (TextUtils.equals(SubtitleLog.TAG, mediaSegment.type)) {
                        arrayList.add(new MultiMediaData());
                    }
                }
                MultiMediaDataTrack multiMediaDataTrack2 = new MultiMediaDataTrack();
                multiMediaDataTrack2.multiMediaDataList = arrayList;
                list2.add(multiMediaDataTrack2);
                if (z) {
                    i2++;
                    z = false;
                }
            }
        }
    }

    public static void applySuperpositionSegment(List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, list, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener) == null) || h.e(list) || h.e(list2) || list.get(0).mediaSegments.size() < c.j) {
            return;
        }
        MultiMediaData multiMediaData = list2.get(0).multiMediaDataSuperpositionHeader;
        MultiMediaData multiMediaData2 = list2.get(0).multiMediaDataSuperpositionFooter;
        MediaSegment mediaSegment = null;
        if (multiMediaData != null) {
            if (onReleaseMultiMediaListener != null) {
                onReleaseMultiMediaListener.onReleaseMultiMedia(multiMediaData);
            }
            multiMediaData = null;
        }
        if (multiMediaData2 != null) {
            if (onReleaseMultiMediaListener != null) {
                onReleaseMultiMediaListener.onReleaseMultiMedia(multiMediaData2);
            }
            multiMediaData2 = null;
        }
        MediaSegment mediaSegment2 = null;
        for (MediaTrack mediaTrack : list) {
            MediaSegment mediaSegment3 = mediaTrack.superpositionHeader;
            if (mediaSegment3 != null) {
                mediaSegment2 = mediaSegment3;
            }
            MediaSegment mediaSegment4 = mediaTrack.superpositionFooter;
            if (mediaSegment4 != null) {
                mediaSegment = mediaSegment4;
            }
            if (mediaSegment == null) {
                if (mediaSegment2 != null) {
                    break;
                }
            } else {
                break;
            }
        }
        if (mediaSegment2 != null) {
            multiMediaData = transSegment2Data(mediaSegment2, (MediaTextureData) h.c(map.get(mediaSegment2.shaderConfigKey).textures, 0));
            multiMediaData.scaleType = getOtherScaleType(mediaSegment2);
            if (onInitMultiMediaListener != null) {
                onInitMultiMediaListener.onInitMultiMedia(multiMediaData);
            }
        }
        list2.get(0).multiMediaDataSuperpositionHeader = multiMediaData;
        if (mediaSegment != null) {
            multiMediaData2 = transSegment2Data(mediaSegment, (MediaTextureData) h.c(map.get(mediaSegment.shaderConfigKey).textures, 0));
            multiMediaData2.scaleType = getOtherScaleType(mediaSegment);
            if (onInitMultiMediaListener != null) {
                onInitMultiMediaListener.onInitMultiMedia(multiMediaData2);
            }
        }
        list2.get(0).multiMediaDataSuperpositionFooter = multiMediaData2;
    }

    public static MediaTrack buildBlurBackgroundTrack(String str, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            MediaTrack mediaTrack = new MediaTrack();
            mediaTrack.trackType = str;
            float[] fArr = mediaTrack.glClearColor;
            fArr[0] = f2;
            fArr[1] = f3;
            ArrayList arrayList = new ArrayList();
            MediaSegment mediaSegment = new MediaSegment();
            mediaSegment.type = "input";
            arrayList.add(mediaSegment);
            mediaTrack.mediaSegments = arrayList;
            return mediaTrack;
        }
        return (MediaTrack) invokeCommon.objValue;
    }

    public static MediaTrack buildColorBackgroundTrack(String str, String str2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Float.valueOf(f2)})) == null) {
            MediaTrack mediaTrack = new MediaTrack();
            mediaTrack.trackType = str;
            float[] parseBgColor = parseBgColor(str2, f2);
            if (parseBgColor != null) {
                mediaTrack.glClearColor = parseBgColor;
            }
            return mediaTrack;
        }
        return (MediaTrack) invokeCommon.objValue;
    }

    public static MultiMediaData buildImageData(MediaSegment mediaSegment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, mediaSegment, str)) == null) {
            MultiMediaData multiMediaData = new MultiMediaData();
            multiMediaData.path = str;
            multiMediaData.type = 0;
            multiMediaData.start = mediaSegment.start;
            multiMediaData.end = mediaSegment.end;
            multiMediaData.inputType = mediaSegment.type;
            multiMediaData.scaleType = getInputScaleType(mediaSegment);
            return multiMediaData;
        }
        return (MultiMediaData) invokeLL.objValue;
    }

    public static void buildInputTrack(List<MultiMediaData> list, List<MediaTrack> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, list, list2) == null) || h.e(list) || list2 == null) {
            return;
        }
        MediaTrack mediaTrack = new MediaTrack();
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (MultiMediaData multiMediaData : list) {
            MediaSegment transData2Segment = transData2Segment(j, multiMediaData);
            arrayList.add(transData2Segment);
            j = transData2Segment.end;
        }
        mediaTrack.mediaSegments = arrayList;
        if (list2.size() > 0) {
            list2.set(0, mediaTrack);
        } else {
            list2.add(mediaTrack);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (b.a.x0.t.h.b(r7) != b.a.x0.t.h.b(r2.mediaSegments)) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void buildMultiMediaDataSource(List<MultiMediaData> list, MediaTrackConfig mediaTrackConfig, List<MultiMediaDataTrack> list2, List<MediaTrack> list3, Map<String, ShaderConfig> map, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        MediaTrack mediaTrack;
        ArrayList arrayList;
        Iterator<Map.Entry<String, ShaderConfig>> it;
        Map<String, ShaderConfig> map2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{list, mediaTrackConfig, list2, list3, map, onInitMultiMediaListener, onReleaseMultiMediaListener}) == null) || list2 == null || list3 == null || map == null) {
            return;
        }
        if (list2.size() == 0) {
            buildMultiMediaDataTrackList(list, list2);
        }
        if (mediaTrackConfig == null || !TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_DRAFT)) {
            MediaTrack mediaTrack2 = (MediaTrack) h.c(list3, 0);
            if (list3.size() != 0) {
                Iterator<MultiMediaData> it2 = list.iterator();
                while (it2.hasNext()) {
                    MultiMediaData next = it2.next();
                    if (next != null && (MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(next.inputType) || MediaSegment.SEG_TYPE_INPUT_HEADER.equals(next.inputType))) {
                        if (onReleaseMultiMediaListener != null) {
                            onReleaseMultiMediaListener.onReleaseMultiMedia(next);
                        }
                        it2.remove();
                    }
                }
                resetInputTrackTimeline(list, mediaTrack2);
                if (mediaTrack2 != null) {
                }
                mediaTrack = (MediaTrack) h.c(list3, 0);
                if (mediaTrack != null) {
                    mediaTrack.glClearColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
                    mediaTrack.mediaTransitions = null;
                }
                arrayList = new ArrayList();
                h.a(arrayList, c.e(mediaTrack, mediaTrackConfig, mediaTrackConfig != null ? null : mediaTrackConfig.shaderConfigMapDebug));
                if (h.b(arrayList) > 0) {
                    MediaTrack subtitleAndStickerTrack = getSubtitleAndStickerTrack(list3);
                    MediaTrack subtitleAndStickerTrack2 = getSubtitleAndStickerTrack(arrayList);
                    if (subtitleAndStickerTrack2 != null && subtitleAndStickerTrack != null) {
                        ArrayList arrayList2 = new ArrayList();
                        subtitleAndStickerTrack2.mediaSegments = arrayList2;
                        arrayList2.addAll(subtitleAndStickerTrack.mediaSegments);
                    }
                    list3.clear();
                    list3.addAll(arrayList);
                }
                it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, ShaderConfig> next2 = it.next();
                    if (!TextUtils.equals(next2.getKey(), c.f1334e) && !TextUtils.equals(next2.getKey(), c.f1332c) && !next2.getKey().contains(c.f1333d)) {
                        next2.getValue().destroy();
                        it.remove();
                    }
                }
                if (mediaTrackConfig != null && (map2 = mediaTrackConfig.shaderConfigMapDebug) != null) {
                    for (Map.Entry<String, ShaderConfig> entry : map2.entrySet()) {
                        if ((!TextUtils.equals(entry.getKey(), c.f1332c) && !TextUtils.equals(entry.getKey(), c.f1334e) && !entry.getKey().contains(c.f1333d)) || !map.containsKey(entry.getKey())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            buildInputTrack(list, list3);
            mediaTrack = (MediaTrack) h.c(list3, 0);
            if (mediaTrack != null) {
            }
            arrayList = new ArrayList();
            h.a(arrayList, c.e(mediaTrack, mediaTrackConfig, mediaTrackConfig != null ? null : mediaTrackConfig.shaderConfigMapDebug));
            if (h.b(arrayList) > 0) {
            }
            it = map.entrySet().iterator();
            while (it.hasNext()) {
            }
            if (mediaTrackConfig != null) {
                while (r2.hasNext()) {
                }
            }
        } else {
            list3.clear();
            list3.addAll(mediaTrackConfig.mediaTracks);
            map.clear();
            map.putAll(mediaTrackConfig.shaderConfigMapDebug);
        }
        int min = Math.min(h.b(list), h.c(list3, 0) != null ? h.b(((MediaTrack) h.c(list3, 0)).mediaSegments) : 0);
        for (int i2 = 0; i2 < min; i2++) {
            MultiMediaData multiMediaData = (MultiMediaData) h.c(list, i2);
            MediaSegment mediaSegment = h.c(list3, 0) != null ? (MediaSegment) h.c(((MediaTrack) h.c(list3, 0)).mediaSegments, i2) : null;
            if (mediaSegment != null && multiMediaData != null && !TextUtils.isEmpty(mediaSegment.scaleType)) {
                multiMediaData.scaleType = mediaSegment.scaleType;
            }
        }
        applySuperpositionSegment(list3, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener);
        applyHeaderAndFooterSegment(mediaTrackConfig, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener);
        applyOtherTrack(list3, map, list2, getSegmentsDuration((MediaTrack) h.c(list3, 0)), onInitMultiMediaListener);
    }

    public static void buildMultiMediaDataTrackList(List<MultiMediaData> list, List<MultiMediaDataTrack> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, list, list2) == null) || list2 == null || list == null) {
            return;
        }
        MultiMediaDataTrack multiMediaDataTrack = new MultiMediaDataTrack();
        multiMediaDataTrack.multiMediaDataList = list;
        if (list2.size() > 0) {
            list2.set(0, multiMediaDataTrack);
        } else {
            list2.add(multiMediaDataTrack);
        }
    }

    public static MediaTrack buildResourceBackgroundTrack(String str, MultiMediaData multiMediaData, Map<String, ShaderConfig> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, str, multiMediaData, map)) == null) {
            MediaTrack mediaTrack = new MediaTrack();
            mediaTrack.trackType = str;
            String str2 = str + "Shader";
            ShaderConfig stickerShaderConfig = ShaderConfig.getStickerShaderConfig();
            stickerShaderConfig.textures = new ArrayList();
            MediaTextureData mediaTextureData = new MediaTextureData();
            mediaTextureData.type = multiMediaData.type == 1 ? "video" : "image";
            mediaTextureData.path = multiMediaData.path;
            mediaTextureData.x = multiMediaData.x;
            mediaTextureData.y = multiMediaData.y;
            mediaTextureData.width = multiMediaData.width;
            mediaTextureData.height = multiMediaData.height;
            mediaTextureData.mipmap = multiMediaData.mipmap;
            mediaTextureData.frameCount = multiMediaData.frameCount;
            mediaTextureData.frameFps = multiMediaData.frameFps;
            mediaTextureData.frameSuffix = multiMediaData.frameSuffix;
            mediaTextureData.loop = multiMediaData.loop;
            stickerShaderConfig.textures.add(mediaTextureData);
            map.put(str2, stickerShaderConfig);
            ArrayList arrayList = new ArrayList();
            MediaSegment mediaSegment = new MediaSegment();
            mediaSegment.type = multiMediaData.type != 1 ? "image" : "video";
            mediaSegment.shaderConfigKey = str2;
            arrayList.add(mediaSegment);
            mediaTrack.mediaSegments = arrayList;
            return mediaTrack;
        }
        return (MediaTrack) invokeLLL.objValue;
    }

    public static MediaTrack buildSubtitleAndStickerTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, list, list2)) == null) {
            if (list == null || list2 == null) {
                return null;
            }
            MediaTrack subtitleAndStickerTrack = getSubtitleAndStickerTrack(list);
            if (subtitleAndStickerTrack == null || !list.contains(subtitleAndStickerTrack) || subtitleAndStickerTrack.mediaSegments == null) {
                if (subtitleAndStickerTrack == null) {
                    subtitleAndStickerTrack = new MediaTrack();
                }
                subtitleAndStickerTrack.trackType = "edit_sticker";
                subtitleAndStickerTrack.mediaSegments = new ArrayList();
                list.add(subtitleAndStickerTrack);
                MultiMediaDataTrack multiMediaDataTrack = new MultiMediaDataTrack();
                multiMediaDataTrack.multiMediaDataList = new ArrayList();
                list2.add(multiMediaDataTrack);
                return subtitleAndStickerTrack;
            }
            return subtitleAndStickerTrack;
        }
        return (MediaTrack) invokeLL.objValue;
    }

    public static void buildTexData(Map<String, ShaderConfig> map, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener, List<MultiMediaData> list, MediaSegment mediaSegment) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, map, onInitMultiMediaListener, list, mediaSegment) == null) {
            String str = mediaSegment.shaderConfigKey;
            if (TextUtils.isEmpty(str) || map.get(str) == null) {
                multiMediaData = new MultiMediaData();
            } else {
                ShaderConfig shaderConfig = map.get(str);
                int b2 = h.b(shaderConfig.textures);
                if (b2 != 0) {
                    for (int i2 = 0; i2 < b2; i2++) {
                        MediaTextureData mediaTextureData = shaderConfig.textures.get(i2);
                        if (mediaTextureData != null) {
                            MultiMediaData multiMediaData2 = new MultiMediaData();
                            if (TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_VIDEO)) {
                                multiMediaData2.type = 1;
                            } else if (TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_IMAGE) || TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_LUT)) {
                                multiMediaData2.type = 0;
                            }
                            multiMediaData2.scaleType = getOtherScaleType(mediaSegment);
                            multiMediaData2.path = mediaTextureData.path;
                            multiMediaData2.inputType = mediaSegment.type;
                            multiMediaData2.end = mediaSegment.end;
                            multiMediaData2.x = mediaTextureData.x;
                            multiMediaData2.y = mediaTextureData.y;
                            multiMediaData2.width = mediaTextureData.width;
                            multiMediaData2.height = mediaTextureData.height;
                            multiMediaData2.mipmap = mediaTextureData.mipmap;
                            multiMediaData2.frameFps = mediaTextureData.frameFps;
                            multiMediaData2.frameCount = mediaTextureData.frameCount;
                            multiMediaData2.frameSuffix = mediaTextureData.frameSuffix;
                            multiMediaData2.loop = mediaTextureData.loop;
                            list.add(multiMediaData2);
                            if (onInitMultiMediaListener != null) {
                                onInitMultiMediaListener.onInitMultiMedia(multiMediaData2);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                multiMediaData = new MultiMediaData();
            }
            list.add(multiMediaData);
        }
    }

    public static MultiMediaData buildVideoData(MediaSegment mediaSegment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, mediaSegment, str)) == null) {
            MultiMediaData multiMediaData = new MultiMediaData();
            multiMediaData.path = str;
            multiMediaData.type = 1;
            multiMediaData.start = mediaSegment.start;
            multiMediaData.end = mediaSegment.end;
            multiMediaData.inputType = mediaSegment.type;
            multiMediaData.scaleType = getInputScaleType(mediaSegment);
            initVideoByPath(multiMediaData);
            return multiMediaData;
        }
        return (MultiMediaData) invokeLL.objValue;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 == i5) {
                i3 = i2;
            }
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 > i3 && i8 / i6 > i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    public static Bitmap decodeBitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (!str.contains(File.separator)) {
                if (getContext() == null) {
                    return null;
                }
                return BitmapFactory.decodeResource(getContext().getResources(), getImageIdByName(str, getContext()));
            }
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, 720, 1280);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int deleteMultiMediaData(List<MultiMediaDataTrack> list, int i2, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65555, null, list, i2, onReleaseMultiMediaListener)) == null) {
            if (i2 < 0 || list == null || list.size() == 0 || list.get(0) == null || list.get(0).multiMediaDataList == null || i2 >= list.get(0).multiMediaDataList.size()) {
                return -1;
            }
            MultiMediaData remove = list.get(0).multiMediaDataList.remove(i2);
            if (onReleaseMultiMediaListener != null) {
                onReleaseMultiMediaListener.onReleaseMultiMedia(remove);
                return i2;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    public static MultiMediaData findDataByUuid(List<MultiMediaData> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, list, str)) == null) {
            if (!TextUtils.isEmpty(str) && !h.e(list)) {
                for (MultiMediaData multiMediaData : list) {
                    if (multiMediaData != null && TextUtils.equals(multiMediaData.uuid, str)) {
                        return multiMediaData;
                    }
                }
            }
            return null;
        }
        return (MultiMediaData) invokeLL.objValue;
    }

    public static int[] findIndexInSegments(List<MediaSegment> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65557, null, list, j)) == null) {
            if (list == null || list.size() <= 0) {
                return new int[0];
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                MediaSegment mediaSegment = (MediaSegment) h.c(list, i2);
                if (mediaSegment == null || TextUtils.equals("input_blank", mediaSegment.type)) {
                    break;
                }
                if (mediaSegment.start <= j && mediaSegment.end >= j) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            int size2 = arrayList.size();
            int[] iArr = new int[size2];
            if (arrayList.size() != 0 && size2 != 0) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
                }
            }
            return iArr;
        }
        return (int[]) invokeLJ.objValue;
    }

    public static int findInputIndexInSegments(List<MediaSegment> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65558, null, list, j)) == null) {
            if (h.e(list)) {
                return 0;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                MediaSegment mediaSegment = list.get(i2);
                if (mediaSegment.start <= j && mediaSegment.end >= j) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeLJ.intValue;
    }

    public static MediaSegment findSegmentByMultiMediaData(MultiMediaData multiMediaData, List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        InterceptResult invokeLLL;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, multiMediaData, list, list2)) == null) {
            if (multiMediaData != null && list != null && list2 != null && (b2 = h.b(list)) == h.b(list2) && b2 != 0) {
                for (int i2 = 0; i2 < b2; i2++) {
                    MediaTrack mediaTrack = (MediaTrack) h.c(list, i2);
                    MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) h.c(list2, i2);
                    if (mediaTrack != null && multiMediaDataTrack != null) {
                        List<MultiMediaData> list3 = multiMediaDataTrack.multiMediaDataList;
                        List<MediaSegment> list4 = mediaTrack.mediaSegments;
                        if (h.b(list3) != h.b(list4)) {
                            continue;
                        } else {
                            int i3 = -1;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= list3.size()) {
                                    break;
                                } else if (multiMediaData == list3.get(i4)) {
                                    i3 = i4;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (i3 >= 0) {
                                return list4.get(i3);
                            }
                        }
                    }
                }
            }
            return null;
        }
        return (MediaSegment) invokeLLL.objValue;
    }

    public static String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (b.c().getContext() == null || b.c().getContext().getApplicationInfo() == null) {
                return null;
            }
            return b.c().getContext().getApplicationInfo().packageName;
        }
        return (String) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? b.c().getContext() : (Context) invokeV.objValue;
    }

    public static MediaTrack getEffectTrack(List<MediaTrack> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, list)) == null) {
            if (h.e(list)) {
                return null;
            }
            for (MediaTrack mediaTrack : list) {
                boolean z = true;
                if (mediaTrack == null || !TextUtils.equals("effect", mediaTrack.trackType)) {
                    boolean z2 = false;
                    if (mediaTrack != null && !h.e(mediaTrack.mediaSegments)) {
                        Iterator<MediaSegment> it = mediaTrack.mediaSegments.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!TextUtils.equals(it.next().type, "effect")) {
                                    z = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        z2 = z;
                        continue;
                    }
                    if (z2) {
                    }
                }
                return mediaTrack;
            }
            return null;
        }
        return (MediaTrack) invokeL.objValue;
    }

    public static int getExifOrientation(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException unused) {
                exifInterface = null;
            }
            if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) != -1) {
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return 270;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getImageIdByName(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, str, context)) == null) {
            try {
                String[] strArr = {getAppPackageName(), context.getPackageName(), "com.baidu.capture"};
                for (int i2 = 0; i2 < 3; i2++) {
                    String str2 = strArr[i2];
                    int identifier = context.getResources().getIdentifier(str, "drawable", str2);
                    if (identifier == 0) {
                        identifier = context.getResources().getIdentifier(str, "mipmap", str2);
                    }
                    if (identifier != 0) {
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String getInputScaleType(MediaSegment mediaSegment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, mediaSegment)) == null) ? !TextUtils.isEmpty(mediaSegment.scaleType) ? mediaSegment.scaleType : MultiDataSourceUtil.sDefaultScaleType : (String) invokeL.objValue;
    }

    public static long getMultiMediaDataSeekTime(MultiMediaData multiMediaData, MediaSegment mediaSegment, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{multiMediaData, mediaSegment, Long.valueOf(j)})) == null) {
            if (multiMediaData == null || mediaSegment == null) {
                return 0L;
            }
            long j2 = multiMediaData.start + (j - mediaSegment.start);
            if (j2 >= 0) {
                return j2;
            }
            return 0L;
        }
        return invokeCommon.longValue;
    }

    public static String getOtherScaleType(MediaSegment mediaSegment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, mediaSegment)) == null) ? !TextUtils.isEmpty(mediaSegment.scaleType) ? mediaSegment.scaleType : MultiDataSourceUtil.sDefaultScaleType : (String) invokeL.objValue;
    }

    public static long getSegmentsDuration(MediaTrack mediaTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, mediaTrack)) == null) {
            if (mediaTrack == null || h.e(mediaTrack.mediaSegments)) {
                return 0L;
            }
            List<MediaSegment> list = mediaTrack.mediaSegments;
            return list.get(list.size() - 1).end;
        }
        return invokeL.longValue;
    }

    public static List<MediaSegment> getStickerSegmentsDataByType(MediaTrack mediaTrack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, mediaTrack, str)) == null) {
            if (mediaTrack == null || h.e(mediaTrack.mediaSegments) || TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                if (mediaSegment != null && TextUtils.equals(str, mediaSegment.type)) {
                    arrayList.add(mediaSegment);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static MediaTrack getSubtitleAndStickerTrack(List<MediaTrack> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, list)) == null) ? getTrackByType(list, "edit_sticker") : (MediaTrack) invokeL.objValue;
    }

    public static MediaTrack getTrackByType(List<MediaTrack> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, list, str)) == null) {
            if (list == null) {
                return null;
            }
            for (MediaTrack mediaTrack : list) {
                if (c.m(mediaTrack, str)) {
                    return mediaTrack;
                }
            }
            return null;
        }
        return (MediaTrack) invokeLL.objValue;
    }

    public static void glDeleteTextures(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65572, null, i2) == null) || i2 == 0) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
    }

    public static void glDeleteTextures(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, null, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int i2 = multiMediaData.textureId;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            multiMediaData.textureId = 0;
        }
        int i3 = multiMediaData.backupFrameTextureId;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            multiMediaData.backupFrameTextureId = 0;
        }
    }

    public static boolean hasFooter(MultiMediaDataTrack multiMediaDataTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, multiMediaDataTrack)) == null) {
            if (multiMediaDataTrack == null) {
                return false;
            }
            return multiMediaDataTrack.hasFooter();
        }
        return invokeL.booleanValue;
    }

    public static int hasGlobalFilter(MediaTrack mediaTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, mediaTrack)) == null) {
            if (mediaTrack != null && !h.e(mediaTrack.mediaSegments)) {
                int size = mediaTrack.mediaSegments.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i2);
                    if (mediaSegment != null && !TextUtils.isEmpty(mediaSegment.lutConfigKey) && !mediaSegment.lutConfigKey.contains(c.f1333d)) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean hasHeader(MultiMediaDataTrack multiMediaDataTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, multiMediaDataTrack)) == null) {
            if (multiMediaDataTrack == null) {
                return false;
            }
            return multiMediaDataTrack.hasHeader();
        }
        return invokeL.booleanValue;
    }

    public static int hexCharToDecimal(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{Character.valueOf(c2)})) == null) ? (c2 < 'A' || c2 > 'F') ? c2 - '0' : (c2 + '\n') - 65 : invokeCommon.intValue;
    }

    public static int hexToDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                i2 = (i2 * 16) + hexCharToDecimal(str.charAt(i3));
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int initImageByBitmap(MultiMediaData multiMediaData, Bitmap bitmap) {
        InterceptResult invokeLL;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, multiMediaData, bitmap)) == null) {
            if (bitmap == null || bitmap.isRecycled() || multiMediaData == null || multiMediaData.textureId != 0) {
                return 0;
            }
            if (multiMediaData.mipmap) {
                b2 = g.c();
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                GLES20.glGenerateMipmap(3553);
            } else {
                b2 = g.b();
                GLUtils.texImage2D(3553, 0, bitmap, 0);
            }
            if (multiMediaData.width == 0) {
                multiMediaData.width = bitmap.getWidth();
            }
            if (multiMediaData.height == 0) {
                multiMediaData.height = bitmap.getHeight();
            }
            Matrix.setIdentityM(multiMediaData.mtx, 0);
            if (!TextUtils.isEmpty(multiMediaData.path)) {
                multiMediaData.rotation = getExifOrientation(multiMediaData.path);
            }
            bitmap.recycle();
            return b2;
        }
        return invokeLL.intValue;
    }

    public static void initVideoByPath(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, null, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(multiMediaData.path);
                multiMediaData.rotation = b.a.x0.t.g.b(mediaMetadataRetriever.extractMetadata(24), 0);
                multiMediaData.width = b.a.x0.t.g.b(mediaMetadataRetriever.extractMetadata(18), 0);
                multiMediaData.height = b.a.x0.t.g.b(mediaMetadataRetriever.extractMetadata(19), 0);
                multiMediaData.originalDuration = b.a.x0.t.g.c(mediaMetadataRetriever.extractMetadata(9), 0L);
            } catch (Exception e2) {
                b.a.x0.t.c.d(e2.getMessage());
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static MediaAEffectConfig loadMediaAEffectConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String readText = FileUtils.readText(new File(str + File.separator + "effect_config.json"));
            if (readText == null || "".equals(readText)) {
                return null;
            }
            b.a.x0.j.b bVar = new b.a.x0.j.b();
            MediaAEffect mediaAEffect = (MediaAEffect) bVar.b(readText, MediaAEffect.class);
            if (mediaAEffect == null) {
                return null;
            }
            ShaderConfig shaderConfig = (ShaderConfig) bVar.b(FileUtils.readText(new File(str + File.separator + "shader_config.json")), ShaderConfig.class);
            if (shaderConfig == null) {
                return null;
            }
            shaderConfig.resourcePath = str;
            return new MediaAEffectConfig(mediaAEffect, shaderConfig);
        }
        return (MediaAEffectConfig) invokeL.objValue;
    }

    public static MediaTransitionConfig loadMediaTransitionConfig(String str) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            MediaTransition mediaTransition = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str);
                if (file2.exists()) {
                    ShaderConfig shaderConfig = null;
                    for (File file3 : file2.listFiles()) {
                        String name = file3.getName();
                        if (!TextUtils.isEmpty(file3.getName()) && name.endsWith(".json")) {
                            if (name.replace(".json", "").equals(file.getName())) {
                                StringBuilder sb = new StringBuilder();
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file3)));
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        sb.append(readLine);
                                    }
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                mediaTransition = (MediaTransition) new b.a.x0.j.b().b(sb.toString(), MediaTransition.class);
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                try {
                                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file3)));
                                    while (true) {
                                        String readLine2 = bufferedReader2.readLine();
                                        if (readLine2 == null) {
                                            break;
                                        }
                                        sb2.append(readLine2);
                                    }
                                    bufferedReader2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                shaderConfig = (ShaderConfig) new b.a.x0.j.b().b(sb2.toString(), ShaderConfig.class);
                                shaderConfig.resourcePath = file3.getParentFile().getAbsolutePath();
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    if (mediaTransition != null && shaderConfig != null) {
                        hashMap.put(mediaTransition.shaderConfigKey, shaderConfig);
                    }
                    MediaTransitionConfig mediaTransitionConfig = new MediaTransitionConfig();
                    mediaTransitionConfig.mediaTransition = mediaTransition;
                    mediaTransitionConfig.shaderConfigMap = hashMap;
                    return mediaTransitionConfig;
                }
                return null;
            }
            return null;
        }
        return (MediaTransitionConfig) invokeL.objValue;
    }

    public static void modifyTimeByRange(List<MediaTrack> list, MediaTrack mediaTrack, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{list, mediaTrack, Long.valueOf(j), Long.valueOf(j2)}) == null) || h.e(list)) {
            return;
        }
        MediaTrack mediaTrack2 = (MediaTrack) h.c(list, 0);
        if (mediaTrack2 != null) {
            MediaSegment mediaSegment = mediaTrack2.superpositionHeader;
            if (mediaSegment != null) {
                mediaSegment.start = j;
                mediaSegment.end = (mediaSegment.end - mediaSegment.start) + j;
            }
            MediaSegment mediaSegment2 = mediaTrack2.superpositionFooter;
            if (mediaSegment2 != null) {
                mediaSegment2.end = j2;
                mediaSegment2.start = j2 - (mediaSegment2.end - mediaSegment2.start);
            }
        }
        MediaTrack effectTrack = getEffectTrack(list);
        if (effectTrack == null || mediaTrack == null) {
            return;
        }
        List<MediaSegment> list2 = effectTrack.mediaSegments;
        List<MediaSegment> list3 = mediaTrack.mediaSegments;
        if (h.e(list2) || h.e(list3)) {
            return;
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            MediaSegment mediaSegment3 = list2.get(i2);
            MediaSegment mediaSegment4 = list3.get(i2);
            if (mediaSegment3 != null && mediaSegment4 != null) {
                long j3 = mediaSegment3.end - mediaSegment3.start;
                long j4 = mediaSegment4.start + j;
                mediaSegment3.start = j4;
                mediaSegment3.end = j4 + j3;
            }
        }
    }

    public static float[] parseBgColor(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65584, null, str, f2)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() >= 6) {
                try {
                    return new float[]{(hexToDecimal(str.substring(str.length() - 6, str.length() - 4).toUpperCase()) * 1.0f) / 255.0f, (hexToDecimal(str.substring(str.length() - 4, str.length() - 2).toUpperCase()) * 1.0f) / 255.0f, (hexToDecimal(str.substring(str.length() - 2, str.length()).toUpperCase()) * 1.0f) / 255.0f, f2};
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (float[]) invokeLF.objValue;
    }

    public static void releaseOtherTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65585, null, list, list2, onReleaseMultiMediaListener) == null) {
            int i3 = 1;
            if (list.size() <= 1 || list2.size() != list.size()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                i2 = 0;
                if (i3 >= list2.size()) {
                    break;
                }
                MultiMediaDataTrack multiMediaDataTrack = list2.get(i3);
                arrayList.add(multiMediaDataTrack);
                if (multiMediaDataTrack != null && !h.e(multiMediaDataTrack.multiMediaDataList)) {
                    while (i2 < h.b(multiMediaDataTrack.multiMediaDataList)) {
                        MultiMediaData multiMediaData = (MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, i2);
                        if (multiMediaData != null && onReleaseMultiMediaListener != null) {
                            onReleaseMultiMediaListener.onReleaseMultiMedia(multiMediaData);
                        }
                        i2++;
                    }
                }
                i3++;
            }
            while (i2 < arrayList.size()) {
                list2.remove(arrayList.get(i2));
                i2++;
            }
        }
    }

    public static void removeOneTrack(MediaTrack mediaTrack, List<MediaTrack> list, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65586, null, mediaTrack, list, list2, onReleaseMultiMediaListener) == null) || mediaTrack == null) {
            return;
        }
        int i2 = -1;
        if (list != null) {
            i2 = list.indexOf(mediaTrack);
            list.remove(mediaTrack);
        }
        MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) h.c(list2, i2);
        if (multiMediaDataTrack != null && multiMediaDataTrack.multiMediaDataList != null) {
            for (int i3 = 0; i3 < h.b(multiMediaDataTrack.multiMediaDataList); i3++) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, i3);
                if (multiMediaData != null && onReleaseMultiMediaListener != null) {
                    onReleaseMultiMediaListener.onReleaseMultiMedia(multiMediaData);
                }
            }
        }
        h.g(list2, i2);
    }

    public static void resetInputTrackTimeline(List<MultiMediaData> list, MediaTrack mediaTrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65587, null, list, mediaTrack) == null) || h.e(list) || mediaTrack == null || h.e(mediaTrack.mediaSegments)) {
            return;
        }
        long j = 0;
        for (int i2 = 0; i2 < mediaTrack.mediaSegments.size(); i2++) {
            MultiMediaData multiMediaData = (MultiMediaData) h.c(list, i2);
            MediaSegment mediaSegment = (MediaSegment) h.c(mediaTrack.mediaSegments, i2);
            if (multiMediaData != null && mediaSegment != null && !multiMediaData.isHeader() && !multiMediaData.isFooter()) {
                mediaSegment.start = j;
                j += (((float) (multiMediaData.end - multiMediaData.start)) * 1.0f) / multiMediaData.getCurrentSpeed();
                mediaSegment.end = j;
            }
        }
    }

    public static Bitmap saveOffscreenBitmap(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int i4 = i2 * i3 * 4;
            try {
                IntBuffer allocate = IntBuffer.allocate(i4);
                GLES20.glReadPixels(0, 0, i2, i3, GeneratedTexture.FORMAT, 5121, allocate);
                if (!z) {
                    Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocate);
                    return createBitmap;
                }
                int[] iArr = new int[i4];
                int[] array = allocate.array();
                for (int i5 = 0; i5 < i3; i5++) {
                    for (int i6 = 0; i6 < i2; i6++) {
                        iArr[(((i3 - i5) - 1) * i2) + i6] = array[(i5 * i2) + i6];
                    }
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap2.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
                return createBitmap2;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Buffer saveOffscreenBuffer(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65589, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int i4 = i2 * i3 * 4;
            try {
                IntBuffer allocate = IntBuffer.allocate(i4);
                GLES20.glReadPixels(0, 0, i2, i3, GeneratedTexture.FORMAT, 5121, allocate);
                if (z) {
                    int[] iArr = new int[i4];
                    int[] array = allocate.array();
                    for (int i5 = 0; i5 < i3; i5++) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            iArr[(((i3 - i5) - 1) * i2) + i6] = array[(i5 * i2) + i6];
                        }
                    }
                    return IntBuffer.wrap(iArr);
                }
                return allocate;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return (Buffer) invokeCommon.objValue;
    }

    public static MediaSegment transData2Segment(long j, MultiMediaData multiMediaData) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65590, null, j, multiMediaData)) == null) {
            MediaSegment mediaSegment = new MediaSegment();
            mediaSegment.type = multiMediaData.type == 0 ? "image" : "video";
            mediaSegment.start = j;
            long currentSpeed = j + ((((float) (multiMediaData.end - multiMediaData.start)) * 1.0f) / multiMediaData.getCurrentSpeed());
            mediaSegment.end = currentSpeed;
            if (multiMediaData.addDefaultEffect) {
                mediaSegment.mediaAEffect = b.a.a0.b.a.k.b.b(currentSpeed - mediaSegment.start);
            }
            return mediaSegment;
        }
        return (MediaSegment) invokeJL.objValue;
    }

    public static MultiMediaData transSegment2Data(MediaSegment mediaSegment, MediaTextureData mediaTextureData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65591, null, mediaSegment, mediaTextureData)) == null) {
            if (TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_IMAGE)) {
                return buildImageData(mediaSegment, mediaTextureData.path);
            }
            if (TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_VIDEO)) {
                return buildVideoData(mediaSegment, mediaTextureData.path);
            }
            return null;
        }
        return (MultiMediaData) invokeLL.objValue;
    }

    public static int updateTimeline(MediaTrack mediaTrack, List<MultiMediaData> list, long j) {
        InterceptResult invokeCommon;
        List<MediaSegment> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65592, null, new Object[]{mediaTrack, list, Long.valueOf(j)})) == null) {
            if (mediaTrack == null || (list2 = mediaTrack.mediaSegments) == null) {
                return -1;
            }
            int[] findIndexInSegments = findIndexInSegments(list2, j);
            int i2 = -1;
            for (int i3 : findIndexInSegments) {
                if (i2 == -1 || i2 > i3) {
                    i2 = i3;
                }
                MultiMediaData multiMediaData = (MultiMediaData) h.c(list, i3);
                if (multiMediaData != null) {
                    VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                    if (multiMediaData.type == 1 && vLogSimplePlayer != null) {
                        if (((float) vLogSimplePlayer.getCurrentPosition()) >= ((float) multiMediaData.end) / multiMediaData.getCurrentSpeed()) {
                            vLogSimplePlayer.pause();
                        } else {
                            if (vLogSimplePlayer.getCurrentPosition() >= vLogSimplePlayer.getDuration()) {
                                vLogSimplePlayer.seekTo(multiMediaData.start);
                            }
                            if (!vLogSimplePlayer.isPlaying()) {
                                vLogSimplePlayer.start();
                            }
                        }
                    }
                }
            }
            if (i2 > 0) {
                for (int i4 = 0; i4 < i2; i4++) {
                    MultiMediaData multiMediaData2 = (MultiMediaData) h.c(list, i4);
                    VLogSimplePlayer vLogSimplePlayer2 = multiMediaData2 != null ? multiMediaData2.player : null;
                    if (multiMediaData2 != null && multiMediaData2.type == 1 && vLogSimplePlayer2 != null && vLogSimplePlayer2.isPlaying()) {
                        vLogSimplePlayer2.pause();
                        vLogSimplePlayer2.seekTo(multiMediaData2.start);
                    }
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }
}
