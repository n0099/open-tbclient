package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class e implements f {
    public static final BdUniqueId fem = BdUniqueId.gen();
    private List<f> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fem;
    }

    public List<f> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
