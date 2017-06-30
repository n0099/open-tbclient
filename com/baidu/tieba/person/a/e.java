package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class e implements v {
    public static final BdUniqueId eQA = BdUniqueId.gen();
    private List<v> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQA;
    }

    public List<v> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
