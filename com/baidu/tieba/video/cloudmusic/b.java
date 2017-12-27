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
    private final CloudMusicListModel hxs;
    private final e.b hxt;
    private MusicPlayer hxu;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.hxs = cloudMusicListModel;
        this.hxt = bVar;
        bVar.a(this);
        this.hxu = MusicPlayer.bGM();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void yh(int i) {
        this.hxt.nY(true);
        this.hxs.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void bh(CloudMusicData.MusicTagList musicTagList) {
                b.this.hxt.nY(false);
                if (!v.G(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.hxt.nX(false);
                    b.this.hxt.b(musicTagList);
                } else {
                    b.this.hxt.nX(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.hxt.bGI();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.G(musicTagList.music_list)) {
            this.hxt.nX(true);
        } else {
            this.hxt.nX(false);
            this.hxt.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hxt.bGI();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String ug = com.baidu.tieba.video.editvideo.model.a.bHw().ug(musicList.resource);
            if (TextUtils.isEmpty(ug)) {
                this.hxt.ye(i);
                com.baidu.tieba.video.editvideo.model.a.bHw().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void co(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.hxu.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bGK() {
                                b.this.hxu.bqK();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bHw().bHx();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void tX(String str) {
                        b.this.hxt.yg(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void bGJ() {
                        b.this.hxt.yf(i);
                    }
                });
                return;
            }
            this.hxu.a(ug, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bGK() {
                    b.this.hxu.bqK();
                    if (ug.startsWith("/")) {
                        File file = new File(ug);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bHw().bHx();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void auK() {
        this.hxs.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bsw() {
        this.hxs.bGS();
    }
}
