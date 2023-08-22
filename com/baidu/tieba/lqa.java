package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.ypa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes7.dex */
public class lqa implements tpa, ypa.c, os6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public lpa b;
    public xpa c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.tpa
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public lqa(lpa lpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lpaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = lpaVar;
        this.a = lpaVar.a;
    }

    public final void a(String str) {
        lpa lpaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (lpaVar = this.b) == null) {
            return;
        }
        if (lpaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        lpa lpaVar2 = this.b;
        if (lpaVar2 != null) {
            lpaVar2.f(videoInfo);
        }
    }

    public void b() {
        lpa lpaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (lpaVar = this.b) == null) {
            return;
        }
        if (lpaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            lpa lpaVar2 = this.b;
            if (!lpaVar2.e) {
                j1(lpaVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        lpa lpaVar3 = this.b;
        selectMusicModel.Q(lpaVar3.b, lpaVar3.d, mpa.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !lpaVar3.e);
    }

    @Override // com.baidu.tieba.os6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            lpa lpaVar = this.b;
            if (lpaVar != null) {
                lpaVar.i(true);
            }
            xpa xpaVar = this.c;
            if (xpaVar != null && xpaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.tpa
    public void j1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            lpa lpaVar = this.b;
            if (lpaVar != null && lpaVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c97);
                lpa lpaVar2 = this.b;
                if (lpaVar2 != null) {
                    lpaVar2.g(i, str2);
                }
            } else {
                lpa lpaVar3 = this.b;
                if (lpaVar3 != null) {
                    lpaVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        xpa xpaVar = new xpa(this.a.getActivity());
                        this.c = xpaVar;
                        xpaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                lpa lpaVar4 = this.b;
                if (lpaVar4 != null) {
                    lpaVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ypa.c
    public void onGenFilterVideoFail(int i, String str) {
        lpa lpaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (lpaVar = this.b) != null) {
            lpaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.ypa.c
    public void onGenFilterVideoRecordError(int i, String str) {
        lpa lpaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (lpaVar = this.b) != null) {
            lpaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.ypa.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            lpa lpaVar = this.b;
            if (lpaVar != null) {
                lpaVar.e();
            }
            a(str);
        }
    }
}
