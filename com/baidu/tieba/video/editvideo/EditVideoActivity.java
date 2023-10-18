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
import com.baidu.tieba.bpa;
import com.baidu.tieba.cpa;
import com.baidu.tieba.dpa;
import com.baidu.tieba.f89;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.gpa;
import com.baidu.tieba.hoa;
import com.baidu.tieba.hpa;
import com.baidu.tieba.ioa;
import com.baidu.tieba.j89;
import com.baidu.tieba.ooa;
import com.baidu.tieba.poa;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.toa;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.tieba.voa;
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
public class EditVideoActivity extends BaseActivity implements ooa, poa, MaskVideoView.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public FrsTabInfoData c;
    public String d;
    public VideoInfo e;
    public VideoTitleData f;
    public List<VideoTitleData> g;
    public gpa h;
    public SelectCoverModel i;
    public SelectMusicModel j;
    public String k;
    public boolean l;
    public boolean m;
    public BlueCircleProgressDialog n;
    public toa o;
    public String p;
    public int q;
    public String r;
    public String s;
    public f89 t;
    public hpa u;
    public hoa v;
    public HttpMessageListener w;
    public CustomMessageListener x;

    @Override // com.baidu.tieba.poa
    public void D0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.ooa
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
    public class b extends hoa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditVideoActivity i;

        @Override // com.baidu.tieba.hoa
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

        @Override // com.baidu.tieba.hoa
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.c();
                this.i.b1();
            }
        }

        @Override // com.baidu.tieba.hoa
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.i.h.Z();
                this.i.h.a0();
                this.i.h.M().q();
            }
        }

        @Override // com.baidu.tieba.hoa
        public void d(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                super.d(i, str);
                this.i.b1();
            }
        }

        @Override // com.baidu.tieba.hoa
        public void g(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                super.g(i, str);
                this.i.b1();
            }
        }

        @Override // com.baidu.tieba.hoa
        public void f(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoInfo) == null) {
                super.f(videoInfo);
                if (!this.i.l) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = ioa.g + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str);
                    }
                    this.i.g1(str);
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
        j89 j89Var;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, j89.class);
        if (runTask != null) {
            j89Var = (j89) runTask.getData();
        } else {
            j89Var = null;
        }
        if (j89Var != null) {
            this.t = j89Var.get();
        }
        this.w = new a(this, CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        this.x = new c(this, 2001374);
    }

    public final void e1() {
        VideoInfo videoInfo;
        gpa gpaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (videoInfo = this.e) != null && videoInfo.getEditVideoData() != null && (gpaVar = this.h) != null) {
            bpa I = gpaVar.I(this.e.getEditVideoData().filterName);
            if (I != null) {
                toa toaVar = this.o;
                if (toaVar != null) {
                    toaVar.h(I);
                }
                this.h.m0(I);
            }
            this.h.l0(this.e.getEditVideoData().musicPath, this.e.getEditVideoData().musicId);
            this.h.n0(!this.e.getEditVideoData().isMute);
        }
    }

    @Override // com.baidu.tieba.ooa
    public void onNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.h != null && this.i != null && this.j != null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    getPageContext().showToast(R.string.no_network);
                    return;
                } else if (this.l) {
                    return;
                } else {
                    this.l = true;
                    this.m = false;
                    hpa hpaVar = this.u;
                    if (hpaVar != null) {
                        hpaVar.cancel();
                    }
                    this.k = null;
                    this.h.W();
                    this.n.setDialogVisiable(true);
                    d1();
                    return;
                }
            }
            b1();
            this.l = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            gpa gpaVar = this.h;
            if (gpaVar != null) {
                gpaVar.W();
                this.h.Z();
                this.h.a0();
                this.h.M().q();
            }
            if (this.o.f()) {
                this.o.e();
            }
            this.l = false;
            this.m = true;
            hpa hpaVar = this.u;
            if (hpaVar != null) {
                hpaVar.cancel();
            }
            U0();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
    public void G(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bitmap, z) == null) {
            a1(bitmap);
        }
    }

    @Override // com.baidu.tieba.ooa
    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.m) {
                this.m = false;
            } else if (this.l) {
                showToast(str);
                b1();
                this.l = false;
            }
        }
    }

    @Override // com.baidu.tieba.ooa
    public void B0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            this.h.M().o(bitmap);
        }
    }

    public final void f1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                new MediaScannerClient(this).saveImage(str);
                voa.c(this, str);
            } catch (Exception unused) {
                b1();
                this.l = false;
            }
        }
    }

    public final void g1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                new MediaScannerClient(this).saveVideo(str);
                voa.c(this, str);
            } catch (Exception unused) {
                b1();
                this.l = false;
            }
        }
    }

    @Override // com.baidu.tieba.ooa
    public void l(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.h.j0(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    /* JADX WARN: Type inference failed for: r7v13 */
    @Override // com.baidu.tieba.ooa
    public void D(String str) {
        String str2;
        PostPrefixData postPrefixData;
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.m) {
                this.m = false;
                return;
            }
            this.k = str;
            f1(str);
            b1();
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
            editVideoData.musicPath = this.h.J();
            editVideoData.musicId = this.h.H();
            editVideoData.isMute = this.h.R();
            editVideoData.filterName = this.o.b();
            this.e.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.r).setCallFrom(this.p).setStatisticFrom(this.q).setForumId(this.a).setForumName(this.b).setAntiData(antiData2).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.c).setVideoInfo(this.e);
            videoInfo.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            videoInfo.getIntent().setFlags(67108864);
            videoInfo.send();
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hpa hpaVar = this.u;
            if (hpaVar != null) {
                hpaVar.cancel();
            }
            this.m = true;
            this.k = null;
            b1();
        }
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
            if (!StringUtils.isNull(this.a)) {
                httpMessage.addParam("forum_id", this.a);
            }
            sendMessage(httpMessage);
        }
    }

    public final void b1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (blueCircleProgressDialog = this.n) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        gpa gpaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (gpaVar = this.h) != null) {
            gpaVar.o0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            gpa gpaVar = this.h;
            if (gpaVar != null) {
                gpaVar.b0();
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
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onRestart();
            cpa.g().d();
            dpa.g().d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            gpa gpaVar = this.h;
            if (gpaVar != null) {
                gpaVar.Y();
            }
        }
    }

    @Override // com.baidu.tieba.ooa
    public void t() {
        SelectCoverModel selectCoverModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            gpa gpaVar = this.h;
            if (gpaVar != null && (selectCoverModel = this.i) != null) {
                if (this.m) {
                    this.m = false;
                    return;
                } else {
                    selectCoverModel.T(this.d, gpaVar.getCurrentPosition());
                    return;
                }
            }
            b1();
            this.l = false;
        }
    }

    public final void a1(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
            gpa gpaVar = this.h;
            if (gpaVar != null && this.i != null) {
                if (this.m) {
                    this.m = false;
                    return;
                }
                if (!TextUtils.isEmpty(gpaVar.L())) {
                    bitmap = this.h.F(bitmap);
                }
                if (bitmap != null) {
                    this.i.R(bitmap, ioa.b);
                    return;
                }
                return;
            }
            b1();
            this.l = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            BDLayoutMode layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.h.K());
            gpa gpaVar = this.h;
            if (gpaVar != null) {
                gpaVar.U(getPageContext(), i);
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                VideoInfo videoInfo = (VideoInfo) serializableExtra;
                this.e = videoInfo;
                String videoPath = videoInfo.getVideoPath();
                this.d = videoPath;
                this.v.b = videoPath;
            }
            this.h.e0(this.d);
            e1();
            this.s = getIntent().getStringExtra("from_type");
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
            tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.ooa
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b1();
            this.l = false;
            hpa hpaVar = this.u;
            if (hpaVar != null) {
                hpaVar.cancel();
            }
            gpa gpaVar = this.h;
            if (gpaVar != null && gpaVar.M() != null) {
                this.h.M().pause();
                this.h.M().q();
            }
            setResult(-1);
            finish();
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.m) {
                this.m = false;
                return;
            }
            String L = this.h.L();
            if (TextUtils.isEmpty(L)) {
                this.i.T(this.d, this.h.getCurrentPosition());
            } else {
                this.i.P(L);
            }
        }
    }

    @Override // com.baidu.tieba.ooa
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m = false;
            this.l = false;
            this.v.i(false);
            hoa hoaVar = this.v;
            hoaVar.c = this.k;
            hoaVar.b = this.d;
            hoaVar.d = this.h.J();
            this.v.e = this.h.R();
            this.v.f = this.o.b();
            this.u.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, intent) == null) {
            if (i2 == -1) {
                if (i == 25032) {
                    String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_RESOURCE);
                    String stringExtra2 = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        String f = cpa.g().f(stringExtra);
                        if (this.h != null && !TextUtils.isEmpty(f)) {
                            this.h.V(f, stringExtra2);
                        }
                    }
                }
            } else if (i2 == 100) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
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
            new File(ioa.g).mkdirs();
            this.i = new SelectCoverModel(getPageContext(), this, this.t);
            this.j = new SelectMusicModel(getPageContext(), this);
            this.o = new toa(this);
            gpa gpaVar = new gpa(getPageContext(), this, findViewById(R.id.root_layout), this.t);
            this.h = gpaVar;
            gpaVar.e0(this.d);
            this.h.k0(getIntent());
            this.h.f0(this.o);
            this.h.g0(this);
            this.i.Q();
            this.j.O();
            BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(getPageContext());
            this.n = blueCircleProgressDialog;
            blueCircleProgressDialog.setTipString(R.string.obfuscated_res_0x7f0f0cba);
            registerListener(this.x);
            c1();
            registerListener(this.w);
            Z0();
            TiebaStatic.log("c12303");
            b bVar = new b(this, this, this.d, this.k);
            this.v = bVar;
            this.u = new hpa(bVar);
            e1();
        }
    }

    @Override // com.baidu.tieba.poa
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(0, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0d22)));
            list.add(1, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0d20)));
            this.h.h0(list);
        }
    }
}
