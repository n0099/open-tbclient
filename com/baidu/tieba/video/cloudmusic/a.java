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
    private final CloudMusicListModel nmA;
    private final d.b nmB;
    private MusicPlayer nmC;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nmA = cloudMusicListModel;
        this.nmB = bVar;
        bVar.a(this);
        this.nmC = MusicPlayer.dOG();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void KE(int i) {
        this.nmB.xT(true);
        this.nmA.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aR(CloudMusicData.MusicTagList musicTagList) {
                a.this.nmB.xT(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nmB.xS(false);
                    a.this.nmB.b(musicTagList);
                } else {
                    a.this.nmB.xS(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nmB.dOC();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nmB.xS(true);
        } else {
            this.nmB.xS(false);
            this.nmB.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nmB.dOC();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String TM = com.baidu.tieba.video.editvideo.model.a.dPj().TM(musicList.resource);
            if (TextUtils.isEmpty(TM)) {
                this.nmB.KB(i);
                com.baidu.tieba.video.editvideo.model.a.dPj().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0860a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                    public void gw(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nmC.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dOE() {
                                a.this.nmC.beE();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dPj().dPk();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                    public void TG(String str) {
                        a.this.nmB.KD(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                    public void dOD() {
                        a.this.nmB.KC(i);
                    }
                });
                return;
            }
            this.nmC.a(TM, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dOE() {
                    a.this.nmC.beE();
                    if (TM.startsWith("/")) {
                        File file = new File(TM);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dPj().dPk();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cBn() {
        this.nmA.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dyO() {
        this.nmA.dOM();
    }
}
