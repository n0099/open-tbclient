package com.baidubce.services.bos.model;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.List;
/* loaded from: classes6.dex */
public class Grant {
    public List<Grantee> grantee;
    public List<Permission> permission;

    public Grant() {
    }

    private boolean equalList(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (Object obj : list) {
            if (!list2.contains(obj)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Grant.class == obj.getClass()) {
            Grant grant = (Grant) obj;
            List<Grantee> list = this.grantee;
            if (list == null) {
                if (grant.grantee != null) {
                    return false;
                }
            } else if (!list.equals(grant.grantee)) {
                return false;
            }
            return equalList(this.permission, grant.permission);
        }
        return false;
    }

    public List<Grantee> getGrantee() {
        return this.grantee;
    }

    public List<Permission> getPermission() {
        return this.permission;
    }

    public int hashCode() {
        List<Grantee> list = this.grantee;
        int hashCode = ((list == null ? 0 : list.hashCode()) + 31) * 31;
        List<Permission> list2 = this.permission;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public void setGrantee(List<Grantee> list) {
        this.grantee = list;
    }

    public void setPermission(List<Permission> list) {
        this.permission = list;
    }

    public String toString() {
        return "Grant [grantee=" + this.grantee + ", permission=" + this.permission + PreferencesUtil.RIGHT_MOUNT;
    }

    public Grant withGrantee(List<Grantee> list) {
        setGrantee(list);
        return this;
    }

    public Grant withPermission(List<Permission> list) {
        setPermission(list);
        return this;
    }

    public Grant(List<Grantee> list, List<Permission> list2) {
        setGrantee(list);
        setPermission(list2);
    }
}
