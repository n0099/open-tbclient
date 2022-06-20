package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
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
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aw7;
import com.repackage.ct7;
import com.repackage.ng;
import com.repackage.ow7;
import com.repackage.pi;
import com.repackage.qt7;
import com.repackage.rq7;
import com.repackage.tu7;
/* loaded from: classes3.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public ImageView c;
    public View d;
    public TbRichTextView e;
    public View f;
    public TbImageView g;
    public TbImageView h;
    public ThreadSkinView i;
    public TextView j;
    public LinearLayout k;
    public TextView l;
    public AppletsCellView m;
    public View n;
    public NovelMemberCardView o;
    public LinearLayout p;
    public qt7 q;
    public FrameLayout r;
    public aw7 s;
    public ThreadForumEnterButtonContainer t;
    public PbBusinessPromotionContainer u;
    public ow7 v;
    public VoteView w;
    public TextView x;

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
        this.a = 3;
        this.q = new qt7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916fb);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -tu7.g());
        this.c.setImageMatrix(matrix);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090383);
        this.e = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091a6f);
        this.b = view2;
        int k = (((pi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.e.getPaddingLeft()) - this.e.getPaddingRight();
        ct7 ct7Var = new ct7(this.e.getLayoutStrategy());
        ct7Var.H = k;
        this.e.setLayoutStrategy(ct7Var);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090bfe);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.e.getLayoutStrategy().q(min);
        this.e.getLayoutStrategy().p((int) (min * 1.618f));
        this.e.setIsNeedResizeEmotion(true);
        this.e.setTextSize(TbConfig.getContentSize());
        this.e.setDisplayImage(z, false);
        this.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d088f);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907bb);
        this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092272);
        this.i = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f0916ad);
        this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916b2);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916ac);
        this.m = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f09053e);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f0906b5);
        this.o = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f09158c);
        this.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916b0);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916f5);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f09168b);
        this.t = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.v = new ow7(tbPageContext);
        this.u = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f09165b);
        this.r = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915e3);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f0923fc);
        this.w = voteView;
        voteView.setPageContext(tbPageContext);
        this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09220e);
    }

    public void c(boolean z, int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (view2 = this.d) == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.height = i;
            this.d.setLayoutParams(layoutParams);
            this.d.setVisibility(0);
            return;
        }
        view2.setVisibility(8);
    }

    public void d(@NonNull rq7 rq7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rq7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.t == null || rq7Var == null || rq7Var.l() == null) {
            return;
        }
        if (rq7Var.g0() && rq7Var.r0()) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(rq7Var.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(rq7Var.Q());
        threadData.setFid(ng.g(rq7Var.l().getId(), 0L));
        threadData.setForum_name(rq7Var.l().getName());
        threadData.setFirstClassName(rq7Var.l().getFirst_class());
        threadData.setSecondClassName(rq7Var.l().getSecond_class());
        if (rq7Var.O() != null) {
            threadData.setThreadType(rq7Var.O().threadType);
        }
        if (rq7Var.i) {
            this.t.setVisibility(8);
            this.u.f(threadData, rq7Var.h(), rq7Var.r0());
            return;
        }
        this.u.setVisibility(8);
    }

    public void e(rq7 rq7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{rq7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (rq7Var != null && rq7Var.j) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f27);
                this.c.setVisibility(0);
            } else if (z && z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f66);
                this.c.setVisibility(0);
            } else if (z) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f64);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f65);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }
}
