package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes.dex */
public class g implements v {
    public static final BdUniqueId exX = BdUniqueId.gen();
    private boolean isSelf;
    private List<v> mPhotoAlbum;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return exX;
    }

    public List<v> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void cw(List<v> list) {
        this.mPhotoAlbum = list;
    }

    public void d(UserData userData) {
        if (userData != null) {
            if (userData.getUserId() != null && userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.isSelf = true;
            } else {
                this.isSelf = false;
            }
            cw(userData.getPhotoAlbum());
            if (this.isSelf && getPhotoAlbum() != null && !cx(getPhotoAlbum()) && getPhotoAlbum().size() < 9) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.oZ(9 - getPhotoAlbum().size());
                getPhotoAlbum().add(aVar);
            }
        }
    }

    private boolean cx(List<v> list) {
        int r = w.r(list);
        if (r == 0) {
            return false;
        }
        for (int i = r - 1; i >= 0; i--) {
            v vVar = (v) w.c(list, i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.person.data.a)) {
                return true;
            }
        }
        return false;
    }
}
