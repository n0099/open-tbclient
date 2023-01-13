package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.a69;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class n69 implements v59, a69.c, ja6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public n59 b;
    public z59 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.v59
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public n69(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = n59Var;
        this.a = n59Var.a;
    }

    public final void a(String str) {
        n59 n59Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (n59Var = this.b) == null) {
            return;
        }
        if (n59Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        n59 n59Var2 = this.b;
        if (n59Var2 != null) {
            n59Var2.f(videoInfo);
        }
    }

    public void b() {
        n59 n59Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (n59Var = this.b) == null) {
            return;
        }
        if (n59Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            n59 n59Var2 = this.b;
            if (!n59Var2.e) {
                o1(n59Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        n59 n59Var3 = this.b;
        selectMusicModel.J(n59Var3.b, n59Var3.d, o59.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !n59Var3.e);
    }

    @Override // com.baidu.tieba.ja6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n59 n59Var = this.b;
            if (n59Var != null) {
                n59Var.i(true);
            }
            z59 z59Var = this.c;
            if (z59Var != null && z59Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.v59
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            n59 n59Var = this.b;
            if (n59Var != null && n59Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b67);
                n59 n59Var2 = this.b;
                if (n59Var2 != null) {
                    n59Var2.g(i, str2);
                }
            } else {
                n59 n59Var3 = this.b;
                if (n59Var3 != null) {
                    n59Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        z59 z59Var = new z59(this.a.getActivity());
                        this.c = z59Var;
                        z59Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                n59 n59Var4 = this.b;
                if (n59Var4 != null) {
                    n59Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.a69.c
    public void onGenFilterVideoFail(int i, String str) {
        n59 n59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (n59Var = this.b) != null) {
            n59Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.a69.c
    public void onGenFilterVideoRecordError(int i, String str) {
        n59 n59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (n59Var = this.b) != null) {
            n59Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.a69.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            n59 n59Var = this.b;
            if (n59Var != null) {
                n59Var.e();
            }
            a(str);
        }
    }
}
