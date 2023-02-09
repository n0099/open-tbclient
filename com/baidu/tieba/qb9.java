package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.db9;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class qb9 implements ya9, db9.c, ve6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public qa9 b;
    public cb9 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.ya9
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public qb9(qa9 qa9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qa9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = qa9Var;
        this.a = qa9Var.a;
    }

    public final void a(String str) {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (qa9Var = this.b) == null) {
            return;
        }
        if (qa9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        qa9 qa9Var2 = this.b;
        if (qa9Var2 != null) {
            qa9Var2.f(videoInfo);
        }
    }

    public void b() {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (qa9Var = this.b) == null) {
            return;
        }
        if (qa9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            qa9 qa9Var2 = this.b;
            if (!qa9Var2.e) {
                o1(qa9Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        qa9 qa9Var3 = this.b;
        selectMusicModel.J(qa9Var3.b, qa9Var3.d, ra9.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !qa9Var3.e);
    }

    @Override // com.baidu.tieba.ve6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qa9 qa9Var = this.b;
            if (qa9Var != null) {
                qa9Var.i(true);
            }
            cb9 cb9Var = this.c;
            if (cb9Var != null && cb9Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.ya9
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            qa9 qa9Var = this.b;
            if (qa9Var != null && qa9Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b96);
                qa9 qa9Var2 = this.b;
                if (qa9Var2 != null) {
                    qa9Var2.g(i, str2);
                }
            } else {
                qa9 qa9Var3 = this.b;
                if (qa9Var3 != null) {
                    qa9Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        cb9 cb9Var = new cb9(this.a.getActivity());
                        this.c = cb9Var;
                        cb9Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                qa9 qa9Var4 = this.b;
                if (qa9Var4 != null) {
                    qa9Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.db9.c
    public void onGenFilterVideoFail(int i, String str) {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (qa9Var = this.b) != null) {
            qa9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.db9.c
    public void onGenFilterVideoRecordError(int i, String str) {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (qa9Var = this.b) != null) {
            qa9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.db9.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            qa9 qa9Var = this.b;
            if (qa9Var != null) {
                qa9Var.e();
            }
            a(str);
        }
    }
}
