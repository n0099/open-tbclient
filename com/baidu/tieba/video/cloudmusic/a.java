package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes23.dex */
public class a implements d.a {
    private final CloudMusicListModel nBK;
    private final d.b nBL;
    private MusicPlayer nBM;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nBK = cloudMusicListModel;
        this.nBL = bVar;
        bVar.a(this);
        this.nBM = MusicPlayer.dTX();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void LZ(int i) {
        this.nBL.yF(true);
        this.nBK.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aS(CloudMusicData.MusicTagList musicTagList) {
                a.this.nBL.yF(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nBL.yE(false);
                    a.this.nBL.b(musicTagList);
                } else {
                    a.this.nBL.yE(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nBL.dTT();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nBL.yE(true);
        } else {
            this.nBL.yE(false);
            this.nBL.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nBL.dTT();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String UM = com.baidu.tieba.video.editvideo.model.a.dUA().UM(musicList.resource);
            if (TextUtils.isEmpty(UM)) {
                this.nBL.LW(i);
                com.baidu.tieba.video.editvideo.model.a.dUA().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void gB(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nBM.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dTV() {
                                a.this.nBM.bhc();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dUA().dUB();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void UG(String str) {
                        a.this.nBL.LY(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void dTU() {
                        a.this.nBL.LX(i);
                    }
                });
                return;
            }
            this.nBM.a(UM, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dTV() {
                    a.this.nBM.bhc();
                    if (UM.startsWith("/")) {
                        File file = new File(UM);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dUA().dUB();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cFg() {
        this.nBK.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dDF() {
        this.nBK.dUd();
    }
}
