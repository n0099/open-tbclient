package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.hx8;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class ux8 implements cx8, hx8.c, j56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public uw8 b;
    public gx8 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.cx8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public ux8(uw8 uw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uw8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = uw8Var;
        this.a = uw8Var.a;
    }

    public final void a(String str) {
        uw8 uw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (uw8Var = this.b) == null) {
            return;
        }
        if (uw8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        uw8 uw8Var2 = this.b;
        if (uw8Var2 != null) {
            uw8Var2.f(videoInfo);
        }
    }

    public void b() {
        uw8 uw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (uw8Var = this.b) == null) {
            return;
        }
        if (uw8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            uw8 uw8Var2 = this.b;
            if (!uw8Var2.e) {
                o1(uw8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        uw8 uw8Var3 = this.b;
        selectMusicModel.C(uw8Var3.b, uw8Var3.d, vw8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !uw8Var3.e);
    }

    @Override // com.baidu.tieba.j56
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            uw8 uw8Var = this.b;
            if (uw8Var != null) {
                uw8Var.i(true);
            }
            gx8 gx8Var = this.c;
            if (gx8Var != null && gx8Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.cx8
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            uw8 uw8Var = this.b;
            if (uw8Var != null && uw8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b14);
                uw8 uw8Var2 = this.b;
                if (uw8Var2 != null) {
                    uw8Var2.g(i, str2);
                }
            } else {
                uw8 uw8Var3 = this.b;
                if (uw8Var3 != null) {
                    uw8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        gx8 gx8Var = new gx8(this.a.getActivity());
                        this.c = gx8Var;
                        gx8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                uw8 uw8Var4 = this.b;
                if (uw8Var4 != null) {
                    uw8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.hx8.c
    public void onGenFilterVideoFail(int i, String str) {
        uw8 uw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (uw8Var = this.b) != null) {
            uw8Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.hx8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        uw8 uw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (uw8Var = this.b) != null) {
            uw8Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.hx8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            uw8 uw8Var = this.b;
            if (uw8Var != null) {
                uw8Var.e();
            }
            a(str);
        }
    }
}
