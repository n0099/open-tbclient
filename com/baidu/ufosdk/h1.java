package com.baidu.ufosdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h1 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONArray b;
    public int c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

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
                }
            }
        }
    }

    public h1(Context context, JSONArray jSONArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = jSONArray;
        this.c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.length() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            try {
                return ((JSONObject) this.b.get(i)).getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        LinearLayout linearLayout;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a();
                LinearLayout linearLayout2 = new LinearLayout(this.a);
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a);
                textView.setTextColor(-16777216);
                textView.setTextSize(1, 17.0f);
                textView.setGravity(16);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(p1.a(this.a, 10.0f), p1.a(this.a, 5.0f), 0, p1.a(this.a, 5.0f));
                linearLayout2.addView(textView, layoutParams);
                aVar.a = textView;
                linearLayout2.setTag(aVar);
                linearLayout = linearLayout2;
            } else {
                linearLayout = view2;
                aVar = (a) view2.getTag();
            }
            try {
                JSONObject jSONObject = (JSONObject) this.b.get(i);
                if (this.c == 0) {
                    aVar.a.setText(jSONObject.getString("question"));
                    aVar.a.setTextColor(-12814593);
                } else {
                    aVar.a.setText(jSONObject.getString("name"));
                    aVar.a.setSingleLine(true);
                    aVar.a.setTextColor(-12814593);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                aVar.a.setText("");
            }
            return linearLayout;
        }
        return (View) invokeILL.objValue;
    }
}
