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
/* loaded from: classes5.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f33984b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f33985c;

    /* renamed from: d  reason: collision with root package name */
    public int f33986d;

    /* renamed from: e  reason: collision with root package name */
    public int f33987e;

    /* renamed from: f  reason: collision with root package name */
    public int f33988f;

    /* renamed from: g  reason: collision with root package name */
    public int f33989g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f33990h;
    public b i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f33985c.removeView(view);
                if (!this.a.i()) {
                    this.a.k();
                }
                if (this.a.i != null) {
                    this.a.i.a(view, view.getTag());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, Object obj);
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
        this.f33986d = -1;
        this.f33987e = -1;
        this.f33988f = -1;
        this.f33989g = 4;
        this.j = new a(this);
        this.f33984b = context;
        j();
    }

    public void e(c.a.o0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || getItemLength() >= this.f33989g) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.J(aVar.h(), 12, false);
        if (i()) {
            f2.setTag(aVar);
            f2.setOnClickListener(this.j);
            this.f33985c.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f33986d + this.f33988f), 0);
        }
        if (getItemLength() >= this.f33989g) {
            m();
        }
    }

    public final HeadImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HeadImageView headImageView = new HeadImageView(this.f33984b);
            headImageView.setIsRound(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f33986d, this.f33987e);
            layoutParams.setMargins(this.f33988f, 0, 0, 0);
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
            int childCount = this.f33985c.getChildCount();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f33985c.getChildAt(i);
                if (childAt != this.f33990h && (tag = childAt.getTag()) != null && (tag instanceof c.a.o0.s.f.a)) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(((c.a.o0.s.f.a) tag).e());
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
                return this.f33985c.getChildCount() - 1;
            }
            return this.f33985c.getChildCount();
        }
        return invokeV.intValue;
    }

    public boolean h(c.a.o0.s.f.a aVar) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            int childCount = this.f33985c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f33985c.getChildAt(i);
                if (childAt != this.f33990h && (tag = childAt.getTag()) != null && (tag instanceof c.a.o0.s.f.a) && ((c.a.o0.s.f.a) tag).equals(aVar)) {
                    aVar.setChecked(true);
                    childAt.setTag(aVar);
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
            int childCount = this.f33985c.getChildCount();
            return childCount > 0 && this.f33985c.getChildAt(childCount - 1) == this.f33990h;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33986d = this.f33984b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.f33987e = this.f33984b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.f33988f = this.f33984b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
            this.f33985c = new LinearLayout(this.f33984b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f33985c.setLayoutParams(layoutParams);
            this.f33985c.setHorizontalScrollBarEnabled(true);
            this.f33985c.setOrientation(0);
            k();
            addView(this.f33985c);
            setSmoothScrollingEnabled(true);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f33990h == null) {
                HeadImageView f2 = f();
                this.f33990h = f2;
                f2.setDrawBorder(false);
            }
            this.f33990h.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
            this.f33985c.addView(this.f33990h);
        }
    }

    public void l(c.a.o0.s.f.a aVar) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (findViewWithTag = this.f33985c.findViewWithTag(aVar)) == null) {
            return;
        }
        this.f33985c.removeView(findViewWithTag);
        if (i()) {
            return;
        }
        k();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && i()) {
            this.f33985c.removeView(this.f33990h);
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
            this.f33989g = i;
        }
    }
}
