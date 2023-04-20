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
import com.baidu.tieba.immessagecenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p98 extends zf6<m98> {
    public static /* synthetic */ Interceptable $ic;
    public static ir5<String> B;
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
    public m98 w;
    public String x;
    public int y;
    public int z;

    @Override // com.baidu.tieba.zf6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b7 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p98 a;

        public a(p98 p98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p98Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.a.w != null && this.a.w.v() != null) {
                    StatisticItem param = new StatisticItem(this.a.w.v()).param("obj_locate", 2);
                    if (this.a.w.getType() != m98.H && this.a.w.getType() != m98.C) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.e() != null) {
                    yg6<m98> e = this.a.e();
                    p98 p98Var = this.a;
                    e.a(p98Var.r, p98Var.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016986, "Lcom/baidu/tieba/p98;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016986, "Lcom/baidu/tieba/p98;");
                return;
            }
        }
        B = new ir5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p98(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.y = ii.g(tbPageContext.getContext(), R.dimen.tbds42);
        this.z = ii.g(this.u.getContext(), R.dimen.tbds48);
        u();
    }

    @Override // com.baidu.tieba.zf6
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.v != i) {
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
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.x = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (this.w == null && this.u == null) {
                return;
            }
            if (view2 == this.i || view2 == this.j) {
                if (this.w.u() == null) {
                    return;
                }
                String userId = this.w.u().getUserId();
                String userName = this.w.u().getUserName();
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
            if (textView != null && spannableString != null && (tbPageContext = this.u) != null) {
                return TextUtils.ellipsize(spannableString, textView.getPaint(), ((ii.l(tbPageContext.getPageActivity()) - (this.u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
            }
            return null;
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void t(@NonNull View view2, @NonNull m98 m98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, m98Var) == null) {
            if (StringHelper.equals(B.a(), m98Var.o())) {
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
            this.i = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f091b45);
            this.j = (TextView) h.findViewById(R.id.user_name);
            this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090a8a);
            this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091bcb);
            this.m = h.findViewById(R.id.obfuscated_res_0x7f0908b8);
            this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0923bd);
            this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0905d4);
            this.p = h.findViewById(R.id.obfuscated_res_0x7f0905d1);
            this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0905d3);
            this.r = (OriginalThreadCardView) h.findViewById(R.id.original_thread_view);
            this.s = (MessageCardBottomView) h.findViewById(R.id.obfuscated_res_0x7f0905d0);
            this.t = h.findViewById(R.id.new_message);
            this.r.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.s.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zf6
    /* renamed from: x */
    public void l(m98 m98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, m98Var) == null) && m98Var != null && m98Var.u() != null) {
            this.w = m98Var;
            MetaData u = m98Var.u();
            this.i.setVisibility(0);
            boolean z = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, u, 0);
            this.i.setTag(null);
            this.i.setPageId(this.u.getUniqueId());
            this.i.N(m98Var.u().getAvater(), 12, false);
            this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(u), 14, StringHelper.STRING_MORE));
            if (m98Var.u().getIsMyFans() == 1) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (!hi.isEmpty(m98Var.m())) {
                this.m.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setText(m98Var.m());
            } else {
                this.m.setVisibility(8);
                this.l.setVisibility(8);
            }
            this.n.setText(StringHelper.getFormatTime(m98Var.getTime()));
            TextView textView = this.o;
            TbFaceManager i = TbFaceManager.i();
            Context applicationContext = this.u.getPageActivity().getApplicationContext();
            String title = m98Var.getTitle();
            int i2 = this.z;
            textView.setText(s(textView, i.s(applicationContext, title, i2, i2)));
            if (hi.isEmpty(m98Var.getSubTitle())) {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
            } else {
                TextView textView2 = this.q;
                TbFaceManager i3 = TbFaceManager.i();
                Context applicationContext2 = this.u.getPageActivity().getApplicationContext();
                String subTitle = m98Var.getSubTitle();
                int i4 = this.y;
                textView2.setText(s(textView2, i3.s(applicationContext2, subTitle, i4, i4)));
                this.q.setVisibility(0);
                this.p.setVisibility(0);
            }
            this.r.setCardFrom(this.x);
            this.r.i(m98Var.l());
            this.r.setSubClickListener(this.A);
            this.s.setData(m98Var.d(), (m98Var.getType() == m98.C || m98Var.getType() == m98.D || m98Var.getType() == m98.E) ? false : false);
            if (m98Var.y()) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
            t(h(), m98Var);
            m(this.u, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
