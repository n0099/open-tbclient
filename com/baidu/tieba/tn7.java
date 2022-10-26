package com.baidu.tieba;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class tn7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public MemberTaskCenterActivity b;
    public View.OnClickListener c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public View d;

        public a(tn7 tn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public tn7(MemberTaskCenterActivity memberTaskCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = memberTaskCenterActivity;
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public qn7 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List list = this.a;
            if (list != null && list.size() > i) {
                return (qn7) this.a.get(i);
            }
            return null;
        }
        return (qn7) invokeI.objValue;
    }

    public void c(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.clear();
            if (list != null) {
                this.a.addAll(list);
            }
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.b.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0584, (ViewGroup) null);
                aVar = new a(this);
                aVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920ce);
                aVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920cf);
                aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920d0);
                aVar.d = view2.findViewById(R.id.divider_line);
            }
            qn7 item = getItem(i);
            if (item != null) {
                aVar.a.setText(item.f());
                aVar.b.setText(a(String.valueOf(item.a()), item.b()));
                if (item.d()) {
                    aVar.c.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f090b), TextView.BufferType.EDITABLE);
                    aVar.c.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    aVar.c.setBackgroundDrawable(null);
                    aVar.c.setOnClickListener(null);
                } else {
                    aVar.c.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f04a1), TextView.BufferType.EDITABLE);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.member_center_task_btn_textcolor);
                    aVar.c.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
                    aVar.c.setTag(item);
                    aVar.c.setOnClickListener(this.c);
                }
                SkinManager.setViewTextColor(aVar.b, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(aVar.a, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor(aVar.d, R.color.CAM_X0204);
            }
            view2.setTag(aVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
