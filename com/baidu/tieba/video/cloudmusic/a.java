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
    private final CloudMusicListModel jxT;
    private final d.b jxU;
    private MusicPlayer jxV;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.jxT = cloudMusicListModel;
        this.jxU = bVar;
        bVar.a(this);
        this.jxV = MusicPlayer.cva();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Ck(int i) {
        this.jxU.rH(true);
        this.jxT.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void az(CloudMusicData.MusicTagList musicTagList) {
                a.this.jxU.rH(false);
                if (!v.aa(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jxU.rG(false);
                    a.this.jxU.b(musicTagList);
                } else {
                    a.this.jxU.rG(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jxU.cuW();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.aa(musicTagList.music_list)) {
            this.jxU.rG(true);
        } else {
            this.jxU.rG(false);
            this.jxU.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jxU.cuW();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Gn = com.baidu.tieba.video.editvideo.model.a.cvJ().Gn(musicList.resource);
            if (TextUtils.isEmpty(Gn)) {
                this.jxU.Ch(i);
                com.baidu.tieba.video.editvideo.model.a.cvJ().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0433a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void et(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jxV.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cuY() {
                                a.this.jxV.aBQ();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cvJ().cvK();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void Gf(String str) {
                        a.this.jxU.Cj(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void cuX() {
                        a.this.jxU.Ci(i);
                    }
                });
                return;
            }
            this.jxV.a(Gn, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cuY() {
                    a.this.jxV.aBQ();
                    if (Gn.startsWith("/")) {
                        File file = new File(Gn);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cvJ().cvK();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bpq() {
        this.jxT.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void chs() {
        this.jxT.cvg();
    }
}
