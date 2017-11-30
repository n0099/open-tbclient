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
    private final CloudMusicListModel gND;
    private final e.b gNE;
    private MusicPlayer gNF;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.gND = cloudMusicListModel;
        this.gNE = bVar;
        bVar.a(this);
        this.gNF = MusicPlayer.bAI();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void vg(int i) {
        this.gNE.nC(true);
        this.gND.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ad(CloudMusicData.MusicTagList musicTagList) {
                b.this.gNE.nC(false);
                if (!v.w(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gNE.nB(false);
                    b.this.gNE.b(musicTagList);
                } else {
                    b.this.gNE.nB(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gNE.bAE();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.w(musicTagList.music_list)) {
            this.gNE.nB(true);
        } else {
            this.gNE.nB(false);
            this.gNE.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gNE.bAE();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String ua = com.baidu.tieba.video.editvideo.model.a.bBs().ua(musicList.resource);
            if (TextUtils.isEmpty(ua)) {
                this.gNE.vd(i);
                com.baidu.tieba.video.editvideo.model.a.bBs().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0133a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void cm(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gNF.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAG() {
                                b.this.gNF.bjf();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBs().bBt();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void tR(String str) {
                        b.this.gNE.vf(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0133a
                    public void bAF() {
                        b.this.gNE.ve(i);
                    }
                });
                return;
            }
            this.gNF.a(ua, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAG() {
                    b.this.gNF.bjf();
                    if (ua.startsWith("/")) {
                        File file = new File(ua);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBs().bBt();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void amU() {
        this.gND.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bkH() {
        this.gND.bAO();
    }
}
