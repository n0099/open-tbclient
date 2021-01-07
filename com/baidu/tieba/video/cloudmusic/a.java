package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements d.a {
    private final CloudMusicListModel nFS;
    private final d.b nFT;
    private MusicPlayer nFU;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nFS = cloudMusicListModel;
        this.nFT = bVar;
        bVar.a(this);
        this.nFU = MusicPlayer.dTQ();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void LN(int i) {
        this.nFT.yI(true);
        this.nFS.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aT(CloudMusicData.MusicTagList musicTagList) {
                a.this.nFT.yI(false);
                if (!x.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nFT.yH(false);
                    a.this.nFT.b(musicTagList);
                } else {
                    a.this.nFT.yH(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nFT.dTM();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (x.isEmpty(musicTagList.music_list)) {
            this.nFT.yH(true);
        } else {
            this.nFT.yH(false);
            this.nFT.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nFT.dTM();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Us = com.baidu.tieba.video.editvideo.model.a.dUt().Us(musicList.resource);
            if (TextUtils.isEmpty(Us)) {
                this.nFT.LK(i);
                com.baidu.tieba.video.editvideo.model.a.dUt().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0900a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                    public void gy(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nFU.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dTO() {
                                a.this.nFU.bjA();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dUt().dUu();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                    public void Um(String str) {
                        a.this.nFT.LM(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                    public void dTN() {
                        a.this.nFT.LL(i);
                    }
                });
                return;
            }
            this.nFU.a(Us, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dTO() {
                    a.this.nFU.bjA();
                    if (Us.startsWith("/")) {
                        File file = new File(Us);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dUt().dUu();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cIc() {
        this.nFS.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dDw() {
        this.nFS.dTW();
    }
}
