package com.baidubce.services.bos.model;
/* loaded from: classes4.dex */
public class Grantee {
    private String id;

    public Grantee() {
    }

    public Grantee(String str) {
        setId(str);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Grantee withId(String str) {
        setId(str);
        return this;
    }

    public int hashCode() {
        return (this.id == null ? 0 : this.id.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Grantee grantee = (Grantee) obj;
            return this.id == null ? grantee.id == null : this.id.equals(grantee.id);
        }
        return false;
    }

    public String toString() {
        return "Grantee [id=" + this.id + "]";
    }
}
