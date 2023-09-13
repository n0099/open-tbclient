package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.wra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class jsa implements rra, wra.c, st6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public jra b;
    public vra c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.rra
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public jsa(jra jraVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jraVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = jraVar;
        this.a = jraVar.a;
    }

    public final void a(String str) {
        jra jraVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (jraVar = this.b) == null) {
            return;
        }
        if (jraVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        jra jraVar2 = this.b;
        if (jraVar2 != null) {
            jraVar2.f(videoInfo);
        }
    }

    public void b() {
        jra jraVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (jraVar = this.b) == null) {
            return;
        }
        if (jraVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            jra jraVar2 = this.b;
            if (!jraVar2.e) {
                e1(jraVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        jra jraVar3 = this.b;
        selectMusicModel.P(jraVar3.b, jraVar3.d, kra.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !jraVar3.e);
    }

    @Override // com.baidu.tieba.st6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jra jraVar = this.b;
            if (jraVar != null) {
                jraVar.i(true);
            }
            vra vraVar = this.c;
            if (vraVar != null && vraVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.rra
    public void e1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            jra jraVar = this.b;
            if (jraVar != null && jraVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0cac);
                jra jraVar2 = this.b;
                if (jraVar2 != null) {
                    jraVar2.g(i, str2);
                }
            } else {
                jra jraVar3 = this.b;
                if (jraVar3 != null) {
                    jraVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        vra vraVar = new vra(this.a.getActivity());
                        this.c = vraVar;
                        vraVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                jra jraVar4 = this.b;
                if (jraVar4 != null) {
                    jraVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.wra.c
    public void onGenFilterVideoFail(int i, String str) {
        jra jraVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (jraVar = this.b) != null) {
            jraVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.wra.c
    public void onGenFilterVideoRecordError(int i, String str) {
        jra jraVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (jraVar = this.b) != null) {
            jraVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.wra.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            jra jraVar = this.b;
            if (jraVar != null) {
                jraVar.e();
            }
            a(str);
        }
    }
}
