package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class ae implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId daX = BdUniqueId.gen();
    private boolean isSelf;
    private List<com.baidu.tbadk.data.g> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return daX;
    }

    public List<com.baidu.tbadk.data.g> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void setPhotoAlbum(List<com.baidu.tbadk.data.g> list) {
        this.mPhotoAlbum = list;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }
}
