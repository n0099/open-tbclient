package com.baidu.tieba.pbextra.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f20045e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f20046f;

    /* renamed from: g  reason: collision with root package name */
    public View f20047g;

    /* renamed from: h  reason: collision with root package name */
    public PbGiftListView f20048h;

    /* renamed from: i  reason: collision with root package name */
    public FrsPraiseView f20049i;
    public ImageView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i2, boolean z3) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.f20045e = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.f20045e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20045e.setOnClickListener(this);
        this.f20045e.setInterceptOnClick(true);
        this.f20045e.setDefaultResource(R.drawable.icon_click);
        this.f20046f = (TbRichTextView) view.findViewById(R.id.richText);
        this.f20047g = view.findViewById(R.id.pb_item_praise_topline);
        this.f20049i = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.j = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.f20048h = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.f20046f.getLayoutStrategy().t();
        this.f20046f.getLayoutStrategy().k(true);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f20046f.getPaddingLeft()) - this.f20046f.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.f20046f.getLayoutStrategy().q(min);
        this.f20046f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f20046f.setTextSize(TbConfig.getContentSize());
        this.f20046f.setDisplayImage(z2, false);
        this.f20046f.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
        }
    }
}
