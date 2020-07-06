package com.baidu.tieba.video.cloudmusic;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
/* loaded from: classes10.dex */
public class a implements d.a {
    private final CloudMusicListModel lVk;
    private final d.b lVl;
    private MusicPlayer lVm;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.lVk = cloudMusicListModel;
        this.lVl = bVar;
        bVar.a(this);
        this.lVm = MusicPlayer.dmA();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void FX(int i) {
        this.lVl.vi(true);
        this.lVk.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aJ(CloudMusicData.MusicTagList musicTagList) {
                a.this.lVl.vi(false);
                if (!w.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.lVl.vh(false);
                    a.this.lVl.b(musicTagList);
                } else {
                    a.this.lVl.vh(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.lVl.dmw();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (w.isEmpty(musicTagList.music_list)) {
            this.lVl.vh(true);
        } else {
            this.lVl.vh(false);
            this.lVl.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.lVl.dmw();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Oc = com.baidu.tieba.video.editvideo.model.a.dne().Oc(musicList.resource);
            if (TextUtils.isEmpty(Oc)) {
                this.lVl.FU(i);
                com.baidu.tieba.video.editvideo.model.a.dne().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0753a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                    public void fE(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.lVm.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dmy() {
                                a.this.lVm.aKF();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dne().dnf();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                    public void NW(String str) {
                        a.this.lVl.FW(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                    public void dmx() {
                        a.this.lVl.FV(i);
                    }
                });
                return;
            }
            this.lVm.a(Oc, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dmy() {
                    a.this.lVm.aKF();
                    if (Oc.startsWith("/")) {
                        File file = new File(Oc);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dne().dnf();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void caS() {
        this.lVk.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void cXz() {
        this.lVk.dmG();
    }
}
