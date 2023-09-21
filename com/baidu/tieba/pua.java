package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.cua;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes7.dex */
public class pua implements xta, cua.c, yt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public pta b;
    public bua c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.xta
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public pua(pta ptaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ptaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ptaVar;
        this.a = ptaVar.a;
    }

    public final void a(String str) {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || (ptaVar = this.b) == null) {
            return;
        }
        if (ptaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        pta ptaVar2 = this.b;
        if (ptaVar2 != null) {
            ptaVar2.f(videoInfo);
        }
    }

    @Override // com.baidu.tieba.xta
    public void C0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            pta ptaVar = this.b;
            if (ptaVar != null && ptaVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0cae);
                pta ptaVar2 = this.b;
                if (ptaVar2 != null) {
                    ptaVar2.g(i, str2);
                }
            } else {
                pta ptaVar3 = this.b;
                if (ptaVar3 != null) {
                    ptaVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        bua buaVar = new bua(this.a.getActivity());
                        this.c = buaVar;
                        buaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                pta ptaVar4 = this.b;
                if (ptaVar4 != null) {
                    ptaVar4.e();
                }
                a(str);
            }
        }
    }

    public void b() {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (ptaVar = this.b) == null) {
            return;
        }
        if (ptaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            pta ptaVar2 = this.b;
            if (!ptaVar2.e) {
                C0(ptaVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        pta ptaVar3 = this.b;
        selectMusicModel.P(ptaVar3.b, ptaVar3.d, qta.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !ptaVar3.e);
    }

    @Override // com.baidu.tieba.yt6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pta ptaVar = this.b;
            if (ptaVar != null) {
                ptaVar.i(true);
            }
            bua buaVar = this.c;
            if (buaVar != null && buaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.cua.c
    public void onGenFilterVideoFail(int i, String str) {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (ptaVar = this.b) != null) {
            ptaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.cua.c
    public void onGenFilterVideoRecordError(int i, String str) {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (ptaVar = this.b) != null) {
            ptaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.cua.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            pta ptaVar = this.b;
            if (ptaVar != null) {
                ptaVar.e();
            }
            a(str);
        }
    }
}
