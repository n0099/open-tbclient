package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements d.a {
    private final CloudMusicListModel gXc;
    private final d.b gXd;
    private MusicPlayer gXe;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.gXc = cloudMusicListModel;
        this.gXd = bVar;
        bVar.a(this);
        this.gXe = MusicPlayer.bBj();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void ux(int i) {
        this.gXd.mY(true);
        this.gXc.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ae(CloudMusicData.MusicTagList musicTagList) {
                a.this.gXd.mY(false);
                if (!w.z(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.gXd.mX(false);
                    a.this.gXd.b(musicTagList);
                } else {
                    a.this.gXd.mX(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.gXd.bBf();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (w.z(musicTagList.music_list)) {
            this.gXd.mX(true);
        } else {
            this.gXd.mX(false);
            this.gXd.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gXd.bBf();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String uR = com.baidu.tieba.video.editvideo.model.a.bBS().uR(musicList.resource);
            if (TextUtils.isEmpty(uR)) {
                this.gXd.uu(i);
                com.baidu.tieba.video.editvideo.model.a.bBS().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0240a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void cq(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.gXe.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bBh() {
                                a.this.gXe.blv();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bBS().bBT();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void uI(String str) {
                        a.this.gXd.uw(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void bBg() {
                        a.this.gXd.uv(i);
                    }
                });
                return;
            }
            this.gXe.a(uR, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bBh() {
                    a.this.gXe.blv();
                    if (uR.startsWith("/")) {
                        File file = new File(uR);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bBS().bBT();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void avk() {
        this.gXc.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bnh() {
        this.gXc.bBp();
    }
}
