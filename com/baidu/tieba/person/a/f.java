package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes6.dex */
public class f implements m {
    public static final BdUniqueId ijy = BdUniqueId.gen();
    private List<m> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ijy;
    }

    public List<m> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
