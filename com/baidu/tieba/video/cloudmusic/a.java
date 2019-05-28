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
    private final CloudMusicListModel jof;
    private final d.b jog;
    private MusicPlayer joh;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.jof = cloudMusicListModel;
        this.jog = bVar;
        bVar.a(this);
        this.joh = MusicPlayer.cre();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Bx(int i) {
        this.jog.rp(true);
        this.jof.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void az(CloudMusicData.MusicTagList musicTagList) {
                a.this.jog.rp(false);
                if (!v.aa(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jog.ro(false);
                    a.this.jog.b(musicTagList);
                } else {
                    a.this.jog.ro(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jog.cra();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.aa(musicTagList.music_list)) {
            this.jog.ro(true);
        } else {
            this.jog.ro(false);
            this.jog.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jog.cra();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String EW = com.baidu.tieba.video.editvideo.model.a.crN().EW(musicList.resource);
            if (TextUtils.isEmpty(EW)) {
                this.jog.Bu(i);
                com.baidu.tieba.video.editvideo.model.a.crN().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.joh.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void crc() {
                                a.this.joh.aAl();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.crN().crO();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EO(String str) {
                        a.this.jog.Bw(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void crb() {
                        a.this.jog.Bv(i);
                    }
                });
                return;
            }
            this.joh.a(EW, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void crc() {
                    a.this.joh.aAl();
                    if (EW.startsWith("/")) {
                        File file = new File(EW);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.crN().crO();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bmr() {
        this.jof.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cdu() {
        this.jof.crk();
    }
}
