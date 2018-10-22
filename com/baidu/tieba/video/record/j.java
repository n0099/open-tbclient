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
/* loaded from: classes5.dex */
public class j implements i.a {
    private MediaPlayer Wb;
    private com.baidu.tieba.j.h heb;
    private SelectMusicModel hsw;
    private String hvu;
    private boolean hvy;
    private String hvz;
    private boolean isDownLoading;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.hsw = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    Tu();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext, 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void Tu() {
        if (this.Wb != null) {
            if (this.Wb.isPlaying()) {
                this.Wb.stop();
            }
            this.Wb.release();
            this.Wb = null;
        }
        this.hvu = null;
        this.hvz = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.Wb != null && this.Wb.isPlaying()) {
                this.Wb.stop();
            }
            this.isDownLoading = false;
            this.hvz = musicData.id;
            String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(vZ)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.hsK.setDrawBorder(false);
                    aVar.hsK.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.bHi().a(musicData.id, musicData.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void cM(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hsK.setDrawBorder(true);
                                aVar.hsK.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void vR(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.hsK.setDrawBorder(true);
                                aVar.hsK.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.heb != null) {
                                    j.this.heb.ab(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void bGw() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.hsK.setDrawBorder(true);
                                aVar.hsK.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bHi().a(musicData.id, musicData.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void vR(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.heb != null) {
                            j.this.heb.ab(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void bGw() {
                    }
                });
                return;
            }
            a(vZ, musicData);
        }
    }

    public boolean bIN() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.hvy) {
            if (this.Wb == null) {
                this.Wb = new MediaPlayer();
                this.Wb.setAudioStreamType(3);
            }
            try {
                this.hvu = str;
                this.Wb.reset();
                this.Wb.setDataSource(str);
                this.Wb.prepare();
                this.Wb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.Wb.setLooping(true);
                        j.this.Wb.start();
                    }
                });
                this.Wb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.heb != null) {
                            j.this.heb.ab(4, "what-->" + i + "  extra-->" + i2);
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
        this.hvu = null;
        Tu();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bHi().bHj();
        }
        a((Object) null, musicData);
    }

    public String bIV() {
        return this.hvu;
    }

    public void onPause() {
        this.hvy = true;
        if (this.Wb != null && this.Wb.isPlaying()) {
            this.Wb.pause();
        }
    }

    public void onResume() {
        this.hvy = false;
        if (this.Wb != null) {
            this.Wb.start();
            this.Wb.seekTo(0);
        }
    }

    public void vO(int i) {
        if (this.Wb != null && this.Wb.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.Wb.getDuration()) {
                i %= this.Wb.getDuration();
            }
            this.Wb.seekTo(i);
            this.Wb.start();
        }
    }

    public void bIW() {
        if (this.Wb != null && this.Wb.isPlaying()) {
            this.Wb.pause();
        }
    }

    public void cN(String str, String str2) {
        this.hvy = false;
        this.hvu = str;
        this.hvz = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.hvu) && !TextUtils.isEmpty(this.hvz)) {
            editVideoActivityConfig.addMusicInfo(this.hvu, this.hvz, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void vN(int i) {
    }
}
