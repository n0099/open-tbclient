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
/* loaded from: classes2.dex */
public class j implements i.a {
    private MediaPlayer aWV;
    private com.baidu.tieba.j.h gJZ;
    private SelectMusicModel gXV;
    private String haT;
    private boolean haX;
    private String haY;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gXV = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    blv();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void blv() {
        if (this.aWV != null) {
            if (this.aWV.isPlaying()) {
                this.aWV.stop();
            }
            this.aWV.release();
            this.aWV = null;
        }
        this.haT = null;
        this.haY = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aWV != null && this.aWV.isPlaying()) {
                this.aWV.stop();
            }
            this.isDownLoading = false;
            this.haY = musicData.id;
            String uR = com.baidu.tieba.video.editvideo.model.a.bBS().uR(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(uR)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gYk.setDrawBorder(false);
                    aVar.gYk.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bBS().a(musicData.id, musicData.resource, new a.InterfaceC0240a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                        public void cq(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.gYk.setDrawBorder(true);
                                aVar.gYk.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                        public void uI(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.gYk.setDrawBorder(true);
                                aVar.gYk.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.gJZ != null) {
                                    j.this.gJZ.ac(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                        public void bBg() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.gYk.setDrawBorder(true);
                                aVar.gYk.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBS().a(musicData.id, musicData.resource, new a.InterfaceC0240a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void cq(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void uI(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.gJZ != null) {
                            j.this.gJZ.ac(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void bBg() {
                    }
                });
                return;
            }
            a(uR, musicData);
        }
    }

    public boolean bDz() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.haX) {
            if (this.aWV == null) {
                this.aWV = new MediaPlayer();
                this.aWV.setAudioStreamType(3);
            }
            try {
                this.haT = str;
                this.aWV.reset();
                this.aWV.setDataSource(str);
                this.aWV.prepare();
                this.aWV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aWV.setLooping(true);
                        j.this.aWV.start();
                    }
                });
                this.aWV.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.gJZ != null) {
                            j.this.gJZ.ac(4, "what-->" + i + "  extra-->" + i2);
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
        this.haT = null;
        blv();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBS().bBT();
        }
        a((Object) null, musicData);
    }

    public String bDH() {
        return this.haT;
    }

    public void onPause() {
        this.haX = true;
        if (this.aWV != null && this.aWV.isPlaying()) {
            this.aWV.pause();
        }
    }

    public void onResume() {
        this.haX = false;
        if (this.aWV != null) {
            this.aWV.start();
            this.aWV.seekTo(0);
        }
    }

    public void uK(int i) {
        if (this.aWV != null && this.aWV.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.aWV.getDuration()) {
                i %= this.aWV.getDuration();
            }
            this.aWV.seekTo(i);
            this.aWV.start();
        }
    }

    public void bDI() {
        if (this.aWV != null && this.aWV.isPlaying()) {
            this.aWV.pause();
        }
    }

    public void cr(String str, String str2) {
        this.haX = false;
        this.haT = str;
        this.haY = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.haT) && !TextUtils.isEmpty(this.haY)) {
            editVideoActivityConfig.addMusicInfo(this.haT, this.haY, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uJ(int i) {
    }
}
