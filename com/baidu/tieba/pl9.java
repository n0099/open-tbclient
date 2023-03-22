package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.cl9;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class pl9 implements xk9, cl9.c, xg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public pk9 b;
    public bl9 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.xk9
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public pl9(pk9 pk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pk9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pk9Var;
        this.a = pk9Var.a;
    }

    public final void a(String str) {
        pk9 pk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (pk9Var = this.b) == null) {
            return;
        }
        if (pk9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        pk9 pk9Var2 = this.b;
        if (pk9Var2 != null) {
            pk9Var2.f(videoInfo);
        }
    }

    public void b() {
        pk9 pk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (pk9Var = this.b) == null) {
            return;
        }
        if (pk9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            pk9 pk9Var2 = this.b;
            if (!pk9Var2.e) {
                q1(pk9Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        pk9 pk9Var3 = this.b;
        selectMusicModel.U(pk9Var3.b, pk9Var3.d, qk9.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !pk9Var3.e);
    }

    @Override // com.baidu.tieba.xg6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pk9 pk9Var = this.b;
            if (pk9Var != null) {
                pk9Var.i(true);
            }
            bl9 bl9Var = this.c;
            if (bl9Var != null && bl9Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.cl9.c
    public void onGenFilterVideoFail(int i, String str) {
        pk9 pk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (pk9Var = this.b) != null) {
            pk9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.cl9.c
    public void onGenFilterVideoRecordError(int i, String str) {
        pk9 pk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (pk9Var = this.b) != null) {
            pk9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.cl9.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            pk9 pk9Var = this.b;
            if (pk9Var != null) {
                pk9Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.xk9
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            pk9 pk9Var = this.b;
            if (pk9Var != null && pk9Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0bac);
                pk9 pk9Var2 = this.b;
                if (pk9Var2 != null) {
                    pk9Var2.g(i, str2);
                }
            } else {
                pk9 pk9Var3 = this.b;
                if (pk9Var3 != null) {
                    pk9Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        bl9 bl9Var = new bl9(this.a.getActivity());
                        this.c = bl9Var;
                        bl9Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                pk9 pk9Var4 = this.b;
                if (pk9Var4 != null) {
                    pk9Var4.e();
                }
                a(str);
            }
        }
    }
}
