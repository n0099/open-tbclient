package com.baidu.tieba.video.editvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.localvideo.f;
import com.baidu.tieba.video.localvideo.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EditVideoActivity extends BaseActivity implements a, b {
    private String aZU;
    private String azM;
    private com.baidu.tbadk.core.view.a eVj;
    private String gEL;
    private List<VideoTitleData> gEM;
    private com.baidu.tieba.video.editvideo.view.a gEN;
    private SelectCoverModel gEO;
    private SelectMusicModel gEP;
    private String gEQ;
    private String gER;
    private boolean gES;
    private String gET;
    private g gEU;
    private com.baidu.tieba.video.commonview.a gEY;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean vo;
    private boolean gEV = false;
    private boolean gEW = false;
    private boolean gEX = false;
    private Handler gEZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            EditVideoActivity.this.gEZ.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (EditVideoActivity.this.gEY != null && EditVideoActivity.this.gEY.isShowing()) {
                        EditVideoActivity.this.gEY.setPercent(message.arg1);
                    }
                    EditVideoActivity.this.gEZ.sendMessageDelayed(EditVideoActivity.this.gEZ.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!EditVideoActivity.this.gEX) {
                        l.showToast(EditVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    EditVideoActivity.this.gEW = true;
                    if (!StringUtils.isNull(EditVideoActivity.this.gET) && (file = new File(EditVideoActivity.this.gET)) != null) {
                        EditVideoActivity.this.gET = EditVideoActivity.this.gET.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(EditVideoActivity.this.gET));
                    }
                    EditVideoActivity.this.byN();
                    if (!EditVideoActivity.this.gEV) {
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(EditVideoActivity.this, d.j.mv_local_video_compress_failed);
                    g byP = EditVideoActivity.this.byP();
                    if (byP != null && byP.isConvertRunning()) {
                        EditVideoActivity.this.byO();
                        return;
                    }
                    return;
                default:
                    return;
            }
            EditVideoActivity.this.gEW = false;
            EditVideoActivity.this.byN();
        }
    };
    private f gFa = new f() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
        @Override // com.baidu.tieba.video.localvideo.f
        public void byZ() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uQ(int i) {
            EditVideoActivity.this.gEZ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            EditVideoActivity.this.gEZ.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            EditVideoActivity.this.gEZ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            EditVideoActivity.this.gEZ.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            EditVideoActivity.this.gEZ.sendEmptyMessage(4);
        }
    };
    private HttpMessageListener gFb = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                    EditVideoActivity.this.gEM = responseGetVideoActivityMessage.getAllVideoTitleList();
                }
            }
        }
    };
    private CustomMessageListener gFc = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                EditVideoActivity.this.finishPage();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void byN() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.root_layout);
        if (relativeLayout != null && this.gEY.getParent() != null) {
            relativeLayout.removeView(this.gEY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byO() {
        byP().abortConvert();
        this.gEX = true;
        if (this.gET != null) {
            File file = new File(this.gET);
            if (file.exists()) {
                file.delete();
            }
        }
        byN();
        this.gET = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g byP() {
        if (this.gEU == null) {
            this.gEU = new g(this);
            this.gEU.a(this.gFa);
        }
        return this.gEU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.activity_edit_video);
        this.azM = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gEL = getIntent().getStringExtra("video_title");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aZU = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aZU) && !new File(this.aZU).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gDC).mkdirs();
        this.gEO = new SelectCoverModel(getPageContext(), this);
        this.gEP = new SelectMusicModel(getPageContext(), this);
        this.gEN = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout));
        this.gEN.setData(this.aZU);
        this.gEN.Z(getIntent());
        this.gEO.bzh();
        this.gEP.bzi();
        this.eVj = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eVj.da(d.j.mixing);
        registerListener(this.gFc);
        byS();
        registerListener(this.gFb);
        byR();
        TiebaStatic.log("c12303");
    }

    private void byQ() {
        this.vo = true;
        this.gER = null;
        this.gEQ = null;
        aox();
    }

    public void byR() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.azM)) {
            httpMessage.addParam("forum_id", this.azM);
        }
        sendMessage(httpMessage);
    }

    private void byS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.gEN.getRootView());
        if (this.gEN != null) {
            this.gEN.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gEN != null) {
            this.gEN.onPause();
        }
        byQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        File file;
        super.onResume();
        if (this.gEN != null) {
            this.gEN.onResume();
        }
        if (!this.gEW || TextUtils.isEmpty(this.gET) || (file = new File(this.gET)) == null || file.exists()) {
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bzc().bzd();
        com.baidu.tieba.video.editvideo.model.b.bzf().bzg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gEN != null) {
            this.gEN.release();
        }
        if (this.gEO != null) {
            this.gEO.cancelLoadData();
        }
        if (this.gEP != null) {
            this.gEP.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gEN != null) {
            this.gEN.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aox();
        k.r(new File(com.baidu.tieba.video.b.gDB));
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void byT() {
        if (this.gEN != null && this.gEO != null && this.gEP != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.gES) {
                this.gES = true;
                this.vo = false;
                this.gER = null;
                this.gEQ = null;
                this.eVj.aE(true);
                this.gEN.onPause();
                byV();
                byU();
            }
        }
    }

    private void aox() {
        if (this.eVj != null) {
            this.eVj.aE(false);
        }
        this.gES = false;
    }

    private void byU() {
        if (this.vo) {
            this.vo = false;
        } else if (this.gEN.bzz()) {
            this.gEP.c(this.aZU, this.gEN.bzx(), com.baidu.tieba.video.b.gDB + "video_" + System.currentTimeMillis() + ".mp4", this.gEN.isMute() ? false : true);
        } else if (this.gEN.isMute()) {
            this.gEP.c(this.aZU, null, com.baidu.tieba.video.b.gDB + "video_" + System.currentTimeMillis() + ".mp4", this.gEN.isMute() ? false : true);
        } else {
            tn(this.aZU);
        }
    }

    private void byV() {
        if (this.vo) {
            this.vo = false;
            return;
        }
        String text = this.gEN.getText();
        if (TextUtils.isEmpty(text)) {
            this.gEO.aG(this.aZU, this.gEN.getCurrentPosition());
        } else {
            this.gEO.pO(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void byW() {
        this.vo = false;
        if (this.gEN.bzz() || this.gEN.isMute()) {
            this.gES = false;
            this.eVj.aE(true);
            this.gEN.onPause();
            if (this.gER != null) {
                tn(this.gER);
                return;
            } else {
                byU();
                return;
            }
        }
        if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
            File file = new File(this.aZU);
            k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gDC + file.getName());
        }
        finishPage();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aVx() {
        if (this.gEN == null || this.gEO == null) {
            aox();
        } else if (this.vo) {
            this.vo = false;
        } else {
            this.gEO.aG(this.aZU, this.gEN.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void pK(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (this.gES) {
            showToast(str);
            aox();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void r(Bitmap bitmap) {
        if (this.gEN == null || this.gEO == null) {
            aox();
        } else if (this.vo) {
            this.vo = false;
        } else {
            if (!TextUtils.isEmpty(this.gEN.getText())) {
                bitmap = this.gEN.j(bitmap);
            }
            if (bitmap != null) {
                this.gEO.b(bitmap, com.baidu.tieba.video.b.gDA);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tm(String str) {
        if (this.vo) {
            this.vo = false;
            return;
        }
        this.gEQ = str;
        this.gEN.bzw();
        byX();
    }

    private void byX() {
        if (this.vo) {
            this.vo = false;
        } else if (!TextUtils.isEmpty(this.gEQ) && !TextUtils.isEmpty(this.gER)) {
            this.mVideoInfo.setVideoPath(this.gER);
            this.mVideoInfo.setThumbPath(this.gEQ);
            if (this.gEN.bzz() && !TextUtils.isEmpty(this.gEN.bzy())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gEN.bzy());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.azM, this.mForumName, this.gEL, 13003, this.mVideoInfo, this.mVideoTitleData, this.gEM)));
            aox();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.gEN.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void tn(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            aox();
            this.gEN.onResume();
        } else {
            this.gER = str;
            if (this.gES) {
                byX();
                return;
            }
            File file = new File(this.gER);
            k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gDC + file.getName());
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void byY() {
        this.gER = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dC(List<PendantData> list) {
        this.gEN.dC(list);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tp = com.baidu.tieba.video.editvideo.model.a.bzc().tp(stringExtra);
                if (this.gEN != null && !TextUtils.isEmpty(tp)) {
                    this.gEN.ck(tp, stringExtra2);
                }
            }
        }
    }
}
