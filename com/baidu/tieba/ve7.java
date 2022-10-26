package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
/* loaded from: classes6.dex */
public class ve7 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public static ni5 C;
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
    public qe7 v;
    public String w;
    public View x;
    public List y;
    public int z;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b7 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve7 a;

        public a(ve7 ve7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                ze7.a(this.a.v, 13);
                if (this.a.e() != null) {
                    p26 e = this.a.e();
                    ve7 ve7Var = this.a;
                    e.a(ve7Var.o, ve7Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948237985, "Lcom/baidu/tieba/ve7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948237985, "Lcom/baidu/tieba/ve7;");
                return;
            }
        }
        C = new ni5();
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
    public ve7(TbPageContext tbPageContext, ViewGroup viewGroup) {
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

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
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
            nv4 d = nv4.d(this.k);
            d.n(R.string.J_X04);
            d.v(R.color.CAM_X0108);
            d.A(R.string.F_X01);
            d.f(R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        qe7 qe7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (qe7Var = this.v) != null && this.t != null) {
            this.y = qe7Var.n();
            if (view2 != this.i && view2 != this.j) {
                if (view2 == this.q) {
                    ze7.a(this.v, 12);
                } else if (view2 == this.r.getReplyContainer()) {
                    ze7.a(this.v, 15);
                }
            } else if (this.v.A() == null) {
                return;
            } else {
                ze7.a(this.v, 14);
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

    public final void s(View view2, qe7 qe7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, qe7Var) == null) {
            if (StringHelper.equals((String) C.a(), qe7Var.t())) {
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
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f0919ba);
            this.j = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0924a1);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0909a5);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091a3d);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0921d2);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09056c);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.obfuscated_res_0x7f091758);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f090568);
            this.s = this.x.findViewById(R.id.obfuscated_res_0x7f09167f);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f091680);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09056d);
            ViewCommonUtil.setViewPadding(this.o, fj.f(getContext(), R.dimen.M_W_X004), fj.f(getContext(), R.dimen.M_H_X003), fj.f(getContext(), R.dimen.M_W_X004), fj.f(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: w */
    public void l(qe7 qe7Var) {
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qe7Var) == null) && qe7Var != null && qe7Var.A() != null) {
            this.v = qe7Var;
            MetaData A = qe7Var.A();
            this.i.setVisibility(0);
            boolean z2 = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, A, 0);
            this.i.setTag(null);
            this.i.setPageId(this.t.getUniqueId());
            this.i.L(this.v.A().getAvater(), 12, false);
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
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02af));
                    } else if (v()) {
                        if (this.v.F()) {
                            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f100a));
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
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02ae));
                } else if (v()) {
                    if (this.v.F()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f100b));
                    } else {
                        this.l.setText(getContext().getString(R.string.replay_my_thread));
                    }
                }
            }
            this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
            if (this.v.n() != null) {
                List n = this.v.n();
                this.y = n;
                if (n.size() <= 2 && this.n != null) {
                    if (this.v.n().size() > 1 && this.y.get(1) != null) {
                        this.n.setVisibility(0);
                        this.n.setOnTouchListener(new pz8(ol5.E(((NewFloorInfo) this.y.get(1)).content)));
                        this.n.setText(ol5.E(((NewFloorInfo) this.y.get(1)).content));
                        this.z = 2;
                    } else if (this.v.n().size() == 1) {
                        this.z = 1;
                        this.n.setVisibility(8);
                    } else if (this.v.n().size() == 0) {
                        this.z = 1;
                        this.n.setVisibility(8);
                        this.q.setVisibility(8);
                        nv4 d = nv4.d(this.p);
                        d.n(R.string.J_X05);
                        d.f(R.color.CAM_X0201);
                        nv4 d2 = nv4.d(this.o);
                        d2.n(R.string.J_X05);
                        d2.f(R.color.CAM_X0204);
                        ViewCommonUtil.setViewMargin(this.p, 0, fj.f(getContext(), R.dimen.M_H_X004), 0, fj.f(getContext(), R.dimen.M_H_X005));
                        this.p.setPadding(0, 0, 0, 0);
                        ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                    }
                    this.q.setVisibility(8);
                    nv4 d3 = nv4.d(this.p);
                    d3.n(R.string.J_X05);
                    d3.f(R.color.CAM_X0201);
                    nv4 d4 = nv4.d(this.o);
                    d4.n(R.string.J_X05);
                    d4.f(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, fj.f(getContext(), R.dimen.M_H_X004), 0, fj.f(getContext(), R.dimen.M_H_X003));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                } else {
                    if (this.y.get(2) != null && (textView = this.n) != null) {
                        textView.setVisibility(0);
                        this.n.setOnTouchListener(new pz8(ol5.E(((NewFloorInfo) this.y.get(2)).content)));
                        this.n.setText(ol5.E(((NewFloorInfo) this.y.get(2)).content));
                    }
                    this.z = 3;
                    this.q.setVisibility(0);
                    ViewCommonUtil.setViewMargin(this.q, fj.f(getContext(), R.dimen.M_W_X005), fj.f(getContext(), R.dimen.M_H_X004), fj.f(getContext(), R.dimen.M_W_X005), 0);
                    ViewCommonUtil.setViewMargin(this.p, 0, fj.f(getContext(), R.dimen.M_H_X004), 0, fj.f(getContext(), R.dimen.M_H_X003));
                    ViewCommonUtil.setViewMargin(this.o, fj.f(getContext(), R.dimen.M_W_X005), fj.f(getContext(), R.dimen.M_H_X004), fj.f(getContext(), R.dimen.M_W_X005), fj.f(getContext(), R.dimen.M_H_X004));
                    this.p.setPadding(0, 0, 0, 0);
                    nv4 d5 = nv4.d(this.p);
                    d5.n(R.string.J_X05);
                    d5.f(R.color.CAM_X0204);
                    nv4 d6 = nv4.d(this.o);
                    d6.n(R.string.J_X05);
                    d6.f(R.color.CAM_X0201);
                    if (this.y.get(1) != null) {
                        this.q.setOnTouchListener(new pz8(ol5.E(((NewFloorInfo) this.y.get(1)).content)));
                        this.q.setText(ol5.E(((NewFloorInfo) this.y.get(1)).content));
                        this.v.L(TbRichTextView.X(((NewFloorInfo) this.y.get(1)).content, false));
                        if (((NewFloorInfo) this.y.get(1)).is_floor.intValue() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.q.setTag(R.id.obfuscated_res_0x7f090f8c, Boolean.valueOf(z));
                    }
                }
                if (this.v.n().size() != 0 && this.y.get(0) != null) {
                    this.v.K(TbRichTextView.X(((NewFloorInfo) this.y.get(0)).content, false));
                    this.A = this.v.j().toString();
                }
            }
            if (this.v.n() != null && this.v.n().size() != 0) {
                this.o.setCardFrom(this.w);
                this.o.j(this.v.r(), this.A);
                this.o.setSubClickListener(this.B);
                this.r.setData(this.v.c(), (this.v.getType() == qe7.A || this.v.getType() == qe7.B || this.v.getType() == qe7.C) ? false : false);
            } else {
                this.o.j(null, "");
                this.r.setData("", (this.v.getType() == qe7.A || this.v.getType() == qe7.B || this.v.getType() == qe7.C) ? false : false);
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
