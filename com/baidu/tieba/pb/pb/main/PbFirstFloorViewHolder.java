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
import com.baidu.tbadk.core.view.NovelInfoCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.av7;
import com.repackage.bs7;
import com.repackage.dw7;
import com.repackage.kg;
import com.repackage.kx7;
import com.repackage.mi;
import com.repackage.mu7;
import com.repackage.yx7;
/* loaded from: classes3.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
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
    public View o;
    public ImageView p;
    public TextView q;
    public NovelInfoCardView r;
    public LinearLayout s;
    public av7 t;
    public FrameLayout u;
    public kx7 v;
    public ThreadForumEnterButtonContainer w;
    public PbBusinessPromotionContainer x;
    public yx7 y;
    public VoteView z;

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
        this.t = new av7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091752);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -dw7.g());
        this.c.setImageMatrix(matrix);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090388);
        this.e = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091ac8);
        this.b = view2;
        int k = (((mi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.e.getPaddingLeft()) - this.e.getPaddingRight();
        mu7 mu7Var = new mu7(this.e.getLayoutStrategy());
        mu7Var.H = k;
        this.e.setLayoutStrategy(mu7Var);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c2b);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.e.getLayoutStrategy().q(min);
        this.e.getLayoutStrategy().p((int) (min * 1.618f));
        this.e.setIsNeedResizeEmotion(true);
        this.e.setTextSize(TbConfig.getContentSize());
        this.e.setDisplayImage(z, false);
        this.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d089d);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907ec);
        this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922e0);
        this.i = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f091704);
        this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091709);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091703);
        this.m = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090565);
        this.r = (NovelInfoCardView) view2.findViewById(R.id.obfuscated_res_0x7f090564);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f0906e8);
        this.o = view2.findViewById(R.id.obfuscated_res_0x7f091a0f);
        this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a10);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a11);
        this.o.setClickable(true);
        this.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091707);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09174c);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f0916e3);
        this.w = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.y = new yx7(tbPageContext);
        this.x = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f0916b3);
        this.u = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09163b);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f09246a);
        this.z = voteView;
        voteView.setPageContext(tbPageContext);
        this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09226d);
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

    public void d(@NonNull bs7 bs7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bs7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.w == null || bs7Var == null || bs7Var.l() == null) {
            return;
        }
        if (bs7Var.g0() && bs7Var.r0()) {
            this.w.setVisibility(8);
            return;
        }
        this.w.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(bs7Var.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(bs7Var.Q());
        threadData.setFid(kg.g(bs7Var.l().getId(), 0L));
        threadData.setForum_name(bs7Var.l().getName());
        threadData.setFirstClassName(bs7Var.l().getFirst_class());
        threadData.setSecondClassName(bs7Var.l().getSecond_class());
        if (bs7Var.O() != null) {
            threadData.setThreadType(bs7Var.O().threadType);
        }
        if (bs7Var.i) {
            this.w.setVisibility(8);
            this.x.f(threadData, bs7Var.h(), bs7Var.r0());
            return;
        }
        this.x.setVisibility(8);
    }

    public void e(bs7 bs7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bs7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (bs7Var != null && bs7Var.j) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f26);
                this.c.setVisibility(0);
            } else if (z && z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f64);
                this.c.setVisibility(0);
            } else if (z) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f62);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f63);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }
}
