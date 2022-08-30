package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.ejection.value.Direction;
import com.baidu.tieba.pb.ejection.value.LifeCycleState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes4.dex */
public abstract class iu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public Direction n;
    public Direction o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public Paint u;
    public LifeCycleState v;
    public CountDownTimer w;
    public Random x;
    public int y;

    public iu7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 255;
        this.h = 2.0f;
        this.i = 0;
        this.j = 0;
        this.k = 90;
        this.l = 0;
        this.m = -0.4f;
        this.n = Direction.TOP;
        this.o = Direction.RIGHT;
        this.t = 0;
        this.v = LifeCycleState.ACTIVE;
        this.u = new Paint(1);
        this.x = new Random();
        this.y = TbadkCoreApplication.getInst().getSkinType();
    }

    public abstract void a();

    public abstract void b(Canvas canvas);
}
