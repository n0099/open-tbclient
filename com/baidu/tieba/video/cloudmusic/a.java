package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes7.dex */
public class a implements d.a {
    private final CloudMusicListModel nBn;
    private final d.b nBo;
    private MusicPlayer nBp;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nBn = cloudMusicListModel;
        this.nBo = bVar;
        bVar.a(this);
        this.nBp = MusicPlayer.dPY();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Kg(int i) {
        this.nBo.yE(true);
        this.nBn.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aT(CloudMusicData.MusicTagList musicTagList) {
                a.this.nBo.yE(false);
                if (!x.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nBo.yD(false);
                    a.this.nBo.b(musicTagList);
                } else {
                    a.this.nBo.yD(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nBo.dPU();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (x.isEmpty(musicTagList.music_list)) {
            this.nBo.yD(true);
        } else {
            this.nBo.yD(false);
            this.nBo.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nBo.dPU();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Tk = com.baidu.tieba.video.editvideo.model.a.dQB().Tk(musicList.resource);
            if (TextUtils.isEmpty(Tk)) {
                this.nBo.Kd(i);
                com.baidu.tieba.video.editvideo.model.a.dQB().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0883a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void gx(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nBp.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dPW() {
                                a.this.nBp.bfG();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dQB().dQC();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void Te(String str) {
                        a.this.nBo.Kf(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void dPV() {
                        a.this.nBo.Ke(i);
                    }
                });
                return;
            }
            this.nBp.a(Tk, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dPW() {
                    a.this.nBp.bfG();
                    if (Tk.startsWith("/")) {
                        File file = new File(Tk);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dQB().dQC();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cEk() {
        this.nBn.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dzE() {
        this.nBn.dQe();
    }
}
