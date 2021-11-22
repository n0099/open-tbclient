package com.baidu.tieba.write.write.work.topic.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.q0.s.u.c;
import b.a.r0.k1.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotVideoViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EMTextView f57212a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f57213b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f57214c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f57215d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f57216e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f57217f;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicSearchAdapter.a f57218e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f57219f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicSearchAdapter f57220g;

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
            this.f57218e = aVar;
            this.f57219f = fVar;
            this.f57220g = videoHotTopicSearchAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f57218e) == null) {
                return;
            }
            aVar.a(this.f57219f);
            this.f57220g.setSelectTopicId(this.f57219f.c().topic_id.longValue());
            this.f57220g.notifyDataSetChanged();
            if (this.f57219f.i()) {
                TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "2").addParam(IntentConfig.IS_VIDEO_TOPIC, "1").addParam("topic_id", this.f57219f.c().topic_id.longValue()));
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
        this.f57212a = (EMTextView) view.findViewById(R.id.topic_title);
        this.f57213b = (EMTextView) view.findViewById(R.id.topic_hot_number);
        this.f57214c = (EMTextView) view.findViewById(R.id.topic_desc);
        this.f57215d = (EMTextView) view.findViewById(R.id.video_topic_tip);
        this.f57216e = (LinearLayout) view.findViewById(R.id.video_topic_main);
        this.f57217f = (RelativeLayout) view.findViewById(R.id.item_content);
    }

    public void bindDataToViewHolder(@NonNull HotVideoViewHolder hotVideoViewHolder, int i2, f fVar, TbPageContext tbPageContext, long j, VideoHotTopicSearchAdapter.a aVar, VideoHotTopicSearchAdapter videoHotTopicSearchAdapter) {
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hotVideoViewHolder, Integer.valueOf(i2), fVar, tbPageContext, Long.valueOf(j), aVar, videoHotTopicSearchAdapter}) == null) {
            if (fVar.h()) {
                this.f57215d.setVisibility(0);
                this.f57217f.setVisibility(8);
                c d2 = c.d(this.f57215d);
                d2.z(R.dimen.T_X09);
                d2.v(R.color.CAM_X0108);
                return;
            }
            this.f57215d.setVisibility(8);
            this.f57217f.setVisibility(0);
            if (fVar.c().discuss_num.longValue() > 0) {
                hotVideoViewHolder.f57213b.setVisibility(0);
                hotVideoViewHolder.f57213b.setText(String.format(tbPageContext.getString(R.string.hot_topic_thread_item_number), StringHelper.numberUniformFormatExtra(fVar.c().discuss_num.longValue())));
            } else {
                hotVideoViewHolder.f57213b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(fVar.c().slogan)) {
                hotVideoViewHolder.f57214c.setVisibility(0);
                hotVideoViewHolder.f57214c.setText(fVar.c().slogan);
            } else {
                hotVideoViewHolder.f57214c.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + fVar.d() + HotSelectActivityConfig.HOT_TOPIC_SING);
            if (fVar.i()) {
                if (j == fVar.c().topic_id.longValue()) {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    c.d(hotVideoViewHolder.f57212a).v(R.color.CAM_X0304);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_videotopic31, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                } else {
                    spannableStringBuilder.insert(1, (CharSequence) "v");
                    c.d(hotVideoViewHolder.f57212a).v(R.color.CAM_X0105);
                    eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_videotopic31, R.color.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                }
                eMRichTextAnyIconSpan.d(VideoHotTopicSearchAdapter.ICON_PADDING);
                eMRichTextAnyIconSpan.b(VideoHotTopicSearchAdapter.ICON_PADDING);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotVideoViewHolder.f57212a.setText(spannableStringBuilder);
            c.d(hotVideoViewHolder.f57213b).v(R.color.CAM_X0110);
            c.d(hotVideoViewHolder.f57214c).v(R.color.CAM_X0108);
            hotVideoViewHolder.f57216e.setOnClickListener(new a(this, aVar, fVar, videoHotTopicSearchAdapter));
        }
    }
}
