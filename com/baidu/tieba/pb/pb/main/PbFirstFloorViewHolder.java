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
import com.baidu.tieba.dx7;
import com.baidu.tieba.ej;
import com.baidu.tieba.f08;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.rx7;
import com.baidu.tieba.vu7;
import com.baidu.tieba.xy7;
import com.baidu.tieba.y08;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoteView A;
    public TextView B;
    public PbFirstFloorQuestionThreadView C;
    public BaseWebView.d D;
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
    public LinearLayout n;
    public TextView o;
    public AppletsCellView p;
    public View q;
    public NovelMemberCardView r;
    public BaseWebView s;
    public LinearLayout t;
    public rx7 u;
    public FrameLayout v;
    public f08 w;
    public ThreadForumEnterButtonContainer x;
    public PbBusinessPromotionContainer y;
    public y08 z;

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
        this.D = new a(this);
        this.a = tbPageContext;
        this.u = new rx7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091884);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -xy7.i());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903a8);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ff);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.c = view2;
        int k = (((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        dx7 dx7Var = new dx7(this.f.getLayoutStrategy());
        dx7Var.H = k;
        this.f.setLayoutStrategy(dx7Var);
        this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c5d);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().q(min);
        this.f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0906);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f090804);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924a1);
        this.l = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091836);
        this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09183b);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091835);
        this.p = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f09056a);
        this.q = view2.findViewById(R.id.obfuscated_res_0x7f0906ee);
        this.r = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f09170d);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f090405);
        this.s = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.s.initCommonJsBridge(tbPageContext.getPageActivity());
        this.s.setOnLoadUrlListener(this.D);
        this.t = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091839);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09187e);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091813);
        this.x = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.z = new y08(tbPageContext);
        this.y = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0917e0);
        this.v = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091764);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f092648);
        this.A = voteView;
        voteView.setPageContext(tbPageContext);
        this.B = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09242a);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
        this.C = pbFirstFloorQuestionThreadView;
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

    public void c(@NonNull vu7 vu7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{vu7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.x == null || vu7Var == null || vu7Var.l() == null) {
            return;
        }
        if (vu7Var.i0() && vu7Var.u0()) {
            this.x.setVisibility(8);
            return;
        }
        this.x.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(vu7Var.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(vu7Var.Q());
        threadData.setFid(dh.g(vu7Var.l().getId(), 0L));
        threadData.setForum_name(vu7Var.l().getName());
        threadData.setFirstClassName(vu7Var.l().getFirst_class());
        threadData.setSecondClassName(vu7Var.l().getSecond_class());
        if (vu7Var.O() != null) {
            threadData.setThreadType(vu7Var.O().threadType);
        }
        if (vu7Var.i) {
            this.x.setVisibility(8);
            this.y.f(threadData, vu7Var.h(), vu7Var.u0());
            return;
        }
        this.y.setVisibility(8);
    }
}
