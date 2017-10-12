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
    private String guZ;
    private com.baidu.tieba.video.editvideo.view.a gva;
    private SelectCoverModel gvb;
    private SelectMusicModel gvc;
    private String gvd;
    private String gve;
    private boolean gvf;
    private String gvg;
    private g gvh;
    private com.baidu.tieba.video.commonview.a gvl;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private boolean vn;
    private boolean gvi = false;
    private boolean gvj = false;
    private boolean gvk = false;
    private Handler gvm = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            EditVideoActivity.this.gvm.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (EditVideoActivity.this.gvl != null && EditVideoActivity.this.gvl.isShowing()) {
                        EditVideoActivity.this.gvl.setPercent(message.arg1);
                    }
                    EditVideoActivity.this.gvm.sendMessageDelayed(EditVideoActivity.this.gvm.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!EditVideoActivity.this.gvk) {
                        l.showToast(EditVideoActivity.this, d.l.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    EditVideoActivity.this.gvj = true;
                    if (!StringUtils.isNull(EditVideoActivity.this.gvg) && (file = new File(EditVideoActivity.this.gvg)) != null) {
                        EditVideoActivity.this.gvg = EditVideoActivity.this.gvg.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(EditVideoActivity.this.gvg));
                    }
                    EditVideoActivity.this.bvG();
                    if (!EditVideoActivity.this.gvi) {
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(EditVideoActivity.this, d.l.mv_local_video_compress_failed);
                    g bvI = EditVideoActivity.this.bvI();
                    if (bvI != null && bvI.isConvertRunning()) {
                        EditVideoActivity.this.bvH();
                        return;
                    }
                    return;
                default:
                    return;
            }
            EditVideoActivity.this.gvj = false;
            EditVideoActivity.this.bvG();
        }
    };
    private f gvn = new f() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
        @Override // com.baidu.tieba.video.localvideo.f
        public void bvQ() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uw(int i) {
            EditVideoActivity.this.gvm.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            EditVideoActivity.this.gvm.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            EditVideoActivity.this.gvm.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            EditVideoActivity.this.gvm.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            EditVideoActivity.this.gvm.sendEmptyMessage(4);
        }
    };
    private CustomMessageListener gvo = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                EditVideoActivity.this.finishPage();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bvG() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.root_layout);
        if (relativeLayout != null && this.gvl.getParent() != null) {
            relativeLayout.removeView(this.gvl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvH() {
        bvI().abortConvert();
        this.gvk = true;
        if (this.gvg != null) {
            File file = new File(this.gvg);
            if (file.exists()) {
                file.delete();
            }
        }
        bvG();
        this.gvg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g bvI() {
        if (this.gvh == null) {
            this.gvh = new g(this);
            this.gvh.a(this.gvn);
        }
        return this.gvh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.activity_edit_video);
        this.azf = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.guZ = getIntent().getStringExtra("video_title");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aZI = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aZI) && !new File(this.aZI).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gtW).mkdirs();
        this.gvb = new SelectCoverModel(getPageContext(), this);
        this.gvc = new SelectMusicModel(getPageContext(), this);
        this.gva = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.h.root_layout));
        this.gva.setData(this.aZI);
        this.gvc.bvV();
        this.eMi = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eMi.db(d.l.mixing);
        registerListener(this.gvo);
        TiebaStatic.log("c12303");
    }

    private void bvJ() {
        this.vn = true;
        this.gve = null;
        this.gvd = null;
        alC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.gva.getRootView());
        if (this.gva != null) {
            this.gva.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gva != null) {
            this.gva.onPause();
        }
        bvJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        File file;
        super.onResume();
        if (this.gva != null) {
            this.gva.onResume();
        }
        if (!this.gvj || TextUtils.isEmpty(this.gvg) || (file = new File(this.gvg)) == null || file.exists()) {
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bvS().bvT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gva != null) {
            this.gva.release();
        }
        if (this.gvb != null) {
            this.gvb.cancelLoadData();
        }
        if (this.gvc != null) {
            this.gvc.cancelLoadData();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gva != null) {
            this.gva.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        alC();
        k.s(new File(com.baidu.tieba.video.b.gtV));
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvK() {
        if (this.gva != null && this.gvb != null && this.gvc != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.l.no_network);
            } else if (!this.gvf) {
                this.gvf = true;
                this.vn = false;
                this.gve = null;
                this.gvd = null;
                this.eMi.aH(true);
                this.gva.onPause();
                bvM();
                bvL();
            }
        }
    }

    private void alC() {
        if (this.eMi != null) {
            this.eMi.aH(false);
        }
        this.gvf = false;
    }

    private void bvL() {
        if (this.vn) {
            this.vn = false;
        } else if (this.gva.bwi()) {
            this.gvc.b(this.aZI, this.gva.bwf(), com.baidu.tieba.video.b.gtV + "video_" + System.currentTimeMillis() + ".mp4", this.gva.bwh() ? false : true);
        } else if (this.gva.bwh()) {
            this.gvc.b(this.aZI, null, com.baidu.tieba.video.b.gtV + "video_" + System.currentTimeMillis() + ".mp4", this.gva.bwh() ? false : true);
        } else {
            sA(this.aZI);
        }
    }

    private void bvM() {
        if (this.vn) {
            this.vn = false;
            return;
        }
        String text = this.gva.getText();
        if (TextUtils.isEmpty(text)) {
            this.gvb.aA(this.aZI, this.gva.getCurrentPosition());
        } else {
            this.gvb.pg(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvN() {
        this.vn = false;
        if (this.gva.bwi() || this.gva.bwh()) {
            this.gvf = false;
            this.eMi.aH(true);
            this.gva.onPause();
            if (this.gve != null) {
                sA(this.gve);
                return;
            } else {
                bvL();
                return;
            }
        }
        if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
            File file = new File(this.aZI);
            k.aa(file.getAbsolutePath(), com.baidu.tieba.video.b.gtW + file.getName());
        }
        finishPage();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aSg() {
        if (this.gva == null || this.gvb == null) {
            alC();
        } else if (this.vn) {
            this.vn = false;
        } else {
            this.gvb.aA(this.aZI, this.gva.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void pc(String str) {
        if (this.vn) {
            this.vn = false;
        } else if (this.gvf) {
            showToast(str);
            alC();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void r(Bitmap bitmap) {
        if (this.gva == null || this.gvb == null) {
            alC();
        } else if (this.vn) {
            this.vn = false;
        } else {
            if (!TextUtils.isEmpty(this.gva.getText())) {
                bitmap = this.gva.j(bitmap);
            }
            if (bitmap != null) {
                this.gvb.b(bitmap, com.baidu.tieba.video.b.gtU);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sz(String str) {
        if (this.vn) {
            this.vn = false;
            return;
        }
        this.gvd = str;
        this.gva.bwe();
        bvO();
    }

    private void bvO() {
        if (this.vn) {
            this.vn = false;
        } else if (!TextUtils.isEmpty(this.gvd) && !TextUtils.isEmpty(this.gve)) {
            this.mVideoInfo.setVideoPath(this.gve);
            this.mVideoInfo.setThumbPath(this.gvd);
            if (this.gva.bwi() && !TextUtils.isEmpty(this.gva.bwg())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gva.bwg());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.azf, this.mForumName, this.guZ, 13003, this.mVideoInfo)));
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
        this.gva.dz(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void sA(String str) {
        if (this.vn) {
            this.vn = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.l.mixing_fail);
            alC();
            this.gva.onResume();
        } else {
            this.gve = str;
            if (this.gvf) {
                bvO();
                return;
            }
            File file = new File(this.gve);
            k.aa(file.getAbsolutePath(), com.baidu.tieba.video.b.gtW + file.getName());
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvP() {
        this.gve = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String sB = com.baidu.tieba.video.editvideo.model.a.bvS().sB(stringExtra);
                if (this.gva != null && !TextUtils.isEmpty(sB)) {
                    this.gva.ck(sB, stringExtra2);
                }
            }
        }
    }
}
