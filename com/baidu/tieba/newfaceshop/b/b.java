package com.baidu.tieba.newfaceshop.b;
/* loaded from: classes9.dex */
public class b implements Comparable<b> {
    public int height;
    public String id;
    public int index;
    public String lAy;
    public String name;
    public String thumbnail;
    public String url;
    public int width;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.index <= bVar.index) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
