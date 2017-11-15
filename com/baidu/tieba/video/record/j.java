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
    private MediaPlayer aZT;
    private SelectMusicModel gEP;
    private String gGY;
    private boolean gHc;
    private String gHd;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.gEP = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    bhy();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    private void bhy() {
        if (this.aZT != null) {
            if (this.aZT.isPlaying()) {
                this.aZT.stop();
            }
            this.aZT.release();
            this.aZT = null;
        }
        this.gGY = null;
        this.gHd = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.aZT != null && this.aZT.isPlaying()) {
                this.aZT.stop();
            }
            this.gHd = musicData.id;
            String tp = com.baidu.tieba.video.editvideo.model.a.bzc().tp(musicData.resource);
            if (TextUtils.isEmpty(tp)) {
                if (obj instanceof c.a) {
                    final c.a aVar = (c.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.gJt.setDrawBorder(false);
                    aVar.gJt.invalidate();
                    this.mPosition = aVar.position;
                    com.baidu.tieba.video.editvideo.model.a.bzc().a(musicData.id, musicData.resource, new a.InterfaceC0134a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            j.this.a(str, musicData);
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gJt.setDrawBorder(true);
                            aVar.gJt.invalidate();
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                        public void tl(String str) {
                            aVar.mProgressBar.setVisibility(4);
                            aVar.gJt.setDrawBorder(true);
                            aVar.gJt.invalidate();
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                        public void byC() {
                            aVar.gJt.setDrawBorder(true);
                            aVar.gJt.invalidate();
                            aVar.mProgressBar.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bzc().a(musicData.id, musicData.resource, new a.InterfaceC0134a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void tl(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void byC() {
                    }
                });
                return;
            }
            a(tp, musicData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.gHc) {
            if (this.aZT == null) {
                this.aZT = new MediaPlayer();
                this.aZT.setAudioStreamType(3);
            }
            try {
                this.gGY = str;
                this.aZT.reset();
                this.aZT.setDataSource(str);
                this.aZT.prepare();
                this.aZT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.aZT.setLooping(true);
                        j.this.aZT.start();
                    }
                });
                this.aZT.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
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
        this.gGY = null;
        bhy();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bzc().bzd();
        }
        a((Object) null, musicData);
    }

    public String bAM() {
        return this.gGY;
    }

    public void onPause() {
        this.gHc = true;
        if (this.aZT != null && this.aZT.isPlaying()) {
            this.aZT.pause();
        }
    }

    public void onResume() {
        this.gHc = false;
        if (this.aZT != null) {
            this.aZT.start();
            this.aZT.seekTo(0);
        }
    }

    public void nk(boolean z) {
        if (this.aZT != null && z) {
            this.aZT.seekTo(0);
        }
        if (this.aZT != null && !this.aZT.isPlaying()) {
            this.aZT.start();
        }
    }

    public void bAN() {
        if (this.aZT != null && this.aZT.isPlaying()) {
            this.aZT.pause();
        }
    }

    public void bAO() {
        bhy();
    }

    public void ck(String str, String str2) {
        this.gHc = false;
        this.gGY = str;
        this.gHd = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.gGY) && !TextUtils.isEmpty(this.gHd)) {
            editVideoActivityConfig.addMusicInfo(this.gGY, this.gHd, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uZ(int i) {
        if (i == 1 && !TextUtils.isEmpty(this.gGY)) {
            onResume();
        }
    }
}
