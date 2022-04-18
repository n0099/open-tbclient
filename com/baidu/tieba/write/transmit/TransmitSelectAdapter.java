package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dp;
import com.repackage.ho;
import com.repackage.l09;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.qe7;
import com.repackage.uo;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes4.dex */
public class TransmitSelectAdapter extends ho<l09, TransmitSelectViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qe7 i;
    public ArrayList<HotTopicBussinessData> j;
    public List<TransmitForumData> k;
    public dp l;
    public qe7.b m;

    /* loaded from: classes4.dex */
    public static class TransmitSelectViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransmitSelectViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c5d);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090119);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitSelectAdapter a;

        public a(TransmitSelectAdapter transmitSelectAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitSelectAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitSelectAdapter;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (!mi.z()) {
                    oi.M(this.a.a, R.string.obfuscated_res_0x7f0f0c17);
                }
                TiebaStatic.log(new StatisticItem("c12053"));
                if (!ListUtils.isEmpty(this.a.j)) {
                    this.a.l0();
                    return;
                }
                TransmitSelectAdapter transmitSelectAdapter = this.a;
                transmitSelectAdapter.i = new qe7(transmitSelectAdapter.e);
                this.a.i.g(this.a.m);
                this.a.i.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements qe7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitSelectAdapter a;

        public b(TransmitSelectAdapter transmitSelectAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitSelectAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitSelectAdapter;
        }

        @Override // com.repackage.qe7.b
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, list}) == null) {
                ArrayList arrayList = new ArrayList();
                if (ListUtils.getCount(list) > 0) {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ForumInfo forumInfo = list.get(i2);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !this.a.k0(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                    }
                    if (this.a.j == null) {
                        this.a.j = arrayList;
                        this.a.l0();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransmitSelectAdapter(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.m = new b(this);
        V(this.l);
        this.k = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, l09 l09Var, TransmitSelectViewHolder transmitSelectViewHolder) {
        n0(i, view2, viewGroup, l09Var, transmitSelectViewHolder);
        return view2;
    }

    public void i0() {
        qe7 qe7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (qe7Var = this.i) == null) {
            return;
        }
        qe7Var.e();
    }

    public HotTopicBussinessData j0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (ListUtils.isEmpty(this.j)) {
                return null;
            }
            return this.j.remove(i);
        }
        return (HotTopicBussinessData) invokeI.objValue;
    }

    public final boolean k0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            List<TransmitForumData> list = this.k;
            if (list == null) {
                return false;
            }
            for (TransmitForumData transmitForumData : list) {
                if (transmitForumData != null && transmitForumData.forumId == j) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.a, 25005, this.j);
            hotTopicChangeActivityConfig.setUseOriginList(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicChangeActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: m0 */
    public TransmitSelectViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) ? new TransmitSelectViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0846, (ViewGroup) null)) : (TransmitSelectViewHolder) invokeL.objValue;
    }

    public View n0(int i, View view2, ViewGroup viewGroup, l09 l09Var, TransmitSelectViewHolder transmitSelectViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l09Var, transmitSelectViewHolder})) == null) {
            SkinManager.setViewTextColor(transmitSelectViewHolder.a, (int) R.color.CAM_X0302);
            SkinManager.setImageResource(transmitSelectViewHolder.b, R.drawable.icon_post_add_ba_n);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
