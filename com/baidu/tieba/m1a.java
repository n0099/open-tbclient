package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.z0a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class m1a implements u0a, z0a.c, vm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public m0a b;
    public y0a c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.u0a
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public m1a(m0a m0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = m0aVar;
        this.a = m0aVar.a;
    }

    public final void a(String str) {
        m0a m0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (m0aVar = this.b) == null) {
            return;
        }
        if (m0aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        m0a m0aVar2 = this.b;
        if (m0aVar2 != null) {
            m0aVar2.f(videoInfo);
        }
    }

    public void b() {
        m0a m0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (m0aVar = this.b) == null) {
            return;
        }
        if (m0aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            m0a m0aVar2 = this.b;
            if (!m0aVar2.e) {
                o1(m0aVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        m0a m0aVar3 = this.b;
        selectMusicModel.X(m0aVar3.b, m0aVar3.d, n0a.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !m0aVar3.e);
    }

    @Override // com.baidu.tieba.vm6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m0a m0aVar = this.b;
            if (m0aVar != null) {
                m0aVar.i(true);
            }
            y0a y0aVar = this.c;
            if (y0aVar != null && y0aVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.u0a
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            m0a m0aVar = this.b;
            if (m0aVar != null && m0aVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3f);
                m0a m0aVar2 = this.b;
                if (m0aVar2 != null) {
                    m0aVar2.g(i, str2);
                }
            } else {
                m0a m0aVar3 = this.b;
                if (m0aVar3 != null) {
                    m0aVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        y0a y0aVar = new y0a(this.a.getActivity());
                        this.c = y0aVar;
                        y0aVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                m0a m0aVar4 = this.b;
                if (m0aVar4 != null) {
                    m0aVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.z0a.c
    public void onGenFilterVideoFail(int i, String str) {
        m0a m0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (m0aVar = this.b) != null) {
            m0aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.z0a.c
    public void onGenFilterVideoRecordError(int i, String str) {
        m0a m0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (m0aVar = this.b) != null) {
            m0aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.z0a.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            m0a m0aVar = this.b;
            if (m0aVar != null) {
                m0aVar.e();
            }
            a(str);
        }
    }
}
