package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel gXk;
    private final c.b gXl;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.gXk = cloudMusicModel;
        this.gXl = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bBi() {
        this.gXl.mW(true);
        this.gXk.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ae(CloudMusicData cloudMusicData) {
                b.this.gXl.mW(false);
                if (cloudMusicData != null) {
                    b.this.gXl.mX(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.gXl.mX(true);
                        return;
                    } else {
                        b.this.gXl.a(cloudMusicData);
                        return;
                    }
                }
                b.this.gXl.mX(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void avk() {
        this.gXk.cancelLoadData();
    }
}
