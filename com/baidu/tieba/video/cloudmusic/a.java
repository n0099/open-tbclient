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
    private final CloudMusicListModel htn;
    private final d.b hto;
    private MusicPlayer htp;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.htn = cloudMusicListModel;
        this.hto = bVar;
        bVar.a(this);
        this.htp = MusicPlayer.bFY();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void vU(int i) {
        this.hto.nU(true);
        this.htn.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ak(CloudMusicData.MusicTagList musicTagList) {
                a.this.hto.nU(false);
                if (!v.I(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hto.nT(false);
                    a.this.hto.b(musicTagList);
                } else {
                    a.this.hto.nT(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hto.bFU();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.I(musicTagList.music_list)) {
            this.hto.nT(true);
        } else {
            this.hto.nT(false);
            this.hto.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hto.bFU();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String we = com.baidu.tieba.video.editvideo.model.a.bGH().we(musicList.resource);
            if (TextUtils.isEmpty(we)) {
                this.hto.vR(i);
                com.baidu.tieba.video.editvideo.model.a.bGH().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0311a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void cM(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.htp.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bFW() {
                                a.this.htp.TD();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bGH().bGI();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void vW(String str) {
                        a.this.hto.vT(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void bFV() {
                        a.this.hto.vS(i);
                    }
                });
                return;
            }
            this.htp.a(we, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bFW() {
                    a.this.htp.TD();
                    if (we.startsWith("/")) {
                        File file = new File(we);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bGH().bGI();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aBt() {
        this.htn.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void brs() {
        this.htn.bGe();
    }
}
