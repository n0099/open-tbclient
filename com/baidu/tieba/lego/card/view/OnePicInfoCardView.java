package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bh7;
import com.baidu.tieba.dg7;
import com.baidu.tieba.ge5;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
import com.baidu.tieba.lo8;
import com.baidu.tieba.rg7;
import com.baidu.tieba.yg7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup m;
    public TbImageView n;
    public LineCountNotifyTextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public TbImageView s;
    public TextView t;
    public LinearLayout u;
    public TbImageView v;
    public TextView w;
    public int x;
    public int y;

    /* loaded from: classes4.dex */
    public class a implements LineCountNotifyTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OnePicInfoCard a;
        public final /* synthetic */ OnePicInfoCardView b;

        public a(OnePicInfoCardView onePicInfoCardView, OnePicInfoCard onePicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onePicInfoCardView, onePicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = onePicInfoCardView;
            this.a = onePicInfoCard;
        }

        @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int lineCount = this.b.o.getLineCount();
                if (this.b.y != lineCount) {
                    if (lineCount == 1) {
                        this.b.p.setMaxLines(2);
                    } else {
                        this.b.p.setMaxLines(1);
                    }
                }
                this.b.y = lineCount;
                this.b.p.setText(this.a.getDesc());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OnePicInfoCard a;
        public final /* synthetic */ OnePicInfoCardView b;

        public b(OnePicInfoCardView onePicInfoCardView, OnePicInfoCard onePicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onePicInfoCardView, onePicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = onePicInfoCardView;
            this.a = onePicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.m(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = 0;
        this.y = -1;
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, onePicInfoCard) == null) || this.q == null) {
            return;
        }
        if (onePicInfoCard != null && !bh7.a(onePicInfoCard.gettBgColor()) && !bh7.a(onePicInfoCard.gettBgColorN())) {
            this.q.setBackgroundColor(r() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
        } else {
            SkinManager.setBackgroundResource(this.q, R.drawable.label_bg_tie_n);
        }
    }

    public final void G(TextView textView, TbImageView tbImageView, yg7 yg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, textView, tbImageView, yg7Var) == null) {
            String str = r() ? yg7Var.b : yg7Var.a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.K(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(rg7.a(yg7Var.c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            try {
                textView.setText(StringHelper.numberUniformFormat(Long.parseLong(yg7Var.d)));
            } catch (NumberFormatException unused) {
                textView.setText(yg7Var.d);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: H */
    public void t(OnePicInfoCard onePicInfoCard, int i) {
        LineCountNotifyTextView lineCountNotifyTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onePicInfoCard, i) == null) {
            ge5.a(this.i, getRootView());
            SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
            setTagBg(onePicInfoCard);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0110);
            int i2 = this.x;
            if (i2 == 0 || (lineCountNotifyTextView = this.o) == null) {
                return;
            }
            SkinManager.setViewTextColor(lineCountNotifyTextView, i2, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void u(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onePicInfoCard) == null) {
            this.n.K(!TextUtils.isEmpty(onePicInfoCard.getPic()) ? onePicInfoCard.getPic() : null, 10, false);
            if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
                this.o.setText(onePicInfoCard.getCardTitle());
                this.o.setGetLineCountCallback(new a(this, onePicInfoCard));
            }
            if (StringUtils.isNull(onePicInfoCard.getTag())) {
                this.q.setVisibility(8);
            } else {
                this.q.setVisibility(0);
                setTagBg(onePicInfoCard);
                this.q.setText(onePicInfoCard.getTag());
            }
            if (onePicInfoCard.getIconList() != null) {
                this.r.setVisibility(8);
                this.u.setVisibility(8);
                if (onePicInfoCard.getIconList().size() > 0) {
                    this.r.setVisibility(0);
                    G(this.t, this.s, onePicInfoCard.getIconList().get(0));
                }
                if (onePicInfoCard.getIconList().size() > 1) {
                    this.u.setVisibility(0);
                    G(this.w, this.v, onePicInfoCard.getIconList().get(1));
                }
            } else {
                this.r.setVisibility(8);
                this.u.setVisibility(8);
            }
            lo8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(String.valueOf(onePicInfoCard.getItemId()))) {
                this.x = R.color.CAM_X0108;
            } else {
                this.x = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.o, this.x, 1);
            setCardOnClickListener(new b(this, onePicInfoCard));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void v(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onePicInfoCard) == null) {
            dg7.e(onePicInfoCard).d(TiebaStatic.Params.OBJ_URL, onePicInfoCard.getScheme()).b("obj_locate", getStatPosition()).a(onePicInfoCard);
            super.v(onePicInfoCard);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01aa, (ViewGroup) null);
            this.m = viewGroup;
            this.n = (TbImageView) l(viewGroup, R.id.obfuscated_res_0x7f090ebc);
            this.o = (LineCountNotifyTextView) l(this.m, R.id.obfuscated_res_0x7f09173c);
            this.p = (TextView) l(this.m, R.id.obfuscated_res_0x7f0907e2);
            View view2 = (View) l(this.m, R.id.obfuscated_res_0x7f090ddc);
            this.q = (TextView) l(view2, R.id.obfuscated_res_0x7f090de5);
            this.r = (LinearLayout) l(view2, R.id.obfuscated_res_0x7f091403);
            this.s = (TbImageView) l(view2, R.id.obfuscated_res_0x7f090e21);
            this.t = (TextView) l(view2, R.id.obfuscated_res_0x7f092102);
            this.u = (LinearLayout) l(view2, R.id.obfuscated_res_0x7f091409);
            this.v = (TbImageView) l(view2, R.id.obfuscated_res_0x7f090e22);
            this.w = (TextView) l(view2, R.id.obfuscated_res_0x7f092103);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
