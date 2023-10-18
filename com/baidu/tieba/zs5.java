package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class zs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i);

        void b();

        void c();

        void d(String str);
    }

    /* loaded from: classes9.dex */
    public class a implements cbb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        @Override // com.baidu.tieba.cbb
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.cbb
        public void a(int i) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (bVar = this.a) != null) {
                bVar.a(i);
            }
        }

        @Override // com.baidu.tieba.cbb
        public void e(String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (bVar = this.a) != null) {
                bVar.d(str);
            }
        }

        @Override // com.baidu.tieba.cbb
        public void f(String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (bVar = this.a) != null) {
                bVar.c();
            }
        }

        @Override // com.baidu.tieba.cbb
        public void b() {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bVar = this.a) != null) {
                bVar.b();
            }
        }

        @Override // com.baidu.tieba.cbb
        public void d() {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bVar = this.a) != null) {
                bVar.c();
            }
        }
    }

    public static Bitmap a(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, uri, i)) == null) {
            try {
                return BitmapHelper.subSampleBitmap(context, uri, i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap b(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i)) == null) {
            try {
                return BitmapHelper.loadResizedBitmap(str, i, i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap c(int i, Context context, Uri uri, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), context, uri, str, Integer.valueOf(i2)})) == null) {
            if (i == 12001) {
                return e(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                return b(context, str, i2);
            }
            return a(context, uri, i2);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static VideoMuxer d(pva pvaVar, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pvaVar, bVar)) == null) {
            if (pvaVar == null) {
                return null;
            }
            int f = pvaVar.f();
            int e = pvaVar.e();
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setRecordConfigEncodeHevcVideo(true);
            videoMuxerData.setCurrentEncodeHevcVideo(true);
            ArrayList arrayList = new ArrayList();
            if (pvaVar.c() != null) {
                TbMultiMediaData tbMultiMediaData = (TbMultiMediaData) pvaVar.c().clone();
                tbMultiMediaData.textureId = 0;
                arrayList.add(tbMultiMediaData);
                videoMuxerData.setPhotoDataList(arrayList);
                videoMuxerData.setVideoPath(tbMultiMediaData.path);
                videoMuxerData.setPreviewWidth(f);
                videoMuxerData.setPreviewHeight(e);
                videoMuxerData.setVideoRatio(pvaVar.g());
                videoMuxerData.setOutWidth(f);
                videoMuxerData.setOutHeight(e);
                videoMuxerData.setOutBitRate(f * e * 6);
            }
            if (pvaVar.a() != null) {
                videoMuxerData.setFilterValue(pvaVar.a());
            }
            if (pvaVar.b() != null) {
                videoMuxerData.setCurrThemeEffect(pvaVar.b());
            }
            videoMuxerData.setUserNewAudioMixture(true);
            if (pvaVar.d() != null) {
                videoMuxerData.setMusicData(pvaVar.d());
                ArrayList arrayList2 = new ArrayList();
                AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
                AudioPlayData audioPlayData = new AudioPlayData(pvaVar.d().localPath, 0, gfb.f(pvaVar.d().localPath), 1.0f);
                ArrayList arrayList3 = new ArrayList();
                audioPlayTrackData.mAudioPlayDataList = arrayList3;
                arrayList3.add(audioPlayData);
                arrayList2.add(audioPlayTrackData);
                videoMuxerData.setAudioPlayTrackDataList(arrayList2);
            }
            videoMuxerData.setComposeNecessary(true);
            VideoMuxer videoMuxer = new VideoMuxer();
            videoMuxer.setListener(new a(bVar));
            videoMuxer.startMuxer(videoMuxerData);
            return videoMuxer;
        }
        return (VideoMuxer) invokeLL.objValue;
    }

    public static Bitmap e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            try {
                int f = f(FileHelper.getFileDireciory(SelectImageHelper.TMP_IMAGE_NAME));
                Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(SelectImageHelper.TMP_IMAGE_NAME, i);
                if (f != 0 && subSampleBitmap != null) {
                    return BitmapHelper.rotateBitmapBydegree(subSampleBitmap, f);
                }
                return subSampleBitmap;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeI.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        if (attributeInt != 8) {
                            return 0;
                        }
                        return 270;
                    }
                    return 90;
                }
                return 180;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
