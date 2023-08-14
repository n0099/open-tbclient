package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.hottopicselect.HotTopicSelectActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n98 extends BaseExpandableListAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicSelectActivity> a;
    public LayoutInflater b;
    public ExpandableListView c;
    public final List<l98> d;

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) ? i2 : invokeII.longValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i, i2)) == null) {
            return true;
        }
        return invokeII.booleanValue;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TextView b;
        public View c;
        public View d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }
    }

    public n98(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.a = tbPageContext;
        this.b = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(a aVar, View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, aVar, view2, i) == null) && aVar != null && aVar.a != i) {
            SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundResource(aVar.c, R.drawable.hot_select_tag_bg);
            SkinManager.setBackgroundColor(aVar.d, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(aVar.e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(aVar.c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(aVar.b, R.color.CAM_X0105, 1);
            aVar.a = i;
        }
    }

    public final void b(b bVar, View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, view2, i) == null) && bVar != null && bVar.a != i) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(bVar.c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(bVar.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(bVar.b, R.color.CAM_X0109, 1);
            bVar.a = i;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.clear();
            notifyDataSetChanged();
        }
    }

    public List<l98> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.d.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: d */
    public m98 getChild(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (getGroup(i) != null && getGroup(i).b() != null) {
                return getGroup(i).b().get(i2);
            }
            return null;
        }
        return (m98) invokeII.objValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            if (getChildTypeCount() == 2) {
                if (i != 0 && i == 1) {
                    return 2;
                }
            } else if (getChildTypeCount() == 1 && getGroup(i).getType() != 0 && getGroup(i).getType() == 1) {
                return 2;
            }
            return 1;
        }
        return invokeII.intValue;
    }

    public final void h(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048593, this, textView, i) != null) || textView == null) {
            return;
        }
        if (i == 10) {
            textView.setVisibility(0);
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f16c5));
        } else if (i == 11) {
            textView.setVisibility(0);
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f16c4));
        } else {
            textView.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: e */
    public l98 getGroup(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return this.d.get(i);
        }
        return (l98) invokeI.objValue;
    }

    public void g(l98 l98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, l98Var) == null) {
            this.d.add(l98Var);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (getGroup(i) != null && getGroup(i).b() != null) {
                return getGroup(i).b().size();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048596, this, i) != null) || this.c == null) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            if (i2 != i) {
                this.c.collapseGroup(i);
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view2, ViewGroup viewGroup) {
        InterceptResult invokeCommon;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), view2, viewGroup})) == null) {
            m98 child = getChild(i, i2);
            if (view2 != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d0402, (ViewGroup) null);
                aVar = new a();
                aVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fd5);
                aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fd4);
                aVar.d = view2.findViewById(R.id.divider_line_top);
                aVar.e = view2.findViewById(R.id.divider_line_bottom);
                view2.setTag(aVar);
            }
            if (child == null) {
                return view2;
            }
            aVar.b.setText(ov5.a(StringHelper.cutStringWithEllipsisNew(child.b(), 15)));
            h(aVar.c, child.a().intValue());
            a(aVar, view2, TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view2, ViewGroup viewGroup) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), view2, viewGroup})) == null) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
            } else {
                view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d0403, (ViewGroup) null);
                bVar = new b();
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f20);
                bVar.c = view2.findViewById(R.id.obfuscated_res_0x7f090908);
                bVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090eb8);
                view2.setTag(bVar);
                view2.setClickable(false);
            }
            l98 group = getGroup(i);
            if (group == null) {
                return view2;
            }
            bVar.b.setText(StringHelper.cutStringWithSuffix(group.a(), 15, null));
            if (i == 0) {
                bVar.c.setVisibility(0);
                bVar.d.setVisibility(8);
            } else {
                bVar.c.setVisibility(8);
                bVar.d.setVisibility(0);
            }
            b(bVar, view2, TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
