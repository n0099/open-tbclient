package com.baidu.tieba.write.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes8.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context b;
    public LinearLayout c;
    public int d;
    public int e;
    public int f;
    public int g;
    public HeadImageView h;
    public b i;
    public final View.OnClickListener j;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view2, Object obj);
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c.removeView(view2);
                if (!this.a.h()) {
                    this.a.j();
                }
                if (this.a.i != null) {
                    this.a.i.a(view2, view2.getTag());
                }
            }
        }
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
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = 4;
        this.j = new a(this);
        this.b = context;
        i();
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
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = 4;
        this.j = new a(this);
        this.b = context;
        i();
    }

    public final boolean l(MetaData metaData, MetaData metaData2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, metaData, metaData2)) == null) {
            if (metaData == null || metaData2 == null) {
                return false;
            }
            String userName = metaData2.getUserName();
            String name_show = metaData2.getName_show();
            if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(name_show)) {
                return false;
            }
            String portrait = metaData2.getPortrait();
            if (TextUtils.isEmpty(portrait)) {
                return false;
            }
            if (!userName.equals(metaData.getUserName()) && !name_show.equals(metaData.getName_show())) {
                z = false;
            } else {
                z = true;
            }
            boolean contains = portrait.contains(metaData.getPortrait());
            if (!z || !contains) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean k(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData)) == null) {
            if (AtSelectData.AT_ALL_FAKE_UID.equals(metaData.getUserId()) && AtSelectData.AT_ALL_FAKE_NAME.equals(metaData.getName_show())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(MetaData metaData) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, metaData) == null) && (findViewWithTag = this.c.findViewWithTag(metaData)) != null) {
            this.c.removeView(findViewWithTag);
            if (!h()) {
                j();
            }
        }
    }

    public void setItemOPerationHandler(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void setMaxCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.g = i;
        }
    }

    public void e(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, metaData) != null) || getItemLength() >= this.g) {
            return;
        }
        HeadImageView f = f();
        f.setIsRound(false);
        String avater = metaData.getAvater();
        if (k(metaData)) {
            f.setDefaultResource(R.drawable.icon_at_all_user);
            avater = "";
        }
        f.startLoad(avater, 12, false);
        if (h()) {
            f.setTag(metaData);
            f.setOnClickListener(this.j);
            this.c.addView(f, getItemLength());
            scrollTo(getItemLength() * (this.d + this.f), 0);
            this.c.requestLayout();
        }
        if (getItemLength() >= this.g) {
            n();
        }
    }

    public final HeadImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HeadImageView headImageView = new HeadImageView(this.b);
            headImageView.setIsRound(true);
            headImageView.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds125));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.d, this.e);
            layoutParams.setMargins(this.f, 0, 0, 0);
            headImageView.setLayoutParams(layoutParams);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return headImageView;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public void g(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            int childCount = this.c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getChildAt(i);
                if (childAt != this.h) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof MetaData) && metaData != null && l((MetaData) tag, metaData)) {
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
            int childCount = this.c.getChildCount();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getChildAt(i);
                if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof MetaData)) {
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
                return this.c.getChildCount() - 1;
            }
            return this.c.getChildCount();
        }
        return invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int childCount = this.c.getChildCount();
            if (childCount > 0 && this.c.getChildAt(childCount - 1) == this.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
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

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && h()) {
            this.c.removeView(this.h);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = this.b.getResources().getDimensionPixelSize(R.dimen.tbds125);
            this.e = this.b.getResources().getDimensionPixelSize(R.dimen.tbds125);
            this.f = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070363);
            this.c = new LinearLayout(this.b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.c.setHorizontalScrollBarEnabled(true);
            this.c.setOrientation(0);
            j();
            addView(this.c);
            setSmoothScrollingEnabled(true);
            setFocusable(false);
        }
    }
}
