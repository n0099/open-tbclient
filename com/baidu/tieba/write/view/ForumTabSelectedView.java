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
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.c.e.p.l;
import d.a.r0.r.u.c;
import d.a.s0.u0.m;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumTabSelectedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsTabItemData f22614e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f22615f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22616g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout f22617h;

    /* renamed from: i  reason: collision with root package name */
    public int f22618i;
    public TabLayout.OnTabSelectedListener j;
    public BaseActivity k;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTabSelectedView f22619a;

        public a(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22619a = forumTabSelectedView;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (frsTabItemData.isSelected) {
                    frsTabItemData.isSelected = false;
                    this.f22619a.f22614e = null;
                    this.f22619a.setTabColorUnSelected(tab);
                    return;
                }
                frsTabItemData.isSelected = true;
                this.f22619a.f22614e = frsTabItemData;
                this.f22619a.setTabColorSelected(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                frsTabItemData.isSelected = true;
                this.f22619a.f22614e = frsTabItemData;
                this.f22619a.setTabColorSelected(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                ((FrsTabItemData) tab.getTag()).isSelected = false;
                this.f22619a.setTabColorUnSelected(tab);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumTabSelectedView f22620e;

        public b(ForumTabSelectedView forumTabSelectedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTabSelectedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22620e = forumTabSelectedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22620e.k == null) {
                return;
            }
            l.x(this.f22620e.getContext(), this.f22620e);
            m.b(this.f22620e.k, this.f22620e.k.getPageContext());
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
        this.f22618i = R.color.CAM_X0202;
        this.j = new a(this);
        this.l = new b(this);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        ((d.a.r0.r.f0.m.b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).q(R.color.CAM_X0302);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        d.a.r0.r.f0.m.b bVar = (d.a.r0.r.f0.m.b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
        if (j(tab)) {
            return;
        }
        bVar.r(R.color.CAM_X0107);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22615f = new ImageView(getContext());
            int g2 = l.g(getContext(), R.dimen.tbds31);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.f22615f.setLayoutParams(layoutParams);
            this.f22615f.setOnClickListener(this.l);
            addView(this.f22615f);
        }
    }

    public final void f(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tabLayout) == null) {
            SkinManager.setBackgroundColor(tabLayout, this.f22618i);
            if (tabLayout != null) {
                for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tabAt.getCustomView();
                        tBSpecificationBtn.k();
                        d.a.r0.r.f0.m.b bVar = (d.a.r0.r.f0.m.b) tBSpecificationBtn.getStyleConfig();
                        if (tabAt.isSelected()) {
                            bVar.q(R.color.CAM_X0302);
                        } else if (j(tabAt)) {
                            bVar.r(R.color.CAM_X0302);
                        } else {
                            bVar.r(R.color.CAM_X0107);
                        }
                    }
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22617h = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.forum_tab_select_layout, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            this.f22617h.setLayoutParams(layoutParams);
            addView(this.f22617h);
            this.f22617h.setOnTabSelectedListener(this.j);
        }
    }

    public FrsTabItemData getSelectedTabItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsTabItemData frsTabItemData = this.f22614e;
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
            this.f22616g = new EMTextView(getContext());
            this.f22616g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            c.d(this.f22616g).x(R.dimen.T_X08);
            this.f22616g.setText(R.string.forum_tab_select_title);
            this.f22616g.setOnClickListener(this.l);
            addView(this.f22616g);
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

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            f(this.f22617h);
            SkinManager.setViewTextColor(this.f22616g, R.color.CAM_X0107);
            this.f22615f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_post_section12, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.google.android.material.tabs.TabLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final void l(List<FrsTabItemData> list, TabLayout tabLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, tabLayout, i2) == null) {
            tabLayout.removeAllTabs();
            tabLayout.setTabRippleColorResource(R.color.transparent);
            int min = Math.min(list.size(), 10);
            ?? r3 = 0;
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i3 = 0; i3 < tabCount; i3++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            int g2 = l.g(getContext(), R.dimen.M_W_X002);
            l.g(getContext(), R.dimen.tbds25);
            int g3 = l.g(getContext(), R.dimen.M_W_X006);
            int g4 = l.g(getContext(), R.dimen.M_H_X003);
            int i4 = 0;
            while (i4 < min) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i4);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, (boolean) r3);
                    View childAt = linearLayout.getChildAt(i4);
                    if (childAt != null) {
                        childAt.setPadding(r3, r3, r3, r3);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i4);
                if (frsTabItemData != null) {
                    String str = frsTabItemData.name;
                    int i5 = frsTabItemData.tabId;
                    if (!TextUtils.isEmpty(str) && i5 >= 0) {
                        TBSpecificationBtn tBSpecificationBtn = null;
                        if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                            tBSpecificationBtn = new TBSpecificationBtn(getContext());
                            d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
                            bVar.k(g3);
                            bVar.m(g4);
                            if (frsTabItemData.tabId == 505) {
                                bVar.r(R.color.CAM_X0302);
                            } else {
                                bVar.r(R.color.CAM_X0107);
                            }
                            tBSpecificationBtn.setConfig(bVar);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(g2, 0, g2, 0);
                            tBSpecificationBtn.setLayoutParams(layoutParams);
                            tabAt.setCustomView(tBSpecificationBtn);
                        }
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(str);
                        }
                        if (tabAt != null) {
                            tabAt.setTag(frsTabItemData);
                        }
                        if (i5 == i2) {
                            tabAt.select();
                        }
                        i4++;
                        r3 = 0;
                    }
                }
                i4++;
                r3 = 0;
            }
            int g5 = l.g(getContext(), R.dimen.M_W_X004);
            linearLayout.setPadding(g5, 0, g5, 0);
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, baseActivity) == null) {
            this.k = baseActivity;
        }
    }

    public void setBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f22618i = i2;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsTabInfoData) == null) {
            if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                setVisibility(0);
                l(frsTabInfoData.tabList, this.f22617h, frsTabInfoData.selectedTabId);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22618i = R.color.CAM_X0202;
        this.j = new a(this);
        this.l = new b(this);
        i();
    }
}
