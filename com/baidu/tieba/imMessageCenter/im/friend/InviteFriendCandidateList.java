package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy4;
/* loaded from: classes3.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public LinearLayout c;
    public int d;
    public int e;
    public int f;
    public int g;
    public HeadImageView h;
    public b i;
    public View.OnClickListener j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InviteFriendCandidateList a;

        public a(InviteFriendCandidateList inviteFriendCandidateList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inviteFriendCandidateList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inviteFriendCandidateList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c.removeView(view2);
                if (!this.a.i()) {
                    this.a.k();
                }
                if (this.a.i != null) {
                    this.a.i.a(view2, view2.getTag());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, Object obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = 4;
        this.j = new a(this);
        this.b = context;
        j();
    }

    public void e(iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iy4Var) == null) || getItemLength() >= this.g) {
            return;
        }
        HeadImageView f = f();
        f.setIsRound(false);
        f.K(iy4Var.h(), 12, false);
        if (i()) {
            f.setTag(iy4Var);
            f.setOnClickListener(this.j);
            this.c.addView(f, getItemLength());
            scrollTo(getItemLength() * (this.d + this.f), 0);
        }
        if (getItemLength() >= this.g) {
            m();
        }
    }

    public final HeadImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HeadImageView headImageView = new HeadImageView(this.b);
            headImageView.setIsRound(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.d, this.e);
            layoutParams.setMargins(this.f, 0, 0, 0);
            headImageView.setLayoutParams(layoutParams);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return headImageView;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int childCount = this.c.getChildCount();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getChildAt(i);
                if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof iy4)) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(((iy4) tag).e());
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int getItemLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (i()) {
                return this.c.getChildCount() - 1;
            }
            return this.c.getChildCount();
        }
        return invokeV.intValue;
    }

    public boolean h(iy4 iy4Var) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iy4Var)) == null) {
            int childCount = this.c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getChildAt(i);
                if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof iy4) && ((iy4) tag).equals(iy4Var)) {
                    iy4Var.setChecked(true);
                    childAt.setTag(iy4Var);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int childCount = this.c.getChildCount();
            return childCount > 0 && this.c.getChildAt(childCount - 1) == this.h;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.e = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.f = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e);
            this.c = new LinearLayout(this.b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.c.setHorizontalScrollBarEnabled(true);
            this.c.setOrientation(0);
            k();
            addView(this.c);
            setSmoothScrollingEnabled(true);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.h == null) {
                HeadImageView f = f();
                this.h = f;
                f.setDrawBorder(false);
            }
            this.h.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
            this.c.addView(this.h);
        }
    }

    public void l(iy4 iy4Var) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iy4Var) == null) || (findViewWithTag = this.c.findViewWithTag(iy4Var)) == null) {
            return;
        }
        this.c.removeView(findViewWithTag);
        if (i()) {
            return;
        }
        k();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && i()) {
            this.c.removeView(this.h);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void setMaxCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.g = i;
        }
    }
}
