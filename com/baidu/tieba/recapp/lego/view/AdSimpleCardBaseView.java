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
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.s0.j3.z;
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
/* loaded from: classes12.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f49184f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f49185g;

    /* renamed from: h  reason: collision with root package name */
    public AdCloseView f49186h;
    public TextView mAdTitle;
    public View mCustomRoot;
    public ViewStub mCustomViewStub;
    public View mRootView;
    public TextView mTextViewAdvertName;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f49187e;

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
            this.f49187e = adSimpleCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49187e.f49186h.performClick();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdCard f49188e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f49189f;

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
            this.f49189f = adSimpleCardBaseView;
            this.f49188e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
                int d2 = z.d(this.f49189f.mContext.getPageActivity(), this.f49188e.getScheme(), this.f49188e.getDownloadId(), this.f49188e.getExtInfo(), this.f49188e.cmdScheme);
                if (this.f49189f.afterClickSchemeListener != null) {
                    this.f49189f.afterClickSchemeListener.a(d2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                if (!k.A()) {
                    this.f49189f.mContext.showToast(R.string.neterror);
                    return;
                }
                AdCard adCard = this.f49188e;
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
            this.f49184f.setVisibility(0);
            this.f49184f.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f49184f.addView(view);
        }
    }

    public final void i(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.f49186h.setVisibility(0);
                this.f49186h.setPage(getBusinessType());
                this.f49186h.setData(advertAppInfo, adCard.closeInfo);
                m.b(this.mContext.getPageActivity(), this.f49185g, 40, 40, 40, 120);
                this.f49185g.setOnClickListener(new a(this));
                return;
            }
            this.f49186h.setVisibility(8);
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
            this.f49184f = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
            this.f49185g = linearLayout;
            this.f49186h = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
            return this.mRootView;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, adCard, i2) == null) {
            this.f49186h.onChangeSkinType();
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
        h(this.f49185g);
        onChangeSkinType(adCard, TbadkCoreApplication.getInst().getSkinType());
        fillCustomView(adCard);
        i(adCard.getAdvertAppInfo(), adCard);
    }
}
