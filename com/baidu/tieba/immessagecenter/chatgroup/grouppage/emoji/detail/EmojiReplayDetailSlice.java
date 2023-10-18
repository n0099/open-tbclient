package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EmojiReplayDetailSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    @NonNull
    public final GroupChatFragment k;
    public d l;
    public BottomSheetDialog m;
    public EmojiPagerAdapter n;
    @NonNull
    public final List<EmojiData> o;
    @NonNull
    public final List<EmojiDetailFragment> p;
    public final long q;
    public final TabLayoutMediator.TabConfigurationStrategy r;
    public final View.OnClickListener s;
    public final TabLayout.OnTabSelectedListener t;

    /* loaded from: classes6.dex */
    public class a implements TabLayoutMediator.TabConfigurationStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplayDetailSlice a;

        public a(EmojiReplayDetailSlice emojiReplayDetailSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplayDetailSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplayDetailSlice;
        }

        @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
        @SuppressLint({"InflateParams"})
        public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
            View customView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, tab, i) == null) {
                if (tab.getCustomView() == null) {
                    customView = LayoutInflater.from(this.a.k.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0292, (ViewGroup) null);
                    tab.setCustomView(customView);
                } else {
                    customView = tab.getCustomView();
                }
                TextView textView = (TextView) customView.findViewById(R.id.obfuscated_res_0x7f0909b2);
                EMManager.from((LinearLayout) customView.findViewById(R.id.obfuscated_res_0x7f0909ad)).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0212);
                EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
                EmojiData emojiData = (EmojiData) this.a.o.get(i);
                ((TbImageView) customView.findViewById(R.id.obfuscated_res_0x7f0909ac)).startLoad(emojiData.getContent());
                textView.setText(String.valueOf(emojiData.getAllNum()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplayDetailSlice a;

        public b(EmojiReplayDetailSlice emojiReplayDetailSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplayDetailSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplayDetailSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2.getId() != R.id.obfuscated_res_0x7f091ee5) {
                return;
            }
            this.a.k0();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplayDetailSlice a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        public c(EmojiReplayDetailSlice emojiReplayDetailSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplayDetailSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplayDetailSlice;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) != null) {
                return;
            }
            this.a.m0(tab.getCustomView(), false);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) != null) {
                return;
            }
            this.a.m0(tab.getCustomView(), true);
            this.a.l.g.setCurrentItem(tab.getPosition());
            EmojiDetailFragment emojiDetailFragment = (EmojiDetailFragment) this.a.p.get(tab.getPosition());
            if (emojiDetailFragment != null) {
                emojiDetailFragment.g2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public RelativeLayout b;
        public LinearLayout c;
        public TextView d;
        public TextView e;
        public TabLayout f;
        public ViewPager2 g;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static d a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                d dVar = new d();
                dVar.a = view2;
                dVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ef1);
                dVar.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ef2);
                dVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ee5);
                dVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ee6);
                TabLayout tabLayout = (TabLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ef4);
                dVar.f = tabLayout;
                tabLayout.setSelectedTabIndicator(0);
                dVar.g = (ViewPager2) view2.findViewById(R.id.obfuscated_res_0x7f091ef6);
                return dVar;
            }
            return (d) invokeL.objValue;
        }
    }

    public EmojiReplayDetailSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull GroupChatFragment groupChatFragment, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.j = tbPageContext;
        this.k = groupChatFragment;
        this.q = j;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @Nullable
    public View U(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0870, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            View inflate = LayoutInflater.from(this.j.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0295, (ViewGroup) null);
            if (inflate != null) {
                this.l = d.a(inflate);
                j0();
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.e.setText(R.string.obfuscated_res_0x7f0f063c);
            this.l.d.setText(R.string.obfuscated_res_0x7f0f063b);
            EmojiPagerAdapter emojiPagerAdapter = new EmojiPagerAdapter(this.k);
            this.n = emojiPagerAdapter;
            this.l.g.setAdapter(emojiPagerAdapter);
            this.l.f.addOnTabSelectedListener(this.t);
            d dVar = this.l;
            new TabLayoutMediator(dVar.f, dVar.g, this.r).attach();
            this.l.d.setOnClickListener(this.s);
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.j.getPageActivity());
            this.m = bottomSheetDialog;
            bottomSheetDialog.setContentView(this.l.a);
            View view2 = (View) this.l.a.getParent();
            view2.setBackgroundResource(17170445);
            BottomSheetBehavior.from(view2).setPeekHeight((int) (BdUtilHelper.getEquipmentHeight(TbadkApplication.getInst()) * 0.93f));
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.g.setAdapter(null);
            BottomSheetDialog bottomSheetDialog = this.m;
            if (bottomSheetDialog != null) {
                bottomSheetDialog.dismiss();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            this.p.clear();
        }
    }

    public void l0(@NonNull List<EmojiData> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, list, i) == null) {
            this.o.clear();
            this.o.addAll(list);
            this.p.clear();
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                this.p.add(new EmojiDetailFragment(this.j, this.o.get(i2), this.q));
            }
            this.l.g.setAdapter(this.n);
            this.n.l(this.p);
            this.l.b.setVisibility(0);
            TabLayout.Tab tabAt = this.l.f.getTabAt(i);
            if (tabAt != null) {
                tabAt.select();
            }
            this.m.show();
            this.m.getWindow().setLayout(-1, (int) (BdUtilHelper.getEquipmentHeight(TbadkApplication.getInst()) * 0.93f));
            this.m.getWindow().setGravity(80);
        }
    }

    public final void m0(@Nullable View view2, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, view2, z) != null) || view2 == null) {
            return;
        }
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909ac);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909b2);
        EMManager corner = EMManager.from((LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909ad)).setCorner(R.string.J_X01);
        if (z) {
            i = R.color.CAM_X0905;
        } else {
            i = R.color.CAM_X0212;
        }
        corner.setBackGroundColor(i);
        EMManager textSize = EMManager.from(textView).setTextSize(R.dimen.T_X07);
        if (z) {
            i2 = R.color.CAM_X0304;
        } else {
            i2 = R.color.CAM_X0105;
        }
        textSize.setTextColor(i2);
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            this.n.notifyDataSetChanged();
            EMManager.from(this.l.b).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0213);
            EMManager.from(this.l.d).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
            EMManager.from(this.l.e).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
        }
    }
}
