package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel lBJ;
    private final c.b lBK;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.lBJ = cloudMusicModel;
        this.lBK = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dik() {
        this.lBK.uQ(true);
        this.lBJ.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aI(CloudMusicData cloudMusicData) {
                b.this.lBK.uQ(false);
                if (cloudMusicData != null) {
                    b.this.lBK.uR(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.lBK.uR(true);
                        return;
                    } else {
                        b.this.lBK.a(cloudMusicData);
                        return;
                    }
                }
                b.this.lBK.uR(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bXG() {
        this.lBJ.cancelLoadData();
    }
}
