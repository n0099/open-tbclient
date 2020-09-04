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
    private final CloudMusicListModel muF;
    private final d.b muG;
    private MusicPlayer muH;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.muF = cloudMusicListModel;
        this.muG = bVar;
        bVar.a(this);
        this.muH = MusicPlayer.dBq();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void IP(int i) {
        this.muG.wD(true);
        this.muF.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aL(CloudMusicData.MusicTagList musicTagList) {
                a.this.muG.wD(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.muG.wC(false);
                    a.this.muG.b(musicTagList);
                } else {
                    a.this.muG.wC(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.muG.dBm();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.muG.wC(true);
        } else {
            this.muG.wC(false);
            this.muG.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.muG.dBm();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String RI = com.baidu.tieba.video.editvideo.model.a.dBT().RI(musicList.resource);
            if (TextUtils.isEmpty(RI)) {
                this.muG.IM(i);
                com.baidu.tieba.video.editvideo.model.a.dBT().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0815a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void fY(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.muH.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dBo() {
                                a.this.muH.aWR();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dBT().dBU();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void RC(String str) {
                        a.this.muG.IO(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void dBn() {
                        a.this.muG.IN(i);
                    }
                });
                return;
            }
            this.muH.a(RI, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dBo() {
                    a.this.muH.aWR();
                    if (RI.startsWith("/")) {
                        File file = new File(RI);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dBT().dBU();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void coV() {
        this.muF.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dlN() {
        this.muF.dBw();
    }
}
