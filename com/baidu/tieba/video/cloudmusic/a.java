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
    private final CloudMusicListModel iVg;
    private final d.b iVh;
    private MusicPlayer iVi;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.iVg = cloudMusicListModel;
        this.iVh = bVar;
        bVar.a(this);
        this.iVi = MusicPlayer.ciZ();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Ap(int i) {
        this.iVh.qA(true);
        this.iVg.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ax(CloudMusicData.MusicTagList musicTagList) {
                a.this.iVh.qA(false);
                if (!v.T(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.iVh.qz(false);
                    a.this.iVh.b(musicTagList);
                } else {
                    a.this.iVh.qz(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.iVh.ciV();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.T(musicTagList.music_list)) {
            this.iVh.qz(true);
        } else {
            this.iVh.qz(false);
            this.iVh.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.iVh.ciV();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(musicList.resource);
            if (TextUtils.isEmpty(DA)) {
                this.iVh.Am(i);
                com.baidu.tieba.video.editvideo.model.a.cjI().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ed(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.iVi.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void ciX() {
                                a.this.iVi.avd();
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
                        a.this.iVh.Ao(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciW() {
                        a.this.iVh.An(i);
                    }
                });
                return;
            }
            this.iVi.a(DA, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void ciX() {
                    a.this.iVi.avd();
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
        this.iVg.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bVq() {
        this.iVg.cjf();
    }
}
