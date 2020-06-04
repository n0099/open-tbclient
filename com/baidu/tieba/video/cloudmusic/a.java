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
    private final CloudMusicListModel lBB;
    private final d.b lBC;
    private MusicPlayer lBD;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.lBB = cloudMusicListModel;
        this.lBC = bVar;
        bVar.a(this);
        this.lBD = MusicPlayer.dil();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void EV(int i) {
        this.lBC.uS(true);
        this.lBB.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aI(CloudMusicData.MusicTagList musicTagList) {
                a.this.lBC.uS(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.lBC.uR(false);
                    a.this.lBC.b(musicTagList);
                } else {
                    a.this.lBC.uR(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.lBC.dih();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.lBC.uR(true);
        } else {
            this.lBC.uR(false);
            this.lBC.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.lBC.dih();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String NC = com.baidu.tieba.video.editvideo.model.a.diR().NC(musicList.resource);
            if (TextUtils.isEmpty(NC)) {
                this.lBC.ES(i);
                com.baidu.tieba.video.editvideo.model.a.diR().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0737a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                    public void fx(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.lBD.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dij() {
                                a.this.lBD.aJz();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.diR().diS();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                    public void Nu(String str) {
                        a.this.lBC.EU(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                    public void dii() {
                        a.this.lBC.ET(i);
                    }
                });
                return;
            }
            this.lBD.a(NC, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dij() {
                    a.this.lBD.aJz();
                    if (NC.startsWith("/")) {
                        File file = new File(NC);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.diR().diS();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bXG() {
        this.lBB.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cTi() {
        this.lBB.dir();
    }
}
