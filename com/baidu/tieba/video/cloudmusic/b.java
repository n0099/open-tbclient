package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel gKF;
    private final c.b gKG;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.gKF = cloudMusicModel;
        this.gKG = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bwd() {
        this.gKG.mP(true);
        this.gKF.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ab(CloudMusicData cloudMusicData) {
                b.this.gKG.mP(false);
                if (cloudMusicData != null) {
                    b.this.gKG.mQ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.gKG.mQ(true);
                        return;
                    } else {
                        b.this.gKG.a(cloudMusicData);
                        return;
                    }
                }
                b.this.gKG.mQ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void arg() {
        this.gKF.cancelLoadData();
    }
}
