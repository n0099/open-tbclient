package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes17.dex */
public class b implements c.a {
    private final CloudMusicModel mcI;
    private final c.b mcJ;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.mcI = cloudMusicModel;
        this.mcJ = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dpK() {
        this.mcJ.vK(true);
        this.mcI.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aJ(CloudMusicData cloudMusicData) {
                b.this.mcJ.vK(false);
                if (cloudMusicData != null) {
                    b.this.mcJ.vL(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.mcJ.vL(true);
                        return;
                    } else {
                        b.this.mcJ.a(cloudMusicData);
                        return;
                    }
                }
                b.this.mcJ.vL(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void ceq() {
        this.mcI.cancelLoadData();
    }
}
