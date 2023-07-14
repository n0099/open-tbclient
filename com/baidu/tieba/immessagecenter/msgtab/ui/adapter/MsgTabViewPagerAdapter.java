package com.baidu.tieba.immessagecenter.msgtab.ui.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.transition.Transition;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.h29;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgTabNotifyFragment;
import com.baidu.tieba.jj8;
import com.baidu.tieba.tr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Lcom/baidu/tbadk/core/BaseFragment;", "tabAdapter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter;", "(Lcom/baidu/tbadk/core/BaseFragment;Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter;)V", "mCreatedIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mSupportTypes", "", "", "containsItem", "", Transition.MATCH_ITEM_ID_STR, "createFragment", "Landroidx/fragment/app/Fragment;", CriusAttrConstants.POSITION, "getFragment", "getItemCount", "getItemId", "getItemViewType", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabViewPagerAdapter extends FragmentStateAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment a;
    public final MsgTabSideNavigationAdapter b;
    public final Set<Integer> c;
    public final HashSet<Long> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgTabViewPagerAdapter(BaseFragment fragment, MsgTabSideNavigationAdapter tabAdapter) {
        super(fragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment, tabAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Fragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(tabAdapter, "tabAdapter");
        this.a = fragment;
        this.b = tabAdapter;
        this.c = new LinkedHashSet();
        this.d = new HashSet<>();
        Set<Integer> set = this.c;
        set.add(2);
        set.add(1);
        set.add(3);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return this.d.contains(Long.valueOf(j));
        }
        return invokeJ.booleanValue;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            tr8 m = this.b.m(i);
            if (m != null) {
                return m.c();
            }
            return super.getItemId(i);
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return this.b.getItemViewType(i);
        }
        return invokeI.intValue;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        InterceptResult invokeI;
        Fragment msgTabNotifyFragment;
        Long l;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.d.add(Long.valueOf(getItemId(i)));
            int itemViewType = getItemViewType(i);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    String str3 = null;
                    if (itemViewType != 3) {
                        h29 iMLog = IMLog.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("dataId == null,position=");
                        sb.append(i);
                        sb.append(",item=");
                        tr8 m = this.b.m(i);
                        if (m != null) {
                            str2 = m.toString();
                        } else {
                            str2 = null;
                        }
                        sb.append(str2);
                        iMLog.c("MsgTabViewPagerAdapter", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("dataId == null,position=");
                        sb2.append(i);
                        sb2.append(",item=");
                        tr8 m2 = this.b.m(i);
                        if (m2 != null) {
                            str3 = m2.toString();
                        }
                        sb2.append(str3);
                        BdLog.e(new IllegalStateException(sb2.toString()));
                        msgTabNotifyFragment = new Fragment();
                    } else {
                        tr8 m3 = this.b.m(i);
                        if (m3 != null) {
                            l = Long.valueOf(m3.c());
                        } else {
                            l = null;
                        }
                        if (l != null) {
                            long longValue = l.longValue();
                            MsgTabForumData e = ForumChannelDataObs.c.a().e(l.longValue());
                            msgTabNotifyFragment = new GroupChatDialogFragment(longValue, (e == null || (r2 = e.getForumName()) == null) ? "" : "", 0L, null, false, jj8.c, "msgTabFragment");
                        } else {
                            h29 iMLog2 = IMLog.getInstance();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("dataId == null,position=");
                            sb3.append(i);
                            sb3.append(",item=");
                            tr8 m4 = this.b.m(i);
                            if (m4 != null) {
                                str = m4.toString();
                            } else {
                                str = null;
                            }
                            sb3.append(str);
                            iMLog2.c("MsgTabViewPagerAdapter", sb3.toString());
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("dataId == null,position=");
                            sb4.append(i);
                            sb4.append(",dataType=Channel,item=");
                            tr8 m5 = this.b.m(i);
                            if (m5 != null) {
                                str3 = m5.toString();
                            }
                            sb4.append(str3);
                            BdLog.e(new IllegalStateException(sb4.toString()));
                            msgTabNotifyFragment = new Fragment();
                        }
                    }
                } else {
                    msgTabNotifyFragment = new ChatTabFragment();
                }
            } else {
                msgTabNotifyFragment = new MsgTabNotifyFragment();
            }
            Bundle bundle = new Bundle();
            if (this.a.getActivity() instanceof MessageCenterActivity) {
                bundle.putString("FROM", "FRS");
            } else {
                bundle.putString("FROM", "MSGTAB");
            }
            msgTabNotifyFragment.setArguments(bundle);
            return msgTabNotifyFragment;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.getItemCount();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('f' char), (r0v2 long)] */
    public final Fragment l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            long itemId = getItemId(i);
            FragmentManager childFragmentManager = this.a.getChildFragmentManager();
            StringBuilder sb = new StringBuilder();
            sb.append('f');
            sb.append(itemId);
            return childFragmentManager.findFragmentByTag(sb.toString());
        }
        return (Fragment) invokeI.objValue;
    }
}
