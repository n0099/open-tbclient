package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes23.dex */
public class b implements c.a {
    private final CloudMusicModel nmI;
    private final c.b nmJ;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nmI = cloudMusicModel;
        this.nmJ = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dOF() {
        this.nmJ.xR(true);
        this.nmI.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aR(CloudMusicData cloudMusicData) {
                b.this.nmJ.xR(false);
                if (cloudMusicData != null) {
                    b.this.nmJ.xS(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nmJ.xS(true);
                        return;
                    } else {
                        b.this.nmJ.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nmJ.xS(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cBn() {
        this.nmI.cancelLoadData();
    }
}
