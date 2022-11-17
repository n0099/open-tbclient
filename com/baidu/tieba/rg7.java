package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.imMessageCenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes5.dex */
public class rg7 extends m36<mg7> {
    public static /* synthetic */ Interceptable $ic;
    public static tj5<String> C;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public OriginalThreadCardView.b B;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public OriginalThreadCardView o;
    public LinearLayout p;
    public TextView q;
    public MessageCardBottomView r;
    public View s;
    public TbPageContext t;
    public int u;
    public mg7 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    @Override // com.baidu.tieba.m36
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b9 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg7 a;

        public a(rg7 rg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                vg7.a(this.a.v, 13);
                if (this.a.e() != null) {
                    m46<mg7> e = this.a.e();
                    rg7 rg7Var = this.a;
                    e.a(rg7Var.o, rg7Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948120743, "Lcom/baidu/tieba/rg7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948120743, "Lcom/baidu/tieba/rg7;");
                return;
            }
        }
        C = new tj5<>();
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_AT_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rg7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.A = null;
        this.B = new a(this);
        this.t = tbPageContext;
        t();
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.w = str;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.n != null && u()) {
            if (z) {
                this.n.setMaxLines(5);
            } else {
                this.n.setMaxLines(2);
            }
        }
    }

    @Override // com.baidu.tieba.m36
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.u != i) {
            this.u = i;
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            OriginalThreadCardView originalThreadCardView = this.o;
            if (originalThreadCardView != null) {
                if (this.z == 3) {
                    originalThreadCardView.t(R.color.CAM_X0201, R.color.CAM_X0107, R.color.CAM_X0107);
                } else {
                    originalThreadCardView.t(R.color.CAM_X0204, R.color.CAM_X0107, R.color.CAM_X0107);
                }
            }
            MessageCardBottomView messageCardBottomView = this.r;
            if (messageCardBottomView != null) {
                messageCardBottomView.h();
            }
            SkinManager.setBackgroundResource(this.s, R.drawable.icon_news_red_dot);
            qw4 d = qw4.d(this.k);
            d.n(R.string.J_X04);
            d.v(R.color.CAM_X0108);
            d.A(R.string.F_X01);
            d.f(R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        mg7 mg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (mg7Var = this.v) != null && this.t != null) {
            this.y = mg7Var.n();
            if (view2 != this.i && view2 != this.j) {
                if (view2 == this.q) {
                    vg7.a(this.v, 12);
                } else if (view2 == this.r.getReplyContainer()) {
                    vg7.a(this.v, 15);
                }
            } else if (this.v.A() == null) {
                return;
            } else {
                vg7.a(this.v, 14);
                String userId = this.v.A().getUserId();
                String userName = this.v.A().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getContext(), userId, userName)));
                }
            }
            if (e() != null) {
                e().a(view2, this.v);
            }
        }
    }

    public final void s(@NonNull View view2, @NonNull mg7 mg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, mg7Var) == null) {
            if (StringHelper.equals(C.a(), mg7Var.t())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View k = k();
            this.x = k;
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f091a07);
            this.j = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f092505);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0909b6);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091a8b);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f092232);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09057a);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.obfuscated_res_0x7f0917a0);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f090576);
            this.s = this.x.findViewById(R.id.obfuscated_res_0x7f0916c5);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f0916c6);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09057b);
            ViewCommonUtil.setViewPadding(this.o, yi.g(getContext(), R.dimen.M_W_X004), yi.g(getContext(), R.dimen.M_H_X003), yi.g(getContext(), R.dimen.M_W_X004), yi.g(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m36
    /* renamed from: w */
    public void l(mg7 mg7Var) {
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mg7Var) == null) && mg7Var != null && mg7Var.A() != null) {
            this.v = mg7Var;
            MetaData A = mg7Var.A();
            this.i.setVisibility(0);
            boolean z2 = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, A, 0);
            this.i.setTag(null);
            this.i.setPageId(this.t.getUniqueId());
            this.i.K(this.v.A().getAvater(), 12, false);
            this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(A), 14, StringHelper.STRING_MORE));
            if (this.v.A().getIsMyFans() == 1) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.v.getCardType() != 2 && this.v.getCardType() != 3) {
                if (this.v.getCardType() == 1) {
                    this.l.setVisibility(0);
                    if (u()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02b0));
                    } else if (v()) {
                        if (this.v.F()) {
                            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f102b));
                        } else {
                            this.l.setText(getContext().getString(R.string.replay_my_theme));
                        }
                    }
                } else {
                    this.l.setVisibility(8);
                }
            } else {
                this.l.setVisibility(0);
                if (u()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02af));
                } else if (v()) {
                    if (this.v.F()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f102c));
                    } else {
                        this.l.setText(getContext().getString(R.string.replay_my_thread));
                    }
                }
            }
            this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
            if (this.v.n() != null) {
                List<NewFloorInfo> n = this.v.n();
                this.y = n;
                if (n.size() <= 2 && this.n != null) {
                    if (this.v.n().size() > 1 && this.y.get(1) != null) {
                        this.n.setVisibility(0);
                        this.n.setOnTouchListener(new k19(xm5.E(this.y.get(1).content)));
                        this.n.setText(xm5.E(this.y.get(1).content));
                        this.z = 2;
                    } else if (this.v.n().size() == 1) {
                        this.z = 1;
                        this.n.setVisibility(8);
                    } else if (this.v.n().size() == 0) {
                        this.z = 1;
                        this.n.setVisibility(8);
                        this.q.setVisibility(8);
                        qw4 d = qw4.d(this.p);
                        d.n(R.string.J_X05);
                        d.f(R.color.CAM_X0201);
                        qw4 d2 = qw4.d(this.o);
                        d2.n(R.string.J_X05);
                        d2.f(R.color.CAM_X0204);
                        ViewCommonUtil.setViewMargin(this.p, 0, yi.g(getContext(), R.dimen.M_H_X004), 0, yi.g(getContext(), R.dimen.M_H_X005));
                        this.p.setPadding(0, 0, 0, 0);
                        ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                    }
                    this.q.setVisibility(8);
                    qw4 d3 = qw4.d(this.p);
                    d3.n(R.string.J_X05);
                    d3.f(R.color.CAM_X0201);
                    qw4 d4 = qw4.d(this.o);
                    d4.n(R.string.J_X05);
                    d4.f(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, yi.g(getContext(), R.dimen.M_H_X004), 0, yi.g(getContext(), R.dimen.M_H_X003));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                } else {
                    if (this.y.get(2) != null && (textView = this.n) != null) {
                        textView.setVisibility(0);
                        this.n.setOnTouchListener(new k19(xm5.E(this.y.get(2).content)));
                        this.n.setText(xm5.E(this.y.get(2).content));
                    }
                    this.z = 3;
                    this.q.setVisibility(0);
                    ViewCommonUtil.setViewMargin(this.q, yi.g(getContext(), R.dimen.M_W_X005), yi.g(getContext(), R.dimen.M_H_X004), yi.g(getContext(), R.dimen.M_W_X005), 0);
                    ViewCommonUtil.setViewMargin(this.p, 0, yi.g(getContext(), R.dimen.M_H_X004), 0, yi.g(getContext(), R.dimen.M_H_X003));
                    ViewCommonUtil.setViewMargin(this.o, yi.g(getContext(), R.dimen.M_W_X005), yi.g(getContext(), R.dimen.M_H_X004), yi.g(getContext(), R.dimen.M_W_X005), yi.g(getContext(), R.dimen.M_H_X004));
                    this.p.setPadding(0, 0, 0, 0);
                    qw4 d5 = qw4.d(this.p);
                    d5.n(R.string.J_X05);
                    d5.f(R.color.CAM_X0204);
                    qw4 d6 = qw4.d(this.o);
                    d6.n(R.string.J_X05);
                    d6.f(R.color.CAM_X0201);
                    if (this.y.get(1) != null) {
                        this.q.setOnTouchListener(new k19(xm5.E(this.y.get(1).content)));
                        this.q.setText(xm5.E(this.y.get(1).content));
                        this.v.L(TbRichTextView.X(this.y.get(1).content, false));
                        if (this.y.get(1).is_floor.intValue() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.q.setTag(R.id.obfuscated_res_0x7f090fc9, Boolean.valueOf(z));
                    }
                }
                if (this.v.n().size() != 0 && this.y.get(0) != null) {
                    this.v.K(TbRichTextView.X(this.y.get(0).content, false));
                    this.A = this.v.j().toString();
                }
            }
            if (this.v.n() != null && this.v.n().size() != 0) {
                this.o.setCardFrom(this.w);
                this.o.j(this.v.r(), this.A);
                this.o.setSubClickListener(this.B);
                this.r.setData(this.v.c(), (this.v.getType() == mg7.A || this.v.getType() == mg7.B || this.v.getType() == mg7.C) ? false : false);
            } else {
                this.o.j(null, "");
                this.r.setData("", (this.v.getType() == mg7.A || this.v.getType() == mg7.B || this.v.getType() == mg7.C) ? false : false);
            }
            if (v()) {
                this.r.setAgreeData(this.v, this.z);
            } else {
                this.r.getAgreeContainer().setVisibility(8);
            }
            if (this.v.E()) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            s(k(), this.v);
            m(this.t, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
