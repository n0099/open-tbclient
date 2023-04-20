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
/* loaded from: classes5.dex */
public class l0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947890444, "Lcom/baidu/tieba/l0a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947890444, "Lcom/baidu/tieba/l0a;");
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements n0a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0a a;

        public a(n0a n0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0aVar;
        }

        @Override // com.baidu.tieba.n0a
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                n0a n0aVar = this.a;
                if (n0aVar != null) {
                    n0aVar.a(i, bitmap);
                }
                lha.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements n0a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0a a;

        public b(n0a n0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0aVar;
        }

        @Override // com.baidu.tieba.n0a
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                n0a n0aVar = this.a;
                if (n0aVar != null) {
                    n0aVar.a(i, bitmap);
                }
                lha.d("multi-frameResult: " + i);
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

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, n0a n0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), n0aVar}) == null) && vlogEditManager != null && context != null && i > 0) {
            w0a w0aVar = new w0a();
            w0aVar.a = vlogEditManager.getDuration();
            w0aVar.b = i;
            w0aVar.f = vlogEditManager.getInputMultiMediaData();
            MediaTrack mediaTrack = (MediaTrack) qha.c(vlogEditManager.getUpdateMediaTracks(), 0);
            if (mediaTrack == null) {
                return;
            }
            w0aVar.e = mediaTrack.mediaSegments;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            w0aVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            w0aVar.d = i3;
            q0a.f().i(w0aVar, new b(n0aVar));
        }
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, n0a n0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), n0aVar}) == null) && multiMediaData != null && context != null && i > 0) {
            x0a x0aVar = new x0a();
            x0aVar.b = i;
            x0aVar.a = multiMediaData.originalDuration;
            x0aVar.e = multiMediaData;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            x0aVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            x0aVar.d = i3;
            q0a.f().j(x0aVar, new a(n0aVar));
        }
    }
}
