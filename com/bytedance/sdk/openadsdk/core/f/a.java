package com.bytedance.sdk.openadsdk.core.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.bannerexpress.b;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.u;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.a.c;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a implements TTNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66195a;

    /* renamed from: b  reason: collision with root package name */
    public TTNativeExpressAd f66196b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f66197c;

    /* renamed from: d  reason: collision with root package name */
    public View f66198d;

    /* renamed from: e  reason: collision with root package name */
    public float f66199e;

    /* renamed from: f  reason: collision with root package name */
    public float f66200f;

    /* renamed from: g  reason: collision with root package name */
    public final n f66201g;

    /* renamed from: h  reason: collision with root package name */
    public final m f66202h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f66203i;

    /* renamed from: j  reason: collision with root package name */
    public TTAdDislike f66204j;
    public DownloadStatusController k;
    public int l;
    public AdSlot m;
    public AtomicBoolean n;
    public AtomicBoolean o;
    public TTNativeAd.ExpressRenderListener p;
    public TTNativeAd.AdInteractionListener q;
    public TextView r;

    public a(@NonNull Context context, @NonNull m mVar, int i2, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, Integer.valueOf(i2), adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        p.a(mVar, "materialMeta不能为null");
        this.f66202h = mVar;
        this.f66203i = context;
        this.l = i2;
        this.m = adSlot;
        this.f66201g = new n(context, this, mVar, a(i2));
        this.f66196b = a(this.f66202h);
        b();
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 5 ? i2 != 6 ? i2 != 9 ? "embeded_ad" : "draw_ad" : "stream" : "embeded_ad" : ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE : "banner_ad" : (String) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tTNativeExpressAd = this.f66196b) == null) {
            return;
        }
        tTNativeExpressAd.destroy();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null) {
                return BitmapFactory.decodeResource(this.f66203i.getResources(), t.d(o.a(), "tt_ad_logo_new"));
            }
            String aO = mVar.aO();
            if (TextUtils.isEmpty(aO)) {
                return BitmapFactory.decodeResource(this.f66203i.getResources(), t.d(o.a(), "tt_ad_logo_new"));
            }
            if (this.r == null) {
                this.r = new TextView(o.a());
                this.r.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            s.a(this.r, aO, o.a());
            return s.g(this.r);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f66202h.al() != null) {
                return this.f66202h.al().f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f66202h.al() != null) {
                return this.f66202h.al().e();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f66202h.al() != null) {
                return this.f66202h.al().g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66202h.aj() : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TextUtils.isEmpty(this.f66202h.ah())) {
                return this.f66202h.ah();
            }
            return this.f66202h.ai();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            if (this.f66196b != null && this.o.get()) {
                return this.f66196b.getDislikeDialog(activity);
            }
            if (this.f66204j == null) {
                a(activity);
            }
            return this.f66204j;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null || mVar.aG() == null) {
                return null;
            }
            this.f66202h.aG().b(a(this.l));
            return new com.bytedance.sdk.openadsdk.dislike.c.a(this.f66202h.aG());
        }
        return (DislikeInfo) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        InterceptResult invokeV;
        n nVar;
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f66196b == null || !this.n.get()) {
                if (this.k == null && (nVar = this.f66201g) != null && (a2 = nVar.a()) != null) {
                    this.k = new DownloadStatusController(this, a2) { // from class: com.bytedance.sdk.openadsdk.core.f.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.core.a f66207a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f66208b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66208b = this;
                            this.f66207a = a2;
                        }

                        @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                        public void cancelDownload() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f66207a.f();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                        public void changeDownloadStatus() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.f66207a.e();
                            }
                        }
                    };
                }
                return this.k;
            }
            return null;
        }
        return (DownloadStatusController) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f66202h.Y() == null) {
                return null;
            }
            return l.a(this.f66202h.Y());
        }
        return (TTImage) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f66202h.ad() != null && !this.f66202h.ad().isEmpty()) {
                for (l lVar : this.f66202h.ad()) {
                    arrayList.add(l.a(lVar));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null) {
                return -1;
            }
            return mVar.ap();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            m mVar = this.f66202h;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f66202h.W() : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f66202h.al() != null && !TextUtils.isEmpty(this.f66202h.al().c())) {
                return this.f66202h.al().c();
            }
            if (!TextUtils.isEmpty(getSource())) {
                return getSource();
            }
            return this.f66202h.ah();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null || mVar.V() == null) {
                return null;
            }
            return new TTImage(this.f66202h.V().b(), this.f66202h.V().c(), this.f66202h.V().h(), 0.0d);
        }
        return (TTImage) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, viewGroup, view, adInteractionListener) == null) {
            boolean z = false;
            p.a(viewGroup != null || this.o.get(), "container不能为null");
            p.a((view != null || this.o.get()) ? true : true, "clickView不能为null");
            this.f66197c = viewGroup;
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(view);
            registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, activity) == null) || activity == null) {
            return;
        }
        this.f66201g.a(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        TTNativeExpressAd tTNativeExpressAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, activity, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null || activity == null || (tTNativeExpressAd = this.f66196b) == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, tTDislikeDialogAbstract) == null) {
            tTDislikeDialogAbstract.setDislikeModel(this.f66202h.aG());
            TTNativeExpressAd tTNativeExpressAd = this.f66196b;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeDialog(tTDislikeDialogAbstract);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, tTAppDownloadListener) == null) {
            p.a(tTAppDownloadListener, "downloadListener不能为null");
            this.f66201g.a(tTAppDownloadListener);
            TTNativeExpressAd tTNativeExpressAd = this.f66196b;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDownloadListener(tTAppDownloadListener);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, expressRenderListener) == null) {
            this.p = expressRenderListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, activity) == null) || (tTNativeExpressAd = this.f66196b) == null) {
            return;
        }
        tTNativeExpressAd.showInteractionExpressAd(activity);
    }

    private void c() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (viewGroup = this.f66197c) == null || this.f66196b == null || this.f66198d == null) {
            return;
        }
        viewGroup.removeAllViews();
        if (this.f66198d.getParent() != null) {
            ((ViewGroup) this.f66198d.getParent()).removeAllViews();
        }
        this.f66197c.addView(this.f66198d);
    }

    private void b() {
        TTNativeAd.ExpressRenderListener expressRenderListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.f66196b == null) {
                TTNativeAd.ExpressRenderListener expressRenderListener2 = this.p;
                if (expressRenderListener2 != null) {
                    expressRenderListener2.onRenderSuccess(this.f66197c, this.m.getExpressViewAcceptedWidth(), this.m.getExpressViewAcceptedHeight(), false);
                }
            } else if (this.n.get() && (expressRenderListener = this.p) != null) {
                expressRenderListener.onRenderSuccess(this.f66198d, this.f66199e, this.f66200f, this.o.get());
            } else {
                this.f66196b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.core.f.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66209a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66209a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || this.f66209a.q == null) {
                            return;
                        }
                        this.f66209a.q.onAdClicked(view, this.f66209a);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) || this.f66209a.q == null) {
                            return;
                        }
                        this.f66209a.q.onAdShow(this.f66209a);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
                            this.f66209a.n.set(true);
                            a aVar = this.f66209a;
                            aVar.f66198d = aVar.f66197c;
                            a aVar2 = this.f66209a;
                            aVar2.f66199e = aVar2.m.getExpressViewAcceptedWidth();
                            a aVar3 = this.f66209a;
                            aVar3.f66200f = aVar3.m.getExpressViewAcceptedHeight();
                            if (this.f66209a.p != null) {
                                this.f66209a.p.onRenderSuccess(this.f66209a.f66197c, this.f66209a.m.getExpressViewAcceptedWidth(), this.f66209a.m.getExpressViewAcceptedHeight(), false);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            this.f66209a.n.set(true);
                            this.f66209a.o.set(true);
                            this.f66209a.f66198d = view;
                            this.f66209a.f66199e = f2;
                            this.f66209a.f66200f = f3;
                            if (this.f66209a.p != null) {
                                this.f66209a.p.onRenderSuccess(view, f2, f3, true);
                            }
                        }
                    }
                });
                this.f66196b.render();
            }
        }
    }

    private List<View> a(List<View> list, List<View> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, list, list2)) == null) {
            LinkedList linkedList = new LinkedList();
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    linkedList.add(list.get(i2));
                }
            }
            if (list2 != null && !list2.isEmpty()) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    linkedList.add(list2.get(i3));
                }
            }
            return linkedList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tTDislikeDialogAbstract)) == null) {
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.setDislikeModel(this.f66202h.aG());
                return new TTAdDislike(this, tTDislikeDialogAbstract) { // from class: com.bytedance.sdk.openadsdk.core.f.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTDislikeDialogAbstract f66205a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f66206b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tTDislikeDialogAbstract};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66206b = this;
                        this.f66205a = tTDislikeDialogAbstract;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                    public boolean isShow() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return false;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                    public void resetDislikeStatus() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dislikeInteractionCallback) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                    public void setDislikeSource(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, str) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                    public void showDislikeDialog() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            if ((this.f66205a.getContext() instanceof Activity) && !((Activity) this.f66205a.getContext()).isFinishing()) {
                                this.f66205a.show();
                            }
                        }
                    }
                };
            }
            throw new IllegalArgumentException("dialog is null, please check");
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048598, this, viewGroup, list, list2, adInteractionListener) == null) {
            p.a(viewGroup != null || this.o.get(), "container不能为null");
            p.a(list != null || this.o.get(), "clickView不能为null");
            p.a(list.size() > 0, "clickViews数量必须大于等于1");
            this.f66197c = viewGroup;
            registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context] */
    private void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, activity) == null) {
            Context context = this.f66203i;
            Activity activity2 = activity;
            if (context instanceof Activity) {
                activity2 = activity;
                if (!((Activity) context).isFinishing()) {
                    activity2 = this.f66203i;
                }
            }
            this.f66204j = new com.bytedance.sdk.openadsdk.dislike.ui.a(activity2, this.f66202h.aG(), a(this.l), false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, viewGroup, list, list2, view, adInteractionListener) == null) {
            p.a(viewGroup != null || this.o.get(), "container不能为null");
            p.a(list != null || this.o.get(), "clickView不能为null");
            p.a(list.size() > 0, "clickViews数量必须大于等于1");
            this.f66197c = viewGroup;
            registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            c c2 = c.b().a(this.l).c(String.valueOf(q.d(this.f66202h.ao())));
            if (z) {
                com.bytedance.sdk.openadsdk.j.a.a().i(c2);
            } else {
                com.bytedance.sdk.openadsdk.j.a.a().j(c2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{viewGroup, list, list2, list3, view, adInteractionListener}) == null) {
            boolean z = false;
            p.a(viewGroup != null || this.o.get(), "container不能为null");
            p.a(list2 != null || this.o.get(), "clickView不能为null");
            p.a(list2.size() > 0, "clickViews数量必须大于等于1");
            this.f66197c = viewGroup;
            this.q = adInteractionListener;
            if (list3 != null && list3.size() > 0) {
                z = true;
            }
            a(z);
            if (a()) {
                list3 = a(list2, list3);
            }
            List<View> list4 = list3;
            if (this.o.get() && ((i2 = this.l) == 5 || i2 == 1 || i2 == 9)) {
                c();
            }
            if (!this.o.get()) {
                this.f66201g.a(viewGroup, list, list2, list4, view, adInteractionListener);
            }
            TTAdDislike tTAdDislike = this.f66204j;
            if (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.ui.a) {
                ((com.bytedance.sdk.openadsdk.dislike.ui.a) tTAdDislike).a(this.f66197c);
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null || mVar.X() == 5) {
                return false;
            }
            if (this.f66195a == 0) {
                this.f66195a = q.d(this.f66202h.ao());
            }
            return o.h().e(this.f66195a) == 1;
        }
        return invokeV.booleanValue;
    }

    private TTNativeExpressAd a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mVar)) == null) {
            m mVar2 = this.f66202h;
            if (mVar2 == null || mVar2.d() != 2) {
                return null;
            }
            int i2 = this.l;
            if (i2 == 1) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f66203i, mVar, this.m);
                }
                return new b(this.f66203i, mVar, this.m);
            } else if (i2 == 2) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.d.c(this.f66203i, mVar, this.m);
                }
                return new com.bytedance.sdk.openadsdk.core.d.b(this.f66203i, mVar, this.m);
            } else if (i2 != 5) {
                if (i2 != 9) {
                    return null;
                }
                return new com.bytedance.sdk.openadsdk.core.nativeexpress.s(this.f66203i, mVar, this.m);
            } else if (mVar.V() != null) {
                return new u(this.f66203i, mVar, this.m);
            } else {
                return new com.bytedance.sdk.openadsdk.core.nativeexpress.q(this.f66203i, mVar, this.m);
            }
        }
        return (TTNativeExpressAd) invokeL.objValue;
    }
}
