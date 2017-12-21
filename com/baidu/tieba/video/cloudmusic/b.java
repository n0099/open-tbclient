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
    private final CloudMusicListModel gQq;
    private final e.b gQr;
    private MusicPlayer gQs;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.gQq = cloudMusicListModel;
        this.gQr = bVar;
        bVar.a(this);
        this.gQs = MusicPlayer.bBp();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void vr(int i) {
        this.gQr.nE(true);
        this.gQq.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ad(CloudMusicData.MusicTagList musicTagList) {
                b.this.gQr.nE(false);
                if (!v.w(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gQr.nD(false);
                    b.this.gQr.b(musicTagList);
                } else {
                    b.this.gQr.nD(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gQr.bBl();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.w(musicTagList.music_list)) {
            this.gQr.nD(true);
        } else {
            this.gQr.nD(false);
            this.gQr.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gQr.bBl();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(musicList.resource);
            if (TextUtils.isEmpty(uf)) {
                this.gQr.vo(i);
                com.baidu.tieba.video.editvideo.model.a.bBZ().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0147a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void cn(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gQs.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bBn() {
                                b.this.gQs.bjo();
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

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void tW(String str) {
                        b.this.gQr.vq(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void bBm() {
                        b.this.gQr.vp(i);
                    }
                });
                return;
            }
            this.gQs.a(uf, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bBn() {
                    b.this.gQs.bjo();
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
        this.gQq.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bkP() {
        this.gQq.bBv();
    }
}
