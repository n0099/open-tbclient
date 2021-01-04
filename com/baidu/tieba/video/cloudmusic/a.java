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
    private final CloudMusicListModel nFT;
    private final d.b nFU;
    private MusicPlayer nFV;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nFT = cloudMusicListModel;
        this.nFU = bVar;
        bVar.a(this);
        this.nFV = MusicPlayer.dTP();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void LN(int i) {
        this.nFU.yI(true);
        this.nFT.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aT(CloudMusicData.MusicTagList musicTagList) {
                a.this.nFU.yI(false);
                if (!x.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nFU.yH(false);
                    a.this.nFU.b(musicTagList);
                } else {
                    a.this.nFU.yH(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nFU.dTL();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (x.isEmpty(musicTagList.music_list)) {
            this.nFU.yH(true);
        } else {
            this.nFU.yH(false);
            this.nFU.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nFU.dTL();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Ut = com.baidu.tieba.video.editvideo.model.a.dUs().Ut(musicList.resource);
            if (TextUtils.isEmpty(Ut)) {
                this.nFU.LK(i);
                com.baidu.tieba.video.editvideo.model.a.dUs().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0862a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                    public void gy(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nFV.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dTN() {
                                a.this.nFV.bjz();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dUs().dUt();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                    public void Un(String str) {
                        a.this.nFU.LM(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                    public void dTM() {
                        a.this.nFU.LL(i);
                    }
                });
                return;
            }
            this.nFV.a(Ut, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dTN() {
                    a.this.nFV.bjz();
                    if (Ut.startsWith("/")) {
                        File file = new File(Ut);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dUs().dUt();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cIb() {
        this.nFT.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dDv() {
        this.nFT.dTV();
    }
}
