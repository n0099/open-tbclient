package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements d.a {
    private MusicPlayer nLA;
    private final CloudMusicListModel nLy;
    private final d.b nLz;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nLy = cloudMusicListModel;
        this.nLz = bVar;
        bVar.a(this);
        this.nLA = MusicPlayer.dSr();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void KA(int i) {
        this.nLz.yX(true);
        this.nLy.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aT(CloudMusicData.MusicTagList musicTagList) {
                a.this.nLz.yX(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nLz.yW(false);
                    a.this.nLz.b(musicTagList);
                } else {
                    a.this.nLz.yW(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nLz.dSn();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nLz.yW(true);
        } else {
            this.nLz.yW(false);
            this.nLz.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nLz.dSn();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Uu = com.baidu.tieba.video.editvideo.model.a.dSU().Uu(musicList.resource);
            if (TextUtils.isEmpty(Uu)) {
                this.nLz.Kx(i);
                com.baidu.tieba.video.editvideo.model.a.dSU().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0888a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void gF(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nLA.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dSp() {
                                a.this.nLA.bfT();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dSU().dSV();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void Uo(String str) {
                        a.this.nLz.Kz(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void dSo() {
                        a.this.nLz.Ky(i);
                    }
                });
                return;
            }
            this.nLA.a(Uu, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dSp() {
                    a.this.nLA.bfT();
                    if (Uu.startsWith("/")) {
                        File file = new File(Uu);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dSU().dSV();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cFE() {
        this.nLy.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dBV() {
        this.nLy.dSx();
    }
}
