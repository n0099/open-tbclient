package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yl7 extends fi7<vga, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;
    public boolean m;

    /* loaded from: classes8.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public View c;
        public TextView d;
        public View e;
        public View f;
        public TextView g;
        public View h;
        public View i;
        public View j;
        public List<View> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
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
            this.k = new ArrayList();
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c93);
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090c95);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090d3c);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d3a);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090d1b);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090c70);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c71);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f0919f4);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f0919f5);
            this.j = view2.findViewById(R.id.obfuscated_res_0x7f0919f3);
            this.k.add(this.h);
            this.k.add(this.i);
            this.k.add(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yl7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
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
        this.l = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.m = z;
    }

    public final void G(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            List<View> list = aVar.k;
            for (View view2 : list) {
                view2.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: H */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            return new a(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d035b, (ViewGroup) null));
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: I */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vga vgaVar, a aVar) {
        InterceptResult invokeCommon;
        boolean z;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vgaVar, aVar})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) vgaVar, (vga) aVar);
            boolean z2 = true;
            if (vgaVar.e()) {
                String c = vgaVar.c();
                if (c != null) {
                    aVar.b.setText(c);
                } else {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null && this.b.getForum().getName() != null) {
                        TextView textView = aVar.b;
                        Context context = this.mContext;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.b;
                        if (frsViewData2 == null) {
                            name = "";
                        } else {
                            name = frsViewData2.getForum().getName();
                        }
                        objArr[0] = name;
                        textView.setText(context.getString(R.string.obfuscated_res_0x7f0f08e2, objArr));
                    }
                }
                aVar.a.setTag(Integer.valueOf(i));
                aVar.a.setOnClickListener(this);
                aVar.a.setVisibility(0);
            } else {
                aVar.a.setVisibility(8);
                aVar.h.setVisibility(8);
            }
            pga d = vgaVar.d();
            if (d != null && d.b() && !TextUtils.isEmpty(d.a())) {
                aVar.d.setText(d.a());
                aVar.c.setTag(Integer.valueOf(i));
                aVar.c.setOnClickListener(this);
                aVar.c.setVisibility(0);
            } else {
                aVar.c.setVisibility(8);
                aVar.i.setVisibility(8);
            }
            if (this.m) {
                aVar.e.setVisibility(0);
            } else {
                aVar.e.setVisibility(8);
            }
            BDLayoutMode layoutMode = this.c.getLayoutMode();
            if (this.f == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.c.getLayoutMode().onModeChanged(view2);
            FrsViewData frsViewData3 = this.b;
            z2 = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.b.getUserData().isBawu()) ? false : false;
            if (z2) {
                aVar.f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f, R.drawable.frs_top_item_bg);
                aVar.e.setVisibility(0);
                aVar.f.setOnClickListener(this);
                aVar.f.setTag(Integer.valueOf(i));
            } else {
                aVar.f.setVisibility(8);
                aVar.j.setVisibility(8);
            }
            if (!this.l && !vgaVar.e()) {
                if (z2) {
                    aVar.a.setVisibility(8);
                    aVar.c.setVisibility(8);
                    G(aVar);
                    return view2;
                }
                return new View(this.mContext);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.d != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            if (!(getItem(intValue) instanceof ThreadData)) {
                return;
            }
            ThreadData threadData = (ThreadData) getItem(intValue);
            this.d.a(id, intValue, view2, s(this.e.getListView(), intValue), threadData);
        }
    }
}
