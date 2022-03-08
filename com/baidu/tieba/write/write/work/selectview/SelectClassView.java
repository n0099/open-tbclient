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
import c.a.q0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectClassDialogActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.selectview.SelectClassView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.runtime.reflect.SignatureImpl;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010-J\u0006\u00105\u001a\u000203J\b\u00106\u001a\u000203H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "mCenterContent", "Landroid/widget/TextView;", "getMCenterContent", "()Landroid/widget/TextView;", "setMCenterContent", "(Landroid/widget/TextView;)V", "mCenterContentTips", "getMCenterContentTips", "setMCenterContentTips", "mClassTitleSign", "Landroid/widget/ImageView;", "getMClassTitleSign", "()Landroid/widget/ImageView;", "setMClassTitleSign", "(Landroid/widget/ImageView;)V", "mIsSelectedTags", "", "getMIsSelectedTags", "()Z", "setMIsSelectedTags", "(Z)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "mRightArrow", "getMRightArrow", "setMRightArrow", "mVideoCategoryClassData", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "getMVideoCategoryClassData", "()Lcom/baidu/tbadk/data/VideoCategoryClassData;", "setMVideoCategoryClassData", "(Lcom/baidu/tbadk/data/VideoCategoryClassData;)V", "bindData", "", "bean", "init", "onChangeSkin", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class SelectClassView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48597e;

    /* renamed from: f  reason: collision with root package name */
    public VideoCategoryClassData f48598f;
    public View mBottomLine;
    public TextView mCenterContent;
    public TextView mCenterContentTips;
    public ImageView mClassTitleSign;
    public TextView mLeftTitle;
    public ImageView mRightArrow;

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

    public static final void a(SelectClassView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectClassDialogActivityConfig selectClassDialogActivityConfig = new SelectClassDialogActivityConfig(this$0.getContext());
            VideoCategoryClassData mVideoCategoryClassData = this$0.getMVideoCategoryClassData();
            selectClassDialogActivityConfig.setFirstOption(mVideoCategoryClassData == null ? null : mVideoCategoryClassData.getFirstClass());
            VideoCategoryClassData mVideoCategoryClassData2 = this$0.getMVideoCategoryClassData();
            selectClassDialogActivityConfig.setSecondOption(mVideoCategoryClassData2 != null ? mVideoCategoryClassData2.getSecondClass() : null);
            selectClassDialogActivityConfig.setIsSelectedTags(this$0.getMIsSelectedTags());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectClassDialogActivityConfig));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x0046: INVOKE  (r2v6 java.lang.String A[REMOVE]) = (r5v0 com.baidu.tbadk.data.VideoCategoryClassData) type: VIRTUAL call: com.baidu.tbadk.data.VideoCategoryClassData.getFirstClass():java.lang.String)), (wrap: char : ?: SGET   org.aspectj.runtime.reflect.SignatureImpl.SEP char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x0052: INVOKE  (r5v3 java.lang.String A[REMOVE]) = (r5v0 com.baidu.tbadk.data.VideoCategoryClassData) type: VIRTUAL call: com.baidu.tbadk.data.VideoCategoryClassData.getSecondClass():java.lang.String))] */
    public final void bindData(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoCategoryClassData) == null) {
            this.f48598f = videoCategoryClassData;
            if (videoCategoryClassData != null) {
                String firstClass = videoCategoryClassData.getFirstClass();
                boolean z = true;
                if (!(firstClass == null || firstClass.length() == 0)) {
                    String secondClass = videoCategoryClassData.getSecondClass();
                    if (secondClass != null && secondClass.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        getMCenterContent().setVisibility(0);
                        getMCenterContentTips().setVisibility(8);
                        TextView mCenterContent = getMCenterContent();
                        StringBuilder sb = new StringBuilder();
                        sb.append((Object) videoCategoryClassData.getFirstClass());
                        sb.append(SignatureImpl.SEP);
                        sb.append((Object) videoCategoryClassData.getSecondClass());
                        mCenterContent.setText(sb.toString());
                        return;
                    }
                }
            }
            getMCenterContent().setVisibility(8);
            getMCenterContentTips().setVisibility(0);
        }
    }

    public final View getMBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.mBottomLine;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.mCenterContent;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getMCenterContentTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.mCenterContentTips;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContentTips");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView getMClassTitleSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageView imageView = this.mClassTitleSign;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mClassTitleSign");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final boolean getMIsSelectedTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48597e : invokeV.booleanValue;
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

    public final VideoCategoryClassData getMVideoCategoryClassData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f48598f : (VideoCategoryClassData) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.view_select_class, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.work_publish_class_sign);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.work_publish_class_sign)");
            setMClassTitleSign((ImageView) findViewById);
            View findViewById2 = findViewById(R.id.left_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.left_title)");
            setMLeftTitle((TextView) findViewById2);
            View findViewById3 = findViewById(R.id.center_content_tips);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.center_content_tips)");
            setMCenterContentTips((TextView) findViewById3);
            View findViewById4 = findViewById(R.id.center_content);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.center_content)");
            setMCenterContent((TextView) findViewById4);
            View findViewById5 = findViewById(R.id.right_arrow);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.right_arrow)");
            setMRightArrow((ImageView) findViewById5);
            View findViewById6 = findViewById(R.id.bottom_line);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.bottom_line)");
            setMBottomLine(findViewById6);
            onChangeSkin();
            setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.q4.u.p.z.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        SelectClassView.a(SelectClassView.this, view);
                    }
                }
            });
            bindData(null);
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SkinManager.setViewTextColor(getMLeftTitle(), (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(getMRightArrow(), R.drawable.icon_list_arrow20_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(getMBottomLine(), R.color.CAM_X0210);
            getMCenterContentTips().setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            c d2 = c.d(getMCenterContent());
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mBottomLine = view;
        }
    }

    public final void setMCenterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mCenterContent = textView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mCenterContentTips = textView;
        }
    }

    public final void setMClassTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mClassTitleSign = imageView;
        }
    }

    public final void setMIsSelectedTags(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f48597e = z;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mLeftTitle = textView;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mRightArrow = imageView;
        }
    }

    public final void setMVideoCategoryClassData(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoCategoryClassData) == null) {
            this.f48598f = videoCategoryClassData;
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
