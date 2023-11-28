package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.el5;
import com.baidu.tieba.ez8;
import com.baidu.tieba.g49;
import com.baidu.tieba.gq8;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.EmojiGroupAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiGroupData;
import com.baidu.tieba.ok5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ReplayEmojiSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d j;
    public BottomSheetDialog k;
    public final List<EmojiGroupData> l;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> m;
    @NonNull
    public final GroupChatFragment n;
    public EmojiGroupAdapter o;
    public final g49 p;
    public final View.OnClickListener q;
    @Nullable
    public List<Reaction> r;
    public int s;
    @Nullable
    public BaseItem<? extends TbBaseMsg> t;
    @NonNull
    public final gq8 u;
    public final BdUniqueId v;

    /* loaded from: classes6.dex */
    public class a implements g49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplayEmojiSlice a;

        public a(ReplayEmojiSlice replayEmojiSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replayEmojiSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replayEmojiSlice;
        }

        @Override // com.baidu.tieba.g49
        public void a(@NonNull Reaction reaction) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, reaction) == null) {
                ez8.g(this.a.u, reaction, this.a.t, 1);
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplayEmojiSlice a;

        public b(ReplayEmojiSlice replayEmojiSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replayEmojiSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replayEmojiSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091fa5) {
                int i = this.a.s;
                if (i != 1) {
                    if (i == 2) {
                        this.a.p0();
                        return;
                    }
                    return;
                }
                if (this.a.n.j3() != null) {
                    this.a.n.j3().u1(this.a.t);
                }
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements el5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplayEmojiSlice a;

        public c(ReplayEmojiSlice replayEmojiSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replayEmojiSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replayEmojiSlice;
        }

        @Override // com.baidu.tieba.el5
        public void a(@Nullable List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (String str : list) {
                        arrayList.add(new Reaction("", str));
                    }
                }
                this.a.n0(arrayList);
                this.a.o.o(this.a.l);
                this.a.r0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public RecyclerView d;

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
                dVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fa5);
                dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fa6);
                RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0909e8);
                dVar.d = recyclerView;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
                int i = ez8.a;
                layoutParams.leftMargin = i;
                layoutParams.rightMargin = i;
                dVar.d.setLayoutParams(layoutParams);
                return dVar;
            }
            return (d) invokeL.objValue;
        }
    }

    public ReplayEmojiSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull GroupChatFragment groupChatFragment, @NonNull gq8 gq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment, gq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.s = 0;
        this.v = BdUniqueId.gen();
        this.m = tbPageContext;
        this.n = groupChatFragment;
        this.u = gq8Var;
    }

    public void q0(int i, @NonNull BaseItem<? extends TbBaseMsg> baseItem, @Nullable List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, baseItem, list) == null) {
            this.l.clear();
            this.s = i;
            this.t = baseItem;
            if (i != 1) {
                if (i == 2) {
                    this.j.b.setVisibility(8);
                }
            } else {
                this.j.b.setVisibility(0);
            }
            this.j.d.setAdapter(this.o);
            if (list != null) {
                n0(list);
                this.o.o(this.l);
                r0();
                return;
            }
            ok5.b().e(this.m.getPageActivity(), true, -ez8.a(), new c(this));
        }
    }

    public void l0(@Nullable List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.r = list;
            if (list != null) {
                o0(list);
            }
        }
    }

    public final void o0(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (Reaction reaction : list) {
                BdResourceLoader.getInstance().loadResource(reaction.getContent(), 10, null, this.v);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            this.j = d.a(LayoutInflater.from(this.m.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0275, (ViewGroup) null));
            m0();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @Nullable
    public View U(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d089f, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.b.setOnClickListener(this.q);
            this.j.c.setText(R.string.obfuscated_res_0x7f0f12ac);
            this.j.d.setLayoutManager(new LinearLayoutManager(this.n.getContext(), 1, false));
            this.o = new EmojiGroupAdapter(this.p);
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.m.getPageActivity());
            this.k = bottomSheetDialog;
            bottomSheetDialog.setContentView(this.j.a);
            View view2 = (View) this.j.a.getParent();
            view2.setBackgroundResource(17170445);
            BottomSheetBehavior.from(view2).setPeekHeight((int) (BdUtilHelper.getEquipmentHeight(TbadkApplication.getInst()) * 0.6f));
        }
    }

    public final void n0(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (!list.isEmpty()) {
                EmojiGroupData emojiGroupData = new EmojiGroupData();
                emojiGroupData.setGroupName(UtilHelper.getString(R.string.obfuscated_res_0x7f0f12ae));
                emojiGroupData.setReactions(list);
                this.l.add(emojiGroupData);
            }
            List<Reaction> list2 = this.r;
            if (list2 != null && !list2.isEmpty()) {
                EmojiGroupData emojiGroupData2 = new EmojiGroupData();
                emojiGroupData2.setGroupName(UtilHelper.getString(R.string.obfuscated_res_0x7f0f12ad));
                emojiGroupData2.setReactions(this.r);
                this.l.add(emojiGroupData2);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.o != null && !this.l.isEmpty()) {
                this.o.notifyItemRangeChanged(0, this.l.size() - 1);
            }
            EMManager.from(this.j.a).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0213);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j.b, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            EMManager.from(this.j.c).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.d.setAdapter(null);
            this.l.clear();
            this.k.dismiss();
            this.s = 0;
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.k.show();
            this.k.getWindow().setLayout(-1, (int) (BdUtilHelper.getEquipmentHeight(TbadkApplication.getInst()) * 0.8f));
            this.k.getWindow().setGravity(80);
        }
    }
}
