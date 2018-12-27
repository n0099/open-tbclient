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
    private final CloudMusicListModel hDK;
    private final d.b hDL;
    private MusicPlayer hDM;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hDK = cloudMusicListModel;
        this.hDL = bVar;
        bVar.a(this);
        this.hDM = MusicPlayer.bIS();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void wE(int i) {
        this.hDL.nZ(true);
        this.hDK.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void al(CloudMusicData.MusicTagList musicTagList) {
                a.this.hDL.nZ(false);
                if (!v.I(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hDL.nY(false);
                    a.this.hDL.b(musicTagList);
                } else {
                    a.this.hDL.nY(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hDL.bIO();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.I(musicTagList.music_list)) {
            this.hDL.nY(true);
        } else {
            this.hDL.nY(false);
            this.hDL.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hDL.bIO();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String wK = com.baidu.tieba.video.editvideo.model.a.bJB().wK(musicList.resource);
            if (TextUtils.isEmpty(wK)) {
                this.hDL.wB(i);
                com.baidu.tieba.video.editvideo.model.a.bJB().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void cR(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hDM.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bIQ() {
                                a.this.hDM.UL();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bJB().bJC();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void wC(String str) {
                        a.this.hDL.wD(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void bIP() {
                        a.this.hDL.wC(i);
                    }
                });
                return;
            }
            this.hDM.a(wK, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bIQ() {
                    a.this.hDM.UL();
                    if (wK.startsWith("/")) {
                        File file = new File(wK);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bJB().bJC();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aDS() {
        this.hDK.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void btW() {
        this.hDK.bIY();
    }
}
