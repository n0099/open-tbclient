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
    private MediaPlayer bdg;
    private com.baidu.tieba.i.h gCP;
    private SelectMusicModel gRf;
    private String gUe;
    private boolean gUi;
    private String gUj;
    private Context mContext;
    private int mPosition;

    public k(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOj();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gRf = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bjn();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void bjn() {
        if (this.bdg != null) {
            if (this.bdg.isPlaying()) {
                this.bdg.stop();
            }
            this.bdg.release();
            this.bdg = null;
        }
        this.gUe = null;
        this.gUj = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bdg != null && this.bdg.isPlaying()) {
                this.bdg.stop();
            }
            this.gUj = musicData.id;
            String uf = com.baidu.tieba.video.editvideo.model.a.bBY().uf(musicData.resource);
            if (TextUtils.isEmpty(uf)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gRu.setDrawBorder(false);
                    aVar.gRu.invalidate();
                    this.mPosition = aVar.position;
                    com.baidu.tieba.video.editvideo.model.a.bBY().a(musicData.id, musicData.resource, new a.InterfaceC0148a() { // from class: com.baidu.tieba.video.record.k.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                        public void cn(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            k.this.a(str, musicData);
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gRu.setDrawBorder(true);
                            aVar.gRu.invalidate();
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                        public void tW(String str) {
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gRu.setDrawBorder(true);
                            aVar.gRu.invalidate();
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                            if (k.this.gCP != null) {
                                k.this.gCP.Q(3, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                        public void bBl() {
                            aVar.gRu.setDrawBorder(true);
                            aVar.gRu.invalidate();
                            aVar.mProgressBar.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBY().a(musicData.id, musicData.resource, new a.InterfaceC0148a() { // from class: com.baidu.tieba.video.record.k.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void cn(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        k.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void tW(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (k.this.gCP != null) {
                            k.this.gCP.Q(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void bBl() {
                    }
                });
                return;
            }
            a(uf, musicData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gUi) {
            if (this.bdg == null) {
                this.bdg = new MediaPlayer();
                this.bdg.setAudioStreamType(3);
            }
            try {
                this.gUe = str;
                this.bdg.reset();
                this.bdg.setDataSource(str);
                this.bdg.prepare();
                this.bdg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.k.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        k.this.bdg.setLooping(true);
                        k.this.bdg.start();
                    }
                });
                this.bdg.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.k.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (k.this.gCP != null) {
                            k.this.gCP.Q(4, "what-->" + i + "  extra-->" + i2);
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
        this.gUe = null;
        bjn();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBY().bBZ();
        }
        a((Object) null, musicData);
    }

    public String bDX() {
        return this.gUe;
    }

    public void onPause() {
        this.gUi = true;
        if (this.bdg != null && this.bdg.isPlaying()) {
            this.bdg.pause();
        }
    }

    public void onResume() {
        this.gUi = false;
        if (this.bdg != null) {
            this.bdg.start();
            this.bdg.seekTo(0);
        }
    }

    public void vE(int i) {
        if (this.bdg != null && this.bdg.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bdg.getDuration()) {
                i %= this.bdg.getDuration();
            }
            if (!this.bdg.isPlaying()) {
                this.bdg.seekTo(i);
                this.bdg.start();
            }
        }
    }

    public void bDY() {
        if (this.bdg != null && this.bdg.isPlaying()) {
            this.bdg.pause();
        }
    }

    public void bDZ() {
        bjn();
    }

    public void co(String str, String str2) {
        this.gUi = false;
        this.gUe = str;
        this.gUj = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gUe) && !TextUtils.isEmpty(this.gUj)) {
            editVideoActivityConfig.addMusicInfo(this.gUe, this.gUj, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void vD(int i) {
        if (i == 1 && !TextUtils.isEmpty(this.gUe)) {
            onResume();
        }
    }
}
