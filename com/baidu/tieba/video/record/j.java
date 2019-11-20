package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private MediaPlayer bSn;
    private boolean isDownLoading;
    private String jAG;
    private boolean jAK;
    private String jAL;
    private com.baidu.tieba.j.h jiP;
    private SelectMusicModel jxN;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.jxN = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    aBY();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void aBY() {
        if (this.bSn != null) {
            if (this.bSn.isPlaying()) {
                this.bSn.stop();
            }
            this.bSn.release();
            this.bSn = null;
        }
        this.jAG = null;
        this.jAL = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bSn != null && this.bSn.isPlaying()) {
                this.bSn.stop();
            }
            this.isDownLoading = false;
            this.jAL = musicData.id;
            String EP = com.baidu.tieba.video.editvideo.model.a.ctv().EP(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(EP)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.jyb.setDrawBorder(false);
                    aVar.jyb.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.ctv().a(musicData.id, musicData.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void ef(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jyb.setDrawBorder(true);
                                aVar.jyb.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void EH(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jyb.setDrawBorder(true);
                                aVar.jyb.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.jiP != null) {
                                    j.this.jiP.au(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void csK() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.jyb.setDrawBorder(true);
                                aVar.jyb.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.ctv().a(musicData.id, musicData.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.record.j.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void ef(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        j.this.a(str, musicData);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void EH(String str) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        if (j.this.jiP != null) {
                            j.this.jiP.au(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void csK() {
                    }
                });
                return;
            }
            a(EP, musicData);
        }
    }

    public boolean cvf() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.jAK) {
            if (this.bSn == null) {
                this.bSn = new MediaPlayer();
                this.bSn.setAudioStreamType(3);
            }
            try {
                this.jAG = str;
                this.bSn.reset();
                this.bSn.setDataSource(str);
                this.bSn.prepare();
                this.bSn.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bSn.setLooping(true);
                        j.this.bSn.start();
                    }
                });
                this.bSn.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.jiP != null) {
                            j.this.jiP.au(4, "what-->" + i + "  extra-->" + i2);
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
        this.jAG = null;
        aBY();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.ctv().ctw();
        }
        a((Object) null, musicData);
    }

    public String cvn() {
        return this.jAG;
    }

    public void onPause() {
        this.jAK = true;
        if (this.bSn != null && this.bSn.isPlaying()) {
            this.bSn.pause();
        }
    }

    public void onResume() {
        this.jAK = false;
        if (this.bSn != null) {
            this.bSn.start();
            this.bSn.seekTo(0);
        }
    }

    public void Bc(int i) {
        if (this.bSn != null && this.bSn.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bSn.getDuration()) {
                i %= this.bSn.getDuration();
            }
            this.bSn.seekTo(i);
            this.bSn.start();
        }
    }

    public void cvo() {
        if (this.bSn != null && this.bSn.isPlaying()) {
            this.bSn.pause();
        }
    }

    public void eg(String str, String str2) {
        this.jAK = false;
        this.jAG = str;
        this.jAL = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.jAG) && !TextUtils.isEmpty(this.jAL)) {
            editVideoActivityConfig.addMusicInfo(this.jAG, this.jAL, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Bb(int i) {
    }
}
