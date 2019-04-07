package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel iVo;
    private final c.b iVp;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.iVo = cloudMusicModel;
        this.iVp = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void ciY() {
        this.iVp.qy(true);
        this.iVo.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ax(CloudMusicData cloudMusicData) {
                b.this.iVp.qy(false);
                if (cloudMusicData != null) {
                    b.this.iVp.qz(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.iVp.qz(true);
                        return;
                    } else {
                        b.this.iVp.a(cloudMusicData);
                        return;
                    }
                }
                b.this.iVp.qz(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void beW() {
        this.iVo.cancelLoadData();
    }
}
