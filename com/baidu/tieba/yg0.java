package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectKeyData;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class yg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface d<T> {
        T a();

        T b(T t);

        boolean c(T t);
    }

    /* loaded from: classes8.dex */
    public static class a implements d<MediaTransition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaTrack a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: d */
        public boolean c(MediaTransition mediaTransition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaTransition)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public a(MediaTrack mediaTrack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaTrack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaTrack;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: e */
        public MediaTransition b(MediaTransition mediaTransition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaTransition)) == null) {
                MediaTrack mediaTrack = this.a;
                if (mediaTrack != null && TextUtils.equals("no", mediaTrack.transitionMode)) {
                    return new MediaTransition();
                }
                return (MediaTransition) mediaTransition.clone();
            }
            return (MediaTransition) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: f */
        public MediaTransition a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new MediaTransition();
            }
            return (MediaTransition) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements d<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaTrackConfig a;

        public String e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? str : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: f */
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public b(MediaTrackConfig mediaTrackConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaTrackConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaTrackConfig;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yg0.d
        public /* bridge */ /* synthetic */ String b(String str) {
            String str2 = str;
            e(str2);
            return str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: d */
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                MediaAEffect mediaAEffect = this.a.effectConfigMap.get(str);
                if (mediaAEffect != null && !mediaAEffect.isRandomModeOnce()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements d<MediaAEffect> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: f */
        public MediaAEffect a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (MediaAEffect) invokeV.objValue;
        }

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: d */
        public boolean c(MediaAEffect mediaAEffect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaAEffect)) == null) {
                if (mediaAEffect != null && !mediaAEffect.isRandomModeOnce()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg0.d
        /* renamed from: e */
        public MediaAEffect b(MediaAEffect mediaAEffect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaAEffect)) == null) {
                return mediaAEffect.m47clone();
            }
            return (MediaAEffect) invokeL.objValue;
        }
    }

    public static void A(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65536, null, j, mediaAEffect) == null) {
            if (!TextUtils.equals(MediaAEffect.AE_ANIM_ONCE, mediaAEffect.repeatMode)) {
                long j2 = mediaAEffect.duration;
                int i = (int) (j / j2);
                if (((int) (j % j2)) != 0) {
                    i++;
                }
                j /= i;
            }
            B(j, mediaAEffect);
        }
    }

    public static <T> T p(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.get(i);
        }
        return (T) invokeLI.objValue;
    }

    public static int r(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            try {
                return context.getResources().getIdentifier(str, "raw", context.getApplicationInfo().packageName);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static void B(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65537, null, j, mediaAEffect) == null) {
            float f = (((float) j) * 1.0f) / ((float) mediaAEffect.duration);
            mediaAEffect.duration = j;
            for (MediaOneAEffect mediaOneAEffect : mediaAEffect.mediaOneAEffects) {
                long j2 = mediaOneAEffect.end;
                long j3 = mediaOneAEffect.start;
                if (j2 - j3 == 0) {
                    mediaOneAEffect.start = 0L;
                    mediaOneAEffect.end = 0L;
                } else {
                    mediaOneAEffect.start = ((float) j3) * f;
                    mediaOneAEffect.end = ((float) j2) * f;
                }
            }
        }
    }

    public static MediaTransition u(List<MediaTransition> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, list, str)) == null) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (MediaTransition mediaTransition : list) {
                    if (mediaTransition != null && str.equals(mediaTransition.name)) {
                        return (MediaTransition) mediaTransition.clone();
                    }
                }
                return new MediaTransition();
            }
            return new MediaTransition();
        }
        return (MediaTransition) invokeLL.objValue;
    }

    public static boolean x(List<MediaTrack> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, list, str)) == null) {
            if (list != null && !TextUtils.isEmpty(str)) {
                for (MediaTrack mediaTrack : list) {
                    if (mediaTrack != null) {
                        if (TextUtils.equals(mediaTrack.trackType, str)) {
                            return true;
                        }
                        List<MediaSegment> list2 = mediaTrack.mediaSegments;
                        if (list2 != null) {
                            for (MediaSegment mediaSegment : list2) {
                                if (TextUtils.equals(mediaSegment.type, str)) {
                                    return true;
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void C(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65538, null, j, mediaAEffect) == null) {
            ArrayList<MediaOneAEffect> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<MediaOneAEffect> it = mediaAEffect.mediaOneAEffects.iterator();
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (it.hasNext()) {
                MediaOneAEffect next = it.next();
                long j5 = j2;
                long j6 = next.end;
                ArrayList arrayList3 = arrayList2;
                Iterator<MediaOneAEffect> it2 = it;
                long j7 = next.start;
                if (j6 - j7 == 0) {
                    if (j7 == 0) {
                        if (dgb.e(arrayList)) {
                            next.start = j4;
                            long j8 = (j4 + j) - mediaAEffect.duration;
                            next.end = j8;
                            j2 = j8 - j4;
                            yfb.c("zmy", "aCenters 0 start : " + next.start + " end : " + next.end + " preSegmentDuration ： " + j);
                            j4 = j8;
                        } else {
                            j2 = j5;
                        }
                        arrayList.add(next);
                        arrayList2 = arrayList3;
                        it = it2;
                    } else {
                        j3 += j7;
                        arrayList3.add(next);
                    }
                } else {
                    if (j4 != 0) {
                        next.start = j4;
                        next.end = j4 + (j6 - j7);
                    }
                    yfb.c("zmy", "aEffect start : " + next.start + " end : " + next.end);
                    j4 = next.end;
                }
                arrayList2 = arrayList3;
                j2 = j5;
                it = it2;
            }
            ArrayList<MediaOneAEffect> arrayList4 = arrayList2;
            long j9 = j2;
            if (dgb.b(arrayList) > 1) {
                long j10 = 0;
                if (j9 - j3 > 0) {
                    long j11 = 0;
                    long j12 = 0;
                    for (MediaOneAEffect mediaOneAEffect : arrayList) {
                        long j13 = mediaOneAEffect.start;
                        if (j13 != j10) {
                            long j14 = mediaOneAEffect.end;
                            if (j14 != j10) {
                                long j15 = (j13 + ((j14 - j13) / 2)) - (j3 / 2);
                                mediaOneAEffect.end = j15;
                                yfb.c("zmy", "aCenters 0 after start : " + mediaOneAEffect.start + " end : " + mediaOneAEffect.end + " centerEffectDuration : " + j3);
                                for (MediaOneAEffect mediaOneAEffect2 : arrayList4) {
                                    mediaOneAEffect2.start = j15;
                                    j15 += mediaOneAEffect2.end;
                                    mediaOneAEffect2.end = j15;
                                    yfb.c("zmy", "aCenterEffects after start : " + mediaOneAEffect2.start + " end : " + mediaOneAEffect2.end);
                                }
                                j12 = j14;
                                j11 = j15;
                                j10 = 0;
                            }
                        }
                        if (j11 != 0) {
                            mediaOneAEffect.start = j11;
                            mediaOneAEffect.end = j12;
                            yfb.c("zmy", "aCenters 1 after start : " + mediaOneAEffect.start + " end : " + mediaOneAEffect.end);
                        }
                        j10 = 0;
                    }
                } else {
                    MediaOneAEffect mediaOneAEffect3 = (MediaOneAEffect) dgb.c(arrayList, 1);
                    if (mediaOneAEffect3 != null) {
                        mediaAEffect.mediaOneAEffects.remove(mediaOneAEffect3);
                    }
                }
            }
            mediaAEffect.duration = j;
        }
    }

    public static void b(MediaTrack mediaTrack, long j) {
        boolean z;
        MediaTrack mediaTrack2;
        List<MediaTransition> list;
        List<MediaTransition> list2;
        List<MediaTransition> list3;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, mediaTrack, j) == null) {
            MediaTrack mediaTrack3 = mediaTrack;
            long j3 = j;
            MediaSegment mediaSegment = (MediaSegment) dgb.d(mediaTrack3.mediaSegments);
            if (mediaSegment != null && TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment.type)) {
                z = true;
            } else {
                z = false;
            }
            int i = 0;
            long j4 = 0;
            int i2 = 0;
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            while (i < mediaTrack3.mediaSegments.size()) {
                MediaSegment mediaSegment2 = (MediaSegment) p(mediaTrack3.mediaSegments, i);
                if (mediaSegment2 != null) {
                    List<MediaTransition> list4 = mediaTrack3.mediaTransitions;
                    if (list4 != null && i > 0) {
                        MediaTransition mediaTransition = (MediaTransition) p(list4, i - 1);
                        if (mediaTransition != null) {
                            long j8 = mediaTransition.duration;
                            if (j8 <= j4 && j8 <= mediaSegment2.end - mediaSegment2.start) {
                                long j9 = j5 - j8;
                                if (j6 > 0 && j7 > j9) {
                                    mediaTransition.duration = 0L;
                                    mediaTransition.start = 0L;
                                    mediaTransition.end = 0L;
                                } else {
                                    mediaTransition.start = j9;
                                    mediaTransition.end = j5;
                                    j7 = j5;
                                }
                            } else {
                                mediaTransition.duration = 0L;
                                mediaTransition.start = 0L;
                                mediaTransition.end = 0L;
                            }
                            j6 = mediaTransition.duration;
                        }
                    }
                    j4 = mediaSegment2.end - mediaSegment2.start;
                    long j10 = j5 - j6;
                    mediaSegment2.start = j10;
                    j2 = j;
                    if (j2 > 0 && j10 + j4 >= j2) {
                        mediaSegment2.end = j2;
                        i2 = i;
                    } else {
                        mediaSegment2.end = mediaSegment2.start + j4;
                    }
                    j5 = mediaSegment2.end;
                    MediaAEffect mediaAEffect = mediaSegment2.mediaAEffect;
                    if (mediaAEffect != null && mediaAEffect.mediaOneAEffects != null && !"camera".equals(mediaSegment2.type)) {
                        z(j4, mediaSegment2.mediaAEffect);
                    }
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                    j3 = j2;
                    mediaTrack3 = mediaTrack;
                }
                j2 = j3;
                i++;
                j3 = j2;
                mediaTrack3 = mediaTrack;
            }
            if (i2 > 0) {
                int i3 = i2 + 1;
                mediaTrack2 = mediaTrack;
                if (i3 < mediaTrack2.mediaSegments.size()) {
                    List<MediaSegment> subList = mediaTrack2.mediaSegments.subList(0, i3);
                    mediaTrack2.mediaSegments = subList;
                    if (z && mediaSegment != null) {
                        long j11 = mediaSegment.end - mediaSegment.start;
                        MediaSegment mediaSegment3 = (MediaSegment) dgb.d(subList);
                        long j12 = mediaSegment3.start;
                        mediaSegment.start = j12;
                        mediaSegment.end = j12 + j11;
                        mediaTrack2.mediaSegments.remove(mediaSegment3);
                        mediaTrack2.mediaSegments.add(mediaSegment);
                    }
                }
            } else {
                mediaTrack2 = mediaTrack;
            }
            if (i2 > 0 && (list3 = mediaTrack2.mediaTransitions) != null && list3.size() >= mediaTrack2.mediaSegments.size()) {
                mediaTrack2.mediaTransitions = mediaTrack2.mediaTransitions.subList(0, mediaTrack2.mediaSegments.size() - 1);
            }
            MediaSegment mediaSegment4 = mediaTrack2.superpositionHeader;
            if (mediaSegment4 != null) {
                if (TextUtils.isEmpty(mediaSegment4.superpositionType)) {
                    MediaSegment mediaSegment5 = mediaTrack2.superpositionHeader;
                    long j13 = mediaSegment5.start;
                    long j14 = mediaSegment5.end;
                    if (j13 != j14 && j14 != 0) {
                        mediaSegment5.superpositionType = "self";
                    } else {
                        mediaTrack2.superpositionHeader.superpositionType = "without_trans";
                    }
                }
                List<MediaSegment> list5 = mediaTrack2.mediaSegments;
                if (list5 != null && list5.size() > 0) {
                    MediaSegment mediaSegment6 = mediaTrack2.superpositionHeader;
                    mediaSegment6.start = 0L;
                    mediaSegment6.end = (mediaSegment6.end - mediaSegment6.start) + 0;
                    if ("all".equals(mediaSegment6.superpositionType) || mediaTrack2.superpositionHeader.end == 0) {
                        mediaTrack2.superpositionHeader.end = mediaTrack2.mediaSegments.get(0).end;
                    }
                    if ("without_trans".equals(mediaTrack2.superpositionHeader.superpositionType) && (list2 = mediaTrack2.mediaTransitions) != null && list2.size() > 0) {
                        mediaTrack2.superpositionHeader.end = mediaTrack2.mediaTransitions.get(0).start;
                    }
                }
            }
            MediaSegment mediaSegment7 = mediaTrack2.superpositionFooter;
            if (mediaSegment7 != null) {
                if (TextUtils.isEmpty(mediaSegment7.superpositionType)) {
                    MediaSegment mediaSegment8 = mediaTrack2.superpositionFooter;
                    long j15 = mediaSegment8.start;
                    long j16 = mediaSegment8.end;
                    if (j15 != j16 && j16 != 0) {
                        mediaSegment8.superpositionType = "self";
                    } else {
                        mediaTrack2.superpositionFooter.superpositionType = "without_trans";
                    }
                }
                List<MediaSegment> list6 = mediaTrack2.mediaSegments;
                if (list6 != null && list6.size() > 0) {
                    int size = mediaTrack2.mediaSegments.size() - 1;
                    if ("all".equals(mediaTrack2.superpositionFooter.superpositionType)) {
                        mediaTrack2.superpositionFooter.start = mediaTrack2.mediaSegments.get(size).start;
                    } else {
                        MediaSegment mediaSegment9 = mediaTrack2.superpositionFooter;
                        long j17 = mediaTrack2.mediaSegments.get(size).end;
                        MediaSegment mediaSegment10 = mediaTrack2.superpositionFooter;
                        mediaSegment9.start = j17 - (mediaSegment10.end - mediaSegment10.start);
                    }
                    if ("without_trans".equals(mediaTrack2.superpositionFooter.superpositionType) && (list = mediaTrack2.mediaTransitions) != null && list.size() > 0) {
                        MediaSegment mediaSegment11 = mediaTrack2.superpositionFooter;
                        long j18 = mediaSegment11.start;
                        List<MediaTransition> list7 = mediaTrack2.mediaTransitions;
                        mediaSegment11.start = j18 + list7.get(list7.size() - 1).duration;
                    }
                    mediaTrack2.superpositionFooter.end = mediaTrack2.mediaSegments.get(size).end;
                }
            }
        }
    }

    public static boolean D(List<MediaSegment> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (dgb.e(list)) {
                return true;
            }
            if (list != null && list.size() == 1 && list.get(0).start == 0 && list.get(0).end == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean E(MediaTrack mediaTrack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaTrack, str)) == null) {
            if (mediaTrack != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.equals(mediaTrack.trackType, str)) {
                    return true;
                }
                List<MediaSegment> list = mediaTrack.mediaSegments;
                if (list != null) {
                    for (MediaSegment mediaSegment : list) {
                        if (TextUtils.equals(mediaSegment.type, str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static long s(MediaSegment mediaSegment, boolean z) {
        InterceptResult invokeLZ;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65560, null, mediaSegment, z)) == null) {
            if (mediaSegment == null) {
                return 0L;
            }
            if (z) {
                j = mediaSegment.start;
            } else {
                j = mediaSegment.end;
            }
            return ((j / 1000) * 1000) + (((((float) (j % 1000)) * 1.0f) / 30.0f) * 1000.0f);
        }
        return invokeLZ.longValue;
    }

    public static void z(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(65567, null, j, mediaAEffect) == null) && mediaAEffect != null && mediaAEffect.duration != 0) {
            if (mediaAEffect.isSceneEffect()) {
                B(j, mediaAEffect);
            } else if (mediaAEffect.isStartEndEffect()) {
                C(j, mediaAEffect);
            } else if (mediaAEffect.isEqualityEffect()) {
                A(j, mediaAEffect);
            }
        }
    }

    public static void F(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, List<MediaTrack> list, MediaSegment mediaSegment, MediaSegment mediaSegment2, MediaTrack mediaTrack2, List<MediaSegment> list2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{mediaTrack, mediaTrackConfig, list, mediaSegment, mediaSegment2, mediaTrack2, list2}) == null) {
            if (D(list2) && dgb.b(list2) > 0) {
                MediaSegment mediaSegment3 = list2.get(0);
                for (MediaSegment mediaSegment4 : mediaTrack.mediaSegments) {
                    if (!TextUtils.isEmpty(mediaSegment3.lutConfigKey)) {
                        mediaSegment4.lutConfigKey = mediaSegment3.lutConfigKey;
                    }
                    mediaSegment4.shaderConfigKey = mediaSegment3.shaderConfigKey;
                    mediaSegment4.effectConfigKey = mediaSegment3.effectConfigKey;
                }
            } else if (list2.size() > 0) {
                int min = Math.min(mediaTrack.mediaSegments.size(), list2.size());
                for (int i = 0; i < min; i++) {
                    MediaSegment mediaSegment5 = mediaTrack.mediaSegments.get(i);
                    MediaSegment mediaSegment6 = list2.get(i);
                    mediaSegment5.lutConfigKey = mediaSegment6.lutConfigKey;
                    mediaSegment5.shaderConfigKey = mediaSegment6.shaderConfigKey;
                    mediaSegment5.effectConfigKey = mediaSegment6.effectConfigKey;
                }
            }
            if (mediaTrack2 != null) {
                list.remove(mediaTrack2);
                mediaTrack.headerTransitionName = mediaTrack2.headerTransitionName;
                mediaTrack.footerTransitionName = mediaTrack2.footerTransitionName;
                mediaTrack.transitionMode = mediaTrack2.transitionMode;
                mediaTrack.mediaAEffectKeyData = mediaTrack2.mediaAEffectKeyData;
                mediaTrack.glClearColor = mediaTrack2.glClearColor;
            }
            if (mediaSegment != null) {
                mediaTrack.mediaSegments.add(0, mediaSegment.m49clone());
            }
            if (mediaSegment2 != null) {
                mediaTrack.mediaSegments.add(mediaSegment2.m49clone());
            }
            mediaTrack.trackType = "input";
            list.add(0, mediaTrack);
            String str = null;
            if (list2.size() > 0) {
                str = list2.get(0).effectConfigKey;
            }
            if (!D(list2) && list2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (MediaSegment mediaSegment7 : list2) {
                    if ("input".equals(mediaSegment7.type)) {
                        arrayList.add(mediaSegment7);
                    }
                }
                int min2 = Math.min(list2.size(), arrayList.size());
                for (int i2 = 0; i2 < min2; i2++) {
                    ((MediaSegment) arrayList.get(i2)).effectConfigKey = list2.get(i2).effectConfigKey;
                }
            }
            c(mediaTrack, mediaTrackConfig, str, D(list2));
            e(mediaTrackConfig, mediaSegment, mediaSegment2);
            g(mediaTrack, mediaTrackConfig);
            i(mediaTrack, mediaTrackConfig, mediaTrack2);
            if (mediaTrackConfig != null && mediaTrack2 != null && !D(list2) && TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE)) {
                h(mediaTrack, mediaTrack2.mediaSegments, mediaTrackConfig);
            }
            if (mediaTrackConfig == null) {
                j = 0;
            } else {
                j = mediaTrackConfig.maxVideoDuration;
            }
            b(mediaTrack, j);
        }
    }

    public static void a(ShaderConfig shaderConfig, og0 og0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, shaderConfig, og0Var) == null) {
            try {
                if (shaderConfig.vParams != null && shaderConfig.vParams.size() > 0) {
                    og0Var.l();
                    for (ShaderParams shaderParams : shaderConfig.vParams) {
                        og0Var.e(GLES20.glGetUniformLocation(og0Var.j(), shaderParams.name), shaderParams.name, shaderParams);
                    }
                }
                if (shaderConfig.fParams != null && shaderConfig.fParams.size() > 0) {
                    og0Var.l();
                    for (ShaderParams shaderParams2 : shaderConfig.fParams) {
                        og0Var.e(GLES20.glGetUniformLocation(og0Var.j(), shaderParams2.name), shaderParams2.name, shaderParams2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void g(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig) {
        Map<String, MediaAEffect> map;
        Map<String, MediaAEffect> map2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65548, null, mediaTrack, mediaTrackConfig) != null) || mediaTrackConfig == null) {
            return;
        }
        MediaSegment mediaSegment = mediaTrack.superpositionHeader;
        if (mediaSegment != null && !TextUtils.isEmpty(mediaSegment.effectConfigKey) && (map2 = mediaTrackConfig.effectConfigMap) != null && map2.containsKey(mediaTrack.superpositionHeader.effectConfigKey)) {
            MediaSegment mediaSegment2 = mediaTrack.superpositionHeader;
            mediaSegment2.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m47clone();
        }
        MediaSegment mediaSegment3 = mediaTrack.superpositionFooter;
        if (mediaSegment3 != null && !TextUtils.isEmpty(mediaSegment3.effectConfigKey) && (map = mediaTrackConfig.effectConfigMap) != null && map.containsKey(mediaTrack.superpositionFooter.effectConfigKey)) {
            MediaSegment mediaSegment4 = mediaTrack.superpositionFooter;
            mediaSegment4.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment4.effectConfigKey).m47clone();
        }
    }

    public static long w(Map<String, ShaderConfig> map, MediaSegment mediaSegment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, map, mediaSegment)) == null) {
            if (map == null) {
                return 0L;
            }
            if (map.get(mediaSegment.shaderConfigKey) != null && map.get(mediaSegment.shaderConfigKey).textures != null && map.get(mediaSegment.shaderConfigKey).textures.size() > 0 && map.get(mediaSegment.shaderConfigKey).textures.get(0).type.equals(MediaTextureData.TEXTURE_VIDEO)) {
                try {
                    String str = map.get(mediaSegment.shaderConfigKey).textures.get(0).path;
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    long longValue = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue();
                    mediaMetadataRetriever.release();
                    return longValue;
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return 2000L;
        }
        return invokeLL.longValue;
    }

    public static void y(Context context, Map<String, ShaderConfig> map) {
        Bitmap g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65566, null, context, map) == null) && map != null) {
            for (Map.Entry<String, ShaderConfig> entry : map.entrySet()) {
                ShaderConfig value = entry.getValue();
                List<MediaTextureData> list = value.textures;
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (MediaTextureData mediaTextureData : value.textures) {
                        if (mediaTextureData.textureId == 0 && TextUtils.equals(MediaTextureData.TEXTURE_LUT, mediaTextureData.type) && (g = ah0.g(context, mediaTextureData.path)) != null) {
                            int g2 = ug0.g(g, -1, true);
                            mediaTextureData.textureId = g2;
                            arrayList.add(Integer.valueOf(g2));
                        }
                    }
                }
            }
        }
    }

    public static void c(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, String str, boolean z) {
        List<MediaSegment> list;
        Map<String, MediaAEffect> map;
        int size;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{mediaTrack, mediaTrackConfig, str, Boolean.valueOf(z)}) == null) {
            String str6 = "";
            if (mediaTrackConfig != null && (map = mediaTrackConfig.effectConfigMap) != null && (size = map.size()) != 0) {
                if (d(mediaTrack, mediaTrackConfig, z)) {
                    return;
                }
                if (z && !TextUtils.isEmpty(str)) {
                    int size2 = mediaTrack.mediaSegments.size();
                    ArrayList arrayList = new ArrayList();
                    if (!str.contains("random") && !str.contains(IMConstants.SERVICE_TYPE_ORDER)) {
                        Boolean valueOf = Boolean.valueOf(mediaTrackConfig.effectConfigMap.containsKey(str));
                        for (int i2 = 0; i2 < size2; i2++) {
                            if (!z && i2 != 0) {
                                valueOf = Boolean.FALSE;
                            }
                            if (valueOf.booleanValue()) {
                                str5 = str;
                            } else {
                                str5 = null;
                            }
                            arrayList.add(str5);
                        }
                        str2 = "";
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<Map.Entry<String, MediaAEffect>> it = mediaTrackConfig.effectConfigMap.entrySet().iterator();
                        String str7 = null;
                        String str8 = null;
                        while (it.hasNext()) {
                            Map.Entry<String, MediaAEffect> next = it.next();
                            String key = next.getKey();
                            MediaAEffect value = next.getValue();
                            boolean equals = "header".equals(key);
                            Iterator<Map.Entry<String, MediaAEffect>> it2 = it;
                            boolean equals2 = "footer".equals(key);
                            String str9 = str6;
                            if (TextUtils.isEmpty(value.shaderConfigKey)) {
                                value.shaderConfigKey = ah0.b;
                            }
                            if (equals) {
                                str7 = key;
                            }
                            if (equals2) {
                                str8 = key;
                            }
                            if (!equals && !equals2 && (!str.contains("random") || size2 >= size || !value.isRandomModeOnce())) {
                                arrayList2.add(key);
                            }
                            it = it2;
                            str6 = str9;
                        }
                        str2 = str6;
                        int i3 = 1;
                        if (str7 == null) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (str8 == null) {
                            i3 = 0;
                        }
                        int i4 = size2 - (i + i3);
                        if (str7 != null && arrayList.size() < size2) {
                            arrayList.add(str7);
                        }
                        if (i4 > 0) {
                            arrayList.addAll(n(arrayList2, i4, new b(mediaTrackConfig), str.contains("random")));
                        }
                        if (str8 != null && arrayList.size() < size2) {
                            arrayList.add(str8);
                        }
                    }
                    if (size2 == arrayList.size()) {
                        int i5 = 0;
                        while (i5 < size2) {
                            MediaSegment mediaSegment = (MediaSegment) p(mediaTrack.mediaSegments, i5);
                            if (mediaSegment != null) {
                                if (!TextUtils.isEmpty(mediaSegment.effectConfigKey) && !mediaSegment.effectConfigKey.contains("random") && !mediaSegment.effectConfigKey.contains(IMConstants.SERVICE_TYPE_ORDER)) {
                                    str3 = mediaSegment.effectConfigKey;
                                } else if (p(arrayList, i5) != null && !TextUtils.isEmpty((CharSequence) p(arrayList, i5))) {
                                    str3 = (String) p(arrayList, i5);
                                } else {
                                    str3 = null;
                                }
                                if (!TextUtils.isEmpty(str3) && mediaTrackConfig.effectConfigMap.get(str3) != null) {
                                    MediaAEffect m47clone = mediaTrackConfig.effectConfigMap.get(str3).m47clone();
                                    mediaSegment.mediaAEffect = m47clone;
                                    if (TextUtils.isEmpty(m47clone.shaderConfigKey)) {
                                        mediaSegment.mediaAEffect.shaderConfigKey = ah0.b;
                                    }
                                    mediaSegment.effectConfigKey = str3;
                                    if (!TextUtils.equals(str, "random_with_video") && !TextUtils.equals(str, "order_with_video") && TextUtils.equals(mediaSegment.type, "video") && mediaSegment.mediaAEffect.isSceneEffect()) {
                                        mediaSegment.mediaAEffect = null;
                                        str4 = str2;
                                        mediaSegment.effectConfigKey = str4;
                                        i5++;
                                        str2 = str4;
                                    }
                                }
                            }
                            str4 = str2;
                            i5++;
                            str2 = str4;
                        }
                    }
                } else if (mediaTrack.mediaSegments != null) {
                    for (int i6 = 0; i6 < mediaTrack.mediaSegments.size(); i6++) {
                        MediaSegment mediaSegment2 = mediaTrack.mediaSegments.get(i6);
                        if (mediaTrackConfig.effectConfigMap.containsKey(mediaSegment2.effectConfigKey)) {
                            MediaAEffect m47clone2 = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m47clone();
                            mediaSegment2.mediaAEffect = m47clone2;
                            if (TextUtils.isEmpty(m47clone2.shaderConfigKey)) {
                                mediaSegment2.mediaAEffect.shaderConfigKey = ah0.b;
                            }
                        }
                    }
                }
            } else if (mediaTrack != null && (list = mediaTrack.mediaSegments) != null) {
                for (MediaSegment mediaSegment3 : list) {
                    if (mediaSegment3 != null) {
                        mediaSegment3.mediaAEffect = null;
                        mediaSegment3.effectConfigKey = "";
                    }
                }
            }
        }
    }

    public static String o(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65556, null, context, str, str2, str3)) == null) {
            if (TextUtils.equals("default", str2)) {
                return "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}";
            }
            if (TextUtils.equals("default_oes", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}";
            }
            if (TextUtils.equals("defaultLut", str2)) {
                return "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float non_level;\n\n//使用LUT获取新的颜色：参考https://www.jianshu.com/p/96a61110a5ae\nvec4 applyFilterOnColor(vec4 inputColor, sampler2D inputLut, float saturation)\n{\n    // 根据B通道获取小正方形（64x64)格子的位置\n    highp float blueColor = inputColor.b * 63.0;\n    //向下取值：获取第一个格子的坐标\n    highp vec2 quad1;\n    //确定所在行\n    quad1.y = floor(floor(blueColor) / 8.0);\n    //确定所在列\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n\n    //向上取值：获取第二个格子的坐标\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n\n    // 根据小正方形格子和RG通道，获取纹理坐标；LUT图片的大小为512*512，每个格子的大小为64*64\n    //quad1是正方形的坐标，每个正方形占纹理大小的1/8，即是0.125，所以quad1.x * 0.125是算出正方形的左下角x坐标，\n    //每个小格子在整个图片的纹理宽度为 0.125，由于纹理坐标是从0开始的(即0 - 63)\n\n    //**确定第一个格子的纹理坐标**\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.g);\n\n    //确定第二个格子的纹理坐标\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.g);\n\n    //根据纹理坐标获取两个颜色\n    lowp vec4 newColor1 = texture2D(inputLut, texPos1);\n    lowp vec4 newColor2 = texture2D(inputLut, texPos2);\n\n    //两个颜色进行混合，返回其小数部分\n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    vec4 tempColor = vec4(newColor.rgb, inputColor.w);\n    vec4 outputColor = mix(inputColor, tempColor, saturation);\n    return outputColor;\n}\n\nvoid main()\n{\n    vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 outColor = applyFilterOnColor(inputColor, inputImageTexture2, 1.0 - non_level);\n    gl_FragColor = mix(inputColor, vec4(outColor.rgb, inputColor.w), inputColor.a);\n}";
            }
            if (TextUtils.equals("defaultSticker", str2)) {
                return "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main()\n{\n    vec4 inputImage = texture2D(inputImageTexture, textureCoordinate);\n    vec4 inputImage2 = texture2D(inputImageTexture2, textureCoordinate2);\n    gl_FragColor = mix(inputImage, inputImage2, inputImage2.a);\n}";
            }
            if (TextUtils.equals("defaultStickerAlpha", str2)) {
                return "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main()\n{\n    vec4 inputImage = texture2D(inputImageTexture, textureCoordinate);\n    vec4 inputImage2 = texture2D(inputImageTexture2, textureCoordinate2);\n    gl_FragColor = min(inputImage2 * 1.0 + inputImage * (1.0 - inputImage2.a), vec4(1.0));\n}";
            }
            if (TextUtils.equals("defaultAnimator", str2)) {
                return "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}";
            }
            if (TextUtils.equals("defaultGaussianBlur", str2)) {
                return "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n// 高斯算子左右偏移值，当偏移值为2时，高斯算子为5 x 5\nconst lowp int SHIFT_SIZE = 9;\nvarying highp vec2 blurCoordinates[SHIFT_SIZE];\n//varying highp vec4 blurShiftCoordinates[SHIFT_SIZE];\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\n//varying highp vec2 imageSizeOffset;\nvoid main()\n{\n    // 计算当前坐标的颜色值\n    vec4 currentColor = texture2D(inputImageTexture, textureCoordinate);\n    mediump vec3 sum = currentColor.rgb;\n    // 计算偏移坐标的颜色值总和\n    for (int i = 0; i < SHIFT_SIZE; i++) {\n        sum += texture2D(inputImageTexture, blurShiftCoordinates[i].xy).rgb;\n        sum += texture2D(inputImageTexture, blurShiftCoordinates[i].zw).rgb;\n    }\n    // 求出平均值\n    gl_FragColor = vec4(sum * 1.0 / float(2 * SHIFT_SIZE + 1), currentColor.a);\n\n\n\n//    vec2 sOff = imageSizeOffset;\n//    sum += texture2D(inputImageTexture, textureCoordinate + sOff * vec2(0.5, 0.5)).rgb * 0.25;\n//    sum += texture2D(inputImageTexture, textureCoordinate + sOff * vec2(-0.5, 0.5)).rgb * 0.25;\n//    sum += texture2D(inputImageTexture, textureCoordinate + sOff * vec2(0.5, -0.5)).rgb * 0.25;\n//    sum += texture2D(inputImageTexture, textureCoordinate + sOff * vec2(-0.5, -0.5)).rgb * 0.25;\n\n //   gl_FragColor = vec4(sum, fragColor.a);\n}\n";
            }
            if (TextUtils.equals("defaultBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    // gl_FragColor = mix(baseColor, blendColor, blendColor.a);\n    gl_FragColor = min(blendColor + baseColor * (1.0 - blendColor.a), vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("defaultVerticalBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2(textureCoordinate2.x, (1.0 - textureCoordinate2.y) / 2.0);\n    vec2 coloursCoor = vec2(textureCoordinate2.x, (1.0 - textureCoordinate2.y) / 2.0 + 0.5);\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n    \n    // gl_FragColor = mix(baseColor, blendColor, blendColor.a);\n    gl_FragColor = min(blendColor + baseColor * (1.0 - blendColor.a), vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("addedBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor + blendColor, vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("overlayBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = baseColor.r < 0.5 ? (2.0 * baseColor.r * blendColor.r)                : (1.0 - 2.0 * (1.0 - baseColor.r) * (1.0 - blendColor.r));\n    float g = baseColor.g < 0.5 ? (2.0 * baseColor.g * blendColor.g)                : (1.0 - 2.0 * (1.0 - baseColor.g) * (1.0 - blendColor.g));\n    float b = baseColor.b < 0.5 ? (2.0 * baseColor.b * blendColor.b)                : (1.0 - 2.0 * (1.0 - baseColor.b) * (1.0 - blendColor.b));\n    float a = baseColor.a < 0.5 ? (2.0 * baseColor.a * blendColor.a)                : (1.0 - 2.0 * (1.0 - baseColor.a) * (1.0 - blendColor.a));\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("screenBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = vec4(1.0) - ((vec4(1.0) - baseColor) * (vec4(1.0) - blendColor));\n}\n";
            }
            if (TextUtils.equals("multiplyBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor * blendColor;\n}\n";
            }
            if (TextUtils.equals("colorBurnBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = vec4(1.0) - (vec4(1.0) - baseColor) / blendColor;\n}\n";
            }
            if (TextUtils.equals("averageBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = (baseColor + blendColor) / 2.0;\n}\n";
            }
            if (TextUtils.equals("darkenBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor, blendColor);\n}\n";
            }
            if (TextUtils.equals("linearBurnBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor + blendColor - vec4(1.0);\n}\n";
            }
            if (TextUtils.equals("differenceBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = abs(baseColor - blendColor);\n}\n";
            }
            if (TextUtils.equals("lightenBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = max(baseColor, blendColor);\n}\n";
            }
            if (TextUtils.equals("colorDodgeBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor / (vec4(1.0) - blendColor);\n}\n";
            }
            if (TextUtils.equals("linearDodgeBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor + blendColor, vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("softLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = 2.0 * baseColor * blendColor + baseColor * baseColor\n                    - 2.0 * baseColor * baseColor * blendColor;\n}\n";
            }
            if (TextUtils.equals("hardLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r < 0.5 ? (2.0 * baseColor.r * blendColor.r)\n                : (1.0 - 2.0 * (1.0 - baseColor.r) * (1.0 - blendColor.r));\n    float g = blendColor.g < 0.5 ? (2.0 * baseColor.g * blendColor.g)\n                : (1.0 - 2.0 * (1.0 - baseColor.g) * (1.0 - blendColor.g));\n    float b = blendColor.b < 0.5 ? (2.0 * baseColor.b * blendColor.b)\n                : (1.0 - 2.0 * (1.0 - baseColor.b) * (1.0 - blendColor.b));\n    float a = blendColor.a < 0.5 ? (2.0 * baseColor.a * blendColor.a)\n                : (1.0 - 2.0 * (1.0 - baseColor.a) * (1.0 - blendColor.a));\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("linearLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor + 2.0 * blendColor - vec4(1.0);\n}\n";
            }
            if (TextUtils.equals("pinLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor, 2.0 * blendColor - vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("hardMixBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r < 1.0 - baseColor.r ? 0.0 : 1.0;\n    float g = blendColor.g < 1.0 - baseColor.g ? 0.0 : 1.0;\n    float b = blendColor.b < 1.0 - baseColor.b ? 0.0 : 1.0;\n    float a = blendColor.a < 1.0 - baseColor.a ? 0.0 : 1.0;\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("vividLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r <= 0.5 ? 1.0 - (1.0 - baseColor.r) / 2.0 * blendColor.r\n                : baseColor.r / (2.0 * (1.0 - blendColor.r));\n    float g = blendColor.g <= 0.5 ? 1.0 - (1.0 - baseColor.g) / 2.0 * blendColor.g\n                : baseColor.g / (2.0 * (1.0 - blendColor.g));\n    float b = blendColor.b <= 0.5 ? 1.0 - (1.0 - baseColor.b) / 2.0 * blendColor.b\n                : baseColor.b / (2.0 * (1.0 - blendColor.b));\n    float a = blendColor.a <= 0.5 ? 1.0 - (1.0 - baseColor.a) / 2.0 * blendColor.a\n                : baseColor.a / (2.0 * (1.0 - blendColor.a));\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("exclusionBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = blendColor + baseColor - 2.0 * blendColor * baseColor;\n}\n";
            }
            if (TextUtils.equals("reflectBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r > 0.99 ? blendColor.r\n                : min(baseColor.r * baseColor.r / (1.0 - blendColor.r), 1.0);\n    float g = blendColor.g > 0.99 ? blendColor.g\n                : min(baseColor.g * baseColor.g / (1.0 - blendColor.g), 1.0);\n    float b = blendColor.b > 0.99 ? blendColor.b\n                : min(baseColor.b * baseColor.b / (1.0 - blendColor.b), 1.0);\n    float a = blendColor.a > 0.99 ? blendColor.a\n                : min(baseColor.a * baseColor.a / (1.0 - blendColor.a), 1.0);\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("glowBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = baseColor.r > 0.99 ? baseColor.r\n                : min(blendColor.r * blendColor.r / (1.0 - baseColor.r), 1.0);\n    float g = baseColor.g > 0.99 ? baseColor.g\n                : min(blendColor.g * blendColor.g / (1.0 - baseColor.g), 1.0);\n    float b = baseColor.b > 0.99 ? baseColor.b\n                : min(blendColor.b * blendColor.b / (1.0 - baseColor.b), 1.0);\n    float a = baseColor.a > 0.99 ? baseColor.a\n                : min(blendColor.a * blendColor.a / (1.0 - baseColor.a), 1.0);\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("negationBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = vec4(1.0) - abs(vec4(1.0) - baseColor - blendColor);\n}\n";
            }
            if (TextUtils.equals("phoenixBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor, blendColor) - max(baseColor, blendColor) + vec4(1.0);\n}\n";
            }
            if (TextUtils.equals("snowColorBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\nvec3 rgb2hsl(in vec3 color){\n    vec3 hsl = vec3(0.0);\n    float fmin = min(min(color.r, color.g), color.b);\n    float fmax = max(max(color.r, color.g), color.b);\n    float delta = fmax - fmin;\n\n    hsl.z = (fmax + fmin) / 2.0;\n\n    if (delta == 0.0) {\n        hsl.x = 0.0;\n        hsl.y = 0.0;\n    } else {\n        if (hsl.z < 0.5)\n        hsl.y = delta / (fmax + fmin);\n        else\n        hsl.y = delta / (2.0 - fmax - fmin);\n\n        float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n        float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n        float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n\n        if (color.r == fmax)\n        hsl.x = deltaB - deltaG;\n        else if (color.g == fmax)\n        hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n        else if (color.b == fmax)\n        hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n\n        if (hsl.x < 0.0)\n        hsl.x += 1.0;\n        else if (hsl.x > 1.0)\n        hsl.x -= 1.0;\n    }\n    return hsl;\n}vec3 hsl2rgb( in vec3 c )\n{\n    vec3 rgb = clamp( abs(mod(c.x*6.0+vec3(0.0,4.0,2.0),6.0)-3.0)-1.0, 0.0, 1.0 );\n    return c.z + c.y * (rgb-0.5)*(1.0-abs(2.0*c.z-1.0));\n}void main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);    vec3 baseHsl = rgb2hsl(baseColor.rgb);\n    vec3 blendHsl = rgb2hsl(blendColor.rgb);\n    gl_FragColor = vec4(hsl2rgb(vec3(baseHsl.r, baseHsl.g, blendHsl.b)).rgb, 1.0);\n}\n";
            }
            if (TextUtils.equals("snowHueBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\nvec3 rgb2hsl(in vec3 color){\n    vec3 hsl = vec3(0.0);\n    float fmin = min(min(color.r, color.g), color.b);\n    float fmax = max(max(color.r, color.g), color.b);\n    float delta = fmax - fmin;\n\n    hsl.z = (fmax + fmin) / 2.0;\n\n    if (delta == 0.0) {\n        hsl.x = 0.0;\n        hsl.y = 0.0;\n    } else {\n        if (hsl.z < 0.5)\n        hsl.y = delta / (fmax + fmin);\n        else\n        hsl.y = delta / (2.0 - fmax - fmin);\n\n        float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n        float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n        float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n\n        if (color.r == fmax)\n        hsl.x = deltaB - deltaG;\n        else if (color.g == fmax)\n        hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n        else if (color.b == fmax)\n        hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n\n        if (hsl.x < 0.0)\n        hsl.x += 1.0;\n        else if (hsl.x > 1.0)\n        hsl.x -= 1.0;\n    }\n    return hsl;\n}vec3 hsl2rgb( in vec3 c )\n{\n    vec3 rgb = clamp( abs(mod(c.x*6.0+vec3(0.0,4.0,2.0),6.0)-3.0)-1.0, 0.0, 1.0 );\n    return c.z + c.y * (rgb-0.5)*(1.0-abs(2.0*c.z-1.0));\n}void main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);    vec3 baseHsl = rgb2hsl(baseColor.rgb);\n    vec3 blendHsl = rgb2hsl(blendColor.rgb);\n    gl_FragColor = vec4(hsl2rgb(vec3(baseHsl.r, blendHsl.g, blendHsl.b)).rgb, 1.0);\n}\n";
            }
            if (TextUtils.equals("subtractBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = max(vec4(baseColor.rgb - blendColor.rgb, 1.0), vec4(0.0));\n}\n";
            }
            if (TextUtils.equals("divideBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor / blendColor;\n}\n";
            }
            if (!TextUtils.equals("f_calculate_blend_video_rose", str2) && !TextUtils.equals("f_calculate_blend_video_rose.glsl", str2)) {
                if (!TextUtils.equals("shader_header", str3) && !TextUtils.equals("shader_footer", str3) && (TextUtils.equals("f_calculate_blend_video", str2) || TextUtils.equals("f_calculate_blend_video.glsl", str2))) {
                    return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    // gl_FragColor = mix(baseColor, blendColor, blendColor.a);\n    gl_FragColor = min(blendColor + baseColor * (1.0 - blendColor.a), vec4(1.0));\n}\n";
                }
                if (TextUtils.isEmpty(str)) {
                    return og0.n(context, r(context, str2));
                }
                return og0.m(str + File.separator + str2);
            }
            return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nconst vec4 black = vec4(0.0, 0.0, 0.0, 1.0);\nconst vec2 boundMin = vec2(0.0, 0.0);\nconst vec2 boundMax = vec2(1.0, 1.0);\n\nbool inBounds (vec2 p) {\n  return all(lessThan(boundMin, p)) && all(lessThan(p, boundMax));\n}\n\nvoid main()\n{\n    vec2 coordinate = textureCoordinate;\n    coordinate.x = (coordinate.x);\n    coordinate.y = (coordinate.y - 0.0659);\n    vec4 inputImage;\n    if (inBounds(coordinate)) {\n        inputImage = texture2D(inputImageTexture, coordinate);\n    } else {\n        inputImage = black;\n    }\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n    gl_FragColor = mix(inputImage, texture2D(inputImageTexture2, coloursCoor),    texture2D(inputImageTexture2, blackCoor).r);\n}\n";
        }
        return (String) invokeLLLL.objValue;
    }

    public static boolean d(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, boolean z) {
        InterceptResult invokeLLZ;
        int i;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, mediaTrack, mediaTrackConfig, z)) == null) {
            int i3 = 0;
            if (mediaTrack != null && !dgb.e(mediaTrack.mediaAEffectKeyData) && mediaTrackConfig != null && mediaTrackConfig.effectConfigMap != null) {
                MediaAEffectKeyData mediaAEffectKeyData = null;
                Iterator<MediaAEffectKeyData> it = mediaTrack.mediaAEffectKeyData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MediaAEffectKeyData next = it.next();
                    if (TextUtils.equals(next.type, "input")) {
                        mediaAEffectKeyData = next;
                        break;
                    }
                }
                if (mediaAEffectKeyData != null && !dgb.e(mediaAEffectKeyData.effectConfigKeys)) {
                    if (z) {
                        k(mediaAEffectKeyData, mediaTrackConfig);
                        int size = mediaTrack.mediaSegments.size();
                        if (mediaAEffectKeyData.headerEffectKey == null) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (mediaAEffectKeyData.footerEffectKey == null) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        int i4 = size - (i + i2);
                        ArrayList arrayList = new ArrayList();
                        if (i4 > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            if (!dgb.e(mediaAEffectKeyData.calculateEffectKeys)) {
                                for (String str2 : mediaAEffectKeyData.calculateEffectKeys) {
                                    MediaAEffect mediaAEffect = mediaTrackConfig.effectConfigMap.get(str2);
                                    if (mediaAEffect != null) {
                                        mediaAEffect.name = str2;
                                        arrayList2.add(mediaAEffect);
                                    }
                                }
                            }
                            arrayList.addAll(n(arrayList2, i4, new c(), mediaAEffectKeyData.keyMode.contains("random")));
                        }
                        while (i3 < size) {
                            MediaSegment mediaSegment = (MediaSegment) p(mediaTrack.mediaSegments, i3);
                            if (mediaSegment != null) {
                                String str3 = "";
                                if (i3 == 0 && !TextUtils.isEmpty(mediaAEffectKeyData.headerEffectKey)) {
                                    str3 = mediaAEffectKeyData.headerEffectKey;
                                } else if (i3 == size - 1 && !TextUtils.isEmpty(mediaAEffectKeyData.footerEffectKey)) {
                                    str3 = mediaAEffectKeyData.footerEffectKey;
                                } else {
                                    MediaAEffect mediaAEffect2 = (MediaAEffect) dgb.c(arrayList, TextUtils.isEmpty(mediaAEffectKeyData.headerEffectKey) ? i3 : i3 - 1);
                                    if (mediaAEffect2 == null) {
                                        str = "";
                                    } else {
                                        str = mediaAEffect2.name;
                                    }
                                    if (TextUtils.equals(mediaAEffectKeyData.keyMode, "random_with_video") || TextUtils.equals(mediaAEffectKeyData.keyMode, "order_with_video") || !TextUtils.equals(mediaSegment.type, "video") || !mediaSegment.mediaAEffect.isSceneEffect()) {
                                        str3 = str;
                                    }
                                }
                                MediaAEffect mediaAEffect3 = mediaTrackConfig.effectConfigMap.get(str3);
                                if (mediaAEffect3 != null) {
                                    mediaAEffect3.name = str3;
                                    MediaAEffect m47clone = mediaAEffect3.m47clone();
                                    mediaSegment.mediaAEffect = m47clone;
                                    if (TextUtils.isEmpty(m47clone.shaderConfigKey)) {
                                        mediaSegment.mediaAEffect.shaderConfigKey = ah0.b;
                                    }
                                }
                                mediaSegment.effectConfigKey = str3;
                            }
                            i3++;
                        }
                    } else if (mediaTrack.mediaSegments != null) {
                        while (i3 < mediaTrack.mediaSegments.size()) {
                            MediaSegment mediaSegment2 = mediaTrack.mediaSegments.get(i3);
                            if (mediaTrackConfig.effectConfigMap.containsKey(mediaSegment2.effectConfigKey)) {
                                MediaAEffect m47clone2 = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m47clone();
                                mediaSegment2.mediaAEffect = m47clone2;
                                if (TextUtils.isEmpty(m47clone2.shaderConfigKey)) {
                                    mediaSegment2.mediaAEffect.shaderConfigKey = ah0.b;
                                }
                            }
                            i3++;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static void i(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, MediaTrack mediaTrack2) {
        String str;
        String str2;
        int i;
        int i2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, mediaTrack, mediaTrackConfig, mediaTrack2) == null) {
            if (mediaTrackConfig == null) {
                List<MediaTransition> list = mediaTrack.mediaTransitions;
                if (list != null) {
                    list.clear();
                }
            } else if (mediaTrack.mediaSegments != null) {
                mediaTrack.mediaTransitions = new ArrayList();
                List<MediaTransition> list2 = mediaTrackConfig.transitionConfigs;
                int i3 = 0;
                boolean z3 = true;
                if (list2 != null && list2.size() > 0) {
                    MediaTransition mediaTransition = null;
                    if (mediaTrack2 != null) {
                        str = mediaTrack2.headerTransitionName;
                    } else {
                        str = null;
                    }
                    if (mediaTrack2 != null) {
                        str2 = mediaTrack2.footerTransitionName;
                    } else {
                        str2 = null;
                    }
                    ArrayList arrayList = new ArrayList();
                    MediaTransition mediaTransition2 = null;
                    for (MediaTransition mediaTransition3 : mediaTrackConfig.transitionConfigs) {
                        if (str != null && str.equals(mediaTransition3.name)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (str2 != null && str2.equals(mediaTransition3.name)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z) {
                            mediaTransition = mediaTransition3;
                        }
                        if (z2) {
                            mediaTransition2 = mediaTransition3;
                        }
                        if (!z && !z2) {
                            arrayList.add(mediaTransition3);
                        }
                    }
                    int size = mediaTrack.mediaSegments.size();
                    if (mediaTransition == null) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (mediaTransition2 == null) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    int i4 = size - 1;
                    int i5 = i4 - (i + i2);
                    ArrayList arrayList2 = new ArrayList();
                    if (mediaTransition != null && arrayList2.size() < i4) {
                        arrayList2.add((MediaTransition) mediaTransition.clone());
                    }
                    if (i5 > 0) {
                        arrayList2.addAll(n(arrayList, i5, new a(mediaTrack2), (mediaTrack2 == null || TextUtils.isEmpty(mediaTrack2.transitionMode) || !mediaTrack2.transitionMode.contains("random")) ? false : false));
                    }
                    if (mediaTransition2 != null && arrayList2.size() < i4) {
                        arrayList2.add((MediaTransition) mediaTransition2.clone());
                    }
                    mediaTrack.mediaTransitions.addAll(arrayList2);
                    while (i3 < i4) {
                        if (mediaTrack.mediaSegments.get(i3) != null && mediaTrack.mediaSegments.get(i3).mediaAEffect != null && mediaTrack.mediaSegments.get(i3).mediaAEffect.isSceneEffect() && !TextUtils.isEmpty(mediaTrack.mediaSegments.get(i3).mediaAEffect.sceneTransitionName)) {
                            mediaTrack.mediaTransitions.set(i3, u(mediaTrackConfig.transitionConfigs, mediaTrack.mediaSegments.get(i3).mediaAEffect.sceneTransitionName));
                        }
                        i3++;
                    }
                    return;
                }
                while (i3 < mediaTrack.mediaSegments.size() - 1) {
                    mediaTrack.mediaTransitions.add(new MediaTransition());
                    i3++;
                }
            }
        }
    }

    public static void e(MediaTrackConfig mediaTrackConfig, MediaSegment mediaSegment, MediaSegment mediaSegment2) {
        Map<String, MediaAEffect> map;
        Map<String, MediaAEffect> map2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65546, null, mediaTrackConfig, mediaSegment, mediaSegment2) != null) || mediaTrackConfig == null) {
            return;
        }
        if (mediaSegment != null) {
            if (!TextUtils.isEmpty(mediaSegment.effectConfigKey) && (map2 = mediaTrackConfig.effectConfigMap) != null && map2.containsKey(mediaSegment.effectConfigKey)) {
                mediaSegment.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment.effectConfigKey).m47clone();
            } else {
                mediaSegment.mediaAEffect = null;
            }
        }
        if (mediaSegment2 != null) {
            if (!TextUtils.isEmpty(mediaSegment2.effectConfigKey) && (map = mediaTrackConfig.effectConfigMap) != null && map.containsKey(mediaSegment2.effectConfigKey)) {
                mediaSegment2.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m47clone();
            } else {
                mediaSegment2.mediaAEffect = null;
            }
        }
    }

    public static void f(MediaTrack mediaTrack, Map<String, ShaderConfig> map, MediaTrack mediaTrack2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65547, null, mediaTrack, map, mediaTrack2) != null) || mediaTrack.mediaSegments.size() < ah0.j) {
            return;
        }
        MediaSegment mediaSegment = mediaTrack2.superpositionHeader;
        if (mediaSegment != null) {
            mediaTrack.superpositionHeader = mediaSegment;
            mediaSegment.start = 0L;
            long j = mediaSegment.end;
            if (j == 0) {
                j = w(map, mediaSegment);
            }
            mediaSegment.end = j;
        }
        MediaSegment mediaSegment2 = mediaTrack2.superpositionFooter;
        if (mediaSegment2 != null) {
            mediaTrack.superpositionFooter = mediaSegment2;
            mediaSegment2.start = mediaTrack2.superpositionFooter.start;
            long j2 = mediaSegment2.end;
            if (j2 == 0) {
                j2 = w(map, mediaSegment2);
            }
            mediaSegment2.end = j2;
        }
    }

    public static String v(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, context, str, str2)) == null) {
            if (TextUtils.equals("default", str2)) {
                return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}";
            }
            if (TextUtils.equals("defaultGaussianBlur", str2)) {
                return "precision highp float;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\n\n// 高斯算子左右偏移值，当偏移值为2时，高斯算子为5 x 5\nconst int SHIFT_SIZE = 9;\n\nuniform float wRatio;\nuniform float hRatio;\nuniform float imageWidth;\nuniform float imageHeight;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[SHIFT_SIZE];\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\n//varying vec4 blurShiftCoordinates[SHIFT_SIZE];\n\n//varying vec2 imageSizeOffset;\n\nvoid main()\n{\n\tgl_Position = uMVPMatrix * position;\n\ttextureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n\t// 偏移步距\n\tvec2 singleStepOffset = vec2(wRatio / imageWidth, hRatio / imageHeight);\n\n\tint multiplier = 0;\n\tvec2 blurStep;\n\t// 记录偏移坐标\n\tfor (int i = 0; i < SHIFT_SIZE; i++) {\n\t\tmultiplier = (i - ((SHIFT_SIZE - 1) / 2));\n\t\tblurStep = float(multiplier) * singleStepOffset;\n\t//\t\t\tblurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n\t//\tblurCoordinates[i] = (uTexMatrix * inputTextureCoordinate).xy + blurStep;\n\n\nblurShiftCoordinates[i] = vec4(textureCoordinate.xy - float(i+1) * singleStepOffset,\n                                       textureCoordinate.xy + float(i+1) * singleStepOffset);\n\n\n\n\n//\t\tblurShiftCoordinates[i] = vec4(textureCoordinate.xy - float(i + 1) * singleStepOffset,\n//\t\ttextureCoordinate.xy + float(i + 1) * singleStepOffset);\n\t}\n//\timageSizeOffset = singleStepOffset;\n}\n";
            }
            if (TextUtils.isEmpty(str)) {
                return og0.n(context, r(context, str2));
            }
            return og0.m(str + File.separator + str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void h(MediaTrack mediaTrack, List<MediaSegment> list, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65549, null, mediaTrack, list, mediaTrackConfig) == null) && mediaTrack != null && mediaTrack.mediaSegments != null && list != null && mediaTrackConfig != null) {
            boolean z = false;
            if (TextUtils.equals("music", mediaTrackConfig.templateType)) {
                int size = list.size();
                int i = 0;
                while (i < size) {
                    MediaSegment mediaSegment = list.get(i);
                    mediaSegment.start = s(mediaSegment, true);
                    mediaSegment.end = s(mediaSegment, z);
                    long j = mediaSegment.effectStart;
                    int i2 = i;
                    if (j != 0) {
                        mediaSegment.effectStart = ((j / 1000) * 1000) + (((((float) (j % 1000)) * 1.0f) / 30.0f) * 1000.0f);
                    }
                    long j2 = mediaSegment.effectEnd;
                    if (j2 != 0) {
                        mediaSegment.effectEnd = ((j2 / 1000) * 1000) + (((((float) (j2 % 1000)) * 1.0f) / 30.0f) * 1000.0f);
                    }
                    i = i2 + 1;
                    MediaTransition mediaTransition = (MediaTransition) p(mediaTrack.mediaTransitions, i);
                    if (mediaTransition != null && i2 != size - 1) {
                        mediaSegment.end += mediaTransition.duration;
                    }
                    z = false;
                }
                mediaTrackConfig.maxVideoDuration = ((MediaSegment) q(list)).end;
            }
            List<MediaSegment> list2 = mediaTrack.mediaSegments;
            int min = Math.min(list2.size(), list.size());
            for (int i3 = 0; i3 < min; i3++) {
                MediaSegment mediaSegment2 = list2.get(i3);
                MediaSegment mediaSegment3 = list.get(i3);
                mediaSegment2.type = mediaSegment3.type;
                mediaSegment2.start = mediaSegment3.start;
                mediaSegment2.end = mediaSegment3.end;
                mediaSegment2.effectStart = mediaSegment3.effectStart;
                mediaSegment2.effectEnd = mediaSegment3.effectEnd;
                mediaSegment2.scaleType = mediaSegment3.scaleType;
            }
            if (dgb.b(list2) > min) {
                mediaTrack.mediaSegments = mediaTrack.mediaSegments.subList(0, min);
            }
            mediaTrackConfig.templateType = "normal";
        }
    }

    public static List<MediaTrack> j(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, Map<String, ShaderConfig> map) {
        InterceptResult invokeLLL;
        MediaSegment mediaSegment;
        Map<String, MediaAEffect> map2;
        long j;
        Iterator it;
        Iterator it2;
        MediaSegment mediaSegment2;
        MediaTrack mediaTrack2;
        List<MediaTrack> list;
        List<MediaTrack> list2;
        Map<String, ShaderConfig> map3;
        ShaderConfig shaderConfig;
        List<MediaTextureData> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, mediaTrack, mediaTrackConfig, map)) == null) {
            MediaSegment mediaSegment3 = null;
            if (mediaTrack == null) {
                return null;
            }
            if (mediaTrackConfig != null && (list2 = mediaTrackConfig.mediaTracks) != null) {
                for (MediaTrack mediaTrack3 : list2) {
                    List<MediaSegment> list4 = mediaTrack3.mediaSegments;
                    if (list4 != null) {
                        for (MediaSegment mediaSegment4 : list4) {
                            if (!TextUtils.isEmpty(mediaSegment4.lutConfigKey) && (map3 = mediaTrackConfig.shaderConfigMapDebug) != null && (shaderConfig = map3.get(mediaSegment4.lutConfigKey)) != null && (list3 = shaderConfig.textures) != null) {
                                for (MediaTextureData mediaTextureData : list3) {
                                    mediaTextureData.type = MediaTextureData.TEXTURE_LUT;
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (mediaTrackConfig != null && (list = mediaTrackConfig.mediaTracks) != null) {
                arrayList.addAll(list);
            }
            m(mediaTrack);
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            MediaSegment mediaSegment5 = null;
            MediaTrack mediaTrack4 = null;
            ArrayList arrayList3 = null;
            while (true) {
                if (it3.hasNext()) {
                    MediaTrack mediaTrack5 = (MediaTrack) it3.next();
                    if (mediaTrack5 != null) {
                        if (!dgb.e(mediaTrack5.mediaSegments)) {
                            for (MediaSegment mediaSegment6 : mediaTrack5.mediaSegments) {
                                if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, mediaSegment6.type)) {
                                    it2 = it3;
                                    mediaSegment6.start = 0L;
                                    mediaSegment2 = mediaSegment5;
                                    mediaTrack2 = mediaTrack4;
                                    long j2 = mediaSegment6.end;
                                    if (j2 == 0) {
                                        j2 = w(map, mediaSegment6);
                                    }
                                    mediaSegment6.end = j2;
                                    mediaSegment3 = mediaSegment6;
                                } else {
                                    MediaSegment mediaSegment7 = mediaSegment3;
                                    it2 = it3;
                                    mediaSegment2 = mediaSegment5;
                                    mediaTrack2 = mediaTrack4;
                                    if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment6.type)) {
                                        mediaSegment6.start = mediaSegment6.start;
                                        long j3 = mediaSegment6.end;
                                        if (j3 == 0) {
                                            j3 = w(map, mediaSegment6);
                                        }
                                        mediaSegment6.end = j3;
                                        mediaSegment5 = mediaSegment6;
                                        mediaSegment3 = mediaSegment7;
                                        it3 = it2;
                                        mediaTrack4 = mediaTrack2;
                                    } else {
                                        mediaSegment3 = mediaSegment7;
                                    }
                                }
                                mediaSegment5 = mediaSegment2;
                                it3 = it2;
                                mediaTrack4 = mediaTrack2;
                            }
                            it = it3;
                        } else {
                            it = it3;
                        }
                        MediaTrack mediaTrack6 = mediaTrack4;
                        if (TextUtils.equals("input", mediaTrack5.trackType)) {
                            f(mediaTrack, map, mediaTrack5);
                            if (!dgb.e(mediaTrack5.mediaSegments)) {
                                for (MediaSegment mediaSegment8 : mediaTrack5.mediaSegments) {
                                    if (!TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, mediaSegment8.type) && !TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment8.type)) {
                                        arrayList2.add(mediaSegment8);
                                    }
                                }
                            }
                            mediaSegment = mediaSegment3;
                            mediaTrack4 = mediaTrack5;
                        } else {
                            if (TextUtils.equals("multi_input", mediaTrack5.trackType)) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                f(mediaTrack, map, mediaTrack5);
                                arrayList3.add(mediaTrack5);
                            } else if (mediaTrack5.mediaSegments == null || !TextUtils.isEmpty(mediaTrack5.trackType)) {
                                it3 = it;
                                mediaTrack4 = mediaTrack6;
                            } else {
                                for (MediaSegment mediaSegment9 : mediaTrack5.mediaSegments) {
                                    MediaSegment mediaSegment10 = mediaSegment3;
                                    if ((mediaSegment9 == null || (!"input".equals(mediaSegment9.type) && !MediaSegment.SEG_TYPE_INPUT_HEADER.equals(mediaSegment9.type) && !MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(mediaSegment9.type))) && mediaTrack5.superpositionFooter == null && mediaTrack5.superpositionHeader == null) {
                                        if (mediaSegment9 != null && "multi_input".equals(mediaSegment9.type)) {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            f(mediaTrack, map, mediaTrack5);
                                            arrayList3.add(mediaTrack5);
                                        }
                                    } else {
                                        f(mediaTrack, map, mediaTrack5);
                                        if (mediaSegment9 != null && "input".equals(mediaSegment9.type)) {
                                            arrayList2.add(mediaSegment9);
                                        }
                                        mediaTrack6 = mediaTrack5;
                                    }
                                    mediaSegment3 = mediaSegment10;
                                }
                            }
                            mediaTrack4 = mediaTrack6;
                            it3 = it;
                            mediaSegment3 = mediaSegment3;
                        }
                    }
                } else {
                    mediaSegment = mediaSegment3;
                    break;
                }
            }
            if (arrayList3 != null && arrayList3.size() > 0) {
                MediaTrack mediaTrack7 = new MediaTrack();
                ArrayList arrayList4 = new ArrayList();
                MediaSegment mediaSegment11 = new MediaSegment();
                mediaSegment11.type = "input_blank";
                mediaSegment11.start = 0L;
                if (mediaTrackConfig == null) {
                    j = 0;
                } else {
                    j = mediaTrackConfig.maxVideoDuration;
                }
                mediaSegment11.end = j;
                arrayList4.add(mediaSegment11);
                mediaTrack7.mediaSegments = arrayList4;
                mediaTrack7.trackType = "input_blank";
                arrayList.add(0, mediaTrack7);
            } else {
                F(mediaTrack, mediaTrackConfig, arrayList, mediaSegment, mediaSegment5, mediaTrack4, arrayList2);
            }
            if (mediaTrackConfig != null) {
                for (int i = 1; i < arrayList.size(); i++) {
                    List<MediaSegment> list5 = ((MediaTrack) arrayList.get(i)).mediaSegments;
                    if (list5 != null) {
                        for (MediaSegment mediaSegment12 : list5) {
                            if (!TextUtils.isEmpty(mediaSegment12.effectConfigKey) && (map2 = mediaTrackConfig.effectConfigMap) != null) {
                                MediaAEffect mediaAEffect = map2.get(mediaSegment12.effectConfigKey);
                                mediaSegment12.mediaAEffect = mediaAEffect;
                                if (mediaAEffect != null && TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                                    mediaSegment12.mediaAEffect.shaderConfigKey = ah0.b;
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static void k(MediaAEffectKeyData mediaAEffectKeyData, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, mediaAEffectKeyData, mediaTrackConfig) == null) && mediaAEffectKeyData != null && !dgb.e(mediaAEffectKeyData.effectConfigKeys) && mediaTrackConfig != null && mediaTrackConfig.effectConfigMap != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : mediaAEffectKeyData.effectConfigKeys) {
                MediaAEffect mediaAEffect = mediaTrackConfig.effectConfigMap.get(str);
                if (mediaAEffect != null) {
                    if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                        mediaAEffect.shaderConfigKey = ah0.b;
                    }
                    arrayList.add(str);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            String str2 = mediaAEffectKeyData.keyMode;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1011358530:
                    if (str2.equals("random_with_video")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -938285885:
                    if (str2.equals("random")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3521:
                    if (str2.equals("no")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 97445748:
                    if (str2.equals("fixed")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 106006350:
                    if (str2.equals(IMConstants.SERVICE_TYPE_ORDER)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1792331091:
                    if (str2.equals("order_with_video")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1 && c2 != 2) {
                    if (c2 == 3 || c2 == 4) {
                        arrayList2.addAll(arrayList);
                    }
                } else {
                    arrayList2.addAll(arrayList);
                    Collections.shuffle(arrayList2);
                }
            } else {
                arrayList2.add(mediaAEffectKeyData.effectConfigKeys.get(0));
            }
            mediaAEffectKeyData.calculateEffectKeys = arrayList2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x00f7 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.tieba.rg0] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.baidu.tieba.qg0] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.baidu.tieba.og0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.baidu.tieba.rg0] */
    public static Map<String, og0> l(Context context, Map<String, ShaderConfig> map) {
        InterceptResult invokeLL;
        ?? rg0Var;
        String v;
        String v2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, map)) == null) {
            y(context, map);
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, ShaderConfig> entry : map.entrySet()) {
                    ShaderConfig value = entry.getValue();
                    List<MediaTextureData> list = value.textures;
                    if (list != null && list.size() > 0) {
                        if (TextUtils.isEmpty(value.vertexShader)) {
                            v2 = rg0.W(value.textures.size());
                        } else {
                            v2 = v(context, value.resourcePath, value.vertexShader);
                        }
                        rg0Var = new rg0(v2, o(context, value.resourcePath, value.fragmentShader, entry.getKey()));
                        ArrayList arrayList = new ArrayList();
                        for (MediaTextureData mediaTextureData : value.textures) {
                            int i = mediaTextureData.textureId;
                            if (i != 0) {
                                arrayList.add(Integer.valueOf(i));
                            }
                        }
                        if (arrayList.size() > 0) {
                            rg0Var.Y(arrayList);
                        }
                    } else if (!TextUtils.equals(entry.getKey(), ah0.c) && !TextUtils.equals(entry.getKey(), ah0.e) && !TextUtils.equals(entry.getKey(), ah0.f)) {
                        if (TextUtils.isEmpty(value.vertexShader)) {
                            v = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}";
                        } else {
                            v = v(context, value.resourcePath, value.vertexShader);
                        }
                        rg0Var = new qg0(v, o(context, value.resourcePath, value.fragmentShader, entry.getKey()));
                    } else {
                        rg0Var = new rg0(rg0.W(1), o(context, value.resourcePath, value.fragmentShader, entry.getKey()));
                    }
                    a(value, rg0Var);
                    hashMap.put(entry.getKey(), rg0Var);
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static void m(MediaTrack mediaTrack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, mediaTrack) == null) {
            Iterator<MediaSegment> it = mediaTrack.mediaSegments.iterator();
            while (it.hasNext()) {
                MediaSegment next = it.next();
                if (!TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, next.type) && !TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, next.type)) {
                    if (TextUtils.isEmpty(next.lutConfigKey) || (!TextUtils.equals(next.lutConfigKey, ah0.c) && !next.lutConfigKey.contains(ah0.d))) {
                        next.lutConfigKey = null;
                    }
                    next.shaderConfigKey = null;
                    next.effectConfigKey = null;
                    next.mediaAEffect = null;
                } else {
                    it.remove();
                }
            }
            if (mediaTrack.superpositionHeader != null) {
                mediaTrack.superpositionHeader = null;
            }
            if (mediaTrack.superpositionFooter != null) {
                mediaTrack.superpositionFooter = null;
            }
        }
    }

    public static <T> List<T> n(List<T> list, int i, d<T> dVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{list, Integer.valueOf(i), dVar, Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i <= 0) {
                return arrayList;
            }
            int i2 = 0;
            if (list != null && list.size() != 0) {
                int size = list.size();
                if (size != i) {
                    while (i2 < i) {
                        T t = list.get(i2 % size);
                        arrayList.add(dVar.b(t));
                        if (!dVar.c(t)) {
                            list.remove(t);
                            size = list.size();
                        }
                        i2++;
                    }
                } else {
                    arrayList.addAll(list);
                }
                if (z) {
                    Collections.shuffle(arrayList);
                }
                return arrayList;
            }
            while (i2 < i) {
                arrayList.add(dVar.a());
                i2++;
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static <T> T q(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                return (T) p(list, list.size() - 1);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaAEffect t(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, String str, int i, int i2, long j) {
        InterceptResult invokeCommon;
        List<MediaAEffectKeyData> list;
        MediaAEffectKeyData mediaAEffectKeyData;
        MediaAEffect mediaAEffect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{mediaTrack, mediaTrackConfig, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            MediaAEffect mediaAEffect2 = null;
            if (mediaTrack == null || (list = mediaTrack.mediaAEffectKeyData) == null || mediaTrackConfig == null || mediaTrackConfig.effectConfigMap == null || j == 0) {
                return null;
            }
            Iterator<MediaAEffectKeyData> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    mediaAEffectKeyData = it.next();
                    if (TextUtils.equals(mediaAEffectKeyData.type, str)) {
                        break;
                    }
                } else {
                    mediaAEffectKeyData = null;
                    break;
                }
            }
            if (mediaAEffectKeyData == null || dgb.e(mediaAEffectKeyData.effectConfigKeys)) {
                return null;
            }
            if (mediaAEffectKeyData.calculateEffectKeys == null) {
                k(mediaAEffectKeyData, mediaTrackConfig);
            }
            if (i == 0) {
                mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaAEffectKeyData.headerEffectKey);
                if (mediaAEffect != null) {
                    if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                        mediaAEffect.shaderConfigKey = ah0.b;
                    }
                    mediaAEffect.name = mediaAEffectKeyData.headerEffectKey;
                    mediaAEffect2 = mediaAEffect;
                }
                if (mediaAEffect2 == null && !dgb.e(mediaAEffectKeyData.calculateEffectKeys)) {
                    List<String> list2 = mediaAEffectKeyData.calculateEffectKeys;
                    mediaAEffect2 = mediaTrackConfig.effectConfigMap.get((String) dgb.c(list2, i % dgb.b(list2)));
                }
                if (mediaAEffect2 == null) {
                    MediaAEffect m47clone = mediaAEffect2.m47clone();
                    z(j, m47clone);
                    return m47clone;
                }
                return mediaAEffect2;
            }
            if (i == i2 - 1 && (mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaAEffectKeyData.footerEffectKey)) != null) {
                if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                    mediaAEffect.shaderConfigKey = ah0.b;
                }
                mediaAEffect.name = mediaAEffectKeyData.footerEffectKey;
                mediaAEffect2 = mediaAEffect;
            }
            if (mediaAEffect2 == null) {
                List<String> list22 = mediaAEffectKeyData.calculateEffectKeys;
                mediaAEffect2 = mediaTrackConfig.effectConfigMap.get((String) dgb.c(list22, i % dgb.b(list22)));
            }
            if (mediaAEffect2 == null) {
            }
        } else {
            return (MediaAEffect) invokeCommon.objValue;
        }
    }
}
