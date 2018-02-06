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
import com.baidu.tieba.video.record.j;
import java.io.File;
/* loaded from: classes2.dex */
public class k implements j.a {
    private MediaPlayer bTq;
    private com.baidu.tieba.i.h hbR;
    private SelectMusicModel hpy;
    private String hsA;
    private boolean hsE;
    private String hsF;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hpy = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    blr();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void blr() {
        if (this.bTq != null) {
            if (this.bTq.isPlaying()) {
                this.bTq.stop();
            }
            this.bTq.release();
            this.bTq = null;
        }
        this.hsA = null;
        this.hsF = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bTq != null && this.bTq.isPlaying()) {
                this.bTq.stop();
            }
            this.isDownLoading = false;
            this.hsF = musicData.id;
            String tN = com.baidu.tieba.video.editvideo.model.a.bBE().tN(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tN)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hpN.setDrawBorder(false);
                    aVar.hpN.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bBE().a(musicData.id, musicData.resource, new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                        public void cj(String str, String str2) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                k.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hpN.setDrawBorder(true);
                                aVar.hpN.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                        public void tE(String str) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hpN.setDrawBorder(true);
                                aVar.hpN.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (k.this.hbR != null) {
                                    k.this.hbR.U(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                        public void bAS() {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.hpN.setDrawBorder(true);
                                aVar.hpN.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBE().a(musicData.id, musicData.resource, new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void tE(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.hbR != null) {
                            k.this.hbR.U(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void bAS() {
                    }
                });
                return;
            }
            a(tN, musicData);
        }
    }

    public boolean bDy() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hsE) {
            if (this.bTq == null) {
                this.bTq = new MediaPlayer();
                this.bTq.setAudioStreamType(3);
            }
            try {
                this.hsA = str;
                this.bTq.reset();
                this.bTq.setDataSource(str);
                this.bTq.prepare();
                this.bTq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bTq.setLooping(true);
                        k.this.bTq.start();
                    }
                });
                this.bTq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.hbR != null) {
                            k.this.hbR.U(4, "what-->" + i + "  extra-->" + i2);
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
        this.hsA = null;
        blr();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBE().bBF();
        }
        a((Object) null, musicData);
    }

    public String bDF() {
        return this.hsA;
    }

    public void onPause() {
        this.hsE = true;
        if (this.bTq != null && this.bTq.isPlaying()) {
            this.bTq.pause();
        }
    }

    public void onResume() {
        this.hsE = false;
        if (this.bTq != null) {
            this.bTq.start();
            this.bTq.seekTo(0);
        }
    }

    public void wV(int i) {
        if (this.bTq != null && this.bTq.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bTq.getDuration()) {
                i %= this.bTq.getDuration();
            }
            this.bTq.seekTo(i);
            this.bTq.start();
        }
    }

    public void bDG() {
        if (this.bTq != null && this.bTq.isPlaying()) {
            this.bTq.pause();
        }
    }

    public void bDH() {
        blr();
    }

    public void ck(String str, String str2) {
        this.hsE = false;
        this.hsA = str;
        this.hsF = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hsA) && !TextUtils.isEmpty(this.hsF)) {
            editVideoActivityConfig.addMusicInfo(this.hsA, this.hsF, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wU(int i) {
    }
}
