package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class z9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public t9a c;
    public VideoPlayView.i d;
    public int e;
    public Set<String> f;

    public z9a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.b = this.a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c != null && this.e > 0) {
            while (this.b < this.c.k()) {
                VideoItemData t = this.c.t(this.b);
                this.b++;
                if (t != null && !TextUtils.isEmpty(t.video_url)) {
                    this.e--;
                    if (!this.f.contains(t.video_url)) {
                        CyberPlayerManager.prefetch(t.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                        this.f.add(t.video_url);
                    }
                    if (this.e <= 0) {
                        break;
                    }
                }
            }
            if (this.e > 0 && this.d != null && this.c.k() - this.a < 10) {
                this.d.a();
            }
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a = i;
        }
    }

    public void d(t9a t9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t9aVar) == null) {
            this.c = t9aVar;
        }
    }

    public void e(VideoPlayView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.d = iVar;
        }
    }
}
