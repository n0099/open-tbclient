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
    private MediaPlayer bTe;
    private com.baidu.tieba.i.h hbC;
    private SelectMusicModel hpl;
    private String hsm;
    private boolean hsq;
    private String hsr;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hpl = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    blq();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void blq() {
        if (this.bTe != null) {
            if (this.bTe.isPlaying()) {
                this.bTe.stop();
            }
            this.bTe.release();
            this.bTe = null;
        }
        this.hsm = null;
        this.hsr = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bTe != null && this.bTe.isPlaying()) {
                this.bTe.stop();
            }
            this.isDownLoading = false;
            this.hsr = musicData.id;
            String tN = com.baidu.tieba.video.editvideo.model.a.bBD().tN(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tN)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hpA.setDrawBorder(false);
                    aVar.hpA.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bBD().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cj(String str, String str2) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                k.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hpA.setDrawBorder(true);
                                aVar.hpA.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void tE(String str) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hpA.setDrawBorder(true);
                                aVar.hpA.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (k.this.hbC != null) {
                                    k.this.hbC.U(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAR() {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.hpA.setDrawBorder(true);
                                aVar.hpA.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBD().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void tE(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.hbC != null) {
                            k.this.hbC.U(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAR() {
                    }
                });
                return;
            }
            a(tN, musicData);
        }
    }

    public boolean bDx() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hsq) {
            if (this.bTe == null) {
                this.bTe = new MediaPlayer();
                this.bTe.setAudioStreamType(3);
            }
            try {
                this.hsm = str;
                this.bTe.reset();
                this.bTe.setDataSource(str);
                this.bTe.prepare();
                this.bTe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bTe.setLooping(true);
                        k.this.bTe.start();
                    }
                });
                this.bTe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.hbC != null) {
                            k.this.hbC.U(4, "what-->" + i + "  extra-->" + i2);
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
        this.hsm = null;
        blq();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBD().bBE();
        }
        a((Object) null, musicData);
    }

    public String bDE() {
        return this.hsm;
    }

    public void onPause() {
        this.hsq = true;
        if (this.bTe != null && this.bTe.isPlaying()) {
            this.bTe.pause();
        }
    }

    public void onResume() {
        this.hsq = false;
        if (this.bTe != null) {
            this.bTe.start();
            this.bTe.seekTo(0);
        }
    }

    public void wW(int i) {
        if (this.bTe != null && this.bTe.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bTe.getDuration()) {
                i %= this.bTe.getDuration();
            }
            this.bTe.seekTo(i);
            this.bTe.start();
        }
    }

    public void bDF() {
        if (this.bTe != null && this.bTe.isPlaying()) {
            this.bTe.pause();
        }
    }

    public void bDG() {
        blq();
    }

    public void ck(String str, String str2) {
        this.hsq = false;
        this.hsm = str;
        this.hsr = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hsm) && !TextUtils.isEmpty(this.hsr)) {
            editVideoActivityConfig.addMusicInfo(this.hsm, this.hsr, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
    }
}
