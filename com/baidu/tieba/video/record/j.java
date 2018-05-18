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
    private MediaPlayer aOZ;
    private SelectMusicModel gMt;
    private String gPr;
    private boolean gPv;
    private String gPw;
    private com.baidu.tieba.j.h gyx;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gMt = selectMusicModel;
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
        if (this.aOZ != null) {
            if (this.aOZ.isPlaying()) {
                this.aOZ.stop();
            }
            this.aOZ.release();
            this.aOZ = null;
        }
        this.gPr = null;
        this.gPw = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aOZ != null && this.aOZ.isPlaying()) {
                this.aOZ.stop();
            }
            this.isDownLoading = false;
            this.gPw = musicData.id;
            String tX = com.baidu.tieba.video.editvideo.model.a.bwL().tX(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tX)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gMI.setDrawBorder(false);
                    aVar.gMI.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bwL().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void ci(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.gMI.setDrawBorder(true);
                                aVar.gMI.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void tO(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.gMI.setDrawBorder(true);
                                aVar.gMI.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.gyx != null) {
                                    j.this.gyx.ac(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void bvZ() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.gMI.setDrawBorder(true);
                                aVar.gMI.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bwL().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tO(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.gyx != null) {
                            j.this.gyx.ac(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bvZ() {
                    }
                });
                return;
            }
            a(tX, musicData);
        }
    }

    public boolean byt() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gPv) {
            if (this.aOZ == null) {
                this.aOZ = new MediaPlayer();
                this.aOZ.setAudioStreamType(3);
            }
            try {
                this.gPr = str;
                this.aOZ.reset();
                this.aOZ.setDataSource(str);
                this.aOZ.prepare();
                this.aOZ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aOZ.setLooping(true);
                        j.this.aOZ.start();
                    }
                });
                this.aOZ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.gyx != null) {
                            j.this.gyx.ac(4, "what-->" + i + "  extra-->" + i2);
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
        this.gPr = null;
        bgx();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bwL().bwM();
        }
        a((Object) null, musicData);
    }

    public String byB() {
        return this.gPr;
    }

    public void onPause() {
        this.gPv = true;
        if (this.aOZ != null && this.aOZ.isPlaying()) {
            this.aOZ.pause();
        }
    }

    public void onResume() {
        this.gPv = false;
        if (this.aOZ != null) {
            this.aOZ.start();
            this.aOZ.seekTo(0);
        }
    }

    public void ux(int i) {
        if (this.aOZ != null && this.aOZ.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.aOZ.getDuration()) {
                i %= this.aOZ.getDuration();
            }
            this.aOZ.seekTo(i);
            this.aOZ.start();
        }
    }

    public void byC() {
        if (this.aOZ != null && this.aOZ.isPlaying()) {
            this.aOZ.pause();
        }
    }

    public void cj(String str, String str2) {
        this.gPv = false;
        this.gPr = str;
        this.gPw = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gPr) && !TextUtils.isEmpty(this.gPw)) {
            editVideoActivityConfig.addMusicInfo(this.gPr, this.gPw, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uw(int i) {
    }
}
