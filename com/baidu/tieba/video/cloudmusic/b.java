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
    private final CloudMusicListModel hoP;
    private final e.b hoQ;
    private MusicPlayer hoR;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.hoP = cloudMusicListModel;
        this.hoQ = bVar;
        bVar.a(this);
        this.hoR = MusicPlayer.bAZ();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void wJ(int i) {
        this.hoQ.np(true);
        this.hoP.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void bg(CloudMusicData.MusicTagList musicTagList) {
                b.this.hoQ.np(false);
                if (!v.E(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.hoQ.no(false);
                    b.this.hoQ.b(musicTagList);
                } else {
                    b.this.hoQ.no(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.hoQ.bAV();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.E(musicTagList.music_list)) {
            this.hoQ.no(true);
        } else {
            this.hoQ.no(false);
            this.hoQ.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hoQ.bAV();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tN = com.baidu.tieba.video.editvideo.model.a.bBI().tN(musicList.resource);
            if (TextUtils.isEmpty(tN)) {
                this.hoQ.wG(i);
                com.baidu.tieba.video.editvideo.model.a.bBI().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cj(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.hoR.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAX() {
                                b.this.hoR.blr();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBI().bBJ();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void tE(String str) {
                        b.this.hoQ.wI(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAW() {
                        b.this.hoQ.wH(i);
                    }
                });
                return;
            }
            this.hoR.a(tN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAX() {
                    b.this.hoR.blr();
                    if (tN.startsWith("/")) {
                        File file = new File(tN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBI().bBJ();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void awQ() {
        this.hoP.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void bnd() {
        this.hoP.bBf();
    }
}
