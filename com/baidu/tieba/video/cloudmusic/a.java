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
    private final CloudMusicListModel lhD;
    private final d.b lhE;
    private MusicPlayer lhF;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.lhD = cloudMusicListModel;
        this.lhE = bVar;
        bVar.a(this);
        this.lhF = MusicPlayer.daK();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Ei(int i) {
        this.lhE.uu(true);
        this.lhD.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aE(CloudMusicData.MusicTagList musicTagList) {
                a.this.lhE.uu(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.lhE.ut(false);
                    a.this.lhE.b(musicTagList);
                } else {
                    a.this.lhE.ut(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.lhE.daG();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.lhE.ut(true);
        } else {
            this.lhE.ut(false);
            this.lhE.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.lhE.daG();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String LL = com.baidu.tieba.video.editvideo.model.a.dbq().LL(musicList.resource);
            if (TextUtils.isEmpty(LL)) {
                this.lhE.Ef(i);
                com.baidu.tieba.video.editvideo.model.a.dbq().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0662a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                    public void eW(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.lhF.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void daI() {
                                a.this.lhF.beN();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dbq().dbr();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                    public void LD(String str) {
                        a.this.lhE.Eh(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                    public void daH() {
                        a.this.lhE.Eg(i);
                    }
                });
                return;
            }
            this.lhF.a(LL, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void daI() {
                    a.this.lhF.beN();
                    if (LL.startsWith("/")) {
                        File file = new File(LL);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dbq().dbr();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bRj() {
        this.lhD.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cLU() {
        this.lhD.daQ();
    }
}
