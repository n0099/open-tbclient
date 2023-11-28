package com.baidu.tieba;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class uz5 extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public final WheelView d;

    public uz5(WheelView wheelView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = wheelView;
        this.c = i;
        this.a = Integer.MAX_VALUE;
        this.b = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == Integer.MAX_VALUE) {
                this.a = this.c;
            }
            int i = this.a;
            int i2 = (int) (i * 0.1f);
            this.b = i2;
            if (i2 == 0) {
                if (i < 0) {
                    this.b = -1;
                } else {
                    this.b = 1;
                }
            }
            if (Math.abs(this.a) <= 1) {
                this.d.b();
                this.d.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.d;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.b);
            if (!this.d.i()) {
                float itemHeight = this.d.getItemHeight();
                float itemsCount = ((this.d.getItemsCount() - 1) - this.d.getInitPosition()) * itemHeight;
                if (this.d.getTotalScrollY() <= (-this.d.getInitPosition()) * itemHeight || this.d.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.d;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.b);
                    this.d.b();
                    this.d.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.d.getHandler().sendEmptyMessage(1000);
            this.a -= this.b;
        }
    }
}
