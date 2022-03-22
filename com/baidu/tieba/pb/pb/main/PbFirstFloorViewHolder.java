package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.p0.w2.i.f;
import c.a.p0.w2.m.f.i;
import c.a.p0.w2.m.f.l1.a;
import c.a.p0.w2.m.f.w;
import c.a.p0.w2.m.f.y0;
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
/* loaded from: classes5.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public View f34877b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34878c;

    /* renamed from: d  reason: collision with root package name */
    public View f34879d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f34880e;

    /* renamed from: f  reason: collision with root package name */
    public View f34881f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f34882g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f34883h;
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
    public w t;
    public FrameLayout u;
    public a v;
    public ThreadForumEnterButtonContainer w;
    public PbBusinessPromotionContainer x;
    public c.a.p0.w2.m.f.o1.a y;
    public VoteView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z), Integer.valueOf(i)};
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
        this.t = new w(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09172c);
        this.f34878c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -y0.g());
        this.f34878c.setImageMatrix(matrix);
        this.f34879d = view.findViewById(R.id.obfuscated_res_0x7f090387);
        this.f34880e = (TbRichTextView) view.findViewById(R.id.obfuscated_res_0x7f091a8a);
        this.f34877b = view;
        int k = (((n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f34880e.getPaddingLeft()) - this.f34880e.getPaddingRight();
        i iVar = new i(this.f34880e.getLayoutStrategy());
        iVar.G = k;
        this.f34880e.setLayoutStrategy(iVar);
        this.f34883h = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090c31);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f34880e.getLayoutStrategy().q(min);
        this.f34880e.getLayoutStrategy().p((int) (min * 1.618f));
        this.f34880e.setIsNeedResizeEmotion(true);
        this.f34880e.setTextSize(TbConfig.getContentSize());
        this.f34880e.setDisplayImage(z, false);
        this.f34880e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b2);
        this.f34881f = view.findViewById(R.id.obfuscated_res_0x7f0907ec);
        this.f34882g = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0922a5);
        this.i = (ThreadSkinView) view.findViewById(R.id.obfuscated_res_0x7f0916df);
        this.k = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0916e4);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0916de);
        this.m = (AppletsCellView) view.findViewById(R.id.obfuscated_res_0x7f09055f);
        this.r = (NovelInfoCardView) view.findViewById(R.id.obfuscated_res_0x7f09055e);
        this.n = view.findViewById(R.id.obfuscated_res_0x7f0906e3);
        this.o = view.findViewById(R.id.obfuscated_res_0x7f0919c5);
        this.p = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0919c6);
        this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919c7);
        this.o.setClickable(true);
        this.s = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0916e2);
        this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091726);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view.findViewById(R.id.obfuscated_res_0x7f0916be);
        this.w = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.y = new c.a.p0.w2.m.f.o1.a(tbPageContext);
        this.x = (PbBusinessPromotionContainer) view.findViewById(R.id.obfuscated_res_0x7f091691);
        this.u = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f091621);
        VoteView voteView = (VoteView) view.findViewById(R.id.obfuscated_res_0x7f09243d);
        this.z = voteView;
        voteView.setPageContext(tbPageContext);
        this.A = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092230);
    }

    public void c(boolean z, int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (view = this.f34879d) == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = i;
            this.f34879d.setLayoutParams(layoutParams);
            this.f34879d.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    public void d(@NonNull f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.w == null || fVar == null || fVar.l() == null) {
            return;
        }
        if (fVar.g0() && fVar.r0()) {
            this.w.setVisibility(8);
            return;
        }
        this.w.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(fVar.p());
        }
        ThreadData threadData = new ThreadData();
        threadData.setId(fVar.Q());
        threadData.setFid(b.g(fVar.l().getId(), 0L));
        threadData.setForum_name(fVar.l().getName());
        threadData.setFirstClassName(fVar.l().getFirst_class());
        threadData.setSecondClassName(fVar.l().getSecond_class());
        if (fVar.O() != null) {
            threadData.setThreadType(fVar.O().threadType);
        }
        if (fVar.i) {
            this.w.setVisibility(8);
            this.x.f(threadData, fVar.h(), fVar.r0());
            return;
        }
        this.x.setVisibility(8);
    }

    public void e(f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (fVar != null && fVar.j) {
                this.f34878c.setImageResource(R.drawable.obfuscated_res_0x7f080efe);
                this.f34878c.setVisibility(0);
            } else if (z && z2) {
                this.f34878c.setImageResource(R.drawable.obfuscated_res_0x7f080f40);
                this.f34878c.setVisibility(0);
            } else if (z) {
                this.f34878c.setImageResource(R.drawable.obfuscated_res_0x7f080f3e);
                this.f34878c.setVisibility(0);
            } else if (z2) {
                this.f34878c.setImageResource(R.drawable.obfuscated_res_0x7f080f3f);
                this.f34878c.setVisibility(0);
            } else {
                this.f34878c.setVisibility(8);
            }
        }
    }
}
