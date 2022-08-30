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
/* loaded from: classes4.dex */
public class iy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements ky8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky8 a;

        public a(ky8 ky8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky8Var;
        }

        @Override // com.baidu.tieba.ky8
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                ky8 ky8Var = this.a;
                if (ky8Var != null) {
                    ky8Var.a(i, bitmap);
                }
                ac9.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements ky8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky8 a;

        public b(ky8 ky8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky8Var;
        }

        @Override // com.baidu.tieba.ky8
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                ky8 ky8Var = this.a;
                if (ky8Var != null) {
                    ky8Var.a(i, bitmap);
                }
                ac9.d("multi-frameResult: " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947869953, "Lcom/baidu/tieba/iy8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947869953, "Lcom/baidu/tieba/iy8;");
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

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, ky8 ky8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ky8Var}) == null) || vlogEditManager == null || context == null || i <= 0) {
            return;
        }
        ty8 ty8Var = new ty8();
        ty8Var.a = vlogEditManager.getDuration();
        ty8Var.b = i;
        ty8Var.f = vlogEditManager.getInputMultiMediaData();
        MediaTrack mediaTrack = (MediaTrack) fc9.c(vlogEditManager.getUpdateMediaTracks(), 0);
        if (mediaTrack == null) {
            return;
        }
        ty8Var.e = mediaTrack.mediaSegments;
        if (i2 == 0) {
            i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        ty8Var.c = i2;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        ty8Var.d = i3;
        ny8.f().i(ty8Var, new b(ky8Var));
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, ky8 ky8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ky8Var}) == null) || multiMediaData == null || context == null || i <= 0) {
            return;
        }
        uy8 uy8Var = new uy8();
        uy8Var.b = i;
        uy8Var.a = multiMediaData.originalDuration;
        uy8Var.e = multiMediaData;
        if (i2 == 0) {
            i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        uy8Var.c = i2;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        uy8Var.d = i3;
        ny8.f().j(uy8Var, new a(ky8Var));
    }
}
