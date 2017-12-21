package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gQy;
    private final d.b gQz;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gQy = cloudMusicModel;
        this.gQz = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bBo() {
        this.gQz.nC(true);
        this.gQy.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ad(CloudMusicData cloudMusicData) {
                c.this.gQz.nC(false);
                if (cloudMusicData != null) {
                    c.this.gQz.nD(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gQz.nD(true);
                        return;
                    } else {
                        c.this.gQz.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gQz.nD(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void and() {
        this.gQy.cancelLoadData();
    }
}
