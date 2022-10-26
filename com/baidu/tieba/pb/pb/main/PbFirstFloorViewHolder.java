package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.cy7;
import com.baidu.tieba.e18;
import com.baidu.tieba.eh;
import com.baidu.tieba.fj;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.qy7;
import com.baidu.tieba.uv7;
import com.baidu.tieba.wz7;
import com.baidu.tieba.x18;
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
    public x18 B;
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
    public qy7 w;
    public FrameLayout x;
    public e18 y;
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
        this.F = new a(this);
        this.a = tbPageContext;
        this.w = new qy7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091879);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -wz7.i());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903b1);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1a);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f1);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.c = view2;
        int k = (((fj.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        cy7 cy7Var = new cy7(this.f.getLayoutStrategy());
        cy7Var.H = k;
        this.f.setLayoutStrategy(cy7Var);
        this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c66);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().q(min);
        this.f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0907);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f09080d);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09248e);
        this.l = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f09182a);
        this.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182f);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091829);
        this.n = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0917f4);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f3);
        this.r = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090573);
        this.s = view2.findViewById(R.id.obfuscated_res_0x7f0906f7);
        this.t = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f0916ff);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f09040e);
        this.u = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.u.initCommonJsBridge(tbPageContext.getPageActivity());
        this.u.setOnLoadUrlListener(this.F);
        this.v = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182d);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091873);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091807);
        this.z = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.B = new x18(tbPageContext);
        this.A = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0917d2);
        this.x = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091756);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f092633);
        this.C = voteView;
        voteView.setPageContext(tbPageContext);
        this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092417);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f0917cc);
        this.E = pbFirstFloorQuestionThreadView;
        pbFirstFloorQuestionThreadView.setPageContext(tbPageContext);
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

    public void c(uv7 uv7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.z != null && uv7Var != null && uv7Var.l() != null) {
            if (uv7Var.k0() && uv7Var.x0()) {
                this.z.setVisibility(8);
                return;
            }
            this.z.setBottomPlaceHolderVisibility(z2);
            if (!z) {
                ListUtils.isEmpty(uv7Var.p());
            }
            ThreadData threadData = new ThreadData();
            threadData.setId(uv7Var.R());
            threadData.setFid(eh.g(uv7Var.l().getId(), 0L));
            threadData.setForum_name(uv7Var.l().getName());
            threadData.setFirstClassName(uv7Var.l().getFirst_class());
            threadData.setSecondClassName(uv7Var.l().getSecond_class());
            if (uv7Var.P() != null) {
                threadData.setThreadType(uv7Var.P().threadType);
            }
            if (uv7Var.i) {
                this.z.setVisibility(8);
                this.A.f(threadData, uv7Var.h(), uv7Var.x0());
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public void d(uv7 uv7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{uv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (uv7Var != null && uv7Var.j) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080f4c);
                this.d.setVisibility(0);
            } else if (z && z2) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080f8d);
                this.d.setVisibility(0);
            } else if (z) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080f8b);
                this.d.setVisibility(0);
            } else if (z2) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080f8c);
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }
}
