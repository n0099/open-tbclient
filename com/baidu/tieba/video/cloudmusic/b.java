package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel gLI;
    private final c.b gLJ;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.gLI = cloudMusicModel;
        this.gLJ = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bwb() {
        this.gLJ.mQ(true);
        this.gLI.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ab(CloudMusicData cloudMusicData) {
                b.this.gLJ.mQ(false);
                if (cloudMusicData != null) {
                    b.this.gLJ.mR(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.gLJ.mR(true);
                        return;
                    } else {
                        b.this.gLJ.a(cloudMusicData);
                        return;
                    }
                }
                b.this.gLJ.mR(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void arf() {
        this.gLI.cancelLoadData();
    }
}
