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
import b.a.q0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectTagActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bG\u0010HB\u001d\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010J\u001a\u0004\u0018\u00010I¢\u0006\u0004\bG\u0010KB%\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bG\u0010NJ%\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b;\u0010\u001e\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010@\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b@\u00106\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014¨\u0006O"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "Landroid/widget/RelativeLayout;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bean", "", "bindData", "(Ljava/util/ArrayList;)V", "initView", "()V", "onChangeSkin", "firstClass", "secondClass", "setClassData", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getFirstClass", "()Ljava/lang/String;", "setFirstClass", "(Ljava/lang/String;)V", "Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "labelTextProvider", "Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "getLabelTextProvider", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "setLabelTextProvider", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;)V", "Landroid/view/View;", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "mCenterContent", "Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "getMCenterContent", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "setMCenterContent", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView;)V", "Landroid/widget/TextView;", "mCenterContentTips", "Landroid/widget/TextView;", "getMCenterContentTips", "()Landroid/widget/TextView;", "setMCenterContentTips", "(Landroid/widget/TextView;)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "Landroid/widget/ImageView;", "mRightArrow", "Landroid/widget/ImageView;", "getMRightArrow", "()Landroid/widget/ImageView;", "setMRightArrow", "(Landroid/widget/ImageView;)V", "mRootView", "getMRootView", "setMRootView", "mTagList", "Ljava/util/ArrayList;", "mTagTitleRightSign", "getMTagTitleRightSign", "setMTagTitleRightSign", "getSecondClass", "setSecondClass", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class SelectTagView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f56257e;

    /* renamed from: f  reason: collision with root package name */
    public String f56258f;

    /* renamed from: g  reason: collision with root package name */
    public String f56259g;

    /* renamed from: h  reason: collision with root package name */
    public AutoChangeLineView.b<String> f56260h;
    public View mBottomLine;
    public AutoChangeLineView mCenterContent;
    public TextView mCenterContentTips;
    public TextView mLeftTitle;
    public ImageView mRightArrow;
    public View mRootView;
    public ImageView mTagTitleRightSign;

    /* loaded from: classes10.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagView f56261e;

        public a(SelectTagView selectTagView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56261e = selectTagView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String firstClass = this.f56261e.getFirstClass();
                boolean z = false;
                if (!(firstClass == null || firstClass.length() == 0)) {
                    String secondClass = this.f56261e.getSecondClass();
                    if (!((secondClass == null || secondClass.length() == 0) ? true : true)) {
                        SelectTagActivityConfig selectTagActivityConfig = new SelectTagActivityConfig(this.f56261e.getContext());
                        selectTagActivityConfig.setTagList(this.f56261e.f56257e);
                        selectTagActivityConfig.setFirstClass(this.f56261e.getFirstClass());
                        selectTagActivityConfig.setSecondClass(this.f56261e.getSecondClass());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectTagActivityConfig));
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921605, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b<T> implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f56262a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-862205544, "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-862205544, "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView$b;");
                    return;
                }
            }
            f56262a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        public /* bridge */ /* synthetic */ CharSequence a(TextView textView, int i2, String str) {
            String str2 = str;
            b(textView, i2, str2);
            return str2;
        }

        public final String b(TextView label, int i2, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, label, i2, str)) == null) {
                Intrinsics.checkExpressionValueIsNotNull(label, "label");
                label.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                label.setCompoundDrawables(null, null, null, null);
                c d2 = c.d(label);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X09);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0204);
                return str;
            }
            return (String) invokeLIL.objValue;
        }
    }

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
        this.f56257e = new ArrayList<>();
        this.f56260h = b.f56262a;
        initView();
    }

    public final void bindData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            this.f56257e = arrayList;
            if (arrayList.isEmpty()) {
                AutoChangeLineView autoChangeLineView = this.mCenterContent;
                if (autoChangeLineView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
                }
                autoChangeLineView.setVisibility(8);
                TextView textView = this.mCenterContentTips;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
                }
                textView.setVisibility(0);
                return;
            }
            AutoChangeLineView autoChangeLineView2 = this.mCenterContent;
            if (autoChangeLineView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            autoChangeLineView2.setVisibility(0);
            TextView textView2 = this.mCenterContentTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            }
            textView2.setVisibility(8);
            AutoChangeLineView autoChangeLineView3 = this.mCenterContent;
            if (autoChangeLineView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            autoChangeLineView3.setLabels(arrayList, this.f56260h);
        }
    }

    public final String getFirstClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56258f : (String) invokeV.objValue;
    }

    public final AutoChangeLineView.b<String> getLabelTextProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56260h : (AutoChangeLineView.b) invokeV.objValue;
    }

    public final View getMBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.mBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final AutoChangeLineView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AutoChangeLineView autoChangeLineView = this.mCenterContent;
            if (autoChangeLineView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            return autoChangeLineView;
        }
        return (AutoChangeLineView) invokeV.objValue;
    }

    public final TextView getMCenterContentTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TextView textView = this.mCenterContentTips;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getMLeftTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.mLeftTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftTitle");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView getMRightArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImageView imageView = this.mRightArrow;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final View getMRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final ImageView getMTagTitleRightSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.mTagTitleRightSign;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagTitleRightSign");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final String getSecondClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f56259g : (String) invokeV.objValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.view_select_tag, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.work_publish_tag_sign);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.work_publish_tag_sign)");
            this.mTagTitleRightSign = (ImageView) findViewById;
            View findViewById2 = findViewById(R.id.part_name);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.part_name)");
            this.mLeftTitle = (TextView) findViewById2;
            View findViewById3 = findViewById(R.id.background_show_text);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.background_show_text)");
            this.mCenterContentTips = (TextView) findViewById3;
            View findViewById4 = findViewById(R.id.center_card_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.center_card_content)");
            this.mCenterContent = (AutoChangeLineView) findViewById4;
            View findViewById5 = findViewById(R.id.right_arrow_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.right_arrow_view)");
            this.mRightArrow = (ImageView) findViewById5;
            View findViewById6 = findViewById(R.id.content_bottom_line);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.content_bottom_line)");
            this.mBottomLine = findViewById6;
            onChangeSkin();
            setOnClickListener(new a(this));
            bindData(new ArrayList<>());
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AutoChangeLineView autoChangeLineView = this.mCenterContent;
            if (autoChangeLineView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            autoChangeLineView.setLabels(this.f56257e, this.f56260h);
            TextView textView = this.mLeftTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftTitle");
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            ImageView imageView = this.mRightArrow;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            }
            WebPManager.setPureDrawable(imageView, R.drawable.icon_list_arrow20_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            View view = this.mBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
            TextView textView2 = this.mCenterContentTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            }
            textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            AutoChangeLineView autoChangeLineView2 = this.mCenterContent;
            if (autoChangeLineView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            c d2 = c.d(autoChangeLineView2);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
        }
    }

    public final void setClassData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            this.f56258f = str;
            this.f56259g = str2;
        }
    }

    public final void setFirstClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f56258f = str;
        }
    }

    public final void setLabelTextProvider(AutoChangeLineView.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.f56260h = bVar;
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.mBottomLine = view;
        }
    }

    public final void setMCenterContent(AutoChangeLineView autoChangeLineView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, autoChangeLineView) == null) {
            this.mCenterContent = autoChangeLineView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, textView) == null) {
            this.mCenterContentTips = textView;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, textView) == null) {
            this.mLeftTitle = textView;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, imageView) == null) {
            this.mRightArrow = imageView;
        }
    }

    public final void setMRootView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            this.mRootView = view;
        }
    }

    public final void setMTagTitleRightSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, imageView) == null) {
            this.mTagTitleRightSign = imageView;
        }
    }

    public final void setSecondClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f56259g = str;
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
        this.f56257e = new ArrayList<>();
        this.f56260h = b.f56262a;
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
        this.f56257e = new ArrayList<>();
        this.f56260h = b.f56262a;
        initView();
    }
}
