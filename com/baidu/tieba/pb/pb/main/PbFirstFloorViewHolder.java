package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.et7;
import com.repackage.fw7;
import com.repackage.kx7;
import com.repackage.kz7;
import com.repackage.og;
import com.repackage.qi;
import com.repackage.rv7;
import com.repackage.ty7;
/* loaded from: classes3.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFirstFloorQuestionThreadView A;
    public BaseWebView.d B;
    public TbPageContext a;
    public int b;
    public View c;
    public ImageView d;
    public View e;
    public TbRichTextView f;
    public View g;
    public TbImageView h;
    public TbImageView i;
    public ThreadSkinView j;
    public TextView k;
    public LinearLayout l;
    public TextView m;
    public AppletsCellView n;
    public View o;
    public NovelMemberCardView p;
    public BaseWebView q;
    public LinearLayout r;
    public fw7 s;
    public FrameLayout t;
    public ty7 u;
    public ThreadForumEnterButtonContainer v;
    public PbBusinessPromotionContainer w;
    public kz7 x;
    public VoteView y;
    public TextView z;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;

        public a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorViewHolder;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) ? UrlManager.getInstance().dealOneLink(this.a.a, new String[]{str}) : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view2, boolean z, int i) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.B = new a(this);
        this.a = tbPageContext;
        this.s = new fw7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09184c);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -kx7.i());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f09039d);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091bd2);
        this.c = view2;
        int k = (((qi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        rv7 rv7Var = new rv7(this.f.getLayoutStrategy());
        rv7Var.H = k;
        this.f.setLayoutStrategy(rv7Var);
        this.i = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c41);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().q(min);
        this.f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08e5);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f0907ee);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09243d);
        this.j = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f0917fe);
        this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091803);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917fd);
        this.n = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f09055b);
        this.o = view2.findViewById(R.id.obfuscated_res_0x7f0906d8);
        this.p = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f0916d6);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f0903f9);
        this.q = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.q.initCommonJsBridge(tbPageContext.getPageActivity());
        this.q.setOnLoadUrlListener(this.B);
        this.r = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091801);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091846);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f0917db);
        this.v = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.x = new kz7(tbPageContext);
        this.w = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0917a9);
        this.t = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09172d);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f0925e2);
        this.y = voteView;
        voteView.setPageContext(tbPageContext);
        this.z = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923c7);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f0917a3);
        this.A = pbFirstFloorQuestionThreadView;
        pbFirstFloorQuestionThreadView.setPageContext(tbPageContext);
    }

    public void b(boolean z, int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (view2 = this.e) == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.height = i;
            this.e.setLayoutParams(layoutParams);
            this.e.setVisibility(0);
            return;
        }
        view2.setVisibility(8);
    }

    public void c(@NonNull et7 et7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{et7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.v == null || et7Var == null || et7Var.l() == null) {
            return;
        }
        if (et7Var.i0() && et7Var.u0()) {
            this.v.setVisibility(8);
            return;
        }
        this.v.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(et7Var.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(et7Var.Q());
        threadData.setFid(og.g(et7Var.l().getId(), 0L));
        threadData.setForum_name(et7Var.l().getName());
        threadData.setFirstClassName(et7Var.l().getFirst_class());
        threadData.setSecondClassName(et7Var.l().getSecond_class());
        if (et7Var.O() != null) {
            threadData.setThreadType(et7Var.O().threadType);
        }
        if (et7Var.i) {
            this.v.setVisibility(8);
            this.w.f(threadData, et7Var.h(), et7Var.u0());
            return;
        }
        this.w.setVisibility(8);
    }
}
