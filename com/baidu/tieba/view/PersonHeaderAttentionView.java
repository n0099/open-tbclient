package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.r0.b4.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f58417e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58418f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58419g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58420h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f58421i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f58422j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public int o;
    public e p;
    public UserData q;
    public View r;
    public View s;
    public View t;
    public View.OnClickListener u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.o0.a f58423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonHeaderAttentionView f58424f;

        public a(PersonHeaderAttentionView personHeaderAttentionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personHeaderAttentionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58424f = personHeaderAttentionView;
            this.f58423e = new c.a.r0.o0.a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58424f.q == null || view == null || !ViewHelper.checkUpIsLogin(this.f58424f.f58417e)) {
                return;
            }
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f58424f.q.getUserId());
            boolean z = this.f58424f.q.getIsFriend() == 1;
            int id = view.getId();
            if (id != this.f58424f.f58418f.getId() && id != this.f58424f.f58419g.getId()) {
                if (id != this.f58424f.f58420h.getId() && id != this.f58424f.f58422j.getId()) {
                    if (id == this.f58424f.k.getId() || id == this.f58424f.l.getId()) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
                        if (this.f58424f.q.getPersonPrivate() != null) {
                            if (this.f58424f.q.getPersonPrivate().w() != 1 && !equals && (!z || this.f58424f.q.getPersonPrivate().w() != 2)) {
                                PersonHeaderAttentionView personHeaderAttentionView = this.f58424f;
                                personHeaderAttentionView.m(personHeaderAttentionView.q.getSex());
                                return;
                            }
                            this.f58423e.f23048a = 7;
                        } else {
                            PersonHeaderAttentionView personHeaderAttentionView2 = this.f58424f;
                            personHeaderAttentionView2.m(personHeaderAttentionView2.q.getSex());
                            return;
                        }
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
                    this.f58423e.f23048a = 5;
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
                this.f58423e.f23048a = 4;
            }
            if (this.f58424f.p == null) {
                return;
            }
            this.f58423e.f23049b = new Bundle();
            this.f58423e.f23049b.putSerializable(UserData.TYPE_USER, this.f58424f.q);
            this.f58424f.p.a(view, this.f58423e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonHeaderAttentionView(Context context) {
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
        this.o = -1;
        this.u = new a(this);
        l(context);
        k();
        onChangeSkinType(0);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58420h.setOnClickListener(this.u);
            this.f58422j.setOnClickListener(this.u);
            this.f58418f.setOnClickListener(this.u);
            this.f58419g.setOnClickListener(this.u);
            this.k.setOnClickListener(this.u);
            this.l.setOnClickListener(this.u);
            this.m.setOnClickListener(this.u);
            this.n.setOnClickListener(this.u);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f58417e = context;
            setOrientation(0);
            setGravity(16);
            LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
            this.f58420h = (TextView) findViewById(R.id.person_header_fans_num);
            this.f58422j = (TextView) findViewById(R.id.person_header_fans_des);
            this.f58421i = (ImageView) findViewById(R.id.person_header_fans_red_tip);
            this.f58418f = (TextView) findViewById(R.id.person_header_attention_num);
            this.f58419g = (TextView) findViewById(R.id.person_header_attention_des);
            this.k = (TextView) findViewById(R.id.person_header_bar_num);
            this.l = (TextView) findViewById(R.id.person_header_bar_des);
            TextView textView = (TextView) findViewById(R.id.person_header_thread_num);
            this.m = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.person_header_thread_des);
            this.n = textView2;
            textView2.setVisibility(8);
            this.r = findViewById(R.id.divider_for_fans_and_attention);
            this.s = findViewById(R.id.divider_for_attention_and_bar);
            View findViewById = findViewById(R.id.divider_for_bar_and_thread);
            this.t = findViewById;
            findViewById.setVisibility(8);
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Context context = this.f58417e;
            BdToast.i(context, String.format(context.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public final void n(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) {
            this.f58418f.setText(str);
            this.f58420h.setText(str2);
            this.k.setText(str4);
            this.m.setText(str3);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.o == i2) {
            return;
        }
        this.o = i2;
        SkinManager.setViewTextColor(this.f58418f, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f58419g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f58420h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f58422j, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(this.f58421i, R.drawable.icon_news_down_bar_one);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
    }

    public void setData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, userData) == null) {
            this.q = userData;
            if (userData.getConcernNum() >= 9999000) {
                this.f58418f.setTextSize(0, l.g(this.f58417e, R.dimen.ds32));
            }
            if (this.q.getFansNum() >= 9999000) {
                this.f58420h.setTextSize(0, l.g(this.f58417e, R.dimen.ds32));
            }
            if (this.q.getLike_bars() >= 9999000) {
                this.k.setTextSize(0, l.g(this.f58417e, R.dimen.ds32));
            }
            if (this.q.getPosts_num() >= 9999000) {
                this.m.setTextSize(0, l.g(this.f58417e, R.dimen.ds32));
            }
            n(StringHelper.numFormatOverWanNa(this.q.getConcernNum()), StringHelper.numFormatOverWanNa(this.q.getFansNum()), StringHelper.numFormatOverWanNa(this.q.getPosts_num()), StringHelper.numFormatOverWanNa(this.q.getLike_bars()));
        }
    }

    public void setOnViewResponseListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.p = eVar;
        }
    }

    public void showMyFansRedTip(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (imageView = this.f58421i) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
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
        this.o = -1;
        this.u = new a(this);
        l(context);
        k();
        onChangeSkinType(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i2) {
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
        this.o = -1;
        this.u = new a(this);
        l(context);
        k();
        onChangeSkinType(0);
    }
}
