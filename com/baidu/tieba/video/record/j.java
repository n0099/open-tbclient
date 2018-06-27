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
    private MediaPlayer aXQ;
    private com.baidu.tieba.j.h gOa;
    private SelectMusicModel hca;
    private String heY;
    private boolean hfc;
    private String hfd;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hca = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    blZ();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void blZ() {
        if (this.aXQ != null) {
            if (this.aXQ.isPlaying()) {
                this.aXQ.stop();
            }
            this.aXQ.release();
            this.aXQ = null;
        }
        this.heY = null;
        this.hfd = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aXQ != null && this.aXQ.isPlaying()) {
                this.aXQ.stop();
            }
            this.isDownLoading = false;
            this.hfd = musicData.id;
            String uN = com.baidu.tieba.video.editvideo.model.a.bCs().uN(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(uN)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hcp.setDrawBorder(false);
                    aVar.hcp.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bCs().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cu(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hcp.setDrawBorder(true);
                                aVar.hcp.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void uE(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hcp.setDrawBorder(true);
                                aVar.hcp.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.gOa != null) {
                                    j.this.gOa.Z(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bBG() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hcp.setDrawBorder(true);
                                aVar.hcp.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bCs().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cu(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uE(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.gOa != null) {
                            j.this.gOa.Z(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bBG() {
                    }
                });
                return;
            }
            a(uN, musicData);
        }
    }

    public boolean bDZ() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hfc) {
            if (this.aXQ == null) {
                this.aXQ = new MediaPlayer();
                this.aXQ.setAudioStreamType(3);
            }
            try {
                this.heY = str;
                this.aXQ.reset();
                this.aXQ.setDataSource(str);
                this.aXQ.prepare();
                this.aXQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aXQ.setLooping(true);
                        j.this.aXQ.start();
                    }
                });
                this.aXQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.gOa != null) {
                            j.this.gOa.Z(4, "what-->" + i + "  extra-->" + i2);
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
        this.heY = null;
        blZ();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bCs().bCt();
        }
        a((Object) null, musicData);
    }

    public String bEh() {
        return this.heY;
    }

    public void onPause() {
        this.hfc = true;
        if (this.aXQ != null && this.aXQ.isPlaying()) {
            this.aXQ.pause();
        }
    }

    public void onResume() {
        this.hfc = false;
        if (this.aXQ != null) {
            this.aXQ.start();
            this.aXQ.seekTo(0);
        }
    }

    public void uS(int i) {
        if (this.aXQ != null && this.aXQ.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.aXQ.getDuration()) {
                i %= this.aXQ.getDuration();
            }
            this.aXQ.seekTo(i);
            this.aXQ.start();
        }
    }

    public void bEi() {
        if (this.aXQ != null && this.aXQ.isPlaying()) {
            this.aXQ.pause();
        }
    }

    public void cv(String str, String str2) {
        this.hfc = false;
        this.heY = str;
        this.hfd = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.heY) && !TextUtils.isEmpty(this.hfd)) {
            editVideoActivityConfig.addMusicInfo(this.heY, this.hfd, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uR(int i) {
    }
}
