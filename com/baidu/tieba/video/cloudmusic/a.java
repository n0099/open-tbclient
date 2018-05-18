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
    private final CloudMusicListModel gLA;
    private final d.b gLB;
    private MusicPlayer gLC;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.gLA = cloudMusicListModel;
        this.gLB = bVar;
        bVar.a(this);
        this.gLC = MusicPlayer.bwc();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void uk(int i) {
        this.gLB.mS(true);
        this.gLA.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ab(CloudMusicData.MusicTagList musicTagList) {
                a.this.gLB.mS(false);
                if (!v.w(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.gLB.mR(false);
                    a.this.gLB.b(musicTagList);
                } else {
                    a.this.gLB.mR(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.gLB.bvY();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.w(musicTagList.music_list)) {
            this.gLB.mR(true);
        } else {
            this.gLB.mR(false);
            this.gLB.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gLB.bvY();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tX = com.baidu.tieba.video.editvideo.model.a.bwL().tX(musicList.resource);
            if (TextUtils.isEmpty(tX)) {
                this.gLB.uh(i);
                com.baidu.tieba.video.editvideo.model.a.bwL().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.gLC.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bwa() {
                                a.this.gLC.bgx();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bwL().bwM();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tO(String str) {
                        a.this.gLB.uj(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bvZ() {
                        a.this.gLB.ui(i);
                    }
                });
                return;
            }
            this.gLC.a(tX, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bwa() {
                    a.this.gLC.bgx();
                    if (tX.startsWith("/")) {
                        File file = new File(tX);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bwL().bwM();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void arf() {
        this.gLA.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bij() {
        this.gLA.bwi();
    }
}
