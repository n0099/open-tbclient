package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes8.dex */
public class b implements c.a {
    private final CloudMusicModel nGa;
    private final c.b nGb;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nGa = cloudMusicModel;
        this.nGb = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dTP() {
        this.nGb.yG(true);
        this.nGa.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aT(CloudMusicData cloudMusicData) {
                b.this.nGb.yG(false);
                if (cloudMusicData != null) {
                    b.this.nGb.yH(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nGb.yH(true);
                        return;
                    } else {
                        b.this.nGb.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nGb.yH(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cIc() {
        this.nGa.cancelLoadData();
    }
}
