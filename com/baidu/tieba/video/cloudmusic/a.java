package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes17.dex */
public class a implements d.a {
    private final CloudMusicListModel mcC;
    private final d.b mcD;
    private MusicPlayer mcE;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.mcC = cloudMusicListModel;
        this.mcD = bVar;
        bVar.a(this);
        this.mcE = MusicPlayer.dpM();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Gt(int i) {
        this.mcD.vM(true);
        this.mcC.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aJ(CloudMusicData.MusicTagList musicTagList) {
                a.this.mcD.vM(false);
                if (!x.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.mcD.vL(false);
                    a.this.mcD.b(musicTagList);
                } else {
                    a.this.mcD.vL(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.mcD.dpI();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (x.isEmpty(musicTagList.music_list)) {
            this.mcD.vL(true);
        } else {
            this.mcD.vL(false);
            this.mcD.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.mcD.dpI();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String OK = com.baidu.tieba.video.editvideo.model.a.dqp().OK(musicList.resource);
            if (TextUtils.isEmpty(OK)) {
                this.mcD.Gq(i);
                com.baidu.tieba.video.editvideo.model.a.dqp().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0763a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void fG(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.mcE.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dpK() {
                                a.this.mcE.aOt();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dqp().dqq();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void OE(String str) {
                        a.this.mcD.Gs(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void dpJ() {
                        a.this.mcD.Gr(i);
                    }
                });
                return;
            }
            this.mcE.a(OK, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dpK() {
                    a.this.mcE.aOt();
                    if (OK.startsWith("/")) {
                        File file = new File(OK);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dqp().dqq();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ceq() {
        this.mcC.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void daG() {
        this.mcC.dpS();
    }
}
