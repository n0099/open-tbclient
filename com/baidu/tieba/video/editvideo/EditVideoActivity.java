package com.baidu.tieba.video.editvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.dsa;
import com.baidu.tieba.esa;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.fsa;
import com.baidu.tieba.hc9;
import com.baidu.tieba.isa;
import com.baidu.tieba.jra;
import com.baidu.tieba.jsa;
import com.baidu.tieba.kra;
import com.baidu.tieba.lc9;
import com.baidu.tieba.qra;
import com.baidu.tieba.rra;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.tieba.vra;
import com.baidu.tieba.xra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class EditVideoActivity extends BaseActivity implements qra, rra, MaskVideoView.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public FrsTabInfoData c;
    public String d;
    public VideoInfo e;
    public VideoTitleData f;
    public List<VideoTitleData> g;
    public isa h;
    public SelectCoverModel i;
    public SelectMusicModel j;
    public String k;
    public boolean l;
    public boolean m;
    public BlueCircleProgressDialog n;
    public vra o;
    public String p;
    public int q;
    public String r;
    public String s;
    public hc9 t;
    public jsa u;
    public jra v;
    public HttpMessageListener w;
    public CustomMessageListener x;

    @Override // com.baidu.tieba.rra
    public void e1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.qra
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EditVideoActivity editVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editVideoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof ResponseGetVideoActivityMessage)) {
                return;
            }
            ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
            if (httpResponsedMessage.getError() == 0) {
                this.a.f = responseGetVideoActivityMessage.getVideoTitleData();
                this.a.g = responseGetVideoActivityMessage.getAllVideoTitleList();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends jra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditVideoActivity i;

        @Override // com.baidu.tieba.jra
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EditVideoActivity editVideoActivity, BaseActivity baseActivity, String str, String str2) {
            super(baseActivity, str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editVideoActivity, baseActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((BaseActivity) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = editVideoActivity;
        }

        @Override // com.baidu.tieba.jra
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.c();
                this.i.A1();
            }
        }

        @Override // com.baidu.tieba.jra
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.i.h.d0();
                this.i.h.e0();
                this.i.h.Q().q();
            }
        }

        @Override // com.baidu.tieba.jra
        public void d(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                super.d(i, str);
                this.i.A1();
            }
        }

        @Override // com.baidu.tieba.jra
        public void g(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                super.g(i, str);
                this.i.A1();
            }
        }

        @Override // com.baidu.tieba.jra
        public void f(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoInfo) == null) {
                super.f(videoInfo);
                if (!this.i.l) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = kra.g + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str);
                    }
                    this.i.G1(str);
                    this.i.d();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EditVideoActivity editVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editVideoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            this.a.d();
        }
    }

    public EditVideoActivity() {
        lc9 lc9Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lc9.class);
        if (runTask != null) {
            lc9Var = (lc9) runTask.getData();
        } else {
            lc9Var = null;
        }
        if (lc9Var != null) {
            this.t = lc9Var.get();
        }
        this.w = new a(this, CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        this.x = new c(this, 2001374);
    }

    public final void D1() {
        VideoInfo videoInfo;
        isa isaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (videoInfo = this.e) != null && videoInfo.getEditVideoData() != null && (isaVar = this.h) != null) {
            dsa M = isaVar.M(this.e.getEditVideoData().filterName);
            if (M != null) {
                vra vraVar = this.o;
                if (vraVar != null) {
                    vraVar.h(M);
                }
                this.h.q0(M);
            }
            this.h.p0(this.e.getEditVideoData().musicPath, this.e.getEditVideoData().musicId);
            this.h.r0(!this.e.getEditVideoData().isMute);
        }
    }

    @Override // com.baidu.tieba.qra
    public void onNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.h != null && this.i != null && this.j != null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    getPageContext().showToast(R.string.no_network);
                    return;
                } else if (this.l) {
                    return;
                } else {
                    this.l = true;
                    this.m = false;
                    jsa jsaVar = this.u;
                    if (jsaVar != null) {
                        jsaVar.cancel();
                    }
                    this.k = null;
                    this.h.b0();
                    this.n.setDialogVisiable(true);
                    C1();
                    return;
                }
            }
            A1();
            this.l = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            isa isaVar = this.h;
            if (isaVar != null) {
                isaVar.b0();
                this.h.d0();
                this.h.e0();
                this.h.Q().q();
            }
            if (this.o.f()) {
                this.o.e();
            }
            this.l = false;
            this.m = true;
            jsa jsaVar = this.u;
            if (jsaVar != null) {
                jsaVar.cancel();
            }
            w1();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
    public void k0(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, bitmap, z) == null) {
            z1(bitmap);
        }
    }

    public final void E1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                new MediaScannerClient(this).saveImage(str);
                xra.c(this, str);
            } catch (Exception unused) {
                A1();
                this.l = false;
            }
        }
    }

    public final void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                new MediaScannerClient(this).saveVideo(str);
                xra.c(this, str);
            } catch (Exception unused) {
                A1();
                this.l = false;
            }
        }
    }

    @Override // com.baidu.tieba.qra
    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (this.m) {
                this.m = false;
            } else if (this.l) {
                showToast(str);
                A1();
                this.l = false;
            }
        }
    }

    @Override // com.baidu.tieba.qra
    public void d1(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bitmap) == null) {
            this.h.Q().o(bitmap);
        }
    }

    @Override // com.baidu.tieba.qra
    public void q(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            this.h.n0(list);
        }
    }

    public final void A1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (blueCircleProgressDialog = this.n) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tieba.qra
    public void J() {
        SelectCoverModel selectCoverModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            isa isaVar = this.h;
            if (isaVar != null && (selectCoverModel = this.i) != null) {
                if (this.m) {
                    this.m = false;
                    return;
                } else {
                    selectCoverModel.S(this.d, isaVar.getCurrentPosition());
                    return;
                }
            }
            A1();
            this.l = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        isa isaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (isaVar = this.h) != null) {
            isaVar.s0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            isa isaVar = this.h;
            if (isaVar != null) {
                isaVar.f0();
            }
            SelectCoverModel selectCoverModel = this.i;
            if (selectCoverModel != null) {
                selectCoverModel.cancelLoadData();
            }
            SelectMusicModel selectMusicModel = this.j;
            if (selectMusicModel != null) {
                selectMusicModel.cancelLoadData();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onRestart();
            esa.g().d();
            fsa.g().d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            isa isaVar = this.h;
            if (isaVar != null) {
                isaVar.c0();
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            jsa jsaVar = this.u;
            if (jsaVar != null) {
                jsaVar.cancel();
            }
            this.m = true;
            this.k = null;
            A1();
        }
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
            if (!StringUtils.isNull(this.a)) {
                httpMessage.addParam("forum_id", this.a);
            }
            sendMessage(httpMessage);
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
            tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.m) {
                this.m = false;
                return;
            }
            String P = this.h.P();
            if (TextUtils.isEmpty(P)) {
                this.i.S(this.d, this.h.getCurrentPosition());
            } else {
                this.i.O(P);
            }
        }
    }

    @Override // com.baidu.tieba.qra
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            A1();
            this.l = false;
            jsa jsaVar = this.u;
            if (jsaVar != null) {
                jsaVar.cancel();
            }
            isa isaVar = this.h;
            if (isaVar != null && isaVar.Q() != null) {
                this.h.Q().pause();
                this.h.Q().q();
            }
            setResult(-1);
            finish();
        }
    }

    @Override // com.baidu.tieba.qra
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m = false;
            this.l = false;
            this.v.i(false);
            jra jraVar = this.v;
            jraVar.c = this.k;
            jraVar.b = this.d;
            jraVar.d = this.h.N();
            this.v.e = this.h.W();
            this.v.f = this.o.b();
            this.u.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    /* JADX WARN: Type inference failed for: r7v13 */
    @Override // com.baidu.tieba.qra
    public void Z(String str) {
        String str2;
        PostPrefixData postPrefixData;
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.m) {
                this.m = false;
                return;
            }
            this.k = str;
            E1(str);
            A1();
            String str3 = "";
            AntiData antiData2 = null;
            if (getIntent() == null) {
                str2 = "";
                postPrefixData = null;
            } else {
                Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    antiData = (AntiData) serializableExtra;
                } else {
                    antiData = null;
                }
                Serializable serializableExtra2 = getIntent().getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                if (serializableExtra2 instanceof PostPrefixData) {
                    antiData2 = (PostPrefixData) serializableExtra2;
                }
                str3 = getIntent().getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                str2 = getIntent().getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                AntiData antiData3 = antiData2;
                antiData2 = antiData;
                postPrefixData = antiData3;
            }
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            EditVideoData editVideoData = new EditVideoData();
            editVideoData.coverPath = this.k;
            editVideoData.originPath = this.d;
            editVideoData.musicPath = this.h.N();
            editVideoData.musicId = this.h.L();
            editVideoData.isMute = this.h.W();
            editVideoData.filterName = this.o.b();
            this.e.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.r).setCallFrom(this.p).setStatisticFrom(this.q).setForumId(this.a).setForumName(this.b).setAntiData(antiData2).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.c).setVideoInfo(this.e);
            videoInfo.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            videoInfo.getIntent().setFlags(67108864);
            videoInfo.send();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            if (i2 == -1) {
                if (i == 25032) {
                    String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_RESOURCE);
                    String stringExtra2 = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        String f = esa.g().f(stringExtra);
                        if (this.h != null && !TextUtils.isEmpty(f)) {
                            this.h.a0(f, stringExtra2);
                        }
                    }
                }
            } else if (i2 == 100) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            BDLayoutMode layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.h.O());
            isa isaVar = this.h;
            if (isaVar != null) {
                isaVar.Z(getPageContext(), i);
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                VideoInfo videoInfo = (VideoInfo) serializableExtra;
                this.e = videoInfo;
                String videoPath = videoInfo.getVideoPath();
                this.d = videoPath;
                this.v.b = videoPath;
            }
            this.h.i0(this.d);
            D1();
            this.s = getIntent().getStringExtra("from_type");
        }
    }

    public final void z1(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bitmap) == null) {
            isa isaVar = this.h;
            if (isaVar != null && this.i != null) {
                if (this.m) {
                    this.m = false;
                    return;
                }
                if (!TextUtils.isEmpty(isaVar.P())) {
                    bitmap = this.h.J(bitmap);
                }
                if (bitmap != null) {
                    this.i.Q(bitmap, kra.b);
                    return;
                }
                return;
            }
            A1();
            this.l = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0035);
            this.a = getIntent().getStringExtra("forum_id");
            getIntent().getIntExtra(BaseWriteConfig.KEY_WRITE_LEVEL, -1);
            this.b = getIntent().getStringExtra("forum_name");
            getIntent().getStringExtra("video_title");
            this.p = getIntent().getStringExtra(BaseWriteConfig.KEY_CALL_FROM);
            this.q = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.s = getIntent().getStringExtra("from_type");
            this.r = getIntent().getStringExtra("from");
            Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                VideoInfo videoInfo = (VideoInfo) serializableExtra;
                this.e = videoInfo;
                this.d = videoInfo.getVideoPath();
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.c = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!TextUtils.isEmpty(this.d) && !new File(this.d).exists()) {
                d();
            }
            new File(kra.g).mkdirs();
            this.i = new SelectCoverModel(getPageContext(), this, this.t);
            this.j = new SelectMusicModel(getPageContext(), this);
            this.o = new vra(this);
            isa isaVar = new isa(getPageContext(), this, findViewById(R.id.root_layout), this.t);
            this.h = isaVar;
            isaVar.i0(this.d);
            this.h.o0(getIntent());
            this.h.j0(this.o);
            this.h.k0(this);
            this.i.P();
            this.j.N();
            BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(getPageContext());
            this.n = blueCircleProgressDialog;
            blueCircleProgressDialog.setTipString(R.string.obfuscated_res_0x7f0f0cab);
            registerListener(this.x);
            B1();
            registerListener(this.w);
            y1();
            TiebaStatic.log("c12303");
            b bVar = new b(this, this, this.d, this.k);
            this.v = bVar;
            this.u = new jsa(bVar);
            D1();
        }
    }

    @Override // com.baidu.tieba.rra
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(0, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0d13)));
            list.add(1, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0d11)));
            this.h.l0(list);
        }
    }
}
