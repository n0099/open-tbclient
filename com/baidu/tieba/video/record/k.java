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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.model.a;
import com.baidu.tieba.video.record.d;
import com.baidu.tieba.video.record.j;
import java.io.File;
/* loaded from: classes2.dex */
public class k implements j.a {
    private MediaPlayer bRd;
    private com.baidu.tieba.i.h gZj;
    private SelectMusicModel hnP;
    private String hqQ;
    private boolean hqU;
    private String hqV;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hnP = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bkd();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bkd() {
        if (this.bRd != null) {
            if (this.bRd.isPlaying()) {
                this.bRd.stop();
            }
            this.bRd.release();
            this.bRd = null;
        }
        this.hqQ = null;
        this.hqV = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bRd != null && this.bRd.isPlaying()) {
                this.bRd.stop();
            }
            this.isDownLoading = false;
            this.hqV = musicData.id;
            String tB = com.baidu.tieba.video.editvideo.model.a.bAT().tB(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tB)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hoe.setDrawBorder(false);
                    aVar.hoe.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bAT().a(musicData.id, musicData.resource, new a.InterfaceC0159a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                        public void ci(String str, String str2) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                k.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hoe.setDrawBorder(true);
                                aVar.hoe.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                        public void ts(String str) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hoe.setDrawBorder(true);
                                aVar.hoe.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (k.this.gZj != null) {
                                    k.this.gZj.R(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                        public void bAg() {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.hoe.setDrawBorder(true);
                                aVar.hoe.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bAT().a(musicData.id, musicData.resource, new a.InterfaceC0159a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void ts(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.gZj != null) {
                            k.this.gZj.R(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void bAg() {
                    }
                });
                return;
            }
            a(tB, musicData);
        }
    }

    public boolean bCO() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hqU) {
            if (this.bRd == null) {
                this.bRd = new MediaPlayer();
                this.bRd.setAudioStreamType(3);
            }
            try {
                this.hqQ = str;
                this.bRd.reset();
                this.bRd.setDataSource(str);
                this.bRd.prepare();
                this.bRd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bRd.setLooping(true);
                        k.this.bRd.start();
                    }
                });
                this.bRd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.gZj != null) {
                            k.this.gZj.R(4, "what-->" + i + "  extra-->" + i2);
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
        this.hqQ = null;
        bkd();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bAT().bAU();
        }
        a((Object) null, musicData);
    }

    public String bCV() {
        return this.hqQ;
    }

    public void onPause() {
        this.hqU = true;
        if (this.bRd != null && this.bRd.isPlaying()) {
            this.bRd.pause();
        }
    }

    public void onResume() {
        this.hqU = false;
        if (this.bRd != null) {
            this.bRd.start();
            this.bRd.seekTo(0);
        }
    }

    public void wW(int i) {
        if (this.bRd != null && this.bRd.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bRd.getDuration()) {
                i %= this.bRd.getDuration();
            }
            this.bRd.seekTo(i);
            this.bRd.start();
        }
    }

    public void bCW() {
        if (this.bRd != null && this.bRd.isPlaying()) {
            this.bRd.pause();
        }
    }

    public void bCX() {
        bkd();
    }

    public void cj(String str, String str2) {
        this.hqU = false;
        this.hqQ = str;
        this.hqV = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hqQ) && !TextUtils.isEmpty(this.hqV)) {
            editVideoActivityConfig.addMusicInfo(this.hqQ, this.hqV, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
    }
}
