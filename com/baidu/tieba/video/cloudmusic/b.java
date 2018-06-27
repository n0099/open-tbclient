package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel hbp;
    private final c.b hbq;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hbp = cloudMusicModel;
        this.hbq = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bBI() {
        this.hbq.ne(true);
        this.hbp.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ag(CloudMusicData cloudMusicData) {
                b.this.hbq.ne(false);
                if (cloudMusicData != null) {
                    b.this.hbq.nf(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hbq.nf(true);
                        return;
                    } else {
                        b.this.hbq.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hbq.nf(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void avN() {
        this.hbp.cancelLoadData();
    }
}
