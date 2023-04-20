package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.bv9;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class ov9 implements wu9, bv9.c, wj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public ou9 b;
    public av9 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.wu9
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public ov9(ou9 ou9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ou9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ou9Var;
        this.a = ou9Var.a;
    }

    public final void a(String str) {
        ou9 ou9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (ou9Var = this.b) == null) {
            return;
        }
        if (ou9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        ou9 ou9Var2 = this.b;
        if (ou9Var2 != null) {
            ou9Var2.f(videoInfo);
        }
    }

    public void b() {
        ou9 ou9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (ou9Var = this.b) == null) {
            return;
        }
        if (ou9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            ou9 ou9Var2 = this.b;
            if (!ou9Var2.e) {
                p1(ou9Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        ou9 ou9Var3 = this.b;
        selectMusicModel.T(ou9Var3.b, ou9Var3.d, pu9.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !ou9Var3.e);
    }

    @Override // com.baidu.tieba.wj6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ou9 ou9Var = this.b;
            if (ou9Var != null) {
                ou9Var.i(true);
            }
            av9 av9Var = this.c;
            if (av9Var != null && av9Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.bv9.c
    public void onGenFilterVideoFail(int i, String str) {
        ou9 ou9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (ou9Var = this.b) != null) {
            ou9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.bv9.c
    public void onGenFilterVideoRecordError(int i, String str) {
        ou9 ou9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (ou9Var = this.b) != null) {
            ou9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.bv9.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ou9 ou9Var = this.b;
            if (ou9Var != null) {
                ou9Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.wu9
    public void p1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            ou9 ou9Var = this.b;
            if (ou9Var != null && ou9Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ba8);
                ou9 ou9Var2 = this.b;
                if (ou9Var2 != null) {
                    ou9Var2.g(i, str2);
                }
            } else {
                ou9 ou9Var3 = this.b;
                if (ou9Var3 != null) {
                    ou9Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        av9 av9Var = new av9(this.a.getActivity());
                        this.c = av9Var;
                        av9Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                ou9 ou9Var4 = this.b;
                if (ou9Var4 != null) {
                    ou9Var4.e();
                }
                a(str);
            }
        }
    }
}
