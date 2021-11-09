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
/* loaded from: classes9.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f50710f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f50711g;

    /* renamed from: h  reason: collision with root package name */
    public int f50712h;

    /* renamed from: i  reason: collision with root package name */
    public int f50713i;
    public int j;
    public int k;
    public HeadImageView l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InviteFriendCandidateList f50714e;

        public a(InviteFriendCandidateList inviteFriendCandidateList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inviteFriendCandidateList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50714e = inviteFriendCandidateList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50714e.f50711g.removeView(view);
                if (!this.f50714e.i()) {
                    this.f50714e.k();
                }
                if (this.f50714e.m != null) {
                    this.f50714e.m.a(view, view.getTag());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50712h = -1;
        this.f50713i = -1;
        this.j = -1;
        this.k = 4;
        this.n = new a(this);
        this.f50710f = context;
        j();
    }

    public void e(b.a.q0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || getItemLength() >= this.k) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.startLoad(aVar.h(), 12, false);
        if (i()) {
            f2.setTag(aVar);
            f2.setOnClickListener(this.n);
            this.f50711g.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f50712h + this.j), 0);
        }
        if (getItemLength() >= this.k) {
            m();
        }
    }

    public final HeadImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HeadImageView headImageView = new HeadImageView(this.f50710f);
            headImageView.setIsRound(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f50712h, this.f50713i);
            layoutParams.setMargins(this.j, 0, 0, 0);
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
            int childCount = this.f50711g.getChildCount();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f50711g.getChildAt(i2);
                if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof b.a.q0.t.f.a)) {
                    if (i2 > 0) {
                        sb.append(",");
                    }
                    sb.append(((b.a.q0.t.f.a) tag).e());
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
                return this.f50711g.getChildCount() - 1;
            }
            return this.f50711g.getChildCount();
        }
        return invokeV.intValue;
    }

    public boolean h(b.a.q0.t.f.a aVar) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            int childCount = this.f50711g.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f50711g.getChildAt(i2);
                if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof b.a.q0.t.f.a) && ((b.a.q0.t.f.a) tag).equals(aVar)) {
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
            int childCount = this.f50711g.getChildCount();
            return childCount > 0 && this.f50711g.getChildAt(childCount - 1) == this.l;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f50712h = this.f50710f.getResources().getDimensionPixelSize(R.dimen.ds80);
            this.f50713i = this.f50710f.getResources().getDimensionPixelSize(R.dimen.ds80);
            this.j = this.f50710f.getResources().getDimensionPixelSize(R.dimen.ds12);
            this.f50711g = new LinearLayout(this.f50710f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f50711g.setLayoutParams(layoutParams);
            this.f50711g.setHorizontalScrollBarEnabled(true);
            this.f50711g.setOrientation(0);
            k();
            addView(this.f50711g);
            setSmoothScrollingEnabled(true);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.l == null) {
                HeadImageView f2 = f();
                this.l = f2;
                f2.setDrawBorder(false);
            }
            this.l.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
            this.f50711g.addView(this.l);
        }
    }

    public void l(b.a.q0.t.f.a aVar) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (findViewWithTag = this.f50711g.findViewWithTag(aVar)) == null) {
            return;
        }
        this.f50711g.removeView(findViewWithTag);
        if (i()) {
            return;
        }
        k();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && i()) {
            this.f50711g.removeView(this.l);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.k = i2;
        }
    }
}
