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
/* loaded from: classes5.dex */
public class j implements i.a {
    private MediaPlayer Wd;
    private SelectMusicModel hEC;
    private String hHA;
    private boolean hHE;
    private String hHF;
    private com.baidu.tieba.j.h hpD;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hEC = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    UL();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void UL() {
        if (this.Wd != null) {
            if (this.Wd.isPlaying()) {
                this.Wd.stop();
            }
            this.Wd.release();
            this.Wd = null;
        }
        this.hHA = null;
        this.hHF = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.Wd != null && this.Wd.isPlaying()) {
                this.Wd.stop();
            }
            this.isDownLoading = false;
            this.hHF = musicData.id;
            String wK = com.baidu.tieba.video.editvideo.model.a.bJB().wK(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(wK)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hEQ.setDrawBorder(false);
                    aVar.hEQ.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bJB().a(musicData.id, musicData.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void cR(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hEQ.setDrawBorder(true);
                                aVar.hEQ.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void wC(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hEQ.setDrawBorder(true);
                                aVar.hEQ.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.hpD != null) {
                                    j.this.hpD.Y(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void bIP() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hEQ.setDrawBorder(true);
                                aVar.hEQ.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bJB().a(musicData.id, musicData.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void cR(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void wC(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.hpD != null) {
                            j.this.hpD.Y(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void bIP() {
                    }
                });
                return;
            }
            a(wK, musicData);
        }
    }

    public boolean bLg() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hHE) {
            if (this.Wd == null) {
                this.Wd = new MediaPlayer();
                this.Wd.setAudioStreamType(3);
            }
            try {
                this.hHA = str;
                this.Wd.reset();
                this.Wd.setDataSource(str);
                this.Wd.prepare();
                this.Wd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.Wd.setLooping(true);
                        j.this.Wd.start();
                    }
                });
                this.Wd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.hpD != null) {
                            j.this.hpD.Y(4, "what-->" + i + "  extra-->" + i2);
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
        this.hHA = null;
        UL();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bJB().bJC();
        }
        a((Object) null, musicData);
    }

    public String bLo() {
        return this.hHA;
    }

    public void onPause() {
        this.hHE = true;
        if (this.Wd != null && this.Wd.isPlaying()) {
            this.Wd.pause();
        }
    }

    public void onResume() {
        this.hHE = false;
        if (this.Wd != null) {
            this.Wd.start();
            this.Wd.seekTo(0);
        }
    }

    public void wR(int i) {
        if (this.Wd != null && this.Wd.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.Wd.getDuration()) {
                i %= this.Wd.getDuration();
            }
            this.Wd.seekTo(i);
            this.Wd.start();
        }
    }

    public void bLp() {
        if (this.Wd != null && this.Wd.isPlaying()) {
            this.Wd.pause();
        }
    }

    public void cS(String str, String str2) {
        this.hHE = false;
        this.hHA = str;
        this.hHF = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hHA) && !TextUtils.isEmpty(this.hHF)) {
            editVideoActivityConfig.addMusicInfo(this.hHA, this.hHF, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wQ(int i) {
    }
}
