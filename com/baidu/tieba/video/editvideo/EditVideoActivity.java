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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import com.repackage.au4;
import com.repackage.eq8;
import com.repackage.fq8;
import com.repackage.jq8;
import com.repackage.kl7;
import com.repackage.lq8;
import com.repackage.ni;
import com.repackage.ol7;
import com.repackage.rq8;
import com.repackage.sq8;
import com.repackage.tq8;
import com.repackage.wq8;
import com.repackage.xp8;
import com.repackage.xq8;
import com.repackage.yp8;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EditVideoActivity extends BaseActivity implements eq8, fq8, MaskVideoView.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public FrsTabInfoData c;
    public String d;
    public VideoInfo e;
    public VideoTitleData f;
    public List<VideoTitleData> g;
    public wq8 h;
    public SelectCoverModel i;
    public SelectMusicModel j;
    public String k;
    public boolean l;
    public boolean m;
    public au4 n;
    public jq8 o;
    public String p;
    public int q;
    public String r;
    public String s;
    public kl7 t;
    public xq8 u;
    public xp8 v;
    public HttpMessageListener w;
    public CustomMessageListener x;

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetVideoActivityMessage)) {
                ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    this.a.f = responseGetVideoActivityMessage.getVideoTitleData();
                    this.a.g = responseGetVideoActivityMessage.getAllVideoTitleList();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends xp8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditVideoActivity i;

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

        @Override // com.repackage.xp8
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.c();
                this.i.K1();
            }
        }

        @Override // com.repackage.xp8
        public void d(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                super.d(i, str);
                this.i.K1();
            }
        }

        @Override // com.repackage.xp8
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.xp8
        public void f(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoInfo) == null) {
                super.f(videoInfo);
                if (this.i.l) {
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = yp8.g + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str);
                }
                this.i.P1(str);
                this.i.g();
            }
        }

        @Override // com.repackage.xp8
        public void g(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                super.g(i, str);
                this.i.K1();
            }
        }

        @Override // com.repackage.xp8
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.i.h.N();
                this.i.h.O();
                this.i.h.A().z();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.a.g();
            }
        }
    }

    public EditVideoActivity() {
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ol7.class);
        ol7 ol7Var = runTask != null ? (ol7) runTask.getData() : null;
        if (ol7Var != null) {
            this.t = ol7Var.get();
        }
        this.w = new a(this, CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        this.x = new c(this, 2001374);
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xq8 xq8Var = this.u;
            if (xq8Var != null) {
                xq8Var.cancel();
            }
            this.m = true;
            this.k = null;
            K1();
        }
    }

    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
            if (!StringUtils.isNull(this.a)) {
                httpMessage.addParam("forum_id", this.a);
            }
            sendMessage(httpMessage);
        }
    }

    public final void J1(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
            wq8 wq8Var = this.h;
            if (wq8Var != null && this.i != null) {
                if (this.m) {
                    this.m = false;
                    return;
                }
                if (!TextUtils.isEmpty(wq8Var.z())) {
                    bitmap = this.h.t(bitmap);
                }
                if (bitmap != null) {
                    this.i.E(bitmap, yp8.b);
                    return;
                }
                return;
            }
            K1();
            this.l = false;
        }
    }

    public final void K1() {
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (au4Var = this.n) == null) {
            return;
        }
        au4Var.h(false);
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
            tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.m) {
                this.m = false;
                return;
            }
            String z = this.h.z();
            if (TextUtils.isEmpty(z)) {
                this.i.G(this.d, this.h.getCurrentPosition());
            } else {
                this.i.C(z);
            }
        }
    }

    public final void N1() {
        VideoInfo videoInfo;
        wq8 wq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (videoInfo = this.e) == null || videoInfo.getEditVideoData() == null || (wq8Var = this.h) == null) {
            return;
        }
        rq8 w = wq8Var.w(this.e.getEditVideoData().filterName);
        if (w != null) {
            jq8 jq8Var = this.o;
            if (jq8Var != null) {
                jq8Var.h(w);
            }
            this.h.a0(w);
        }
        this.h.Z(this.e.getEditVideoData().musicPath, this.e.getEditVideoData().musicId);
        this.h.b0(!this.e.getEditVideoData().isMute);
    }

    public final void O1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                new MediaScannerClient(this).saveImage(str);
                lq8.c(this, str);
            } catch (Exception unused) {
                K1();
                this.l = false;
            }
        }
    }

    public final void P1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                new MediaScannerClient(this).saveVideo(str);
                lq8.c(this, str);
            } catch (Exception unused) {
                K1();
                this.l = false;
            }
        }
    }

    @Override // com.repackage.eq8
    public void a0() {
        SelectCoverModel selectCoverModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            wq8 wq8Var = this.h;
            if (wq8Var != null && (selectCoverModel = this.i) != null) {
                if (this.m) {
                    this.m = false;
                    return;
                } else {
                    selectCoverModel.G(this.d, wq8Var.getCurrentPosition());
                    return;
                }
            }
            K1();
            this.l = false;
        }
    }

    @Override // com.repackage.eq8
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            K1();
            this.l = false;
            xq8 xq8Var = this.u;
            if (xq8Var != null) {
                xq8Var.cancel();
            }
            wq8 wq8Var = this.h;
            if (wq8Var != null && wq8Var.A() != null) {
                this.h.A().pause();
                this.h.A().z();
            }
            setResult(-1);
            finish();
        }
    }

    @Override // com.repackage.eq8
    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (this.m) {
                this.m = false;
            } else if (this.l) {
                showToast(str);
                K1();
                this.l = false;
            }
        }
    }

    @Override // com.repackage.eq8
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m = false;
            this.l = false;
            this.v.i(false);
            xp8 xp8Var = this.v;
            xp8Var.c = this.k;
            xp8Var.b = this.d;
            xp8Var.d = this.h.x();
            this.v.e = this.h.F();
            this.v.f = this.o.b();
            this.u.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            if (i2 != -1) {
                if (i2 == 100) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                    finish();
                }
            } else if (i == 25032) {
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_RESOURCE);
                String stringExtra2 = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                String f = sq8.g().f(stringExtra);
                if (this.h == null || TextUtils.isEmpty(f)) {
                    return;
                }
                this.h.J(f, stringExtra2);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        wq8 wq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (wq8Var = this.h) == null) {
            return;
        }
        wq8Var.d0();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.h.y());
            wq8 wq8Var = this.h;
            if (wq8Var != null) {
                wq8Var.I(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0034);
            this.a = getIntent().getStringExtra("forum_id");
            getIntent().getIntExtra(BaseWriteConfig.KEY_WRITE_LEVEL, -1);
            getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
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
                g();
            }
            new File(yp8.g).mkdirs();
            this.i = new SelectCoverModel(getPageContext(), this, this.t);
            this.j = new SelectMusicModel(getPageContext(), this);
            this.o = new jq8(this);
            wq8 wq8Var = new wq8(getPageContext(), this, findViewById(R.id.obfuscated_res_0x7f091b6a), this.t);
            this.h = wq8Var;
            wq8Var.S(this.d);
            this.h.Y(getIntent());
            this.h.T(this.o);
            this.h.U(this);
            this.i.D();
            this.j.B();
            au4 au4Var = new au4(getPageContext());
            this.n = au4Var;
            au4Var.i(R.string.obfuscated_res_0x7f0f0ace);
            registerListener(this.x);
            L1();
            registerListener(this.w);
            I1();
            TiebaStatic.log("c12303");
            b bVar = new b(this, this, this.d, this.k);
            this.v = bVar;
            this.u = new xq8(bVar);
            N1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            wq8 wq8Var = this.h;
            if (wq8Var != null) {
                wq8Var.P();
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
            this.h.S(this.d);
            N1();
            this.s = getIntent().getStringExtra("from_type");
        }
    }

    @Override // com.repackage.eq8
    public void onNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.h != null && this.i != null && this.j != null) {
                if (!ni.z()) {
                    getPageContext().showToast(R.string.obfuscated_res_0x7f0f0c63);
                    return;
                } else if (this.l) {
                    return;
                } else {
                    this.l = true;
                    this.m = false;
                    xq8 xq8Var = this.u;
                    if (xq8Var != null) {
                        xq8Var.cancel();
                    }
                    this.k = null;
                    this.h.L();
                    this.n.h(true);
                    M1();
                    return;
                }
            }
            K1();
            this.l = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            wq8 wq8Var = this.h;
            if (wq8Var != null) {
                wq8Var.L();
                this.h.N();
                this.h.O();
                this.h.A().z();
            }
            if (this.o.f()) {
                this.o.e();
            }
            this.l = false;
            this.m = true;
            xq8 xq8Var = this.u;
            if (xq8Var != null) {
                xq8Var.cancel();
            }
            G1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onRestart();
            sq8.g().d();
            tq8.g().d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            wq8 wq8Var = this.h;
            if (wq8Var != null) {
                wq8Var.M();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    /* JADX WARN: Type inference failed for: r7v13 */
    @Override // com.repackage.eq8
    public void q0(String str) {
        String str2;
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (this.m) {
                this.m = false;
                return;
            }
            this.k = str;
            O1(str);
            K1();
            String str3 = "";
            if (getIntent() != null) {
                Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
                AntiData antiData = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
                r1 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                str3 = getIntent().getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                str2 = getIntent().getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                AntiData antiData2 = r1;
                r1 = antiData;
                postPrefixData = antiData2;
            } else {
                str2 = "";
                postPrefixData = null;
            }
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            EditVideoData editVideoData = new EditVideoData();
            editVideoData.coverPath = this.k;
            editVideoData.originPath = this.d;
            editVideoData.musicPath = this.h.x();
            editVideoData.musicId = this.h.v();
            editVideoData.isMute = this.h.F();
            editVideoData.filterName = this.o.b();
            this.e.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.r).setCallFrom(this.p).setStatisticFrom(this.q).setForumId(this.a).setForumName(this.b).setAntiData(r1).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.c).setVideoInfo(this.e);
            videoInfo.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            videoInfo.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            videoInfo.send();
        }
    }

    @Override // com.repackage.eq8
    public void q1(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bitmap) == null) {
            this.h.A().x(bitmap);
        }
    }

    @Override // com.repackage.fq8
    public void r1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048602, this, str, i, str2) == null) {
        }
    }

    @Override // com.repackage.fq8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(0, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0b1a)));
            list.add(1, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0b18)));
            this.h.V(list);
        }
    }

    @Override // com.repackage.eq8
    public void t(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            this.h.X(list);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
    public void w0(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048605, this, bitmap, z) == null) {
            J1(bitmap);
        }
    }

    @Override // com.repackage.eq8
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }
}
