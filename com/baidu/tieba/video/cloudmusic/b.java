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
    private final CloudMusicListModel guk;
    private final e.b gul;
    private MusicPlayer gum;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.guk = cloudMusicListModel;
        this.gul = bVar;
        bVar.a(this);
        this.gum = MusicPlayer.bvz();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void uu(int i) {
        this.gul.na(true);
        this.guk.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void Y(CloudMusicData.MusicTagList musicTagList) {
                b.this.gul.na(false);
                if (!v.u(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gul.mZ(false);
                    b.this.gul.b(musicTagList);
                } else {
                    b.this.gul.mZ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gul.bvv();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.u(musicTagList.music_list)) {
            this.gul.mZ(true);
        } else {
            this.gul.mZ(false);
            this.gul.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gul.bvv();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String sB = com.baidu.tieba.video.editvideo.model.a.bvT().sB(musicList.resource);
            if (TextUtils.isEmpty(sB)) {
                this.gul.ur(i);
                com.baidu.tieba.video.editvideo.model.a.bvT().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void cj(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gum.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bvx() {
                                b.this.gum.ben();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bvT().bvU();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void sy(String str) {
                        b.this.gul.ut(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void bvw() {
                        b.this.gul.us(i);
                    }
                });
                return;
            }
            this.gum.a(sB, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bvx() {
                    b.this.gum.ben();
                    if (sB.startsWith("/")) {
                        File file = new File(sB);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bvT().bvU();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void aiD() {
        this.guk.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bfq() {
        this.guk.bvF();
    }
}
