package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements i {
    public static final BdUniqueId gih = BdUniqueId.gen();
    private List<i> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gih;
    }

    public List<i> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
