package com.baidu.ufosdk.ui;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes8.dex */
public final class fd extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f59556a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f59557b;

    /* renamed from: c  reason: collision with root package name */
    public int f59558c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59559d;

    public fd(Context context, JSONArray jSONArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59559d = false;
        this.f59556a = context;
        this.f59557b = jSONArray;
        this.f59558c = i2;
        this.f59559d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            try {
                return ((JSONObject) this.f59557b.get(i2)).getString("name");
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59557b.length() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        LinearLayout linearLayout;
        fe feVar;
        JSONObject jSONObject;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                feVar = new fe();
                LinearLayout linearLayout2 = new LinearLayout(this.f59556a);
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                TextView textView3 = new TextView(this.f59556a);
                textView3.setTextColor(-16777216);
                textView3.setTextSize(com.baidu.ufosdk.b.R);
                textView3.setGravity(16);
                textView3.setSingleLine(true);
                textView3.setEllipsize(TextUtils.TruncateAt.END);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f59556a, 10.0f), com.baidu.ufosdk.f.i.a(this.f59556a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f59556a, 5.0f));
                linearLayout2.addView(textView3, layoutParams);
                feVar.f59560a = textView3;
                linearLayout2.setTag(feVar);
                linearLayout = linearLayout2;
            } else {
                linearLayout = view;
                feVar = (fe) view.getTag();
            }
            try {
                jSONObject = (JSONObject) this.f59557b.get(i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                feVar.f59560a.setText("");
            }
            if (this.f59558c == 0) {
                feVar.f59560a.setText(jSONObject.getString("question"));
                feVar.f59560a.setSingleLine(true);
                if (this.f59559d) {
                    textView2 = feVar.f59560a;
                    textView2.setTextColor(-13421773);
                    return linearLayout;
                }
                textView = feVar.f59560a;
                textView.setTextColor(-12814593);
                return linearLayout;
            }
            feVar.f59560a.setText(jSONObject.getString("name"));
            feVar.f59560a.setSingleLine(true);
            if (this.f59559d) {
                textView2 = feVar.f59560a;
                textView2.setTextColor(-13421773);
                return linearLayout;
            }
            textView = feVar.f59560a;
            textView.setTextColor(-12814593);
            return linearLayout;
        }
        return (View) invokeILL.objValue;
    }
}
