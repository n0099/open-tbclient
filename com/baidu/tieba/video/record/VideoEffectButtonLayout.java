package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nu8;
/* loaded from: classes4.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, nu8.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public LinearLayout e;
    public LinearLayout f;
    public LinearLayout g;
    public LinearLayout h;
    public a i;
    public View j;

    /* loaded from: classes4.dex */
    public interface a {
        void F0();

        void U0();

        void m0();

        void u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectButtonLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    @Override // com.repackage.nu8.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 1) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b06);
            } else {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080b07);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0500, this);
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09127e);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09128b);
            this.g = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091254);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09126c);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eda);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eef);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eb0);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ec4);
            this.a.setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.i == null) {
            return;
        }
        int id = view2.getId();
        this.j = view2;
        StatisticItem statisticItem = new StatisticItem("c12495");
        if (id == R.id.obfuscated_res_0x7f090eda) {
            this.i.F0();
            statisticItem.param("obj_type", 6);
        } else if (id == R.id.obfuscated_res_0x7f090eef) {
            this.i.u();
            statisticItem.param("obj_type", 4);
        } else if (id == R.id.obfuscated_res_0x7f090eb0) {
            this.i.m0();
            statisticItem.param("obj_type", 3);
        } else if (id == R.id.obfuscated_res_0x7f090ec4) {
            this.i.U0();
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.i = aVar;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                this.a.setSelected(z);
            } else if (i == 1) {
                this.b.setSelected(z);
            } else if (i == 2) {
                this.c.setSelected(z);
            } else if (i != 3) {
            } else {
                this.d.setSelected(z);
            }
        }
    }

    public void setViewVisibility(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            if (i == 0) {
                this.e.setVisibility(i2);
            } else if (i == 1) {
                this.f.setVisibility(i2);
            } else if (i == 2) {
                this.g.setVisibility(i2);
            } else if (i != 3) {
            } else {
                this.h.setVisibility(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }
}
