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
import com.baidu.card.view.HeadlinesAgreeCardView;
import com.baidu.card.view.HeadlinesCardView;
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
import com.baidu.tieba.ag8;
import com.baidu.tieba.dc8;
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.hf8;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.rc8;
import com.baidu.tieba.v98;
import com.baidu.tieba.xd8;
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
    public ag8 B;
    public VoteView C;
    public TextView D;
    public PbFirstFloorQuestionThreadView E;
    public HeadlinesCardView F;
    public HeadlinesAgreeCardView G;
    public TbImageView H;
    public TextView I;
    public TextView J;
    public TbImageView K;
    public TbImageView L;
    public LinearLayout M;
    public BaseWebView.c N;
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
    public rc8 w;
    public FrameLayout x;
    public hf8 y;
    public ThreadForumEnterButtonContainer z;

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.c {
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

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (UrlManager.getInstance().dealOneLink(this.a.a, new String[]{str})) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
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
        this.N = new a(this);
        this.a = tbPageContext;
        this.w = new rc8(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091995);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -xd8.t());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903b7);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091d3d);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09190c);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014b);
        this.c = view2;
        int l = (((ej.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        dc8 dc8Var = new dc8(this.f.getLayoutStrategy());
        dc8Var.J = l;
        this.f.setLayoutStrategy(dc8Var);
        this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cf6);
        int min = Math.min(l - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().r(min);
        this.f.getLayoutStrategy().q((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0941);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f09085b);
        this.j = (TbImageView) view2.findViewById(R.id.user_head_mask);
        this.l = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091946);
        this.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09194b);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091945);
        this.n = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09190f);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09190e);
        this.r = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090583);
        this.s = view2.findViewById(R.id.obfuscated_res_0x7f09073a);
        this.t = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f09181b);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f090414);
        this.u = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.u.initCommonJsBridge(tbPageContext.getPageActivity());
        this.u.setOnLoadUrlListener(this.N);
        this.v = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091949);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09198e);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091923);
        this.z = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.B = new ag8(tbPageContext);
        this.A = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0918ed);
        this.x = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091870);
        VoteView voteView = (VoteView) view2.findViewById(R.id.vote_view);
        this.C = voteView;
        voteView.setPageContext(tbPageContext);
        this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092580);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f0918e7);
        this.E = pbFirstFloorQuestionThreadView;
        pbFirstFloorQuestionThreadView.setPageContext(tbPageContext);
        this.F = (HeadlinesCardView) view2.findViewById(R.id.obfuscated_res_0x7f09193b);
        this.G = (HeadlinesAgreeCardView) view2.findViewById(R.id.obfuscated_res_0x7f09193a);
        this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d09);
        this.H = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d04);
        this.I = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d08);
        this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d07);
        this.K = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d05);
        this.L = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d06);
    }

    public void b(boolean z, int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || (view2 = this.e) == null) {
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

    public void c(@NonNull v98 v98Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{v98Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.z != null && v98Var != null && v98Var.l() != null) {
            if (v98Var.l0() && v98Var.y0()) {
                this.z.setVisibility(8);
                return;
            }
            this.z.setBottomPlaceHolderVisibility(z2);
            if (!z) {
                ListUtils.isEmpty(v98Var.p());
            }
            ThreadData threadData = new ThreadData();
            threadData.setId(v98Var.S());
            threadData.setFid(dh.g(v98Var.l().getId(), 0L));
            threadData.setForum_name(v98Var.l().getName());
            threadData.setFirstClassName(v98Var.l().getFirst_class());
            threadData.setSecondClassName(v98Var.l().getSecond_class());
            if (v98Var.Q() != null) {
                threadData.setThreadType(v98Var.Q().threadType);
            }
            if (v98Var.i) {
                this.z.setVisibility(8);
                this.A.f(threadData, v98Var.h(), v98Var.y0());
                return;
            }
            this.A.setVisibility(8);
        }
    }
}
