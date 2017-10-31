package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class b implements e.a {
    private final CloudMusicListModel gCN;
    private final e.b gCO;
    private MusicPlayer gCP;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.gCN = cloudMusicListModel;
        this.gCO = bVar;
        bVar.a(this);
        this.gCP = MusicPlayer.byt();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void uK(int i) {
        this.gCO.mV(true);
        this.gCN.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ab(CloudMusicData.MusicTagList musicTagList) {
                b.this.gCO.mV(false);
                if (!v.v(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gCO.mU(false);
                    b.this.gCO.b(musicTagList);
                } else {
                    b.this.gCO.mU(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gCO.byp();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.v(musicTagList.music_list)) {
            this.gCO.mU(true);
        } else {
            this.gCO.mU(false);
            this.gCO.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gCO.byp();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tj = com.baidu.tieba.video.editvideo.model.a.byQ().tj(musicList.resource);
            if (TextUtils.isEmpty(tj)) {
                this.gCO.uH(i);
                com.baidu.tieba.video.editvideo.model.a.byQ().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void cf(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gCP.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void byr() {
                                b.this.gCP.bhq();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.byQ().byR();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void tf(String str) {
                        b.this.gCO.uJ(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void byq() {
                        b.this.gCO.uI(i);
                    }
                });
                return;
            }
            this.gCP.a(tj, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void byr() {
                    b.this.gCP.bhq();
                    if (tj.startsWith("/")) {
                        File file = new File(tj);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.byQ().byR();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void akK() {
        this.gCN.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void biw() {
        this.gCN.byz();
    }
}
