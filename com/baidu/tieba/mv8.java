package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.zu8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class mv8 implements uu8, zu8.c, f36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public mu8 b;
    public yu8 c;
    public SelectMusicModel d;
    public String e;

    public mv8(mu8 mu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = mu8Var;
        this.a = mu8Var.a;
    }

    public final void a(String str) {
        mu8 mu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (mu8Var = this.b) == null) {
            return;
        }
        if (mu8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        mu8 mu8Var2 = this.b;
        if (mu8Var2 != null) {
            mu8Var2.f(videoInfo);
        }
    }

    public void b() {
        mu8 mu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mu8Var = this.b) == null) {
            return;
        }
        if (mu8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            mu8 mu8Var2 = this.b;
            if (!mu8Var2.e) {
                q1(mu8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        mu8 mu8Var3 = this.b;
        selectMusicModel.C(mu8Var3.b, mu8Var3.d, nu8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !mu8Var3.e);
    }

    @Override // com.baidu.tieba.f36
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mu8 mu8Var = this.b;
            if (mu8Var != null) {
                mu8Var.i(true);
            }
            yu8 yu8Var = this.c;
            if (yu8Var == null || !yu8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.baidu.tieba.zu8.c
    public void onGenFilterVideoFail(int i, String str) {
        mu8 mu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (mu8Var = this.b) == null) {
            return;
        }
        mu8Var.d(i, str);
    }

    @Override // com.baidu.tieba.zu8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        mu8 mu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (mu8Var = this.b) == null) {
            return;
        }
        mu8Var.d(i, str);
    }

    @Override // com.baidu.tieba.zu8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            mu8 mu8Var = this.b;
            if (mu8Var != null) {
                mu8Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.uu8
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            mu8 mu8Var = this.b;
            if (mu8Var != null && mu8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0af9);
                mu8 mu8Var2 = this.b;
                if (mu8Var2 != null) {
                    mu8Var2.g(i, str2);
                }
            } else {
                mu8 mu8Var3 = this.b;
                if (mu8Var3 != null) {
                    mu8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        yu8 yu8Var = new yu8(this.a.getActivity());
                        this.c = yu8Var;
                        yu8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                mu8 mu8Var4 = this.b;
                if (mu8Var4 != null) {
                    mu8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.uu8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
