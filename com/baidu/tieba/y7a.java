package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.l7a;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes8.dex */
public class y7a implements g7a, l7a.c, gr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public y6a b;
    public k7a c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.g7a
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public y7a(y6a y6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y6aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = y6aVar;
        this.a = y6aVar.a;
    }

    public final void a(String str) {
        y6a y6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (y6aVar = this.b) == null) {
            return;
        }
        if (y6aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        y6a y6aVar2 = this.b;
        if (y6aVar2 != null) {
            y6aVar2.f(videoInfo);
        }
    }

    public void b() {
        y6a y6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (y6aVar = this.b) == null) {
            return;
        }
        if (y6aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            y6a y6aVar2 = this.b;
            if (!y6aVar2.e) {
                o1(y6aVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        y6a y6aVar3 = this.b;
        selectMusicModel.X(y6aVar3.b, y6aVar3.d, z6a.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !y6aVar3.e);
    }

    @Override // com.baidu.tieba.gr6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            y6a y6aVar = this.b;
            if (y6aVar != null) {
                y6aVar.i(true);
            }
            k7a k7aVar = this.c;
            if (k7aVar != null && k7aVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.g7a
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            y6a y6aVar = this.b;
            if (y6aVar != null && y6aVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c78);
                y6a y6aVar2 = this.b;
                if (y6aVar2 != null) {
                    y6aVar2.g(i, str2);
                }
            } else {
                y6a y6aVar3 = this.b;
                if (y6aVar3 != null) {
                    y6aVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        k7a k7aVar = new k7a(this.a.getActivity());
                        this.c = k7aVar;
                        k7aVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                y6a y6aVar4 = this.b;
                if (y6aVar4 != null) {
                    y6aVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.l7a.c
    public void onGenFilterVideoFail(int i, String str) {
        y6a y6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (y6aVar = this.b) != null) {
            y6aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.l7a.c
    public void onGenFilterVideoRecordError(int i, String str) {
        y6a y6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (y6aVar = this.b) != null) {
            y6aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.l7a.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            y6a y6aVar = this.b;
            if (y6aVar != null) {
                y6aVar.e();
            }
            a(str);
        }
    }
}
