package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
public class g implements v {
    public static final BdUniqueId eKn = BdUniqueId.gen();
    private boolean isSelf;
    private List<v> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKn;
    }

    public List<v> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void setPhotoAlbum(List<v> list) {
        this.mPhotoAlbum = list;
    }

    public void f(UserData userData) {
        if (userData != null) {
            if (userData.getUserId() != null && userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.isSelf = true;
            } else {
                this.isSelf = false;
            }
            setPhotoAlbum(userData.getPhotoAlbum());
            if (this.isSelf && getPhotoAlbum() != null && !cA(getPhotoAlbum()) && getPhotoAlbum().size() < 9) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.pf(9 - getPhotoAlbum().size());
                getPhotoAlbum().add(aVar);
            }
        }
    }

    private boolean cA(List<v> list) {
        int s = x.s(list);
        if (s == 0) {
            return false;
        }
        for (int i = s - 1; i >= 0; i--) {
            v vVar = (v) x.c(list, i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.person.data.a)) {
                return true;
            }
        }
        return false;
    }
}
