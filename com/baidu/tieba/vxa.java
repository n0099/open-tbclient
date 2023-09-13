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
/* loaded from: classes8.dex */
public class vxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948257546, "Lcom/baidu/tieba/vxa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948257546, "Lcom/baidu/tieba/vxa;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xxa a;

        public a(xxa xxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xxaVar;
        }

        @Override // com.baidu.tieba.xxa
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                xxa xxaVar = this.a;
                if (xxaVar != null) {
                    xxaVar.a(i, bitmap);
                }
                iib.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xxa a;

        public b(xxa xxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xxaVar;
        }

        @Override // com.baidu.tieba.xxa
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                xxa xxaVar = this.a;
                if (xxaVar != null) {
                    xxaVar.a(i, bitmap);
                }
                iib.d("multi-frameResult: " + i);
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

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, xxa xxaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), xxaVar}) == null) && vlogEditManager != null && context != null && i > 0) {
            gya gyaVar = new gya();
            gyaVar.a = vlogEditManager.getDuration();
            gyaVar.b = i;
            gyaVar.f = vlogEditManager.getInputMultiMediaData();
            MediaTrack mediaTrack = (MediaTrack) nib.c(vlogEditManager.getUpdateMediaTracks(), 0);
            if (mediaTrack == null) {
                return;
            }
            gyaVar.e = mediaTrack.mediaSegments;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            gyaVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            gyaVar.d = i3;
            aya.f().i(gyaVar, new b(xxaVar));
        }
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, xxa xxaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), xxaVar}) == null) && multiMediaData != null && context != null && i > 0) {
            hya hyaVar = new hya();
            hyaVar.b = i;
            hyaVar.a = multiMediaData.originalDuration;
            hyaVar.e = multiMediaData;
            if (i2 == 0) {
                i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            }
            hyaVar.c = i2;
            if (i3 == 0) {
                i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
            }
            hyaVar.d = i3;
            aya.f().j(hyaVar, new a(xxaVar));
        }
    }
}
