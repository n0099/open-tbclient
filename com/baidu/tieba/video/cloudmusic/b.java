package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes22.dex */
public class b implements c.a {
    private final CloudMusicModel nnP;
    private final c.b nnQ;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nnP = cloudMusicModel;
        this.nnQ = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dOE() {
        this.nnQ.xY(true);
        this.nnP.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aS(CloudMusicData cloudMusicData) {
                b.this.nnQ.xY(false);
                if (cloudMusicData != null) {
                    b.this.nnQ.xZ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nnQ.xZ(true);
                        return;
                    } else {
                        b.this.nnQ.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nnQ.xZ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cAQ() {
        this.nnP.cancelLoadData();
    }
}
