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
import c.a.t0.s.v.c;
import c.a.u0.s1.f;
import c.a.u0.s4.d;
import c.a.u0.s4.g;
import c.a.u0.s4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class HotNormalViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f50202b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f50203c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f50204d;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoHotTopicSearchAdapter.a f50205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f50206f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50207g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HotNormalViewHolder f50208h;

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
            this.f50208h = hotNormalViewHolder;
            this.f50205e = aVar;
            this.f50206f = fVar;
            this.f50207g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f50205e) == null) {
                return;
            }
            aVar.a(this.f50206f);
            if (this.f50206f.j() && this.f50208h.b(this.f50207g)) {
                TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "3").addParam("is_video_topic", "1").addParam("topic_id", this.f50206f.d().longValue()));
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
        this.a = (EMTextView) view.findViewById(g.topic_title);
        this.f50202b = (EMTextView) view.findViewById(g.topic_extra);
        this.f50203c = (EMTextView) view.findViewById(g.hot_topic_tag);
        this.f50204d = (RelativeLayout) view.findViewById(g.nromal_topic_main);
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public void bindViewHolder(@NonNull HotNormalViewHolder hotNormalViewHolder, int i2, f fVar, TbPageContext tbPageContext, String str, VideoHotTopicSearchAdapter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hotNormalViewHolder, Integer.valueOf(i2), fVar, tbPageContext, str, aVar}) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + fVar.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
            c.d(hotNormalViewHolder.a).v(d.CAM_X0106);
            int indexOf = spannableStringBuilder.toString().indexOf(str);
            if (b(str) && indexOf != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(1), 1, indexOf, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(d.CAM_X0105)), 1, indexOf, 34);
                spannableStringBuilder.setSpan(new StyleSpan(1), str.length() + indexOf, spannableStringBuilder.length() - 1, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(d.CAM_X0105)), indexOf + str.length(), spannableStringBuilder.length() - 1, 34);
            }
            if (fVar.j() && b(str)) {
                spannableStringBuilder.insert(1, (CharSequence) "v");
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(c.a.u0.s4.f.icon_pure_videotopic31, d.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.d(VideoHotTopicSearchAdapter.ICON_PADDING);
                eMRichTextAnyIconSpan.b(VideoHotTopicSearchAdapter.ICON_PADDING);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotNormalViewHolder.a.setText(spannableStringBuilder);
            if (fVar.a() > 0 && b(str) && fVar.j()) {
                hotNormalViewHolder.f50202b.setVisibility(0);
                hotNormalViewHolder.f50202b.setText(String.format(tbPageContext.getString(j.hot_topic_thread_item_number), StringHelper.numberUniformFormatExtra(fVar.a())));
            } else if (fVar.a() == 0 && fVar.d().longValue() == 0 && b(str)) {
                hotNormalViewHolder.f50202b.setVisibility(0);
                hotNormalViewHolder.f50202b.setText(tbPageContext.getString(j.hot_topic_thread_create_new_topic));
            } else {
                hotNormalViewHolder.f50202b.setVisibility(8);
            }
            c(tbPageContext, hotNormalViewHolder.f50203c, fVar.c());
            c.d(hotNormalViewHolder.f50202b).v(d.CAM_X0110);
            SkinManager.setBackgroundResource(hotNormalViewHolder.f50203c, c.a.u0.s4.f.hot_select_tag_bg);
            SkinManager.setViewTextColor(hotNormalViewHolder.f50203c, d.CAM_X0302, 1);
            hotNormalViewHolder.f50204d.setOnClickListener(new a(this, aVar, fVar, str));
        }
    }

    public final void c(TbPageContext tbPageContext, TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, textView, i2) == null) || textView == null) {
            return;
        }
        if (i2 == 10) {
            textView.setVisibility(0);
            textView.setText(tbPageContext.getString(j.topic_tag_offical));
        } else if (i2 == 11) {
            textView.setVisibility(0);
            textView.setText(tbPageContext.getString(j.topic_tag_bar));
        } else {
            textView.setVisibility(8);
        }
    }
}
