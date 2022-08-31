package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.it8;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class vt8 implements dt8, it8.c, p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public vs8 b;
    public ht8 c;
    public SelectMusicModel d;
    public String e;

    public vt8(vs8 vs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vs8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = vs8Var;
        this.a = vs8Var.a;
    }

    public final void a(String str) {
        vs8 vs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (vs8Var = this.b) == null) {
            return;
        }
        if (vs8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        vs8 vs8Var2 = this.b;
        if (vs8Var2 != null) {
            vs8Var2.f(videoInfo);
        }
    }

    public void b() {
        vs8 vs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (vs8Var = this.b) == null) {
            return;
        }
        if (vs8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            vs8 vs8Var2 = this.b;
            if (!vs8Var2.e) {
                q1(vs8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        vs8 vs8Var3 = this.b;
        selectMusicModel.C(vs8Var3.b, vs8Var3.d, ws8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !vs8Var3.e);
    }

    @Override // com.baidu.tieba.p16
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vs8 vs8Var = this.b;
            if (vs8Var != null) {
                vs8Var.i(true);
            }
            ht8 ht8Var = this.c;
            if (ht8Var == null || !ht8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.baidu.tieba.it8.c
    public void onGenFilterVideoFail(int i, String str) {
        vs8 vs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (vs8Var = this.b) == null) {
            return;
        }
        vs8Var.d(i, str);
    }

    @Override // com.baidu.tieba.it8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        vs8 vs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (vs8Var = this.b) == null) {
            return;
        }
        vs8Var.d(i, str);
    }

    @Override // com.baidu.tieba.it8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            vs8 vs8Var = this.b;
            if (vs8Var != null) {
                vs8Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.dt8
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            vs8 vs8Var = this.b;
            if (vs8Var != null && vs8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ae3);
                vs8 vs8Var2 = this.b;
                if (vs8Var2 != null) {
                    vs8Var2.g(i, str2);
                }
            } else {
                vs8 vs8Var3 = this.b;
                if (vs8Var3 != null) {
                    vs8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        ht8 ht8Var = new ht8(this.a.getActivity());
                        this.c = ht8Var;
                        ht8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                vs8 vs8Var4 = this.b;
                if (vs8Var4 != null) {
                    vs8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.dt8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
