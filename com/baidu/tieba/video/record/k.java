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
    private MediaPlayer bTh;
    private com.baidu.tieba.i.h hca;
    private SelectMusicModel hpJ;
    private String hsL;
    private boolean hsP;
    private String hsQ;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hpJ = selectMusicModel;
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
        if (this.bTh != null) {
            if (this.bTh.isPlaying()) {
                this.bTh.stop();
            }
            this.bTh.release();
            this.bTh = null;
        }
        this.hsL = null;
        this.hsQ = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bTh != null && this.bTh.isPlaying()) {
                this.bTh.stop();
            }
            this.isDownLoading = false;
            this.hsQ = musicData.id;
            String tN = com.baidu.tieba.video.editvideo.model.a.bBI().tN(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tN)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hpY.setDrawBorder(false);
                    aVar.hpY.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bBI().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cj(String str, String str2) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                k.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hpY.setDrawBorder(true);
                                aVar.hpY.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void tE(String str) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hpY.setDrawBorder(true);
                                aVar.hpY.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (k.this.hca != null) {
                                    k.this.hca.U(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAW() {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.hpY.setDrawBorder(true);
                                aVar.hpY.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBI().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.k.2
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
                        if (k.this.hca != null) {
                            k.this.hca.U(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAW() {
                    }
                });
                return;
            }
            a(tN, musicData);
        }
    }

    public boolean bDC() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hsP) {
            if (this.bTh == null) {
                this.bTh = new MediaPlayer();
                this.bTh.setAudioStreamType(3);
            }
            try {
                this.hsL = str;
                this.bTh.reset();
                this.bTh.setDataSource(str);
                this.bTh.prepare();
                this.bTh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bTh.setLooping(true);
                        k.this.bTh.start();
                    }
                });
                this.bTh.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.hca != null) {
                            k.this.hca.U(4, "what-->" + i + "  extra-->" + i2);
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
        this.hsL = null;
        blr();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBI().bBJ();
        }
        a((Object) null, musicData);
    }

    public String bDJ() {
        return this.hsL;
    }

    public void onPause() {
        this.hsP = true;
        if (this.bTh != null && this.bTh.isPlaying()) {
            this.bTh.pause();
        }
    }

    public void onResume() {
        this.hsP = false;
        if (this.bTh != null) {
            this.bTh.start();
            this.bTh.seekTo(0);
        }
    }

    public void wW(int i) {
        if (this.bTh != null && this.bTh.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bTh.getDuration()) {
                i %= this.bTh.getDuration();
            }
            this.bTh.seekTo(i);
            this.bTh.start();
        }
    }

    public void bDK() {
        if (this.bTh != null && this.bTh.isPlaying()) {
            this.bTh.pause();
        }
    }

    public void bDL() {
        blr();
    }

    public void ck(String str, String str2) {
        this.hsP = false;
        this.hsL = str;
        this.hsQ = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hsL) && !TextUtils.isEmpty(this.hsQ)) {
            editVideoActivityConfig.addMusicInfo(this.hsL, this.hsQ, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
    }
}
