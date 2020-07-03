package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes11.dex */
public class f implements q {
    public static final BdUniqueId kED = BdUniqueId.gen();
    private List<q> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kED;
    }

    public List<q> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }
}
