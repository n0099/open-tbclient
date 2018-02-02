package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel hnx;
    private final d.b hny;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.hnx = cloudMusicModel;
        this.hny = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bAk() {
        this.hny.nb(true);
        this.hnx.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void be(CloudMusicData cloudMusicData) {
                c.this.hny.nb(false);
                if (cloudMusicData != null) {
                    c.this.hny.nc(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.hny.nc(true);
                        return;
                    } else {
                        c.this.hny.a(cloudMusicData);
                        return;
                    }
                }
                c.this.hny.nc(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void avS() {
        this.hnx.cancelLoadData();
    }
}
