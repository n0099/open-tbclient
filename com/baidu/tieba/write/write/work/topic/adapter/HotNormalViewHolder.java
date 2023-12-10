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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.qm8;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class HotNormalViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public EMTextView c;
    public RelativeLayout d;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoHotTopicSearchAdapter.a a;
        public final /* synthetic */ qm8 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ HotNormalViewHolder d;

        public a(HotNormalViewHolder hotNormalViewHolder, VideoHotTopicSearchAdapter.a aVar, qm8 qm8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotNormalViewHolder, aVar, qm8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hotNormalViewHolder;
            this.a = aVar;
            this.b = qm8Var;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            VideoHotTopicSearchAdapter.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.a) != null) {
                aVar.a(this.b);
                if (this.b.j() && this.d.c(this.c)) {
                    TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "3").addParam("is_video_topic", "1").addParam("topic_id", this.b.d().longValue()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotNormalViewHolder(@NonNull View view2) {
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
        this.a = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09278a);
        this.b = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092750);
        this.c = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09104f);
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac0);
    }

    public void b(@NonNull HotNormalViewHolder hotNormalViewHolder, int i, qm8 qm8Var, TbPageContext tbPageContext, String str, VideoHotTopicSearchAdapter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hotNormalViewHolder, Integer.valueOf(i), qm8Var, tbPageContext, str, aVar}) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HotSelectActivityConfig.HOT_TOPIC_SING + qm8Var.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
            EMManager.from(hotNormalViewHolder.a).setTextColor(R.color.CAM_X0106);
            int indexOf = spannableStringBuilder.toString().indexOf(str);
            if (c(str) && indexOf != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(1), 1, indexOf, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 1, indexOf, 34);
                spannableStringBuilder.setSpan(new StyleSpan(1), str.length() + indexOf, spannableStringBuilder.length() - 1, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), indexOf + str.length(), spannableStringBuilder.length() - 1, 34);
            }
            if (qm8Var.j() && c(str)) {
                spannableStringBuilder.insert(1, (CharSequence) "v");
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_videotopic31, R.color.CAM_X0105, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.j(VideoHotTopicSearchAdapter.h);
                eMRichTextAnyIconSpan.f(VideoHotTopicSearchAdapter.h);
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 1, 2, 17);
            }
            hotNormalViewHolder.a.setText(spannableStringBuilder);
            if (qm8Var.a() > 0 && c(str) && qm8Var.j()) {
                hotNormalViewHolder.b.setVisibility(0);
                hotNormalViewHolder.b.setText(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0a4e), StringHelper.numberUniformFormatExtra(qm8Var.a())));
            } else if (qm8Var.a() == 0 && qm8Var.d().longValue() == 0 && c(str)) {
                hotNormalViewHolder.b.setVisibility(0);
                hotNormalViewHolder.b.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0a4d));
            } else {
                hotNormalViewHolder.b.setVisibility(8);
            }
            d(tbPageContext, hotNormalViewHolder.c, qm8Var.c());
            EMManager.from(hotNormalViewHolder.b).setTextColor(R.color.CAM_X0110);
            SkinManager.setBackgroundResource(hotNormalViewHolder.c, R.drawable.hot_select_tag_bg);
            SkinManager.setViewTextColor(hotNormalViewHolder.c, R.color.CAM_X0302, 1);
            hotNormalViewHolder.d.setOnClickListener(new a(this, aVar, qm8Var, str));
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return !TextUtils.isEmpty(str);
        }
        return invokeL.booleanValue;
    }

    public final void d(TbPageContext tbPageContext, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, textView, i) != null) || textView == null) {
            return;
        }
        if (i == 10) {
            textView.setVisibility(0);
            textView.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f172b));
        } else if (i == 11) {
            textView.setVisibility(0);
            textView.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f172a));
        } else {
            textView.setVisibility(8);
        }
    }
}
