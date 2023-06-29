package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
/* loaded from: classes6.dex */
public class lja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947946182, "Lcom/baidu/tieba/lja;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947946182, "Lcom/baidu/tieba/lja;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements nja {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nja a;

        public a(nja njaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {njaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = njaVar;
        }

        @Override // com.baidu.tieba.nja
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                nja njaVar = this.a;
                if (njaVar != null) {
                    njaVar.a(i, bitmap);
                }
                h1b.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements nja {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nja a;

        public b(nja njaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {njaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = njaVar;
        }

        @Override // com.baidu.tieba.nja
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                nja njaVar = this.a;
                if (njaVar != null) {
                    njaVar.a(i, bitmap);
                }
                h1b.d("multi-frameResult: " + i);
            }
        }
    }

    public static TbMultiMediaData a(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoInfo)) == null) {
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            tbMultiMediaData.path = videoInfo.getVideoPath();
            tbMultiMediaData.coverPath = videoInfo.getThumbPath();
            tbMultiMediaData.height = videoInfo.getVideoHeight();
            tbMultiMediaData.width = videoInfo.getVideoWidth();
            tbMultiMediaData.type = 1;
            tbMultiMediaData.start = 0L;
            tbMultiMediaData.end = videoInfo.getVideoDuration() * 1000;
            tbMultiMediaData.originalDuration = videoInfo.getVideoDuration() * 1000;
            tbMultiMediaData.scaleType = "center_inside";
            tbMultiMediaData.videoInfoSource = videoInfo.getVideoSource();
            return tbMultiMediaData;
        }
        return (TbMultiMediaData) invokeL.objValue;
    }

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, nja njaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), njaVar}) == null) && vlogEditManager != null && context != null && i > 0) {
            wja wjaVar = new wja();
            wjaVar.a = vlogEditManager.getDuration();
            wjaVar.b = i;
            wjaVar.f = vlogEditManager.getInputMultiMediaData();
            MediaTrack mediaTrack = (MediaTrack) m1b.c(vlogEditManager.getUpdateMediaTracks(), 0);
            if (mediaTrack == null) {
                return;
            }
            wjaVar.e = mediaTrack.mediaSegments;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            wjaVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            wjaVar.d = i3;
            qja.f().i(wjaVar, new b(njaVar));
        }
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, nja njaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), njaVar}) == null) && multiMediaData != null && context != null && i > 0) {
            xja xjaVar = new xja();
            xjaVar.b = i;
            xjaVar.a = multiMediaData.originalDuration;
            xjaVar.e = multiMediaData;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            xjaVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            xjaVar.d = i3;
            qja.f().j(xjaVar, new a(njaVar));
        }
    }
}
