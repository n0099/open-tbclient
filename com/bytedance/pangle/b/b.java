package com.bytedance.pangle.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static String b = "request_finish";
    public static String c = "download_start";
    public static String d = "download_finish";
    public static String e = "install_start";
    public static String f = "install_finish";
    public static String g = "load_start";
    public static String h = "load_finish";
    public static String i = "zeus_error";
    public static volatile b j;
    public final List<com.bytedance.pangle.b.a> a = new ArrayList();

    /* loaded from: classes9.dex */
    public static class a {
        public static int a = 11000;
        public static int b = 12000;
        public static int c = 12001;
        public static int d = 20000;
        public static int e = 21000;
        public static int f = 21001;
        public static int g = 21002;
        public static int h = 22000;
        public static int i = 22001;
        public static int j = 22002;
        public static int k = 22999;
        public static int l = 30000;
        public static int m = 31000;
        public static int n = 32000;
        public static int o = 32001;
        public static int p = 32002;
        public static int q = 32003;
        public static int r = 32004;
        public static int s = 32005;
        public static int t = 32006;
        public static int u = 32007;
        public static int v = 32008;
        public static int w = 32999;
        public static int x = 40000;
        public static int y = 41000;
        public static int z = 42000;
    }

    public static b a() {
        if (j == null) {
            synchronized (b.class) {
                j = new b();
            }
        }
        return j;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.a) {
            for (com.bytedance.pangle.b.a aVar : this.a) {
                aVar.a(str, jSONObject, jSONObject2, jSONObject3);
            }
        }
    }
}
