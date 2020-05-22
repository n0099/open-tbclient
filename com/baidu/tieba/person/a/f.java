package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.List;
/* loaded from: classes11.dex */
public class f implements o {
    public static final BdUniqueId kjL = BdUniqueId.gen();
    private List<o> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kjL;
    }

    public List<o> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
