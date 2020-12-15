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
/* loaded from: classes23.dex */
public class j implements i.a {
    private boolean isDownLoading;
    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private int mPosition;
    private SelectMusicModel nCF;
    private boolean nFD;
    private String nFE;
    private String nFz;
    private com.baidu.tieba.l.h nnd;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.nCF = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bhc();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bhc() {
        if (this.mMediaPlayer != null) {
            if (this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.nFz = null;
        this.nFE = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.isDownLoading = false;
            this.nFE = musicData.id;
            String UM = com.baidu.tieba.video.editvideo.model.a.dUB().UM(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(UM)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.nCV.setDrawBorder(false);
                    aVar.nCV.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.dUB().a(musicData.id, musicData.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void gB(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.nCV.setDrawBorder(true);
                                aVar.nCV.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void UG(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.nCV.setDrawBorder(true);
                                aVar.nCV.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.nnd != null) {
                                    j.this.nnd.bD(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void dTV() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.nCV.setDrawBorder(true);
                                aVar.nCV.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dUB().a(musicData.id, musicData.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void gB(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void UG(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.nnd != null) {
                            j.this.nnd.bD(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void dTV() {
                    }
                });
                return;
            }
            a(UM, musicData);
        }
    }

    public boolean dWj() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.nFD) {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setAudioStreamType(3);
            }
            try {
                this.nFz = str;
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
                        if (j.this.nnd != null) {
                            j.this.nnd.bD(4, "what-->" + i + "  extra-->" + i2);
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
        this.nFz = null;
        bhc();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dUB().dUC();
        }
        a((Object) null, musicData);
    }

    public String dWp() {
        return this.nFz;
    }

    public void onPause() {
        this.nFD = true;
        if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void onResume() {
        this.nFD = false;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.start();
            this.mMediaPlayer.seekTo(0);
        }
    }

    public void Mn(int i) {
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

    public void dWq() {
        if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void gE(String str, String str2) {
        this.nFD = false;
        this.nFz = str;
        this.nFE = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.nFz) && !TextUtils.isEmpty(this.nFE)) {
            editVideoActivityConfig.addMusicInfo(this.nFz, this.nFE, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Mm(int i) {
    }
}
