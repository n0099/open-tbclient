package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
public class g implements v {
    public static final BdUniqueId eBx = BdUniqueId.gen();
    private boolean isSelf;
    private List<v> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eBx;
    }

    public List<v> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void cd(List<v> list) {
        this.mPhotoAlbum = list;
    }

    public void d(UserData userData) {
        if (userData != null) {
            if (userData.getUserId() != null && userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.isSelf = true;
            } else {
                this.isSelf = false;
            }
            cd(userData.getPhotoAlbum());
            if (this.isSelf && getPhotoAlbum() != null && !ce(getPhotoAlbum()) && getPhotoAlbum().size() < 9) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.oV(9 - getPhotoAlbum().size());
                getPhotoAlbum().add(aVar);
            }
        }
    }

    private boolean ce(List<v> list) {
        int p = x.p(list);
        if (p == 0) {
            return false;
        }
        for (int i = p - 1; i >= 0; i--) {
            v vVar = (v) x.c(list, i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.person.data.a)) {
                return true;
            }
        }
        return false;
    }
}
