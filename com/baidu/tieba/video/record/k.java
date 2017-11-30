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
    private MediaPlayer bdf;
    private com.baidu.tieba.i.h gAg;
    private SelectMusicModel gOx;
    private String gRA;
    private String gRv;
    private boolean gRz;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gOx = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bjf();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bjf() {
        if (this.bdf != null) {
            if (this.bdf.isPlaying()) {
                this.bdf.stop();
            }
            this.bdf.release();
            this.bdf = null;
        }
        this.gRv = null;
        this.gRA = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bdf != null && this.bdf.isPlaying()) {
                this.bdf.stop();
            }
            this.gRA = musicData.id;
            String ua = com.baidu.tieba.video.editvideo.model.a.bBs().ua(musicData.resource);
            if (TextUtils.isEmpty(ua)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gOL.setDrawBorder(false);
                    aVar.gOL.invalidate();
                    this.mPosition = aVar.position;
                    com.baidu.tieba.video.editvideo.model.a.bBs().a(musicData.id, musicData.resource, new a.InterfaceC0133a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                        public void cm(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            k.this.a(str, musicData);
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gOL.setDrawBorder(true);
                            aVar.gOL.invalidate();
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                        public void tR(String str) {
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gOL.setDrawBorder(true);
                            aVar.gOL.invalidate();
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                            if (k.this.gAg != null) {
                                k.this.gAg.Q(3, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                        public void bAF() {
                            aVar.gOL.setDrawBorder(true);
                            aVar.gOL.invalidate();
                            aVar.mProgressBar.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBs().a(musicData.id, musicData.resource, new a.InterfaceC0133a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void cm(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void tR(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.gAg != null) {
                            k.this.gAg.Q(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void bAF() {
                    }
                });
                return;
            }
            a(ua, musicData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gRz) {
            if (this.bdf == null) {
                this.bdf = new MediaPlayer();
                this.bdf.setAudioStreamType(3);
            }
            try {
                this.gRv = str;
                this.bdf.reset();
                this.bdf.setDataSource(str);
                this.bdf.prepare();
                this.bdf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bdf.setLooping(true);
                        k.this.bdf.start();
                    }
                });
                this.bdf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.gAg != null) {
                            k.this.gAg.Q(4, "what-->" + i + "  extra-->" + i2);
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
        this.gRv = null;
        bjf();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBs().bBt();
        }
        a((Object) null, musicData);
    }

    public String bDp() {
        return this.gRv;
    }

    public void onPause() {
        this.gRz = true;
        if (this.bdf != null && this.bdf.isPlaying()) {
            this.bdf.pause();
        }
    }

    public void onResume() {
        this.gRz = false;
        if (this.bdf != null) {
            this.bdf.start();
            this.bdf.seekTo(0);
        }
    }

    public void nK(boolean z) {
        if (this.bdf != null && z) {
            this.bdf.seekTo(0);
        }
        if (this.bdf != null && !this.bdf.isPlaying()) {
            this.bdf.start();
        }
    }

    public void bDq() {
        if (this.bdf != null && this.bdf.isPlaying()) {
            this.bdf.pause();
        }
    }

    public void bDr() {
        bjf();
    }

    public void cn(String str, String str2) {
        this.gRz = false;
        this.gRv = str;
        this.gRA = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gRv) && !TextUtils.isEmpty(this.gRA)) {
            editVideoActivityConfig.addMusicInfo(this.gRv, this.gRA, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void vs(int i) {
        if (i == 1 && !TextUtils.isEmpty(this.gRv)) {
            onResume();
        }
    }
}
