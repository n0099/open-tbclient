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
    private MusicPlayer kvA;
    private final CloudMusicListModel kvy;
    private final d.b kvz;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kvy = cloudMusicListModel;
        this.kvz = bVar;
        bVar.a(this);
        this.kvA = MusicPlayer.cPt();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Dw(int i) {
        this.kvz.tn(true);
        this.kvy.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aC(CloudMusicData.MusicTagList musicTagList) {
                a.this.kvz.tn(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kvz.tm(false);
                    a.this.kvz.b(musicTagList);
                } else {
                    a.this.kvz.tm(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kvz.cPp();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kvz.tm(true);
        } else {
            this.kvz.tm(false);
            this.kvz.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kvz.cPp();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Ka = com.baidu.tieba.video.editvideo.model.a.cPY().Ka(musicList.resource);
            if (TextUtils.isEmpty(Ka)) {
                this.kvz.Dt(i);
                com.baidu.tieba.video.editvideo.model.a.cPY().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void eJ(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kvA.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cPr() {
                                a.this.kvA.aWC();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cPY().cPZ();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void JT(String str) {
                        a.this.kvz.Dv(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void cPq() {
                        a.this.kvz.Du(i);
                    }
                });
                return;
            }
            this.kvA.a(Ka, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cPr() {
                    a.this.kvA.aWC();
                    if (Ka.startsWith("/")) {
                        File file = new File(Ka);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cPY().cPZ();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bGv() {
        this.kvy.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cAO() {
        this.kvy.cPz();
    }
}
