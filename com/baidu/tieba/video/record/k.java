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
    private MediaPlayer bQW;
    private String hBn;
    private boolean hBr;
    private String hBs;
    private com.baidu.tieba.i.h hjJ;
    private SelectMusicModel hym;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hym = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bqK();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bqK() {
        if (this.bQW != null) {
            if (this.bQW.isPlaying()) {
                this.bQW.stop();
            }
            this.bQW.release();
            this.bQW = null;
        }
        this.hBn = null;
        this.hBs = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bQW != null && this.bQW.isPlaying()) {
                this.bQW.stop();
            }
            this.isDownLoading = false;
            this.hBs = musicData.id;
            String ug = com.baidu.tieba.video.editvideo.model.a.bHw().ug(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(ug)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hyB.setDrawBorder(false);
                    aVar.hyB.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bHw().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void co(String str, String str2) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                k.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hyB.setDrawBorder(true);
                                aVar.hyB.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void tX(String str) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hyB.setDrawBorder(true);
                                aVar.hyB.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (k.this.hjJ != null) {
                                    k.this.hjJ.P(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void bGJ() {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.hyB.setDrawBorder(true);
                                aVar.hyB.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bHw().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void co(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void tX(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.hjJ != null) {
                            k.this.hjJ.P(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void bGJ() {
                    }
                });
                return;
            }
            a(ug, musicData);
        }
    }

    public boolean bJr() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hBr) {
            if (this.bQW == null) {
                this.bQW = new MediaPlayer();
                this.bQW.setAudioStreamType(3);
            }
            try {
                this.hBn = str;
                this.bQW.reset();
                this.bQW.setDataSource(str);
                this.bQW.prepare();
                this.bQW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bQW.setLooping(true);
                        k.this.bQW.start();
                    }
                });
                this.bQW.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.hjJ != null) {
                            k.this.hjJ.P(4, "what-->" + i + "  extra-->" + i2);
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
        this.hBn = null;
        bqK();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bHw().bHx();
        }
        a((Object) null, musicData);
    }

    public String bJy() {
        return this.hBn;
    }

    public void onPause() {
        this.hBr = true;
        if (this.bQW != null && this.bQW.isPlaying()) {
            this.bQW.pause();
        }
    }

    public void onResume() {
        this.hBr = false;
        if (this.bQW != null) {
            this.bQW.start();
            this.bQW.seekTo(0);
        }
    }

    public void yu(int i) {
        if (this.bQW != null && this.bQW.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bQW.getDuration()) {
                i %= this.bQW.getDuration();
            }
            this.bQW.seekTo(i);
            this.bQW.start();
        }
    }

    public void bJz() {
        if (this.bQW != null && this.bQW.isPlaying()) {
            this.bQW.pause();
        }
    }

    public void bJA() {
        bqK();
    }

    public void cp(String str, String str2) {
        this.hBr = false;
        this.hBn = str;
        this.hBs = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hBn) && !TextUtils.isEmpty(this.hBs)) {
            editVideoActivityConfig.addMusicInfo(this.hBn, this.hBs, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void yt(int i) {
    }
}
