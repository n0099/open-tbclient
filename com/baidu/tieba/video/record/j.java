package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.model.a;
import com.baidu.tieba.video.record.d;
import com.baidu.tieba.video.record.i;
import java.io.File;
/* loaded from: classes8.dex */
public class j implements i.a {
    private boolean isDownLoading;
    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private int mPosition;
    private SelectMusicModel nMr;
    private String nPj;
    private boolean nPn;
    private String nPo;
    private com.baidu.tieba.l.g nyu;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.nMr = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bfT();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bfT() {
        if (this.mMediaPlayer != null) {
            if (this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.nPj = null;
        this.nPo = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.isDownLoading = false;
            this.nPo = musicData.id;
            String Uu = com.baidu.tieba.video.editvideo.model.a.dSU().Uu(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(Uu)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.nMF.setDrawBorder(false);
                    aVar.nMF.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.dSU().a(musicData.id, musicData.resource, new a.InterfaceC0888a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                        public void gF(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.nMF.setDrawBorder(true);
                                aVar.nMF.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                        public void Uo(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.nMF.setDrawBorder(true);
                                aVar.nMF.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.nyu != null) {
                                    j.this.nyu.bK(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                        public void dSo() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.nMF.setDrawBorder(true);
                                aVar.nMF.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dSU().a(musicData.id, musicData.resource, new a.InterfaceC0888a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void gF(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void Uo(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.nyu != null) {
                            j.this.nyu.bK(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void dSo() {
                    }
                });
                return;
            }
            a(Uu, musicData);
        }
    }

    public boolean dUn() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.nPn) {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setAudioStreamType(3);
            }
            try {
                this.nPj = str;
                this.mMediaPlayer.reset();
                this.mMediaPlayer.setDataSource(str);
                this.mMediaPlayer.prepare();
                this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.mMediaPlayer.setLooping(true);
                        j.this.mMediaPlayer.start();
                    }
                });
                this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.nyu != null) {
                            j.this.nyu.bK(4, "what-->" + i + "  extra-->" + i2);
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
        this.nPj = null;
        bfT();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dSU().dSV();
        }
        a((Object) null, musicData);
    }

    public String dUt() {
        return this.nPj;
    }

    public void onPause() {
        this.nPn = true;
        if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void onResume() {
        this.nPn = false;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.start();
            this.mMediaPlayer.seekTo(0);
        }
    }

    public void KN(int i) {
        if (this.mMediaPlayer != null && this.mMediaPlayer.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.mMediaPlayer.getDuration()) {
                i %= this.mMediaPlayer.getDuration();
            }
            this.mMediaPlayer.seekTo(i);
            this.mMediaPlayer.start();
        }
    }

    public void dUu() {
        if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void gI(String str, String str2) {
        this.nPn = false;
        this.nPj = str;
        this.nPo = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.nPj) && !TextUtils.isEmpty(this.nPo)) {
            editVideoActivityConfig.addMusicInfo(this.nPj, this.nPo, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void KM(int i) {
    }
}
