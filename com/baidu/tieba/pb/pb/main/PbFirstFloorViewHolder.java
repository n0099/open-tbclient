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
import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadlinesAgreeCardView;
import com.baidu.card.view.HeadlinesCardView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.fi9;
import com.baidu.tieba.hj9;
import com.baidu.tieba.oh9;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.rk9;
import com.baidu.tieba.vl9;
import com.baidu.tieba.wg;
import com.baidu.tieba.yi;
import com.baidu.tieba.ze9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vl9 A;
    public VoteView B;
    public TextView C;
    public PbFirstFloorQuestionThreadView D;
    public HeadlinesCardView E;
    public HeadlinesAgreeCardView F;
    public TbImageView G;
    public TextView H;
    public TextView I;
    public TbImageView J;
    public TbImageView K;
    public LinearLayout L;
    public BaseWebView.c M;
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
    public ThreadSkinView k;
    public TextView l;
    public SimpleDraweeView m;
    public LinearLayout n;
    public LinearLayout o;
    public TextView p;
    public AppletsCellView q;
    public View r;
    public NovelMemberCardView s;
    public BaseWebView t;
    public LinearLayout u;
    public fi9 v;
    public FrameLayout w;
    public rk9 x;
    public ThreadForumEnterButtonContainer y;
    public PbBusinessPromotionContainer z;

    /* loaded from: classes7.dex */
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
                return UrlManager.getInstance().dealOneLink(this.a.a, new String[]{str});
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
        this.M = new a(this);
        this.a = tbPageContext;
        this.v = new fi9(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b11);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -hj9.s());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090406);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091ee7);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a81);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015b);
        this.c = view2;
        int l = (((yi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        oh9 oh9Var = new oh9(this.f.getLayoutStrategy());
        oh9Var.J = l;
        this.f.setLayoutStrategy(oh9Var);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dbe);
        int min = Math.min(l - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().r(min);
        this.f.getLayoutStrategy().q((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a04);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f0908f1);
        this.k = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091abf);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac4);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091abe);
        this.m = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091a84);
        this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a83);
        this.q = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090605);
        this.r = view2.findViewById(R.id.obfuscated_res_0x7f0907c4);
        this.s = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f09198b);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f090479);
        this.t = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.t.initCommonJsBridge(tbPageContext.getPageActivity());
        this.t.setOnLoadUrlListener(this.M);
        this.u = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac2);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b0a);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091a98);
        this.y = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.A = new vl9(tbPageContext);
        this.z = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f091a61);
        this.w = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919e9);
        VoteView voteView = (VoteView) view2.findViewById(R.id.vote_view);
        this.B = voteView;
        voteView.setPageContext(tbPageContext);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09277f);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f091a5b);
        this.D = pbFirstFloorQuestionThreadView;
        pbFirstFloorQuestionThreadView.setPageContext(tbPageContext);
        this.E = (HeadlinesCardView) view2.findViewById(R.id.obfuscated_res_0x7f091ab3);
        this.F = (HeadlinesAgreeCardView) view2.findViewById(R.id.obfuscated_res_0x7f091ab2);
        this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dd1);
        this.G = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dcc);
        this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dd0);
        this.I = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dcf);
        this.J = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dcd);
        this.K = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dce);
        if (this.f != null && (tbPageContext.getPageActivity() instanceof PbActivity)) {
            PbActivity pbActivity = (PbActivity) tbPageContext.getPageActivity();
            if (pbActivity.Y1() != null) {
                pbActivity.Y1().W6(this.f);
            }
        }
    }

    @Nullable
    public ImageView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public void d(boolean z, int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || (view2 = this.e) == null) {
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

    public void e(@NonNull ze9 ze9Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ze9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.y != null && ze9Var != null && ze9Var.k() != null) {
            if (ze9Var.i0() && ze9Var.w0()) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setBottomPlaceHolderVisibility(z2);
            ThreadData threadData = new ThreadData();
            threadData.setId(ze9Var.P());
            threadData.setFid(wg.g(ze9Var.k().getId(), 0L));
            threadData.setForum_name(ze9Var.k().getName());
            threadData.setFirstClassName(ze9Var.k().getFirst_class());
            threadData.setSecondClassName(ze9Var.k().getSecond_class());
            if (ze9Var.N() != null) {
                threadData.setThreadType(ze9Var.N().threadType);
            }
            if (ze9Var.i) {
                this.y.setVisibility(8);
                this.z.f(threadData, ze9Var.g(), ze9Var.w0());
                return;
            }
            this.z.setVisibility(8);
        }
    }
}
