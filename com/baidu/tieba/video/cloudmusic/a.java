package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements d.a {
    private final CloudMusicListModel joj;
    private final d.b jok;
    private MusicPlayer jol;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.joj = cloudMusicListModel;
        this.jok = bVar;
        bVar.a(this);
        this.jol = MusicPlayer.crf();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Bx(int i) {
        this.jok.rq(true);
        this.joj.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void az(CloudMusicData.MusicTagList musicTagList) {
                a.this.jok.rq(false);
                if (!v.aa(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jok.rp(false);
                    a.this.jok.b(musicTagList);
                } else {
                    a.this.jok.rp(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jok.crb();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.aa(musicTagList.music_list)) {
            this.jok.rp(true);
        } else {
            this.jok.rp(false);
            this.jok.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jok.crb();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String EY = com.baidu.tieba.video.editvideo.model.a.crM().EY(musicList.resource);
            if (TextUtils.isEmpty(EY)) {
                this.jok.Bu(i);
                com.baidu.tieba.video.editvideo.model.a.crM().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jol.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void crd() {
                                a.this.jol.aAl();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.crM().crN();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EQ(String str) {
                        a.this.jok.Bw(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void crc() {
                        a.this.jok.Bv(i);
                    }
                });
                return;
            }
            this.jol.a(EY, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void crd() {
                    a.this.jol.aAl();
                    if (EY.startsWith("/")) {
                        File file = new File(EY);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.crM().crN();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bmr() {
        this.joj.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cdv() {
        this.joj.crl();
    }
}
