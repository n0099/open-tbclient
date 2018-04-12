package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel gKI;
    private final c.b gKJ;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.gKI = cloudMusicModel;
        this.gKJ = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bwd() {
        this.gKJ.mP(true);
        this.gKI.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ab(CloudMusicData cloudMusicData) {
                b.this.gKJ.mP(false);
                if (cloudMusicData != null) {
                    b.this.gKJ.mQ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.gKJ.mQ(true);
                        return;
                    } else {
                        b.this.gKJ.a(cloudMusicData);
                        return;
                    }
                }
                b.this.gKJ.mQ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void arg() {
        this.gKI.cancelLoadData();
    }
}
