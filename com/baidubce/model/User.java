package com.baidubce.model;
/* loaded from: classes5.dex */
public class User {
    public String displayName;
    public String id;

    public User() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && User.class == obj.getClass()) {
            User user = (User) obj;
            String str = this.displayName;
            if (str == null) {
                if (user.displayName != null) {
                    return false;
                }
            } else if (!str.equals(user.displayName)) {
                return false;
            }
            String str2 = this.id;
            if (str2 == null) {
                if (user.id != null) {
                    return false;
                }
            } else if (!str2.equals(user.id)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.displayName;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.id;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "User [id=" + this.id + ", displayName=" + this.displayName + "]";
    }

    public User withDisplayName(String str) {
        setDisplayName(str);
        return this;
    }

    public User withId(String str) {
        setId(str);
        return this;
    }

    public User(String str, String str2) {
        setId(str);
        setDisplayName(str2);
    }
}
