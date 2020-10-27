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
    private final CloudMusicListModel ngE;
    private final d.b ngF;
    private MusicPlayer ngG;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.ngE = cloudMusicListModel;
        this.ngF = bVar;
        bVar.a(this);
        this.ngG = MusicPlayer.dMe();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Kr(int i) {
        this.ngF.xK(true);
        this.ngE.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aR(CloudMusicData.MusicTagList musicTagList) {
                a.this.ngF.xK(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.ngF.xJ(false);
                    a.this.ngF.b(musicTagList);
                } else {
                    a.this.ngF.xJ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.ngF.dMa();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.ngF.xJ(true);
        } else {
            this.ngF.xJ(false);
            this.ngF.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.ngF.dMa();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Tv = com.baidu.tieba.video.editvideo.model.a.dMH().Tv(musicList.resource);
            if (TextUtils.isEmpty(Tv)) {
                this.ngF.Ko(i);
                com.baidu.tieba.video.editvideo.model.a.dMH().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0845a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                    public void gw(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.ngG.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dMc() {
                                a.this.ngG.bce();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dMH().dMI();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                    public void Tp(String str) {
                        a.this.ngF.Kq(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                    public void dMb() {
                        a.this.ngF.Kp(i);
                    }
                });
                return;
            }
            this.ngG.a(Tv, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dMc() {
                    a.this.ngG.bce();
                    if (Tv.startsWith("/")) {
                        File file = new File(Tv);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dMH().dMI();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cyM() {
        this.ngE.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dwm() {
        this.ngE.dMk();
    }
}
