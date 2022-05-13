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
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gs4;
import com.repackage.t37;
/* loaded from: classes4.dex */
public class HotVideoViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public EMTextView c;
    public EMTextView d;
    public LinearLayout e;
    public RelativeLayout f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicSearchAdapter.a a;
        public final /* synthetic */ t37 b;
        public final /* synthetic */ VideoHotTopicSearchAdapter c;

        public a(HotVideoViewHolder hotVideoViewHolder, VideoHotTopicSearchAdapter.a aVar, t37 t37Var, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotVideoViewHolder, aVar, t37Var, videoHotTopicSearchAdapter};
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
            this.b = t37Var;
            this.c = videoHotTopicSearchAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(this.b);
            this.c.f(this.b.d().longValue());
            this.c.notifyDataSetChanged();
            if (this.b.j()) {
                TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "2").addParam("is_video_topic", "1").addParam("topic_id", this.b.d().longValue()));
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
        this.a = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09216c);
        this.b = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092130);
        this.c = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09211e);
        this.d = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0923c9);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923c8);
        this.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f6a);
    }

    public void a(@NonNull HotVideoViewHolder hotVideoViewHolder, int i, t37 t37Var, TbPageContext tbPageContext, long j, VideoHotTopicSearchAdapter.a aVar, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hotVideoViewHolder, Integer.valueOf(i), t37Var, tbPageContext, Long.valueOf(j), aVar, videoHotTopicSearchAdapter}) == null) {
            if (t37Var.i()) {
                this.d.setVisibility(0);
                this.f.setVisibility(8);
                gs4 d = gs4.d(this.d);
                d.z(R.dimen.T_X09);
                d.v(R.color.CAM_X0108);
                return;
            }
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            if (t37Var.a() > 0) {
                hotVideoViewHolder.b.setVisibility(0);
                hotVideoViewHolder.b.setText(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0889), StringHelper.numberUniformFormatExtra(t37Var.a())));
            } else {
                hotVideoViewHolder.b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(t37Var.b())) {
                hotVideoViewHolder.c.setVisibility(0);
                hotVideoViewHolder.c.setText(t37Var.b());
            } else {
                hotVideoViewHolder.c.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + t37Var.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
            if (t37Var.j()) {
                if (j == t37Var.d().longValue()) {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    gs4.d(hotVideoViewHolder.a).v(R.color.CAM_X0304);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a04, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                } else {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    gs4.d(hotVideoViewHolder.a).v(R.color.CAM_X0105);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a04, R.color.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                }
                eMRichTextAnyIconSpan.d(VideoHotTopicSearchAdapter.h);
                eMRichTextAnyIconSpan.b(VideoHotTopicSearchAdapter.h);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotVideoViewHolder.a.setText(spannableStringBuilder);
            gs4.d(hotVideoViewHolder.b).v(R.color.CAM_X0110);
            gs4.d(hotVideoViewHolder.c).v(R.color.CAM_X0108);
            hotVideoViewHolder.e.setOnClickListener(new a(this, aVar, t37Var, videoHotTopicSearchAdapter));
        }
    }
}
