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
/* loaded from: classes5.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TbRichTextView f35304b;

    /* renamed from: c  reason: collision with root package name */
    public View f35305c;

    /* renamed from: d  reason: collision with root package name */
    public PbGiftListView f35306d;

    /* renamed from: e  reason: collision with root package name */
    public FrsPraiseView f35307e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35308f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3)};
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
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090f3e);
        this.a = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setOnClickListener(this);
        this.a.setInterceptOnClick(true);
        this.a.setDefaultResource(R.drawable.icon_click);
        this.f35304b = (TbRichTextView) view.findViewById(R.id.obfuscated_res_0x7f091a8a);
        this.f35305c = view.findViewById(R.id.obfuscated_res_0x7f0916db);
        this.f35307e = (FrsPraiseView) view.findViewById(R.id.obfuscated_res_0x7f0916dc);
        this.f35308f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0916da);
        this.f35306d = (PbGiftListView) view.findViewById(R.id.obfuscated_res_0x7f090ca6);
        this.f35304b.getLayoutStrategy().t();
        this.f35304b.getLayoutStrategy().k(true);
        int min = Math.min(((((n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f35304b.getPaddingLeft()) - this.f35304b.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070253)), i);
        this.f35304b.getLayoutStrategy().q(min);
        this.f35304b.getLayoutStrategy().p((int) (min * 1.618f));
        this.f35304b.setTextSize(TbConfig.getContentSize());
        this.f35304b.setDisplayImage(z2, false);
        this.f35304b.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
        }
    }
}
