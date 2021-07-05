package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.s0.w2.x;
import tbclient.AdCloseInfo;
/* loaded from: classes5.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View r;
    public ViewStub s;
    public View t;
    public TextView u;
    public TextView v;
    public FrameLayout w;
    public LinearLayout x;
    public AdCloseView y;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f20489e;

        public a(AdSimpleCardBaseView adSimpleCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSimpleCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20489e = adSimpleCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20489e.y.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdCard f20490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f20491f;

        public b(AdSimpleCardBaseView adSimpleCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSimpleCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20491f = adSimpleCardBaseView;
            this.f20490e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
                int d2 = x.d(this.f20491f.m.getPageActivity(), this.f20490e.getScheme(), this.f20490e.getDownloadId(), this.f20490e.getExtInfo());
                if (this.f20491f.o != null) {
                    this.f20491f.o.a(d2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                if (!j.A()) {
                    this.f20491f.m.showToast(R.string.neterror);
                    return;
                }
                AdCard adCard = this.f20490e;
                if (adCard == null) {
                    return;
                }
                a(adCard.getAdvertAppInfo());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
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
    }

    public final void M(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.w.setVisibility(0);
            this.w.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.w.addView(view);
        }
    }

    public abstract void N(AdCard adCard);

    public final void O(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.y.setVisibility(0);
                this.y.setPage(getBusinessType());
                this.y.setData(advertAppInfo, adCard.closeInfo);
                l.c(this.m.getPageActivity(), this.x, 40, 40, 40, 120);
                this.x.setOnClickListener(new a(this));
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public abstract void P(View view);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: Q */
    public void v(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, adCard, i2) == null) {
            this.y.onChangeSkinType();
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109, 1, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: R */
    public void w(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) || adCard == null) {
            return;
        }
        this.r.setOnClickListener(new b(this, adCard));
        String str = adCard.threadTitle;
        if (!TextUtils.isEmpty(str)) {
            this.u.setText(str);
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        String str2 = adCard.userName;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2 + GlideException.IndentedAppendable.INDENT;
        }
        this.v.setText(str2 + "广告");
        M(this.x);
        v(adCard, TbadkCoreApplication.getInst().getSkinType());
        N(adCard);
        O(adCard.getAdvertAppInfo(), adCard);
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.r = inflate;
            ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.ad_custom_view_stub);
            this.s = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            View inflate2 = this.s.inflate();
            this.t = inflate2;
            P(inflate2);
            this.u = (TextView) this.r.findViewById(R.id.ad_title);
            this.v = (TextView) this.r.findViewById(R.id.advert_app_name);
            this.w = (FrameLayout) this.r.findViewById(R.id.btn_pb_card_bottom_op_more_container);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
            this.x = linearLayout;
            this.y = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
            return this.r;
        }
        return (View) invokeV.objValue;
    }
}
