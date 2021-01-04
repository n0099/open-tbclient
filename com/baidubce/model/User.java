package com.baidubce.model;
/* loaded from: classes6.dex */
public class User {
    private String displayName;
    private String id;

    public User() {
    }

    public User(String str, String str2) {
        setId(str);
        setDisplayName(str2);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public User withId(String str) {
        setId(str);
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public User withDisplayName(String str) {
        setDisplayName(str);
        return this;
    }

    public int hashCode() {
        return (((this.displayName == null ? 0 : this.displayName.hashCode()) + 31) * 31) + (this.id != null ? this.id.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            User user = (User) obj;
            if (this.displayName == null) {
                if (user.displayName != null) {
                    return false;
                }
            } else if (!this.displayName.equals(user.displayName)) {
                return false;
            }
            return this.id == null ? user.id == null : this.id.equals(user.id);
        }
        return false;
    }

    public String toString() {
        return "User [id=" + this.id + ", displayName=" + this.displayName + "]";
    }
}
