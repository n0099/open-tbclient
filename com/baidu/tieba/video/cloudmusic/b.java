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
    private final CloudMusicListModel hmV;
    private final e.b hmW;
    private MusicPlayer hmX;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.hmV = cloudMusicListModel;
        this.hmW = bVar;
        bVar.a(this);
        this.hmX = MusicPlayer.bAj();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void wJ(int i) {
        this.hmW.na(true);
        this.hmV.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void be(CloudMusicData.MusicTagList musicTagList) {
                b.this.hmW.na(false);
                if (!v.E(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.hmW.mZ(false);
                    b.this.hmW.b(musicTagList);
                } else {
                    b.this.hmW.mZ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.hmW.bAf();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.E(musicTagList.music_list)) {
            this.hmW.mZ(true);
        } else {
            this.hmW.mZ(false);
            this.hmW.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hmW.bAf();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tB = com.baidu.tieba.video.editvideo.model.a.bAT().tB(musicList.resource);
            if (TextUtils.isEmpty(tB)) {
                this.hmW.wG(i);
                com.baidu.tieba.video.editvideo.model.a.bAT().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0159a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void ci(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.hmX.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAh() {
                                b.this.hmX.bkd();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bAT().bAU();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void ts(String str) {
                        b.this.hmW.wI(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void bAg() {
                        b.this.hmW.wH(i);
                    }
                });
                return;
            }
            this.hmX.a(tB, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAh() {
                    b.this.hmX.bkd();
                    if (tB.startsWith("/")) {
                        File file = new File(tB);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bAT().bAU();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void avN() {
        this.hmV.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void blP() {
        this.hmV.bAp();
    }
}
