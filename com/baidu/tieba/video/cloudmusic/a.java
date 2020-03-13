package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes10.dex */
public class a implements d.a {
    private final CloudMusicListModel kvK;
    private final d.b kvL;
    private MusicPlayer kvM;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kvK = cloudMusicListModel;
        this.kvL = bVar;
        bVar.a(this);
        this.kvM = MusicPlayer.cPu();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Dw(int i) {
        this.kvL.tn(true);
        this.kvK.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aC(CloudMusicData.MusicTagList musicTagList) {
                a.this.kvL.tn(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kvL.tm(false);
                    a.this.kvL.b(musicTagList);
                } else {
                    a.this.kvL.tm(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kvL.cPq();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kvL.tm(true);
        } else {
            this.kvL.tm(false);
            this.kvL.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kvL.cPq();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Kb = com.baidu.tieba.video.editvideo.model.a.cPZ().Kb(musicList.resource);
            if (TextUtils.isEmpty(Kb)) {
                this.kvL.Dt(i);
                com.baidu.tieba.video.editvideo.model.a.cPZ().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void eJ(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kvM.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cPs() {
                                a.this.kvM.aWD();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cPZ().cQa();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void JU(String str) {
                        a.this.kvL.Dv(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void cPr() {
                        a.this.kvL.Du(i);
                    }
                });
                return;
            }
            this.kvM.a(Kb, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cPs() {
                    a.this.kvM.aWD();
                    if (Kb.startsWith("/")) {
                        File file = new File(Kb);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cPZ().cQa();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bGw() {
        this.kvK.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cAP() {
        this.kvK.cPA();
    }
}
