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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.u0.l3.z;
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
import tbclient.AdCloseInfo;
/* loaded from: classes13.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f47729f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f47730g;

    /* renamed from: h  reason: collision with root package name */
    public AdCloseView f47731h;
    public TextView mAdTitle;
    public View mCustomRoot;
    public ViewStub mCustomViewStub;
    public View mRootView;
    public TextView mTextViewAdvertName;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f47732e;

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
            this.f47732e = adSimpleCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47732e.f47731h.performClick();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdCard f47733e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f47734f;

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
            this.f47734f = adSimpleCardBaseView;
            this.f47733e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
                int d2 = z.d(this.f47734f.mContext.getPageActivity(), this.f47733e.getScheme(), this.f47733e.getDownloadId(), this.f47733e.getExtInfo(), this.f47733e.cmdScheme);
                if (this.f47734f.afterClickSchemeListener != null) {
                    this.f47734f.afterClickSchemeListener.a(d2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                if (!l.A()) {
                    this.f47734f.mContext.showToast(R.string.neterror);
                    return;
                }
                AdCard adCard = this.f47733e;
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

    public abstract void fillCustomView(AdCard adCard);

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.f47729f.setVisibility(0);
            this.f47729f.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f47729f.addView(view);
        }
    }

    public final void i(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.f47731h.setVisibility(0);
                this.f47731h.setPage(getBusinessType());
                this.f47731h.setData(advertAppInfo, adCard.closeInfo);
                n.b(this.mContext.getPageActivity(), this.f47730g, 40, 40, 40, 120);
                this.f47730g.setOnClickListener(new a(this));
                return;
            }
            this.f47731h.setVisibility(8);
        }
    }

    public abstract void initCustomView(View view);

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.mRootView = inflate;
            ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.ad_custom_view_stub);
            this.mCustomViewStub = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            View inflate2 = this.mCustomViewStub.inflate();
            this.mCustomRoot = inflate2;
            initCustomView(inflate2);
            this.mAdTitle = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mTextViewAdvertName = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
            this.f47729f = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
            this.f47730g = linearLayout;
            this.f47731h = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
            return this.mRootView;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, adCard, i2) == null) {
            this.f47731h.onChangeSkinType();
            SkinManager.setViewTextColor(this.mAdTitle, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mTextViewAdvertName, R.color.CAM_X0109, 1, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) || adCard == null) {
            return;
        }
        this.mRootView.setOnClickListener(new b(this, adCard));
        String str = adCard.threadTitle;
        if (!TextUtils.isEmpty(str)) {
            this.mAdTitle.setText(str);
            this.mAdTitle.setVisibility(0);
        } else {
            this.mAdTitle.setVisibility(8);
        }
        String str2 = adCard.userName;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2 + GlideException.IndentedAppendable.INDENT;
        }
        this.mTextViewAdvertName.setText(str2 + "广告");
        h(this.f47730g);
        onChangeSkinType(adCard, TbadkCoreApplication.getInst().getSkinType());
        fillCustomView(adCard);
        i(adCard.getAdvertAppInfo(), adCard);
    }
}
