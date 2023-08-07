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
/* loaded from: classes7.dex */
public class nra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948013452, "Lcom/baidu/tieba/nra;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948013452, "Lcom/baidu/tieba/nra;");
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements pra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pra a;

        public a(pra praVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {praVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = praVar;
        }

        @Override // com.baidu.tieba.pra
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                pra praVar = this.a;
                if (praVar != null) {
                    praVar.a(i, bitmap);
                }
                i9b.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements pra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pra a;

        public b(pra praVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {praVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = praVar;
        }

        @Override // com.baidu.tieba.pra
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                pra praVar = this.a;
                if (praVar != null) {
                    praVar.a(i, bitmap);
                }
                i9b.d("multi-frameResult: " + i);
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

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, pra praVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), praVar}) == null) && vlogEditManager != null && context != null && i > 0) {
            yra yraVar = new yra();
            yraVar.a = vlogEditManager.getDuration();
            yraVar.b = i;
            yraVar.f = vlogEditManager.getInputMultiMediaData();
            MediaTrack mediaTrack = (MediaTrack) n9b.c(vlogEditManager.getUpdateMediaTracks(), 0);
            if (mediaTrack == null) {
                return;
            }
            yraVar.e = mediaTrack.mediaSegments;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            yraVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            yraVar.d = i3;
            sra.f().i(yraVar, new b(praVar));
        }
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, pra praVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), praVar}) == null) && multiMediaData != null && context != null && i > 0) {
            zra zraVar = new zra();
            zraVar.b = i;
            zraVar.a = multiMediaData.originalDuration;
            zraVar.e = multiMediaData;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            zraVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            zraVar.d = i3;
            sra.f().j(zraVar, new a(praVar));
        }
    }
}
