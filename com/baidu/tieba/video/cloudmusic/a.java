package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes22.dex */
public class a implements d.a {
    private final CloudMusicListModel nnH;
    private final d.b nnI;
    private MusicPlayer nnJ;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.nnH = cloudMusicListModel;
        this.nnI = bVar;
        bVar.a(this);
        this.nnJ = MusicPlayer.dOF();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Lh(int i) {
        this.nnI.ya(true);
        this.nnH.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aS(CloudMusicData.MusicTagList musicTagList) {
                a.this.nnI.ya(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.nnI.xZ(false);
                    a.this.nnI.b(musicTagList);
                } else {
                    a.this.nnI.xZ(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.nnI.dOB();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.nnI.xZ(true);
        } else {
            this.nnI.xZ(false);
            this.nnI.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.nnI.dOB();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Tx = com.baidu.tieba.video.editvideo.model.a.dPi().Tx(musicList.resource);
            if (TextUtils.isEmpty(Tx)) {
                this.nnI.Le(i);
                com.baidu.tieba.video.editvideo.model.a.dPi().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0863a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                    public void gw(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.nnJ.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dOD() {
                                a.this.nnJ.bdX();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dPi().dPj();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                    public void Tr(String str) {
                        a.this.nnI.Lg(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                    public void dOC() {
                        a.this.nnI.Lf(i);
                    }
                });
                return;
            }
            this.nnJ.a(Tx, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dOD() {
                    a.this.nnJ.bdX();
                    if (Tx.startsWith("/")) {
                        File file = new File(Tx);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dPi().dPj();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cAQ() {
        this.nnH.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dyo() {
        this.nnH.dOL();
    }
}
