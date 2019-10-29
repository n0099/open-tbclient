package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jxT;
    private final c.b jxU;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jxT = cloudMusicModel;
        this.jxU = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void csO() {
        this.jxU.ro(true);
        this.jxT.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void au(CloudMusicData cloudMusicData) {
                b.this.jxU.ro(false);
                if (cloudMusicData != null) {
                    b.this.jxU.rp(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.jxU.rp(true);
                        return;
                    } else {
                        b.this.jxU.a(cloudMusicData);
                        return;
                    }
                }
                b.this.jxU.rp(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bmv() {
        this.jxT.cancelLoadData();
    }
}
