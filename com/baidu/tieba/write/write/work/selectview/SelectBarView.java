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
import c.a.e.e.p.l;
import c.a.q0.s.u.c;
import c.a.q0.u.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<B\u001d\b\u0016\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\b\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b;\u0010?B%\b\u0016\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b;\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\"\u0010/\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006C"}, d2 = {"Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tbadk/data/SelectForumData;", "bean", "", "bindData", "(Lcom/baidu/tbadk/data/SelectForumData;)V", "init", "()V", "onChangeSkin", "Landroid/view/View;", "mBottomLine", "Landroid/view/View;", "getMBottomLine", "()Landroid/view/View;", "setMBottomLine", "(Landroid/view/View;)V", "", "mCanChangeBarName", "Z", "getMCanChangeBarName", "()Z", "setMCanChangeBarName", "(Z)V", "Landroid/widget/TextView;", "mCenterContent", "Landroid/widget/TextView;", "getMCenterContent", "()Landroid/widget/TextView;", "setMCenterContent", "(Landroid/widget/TextView;)V", "mCenterContentPos", "getMCenterContentPos", "setMCenterContentPos", "mCenterContentTips", "getMCenterContentTips", "setMCenterContentTips", "Landroid/graphics/drawable/Drawable;", "mIconDrawable", "Landroid/graphics/drawable/Drawable;", "getMIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setMIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mLeftTitle", "getMLeftTitle", "setMLeftTitle", "mPosDrawable", "getMPosDrawable", "setMPosDrawable", "Landroid/widget/ImageView;", "mRightArrow", "Landroid/widget/ImageView;", "getMRightArrow", "()Landroid/widget/ImageView;", "setMRightArrow", "(Landroid/widget/ImageView;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public class SelectBarView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59310e;
    public View mBottomLine;
    public TextView mCenterContent;
    public TextView mCenterContentPos;
    public TextView mCenterContentTips;
    public Drawable mIconDrawable;
    public TextView mLeftTitle;
    public Drawable mPosDrawable;
    public ImageView mRightArrow;

    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectBarView f59311e;

        public a(SelectBarView selectBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59311e = selectBarView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59311e.getMCanChangeBarName()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.f59311e.getContext())));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921621, Boolean.TRUE));
            }
        }
    }

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
        this.f59310e = true;
        init();
    }

    public final void bindData(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            if (iVar != null) {
                String str = iVar.f15059a;
                boolean z = true;
                if (!(str == null || str.length() == 0)) {
                    String str2 = iVar.f15061c;
                    if (str2 != null && str2.length() != 0) {
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
                        textView3.setText(iVar.f15061c + getContext().getString(R.string.forum));
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

    public final boolean getMCanChangeBarName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59310e : invokeV.booleanValue;
    }

    public final TextView getMCenterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.mCenterContent;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getMCenterContentPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.mCenterContentPos;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
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

    public final Drawable getMIconDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Drawable drawable = this.mIconDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconDrawable");
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public final TextView getMLeftTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = this.mLeftTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftTitle");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final Drawable getMPosDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Drawable drawable = this.mPosDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosDrawable");
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public final ImageView getMRightArrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.mRightArrow;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightArrow");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.view_select_bar, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.left_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.left_title)");
            this.mLeftTitle = (TextView) findViewById;
            View findViewById2 = findViewById(R.id.center_content_tips);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.center_content_tips)");
            this.mCenterContentTips = (TextView) findViewById2;
            View findViewById3 = findViewById(R.id.center_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.center_content)");
            TextView textView = (TextView) findViewById3;
            this.mCenterContent = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            textView.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
            View findViewById4 = findViewById(R.id.center_content_pos);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.center_content_pos)");
            TextView textView2 = (TextView) findViewById4;
            this.mCenterContentPos = textView2;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            textView2.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
            TextView textView3 = this.mCenterContentPos;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            textView3.setVisibility(8);
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0105);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0204);
            d2.f(R.color.CAM_X0204);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba12, SkinManager.getColor(R.color.CAM_X0110), WebPManager.ResourceStateType.NORMAL_PRESS);
            Intrinsics.checkExpressionValueIsNotNull(pureDrawable, "WebPManager.getPureDrawa…ceStateType.NORMAL_PRESS)");
            this.mIconDrawable = pureDrawable;
            int g2 = l.g(getContext(), R.dimen.tbds32);
            Drawable drawable = this.mIconDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconDrawable");
            }
            drawable.setBounds(0, 0, g2, g2);
            TextView textView4 = this.mCenterContent;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            Drawable drawable2 = this.mIconDrawable;
            if (drawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconDrawable");
            }
            textView4.setCompoundDrawables(drawable2, null, null, null);
            TextView textView5 = this.mCenterContent;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            textView5.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
            TextView textView6 = this.mCenterContent;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContent");
            }
            textView6.setPadding(l.g(getContext(), R.dimen.M_W_X004), 0, l.g(getContext(), R.dimen.M_W_X004), 0);
            TextView textView7 = this.mCenterContentPos;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            c d3 = c.d(textView7);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0105);
            d3.e(R.string.A_X07);
            d3.n(R.string.J_X01);
            d3.l(R.dimen.L_X02);
            d3.k(R.color.CAM_X0204);
            d3.f(R.color.CAM_X0204);
            Drawable pureDrawable2 = WebPManager.getPureDrawable(R.drawable.ic_icon_pure_post_location12, SkinManager.getColor(R.color.CAM_X0110), WebPManager.ResourceStateType.NORMAL);
            Intrinsics.checkExpressionValueIsNotNull(pureDrawable2, "WebPManager.getPureDrawa…ResourceStateType.NORMAL)");
            this.mPosDrawable = pureDrawable2;
            if (pureDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosDrawable");
            }
            pureDrawable2.setBounds(0, 0, g2, g2);
            TextView textView8 = this.mCenterContentPos;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            Drawable drawable3 = this.mPosDrawable;
            if (drawable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosDrawable");
            }
            textView8.setCompoundDrawables(drawable3, null, null, null);
            TextView textView9 = this.mCenterContentPos;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            textView9.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X004));
            TextView textView10 = this.mCenterContentPos;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContentPos");
            }
            textView10.setPadding(l.g(getContext(), R.dimen.M_W_X004), 0, l.g(getContext(), R.dimen.M_W_X002), 0);
        }
    }

    public final void setMBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.mBottomLine = view;
        }
    }

    public final void setMCanChangeBarName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f59310e = z;
        }
    }

    public final void setMCenterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            this.mCenterContent = textView;
        }
    }

    public final void setMCenterContentPos(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, textView) == null) {
            this.mCenterContentPos = textView;
        }
    }

    public final void setMCenterContentTips(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            this.mCenterContentTips = textView;
        }
    }

    public final void setMIconDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, drawable) == null) {
            this.mIconDrawable = drawable;
        }
    }

    public final void setMLeftTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, textView) == null) {
            this.mLeftTitle = textView;
        }
    }

    public final void setMPosDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            this.mPosDrawable = drawable;
        }
    }

    public final void setMRightArrow(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, imageView) == null) {
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
        this.f59310e = true;
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
        this.f59310e = true;
        init();
    }
}
