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
    private final CloudMusicListModel jvx;
    private final d.b jvy;
    private MusicPlayer jvz;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.jvx = cloudMusicListModel;
        this.jvy = bVar;
        bVar.a(this);
        this.jvz = MusicPlayer.cum();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Cg(int i) {
        this.jvy.rE(true);
        this.jvx.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void az(CloudMusicData.MusicTagList musicTagList) {
                a.this.jvy.rE(false);
                if (!v.aa(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jvy.rD(false);
                    a.this.jvy.b(musicTagList);
                } else {
                    a.this.jvy.rD(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jvy.cui();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.aa(musicTagList.music_list)) {
            this.jvy.rD(true);
        } else {
            this.jvy.rD(false);
            this.jvy.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jvy.cui();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String FN = com.baidu.tieba.video.editvideo.model.a.cuV().FN(musicList.resource);
            if (TextUtils.isEmpty(FN)) {
                this.jvy.Cd(i);
                com.baidu.tieba.video.editvideo.model.a.cuV().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0422a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void es(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jvz.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cuk() {
                                a.this.jvz.aBC();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cuV().cuW();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void FF(String str) {
                        a.this.jvy.Cf(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void cuj() {
                        a.this.jvy.Ce(i);
                    }
                });
                return;
            }
            this.jvz.a(FN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cuk() {
                    a.this.jvz.aBC();
                    if (FN.startsWith("/")) {
                        File file = new File(FN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cuV().cuW();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void boF() {
        this.jvx.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cgE() {
        this.jvx.cus();
    }
}
