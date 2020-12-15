package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes24.dex */
public class f implements q {
    public static final BdUniqueId miH = BdUniqueId.gen();
    private List<q> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return miH;
    }

    public List<q> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
