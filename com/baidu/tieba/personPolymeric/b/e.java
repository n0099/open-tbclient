package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes24.dex */
public abstract class e {
    protected boolean mIsHost;

    public e(boolean z) {
        this.mIsHost = z;
    }

    public PersonStatus a(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar == null || aVar.getUserData() == null) {
            if (this.mIsHost) {
                return PersonStatus.HOST_DEFAULT;
            }
            return PersonStatus.GUEST_DEFAULT;
        }
        return d(aVar.getUserData());
    }

    public PersonStatus d(UserData userData) {
        if (userData == null) {
            if (this.mIsHost) {
                return PersonStatus.HOST_DEFAULT;
            }
            return PersonStatus.GUEST_DEFAULT;
        } else if (userData.isBaijiahaoUser()) {
            if (this.mIsHost) {
                return PersonStatus.HOST_BJH;
            }
            return PersonStatus.GUEST_BJH;
        } else if (this.mIsHost) {
            return PersonStatus.HOST_DEFAULT;
        } else {
            return PersonStatus.GUEST_DEFAULT;
        }
    }
}
