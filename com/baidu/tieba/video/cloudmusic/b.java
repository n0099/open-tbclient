package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel iVp;
    private final c.b iVq;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.iVp = cloudMusicModel;
        this.iVq = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void ciY() {
        this.iVq.qy(true);
        this.iVp.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ax(CloudMusicData cloudMusicData) {
                b.this.iVq.qy(false);
                if (cloudMusicData != null) {
                    b.this.iVq.qz(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.iVq.qz(true);
                        return;
                    } else {
                        b.this.iVq.a(cloudMusicData);
                        return;
                    }
                }
                b.this.iVq.qz(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void beW() {
        this.iVp.cancelLoadData();
    }
}
