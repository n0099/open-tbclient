package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonTabView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35531b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35532c;

    /* renamed from: d  reason: collision with root package name */
    public View f35533d;

    /* renamed from: e  reason: collision with root package name */
    public View f35534e;

    /* renamed from: f  reason: collision with root package name */
    public View f35535f;

    /* renamed from: g  reason: collision with root package name */
    public View f35536g;

    /* renamed from: h  reason: collision with root package name */
    public int f35537h;
    public int i;
    public int j;
    public b k;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonTabView a;

        public a(PersonTabView personTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f09137b) {
                    this.a.setCurrentTab(0);
                } else if (view.getId() == R.id.obfuscated_res_0x7f091a55) {
                    this.a.setCurrentTab(1);
                }
                if (this.a.k != null) {
                    this.a.k.onTabSelect(this.a.f35537h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onTabSelect(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonTabView(Context context) {
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
        this.f35537h = 0;
        this.i = SkinManager.getColor(R.color.CAM_X0105);
        this.j = SkinManager.getColor(R.color.CAM_X0106);
        this.l = new a(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06ad, this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09137b);
            this.f35531b = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a55);
            this.f35532c = textView2;
            textView2.setOnClickListener(this.l);
            this.f35533d = findViewById(R.id.obfuscated_res_0x7f09137c);
            this.f35534e = findViewById(R.id.obfuscated_res_0x7f091a57);
            this.f35535f = findViewById(R.id.obfuscated_res_0x7f09137a);
            this.f35536g = findViewById(R.id.obfuscated_res_0x7f091a56);
            setCurrentTab(0);
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i == this.f35537h) {
            return;
        }
        this.f35537h = i;
        if (i == 0) {
            this.f35533d.setVisibility(0);
            this.f35534e.setVisibility(4);
            this.f35531b.setTextColor(this.i);
            this.f35532c.setTextColor(this.j);
        } else if (i == 1) {
            this.f35533d.setVisibility(4);
            this.f35534e.setVisibility(0);
            this.f35531b.setTextColor(this.j);
            this.f35532c.setTextColor(this.i);
        }
    }

    public void setOnTabSelectListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.k = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonTabView(Context context, AttributeSet attributeSet) {
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
        this.f35537h = 0;
        this.i = SkinManager.getColor(R.color.CAM_X0105);
        this.j = SkinManager.getColor(R.color.CAM_X0106);
        this.l = new a(this);
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
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
        this.f35537h = 0;
        this.i = SkinManager.getColor(R.color.CAM_X0105);
        this.j = SkinManager.getColor(R.color.CAM_X0106);
        this.l = new a(this);
        c(context);
    }
}
