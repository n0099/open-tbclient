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
    private final d.b hAA;
    private MusicPlayer hAB;
    private final CloudMusicListModel hAz;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.hAz = cloudMusicListModel;
        this.hAA = bVar;
        bVar.a(this);
        this.hAB = MusicPlayer.bIc();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void wr(int i) {
        this.hAA.nW(true);
        this.hAz.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void al(CloudMusicData.MusicTagList musicTagList) {
                a.this.hAA.nW(false);
                if (!v.I(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.hAA.nV(false);
                    a.this.hAA.b(musicTagList);
                } else {
                    a.this.hAA.nV(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.hAA.bHY();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.I(musicTagList.music_list)) {
            this.hAA.nV(true);
        } else {
            this.hAA.nV(false);
            this.hAA.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.hAA.bHY();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String wH = com.baidu.tieba.video.editvideo.model.a.bIL().wH(musicList.resource);
            if (TextUtils.isEmpty(wH)) {
                this.hAA.wo(i);
                com.baidu.tieba.video.editvideo.model.a.bIL().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void cR(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.hAB.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void bIa() {
                                a.this.hAB.UJ();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bIL().bIM();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void wz(String str) {
                        a.this.hAA.wq(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void bHZ() {
                        a.this.hAA.wp(i);
                    }
                });
                return;
            }
            this.hAB.a(wH, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void bIa() {
                    a.this.hAB.UJ();
                    if (wH.startsWith("/")) {
                        File file = new File(wH);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bIL().bIM();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aDd() {
        this.hAz.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void btk() {
        this.hAz.bIi();
    }
}
