package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes17.dex */
public class a implements d.a {
    private final CloudMusicListModel mun;
    private final d.b muo;
    private MusicPlayer mup;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.mun = cloudMusicListModel;
        this.muo = bVar;
        bVar.a(this);
        this.mup = MusicPlayer.dBh();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void IP(int i) {
        this.muo.wB(true);
        this.mun.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aL(CloudMusicData.MusicTagList musicTagList) {
                a.this.muo.wB(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.muo.wA(false);
                    a.this.muo.b(musicTagList);
                } else {
                    a.this.muo.wA(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.muo.dBd();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.muo.wA(true);
        } else {
            this.muo.wA(false);
            this.muo.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.muo.dBd();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String RI = com.baidu.tieba.video.editvideo.model.a.dBK().RI(musicList.resource);
            if (TextUtils.isEmpty(RI)) {
                this.muo.IM(i);
                com.baidu.tieba.video.editvideo.model.a.dBK().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0815a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void fX(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.mup.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dBf() {
                                a.this.mup.aWR();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dBK().dBL();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void RC(String str) {
                        a.this.muo.IO(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void dBe() {
                        a.this.muo.IN(i);
                    }
                });
                return;
            }
            this.mup.a(RI, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dBf() {
                    a.this.mup.aWR();
                    if (RI.startsWith("/")) {
                        File file = new File(RI);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dBK().dBL();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void coU() {
        this.mun.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dlK() {
        this.mun.dBn();
    }
}
