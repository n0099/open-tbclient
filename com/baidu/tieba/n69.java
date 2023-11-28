package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.immessagecenter.mention.base.MessageCardBottomView;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes7.dex */
public class n69 extends jl6<i69> {
    public static /* synthetic */ Interceptable $ic;
    public static ou5<String> C;
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
    public i69 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    @Override // com.baidu.tieba.jl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ed : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n69 a;

        public a(n69 n69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n69Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                c79.a(this.a.v, 13);
                if (this.a.f() != null) {
                    im6<i69> f = this.a.f();
                    n69 n69Var = this.a;
                    f.a(n69Var.o, n69Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947954552, "Lcom/baidu/tieba/n69;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947954552, "Lcom/baidu/tieba/n69;");
                return;
            }
        }
        C = new ou5<>();
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_AT_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n69(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        s();
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.w = str;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.n != null && y()) {
            if (z) {
                this.n.setMaxLines(5);
            } else {
                this.n.setMaxLines(2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jl6
    /* renamed from: A */
    public void j(i69 i69Var) {
        int i;
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, i69Var) == null) && i69Var != null && i69Var.s() != null) {
            this.v = i69Var;
            MetaData s = i69Var.s();
            this.i.setVisibility(0);
            boolean z2 = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, s, 0);
            this.i.setTag(null);
            this.i.setPageId(this.t.getUniqueId());
            zx9.a(this.i, this.v.s().getAvatarUrl(), this.v.s().getAvater(), 12);
            this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(s), 14, "..."));
            if (this.v.s().getIsMyFans() == 1) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.v.getCardType() != 2 && this.v.getCardType() != 3) {
                if (this.v.getCardType() == 1) {
                    this.l.setVisibility(0);
                    if (y()) {
                        this.l.setText(c().getString(R.string.obfuscated_res_0x7f0f02f3));
                    } else if (z()) {
                        if (this.v.A()) {
                            this.l.setText(c().getString(R.string.obfuscated_res_0x7f0f1276));
                        } else {
                            this.l.setText(c().getString(R.string.obfuscated_res_0x7f0f1278));
                        }
                    }
                } else {
                    this.l.setVisibility(8);
                }
            } else {
                this.l.setVisibility(0);
                if (y()) {
                    if (this.v.y()) {
                        i = R.string.obfuscated_res_0x7f0f02f1;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f02f2;
                    }
                    this.l.setText(c().getString(i));
                } else if (z()) {
                    if (this.v.A()) {
                        this.l.setText(c().getString(R.string.obfuscated_res_0x7f0f1277));
                    } else {
                        this.l.setText(c().getString(R.string.obfuscated_res_0x7f0f1279));
                    }
                }
            }
            this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
            if (this.v.k() != null) {
                List<NewFloorInfo> k = this.v.k();
                this.y = k;
                if (k.size() <= 2 && this.n != null) {
                    if (this.v.k().size() > 1 && this.y.get(1) != null) {
                        this.n.setVisibility(0);
                        this.n.setOnTouchListener(new dab(py5.I(this.y.get(1).content)));
                        this.n.setText(py5.I(this.y.get(1).content));
                        this.z = 2;
                    } else if (this.v.k().size() == 1) {
                        this.z = 1;
                        this.n.setVisibility(8);
                    } else if (this.v.k().size() == 0) {
                        this.z = 1;
                        this.n.setVisibility(8);
                        this.q.setVisibility(8);
                        EMManager.from(this.p).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
                        EMManager.from(this.o).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
                        ViewCommonUtil.setViewMargin(this.p, 0, BdUtilHelper.getDimens(c(), R.dimen.M_H_X004), 0, BdUtilHelper.getDimens(c(), R.dimen.M_H_X005));
                        this.p.setPadding(0, 0, 0, 0);
                        ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                    }
                    this.q.setVisibility(8);
                    EMManager.from(this.p).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
                    EMManager.from(this.o).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, BdUtilHelper.getDimens(c(), R.dimen.M_H_X004), 0, BdUtilHelper.getDimens(c(), R.dimen.M_H_X003));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                } else {
                    if (this.y.get(2) != null && (textView = this.n) != null) {
                        textView.setVisibility(0);
                        this.n.setOnTouchListener(new dab(py5.I(this.y.get(2).content)));
                        this.n.setText(py5.I(this.y.get(2).content));
                    }
                    this.z = 3;
                    this.q.setVisibility(0);
                    ViewCommonUtil.setViewMargin(this.q, BdUtilHelper.getDimens(c(), R.dimen.M_W_X005), BdUtilHelper.getDimens(c(), R.dimen.M_H_X004), BdUtilHelper.getDimens(c(), R.dimen.M_W_X005), 0);
                    ViewCommonUtil.setViewMargin(this.p, 0, BdUtilHelper.getDimens(c(), R.dimen.M_H_X004), 0, BdUtilHelper.getDimens(c(), R.dimen.M_H_X003));
                    ViewCommonUtil.setViewMargin(this.o, BdUtilHelper.getDimens(c(), R.dimen.M_W_X005), BdUtilHelper.getDimens(c(), R.dimen.M_H_X004), BdUtilHelper.getDimens(c(), R.dimen.M_W_X005), BdUtilHelper.getDimens(c(), R.dimen.M_H_X004));
                    this.p.setPadding(0, 0, 0, 0);
                    EMManager.from(this.p).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
                    EMManager.from(this.o).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
                    if (this.y.get(1) != null) {
                        this.q.setOnTouchListener(new dab(py5.I(this.y.get(1).content)));
                        this.q.setText(py5.I(this.y.get(1).content));
                        this.v.G(TbRichTextView.c0(this.y.get(1).content, false));
                        if (this.y.get(1).is_floor.intValue() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.q.setTag(R.id.item_data, Boolean.valueOf(z));
                    }
                }
                if (this.v.k().size() != 0 && this.y.get(0) != null) {
                    this.v.F(TbRichTextView.c0(this.y.get(0).content, false));
                    this.A = this.v.g().toString();
                }
            }
            if (this.v.k() != null && this.v.k().size() != 0) {
                this.o.setCardFrom(this.w);
                this.o.j(this.v.l(), this.A);
                this.o.setSubClickListener(this.B);
                this.r.setData(this.v.d(), (this.v.getType() == i69.D || this.v.getType() == i69.E || this.v.getType() == i69.F) ? false : false);
            } else {
                this.o.j(null, "");
                this.r.setData("", (this.v.getType() == i69.D || this.v.getType() == i69.E || this.v.getType() == i69.F) ? false : false);
            }
            if (z()) {
                this.r.setAgreeData(this.v, this.z);
            } else {
                this.r.getAgreeContainer().setVisibility(8);
            }
            if (this.v.z()) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            r(i(), this.v);
            k(this.t, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.jl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && this.u != i) {
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
            EMManager.from(this.k).setCorner(R.string.J_X04).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01).setBackGroundColor(R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        i69 i69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && (i69Var = this.v) != null && this.t != null) {
            this.y = i69Var.k();
            if (view2 != this.i && view2 != this.j) {
                if (view2 == this.q) {
                    c79.a(this.v, 12);
                } else if (view2 == this.r.getReplyContainer()) {
                    c79.a(this.v, 15);
                }
            } else if (this.v.s() == null) {
                return;
            } else {
                c79.a(this.v, 14);
                String userId = this.v.s().getUserId();
                String targetScheme = this.v.s().getTargetScheme();
                String userName = this.v.s().getUserName();
                if (ay9.a(targetScheme)) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + targetScheme);
                } else if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getContext(), userId, userName)));
                }
            }
            if (f() != null) {
                f().a(view2, this.v);
            }
        }
    }

    public final void r(@NonNull View view2, @NonNull i69 i69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, i69Var) == null) {
            if (StringHelper.equals(C.a(), i69Var.o())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View i = i();
            this.x = i;
            this.i = (HeadImageView) i.findViewById(R.id.obfuscated_res_0x7f091d56);
            this.j = (TextView) this.x.findViewById(R.id.user_name);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090b41);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091dec);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09264c);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09065a);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.original_thread_view);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f090656);
            this.s = this.x.findViewById(R.id.new_message);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f091a21);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f09065b);
            ViewCommonUtil.setViewPadding(this.o, BdUtilHelper.getDimens(c(), R.dimen.M_W_X004), BdUtilHelper.getDimens(c(), R.dimen.M_H_X003), BdUtilHelper.getDimens(c(), R.dimen.M_W_X004), BdUtilHelper.getDimens(c(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }
}
