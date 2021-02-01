package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes8.dex */
public class b implements c.a {
    private final CloudMusicModel nLg;
    private final c.b nLh;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nLg = cloudMusicModel;
        this.nLh = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dSi() {
        this.nLh.yV(true);
        this.nLg.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aT(CloudMusicData cloudMusicData) {
                b.this.nLh.yV(false);
                if (cloudMusicData != null) {
                    b.this.nLh.yW(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nLh.yW(true);
                        return;
                    } else {
                        b.this.nLh.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nLh.yW(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cFx() {
        this.nLg.cancelLoadData();
    }
}
