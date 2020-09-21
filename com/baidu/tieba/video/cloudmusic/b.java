package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes22.dex */
public class b implements c.a {
    private final CloudMusicModel mEy;
    private final c.b mEz;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.mEy = cloudMusicModel;
        this.mEz = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dFj() {
        this.mEz.wK(true);
        this.mEy.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aN(CloudMusicData cloudMusicData) {
                b.this.mEz.wK(false);
                if (cloudMusicData != null) {
                    b.this.mEz.wL(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.mEz.wL(true);
                        return;
                    } else {
                        b.this.mEz.a(cloudMusicData);
                        return;
                    }
                }
                b.this.mEz.wL(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void csi() {
        this.mEy.cancelLoadData();
    }
}
