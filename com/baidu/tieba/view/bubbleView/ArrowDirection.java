package com.baidu.tieba.view.bubbleView;
/* loaded from: classes5.dex */
public enum ArrowDirection {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3);
    
    public int value;

    ArrowDirection(int i2) {
        this.value = i2;
    }

    public static ArrowDirection fromInt(int i2) {
        ArrowDirection[] values;
        for (ArrowDirection arrowDirection : values()) {
            if (i2 == arrowDirection.getValue()) {
                return arrowDirection;
            }
        }
        return LEFT;
    }

    public int getValue() {
        return this.value;
    }
}
