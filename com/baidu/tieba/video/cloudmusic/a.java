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
    private final CloudMusicListModel nBM;
    private final d.b nBN;
    private MusicPlayer nBO;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nBM = cloudMusicListModel;
        this.nBN = bVar;
        bVar.a(this);
        this.nBO = MusicPlayer.dTY();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void LZ(int i) {
        this.nBN.yF(true);
        this.nBM.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aS(CloudMusicData.MusicTagList musicTagList) {
                a.this.nBN.yF(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nBN.yE(false);
                    a.this.nBN.b(musicTagList);
                } else {
                    a.this.nBN.yE(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nBN.dTU();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nBN.yE(true);
        } else {
            this.nBN.yE(false);
            this.nBN.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nBN.dTU();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String UM = com.baidu.tieba.video.editvideo.model.a.dUB().UM(musicList.resource);
            if (TextUtils.isEmpty(UM)) {
                this.nBN.LW(i);
                com.baidu.tieba.video.editvideo.model.a.dUB().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void gB(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nBO.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dTW() {
                                a.this.nBO.bhc();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dUB().dUC();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void UG(String str) {
                        a.this.nBN.LY(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void dTV() {
                        a.this.nBN.LX(i);
                    }
                });
                return;
            }
            this.nBO.a(UM, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dTW() {
                    a.this.nBO.bhc();
                    if (UM.startsWith("/")) {
                        File file = new File(UM);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dUB().dUC();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cFh() {
        this.nBM.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dDG() {
        this.nBM.dUe();
    }
}
