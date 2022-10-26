package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.yv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes4.dex */
public class lw8 implements tv8, yv8.c, z36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public lv8 b;
    public xv8 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.tv8
    public void setMusicData(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public lw8(lv8 lv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lv8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = lv8Var;
        this.a = lv8Var.a;
    }

    public final void a(String str) {
        lv8 lv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (lv8Var = this.b) == null) {
            return;
        }
        if (lv8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        lv8 lv8Var2 = this.b;
        if (lv8Var2 != null) {
            lv8Var2.f(videoInfo);
        }
    }

    public void b() {
        lv8 lv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (lv8Var = this.b) == null) {
            return;
        }
        if (lv8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            lv8 lv8Var2 = this.b;
            if (!lv8Var2.e) {
                p1(lv8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        lv8 lv8Var3 = this.b;
        selectMusicModel.C(lv8Var3.b, lv8Var3.d, mv8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !lv8Var3.e);
    }

    @Override // com.baidu.tieba.z36
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            lv8 lv8Var = this.b;
            if (lv8Var != null) {
                lv8Var.i(true);
            }
            xv8 xv8Var = this.c;
            if (xv8Var != null && xv8Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.yv8.c
    public void onGenFilterVideoFail(int i, String str) {
        lv8 lv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (lv8Var = this.b) != null) {
            lv8Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.yv8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        lv8 lv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (lv8Var = this.b) != null) {
            lv8Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.yv8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            lv8 lv8Var = this.b;
            if (lv8Var != null) {
                lv8Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.tv8
    public void p1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            lv8 lv8Var = this.b;
            if (lv8Var != null && lv8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b08);
                lv8 lv8Var2 = this.b;
                if (lv8Var2 != null) {
                    lv8Var2.g(i, str2);
                }
            } else {
                lv8 lv8Var3 = this.b;
                if (lv8Var3 != null) {
                    lv8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        xv8 xv8Var = new xv8(this.a.getActivity());
                        this.c = xv8Var;
                        xv8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                lv8 lv8Var4 = this.b;
                if (lv8Var4 != null) {
                    lv8Var4.e();
                }
                a(str);
            }
        }
    }
}
