package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PAGE_COUNT = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f53361a;

    /* renamed from: b  reason: collision with root package name */
    public PersonThreadFragment f53362b;

    /* renamed from: c  reason: collision with root package name */
    public PersonReplyFragment f53363c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personPostActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString(PersonPostActivity.KEY_EMPTYVIEW_TXT, personPostActivity.getEmptyViewText());
        PersonReplyFragment personReplyFragment = new PersonReplyFragment();
        this.f53363c = personReplyFragment;
        personReplyFragment.setArguments(bundle);
        this.f53363c.setNoNetRefreshListener(personPostActivity);
        PersonThreadFragment personThreadFragment = new PersonThreadFragment();
        this.f53362b = personThreadFragment;
        personThreadFragment.setArguments(bundle);
        this.f53362b.setNoNetRefreshListener(personPostActivity);
        this.f53362b.setNavigationBarRedTipListener(personPostActivity);
        this.f53361a = new int[]{0, 1};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return null;
                }
                return this.f53363c;
            }
            return this.f53362b;
        }
        return (Fragment) invokeI.objValue;
    }

    public int getItemPageType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f53361a[i2] : invokeI.intValue;
    }

    public PersonThreadFragment getPersonThreadFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53362b : (PersonThreadFragment) invokeV.objValue;
    }
}
