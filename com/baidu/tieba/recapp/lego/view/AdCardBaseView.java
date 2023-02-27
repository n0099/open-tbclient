package com.baidu.tieba.recapp.lego.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.b35;
import com.baidu.tieba.by4;
import com.baidu.tieba.dw8;
import com.baidu.tieba.ej;
import com.baidu.tieba.ey7;
import com.baidu.tieba.gx8;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.nj0;
import com.baidu.tieba.o41;
import com.baidu.tieba.oj0;
import com.baidu.tieba.oy5;
import com.baidu.tieba.p41;
import com.baidu.tieba.pu6;
import com.baidu.tieba.qu6;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdLottieButtonView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.ui;
import com.baidu.tieba.uv8;
import com.baidu.tieba.w75;
import com.baidu.tieba.xy5;
import com.baidu.tieba.yy5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import tbclient.AdCloseInfo;
/* loaded from: classes6.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int A;
    public int B;
    public TextView C;
    public TextView D;
    public TextView E;
    public AdCloseView F;
    public LinearLayout G;
    public ApkDownloadView H;
    public TextView I;
    public RelativeLayout J;
    public View K;
    public AdCard L;
    public AdThreadCommentAndPraiseInfoLayout M;
    public AdThreadUserInfoLayout N;
    public View O;
    public View P;
    public FrameLayout Q;
    public View R;
    public View S;
    public AdAppInfoView T;
    public AdLottieButtonView U;
    public VipAdFreeGuideLayout V;
    public boolean W;
    public xy5 a0;
    public View m;
    public ViewStub n;
    public View o;
    public View p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    public abstract void O(AdCard adCard);

    public abstract void U(View view2);

    public abstract int getCustomLayout();

    public abstract int getLayout();

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public a(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q("title");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public b(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements uv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;
        public final /* synthetic */ AdCardBaseView b;

        public c(AdCardBaseView adCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.uv8
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean b = nj0.b(this.b.i.getPageActivity(), this.a.downloadInfo.a);
                HashMap<String, Object> M = this.b.M("try_button");
                if (this.b.k != null) {
                    this.b.k.a(1, M);
                }
                return b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public d(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q("hotarea");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public e(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                o41.a().b(this.a.getContext());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public f(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q("username");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;
        public final /* synthetic */ AdCardBaseView b;

        public g(AdCardBaseView adCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((TextView) this.b.N.getUserName()).setText(this.a.userName);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ AdCardBaseView b;

        public h(AdCardBaseView adCardBaseView, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        @SuppressLint({"MissingPermission"})
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            AdvertAppInfo advertAppInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                w75 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.d() || (advertAppInfo = this.a) == null) {
                    return false;
                }
                ui.a(advertAppInfo.c());
                ((Vibrator) this.b.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public i(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q("icon");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements yy5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AdCardBaseView b;

        public j(AdCardBaseView adCardBaseView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = str;
        }

        @Override // com.baidu.tieba.yy5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                oy5.a(this.a);
                HashMap<String, Object> M = this.b.M(NativeConstants.ID_BUTTON);
                if (this.b.k != null) {
                    this.b.k.a(3, M);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public k(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q(NativeConstants.ID_BUTTON);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public l(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q("tag");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardBaseView(TbPageContext tbPageContext) {
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
        Resources resources = tbPageContext.getResources();
        this.q = (int) resources.getDimension(R.dimen.tbds92);
        resources.getDimension(R.dimen.tbds92);
        this.r = (int) resources.getDimension(R.dimen.M_W_X004);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds22);
        this.s = (int) resources.getDimension(R.dimen.M_W_X005);
        this.v = (int) resources.getDimension(R.dimen.M_W_X004);
        this.w = 0;
        this.t = (int) resources.getDimension(R.dimen.M_W_X007);
        this.u = (int) resources.getDimension(R.dimen.M_H_X005);
        this.x = (int) resources.getDimension(R.dimen.tbds208);
        this.y = (int) resources.getDimension(R.dimen.tbds33);
        this.z = (int) resources.getDimension(R.dimen.tbds72);
        this.A = (int) resources.getDimension(R.dimen.tbds48);
    }

    public final void N(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adCard) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.P.setVisibility(0);
                this.M.setVisibility(8);
                return;
            }
            this.P.setVisibility(8);
            this.M.setVisibility(0);
            this.M.setBarNameClickEnabled(false);
            this.M.setReplyTimeVisible(false);
            this.M.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.M.setAgreeClickable(true);
                this.M.setPraiseContainerBgGray(false);
            } else {
                this.M.setAgreeClickable(false);
                this.M.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.M.setShareClickable(true);
                this.M.setShareContainerBgGray(false);
            } else {
                this.M.setShareClickable(false);
                this.M.setShareContainerBgGray(true);
            }
            this.M.setNeedAddReplyIcon(true);
            this.M.setCommentNumEnable(false);
            this.M.setCommentClickable(true);
            this.M.setReplayContainerBgGray(true);
            this.M.setShareData(adCard);
            this.M.setDisPraiseViewVisibility(false);
        }
    }

    @NonNull
    public HashMap M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("da_area", str);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public float P(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
            } catch (Exception unused) {
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    public boolean f0(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, adCard)) == null) {
            if (g0() && adCard.isPBBanner) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.az7
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.W = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (adThreadCommentAndPraiseInfoLayout = this.M) != null) {
            adThreadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
        }
    }

    public final void J(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.Q.setVisibility(0);
            if (h0(view2, this.Q)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.Q.removeAllViews();
            view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.Q.addView(view2);
        }
    }

    public final void S(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adCard) == null) {
            int i2 = (this.B - this.x) - this.A;
            if (g0()) {
                i2 -= this.y + this.z;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            this.I.setText(gx8.e(str, this.i.getString(R.string.advert_label), i2, this.I.getPaint()));
            this.I.setOnClickListener(new l(this));
        }
    }

    public final void V(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            m0(adCard);
            this.D.setVisibility(8);
            this.H.setVisibility(0);
            this.H.setClickable(true);
            this.H.setInitText(adCard.getButtonText());
            this.H.setOnClickInterceptListener(new j(this, adCard.getButtonCmdScheme()));
            this.a0 = new xy5(this.H, gx8.d(adCard));
        }
    }

    public final void Y(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adCard) == null) {
            this.H.setVisibility(8);
            this.T.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setClickable(true);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.D, R.drawable.obfuscated_res_0x7f0800c1);
            this.D.setText(adCard.getButtonText());
            this.D.setOnClickListener(new k(this));
        }
    }

    public final void b0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, adCard) == null) {
            this.M.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (g0()) {
                this.M.setVisibility(8);
                this.M.setBarNameClickEnabled(false);
                this.M.setShareVisible(false);
                this.M.setShowPraiseNum(false);
                this.M.setCommentNumEnable(false);
                this.M.setReplyTimeVisible(false);
                this.O.setVisibility(0);
                this.P.setVisibility(8);
                return;
            }
            N(adCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: k0 */
    public void u(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, adCard) == null) {
            this.L = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            L(adCard);
            a0(adCard, advertAppInfo);
            T(adCard);
            Z(adCard, advertAppInfo);
            S(adCard);
            R(advertAppInfo, adCard);
            b0(adCard);
            n0(adCard);
            this.m.setOnClickListener(new d(this));
            if (p41.a) {
                this.m.setOnLongClickListener(new e(this));
            }
            O(adCard);
            t(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void m0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, adCard) == null) {
            by4 appInfoModel = adCard.getAppInfoModel();
            RelativeLayout downloadButtonContainer = this.T.getDownloadButtonContainer();
            if (by4.a(appInfoModel)) {
                this.T.setVisibility(0);
                this.T.setAppInfo(appInfoModel);
                this.T.setAd(adCard.getAdvertAppInfo());
                if (h0(this.H, downloadButtonContainer)) {
                    return;
                }
                i0(this.H, downloadButtonContainer);
                return;
            }
            this.T.setVisibility(8);
            if (h0(this.H, this.J)) {
                return;
            }
            i0(this.H, this.J);
        }
    }

    public final void K(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.Q.setVisibility(8);
            if (h0(view2, this.N)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.N.addAdTagView(this.G);
        }
    }

    public final void T(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adCard) == null) {
            String str = adCard.threadTitle;
            if (TextUtils.isEmpty(str)) {
                this.C.setVisibility(8);
                return;
            }
            int i2 = adCard.maxTitleLine;
            if (i2 <= 0) {
                i2 = 4;
            }
            this.C.setMaxLines(i2);
            this.C.setText(str);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new a(this));
        }
    }

    public final void n0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, adCard) == null) {
            if (adCard.gameModel == null && this.U == null) {
                return;
            }
            AdLottieButtonView adLottieButtonView = this.U;
            if ((adLottieButtonView == null || adLottieButtonView.getParent() == null) && !W()) {
                return;
            }
            this.U.setData(adCard.gameModel);
            this.U.setClickListener(new c(this, adCard));
        }
    }

    public final void L(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
            layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.K.setPadding(0, 0, 0, 0);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            if (g0()) {
                View view2 = this.m;
                int i2 = this.t;
                view2.setPadding(i2, this.u, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                int l2 = (ej.l(getContext()) - (this.w * 2)) - (this.t * 2);
                int i3 = this.q;
                int i4 = this.r;
                this.B = (l2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.S.setVisibility(0);
                K(this.G);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                    layoutParams3.leftMargin = 0;
                    layoutParams3.rightMargin = 0;
                }
                if (f0(adCard)) {
                    this.S.setVisibility(8);
                    this.m.setPadding(0, 0, 0, 0);
                    View view3 = this.K;
                    int i5 = this.t;
                    view3.setPadding(i5, 0, i5, 0);
                    this.V.setLayoutPadding(-1, -1, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007));
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
                    if (layoutParams4 != null) {
                        int i6 = this.t;
                        layoutParams4.leftMargin = -i6;
                        layoutParams4.rightMargin = -i6;
                    }
                    layoutParams2.leftMargin = 0;
                    this.B = (ej.l(getContext()) - (this.t * 2)) - (this.w * 2);
                    layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.R.setVisibility(0);
                    SkinManager.setBackgroundColor(this.R, R.color.CAM_X0204);
                    J(this.G);
                    return;
                }
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                if (this.W) {
                    l0(layoutParams5, -1);
                    this.p.setVisibility(0);
                    this.p.bringToFront();
                    SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
                    return;
                }
                l0(layoutParams5, -2);
                this.p.setVisibility(8);
                return;
            }
            View view4 = this.m;
            int i7 = this.s;
            view4.setPadding(i7, this.u, i7, 0);
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
            if (layoutParams6 != null) {
                int i8 = this.s;
                layoutParams6.leftMargin = -i8;
                layoutParams6.rightMargin = -i8;
            }
            this.B = (ej.l(getContext()) - (this.s * 2)) - (this.v * 2);
            if ((qu6.f().i() || pu6.h().j()) && e0()) {
                this.p.setVisibility(0);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            } else {
                this.p.setVisibility(8);
            }
            this.S.setVisibility(8);
        }
    }

    public void Q(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0d11);
                return;
            }
            AdCard adCard = this.L;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            String extInfo = this.L.getExtInfo();
            String downloadId = this.L.getDownloadId();
            String str3 = this.L.scheme;
            if (NativeConstants.ID_BUTTON.equals(str)) {
                str2 = this.L.getButtonCmdScheme();
            } else {
                str2 = this.L.cmdScheme;
            }
            int i2 = 3;
            boolean z = false;
            if (advertAppInfo != null && advertAppInfo.g() && !oj0.n(this.L.cmdScheme)) {
                z = nj0.b(this.i.getPageActivity(), advertAppInfo.p);
            }
            if (!z) {
                i2 = dw8.b(this.i, str3, downloadId, extInfo, str2);
            }
            HashMap<String, Object> M = M(str);
            ey7 ey7Var = this.k;
            if (ey7Var != null) {
                ey7Var.a(i2, M);
            }
        }
    }

    public final void R(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.F.setVisibility(0);
                this.F.setPage(getBusinessType());
                this.F.setData(advertAppInfo, adCard.closeInfo);
                ej.b(this.i.getPageActivity(), this.G, 40, 40, 40, 120);
                this.G.setOnClickListener(new b(this));
                return;
            }
            this.F.setVisibility(8);
            this.E.setOnClickListener(null);
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!(this.o instanceof RelativeLayout)) {
                return false;
            }
            AdLottieButtonView adLottieButtonView = new AdLottieButtonView(this.i.getPageActivity());
            this.U = adLottieButtonView;
            adLottieButtonView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ej.g(this.i.getPageActivity(), R.dimen.M_H_X003);
            layoutParams.leftMargin = ej.g(this.i.getPageActivity(), R.dimen.M_W_X004);
            View view2 = this.o;
            if (view2 instanceof RelativeLayout) {
                ((RelativeLayout) view2).addView(this.U, layoutParams);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.G = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d006e, (ViewGroup) null);
            ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f09009e);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.o = this.n.inflate();
        }
    }

    public final void Z(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, adCard, advertAppInfo) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.J.setVisibility(0);
                xy5 xy5Var = this.a0;
                if (xy5Var != null) {
                    xy5Var.k();
                    this.a0 = null;
                }
                if (advertAppInfo.g()) {
                    V(adCard);
                    return;
                } else if (advertAppInfo.j()) {
                    Y(adCard);
                    return;
                } else {
                    return;
                }
            }
            this.J.setVisibility(8);
        }
    }

    public final void a0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, adCard, advertAppInfo) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
            }
            this.N.setShowFlag(1413);
            this.N.setData(advertAppInfo2);
            ((TextView) this.N.getUserName()).setText(adCard.userName);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView((TextView) this.N.getUserName());
            this.N.getUserName().setOnClickListener(new f(this));
            this.N.setAfterAdjustChildWidthListener(new g(this, adCard));
            this.N.getHeaderImg().setOnLongClickListener(new h(this, advertAppInfo));
            if (this.N.getHeaderImg() != null) {
                this.N.getHeaderImg().setClickable(true);
                this.N.getHeaderImg().setOnClickListener(new i(this));
            }
            if (f0(adCard)) {
                this.N.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: j0 */
    public void t(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, adCard, i2) == null) {
            this.F.onChangeSkinType();
            this.N.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.M.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view2 = this.m;
                view2.setBackgroundDrawable(gx8.f(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view2.getMeasuredHeight()));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor((TextView) this.N.getUserName());
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.C);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.D, R.drawable.obfuscated_res_0x7f0800c1);
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.R, R.color.CAM_X0204);
            this.H.e(i2);
            b35 d2 = b35.d(this.T);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            this.T.onChangeSkinType();
            this.V.f();
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (getBusinessType() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (getBusinessType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.b == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.az7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && g0()) {
            this.C.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (getBusinessType() == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View getPbAdBottomDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.S;
        }
        return (View) invokeV.objValue;
    }

    public View getPbBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.O;
        }
        return (View) invokeV.objValue;
    }

    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.V;
        }
        return (VipAdFreeGuideLayout) invokeV.objValue;
    }

    public void setUseDynamicLikeRes() {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (adThreadCommentAndPraiseInfoLayout = this.M) != null) {
            adThreadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
        }
    }

    public final boolean h0(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, view2, viewGroup)) == null) {
            if (view2 == null || view2.getParent() == null || view2.getParent() != viewGroup) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void i0(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048607, this, view2, viewGroup) != null) || view2 == null || !(view2.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view2.getParent()).removeView(view2);
        viewGroup.addView(view2);
    }

    public final void l0(ViewGroup.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048610, this, layoutParams, i2) == null) && layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = i2;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.m == null) {
                this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) this, false);
            }
            this.R = this.m.findViewById(R.id.obfuscated_res_0x7f090331);
            View findViewById = this.m.findViewById(R.id.obfuscated_res_0x7f09233e);
            this.p = findViewById;
            findViewById.setClickable(true);
            this.C = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090102);
            this.D = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0924ba);
            this.H = (ApkDownloadView) this.m.findViewById(R.id.obfuscated_res_0x7f090142);
            this.I = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090146);
            this.J = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f09044d);
            this.K = this.m.findViewById(R.id.obfuscated_res_0x7f09052d);
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0905a1);
            this.M = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            if (c0() || d0()) {
                setUseDynamicLikeRes();
                setNeedMatchStrategy(true);
            }
            this.N = (AdThreadUserInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f09052e);
            this.Q = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0904a4);
            if (this.G == null) {
                this.G = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d006e, (ViewGroup) null);
            }
            AdCloseView adCloseView = (AdCloseView) this.G.findViewById(R.id.obfuscated_res_0x7f090097);
            this.F = adCloseView;
            adCloseView.k.getLayoutParams().height = ej.g(getContext(), R.dimen.tbds76);
            this.F.k.getLayoutParams().width = ej.g(getContext(), R.dimen.tbds76);
            TextView textView = (TextView) this.G.findViewById(R.id.obfuscated_res_0x7f090a78);
            this.E = textView;
            textView.setVisibility(8);
            this.N.addAdTagView(this.G);
            if (this.o == null) {
                ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f09009e);
                this.n = viewStub;
                viewStub.setLayoutResource(getCustomLayout());
                this.o = this.n.inflate();
            }
            this.O = this.m.findViewById(R.id.obfuscated_res_0x7f09192d);
            this.P = this.m.findViewById(R.id.obfuscated_res_0x7f090bd4);
            this.S = this.m.findViewById(R.id.obfuscated_res_0x7f091927);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f0902a4);
            this.T = adAppInfoView;
            b35 d2 = b35.d(adAppInfoView);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            U(this.o);
            this.V = (VipAdFreeGuideLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0905ee);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
