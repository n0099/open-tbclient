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
    private MediaPlayer bTe;
    private boolean isDownLoading;
    private boolean jBB;
    private String jBC;
    private String jBx;
    private com.baidu.tieba.j.h jjG;
    private SelectMusicModel jyE;
    private Context mContext;
    private int mPosition;

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjG = lVar.bMY();
        }
        this.mContext = activity;
    }

    public void b(SelectMusicModel selectMusicModel) {
        this.jyE = selectMusicModel;
    }

    public void a(MusicData musicData, Object obj) {
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 0:
                    a(obj, musicData);
                    return;
                case 1:
                    aCa();
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext, RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void aCa() {
        if (this.bTe != null) {
            if (this.bTe.isPlaying()) {
                this.bTe.stop();
            }
            this.bTe.release();
            this.bTe = null;
        }
        this.jBx = null;
        this.jBC = null;
    }

    private void a(Object obj, final MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            if (this.bTe != null && this.bTe.isPlaying()) {
                this.bTe.stop();
            }
            this.isDownLoading = false;
            this.jBC = musicData.id;
            String EP = com.baidu.tieba.video.editvideo.model.a.ctx().EP(musicData.resource);
            if (obj != null && (obj instanceof d.a)) {
                this.mPosition = ((d.a) obj).position;
            }
            if (TextUtils.isEmpty(EP)) {
                if (obj instanceof d.a) {
                    final d.a aVar = (d.a) obj;
                    aVar.mProgressBar.setVisibility(0);
                    aVar.jyS.setDrawBorder(false);
                    aVar.jyS.invalidate();
                    this.isDownLoading = true;
                    com.baidu.tieba.video.editvideo.model.a.ctx().a(musicData.id, musicData.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.record.j.1
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void ef(String str, String str2) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                j.this.a(str, musicData);
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jyS.setDrawBorder(true);
                                aVar.jyS.invalidate();
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void EH(String str) {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.mProgressBar.setVisibility(4);
                                aVar.jyS.setDrawBorder(true);
                                aVar.jyS.invalidate();
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                                if (j.this.jjG != null) {
                                    j.this.jjG.av(3, str);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void csM() {
                            if (aVar.position == j.this.mPosition) {
                                j.this.isDownLoading = false;
                                aVar.jyS.setDrawBorder(true);
                                aVar.jyS.invalidate();
                                aVar.mProgressBar.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.ctx().a(musicData.id, musicData.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.record.j.2
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
                        if (j.this.jjG != null) {
                            j.this.jjG.av(3, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void csM() {
                    }
                });
                return;
            }
            a(EP, musicData);
        }
    }

    public boolean cvh() {
        return this.isDownLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MusicData musicData) {
        if (!this.jBB) {
            if (this.bTe == null) {
                this.bTe = new MediaPlayer();
                this.bTe.setAudioStreamType(3);
            }
            try {
                this.jBx = str;
                this.bTe.reset();
                this.bTe.setDataSource(str);
                this.bTe.prepare();
                this.bTe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.record.j.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        j.this.bTe.setLooping(true);
                        j.this.bTe.start();
                    }
                });
                this.bTe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.record.j.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (j.this.jjG != null) {
                            j.this.jjG.av(4, "what-->" + i + "  extra-->" + i2);
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
        this.jBx = null;
        aCa();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.ctx().cty();
        }
        a((Object) null, musicData);
    }

    public String cvp() {
        return this.jBx;
    }

    public void onPause() {
        this.jBB = true;
        if (this.bTe != null && this.bTe.isPlaying()) {
            this.bTe.pause();
        }
    }

    public void onResume() {
        this.jBB = false;
        if (this.bTe != null) {
            this.bTe.start();
            this.bTe.seekTo(0);
        }
    }

    public void Bd(int i) {
        if (this.bTe != null && this.bTe.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.bTe.getDuration()) {
                i %= this.bTe.getDuration();
            }
            this.bTe.seekTo(i);
            this.bTe.start();
        }
    }

    public void cvq() {
        if (this.bTe != null && this.bTe.isPlaying()) {
            this.bTe.pause();
        }
    }

    public void eg(String str, String str2) {
        this.jBB = false;
        this.jBx = str;
        this.jBC = str2;
        a(str, (MusicData) null);
    }

    public void a(EditVideoActivityConfig editVideoActivityConfig) {
        if (!TextUtils.isEmpty(this.jBx) && !TextUtils.isEmpty(this.jBC)) {
            editVideoActivityConfig.addMusicInfo(this.jBx, this.jBC, this.mPosition);
        }
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Bc(int i) {
    }
}
