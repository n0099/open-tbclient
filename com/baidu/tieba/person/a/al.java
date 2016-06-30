package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class al implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId egX = BdUniqueId.gen();
    private boolean isSelf;
    private List<com.baidu.adp.widget.ListView.v> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return egX;
    }

    public List<com.baidu.adp.widget.ListView.v> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void setPhotoAlbum(List<com.baidu.adp.widget.ListView.v> list) {
        this.mPhotoAlbum = list;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }
}
