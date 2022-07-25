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
import com.repackage.iu7;
import com.repackage.ix7;
import com.repackage.jr7;
import com.repackage.lv7;
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.ut7;
import com.repackage.uw7;
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
    public iu7 q;
    public FrameLayout r;
    public uw7 s;
    public ThreadForumEnterButtonContainer t;
    public PbBusinessPromotionContainer u;
    public ix7 v;
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
        this.q = new iu7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09177f);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -lv7.h());
        this.c.setImageMatrix(matrix);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090385);
        this.e = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091af1);
        this.b = view2;
        int k = (((pi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.e.getPaddingLeft()) - this.e.getPaddingRight();
        ut7 ut7Var = new ut7(this.e.getLayoutStrategy());
        ut7Var.H = k;
        this.e.setLayoutStrategy(ut7Var);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c00);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.e.getLayoutStrategy().q(min);
        this.e.getLayoutStrategy().p((int) (min * 1.618f));
        this.e.setIsNeedResizeEmotion(true);
        this.e.setTextSize(TbConfig.getContentSize());
        this.e.setDisplayImage(z, false);
        this.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b9);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907c0);
        this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09231c);
        this.i = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091731);
        this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091736);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091730);
        this.m = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090540);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f0906b9);
        this.o = (NovelMemberCardView) view2.findViewById(R.id.obfuscated_res_0x7f091610);
        this.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091734);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091779);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f09170f);
        this.t = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.v = new ix7(tbPageContext);
        this.u = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0916df);
        this.r = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091667);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f0924bc);
        this.w = voteView;
        voteView.setPageContext(tbPageContext);
        this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922b6);
    }

    public void b(boolean z, int i) {
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

    public void c(@NonNull jr7 jr7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jr7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.t == null || jr7Var == null || jr7Var.l() == null) {
            return;
        }
        if (jr7Var.g0() && jr7Var.r0()) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(jr7Var.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(jr7Var.Q());
        threadData.setFid(ng.g(jr7Var.l().getId(), 0L));
        threadData.setForum_name(jr7Var.l().getName());
        threadData.setFirstClassName(jr7Var.l().getFirst_class());
        threadData.setSecondClassName(jr7Var.l().getSecond_class());
        if (jr7Var.O() != null) {
            threadData.setThreadType(jr7Var.O().threadType);
        }
        if (jr7Var.i) {
            this.t.setVisibility(8);
            this.u.f(threadData, jr7Var.h(), jr7Var.r0());
            return;
        }
        this.u.setVisibility(8);
    }
}
