package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel hcC;
    private final c.b hcD;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hcC = cloudMusicModel;
        this.hcD = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bAt() {
        this.hcD.mQ(true);
        this.hcC.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ag(CloudMusicData cloudMusicData) {
                b.this.hcD.mQ(false);
                if (cloudMusicData != null) {
                    b.this.hcD.mR(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hcD.mR(true);
                        return;
                    } else {
                        b.this.hcD.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hcD.mR(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aws() {
        this.hcC.cancelLoadData();
    }
}
