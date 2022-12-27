package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.d19;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class q19 implements y09, d19.c, r66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public q09 b;
    public c19 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.y09
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public q19(q09 q09Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q09Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = q09Var;
        this.a = q09Var.a;
    }

    public final void a(String str) {
        q09 q09Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (q09Var = this.b) == null) {
            return;
        }
        if (q09Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        q09 q09Var2 = this.b;
        if (q09Var2 != null) {
            q09Var2.f(videoInfo);
        }
    }

    public void b() {
        q09 q09Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (q09Var = this.b) == null) {
            return;
        }
        if (q09Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            q09 q09Var2 = this.b;
            if (!q09Var2.e) {
                n1(q09Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        q09 q09Var3 = this.b;
        selectMusicModel.J(q09Var3.b, q09Var3.d, r09.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !q09Var3.e);
    }

    @Override // com.baidu.tieba.r66
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            q09 q09Var = this.b;
            if (q09Var != null) {
                q09Var.i(true);
            }
            c19 c19Var = this.c;
            if (c19Var != null && c19Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.y09
    public void n1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            q09 q09Var = this.b;
            if (q09Var != null && q09Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b4c);
                q09 q09Var2 = this.b;
                if (q09Var2 != null) {
                    q09Var2.g(i, str2);
                }
            } else {
                q09 q09Var3 = this.b;
                if (q09Var3 != null) {
                    q09Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        c19 c19Var = new c19(this.a.getActivity());
                        this.c = c19Var;
                        c19Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                q09 q09Var4 = this.b;
                if (q09Var4 != null) {
                    q09Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.d19.c
    public void onGenFilterVideoFail(int i, String str) {
        q09 q09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (q09Var = this.b) != null) {
            q09Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.d19.c
    public void onGenFilterVideoRecordError(int i, String str) {
        q09 q09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (q09Var = this.b) != null) {
            q09Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.d19.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            q09 q09Var = this.b;
            if (q09Var != null) {
                q09Var.e();
            }
            a(str);
        }
    }
}
