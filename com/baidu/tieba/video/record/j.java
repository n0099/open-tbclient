package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.model.a;
import com.baidu.tieba.video.record.d;
import com.baidu.tieba.video.record.i;
import java.io.File;
/* loaded from: classes2.dex */
public class j implements i.a {
    private MediaPlayer aXW;
    private com.baidu.tieba.j.h gOY;
    private SelectMusicModel hdn;
    private String hgn;
    private boolean hgr;
    private String hgs;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hdn = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bkr();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bkr() {
        if (this.aXW != null) {
            if (this.aXW.isPlaying()) {
                this.aXW.stop();
            }
            this.aXW.release();
            this.aXW = null;
        }
        this.hgn = null;
        this.hgs = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aXW != null && this.aXW.isPlaying()) {
                this.aXW.stop();
            }
            this.isDownLoading = false;
            this.hgs = musicData.id;
            String uL = com.baidu.tieba.video.editvideo.model.a.bBd().uL(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(uL)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hdB.setDrawBorder(false);
                    aVar.hdB.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bBd().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cr(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hdB.setDrawBorder(true);
                                aVar.hdB.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void uC(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hdB.setDrawBorder(true);
                                aVar.hdB.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.gOY != null) {
                                    j.this.gOY.ab(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAr() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hdB.setDrawBorder(true);
                                aVar.hdB.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBd().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cr(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uC(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.gOY != null) {
                            j.this.gOY.ab(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAr() {
                    }
                });
                return;
            }
            a(uL, musicData);
        }
    }

    public boolean bCJ() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hgr) {
            if (this.aXW == null) {
                this.aXW = new MediaPlayer();
                this.aXW.setAudioStreamType(3);
            }
            try {
                this.hgn = str;
                this.aXW.reset();
                this.aXW.setDataSource(str);
                this.aXW.prepare();
                this.aXW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aXW.setLooping(true);
                        j.this.aXW.start();
                    }
                });
                this.aXW.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.gOY != null) {
                            j.this.gOY.ab(4, "what-->" + i + "  extra-->" + i2);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                b(str, musicData);
            }
        }
    }

    private void b(String str, MusicData musicData) {
        this.hgn = null;
        bkr();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBd().bBe();
        }
        a((Object) null, musicData);
    }

    public String bCR() {
        return this.hgn;
    }

    public void onPause() {
        this.hgr = true;
        if (this.aXW != null && this.aXW.isPlaying()) {
            this.aXW.pause();
        }
    }

    public void onResume() {
        this.hgr = false;
        if (this.aXW != null) {
            this.aXW.start();
            this.aXW.seekTo(0);
        }
    }

    public void uR(int i) {
        if (this.aXW != null && this.aXW.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.aXW.getDuration()) {
                i %= this.aXW.getDuration();
            }
            this.aXW.seekTo(i);
            this.aXW.start();
        }
    }

    public void bCS() {
        if (this.aXW != null && this.aXW.isPlaying()) {
            this.aXW.pause();
        }
    }

    public void cs(String str, String str2) {
        this.hgr = false;
        this.hgn = str;
        this.hgs = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hgn) && !TextUtils.isEmpty(this.hgs)) {
            editVideoActivityConfig.addMusicInfo(this.hgn, this.hgs, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uQ(int i) {
    }
}
