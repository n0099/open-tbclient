package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes7.dex */
public class f implements n {
    public static final BdUniqueId mjk = BdUniqueId.gen();
    private List<n> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mjk;
    }

    public List<n> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
