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
    private MediaPlayer bdk;
    private com.baidu.tieba.i.h gCU;
    private SelectMusicModel gRk;
    private String gUj;
    private boolean gUn;
    private String gUo;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gRk = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bjo();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bjo() {
        if (this.bdk != null) {
            if (this.bdk.isPlaying()) {
                this.bdk.stop();
            }
            this.bdk.release();
            this.bdk = null;
        }
        this.gUj = null;
        this.gUo = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bdk != null && this.bdk.isPlaying()) {
                this.bdk.stop();
            }
            this.gUo = musicData.id;
            String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(musicData.resource);
            if (TextUtils.isEmpty(uf)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gRz.setDrawBorder(false);
                    aVar.gRz.invalidate();
                    this.mPosition = aVar.position;
                    com.baidu.tieba.video.editvideo.model.a.bBZ().a(musicData.id, musicData.resource, new a.InterfaceC0147a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                        public void cn(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            k.this.a(str, musicData);
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gRz.setDrawBorder(true);
                            aVar.gRz.invalidate();
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                        public void tW(String str) {
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gRz.setDrawBorder(true);
                            aVar.gRz.invalidate();
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                            if (k.this.gCU != null) {
                                k.this.gCU.Q(3, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                        public void bBm() {
                            aVar.gRz.setDrawBorder(true);
                            aVar.gRz.invalidate();
                            aVar.mProgressBar.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBZ().a(musicData.id, musicData.resource, new a.InterfaceC0147a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void cn(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void tW(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.gCU != null) {
                            k.this.gCU.Q(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void bBm() {
                    }
                });
                return;
            }
            a(uf, musicData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gUn) {
            if (this.bdk == null) {
                this.bdk = new MediaPlayer();
                this.bdk.setAudioStreamType(3);
            }
            try {
                this.gUj = str;
                this.bdk.reset();
                this.bdk.setDataSource(str);
                this.bdk.prepare();
                this.bdk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bdk.setLooping(true);
                        k.this.bdk.start();
                    }
                });
                this.bdk.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.gCU != null) {
                            k.this.gCU.Q(4, "what-->" + i + "  extra-->" + i2);
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
        this.gUj = null;
        bjo();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBZ().bCa();
        }
        a((Object) null, musicData);
    }

    public String bDY() {
        return this.gUj;
    }

    public void onPause() {
        this.gUn = true;
        if (this.bdk != null && this.bdk.isPlaying()) {
            this.bdk.pause();
        }
    }

    public void onResume() {
        this.gUn = false;
        if (this.bdk != null) {
            this.bdk.start();
            this.bdk.seekTo(0);
        }
    }

    public void vE(int i) {
        if (this.bdk != null && this.bdk.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bdk.getDuration()) {
                i %= this.bdk.getDuration();
            }
            if (!this.bdk.isPlaying()) {
                this.bdk.seekTo(i);
                this.bdk.start();
            }
        }
    }

    public void bDZ() {
        if (this.bdk != null && this.bdk.isPlaying()) {
            this.bdk.pause();
        }
    }

    public void bEa() {
        bjo();
    }

    public void co(String str, String str2) {
        this.gUn = false;
        this.gUj = str;
        this.gUo = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gUj) && !TextUtils.isEmpty(this.gUo)) {
            editVideoActivityConfig.addMusicInfo(this.gUj, this.gUo, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void vD(int i) {
        if (i == 1 && !TextUtils.isEmpty(this.gUj)) {
            onResume();
        }
    }
}
