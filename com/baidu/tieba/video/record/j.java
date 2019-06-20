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
    private MediaPlayer bzd;
    private com.baidu.tieba.j.h iZX;
    private boolean isDownLoading;
    private SelectMusicModel jpc;
    private String jrU;
    private boolean jrY;
    private String jrZ;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZX = lVar.bMo();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.jpc = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    aAl();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void aAl() {
        if (this.bzd != null) {
            if (this.bzd.isPlaying()) {
                this.bzd.stop();
            }
            this.bzd.release();
            this.bzd = null;
        }
        this.jrU = null;
        this.jrZ = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bzd != null && this.bzd.isPlaying()) {
                this.bzd.stop();
            }
            this.isDownLoading = false;
            this.jrZ = musicData.id;
            String EY = com.baidu.tieba.video.editvideo.model.a.crM().EY(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(EY)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.jpq.setDrawBorder(false);
                    aVar.jpq.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.crM().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void er(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jpq.setDrawBorder(true);
                                aVar.jpq.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void EQ(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jpq.setDrawBorder(true);
                                aVar.jpq.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.iZX != null) {
                                    j.this.iZX.av(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void crc() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.jpq.setDrawBorder(true);
                                aVar.jpq.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.crM().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EQ(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.iZX != null) {
                            j.this.iZX.av(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void crc() {
                    }
                });
                return;
            }
            a(EY, musicData);
        }
    }

    public boolean cts() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.jrY) {
            if (this.bzd == null) {
                this.bzd = new MediaPlayer();
                this.bzd.setAudioStreamType(3);
            }
            try {
                this.jrU = str;
                this.bzd.reset();
                this.bzd.setDataSource(str);
                this.bzd.prepare();
                this.bzd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bzd.setLooping(true);
                        j.this.bzd.start();
                    }
                });
                this.bzd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.iZX != null) {
                            j.this.iZX.av(4, "what-->" + i + "  extra-->" + i2);
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
        this.jrU = null;
        aAl();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.crM().crN();
        }
        a((Object) null, musicData);
    }

    public String ctA() {
        return this.jrU;
    }

    public void onPause() {
        this.jrY = true;
        if (this.bzd != null && this.bzd.isPlaying()) {
            this.bzd.pause();
        }
    }

    public void onResume() {
        this.jrY = false;
        if (this.bzd != null) {
            this.bzd.start();
            this.bzd.seekTo(0);
        }
    }

    public void BK(int i) {
        if (this.bzd != null && this.bzd.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bzd.getDuration()) {
                i %= this.bzd.getDuration();
            }
            this.bzd.seekTo(i);
            this.bzd.start();
        }
    }

    public void ctB() {
        if (this.bzd != null && this.bzd.isPlaying()) {
            this.bzd.pause();
        }
    }

    public void es(String str, String str2) {
        this.jrY = false;
        this.jrU = str;
        this.jrZ = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.jrU) && !TextUtils.isEmpty(this.jrZ)) {
            editVideoActivityConfig.addMusicInfo(this.jrU, this.jrZ, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void BJ(int i) {
    }
}
