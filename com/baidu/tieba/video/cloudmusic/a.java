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
    private final CloudMusicListModel jxL;
    private final d.b jxM;
    private MusicPlayer jxN;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.jxL = cloudMusicListModel;
        this.jxM = bVar;
        bVar.a(this);
        this.jxN = MusicPlayer.csP();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void AQ(int i) {
        this.jxM.rq(true);
        this.jxL.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void au(CloudMusicData.MusicTagList musicTagList) {
                a.this.jxM.rq(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jxM.rp(false);
                    a.this.jxM.b(musicTagList);
                } else {
                    a.this.jxM.rp(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jxM.csL();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.jxM.rp(true);
        } else {
            this.jxM.rp(false);
            this.jxM.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jxM.csL();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String EP = com.baidu.tieba.video.editvideo.model.a.ctx().EP(musicList.resource);
            if (TextUtils.isEmpty(EP)) {
                this.jxM.AN(i);
                com.baidu.tieba.video.editvideo.model.a.ctx().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void ef(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jxN.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void csN() {
                                a.this.jxN.aCa();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.ctx().cty();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void EH(String str) {
                        a.this.jxM.AP(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void csM() {
                        a.this.jxM.AO(i);
                    }
                });
                return;
            }
            this.jxN.a(EP, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void csN() {
                    a.this.jxN.aCa();
                    if (EP.startsWith("/")) {
                        File file = new File(EP);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.ctx().cty();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bmv() {
        this.jxL.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cer() {
        this.jxL.csV();
    }
}
