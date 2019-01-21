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
    private MediaPlayer Wm;
    private SelectMusicModel hFK;
    private String hII;
    private boolean hIM;
    private String hIN;
    private com.baidu.tieba.j.h hqM;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hqM = lVar.bdZ();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hFK = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    Vh();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void Vh() {
        if (this.Wm != null) {
            if (this.Wm.isPlaying()) {
                this.Wm.stop();
            }
            this.Wm.release();
            this.Wm = null;
        }
        this.hII = null;
        this.hIN = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.Wm != null && this.Wm.isPlaying()) {
                this.Wm.stop();
            }
            this.isDownLoading = false;
            this.hIN = musicData.id;
            String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(xa)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hFY.setDrawBorder(false);
                    aVar.hFY.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bKk().a(musicData.id, musicData.resource, new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void cT(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hFY.setDrawBorder(true);
                                aVar.hFY.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void wS(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hFY.setDrawBorder(true);
                                aVar.hFY.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.hqM != null) {
                                    j.this.hqM.aa(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void bJy() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hFY.setDrawBorder(true);
                                aVar.hFY.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bKk().a(musicData.id, musicData.resource, new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void cT(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void wS(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.hqM != null) {
                            j.this.hqM.aa(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void bJy() {
                    }
                });
                return;
            }
            a(xa, musicData);
        }
    }

    public boolean bLP() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hIM) {
            if (this.Wm == null) {
                this.Wm = new MediaPlayer();
                this.Wm.setAudioStreamType(3);
            }
            try {
                this.hII = str;
                this.Wm.reset();
                this.Wm.setDataSource(str);
                this.Wm.prepare();
                this.Wm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.Wm.setLooping(true);
                        j.this.Wm.start();
                    }
                });
                this.Wm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.hqM != null) {
                            j.this.hqM.aa(4, "what-->" + i + "  extra-->" + i2);
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
        this.hII = null;
        Vh();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bKk().bKl();
        }
        a((Object) null, musicData);
    }

    public String bLX() {
        return this.hII;
    }

    public void onPause() {
        this.hIM = true;
        if (this.Wm != null && this.Wm.isPlaying()) {
            this.Wm.pause();
        }
    }

    public void onResume() {
        this.hIM = false;
        if (this.Wm != null) {
            this.Wm.start();
            this.Wm.seekTo(0);
        }
    }

    public void wU(int i) {
        if (this.Wm != null && this.Wm.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.Wm.getDuration()) {
                i %= this.Wm.getDuration();
            }
            this.Wm.seekTo(i);
            this.Wm.start();
        }
    }

    public void bLY() {
        if (this.Wm != null && this.Wm.isPlaying()) {
            this.Wm.pause();
        }
    }

    public void cU(String str, String str2) {
        this.hIM = false;
        this.hII = str;
        this.hIN = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hII) && !TextUtils.isEmpty(this.hIN)) {
            editVideoActivityConfig.addMusicInfo(this.hII, this.hIN, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wT(int i) {
    }
}
