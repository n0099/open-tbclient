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
    private final CloudMusicListModel lhH;
    private final d.b lhI;
    private MusicPlayer lhJ;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.lhH = cloudMusicListModel;
        this.lhI = bVar;
        bVar.a(this);
        this.lhJ = MusicPlayer.daH();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Ei(int i) {
        this.lhI.uu(true);
        this.lhH.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aF(CloudMusicData.MusicTagList musicTagList) {
                a.this.lhI.uu(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.lhI.ut(false);
                    a.this.lhI.b(musicTagList);
                } else {
                    a.this.lhI.ut(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.lhI.daD();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.lhI.ut(true);
        } else {
            this.lhI.ut(false);
            this.lhI.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.lhI.daD();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String LO = com.baidu.tieba.video.editvideo.model.a.dbn().LO(musicList.resource);
            if (TextUtils.isEmpty(LO)) {
                this.lhI.Ef(i);
                com.baidu.tieba.video.editvideo.model.a.dbn().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0683a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                    public void eW(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.lhJ.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void daF() {
                                a.this.lhJ.beL();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dbn().dbo();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                    public void LG(String str) {
                        a.this.lhI.Eh(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                    public void daE() {
                        a.this.lhI.Eg(i);
                    }
                });
                return;
            }
            this.lhJ.a(LO, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void daF() {
                    a.this.lhJ.beL();
                    if (LO.startsWith("/")) {
                        File file = new File(LO);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dbn().dbo();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bRh() {
        this.lhH.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cLR() {
        this.lhH.daN();
    }
}
