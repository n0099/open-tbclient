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
import c.a.d.f.p.n;
import c.a.q0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.selectview.SelectBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108J\u0006\u00109\u001a\u000206J\b\u0010:\u001a\u000206H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001a\u0010,\u001a\u00020$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u000200X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006;"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "mCanChangeBarName", "", "getMCanChangeBarName", "()Z", "setMCanChangeBarName", "(Z)V", "mCenterContent", "Landroid/widget/TextView;", "getMCenterContent", "()Landroid/widget/TextView;", "setMCenterContent", "(Landroid/widget/TextView;)V", "mCenterContentPos", "getMCenterContentPos", "setMCenterContentPos", "mCenterContentTips", "getMCenterContentTips", "setMCenterContentTips", "mIconDrawable", "Landroid/graphics/drawable/Drawable;", "getMIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setMIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "mPosDrawable", "getMPosDrawable", "setMPosDrawable", "mRightArrow", "Landroid/widget/ImageView;", "getMRightArrow", "()Landroid/widget/ImageView;", "setMRightArrow", "(Landroid/widget/ImageView;)V", "bindData", "", "bean", "Lcom/baidu/tbadk/data/SelectForumData;", "init", "onChangeSkin", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class SelectBarView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48596e;
    public View mBottomLine;
    public TextView mCenterContent;
    public TextView mCenterContentPos;
    public TextView mCenterContentTips;
    public Drawable mIconDrawable;
    public TextView mLeftTitle;
    public Drawable mPosDrawable;
    public ImageView mRightArrow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBarView(Context context) {
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
        this.f48596e = true;
        init();
    }

    public static final void a(SelectBarView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getMCanChangeBarName()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this$0.getContext())));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921621, Boolean.TRUE));
        }
    }

    public final void bindData(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) {
            if (selectForumData != null) {
                String str = selectForumData.forumId;
                boolean z = true;
                if (!(str == null || str.length() == 0)) {
                    String str2 = selectForumData.forumName;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        getMCenterContent().setVisibility(0);
                        getMCenterContentTips().setVisibility(8);
                        getMCenterContent().setText(Intrinsics.stringPlus(selectForumData.forumName, getContext().getString(R.string.forum)));
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

    public final boolean getMCanChangeBarName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48596e : invokeV.booleanValue;
    }

    public final TextView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.mCenterContent;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getMCenterContentPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.mCenterContentPos;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            return null;
        }
        return (TextView) invokeV.objValue;
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

    public final Drawable getMIconDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Drawable drawable = this.mIconDrawable;
            if (drawable != null) {
                return drawable;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mIconDrawable");
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public final TextView getMLeftTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = this.mLeftTitle;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mLeftTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final Drawable getMPosDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Drawable drawable = this.mPosDrawable;
            if (drawable != null) {
                return drawable;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPosDrawable");
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public final ImageView getMRightArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.mRightArrow;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.view_select_bar, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.left_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.left_title)");
            setMLeftTitle((TextView) findViewById);
            View findViewById2 = findViewById(R.id.center_content_tips);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.center_content_tips)");
            setMCenterContentTips((TextView) findViewById2);
            View findViewById3 = findViewById(R.id.center_content);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.center_content)");
            setMCenterContent((TextView) findViewById3);
            getMCenterContent().setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
            View findViewById4 = findViewById(R.id.center_content_pos);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.center_content_pos)");
            setMCenterContentPos((TextView) findViewById4);
            getMCenterContentPos().setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
            getMCenterContentPos().setVisibility(8);
            View findViewById5 = findViewById(R.id.right_arrow);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.right_arrow)");
            setMRightArrow((ImageView) findViewById5);
            View findViewById6 = findViewById(R.id.bottom_line);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.bottom_line)");
            setMBottomLine(findViewById6);
            onChangeSkin();
            setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.q4.u.p.z.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        SelectBarView.a(SelectBarView.this, view);
                    }
                }
            });
            bindData(null);
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SkinManager.setViewTextColor(getMLeftTitle(), (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(getMRightArrow(), R.drawable.icon_list_arrow20_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(getMBottomLine(), R.color.CAM_X0210);
            getMCenterContentTips().setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            c d2 = c.d(getMCenterContent());
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0105);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0204);
            d2.f(R.color.CAM_X0204);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba12, SkinManager.getColor(R.color.CAM_X0110), WebPManager.ResourceStateType.NORMAL_PRESS);
            Intrinsics.checkNotNullExpressionValue(pureDrawable, "getPureDrawable(R.drawab…ceStateType.NORMAL_PRESS)");
            setMIconDrawable(pureDrawable);
            int f2 = n.f(getContext(), R.dimen.tbds32);
            getMIconDrawable().setBounds(0, 0, f2, f2);
            getMCenterContent().setCompoundDrawables(getMIconDrawable(), null, null, null);
            getMCenterContent().setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
            getMCenterContent().setPadding(n.f(getContext(), R.dimen.M_W_X004), 0, n.f(getContext(), R.dimen.M_W_X004), 0);
            c d3 = c.d(getMCenterContentPos());
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0105);
            d3.e(R.string.A_X07);
            d3.n(R.string.J_X01);
            d3.l(R.dimen.L_X02);
            d3.k(R.color.CAM_X0204);
            d3.f(R.color.CAM_X0204);
            Drawable pureDrawable2 = WebPManager.getPureDrawable(R.drawable.ic_icon_pure_post_location12, SkinManager.getColor(R.color.CAM_X0110), WebPManager.ResourceStateType.NORMAL);
            Intrinsics.checkNotNullExpressionValue(pureDrawable2, "getPureDrawable(R.drawab…ResourceStateType.NORMAL)");
            setMPosDrawable(pureDrawable2);
            getMPosDrawable().setBounds(0, 0, f2, f2);
            getMCenterContentPos().setCompoundDrawables(getMPosDrawable(), null, null, null);
            getMCenterContentPos().setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X004));
            getMCenterContentPos().setPadding(n.f(getContext(), R.dimen.M_W_X004), 0, n.f(getContext(), R.dimen.M_W_X002), 0);
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mBottomLine = view;
        }
    }

    public final void setMCanChangeBarName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f48596e = z;
        }
    }

    public final void setMCenterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mCenterContent = textView;
        }
    }

    public final void setMCenterContentPos(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mCenterContentPos = textView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mCenterContentTips = textView;
        }
    }

    public final void setMIconDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, drawable) == null) {
            Intrinsics.checkNotNullParameter(drawable, "<set-?>");
            this.mIconDrawable = drawable;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mLeftTitle = textView;
        }
    }

    public final void setMPosDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            Intrinsics.checkNotNullParameter(drawable, "<set-?>");
            this.mPosDrawable = drawable;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mRightArrow = imageView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBarView(Context context, AttributeSet attributeSet) {
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
        this.f48596e = true;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBarView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f48596e = true;
        init();
    }
}
