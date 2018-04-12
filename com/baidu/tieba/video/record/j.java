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
    private MediaPlayer aOY;
    private SelectMusicModel gLt;
    private String gOr;
    private boolean gOv;
    private String gOw;
    private com.baidu.tieba.j.h gxw;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gLt = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bgx();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bgx() {
        if (this.aOY != null) {
            if (this.aOY.isPlaying()) {
                this.aOY.stop();
            }
            this.aOY.release();
            this.aOY = null;
        }
        this.gOr = null;
        this.gOw = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aOY != null && this.aOY.isPlaying()) {
                this.aOY.stop();
            }
            this.isDownLoading = false;
            this.gOw = musicData.id;
            String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tU)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gLI.setDrawBorder(false);
                    aVar.gLI.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bwN().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void ci(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.gLI.setDrawBorder(true);
                                aVar.gLI.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void tL(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.gLI.setDrawBorder(true);
                                aVar.gLI.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.gxw != null) {
                                    j.this.gxw.ac(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void bwb() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.gLI.setDrawBorder(true);
                                aVar.gLI.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bwN().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tL(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.gxw != null) {
                            j.this.gxw.ac(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bwb() {
                    }
                });
                return;
            }
            a(tU, musicData);
        }
    }

    public boolean byv() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gOv) {
            if (this.aOY == null) {
                this.aOY = new MediaPlayer();
                this.aOY.setAudioStreamType(3);
            }
            try {
                this.gOr = str;
                this.aOY.reset();
                this.aOY.setDataSource(str);
                this.aOY.prepare();
                this.aOY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aOY.setLooping(true);
                        j.this.aOY.start();
                    }
                });
                this.aOY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.gxw != null) {
                            j.this.gxw.ac(4, "what-->" + i + "  extra-->" + i2);
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
        this.gOr = null;
        bgx();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bwN().bwO();
        }
        a((Object) null, musicData);
    }

    public String byD() {
        return this.gOr;
    }

    public void onPause() {
        this.gOv = true;
        if (this.aOY != null && this.aOY.isPlaying()) {
            this.aOY.pause();
        }
    }

    public void onResume() {
        this.gOv = false;
        if (this.aOY != null) {
            this.aOY.start();
            this.aOY.seekTo(0);
        }
    }

    public void uz(int i) {
        if (this.aOY != null && this.aOY.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.aOY.getDuration()) {
                i %= this.aOY.getDuration();
            }
            this.aOY.seekTo(i);
            this.aOY.start();
        }
    }

    public void byE() {
        if (this.aOY != null && this.aOY.isPlaying()) {
            this.aOY.pause();
        }
    }

    public void cj(String str, String str2) {
        this.gOv = false;
        this.gOr = str;
        this.gOw = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gOr) && !TextUtils.isEmpty(this.gOw)) {
            editVideoActivityConfig.addMusicInfo(this.gOr, this.gOw, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uy(int i) {
    }
}
