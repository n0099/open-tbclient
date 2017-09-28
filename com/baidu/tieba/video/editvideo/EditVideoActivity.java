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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.editvideo.data.MusicData;
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
    private String aZI;
    private String azf;
    private com.baidu.tbadk.core.view.a eMi;
    private String gva;
    private com.baidu.tieba.video.editvideo.view.a gvb;
    private SelectCoverModel gvc;
    private SelectMusicModel gvd;
    private String gve;
    private String gvf;
    private boolean gvg;
    private String gvh;
    private g gvi;
    private com.baidu.tieba.video.commonview.a gvm;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private boolean vn;
    private boolean gvj = false;
    private boolean gvk = false;
    private boolean gvl = false;
    private Handler gvn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            EditVideoActivity.this.gvn.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (EditVideoActivity.this.gvm != null && EditVideoActivity.this.gvm.isShowing()) {
                        EditVideoActivity.this.gvm.setPercent(message.arg1);
                    }
                    EditVideoActivity.this.gvn.sendMessageDelayed(EditVideoActivity.this.gvn.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!EditVideoActivity.this.gvl) {
                        l.showToast(EditVideoActivity.this, d.l.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    EditVideoActivity.this.gvk = true;
                    if (!StringUtils.isNull(EditVideoActivity.this.gvh) && (file = new File(EditVideoActivity.this.gvh)) != null) {
                        EditVideoActivity.this.gvh = EditVideoActivity.this.gvh.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(EditVideoActivity.this.gvh));
                    }
                    EditVideoActivity.this.bvH();
                    if (!EditVideoActivity.this.gvj) {
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(EditVideoActivity.this, d.l.mv_local_video_compress_failed);
                    g bvJ = EditVideoActivity.this.bvJ();
                    if (bvJ != null && bvJ.isConvertRunning()) {
                        EditVideoActivity.this.bvI();
                        return;
                    }
                    return;
                default:
                    return;
            }
            EditVideoActivity.this.gvk = false;
            EditVideoActivity.this.bvH();
        }
    };
    private f gvo = new f() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
        @Override // com.baidu.tieba.video.localvideo.f
        public void bvR() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uw(int i) {
            EditVideoActivity.this.gvn.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            EditVideoActivity.this.gvn.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            EditVideoActivity.this.gvn.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            EditVideoActivity.this.gvn.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            EditVideoActivity.this.gvn.sendEmptyMessage(4);
        }
    };
    private CustomMessageListener gvp = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                EditVideoActivity.this.finishPage();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bvH() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.root_layout);
        if (relativeLayout != null && this.gvm.getParent() != null) {
            relativeLayout.removeView(this.gvm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        bvJ().abortConvert();
        this.gvl = true;
        if (this.gvh != null) {
            File file = new File(this.gvh);
            if (file.exists()) {
                file.delete();
            }
        }
        bvH();
        this.gvh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g bvJ() {
        if (this.gvi == null) {
            this.gvi = new g(this);
            this.gvi.a(this.gvo);
        }
        return this.gvi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.activity_edit_video);
        this.azf = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gva = getIntent().getStringExtra("video_title");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aZI = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aZI) && !new File(this.aZI).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gtX).mkdirs();
        this.gvc = new SelectCoverModel(getPageContext(), this);
        this.gvd = new SelectMusicModel(getPageContext(), this);
        this.gvb = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.h.root_layout));
        this.gvb.setData(this.aZI);
        this.gvd.bvW();
        this.eMi = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eMi.db(d.l.mixing);
        registerListener(this.gvp);
        TiebaStatic.log("c12303");
    }

    private void bvK() {
        this.vn = true;
        this.gvf = null;
        this.gve = null;
        alC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.gvb.getRootView());
        if (this.gvb != null) {
            this.gvb.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gvb != null) {
            this.gvb.onPause();
        }
        bvK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        File file;
        super.onResume();
        if (this.gvb != null) {
            this.gvb.onResume();
        }
        if (!this.gvk || TextUtils.isEmpty(this.gvh) || (file = new File(this.gvh)) == null || file.exists()) {
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bvT().bvU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gvb != null) {
            this.gvb.release();
        }
        if (this.gvc != null) {
            this.gvc.cancelLoadData();
        }
        if (this.gvd != null) {
            this.gvd.cancelLoadData();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gvb != null) {
            this.gvb.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        alC();
        k.s(new File(com.baidu.tieba.video.b.gtW));
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvL() {
        if (this.gvb != null && this.gvc != null && this.gvd != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.l.no_network);
            } else if (!this.gvg) {
                this.gvg = true;
                this.vn = false;
                this.gvf = null;
                this.gve = null;
                this.eMi.aH(true);
                this.gvb.onPause();
                bvN();
                bvM();
            }
        }
    }

    private void alC() {
        if (this.eMi != null) {
            this.eMi.aH(false);
        }
        this.gvg = false;
    }

    private void bvM() {
        if (this.vn) {
            this.vn = false;
        } else if (this.gvb.bwj()) {
            this.gvd.b(this.aZI, this.gvb.bwg(), com.baidu.tieba.video.b.gtW + "video_" + System.currentTimeMillis() + ".mp4", this.gvb.bwi() ? false : true);
        } else if (this.gvb.bwi()) {
            this.gvd.b(this.aZI, null, com.baidu.tieba.video.b.gtW + "video_" + System.currentTimeMillis() + ".mp4", this.gvb.bwi() ? false : true);
        } else {
            sA(this.aZI);
        }
    }

    private void bvN() {
        if (this.vn) {
            this.vn = false;
            return;
        }
        String text = this.gvb.getText();
        if (TextUtils.isEmpty(text)) {
            this.gvc.aA(this.aZI, this.gvb.getCurrentPosition());
        } else {
            this.gvc.pg(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvO() {
        this.vn = false;
        if (this.gvb.bwj() || this.gvb.bwi()) {
            this.gvg = false;
            this.eMi.aH(true);
            this.gvb.onPause();
            if (this.gvf != null) {
                sA(this.gvf);
                return;
            } else {
                bvM();
                return;
            }
        }
        if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
            File file = new File(this.aZI);
            k.aa(file.getAbsolutePath(), com.baidu.tieba.video.b.gtX + file.getName());
        }
        finishPage();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aSg() {
        if (this.gvb == null || this.gvc == null) {
            alC();
        } else if (this.vn) {
            this.vn = false;
        } else {
            this.gvc.aA(this.aZI, this.gvb.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void pc(String str) {
        if (this.vn) {
            this.vn = false;
        } else if (this.gvg) {
            showToast(str);
            alC();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void r(Bitmap bitmap) {
        if (this.gvb == null || this.gvc == null) {
            alC();
        } else if (this.vn) {
            this.vn = false;
        } else {
            if (!TextUtils.isEmpty(this.gvb.getText())) {
                bitmap = this.gvb.j(bitmap);
            }
            if (bitmap != null) {
                this.gvc.b(bitmap, com.baidu.tieba.video.b.gtV);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sz(String str) {
        if (this.vn) {
            this.vn = false;
            return;
        }
        this.gve = str;
        this.gvb.bwf();
        bvP();
    }

    private void bvP() {
        if (this.vn) {
            this.vn = false;
        } else if (!TextUtils.isEmpty(this.gve) && !TextUtils.isEmpty(this.gvf)) {
            this.mVideoInfo.setVideoPath(this.gvf);
            this.mVideoInfo.setThumbPath(this.gve);
            if (this.gvb.bwj() && !TextUtils.isEmpty(this.gvb.bwh())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gvb.bwh());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.azf, this.mForumName, this.gva, 13003, this.mVideoInfo)));
            alC();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void dz(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.l.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.l.music_cloud)));
        this.gvb.dz(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void sA(String str) {
        if (this.vn) {
            this.vn = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.l.mixing_fail);
            alC();
            this.gvb.onResume();
        } else {
            this.gvf = str;
            if (this.gvg) {
                bvP();
                return;
            }
            File file = new File(this.gvf);
            k.aa(file.getAbsolutePath(), com.baidu.tieba.video.b.gtX + file.getName());
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvQ() {
        this.gvf = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String sB = com.baidu.tieba.video.editvideo.model.a.bvT().sB(stringExtra);
                if (this.gvb != null && !TextUtils.isEmpty(sB)) {
                    this.gvb.ck(sB, stringExtra2);
                }
            }
        }
    }
}
