package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes17.dex */
public class b implements c.a {
    private final CloudMusicModel mcK;
    private final c.b mcL;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.mcK = cloudMusicModel;
        this.mcL = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dpL() {
        this.mcL.vK(true);
        this.mcK.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aJ(CloudMusicData cloudMusicData) {
                b.this.mcL.vK(false);
                if (cloudMusicData != null) {
                    b.this.mcL.vL(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.mcL.vL(true);
                        return;
                    } else {
                        b.this.mcL.a(cloudMusicData);
                        return;
                    }
                }
                b.this.mcL.vL(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void ceq() {
        this.mcK.cancelLoadData();
    }
}
