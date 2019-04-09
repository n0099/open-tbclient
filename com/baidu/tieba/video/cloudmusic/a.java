package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements d.a {
    private final CloudMusicListModel iVh;
    private final d.b iVi;
    private MusicPlayer iVj;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.iVh = cloudMusicListModel;
        this.iVi = bVar;
        bVar.a(this);
        this.iVj = MusicPlayer.ciZ();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Ap(int i) {
        this.iVi.qA(true);
        this.iVh.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ax(CloudMusicData.MusicTagList musicTagList) {
                a.this.iVi.qA(false);
                if (!v.T(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.iVi.qz(false);
                    a.this.iVi.b(musicTagList);
                } else {
                    a.this.iVi.qz(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.iVi.ciV();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.T(musicTagList.music_list)) {
            this.iVi.qz(true);
        } else {
            this.iVi.qz(false);
            this.iVi.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.iVi.ciV();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(musicList.resource);
            if (TextUtils.isEmpty(DA)) {
                this.iVi.Am(i);
                com.baidu.tieba.video.editvideo.model.a.cjI().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ed(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.iVj.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void ciX() {
                                a.this.iVj.avd();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cjI().cjJ();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void Ds(String str) {
                        a.this.iVi.Ao(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciW() {
                        a.this.iVi.An(i);
                    }
                });
                return;
            }
            this.iVj.a(DA, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void ciX() {
                    a.this.iVj.avd();
                    if (DA.startsWith("/")) {
                        File file = new File(DA);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cjI().cjJ();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void beW() {
        this.iVh.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bVq() {
        this.iVh.cjf();
    }
}
