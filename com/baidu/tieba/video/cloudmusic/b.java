package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes8.dex */
public class b implements c.a {
    private final CloudMusicModel kuH;
    private final c.b kuI;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kuH = cloudMusicModel;
        this.kuI = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cNV() {
        this.kuI.th(true);
        this.kuH.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aA(CloudMusicData cloudMusicData) {
                b.this.kuI.th(false);
                if (cloudMusicData != null) {
                    b.this.kuI.ti(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kuI.ti(true);
                        return;
                    } else {
                        b.this.kuI.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kuI.ti(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bER() {
        this.kuH.cancelLoadData();
    }
}
