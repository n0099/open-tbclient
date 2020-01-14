package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements d.a {
    private final d.b kuA;
    private MusicPlayer kuB;
    private final CloudMusicListModel kuz;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kuz = cloudMusicListModel;
        this.kuA = bVar;
        bVar.a(this);
        this.kuB = MusicPlayer.cNW();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Dq(int i) {
        this.kuA.tj(true);
        this.kuz.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aA(CloudMusicData.MusicTagList musicTagList) {
                a.this.kuA.tj(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kuA.ti(false);
                    a.this.kuA.b(musicTagList);
                } else {
                    a.this.kuA.ti(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kuA.cNS();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kuA.ti(true);
        } else {
            this.kuA.ti(false);
            this.kuA.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kuA.cNS();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String JN = com.baidu.tieba.video.editvideo.model.a.cOD().JN(musicList.resource);
            if (TextUtils.isEmpty(JN)) {
                this.kuA.Dn(i);
                com.baidu.tieba.video.editvideo.model.a.cOD().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void eA(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kuB.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cNU() {
                                a.this.kuB.aUk();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cOD().cOE();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void JG(String str) {
                        a.this.kuA.Dp(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void cNT() {
                        a.this.kuA.Do(i);
                    }
                });
                return;
            }
            this.kuB.a(JN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cNU() {
                    a.this.kuB.aUk();
                    if (JN.startsWith("/")) {
                        File file = new File(JN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cOD().cOE();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bER() {
        this.kuz.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void czr() {
        this.kuz.cOc();
    }
}
