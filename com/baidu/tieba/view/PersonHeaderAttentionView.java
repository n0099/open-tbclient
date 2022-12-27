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
import com.baidu.tieba.qe6;
import com.baidu.tieba.r49;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public int k;
    public r49 l;
    public UserData m;
    public View n;
    public View o;
    public View p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qe6 a;
        public final /* synthetic */ PersonHeaderAttentionView b;

        public a(PersonHeaderAttentionView personHeaderAttentionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personHeaderAttentionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personHeaderAttentionView;
            this.a = new qe6();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.m == null || view2 == null || !ViewHelper.checkUpIsLogin(this.b.a)) {
                return;
            }
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.b.m.getUserId());
            if (this.b.m.getIsFriend() == 1) {
                z = true;
            } else {
                z = false;
            }
            int id = view2.getId();
            if (id != this.b.b.getId() && id != this.b.c.getId()) {
                if (id != this.b.d.getId() && id != this.b.f.getId()) {
                    if (id == this.b.g.getId() || id == this.b.h.getId()) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
                        if (this.b.m.getPersonPrivate() == null) {
                            PersonHeaderAttentionView personHeaderAttentionView = this.b;
                            personHeaderAttentionView.n(personHeaderAttentionView.m.getSex());
                            return;
                        } else if (this.b.m.getPersonPrivate().G() != 1 && !equals && (!z || this.b.m.getPersonPrivate().G() != 2)) {
                            PersonHeaderAttentionView personHeaderAttentionView2 = this.b;
                            personHeaderAttentionView2.n(personHeaderAttentionView2.m.getSex());
                            return;
                        } else {
                            this.a.a = 7;
                        }
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
                    this.a.a = 5;
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
                this.a.a = 4;
            }
            if (this.b.l == null) {
                return;
            }
            this.a.b = new Bundle();
            this.a.b.putSerializable(UserData.TYPE_USER, this.b.m);
            this.b.l.a(view2, this.a);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = -1;
        this.q = new a(this);
        l(context);
        k();
        m(0);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.k == i) {
            return;
        }
        this.k = i;
        SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.c, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.d, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(this.e, R.drawable.icon_news_down_bar_one);
        SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
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
        this.k = -1;
        this.q = new a(this);
        l(context);
        k();
        m(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
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
        this.k = -1;
        this.q = new a(this);
        l(context);
        k();
        m(0);
    }

    public void setOnViewResponseListener(r49 r49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, r49Var) == null) {
            this.l = r49Var;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setOnClickListener(this.q);
            this.f.setOnClickListener(this.q);
            this.b.setOnClickListener(this.q);
            this.c.setOnClickListener(this.q);
            this.g.setOnClickListener(this.q);
            this.h.setOnClickListener(this.q);
            this.i.setOnClickListener(this.q);
            this.j.setOnClickListener(this.q);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            setOrientation(0);
            setGravity(16);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0412, (ViewGroup) this, true);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0919fa);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0919f7);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919fb);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0919f2);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0919ef);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0919f5);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0919f4);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091a08);
            this.i = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a07);
            this.j = textView2;
            textView2.setVisibility(8);
            this.n = findViewById(R.id.obfuscated_res_0x7f09083e);
            this.o = findViewById(R.id.obfuscated_res_0x7f09083c);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09083d);
            this.p = findViewById;
            findViewById.setVisibility(8);
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Context context = this.a;
            BdToast b = BdToast.b(context, String.format(context.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i)));
            b.f(BdToast.ToastIcon.FAILURE);
            b.i();
        }
    }

    public final void o(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) {
            this.b.setText(str);
            this.d.setText(str2);
            this.g.setText(str4);
            this.i.setText(str3);
        }
    }

    public void setData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, userData) == null) {
            this.m = userData;
            if (userData.getConcernNum() >= 9999000) {
                this.b.setTextSize(0, yi.g(this.a, R.dimen.obfuscated_res_0x7f070207));
            }
            if (this.m.getFansNum() >= 9999000) {
                this.d.setTextSize(0, yi.g(this.a, R.dimen.obfuscated_res_0x7f070207));
            }
            if (this.m.getLike_bars() >= 9999000) {
                this.g.setTextSize(0, yi.g(this.a, R.dimen.obfuscated_res_0x7f070207));
            }
            if (this.m.getPosts_num() >= 9999000) {
                this.i.setTextSize(0, yi.g(this.a, R.dimen.obfuscated_res_0x7f070207));
            }
            o(StringHelper.numFormatOverWanNa(this.m.getConcernNum()), StringHelper.numFormatOverWanNa(this.m.getFansNum()), StringHelper.numFormatOverWanNa(this.m.getPosts_num()), StringHelper.numFormatOverWanNa(this.m.getLike_bars()));
        }
    }
}
