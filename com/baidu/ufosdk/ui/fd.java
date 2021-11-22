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
/* loaded from: classes9.dex */
public final class fd extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f57939a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f57940b;

    /* renamed from: c  reason: collision with root package name */
    public int f57941c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57942d;

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
        this.f57942d = false;
        this.f57939a = context;
        this.f57940b = jSONArray;
        this.f57941c = i2;
        this.f57942d = z;
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
                return ((JSONObject) this.f57940b.get(i2)).getString("name");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57940b.length() : invokeV.intValue;
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
                LinearLayout linearLayout2 = new LinearLayout(this.f57939a);
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                TextView textView3 = new TextView(this.f57939a);
                textView3.setTextColor(-16777216);
                textView3.setTextSize(com.baidu.ufosdk.b.R);
                textView3.setGravity(16);
                textView3.setSingleLine(true);
                textView3.setEllipsize(TextUtils.TruncateAt.END);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f57939a, 10.0f), com.baidu.ufosdk.f.i.a(this.f57939a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f57939a, 5.0f));
                linearLayout2.addView(textView3, layoutParams);
                feVar.f57943a = textView3;
                linearLayout2.setTag(feVar);
                linearLayout = linearLayout2;
            } else {
                linearLayout = view;
                feVar = (fe) view.getTag();
            }
            try {
                jSONObject = (JSONObject) this.f57940b.get(i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                feVar.f57943a.setText("");
            }
            if (this.f57941c == 0) {
                feVar.f57943a.setText(jSONObject.getString("question"));
                feVar.f57943a.setSingleLine(true);
                if (this.f57942d) {
                    textView2 = feVar.f57943a;
                    textView2.setTextColor(-13421773);
                    return linearLayout;
                }
                textView = feVar.f57943a;
                textView.setTextColor(-12814593);
                return linearLayout;
            }
            feVar.f57943a.setText(jSONObject.getString("name"));
            feVar.f57943a.setSingleLine(true);
            if (this.f57942d) {
                textView2 = feVar.f57943a;
                textView2.setTextColor(-13421773);
                return linearLayout;
            }
            textView = feVar.f57943a;
            textView.setTextColor(-12814593);
            return linearLayout;
        }
        return (View) invokeILL.objValue;
    }
}
