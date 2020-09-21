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
    private final CloudMusicListModel mEq;
    private final d.b mEr;
    private MusicPlayer mEs;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.mEq = cloudMusicListModel;
        this.mEr = bVar;
        bVar.a(this);
        this.mEs = MusicPlayer.dFk();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void Jt(int i) {
        this.mEr.wM(true);
        this.mEq.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aN(CloudMusicData.MusicTagList musicTagList) {
                a.this.mEr.wM(false);
                if (!y.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.mEr.wL(false);
                    a.this.mEr.b(musicTagList);
                } else {
                    a.this.mEr.wL(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.mEr.dFg();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (y.isEmpty(musicTagList.music_list)) {
            this.mEr.wL(true);
        } else {
            this.mEr.wL(false);
            this.mEr.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.mEr.dFg();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String Si = com.baidu.tieba.video.editvideo.model.a.dFN().Si(musicList.resource);
            if (TextUtils.isEmpty(Si)) {
                this.mEr.Jq(i);
                com.baidu.tieba.video.editvideo.model.a.dFN().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0812a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                    public void gk(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.mEs.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void dFi() {
                                a.this.mEs.aXD();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.dFN().dFO();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                    public void Sc(String str) {
                        a.this.mEr.Js(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                    public void dFh() {
                        a.this.mEr.Jr(i);
                    }
                });
                return;
            }
            this.mEs.a(Si, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void dFi() {
                    a.this.mEs.aXD();
                    if (Si.startsWith("/")) {
                        File file = new File(Si);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.dFN().dFO();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void csi() {
        this.mEq.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void dpu() {
        this.mEq.dFq();
    }
}
