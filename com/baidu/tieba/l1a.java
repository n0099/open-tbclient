package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.y0a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class l1a implements t0a, y0a.c, um6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public l0a b;
    public x0a c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.t0a
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public l1a(l0a l0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = l0aVar;
        this.a = l0aVar.a;
    }

    public final void a(String str) {
        l0a l0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (l0aVar = this.b) == null) {
            return;
        }
        if (l0aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        l0a l0aVar2 = this.b;
        if (l0aVar2 != null) {
            l0aVar2.f(videoInfo);
        }
    }

    public void b() {
        l0a l0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (l0aVar = this.b) == null) {
            return;
        }
        if (l0aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            l0a l0aVar2 = this.b;
            if (!l0aVar2.e) {
                o1(l0aVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        l0a l0aVar3 = this.b;
        selectMusicModel.X(l0aVar3.b, l0aVar3.d, m0a.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !l0aVar3.e);
    }

    @Override // com.baidu.tieba.um6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l0a l0aVar = this.b;
            if (l0aVar != null) {
                l0aVar.i(true);
            }
            x0a x0aVar = this.c;
            if (x0aVar != null && x0aVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.t0a
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            l0a l0aVar = this.b;
            if (l0aVar != null && l0aVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3f);
                l0a l0aVar2 = this.b;
                if (l0aVar2 != null) {
                    l0aVar2.g(i, str2);
                }
            } else {
                l0a l0aVar3 = this.b;
                if (l0aVar3 != null) {
                    l0aVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        x0a x0aVar = new x0a(this.a.getActivity());
                        this.c = x0aVar;
                        x0aVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                l0a l0aVar4 = this.b;
                if (l0aVar4 != null) {
                    l0aVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.y0a.c
    public void onGenFilterVideoFail(int i, String str) {
        l0a l0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (l0aVar = this.b) != null) {
            l0aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.y0a.c
    public void onGenFilterVideoRecordError(int i, String str) {
        l0a l0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (l0aVar = this.b) != null) {
            l0aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.y0a.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            l0a l0aVar = this.b;
            if (l0aVar != null) {
                l0aVar.e();
            }
            a(str);
        }
    }
}
