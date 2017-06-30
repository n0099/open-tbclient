package com.baidu.tieba.view.bubbleView;
/* loaded from: classes.dex */
public enum ArrowDirection {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3);
    
    private int value;

    /* JADX DEBUG: Replace access to removed values field (gbg) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ArrowDirection[] valuesCustom() {
        ArrowDirection[] valuesCustom = values();
        int length = valuesCustom.length;
        ArrowDirection[] arrowDirectionArr = new ArrowDirection[length];
        System.arraycopy(valuesCustom, 0, arrowDirectionArr, 0, length);
        return arrowDirectionArr;
    }

    ArrowDirection(int i) {
        this.value = i;
    }

    public static ArrowDirection fromInt(int i) {
        ArrowDirection[] valuesCustom;
        for (ArrowDirection arrowDirection : valuesCustom()) {
            if (i == arrowDirection.getValue()) {
                return arrowDirection;
            }
        }
        return LEFT;
    }

    public int getValue() {
        return this.value;
    }
}
