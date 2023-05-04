package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.wy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class jz9 implements ry9, wy9.c, il6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public jy9 b;
    public vy9 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.ry9
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public jz9(jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jy9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = jy9Var;
        this.a = jy9Var.a;
    }

    public final void a(String str) {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (jy9Var = this.b) == null) {
            return;
        }
        if (jy9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        jy9 jy9Var2 = this.b;
        if (jy9Var2 != null) {
            jy9Var2.f(videoInfo);
        }
    }

    public void b() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (jy9Var = this.b) == null) {
            return;
        }
        if (jy9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            jy9 jy9Var2 = this.b;
            if (!jy9Var2.e) {
                p1(jy9Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        jy9 jy9Var3 = this.b;
        selectMusicModel.Y(jy9Var3.b, jy9Var3.d, ky9.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !jy9Var3.e);
    }

    @Override // com.baidu.tieba.il6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jy9 jy9Var = this.b;
            if (jy9Var != null) {
                jy9Var.i(true);
            }
            vy9 vy9Var = this.c;
            if (vy9Var != null && vy9Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.wy9.c
    public void onGenFilterVideoFail(int i, String str) {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (jy9Var = this.b) != null) {
            jy9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.wy9.c
    public void onGenFilterVideoRecordError(int i, String str) {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (jy9Var = this.b) != null) {
            jy9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.wy9.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            jy9 jy9Var = this.b;
            if (jy9Var != null) {
                jy9Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.ry9
    public void p1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            jy9 jy9Var = this.b;
            if (jy9Var != null && jy9Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0bbd);
                jy9 jy9Var2 = this.b;
                if (jy9Var2 != null) {
                    jy9Var2.g(i, str2);
                }
            } else {
                jy9 jy9Var3 = this.b;
                if (jy9Var3 != null) {
                    jy9Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        vy9 vy9Var = new vy9(this.a.getActivity());
                        this.c = vy9Var;
                        vy9Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                jy9 jy9Var4 = this.b;
                if (jy9Var4 != null) {
                    jy9Var4.e();
                }
                a(str);
            }
        }
    }
}
