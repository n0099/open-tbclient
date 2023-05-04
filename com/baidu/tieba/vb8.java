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
import com.baidu.tieba.immessagecenter.mention.base.MessageCardBottomView;
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
public class vb8 extends kh6<qb8> {
    public static /* synthetic */ Interceptable $ic;
    public static as5<String> C;
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
    public qb8 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    @Override // com.baidu.tieba.kh6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d01cb : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb8 a;

        public a(vb8 vb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vb8Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                zb8.a(this.a.v, 13);
                if (this.a.e() != null) {
                    ji6<qb8> e = this.a.e();
                    vb8 vb8Var = this.a;
                    e.a(vb8Var.o, vb8Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235133, "Lcom/baidu/tieba/vb8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235133, "Lcom/baidu/tieba/vb8;");
                return;
            }
        }
        C = new as5<>();
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_AT_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vb8(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.n != null && u()) {
            if (z) {
                this.n.setMaxLines(5);
            } else {
                this.n.setMaxLines(2);
            }
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    @Override // com.baidu.tieba.kh6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.u != i) {
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
            g35 d = g35.d(this.k);
            d.o(R.string.J_X04);
            d.w(R.color.CAM_X0108);
            d.C(R.string.F_X01);
            d.f(R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        qb8 qb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (qb8Var = this.v) != null && this.t != null) {
            this.y = qb8Var.j();
            if (view2 != this.i && view2 != this.j) {
                if (view2 == this.q) {
                    zb8.a(this.v, 12);
                } else if (view2 == this.r.getReplyContainer()) {
                    zb8.a(this.v, 15);
                }
            } else if (this.v.r() == null) {
                return;
            } else {
                zb8.a(this.v, 14);
                String userId = this.v.r().getUserId();
                String userName = this.v.r().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getContext(), userId, userName)));
                }
            }
            if (e() != null) {
                e().a(view2, this.v);
            }
        }
    }

    public final void s(@NonNull View view2, @NonNull qb8 qb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, qb8Var) == null) {
            if (StringHelper.equals(C.a(), qb8Var.n())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View h = h();
            this.x = h;
            this.i = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f091b54);
            this.j = (TextView) this.x.findViewById(R.id.user_name);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090a90);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091bdb);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0923d5);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0905d7);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.original_thread_view);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f0905d3);
            this.s = this.x.findViewById(R.id.new_message);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f091827);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0905d8);
            ViewCommonUtil.setViewPadding(this.o, ii.g(getContext(), R.dimen.M_W_X004), ii.g(getContext(), R.dimen.M_H_X003), ii.g(getContext(), R.dimen.M_W_X004), ii.g(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6
    /* renamed from: y */
    public void i(qb8 qb8Var) {
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qb8Var) == null) && qb8Var != null && qb8Var.r() != null) {
            this.v = qb8Var;
            MetaData r = qb8Var.r();
            this.i.setVisibility(0);
            boolean z2 = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, r, 0);
            this.i.setTag(null);
            this.i.setPageId(this.t.getUniqueId());
            this.i.N(this.v.r().getAvater(), 12, false);
            this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(r), 14, StringHelper.STRING_MORE));
            if (this.v.r().getIsMyFans() == 1) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.v.getCardType() != 2 && this.v.getCardType() != 3) {
                if (this.v.getCardType() == 1) {
                    this.l.setVisibility(0);
                    if (u()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02b6));
                    } else if (x()) {
                        if (this.v.z()) {
                            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f10ce));
                        } else {
                            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f10d0));
                        }
                    }
                } else {
                    this.l.setVisibility(8);
                }
            } else {
                this.l.setVisibility(0);
                if (u()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02b5));
                } else if (x()) {
                    if (this.v.z()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f10cf));
                    } else {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f10d1));
                    }
                }
            }
            this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
            if (this.v.j() != null) {
                List<NewFloorInfo> j = this.v.j();
                this.y = j;
                if (j.size() <= 2 && this.n != null) {
                    if (this.v.j().size() > 1 && this.y.get(1) != null) {
                        this.n.setVisibility(0);
                        this.n.setOnTouchListener(new o2a(bw5.H(this.y.get(1).content)));
                        this.n.setText(bw5.H(this.y.get(1).content));
                        this.z = 2;
                    } else if (this.v.j().size() == 1) {
                        this.z = 1;
                        this.n.setVisibility(8);
                    } else if (this.v.j().size() == 0) {
                        this.z = 1;
                        this.n.setVisibility(8);
                        this.q.setVisibility(8);
                        g35 d = g35.d(this.p);
                        d.o(R.string.J_X05);
                        d.f(R.color.CAM_X0201);
                        g35 d2 = g35.d(this.o);
                        d2.o(R.string.J_X05);
                        d2.f(R.color.CAM_X0204);
                        ViewCommonUtil.setViewMargin(this.p, 0, ii.g(getContext(), R.dimen.M_H_X004), 0, ii.g(getContext(), R.dimen.M_H_X005));
                        this.p.setPadding(0, 0, 0, 0);
                        ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                    }
                    this.q.setVisibility(8);
                    g35 d3 = g35.d(this.p);
                    d3.o(R.string.J_X05);
                    d3.f(R.color.CAM_X0201);
                    g35 d4 = g35.d(this.o);
                    d4.o(R.string.J_X05);
                    d4.f(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, ii.g(getContext(), R.dimen.M_H_X004), 0, ii.g(getContext(), R.dimen.M_H_X003));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                } else {
                    if (this.y.get(2) != null && (textView = this.n) != null) {
                        textView.setVisibility(0);
                        this.n.setOnTouchListener(new o2a(bw5.H(this.y.get(2).content)));
                        this.n.setText(bw5.H(this.y.get(2).content));
                    }
                    this.z = 3;
                    this.q.setVisibility(0);
                    ViewCommonUtil.setViewMargin(this.q, ii.g(getContext(), R.dimen.M_W_X005), ii.g(getContext(), R.dimen.M_H_X004), ii.g(getContext(), R.dimen.M_W_X005), 0);
                    ViewCommonUtil.setViewMargin(this.p, 0, ii.g(getContext(), R.dimen.M_H_X004), 0, ii.g(getContext(), R.dimen.M_H_X003));
                    ViewCommonUtil.setViewMargin(this.o, ii.g(getContext(), R.dimen.M_W_X005), ii.g(getContext(), R.dimen.M_H_X004), ii.g(getContext(), R.dimen.M_W_X005), ii.g(getContext(), R.dimen.M_H_X004));
                    this.p.setPadding(0, 0, 0, 0);
                    g35 d5 = g35.d(this.p);
                    d5.o(R.string.J_X05);
                    d5.f(R.color.CAM_X0204);
                    g35 d6 = g35.d(this.o);
                    d6.o(R.string.J_X05);
                    d6.f(R.color.CAM_X0201);
                    if (this.y.get(1) != null) {
                        this.q.setOnTouchListener(new o2a(bw5.H(this.y.get(1).content)));
                        this.q.setText(bw5.H(this.y.get(1).content));
                        this.v.G(TbRichTextView.c0(this.y.get(1).content, false));
                        if (this.y.get(1).is_floor.intValue() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.q.setTag(R.id.item_data, Boolean.valueOf(z));
                    }
                }
                if (this.v.j().size() != 0 && this.y.get(0) != null) {
                    this.v.E(TbRichTextView.c0(this.y.get(0).content, false));
                    this.A = this.v.g().toString();
                }
            }
            if (this.v.j() != null && this.v.j().size() != 0) {
                this.o.setCardFrom(this.w);
                this.o.j(this.v.k(), this.A);
                this.o.setSubClickListener(this.B);
                this.r.setData(this.v.d(), (this.v.getType() == qb8.C || this.v.getType() == qb8.D || this.v.getType() == qb8.E) ? false : false);
            } else {
                this.o.j(null, "");
                this.r.setData("", (this.v.getType() == qb8.C || this.v.getType() == qb8.D || this.v.getType() == qb8.E) ? false : false);
            }
            if (x()) {
                this.r.setAgreeData(this.v, this.z);
            } else {
                this.r.getAgreeContainer().setVisibility(8);
            }
            if (this.v.y()) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            s(h(), this.v);
            j(this.t, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
