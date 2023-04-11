package com.baidu.tieba;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class nv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public String B;
    public String C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public WheelView.DividerType U;
    public tv5 a;
    public sv5 b;
    public ov5 c;
    public boolean[] d;
    public Calendar e;
    public Calendar f;
    public Calendar g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public ViewGroup y;
    public int z;

    public nv5(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new boolean[]{true, true, true, false, false, false};
        this.j = false;
        this.k = false;
        this.z = 17;
        this.E = -16417281;
        this.F = -16417281;
        this.G = -16777216;
        this.H = -1;
        this.I = BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT;
        this.J = 17;
        this.K = 18;
        this.L = 18;
        this.M = -5723992;
        this.N = -14013910;
        this.O = -2763307;
        this.P = -1;
        this.Q = 1.6f;
        this.S = true;
        this.T = false;
        Typeface typeface = Typeface.MONOSPACE;
        this.U = WheelView.DividerType.FILL;
        if (i == 1) {
            this.x = R.layout.pickerview_options;
        } else {
            this.x = R.layout.pickerview_time;
        }
    }
}
