package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gus;
    private final d.b gut;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gus = cloudMusicModel;
        this.gut = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bvy() {
        this.gut.mY(true);
        this.gus.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void Y(CloudMusicData cloudMusicData) {
                c.this.gut.mY(false);
                if (cloudMusicData != null) {
                    c.this.gut.mZ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gut.mZ(true);
                        return;
                    } else {
                        c.this.gut.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gut.mZ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aiD() {
        this.gus.cancelLoadData();
    }
}
