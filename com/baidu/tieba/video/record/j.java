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
    private com.baidu.tieba.j.h kgF;
    private SelectMusicModel kvm;
    private String kya;
    private boolean kye;
    private String kyf;
    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kgF = lVar.cfr();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.kvm = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    aUk();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void aUk() {
        if (this.mMediaPlayer != null) {
            if (this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.kya = null;
        this.kyf = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.isDownLoading = false;
            this.kyf = musicData.id;
            String JN = com.baidu.tieba.video.editvideo.model.a.cOB().JN(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(JN)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.kvz.setDrawBorder(false);
                    aVar.kvz.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.cOB().a(musicData.id, musicData.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void eA(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.kvz.setDrawBorder(true);
                                aVar.kvz.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void JG(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.kvz.setDrawBorder(true);
                                aVar.kvz.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.kgF != null) {
                                    j.this.kgF.aP(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void cNR() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.kvz.setDrawBorder(true);
                                aVar.kvz.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cOB().a(musicData.id, musicData.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void eA(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void JG(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.kgF != null) {
                            j.this.kgF.aP(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void cNR() {
                    }
                });
                return;
            }
            a(JN, musicData);
        }
    }

    public boolean cQc() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.kye) {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setAudioStreamType(3);
            }
            try {
                this.kya = str;
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
                        if (j.this.kgF != null) {
                            j.this.kgF.aP(4, "what-->" + i + "  extra-->" + i2);
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
        this.kya = null;
        aUk();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cOB().cOC();
        }
        a((Object) null, musicData);
    }

    public String cQh() {
        return this.kya;
    }

    public void onPause() {
        this.kye = true;
        if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void onResume() {
        this.kye = false;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.start();
            this.mMediaPlayer.seekTo(0);
        }
    }

    public void DD(int i) {
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

    public void cQi() {
        if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void eB(String str, String str2) {
        this.kye = false;
        this.kya = str;
        this.kyf = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.kya) && !TextUtils.isEmpty(this.kyf)) {
            editVideoActivityConfig.addMusicInfo(this.kya, this.kyf, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DC(int i) {
    }
}
