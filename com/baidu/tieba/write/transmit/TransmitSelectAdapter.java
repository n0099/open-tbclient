package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.d.n.e.v;
import c.a.t0.a2.a;
import c.a.t0.p4.a0.c;
import c.a.t0.p4.d;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes13.dex */
public class TransmitSelectAdapter extends c.a.d.n.e.a<c, TransmitSelectViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.a2.a m;
    public ArrayList<HotTopicBussinessData> n;
    public List<TransmitForumData> o;
    public v p;
    public a.b q;

    /* loaded from: classes13.dex */
    public static class TransmitSelectViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView mAddIcon;
        public TextView mSelectBySelf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransmitSelectViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSelectBySelf = (TextView) view.findViewById(g.select_by_self);
            this.mAddIcon = (ImageView) view.findViewById(g.add_icon);
        }
    }

    /* loaded from: classes13.dex */
    public class a implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitSelectAdapter f49674e;

        public a(TransmitSelectAdapter transmitSelectAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitSelectAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49674e = transmitSelectAdapter;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (!l.z()) {
                    c.a.d.f.p.n.M(this.f49674e.f3360e, j.neterror);
                }
                TiebaStatic.log(new StatisticItem("c12053"));
                if (!ListUtils.isEmpty(this.f49674e.n)) {
                    this.f49674e.l0();
                    return;
                }
                TransmitSelectAdapter transmitSelectAdapter = this.f49674e;
                transmitSelectAdapter.m = new c.a.t0.a2.a(transmitSelectAdapter.f3364i);
                this.f49674e.m.g(this.f49674e.q);
                this.f49674e.m.f();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements a.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitSelectAdapter;
        }

        @Override // c.a.t0.a2.a.b
        public void a(boolean z, int i2, String str, List<ForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, list}) == null) {
                ArrayList arrayList = new ArrayList();
                if (ListUtils.getCount(list) > 0) {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ForumInfo forumInfo = list.get(i3);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !this.a.k0(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                    }
                    if (this.a.n == null) {
                        this.a.n = arrayList;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.q = new b(this);
        V(this.p);
        this.o = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        n0(i2, view, viewGroup, cVar, transmitSelectViewHolder);
        return view;
    }

    public void i0() {
        c.a.t0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.e();
    }

    public HotTopicBussinessData j0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (ListUtils.isEmpty(this.n)) {
                return null;
            }
            return this.n.remove(i2);
        }
        return (HotTopicBussinessData) invokeI.objValue;
    }

    public final boolean k0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            List<TransmitForumData> list = this.o;
            if (list == null) {
                return false;
            }
            for (TransmitForumData transmitForumData : list) {
                if (transmitForumData != null && transmitForumData.forumId == j2) {
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
            HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.f3360e, 25005, this.n);
            hotTopicChangeActivityConfig.setUseOriginList(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicChangeActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: m0 */
    public TransmitSelectViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) ? new TransmitSelectViewHolder(LayoutInflater.from(this.f3360e).inflate(h.transmit_select_layout, (ViewGroup) null)) : (TransmitSelectViewHolder) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, transmitSelectViewHolder})) == null) {
            SkinManager.setViewTextColor(transmitSelectViewHolder.mSelectBySelf, d.CAM_X0302);
            SkinManager.setImageResource(transmitSelectViewHolder.mAddIcon, f.icon_post_add_ba_n);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
