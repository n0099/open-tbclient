package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes10.dex */
public class a implements d.a {
    private final CloudMusicListModel kvw;
    private final d.b kvx;
    private MusicPlayer kvy;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kvw = cloudMusicListModel;
        this.kvx = bVar;
        bVar.a(this);
        this.kvy = MusicPlayer.cPr();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Dw(int i) {
        this.kvx.tn(true);
        this.kvw.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aC(CloudMusicData.MusicTagList musicTagList) {
                a.this.kvx.tn(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kvx.tm(false);
                    a.this.kvx.b(musicTagList);
                } else {
                    a.this.kvx.tm(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kvx.cPn();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kvx.tm(true);
        } else {
            this.kvx.tm(false);
            this.kvx.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kvx.cPn();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Ka = com.baidu.tieba.video.editvideo.model.a.cPW().Ka(musicList.resource);
            if (TextUtils.isEmpty(Ka)) {
                this.kvx.Dt(i);
                com.baidu.tieba.video.editvideo.model.a.cPW().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void eJ(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kvy.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cPp() {
                                a.this.kvy.aWA();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cPW().cPX();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void JT(String str) {
                        a.this.kvx.Dv(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void cPo() {
                        a.this.kvx.Du(i);
                    }
                });
                return;
            }
            this.kvy.a(Ka, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cPp() {
                    a.this.kvy.aWA();
                    if (Ka.startsWith("/")) {
                        File file = new File(Ka);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cPW().cPX();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bGt() {
        this.kvw.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cAM() {
        this.kvw.cPx();
    }
}
