package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.h9a;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes8.dex */
public class u9a implements c9a, h9a.c, nr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public u8a b;
    public g9a c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.c9a
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public u9a(u8a u8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u8aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = u8aVar;
        this.a = u8aVar.a;
    }

    public final void a(String str) {
        u8a u8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (u8aVar = this.b) == null) {
            return;
        }
        if (u8aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        u8a u8aVar2 = this.b;
        if (u8aVar2 != null) {
            u8aVar2.f(videoInfo);
        }
    }

    public void b() {
        u8a u8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (u8aVar = this.b) == null) {
            return;
        }
        if (u8aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            u8a u8aVar2 = this.b;
            if (!u8aVar2.e) {
                o1(u8aVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        u8a u8aVar3 = this.b;
        selectMusicModel.X(u8aVar3.b, u8aVar3.d, v8a.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !u8aVar3.e);
    }

    @Override // com.baidu.tieba.nr6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u8a u8aVar = this.b;
            if (u8aVar != null) {
                u8aVar.i(true);
            }
            g9a g9aVar = this.c;
            if (g9aVar != null && g9aVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            u8a u8aVar = this.b;
            if (u8aVar != null && u8aVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c7c);
                u8a u8aVar2 = this.b;
                if (u8aVar2 != null) {
                    u8aVar2.g(i, str2);
                }
            } else {
                u8a u8aVar3 = this.b;
                if (u8aVar3 != null) {
                    u8aVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        g9a g9aVar = new g9a(this.a.getActivity());
                        this.c = g9aVar;
                        g9aVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                u8a u8aVar4 = this.b;
                if (u8aVar4 != null) {
                    u8aVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.h9a.c
    public void onGenFilterVideoFail(int i, String str) {
        u8a u8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (u8aVar = this.b) != null) {
            u8aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.h9a.c
    public void onGenFilterVideoRecordError(int i, String str) {
        u8a u8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (u8aVar = this.b) != null) {
            u8aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.h9a.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            u8a u8aVar = this.b;
            if (u8aVar != null) {
                u8aVar.e();
            }
            a(str);
        }
    }
}
