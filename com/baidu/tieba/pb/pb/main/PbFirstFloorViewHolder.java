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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.aj9;
import com.baidu.tieba.dm9;
import com.baidu.tieba.hp9;
import com.baidu.tieba.lq9;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.pb.view.PbFirstFloorQuestionThreadView;
import com.baidu.tieba.um9;
import com.baidu.tieba.wn9;
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
    public lq9 A;
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
    public um9 v;
    public FrameLayout w;
    public hp9 x;
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
        this.v = new um9(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b69);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -wn9.r());
        this.d.setImageMatrix(matrix);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090411);
        this.f = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f50);
        this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ad9);
        this.h = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015a);
        this.c = view2;
        int equipmentWidth = (((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.f.getPaddingLeft()) - this.f.getPaddingRight();
        dm9 dm9Var = new dm9(this.f.getLayoutStrategy());
        dm9Var.J = equipmentWidth;
        this.f.setLayoutStrategy(dm9Var);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dd9);
        int min = Math.min(equipmentWidth - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f.getLayoutStrategy().r(min);
        this.f.getLayoutStrategy().q((int) (min * 1.618f));
        this.f.setIsNeedResizeEmotion(true);
        this.f.setTextSize(TbConfig.getContentSize());
        this.f.setDisplayImage(z, false);
        this.f.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a29);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f0908fc);
        this.k = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091b16);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b1b);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b15);
        this.m = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091adc);
        this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091adb);
        this.q = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f09061a);
        this.r = view2.findViewById(R.id.obfuscated_res_0x7f0907cc);
        this.s = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f0919df);
        BaseWebView baseWebView = (BaseWebView) view2.findViewById(R.id.obfuscated_res_0x7f090492);
        this.t = baseWebView;
        baseWebView.setBackgroundColor(0);
        this.t.initCommonJsBridge(tbPageContext.getPageActivity());
        this.t.setOnLoadUrlListener(this.M);
        this.u = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b19);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b62);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.y = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.A = new lq9(tbPageContext);
        this.z = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f091ab8);
        this.w = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a40);
        VoteView voteView = (VoteView) view2.findViewById(R.id.vote_view);
        this.B = voteView;
        voteView.setPageContext(tbPageContext);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092803);
        PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView = (PbFirstFloorQuestionThreadView) view2.findViewById(R.id.obfuscated_res_0x7f091ab2);
        this.D = pbFirstFloorQuestionThreadView;
        pbFirstFloorQuestionThreadView.setPageContext(tbPageContext);
        this.E = (HeadlinesCardView) view2.findViewById(R.id.obfuscated_res_0x7f091b0a);
        this.F = (HeadlinesAgreeCardView) view2.findViewById(R.id.obfuscated_res_0x7f091b09);
        this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dec);
        this.G = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090de7);
        this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090deb);
        this.I = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dea);
        this.J = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090de8);
        this.K = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090de9);
        if (this.f != null && (tbPageContext.getPageActivity() instanceof PbActivity)) {
            PbActivity pbActivity = (PbActivity) tbPageContext.getPageActivity();
            if (pbActivity.Z1() != null) {
                pbActivity.Z1().s8(this.f);
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

    public void d(@NonNull aj9 aj9Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aj9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.y != null && aj9Var != null && aj9Var.k() != null) {
            if (aj9Var.j0() && aj9Var.x0()) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setBottomPlaceHolderVisibility(z2);
            ThreadData threadData = new ThreadData();
            threadData.setId(aj9Var.Q());
            threadData.setFid(JavaTypesHelper.toLong(aj9Var.k().getId(), 0L));
            threadData.setForum_name(aj9Var.k().getName());
            threadData.setFirstClassName(aj9Var.k().getFirst_class());
            threadData.setSecondClassName(aj9Var.k().getSecond_class());
            if (aj9Var.O() != null) {
                threadData.setThreadType(aj9Var.O().threadType);
            }
            if (aj9Var.i) {
                this.y.setVisibility(8);
                this.z.f(threadData, aj9Var.g(), aj9Var.x0());
                return;
            }
            this.z.setVisibility(8);
        }
    }
}
