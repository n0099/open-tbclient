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
    private MediaPlayer bAa;
    private boolean isDownLoading;
    private com.baidu.tieba.j.h jgo;
    private SelectMusicModel jvj;
    private String jyc;
    private boolean jyg;
    private String jyh;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.jvj = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    aBA();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void aBA() {
        if (this.bAa != null) {
            if (this.bAa.isPlaying()) {
                this.bAa.stop();
            }
            this.bAa.release();
            this.bAa = null;
        }
        this.jyc = null;
        this.jyh = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bAa != null && this.bAa.isPlaying()) {
                this.bAa.stop();
            }
            this.isDownLoading = false;
            this.jyh = musicData.id;
            String FM = com.baidu.tieba.video.editvideo.model.a.cuz().FM(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(FM)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.jvx.setDrawBorder(false);
                    aVar.jvx.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.cuz().a(musicData.id, musicData.resource, new a.InterfaceC0416a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                        public void es(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jvx.setDrawBorder(true);
                                aVar.jvx.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                        public void FE(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jvx.setDrawBorder(true);
                                aVar.jvx.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.jgo != null) {
                                    j.this.jgo.av(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                        public void ctN() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.jvx.setDrawBorder(true);
                                aVar.jvx.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cuz().a(musicData.id, musicData.resource, new a.InterfaceC0416a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                    public void es(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                    public void FE(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.jgo != null) {
                            j.this.jgo.av(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                    public void ctN() {
                    }
                });
                return;
            }
            a(FM, musicData);
        }
    }

    public boolean cwh() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.jyg) {
            if (this.bAa == null) {
                this.bAa = new MediaPlayer();
                this.bAa.setAudioStreamType(3);
            }
            try {
                this.jyc = str;
                this.bAa.reset();
                this.bAa.setDataSource(str);
                this.bAa.prepare();
                this.bAa.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bAa.setLooping(true);
                        j.this.bAa.start();
                    }
                });
                this.bAa.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.jgo != null) {
                            j.this.jgo.av(4, "what-->" + i + "  extra-->" + i2);
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
        this.jyc = null;
        aBA();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cuz().cuA();
        }
        a((Object) null, musicData);
    }

    public String cwp() {
        return this.jyc;
    }

    public void onPause() {
        this.jyg = true;
        if (this.bAa != null && this.bAa.isPlaying()) {
            this.bAa.pause();
        }
    }

    public void onResume() {
        this.jyg = false;
        if (this.bAa != null) {
            this.bAa.start();
            this.bAa.seekTo(0);
        }
    }

    public void Cr(int i) {
        if (this.bAa != null && this.bAa.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bAa.getDuration()) {
                i %= this.bAa.getDuration();
            }
            this.bAa.seekTo(i);
            this.bAa.start();
        }
    }

    public void cwq() {
        if (this.bAa != null && this.bAa.isPlaying()) {
            this.bAa.pause();
        }
    }

    public void et(String str, String str2) {
        this.jyg = false;
        this.jyc = str;
        this.jyh = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.jyc) && !TextUtils.isEmpty(this.jyh)) {
            editVideoActivityConfig.addMusicInfo(this.jyc, this.jyh, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Cq(int i) {
    }
}
