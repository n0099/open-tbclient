package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements d.a {
    private final CloudMusicListModel hcu;
    private final d.b hcv;
    private MusicPlayer hcw;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hcu = cloudMusicListModel;
        this.hcv = bVar;
        bVar.a(this);
        this.hcw = MusicPlayer.bAu();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void uE(int i) {
        this.hcv.mS(true);
        this.hcu.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ag(CloudMusicData.MusicTagList musicTagList) {
                a.this.hcv.mS(false);
                if (!w.z(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hcv.mR(false);
                    a.this.hcv.b(musicTagList);
                } else {
                    a.this.hcv.mR(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hcv.bAq();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (w.z(musicTagList.music_list)) {
            this.hcv.mR(true);
        } else {
            this.hcv.mR(false);
            this.hcv.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hcv.bAq();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String uL = com.baidu.tieba.video.editvideo.model.a.bBd().uL(musicList.resource);
            if (TextUtils.isEmpty(uL)) {
                this.hcv.uB(i);
                com.baidu.tieba.video.editvideo.model.a.bBd().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cr(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hcw.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAs() {
                                a.this.hcw.bkr();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBd().bBe();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uC(String str) {
                        a.this.hcv.uD(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAr() {
                        a.this.hcv.uC(i);
                    }
                });
                return;
            }
            this.hcw.a(uL, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAs() {
                    a.this.hcw.bkr();
                    if (uL.startsWith("/")) {
                        File file = new File(uL);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBd().bBe();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aws() {
        this.hcu.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bme() {
        this.hcu.bAA();
    }
}
