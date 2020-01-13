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
    private final CloudMusicListModel kuu;
    private final d.b kuv;
    private MusicPlayer kuw;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kuu = cloudMusicListModel;
        this.kuv = bVar;
        bVar.a(this);
        this.kuw = MusicPlayer.cNU();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Dq(int i) {
        this.kuv.tj(true);
        this.kuu.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aA(CloudMusicData.MusicTagList musicTagList) {
                a.this.kuv.tj(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kuv.ti(false);
                    a.this.kuv.b(musicTagList);
                } else {
                    a.this.kuv.ti(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kuv.cNQ();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kuv.ti(true);
        } else {
            this.kuv.ti(false);
            this.kuv.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kuv.cNQ();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String JN = com.baidu.tieba.video.editvideo.model.a.cOB().JN(musicList.resource);
            if (TextUtils.isEmpty(JN)) {
                this.kuv.Dn(i);
                com.baidu.tieba.video.editvideo.model.a.cOB().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void eA(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kuw.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cNS() {
                                a.this.kuw.aUk();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cOB().cOC();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void JG(String str) {
                        a.this.kuv.Dp(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void cNR() {
                        a.this.kuv.Do(i);
                    }
                });
                return;
            }
            this.kuw.a(JN, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cNS() {
                    a.this.kuw.aUk();
                    if (JN.startsWith("/")) {
                        File file = new File(JN);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cOB().cOC();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bER() {
        this.kuu.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void czp() {
        this.kuu.cOa();
    }
}
