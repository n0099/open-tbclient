package com.baidu.tieba.view;
/* loaded from: classes.dex */
public abstract class ListPageView extends com.baidu.adp.widget.ListView.c {

    /* loaded from: classes.dex */
    public enum TYPE {
        PREV_PAGE,
        NEXT_PAGE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TYPE[] valuesCustom() {
            TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            TYPE[] typeArr = new TYPE[length];
            System.arraycopy(valuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }
}
