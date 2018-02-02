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
    private MediaPlayer bRl;
    private com.baidu.tieba.i.h gZD;
    private SelectMusicModel hoj;
    private String hrk;
    private boolean hro;
    private String hrp;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hoj = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bke();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bke() {
        if (this.bRl != null) {
            if (this.bRl.isPlaying()) {
                this.bRl.stop();
            }
            this.bRl.release();
            this.bRl = null;
        }
        this.hrk = null;
        this.hrp = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bRl != null && this.bRl.isPlaying()) {
                this.bRl.stop();
            }
            this.isDownLoading = false;
            this.hrp = musicData.id;
            String tJ = com.baidu.tieba.video.editvideo.model.a.bAV().tJ(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(tJ)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hoy.setDrawBorder(false);
                    aVar.hoy.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bAV().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void ch(String str, String str2) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                k.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hoy.setDrawBorder(true);
                                aVar.hoy.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void tA(String str) {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hoy.setDrawBorder(true);
                                aVar.hoy.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (k.this.gZD != null) {
                                    k.this.gZD.T(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void bAi() {
                            if (aVar.position == k.this.mPosition) {
                                k.this.isDownLoading = false;
                                aVar.hoy.setDrawBorder(true);
                                aVar.hoy.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bAV().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void ch(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void tA(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.gZD != null) {
                            k.this.gZD.T(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void bAi() {
                    }
                });
                return;
            }
            a(tJ, musicData);
        }
    }

    public boolean bCQ() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hro) {
            if (this.bRl == null) {
                this.bRl = new MediaPlayer();
                this.bRl.setAudioStreamType(3);
            }
            try {
                this.hrk = str;
                this.bRl.reset();
                this.bRl.setDataSource(str);
                this.bRl.prepare();
                this.bRl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bRl.setLooping(true);
                        k.this.bRl.start();
                    }
                });
                this.bRl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.gZD != null) {
                            k.this.gZD.T(4, "what-->" + i + "  extra-->" + i2);
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
        this.hrk = null;
        bke();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bAV().bAW();
        }
        a((Object) null, musicData);
    }

    public String bCX() {
        return this.hrk;
    }

    public void onPause() {
        this.hro = true;
        if (this.bRl != null && this.bRl.isPlaying()) {
            this.bRl.pause();
        }
    }

    public void onResume() {
        this.hro = false;
        if (this.bRl != null) {
            this.bRl.start();
            this.bRl.seekTo(0);
        }
    }

    public void wW(int i) {
        if (this.bRl != null && this.bRl.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bRl.getDuration()) {
                i %= this.bRl.getDuration();
            }
            this.bRl.seekTo(i);
            this.bRl.start();
        }
    }

    public void bCY() {
        if (this.bRl != null && this.bRl.isPlaying()) {
            this.bRl.pause();
        }
    }

    public void bCZ() {
        bke();
    }

    public void ci(String str, String str2) {
        this.hro = false;
        this.hrk = str;
        this.hrp = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hrk) && !TextUtils.isEmpty(this.hrp)) {
            editVideoActivityConfig.addMusicInfo(this.hrk, this.hrp, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
    }
}
