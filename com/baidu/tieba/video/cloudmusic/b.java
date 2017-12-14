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
    private final CloudMusicListModel gQl;
    private final e.b gQm;
    private MusicPlayer gQn;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.gQl = cloudMusicListModel;
        this.gQm = bVar;
        bVar.a(this);
        this.gQn = MusicPlayer.bBp();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void vr(int i) {
        this.gQm.nE(true);
        this.gQl.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ad(CloudMusicData.MusicTagList musicTagList) {
                b.this.gQm.nE(false);
                if (!v.w(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gQm.nD(false);
                    b.this.gQm.b(musicTagList);
                } else {
                    b.this.gQm.nD(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gQm.bBl();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.w(musicTagList.music_list)) {
            this.gQm.nD(true);
        } else {
            this.gQm.nD(false);
            this.gQm.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gQm.bBl();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(musicList.resource);
            if (TextUtils.isEmpty(uf)) {
                this.gQm.vo(i);
                com.baidu.tieba.video.editvideo.model.a.bBZ().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0148a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void cn(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gQn.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bBn() {
                                b.this.gQn.bjo();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBZ().bCa();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void tW(String str) {
                        b.this.gQm.vq(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void bBm() {
                        b.this.gQm.vp(i);
                    }
                });
                return;
            }
            this.gQn.a(uf, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bBn() {
                    b.this.gQn.bjo();
                    if (uf.startsWith("/")) {
                        File file = new File(uf);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBZ().bCa();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void and() {
        this.gQl.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bkP() {
        this.gQl.bBv();
    }
}
