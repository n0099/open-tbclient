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
    private final CloudMusicListModel joe;
    private final d.b jof;
    private MusicPlayer jog;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.joe = cloudMusicListModel;
        this.jof = bVar;
        bVar.a(this);
        this.jog = MusicPlayer.crc();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Bx(int i) {
        this.jof.rp(true);
        this.joe.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void az(CloudMusicData.MusicTagList musicTagList) {
                a.this.jof.rp(false);
                if (!v.aa(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jof.ro(false);
                    a.this.jof.b(musicTagList);
                } else {
                    a.this.jof.ro(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jof.cqY();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.aa(musicTagList.music_list)) {
            this.jof.ro(true);
        } else {
            this.jof.ro(false);
            this.jof.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jof.cqY();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String EW = com.baidu.tieba.video.editvideo.model.a.crL().EW(musicList.resource);
            if (TextUtils.isEmpty(EW)) {
                this.jof.Bu(i);
                com.baidu.tieba.video.editvideo.model.a.crL().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jog.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cra() {
                                a.this.jog.aAi();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.crL().crM();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EO(String str) {
                        a.this.jof.Bw(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void cqZ() {
                        a.this.jof.Bv(i);
                    }
                });
                return;
            }
            this.jog.a(EW, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cra() {
                    a.this.jog.aAi();
                    if (EW.startsWith("/")) {
                        File file = new File(EW);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.crL().crM();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bmo() {
        this.joe.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cdr() {
        this.joe.cri();
    }
}
