package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.model.a;
import com.baidu.tieba.video.record.c;
import com.baidu.tieba.video.record.i;
import java.io.File;
/* loaded from: classes2.dex */
public class j implements i.a {
    private MediaPlayer aZK;
    private SelectMusicModel gDH;
    private String gFQ;
    private boolean gFU;
    private String gFV;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gDH = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bhq();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    private void bhq() {
        if (this.aZK != null) {
            if (this.aZK.isPlaying()) {
                this.aZK.stop();
            }
            this.aZK.release();
            this.aZK = null;
        }
        this.gFQ = null;
        this.gFV = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aZK != null && this.aZK.isPlaying()) {
                this.aZK.stop();
            }
            this.gFV = musicData.id;
            String tj = com.baidu.tieba.video.editvideo.model.a.byQ().tj(musicData.resource);
            if (TextUtils.isEmpty(tj)) {
                if (obj instanceof c.a) {
                    final c.a aVar = (c.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gIl.setDrawBorder(false);
                    aVar.gIl.invalidate();
                    this.mPosition = aVar.position;
                    com.baidu.tieba.video.editvideo.model.a.byQ().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void cf(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            j.this.a(str, musicData);
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gIl.setDrawBorder(true);
                            aVar.gIl.invalidate();
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void tf(String str) {
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gIl.setDrawBorder(true);
                            aVar.gIl.invalidate();
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void byq() {
                            aVar.gIl.setDrawBorder(true);
                            aVar.gIl.invalidate();
                            aVar.mProgressBar.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.byQ().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void cf(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void tf(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void byq() {
                    }
                });
                return;
            }
            a(tj, musicData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gFU) {
            if (this.aZK == null) {
                this.aZK = new MediaPlayer();
                this.aZK.setAudioStreamType(3);
            }
            try {
                this.gFQ = str;
                this.aZK.reset();
                this.aZK.setDataSource(str);
                this.aZK.prepare();
                this.aZK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aZK.setLooping(true);
                        j.this.aZK.start();
                    }
                });
                this.aZK.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
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
        this.gFQ = null;
        bhq();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.byQ().byR();
        }
        a((Object) null, musicData);
    }

    public String bAA() {
        return this.gFQ;
    }

    public void onPause() {
        this.gFU = true;
        if (this.aZK != null && this.aZK.isPlaying()) {
            this.aZK.pause();
        }
    }

    public void onResume() {
        this.gFU = false;
        if (this.aZK != null) {
            this.aZK.start();
            this.aZK.seekTo(0);
        }
    }

    public void nc(boolean z) {
        if (this.aZK != null && z) {
            this.aZK.seekTo(0);
        }
        if (this.aZK != null && !this.aZK.isPlaying()) {
            this.aZK.start();
        }
    }

    public void bAB() {
        if (this.aZK != null && this.aZK.isPlaying()) {
            this.aZK.pause();
        }
    }

    public void bAC() {
        bhq();
    }

    public void cg(String str, String str2) {
        this.gFU = false;
        this.gFQ = str;
        this.gFV = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gFQ) && !TextUtils.isEmpty(this.gFV)) {
            editVideoActivityConfig.addMusicInfo(this.gFQ, this.gFV, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uV(int i) {
        if (i == 1 && !TextUtils.isEmpty(this.gFQ)) {
            onResume();
        }
    }
}
