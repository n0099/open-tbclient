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
    private MediaPlayer bbp;
    private com.baidu.tieba.j.h gWF;
    private SelectMusicModel hlg;
    private String hoe;
    private boolean hoi;
    private String hoj;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hlg = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    Ry();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void Ry() {
        if (this.bbp != null) {
            if (this.bbp.isPlaying()) {
                this.bbp.stop();
            }
            this.bbp.release();
            this.bbp = null;
        }
        this.hoe = null;
        this.hoj = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bbp != null && this.bbp.isPlaying()) {
                this.bbp.stop();
            }
            this.isDownLoading = false;
            this.hoj = musicData.id;
            String vy = com.baidu.tieba.video.editvideo.model.a.bDU().vy(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(vy)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hlu.setDrawBorder(false);
                    aVar.hlu.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bDU().a(musicData.id, musicData.resource, new a.InterfaceC0248a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                        public void cB(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hlu.setDrawBorder(true);
                                aVar.hlu.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                        public void vp(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hlu.setDrawBorder(true);
                                aVar.hlu.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.gWF != null) {
                                    j.this.gWF.ab(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                        public void bDi() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hlu.setDrawBorder(true);
                                aVar.hlu.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bDU().a(musicData.id, musicData.resource, new a.InterfaceC0248a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void cB(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void vp(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.gWF != null) {
                            j.this.gWF.ab(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void bDi() {
                    }
                });
                return;
            }
            a(vy, musicData);
        }
    }

    public boolean bFA() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hoi) {
            if (this.bbp == null) {
                this.bbp = new MediaPlayer();
                this.bbp.setAudioStreamType(3);
            }
            try {
                this.hoe = str;
                this.bbp.reset();
                this.bbp.setDataSource(str);
                this.bbp.prepare();
                this.bbp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bbp.setLooping(true);
                        j.this.bbp.start();
                    }
                });
                this.bbp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.gWF != null) {
                            j.this.gWF.ab(4, "what-->" + i + "  extra-->" + i2);
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
        this.hoe = null;
        Ry();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bDU().bDV();
        }
        a((Object) null, musicData);
    }

    public String bFI() {
        return this.hoe;
    }

    public void onPause() {
        this.hoi = true;
        if (this.bbp != null && this.bbp.isPlaying()) {
            this.bbp.pause();
        }
    }

    public void onResume() {
        this.hoi = false;
        if (this.bbp != null) {
            this.bbp.start();
            this.bbp.seekTo(0);
        }
    }

    public void vr(int i) {
        if (this.bbp != null && this.bbp.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bbp.getDuration()) {
                i %= this.bbp.getDuration();
            }
            this.bbp.seekTo(i);
            this.bbp.start();
        }
    }

    public void bFJ() {
        if (this.bbp != null && this.bbp.isPlaying()) {
            this.bbp.pause();
        }
    }

    public void cC(String str, String str2) {
        this.hoi = false;
        this.hoe = str;
        this.hoj = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hoe) && !TextUtils.isEmpty(this.hoj)) {
            editVideoActivityConfig.addMusicInfo(this.hoe, this.hoj, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void vq(int i) {
    }
}
