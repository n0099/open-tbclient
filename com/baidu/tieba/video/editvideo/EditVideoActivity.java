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
    private String aZL;
    private String azE;
    private com.baidu.tbadk.core.view.a eUO;
    private String gDD;
    private List<VideoTitleData> gDE;
    private com.baidu.tieba.video.editvideo.view.a gDF;
    private SelectCoverModel gDG;
    private SelectMusicModel gDH;
    private String gDI;
    private String gDJ;
    private boolean gDK;
    private String gDL;
    private g gDM;
    private com.baidu.tieba.video.commonview.a gDQ;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean vo;
    private boolean gDN = false;
    private boolean gDO = false;
    private boolean gDP = false;
    private Handler gDR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            EditVideoActivity.this.gDR.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (EditVideoActivity.this.gDQ != null && EditVideoActivity.this.gDQ.isShowing()) {
                        EditVideoActivity.this.gDQ.setPercent(message.arg1);
                    }
                    EditVideoActivity.this.gDR.sendMessageDelayed(EditVideoActivity.this.gDR.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!EditVideoActivity.this.gDP) {
                        l.showToast(EditVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    EditVideoActivity.this.gDO = true;
                    if (!StringUtils.isNull(EditVideoActivity.this.gDL) && (file = new File(EditVideoActivity.this.gDL)) != null) {
                        EditVideoActivity.this.gDL = EditVideoActivity.this.gDL.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(EditVideoActivity.this.gDL));
                    }
                    EditVideoActivity.this.byB();
                    if (!EditVideoActivity.this.gDN) {
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(EditVideoActivity.this, d.j.mv_local_video_compress_failed);
                    g byD = EditVideoActivity.this.byD();
                    if (byD != null && byD.isConvertRunning()) {
                        EditVideoActivity.this.byC();
                        return;
                    }
                    return;
                default:
                    return;
            }
            EditVideoActivity.this.gDO = false;
            EditVideoActivity.this.byB();
        }
    };
    private f gDS = new f() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
        @Override // com.baidu.tieba.video.localvideo.f
        public void byN() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uM(int i) {
            EditVideoActivity.this.gDR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            EditVideoActivity.this.gDR.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            EditVideoActivity.this.gDR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            EditVideoActivity.this.gDR.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            EditVideoActivity.this.gDR.sendEmptyMessage(4);
        }
    };
    private HttpMessageListener gDT = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                    EditVideoActivity.this.gDE = responseGetVideoActivityMessage.getAllVideoTitleList();
                }
            }
        }
    };
    private CustomMessageListener gDU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                EditVideoActivity.this.finishPage();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void byB() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.root_layout);
        if (relativeLayout != null && this.gDQ.getParent() != null) {
            relativeLayout.removeView(this.gDQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byC() {
        byD().abortConvert();
        this.gDP = true;
        if (this.gDL != null) {
            File file = new File(this.gDL);
            if (file.exists()) {
                file.delete();
            }
        }
        byB();
        this.gDL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g byD() {
        if (this.gDM == null) {
            this.gDM = new g(this);
            this.gDM.a(this.gDS);
        }
        return this.gDM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.activity_edit_video);
        this.azE = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gDD = getIntent().getStringExtra("video_title");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aZL = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aZL) && !new File(this.aZL).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gCu).mkdirs();
        this.gDG = new SelectCoverModel(getPageContext(), this);
        this.gDH = new SelectMusicModel(getPageContext(), this);
        this.gDF = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout));
        this.gDF.setData(this.aZL);
        this.gDF.Z(getIntent());
        this.gDG.byV();
        this.gDH.byW();
        this.eUO = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eUO.db(d.j.mixing);
        registerListener(this.gDU);
        byG();
        registerListener(this.gDT);
        byF();
        TiebaStatic.log("c12303");
    }

    private void byE() {
        this.vo = true;
        this.gDJ = null;
        this.gDI = null;
        aoi();
    }

    public void byF() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.azE)) {
            httpMessage.addParam("forum_id", this.azE);
        }
        sendMessage(httpMessage);
    }

    private void byG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.gDF.getRootView());
        if (this.gDF != null) {
            this.gDF.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gDF != null) {
            this.gDF.onPause();
        }
        byE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        File file;
        super.onResume();
        if (this.gDF != null) {
            this.gDF.onResume();
        }
        if (!this.gDO || TextUtils.isEmpty(this.gDL) || (file = new File(this.gDL)) == null || file.exists()) {
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.byQ().byR();
        com.baidu.tieba.video.editvideo.model.b.byT().byU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDF != null) {
            this.gDF.release();
        }
        if (this.gDG != null) {
            this.gDG.cancelLoadData();
        }
        if (this.gDH != null) {
            this.gDH.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gDF != null) {
            this.gDF.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aoi();
        k.r(new File(com.baidu.tieba.video.b.gCt));
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void byH() {
        if (this.gDF != null && this.gDG != null && this.gDH != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.gDK) {
                this.gDK = true;
                this.vo = false;
                this.gDJ = null;
                this.gDI = null;
                this.eUO.aE(true);
                this.gDF.onPause();
                byJ();
                byI();
            }
        }
    }

    private void aoi() {
        if (this.eUO != null) {
            this.eUO.aE(false);
        }
        this.gDK = false;
    }

    private void byI() {
        if (this.vo) {
            this.vo = false;
        } else if (this.gDF.bzn()) {
            this.gDH.c(this.aZL, this.gDF.bzl(), com.baidu.tieba.video.b.gCt + "video_" + System.currentTimeMillis() + ".mp4", this.gDF.isMute() ? false : true);
        } else if (this.gDF.isMute()) {
            this.gDH.c(this.aZL, null, com.baidu.tieba.video.b.gCt + "video_" + System.currentTimeMillis() + ".mp4", this.gDF.isMute() ? false : true);
        } else {
            th(this.aZL);
        }
    }

    private void byJ() {
        if (this.vo) {
            this.vo = false;
            return;
        }
        String text = this.gDF.getText();
        if (TextUtils.isEmpty(text)) {
            this.gDG.aG(this.aZL, this.gDF.getCurrentPosition());
        } else {
            this.gDG.pK(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void byK() {
        this.vo = false;
        if (this.gDF.bzn() || this.gDF.isMute()) {
            this.gDK = false;
            this.eUO.aE(true);
            this.gDF.onPause();
            if (this.gDJ != null) {
                th(this.gDJ);
                return;
            } else {
                byI();
                return;
            }
        }
        if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
            File file = new File(this.aZL);
            k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gCu + file.getName());
        }
        finishPage();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aVp() {
        if (this.gDF == null || this.gDG == null) {
            aoi();
        } else if (this.vo) {
            this.vo = false;
        } else {
            this.gDG.aG(this.aZL, this.gDF.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void pG(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (this.gDK) {
            showToast(str);
            aoi();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void r(Bitmap bitmap) {
        if (this.gDF == null || this.gDG == null) {
            aoi();
        } else if (this.vo) {
            this.vo = false;
        } else {
            if (!TextUtils.isEmpty(this.gDF.getText())) {
                bitmap = this.gDF.j(bitmap);
            }
            if (bitmap != null) {
                this.gDG.b(bitmap, com.baidu.tieba.video.b.gCs);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tg(String str) {
        if (this.vo) {
            this.vo = false;
            return;
        }
        this.gDI = str;
        this.gDF.bzk();
        byL();
    }

    private void byL() {
        if (this.vo) {
            this.vo = false;
        } else if (!TextUtils.isEmpty(this.gDI) && !TextUtils.isEmpty(this.gDJ)) {
            this.mVideoInfo.setVideoPath(this.gDJ);
            this.mVideoInfo.setThumbPath(this.gDI);
            if (this.gDF.bzn() && !TextUtils.isEmpty(this.gDF.bzm())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gDF.bzm());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.azE, this.mForumName, this.gDD, 13003, this.mVideoInfo, this.mVideoTitleData, this.gDE)));
            aoi();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.gDF.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void th(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            aoi();
            this.gDF.onResume();
        } else {
            this.gDJ = str;
            if (this.gDK) {
                byL();
                return;
            }
            File file = new File(this.gDJ);
            k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gCu + file.getName());
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void byM() {
        this.gDJ = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dB(List<PendantData> list) {
        this.gDF.dB(list);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tj = com.baidu.tieba.video.editvideo.model.a.byQ().tj(stringExtra);
                if (this.gDF != null && !TextUtils.isEmpty(tj)) {
                    this.gDF.cg(tj, stringExtra2);
                }
            }
        }
    }
}
