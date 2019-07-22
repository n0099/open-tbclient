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
    private final CloudMusicListModel juq;
    private final d.b jur;
    private MusicPlayer jus;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.juq = cloudMusicListModel;
        this.jur = bVar;
        bVar.a(this);
        this.jus = MusicPlayer.ctQ();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Ce(int i) {
        this.jur.rD(true);
        this.juq.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void az(CloudMusicData.MusicTagList musicTagList) {
                a.this.jur.rD(false);
                if (!v.aa(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jur.rC(false);
                    a.this.jur.b(musicTagList);
                } else {
                    a.this.jur.rC(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jur.ctM();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.aa(musicTagList.music_list)) {
            this.jur.rC(true);
        } else {
            this.jur.rC(false);
            this.jur.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jur.ctM();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String FM = com.baidu.tieba.video.editvideo.model.a.cuz().FM(musicList.resource);
            if (TextUtils.isEmpty(FM)) {
                this.jur.Cb(i);
                com.baidu.tieba.video.editvideo.model.a.cuz().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0416a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                    public void es(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jus.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void ctO() {
                                a.this.jus.aBA();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cuz().cuA();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                    public void FE(String str) {
                        a.this.jur.Cd(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0416a
                    public void ctN() {
                        a.this.jur.Cc(i);
                    }
                });
                return;
            }
            this.jus.a(FM, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void ctO() {
                    a.this.jus.aBA();
                    if (FM.startsWith("/")) {
                        File file = new File(FM);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cuz().cuA();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bos() {
        this.juq.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cgm() {
        this.juq.ctW();
    }
}
