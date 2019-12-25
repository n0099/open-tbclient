package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes8.dex */
public class f implements m {
    public static final BdUniqueId jbp = BdUniqueId.gen();
    private List<m> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jbp;
    }

    public List<m> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
