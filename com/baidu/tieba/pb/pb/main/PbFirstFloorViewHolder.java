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
import com.repackage.bs7;
import com.repackage.bv7;
import com.repackage.by7;
import com.repackage.ew7;
import com.repackage.mg;
import com.repackage.nu7;
import com.repackage.nx7;
import com.repackage.oi;
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
    public bv7 t;
    public FrameLayout u;
    public nx7 v;
    public ThreadForumEnterButtonContainer w;
    public PbBusinessPromotionContainer x;
    public by7 y;
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
        this.t = new bv7(view2);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09172a);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ew7.g());
        this.c.setImageMatrix(matrix);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090392);
        this.e = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091a7a);
        this.b = view2;
        int k = (((oi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.e.getPaddingLeft()) - this.e.getPaddingRight();
        nu7 nu7Var = new nu7(this.e.getLayoutStrategy());
        nu7Var.G = k;
        this.e.setLayoutStrategy(nu7Var);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c3f);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.e.getLayoutStrategy().q(min);
        this.e.getLayoutStrategy().p((int) (min * 1.618f));
        this.e.setIsNeedResizeEmotion(true);
        this.e.setTextSize(TbConfig.getContentSize());
        this.e.setDisplayImage(z, false);
        this.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08a8);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907f5);
        this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09228a);
        this.i = (ThreadSkinView) view2.findViewById(R.id.obfuscated_res_0x7f0916dc);
        this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916e1);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916db);
        this.m = (AppletsCellView) view2.findViewById(R.id.obfuscated_res_0x7f090568);
        this.r = (NovelInfoCardView) view2.findViewById(R.id.obfuscated_res_0x7f090567);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f0906ec);
        this.o = view2.findViewById(R.id.obfuscated_res_0x7f0919b7);
        this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919b8);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919b9);
        this.o.setClickable(true);
        this.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916df);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091724);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view2.findViewById(R.id.obfuscated_res_0x7f0916bb);
        this.w = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.y = new by7(tbPageContext);
        this.x = (PbBusinessPromotionContainer) view2.findViewById(R.id.obfuscated_res_0x7f09168c);
        this.u = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09161c);
        VoteView voteView = (VoteView) view2.findViewById(R.id.obfuscated_res_0x7f09241a);
        this.z = voteView;
        voteView.setPageContext(tbPageContext);
        this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092215);
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
        threadData.setFid(mg.g(bs7Var.l().getId(), 0L));
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
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f0c);
                this.c.setVisibility(0);
            } else if (z && z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f4e);
                this.c.setVisibility(0);
            } else if (z) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f4c);
                this.c.setVisibility(0);
            } else if (z2) {
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f080f4d);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }
}
