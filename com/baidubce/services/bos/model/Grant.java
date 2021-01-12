package com.baidubce.services.bos.model;

import java.util.List;
/* loaded from: classes5.dex */
public class Grant {
    private List<Grantee> grantee;
    private List<Permission> permission;

    public Grant() {
    }

    public Grant(List<Grantee> list, List<Permission> list2) {
        setGrantee(list);
        setPermission(list2);
    }

    public List<Grantee> getGrantee() {
        return this.grantee;
    }

    public void setGrantee(List<Grantee> list) {
        this.grantee = list;
    }

    public Grant withGrantee(List<Grantee> list) {
        setGrantee(list);
        return this;
    }

    public List<Permission> getPermission() {
        return this.permission;
    }

    public void setPermission(List<Permission> list) {
        this.permission = list;
    }

    public Grant withPermission(List<Permission> list) {
        setPermission(list);
        return this;
    }

    public int hashCode() {
        return (((this.grantee == null ? 0 : this.grantee.hashCode()) + 31) * 31) + (this.permission != null ? this.permission.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Grant grant = (Grant) obj;
            if (this.grantee == null) {
                if (grant.grantee != null) {
                    return false;
                }
            } else if (!this.grantee.equals(grant.grantee)) {
                return false;
            }
            return equalList(this.permission, grant.permission);
        }
        return false;
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

    public String toString() {
        return "Grant [grantee=" + this.grantee + ", permission=" + this.permission + "]";
    }
}
