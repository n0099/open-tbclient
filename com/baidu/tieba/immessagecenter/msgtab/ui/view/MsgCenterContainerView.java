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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.gpa;
import com.baidu.tieba.hja;
import com.baidu.tieba.immessagecenter.arch.utils.SafetyLinearLayoutManager;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabSideNavigationAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabViewPagerAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgCenterContainerViewModel;
import com.baidu.tieba.lz4;
import com.baidu.tieba.ms8;
import com.baidu.tieba.np8;
import com.baidu.tieba.ns8;
import com.baidu.tieba.qs8;
import com.baidu.tieba.tracker.core.data.ErrCode;
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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020%J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\b\u00100\u001a\u00020\u0004H\u0014J\b\u00101\u001a\u00020%H\u0002J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020%H\u0014J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u0002H\u0014J\u0018\u00107\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u0010&\u001a\u00020\nH\u0002J\u0018\u0010:\u001a\u00020%2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010<H\u0002J\u0018\u0010=\u001a\u00020%2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010<H\u0002J\u0006\u0010>\u001a\u00020%J\u0006\u0010?\u001a\u00020%J\u0006\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u00020%J\u0017\u0010B\u001a\u00020%2\b\u0010C\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010DR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgCenterContainerView;", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiState;", "Lcom/baidu/tieba/immessagecenter/msgtab/uidata/MsgCenterNavigationUiIntent;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/vm/MsgCenterContainerViewModel;", "activity", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "fragment", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "defaultSelectedTabId", "", "(Lcom/baidu/tbadk/core/BaseFragmentActivity;Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mBgView", "Landroid/widget/ImageView;", "mCurrentPosition", "mEnterChatBtn", "Landroid/widget/TextView;", "mFragmentTabAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabViewPagerAdapter;", "mLeftDrawable", "Landroid/graphics/drawable/Drawable;", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "msgTabGuide", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;", "getMsgTabGuide", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;", "msgTabGuide$delegate", "Lkotlin/Lazy;", "msgTabSideNavigationAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter;", "changeToPage", "", CriusAttrConstants.POSITION, "forceChange", "", "doAfterRender", "getPageContext", "Lcom/baidu/tbadk/TbPageContext;", "init", "context", "Landroid/content/Context;", "initNavigationBar", "initViewModel", "msgGroupEditItemClick", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onFinishInflate", "onRender", "state", "onSelectedViewItem", "itemData", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "renderBodyData", "data", "", "renderHeaderData", "requestData", "requestSilent", "resetSelected", "tryShowGuide", "updateNavigationBar", "type", "(Ljava/lang/Integer;)V", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerView extends BaseView<ns8, ms8, MsgCenterContainerViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity e;
    public final MsgCenterContainerFragment f;
    public final Integer g;
    public NavigationBar h;
    public TextView i;
    public Drawable j;
    public RecyclerView k;
    public ViewPager2 l;
    public ImageView m;
    public MsgTabSideNavigationAdapter n;
    public MsgTabViewPagerAdapter o;
    public int p;
    public final Lazy q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgCenterContainerView(BaseFragmentActivity activity, MsgCenterContainerFragment fragment, Integer num) {
        super(R.layout.obfuscated_res_0x7f0d061b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, fragment, num};
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
        this.g = num;
        MsgTabSideNavigationAdapter msgTabSideNavigationAdapter = new MsgTabSideNavigationAdapter(activity);
        this.n = msgTabSideNavigationAdapter;
        this.o = new MsgTabViewPagerAdapter(this.f, msgTabSideNavigationAdapter);
        this.p = -1;
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<MsgTabGuide>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView$msgTabGuide$2
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
                BaseFragmentActivity baseFragmentActivity;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    MsgTabGuide.a aVar = MsgTabGuide.j;
                    baseFragmentActivity = this.this$0.e;
                    MsgTabGuide d = aVar.d(baseFragmentActivity);
                    if (d != null) {
                        final MsgCenterContainerView msgCenterContainerView = this.this$0;
                        d.u(new Function2<gpa, Integer, Unit>(msgCenterContainerView) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView$msgTabGuide$2$1$1
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
                            public /* bridge */ /* synthetic */ Unit invoke(gpa gpaVar, Integer num2) {
                                invoke(gpaVar, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(gpa gpaVar, int i3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gpaVar, i3) == null) {
                                    Intrinsics.checkNotNullParameter(gpaVar, "<anonymous parameter 0>");
                                    if (i3 == 2) {
                                        i3++;
                                    }
                                    this.this$0.R(i3, true);
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

    public /* synthetic */ MsgCenterContainerView(BaseFragmentActivity baseFragmentActivity, MsgCenterContainerFragment msgCenterContainerFragment, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseFragmentActivity, msgCenterContainerFragment, (i & 4) != 0 ? null : num);
    }

    public static final void U(MsgCenterContainerView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MsgTabGuide V = this$0.V();
            if (V != null) {
                V.t();
            }
        }
    }

    public final void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            R(i, false);
        }
    }

    public final void f0(List<np8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && list != null) {
            this.n.n(list);
            this.f.J1().onNext(list);
        }
    }

    public final void g0(List<np8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && list != null) {
            this.n.o(list);
        }
    }

    public static final void S(MsgCenterContainerView this$0, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, i) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewPager2 viewPager2 = this$0.l;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(i, false);
        }
    }

    public static final void a0(MsgCenterContainerView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e.finish();
        }
    }

    public static final void X(MsgCenterContainerView this$0, View view2, np8 itemData, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{this$0, view2, itemData, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this$0.e0(itemData, i);
        }
    }

    public static final void Z(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, view2) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(context);
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m = (ImageView) j(R.id.obfuscated_res_0x7f091f38);
            this.k = (RecyclerView) j(R.id.obfuscated_res_0x7f091f9f);
            this.l = (ViewPager2) j(R.id.obfuscated_res_0x7f0929d5);
            NavigationBar navigationBar = (NavigationBar) j(R.id.navigation_bar);
            this.h = navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            navigationBar.setBarBackgourndColor(R.color.transparent);
        }
    }

    public final void R(final int i, boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            boolean z4 = false;
            if (!z) {
                MsgTabGuide V = V();
                if (V != null && V.r()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return;
                }
            }
            int i2 = this.p;
            if (i2 != i) {
                MsgTabSideNavigationAdapter msgTabSideNavigationAdapter = this.n;
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
                    np8 m = msgTabSideNavigationAdapter.m(this.p);
                    if (m != null) {
                        m.e(false);
                    }
                    msgTabSideNavigationAdapter.notifyItemChanged(this.p);
                }
                this.p = i;
                ViewPager2 viewPager2 = this.l;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager2 = null;
                }
                viewPager2.post(new Runnable() { // from class: com.baidu.tieba.dr8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MsgCenterContainerView.S(MsgCenterContainerView.this, i);
                        }
                    }
                });
                MsgTabSideNavigationAdapter msgTabSideNavigationAdapter2 = this.n;
                if (i >= 0) {
                    z4 = true;
                }
                if (!z4) {
                    msgTabSideNavigationAdapter2 = null;
                }
                if (msgTabSideNavigationAdapter2 != null) {
                    np8 m2 = msgTabSideNavigationAdapter2.m(i);
                    if (m2 != null) {
                        m2.e(true);
                    }
                    msgTabSideNavigationAdapter2.notifyItemChanged(i);
                    np8 m3 = msgTabSideNavigationAdapter2.m(i);
                    if (m3 != null) {
                        num = Integer.valueOf(m3.getType());
                    }
                    l0(num);
                }
            }
        }
    }

    public final void T() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            List<np8> l = this.n.l();
            Iterator<np8> it = l.iterator();
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
                Q(i);
            } else if (i > 1 && this.p != i) {
                this.p = i;
                ViewPager2 viewPager2 = this.l;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    viewPager2 = null;
                }
                viewPager2.setCurrentItem(i, false);
            }
            MsgTabGuide V = V();
            if (V != null) {
                V.x(l);
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.xq8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgCenterContainerView.U(MsgCenterContainerView.this);
                    }
                }
            });
        }
    }

    public final MsgTabGuide V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (MsgTabGuide) this.q.getValue();
        }
        return (MsgTabGuide) invokeV.objValue;
    }

    public final TbPageContext<BaseFragmentActivity> W() {
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
    /* renamed from: b0 */
    public MsgCenterContainerViewModel r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.e).get(MsgCenterContainerViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…nerViewModel::class.java)");
            MsgCenterContainerViewModel msgCenterContainerViewModel = (MsgCenterContainerViewModel) viewModel;
            msgCenterContainerViewModel.q(this.g);
            return msgCenterContainerViewModel;
        }
        return (MsgCenterContainerViewModel) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_EDIT_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p().k(new ms8.b(W()));
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p().k(new ms8.a(W()));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            p().k(ms8.c.a);
        }
    }

    public final void k0() {
        MsgTabGuide V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (V = V()) != null) {
            V.v();
        }
    }

    public final void Y(final Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            NavigationBar navigationBar = this.h;
            NavigationBar navigationBar2 = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            navigationBar.setVisibility(0);
            NavigationBar navigationBar3 = this.h;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar3 = null;
            }
            navigationBar3.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.yq8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgCenterContainerView.a0(MsgCenterContainerView.this, view2);
                    }
                }
            });
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.im_send_private_msg));
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds60);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080afe, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS);
            this.j = pureDrawable;
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, 0, dimens, dimens);
            }
            textView.setCompoundDrawables(this.j, null, null, null);
            textView.setCompoundDrawablePadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X002));
            textView.setVisibility(0);
            textView.setGravity(16);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
            marginLayoutParams.setMargins(0, 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X007), 0);
            textView.setLayoutParams(marginLayoutParams);
            EMManager.from(textView).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
            this.i = textView;
            NavigationBar navigationBar4 = this.h;
            if (navigationBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
            } else {
                navigationBar2 = navigationBar4;
            }
            navigationBar2.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.i, new View.OnClickListener() { // from class: com.baidu.tieba.or8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgCenterContainerView.Z(context, view2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.gg8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0202, i);
            BaseFragment baseFragment = null;
            if (i == 4) {
                ImageView imageView = this.m;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    imageView = null;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0810f6);
            } else {
                ImageView imageView2 = this.m;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.obfuscated_res_0x7f0810f5);
            }
            NavigationBar navigationBar = this.h;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar = null;
            }
            SkinManager.setBackgroundColor(navigationBar, R.color.CAM_X0202);
            NavigationBar navigationBar2 = this.h;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar2 = null;
            }
            navigationBar2.onChangeSkinType(W(), i);
            TextView textView = this.i;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0107);
                Drawable drawable = this.j;
                if (drawable != null) {
                    drawable.setTint(SkinManager.getColor(R.color.CAM_X0107));
                }
            }
            NavigationBar navigationBar3 = this.h;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                navigationBar3 = null;
            }
            EMManager.from(navigationBar3.getCenterText()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            MsgTabViewPagerAdapter msgTabViewPagerAdapter = this.o;
            ViewPager2 viewPager2 = this.l;
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
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            ViewPager2 viewPager2 = this.l;
            ViewPager2 viewPager22 = null;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager2 = null;
            }
            viewPager2.setOrientation(1);
            viewPager2.setAdapter(this.o);
            viewPager2.setUserInputEnabled(false);
            this.n.s(new lz4() { // from class: com.baidu.tieba.hr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.lz4
                public final void d(View view2, Object obj, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        MsgCenterContainerView.X(MsgCenterContainerView.this, view2, (np8) obj, i, j);
                    }
                }
            });
            RecyclerView recyclerView = this.k;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new SafetyLinearLayoutManager(context, 1, false));
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setAdapter(this.n);
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
                    BaseFragmentActivity baseFragmentActivity;
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
                            outRect.top = BdUtilHelper.getDimens(this.a, R.dimen.tbds35);
                        } else {
                            outRect.top = BdUtilHelper.getDimens(this.a, R.dimen.tbds18);
                        }
                        if (childAdapterPosition != i - 1) {
                            return;
                        }
                        baseFragmentActivity = this.b.e;
                        if (baseFragmentActivity instanceof MessageCenterActivity) {
                            outRect.bottom = BdUtilHelper.getDimens(this.a, R.dimen.tbds60);
                        } else {
                            outRect.bottom = BdUtilHelper.getDimens(this.a, R.dimen.tbds177);
                        }
                    }
                }
            });
            if (this.e instanceof MessageCenterActivity) {
                Y(context);
                return;
            }
            RecyclerView recyclerView2 = this.k;
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
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds145);
            RecyclerView recyclerView3 = this.k;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.offsetTopAndBottom(dimens);
            ViewPager2 viewPager23 = this.l;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setPadding(0, 0, 0, dimens);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: d0 */
    public void H(ns8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (!(state instanceof ns8.c)) {
                if (state instanceof ns8.b) {
                    g0(((ns8.b) state).a());
                } else if (state instanceof ns8.a) {
                    hja.f(this.f, new Pair[0]);
                    f0(((ns8.a) state).a());
                } else {
                    hja.b(this.f, new Pair(StatConstants.KEY_EXT_ERR_CODE, ErrCode.NET_ERROR.getValue()));
                }
            }
            T();
        }
    }

    public final void e0(np8 np8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, np8Var, i) == null) {
            p().q(null);
            int type = np8Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            p().k(new ms8.d(W(), np8Var.c()));
                            c0();
                            return;
                        }
                        return;
                    }
                    qs8.a.b(Long.valueOf(np8Var.c()));
                    Q(i);
                    i0();
                    return;
                }
                qs8.a.d();
                Q(i);
                return;
            }
            qs8.a.f();
            Q(i);
        }
    }

    public final void l0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, num) == null) {
            NavigationBar navigationBar = null;
            if (num != null && num.intValue() == 2) {
                TextView textView = this.i;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                NavigationBar navigationBar2 = this.h;
                if (navigationBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar2;
                }
                navigationBar.setCenterTextTitle("聊天");
            } else if (num != null && num.intValue() == 3) {
                TextView textView2 = this.i;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                NavigationBar navigationBar3 = this.h;
                if (navigationBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationBar");
                } else {
                    navigationBar = navigationBar3;
                }
                navigationBar.setCenterTextTitle("聊天频道");
            } else {
                TextView textView3 = this.i;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                NavigationBar navigationBar4 = this.h;
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
