package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes10.dex */
public class a implements d.a {
    private final CloudMusicListModel lVh;
    private final d.b lVi;
    private MusicPlayer lVj;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.lVh = cloudMusicListModel;
        this.lVi = bVar;
        bVar.a(this);
        this.lVj = MusicPlayer.dmw();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void FX(int i) {
        this.lVi.vi(true);
        this.lVh.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aJ(CloudMusicData.MusicTagList musicTagList) {
                a.this.lVi.vi(false);
                if (!w.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.lVi.vh(false);
                    a.this.lVi.b(musicTagList);
                } else {
                    a.this.lVi.vh(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.lVi.dms();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (w.isEmpty(musicTagList.music_list)) {
            this.lVi.vh(true);
        } else {
            this.lVi.vh(false);
            this.lVi.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.lVi.dms();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Ob = com.baidu.tieba.video.editvideo.model.a.dna().Ob(musicList.resource);
            if (TextUtils.isEmpty(Ob)) {
                this.lVi.FU(i);
                com.baidu.tieba.video.editvideo.model.a.dna().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0752a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                    public void fE(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.lVj.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dmu() {
                                a.this.lVj.aKF();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dna().dnb();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                    public void NV(String str) {
                        a.this.lVi.FW(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                    public void dmt() {
                        a.this.lVi.FV(i);
                    }
                });
                return;
            }
            this.lVj.a(Ob, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dmu() {
                    a.this.lVj.aKF();
                    if (Ob.startsWith("/")) {
                        File file = new File(Ob);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dna().dnb();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void caR() {
        this.lVh.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cXy() {
        this.lVh.dmC();
    }
}
