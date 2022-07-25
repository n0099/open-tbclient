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
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdLottieButtonView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a01;
import com.repackage.dh0;
import com.repackage.eh0;
import com.repackage.ei;
import com.repackage.hk5;
import com.repackage.k98;
import com.repackage.ni;
import com.repackage.pi;
import com.repackage.qn4;
import com.repackage.rk5;
import com.repackage.sc6;
import com.repackage.sk5;
import com.repackage.t98;
import com.repackage.tc6;
import com.repackage.tc7;
import com.repackage.tw4;
import com.repackage.vr4;
import com.repackage.wa8;
import com.repackage.zz0;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class c implements k98 {
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

        @Override // com.repackage.k98
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean b = dh0.b(this.b.i.getPageActivity(), this.a.downloadInfo.a);
                HashMap<String, Object> M = this.b.M("try_button");
                if (this.b.k != null) {
                    this.b.k.a(1, M);
                }
                return b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                zz0.a().b(this.a.getContext());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                tw4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.d() || (advertAppInfo = this.a) == null) {
                    return false;
                }
                ei.a(advertAppInfo.c());
                ((Vibrator) this.b.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class j implements sk5.a {
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

        @Override // com.repackage.sk5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                hk5.a(this.a);
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                int k2 = (pi.k(getContext()) - (this.w * 2)) - (this.t * 2);
                int i3 = this.q;
                int i4 = this.r;
                this.B = (k2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.S.setVisibility(0);
                K(this.G);
                if (f0(adCard)) {
                    this.S.setVisibility(8);
                    this.m.setPadding(0, 0, 0, 0);
                    View view3 = this.K;
                    int i5 = this.t;
                    view3.setPadding(i5, 0, i5, 0);
                    layoutParams2.leftMargin = 0;
                    this.B = (pi.k(getContext()) - (this.t * 2)) - (this.w * 2);
                    layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.R.setVisibility(0);
                    SkinManager.setBackgroundColor(this.R, R.color.CAM_X0204);
                    J(this.G);
                    return;
                }
                return;
            }
            View view4 = this.m;
            int i6 = this.s;
            view4.setPadding(i6, this.u, i6, 0);
            this.B = (pi.k(getContext()) - (this.s * 2)) - (this.v * 2);
            if ((tc6.f().i() || sc6.h().j()) && e0()) {
                this.p.setVisibility(0);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            } else {
                this.p.setVisibility(8);
            }
            this.S.setVisibility(8);
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

    public abstract void O(AdCard adCard);

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

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (!ni.A()) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0c17);
                return;
            }
            AdCard adCard = this.L;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            String extInfo = this.L.getExtInfo();
            String downloadId = this.L.getDownloadId();
            String str2 = this.L.scheme;
            String buttonCmdScheme = NativeConstants.ID_BUTTON.equals(str) ? this.L.getButtonCmdScheme() : this.L.cmdScheme;
            boolean z = false;
            if (advertAppInfo != null && advertAppInfo.g() && !eh0.n(this.L.cmdScheme)) {
                z = dh0.b(this.i.getPageActivity(), advertAppInfo.p);
            }
            int b2 = z ? 3 : t98.b(this.i, str2, downloadId, extInfo, buttonCmdScheme);
            HashMap<String, Object> M = M(str);
            tc7 tc7Var = this.k;
            if (tc7Var != null) {
                tc7Var.a(b2, M);
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
                pi.b(this.i.getPageActivity(), this.G, 40, 40, 40, 120);
                this.G.setOnClickListener(new b(this));
                return;
            }
            this.F.setVisibility(8);
            this.E.setOnClickListener(null);
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
            this.I.setText(wa8.e(str, this.i.getString(R.string.obfuscated_res_0x7f0f00dd), i2, this.I.getPaint()));
            this.I.setOnClickListener(new l(this));
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

    public abstract void U(View view2);

    public final void V(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            l0(adCard);
            this.D.setVisibility(8);
            this.H.setVisibility(0);
            this.H.setClickable(true);
            this.H.setInitText(adCard.getButtonText());
            this.H.setOnClickInterceptListener(new j(this, adCard.getButtonCmdScheme()));
            new rk5(this.H, wa8.d(adCard));
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.o instanceof RelativeLayout) {
                AdLottieButtonView adLottieButtonView = new AdLottieButtonView(this.i.getPageActivity());
                this.U = adLottieButtonView;
                adLottieButtonView.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = pi.f(this.i.getPageActivity(), R.dimen.M_H_X003);
                layoutParams.leftMargin = pi.f(this.i.getPageActivity(), R.dimen.M_W_X004);
                View view2 = this.o;
                if (view2 instanceof RelativeLayout) {
                    ((RelativeLayout) view2).addView(this.U, layoutParams);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.G = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d006a, (ViewGroup) null);
            ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f090099);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.o = this.n.inflate();
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

    public final void Z(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, adCard, advertAppInfo) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.J.setVisibility(0);
                if (advertAppInfo.g()) {
                    V(adCard);
                    return;
                } else if (advertAppInfo.k()) {
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

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getBusinessType() == 1 : invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getBusinessType() == 2 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.repackage.pd7
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && g0()) {
            this.C.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.b == 1 : invokeV.booleanValue;
    }

    public boolean f0(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, adCard)) == null) ? g0() && adCard.isPBBanner : invokeL.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getBusinessType() == 4 : invokeV.booleanValue;
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public final boolean h0(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, view2, viewGroup)) == null) ? (view2 == null || view2.getParent() == null || view2.getParent() != viewGroup) ? false : true : invokeLL.booleanValue;
    }

    public final void i0(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, view2, viewGroup) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
            viewGroup.addView(view2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: j0 */
    public void t(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, adCard, i2) == null) {
            this.F.onChangeSkinType();
            this.N.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.M.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view2 = this.m;
                view2.setBackgroundDrawable(wa8.f(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view2.getMeasuredHeight()));
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
            vr4 d2 = vr4.d(this.T);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            this.T.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: k0 */
    public void u(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, adCard) == null) {
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
            m0(adCard);
            this.m.setOnClickListener(new d(this));
            if (a01.a) {
                this.m.setOnLongClickListener(new e(this));
            }
            O(adCard);
            t(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void l0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, adCard) == null) {
            qn4 appInfoModel = adCard.getAppInfoModel();
            RelativeLayout downloadButtonContainer = this.T.getDownloadButtonContainer();
            if (qn4.a(appInfoModel)) {
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

    public final void m0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, adCard) == null) {
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

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.m == null) {
                this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            }
            this.R = this.m.findViewById(R.id.obfuscated_res_0x7f09030a);
            View findViewById = this.m.findViewById(R.id.obfuscated_res_0x7f09204d);
            this.p = findViewById;
            findViewById.setClickable(true);
            this.C = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900f0);
            this.D = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0921c6);
            this.H = (ApkDownloadView) this.m.findViewById(R.id.obfuscated_res_0x7f09013f);
            this.I = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090143);
            this.J = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0903de);
            this.K = this.m.findViewById(R.id.obfuscated_res_0x7f0904a4);
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090519);
            this.M = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            if (c0() || d0()) {
                setUseDynamicLikeRes();
                setNeedMatchStrategy(c0());
            }
            this.N = (AdThreadUserInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0904a5);
            this.Q = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090427);
            if (this.G == null) {
                this.G = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d006a, (ViewGroup) null);
            }
            AdCloseView adCloseView = (AdCloseView) this.G.findViewById(R.id.obfuscated_res_0x7f090092);
            this.F = adCloseView;
            adCloseView.k.getLayoutParams().height = pi.f(getContext(), R.dimen.tbds76);
            this.F.k.getLayoutParams().width = pi.f(getContext(), R.dimen.tbds76);
            TextView textView = (TextView) this.G.findViewById(R.id.obfuscated_res_0x7f090963);
            this.E = textView;
            textView.setVisibility(8);
            this.N.addAdTagView(this.G);
            if (this.o == null) {
                ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f090099);
                this.n = viewStub;
                viewStub.setLayoutResource(getCustomLayout());
                this.o = this.n.inflate();
            }
            this.O = this.m.findViewById(R.id.obfuscated_res_0x7f0916de);
            this.P = this.m.findViewById(R.id.obfuscated_res_0x7f090aa4);
            this.S = this.m.findViewById(R.id.obfuscated_res_0x7f0916d9);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f090288);
            this.T = adAppInfoView;
            vr4 d2 = vr4.d(adAppInfoView);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            U(this.o);
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public void setNeedMatchStrategy(boolean z) {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (adThreadCommentAndPraiseInfoLayout = this.M) == null) {
            return;
        }
        adThreadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
    }

    public void setUseDynamicLikeRes() {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (adThreadCommentAndPraiseInfoLayout = this.M) == null) {
            return;
        }
        adThreadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
    }
}
