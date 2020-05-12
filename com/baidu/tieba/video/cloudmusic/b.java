package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel lhP;
    private final c.b lhQ;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.lhP = cloudMusicModel;
        this.lhQ = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void daH() {
        this.lhQ.us(true);
        this.lhP.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aF(CloudMusicData cloudMusicData) {
                b.this.lhQ.us(false);
                if (cloudMusicData != null) {
                    b.this.lhQ.ut(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.lhQ.ut(true);
                        return;
                    } else {
                        b.this.lhQ.a(cloudMusicData);
                        return;
                    }
                }
                b.this.lhQ.ut(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bRi() {
        this.lhP.cancelLoadData();
    }
}
