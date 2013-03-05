package com.baidu.zeus.bouncycastle;

import java.util.Vector;
/* loaded from: classes.dex */
public class DEREncodableVector {
    private Vector v = new Vector();

    public void add(DEREncodable dEREncodable) {
        this.v.addElement(dEREncodable);
    }

    public DEREncodable get(int i) {
        return (DEREncodable) this.v.elementAt(i);
    }

    public int size() {
        return this.v.size();
    }
}
