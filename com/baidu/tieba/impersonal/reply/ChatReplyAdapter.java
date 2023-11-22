package com.baidu.tieba.impersonal.reply;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.impersonal.data.QuickReplyData;
import com.baidu.tieba.impersonal.databinding.ItemQuickChatReplyBinding;
import com.baidu.tieba.m79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\fJ\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/impersonal/reply/ChatReplyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/impersonal/reply/ChatReplyAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "mDataList", "", "Lcom/baidu/tieba/impersonal/data/QuickReplyData$QuestionData;", "getItemCount", "", "getItemData", CriusAttrConstants.POSITION, "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "ViewHolder", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatReplyAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<QuickReplyData.QuestionData> b;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/impersonal/reply/ChatReplyAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/baidu/tieba/impersonal/databinding/ItemQuickChatReplyBinding;", "(Lcom/baidu/tieba/impersonal/reply/ChatReplyAdapter;Lcom/baidu/tieba/impersonal/databinding/ItemQuickChatReplyBinding;)V", "curSkinType", "", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getTextMeasureWith", "", "text", "", "onSkinChanged", "", "setQuestionItemData", "data", "Lcom/baidu/tieba/impersonal/data/QuickReplyData$QuestionData;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemQuickChatReplyBinding a;
        public int b;
        public final GradientDrawable c;
        public final /* synthetic */ ChatReplyAdapter d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ChatReplyAdapter chatReplyAdapter, ItemQuickChatReplyBinding binding) {
            super(binding.getRoot());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatReplyAdapter, binding};
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
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.d = chatReplyAdapter;
            this.a = binding;
            this.b = 3;
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.c = gradientDrawable;
            gradientDrawable.setCornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds47));
            b();
        }

        public final float a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                TextPaint paint = this.a.b.getPaint();
                Intrinsics.checkNotNullExpressionValue(paint, "binding.questionText.paint");
                return paint.measureText(str);
            }
            return invokeL.floatValue;
        }

        public final void b() {
            int skinType;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                this.b = skinType;
                this.a.c.setBackground(this.c);
                EMManager.from(this.a.d).setCardType(0).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0205);
            }
        }

        public final void c(QuickReplyData.QuestionData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!StringUtils.isNull(data.getQuestion())) {
                    this.a.b.setText(data.getQuestion());
                }
                if (!StringUtils.isNull(data.getQuestionBg())) {
                    Glide.with(this.d.getMContext()).load(data.getQuestionBg()).into(this.a.c);
                } else {
                    SkinManager.setImageResource(this.a.c, R.drawable.obfuscated_res_0x7f0804ed);
                }
                if (!StringUtils.isNull(data.getTextColor())) {
                    this.a.b.setTextColor(Color.parseColor(data.getTextColor()));
                } else {
                    EMManager.from(this.a.b).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01);
                    this.a.b.setTextColor(SkinManager.getColor(0, (int) R.color.CAM_X0119));
                }
                ViewGroup.LayoutParams layoutParams = this.a.c.getLayoutParams();
                layoutParams.width = ((int) a(String.valueOf(data.getQuestion()))) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X009) * 2);
                this.a.c.setLayoutParams(layoutParams);
            }
        }
    }

    public ChatReplyAdapter(Context mContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.a = mContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public final Context getMContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public final QuickReplyData.QuestionData l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (!ListUtils.isEmpty(this.b) && ListUtils.getCount(this.b) > i) {
                return (QuickReplyData.QuestionData) ListUtils.getItem(this.b, i);
            }
            return null;
        }
        return (QuickReplyData.QuestionData) invokeI.objValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(List<QuickReplyData.QuestionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.b = list;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(ViewHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Object item = ListUtils.getItem(this.b, i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(mDataList, position)");
            QuickReplyData.QuestionData questionData = (QuickReplyData.QuestionData) item;
            holder.c(questionData);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            Intrinsics.checkNotNullExpressionValue(currentAccount, "TbadkApplication.getCurrentAccount() ?: \"\"");
            m79.a("c15229", currentAccount, questionData.getQuestion());
            holder.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ItemQuickChatReplyBinding c = ItemQuickChatReplyBinding.c(LayoutInflater.from(this.a), parent, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.f…mContext), parent, false)");
            return new ViewHolder(this, c);
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
