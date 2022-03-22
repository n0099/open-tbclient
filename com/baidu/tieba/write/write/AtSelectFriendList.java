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
/* loaded from: classes6.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f37413b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f37414c;

    /* renamed from: d  reason: collision with root package name */
    public int f37415d;

    /* renamed from: e  reason: collision with root package name */
    public int f37416e;

    /* renamed from: f  reason: collision with root package name */
    public int f37417f;

    /* renamed from: g  reason: collision with root package name */
    public int f37418g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f37419h;
    public b i;
    public final View.OnClickListener j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtSelectFriendList a;

        public a(AtSelectFriendList atSelectFriendList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atSelectFriendList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atSelectFriendList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f37414c.removeView(view);
                if (!this.a.h()) {
                    this.a.j();
                }
                if (this.a.i != null) {
                    this.a.i.a(view, view.getTag());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37415d = -1;
        this.f37416e = -1;
        this.f37417f = -1;
        this.f37418g = 4;
        this.j = new a(this);
        this.f37413b = context;
        i();
    }

    public void e(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || getItemLength() >= this.f37418g) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.J(metaData.getAvater(), 12, false);
        if (h()) {
            f2.setTag(metaData);
            f2.setOnClickListener(this.j);
            this.f37414c.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f37415d + this.f37417f), 0);
            this.f37414c.requestLayout();
        }
        if (getItemLength() >= this.f37418g) {
            l();
        }
    }

    public final HeadImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HeadImageView headImageView = new HeadImageView(this.f37413b);
            headImageView.setIsRound(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f37415d, this.f37416e);
            layoutParams.setMargins(this.f37417f, 0, 0, 0);
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
            int childCount = this.f37414c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f37414c.getChildAt(i);
                if (childAt != this.f37419h && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            int childCount = this.f37414c.getChildCount();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f37414c.getChildAt(i);
                if (childAt != this.f37419h && (tag = childAt.getTag()) != null && (tag instanceof MetaData)) {
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
                return this.f37414c.getChildCount() - 1;
            }
            return this.f37414c.getChildCount();
        }
        return invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int childCount = this.f37414c.getChildCount();
            return childCount > 0 && this.f37414c.getChildAt(childCount - 1) == this.f37419h;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f37415d = this.f37413b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.f37416e = this.f37413b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.f37417f = this.f37413b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
            this.f37414c = new LinearLayout(this.f37413b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f37414c.setLayoutParams(layoutParams);
            this.f37414c.setHorizontalScrollBarEnabled(true);
            this.f37414c.setOrientation(0);
            j();
            addView(this.f37414c);
            setSmoothScrollingEnabled(true);
            setFocusable(false);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f37419h == null) {
                HeadImageView f2 = f();
                this.f37419h = f2;
                f2.setDrawBorder(false);
            }
            this.f37419h.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
            this.f37414c.addView(this.f37419h);
        }
    }

    public void k(MetaData metaData) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData) == null) || (findViewWithTag = this.f37414c.findViewWithTag(metaData)) == null) {
            return;
        }
        this.f37414c.removeView(findViewWithTag);
        if (h()) {
            return;
        }
        j();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && h()) {
            this.f37414c.removeView(this.f37419h);
        }
    }

    public void setItemOPerationHandler(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void setMaxCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f37418g = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37415d = -1;
        this.f37416e = -1;
        this.f37417f = -1;
        this.f37418g = 4;
        this.j = new a(this);
        this.f37413b = context;
        i();
    }
}
