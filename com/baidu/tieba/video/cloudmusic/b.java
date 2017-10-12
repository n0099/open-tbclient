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
    private final CloudMusicListModel guj;
    private final e.b guk;
    private MusicPlayer gul;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.guj = cloudMusicListModel;
        this.guk = bVar;
        bVar.a(this);
        this.gul = MusicPlayer.bvy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void uu(int i) {
        this.guk.na(true);
        this.guj.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void Y(CloudMusicData.MusicTagList musicTagList) {
                b.this.guk.na(false);
                if (!v.u(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.guk.mZ(false);
                    b.this.guk.b(musicTagList);
                } else {
                    b.this.guk.mZ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.guk.bvu();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.u(musicTagList.music_list)) {
            this.guk.mZ(true);
        } else {
            this.guk.mZ(false);
            this.guk.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.guk.bvu();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String sB = com.baidu.tieba.video.editvideo.model.a.bvS().sB(musicList.resource);
            if (TextUtils.isEmpty(sB)) {
                this.guk.ur(i);
                com.baidu.tieba.video.editvideo.model.a.bvS().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void cj(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gul.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bvw() {
                                b.this.gul.bem();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bvS().bvT();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void sy(String str) {
                        b.this.guk.ut(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void bvv() {
                        b.this.guk.us(i);
                    }
                });
                return;
            }
            this.gul.a(sB, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bvw() {
                    b.this.gul.bem();
                    if (sB.startsWith("/")) {
                        File file = new File(sB);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bvS().bvT();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void aiD() {
        this.guj.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bfp() {
        this.guj.bvE();
    }
}
