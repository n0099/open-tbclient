package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.Outline;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.if7;
import com.baidu.tieba.x95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumTabSelectedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabItemData a;
    public ImageView b;
    public TextView c;
    public TabLayout d;
    public int e;
    public d f;
    public TabLayout.OnTabSelectedListener g;
    public TbPageContext h;
    public View.OnClickListener i;

    /* loaded from: classes8.dex */
    public interface d {
        void a(FrsTabItemData frsTabItemData);
    }

    /* loaded from: classes8.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTabSelectedView a;

        public a(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTabSelectedView;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                ((FrsTabItemData) tab.getTag()).isSelected = false;
                this.a.setTabColorUnSelected(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (frsTabItemData.isSelected) {
                    frsTabItemData.isSelected = false;
                    this.a.a = null;
                    this.a.setTabColorUnSelected(tab);
                } else {
                    frsTabItemData.isSelected = true;
                    this.a.a = frsTabItemData;
                    this.a.setTabColorSelected(tab);
                }
                if (this.a.f != null) {
                    this.a.f.a(this.a.a);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                frsTabItemData.isSelected = true;
                this.a.a = frsTabItemData;
                this.a.setTabColorSelected(tab);
                if (this.a.f != null) {
                    this.a.f.a(this.a.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTabSelectedView a;

        public b(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTabSelectedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                BdUtilHelper.hideSoftKeyPad(this.a.getContext(), this.a);
                if7.a(this.a.h.getPageActivity(), this.a.h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTabSelectedView a;

        public c(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTabSelectedView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), view2.getWidth() * 0.5f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTabSelectedView(Context context) {
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
        this.e = R.color.CAM_X0202;
        this.g = new a(this);
        this.i = new b(this);
        m();
    }

    @RequiresApi(api = 21)
    public final View g(TabLayout.Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tab)) == null) {
            View findViewById = tab.getCustomView().findViewById(R.id.forum_section_red_dot);
            if (findViewById != null) {
                return findViewById;
            }
            View view2 = new View(getContext());
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds21);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.setMargins(0, 0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds10), 0);
            layoutParams.gravity = 5;
            view2.setLayoutParams(layoutParams);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0301);
            view2.setId(R.id.forum_section_red_dot);
            view2.setOutlineProvider(new c(this));
            view2.setClipToOutline(true);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public final void j(TabLayout tabLayout) {
        TBSpecificationBtn h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tabLayout) == null) {
            SkinManager.setBackgroundColor(tabLayout, this.e);
            if (tabLayout != null) {
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                    if (tabAt != null && (tabAt.getCustomView() instanceof FrameLayout) && (h = h(tabAt, null)) != null) {
                        h.k();
                        x95 x95Var = (x95) h.getStyleConfig();
                        if (tabAt.isSelected()) {
                            x95Var.u(R.color.CAM_X0302);
                        } else if (n(tabAt)) {
                            x95Var.w(R.color.CAM_X0302);
                        } else {
                            x95Var.w(R.color.CAM_X0107);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTabSelectedView(Context context, AttributeSet attributeSet) {
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
        this.e = R.color.CAM_X0202;
        this.g = new a(this);
        this.i = new b(this);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            x95 x95Var = (x95) h(tab, null).getStyleConfig();
            if (!n(tab)) {
                x95Var.w(R.color.CAM_X0107);
            }
        }
    }

    public final boolean n(TabLayout.Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tab)) == null) {
            if (tab == null || !(tab.getTag() instanceof FrsTabItemData) || ((FrsTabItemData) tab.getTag()).tabId != 505) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            j(this.d);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            this.b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080bbf, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public void setActivity(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.h = tbPageContext;
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && i != 0) {
            this.e = i;
        }
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, frsTabInfoData) == null) {
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                setVisibility(0);
                p(frsTabInfoData.tabList, this.d, frsTabInfoData.selectedTabId);
                return;
            }
            setVisibility(8);
        }
    }

    public void setTabSelectedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.f = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            ((x95) h(tab, null).getStyleConfig()).u(R.color.CAM_X0302);
            View g = g(tab);
            if (g != null) {
                g.setVisibility(8);
                SharedPrefHelper.getInstance().putBoolean("send_thread_forum_section_gaokao_red_dot", false);
            }
        }
    }

    public FrsTabItemData getSelectedTabItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsTabItemData frsTabItemData = this.a;
            if (frsTabItemData != null && frsTabItemData.isSelected) {
                return frsTabItemData;
            }
            return null;
        }
        return (FrsTabItemData) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setOrientation(0);
            setGravity(16);
            l();
            i();
            k();
        }
    }

    public final TBSpecificationBtn h(TabLayout.Tab tab, FrsTabItemData frsTabItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tab, frsTabItemData)) == null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView().findViewById(R.id.forum_section_btn);
            if (tBSpecificationBtn != null) {
                return tBSpecificationBtn;
            }
            if (frsTabItemData == null) {
                return null;
            }
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            BdUtilHelper.getDimens(getContext(), R.dimen.tbds25);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003);
            TBSpecificationBtn tBSpecificationBtn2 = new TBSpecificationBtn(getContext());
            x95 x95Var = new x95();
            x95Var.n(dimens2);
            x95Var.p(dimens3);
            if (frsTabItemData.tabId == 505) {
                x95Var.w(R.color.CAM_X0302);
            } else {
                x95Var.w(R.color.CAM_X0107);
            }
            tBSpecificationBtn2.setConfig(x95Var);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(dimens, 0, dimens, 0);
            tBSpecificationBtn2.setLayoutParams(layoutParams);
            tBSpecificationBtn2.setId(R.id.forum_section_btn);
            return tBSpecificationBtn2;
        }
        return (TBSpecificationBtn) invokeLL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = new ImageView(getContext());
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds31);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.setMargins(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(this.i);
            addView(this.b);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0318, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
            this.d.setOnTabSelectedListener(this.g);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = new EMTextView(getContext());
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            EMManager.from(this.c).setTextSize(R.dimen.T_X08);
            this.c.setText(R.string.obfuscated_res_0x7f0f07e0);
            this.c.setOnClickListener(this.i);
            addView(this.c);
        }
    }

    public final void p(List<FrsTabItemData> list, TabLayout tabLayout, int i) {
        TBSpecificationBtn h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, list, tabLayout, i) == null) {
            tabLayout.removeAllTabs();
            tabLayout.setTabRippleColorResource(R.color.transparent);
            int min = Math.min(list.size(), 10);
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i2 = 0; i2 < tabCount; i2++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i3);
                if (frsTabItemData != null) {
                    String str = frsTabItemData.name;
                    int i4 = frsTabItemData.tabId;
                    if (!TextUtils.isEmpty(str) && i4 >= 0) {
                        if (!(tabAt.getCustomView() instanceof FrameLayout)) {
                            FrameLayout frameLayout = new FrameLayout(getContext());
                            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                            tabAt.setCustomView(frameLayout);
                            h = h(tabAt, frsTabItemData);
                            frameLayout.addView(h);
                            boolean z = true;
                            if ((SharedPrefHelper.getInstance().getBoolean("send_thread_forum_section_gaokao_red_dot", true) && frsTabItemData.tabType == 102) ? false : false) {
                                frameLayout.addView(g(tabAt));
                            }
                        } else {
                            h = h(tabAt, frsTabItemData);
                        }
                        if (h != null) {
                            h.setText(str);
                        }
                        if (tabAt != null) {
                            tabAt.setTag(frsTabItemData);
                        }
                        if (i4 == i) {
                            tabAt.select();
                        }
                    }
                }
            }
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004);
            linearLayout.setPadding(dimens, 0, dimens, 0);
        }
    }
}
