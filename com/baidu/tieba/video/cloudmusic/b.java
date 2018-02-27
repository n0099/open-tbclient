package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class b implements e.a {
    private final CloudMusicListModel hor;
    private final e.b hos;
    private MusicPlayer hot;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.hor = cloudMusicListModel;
        this.hos = bVar;
        bVar.a(this);
        this.hot = MusicPlayer.bAU();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void wJ(int i) {
        this.hos.nk(true);
        this.hor.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void bg(CloudMusicData.MusicTagList musicTagList) {
                b.this.hos.nk(false);
                if (!v.E(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.hos.nj(false);
                    b.this.hos.b(musicTagList);
                } else {
                    b.this.hos.nj(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.hos.bAQ();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.E(musicTagList.music_list)) {
            this.hos.nj(true);
        } else {
            this.hos.nj(false);
            this.hos.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hos.bAQ();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tN = com.baidu.tieba.video.editvideo.model.a.bBD().tN(musicList.resource);
            if (TextUtils.isEmpty(tN)) {
                this.hos.wG(i);
                com.baidu.tieba.video.editvideo.model.a.bBD().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cj(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.hot.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAS() {
                                b.this.hot.blq();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBD().bBE();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void tE(String str) {
                        b.this.hos.wI(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAR() {
                        b.this.hos.wH(i);
                    }
                });
                return;
            }
            this.hot.a(tN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAS() {
                    b.this.hot.blq();
                    if (tN.startsWith("/")) {
                        File file = new File(tN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBD().bBE();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void awO() {
        this.hor.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bnc() {
        this.hor.bBa();
    }
}
