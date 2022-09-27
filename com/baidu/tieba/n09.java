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
public class n09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements p09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p09 a;

        public a(p09 p09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p09Var;
        }

        @Override // com.baidu.tieba.p09
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                p09 p09Var = this.a;
                if (p09Var != null) {
                    p09Var.a(i, bitmap);
                }
                qg9.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements p09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p09 a;

        public b(p09 p09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p09Var;
        }

        @Override // com.baidu.tieba.p09
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                p09 p09Var = this.a;
                if (p09Var != null) {
                    p09Var.a(i, bitmap);
                }
                qg9.d("multi-frameResult: " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947948786, "Lcom/baidu/tieba/n09;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947948786, "Lcom/baidu/tieba/n09;");
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

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, p09 p09Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), p09Var}) == null) || vlogEditManager == null || context == null || i <= 0) {
            return;
        }
        y09 y09Var = new y09();
        y09Var.a = vlogEditManager.getDuration();
        y09Var.b = i;
        y09Var.f = vlogEditManager.getInputMultiMediaData();
        MediaTrack mediaTrack = (MediaTrack) vg9.c(vlogEditManager.getUpdateMediaTracks(), 0);
        if (mediaTrack == null) {
            return;
        }
        y09Var.e = mediaTrack.mediaSegments;
        if (i2 == 0) {
            i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        y09Var.c = i2;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        y09Var.d = i3;
        s09.f().i(y09Var, new b(p09Var));
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, p09 p09Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), p09Var}) == null) || multiMediaData == null || context == null || i <= 0) {
            return;
        }
        z09 z09Var = new z09();
        z09Var.b = i;
        z09Var.a = multiMediaData.originalDuration;
        z09Var.e = multiMediaData;
        if (i2 == 0) {
            i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        z09Var.c = i2;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        z09Var.d = i3;
        s09.f().j(z09Var, new a(p09Var));
    }
}
