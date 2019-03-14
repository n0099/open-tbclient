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
    private MediaPlayer bsm;
    private com.baidu.tieba.j.h iHn;
    private SelectMusicModel iWl;
    private String iZg;
    private boolean iZk;
    private String iZl;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.iWl = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    avg();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void avg() {
        if (this.bsm != null) {
            if (this.bsm.isPlaying()) {
                this.bsm.stop();
            }
            this.bsm.release();
            this.bsm = null;
        }
        this.iZg = null;
        this.iZl = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bsm != null && this.bsm.isPlaying()) {
                this.bsm.stop();
            }
            this.isDownLoading = false;
            this.iZl = musicData.id;
            String DB = com.baidu.tieba.video.editvideo.model.a.cjK().DB(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(DB)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.iWz.setDrawBorder(false);
                    aVar.iWz.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.cjK().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ec(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.iWz.setDrawBorder(true);
                                aVar.iWz.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void Dt(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.iWz.setDrawBorder(true);
                                aVar.iWz.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.iHn != null) {
                                    j.this.iHn.aq(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ciY() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.iWz.setDrawBorder(true);
                                aVar.iWz.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cjK().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ec(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void Dt(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.iHn != null) {
                            j.this.iHn.aq(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciY() {
                    }
                });
                return;
            }
            a(DB, musicData);
        }
    }

    public boolean clq() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.iZk) {
            if (this.bsm == null) {
                this.bsm = new MediaPlayer();
                this.bsm.setAudioStreamType(3);
            }
            try {
                this.iZg = str;
                this.bsm.reset();
                this.bsm.setDataSource(str);
                this.bsm.prepare();
                this.bsm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bsm.setLooping(true);
                        j.this.bsm.start();
                    }
                });
                this.bsm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.iHn != null) {
                            j.this.iHn.aq(4, "what-->" + i + "  extra-->" + i2);
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
        this.iZg = null;
        avg();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cjK().cjL();
        }
        a((Object) null, musicData);
    }

    public String cly() {
        return this.iZg;
    }

    public void onPause() {
        this.iZk = true;
        if (this.bsm != null && this.bsm.isPlaying()) {
            this.bsm.pause();
        }
    }

    public void onResume() {
        this.iZk = false;
        if (this.bsm != null) {
            this.bsm.start();
            this.bsm.seekTo(0);
        }
    }

    public void AG(int i) {
        if (this.bsm != null && this.bsm.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bsm.getDuration()) {
                i %= this.bsm.getDuration();
            }
            this.bsm.seekTo(i);
            this.bsm.start();
        }
    }

    public void clz() {
        if (this.bsm != null && this.bsm.isPlaying()) {
            this.bsm.pause();
        }
    }

    public void ed(String str, String str2) {
        this.iZk = false;
        this.iZg = str;
        this.iZl = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.iZg) && !TextUtils.isEmpty(this.iZl)) {
            editVideoActivityConfig.addMusicInfo(this.iZg, this.iZl, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void AF(int i) {
    }
}
