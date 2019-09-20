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
    private MediaPlayer bAy;
    private boolean isDownLoading;
    private String jBF;
    private boolean jBJ;
    private String jBK;
    private com.baidu.tieba.j.h jjR;
    private SelectMusicModel jyM;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.jyM = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    aBQ();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void aBQ() {
        if (this.bAy != null) {
            if (this.bAy.isPlaying()) {
                this.bAy.stop();
            }
            this.bAy.release();
            this.bAy = null;
        }
        this.jBF = null;
        this.jBK = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bAy != null && this.bAy.isPlaying()) {
                this.bAy.stop();
            }
            this.isDownLoading = false;
            this.jBK = musicData.id;
            String Gn = com.baidu.tieba.video.editvideo.model.a.cvJ().Gn(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(Gn)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.jza.setDrawBorder(false);
                    aVar.jza.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.cvJ().a(musicData.id, musicData.resource, new a.InterfaceC0433a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                        public void et(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jza.setDrawBorder(true);
                                aVar.jza.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                        public void Gf(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jza.setDrawBorder(true);
                                aVar.jza.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.jjR != null) {
                                    j.this.jjR.av(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                        public void cuX() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.jza.setDrawBorder(true);
                                aVar.jza.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cvJ().a(musicData.id, musicData.resource, new a.InterfaceC0433a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void et(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void Gf(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.jjR != null) {
                            j.this.jjR.av(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void cuX() {
                    }
                });
                return;
            }
            a(Gn, musicData);
        }
    }

    public boolean cxr() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.jBJ) {
            if (this.bAy == null) {
                this.bAy = new MediaPlayer();
                this.bAy.setAudioStreamType(3);
            }
            try {
                this.jBF = str;
                this.bAy.reset();
                this.bAy.setDataSource(str);
                this.bAy.prepare();
                this.bAy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bAy.setLooping(true);
                        j.this.bAy.start();
                    }
                });
                this.bAy.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.jjR != null) {
                            j.this.jjR.av(4, "what-->" + i + "  extra-->" + i2);
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
        this.jBF = null;
        aBQ();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cvJ().cvK();
        }
        a((Object) null, musicData);
    }

    public String cxz() {
        return this.jBF;
    }

    public void onPause() {
        this.jBJ = true;
        if (this.bAy != null && this.bAy.isPlaying()) {
            this.bAy.pause();
        }
    }

    public void onResume() {
        this.jBJ = false;
        if (this.bAy != null) {
            this.bAy.start();
            this.bAy.seekTo(0);
        }
    }

    public void Cx(int i) {
        if (this.bAy != null && this.bAy.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bAy.getDuration()) {
                i %= this.bAy.getDuration();
            }
            this.bAy.seekTo(i);
            this.bAy.start();
        }
    }

    public void cxA() {
        if (this.bAy != null && this.bAy.isPlaying()) {
            this.bAy.pause();
        }
    }

    public void eu(String str, String str2) {
        this.jBJ = false;
        this.jBF = str;
        this.jBK = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.jBF) && !TextUtils.isEmpty(this.jBK)) {
            editVideoActivityConfig.addMusicInfo(this.jBF, this.jBK, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Cw(int i) {
    }
}
