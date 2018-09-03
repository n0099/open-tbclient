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
    private final CloudMusicListModel hcv;
    private final d.b hcw;
    private MusicPlayer hcx;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hcv = cloudMusicListModel;
        this.hcw = bVar;
        bVar.a(this);
        this.hcx = MusicPlayer.bAw();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void uE(int i) {
        this.hcw.mS(true);
        this.hcv.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ag(CloudMusicData.MusicTagList musicTagList) {
                a.this.hcw.mS(false);
                if (!w.z(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hcw.mR(false);
                    a.this.hcw.b(musicTagList);
                } else {
                    a.this.hcw.mR(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hcw.bAs();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (w.z(musicTagList.music_list)) {
            this.hcw.mR(true);
        } else {
            this.hcw.mR(false);
            this.hcw.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hcw.bAs();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String uP = com.baidu.tieba.video.editvideo.model.a.bBf().uP(musicList.resource);
            if (TextUtils.isEmpty(uP)) {
                this.hcw.uB(i);
                com.baidu.tieba.video.editvideo.model.a.bBf().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cr(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hcx.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAu() {
                                a.this.hcx.bko();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBf().bBg();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uG(String str) {
                        a.this.hcw.uD(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAt() {
                        a.this.hcw.uC(i);
                    }
                });
                return;
            }
            this.hcx.a(uP, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAu() {
                    a.this.hcx.bko();
                    if (uP.startsWith("/")) {
                        File file = new File(uP);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBf().bBg();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void awr() {
        this.hcv.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bmb() {
        this.hcv.bAC();
    }
}
