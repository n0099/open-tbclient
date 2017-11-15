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
    private final CloudMusicListModel gDV;
    private final e.b gDW;
    private MusicPlayer gDX;

    public b(CloudMusicListModel cloudMusicListModel, e.b bVar) {
        this.gDV = cloudMusicListModel;
        this.gDW = bVar;
        bVar.a(this);
        this.gDX = MusicPlayer.byF();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void uO(int i) {
        this.gDW.nd(true);
        this.gDV.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void ab(CloudMusicData.MusicTagList musicTagList) {
                b.this.gDW.nd(false);
                if (!v.v(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    b.this.gDW.nc(false);
                    b.this.gDW.b(musicTagList);
                } else {
                    b.this.gDW.nc(true);
                }
                if (musicTagList.page.has_more == 0) {
                    b.this.gDW.byB();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.v(musicTagList.music_list)) {
            this.gDW.nc(true);
        } else {
            this.gDW.nc(false);
            this.gDW.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.gDW.byB();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String tp = com.baidu.tieba.video.editvideo.model.a.bzc().tp(musicList.resource);
            if (TextUtils.isEmpty(tp)) {
                this.gDW.uL(i);
                com.baidu.tieba.video.editvideo.model.a.bzc().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0134a() { // from class: com.baidu.tieba.video.cloudmusic.b.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void cj(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        b.this.gDX.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void byD() {
                                b.this.gDX.bhy();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.bzc().bzd();
                                    b.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void tl(String str) {
                        b.this.gDW.uN(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void byC() {
                        b.this.gDW.uM(i);
                    }
                });
                return;
            }
            this.gDX.a(tp, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.b.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void byD() {
                    b.this.gDX.bhy();
                    if (tp.startsWith("/")) {
                        File file = new File(tp);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.bzc().bzd();
                        b.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void akY() {
        this.gDV.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.a
    public void biH() {
        this.gDV.byL();
    }
}
