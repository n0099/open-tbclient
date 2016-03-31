package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class ae implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId dvz = BdUniqueId.gen();
    private boolean isSelf;
    private List<com.baidu.tbadk.data.h> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dvz;
    }

    public List<com.baidu.tbadk.data.h> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void setPhotoAlbum(List<com.baidu.tbadk.data.h> list) {
        this.mPhotoAlbum = list;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }
}
