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
    private final CloudMusicListModel hoE;
    private final e.b hoF;
    private MusicPlayer hoG;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.hoE = cloudMusicListModel;
        this.hoF = bVar;
        bVar.a(this);
        this.hoG = MusicPlayer.bAV();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void wI(int i) {
        this.hoF.nk(true);
        this.hoE.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void bg(CloudMusicData.MusicTagList musicTagList) {
                b.this.hoF.nk(false);
                if (!v.E(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.hoF.nj(false);
                    b.this.hoF.b(musicTagList);
                } else {
                    b.this.hoF.nj(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.hoF.bAR();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.E(musicTagList.music_list)) {
            this.hoF.nj(true);
        } else {
            this.hoF.nj(false);
            this.hoF.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hoF.bAR();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tN = com.baidu.tieba.video.editvideo.model.a.bBE().tN(musicList.resource);
            if (TextUtils.isEmpty(tN)) {
                this.hoF.wF(i);
                com.baidu.tieba.video.editvideo.model.a.bBE().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void cj(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.hoG.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAT() {
                                b.this.hoG.blr();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBE().bBF();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void tE(String str) {
                        b.this.hoF.wH(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void bAS() {
                        b.this.hoF.wG(i);
                    }
                });
                return;
            }
            this.hoG.a(tN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAT() {
                    b.this.hoG.blr();
                    if (tN.startsWith("/")) {
                        File file = new File(tN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBE().bBF();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void awP() {
        this.hoE.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bnd() {
        this.hoE.bBb();
    }
}
