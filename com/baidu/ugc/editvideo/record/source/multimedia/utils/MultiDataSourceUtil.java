package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import d.a.v0.t.h;
import java.nio.Buffer;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class MultiDataSourceUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_SINGLE_MEDIA_TIME = 3.0f;
    public static String sDefaultScaleType = "center_inside";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface OnInitMultiMediaListener {
        void onInitMultiMedia(MultiMediaData multiMediaData);
    }

    /* loaded from: classes5.dex */
    public interface OnReleaseMultiMediaListener {
        void onReleaseMultiMedia(MultiMediaData multiMediaData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-384645507, "Lcom/baidu/ugc/editvideo/record/source/multimedia/utils/MultiDataSourceUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-384645507, "Lcom/baidu/ugc/editvideo/record/source/multimedia/utils/MultiDataSourceUtil;");
        }
    }

    public MultiDataSourceUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int addMultiMediaData(MultiMediaDataTrack multiMediaDataTrack, int i2, MultiMediaData multiMediaData) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, multiMediaDataTrack, i2, multiMediaData)) == null) ? InnerMultiDataSourceUtil.addMultiMediaData(multiMediaDataTrack, i2, multiMediaData) : invokeLIL.intValue;
    }

    public static void applySuperpositionSegment(List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, OnInitMultiMediaListener onInitMultiMediaListener, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, list, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener) == null) {
            InnerMultiDataSourceUtil.applySuperpositionSegment(list, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener);
        }
    }

    public static void buildInputTrack(List<MultiMediaData> list, List<MediaTrack> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, list2) == null) {
            InnerMultiDataSourceUtil.buildInputTrack(list, list2);
        }
    }

    public static void buildMultiMediaDataSource(List<MultiMediaData> list, MediaTrackConfig mediaTrackConfig, List<MultiMediaDataTrack> list2, List<MediaTrack> list3, Map<String, ShaderConfig> map, OnInitMultiMediaListener onInitMultiMediaListener, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{list, mediaTrackConfig, list2, list3, map, onInitMultiMediaListener, onReleaseMultiMediaListener}) == null) {
            InnerMultiDataSourceUtil.buildMultiMediaDataSource(list, mediaTrackConfig, list2, list3, map, onInitMultiMediaListener, onReleaseMultiMediaListener);
        }
    }

    public static void buildMultiMediaDataTrackList(List<MultiMediaData> list, List<MultiMediaDataTrack> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, list2) == null) {
            InnerMultiDataSourceUtil.buildMultiMediaDataTrackList(list, list2);
        }
    }

    public static MediaTrack buildSubtitleAndStickerTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, list2)) == null) ? InnerMultiDataSourceUtil.buildSubtitleAndStickerTrack(list, list2) : (MediaTrack) invokeLL.objValue;
    }

    public static Bitmap decodeBitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? InnerMultiDataSourceUtil.decodeBitmap(str) : (Bitmap) invokeL.objValue;
    }

    public static int deleteMultiMediaData(List<MultiMediaDataTrack> list, int i2, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, list, i2, onReleaseMultiMediaListener)) == null) ? InnerMultiDataSourceUtil.deleteMultiMediaData(list, i2, onReleaseMultiMediaListener) : invokeLIL.intValue;
    }

    public static MultiMediaData findDataByUuid(List<MultiMediaData> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, list, str)) == null) ? InnerMultiDataSourceUtil.findDataByUuid(list, str) : (MultiMediaData) invokeLL.objValue;
    }

    public static int[] findIndexInSegments(List<MediaSegment> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, list, j)) == null) ? InnerMultiDataSourceUtil.findIndexInSegments(list, j) : (int[]) invokeLJ.objValue;
    }

    public static int findInputIndexInSegments(List<MediaSegment> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, null, list, j)) == null) ? InnerMultiDataSourceUtil.findInputIndexInSegments(list, j) : invokeLJ.intValue;
    }

    public static MediaSegment findSegmentByMultiMediaData(MultiMediaData multiMediaData, List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, multiMediaData, list, list2)) == null) ? InnerMultiDataSourceUtil.findSegmentByMultiMediaData(multiMediaData, list, list2) : (MediaSegment) invokeLLL.objValue;
    }

    public static MediaTrack getEffectTrack(List<MediaTrack> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) ? InnerMultiDataSourceUtil.getEffectTrack(list) : (MediaTrack) invokeL.objValue;
    }

    public static String getInputScaleType(MediaSegment mediaSegment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, mediaSegment)) == null) ? InnerMultiDataSourceUtil.getInputScaleType(mediaSegment) : (String) invokeL.objValue;
    }

    public static int getInputSegmentSize(MediaTrackConfig mediaTrackConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, mediaTrackConfig)) == null) ? InnerMultiDataSourceUtil.getInputSegmentSize(mediaTrackConfig) : invokeL.intValue;
    }

    public static long getMultiMediaDataRealEnd(MediaTrack mediaTrack, int i2) {
        InterceptResult invokeLI;
        MediaSegment mediaSegment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, mediaTrack, i2)) == null) {
            if (i2 < 0 || mediaTrack == null || h.e(mediaTrack.mediaSegments) || (mediaSegment = (MediaSegment) h.c(mediaTrack.mediaSegments, i2)) == null) {
                return 0L;
            }
            MediaTransition mediaTransition = (MediaTransition) h.c(mediaTrack.mediaTransitions, i2);
            return (mediaSegment.end - mediaSegment.start) - (mediaTransition != null ? mediaTransition.duration : 0L);
        }
        return invokeLI.longValue;
    }

    public static long getMultiMediaDataSeekTime(MultiMediaData multiMediaData, MediaSegment mediaSegment, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{multiMediaData, mediaSegment, Long.valueOf(j)})) == null) ? InnerMultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData, mediaSegment, j) : invokeCommon.longValue;
    }

    public static long getSegmentsDuration(MediaTrack mediaTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, mediaTrack)) == null) ? InnerMultiDataSourceUtil.getSegmentsDuration(mediaTrack) : invokeL.longValue;
    }

    public static List<MediaSegment> getStickerSegmentsDataByType(MediaTrack mediaTrack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, mediaTrack, str)) == null) ? InnerMultiDataSourceUtil.getStickerSegmentsDataByType(mediaTrack, str) : (List) invokeLL.objValue;
    }

    public static MediaTrack getSubtitleAndStickerTrack(List<MediaTrack> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, list)) == null) ? InnerMultiDataSourceUtil.getSubtitleAndStickerTrack(list) : (MediaTrack) invokeL.objValue;
    }

    public static void glDeleteTextures(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            InnerMultiDataSourceUtil.glDeleteTextures(i2);
        }
    }

    public static void glDeleteTextures(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, multiMediaData) == null) {
            InnerMultiDataSourceUtil.glDeleteTextures(multiMediaData);
        }
    }

    public static boolean hasAddInputFooter(MediaTrackConfig mediaTrackConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, mediaTrackConfig)) == null) ? InnerMultiDataSourceUtil.hasAddInputFooter(mediaTrackConfig) : invokeL.booleanValue;
    }

    public static boolean hasAddInputHeader(MediaTrackConfig mediaTrackConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, mediaTrackConfig)) == null) ? InnerMultiDataSourceUtil.hasAddInputHeader(mediaTrackConfig) : invokeL.booleanValue;
    }

    public static int hasGlobalFilter(MediaTrack mediaTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, mediaTrack)) == null) ? InnerMultiDataSourceUtil.hasGlobalFilter(mediaTrack) : invokeL.intValue;
    }

    public static int initImageByBitmap(MultiMediaData multiMediaData, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, multiMediaData, bitmap)) == null) ? InnerMultiDataSourceUtil.initImageByBitmap(multiMediaData, bitmap) : invokeLL.intValue;
    }

    public static void initVideoByPath(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, multiMediaData) == null) {
            InnerMultiDataSourceUtil.initVideoByPath(multiMediaData);
        }
    }

    public static MediaAEffectConfig loadMediaAEffectConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) ? InnerMultiDataSourceUtil.loadMediaAEffectConfig(str) : (MediaAEffectConfig) invokeL.objValue;
    }

    public static MediaTransitionConfig loadMediaTransitionConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? InnerMultiDataSourceUtil.loadMediaTransitionConfig(str) : (MediaTransitionConfig) invokeL.objValue;
    }

    public static void modifyTimeByRange(List<MediaTrack> list, MediaTrack mediaTrack, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{list, mediaTrack, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            InnerMultiDataSourceUtil.modifyTimeByRange(list, mediaTrack, j, j2);
        }
    }

    public static void releaseOtherTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65568, null, list, list2, onReleaseMultiMediaListener) == null) {
            InnerMultiDataSourceUtil.releaseOtherTrack(list, list2, onReleaseMultiMediaListener);
        }
    }

    public static void removeOneTrack(MediaTrack mediaTrack, List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, mediaTrack, list, list2) == null) {
            InnerMultiDataSourceUtil.removeOneTrack(mediaTrack, list, list2);
        }
    }

    public static Bitmap saveOffscreenBitmap(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65570, null, i2, i3)) == null) ? saveOffscreenBitmap(i2, i3, true) : (Bitmap) invokeII.objValue;
    }

    public static Bitmap saveOffscreenBitmap(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65571, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) ? InnerMultiDataSourceUtil.saveOffscreenBitmap(i2, i3, z) : (Bitmap) invokeCommon.objValue;
    }

    public static Buffer saveOffscreenBuffer(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65572, null, i2, i3)) == null) ? saveOffscreenBuffer(i2, i3, true) : (Buffer) invokeII.objValue;
    }

    public static Buffer saveOffscreenBuffer(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) ? InnerMultiDataSourceUtil.saveOffscreenBuffer(i2, i3, z) : (Buffer) invokeCommon.objValue;
    }

    public static MediaSegment transData2Segment(long j, MultiMediaData multiMediaData) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65574, null, j, multiMediaData)) == null) ? InnerMultiDataSourceUtil.transData2Segment(j, multiMediaData) : (MediaSegment) invokeJL.objValue;
    }

    public static int updateTimeline(MediaTrack mediaTrack, List<MultiMediaData> list, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{mediaTrack, list, Long.valueOf(j)})) == null) ? InnerMultiDataSourceUtil.updateTimeline(mediaTrack, list, j) : invokeCommon.intValue;
    }
}
