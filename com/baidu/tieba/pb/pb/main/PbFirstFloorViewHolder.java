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
import com.baidu.tieba.ac9;
import com.baidu.tieba.cd9;
import com.baidu.tieba.jb9;
import com.baidu.tieba.me9;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.pf9;
import com.baidu.tieba.u89;
import com.baidu.tieba.vg;
import com.baidu.tieba.xi;
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
    public pf9 A;
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
    public ac9 v;
    public FrameLayout w;
    public me9 x;
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
        this.v = new ac9(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091afa);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -cd9.s());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090406);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091eb4);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a6a);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015b);
        this.c = view2;
        int l = (((xi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        jb9 jb9Var = new jb9(this.f.getLayoutStrategy());
        jb9Var.J = l;
        this.f.setLayoutStrategy(jb9Var);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090db1);
        int min = Math.min(l - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().r(min);
        this.f.getLayoutStrategy().q((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d09ea);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f0908f0);
        this.k = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091aa8);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091aad);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091aa7);
        this.m = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091a6d);
        this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a6c);
        this.q = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090603);
        this.r = view2.findViewById(R.id.obfuscated_res_0x7f0907c3);
        this.s = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f091974);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f090478);
        this.t = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.t.initCommonJsBridge(tbPageContext.getPageActivity());
        this.t.setOnLoadUrlListener(this.M);
        this.u = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091aab);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091af3);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091a81);
        this.y = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.A = new pf9(tbPageContext);
        this.z = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f091a4a);
        this.w = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919d2);
        VoteView voteView = (VoteView) view2.findViewById(R.id.vote_view);
        this.B = voteView;
        voteView.setPageContext(tbPageContext);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09274a);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f091a44);
        this.D = pbFirstFloorQuestionThreadView;
        pbFirstFloorQuestionThreadView.setPageContext(tbPageContext);
        this.E = (HeadlinesCardView) view2.findViewById(R.id.obfuscated_res_0x7f091a9c);
        this.F = (HeadlinesAgreeCardView) view2.findViewById(R.id.obfuscated_res_0x7f091a9b);
        this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dc4);
        this.G = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dbf);
        this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc3);
        this.I = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc2);
        this.J = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dc0);
        this.K = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dc1);
        if (this.f != null && (tbPageContext.getPageActivity() instanceof PbActivity)) {
            PbActivity pbActivity = (PbActivity) tbPageContext.getPageActivity();
            if (pbActivity.Y1() != null) {
                pbActivity.Y1().W6(this.f);
            }
        }
    }

    @Nullable
    public ImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public void c(boolean z, int i) {
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

    public void d(@NonNull u89 u89Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{u89Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.y != null && u89Var != null && u89Var.k() != null) {
            if (u89Var.i0() && u89Var.w0()) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setBottomPlaceHolderVisibility(z2);
            ThreadData threadData = new ThreadData();
            threadData.setId(u89Var.P());
            threadData.setFid(vg.g(u89Var.k().getId(), 0L));
            threadData.setForum_name(u89Var.k().getName());
            threadData.setFirstClassName(u89Var.k().getFirst_class());
            threadData.setSecondClassName(u89Var.k().getSecond_class());
            if (u89Var.N() != null) {
                threadData.setThreadType(u89Var.N().threadType);
            }
            if (u89Var.i) {
                this.y.setVisibility(8);
                this.z.f(threadData, u89Var.g(), u89Var.w0());
                return;
            }
            this.z.setVisibility(8);
        }
    }
}
