package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gQt;
    private final d.b gQu;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gQt = cloudMusicModel;
        this.gQu = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bBo() {
        this.gQu.nC(true);
        this.gQt.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ad(CloudMusicData cloudMusicData) {
                c.this.gQu.nC(false);
                if (cloudMusicData != null) {
                    c.this.gQu.nD(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gQu.nD(true);
                        return;
                    } else {
                        c.this.gQu.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gQu.nD(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void and() {
        this.gQt.cancelLoadData();
    }
}
