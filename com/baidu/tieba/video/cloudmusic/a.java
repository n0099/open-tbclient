package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements d.a {
    private final CloudMusicListModel hkn;
    private final d.b hko;
    private MusicPlayer hkp;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hkn = cloudMusicListModel;
        this.hko = bVar;
        bVar.a(this);
        this.hkp = MusicPlayer.bDl();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ve(int i) {
        this.hko.np(true);
        this.hkn.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aj(CloudMusicData.MusicTagList musicTagList) {
                a.this.hko.np(false);
                if (!v.z(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hko.no(false);
                    a.this.hko.b(musicTagList);
                } else {
                    a.this.hko.no(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hko.bDh();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.z(musicTagList.music_list)) {
            this.hko.no(true);
        } else {
            this.hko.no(false);
            this.hko.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hko.bDh();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String vy = com.baidu.tieba.video.editvideo.model.a.bDU().vy(musicList.resource);
            if (TextUtils.isEmpty(vy)) {
                this.hko.vb(i);
                com.baidu.tieba.video.editvideo.model.a.bDU().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0248a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void cB(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hkp.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bDj() {
                                a.this.hkp.Ry();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bDU().bDV();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void vp(String str) {
                        a.this.hko.vd(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void bDi() {
                        a.this.hko.vc(i);
                    }
                });
                return;
            }
            this.hkp.a(vy, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bDj() {
                    a.this.hkp.Ry();
                    if (vy.startsWith("/")) {
                        File file = new File(vy);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bDU().bDV();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ayC() {
        this.hkn.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void boH() {
        this.hkn.bDr();
    }
}
