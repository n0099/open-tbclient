package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements h {
    public static final BdUniqueId gie = BdUniqueId.gen();
    private List<h> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gie;
    }

    public List<h> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
