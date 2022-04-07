package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import com.repackage.kd6;
import com.repackage.mu4;
import com.repackage.oi;
import com.repackage.wr4;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumTabSelectedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabItemData a;
    public ImageView b;
    public TextView c;
    public TabLayout d;
    public int e;
    public TabLayout.OnTabSelectedListener f;
    public BaseActivity g;
    public View.OnClickListener h;

    /* loaded from: classes4.dex */
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
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (frsTabItemData.isSelected) {
                    frsTabItemData.isSelected = false;
                    this.a.a = null;
                    this.a.setTabColorUnSelected(tab);
                    return;
                }
                frsTabItemData.isSelected = true;
                this.a.a = frsTabItemData;
                this.a.setTabColorSelected(tab);
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
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                ((FrsTabItemData) tab.getTag()).isSelected = false;
                this.a.setTabColorUnSelected(tab);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            oi.w(this.a.getContext(), this.a);
            kd6.b(this.a.g, this.a.g.getPageContext());
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
        this.f = new a(this);
        this.h = new b(this);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        ((mu4) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).r(R.color.CAM_X0302);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        mu4 mu4Var = (mu4) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
        if (j(tab)) {
            return;
        }
        mu4Var.t(R.color.CAM_X0107);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ImageView(getContext());
            int f = oi.f(getContext(), R.dimen.tbds31);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.setMargins(oi.f(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(this.h);
            addView(this.b);
        }
    }

    public final void f(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tabLayout) == null) {
            SkinManager.setBackgroundColor(tabLayout, this.e);
            if (tabLayout != null) {
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tabAt.getCustomView();
                        tBSpecificationBtn.k();
                        mu4 mu4Var = (mu4) tBSpecificationBtn.getStyleConfig();
                        if (tabAt.isSelected()) {
                            mu4Var.r(R.color.CAM_X0302);
                        } else if (j(tabAt)) {
                            mu4Var.t(R.color.CAM_X0302);
                        } else {
                            mu4Var.t(R.color.CAM_X0107);
                        }
                    }
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02d5, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(oi.f(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
            this.d.setOnTabSelectedListener(this.f);
        }
    }

    public FrsTabItemData getSelectedTabItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsTabItemData frsTabItemData = this.a;
            if (frsTabItemData == null || !frsTabItemData.isSelected) {
                return null;
            }
            return frsTabItemData;
        }
        return (FrsTabItemData) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = new EMTextView(getContext());
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            wr4.d(this.c).z(R.dimen.T_X08);
            this.c.setText(R.string.obfuscated_res_0x7f0f06aa);
            this.c.setOnClickListener(this.h);
            addView(this.c);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setOrientation(0);
            setGravity(16);
            h();
            e();
            g();
        }
    }

    public final boolean j(TabLayout.Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tab)) == null) ? tab != null && (tab.getTag() instanceof FrsTabItemData) && ((FrsTabItemData) tab.getTag()).tabId == 505 : invokeL.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            f(this.d);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            this.b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080975, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.google.android.material.tabs.TabLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final void l(List<FrsTabItemData> list, TabLayout tabLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, tabLayout, i) == null) {
            tabLayout.removeAllTabs();
            tabLayout.setTabRippleColorResource(R.color.transparent);
            int min = Math.min(list.size(), 10);
            ?? r3 = 0;
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
            int f = oi.f(getContext(), R.dimen.M_W_X002);
            oi.f(getContext(), R.dimen.tbds25);
            int f2 = oi.f(getContext(), R.dimen.M_W_X006);
            int f3 = oi.f(getContext(), R.dimen.M_H_X003);
            int i3 = 0;
            while (i3 < min) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, (boolean) r3);
                    View childAt = linearLayout.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setPadding(r3, r3, r3, r3);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i3);
                if (frsTabItemData != null) {
                    String str = frsTabItemData.name;
                    int i4 = frsTabItemData.tabId;
                    if (!TextUtils.isEmpty(str) && i4 >= 0) {
                        TBSpecificationBtn tBSpecificationBtn = null;
                        if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                            tBSpecificationBtn = new TBSpecificationBtn(getContext());
                            mu4 mu4Var = new mu4();
                            mu4Var.l(f2);
                            mu4Var.n(f3);
                            if (frsTabItemData.tabId == 505) {
                                mu4Var.t(R.color.CAM_X0302);
                            } else {
                                mu4Var.t(R.color.CAM_X0107);
                            }
                            tBSpecificationBtn.setConfig(mu4Var);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(f, 0, f, 0);
                            tBSpecificationBtn.setLayoutParams(layoutParams);
                            tabAt.setCustomView(tBSpecificationBtn);
                        }
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(str);
                        }
                        if (tabAt != null) {
                            tabAt.setTag(frsTabItemData);
                        }
                        if (i4 == i) {
                            tabAt.select();
                        }
                        i3++;
                        r3 = 0;
                    }
                }
                i3++;
                r3 = 0;
            }
            int f4 = oi.f(getContext(), R.dimen.M_W_X004);
            linearLayout.setPadding(f4, 0, f4, 0);
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, baseActivity) == null) {
            this.g = baseActivity;
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i == 0) {
            return;
        }
        this.e = i;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsTabInfoData) == null) {
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                setVisibility(0);
                l(frsTabInfoData.tabList, this.d, frsTabInfoData.selectedTabId);
                return;
            }
            setVisibility(8);
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
        this.f = new a(this);
        this.h = new b(this);
        i();
    }
}
