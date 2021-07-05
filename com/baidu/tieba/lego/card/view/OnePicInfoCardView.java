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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.n0.d;
import d.a.s0.n1.i;
import d.a.s0.n1.o.f;
/* loaded from: classes5.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TextView B;
    public int C;
    public int D;
    public ViewGroup r;
    public TbImageView s;
    public LineCountNotifyTextView t;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public TbImageView x;
    public TextView y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a implements LineCountNotifyTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCard f18212a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCardView f18213b;

        public a(OnePicInfoCardView onePicInfoCardView, OnePicInfoCard onePicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onePicInfoCardView, onePicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18213b = onePicInfoCardView;
            this.f18212a = onePicInfoCard;
        }

        @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int lineCount = this.f18213b.t.getLineCount();
                if (this.f18213b.D != lineCount) {
                    if (lineCount == 1) {
                        this.f18213b.u.setMaxLines(2);
                    } else {
                        this.f18213b.u.setMaxLines(1);
                    }
                }
                this.f18213b.D = lineCount;
                this.f18213b.u.setText(this.f18212a.getDesc());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCard f18214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCardView f18215f;

        public b(OnePicInfoCardView onePicInfoCardView, OnePicInfoCard onePicInfoCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onePicInfoCardView, onePicInfoCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18215f = onePicInfoCardView;
            this.f18214e = onePicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18215f.o(this.f18214e);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C = 0;
        this.D = -1;
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, onePicInfoCard) == null) || this.v == null) {
            return;
        }
        if (onePicInfoCard != null && !d.a.s0.n1.o.k.b.a(onePicInfoCard.gettBgColor()) && !d.a.s0.n1.o.k.b.a(onePicInfoCard.gettBgColorN())) {
            this.v.setBackgroundColor(t() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
        } else {
            SkinManager.setBackgroundResource(this.v, R.drawable.label_bg_tie_n);
        }
    }

    public final void L(TextView textView, TbImageView tbImageView, d.a.s0.n1.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, textView, tbImageView, bVar) == null) {
            String str = t() ? bVar.f63805b : bVar.f63804a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.M(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(f.a(bVar.f63806c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            try {
                textView.setText(StringHelper.numberUniformFormat(Long.parseLong(bVar.f63807d)));
            } catch (NumberFormatException unused) {
                textView.setText(bVar.f63807d);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void v(OnePicInfoCard onePicInfoCard, int i2) {
        LineCountNotifyTextView lineCountNotifyTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onePicInfoCard, i2) == null) {
            d.a.r0.s0.a.a(this.m, getRootView());
            SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
            setTagBg(onePicInfoCard);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110);
            int i3 = this.C;
            if (i3 == 0 || (lineCountNotifyTextView = this.t) == null) {
                return;
            }
            SkinManager.setViewTextColor(lineCountNotifyTextView, i3, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: N */
    public void w(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onePicInfoCard) == null) {
            this.s.M(!TextUtils.isEmpty(onePicInfoCard.getPic()) ? onePicInfoCard.getPic() : null, 10, false);
            if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
                this.t.setText(onePicInfoCard.getCardTitle());
                this.t.setGetLineCountCallback(new a(this, onePicInfoCard));
            }
            if (StringUtils.isNull(onePicInfoCard.getTag())) {
                this.v.setVisibility(8);
            } else {
                this.v.setVisibility(0);
                setTagBg(onePicInfoCard);
                this.v.setText(onePicInfoCard.getTag());
            }
            if (onePicInfoCard.getIconList() != null) {
                this.w.setVisibility(8);
                this.z.setVisibility(8);
                if (onePicInfoCard.getIconList().size() > 0) {
                    this.w.setVisibility(0);
                    L(this.y, this.x, onePicInfoCard.getIconList().get(0));
                }
                if (onePicInfoCard.getIconList().size() > 1) {
                    this.z.setVisibility(0);
                    L(this.B, this.A, onePicInfoCard.getIconList().get(1));
                }
            } else {
                this.w.setVisibility(8);
                this.z.setVisibility(8);
            }
            d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(String.valueOf(onePicInfoCard.getItemId()))) {
                this.C = R.color.CAM_X0108;
            } else {
                this.C = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.t, this.C, 1);
            setCardOnClickListener(new b(this, onePicInfoCard));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: O */
    public void x(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onePicInfoCard) == null) {
            i.e(onePicInfoCard).d(TiebaStatic.Params.OBJ_URL, onePicInfoCard.getScheme()).b("obj_locate", getStatPosition()).a(onePicInfoCard);
            super.x(onePicInfoCard);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
            this.r = viewGroup;
            this.s = (TbImageView) n(viewGroup, R.id.img);
            this.t = (LineCountNotifyTextView) n(this.r, R.id.one_title);
            this.u = (TextView) n(this.r, R.id.discription);
            View view = (View) n(this.r, R.id.hot_thread_comment);
            this.v = (TextView) n(view, R.id.hot_thread_line_tag);
            this.w = (LinearLayout) n(view, R.id.ll_left);
            this.x = (TbImageView) n(view, R.id.iconLeft);
            this.y = (TextView) n(view, R.id.textLeft);
            this.z = (LinearLayout) n(view, R.id.ll_right);
            this.A = (TbImageView) n(view, R.id.iconRight);
            this.B = (TextView) n(view, R.id.textRight);
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
