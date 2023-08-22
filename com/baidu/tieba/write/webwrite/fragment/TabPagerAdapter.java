package com.baidu.tieba.write.webwrite.fragment;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/write/webwrite/fragment/TabPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragments", "", "Lcom/baidu/tieba/write/webwrite/fragment/TabPagerAdapter$FragmentItem;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "mCurrentFragment", "Lcom/baidu/tieba/write/webwrite/fragment/BaseWebWriteFragment;", "getMCurrentFragment", "()Lcom/baidu/tieba/write/webwrite/fragment/BaseWebWriteFragment;", "setMCurrentFragment", "(Lcom/baidu/tieba/write/webwrite/fragment/BaseWebWriteFragment;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", CriusAttrConstants.POSITION, "getItemId", "", "getItemPosition", "obj", "", "getPageTitle", "", "setPrimaryItem", "", "container", "Landroid/view/ViewGroup;", "FragmentItem", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TabPagerAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentManager a;
    public final List<a> b;
    public BaseWebWriteFragment c;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BaseWebWriteFragment a;
        public String b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final BaseWebWriteFragment a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                BaseWebWriteFragment baseWebWriteFragment = this.a;
                if (baseWebWriteFragment != null) {
                    return baseWebWriteFragment;
                }
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
                return null;
            }
            return (BaseWebWriteFragment) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.b;
                if (str != null) {
                    return str;
                }
                Intrinsics.throwUninitializedPropertyAccessException("title");
                return null;
            }
            return (String) invokeV.objValue;
        }

        public final void c(BaseWebWriteFragment baseWebWriteFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseWebWriteFragment) == null) {
                Intrinsics.checkNotNullParameter(baseWebWriteFragment, "<set-?>");
                this.a = baseWebWriteFragment;
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.b = str;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabPagerAdapter(FragmentManager mFragmentManager, List<a> mFragments) {
        super(mFragmentManager, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mFragmentManager, mFragments};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FragmentManager) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mFragmentManager, "mFragmentManager");
        Intrinsics.checkNotNullParameter(mFragments, "mFragments");
        this.a = mFragmentManager;
        this.b = mFragments;
    }

    public final BaseWebWriteFragment b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (BaseWebWriteFragment) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.b.get(i).a();
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i >= 0 && i < this.b.size()) {
                return this.b.get(i).hashCode();
            }
            return super.getItemId(i);
        }
        return invokeI.longValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            List<Fragment> fragments = this.a.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "mFragmentManager.fragments");
            if (CollectionsKt___CollectionsKt.contains(fragments, obj)) {
                return -1;
            }
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0 && i < this.b.size()) {
                return this.b.get(i).b();
            }
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup container, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, container, i, obj) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(obj, "obj");
            super.setPrimaryItem(container, i, obj);
            if (obj instanceof BaseWebWriteFragment) {
                this.c = (BaseWebWriteFragment) obj;
            }
        }
    }
}
