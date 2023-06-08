package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.immessagecenter.mention.ChatAggregationFragment;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.mention.MessageCenterFragment;
import com.baidu.tieba.immessagecenter.mention.MessageFragmentPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yi8 extends i9 implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageCenterFragment a;
    public TbTabLayout b;
    public BdBaseViewPager c;
    public MessageFragmentPagerAdapter d;
    public List<MessageFragmentPagerAdapter.a> e;
    public View f;
    public ChatAggregationFragment g;
    public TextView h;
    public NavigationBar i;
    public NoNetworkView j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi8 a;

        public a(yi8 yi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                this.a.a.M1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi8 a;

        public b(yi8 yi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                TiebaStatic.log("c14668");
                this.a.a.N1();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yi8(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageCenterFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = messageCenterFragment;
    }

    public void I(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.d;
            if (messageFragmentPagerAdapter != null) {
                messageFragmentPagerAdapter.b(z);
            }
            List<MessageFragmentPagerAdapter.a> list = this.e;
            if (list != null && list.size() > 0 && (bdBaseViewPager = this.c) != null) {
                MessageFragmentPagerAdapter.a aVar = this.e.get(bdBaseViewPager.getCurrentItem());
                if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).setPrimary(z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void i(boolean z) {
        List<MessageFragmentPagerAdapter.a> list;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (list = this.e) != null && list.size() > 0) {
            for (int i = 0; i < this.e.size(); i++) {
                MessageFragmentPagerAdapter.a aVar = this.e.get(i);
                if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                    ((NoNetworkView.b) fragment).i(z);
                }
            }
        }
    }

    public TbTabLayout.f y(int i) {
        InterceptResult invokeI;
        int tabCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
                for (int i2 = 0; i2 < tabCount; i2++) {
                    TbTabLayout.f w = this.b.w(i2);
                    if (w != null && w.d() != -1 && w.d() == i) {
                        return w;
                    }
                }
            }
            return null;
        }
        return (TbTabLayout.f) invokeI.objValue;
    }

    public static String D(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public void B(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null) {
            return;
        }
        this.f = view2;
        C();
        A();
        z();
        NoNetworkView noNetworkView = (NoNetworkView) this.f.findViewById(R.id.view_no_network);
        this.j = noNetworkView;
        noNetworkView.a(this);
    }

    public void H(int i) {
        TbTabLayout.f y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (y = y(i)) != null) {
            y.l();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d060b, (ViewGroup) null);
            this.b = tbTabLayout;
            tbTabLayout.setupWithViewPager(this.c);
            int tabCount = this.b.getTabCount();
            if (tabCount > 0) {
                for (int i = 0; i < tabCount; i++) {
                    this.b.w(i).q(1);
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = (BdBaseViewPager) this.f.findViewById(R.id.obfuscated_res_0x7f09171f);
            MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
            ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
            this.g = chatAggregationFragment;
            aVar.a = chatAggregationFragment;
            aVar.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c61);
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            arrayList.add(aVar);
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.a.getActivity().getSupportFragmentManager(), this.e);
            this.d = messageFragmentPagerAdapter;
            this.c.setAdapter(messageFragmentPagerAdapter);
            this.c.setOffscreenPageLimit(this.e.size());
            this.d.notifyDataSetChanged();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageCenterFragment messageCenterFragment = this.a;
            if (messageCenterFragment != null && messageCenterFragment.getActivity() != null && this.e != null && this.c != null && this.d != null) {
                FragmentManager supportFragmentManager = this.a.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.e.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(D(this.c.getId(), this.d.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.e(this);
            }
        }
    }

    public void E(int i, int i2, Intent intent) {
        List<MessageFragmentPagerAdapter.a> list;
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) && (list = this.e) != null && list.size() > 0 && (bdBaseViewPager = this.c) != null) {
            MessageFragmentPagerAdapter.a aVar = this.e.get(bdBaseViewPager.getCurrentItem());
            if (aVar != null && (fragment = aVar.a) != null) {
                fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void G() {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (chatAggregationFragment = this.g) != null) {
            chatAggregationFragment.B();
        }
    }

    public TbTabLayout.f x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null && tbTabLayout.getTabCount() > 0) {
                TbTabLayout tbTabLayout2 = this.b;
                return tbTabLayout2.w(tbTabLayout2.getSelectedTabPosition());
            }
            return null;
        }
        return (TbTabLayout.f) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            NavigationBar navigationBar = this.i;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
                SkinManager.setBackgroundColor(this.i.getBarBgView(), R.color.CAM_X0207, i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.d(getPageContext(), i);
            }
            List<MessageFragmentPagerAdapter.a> list = this.e;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    MessageFragmentPagerAdapter.a aVar = this.e.get(i2);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i);
                    }
                }
            }
            this.h.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080bf4, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null, (Drawable) null);
            o75 d = o75.d(this.h);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X06);
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
                this.b.setSelectedTabIndicatorHeight(0);
                this.b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
            ChatAggregationFragment chatAggregationFragment = this.g;
            if (chatAggregationFragment != null) {
                chatAggregationFragment.M1();
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.navigation_bar);
            this.i = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (addSystemImageButton != null) {
                if (this.a.getActivity() instanceof MessageCenterActivity) {
                    addSystemImageButton.setVisibility(0);
                } else {
                    addSystemImageButton.setVisibility(4);
                }
            }
            TextView textView = new TextView(this.a.getContext());
            this.h = textView;
            textView.setText(this.a.getContext().getString(R.string.im_send_private_msg));
            this.h.setGravity(16);
            this.h.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            this.h.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080bf4, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null, (Drawable) null);
            o75 d = o75.d(this.h);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X06);
            this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.h, new b(this));
            if (this.h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, vi.g(this.a.getContext(), R.dimen.M_W_X007), 0);
                this.h.setLayoutParams(marginLayoutParams);
            }
            if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(4);
            }
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null) {
                this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, tbTabLayout, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 17;
                    viewGroup.setLayoutParams(layoutParams);
                }
                TbTabLayout tbTabLayout2 = this.b;
                tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), this.b.getPaddingBottom() + vi.g(this.a.getContext(), R.dimen.obfuscated_res_0x7f070198));
            }
            NavigationBar navigationBar2 = this.i;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                o75.d(this.i.getBarBgView()).f(R.color.CAM_X0207);
            }
        }
    }
}
