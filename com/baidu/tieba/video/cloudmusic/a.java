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
    private final CloudMusicListModel lAs;
    private final d.b lAt;
    private MusicPlayer lAu;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.lAs = cloudMusicListModel;
        this.lAt = bVar;
        bVar.a(this);
        this.lAu = MusicPlayer.dhW();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ET(int i) {
        this.lAt.uS(true);
        this.lAs.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aI(CloudMusicData.MusicTagList musicTagList) {
                a.this.lAt.uS(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.lAt.uR(false);
                    a.this.lAt.b(musicTagList);
                } else {
                    a.this.lAt.uR(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.lAt.dhS();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.lAt.uR(true);
        } else {
            this.lAt.uR(false);
            this.lAt.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.lAt.dhS();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String NB = com.baidu.tieba.video.editvideo.model.a.diC().NB(musicList.resource);
            if (TextUtils.isEmpty(NB)) {
                this.lAt.EQ(i);
                com.baidu.tieba.video.editvideo.model.a.diC().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0736a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                    public void fx(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.lAu.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dhU() {
                                a.this.lAu.aJz();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.diC().diD();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                    public void Nt(String str) {
                        a.this.lAt.ES(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0736a
                    public void dhT() {
                        a.this.lAt.ER(i);
                    }
                });
                return;
            }
            this.lAu.a(NB, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dhU() {
                    a.this.lAu.aJz();
                    if (NB.startsWith("/")) {
                        File file = new File(NB);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.diC().diD();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bXE() {
        this.lAs.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cSS() {
        this.lAs.dic();
    }
}
