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
    private final CloudMusicListModel mcA;
    private final d.b mcB;
    private MusicPlayer mcC;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.mcA = cloudMusicListModel;
        this.mcB = bVar;
        bVar.a(this);
        this.mcC = MusicPlayer.dpL();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Gt(int i) {
        this.mcB.vM(true);
        this.mcA.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aJ(CloudMusicData.MusicTagList musicTagList) {
                a.this.mcB.vM(false);
                if (!x.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.mcB.vL(false);
                    a.this.mcB.b(musicTagList);
                } else {
                    a.this.mcB.vL(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.mcB.dpH();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (x.isEmpty(musicTagList.music_list)) {
            this.mcB.vL(true);
        } else {
            this.mcB.vL(false);
            this.mcB.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.mcB.dpH();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String OK = com.baidu.tieba.video.editvideo.model.a.dqo().OK(musicList.resource);
            if (TextUtils.isEmpty(OK)) {
                this.mcB.Gq(i);
                com.baidu.tieba.video.editvideo.model.a.dqo().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0763a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void fG(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.mcC.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dpJ() {
                                a.this.mcC.aOt();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dqo().dqp();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void OE(String str) {
                        a.this.mcB.Gs(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void dpI() {
                        a.this.mcB.Gr(i);
                    }
                });
                return;
            }
            this.mcC.a(OK, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dpJ() {
                    a.this.mcC.aOt();
                    if (OK.startsWith("/")) {
                        File file = new File(OK);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dqo().dqp();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ceq() {
        this.mcA.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void daG() {
        this.mcA.dpR();
    }
}
