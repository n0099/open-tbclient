package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements d.a {
    private final CloudMusicListModel gKx;
    private final d.b gKy;
    private MusicPlayer gKz;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.gKx = cloudMusicListModel;
        this.gKy = bVar;
        bVar.a(this);
        this.gKz = MusicPlayer.bwe();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ul(int i) {
        this.gKy.mR(true);
        this.gKx.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ab(CloudMusicData.MusicTagList musicTagList) {
                a.this.gKy.mR(false);
                if (!v.w(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.gKy.mQ(false);
                    a.this.gKy.b(musicTagList);
                } else {
                    a.this.gKy.mQ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.gKy.bwa();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.w(musicTagList.music_list)) {
            this.gKy.mQ(true);
        } else {
            this.gKy.mQ(false);
            this.gKy.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gKy.bwa();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(musicList.resource);
            if (TextUtils.isEmpty(tU)) {
                this.gKy.ui(i);
                com.baidu.tieba.video.editvideo.model.a.bwN().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.gKz.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bwc() {
                                a.this.gKz.bgx();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bwN().bwO();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tL(String str) {
                        a.this.gKy.uk(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bwb() {
                        a.this.gKy.uj(i);
                    }
                });
                return;
            }
            this.gKz.a(tU, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bwc() {
                    a.this.gKz.bgx();
                    if (tU.startsWith("/")) {
                        File file = new File(tU);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bwN().bwO();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void arg() {
        this.gKx.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bij() {
        this.gKx.bwk();
    }
}
