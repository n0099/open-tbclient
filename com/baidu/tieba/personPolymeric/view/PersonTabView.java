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
/* loaded from: classes4.dex */
public class PersonTabView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20382e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20383f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20384g;

    /* renamed from: h  reason: collision with root package name */
    public View f20385h;

    /* renamed from: i  reason: collision with root package name */
    public View f20386i;
    public View j;
    public View k;
    public int l;
    public int m;
    public int n;
    public b o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonTabView f20387e;

        public a(PersonTabView personTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20387e = personTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.main_thread_btn) {
                    this.f20387e.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    this.f20387e.setCurrentTab(1);
                }
                if (this.f20387e.o != null) {
                    this.f20387e.o.onTabSelect(this.f20387e.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onTabSelect(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = SkinManager.getColor(R.color.CAM_X0105);
        this.n = SkinManager.getColor(R.color.CAM_X0106);
        this.p = new a(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f20382e = context;
            LayoutInflater.from(context).inflate(R.layout.person_button_header_view, this);
            TextView textView = (TextView) findViewById(R.id.main_thread_btn);
            this.f20383f = textView;
            textView.setOnClickListener(this.p);
            TextView textView2 = (TextView) findViewById(R.id.reply_btn);
            this.f20384g = textView2;
            textView2.setOnClickListener(this.p);
            this.f20385h = findViewById(R.id.main_thread_divider);
            this.f20386i = findViewById(R.id.reply_btn_divider);
            this.j = findViewById(R.id.main_thread_bottom_divider);
            this.k = findViewById(R.id.reply_btn_bottom_divider);
            setCurrentTab(0);
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.l) {
            return;
        }
        this.l = i2;
        if (i2 == 0) {
            this.f20385h.setVisibility(0);
            this.f20386i.setVisibility(4);
            this.f20383f.setTextColor(this.m);
            this.f20384g.setTextColor(this.n);
        } else if (i2 == 1) {
            this.f20385h.setVisibility(4);
            this.f20386i.setVisibility(0);
            this.f20383f.setTextColor(this.n);
            this.f20384g.setTextColor(this.m);
        }
    }

    public void setOnTabSelectListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.o = bVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = SkinManager.getColor(R.color.CAM_X0105);
        this.n = SkinManager.getColor(R.color.CAM_X0106);
        this.p = new a(this);
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = SkinManager.getColor(R.color.CAM_X0105);
        this.n = SkinManager.getColor(R.color.CAM_X0106);
        this.p = new a(this);
        c(context);
    }
}
