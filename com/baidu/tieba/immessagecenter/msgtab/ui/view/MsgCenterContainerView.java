package com.baidu.tieba.immessagecenter.msgtab.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.arch.utils.SafetyLinearLayoutManager;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabSideNavigationAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabViewPagerAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel;
import com.baidu.tieba.u69;
import com.baidu.tieba.uu4;
import com.baidu.tieba.v69;
import com.baidu.tieba.x39;
import com.baidu.tieba.y69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001f\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\nH\u0002¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020+J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000601J\b\u00102\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0014J\u0010\u00106\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0002J\b\u00107\u001a\u00020\u0004H\u0014J\u0010\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020+H\u0014J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u0002H\u0014J\u0018\u0010>\u001a\u00020+2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@H\u0002J\b\u0010B\u001a\u00020+H\u0002J\u0006\u0010C\u001a\u00020+J\u0006\u0010D\u001a\u00020+J\u0006\u0010E\u001a\u00020+J\u0006\u0010F\u001a\u00020+J\u0017\u0010G\u001a\u00020+2\b\u0010H\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010IR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgCenterContainerView;", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiIntent;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgCenterContainerViewModel;", "activity", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "fragment", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "defaultSelectedTabId", "", "(Lcom/baidu/tbadk/core/BaseFragmentActivity;Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;Ljava/lang/Long;)V", "Ljava/lang/Long;", "mBgView", "Landroid/widget/ImageView;", "mBottomMaskView", "Landroid/view/View;", "mCurrentSelectedId", "mDividerLineBgView", "mEnterChatBtn", "Landroid/widget/TextView;", "mExtFunView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/NaExtensionView;", "mFragmentTabAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabViewPagerAdapter;", "mHeaderNavigationAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter;", "mHeaderRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mLeftDrawable", "Landroid/graphics/drawable/Drawable;", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "mRecyclerView", "mTopMaskView", "mTopSpace", "Landroid/widget/Space;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "msgTabGuide", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;", "msgTabSideNavigationAdapter", "changeToPage", "", "oldSelectedId", "newSelectedId", "(Ljava/lang/Long;J)V", "doAfterRender", "getPageContext", "Lcom/baidu/tbadk/TbPageContext;", "getSelectedDataId", "init", "context", "Landroid/content/Context;", "initNavigationBar", "initViewModel", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onFinishInflate", "onRender", "state", "renderBodyData", "data", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "renderHeaderData", "requestData", "requestSilent", "resetSelected", "tryShowGuide", "updateNavigationBar", "type", "(Ljava/lang/Integer;)V", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerView extends BaseView<v69, u69, MsgCenterContainerViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity f;
    public final MsgCenterContainerFragment g;
    public Long h;
    public NavigationBar i;
    public TextView j;
    public Drawable k;
    public RecyclerView l;
    public RecyclerView m;
    public ViewPager2 n;
    public ImageView o;
    public NaExtensionView p;
    public View q;
    public View r;
    public Space s;
    public View t;
    public MsgTabSideNavigationAdapter u;
    public MsgTabSideNavigationAdapter v;
    public MsgTabViewPagerAdapter w;
    public Long x;
    public MsgTabGuide y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgCenterContainerView(BaseFragmentActivity activity, MsgCenterContainerFragment fragment, Long l) {
        super(R.layout.obfuscated_res_0x7f0d063a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, fragment, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f = activity;
        this.g = fragment;
        this.h = l;
        this.u = new MsgTabSideNavigationAdapter(activity);
        this.v = new MsgTabSideNavigationAdapter(this.f);
        this.w = new MsgTabViewPagerAdapter(this.g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: c0 */
    public void J(v69 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof v69.a) {
                d0(((v69.a) state).a());
            }
            S();
        }
    }

    public final void d0(List<x39> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, list) == null) && list != null) {
            this.w.o(list);
            this.u.n(list);
            this.g.v2().onNext(list);
        }
    }

    public static final void V(MsgCenterContainerView this$0, View view2, x39 itemData, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{this$0, view2, itemData, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this$0.h = null;
            if (itemData.b() == 3) {
                y69.a.b(Long.valueOf(itemData.a()));
                this$0.R(this$0.x, itemData.a());
                this$0.g0();
            }
        }
    }

    public static final void W(MsgCenterContainerView this$0, View view2, x39 itemData, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, view2, itemData, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this$0.h = null;
            int b = itemData.b();
            if (b != 1) {
                if (b == 2) {
                    y69.a.d();
                    this$0.R(this$0.x, itemData.a());
                    return;
                }
                return;
            }
            y69.a.f();
            this$0.R(this$0.x, itemData.a());
        }
    }

    public static final void X(MsgCenterContainerView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.q().k(new u69.c(this$0.T(), "https://tieba.baidu.com/mo/q/hybrid-main-chatgroup/all-channel?customfullscreen=1&nonavigationbar=1"));
            y69.a.h();
        }
    }

    public static final void Z(MsgCenterContainerView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f.finish();
        }
    }

    public static final void a0(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, view2) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(context);
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Long l = this.x;
            if (l != null) {
                MsgTabViewPagerAdapter msgTabViewPagerAdapter = this.w;
                Intrinsics.checkNotNull(l);
                if (msgTabViewPagerAdapter.n(l.longValue()) != null) {
                    return;
                }
            }
            h0();
        }
    }

    public final TbPageContext<BaseFragmentActivity> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = this.f.getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "activity.pageContext");
            return pageContext;
        }
        return (TbPageContext) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: b0 */
    public MsgCenterContainerViewModel B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.f).get(MsgCenterContainerViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…nerViewModel::class.java)");
            return (MsgCenterContainerViewModel) viewModel;
        }
        return (MsgCenterContainerViewModel) invokeV.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q().k(new u69.b(T()));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q().k(new u69.a(T()));
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            R(this.x, U());
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.y == null) {
                this.y = MsgTabGuide.k.i(this.f);
            }
            MsgTabGuide msgTabGuide = this.y;
            if (msgTabGuide != null) {
                msgTabGuide.v();
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o = (ImageView) l(R.id.obfuscated_res_0x7f091fbc);
            this.l = (RecyclerView) l(R.id.obfuscated_res_0x7f092026);
            this.m = (RecyclerView) l(R.id.obfuscated_res_0x7f092028);
            this.n = (ViewPager2) l(R.id.obfuscated_res_0x7f092a5e);
            NavigationBar navigationBar = (NavigationBar) l(R.id.navigation_bar);
            this.i = navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            navigationBar.setBarBackgourndColor(R.color.transparent);
            this.p = (NaExtensionView) l(R.id.obfuscated_res_0x7f090aee);
            this.q = l(R.id.obfuscated_res_0x7f0926a2);
            this.r = l(R.id.obfuscated_res_0x7f090491);
            this.s = (Space) l(R.id.obfuscated_res_0x7f0926ab);
            this.t = l(R.id.obfuscated_res_0x7f090940);
        }
    }

    public final void R(Long l, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, l, j) == null) {
            if (this.y == null) {
                this.y = MsgTabGuide.k.i(this.f);
            }
            MsgTabGuide msgTabGuide = this.y;
            if (msgTabGuide != null) {
                msgTabGuide.z(Long.valueOf(j));
            }
            MsgTabGuide msgTabGuide2 = this.y;
            if (msgTabGuide2 != null) {
                msgTabGuide2.s();
            }
            if (this.g.isPrimary()) {
                i0();
            }
            if (l != null && l.longValue() == j) {
                return;
            }
            Pair<Integer, x39> n = this.w.n(j);
            ViewPager2 viewPager2 = null;
            if (n == null) {
                this.x = null;
                return;
            }
            this.x = Long.valueOf(j);
            j0(Integer.valueOf(n.getSecond().b()));
            ViewPager2 viewPager22 = this.n;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.setCurrentItem(n.getFirst().intValue(), false);
            int i = 0;
            for (Object obj : this.v.l()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                x39 x39Var = (x39) obj;
                if (j == x39Var.a()) {
                    x39Var.d(true);
                    this.v.notifyItemChanged(i);
                } else {
                    long a = x39Var.a();
                    if (l != null && l.longValue() == a) {
                        x39Var.d(false);
                        this.v.notifyItemChanged(i);
                    }
                }
                i = i2;
            }
            int i3 = 0;
            for (Object obj2 : this.u.l()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                x39 x39Var2 = (x39) obj2;
                if (j == x39Var2.a()) {
                    x39Var2.d(true);
                    this.u.notifyItemChanged(i3);
                } else {
                    long a2 = x39Var2.a();
                    if (l != null && l.longValue() == a2) {
                        x39Var2.d(false);
                        this.u.notifyItemChanged(i3);
                    }
                }
                i3 = i4;
            }
        }
    }

    public final long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Long l = this.h;
            if (l != null && (l == null || l.longValue() != 0)) {
                Long l2 = this.h;
                Intrinsics.checkNotNull(l2);
                return l2.longValue();
            }
            return q().m(-2L);
        }
        return invokeV.longValue;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new x39(-1L, 1, false, 4, null));
            arrayList.add(new x39(-2L, 2, false, 4, null));
            this.w.p(arrayList);
            this.v.n(arrayList);
        }
    }

    public final void Y(final Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            NavigationBar navigationBar = this.i;
            NavigationBar navigationBar2 = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            navigationBar.setVisibility(0);
            NavigationBar navigationBar3 = this.i;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar3 = null;
            }
            navigationBar3.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.v59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgCenterContainerView.Z(MsgCenterContainerView.this, view2);
                    }
                }
            });
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.im_send_private_msg));
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds60);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b2b, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS);
            this.k = pureDrawable;
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, 0, dimens, dimens);
            }
            textView.setCompoundDrawables(this.k, null, null, null);
            textView.setCompoundDrawablePadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X002));
            textView.setVisibility(0);
            textView.setGravity(16);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
            marginLayoutParams.setMargins(0, 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X007), 0);
            textView.setLayoutParams(marginLayoutParams);
            EMManager.from(textView).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
            this.j = textView;
            NavigationBar navigationBar4 = this.i;
            if (navigationBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
            } else {
                navigationBar2 = navigationBar4;
            }
            navigationBar2.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new View.OnClickListener() { // from class: com.baidu.tieba.r59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgCenterContainerView.a0(context, view2);
                    }
                }
            });
        }
    }

    public final void j0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            NavigationBar navigationBar = null;
            if (num != null && num.intValue() == 2) {
                TextView textView = this.j;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                NavigationBar navigationBar2 = this.i;
                if (navigationBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar2;
                }
                navigationBar.setCenterTextTitle("聊天");
            } else if (num != null && num.intValue() == 3) {
                TextView textView2 = this.j;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                NavigationBar navigationBar3 = this.i;
                if (navigationBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar3;
                }
                navigationBar.setCenterTextTitle("聊天频道");
            } else {
                TextView textView3 = this.j;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                NavigationBar navigationBar4 = this.i;
                if (navigationBar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar4;
                }
                navigationBar.setCenterTextTitle("通知");
            }
        }
    }

    @Override // com.baidu.tieba.vx8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            NaExtensionView naExtensionView = this.p;
            BaseFragment baseFragment = null;
            if (naExtensionView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExtFunView");
                naExtensionView = null;
            }
            naExtensionView.b(i);
            SkinManager.setBackgroundColor(o(), R.color.CAM_X0202, i);
            View view2 = this.t;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDividerLineBgView");
                view2 = null;
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0202, i);
            if (i == 4) {
                ImageView imageView = this.o;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    imageView = null;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08113e);
                View view3 = this.q;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopMaskView");
                    view3 = null;
                }
                view3.setBackgroundResource(R.drawable.obfuscated_res_0x7f08100b);
                View view4 = this.r;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomMaskView");
                    view4 = null;
                }
                view4.setBackgroundResource(R.drawable.obfuscated_res_0x7f081009);
            } else {
                ImageView imageView2 = this.o;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.obfuscated_res_0x7f08113d);
                View view5 = this.q;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopMaskView");
                    view5 = null;
                }
                view5.setBackgroundResource(R.drawable.obfuscated_res_0x7f08100a);
                View view6 = this.r;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomMaskView");
                    view6 = null;
                }
                view6.setBackgroundResource(R.drawable.obfuscated_res_0x7f081008);
            }
            NavigationBar navigationBar = this.i;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            SkinManager.setBackgroundColor(navigationBar, R.color.CAM_X0202);
            NavigationBar navigationBar2 = this.i;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar2 = null;
            }
            navigationBar2.onChangeSkinType(T(), i);
            TextView textView = this.j;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0107);
                Drawable drawable = this.k;
                if (drawable != null) {
                    drawable.setTint(SkinManager.getColor(R.color.CAM_X0107));
                }
            }
            NavigationBar navigationBar3 = this.i;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar3 = null;
            }
            EMManager.from(navigationBar3.getCenterText()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            MsgTabViewPagerAdapter msgTabViewPagerAdapter = this.w;
            ViewPager2 viewPager2 = this.n;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            Fragment m = msgTabViewPagerAdapter.m(viewPager2.getCurrentItem());
            if (m != null) {
                if (m instanceof BaseFragment) {
                    baseFragment = (BaseFragment) m;
                }
                if (baseFragment != null) {
                    baseFragment.changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void r(Context context) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            ViewPager2 viewPager2 = this.n;
            ViewPager2 viewPager22 = null;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            viewPager2.setOrientation(1);
            viewPager2.setAdapter(this.w);
            viewPager2.setUserInputEnabled(false);
            this.u.s(new uu4() { // from class: com.baidu.tieba.u59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.uu4
                public final void b(View view2, Object obj, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        MsgCenterContainerView.V(MsgCenterContainerView.this, view2, (x39) obj, i, j);
                    }
                }
            });
            this.v.s(new uu4() { // from class: com.baidu.tieba.y59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.uu4
                public final void b(View view2, Object obj, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        MsgCenterContainerView.W(MsgCenterContainerView.this, view2, (x39) obj, i, j);
                    }
                }
            });
            RecyclerView recyclerView = this.m;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderRecyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new SafetyLinearLayoutManager(context, 1, false));
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setAdapter(this.v);
            recyclerView.setItemAnimator(null);
            RecyclerView recyclerView2 = this.l;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setLayoutManager(new SafetyLinearLayoutManager(context, 1, false));
            recyclerView2.setNestedScrollingEnabled(true);
            recyclerView2.setAdapter(this.u);
            recyclerView2.setItemAnimator(null);
            final int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds31);
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            RecyclerView recyclerView3 = this.l;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener(floatRef, dimens, this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView$init$6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.FloatRef a;
                public final /* synthetic */ int b;
                public final /* synthetic */ MsgCenterContainerView c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {floatRef, Integer.valueOf(dimens), this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = floatRef;
                    this.b = dimens;
                    this.c = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView4, int i, int i2) {
                    View view2;
                    View view3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView4, i, i2) == null) {
                        Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                        super.onScrolled(recyclerView4, i, i2);
                        Ref.FloatRef floatRef2 = this.a;
                        float f = floatRef2.element + i2;
                        floatRef2.element = f;
                        float f2 = f / this.b;
                        MsgCenterContainerView msgCenterContainerView = this.c;
                        view2 = msgCenterContainerView.q;
                        View view4 = null;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopMaskView");
                            view2 = null;
                        }
                        view2.setAlpha(f2);
                        view3 = msgCenterContainerView.t;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDividerLineBgView");
                        } else {
                            view4 = view3;
                        }
                        view4.setAlpha(f2);
                    }
                }
            });
            NaExtensionView naExtensionView = this.p;
            if (naExtensionView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExtFunView");
                naExtensionView = null;
            }
            naExtensionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.t59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgCenterContainerView.X(MsgCenterContainerView.this, view2);
                    }
                }
            });
            if (this.f instanceof MessageCenterActivity) {
                Y(context);
            } else {
                Space space = this.s;
                if (space == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopSpace");
                    space = null;
                }
                space.getLayoutParams().height = UtilHelper.getStatusBarHeight();
                int mainTabBottomBarHeight = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                NaExtensionView naExtensionView2 = this.p;
                if (naExtensionView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExtFunView");
                    naExtensionView2 = null;
                }
                ViewGroup.LayoutParams layoutParams = naExtensionView2.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = BdUtilHelper.getDimens(this.f, R.dimen.tbds10) + mainTabBottomBarHeight;
                }
                ViewPager2 viewPager23 = this.n;
                if (viewPager23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager23 = null;
                }
                ViewPager2 viewPager24 = this.n;
                if (viewPager24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager24 = null;
                }
                int paddingLeft = viewPager24.getPaddingLeft();
                ViewPager2 viewPager25 = this.n;
                if (viewPager25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager25 = null;
                }
                int paddingTop = viewPager25.getPaddingTop();
                ViewPager2 viewPager26 = this.n;
                if (viewPager26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                } else {
                    viewPager22 = viewPager26;
                }
                viewPager23.setPadding(paddingLeft, paddingTop, viewPager22.getPaddingRight(), mainTabBottomBarHeight);
            }
            e0();
        }
    }
}
