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
    private com.baidu.tieba.j.h iZT;
    private boolean isDownLoading;
    private SelectMusicModel joY;
    private String jrR;
    private boolean jrV;
    private String jrW;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.joY = selectMusicModel;
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
        this.jrR = null;
        this.jrW = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bzd != null && this.bzd.isPlaying()) {
                this.bzd.stop();
            }
            this.isDownLoading = false;
            this.jrW = musicData.id;
            String EW = com.baidu.tieba.video.editvideo.model.a.crN().EW(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(EW)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.jpm.setDrawBorder(false);
                    aVar.jpm.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.crN().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void er(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jpm.setDrawBorder(true);
                                aVar.jpm.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void EO(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jpm.setDrawBorder(true);
                                aVar.jpm.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.iZT != null) {
                                    j.this.iZT.av(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void crb() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.jpm.setDrawBorder(true);
                                aVar.jpm.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.crN().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EO(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.iZT != null) {
                            j.this.iZT.av(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void crb() {
                    }
                });
                return;
            }
            a(EW, musicData);
        }
    }

    public boolean ctt() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.jrV) {
            if (this.bzd == null) {
                this.bzd = new MediaPlayer();
                this.bzd.setAudioStreamType(3);
            }
            try {
                this.jrR = str;
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
                        if (j.this.iZT != null) {
                            j.this.iZT.av(4, "what-->" + i + "  extra-->" + i2);
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
        this.jrR = null;
        aAl();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.crN().crO();
        }
        a((Object) null, musicData);
    }

    public String ctB() {
        return this.jrR;
    }

    public void onPause() {
        this.jrV = true;
        if (this.bzd != null && this.bzd.isPlaying()) {
            this.bzd.pause();
        }
    }

    public void onResume() {
        this.jrV = false;
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

    public void ctC() {
        if (this.bzd != null && this.bzd.isPlaying()) {
            this.bzd.pause();
        }
    }

    public void es(String str, String str2) {
        this.jrV = false;
        this.jrR = str;
        this.jrW = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.jrR) && !TextUtils.isEmpty(this.jrW)) {
            editVideoActivityConfig.addMusicInfo(this.jrR, this.jrW, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void BJ(int i) {
    }
}
