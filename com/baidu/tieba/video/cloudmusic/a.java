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
    private final CloudMusicListModel jwU;
    private final d.b jwV;
    private MusicPlayer jwW;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.jwU = cloudMusicListModel;
        this.jwV = bVar;
        bVar.a(this);
        this.jwW = MusicPlayer.csN();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void AP(int i) {
        this.jwV.rq(true);
        this.jwU.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void au(CloudMusicData.MusicTagList musicTagList) {
                a.this.jwV.rq(false);
                if (!v.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.jwV.rp(false);
                    a.this.jwV.b(musicTagList);
                } else {
                    a.this.jwV.rp(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.jwV.csJ();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.isEmpty(musicTagList.music_list)) {
            this.jwV.rp(true);
        } else {
            this.jwV.rp(false);
            this.jwV.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.jwV.csJ();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String EP = com.baidu.tieba.video.editvideo.model.a.ctv().EP(musicList.resource);
            if (TextUtils.isEmpty(EP)) {
                this.jwV.AM(i);
                com.baidu.tieba.video.editvideo.model.a.ctv().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0523a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                    public void ef(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.jwW.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void csL() {
                                a.this.jwW.aBY();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.ctv().ctw();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                    public void EH(String str) {
                        a.this.jwV.AO(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                    public void csK() {
                        a.this.jwV.AN(i);
                    }
                });
                return;
            }
            this.jwW.a(EP, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void csL() {
                    a.this.jwW.aBY();
                    if (EP.startsWith("/")) {
                        File file = new File(EP);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.ctv().ctw();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bmt() {
        this.jwU.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cep() {
        this.jwU.csT();
    }
}
