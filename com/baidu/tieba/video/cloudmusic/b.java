package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes23.dex */
public class b implements c.a {
    private final CloudMusicModel mUm;
    private final c.b mUn;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.mUm = cloudMusicModel;
        this.mUn = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dIV() {
        this.mUn.xr(true);
        this.mUm.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aQ(CloudMusicData cloudMusicData) {
                b.this.mUn.xr(false);
                if (cloudMusicData != null) {
                    b.this.mUn.xs(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.mUn.xs(true);
                        return;
                    } else {
                        b.this.mUn.a(cloudMusicData);
                        return;
                    }
                }
                b.this.mUn.xs(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cvF() {
        this.mUm.cancelLoadData();
    }
}
