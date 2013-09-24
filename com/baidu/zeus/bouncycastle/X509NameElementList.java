package com.baidu.zeus.bouncycastle;

import java.util.ArrayList;
import java.util.BitSet;
/* loaded from: classes.dex */
public class X509NameElementList {
    private BitSet added = new BitSet();
    private DERObjectIdentifier key0;
    private DERObjectIdentifier key1;
    private DERObjectIdentifier key2;
    private DERObjectIdentifier key3;
    private ArrayList<Object> rest;
    private int size;
    private String value0;
    private String value1;
    private String value2;
    private String value3;

    public void add(DERObjectIdentifier dERObjectIdentifier, String str) {
        add(dERObjectIdentifier, str, false);
    }

    public void add(DERObjectIdentifier dERObjectIdentifier, String str, boolean z) {
        if (dERObjectIdentifier == null) {
            throw new NullPointerException("key == null");
        }
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        int i = this.size;
        switch (i) {
            case 0:
                this.key0 = dERObjectIdentifier;
                this.value0 = str;
                break;
            case 1:
                this.key1 = dERObjectIdentifier;
                this.value1 = str;
                break;
            case 2:
                this.key2 = dERObjectIdentifier;
                this.value2 = str;
                break;
            case 3:
                this.key3 = dERObjectIdentifier;
                this.value3 = str;
                break;
            case 4:
                this.rest = new ArrayList<>();
            default:
                this.rest.add(dERObjectIdentifier);
                this.rest.add(str);
                break;
        }
        if (z) {
            this.added.set(i);
        }
        this.size = i + 1;
    }

    public void setLastAddedFlag() {
        this.added.set(this.size - 1);
    }

    public int size() {
        return this.size;
    }

    public DERObjectIdentifier getKey(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        switch (i) {
            case 0:
                return this.key0;
            case 1:
                return this.key1;
            case 2:
                return this.key2;
            case 3:
                return this.key3;
            default:
                return (DERObjectIdentifier) this.rest.get((i - 4) * 2);
        }
    }

    public String getValue(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        switch (i) {
            case 0:
                return this.value0;
            case 1:
                return this.value1;
            case 2:
                return this.value2;
            case 3:
                return this.value3;
            default:
                return (String) this.rest.get(((i - 4) * 2) + 1);
        }
    }

    public boolean getAdded(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        return this.added.get(i);
    }

    public X509NameElementList reverse() {
        X509NameElementList x509NameElementList = new X509NameElementList();
        for (int i = this.size - 1; i >= 0; i--) {
            x509NameElementList.add(getKey(i), getValue(i), getAdded(i));
        }
        return x509NameElementList;
    }
}
