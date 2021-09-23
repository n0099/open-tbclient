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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:B\u001d\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b9\u0010=B%\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b9\u0010@J%\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00104\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/\"\u0004\b6\u00101¨\u0006A"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "Landroid/widget/LinearLayout;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bean", "", "bindData", "(Ljava/util/ArrayList;)V", "init", "()V", "onChangeSkin", "Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "labelTextProvider", "Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "getLabelTextProvider", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;", "setLabelTextProvider", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView$LabelTextProvider;)V", "Landroid/view/View;", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "mCenterContent", "Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "getMCenterContent", "()Lcom/baidu/tbadk/core/view/AutoChangeLineView;", "setMCenterContent", "(Lcom/baidu/tbadk/core/view/AutoChangeLineView;)V", "Landroid/widget/TextView;", "mCenterContentTips", "Landroid/widget/TextView;", "getMCenterContentTips", "()Landroid/widget/TextView;", "setMCenterContentTips", "(Landroid/widget/TextView;)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "Landroid/widget/ImageView;", "mRightArrow", "Landroid/widget/ImageView;", "getMRightArrow", "()Landroid/widget/ImageView;", "setMRightArrow", "(Landroid/widget/ImageView;)V", "mTopicList", "Ljava/util/ArrayList;", "mTopicTitleSign", "getMTopicTitleSign", "setMTopicTitleSign", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public class SelectTopicView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f59363e;

    /* renamed from: f  reason: collision with root package name */
    public AutoChangeLineView.b<String> f59364f;
    public View mBottomLine;
    public AutoChangeLineView mCenterContent;
    public TextView mCenterContentTips;
    public TextView mLeftTitle;
    public ImageView mRightArrow;
    public ImageView mTopicTitleSign;

    /* loaded from: classes8.dex */
    public static final class a implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicView f59365e;

        public a(SelectTopicView selectTopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59365e = selectTopicView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public final void onLabelClick(TextView textView, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) {
                WorkPublishHotTopicSelectActivityConfig workPublishHotTopicSelectActivityConfig = new WorkPublishHotTopicSelectActivityConfig(this.f59365e.getContext(), 25004, WorkPublishHotTopicSelectActivityConfig.FROM_POST_WORK_THREAD);
                workPublishHotTopicSelectActivityConfig.setTopicList(this.f59365e.f59363e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishHotTopicSelectActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicView f59366e;

        public b(SelectTopicView selectTopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59366e = selectTopicView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                WorkPublishHotTopicSelectActivityConfig workPublishHotTopicSelectActivityConfig = new WorkPublishHotTopicSelectActivityConfig(this.f59366e.getContext(), 25004, WorkPublishHotTopicSelectActivityConfig.FROM_POST_WORK_THREAD);
                workPublishHotTopicSelectActivityConfig.setTopicList(this.f59366e.f59363e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishHotTopicSelectActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i2, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i2, str)) == null) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_post_topic12, R.color.CAM_X0109, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setCompoundDrawables(pureDrawable, null, null, null);
                String cutData = StringHelper.cutChineseAndEnglishWithEmoji(str, 16, "...");
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
                d2.o(R.string.J_X01);
                d2.f(R.color.CAM_X0204);
                Intrinsics.checkExpressionValueIsNotNull(cutData, "cutData");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59363e = new ArrayList<>();
        this.f59364f = new c();
        init();
    }

    public final void bindData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            this.f59363e = arrayList;
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
            autoChangeLineView3.setLabels(arrayList, this.f59364f);
        }
    }

    public final AutoChangeLineView.b<String> getLabelTextProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59364f : (AutoChangeLineView.b) invokeV.objValue;
    }

    public final View getMBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ImageView imageView = this.mRightArrow;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final ImageView getMTopicTitleSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImageView imageView = this.mTopicTitleSign;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopicTitleSign");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.view_select_topic, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.work_publish_topic_sign);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.work_publish_topic_sign)");
            this.mTopicTitleSign = (ImageView) findViewById;
            View findViewById2 = findViewById(R.id.left_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.left_title)");
            this.mLeftTitle = (TextView) findViewById2;
            View findViewById3 = findViewById(R.id.center_content_tips);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.center_content_tips)");
            this.mCenterContentTips = (TextView) findViewById3;
            View findViewById4 = findViewById(R.id.center_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.center_content)");
            this.mCenterContent = (AutoChangeLineView) findViewById4;
            View findViewById5 = findViewById(R.id.right_arrow);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.right_arrow)");
            this.mRightArrow = (ImageView) findViewById5;
            View findViewById6 = findViewById(R.id.bottom_line);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.bottom_line)");
            this.mBottomLine = findViewById6;
            onChangeSkin();
            AutoChangeLineView autoChangeLineView = this.mCenterContent;
            if (autoChangeLineView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            autoChangeLineView.setOnLabelClickListener(new a(this));
            setOnClickListener(new b(this));
            bindData(new ArrayList<>());
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AutoChangeLineView autoChangeLineView = this.mCenterContent;
            if (autoChangeLineView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            autoChangeLineView.setLabelTextColor(SkinManager.getColor(R.color.CAM_X0105));
            AutoChangeLineView autoChangeLineView2 = this.mCenterContent;
            if (autoChangeLineView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            autoChangeLineView2.setLabels(this.f59363e, this.f59364f);
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
        }
    }

    public final void setLabelTextProvider(AutoChangeLineView.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f59364f = bVar;
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            this.mBottomLine = view;
        }
    }

    public final void setMCenterContent(AutoChangeLineView autoChangeLineView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, autoChangeLineView) == null) {
            this.mCenterContent = autoChangeLineView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, textView) == null) {
            this.mCenterContentTips = textView;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            this.mLeftTitle = textView;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imageView) == null) {
            this.mRightArrow = imageView;
        }
    }

    public final void setMTopicTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, imageView) == null) {
            this.mTopicTitleSign = imageView;
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
        this.f59363e = new ArrayList<>();
        this.f59364f = new c();
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f59363e = new ArrayList<>();
        this.f59364f = new c();
        init();
    }
}
