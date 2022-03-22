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
import c.a.p0.l3.a0;
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
/* loaded from: classes5.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public ViewStub n;
    public View o;
    public TextView p;
    public TextView q;
    public FrameLayout r;
    public LinearLayout s;
    public AdCloseView t;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdSimpleCardBaseView a;

        public a(AdSimpleCardBaseView adSimpleCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSimpleCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adSimpleCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.t.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdSimpleCardBaseView f35723b;

        public b(AdSimpleCardBaseView adSimpleCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adSimpleCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35723b = adSimpleCardBaseView;
            this.a = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
                int d2 = a0.d(this.f35723b.i.getPageActivity(), this.a.getScheme(), this.a.getDownloadId(), this.a.getExtInfo(), this.a.cmdScheme);
                if (this.f35723b.k != null) {
                    this.f35723b.k.a(d2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                if (!l.A()) {
                    this.f35723b.i.showToast(R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                AdCard adCard = this.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void H(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.r.setVisibility(0);
            this.r.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.r.addView(view);
        }
    }

    public abstract void I(AdCard adCard);

    public final void J(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.t.setVisibility(0);
                this.t.setPage(getBusinessType());
                this.t.setData(advertAppInfo, adCard.closeInfo);
                n.b(this.i.getPageActivity(), this.s, 40, 40, 40, 120);
                this.s.setOnClickListener(new a(this));
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public abstract void K(View view);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void t(AdCard adCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, adCard, i) == null) {
            this.t.onChangeSkinType();
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void u(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) || adCard == null) {
            return;
        }
        this.m.setOnClickListener(new b(this, adCard));
        String str = adCard.threadTitle;
        if (!TextUtils.isEmpty(str)) {
            this.p.setText(str);
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
        String str2 = adCard.userName;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2 + GlideException.IndentedAppendable.INDENT;
        }
        this.q.setText(str2 + "广告");
        H(this.s);
        t(adCard, TbadkCoreApplication.getInst().getSkinType());
        I(adCard);
        J(adCard.getAdvertAppInfo(), adCard);
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.m = inflate;
            ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f09009a);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            View inflate2 = this.n.inflate();
            this.o = inflate2;
            K(inflate2);
            this.p = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900f3);
            this.q = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090146);
            this.r = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f09042c);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0071, (ViewGroup) null);
            this.s = linearLayout;
            this.t = (AdCloseView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090092);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
