package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements d.a {
    private final CloudMusicListModel hbh;
    private final d.b hbi;
    private MusicPlayer hbj;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hbh = cloudMusicListModel;
        this.hbi = bVar;
        bVar.a(this);
        this.hbj = MusicPlayer.bBJ();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void uF(int i) {
        this.hbi.ng(true);
        this.hbh.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ag(CloudMusicData.MusicTagList musicTagList) {
                a.this.hbi.ng(false);
                if (!w.A(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hbi.nf(false);
                    a.this.hbi.b(musicTagList);
                } else {
                    a.this.hbi.nf(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hbi.bBF();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (w.A(musicTagList.music_list)) {
            this.hbi.nf(true);
        } else {
            this.hbi.nf(false);
            this.hbi.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hbi.bBF();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String uN = com.baidu.tieba.video.editvideo.model.a.bCs().uN(musicList.resource);
            if (TextUtils.isEmpty(uN)) {
                this.hbi.uC(i);
                com.baidu.tieba.video.editvideo.model.a.bCs().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cu(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hbj.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bBH() {
                                a.this.hbj.blZ();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bCs().bCt();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uE(String str) {
                        a.this.hbi.uE(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bBG() {
                        a.this.hbi.uD(i);
                    }
                });
                return;
            }
            this.hbj.a(uN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bBH() {
                    a.this.hbj.blZ();
                    if (uN.startsWith("/")) {
                        File file = new File(uN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bCs().bCt();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void avN() {
        this.hbh.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bnL() {
        this.hbh.bBP();
    }
}
