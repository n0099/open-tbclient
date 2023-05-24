package com.baidu.tieba.write.write.work.selectview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WorkPublishHotTopicSelectActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tieba.R;
import com.baidu.tieba.p45;
import com.baidu.tieba.write.write.work.selectview.SelectTopicView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u00103\u001a\u0002042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\r0.j\b\u0012\u0004\u0012\u00020\r`/J\u0006\u00106\u001a\u000204J\b\u00107\u001a\u000204H\u0016R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\r0.j\b\u0012\u0004\u0012\u00020\r`/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,¨\u00068"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "labelTextProvider", "Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "", "getLabelTextProvider", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "setLabelTextProvider", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;)V", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "mCenterContent", "Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "getMCenterContent", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "setMCenterContent", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView;)V", "mCenterContentTips", "Landroid/widget/TextView;", "getMCenterContentTips", "()Landroid/widget/TextView;", "setMCenterContentTips", "(Landroid/widget/TextView;)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "mRightArrow", "Landroid/widget/ImageView;", "getMRightArrow", "()Landroid/widget/ImageView;", "setMRightArrow", "(Landroid/widget/ImageView;)V", "mTopicList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTopicTitleSign", "getMTopicTitleSign", "setMTopicTitleSign", "bindData", "", "bean", "init", "onChangeSkin", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class SelectTopicView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public AutoChangeLineView d;
    public ImageView e;
    public View f;
    public ArrayList<String> g;
    public AutoChangeLineView.b<String> h;

    /* loaded from: classes8.dex */
    public static final class a implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        /* renamed from: b */
        public CharSequence a(TextView label, int i, String data) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, label, i, data)) == null) {
                Intrinsics.checkNotNullParameter(label, "label");
                Intrinsics.checkNotNullParameter(data, "data");
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_post_topic12, R.color.CAM_X0109, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                label.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                label.setCompoundDrawables(pureDrawable, null, null, null);
                String cutData = StringHelper.cutChineseAndEnglishWithEmoji(data, 16, StringHelper.STRING_MORE);
                p45 d = p45.d(label);
                d.o(R.string.J_X01);
                d.f(R.color.CAM_X0204);
                Intrinsics.checkNotNullExpressionValue(cutData, "cutData");
                return cutData;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new ArrayList<>();
        this.h = new a();
        b();
    }

    public final void a(ArrayList<String> bean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bean) == null) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            this.g = bean;
            if (bean.isEmpty()) {
                getMCenterContent().setVisibility(8);
                getMCenterContentTips().setVisibility(0);
                return;
            }
            getMCenterContent().setVisibility(0);
            getMCenterContentTips().setVisibility(8);
            getMCenterContent().setLabels(bean, this.h);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new ArrayList<>();
        this.h = new a();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = new ArrayList<>();
        this.h = new a();
        b();
    }

    public static final void c(SelectTopicView this$0, TextView textView, Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65539, null, this$0, textView, obj, i) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WorkPublishHotTopicSelectActivityConfig workPublishHotTopicSelectActivityConfig = new WorkPublishHotTopicSelectActivityConfig(this$0.getContext(), 25004, WorkPublishHotTopicSelectActivityConfig.FROM_POST_WORK_THREAD);
            workPublishHotTopicSelectActivityConfig.setTopicList(this$0.g);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishHotTopicSelectActivityConfig));
        }
    }

    public static final void d(SelectTopicView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WorkPublishHotTopicSelectActivityConfig workPublishHotTopicSelectActivityConfig = new WorkPublishHotTopicSelectActivityConfig(this$0.getContext(), 25004, WorkPublishHotTopicSelectActivityConfig.FROM_POST_WORK_THREAD);
            workPublishHotTopicSelectActivityConfig.setTopicList(this$0.g);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishHotTopicSelectActivityConfig));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d09aa, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092944);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.work_publish_topic_sign)");
            setMTopicTitleSign((ImageView) findViewById);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091492);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.left_title)");
            setMLeftTitle((TextView) findViewById2);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f090677);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.center_content_tips)");
            setMCenterContentTips((TextView) findViewById3);
            View findViewById4 = findViewById(R.id.obfuscated_res_0x7f092527);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.topic_center_content)");
            setMCenterContent((AutoChangeLineView) findViewById4);
            View findViewById5 = findViewById(R.id.obfuscated_res_0x7f091e31);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.right_arrow)");
            setMRightArrow((ImageView) findViewById5);
            View findViewById6 = findViewById(R.id.bottom_line);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.bottom_line)");
            setMBottomLine(findViewById6);
            e();
            getMCenterContent().setOnLabelClickListener(new AutoChangeLineView.c() { // from class: com.baidu.tieba.hea
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
                public final void a(TextView textView, Object obj, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, textView, obj, i) == null) {
                        SelectTopicView.c(SelectTopicView.this, textView, obj, i);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lea
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SelectTopicView.d(SelectTopicView.this, view2);
                    }
                }
            });
            a(new ArrayList<>());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            getMCenterContent().setLabelTextColor(SkinManager.getColor(R.color.CAM_X0105));
            getMCenterContent().setLabels(this.g, this.h);
            SkinManager.setViewTextColor(getMLeftTitle(), (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(getMRightArrow(), R.drawable.icon_list_arrow20_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(getMBottomLine(), R.color.CAM_X0210);
            getMCenterContentTips().setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
    }

    public final AutoChangeLineView.b<String> getLabelTextProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (AutoChangeLineView.b) invokeV.objValue;
    }

    public final View getMBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.f;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final AutoChangeLineView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AutoChangeLineView autoChangeLineView = this.d;
            if (autoChangeLineView != null) {
                return autoChangeLineView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            return null;
        }
        return (AutoChangeLineView) invokeV.objValue;
    }

    public final TextView getMCenterContentTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.c;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getMLeftTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = this.b;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mLeftTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView getMRightArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageView imageView = this.e;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final ImageView getMTopicTitleSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.a;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTopicTitleSign");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final void setLabelTextProvider(AutoChangeLineView.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.h = bVar;
        }
    }

    public final void setMBottomLine(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.f = view2;
        }
    }

    public final void setMCenterContent(AutoChangeLineView autoChangeLineView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, autoChangeLineView) == null) {
            Intrinsics.checkNotNullParameter(autoChangeLineView, "<set-?>");
            this.d = autoChangeLineView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.c = textView;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.b = textView;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.e = imageView;
        }
    }

    public final void setMTopicTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.a = imageView;
        }
    }
}
