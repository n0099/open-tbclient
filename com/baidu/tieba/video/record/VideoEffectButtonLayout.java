package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.p0.n4.l.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36525b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36526c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36527d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f36528e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f36529f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f36530g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f36531h;
    public a i;
    public View j;

    /* loaded from: classes6.dex */
    public interface a {
        void onClickBeauty();

        void onClickFilter();

        void onClickMusic();

        void onClickSticker();
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

    @Override // c.a.p0.n4.l.h.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 1) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080ac0);
            } else {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f080ac1);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04ef, this);
            this.f36528e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911ec);
            this.f36529f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911f9);
            this.f36530g = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911c2);
            this.f36531h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911da);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ec6);
            this.f36525b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ed9);
            this.f36526c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e9f);
            this.f36527d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eb3);
            this.a.setOnClickListener(this);
            this.f36525b.setOnClickListener(this);
            this.f36526c.setOnClickListener(this);
            this.f36527d.setOnClickListener(this);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.i == null) {
            return;
        }
        int id = view.getId();
        this.j = view;
        StatisticItem statisticItem = new StatisticItem("c12495");
        if (id == R.id.obfuscated_res_0x7f090ec6) {
            this.i.onClickMusic();
            statisticItem.param("obj_type", 6);
        } else if (id == R.id.obfuscated_res_0x7f090ed9) {
            this.i.onClickSticker();
            statisticItem.param("obj_type", 4);
        } else if (id == R.id.obfuscated_res_0x7f090e9f) {
            this.i.onClickBeauty();
            statisticItem.param("obj_type", 3);
        } else if (id == R.id.obfuscated_res_0x7f090eb3) {
            this.i.onClickFilter();
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
                this.f36525b.setSelected(z);
            } else if (i == 2) {
                this.f36526c.setSelected(z);
            } else if (i != 3) {
            } else {
                this.f36527d.setSelected(z);
            }
        }
    }

    public void setViewVisibility(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            if (i == 0) {
                this.f36528e.setVisibility(i2);
            } else if (i == 1) {
                this.f36529f.setVisibility(i2);
            } else if (i == 2) {
                this.f36530g.setVisibility(i2);
            } else if (i != 3) {
            } else {
                this.f36531h.setVisibility(i2);
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
