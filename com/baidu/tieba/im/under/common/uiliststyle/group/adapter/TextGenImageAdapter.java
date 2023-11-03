package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbTaskInfo;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.SingleTextImageAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextGenImageItem;
import com.baidu.tieba.mv8;
import com.baidu.tieba.qm8;
import com.baidu.tieba.uu8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes6.dex */
public class TextGenImageAdapter extends BaseStyleNormalAdapter<TextGenImageItem, SingleTextImageAdapter.Holder, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;

    @Override // com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BaseStyleNormalAdapter
    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final qm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(RecyclerView recyclerView) {
            super(recyclerView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context context = recyclerView.getContext();
            this.a = uu8.e(context, recyclerView, BdUtilHelper.getDimens(context, R.dimen.M_W_X004));
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextGenImageItem a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ TextGenImageAdapter e;

        public a(TextGenImageAdapter textGenImageAdapter, TextGenImageItem textGenImageItem, String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textGenImageAdapter, textGenImageItem, str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = textGenImageAdapter;
            this.a = textGenImageItem;
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbTaskInfo taskInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090ee2 && (taskInfo = this.a.getTbMsg().getTaskInfo()) != null && taskInfo.isComplete()) {
                SingleTextImageAdapter.j0(view2.getContext(), this.a.getTbMsg(), this.b);
                this.e.m0(this.c, this.d, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextGenImageAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @Nullable
    /* renamed from: g0 */
    public Holder N(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            super.N(viewGroup);
            return new Holder(mv8.g(this.mContext));
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: h0 */
    public SingleTextImageAdapter.Holder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            SingleTextImageAdapter.Holder holder = new SingleTextImageAdapter.Holder(SingleTextImageAdapter.h0(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (SingleTextImageAdapter.Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @Nullable
    /* renamed from: i0 */
    public Holder P(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            return new Holder(mv8.g(this.mContext));
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: j0 */
    public SingleTextImageAdapter.Holder Q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            SingleTextImageAdapter.Holder holder = new SingleTextImageAdapter.Holder(SingleTextImageAdapter.h0(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (SingleTextImageAdapter.Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: k0 */
    public void U(int i, @NonNull ViewGroup viewGroup, @NonNull TextGenImageItem textGenImageItem, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), viewGroup, textGenImageItem, holder, list, Integer.valueOf(i2)}) == null) {
            super.U(i, viewGroup, textGenImageItem, holder, list, i2);
            qm8 qm8Var = holder.a;
            if (qm8Var != null && textGenImageItem.getTbMsg().getSubSkillConfig() != null && !((List) Objects.requireNonNull(textGenImageItem.getTbMsg().getSubSkillConfig().a)).isEmpty()) {
                viewGroup.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(textGenImageItem.getTbMsg());
                qm8Var.d(arrayList);
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: l0 */
    public void V(int i, @NonNull ViewGroup viewGroup, @NonNull TextGenImageItem textGenImageItem, @NonNull SingleTextImageAdapter.Holder holder, @NonNull List<Object> list, int i2) {
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), viewGroup, textGenImageItem, holder, list, Integer.valueOf(i2)}) == null) {
            SingleTextImageAdapter.i0(i, viewGroup, textGenImageItem, holder, list, i2, this.mType);
            TbTextGenImageMsg tbMsg = textGenImageItem.getTbMsg();
            long sessionId = tbMsg.getSessionId();
            if (tbMsg.getForumExt() == null) {
                a2 = 0;
            } else {
                a2 = tbMsg.getForumExt().a();
            }
            long j = a2;
            String str = this.m;
            n0(sessionId, j, str);
            holder.a(new a(this, textGenImageItem, str, sessionId, j));
        }
    }

    public void m0(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 2).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void n0(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 1).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
