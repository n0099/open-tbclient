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
import com.baidu.tieba.k2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, k2a.b {
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

    /* loaded from: classes7.dex */
    public interface a {
        void B0();

        void T0();

        void h0();

        void u();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
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

    public void setViewVisibility(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            this.h.setVisibility(i2);
                            return;
                        }
                        return;
                    }
                    this.g.setVisibility(i2);
                    return;
                }
                this.f.setVisibility(i2);
                return;
            }
            this.e.setVisibility(i2);
        }
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

    @Override // com.baidu.tieba.k2a.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 1) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080cec);
            } else {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080ced);
            }
        }
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.i = aVar;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0578, this);
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091452);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09145f);
            this.g = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091429);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091441);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910a3);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910b8);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091076);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f09108b);
            this.a.setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || this.i == null) {
            return;
        }
        int id = view2.getId();
        this.j = view2;
        StatisticItem statisticItem = new StatisticItem("c12495");
        if (id == R.id.obfuscated_res_0x7f0910a3) {
            this.i.B0();
            statisticItem.param("obj_type", 6);
        } else if (id == R.id.obfuscated_res_0x7f0910b8) {
            this.i.u();
            statisticItem.param("obj_type", 4);
        } else if (id == R.id.obfuscated_res_0x7f091076) {
            this.i.h0();
            statisticItem.param("obj_type", 3);
        } else if (id == R.id.obfuscated_res_0x7f09108b) {
            this.i.T0();
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void setViewChoosed(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            this.d.setSelected(z);
                            return;
                        }
                        return;
                    }
                    this.c.setSelected(z);
                    return;
                }
                this.b.setSelected(z);
                return;
            }
            this.a.setSelected(z);
        }
    }
}
