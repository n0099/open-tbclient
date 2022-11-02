package com.baidu.tieba.write.write.work.topic.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.h97;
import com.baidu.tieba.kw4;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HotVideoViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public EMTextView c;
    public EMTextView d;
    public LinearLayout e;
    public RelativeLayout f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicSearchAdapter.a a;
        public final /* synthetic */ h97 b;
        public final /* synthetic */ VideoHotTopicSearchAdapter c;

        public a(HotVideoViewHolder hotVideoViewHolder, VideoHotTopicSearchAdapter.a aVar, h97 h97Var, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotVideoViewHolder, aVar, h97Var, videoHotTopicSearchAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = h97Var;
            this.c = videoHotTopicSearchAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.a) != null) {
                aVar.a(this.b);
                this.c.f(this.b.d().longValue());
                this.c.notifyDataSetChanged();
                if (this.b.j()) {
                    TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "2").addParam("is_video_topic", "1").addParam("topic_id", this.b.d().longValue()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotVideoViewHolder(@NonNull View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092352);
        this.b = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092314);
        this.c = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092302);
        this.d = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d0);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925cf);
        this.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fc3);
    }

    public void a(@NonNull HotVideoViewHolder hotVideoViewHolder, int i, h97 h97Var, TbPageContext tbPageContext, long j, VideoHotTopicSearchAdapter.a aVar, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hotVideoViewHolder, Integer.valueOf(i), h97Var, tbPageContext, Long.valueOf(j), aVar, videoHotTopicSearchAdapter}) == null) {
            if (h97Var.i()) {
                this.d.setVisibility(0);
                this.f.setVisibility(8);
                kw4 d = kw4.d(this.d);
                d.z(R.dimen.T_X09);
                d.v(R.color.CAM_X0108);
                return;
            }
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            if (h97Var.a() > 0) {
                hotVideoViewHolder.b.setVisibility(0);
                hotVideoViewHolder.b.setText(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f08c3), StringHelper.numberUniformFormatExtra(h97Var.a())));
            } else {
                hotVideoViewHolder.b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(h97Var.b())) {
                hotVideoViewHolder.c.setVisibility(0);
                hotVideoViewHolder.c.setText(h97Var.b());
            } else {
                hotVideoViewHolder.c.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + h97Var.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
            if (h97Var.j()) {
                if (j == h97Var.d().longValue()) {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    kw4.d(hotVideoViewHolder.a).v(R.color.CAM_X0304);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a62, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                } else {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    kw4.d(hotVideoViewHolder.a).v(R.color.CAM_X0105);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a62, R.color.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                }
                eMRichTextAnyIconSpan.f(VideoHotTopicSearchAdapter.h);
                eMRichTextAnyIconSpan.d(VideoHotTopicSearchAdapter.h);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotVideoViewHolder.a.setText(spannableStringBuilder);
            kw4.d(hotVideoViewHolder.b).v(R.color.CAM_X0110);
            kw4.d(hotVideoViewHolder.c).v(R.color.CAM_X0108);
            hotVideoViewHolder.e.setOnClickListener(new a(this, aVar, h97Var, videoHotTopicSearchAdapter));
        }
    }
}
