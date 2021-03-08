package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes7.dex */
public class b implements c.a {
    private final CloudMusicModel nNL;
    private final c.b nNM;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nNL = cloudMusicModel;
        this.nNM = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dSy() {
        this.nNM.yU(true);
        this.nNL.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aV(CloudMusicData cloudMusicData) {
                b.this.nNM.yU(false);
                if (cloudMusicData != null) {
                    b.this.nNM.yV(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nNM.yV(true);
                        return;
                    } else {
                        b.this.nNM.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nNM.yV(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cFK() {
        this.nNL.cancelLoadData();
    }
}
