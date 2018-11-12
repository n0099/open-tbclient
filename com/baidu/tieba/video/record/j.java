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
    private com.baidu.tieba.j.h hfy;
    private SelectMusicModel huf;
    private String hxd;
    private boolean hxh;
    private String hxi;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.huf = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    TD();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void TD() {
        if (this.Wd != null) {
            if (this.Wd.isPlaying()) {
                this.Wd.stop();
            }
            this.Wd.release();
            this.Wd = null;
        }
        this.hxd = null;
        this.hxi = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.Wd != null && this.Wd.isPlaying()) {
                this.Wd.stop();
            }
            this.isDownLoading = false;
            this.hxi = musicData.id;
            String we = com.baidu.tieba.video.editvideo.model.a.bGH().we(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(we)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hut.setDrawBorder(false);
                    aVar.hut.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bGH().a(musicData.id, musicData.resource, new a.InterfaceC0311a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                        public void cM(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hut.setDrawBorder(true);
                                aVar.hut.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                        public void vW(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hut.setDrawBorder(true);
                                aVar.hut.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.hfy != null) {
                                    j.this.hfy.X(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                        public void bFV() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hut.setDrawBorder(true);
                                aVar.hut.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bGH().a(musicData.id, musicData.resource, new a.InterfaceC0311a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void vW(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.hfy != null) {
                            j.this.hfy.X(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void bFV() {
                    }
                });
                return;
            }
            a(we, musicData);
        }
    }

    public boolean bIm() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hxh) {
            if (this.Wd == null) {
                this.Wd = new MediaPlayer();
                this.Wd.setAudioStreamType(3);
            }
            try {
                this.hxd = str;
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
                        if (j.this.hfy != null) {
                            j.this.hfy.X(4, "what-->" + i + "  extra-->" + i2);
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
        this.hxd = null;
        TD();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bGH().bGI();
        }
        a((Object) null, musicData);
    }

    public String bIu() {
        return this.hxd;
    }

    public void onPause() {
        this.hxh = true;
        if (this.Wd != null && this.Wd.isPlaying()) {
            this.Wd.pause();
        }
    }

    public void onResume() {
        this.hxh = false;
        if (this.Wd != null) {
            this.Wd.start();
            this.Wd.seekTo(0);
        }
    }

    public void wh(int i) {
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

    public void bIv() {
        if (this.Wd != null && this.Wd.isPlaying()) {
            this.Wd.pause();
        }
    }

    public void cN(String str, String str2) {
        this.hxh = false;
        this.hxd = str;
        this.hxi = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hxd) && !TextUtils.isEmpty(this.hxi)) {
            editVideoActivityConfig.addMusicInfo(this.hxd, this.hxi, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wg(int i) {
    }
}
