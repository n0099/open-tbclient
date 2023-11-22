package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.w1b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class j2b implements r1b, w1b.c, yp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public j1b b;
    public v1b c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.r1b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public j2b(j1b j1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = j1bVar;
        this.a = j1bVar.a;
    }

    public final void a(String str) {
        j1b j1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || (j1bVar = this.b) == null) {
            return;
        }
        if (j1bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        j1b j1bVar2 = this.b;
        if (j1bVar2 != null) {
            j1bVar2.f(videoInfo);
        }
    }

    @Override // com.baidu.tieba.r1b
    public void A0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            j1b j1bVar = this.b;
            if (j1bVar != null && j1bVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ccd);
                j1b j1bVar2 = this.b;
                if (j1bVar2 != null) {
                    j1bVar2.g(i, str2);
                }
            } else {
                j1b j1bVar3 = this.b;
                if (j1bVar3 != null) {
                    j1bVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        v1b v1bVar = new v1b(this.a.getActivity());
                        this.c = v1bVar;
                        v1bVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                j1b j1bVar4 = this.b;
                if (j1bVar4 != null) {
                    j1bVar4.e();
                }
                a(str);
            }
        }
    }

    public void b() {
        j1b j1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (j1bVar = this.b) == null) {
            return;
        }
        if (j1bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            j1b j1bVar2 = this.b;
            if (!j1bVar2.e) {
                A0(j1bVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        j1b j1bVar3 = this.b;
        selectMusicModel.R(j1bVar3.b, j1bVar3.d, k1b.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !j1bVar3.e);
    }

    @Override // com.baidu.tieba.yp6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j1b j1bVar = this.b;
            if (j1bVar != null) {
                j1bVar.i(true);
            }
            v1b v1bVar = this.c;
            if (v1bVar != null && v1bVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.w1b.c
    public void onGenFilterVideoFail(int i, String str) {
        j1b j1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (j1bVar = this.b) != null) {
            j1bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.w1b.c
    public void onGenFilterVideoRecordError(int i, String str) {
        j1b j1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (j1bVar = this.b) != null) {
            j1bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.w1b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            j1b j1bVar = this.b;
            if (j1bVar != null) {
                j1bVar.e();
            }
            a(str);
        }
    }
}
