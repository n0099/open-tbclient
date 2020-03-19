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
    private final CloudMusicListModel kxo;
    private final d.b kxp;
    private MusicPlayer kxq;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.kxo = cloudMusicListModel;
        this.kxp = bVar;
        bVar.a(this);
        this.kxq = MusicPlayer.cPO();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void DE(int i) {
        this.kxp.tt(true);
        this.kxo.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aC(CloudMusicData.MusicTagList musicTagList) {
                a.this.kxp.tt(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.kxp.ts(false);
                    a.this.kxp.b(musicTagList);
                } else {
                    a.this.kxp.ts(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.kxp.cPK();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.kxp.ts(true);
        } else {
            this.kxp.ts(false);
            this.kxp.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.kxp.cPK();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Kb = com.baidu.tieba.video.editvideo.model.a.cQt().Kb(musicList.resource);
            if (TextUtils.isEmpty(Kb)) {
                this.kxp.DB(i);
                com.baidu.tieba.video.editvideo.model.a.cQt().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0621a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                    public void eH(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.kxq.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void cPM() {
                                a.this.kxq.aWH();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cQt().cQu();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                    public void JU(String str) {
                        a.this.kxp.DD(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                    public void cPL() {
                        a.this.kxp.DC(i);
                    }
                });
                return;
            }
            this.kxq.a(Kb, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void cPM() {
                    a.this.kxq.aWH();
                    if (Kb.startsWith("/")) {
                        File file = new File(Kb);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cQt().cQu();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bGI() {
        this.kxo.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cBj() {
        this.kxo.cPU();
    }
}
