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
    private MediaPlayer bsp;
    private com.baidu.tieba.j.h iGX;
    private SelectMusicModel iVZ;
    private String iYU;
    private boolean iYY;
    private String iYZ;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iGX = lVar.bEz();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.iVZ = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    avd();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void avd() {
        if (this.bsp != null) {
            if (this.bsp.isPlaying()) {
                this.bsp.stop();
            }
            this.bsp.release();
            this.bsp = null;
        }
        this.iYU = null;
        this.iYZ = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bsp != null && this.bsp.isPlaying()) {
                this.bsp.stop();
            }
            this.isDownLoading = false;
            this.iYZ = musicData.id;
            String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(DA)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.iWn.setDrawBorder(false);
                    aVar.iWn.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.cjI().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ed(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.iWn.setDrawBorder(true);
                                aVar.iWn.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void Ds(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.iWn.setDrawBorder(true);
                                aVar.iWn.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.iGX != null) {
                                    j.this.iGX.as(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ciW() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.iWn.setDrawBorder(true);
                                aVar.iWn.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cjI().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ed(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void Ds(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.iGX != null) {
                            j.this.iGX.as(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciW() {
                    }
                });
                return;
            }
            a(DA, musicData);
        }
    }

    public boolean clo() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.iYY) {
            if (this.bsp == null) {
                this.bsp = new MediaPlayer();
                this.bsp.setAudioStreamType(3);
            }
            try {
                this.iYU = str;
                this.bsp.reset();
                this.bsp.setDataSource(str);
                this.bsp.prepare();
                this.bsp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bsp.setLooping(true);
                        j.this.bsp.start();
                    }
                });
                this.bsp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.iGX != null) {
                            j.this.iGX.as(4, "what-->" + i + "  extra-->" + i2);
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
        this.iYU = null;
        avd();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cjI().cjJ();
        }
        a((Object) null, musicData);
    }

    public String clw() {
        return this.iYU;
    }

    public void onPause() {
        this.iYY = true;
        if (this.bsp != null && this.bsp.isPlaying()) {
            this.bsp.pause();
        }
    }

    public void onResume() {
        this.iYY = false;
        if (this.bsp != null) {
            this.bsp.start();
            this.bsp.seekTo(0);
        }
    }

    public void AC(int i) {
        if (this.bsp != null && this.bsp.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bsp.getDuration()) {
                i %= this.bsp.getDuration();
            }
            this.bsp.seekTo(i);
            this.bsp.start();
        }
    }

    public void clx() {
        if (this.bsp != null && this.bsp.isPlaying()) {
            this.bsp.pause();
        }
    }

    public void ef(String str, String str2) {
        this.iYY = false;
        this.iYU = str;
        this.iYZ = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.iYU) && !TextUtils.isEmpty(this.iYZ)) {
            editVideoActivityConfig.addMusicInfo(this.iYU, this.iYZ, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void AB(int i) {
    }
}
