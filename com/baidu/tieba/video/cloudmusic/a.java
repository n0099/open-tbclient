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
    private final CloudMusicListModel iVs;
    private final d.b iVt;
    private MusicPlayer iVu;

    public a(CloudMusicListModel cloudMusicListModel, d.b bVar) {
        this.iVs = cloudMusicListModel;
        this.iVt = bVar;
        bVar.a(this);
        this.iVu = MusicPlayer.cjb();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void At(int i) {
        this.iVt.qA(true);
        this.iVs.a(i, new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData.MusicTagList>() { // from class: com.baidu.tieba.video.cloudmusic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: d */
            public void aB(CloudMusicData.MusicTagList musicTagList) {
                a.this.iVt.qA(false);
                if (!v.T(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    a.this.iVt.qz(false);
                    a.this.iVt.b(musicTagList);
                } else {
                    a.this.iVt.qz(true);
                }
                if (musicTagList.page.has_more == 0) {
                    a.this.iVt.ciX();
                }
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (v.T(musicTagList.music_list)) {
            this.iVt.qz(true);
        } else {
            this.iVt.qz(false);
            this.iVt.b(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.iVt.ciX();
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void a(final CloudMusicData.MusicTagList.MusicList musicList, final int i) {
        if (musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            final String DB = com.baidu.tieba.video.editvideo.model.a.cjK().DB(musicList.resource);
            if (TextUtils.isEmpty(DB)) {
                this.iVt.Aq(i);
                com.baidu.tieba.video.editvideo.model.a.cjK().a(String.valueOf(musicList.music_id), musicList.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.cloudmusic.a.2
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ec(final String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        a.this.iVu.a(str, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.2.1
                            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                            public void ciZ() {
                                a.this.iVu.avg();
                                if (str.startsWith("/")) {
                                    File file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    com.baidu.tieba.video.editvideo.model.a.cjK().cjL();
                                    a.this.a(musicList, i);
                                }
                            }
                        });
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void Dt(String str) {
                        a.this.iVt.As(i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciY() {
                        a.this.iVt.Ar(i);
                    }
                });
                return;
            }
            this.iVu.a(DB, musicList, new MusicPlayer.a() { // from class: com.baidu.tieba.video.cloudmusic.a.3
                @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.a
                public void ciZ() {
                    a.this.iVu.avg();
                    if (DB.startsWith("/")) {
                        File file = new File(DB);
                        if (file.exists()) {
                            file.delete();
                        }
                        com.baidu.tieba.video.editvideo.model.a.cjK().cjL();
                        a.this.a(musicList, i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void beY() {
        this.iVs.cancelLoadData();
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bVu() {
        this.iVs.cjh();
    }
}
