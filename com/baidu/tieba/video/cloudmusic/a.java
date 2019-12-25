package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes7.dex */
public class a implements d.a {
    private final CloudMusicListModel kqR;
    private final d.b kqS;
    private MusicPlayer kqT;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kqR = cloudMusicListModel;
        this.kqS = bVar;
        bVar.a(this);
        this.kqT = MusicPlayer.cMP();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Dk(int i) {
        this.kqS.sX(true);
        this.kqR.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aA(CloudMusicData.MusicTagList musicTagList) {
                a.this.kqS.sX(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kqS.sW(false);
                    a.this.kqS.b(musicTagList);
                } else {
                    a.this.kqS.sW(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kqS.cML();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kqS.sW(true);
        } else {
            this.kqS.sW(false);
            this.kqS.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kqS.cML();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String JD = com.baidu.tieba.video.editvideo.model.a.cNw().JD(musicList.resource);
            if (TextUtils.isEmpty(JD)) {
                this.kqS.Dh(i);
                com.baidu.tieba.video.editvideo.model.a.cNw().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0607a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                    public void ey(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kqT.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cMN() {
                                a.this.kqT.aTQ();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cNw().cNx();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                    public void Jw(String str) {
                        a.this.kqS.Dj(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                    public void cMM() {
                        a.this.kqS.Di(i);
                    }
                });
                return;
            }
            this.kqT.a(JD, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cMN() {
                    a.this.kqT.aTQ();
                    if (JD.startsWith("/")) {
                        File file = new File(JD);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cNw().cNx();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bDP() {
        this.kqR.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cyi() {
        this.kqR.cMV();
    }
}
