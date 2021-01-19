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
    private final CloudMusicListModel nBo;
    private final d.b nBp;
    private MusicPlayer nBq;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nBo = cloudMusicListModel;
        this.nBp = bVar;
        bVar.a(this);
        this.nBq = MusicPlayer.dPY();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Kg(int i) {
        this.nBp.yE(true);
        this.nBo.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aT(CloudMusicData.MusicTagList musicTagList) {
                a.this.nBp.yE(false);
                if (!x.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nBp.yD(false);
                    a.this.nBp.b(musicTagList);
                } else {
                    a.this.nBp.yD(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nBp.dPU();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (x.isEmpty(musicTagList.music_list)) {
            this.nBp.yD(true);
        } else {
            this.nBp.yD(false);
            this.nBp.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nBp.dPU();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Tl = com.baidu.tieba.video.editvideo.model.a.dQB().Tl(musicList.resource);
            if (TextUtils.isEmpty(Tl)) {
                this.nBp.Kd(i);
                com.baidu.tieba.video.editvideo.model.a.dQB().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0883a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void gx(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nBq.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dPW() {
                                a.this.nBq.bfG();
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
                    public void Tf(String str) {
                        a.this.nBp.Kf(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void dPV() {
                        a.this.nBp.Ke(i);
                    }
                });
                return;
            }
            this.nBq.a(Tl, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dPW() {
                    a.this.nBq.bfG();
                    if (Tl.startsWith("/")) {
                        File file = new File(Tl);
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
        this.nBo.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dzE() {
        this.nBo.dQe();
    }
}
