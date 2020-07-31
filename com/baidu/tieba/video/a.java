package com.baidu.tieba.video;
/* loaded from: classes17.dex */
public class a {
    public int level;
    public float mbF;
    public float mbG;
    public float mbH;
    public float mbI;
    public float mbJ;

    public static a Gm(int i) {
        switch (i) {
            case 0:
                return a(i, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            case 1:
                return a(i, 0.1f, 1.0f, 0.0f, 0.0f, 0.09f);
            case 2:
                return a(i, 0.1f, 2.0f, 0.39f, 0.31f, 0.66f);
            case 3:
                return a(i, 0.59f, 3.0f, 1.11f, 0.71f, 0.67f);
            case 4:
                return a(i, 0.53f, 3.0f, 1.64f, 1.08f, 0.62f);
            case 5:
                return a(i, 0.47f, 3.0f, 2.14f, 1.41f, 1.03f);
            default:
                return null;
        }
    }

    private static a a(int i, float f, float f2, float f3, float f4, float f5) {
        a aVar = new a();
        aVar.level = i;
        aVar.mbF = f;
        aVar.mbG = f2;
        aVar.mbH = f3;
        aVar.mbI = f4;
        aVar.mbJ = f5;
        return aVar;
    }
}
