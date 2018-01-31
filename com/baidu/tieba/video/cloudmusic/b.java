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
    private final CloudMusicListModel hnp;
    private final e.b hnq;
    private MusicPlayer hnr;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.hnp = cloudMusicListModel;
        this.hnq = bVar;
        bVar.a(this);
        this.hnr = MusicPlayer.bAl();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void wJ(int i) {
        this.hnq.nc(true);
        this.hnp.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void be(CloudMusicData.MusicTagList musicTagList) {
                b.this.hnq.nc(false);
                if (!v.E(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.hnq.nb(false);
                    b.this.hnq.b(musicTagList);
                } else {
                    b.this.hnq.nb(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.hnq.bAh();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.E(musicTagList.music_list)) {
            this.hnq.nb(true);
        } else {
            this.hnq.nb(false);
            this.hnq.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hnq.bAh();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tI = com.baidu.tieba.video.editvideo.model.a.bAV().tI(musicList.resource);
            if (TextUtils.isEmpty(tI)) {
                this.hnq.wG(i);
                com.baidu.tieba.video.editvideo.model.a.bAV().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void ch(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.hnr.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bAj() {
                                b.this.hnr.bke();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bAV().bAW();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void tz(String str) {
                        b.this.hnq.wI(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void bAi() {
                        b.this.hnq.wH(i);
                    }
                });
                return;
            }
            this.hnr.a(tI, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bAj() {
                    b.this.hnr.bke();
                    if (tI.startsWith("/")) {
                        File file = new File(tI);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bAV().bAW();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void avS() {
        this.hnp.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void blQ() {
        this.hnp.bAr();
    }
}
