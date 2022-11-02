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
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.dg9;
import com.baidu.tieba.gg0;
import com.baidu.tieba.lg0;
import com.baidu.tieba.mg0;
import com.baidu.tieba.ri9;
import com.baidu.tieba.ue9;
import com.baidu.tieba.vi9;
import com.baidu.tieba.wi9;
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
import com.sina.weibo.sdk.utils.ResourceManager;
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
/* loaded from: classes6.dex */
public class InnerMultiDataSourceUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InnerMultiDataSourceUtil() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public static int addMultiMediaData(MultiMediaDataTrack multiMediaDataTrack, int i, MultiMediaData multiMediaData) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, multiMediaDataTrack, i, multiMediaData)) == null) {
            if (multiMediaData == null || multiMediaDataTrack == null) {
                return -1;
            }
            int size = multiMediaDataTrack.multiMediaDataList.size();
            int i2 = i;
            if (i <= 0) {
                i2 = hasHeader(multiMediaDataTrack);
            } else if (i >= size) {
                if (hasFooter(multiMediaDataTrack)) {
                    size--;
                }
                i2 = size;
            }
            multiMediaDataTrack.multiMediaDataList.add(i2, multiMediaData);
            return i2;
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
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, null, mediaTrackConfig, map, list, onInitMultiMediaListener, onReleaseMultiMediaListener) == null) || mediaTrackConfig == null || wi9.e(list) || wi9.e(mediaTrackConfig.mediaTracks)) {
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
        int i = 0;
        int i2 = 0;
        loop1: for (MediaTrack mediaTrack : mediaTrackConfig.mediaTracks) {
            if (mediaTrack.mediaSegments != null) {
                for (int i3 = 0; i3 < mediaTrack.mediaSegments.size(); i3++) {
                    MediaSegment mediaSegment3 = mediaTrack.mediaSegments.get(i3);
                    if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, mediaSegment3.type)) {
                        if (TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE)) {
                            i = i3;
                            mediaSegment = mediaSegment3;
                        } else {
                            mediaSegment = mediaSegment3;
                            i = 0;
                        }
                    } else if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment3.type)) {
                        i2 = TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE) ? i3 : mediaTrack.mediaSegments.size() + 1;
                        mediaSegment2 = mediaSegment3;
                    }
                    if (mediaSegment != null && mediaSegment2 != null) {
                        break loop1;
                    }
                }
                continue;
            }
        }
        applyHeaderOrFooter(map, list, mediaSegment, i, onInitMultiMediaListener);
        applyHeaderOrFooter(map, list, mediaSegment2, i2, onInitMultiMediaListener);
    }

    public static void applyHeaderOrFooter(Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list, MediaSegment mediaSegment, int i, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener) {
        ShaderConfig shaderConfig;
        MultiMediaData transSegment2Data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{map, list, mediaSegment, Integer.valueOf(i), onInitMultiMediaListener}) == null) || mediaSegment == null || map == null || TextUtils.isEmpty(mediaSegment.shaderConfigKey) || (shaderConfig = map.get(mediaSegment.shaderConfigKey)) == null || wi9.e(shaderConfig.textures) || (transSegment2Data = transSegment2Data(mediaSegment, (MediaTextureData) wi9.c(shaderConfig.textures, 0))) == null) {
            return;
        }
        list.get(0).multiMediaDataList.add(i, transSegment2Data);
        if (onInitMultiMediaListener != null) {
            onInitMultiMediaListener.onInitMultiMedia(transSegment2Data);
        }
    }

    public static void applyOtherTrack(List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, long j, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, map, list2, Long.valueOf(j), onInitMultiMediaListener}) == null) {
            MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) wi9.c(list2, 0);
            List<MultiMediaData> list3 = multiMediaDataTrack != null ? multiMediaDataTrack.multiMediaDataList : null;
            int i = 0;
            boolean z = false;
            for (int i2 = 1; i2 < list.size(); i2++) {
                MediaTrack mediaTrack = list.get(i2);
                int b = wi9.b(mediaTrack.mediaSegments);
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < b; i3++) {
                    MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i3);
                    if (mediaSegment.start == 0 && mediaSegment.end == 0) {
                        mediaSegment.end = j;
                    }
                    if (mg0.m(mediaTrack, "multi_input") && list3 != null) {
                        MultiMediaData multiMediaData = (MultiMediaData) wi9.c(list3, i);
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
                            i++;
                            z = false;
                        }
                    } else if (!mg0.m(mediaTrack, "edit_sticker")) {
                        buildTexData(map, onInitMultiMediaListener, arrayList, mediaSegment);
                    } else if (TextUtils.equals(SubtitleLog.TAG, mediaSegment.type)) {
                        arrayList.add(new MultiMediaData());
                    }
                }
                MultiMediaDataTrack multiMediaDataTrack2 = new MultiMediaDataTrack();
                multiMediaDataTrack2.multiMediaDataList = arrayList;
                list2.add(multiMediaDataTrack2);
                if (z) {
                    i++;
                    z = false;
                }
            }
        }
    }

    public static void applySuperpositionSegment(List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnInitMultiMediaListener onInitMultiMediaListener, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65542, null, list, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener) == null) || wi9.e(list) || wi9.e(list2) || list.get(0).mediaSegments.size() < mg0.j) {
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
            multiMediaData = transSegment2Data(mediaSegment2, (MediaTextureData) wi9.c(map.get(mediaSegment2.shaderConfigKey).textures, 0));
            multiMediaData.scaleType = getOtherScaleType(mediaSegment2);
            if (onInitMultiMediaListener != null) {
                onInitMultiMediaListener.onInitMultiMedia(multiMediaData);
            }
        }
        list2.get(0).multiMediaDataSuperpositionHeader = multiMediaData;
        if (mediaSegment != null) {
            multiMediaData2 = transSegment2Data(mediaSegment, (MediaTextureData) wi9.c(map.get(mediaSegment.shaderConfigKey).textures, 0));
            multiMediaData2.scaleType = getOtherScaleType(mediaSegment);
            if (onInitMultiMediaListener != null) {
                onInitMultiMediaListener.onInitMultiMedia(multiMediaData2);
            }
        }
        list2.get(0).multiMediaDataSuperpositionFooter = multiMediaData2;
    }

    public static MediaTrack buildBlurBackgroundTrack(String str, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            MediaTrack mediaTrack = new MediaTrack();
            mediaTrack.trackType = str;
            float[] fArr = mediaTrack.glClearColor;
            fArr[0] = f;
            fArr[1] = f2;
            ArrayList arrayList = new ArrayList();
            MediaSegment mediaSegment = new MediaSegment();
            mediaSegment.type = "input";
            arrayList.add(mediaSegment);
            mediaTrack.mediaSegments = arrayList;
            return mediaTrack;
        }
        return (MediaTrack) invokeCommon.objValue;
    }

    public static MediaTrack buildColorBackgroundTrack(String str, String str2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Float.valueOf(f)})) == null) {
            MediaTrack mediaTrack = new MediaTrack();
            mediaTrack.trackType = str;
            float[] parseBgColor = parseBgColor(str2, f);
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
        if (!(interceptable == null || interceptable.invokeLL(65546, null, list, list2) == null) || wi9.e(list) || list2 == null) {
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
        if (com.baidu.tieba.wi9.b(r7) != com.baidu.tieba.wi9.b(r2.mediaSegments)) goto L40;
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
            MediaTrack mediaTrack2 = (MediaTrack) wi9.c(list3, 0);
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
                mediaTrack = (MediaTrack) wi9.c(list3, 0);
                if (mediaTrack != null) {
                    mediaTrack.glClearColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
                    mediaTrack.mediaTransitions = null;
                }
                arrayList = new ArrayList();
                wi9.a(arrayList, mg0.e(mediaTrack, mediaTrackConfig, mediaTrackConfig != null ? null : mediaTrackConfig.shaderConfigMapDebug));
                if (wi9.b(arrayList) > 0) {
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
                    if (!TextUtils.equals(next2.getKey(), mg0.e) && !TextUtils.equals(next2.getKey(), mg0.c) && !next2.getKey().contains(mg0.d)) {
                        next2.getValue().destroy();
                        it.remove();
                    }
                }
                if (mediaTrackConfig != null && (map2 = mediaTrackConfig.shaderConfigMapDebug) != null) {
                    for (Map.Entry<String, ShaderConfig> entry : map2.entrySet()) {
                        if ((!TextUtils.equals(entry.getKey(), mg0.c) && !TextUtils.equals(entry.getKey(), mg0.e) && !entry.getKey().contains(mg0.d)) || !map.containsKey(entry.getKey())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            buildInputTrack(list, list3);
            mediaTrack = (MediaTrack) wi9.c(list3, 0);
            if (mediaTrack != null) {
            }
            arrayList = new ArrayList();
            wi9.a(arrayList, mg0.e(mediaTrack, mediaTrackConfig, mediaTrackConfig != null ? null : mediaTrackConfig.shaderConfigMapDebug));
            if (wi9.b(arrayList) > 0) {
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
        int min = Math.min(wi9.b(list), wi9.c(list3, 0) != null ? wi9.b(((MediaTrack) wi9.c(list3, 0)).mediaSegments) : 0);
        for (int i = 0; i < min; i++) {
            MultiMediaData multiMediaData = (MultiMediaData) wi9.c(list, i);
            MediaSegment mediaSegment = wi9.c(list3, 0) != null ? (MediaSegment) wi9.c(((MediaTrack) wi9.c(list3, 0)).mediaSegments, i) : null;
            if (mediaSegment != null && multiMediaData != null && !TextUtils.isEmpty(mediaSegment.scaleType)) {
                multiMediaData.scaleType = mediaSegment.scaleType;
            }
        }
        applySuperpositionSegment(list3, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener);
        applyHeaderAndFooterSegment(mediaTrackConfig, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener);
        applyOtherTrack(list3, map, list2, getSegmentsDuration((MediaTrack) wi9.c(list3, 0)), onInitMultiMediaListener);
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
                int b = wi9.b(shaderConfig.textures);
                if (b != 0) {
                    for (int i = 0; i < b; i++) {
                        MediaTextureData mediaTextureData = shaderConfig.textures.get(i);
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

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 == i4) {
                i2 = i;
            }
            int i5 = 1;
            if (i3 > i2 || i4 > i) {
                int i6 = i3 / 2;
                int i7 = i4 / 2;
                while (i6 / i5 > i2 && i7 / i5 > i) {
                    i5 *= 2;
                }
            }
            return i5;
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

    public static int deleteMultiMediaData(List<MultiMediaDataTrack> list, int i, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65555, null, list, i, onReleaseMultiMediaListener)) == null) {
            if (i < 0 || list == null || list.size() == 0 || list.get(0) == null || list.get(0).multiMediaDataList == null || i >= list.get(0).multiMediaDataList.size()) {
                return -1;
            }
            MultiMediaData remove = list.get(0).multiMediaDataList.remove(i);
            if (onReleaseMultiMediaListener != null) {
                onReleaseMultiMediaListener.onReleaseMultiMedia(remove);
                return i;
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    public static MultiMediaData findDataByUuid(List<MultiMediaData> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, list, str)) == null) {
            if (!TextUtils.isEmpty(str) && !wi9.e(list)) {
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
            for (int i = 0; i < size; i++) {
                MediaSegment mediaSegment = (MediaSegment) wi9.c(list, i);
                if (mediaSegment == null || TextUtils.equals("input_blank", mediaSegment.type)) {
                    break;
                }
                if (mediaSegment.start <= j && mediaSegment.end >= j) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            int size2 = arrayList.size();
            int[] iArr = new int[size2];
            if (arrayList.size() != 0 && size2 != 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
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
            if (wi9.e(list)) {
                return 0;
            }
            for (int i = 0; i < list.size(); i++) {
                MediaSegment mediaSegment = list.get(i);
                if (mediaSegment.start <= j && mediaSegment.end >= j) {
                    return i;
                }
            }
            return 0;
        }
        return invokeLJ.intValue;
    }

    public static MediaSegment findSegmentByMultiMediaData(MultiMediaData multiMediaData, List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        InterceptResult invokeLLL;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, multiMediaData, list, list2)) == null) {
            if (multiMediaData != null && list != null && list2 != null && (b = wi9.b(list)) == wi9.b(list2) && b != 0) {
                for (int i = 0; i < b; i++) {
                    MediaTrack mediaTrack = (MediaTrack) wi9.c(list, i);
                    MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) wi9.c(list2, i);
                    if (mediaTrack != null && multiMediaDataTrack != null) {
                        List<MultiMediaData> list3 = multiMediaDataTrack.multiMediaDataList;
                        List<MediaSegment> list4 = mediaTrack.mediaSegments;
                        if (wi9.b(list3) != wi9.b(list4)) {
                            continue;
                        } else {
                            int i2 = -1;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= list3.size()) {
                                    break;
                                } else if (multiMediaData == list3.get(i3)) {
                                    i2 = i3;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            if (i2 >= 0) {
                                return list4.get(i2);
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
            if (ue9.c().getContext() == null || ue9.c().getContext().getApplicationInfo() == null) {
                return null;
            }
            return ue9.c().getContext().getApplicationInfo().packageName;
        }
        return (String) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? ue9.c().getContext() : (Context) invokeV.objValue;
    }

    public static MediaTrack getEffectTrack(List<MediaTrack> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, list)) == null) {
            if (wi9.e(list)) {
                return null;
            }
            for (MediaTrack mediaTrack : list) {
                boolean z = true;
                if (mediaTrack == null || !TextUtils.equals("effect", mediaTrack.trackType)) {
                    boolean z2 = false;
                    if (mediaTrack != null && !wi9.e(mediaTrack.mediaSegments)) {
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
                for (int i = 0; i < 3; i++) {
                    String str2 = strArr[i];
                    int identifier = context.getResources().getIdentifier(str, ResourceManager.DRAWABLE, str2);
                    if (identifier == 0) {
                        identifier = context.getResources().getIdentifier(str, "mipmap", str2);
                    }
                    if (identifier != 0) {
                        return identifier;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
            if (mediaTrack == null || wi9.e(mediaTrack.mediaSegments)) {
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
            if (mediaTrack == null || wi9.e(mediaTrack.mediaSegments) || TextUtils.isEmpty(str)) {
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
                if (mg0.m(mediaTrack, str)) {
                    return mediaTrack;
                }
            }
            return null;
        }
        return (MediaTrack) invokeLL.objValue;
    }

    public static void glDeleteTextures(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65572, null, i) == null) || i == 0) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static void glDeleteTextures(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, null, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int i = multiMediaData.textureId;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            multiMediaData.textureId = 0;
        }
        int i2 = multiMediaData.backupFrameTextureId;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
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
            if (mediaTrack != null && !wi9.e(mediaTrack.mediaSegments)) {
                int size = mediaTrack.mediaSegments.size();
                for (int i = 0; i < size; i++) {
                    MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i);
                    if (mediaSegment != null && !TextUtils.isEmpty(mediaSegment.lutConfigKey) && !mediaSegment.lutConfigKey.contains(mg0.d)) {
                        return i;
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

    public static int hexCharToDecimal(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{Character.valueOf(c)})) == null) ? (c < 'A' || c > 'F') ? c - '0' : (c + '\n') - 65 : invokeCommon.intValue;
    }

    public static int hexToDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i = (i * 16) + hexCharToDecimal(str.charAt(i2));
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int initImageByBitmap(MultiMediaData multiMediaData, Bitmap bitmap) {
        InterceptResult invokeLL;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, multiMediaData, bitmap)) == null) {
            if (bitmap == null || bitmap.isRecycled() || multiMediaData == null || multiMediaData.textureId != 0) {
                return 0;
            }
            if (multiMediaData.mipmap) {
                b = gg0.c();
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                GLES20.glGenerateMipmap(3553);
            } else {
                b = gg0.b();
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
            return b;
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
                multiMediaData.rotation = vi9.b(mediaMetadataRetriever.extractMetadata(24), 0);
                multiMediaData.width = vi9.b(mediaMetadataRetriever.extractMetadata(18), 0);
                multiMediaData.height = vi9.b(mediaMetadataRetriever.extractMetadata(19), 0);
                multiMediaData.originalDuration = vi9.c(mediaMetadataRetriever.extractMetadata(9), 0L);
            } catch (Exception e) {
                ri9.d(e.getMessage());
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
            dg9 dg9Var = new dg9();
            MediaAEffect mediaAEffect = (MediaAEffect) dg9Var.b(readText, MediaAEffect.class);
            if (mediaAEffect == null) {
                return null;
            }
            ShaderConfig shaderConfig = (ShaderConfig) dg9Var.b(FileUtils.readText(new File(str + File.separator + "shader_config.json")), ShaderConfig.class);
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
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                mediaTransition = (MediaTransition) new dg9().b(sb.toString(), MediaTransition.class);
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
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                shaderConfig = (ShaderConfig) new dg9().b(sb2.toString(), ShaderConfig.class);
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
        if (!(interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{list, mediaTrack, Long.valueOf(j), Long.valueOf(j2)}) == null) || wi9.e(list)) {
            return;
        }
        MediaTrack mediaTrack2 = (MediaTrack) wi9.c(list, 0);
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
        if (wi9.e(list2) || wi9.e(list3)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            MediaSegment mediaSegment3 = list2.get(i);
            MediaSegment mediaSegment4 = list3.get(i);
            if (mediaSegment3 != null && mediaSegment4 != null) {
                long j3 = mediaSegment3.end - mediaSegment3.start;
                long j4 = mediaSegment4.start + j;
                mediaSegment3.start = j4;
                mediaSegment3.end = j4 + j3;
            }
        }
    }

    public static float[] parseBgColor(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65584, null, str, f)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() >= 6) {
                try {
                    return new float[]{(hexToDecimal(str.substring(str.length() - 6, str.length() - 4).toUpperCase()) * 1.0f) / 255.0f, (hexToDecimal(str.substring(str.length() - 4, str.length() - 2).toUpperCase()) * 1.0f) / 255.0f, (hexToDecimal(str.substring(str.length() - 2, str.length()).toUpperCase()) * 1.0f) / 255.0f, f};
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (float[]) invokeLF.objValue;
    }

    public static void releaseOtherTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65585, null, list, list2, onReleaseMultiMediaListener) == null) {
            int i2 = 1;
            if (list.size() <= 1 || list2.size() != list.size()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                i = 0;
                if (i2 >= list2.size()) {
                    break;
                }
                MultiMediaDataTrack multiMediaDataTrack = list2.get(i2);
                arrayList.add(multiMediaDataTrack);
                if (multiMediaDataTrack != null && !wi9.e(multiMediaDataTrack.multiMediaDataList)) {
                    while (i < wi9.b(multiMediaDataTrack.multiMediaDataList)) {
                        MultiMediaData multiMediaData = (MultiMediaData) wi9.c(multiMediaDataTrack.multiMediaDataList, i);
                        if (multiMediaData != null && onReleaseMultiMediaListener != null) {
                            onReleaseMultiMediaListener.onReleaseMultiMedia(multiMediaData);
                        }
                        i++;
                    }
                }
                i2++;
            }
            while (i < arrayList.size()) {
                list2.remove(arrayList.get(i));
                i++;
            }
        }
    }

    public static void removeOneTrack(MediaTrack mediaTrack, List<MediaTrack> list, List<MultiMediaDataTrack> list2, MultiDataSourceUtil.OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65586, null, mediaTrack, list, list2, onReleaseMultiMediaListener) == null) || mediaTrack == null) {
            return;
        }
        int i = -1;
        if (list != null) {
            i = list.indexOf(mediaTrack);
            list.remove(mediaTrack);
        }
        MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) wi9.c(list2, i);
        if (multiMediaDataTrack != null && multiMediaDataTrack.multiMediaDataList != null) {
            for (int i2 = 0; i2 < wi9.b(multiMediaDataTrack.multiMediaDataList); i2++) {
                MultiMediaData multiMediaData = (MultiMediaData) wi9.c(multiMediaDataTrack.multiMediaDataList, i2);
                if (multiMediaData != null && onReleaseMultiMediaListener != null) {
                    onReleaseMultiMediaListener.onReleaseMultiMedia(multiMediaData);
                }
            }
        }
        wi9.g(list2, i);
    }

    public static void resetInputTrackTimeline(List<MultiMediaData> list, MediaTrack mediaTrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65587, null, list, mediaTrack) == null) || wi9.e(list) || mediaTrack == null || wi9.e(mediaTrack.mediaSegments)) {
            return;
        }
        long j = 0;
        for (int i = 0; i < mediaTrack.mediaSegments.size(); i++) {
            MultiMediaData multiMediaData = (MultiMediaData) wi9.c(list, i);
            MediaSegment mediaSegment = (MediaSegment) wi9.c(mediaTrack.mediaSegments, i);
            if (multiMediaData != null && mediaSegment != null && !multiMediaData.isHeader() && !multiMediaData.isFooter()) {
                mediaSegment.start = j;
                j += (((float) (multiMediaData.end - multiMediaData.start)) * 1.0f) / multiMediaData.getCurrentSpeed();
                mediaSegment.end = j;
            }
        }
    }

    public static Bitmap saveOffscreenBitmap(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = i * i2 * 4;
            try {
                IntBuffer allocate = IntBuffer.allocate(i3);
                GLES20.glReadPixels(0, 0, i, i2, GeneratedTexture.FORMAT, 5121, allocate);
                if (!z) {
                    Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocate);
                    return createBitmap;
                }
                int[] iArr = new int[i3];
                int[] array = allocate.array();
                for (int i4 = 0; i4 < i2; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        iArr[(((i2 - i4) - 1) * i) + i5] = array[(i4 * i) + i5];
                    }
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                createBitmap2.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
                return createBitmap2;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Buffer saveOffscreenBuffer(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65589, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = i * i2 * 4;
            try {
                IntBuffer allocate = IntBuffer.allocate(i3);
                GLES20.glReadPixels(0, 0, i, i2, GeneratedTexture.FORMAT, 5121, allocate);
                if (z) {
                    int[] iArr = new int[i3];
                    int[] array = allocate.array();
                    for (int i4 = 0; i4 < i2; i4++) {
                        for (int i5 = 0; i5 < i; i5++) {
                            iArr[(((i2 - i4) - 1) * i) + i5] = array[(i4 * i) + i5];
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
                mediaSegment.mediaAEffect = lg0.b(currentSpeed - mediaSegment.start);
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
            int i = -1;
            for (int i2 : findIndexInSegments) {
                if (i == -1 || i > i2) {
                    i = i2;
                }
                MultiMediaData multiMediaData = (MultiMediaData) wi9.c(list, i2);
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
            if (i > 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    MultiMediaData multiMediaData2 = (MultiMediaData) wi9.c(list, i3);
                    VLogSimplePlayer vLogSimplePlayer2 = multiMediaData2 != null ? multiMediaData2.player : null;
                    if (multiMediaData2 != null && multiMediaData2.type == 1 && vLogSimplePlayer2 != null && vLogSimplePlayer2.isPlaying()) {
                        vLogSimplePlayer2.pause();
                        vLogSimplePlayer2.seekTo(multiMediaData2.start);
                    }
                }
            }
            return i;
        }
        return invokeCommon.intValue;
    }
}
