package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements d.a {
    private final CloudMusicListModel nKY;
    private final d.b nKZ;
    private MusicPlayer nLa;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nKY = cloudMusicListModel;
        this.nKZ = bVar;
        bVar.a(this);
        this.nLa = MusicPlayer.dSj();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void KA(int i) {
        this.nKZ.yX(true);
        this.nKY.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aT(CloudMusicData.MusicTagList musicTagList) {
                a.this.nKZ.yX(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nKZ.yW(false);
                    a.this.nKZ.b(musicTagList);
                } else {
                    a.this.nKZ.yW(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nKZ.dSf();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nKZ.yW(true);
        } else {
            this.nKZ.yW(false);
            this.nKZ.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nKZ.dSf();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Ui = com.baidu.tieba.video.editvideo.model.a.dSM().Ui(musicList.resource);
            if (TextUtils.isEmpty(Ui)) {
                this.nKZ.Kx(i);
                com.baidu.tieba.video.editvideo.model.a.dSM().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0886a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                    public void gD(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nLa.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dSh() {
                                a.this.nLa.bfT();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dSM().dSN();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                    public void Uc(String str) {
                        a.this.nKZ.Kz(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                    public void dSg() {
                        a.this.nKZ.Ky(i);
                    }
                });
                return;
            }
            this.nLa.a(Ui, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dSh() {
                    a.this.nLa.bfT();
                    if (Ui.startsWith("/")) {
                        File file = new File(Ui);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dSM().dSN();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cFx() {
        this.nKY.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dBO() {
        this.nKY.dSp();
    }
}
