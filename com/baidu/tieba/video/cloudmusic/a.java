package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes7.dex */
public class a implements d.a {
    private final CloudMusicListModel nND;
    private final d.b nNE;
    private MusicPlayer nNF;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nND = cloudMusicListModel;
        this.nNE = bVar;
        bVar.a(this);
        this.nNF = MusicPlayer.dSz();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void KF(int i) {
        this.nNE.yW(true);
        this.nND.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aV(CloudMusicData.MusicTagList musicTagList) {
                a.this.nNE.yW(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nNE.yV(false);
                    a.this.nNE.b(musicTagList);
                } else {
                    a.this.nNE.yV(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nNE.dSv();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nNE.yV(true);
        } else {
            this.nNE.yV(false);
            this.nNE.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nNE.dSv();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String UB = com.baidu.tieba.video.editvideo.model.a.dTc().UB(musicList.resource);
            if (TextUtils.isEmpty(UB)) {
                this.nNE.KC(i);
                com.baidu.tieba.video.editvideo.model.a.dTc().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0894a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                    public void gF(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nNF.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dSx() {
                                a.this.nNF.bfV();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dTc().dTd();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                    public void Uv(String str) {
                        a.this.nNE.KE(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                    public void dSw() {
                        a.this.nNE.KD(i);
                    }
                });
                return;
            }
            this.nNF.a(UB, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dSx() {
                    a.this.nNF.bfV();
                    if (UB.startsWith("/")) {
                        File file = new File(UB);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dTc().dTd();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cFK() {
        this.nND.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dCd() {
        this.nND.dSF();
    }
}
