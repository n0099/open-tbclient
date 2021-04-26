package com.baidu.wallet.core.utils.contacts;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
import java.util.List;
/* loaded from: classes5.dex */
public class ContactSelectModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class AllContact implements NoProguard {
        public List<PhoneNumberUnit> list;
        public String name;

        public List<PhoneNumberUnit> getList() {
            return this.list;
        }

        public String getName() {
            return this.name;
        }

        public void setList(List<PhoneNumberUnit> list) {
            this.list = list;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String toString() {
            return "AllContact [name=" + this.name + ", list=" + this.list + "]";
        }
    }

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public String abc;
        public List<AllContact> all;
        public String allCount;
        public SelectedContact selected = new SelectedContact();
        public String errCode = "";
        public String des = "";
    }

    /* loaded from: classes5.dex */
    public static class PhoneNumberUnit implements NoProguard {
        public String num = "";
    }

    /* loaded from: classes5.dex */
    public static class SelectedContact implements NoProguard {
        public String name = "";
        public String phone = "";
    }

    public ContactSelectModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public ContactSelectModel(int i2) {
        this();
        this.result = i2;
    }
}
