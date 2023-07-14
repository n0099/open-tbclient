package com.baidu.tieba.immessagecenter.msgtab.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.cqa;
import com.baidu.tieba.d85;
import com.baidu.tieba.h05;
import com.baidu.tieba.immessagecenter.arch.utils.SafetyLinearLayoutManager;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabSideNavigationAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabViewPagerAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel;
import com.baidu.tieba.qu8;
import com.baidu.tieba.ru8;
import com.baidu.tieba.tr8;
import com.baidu.tieba.uu8;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020)J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0002J\b\u00104\u001a\u00020\u0004H\u0014J\b\u00105\u001a\u00020)H\u0002J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020)H\u0014J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0002H\u0014J\u0018\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0018\u0010>\u001a\u00020)2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010@H\u0002J\u0018\u0010A\u001a\u00020)2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010@H\u0002J\u0006\u0010B\u001a\u00020)J\u0006\u0010C\u001a\u00020)J\u0006\u0010D\u001a\u00020)J\u0006\u0010E\u001a\u00020)J\u0017\u0010F\u001a\u00020)2\b\u0010G\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010HR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgCenterContainerView;", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiIntent;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgCenterContainerViewModel;", "activity", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "fragment", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "(Lcom/baidu/tbadk/core/BaseFragmentActivity;Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;)V", "getActivity", "()Lcom/baidu/tbadk/core/BaseFragmentActivity;", "setActivity", "(Lcom/baidu/tbadk/core/BaseFragmentActivity;)V", "getFragment", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "mBgView", "Landroid/widget/ImageView;", "mCurrentPosition", "", "mEnterChatBtn", "Landroid/widget/TextView;", "mFragmentTabAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabViewPagerAdapter;", "mLeftDrawable", "Landroid/graphics/drawable/Drawable;", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "msgTabGuide", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;", "getMsgTabGuide", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;", "msgTabGuide$delegate", "Lkotlin/Lazy;", "msgTabSideNavigationAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter;", "changeToPage", "", CriusAttrConstants.POSITION, "forceChange", "", "doAfterRender", "getPageContext", "Lcom/baidu/tbadk/TbPageContext;", "init", "context", "Landroid/content/Context;", "initNavigationBar", "initViewModel", "msgGroupEditItemClick", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onFinishInflate", "onRender", "state", "onSelectedViewItem", "itemData", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "renderBodyData", "data", "", "renderHeaderData", "requestData", "requestSilent", "resetSelected", "tryShowGuide", "updateNavigationBar", "type", "(Ljava/lang/Integer;)V", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerView extends BaseView<ru8, qu8, MsgCenterContainerViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity e;
    public final MsgCenterContainerFragment f;
    public NavigationBar g;
    public TextView h;
    public Drawable i;
    public RecyclerView j;
    public ViewPager2 k;
    public ImageView l;
    public MsgTabSideNavigationAdapter m;
    public MsgTabViewPagerAdapter n;
    public int o;
    public final Lazy p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgCenterContainerView(BaseFragmentActivity activity, MsgCenterContainerFragment fragment) {
        super(R.layout.obfuscated_res_0x7f0d0616);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, fragment};
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
        this.e = activity;
        this.f = fragment;
        MsgTabSideNavigationAdapter msgTabSideNavigationAdapter = new MsgTabSideNavigationAdapter(activity);
        this.m = msgTabSideNavigationAdapter;
        this.n = new MsgTabViewPagerAdapter(this.f, msgTabSideNavigationAdapter);
        this.o = -1;
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<MsgTabGuide>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView$msgTabGuide$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgCenterContainerView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MsgTabGuide invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    MsgTabGuide d = MsgTabGuide.j.d(this.this$0.getActivity());
                    if (d != null) {
                        final MsgCenterContainerView msgCenterContainerView = this.this$0;
                        d.u(new Function2<cqa, Integer, Unit>(msgCenterContainerView) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView$msgTabGuide$2$1$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MsgCenterContainerView this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr2 = {msgCenterContainerView};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$0 = msgCenterContainerView;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(cqa cqaVar, Integer num) {
                                invoke(cqaVar, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(cqa cqaVar, int i3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cqaVar, i3) == null) {
                                    Intrinsics.checkNotNullParameter(cqaVar, "<anonymous parameter 0>");
                                    if (i3 == 2) {
                                        i3++;
                                    }
                                    this.this$0.P(i3, true);
                                }
                            }
                        });
                        return d;
                    }
                    return null;
                }
                return (MsgTabGuide) invokeV.objValue;
            }
        });
    }

    public static final void R(MsgCenterContainerView this$0, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, this$0, i) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewPager2 viewPager2 = this$0.k;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(i, false);
        }
    }

    public static final void Z(MsgCenterContainerView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e.finish();
        }
    }

    public static final void T(MsgCenterContainerView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MsgTabGuide U = this$0.U();
            if (U != null) {
                U.t();
            }
        }
    }

    public final void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            P(i, false);
        }
    }

    public final void e0(List<tr8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && list != null) {
            this.m.n(list);
            this.f.I1().onNext(list);
        }
    }

    public final void f0(List<tr8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && list != null) {
            this.m.o(list);
        }
    }

    public static final void W(MsgCenterContainerView this$0, View view2, tr8 itemData, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, view2, itemData, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this$0.d0(itemData, i);
        }
    }

    public static final void Y(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, view2) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(context);
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = (ImageView) j(R.id.obfuscated_res_0x7f091f21);
            this.j = (RecyclerView) j(R.id.obfuscated_res_0x7f091f88);
            this.k = (ViewPager2) j(R.id.obfuscated_res_0x7f0929bb);
            NavigationBar navigationBar = (NavigationBar) j(R.id.navigation_bar);
            this.g = navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            navigationBar.setBarBackgourndColor(R.color.transparent);
        }
    }

    public final void P(final int i, boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            boolean z4 = false;
            if (!z) {
                MsgTabGuide U = U();
                if (U != null && U.r()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return;
                }
            }
            int i2 = this.o;
            if (i2 != i) {
                MsgTabSideNavigationAdapter msgTabSideNavigationAdapter = this.m;
                if (i2 >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Integer num = null;
                if (!z2) {
                    msgTabSideNavigationAdapter = null;
                }
                if (msgTabSideNavigationAdapter != null) {
                    tr8 m = msgTabSideNavigationAdapter.m(this.o);
                    if (m != null) {
                        m.e(false);
                    }
                    msgTabSideNavigationAdapter.notifyItemChanged(this.o);
                }
                this.o = i;
                ViewPager2 viewPager2 = this.k;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager2 = null;
                }
                viewPager2.post(new Runnable() { // from class: com.baidu.tieba.gt8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MsgCenterContainerView.R(MsgCenterContainerView.this, i);
                        }
                    }
                });
                MsgTabSideNavigationAdapter msgTabSideNavigationAdapter2 = this.m;
                if (i >= 0) {
                    z4 = true;
                }
                if (!z4) {
                    msgTabSideNavigationAdapter2 = null;
                }
                if (msgTabSideNavigationAdapter2 != null) {
                    tr8 m2 = msgTabSideNavigationAdapter2.m(i);
                    if (m2 != null) {
                        m2.e(true);
                    }
                    msgTabSideNavigationAdapter2.notifyItemChanged(i);
                    tr8 m3 = msgTabSideNavigationAdapter2.m(i);
                    if (m3 != null) {
                        num = Integer.valueOf(m3.getType());
                    }
                    k0(num);
                }
            }
        }
    }

    public final void S() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            List<tr8> l = this.m.l();
            Iterator<tr8> it = l.iterator();
            int i = 0;
            while (true) {
                if (it.hasNext()) {
                    if (it.next().d()) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i >= 0 && i < 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                O(i);
            } else if (i > 1 && this.o != i) {
                this.o = i;
                ViewPager2 viewPager2 = this.k;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager2 = null;
                }
                viewPager2.setCurrentItem(i, false);
            }
            MsgTabGuide U = U();
            if (U != null) {
                U.x(l);
            }
            zg.a().post(new Runnable() { // from class: com.baidu.tieba.at8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgCenterContainerView.T(MsgCenterContainerView.this);
                    }
                }
            });
        }
    }

    public final MsgTabGuide U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (MsgTabGuide) this.p.getValue();
        }
        return (MsgTabGuide) invokeV.objValue;
    }

    public final TbPageContext<BaseFragmentActivity> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = this.e.getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "activity.pageContext");
            return pageContext;
        }
        return (TbPageContext) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: a0 */
    public MsgCenterContainerViewModel r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.e).get(MsgCenterContainerViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…nerViewModel::class.java)");
            return (MsgCenterContainerViewModel) viewModel;
        }
        return (MsgCenterContainerViewModel) invokeV.objValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_EDIT_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            o().k(new qu8.b(V()));
        }
    }

    public final BaseFragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.e;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            o().k(new qu8.a(V()));
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            o().k(qu8.c.a);
        }
    }

    public final void j0() {
        MsgTabGuide U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (U = U()) != null) {
            U.v();
        }
    }

    public final void X(final Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            NavigationBar navigationBar = this.g;
            NavigationBar navigationBar2 = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            navigationBar.setVisibility(0);
            NavigationBar navigationBar3 = this.g;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar3 = null;
            }
            navigationBar3.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.bt8
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
            int g = yi.g(context, R.dimen.tbds60);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080afd, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS);
            this.i = pureDrawable;
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, 0, g, g);
            }
            textView.setCompoundDrawables(this.i, null, null, null);
            textView.setCompoundDrawablePadding(yi.g(context, R.dimen.M_W_X002));
            textView.setVisibility(0);
            textView.setGravity(16);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
            marginLayoutParams.setMargins(0, 0, yi.g(context, R.dimen.M_W_X007), 0);
            textView.setLayoutParams(marginLayoutParams);
            d85 d = d85.d(textView);
            d.x(R.color.CAM_X0107);
            d.C(R.dimen.T_X06);
            d.D(R.string.F_X01);
            this.h = textView;
            NavigationBar navigationBar4 = this.g;
            if (navigationBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
            } else {
                navigationBar2 = navigationBar4;
            }
            navigationBar2.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.h, new View.OnClickListener() { // from class: com.baidu.tieba.rt8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgCenterContainerView.Y(context, view2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.oi8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0202, i);
            BaseFragment baseFragment = null;
            if (i == 4) {
                ImageView imageView = this.l;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    imageView = null;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0810f0);
            } else {
                ImageView imageView2 = this.l;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.obfuscated_res_0x7f0810ef);
            }
            NavigationBar navigationBar = this.g;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            SkinManager.setBackgroundColor(navigationBar, R.color.CAM_X0202);
            NavigationBar navigationBar2 = this.g;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar2 = null;
            }
            navigationBar2.onChangeSkinType(V(), i);
            TextView textView = this.h;
            if (textView != null) {
                d85.d(textView).x(R.color.CAM_X0107);
                Drawable drawable = this.i;
                if (drawable != null) {
                    drawable.setTint(SkinManager.getColor(R.color.CAM_X0107));
                }
            }
            NavigationBar navigationBar3 = this.g;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar3 = null;
            }
            d85 d = d85.d(navigationBar3.getCenterText());
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X04);
            d.D(R.string.F_X02);
            MsgTabViewPagerAdapter msgTabViewPagerAdapter = this.n;
            ViewPager2 viewPager2 = this.k;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            Fragment l = msgTabViewPagerAdapter.l(viewPager2.getCurrentItem());
            if (l != null) {
                if (l instanceof BaseFragment) {
                    baseFragment = (BaseFragment) l;
                }
                if (baseFragment != null) {
                    baseFragment.changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(final Context context) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            ViewPager2 viewPager2 = this.k;
            ViewPager2 viewPager22 = null;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            viewPager2.setOrientation(1);
            viewPager2.setAdapter(this.n);
            viewPager2.setUserInputEnabled(false);
            this.m.s(new h05() { // from class: com.baidu.tieba.kt8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.h05
                public final void d(View view2, Object obj, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        MsgCenterContainerView.W(MsgCenterContainerView.this, view2, (tr8) obj, i, j);
                    }
                }
            });
            RecyclerView recyclerView = this.j;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new SafetyLinearLayoutManager(context, 1, false));
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setAdapter(this.m);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration(context, this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView$init$3$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ MsgCenterContainerView b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.b = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, outRect, view2, parent, state) == null) {
                        Intrinsics.checkNotNullParameter(outRect, "outRect");
                        Intrinsics.checkNotNullParameter(view2, "view");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        Intrinsics.checkNotNullParameter(state, "state");
                        super.getItemOffsets(outRect, view2, parent, state);
                        int childAdapterPosition = parent.getChildAdapterPosition(view2);
                        RecyclerView.Adapter adapter = parent.getAdapter();
                        if (adapter != null) {
                            i = adapter.getItemCount();
                        } else {
                            i = 0;
                        }
                        if (childAdapterPosition != 0 && childAdapterPosition != 1) {
                            outRect.top = yi.g(this.a, R.dimen.tbds35);
                        } else {
                            outRect.top = yi.g(this.a, R.dimen.tbds18);
                        }
                        if (childAdapterPosition == i - 1) {
                            if (this.b.getActivity() instanceof MessageCenterActivity) {
                                outRect.bottom = yi.g(this.a, R.dimen.tbds60);
                            } else {
                                outRect.bottom = yi.g(this.a, R.dimen.tbds177);
                            }
                        }
                    }
                }
            });
            if (this.e instanceof MessageCenterActivity) {
                X(context);
                return;
            }
            RecyclerView recyclerView2 = this.j;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight();
            }
            int g = yi.g(context, R.dimen.tbds150);
            RecyclerView recyclerView3 = this.j;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.offsetTopAndBottom(g);
            ViewPager2 viewPager23 = this.k;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setPadding(0, 0, 0, g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: c0 */
    public void F(ru8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof ru8.b) {
                f0(((ru8.b) state).a());
            } else if (state instanceof ru8.a) {
                e0(((ru8.a) state).a());
            }
            S();
        }
    }

    public final void d0(tr8 tr8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tr8Var, i) == null) {
            int type = tr8Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            o().k(new qu8.d(V(), tr8Var.c()));
                            b0();
                            return;
                        }
                        return;
                    }
                    uu8.a.b(Long.valueOf(tr8Var.c()));
                    O(i);
                    h0();
                    return;
                }
                uu8.a.d();
                O(i);
                return;
            }
            uu8.a.f();
            O(i);
        }
    }

    public final void k0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, num) == null) {
            NavigationBar navigationBar = null;
            if (num != null && num.intValue() == 2) {
                TextView textView = this.h;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                NavigationBar navigationBar2 = this.g;
                if (navigationBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar2;
                }
                navigationBar.setCenterTextTitle("聊天");
            } else if (num != null && num.intValue() == 3) {
                TextView textView2 = this.h;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                NavigationBar navigationBar3 = this.g;
                if (navigationBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar3;
                }
                navigationBar.setCenterTextTitle("聊天频道");
            } else {
                TextView textView3 = this.h;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                NavigationBar navigationBar4 = this.g;
                if (navigationBar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar4;
                }
                navigationBar.setCenterTextTitle("通知");
            }
        }
    }
}
