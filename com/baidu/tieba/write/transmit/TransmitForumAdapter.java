package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import b.a.e.l.e.n;
import b.a.e.l.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TransmitForumAdapter extends b.a.e.l.e.a<TransmitForumData, TransmitForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.d4.q.a m;
    public w n;

    /* loaded from: classes9.dex */
    public static class TransmitForumViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView mForumName;
        public CheckBox mSelected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransmitForumViewHolder(View view) {
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
            this.mForumName = (TextView) view.findViewById(R.id.transmit_forum_name);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.mSelected = checkBox;
            checkBox.setButtonDrawable(SkinManager.getDrawable(R.drawable.transmit_check_box));
        }
    }

    /* loaded from: classes9.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitForumAdapter f55847e;

        public a(TransmitForumAdapter transmitForumAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55847e = transmitForumAdapter;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof TransmitForumData)) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                boolean isChecked = checkBox.isChecked();
                boolean c2 = this.f55847e.m != null ? this.f55847e.m.c() : false;
                if (!isChecked && c2) {
                    this.f55847e.m.b();
                }
                if (isChecked || !c2) {
                    checkBox.setChecked(!checkBox.isChecked());
                    ((TransmitForumData) nVar).checked = checkBox.isChecked();
                    if (this.f55847e.m != null) {
                        this.f55847e.m.a();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransmitForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.n = aVar;
        c0(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        i0(i2, view, viewGroup, transmitForumData, transmitForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public TransmitForumViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new TransmitForumViewHolder(LayoutInflater.from(this.f2419e).inflate(R.layout.transmit_forum_layout, (ViewGroup) null)) : (TransmitForumViewHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, transmitForumData, transmitForumViewHolder})) == null) {
            transmitForumViewHolder.mForumName.setText(transmitForumData.forumName);
            transmitForumViewHolder.mSelected.setChecked(transmitForumData.checked);
            SkinManager.setViewTextColor(transmitForumViewHolder.mForumName, R.color.CAM_X0105);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(b.a.r0.d4.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.m = aVar;
        }
    }
}
