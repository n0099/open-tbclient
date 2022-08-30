package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.kt8;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class xt8 implements ft8, kt8.c, r16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public xs8 b;
    public jt8 c;
    public SelectMusicModel d;
    public String e;

    public xt8(xs8 xs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xs8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = xs8Var;
        this.a = xs8Var.a;
    }

    public final void a(String str) {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (xs8Var = this.b) == null) {
            return;
        }
        if (xs8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        xs8 xs8Var2 = this.b;
        if (xs8Var2 != null) {
            xs8Var2.f(videoInfo);
        }
    }

    public void b() {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (xs8Var = this.b) == null) {
            return;
        }
        if (xs8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            xs8 xs8Var2 = this.b;
            if (!xs8Var2.e) {
                q1(xs8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        xs8 xs8Var3 = this.b;
        selectMusicModel.C(xs8Var3.b, xs8Var3.d, ys8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !xs8Var3.e);
    }

    @Override // com.baidu.tieba.r16
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xs8 xs8Var = this.b;
            if (xs8Var != null) {
                xs8Var.i(true);
            }
            jt8 jt8Var = this.c;
            if (jt8Var == null || !jt8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.baidu.tieba.kt8.c
    public void onGenFilterVideoFail(int i, String str) {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (xs8Var = this.b) == null) {
            return;
        }
        xs8Var.d(i, str);
    }

    @Override // com.baidu.tieba.kt8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (xs8Var = this.b) == null) {
            return;
        }
        xs8Var.d(i, str);
    }

    @Override // com.baidu.tieba.kt8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            xs8 xs8Var = this.b;
            if (xs8Var != null) {
                xs8Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.ft8
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            xs8 xs8Var = this.b;
            if (xs8Var != null && xs8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ae3);
                xs8 xs8Var2 = this.b;
                if (xs8Var2 != null) {
                    xs8Var2.g(i, str2);
                }
            } else {
                xs8 xs8Var3 = this.b;
                if (xs8Var3 != null) {
                    xs8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        jt8 jt8Var = new jt8(this.a.getActivity());
                        this.c = jt8Var;
                        jt8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                xs8 xs8Var4 = this.b;
                if (xs8Var4 != null) {
                    xs8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ft8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
