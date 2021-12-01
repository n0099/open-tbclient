package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final Context f50957f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f50958g;

    /* renamed from: h  reason: collision with root package name */
    public int f50959h;

    /* renamed from: i  reason: collision with root package name */
    public int f50960i;

    /* renamed from: j  reason: collision with root package name */
    public int f50961j;

    /* renamed from: k  reason: collision with root package name */
    public int f50962k;
    public HeadImageView l;
    public b m;
    public final View.OnClickListener n;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtSelectFriendList f50963e;

        public a(AtSelectFriendList atSelectFriendList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atSelectFriendList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50963e = atSelectFriendList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50963e.f50958g.removeView(view);
                if (!this.f50963e.h()) {
                    this.f50963e.j();
                }
                if (this.f50963e.m != null) {
                    this.f50963e.m.a(view, view.getTag());
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(View view, Object obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtSelectFriendList(Context context) {
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
        this.f50959h = -1;
        this.f50960i = -1;
        this.f50961j = -1;
        this.f50962k = 4;
        this.n = new a(this);
        this.f50957f = context;
        i();
    }

    public void e(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || getItemLength() >= this.f50962k) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.startLoad(metaData.getAvater(), 12, false);
        if (h()) {
            f2.setTag(metaData);
            f2.setOnClickListener(this.n);
            this.f50958g.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f50959h + this.f50961j), 0);
            this.f50958g.requestLayout();
        }
        if (getItemLength() >= this.f50962k) {
            l();
        }
    }

    public final HeadImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HeadImageView headImageView = new HeadImageView(this.f50957f);
            headImageView.setIsRound(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f50959h, this.f50960i);
            layoutParams.setMargins(this.f50961j, 0, 0, 0);
            headImageView.setLayoutParams(layoutParams);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return headImageView;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public void g(MetaData metaData) {
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            int childCount = this.f50958g.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f50958g.getChildAt(i2);
                if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                    MetaData metaData2 = (MetaData) tag;
                    if ((metaData2.getUserName().equals(metaData.getUserName()) || metaData2.getName_show().equals(metaData.getName_show())) && metaData2.getPortrait().equals(metaData.getPortrait())) {
                        metaData.setChecked(true);
                        childAt.setTag(metaData);
                        return;
                    }
                }
            }
        }
    }

    public ArrayList<AtSelectData> getDataList() {
        InterceptResult invokeV;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int childCount = this.f50958g.getChildCount();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f50958g.getChildAt(i2);
                if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof MetaData)) {
                    MetaData metaData = (MetaData) tag;
                    arrayList.add(new AtSelectData(metaData.getPortrait(), metaData.getName_show(), metaData.getUserId()));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getItemLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (h()) {
                return this.f50958g.getChildCount() - 1;
            }
            return this.f50958g.getChildCount();
        }
        return invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int childCount = this.f50958g.getChildCount();
            return childCount > 0 && this.f50958g.getChildAt(childCount - 1) == this.l;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f50959h = this.f50957f.getResources().getDimensionPixelSize(R.dimen.ds80);
            this.f50960i = this.f50957f.getResources().getDimensionPixelSize(R.dimen.ds80);
            this.f50961j = this.f50957f.getResources().getDimensionPixelSize(R.dimen.ds12);
            this.f50958g = new LinearLayout(this.f50957f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f50958g.setLayoutParams(layoutParams);
            this.f50958g.setHorizontalScrollBarEnabled(true);
            this.f50958g.setOrientation(0);
            j();
            addView(this.f50958g);
            setSmoothScrollingEnabled(true);
            setFocusable(false);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.l == null) {
                HeadImageView f2 = f();
                this.l = f2;
                f2.setDrawBorder(false);
            }
            this.l.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
            this.f50958g.addView(this.l);
        }
    }

    public void k(MetaData metaData) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData) == null) || (findViewWithTag = this.f50958g.findViewWithTag(metaData)) == null) {
            return;
        }
        this.f50958g.removeView(findViewWithTag);
        if (h()) {
            return;
        }
        j();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && h()) {
            this.f50958g.removeView(this.l);
        }
    }

    public void setItemOPerationHandler(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f50962k = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
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
        this.f50959h = -1;
        this.f50960i = -1;
        this.f50961j = -1;
        this.f50962k = 4;
        this.n = new a(this);
        this.f50957f = context;
        i();
    }
}
