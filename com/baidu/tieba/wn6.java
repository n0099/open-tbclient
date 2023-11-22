package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.ad.AbsDownloadGuide;
import com.baidu.tbadk.widget.ad.DownloadGuideFull;
import com.baidu.tbadk.widget.ad.DownloadGuidePart;
import com.baidu.tieba.feed.widget.roundcorners.RoundFrameLayout;
import com.baidu.tieba.u27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.PbContent;
/* loaded from: classes8.dex */
public final class wn6 implements u27.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RoundFrameLayout a;
    public AbsDownloadGuide b;
    public String c;

    public wn6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = "part";
    }

    @Override // com.baidu.tieba.u27.s
    public void b(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            AbsDownloadGuide absDownloadGuide = this.b;
            if (absDownloadGuide == null) {
                Intrinsics.throwUninitializedPropertyAccessException("absDownloadGuide");
                absDownloadGuide = null;
            }
            absDownloadGuide.q();
        }
    }

    @Override // com.baidu.tieba.u27.g
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = new RoundFrameLayout(context);
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds21);
            RoundFrameLayout roundFrameLayout = this.a;
            if (roundFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roundLayout");
                roundFrameLayout = null;
            }
            roundFrameLayout.setRadiusPx(0, 0, dimens, dimens);
            this.b = new DownloadGuidePart(context);
            RoundFrameLayout roundFrameLayout2 = this.a;
            if (roundFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roundLayout");
                roundFrameLayout2 = null;
            }
            AbsDownloadGuide absDownloadGuide = this.b;
            if (absDownloadGuide == null) {
                Intrinsics.throwUninitializedPropertyAccessException("absDownloadGuide");
                absDownloadGuide = null;
            }
            roundFrameLayout2.addView(absDownloadGuide);
            RoundFrameLayout roundFrameLayout3 = this.a;
            if (roundFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roundLayout");
                return null;
            }
            return roundFrameLayout3;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u27.g
    public void g(ViewGroup view2, t57 downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, downloadData) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            Map<String, String> a = downloadData.a().a();
            String b = downloadData.b();
            AbsDownloadGuide absDownloadGuide = null;
            if (!Intrinsics.areEqual(b, this.c)) {
                RoundFrameLayout roundFrameLayout = this.a;
                if (roundFrameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roundLayout");
                    roundFrameLayout = null;
                }
                AbsDownloadGuide absDownloadGuide2 = this.b;
                if (absDownloadGuide2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("absDownloadGuide");
                    absDownloadGuide2 = null;
                }
                roundFrameLayout.removeView(absDownloadGuide2);
                if (Intrinsics.areEqual(b, "part")) {
                    Context context = view2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "view.context");
                    this.b = new DownloadGuidePart(context);
                } else if (Intrinsics.areEqual(b, "full")) {
                    Context context2 = view2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                    this.b = new DownloadGuideFull(context2);
                }
                RoundFrameLayout roundFrameLayout2 = this.a;
                if (roundFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roundLayout");
                    roundFrameLayout2 = null;
                }
                AbsDownloadGuide absDownloadGuide3 = this.b;
                if (absDownloadGuide3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("absDownloadGuide");
                    absDownloadGuide3 = null;
                }
                roundFrameLayout2.addView(absDownloadGuide3);
            }
            ThreadData threadData = new ThreadData();
            ArrayList arrayList = new ArrayList();
            PbContent.Builder builder = new PbContent.Builder();
            builder.type = 35;
            builder.tiebaplus_info = so6.a(downloadData.a());
            PbContent build = builder.build(true);
            Intrinsics.checkNotNullExpressionValue(build, "contentBuilder.build(true)");
            arrayList.add(build);
            threadData.setRichAbstractList(arrayList);
            threadData.isTiebaPlusAdThread = Intrinsics.areEqual(a.get("is_tie_plus_ad"), "1");
            threadData.tiebaPlusOrderId = a.get("tie_plus_order_id");
            threadData.tid = a.get("thread_id");
            threadData.setFid(JavaTypesHelper.toLong(a.get("forum_id"), 0L));
            AbsDownloadGuide absDownloadGuide4 = this.b;
            if (absDownloadGuide4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("absDownloadGuide");
            } else {
                absDownloadGuide = absDownloadGuide4;
            }
            absDownloadGuide.setData(threadData);
        }
    }
}
