package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fhq = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.f> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhq;
    }

    public List<com.baidu.adp.widget.ListView.f> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
