package com.baidu.tieba.video.editvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
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
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import d.b.b.e.p.j;
import d.b.i0.s1.g;
import d.b.i0.s1.k;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditVideoActivity extends BaseActivity implements d.b.i0.p3.j.a, d.b.i0.p3.j.b, MaskVideoView.f {
    public boolean isCancel;
    public boolean isSend;
    public List<VideoTitleData> mAllVideoTitleDatas;
    public String mCallFrom;
    public SelectCoverModel mCoverModel;
    public String mCoverPath;
    public d.b.i0.p3.j.h.a mEditVideoView;
    public String mFid;
    public d.b.i0.p3.j.d.a mFilterEffectManager;
    public int mForumLevel;
    public String mForumName;
    public String mFrom;
    public String mFromType;
    public FrsTabInfoData mFrsTabInfo;
    public HttpMessageListener mGetVideoActivityListener;
    public SelectMusicModel mMusicModel;
    public g mPostMonitorManager;
    public CustomMessageListener mPostSuccessListener;
    public int mProZone;
    public d.b.h0.r.f0.a mProgressDialog;
    public VideoInfo mVideoInfo;
    public String mVideoPath;
    public String mVideoTitle;
    public VideoTitleData mVideoTitleData;
    public d.b.i0.p3.j.h.b saveEditVideoController;
    public int statisticFrom;
    public d.b.i0.p3.b thisPageCallback;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                    EditVideoActivity.this.mAllVideoTitleDatas = responseGetVideoActivityMessage.getAllVideoTitleList();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.i0.p3.b {
        public b(BaseActivity baseActivity, String str, String str2) {
            super(baseActivity, str, str2);
        }

        @Override // d.b.i0.p3.b
        public void c() {
            super.c();
            EditVideoActivity.this.hideProgress();
        }

        @Override // d.b.i0.p3.b
        public void d(int i, String str) {
            super.d(i, str);
            EditVideoActivity.this.hideProgress();
        }

        @Override // d.b.i0.p3.b
        public void e() {
        }

        @Override // d.b.i0.p3.b
        public void f(VideoInfo videoInfo) {
            super.f(videoInfo);
            if (EditVideoActivity.this.isSend) {
                return;
            }
            File file = new File(videoInfo.getVideoPath());
            String str = d.b.i0.p3.c.f58891d + file.getName();
            if (!str.equals(file.getAbsolutePath())) {
                FileHelper.copyFile(file.getAbsolutePath(), str);
            }
            EditVideoActivity.this.syncMediaData(str);
            EditVideoActivity.this.finishPage();
        }

        @Override // d.b.i0.p3.b
        public void g(int i, String str) {
            super.g(i, str);
            EditVideoActivity.this.hideProgress();
        }

        @Override // d.b.i0.p3.b
        public void h() {
            EditVideoActivity.this.mEditVideoView.P();
            EditVideoActivity.this.mEditVideoView.Q();
            EditVideoActivity.this.mEditVideoView.z().r();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                EditVideoActivity.this.finishPage();
            }
        }
    }

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.mPostMonitorManager = kVar.get();
        }
        this.mGetVideoActivityListener = new a(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        this.mPostSuccessListener = new c(2001374);
    }

    private void cancelProgress() {
        d.b.i0.p3.j.h.b bVar = this.saveEditVideoController;
        if (bVar != null) {
            bVar.cancel();
        }
        this.isCancel = true;
        this.mCoverPath = null;
        hideProgress();
    }

    private void handleGenMaskCoverFinish(Bitmap bitmap) {
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null && this.mCoverModel != null) {
            if (this.isCancel) {
                this.isCancel = false;
                return;
            }
            if (!TextUtils.isEmpty(aVar.y())) {
                bitmap = this.mEditVideoView.r(bitmap);
            }
            if (bitmap != null) {
                this.mCoverModel.w(bitmap, d.b.i0.p3.c.f58889b);
                return;
            }
            return;
        }
        hideProgress();
        this.isSend = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        d.b.h0.r.f0.a aVar = this.mProgressDialog;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    private void registerLoadVideoActivitysTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void saveCover() {
        if (this.isCancel) {
            this.isCancel = false;
            return;
        }
        String y = this.mEditVideoView.y();
        if (TextUtils.isEmpty(y)) {
            this.mCoverModel.y(this.mVideoPath, this.mEditVideoView.getCurrentPosition());
        } else {
            this.mCoverModel.u(y);
        }
    }

    private void setSelectedMusicAndFilter() {
        d.b.i0.p3.j.h.a aVar;
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null || videoInfo.getEditVideoData() == null || (aVar = this.mEditVideoView) == null) {
            return;
        }
        d.b.i0.p3.j.e.a v = aVar.v(this.mVideoInfo.getEditVideoData().filterName);
        if (v != null) {
            d.b.i0.p3.j.d.a aVar2 = this.mFilterEffectManager;
            if (aVar2 != null) {
                aVar2.h(v);
            }
            this.mEditVideoView.f0(v);
        }
        this.mEditVideoView.d0(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
        this.mEditVideoView.g0(!this.mVideoInfo.getEditVideoData().isMute);
    }

    private void syncCoverData(String str) {
        try {
            new MediaScannerClient(this).saveImage(str);
            d.b.i0.p3.j.d.c.c(this, str);
        } catch (Exception unused) {
            hideProgress();
            this.isSend = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncMediaData(String str) {
        try {
            new MediaScannerClient(this).saveVideo(str);
            d.b.i0.p3.j.d.c.c(this, str);
        } catch (Exception unused) {
            hideProgress();
            this.isSend = false;
        }
    }

    @Override // d.b.i0.p3.j.a
    public void clearFinalVideoPath() {
    }

    @Override // d.b.i0.p3.j.a
    public void finishPage() {
        hideProgress();
        this.isSend = false;
        d.b.i0.p3.j.h.b bVar = this.saveEditVideoController;
        if (bVar != null) {
            bVar.cancel();
        }
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null && aVar.z() != null) {
            this.mEditVideoView.z().pause();
            this.mEditVideoView.z().r();
        }
        setResult(-1);
        finish();
    }

    public String getFromType() {
        return this.mFromType;
    }

    public void getVideoTitleList() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.mFid)) {
            httpMessage.addParam("forum_id", this.mFid);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i2 == 100) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                finish();
            }
        } else if (i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            String g2 = d.b.i0.p3.j.f.a.h().g(stringExtra);
            if (this.mEditVideoView == null || TextUtils.isEmpty(g2)) {
                return;
            }
            this.mEditVideoView.L(g2, stringExtra2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null) {
            aVar.h0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().k(i == 1);
        getLayoutMode().j(this.mEditVideoView.x());
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null) {
            aVar.K(getPageContext(), i);
        }
    }

    @Override // d.b.i0.p3.j.a
    public void onCheckUegFail(String str) {
        if (this.isCancel) {
            this.isCancel = false;
        } else if (this.isSend) {
            showToast(str);
            hideProgress();
            this.isSend = false;
        }
    }

    @Override // d.b.i0.p3.j.a
    public void onCheckUegSuccess() {
        SelectCoverModel selectCoverModel;
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null && (selectCoverModel = this.mCoverModel) != null) {
            if (this.isCancel) {
                this.isCancel = false;
                return;
            } else {
                selectCoverModel.y(this.mVideoPath, aVar.getCurrentPosition());
                return;
            }
        }
        hideProgress();
        this.isSend = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
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
        new File(d.b.i0.p3.c.f58891d).mkdirs();
        this.mCoverModel = new SelectCoverModel(getPageContext(), this, this.mPostMonitorManager);
        this.mMusicModel = new SelectMusicModel(getPageContext(), this);
        this.mFilterEffectManager = new d.b.i0.p3.j.d.a(this);
        d.b.i0.p3.j.h.a aVar = new d.b.i0.p3.j.h.a(getPageContext(), this, findViewById(R.id.root_layout), this.mPostMonitorManager);
        this.mEditVideoView = aVar;
        aVar.U(this.mVideoPath);
        this.mEditVideoView.c0(getIntent());
        this.mEditVideoView.V(this.mFilterEffectManager);
        this.mEditVideoView.W(this);
        this.mCoverModel.v();
        this.mMusicModel.t();
        d.b.h0.r.f0.a aVar2 = new d.b.h0.r.f0.a(getPageContext());
        this.mProgressDialog = aVar2;
        aVar2.i(R.string.mixing);
        registerListener(this.mPostSuccessListener);
        registerLoadVideoActivitysTask();
        registerListener(this.mGetVideoActivityListener);
        getVideoTitleList();
        TiebaStatic.log("c12303");
        b bVar = new b(this, this.mVideoPath, this.mCoverPath);
        this.thisPageCallback = bVar;
        this.saveEditVideoController = new d.b.i0.p3.j.h.b(bVar);
        setSelectedMusicAndFilter();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null) {
            aVar.R();
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

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
    public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
        handleGenMaskCoverFinish(bitmap);
    }

    @Override // d.b.i0.p3.j.a
    public void onGetCoverBitmap(Bitmap bitmap) {
        this.mEditVideoView.z().p(bitmap);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            VideoInfo videoInfo = (VideoInfo) serializableExtra;
            this.mVideoInfo = videoInfo;
            String videoPath = videoInfo.getVideoPath();
            this.mVideoPath = videoPath;
            this.thisPageCallback.f58881b = videoPath;
        }
        this.mEditVideoView.U(this.mVideoPath);
        setSelectedMusicAndFilter();
        this.mFromType = getIntent().getStringExtra("from_type");
    }

    @Override // d.b.i0.p3.j.a
    public void onNext() {
        if (this.mEditVideoView != null && this.mCoverModel != null && this.mMusicModel != null) {
            if (!j.z()) {
                getPageContext().showToast(R.string.no_network);
                return;
            } else if (this.isSend) {
                return;
            } else {
                this.isSend = true;
                this.isCancel = false;
                d.b.i0.p3.j.h.b bVar = this.saveEditVideoController;
                if (bVar != null) {
                    bVar.cancel();
                }
                this.mCoverPath = null;
                this.mEditVideoView.M();
                this.mProgressDialog.h(true);
                saveCover();
                return;
            }
        }
        hideProgress();
        this.isSend = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null) {
            aVar.M();
            this.mEditVideoView.P();
            this.mEditVideoView.Q();
            this.mEditVideoView.z().r();
        }
        if (this.mFilterEffectManager.f()) {
            this.mFilterEffectManager.e();
        }
        this.isSend = false;
        this.isCancel = true;
        d.b.i0.p3.j.h.b bVar = this.saveEditVideoController;
        if (bVar != null) {
            bVar.cancel();
        }
        cancelProgress();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        d.b.i0.p3.j.f.a.h().e();
        d.b.i0.p3.j.f.b.g().d();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.i0.p3.j.h.a aVar = this.mEditVideoView;
        if (aVar != null) {
            aVar.O();
        }
    }

    @Override // d.b.i0.p3.j.a
    public void onSave() {
        this.isCancel = false;
        this.isSend = false;
        this.thisPageCallback.i(false);
        d.b.i0.p3.b bVar = this.thisPageCallback;
        bVar.f58882c = this.mCoverPath;
        bVar.f58881b = this.mVideoPath;
        bVar.f58883d = this.mEditVideoView.w();
        this.thisPageCallback.f58884e = this.mEditVideoView.G();
        this.thisPageCallback.f58885f = this.mFilterEffectManager.b();
        this.saveEditVideoController.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    /* JADX WARN: Type inference failed for: r7v12 */
    @Override // d.b.i0.p3.j.a
    public void onSaveCover(String str) {
        String str2;
        PostPrefixData postPrefixData;
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
        editVideoData.musicPath = this.mEditVideoView.w();
        editVideoData.musicId = this.mEditVideoView.u();
        editVideoData.isMute = this.mEditVideoView.G();
        editVideoData.filterName = this.mFilterEffectManager.b();
        this.mVideoInfo.setEditVideoData(editVideoData);
        WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.mCallFrom).setStatisticFrom(this.statisticFrom).setForumId(this.mFid).setForumName(this.mForumName).setAntiData(r1).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.mFrsTabInfo).setVideoInfo(this.mVideoInfo);
        videoInfo.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
        videoInfo.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        videoInfo.send();
    }

    @Override // d.b.i0.p3.j.b
    public void onSaveMusicVideo(String str, int i, String str2) {
    }

    @Override // d.b.i0.p3.j.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.mEditVideoView.X(list);
    }

    @Override // d.b.i0.p3.j.a
    public void setPendantData(List<PendantData> list) {
        this.mEditVideoView.b0(list);
    }
}
