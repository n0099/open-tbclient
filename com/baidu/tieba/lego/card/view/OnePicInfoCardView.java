package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.p0.d;
import b.a.r0.q1.i;
import b.a.r0.q1.o.f;
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
/* loaded from: classes9.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f51156f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f51157g;

    /* renamed from: h  reason: collision with root package name */
    public LineCountNotifyTextView f51158h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51159i;
    public TextView j;
    public LinearLayout k;
    public TbImageView l;
    public TextView m;
    public LinearLayout n;
    public TbImageView o;
    public TextView p;
    public int q;
    public int r;

    /* loaded from: classes9.dex */
    public class a implements LineCountNotifyTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCard f51160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCardView f51161b;

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
            this.f51161b = onePicInfoCardView;
            this.f51160a = onePicInfoCard;
        }

        @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int lineCount = this.f51161b.f51158h.getLineCount();
                if (this.f51161b.r != lineCount) {
                    if (lineCount == 1) {
                        this.f51161b.f51159i.setMaxLines(2);
                    } else {
                        this.f51161b.f51159i.setMaxLines(1);
                    }
                }
                this.f51161b.r = lineCount;
                this.f51161b.f51159i.setText(this.f51160a.getDesc());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCard f51162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCardView f51163f;

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
            this.f51163f = onePicInfoCardView;
            this.f51162e = onePicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51163f.handleClickEvent(this.f51162e);
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
        this.q = 0;
        this.r = -1;
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, onePicInfoCard) == null) || this.j == null) {
            return;
        }
        if (onePicInfoCard != null && !b.a.r0.q1.o.k.b.a(onePicInfoCard.gettBgColor()) && !b.a.r0.q1.o.k.b.a(onePicInfoCard.gettBgColorN())) {
            this.j.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
        } else {
            SkinManager.setBackgroundResource(this.j, R.drawable.label_bg_tie_n);
        }
    }

    public final void g(TextView textView, TbImageView tbImageView, b.a.r0.q1.o.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, textView, tbImageView, bVar) == null) {
            String str = isNightMode() ? bVar.f22640b : bVar.f22639a;
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                tbImageView.setVisibility(0);
                tbImageView.startLoad(str, 10, false);
            } else {
                tbImageView.setVisibility(8);
                textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(f.a(bVar.f22641c)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            try {
                textView.setText(StringHelper.numberUniformFormat(Long.parseLong(bVar.f22642d)));
            } catch (NumberFormatException unused) {
                textView.setText(bVar.f22642d);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
            this.f51156f = viewGroup;
            this.f51157g = (TbImageView) findViewById(viewGroup, R.id.img);
            this.f51158h = (LineCountNotifyTextView) findViewById(this.f51156f, R.id.one_title);
            this.f51159i = (TextView) findViewById(this.f51156f, R.id.discription);
            View view = (View) findViewById(this.f51156f, R.id.hot_thread_comment);
            this.j = (TextView) findViewById(view, R.id.hot_thread_line_tag);
            this.k = (LinearLayout) findViewById(view, R.id.ll_left);
            this.l = (TbImageView) findViewById(view, R.id.iconLeft);
            this.m = (TextView) findViewById(view, R.id.textLeft);
            this.n = (LinearLayout) findViewById(view, R.id.ll_right);
            this.o = (TbImageView) findViewById(view, R.id.iconRight);
            this.p = (TextView) findViewById(view, R.id.textRight);
            return this.f51156f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(OnePicInfoCard onePicInfoCard, int i2) {
        LineCountNotifyTextView lineCountNotifyTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, onePicInfoCard, i2) == null) {
            b.a.q0.w0.a.a(this.mContext, getRootView());
            SkinManager.setBackgroundResource(this.f51156f, R.drawable.addresslist_item_bg);
            setTagBg(onePicInfoCard);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0110);
            int i3 = this.q;
            if (i3 == 0 || (lineCountNotifyTextView = this.f51158h) == null) {
                return;
            }
            SkinManager.setViewTextColor(lineCountNotifyTextView, i3, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void openCardScheme(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onePicInfoCard) == null) {
            i.e(onePicInfoCard).d(TiebaStatic.Params.OBJ_URL, onePicInfoCard.getScheme()).b("obj_locate", getStatPosition()).a(onePicInfoCard);
            super.openCardScheme((OnePicInfoCardView) onePicInfoCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(OnePicInfoCard onePicInfoCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onePicInfoCard) == null) {
            this.f51157g.startLoad(!TextUtils.isEmpty(onePicInfoCard.getPic()) ? onePicInfoCard.getPic() : null, 10, false);
            if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
                this.f51158h.setText(onePicInfoCard.getCardTitle());
                this.f51158h.setGetLineCountCallback(new a(this, onePicInfoCard));
            }
            if (StringUtils.isNull(onePicInfoCard.getTag())) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                setTagBg(onePicInfoCard);
                this.j.setText(onePicInfoCard.getTag());
            }
            if (onePicInfoCard.getIconList() != null) {
                this.k.setVisibility(8);
                this.n.setVisibility(8);
                if (onePicInfoCard.getIconList().size() > 0) {
                    this.k.setVisibility(0);
                    g(this.m, this.l, onePicInfoCard.getIconList().get(0));
                }
                if (onePicInfoCard.getIconList().size() > 1) {
                    this.n.setVisibility(0);
                    g(this.p, this.o, onePicInfoCard.getIconList().get(1));
                }
            } else {
                this.k.setVisibility(8);
                this.n.setVisibility(8);
            }
            d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(String.valueOf(onePicInfoCard.getItemId()))) {
                this.q = R.color.CAM_X0108;
            } else {
                this.q = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f51158h, this.q, 1);
            setCardOnClickListener(new b(this, onePicInfoCard));
        }
    }
}
