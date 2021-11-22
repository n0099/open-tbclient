package com.baidu.tieba.write.write.work.selectview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectClassDialogActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.runtime.reflect.SignatureImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107B\u001d\b\u0016\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b6\u0010:B%\b\u0016\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b6\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010,\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0006¨\u0006>"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "bean", "", "bindData", "(Lcom/baidu/tbadk/data/VideoCategoryClassData;)V", "init", "()V", "onChangeSkin", "Landroid/view/View;", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "mCenterContent", "Landroid/widget/TextView;", "getMCenterContent", "()Landroid/widget/TextView;", "setMCenterContent", "(Landroid/widget/TextView;)V", "mCenterContentTips", "getMCenterContentTips", "setMCenterContentTips", "Landroid/widget/ImageView;", "mClassTitleSign", "Landroid/widget/ImageView;", "getMClassTitleSign", "()Landroid/widget/ImageView;", "setMClassTitleSign", "(Landroid/widget/ImageView;)V", "", "mIsSelectedTags", "Z", "getMIsSelectedTags", "()Z", "setMIsSelectedTags", "(Z)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "mRightArrow", "getMRightArrow", "setMRightArrow", "mVideoCategoryClassData", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "getMVideoCategoryClassData", "()Lcom/baidu/tbadk/data/VideoCategoryClassData;", "setMVideoCategoryClassData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public class SelectClassView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57175e;

    /* renamed from: f  reason: collision with root package name */
    public VideoCategoryClassData f57176f;
    public View mBottomLine;
    public TextView mCenterContent;
    public TextView mCenterContentTips;
    public ImageView mClassTitleSign;
    public TextView mLeftTitle;
    public ImageView mRightArrow;

    /* loaded from: classes9.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassView f57177e;

        public a(SelectClassView selectClassView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57177e = selectClassView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SelectClassDialogActivityConfig selectClassDialogActivityConfig = new SelectClassDialogActivityConfig(this.f57177e.getContext());
                VideoCategoryClassData mVideoCategoryClassData = this.f57177e.getMVideoCategoryClassData();
                selectClassDialogActivityConfig.setFirstOption(mVideoCategoryClassData != null ? mVideoCategoryClassData.getFirstClass() : null);
                VideoCategoryClassData mVideoCategoryClassData2 = this.f57177e.getMVideoCategoryClassData();
                selectClassDialogActivityConfig.setSecondOption(mVideoCategoryClassData2 != null ? mVideoCategoryClassData2.getSecondClass() : null);
                selectClassDialogActivityConfig.setIsSelectedTags(this.f57177e.getMIsSelectedTags());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectClassDialogActivityConfig));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectClassView(Context context) {
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
        init();
    }

    public final void bindData(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoCategoryClassData) == null) {
            this.f57176f = videoCategoryClassData;
            if (videoCategoryClassData != null) {
                String firstClass = videoCategoryClassData.getFirstClass();
                boolean z = true;
                if (!(firstClass == null || firstClass.length() == 0)) {
                    String secondClass = videoCategoryClassData.getSecondClass();
                    if (secondClass != null && secondClass.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        TextView textView = this.mCenterContent;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
                        }
                        textView.setVisibility(0);
                        TextView textView2 = this.mCenterContentTips;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
                        }
                        textView2.setVisibility(8);
                        TextView textView3 = this.mCenterContent;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
                        }
                        textView3.setText(videoCategoryClassData.getFirstClass() + SignatureImpl.SEP + videoCategoryClassData.getSecondClass());
                        return;
                    }
                }
            }
            TextView textView4 = this.mCenterContent;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            textView4.setVisibility(8);
            TextView textView5 = this.mCenterContentTips;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            }
            textView5.setVisibility(0);
        }
    }

    public final View getMBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.mBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.mCenterContent;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getMCenterContentTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.mCenterContentTips;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView getMClassTitleSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageView imageView = this.mClassTitleSign;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mClassTitleSign");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final boolean getMIsSelectedTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57175e : invokeV.booleanValue;
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

    public final VideoCategoryClassData getMVideoCategoryClassData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f57176f : (VideoCategoryClassData) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.view_select_class, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.work_publish_class_sign);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.work_publish_class_sign)");
            this.mClassTitleSign = (ImageView) findViewById;
            View findViewById2 = findViewById(R.id.left_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.left_title)");
            this.mLeftTitle = (TextView) findViewById2;
            View findViewById3 = findViewById(R.id.center_content_tips);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.center_content_tips)");
            this.mCenterContentTips = (TextView) findViewById3;
            View findViewById4 = findViewById(R.id.center_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.center_content)");
            this.mCenterContent = (TextView) findViewById4;
            View findViewById5 = findViewById(R.id.right_arrow);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.right_arrow)");
            this.mRightArrow = (ImageView) findViewById5;
            View findViewById6 = findViewById(R.id.bottom_line);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.bottom_line)");
            this.mBottomLine = findViewById6;
            onChangeSkin();
            setOnClickListener(new a(this));
            bindData(null);
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
            TextView textView3 = this.mCenterContent;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            c d2 = c.d(textView3);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            this.mBottomLine = view;
        }
    }

    public final void setMCenterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textView) == null) {
            this.mCenterContent = textView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, textView) == null) {
            this.mCenterContentTips = textView;
        }
    }

    public final void setMClassTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, imageView) == null) {
            this.mClassTitleSign = imageView;
        }
    }

    public final void setMIsSelectedTags(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f57175e = z;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            this.mLeftTitle = textView;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, imageView) == null) {
            this.mRightArrow = imageView;
        }
    }

    public final void setMVideoCategoryClassData(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoCategoryClassData) == null) {
            this.f57176f = videoCategoryClassData;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectClassView(Context context, AttributeSet attributeSet) {
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectClassView(Context context, AttributeSet attributeSet, int i2) {
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
        init();
    }
}
