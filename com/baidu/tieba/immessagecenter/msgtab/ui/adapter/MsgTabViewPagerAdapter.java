package com.baidu.tieba.immessagecenter.msgtab.ui.adapter;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.transition.Transition;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.dr8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgTabNotifyFragment;
import com.baidu.tieba.jw8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\nJ\u0014\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017J\u0014\u0010\"\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Lcom/baidu/tbadk/core/BaseFragment;", "(Lcom/baidu/tbadk/core/BaseFragment;)V", "mBodyDataList", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "mCreatedIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mHeaderDataList", "mSupportTypes", "", "", "containsItem", "", Transition.MATCH_ITEM_ID_STR, "createFragment", "Landroidx/fragment/app/Fragment;", CriusAttrConstants.POSITION, "getAllData", "", "getFragment", "getItemCount", "getItemId", "getItemViewType", "getSelectedItem", "Lkotlin/Pair;", "dataId", "setBodyData", "", "list", "setHeaderData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabViewPagerAdapter extends FragmentStateAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment a;
    public final Set<Integer> b;
    public final HashSet<Long> c;
    public final List<jw8> d;
    public final List<jw8> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgTabViewPagerAdapter(BaseFragment fragment) {
        super(fragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
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
        this.a = fragment;
        this.b = new LinkedHashSet();
        this.c = new HashSet<>();
        this.d = new ArrayList();
        this.e = new ArrayList();
        Set<Integer> set = this.b;
        set.add(2);
        set.add(1);
        set.add(3);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        InterceptResult invokeI;
        Fragment msgTabNotifyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            long itemId = getItemId(i);
            this.c.add(Long.valueOf(itemId));
            int itemViewType = getItemViewType(i);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        msgTabNotifyFragment = new Fragment();
                    } else {
                        MsgTabForumData d = ForumChannelDataObs.b.a().d(itemId);
                        msgTabNotifyFragment = new GroupChatDialogFragment(itemId, (d == null || (r0 = d.getForumName()) == null) ? "" : "", 0L, null, false, dr8.c, "message_tab");
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

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return this.c.contains(Long.valueOf(j));
        }
        return invokeJ.booleanValue;
    }

    public final void o(List<jw8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.e.clear();
            this.e.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final void p(List<jw8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.d.clear();
            this.d.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d.size() + this.e.size();
        }
        return invokeV.intValue;
    }

    public final List<jw8> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.d);
            arrayList.addAll(this.e);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i > this.d.size() - 1) {
                return this.e.get(i - this.d.size()).a();
            }
            return this.d.get(i).a();
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i > this.d.size() - 1) {
                return this.e.get(i - this.d.size()).getType();
            }
            return this.d.get(i).getType();
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('f' char), (r0v2 long)] */
    public final Fragment m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            long itemId = getItemId(i);
            FragmentManager childFragmentManager = this.a.getChildFragmentManager();
            StringBuilder sb = new StringBuilder();
            sb.append('f');
            sb.append(itemId);
            return childFragmentManager.findFragmentByTag(sb.toString());
        }
        return (Fragment) invokeI.objValue;
    }

    public final Pair<Integer, jw8> n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            int i = 0;
            for (Object obj : l()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                jw8 jw8Var = (jw8) obj;
                if (jw8Var.a() == j) {
                    return new Pair<>(Integer.valueOf(i), jw8Var);
                }
                i = i2;
            }
            return null;
        }
        return (Pair) invokeJ.objValue;
    }
}
