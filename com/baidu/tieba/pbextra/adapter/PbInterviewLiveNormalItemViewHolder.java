package com.baidu.tieba.pbextra.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TbRichTextView b;
    public View c;
    public PbGiftListView d;
    public FrsPraiseView e;
    public ImageView f;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewLiveNormalItemViewHolder(View view2, boolean z, boolean z2, int i, boolean z3) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3)};
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
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910a2);
        this.a = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setOnClickListener(this);
        this.a.setInterceptOnClick(true);
        this.a.setDefaultResource(R.drawable.icon_click);
        this.b = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091d80);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f091983);
        this.e = (FrsPraiseView) view2.findViewById(R.id.obfuscated_res_0x7f091984);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091982);
        this.d = (PbGiftListView) view2.findViewById(R.id.obfuscated_res_0x7f090d9a);
        this.b.getLayoutStrategy().v();
        this.b.getLayoutStrategy().l(true);
        int min = Math.min(((((ej.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.b.getPaddingLeft()) - this.b.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.b.getLayoutStrategy().r(min);
        this.b.getLayoutStrategy().q((int) (min * 1.618f));
        this.b.setTextSize(TbConfig.getContentSize());
        this.b.setDisplayImage(z2, false);
        this.b.setVoiceViewRes(R.layout.voice_play_btn);
    }
}
