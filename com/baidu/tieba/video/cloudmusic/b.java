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
    private final CloudMusicListModel gtV;
    private final e.b gtW;
    private MusicPlayer gtX;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.gtV = cloudMusicListModel;
        this.gtW = bVar;
        bVar.a(this);
        this.gtX = MusicPlayer.bvq();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void ut(int i) {
        this.gtW.mZ(true);
        this.gtV.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void Y(CloudMusicData.MusicTagList musicTagList) {
                b.this.gtW.mZ(false);
                if (!v.u(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gtW.mY(false);
                    b.this.gtW.b(musicTagList);
                } else {
                    b.this.gtW.mY(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gtW.bvm();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.u(musicTagList.music_list)) {
            this.gtW.mY(true);
        } else {
            this.gtW.mY(false);
            this.gtW.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gtW.bvm();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String sA = com.baidu.tieba.video.editvideo.model.a.bvK().sA(musicList.resource);
            if (TextUtils.isEmpty(sA)) {
                this.gtW.uq(i);
                com.baidu.tieba.video.editvideo.model.a.bvK().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void ci(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gtX.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bvo() {
                                b.this.gtX.beh();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bvK().bvL();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void sx(String str) {
                        b.this.gtW.us(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void bvn() {
                        b.this.gtW.ur(i);
                    }
                });
                return;
            }
            this.gtX.a(sA, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bvo() {
                    b.this.gtX.beh();
                    if (sA.startsWith("/")) {
                        File file = new File(sA);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bvK().bvL();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void aiy() {
        this.gtV.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bfk() {
        this.gtV.bvw();
    }
}
