package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.t0.y2.c;
import c.a.t0.y2.d;
import c.a.t0.y2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PersonTabView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_REPLY = 1;
    public static final int TAB_THREAD = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49133e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49134f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49135g;

    /* renamed from: h  reason: collision with root package name */
    public View f49136h;

    /* renamed from: i  reason: collision with root package name */
    public View f49137i;

    /* renamed from: j  reason: collision with root package name */
    public View f49138j;

    /* renamed from: k  reason: collision with root package name */
    public View f49139k;
    public int l;
    public int m;
    public int n;
    public b o;
    public View.OnClickListener p;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonTabView f49140e;

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
            this.f49140e = personTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == d.main_thread_btn) {
                    this.f49140e.setCurrentTab(0);
                } else if (view.getId() == d.reply_btn) {
                    this.f49140e.setCurrentTab(1);
                }
                if (this.f49140e.o != null) {
                    this.f49140e.o.onTabSelect(this.f49140e.l);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
        this.m = SkinManager.getColor(c.a.t0.y2.a.CAM_X0105);
        this.n = SkinManager.getColor(c.a.t0.y2.a.CAM_X0106);
        this.p = new a(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f49133e = context;
            LayoutInflater.from(context).inflate(e.person_button_header_view, this);
            TextView textView = (TextView) findViewById(d.main_thread_btn);
            this.f49134f = textView;
            textView.setOnClickListener(this.p);
            TextView textView2 = (TextView) findViewById(d.reply_btn);
            this.f49135g = textView2;
            textView2.setOnClickListener(this.p);
            this.f49136h = findViewById(d.main_thread_divider);
            this.f49137i = findViewById(d.reply_btn_divider);
            this.f49138j = findViewById(d.main_thread_bottom_divider);
            this.f49139k = findViewById(d.reply_btn_bottom_divider);
            setCurrentTab(0);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = SkinManager.getColor(c.a.t0.y2.a.CAM_X0105);
            this.n = SkinManager.getColor(c.a.t0.y2.a.CAM_X0107);
            SkinManager.setBackgroundResource(this, c.item_person_header_attention_bg_selector);
            SkinManager.setBackgroundResource(this.f49136h, c.roundline);
            SkinManager.setBackgroundResource(this.f49137i, c.roundline);
            SkinManager.setBackgroundColor(this.f49138j, c.a.t0.y2.a.CAM_X0204);
            SkinManager.setBackgroundColor(this.f49139k, c.a.t0.y2.a.CAM_X0204);
            int i2 = this.l;
            if (i2 == 0) {
                this.f49134f.setTextColor(this.m);
                this.f49135g.setTextColor(this.n);
            } else if (i2 == 1) {
                this.f49134f.setTextColor(this.n);
                this.f49135g.setTextColor(this.m);
            }
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 == this.l) {
            return;
        }
        this.l = i2;
        if (i2 == 0) {
            this.f49136h.setVisibility(0);
            this.f49137i.setVisibility(4);
            this.f49134f.setTextColor(this.m);
            this.f49135g.setTextColor(this.n);
        } else if (i2 == 1) {
            this.f49136h.setVisibility(4);
            this.f49137i.setVisibility(0);
            this.f49134f.setTextColor(this.n);
            this.f49135g.setTextColor(this.m);
        }
    }

    public void setOnTabSelectListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
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
        this.m = SkinManager.getColor(c.a.t0.y2.a.CAM_X0105);
        this.n = SkinManager.getColor(c.a.t0.y2.a.CAM_X0106);
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
        this.m = SkinManager.getColor(c.a.t0.y2.a.CAM_X0105);
        this.n = SkinManager.getColor(c.a.t0.y2.a.CAM_X0106);
        this.p = new a(this);
        c(context);
    }
}
