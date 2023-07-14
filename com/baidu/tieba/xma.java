package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.kma;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes8.dex */
public class xma implements fma, kma.c, xt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public xla b;
    public jma c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.fma
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public xma(xla xlaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xlaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = xlaVar;
        this.a = xlaVar.a;
    }

    public final void a(String str) {
        xla xlaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (xlaVar = this.b) == null) {
            return;
        }
        if (xlaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        xla xlaVar2 = this.b;
        if (xlaVar2 != null) {
            xlaVar2.f(videoInfo);
        }
    }

    public void b() {
        xla xlaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (xlaVar = this.b) == null) {
            return;
        }
        if (xlaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            xla xlaVar2 = this.b;
            if (!xlaVar2.e) {
                l1(xlaVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        xla xlaVar3 = this.b;
        selectMusicModel.Y(xlaVar3.b, xlaVar3.d, yla.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !xlaVar3.e);
    }

    @Override // com.baidu.tieba.xt6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xla xlaVar = this.b;
            if (xlaVar != null) {
                xlaVar.i(true);
            }
            jma jmaVar = this.c;
            if (jmaVar != null && jmaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.fma
    public void l1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            xla xlaVar = this.b;
            if (xlaVar != null && xlaVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c8d);
                xla xlaVar2 = this.b;
                if (xlaVar2 != null) {
                    xlaVar2.g(i, str2);
                }
            } else {
                xla xlaVar3 = this.b;
                if (xlaVar3 != null) {
                    xlaVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        jma jmaVar = new jma(this.a.getActivity());
                        this.c = jmaVar;
                        jmaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                xla xlaVar4 = this.b;
                if (xlaVar4 != null) {
                    xlaVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.kma.c
    public void onGenFilterVideoFail(int i, String str) {
        xla xlaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (xlaVar = this.b) != null) {
            xlaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.kma.c
    public void onGenFilterVideoRecordError(int i, String str) {
        xla xlaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (xlaVar = this.b) != null) {
            xlaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.kma.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            xla xlaVar = this.b;
            if (xlaVar != null) {
                xlaVar.e();
            }
            a(str);
        }
    }
}
