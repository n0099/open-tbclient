package com.baidu.tieba.write.write.work.topic.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.s.v.c;
import c.a.s0.n4.d;
import c.a.s0.n4.e;
import c.a.s0.n4.g;
import c.a.s0.n4.j;
import c.a.s0.r1.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotVideoViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f51753b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f51754c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f51755d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f51756e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f51757f;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicSearchAdapter.a f51758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f51759f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicSearchAdapter f51760g;

        public a(HotVideoViewHolder hotVideoViewHolder, VideoHotTopicSearchAdapter.a aVar, f fVar, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotVideoViewHolder, aVar, fVar, videoHotTopicSearchAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51758e = aVar;
            this.f51759f = fVar;
            this.f51760g = videoHotTopicSearchAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f51758e) == null) {
                return;
            }
            aVar.a(this.f51759f);
            this.f51760g.setSelectTopicId(this.f51759f.d().longValue());
            this.f51760g.notifyDataSetChanged();
            if (this.f51759f.j()) {
                TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "2").addParam("is_video_topic", "1").addParam("topic_id", this.f51759f.d().longValue()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotVideoViewHolder(@NonNull View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.a = (EMTextView) view.findViewById(g.topic_title);
        this.f51753b = (EMTextView) view.findViewById(g.topic_hot_number);
        this.f51754c = (EMTextView) view.findViewById(g.topic_desc);
        this.f51755d = (EMTextView) view.findViewById(g.video_topic_tip);
        this.f51756e = (LinearLayout) view.findViewById(g.video_topic_main);
        this.f51757f = (RelativeLayout) view.findViewById(g.item_content);
    }

    public void bindDataToViewHolder(@NonNull HotVideoViewHolder hotVideoViewHolder, int i2, f fVar, TbPageContext tbPageContext, long j2, VideoHotTopicSearchAdapter.a aVar, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hotVideoViewHolder, Integer.valueOf(i2), fVar, tbPageContext, Long.valueOf(j2), aVar, videoHotTopicSearchAdapter}) == null) {
            if (fVar.i()) {
                this.f51755d.setVisibility(0);
                this.f51757f.setVisibility(8);
                c d2 = c.d(this.f51755d);
                d2.z(e.T_X09);
                d2.v(d.CAM_X0108);
                return;
            }
            this.f51755d.setVisibility(8);
            this.f51757f.setVisibility(0);
            if (fVar.a() > 0) {
                hotVideoViewHolder.f51753b.setVisibility(0);
                hotVideoViewHolder.f51753b.setText(String.format(tbPageContext.getString(j.hot_topic_thread_item_number), StringHelper.numberUniformFormatExtra(fVar.a())));
            } else {
                hotVideoViewHolder.f51753b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(fVar.b())) {
                hotVideoViewHolder.f51754c.setVisibility(0);
                hotVideoViewHolder.f51754c.setText(fVar.b());
            } else {
                hotVideoViewHolder.f51754c.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + fVar.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
            if (fVar.j()) {
                if (j2 == fVar.d().longValue()) {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    c.d(hotVideoViewHolder.a).v(d.CAM_X0304);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(c.a.s0.n4.f.icon_pure_videotopic31, d.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                } else {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    c.d(hotVideoViewHolder.a).v(d.CAM_X0105);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(c.a.s0.n4.f.icon_pure_videotopic31, d.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                }
                eMRichTextAnyIconSpan.d(VideoHotTopicSearchAdapter.ICON_PADDING);
                eMRichTextAnyIconSpan.b(VideoHotTopicSearchAdapter.ICON_PADDING);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotVideoViewHolder.a.setText(spannableStringBuilder);
            c.d(hotVideoViewHolder.f51753b).v(d.CAM_X0110);
            c.d(hotVideoViewHolder.f51754c).v(d.CAM_X0108);
            hotVideoViewHolder.f51756e.setOnClickListener(new a(this, aVar, fVar, videoHotTopicSearchAdapter));
        }
    }
}
