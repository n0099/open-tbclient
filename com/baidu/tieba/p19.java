package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.c19;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class p19 implements x09, c19.c, r66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public p09 b;
    public b19 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.x09
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public p19(p09 p09Var) {
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
        this.b = p09Var;
        this.a = p09Var.a;
    }

    public final void a(String str) {
        p09 p09Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (p09Var = this.b) == null) {
            return;
        }
        if (p09Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        p09 p09Var2 = this.b;
        if (p09Var2 != null) {
            p09Var2.f(videoInfo);
        }
    }

    public void b() {
        p09 p09Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (p09Var = this.b) == null) {
            return;
        }
        if (p09Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            p09 p09Var2 = this.b;
            if (!p09Var2.e) {
                n1(p09Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        p09 p09Var3 = this.b;
        selectMusicModel.J(p09Var3.b, p09Var3.d, q09.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !p09Var3.e);
    }

    @Override // com.baidu.tieba.r66
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p09 p09Var = this.b;
            if (p09Var != null) {
                p09Var.i(true);
            }
            b19 b19Var = this.c;
            if (b19Var != null && b19Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.x09
    public void n1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            p09 p09Var = this.b;
            if (p09Var != null && p09Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b4c);
                p09 p09Var2 = this.b;
                if (p09Var2 != null) {
                    p09Var2.g(i, str2);
                }
            } else {
                p09 p09Var3 = this.b;
                if (p09Var3 != null) {
                    p09Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        b19 b19Var = new b19(this.a.getActivity());
                        this.c = b19Var;
                        b19Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                p09 p09Var4 = this.b;
                if (p09Var4 != null) {
                    p09Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.c19.c
    public void onGenFilterVideoFail(int i, String str) {
        p09 p09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (p09Var = this.b) != null) {
            p09Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.c19.c
    public void onGenFilterVideoRecordError(int i, String str) {
        p09 p09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (p09Var = this.b) != null) {
            p09Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.c19.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            p09 p09Var = this.b;
            if (p09Var != null) {
                p09Var.e();
            }
            a(str);
        }
    }
}
