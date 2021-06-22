package com.baidubce.services.bos.model;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes6.dex */
public class Grantee {
    public String id;

    public Grantee() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Grantee.class == obj.getClass()) {
            Grantee grantee = (Grantee) obj;
            String str = this.id;
            if (str == null) {
                if (grantee.id != null) {
                    return false;
                }
            } else if (!str.equals(grantee.id)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "Grantee [id=" + this.id + PreferencesUtil.RIGHT_MOUNT;
    }

    public Grantee withId(String str) {
        setId(str);
        return this;
    }

    public Grantee(String str) {
        setId(str);
    }
}
