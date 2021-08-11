package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.e.k.e.w;
import c.a.p0.b4.q.c;
import c.a.p0.q1.a;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes7.dex */
public class TransmitSelectAdapter extends c.a.e.k.e.a<c, TransmitSelectViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.q1.a m;
    public ArrayList<HotTopicBussinessData> n;
    public List<TransmitForumData> o;
    public w p;
    public a.b q;

    /* loaded from: classes7.dex */
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
            this.mSelectBySelf = (TextView) view.findViewById(R.id.select_by_self);
            this.mAddIcon = (ImageView) view.findViewById(R.id.add_icon);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitSelectAdapter f58438e;

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
            this.f58438e = transmitSelectAdapter;
        }

        @Override // c.a.e.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (!j.z()) {
                    l.L(this.f58438e.f2904e, R.string.neterror);
                }
                TiebaStatic.log(new StatisticItem("c12053"));
                if (!ListUtils.isEmpty(this.f58438e.n)) {
                    this.f58438e.t0();
                    return;
                }
                TransmitSelectAdapter transmitSelectAdapter = this.f58438e;
                transmitSelectAdapter.m = new c.a.p0.q1.a(transmitSelectAdapter.f2908i);
                this.f58438e.m.g(this.f58438e.q);
                this.f58438e.m.f();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitSelectAdapter f58439a;

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
            this.f58439a = transmitSelectAdapter;
        }

        @Override // c.a.p0.q1.a.b
        public void a(boolean z, int i2, String str, List<ForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, list}) == null) {
                ArrayList arrayList = new ArrayList();
                if (ListUtils.getCount(list) > 0) {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ForumInfo forumInfo = list.get(i3);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !this.f58439a.s0(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                    }
                    if (this.f58439a.n == null) {
                        this.f58439a.n = arrayList;
                        this.f58439a.t0();
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
        d0(this.p);
        this.o = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.k.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        v0(i2, view, viewGroup, cVar, transmitSelectViewHolder);
        return view;
    }

    public void q0() {
        c.a.p0.q1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.e();
    }

    public HotTopicBussinessData r0(int i2) {
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

    public final boolean s0(long j2) {
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

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.f2904e, 25005, this.n);
            hotTopicChangeActivityConfig.setUseOriginList(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicChangeActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: u0 */
    public TransmitSelectViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) ? new TransmitSelectViewHolder(LayoutInflater.from(this.f2904e).inflate(R.layout.transmit_select_layout, (ViewGroup) null)) : (TransmitSelectViewHolder) invokeL.objValue;
    }

    public View v0(int i2, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, transmitSelectViewHolder})) == null) {
            SkinManager.setViewTextColor(transmitSelectViewHolder.mSelectBySelf, R.color.CAM_X0302);
            SkinManager.setImageResource(transmitSelectViewHolder.mAddIcon, R.drawable.icon_post_add_ba_n);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
