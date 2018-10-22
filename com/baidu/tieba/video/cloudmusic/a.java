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
    private final CloudMusicListModel hrE;
    private final d.b hrF;
    private MusicPlayer hrG;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hrE = cloudMusicListModel;
        this.hrF = bVar;
        bVar.a(this);
        this.hrG = MusicPlayer.bGz();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void vB(int i) {
        this.hrF.nG(true);
        this.hrE.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void al(CloudMusicData.MusicTagList musicTagList) {
                a.this.hrF.nG(false);
                if (!v.J(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hrF.nF(false);
                    a.this.hrF.b(musicTagList);
                } else {
                    a.this.hrF.nF(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hrF.bGv();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.J(musicTagList.music_list)) {
            this.hrF.nF(true);
        } else {
            this.hrF.nF(false);
            this.hrF.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hrF.bGv();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(musicList.resource);
            if (TextUtils.isEmpty(vZ)) {
                this.hrF.vy(i);
                com.baidu.tieba.video.editvideo.model.a.bHi().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void cM(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hrG.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bGx() {
                                a.this.hrG.Tu();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bHi().bHj();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void vR(String str) {
                        a.this.hrF.vA(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void bGw() {
                        a.this.hrF.vz(i);
                    }
                });
                return;
            }
            this.hrG.a(vZ, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bGx() {
                    a.this.hrG.Tu();
                    if (vZ.startsWith("/")) {
                        File file = new File(vZ);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bHi().bHj();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aBW() {
        this.hrE.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void brW() {
        this.hrE.bGF();
    }
}
