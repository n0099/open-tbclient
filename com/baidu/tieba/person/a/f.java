package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes8.dex */
public class f implements n {
    public static final BdUniqueId mnP = BdUniqueId.gen();
    private List<n> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mnP;
    }

    public List<n> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
