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
    private final CloudMusicListModel mUd;
    private final d.b mUe;
    private MusicPlayer mUf;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.mUd = cloudMusicListModel;
        this.mUe = bVar;
        bVar.a(this);
        this.mUf = MusicPlayer.dIW();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void JZ(int i) {
        this.mUe.xt(true);
        this.mUd.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aQ(CloudMusicData.MusicTagList musicTagList) {
                a.this.mUe.xt(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.mUe.xs(false);
                    a.this.mUe.b(musicTagList);
                } else {
                    a.this.mUe.xs(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.mUe.dIS();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.mUe.xs(true);
        } else {
            this.mUe.xs(false);
            this.mUe.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.mUe.dIS();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String SW = com.baidu.tieba.video.editvideo.model.a.dJz().SW(musicList.resource);
            if (TextUtils.isEmpty(SW)) {
                this.mUe.JW(i);
                com.baidu.tieba.video.editvideo.model.a.dJz().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0830a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                    public void gr(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.mUf.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dIU() {
                                a.this.mUf.bal();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dJz().dJA();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                    public void SQ(String str) {
                        a.this.mUe.JY(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                    public void dIT() {
                        a.this.mUe.JX(i);
                    }
                });
                return;
            }
            this.mUf.a(SW, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dIU() {
                    a.this.mUf.bal();
                    if (SW.startsWith("/")) {
                        File file = new File(SW);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dJz().dJA();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cvF() {
        this.mUd.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dtf() {
        this.mUd.dJc();
    }
}
