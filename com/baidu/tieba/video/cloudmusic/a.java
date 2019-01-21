package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements d.a {
    private final CloudMusicListModel hES;
    private final d.b hET;
    private MusicPlayer hEU;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hES = cloudMusicListModel;
        this.hET = bVar;
        bVar.a(this);
        this.hEU = MusicPlayer.bJB();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void wH(int i) {
        this.hET.oa(true);
        this.hES.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void al(CloudMusicData.MusicTagList musicTagList) {
                a.this.hET.oa(false);
                if (!v.I(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hET.nZ(false);
                    a.this.hET.b(musicTagList);
                } else {
                    a.this.hET.nZ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hET.bJx();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.I(musicTagList.music_list)) {
            this.hET.nZ(true);
        } else {
            this.hET.nZ(false);
            this.hET.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hET.bJx();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(musicList.resource);
            if (TextUtils.isEmpty(xa)) {
                this.hET.wE(i);
                com.baidu.tieba.video.editvideo.model.a.bKk().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void cT(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hEU.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bJz() {
                                a.this.hEU.Vh();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bKk().bKl();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void wS(String str) {
                        a.this.hET.wG(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void bJy() {
                        a.this.hET.wF(i);
                    }
                });
                return;
            }
            this.hEU.a(xa, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bJz() {
                    a.this.hEU.Vh();
                    if (xa.startsWith("/")) {
                        File file = new File(xa);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bKk().bKl();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aEp() {
        this.hES.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void buF() {
        this.hES.bJH();
    }
}
