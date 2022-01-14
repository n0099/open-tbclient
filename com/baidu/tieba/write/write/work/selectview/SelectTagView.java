package com.baidu.tieba.write.write.work.selectview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.u.c;
import c.a.t0.p4.d;
import c.a.t0.p4.e;
import c.a.t0.p4.e0.p.z.a;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectTagActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tieba.write.write.work.selectview.SelectTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010>\u001a\u00020?2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\f06j\b\u0012\u0004\u0012\u00020\f`7J\u0006\u0010A\u001a\u00020?J\b\u0010B\u001a\u00020?H\u0016J\u0016\u0010C\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001e\u00105\u001a\u0012\u0012\u0004\u0012\u00020\f06j\b\u0012\u0004\u0012\u00020\f`7X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001c\u0010;\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010¨\u0006D"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "firstClass", "", "getFirstClass", "()Ljava/lang/String;", "setFirstClass", "(Ljava/lang/String;)V", "labelTextProvider", "Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "getLabelTextProvider", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "setLabelTextProvider", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;)V", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "mCenterContent", "Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "getMCenterContent", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "setMCenterContent", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView;)V", "mCenterContentTips", "Landroid/widget/TextView;", "getMCenterContentTips", "()Landroid/widget/TextView;", "setMCenterContentTips", "(Landroid/widget/TextView;)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "mRightArrow", "Landroid/widget/ImageView;", "getMRightArrow", "()Landroid/widget/ImageView;", "setMRightArrow", "(Landroid/widget/ImageView;)V", "mRootView", "getMRootView", "setMRootView", "mTagList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTagTitleRightSign", "getMTagTitleRightSign", "setMTagTitleRightSign", "secondClass", "getSecondClass", "setSecondClass", "bindData", "", "bean", "initView", "onChangeSkin", "setClassData", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class SelectTagView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f49969e;

    /* renamed from: f  reason: collision with root package name */
    public String f49970f;

    /* renamed from: g  reason: collision with root package name */
    public String f49971g;

    /* renamed from: h  reason: collision with root package name */
    public AutoChangeLineView.b<String> f49972h;
    public View mBottomLine;
    public AutoChangeLineView mCenterContent;
    public TextView mCenterContentTips;
    public TextView mLeftTitle;
    public ImageView mRightArrow;
    public View mRootView;
    public ImageView mTagTitleRightSign;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTagView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49969e = new ArrayList<>();
        this.f49972h = a.a;
        initView();
    }

    public static final void a(SelectTagView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String firstClass = this$0.getFirstClass();
            boolean z = false;
            if (!(firstClass == null || firstClass.length() == 0)) {
                String secondClass = this$0.getSecondClass();
                if (!((secondClass == null || secondClass.length() == 0) ? true : true)) {
                    SelectTagActivityConfig selectTagActivityConfig = new SelectTagActivityConfig(this$0.getContext());
                    selectTagActivityConfig.setTagList(this$0.f49969e);
                    selectTagActivityConfig.setFirstClass(this$0.getFirstClass());
                    selectTagActivityConfig.setSecondClass(this$0.getSecondClass());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectTagActivityConfig));
                    return;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921605, Boolean.TRUE));
        }
    }

    public static final CharSequence b(TextView textView, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView, i2, str)) == null) {
            textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(e.M_W_X002));
            textView.setCompoundDrawables(null, null, null, null);
            c d2 = c.d(textView);
            d2.v(d.CAM_X0105);
            d2.z(e.T_X09);
            d2.n(j.J_X01);
            d2.f(d.CAM_X0204);
            return str;
        }
        return (CharSequence) invokeLIL.objValue;
    }

    public final void bindData(ArrayList<String> bean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bean) == null) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            this.f49969e = bean;
            if (bean.isEmpty()) {
                getMCenterContent().setVisibility(8);
                getMCenterContentTips().setVisibility(0);
                return;
            }
            getMCenterContent().setVisibility(0);
            getMCenterContentTips().setVisibility(8);
            getMCenterContent().setLabels(bean, this.f49972h);
        }
    }

    public final String getFirstClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49970f : (String) invokeV.objValue;
    }

    public final AutoChangeLineView.b<String> getLabelTextProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49972h : (AutoChangeLineView.b) invokeV.objValue;
    }

    public final View getMBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.mBottomLine;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final AutoChangeLineView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AutoChangeLineView autoChangeLineView = this.mCenterContent;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TextView textView = this.mCenterContentTips;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.mLeftTitle;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImageView imageView = this.mRightArrow;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final View getMRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view = this.mRootView;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final ImageView getMTagTitleRightSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.mTagTitleRightSign;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTagTitleRightSign");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final String getSecondClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49971g : (String) invokeV.objValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LayoutInflater.from(getContext()).inflate(h.view_select_tag, (ViewGroup) this, true);
            View findViewById = findViewById(g.work_publish_tag_sign);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.work_publish_tag_sign)");
            setMTagTitleRightSign((ImageView) findViewById);
            View findViewById2 = findViewById(g.part_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.part_name)");
            setMLeftTitle((TextView) findViewById2);
            View findViewById3 = findViewById(g.background_show_text);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.background_show_text)");
            setMCenterContentTips((TextView) findViewById3);
            View findViewById4 = findViewById(g.center_card_content);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.center_card_content)");
            setMCenterContent((AutoChangeLineView) findViewById4);
            View findViewById5 = findViewById(g.right_arrow_view);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.right_arrow_view)");
            setMRightArrow((ImageView) findViewById5);
            View findViewById6 = findViewById(g.content_bottom_line);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.content_bottom_line)");
            setMBottomLine(findViewById6);
            onChangeSkin();
            setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.p4.e0.p.z.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        SelectTagView.a(SelectTagView.this, view);
                    }
                }
            });
            bindData(new ArrayList<>());
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getMCenterContent().setLabels(this.f49969e, this.f49972h);
            SkinManager.setViewTextColor(getMLeftTitle(), d.CAM_X0105);
            WebPManager.setPureDrawable(getMRightArrow(), f.icon_list_arrow20_right, d.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(getMBottomLine(), d.CAM_X0210);
            getMCenterContentTips().setTextColor(SkinManager.getColor(d.CAM_X0109));
            c d2 = c.d(getMCenterContent());
            d2.A(j.F_X01);
            d2.z(e.T_X07);
            d2.v(d.CAM_X0105);
        }
    }

    public final void setClassData(String firstClass, String secondClass) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, firstClass, secondClass) == null) {
            Intrinsics.checkNotNullParameter(firstClass, "firstClass");
            Intrinsics.checkNotNullParameter(secondClass, "secondClass");
            this.f49970f = firstClass;
            this.f49971g = secondClass;
        }
    }

    public final void setFirstClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f49970f = str;
        }
    }

    public final void setLabelTextProvider(AutoChangeLineView.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f49972h = bVar;
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mBottomLine = view;
        }
    }

    public final void setMCenterContent(AutoChangeLineView autoChangeLineView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, autoChangeLineView) == null) {
            Intrinsics.checkNotNullParameter(autoChangeLineView, "<set-?>");
            this.mCenterContent = autoChangeLineView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mCenterContentTips = textView;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mLeftTitle = textView;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mRightArrow = imageView;
        }
    }

    public final void setMRootView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mRootView = view;
        }
    }

    public final void setMTagTitleRightSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mTagTitleRightSign = imageView;
        }
    }

    public final void setSecondClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f49971g = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49969e = new ArrayList<>();
        this.f49972h = a.a;
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTagView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49969e = new ArrayList<>();
        this.f49972h = a.a;
        initView();
    }
}
