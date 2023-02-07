package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.z99;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class ma9 implements u99, z99.c, ve6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public m99 b;
    public y99 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.u99
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public ma9(m99 m99Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m99Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = m99Var;
        this.a = m99Var.a;
    }

    public final void a(String str) {
        m99 m99Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (m99Var = this.b) == null) {
            return;
        }
        if (m99Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        m99 m99Var2 = this.b;
        if (m99Var2 != null) {
            m99Var2.f(videoInfo);
        }
    }

    public void b() {
        m99 m99Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (m99Var = this.b) == null) {
            return;
        }
        if (m99Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            m99 m99Var2 = this.b;
            if (!m99Var2.e) {
                o1(m99Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        m99 m99Var3 = this.b;
        selectMusicModel.J(m99Var3.b, m99Var3.d, n99.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !m99Var3.e);
    }

    @Override // com.baidu.tieba.ve6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m99 m99Var = this.b;
            if (m99Var != null) {
                m99Var.i(true);
            }
            y99 y99Var = this.c;
            if (y99Var != null && y99Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.u99
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            m99 m99Var = this.b;
            if (m99Var != null && m99Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b8c);
                m99 m99Var2 = this.b;
                if (m99Var2 != null) {
                    m99Var2.g(i, str2);
                }
            } else {
                m99 m99Var3 = this.b;
                if (m99Var3 != null) {
                    m99Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        y99 y99Var = new y99(this.a.getActivity());
                        this.c = y99Var;
                        y99Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                m99 m99Var4 = this.b;
                if (m99Var4 != null) {
                    m99Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.z99.c
    public void onGenFilterVideoFail(int i, String str) {
        m99 m99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (m99Var = this.b) != null) {
            m99Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.z99.c
    public void onGenFilterVideoRecordError(int i, String str) {
        m99 m99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (m99Var = this.b) != null) {
            m99Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.z99.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            m99 m99Var = this.b;
            if (m99Var != null) {
                m99Var.e();
            }
            a(str);
        }
    }
}
