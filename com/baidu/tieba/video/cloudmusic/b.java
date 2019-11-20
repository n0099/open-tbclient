package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jxc;
    private final c.b jxd;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jxc = cloudMusicModel;
        this.jxd = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void csM() {
        this.jxd.ro(true);
        this.jxc.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void au(CloudMusicData cloudMusicData) {
                b.this.jxd.ro(false);
                if (cloudMusicData != null) {
                    b.this.jxd.rp(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.jxd.rp(true);
                        return;
                    } else {
                        b.this.jxd.a(cloudMusicData);
                        return;
                    }
                }
                b.this.jxd.rp(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bmt() {
        this.jxc.cancelLoadData();
    }
}
