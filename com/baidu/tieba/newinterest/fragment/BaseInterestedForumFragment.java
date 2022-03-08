package com.baidu.tieba.newinterest.fragment;

import android.view.View;
import c.a.r0.q2.c.b;
import c.a.r0.q2.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class BaseInterestedForumFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CUSTOM_TITLE = "key_custom_title";
    public static final String KEY_ONLY_SHOW_INTERESTED_FORUM = "key_only_show_interested_forum";
    public static final String SCENE = "scene";
    public transient /* synthetic */ FieldHolder $fh;
    public String[] mCustomTitle;
    public boolean mOnlyShowInterestedForum;
    public View mRootView;
    public int mScene;
    public List<b> mSelectedInterest;

    public BaseInterestedForumFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mScene : invokeV.intValue;
    }

    public void onDataRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hideLoadingView(this.mRootView);
        }
    }

    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            hideLoadingView(this.mRootView);
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 2) {
                a.c(2, this.mScene);
            }
        }
    }

    public void setSelectedInterest(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.mSelectedInterest = list;
        }
    }
}
