package com.baidu.tieba.write.write.work.topic.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.q0.s.u.c;
import b.a.r0.k1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotNormalViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EMTextView f57204a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f57205b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f57206c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57207d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicSearchAdapter.a f57208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f57209f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f57210g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HotNormalViewHolder f57211h;

        public a(HotNormalViewHolder hotNormalViewHolder, VideoHotTopicSearchAdapter.a aVar, f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotNormalViewHolder, aVar, fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57211h = hotNormalViewHolder;
            this.f57208e = aVar;
            this.f57209f = fVar;
            this.f57210g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f57208e) == null) {
                return;
            }
            aVar.a(this.f57209f);
            if (this.f57209f.i() && this.f57211h.b(this.f57210g)) {
                TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "3").addParam(IntentConfig.IS_VIDEO_TOPIC, "1").addParam("topic_id", this.f57209f.c().topic_id.longValue()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotNormalViewHolder(@NonNull View view) {
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
        this.f57204a = (EMTextView) view.findViewById(R.id.topic_title);
        this.f57205b = (EMTextView) view.findViewById(R.id.topic_extra);
        this.f57206c = (EMTextView) view.findViewById(R.id.hot_topic_tag);
        this.f57207d = (RelativeLayout) view.findViewById(R.id.nromal_topic_main);
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public void bindViewHolder(@NonNull HotNormalViewHolder hotNormalViewHolder, int i2, f fVar, TbPageContext tbPageContext, String str, VideoHotTopicSearchAdapter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hotNormalViewHolder, Integer.valueOf(i2), fVar, tbPageContext, str, aVar}) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + fVar.d() + HotSelectActivityConfig.HOT_TOPIC_SING);
            c.d(hotNormalViewHolder.f57204a).v(R.color.CAM_X0106);
            int indexOf = spannableStringBuilder.toString().indexOf(str);
            if (b(str) && indexOf != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(1), 1, indexOf, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 1, indexOf, 34);
                spannableStringBuilder.setSpan(new StyleSpan(1), str.length() + indexOf, spannableStringBuilder.length() - 1, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), indexOf + str.length(), spannableStringBuilder.length() - 1, 34);
            }
            if (fVar.i() && b(str)) {
                spannableStringBuilder.insert(1, (CharSequence) "v");
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_videotopic31, R.color.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.d(VideoHotTopicSearchAdapter.ICON_PADDING);
                eMRichTextAnyIconSpan.b(VideoHotTopicSearchAdapter.ICON_PADDING);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotNormalViewHolder.f57204a.setText(spannableStringBuilder);
            if (fVar.c().discuss_num.longValue() > 0 && b(str) && fVar.i()) {
                hotNormalViewHolder.f57205b.setVisibility(0);
                hotNormalViewHolder.f57205b.setText(String.format(tbPageContext.getString(R.string.hot_topic_thread_item_number), StringHelper.numberUniformFormatExtra(fVar.c().discuss_num.longValue())));
            } else if (fVar.c().discuss_num.longValue() == 0 && fVar.c().topic_id.longValue() == 0 && b(str)) {
                hotNormalViewHolder.f57205b.setVisibility(0);
                hotNormalViewHolder.f57205b.setText(tbPageContext.getString(R.string.hot_topic_thread_create_new_topic));
            } else {
                hotNormalViewHolder.f57205b.setVisibility(8);
            }
            c(tbPageContext, hotNormalViewHolder.f57206c, fVar.c().tag.intValue());
            c.d(hotNormalViewHolder.f57205b).v(R.color.CAM_X0110);
            SkinManager.setBackgroundResource(hotNormalViewHolder.f57206c, R.drawable.hot_select_tag_bg);
            SkinManager.setViewTextColor(hotNormalViewHolder.f57206c, R.color.CAM_X0302, 1);
            hotNormalViewHolder.f57207d.setOnClickListener(new a(this, aVar, fVar, str));
        }
    }

    public final void c(TbPageContext tbPageContext, TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, textView, i2) == null) || textView == null) {
            return;
        }
        if (i2 == 10) {
            textView.setVisibility(0);
            textView.setText(tbPageContext.getString(R.string.topic_tag_offical));
        } else if (i2 == 11) {
            textView.setVisibility(0);
            textView.setText(tbPageContext.getString(R.string.topic_tag_bar));
        } else {
            textView.setVisibility(8);
        }
    }
}
