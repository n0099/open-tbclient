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
import com.repackage.bt8;
import com.repackage.ct8;
import com.repackage.dm7;
import com.repackage.gt8;
import com.repackage.it8;
import com.repackage.mi;
import com.repackage.ot8;
import com.repackage.pt8;
import com.repackage.qt8;
import com.repackage.tt8;
import com.repackage.us8;
import com.repackage.ut8;
import com.repackage.vs8;
import com.repackage.xt4;
import com.repackage.zl7;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EditVideoActivity extends BaseActivity implements bt8, ct8, MaskVideoView.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCancel;
    public boolean isSend;
    public List<VideoTitleData> mAllVideoTitleDatas;
    public String mCallFrom;
    public SelectCoverModel mCoverModel;
    public String mCoverPath;
    public tt8 mEditVideoView;
    public String mFid;
    public gt8 mFilterEffectManager;
    public int mForumLevel;
    public String mForumName;
    public String mFrom;
    public String mFromType;
    public FrsTabInfoData mFrsTabInfo;
    public HttpMessageListener mGetVideoActivityListener;
    public SelectMusicModel mMusicModel;
    public zl7 mPostMonitorManager;
    public CustomMessageListener mPostSuccessListener;
    public int mProZone;
    public xt4 mProgressDialog;
    public VideoInfo mVideoInfo;
    public String mVideoPath;
    public String mVideoTitle;
    public VideoTitleData mVideoTitleData;
    public ut8 saveEditVideoController;
    public int statisticFrom;
    public us8 thisPageCallback;

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
                    this.a.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                    this.a.mAllVideoTitleDatas = responseGetVideoActivityMessage.getAllVideoTitleList();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends us8 {
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

        @Override // com.repackage.us8
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.c();
                this.i.hideProgress();
            }
        }

        @Override // com.repackage.us8
        public void d(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                super.d(i, str);
                this.i.hideProgress();
            }
        }

        @Override // com.repackage.us8
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.us8
        public void f(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoInfo) == null) {
                super.f(videoInfo);
                if (this.i.isSend) {
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = vs8.g + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str);
                }
                this.i.syncMediaData(str);
                this.i.finishPage();
            }
        }

        @Override // com.repackage.us8
        public void g(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                super.g(i, str);
                this.i.hideProgress();
            }
        }

        @Override // com.repackage.us8
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.i.mEditVideoView.L();
                this.i.mEditVideoView.M();
                this.i.mEditVideoView.y().z();
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
                this.a.finishPage();
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, dm7.class);
        dm7 dm7Var = runTask != null ? (dm7) runTask.getData() : null;
        if (dm7Var != null) {
            this.mPostMonitorManager = dm7Var.get();
        }
        this.mGetVideoActivityListener = new a(this, CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        this.mPostSuccessListener = new c(this, 2001374);
    }

    private void cancelProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ut8 ut8Var = this.saveEditVideoController;
            if (ut8Var != null) {
                ut8Var.cancel();
            }
            this.isCancel = true;
            this.mCoverPath = null;
            hideProgress();
        }
    }

    private void handleGenMaskCoverFinish(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bitmap) == null) {
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null && this.mCoverModel != null) {
                if (this.isCancel) {
                    this.isCancel = false;
                    return;
                }
                if (!TextUtils.isEmpty(tt8Var.x())) {
                    bitmap = this.mEditVideoView.r(bitmap);
                }
                if (bitmap != null) {
                    this.mCoverModel.C(bitmap, vs8.b);
                    return;
                }
                return;
            }
            hideProgress();
            this.isSend = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (xt4Var = this.mProgressDialog) == null) {
            return;
        }
        xt4Var.h(false);
    }

    private void registerLoadVideoActivitysTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
            tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    private void saveCover() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.isCancel) {
                this.isCancel = false;
                return;
            }
            String x = this.mEditVideoView.x();
            if (TextUtils.isEmpty(x)) {
                this.mCoverModel.E(this.mVideoPath, this.mEditVideoView.getCurrentPosition());
            } else {
                this.mCoverModel.A(x);
            }
        }
    }

    private void setSelectedMusicAndFilter() {
        VideoInfo videoInfo;
        tt8 tt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (videoInfo = this.mVideoInfo) == null || videoInfo.getEditVideoData() == null || (tt8Var = this.mEditVideoView) == null) {
            return;
        }
        ot8 u = tt8Var.u(this.mVideoInfo.getEditVideoData().filterName);
        if (u != null) {
            gt8 gt8Var = this.mFilterEffectManager;
            if (gt8Var != null) {
                gt8Var.h(u);
            }
            this.mEditVideoView.Z(u);
        }
        this.mEditVideoView.Y(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
        this.mEditVideoView.a0(!this.mVideoInfo.getEditVideoData().isMute);
    }

    private void syncCoverData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            try {
                new MediaScannerClient(this).saveImage(str);
                it8.c(this, str);
            } catch (Exception unused) {
                hideProgress();
                this.isSend = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncMediaData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            try {
                new MediaScannerClient(this).saveVideo(str);
                it8.c(this, str);
            } catch (Exception unused) {
                hideProgress();
                this.isSend = false;
            }
        }
    }

    @Override // com.repackage.bt8
    public void clearFinalVideoPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.bt8
    public void finishPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hideProgress();
            this.isSend = false;
            ut8 ut8Var = this.saveEditVideoController;
            if (ut8Var != null) {
                ut8Var.cancel();
            }
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null && tt8Var.y() != null) {
                this.mEditVideoView.y().pause();
                this.mEditVideoView.y().z();
            }
            setResult(-1);
            finish();
        }
    }

    public String getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFromType : (String) invokeV.objValue;
    }

    public void getVideoTitleList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
            if (!StringUtils.isNull(this.mFid)) {
                httpMessage.addParam("forum_id", this.mFid);
            }
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
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
                String f = pt8.g().f(stringExtra);
                if (this.mEditVideoView == null || TextUtils.isEmpty(f)) {
                    return;
                }
                this.mEditVideoView.H(f, stringExtra2);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        tt8 tt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tt8Var = this.mEditVideoView) == null) {
            return;
        }
        tt8Var.b0();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mEditVideoView.w());
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null) {
                tt8Var.G(getPageContext(), i);
            }
        }
    }

    @Override // com.repackage.bt8
    public void onCheckUegFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (this.isCancel) {
                this.isCancel = false;
            } else if (this.isSend) {
                showToast(str);
                hideProgress();
                this.isSend = false;
            }
        }
    }

    @Override // com.repackage.bt8
    public void onCheckUegSuccess() {
        SelectCoverModel selectCoverModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null && (selectCoverModel = this.mCoverModel) != null) {
                if (this.isCancel) {
                    this.isCancel = false;
                    return;
                } else {
                    selectCoverModel.E(this.mVideoPath, tt8Var.getCurrentPosition());
                    return;
                }
            }
            hideProgress();
            this.isSend = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0034);
            this.mFid = getIntent().getStringExtra("forum_id");
            this.mForumLevel = getIntent().getIntExtra("key_write_level", -1);
            this.mProZone = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.mVideoTitle = getIntent().getStringExtra("video_title");
            this.mCallFrom = getIntent().getStringExtra("KEY_CALL_FROM");
            this.statisticFrom = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.mFromType = getIntent().getStringExtra("from_type");
            this.mFrom = getIntent().getStringExtra("from");
            Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                VideoInfo videoInfo = (VideoInfo) serializableExtra;
                this.mVideoInfo = videoInfo;
                this.mVideoPath = videoInfo.getVideoPath();
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mFrsTabInfo = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
                finishPage();
            }
            new File(vs8.g).mkdirs();
            this.mCoverModel = new SelectCoverModel(getPageContext(), this, this.mPostMonitorManager);
            this.mMusicModel = new SelectMusicModel(getPageContext(), this);
            this.mFilterEffectManager = new gt8(this);
            tt8 tt8Var = new tt8(getPageContext(), this, findViewById(R.id.obfuscated_res_0x7f091ad6), this.mPostMonitorManager);
            this.mEditVideoView = tt8Var;
            tt8Var.Q(this.mVideoPath);
            this.mEditVideoView.X(getIntent());
            this.mEditVideoView.S(this.mFilterEffectManager);
            this.mEditVideoView.T(this);
            this.mCoverModel.B();
            this.mMusicModel.z();
            xt4 xt4Var = new xt4(getPageContext());
            this.mProgressDialog = xt4Var;
            xt4Var.i(R.string.obfuscated_res_0x7f0f0ac5);
            registerListener(this.mPostSuccessListener);
            registerLoadVideoActivitysTask();
            registerListener(this.mGetVideoActivityListener);
            getVideoTitleList();
            TiebaStatic.log("c12303");
            b bVar = new b(this, this, this.mVideoPath, this.mCoverPath);
            this.thisPageCallback = bVar;
            this.saveEditVideoController = new ut8(bVar);
            setSelectedMusicAndFilter();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null) {
                tt8Var.N();
            }
            SelectCoverModel selectCoverModel = this.mCoverModel;
            if (selectCoverModel != null) {
                selectCoverModel.cancelLoadData();
            }
            SelectMusicModel selectMusicModel = this.mMusicModel;
            if (selectMusicModel != null) {
                selectMusicModel.cancelLoadData();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
    public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, bitmap, z) == null) {
            handleGenMaskCoverFinish(bitmap);
        }
    }

    @Override // com.repackage.bt8
    public void onGetCoverBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bitmap) == null) {
            this.mEditVideoView.y().x(bitmap);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                VideoInfo videoInfo = (VideoInfo) serializableExtra;
                this.mVideoInfo = videoInfo;
                String videoPath = videoInfo.getVideoPath();
                this.mVideoPath = videoPath;
                this.thisPageCallback.b = videoPath;
            }
            this.mEditVideoView.Q(this.mVideoPath);
            setSelectedMusicAndFilter();
            this.mFromType = getIntent().getStringExtra("from_type");
        }
    }

    @Override // com.repackage.bt8
    public void onNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.mEditVideoView != null && this.mCoverModel != null && this.mMusicModel != null) {
                if (!mi.z()) {
                    getPageContext().showToast(R.string.obfuscated_res_0x7f0f0c4d);
                    return;
                } else if (this.isSend) {
                    return;
                } else {
                    this.isSend = true;
                    this.isCancel = false;
                    ut8 ut8Var = this.saveEditVideoController;
                    if (ut8Var != null) {
                        ut8Var.cancel();
                    }
                    this.mCoverPath = null;
                    this.mEditVideoView.I();
                    this.mProgressDialog.h(true);
                    saveCover();
                    return;
                }
            }
            hideProgress();
            this.isSend = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null) {
                tt8Var.I();
                this.mEditVideoView.L();
                this.mEditVideoView.M();
                this.mEditVideoView.y().z();
            }
            if (this.mFilterEffectManager.f()) {
                this.mFilterEffectManager.e();
            }
            this.isSend = false;
            this.isCancel = true;
            ut8 ut8Var = this.saveEditVideoController;
            if (ut8Var != null) {
                ut8Var.cancel();
            }
            cancelProgress();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onRestart();
            pt8.g().d();
            qt8.g().d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            tt8 tt8Var = this.mEditVideoView;
            if (tt8Var != null) {
                tt8Var.K();
            }
        }
    }

    @Override // com.repackage.bt8
    public void onSave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.isCancel = false;
            this.isSend = false;
            this.thisPageCallback.i(false);
            us8 us8Var = this.thisPageCallback;
            us8Var.c = this.mCoverPath;
            us8Var.b = this.mVideoPath;
            us8Var.d = this.mEditVideoView.v();
            this.thisPageCallback.e = this.mEditVideoView.D();
            this.thisPageCallback.f = this.mFilterEffectManager.b();
            this.saveEditVideoController.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    /* JADX WARN: Type inference failed for: r7v12 */
    @Override // com.repackage.bt8
    public void onSaveCover(String str) {
        String str2;
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.isCancel) {
                this.isCancel = false;
                return;
            }
            this.mCoverPath = str;
            syncCoverData(str);
            hideProgress();
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
            editVideoData.coverPath = this.mCoverPath;
            editVideoData.originPath = this.mVideoPath;
            editVideoData.musicPath = this.mEditVideoView.v();
            editVideoData.musicId = this.mEditVideoView.t();
            editVideoData.isMute = this.mEditVideoView.D();
            editVideoData.filterName = this.mFilterEffectManager.b();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.mCallFrom).setStatisticFrom(this.statisticFrom).setForumId(this.mFid).setForumName(this.mForumName).setAntiData(r1).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.mFrsTabInfo).setVideoInfo(this.mVideoInfo);
            videoInfo.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            videoInfo.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            videoInfo.send();
        }
    }

    @Override // com.repackage.ct8
    public void onSaveMusicVideo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i, str2) == null) {
        }
    }

    @Override // com.repackage.ct8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(0, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0b0f)));
            list.add(1, new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0b0d)));
            this.mEditVideoView.U(list);
        }
    }

    @Override // com.repackage.bt8
    public void setPendantData(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            this.mEditVideoView.W(list);
        }
    }
}
