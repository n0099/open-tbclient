package com.baidu.tieba.pbextra.adapter;

import android.view.View;
import android.widget.ImageView;
import c.a.d.f.p.n;
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
/* loaded from: classes12.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbGiftListView giftListView;
    public TbImageView mPostImage;
    public ImageView praiseBottomLine;
    public View praiseToLine;
    public FrsPraiseView praiseView;
    public TbRichTextView richText;

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
        this.mPostImage = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.mPostImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mPostImage.setOnClickListener(this);
        this.mPostImage.setInterceptOnClick(true);
        this.mPostImage.setDefaultResource(R.drawable.icon_click);
        this.richText = (TbRichTextView) view.findViewById(R.id.richText);
        this.praiseToLine = view.findViewById(R.id.pb_item_praise_topline);
        this.praiseView = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.praiseBottomLine = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.giftListView = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.richText.getLayoutStrategy().t();
        this.richText.getLayoutStrategy().k(true);
        int min = Math.min(((((n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.richText.getPaddingLeft()) - this.richText.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.richText.getLayoutStrategy().q(min);
        this.richText.getLayoutStrategy().p((int) (min * 1.618f));
        this.richText.setTextSize(TbConfig.getContentSize());
        this.richText.setDisplayImage(z2, false);
        this.richText.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
        }
    }
}
