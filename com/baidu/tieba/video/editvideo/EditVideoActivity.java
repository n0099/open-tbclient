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
    private String aZu;
    private String ayT;
    private com.baidu.tbadk.core.view.a eLU;
    private String guL;
    private com.baidu.tieba.video.editvideo.view.a guM;
    private SelectCoverModel guN;
    private SelectMusicModel guO;
    private String guP;
    private String guQ;
    private boolean guR;
    private String guS;
    private g guT;
    private com.baidu.tieba.video.commonview.a guX;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private boolean vo;
    private boolean guU = false;
    private boolean guV = false;
    private boolean guW = false;
    private Handler guY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            EditVideoActivity.this.guY.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (EditVideoActivity.this.guX != null && EditVideoActivity.this.guX.isShowing()) {
                        EditVideoActivity.this.guX.setPercent(message.arg1);
                    }
                    EditVideoActivity.this.guY.sendMessageDelayed(EditVideoActivity.this.guY.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!EditVideoActivity.this.guW) {
                        l.showToast(EditVideoActivity.this, d.l.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    EditVideoActivity.this.guV = true;
                    if (!StringUtils.isNull(EditVideoActivity.this.guS) && (file = new File(EditVideoActivity.this.guS)) != null) {
                        EditVideoActivity.this.guS = EditVideoActivity.this.guS.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(EditVideoActivity.this.guS));
                    }
                    EditVideoActivity.this.bvy();
                    if (!EditVideoActivity.this.guU) {
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(EditVideoActivity.this, d.l.mv_local_video_compress_failed);
                    g bvA = EditVideoActivity.this.bvA();
                    if (bvA != null && bvA.isConvertRunning()) {
                        EditVideoActivity.this.bvz();
                        return;
                    }
                    return;
                default:
                    return;
            }
            EditVideoActivity.this.guV = false;
            EditVideoActivity.this.bvy();
        }
    };
    private f guZ = new f() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
        @Override // com.baidu.tieba.video.localvideo.f
        public void bvI() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uv(int i) {
            EditVideoActivity.this.guY.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            EditVideoActivity.this.guY.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            EditVideoActivity.this.guY.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            EditVideoActivity.this.guY.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            EditVideoActivity.this.guY.sendEmptyMessage(4);
        }
    };
    private CustomMessageListener gva = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                EditVideoActivity.this.finishPage();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bvy() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.root_layout);
        if (relativeLayout != null && this.guX.getParent() != null) {
            relativeLayout.removeView(this.guX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvz() {
        bvA().abortConvert();
        this.guW = true;
        if (this.guS != null) {
            File file = new File(this.guS);
            if (file.exists()) {
                file.delete();
            }
        }
        bvy();
        this.guS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g bvA() {
        if (this.guT == null) {
            this.guT = new g(this);
            this.guT.a(this.guZ);
        }
        return this.guT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.activity_edit_video);
        this.ayT = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.guL = getIntent().getStringExtra("video_title");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aZu = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aZu) && !new File(this.aZu).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gtI).mkdirs();
        this.guN = new SelectCoverModel(getPageContext(), this);
        this.guO = new SelectMusicModel(getPageContext(), this);
        this.guM = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.h.root_layout));
        this.guM.setData(this.aZu);
        this.guO.bvN();
        this.eLU = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eLU.da(d.l.mixing);
        registerListener(this.gva);
        TiebaStatic.log("c12303");
    }

    private void bvB() {
        this.vo = true;
        this.guQ = null;
        this.guP = null;
        alx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.guM.getRootView());
        if (this.guM != null) {
            this.guM.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.guM != null) {
            this.guM.onPause();
        }
        bvB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        File file;
        super.onResume();
        if (this.guM != null) {
            this.guM.onResume();
        }
        if (!this.guV || TextUtils.isEmpty(this.guS) || (file = new File(this.guS)) == null || file.exists()) {
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bvK().bvL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.guM != null) {
            this.guM.release();
        }
        if (this.guN != null) {
            this.guN.cancelLoadData();
        }
        if (this.guO != null) {
            this.guO.cancelLoadData();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.guM != null) {
            this.guM.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        alx();
        k.s(new File(com.baidu.tieba.video.b.gtH));
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvC() {
        if (this.guM != null && this.guN != null && this.guO != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.l.no_network);
            } else if (!this.guR) {
                this.guR = true;
                this.vo = false;
                this.guQ = null;
                this.guP = null;
                this.eLU.aG(true);
                this.guM.onPause();
                bvE();
                bvD();
            }
        }
    }

    private void alx() {
        if (this.eLU != null) {
            this.eLU.aG(false);
        }
        this.guR = false;
    }

    private void bvD() {
        if (this.vo) {
            this.vo = false;
        } else if (this.guM.bwa()) {
            this.guO.b(this.aZu, this.guM.bvX(), com.baidu.tieba.video.b.gtH + "video_" + System.currentTimeMillis() + ".mp4", this.guM.bvZ() ? false : true);
        } else if (this.guM.bvZ()) {
            this.guO.b(this.aZu, null, com.baidu.tieba.video.b.gtH + "video_" + System.currentTimeMillis() + ".mp4", this.guM.bvZ() ? false : true);
        } else {
            sz(this.aZu);
        }
    }

    private void bvE() {
        if (this.vo) {
            this.vo = false;
            return;
        }
        String text = this.guM.getText();
        if (TextUtils.isEmpty(text)) {
            this.guN.aA(this.aZu, this.guM.getCurrentPosition());
        } else {
            this.guN.pf(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvF() {
        this.vo = false;
        if (this.guM.bwa() || this.guM.bvZ()) {
            this.guR = false;
            this.eLU.aG(true);
            this.guM.onPause();
            if (this.guQ != null) {
                sz(this.guQ);
                return;
            } else {
                bvD();
                return;
            }
        }
        if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
            File file = new File(this.aZu);
            k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gtI + file.getName());
        }
        finishPage();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aSb() {
        if (this.guM == null || this.guN == null) {
            alx();
        } else if (this.vo) {
            this.vo = false;
        } else {
            this.guN.aA(this.aZu, this.guM.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void pb(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (this.guR) {
            showToast(str);
            alx();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void r(Bitmap bitmap) {
        if (this.guM == null || this.guN == null) {
            alx();
        } else if (this.vo) {
            this.vo = false;
        } else {
            if (!TextUtils.isEmpty(this.guM.getText())) {
                bitmap = this.guM.j(bitmap);
            }
            if (bitmap != null) {
                this.guN.b(bitmap, com.baidu.tieba.video.b.gtG);
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sy(String str) {
        if (this.vo) {
            this.vo = false;
            return;
        }
        this.guP = str;
        this.guM.bvW();
        bvG();
    }

    private void bvG() {
        if (this.vo) {
            this.vo = false;
        } else if (!TextUtils.isEmpty(this.guP) && !TextUtils.isEmpty(this.guQ)) {
            this.mVideoInfo.setVideoPath(this.guQ);
            this.mVideoInfo.setThumbPath(this.guP);
            if (this.guM.bwa() && !TextUtils.isEmpty(this.guM.bvY())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.guM.bvY());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.ayT, this.mForumName, this.guL, 13003, this.mVideoInfo)));
            alx();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void dz(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.l.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.l.music_cloud)));
        this.guM.dz(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void sz(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.l.mixing_fail);
            alx();
            this.guM.onResume();
        } else {
            this.guQ = str;
            if (this.guR) {
                bvG();
                return;
            }
            File file = new File(this.guQ);
            k.Z(file.getAbsolutePath(), com.baidu.tieba.video.b.gtI + file.getName());
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvH() {
        this.guQ = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String sA = com.baidu.tieba.video.editvideo.model.a.bvK().sA(stringExtra);
                if (this.guM != null && !TextUtils.isEmpty(sA)) {
                    this.guM.cj(sA, stringExtra2);
                }
            }
        }
    }
}
