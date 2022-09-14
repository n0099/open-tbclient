package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.imMessageCenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xd7 extends v06<ud7> {
    public static /* synthetic */ Interceptable $ic;
    public static vh5<String> B;
    public transient /* synthetic */ FieldHolder $fh;
    public OriginalThreadCardView.b A;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public OriginalThreadCardView r;
    public MessageCardBottomView s;
    public View t;
    public TbPageContext u;
    public int v;
    public ud7 w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd7 a;

        public a(xd7 xd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.a.w != null && this.a.w.B() != null) {
                    StatisticItem param = new StatisticItem(this.a.w.B()).param("obj_locate", 2);
                    if (this.a.w.getType() != ud7.F && this.a.w.getType() != ud7.A) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.e() != null) {
                    v16<ud7> e = this.a.e();
                    xd7 xd7Var = this.a;
                    e.a(xd7Var.r, xd7Var.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948296606, "Lcom/baidu/tieba/xd7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948296606, "Lcom/baidu/tieba/xd7;");
                return;
            }
        }
        B = new vh5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.v = 3;
        this.A = new a(this);
        this.u = tbPageContext;
        this.y = ej.f(tbPageContext.getContext(), R.dimen.tbds42);
        this.z = ej.f(this.u.getContext(), R.dimen.tbds48);
        u();
    }

    @Override // com.baidu.tieba.v06
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a7 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.v06
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.v == i) {
            return;
        }
        this.v = i;
        h().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.k, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0107);
        OriginalThreadCardView originalThreadCardView = this.r;
        if (originalThreadCardView != null) {
            originalThreadCardView.s();
        }
        MessageCardBottomView messageCardBottomView = this.s;
        if (messageCardBottomView != null) {
            messageCardBottomView.h();
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.icon_news_red_dot);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (this.w == null && this.u == null) {
                return;
            }
            if (view2 == this.i || view2 == this.j) {
                if (this.w.A() == null) {
                    return;
                }
                String userId = this.w.A().getUserId();
                String userName = this.w.A().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.u.getContext(), userId, userName)));
                }
            }
            if (e() != null) {
                e().a(view2, this.w);
            }
        }
    }

    public final CharSequence s(TextView textView, SpannableString spannableString) {
        InterceptResult invokeLL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, textView, spannableString)) == null) {
            if (textView == null || spannableString == null || (tbPageContext = this.u) == null) {
                return null;
            }
            return TextUtils.ellipsize(spannableString, textView.getPaint(), ((ej.k(tbPageContext.getPageActivity()) - (this.u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void t(@NonNull View view2, @NonNull ud7 ud7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, ud7Var) == null) {
            if (StringHelper.equals(B.a(), ud7Var.t())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View h = h();
            this.i = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f0919bc);
            this.j = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0924b4);
            this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09099b);
            this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091a3f);
            this.m = h.findViewById(R.id.obfuscated_res_0x7f090801);
            this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0921e5);
            this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090563);
            this.p = h.findViewById(R.id.obfuscated_res_0x7f090560);
            this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090562);
            this.r = (OriginalThreadCardView) h.findViewById(R.id.obfuscated_res_0x7f091766);
            this.s = (MessageCardBottomView) h.findViewById(R.id.obfuscated_res_0x7f09055f);
            this.t = h.findViewById(R.id.obfuscated_res_0x7f09168d);
            this.r.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.s.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v06
    /* renamed from: v */
    public void i(ud7 ud7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ud7Var) == null) || ud7Var == null || ud7Var.A() == null) {
            return;
        }
        this.w = ud7Var;
        MetaData A = ud7Var.A();
        this.i.setVisibility(0);
        boolean z = true;
        this.i.setPlaceHolder(1);
        this.i.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.i, A, 0);
        this.i.setTag(null);
        this.i.setPageId(this.u.getUniqueId());
        this.i.K(ud7Var.A().getAvater(), 12, false);
        this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(A), 14, StringHelper.STRING_MORE));
        if (ud7Var.A().getIsMyFans() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (!dj.isEmpty(ud7Var.s())) {
            this.m.setVisibility(0);
            this.l.setVisibility(0);
            this.l.setText(ud7Var.s());
        } else {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.n.setText(StringHelper.getFormatTime(ud7Var.getTime()));
        TextView textView = this.o;
        TbFaceManager i = TbFaceManager.i();
        Context applicationContext = this.u.getPageActivity().getApplicationContext();
        String title = ud7Var.getTitle();
        int i2 = this.z;
        textView.setText(s(textView, i.s(applicationContext, title, i2, i2)));
        if (dj.isEmpty(ud7Var.getSubTitle())) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            TextView textView2 = this.q;
            TbFaceManager i3 = TbFaceManager.i();
            Context applicationContext2 = this.u.getPageActivity().getApplicationContext();
            String subTitle = ud7Var.getSubTitle();
            int i4 = this.y;
            textView2.setText(s(textView2, i3.s(applicationContext2, subTitle, i4, i4)));
            this.q.setVisibility(0);
            this.p.setVisibility(0);
        }
        this.r.setCardFrom(this.x);
        this.r.i(ud7Var.r());
        this.r.setSubClickListener(this.A);
        this.s.setData(ud7Var.c(), (ud7Var.getType() == ud7.A || ud7Var.getType() == ud7.B || ud7Var.getType() == ud7.C) ? false : false);
        if (ud7Var.E()) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        t(h(), ud7Var);
        j(this.u, TbadkCoreApplication.getInst().getSkinType());
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.x = str;
        }
    }
}
