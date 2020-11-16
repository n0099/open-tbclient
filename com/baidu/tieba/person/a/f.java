package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes23.dex */
public class f implements q {
    public static final BdUniqueId lUy = BdUniqueId.gen();
    private List<q> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lUy;
    }

    public List<q> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
