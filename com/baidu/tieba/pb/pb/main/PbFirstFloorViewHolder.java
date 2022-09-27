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
import com.baidu.tbadk.afx.TbAlphaVideo;
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
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.fy7;
import com.baidu.tieba.jv7;
import com.baidu.tieba.lz7;
import com.baidu.tieba.m18;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.rx7;
import com.baidu.tieba.t08;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbBusinessPromotionContainer A;
    public m18 B;
    public VoteView C;
    public TextView D;
    public PbFirstFloorQuestionThreadView E;
    public BaseWebView.d F;
    public TbPageContext a;
    public int b;
    public View c;
    public ImageView d;
    public View e;
    public TbRichTextView f;
    public RelativeLayout g;
    public TbAlphaVideo h;
    public View i;
    public TbImageView j;
    public TbImageView k;
    public ThreadSkinView l;
    public TextView m;
    public SimpleDraweeView n;
    public LinearLayout o;
    public LinearLayout p;
    public TextView q;
    public AppletsCellView r;
    public View s;
    public NovelMemberCardView t;
    public BaseWebView u;
    public LinearLayout v;
    public fy7 w;
    public FrameLayout x;
    public t08 y;
    public ThreadForumEnterButtonContainer z;

    /* loaded from: classes5.dex */
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
        this.F = new a(this);
        this.a = tbPageContext;
        this.w = new fy7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091886);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -lz7.i());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903a8);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1d);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ff);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.c = view2;
        int k = (((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        rx7 rx7Var = new rx7(this.f.getLayoutStrategy());
        rx7Var.H = k;
        this.f.setLayoutStrategy(rx7Var);
        this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c5c);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().q(min);
        this.f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0906);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f090804);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924a3);
        this.l = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091838);
        this.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09183d);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091837);
        this.n = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091802);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091801);
        this.r = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f09056a);
        this.s = view2.findViewById(R.id.obfuscated_res_0x7f0906ee);
        this.t = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f09170d);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f090405);
        this.u = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.u.initCommonJsBridge(tbPageContext.getPageActivity());
        this.u.setOnLoadUrlListener(this.F);
        this.v = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09183b);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091880);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091815);
        this.z = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.B = new m18(tbPageContext);
        this.A = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0917e0);
        this.x = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091764);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f09264a);
        this.C = voteView;
        voteView.setPageContext(tbPageContext);
        this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09242c);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
        this.E = pbFirstFloorQuestionThreadView;
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

    public void c(@NonNull jv7 jv7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.z == null || jv7Var == null || jv7Var.l() == null) {
            return;
        }
        if (jv7Var.i0() && jv7Var.u0()) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(jv7Var.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(jv7Var.Q());
        threadData.setFid(dh.g(jv7Var.l().getId(), 0L));
        threadData.setForum_name(jv7Var.l().getName());
        threadData.setFirstClassName(jv7Var.l().getFirst_class());
        threadData.setSecondClassName(jv7Var.l().getSecond_class());
        if (jv7Var.O() != null) {
            threadData.setThreadType(jv7Var.O().threadType);
        }
        if (jv7Var.i) {
            this.z.setVisibility(8);
            this.A.f(threadData, jv7Var.h(), jv7Var.u0());
            return;
        }
        this.A.setVisibility(8);
    }
}
