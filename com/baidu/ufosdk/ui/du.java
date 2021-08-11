package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.widget.ConfirmDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class du extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f59477a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59478b;

    public du(FeedbackListActivity feedbackListActivity, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackListActivity, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59477a = feedbackListActivity;
        this.f59478b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        InterceptResult invokeV;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            list = this.f59477a.f59305e;
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x02dd  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        dt dtVar;
        RelativeLayout relativeLayout;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        TextView textView;
        StringBuilder sb;
        List list7;
        TextView textView2;
        BitmapDrawable bitmapDrawable;
        List list8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dtVar = new dt(this.f59477a);
                RelativeLayout relativeLayout2 = new RelativeLayout(this.f59478b);
                relativeLayout2.setBackgroundDrawable(null);
                relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 80.0f)));
                TextView textView3 = new TextView(this.f59478b);
                textView3.setId(2132344840);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 6.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 6.0f));
                layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 15.0f), 0, 0);
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                relativeLayout2.addView(textView3, layoutParams);
                TextView textView4 = new TextView(this.f59478b);
                textView4.setId(2132344842);
                textView4.setTextColor(-13421773);
                textView4.setLineSpacing(4.0f, 1.0f);
                textView4.setMaxLines(1);
                textView4.setEllipsize(TextUtils.TruncateAt.END);
                textView4.setTextSize(14.0f);
                textView4.setPadding(0, 0, 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 60.0f), 0);
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
                relativeLayout2.addView(textView4, layoutParams2);
                TextView textView5 = new TextView(this.f59478b);
                textView5.setTextSize(11.0f);
                textView5.setTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(0, com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 9.0f), 0);
                layoutParams3.addRule(10);
                layoutParams3.addRule(11);
                relativeLayout2.addView(textView5, layoutParams3);
                TextView textView6 = new TextView(this.f59478b);
                textView6.setId(2132344843);
                textView6.setTextSize(12.0f);
                textView6.setLines(1);
                textView6.setGravity(16);
                textView6.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                textView6.setTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
                textView6.setPadding(0, 0, 0, 0);
                layoutParams4.addRule(9);
                layoutParams4.addRule(3, textView4.getId());
                layoutParams4.setMargins(com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 60.0f), com.baidu.ufosdk.f.i.a(this.f59477a.getApplicationContext(), 0.0f));
                relativeLayout2.addView(textView6, layoutParams4);
                Context applicationContext = this.f59477a.getApplicationContext();
                int i3 = com.baidu.ufosdk.b.D;
                StateListDrawable stateListDrawable = new StateListDrawable();
                ColorDrawable colorDrawable = new ColorDrawable(i3);
                stateListDrawable.addState(new int[]{16842919}, new BitmapDrawable(com.baidu.ufosdk.f.m.a(applicationContext, "ufo_list_press.png")));
                stateListDrawable.addState(new int[0], colorDrawable);
                relativeLayout2.setBackgroundDrawable(stateListDrawable);
                dtVar.f59472a = textView4;
                dtVar.f59473b = textView3;
                dtVar.f59474c = textView5;
                dtVar.f59475d = textView6;
                relativeLayout2.setTag(dtVar);
                relativeLayout = relativeLayout2;
            } else {
                dtVar = (dt) view.getTag();
                relativeLayout = view;
            }
            TextView textView7 = dtVar.f59472a;
            list = this.f59477a.f59305e;
            textView7.setText((String) ((Map) list.get(i2)).get("content"));
            TextView textView8 = dtVar.f59474c;
            list2 = this.f59477a.f59305e;
            textView8.setText(FeedbackListActivity.a((String) ((Map) list2.get(i2)).get("time")));
            list3 = this.f59477a.f59305e;
            if (((String) ((Map) list3.get(i2)).get("replied")).equals("1")) {
                textView = dtVar.f59475d;
                sb = new StringBuilder("[已回复] ");
            } else {
                list4 = this.f59477a.f59305e;
                if (((String) ((Map) list4.get(i2)).get("replied")).equals("0")) {
                    textView = dtVar.f59475d;
                    sb = new StringBuilder("[待回复] ");
                } else {
                    list5 = this.f59477a.f59305e;
                    if (!((String) ((Map) list5.get(i2)).get("replied")).equals("2")) {
                        list6 = this.f59477a.f59305e;
                        if (((String) ((Map) list6.get(i2)).get("replied")).equals("3")) {
                            textView = dtVar.f59475d;
                            sb = new StringBuilder("[已评价] ");
                        }
                        list7 = this.f59477a.f59305e;
                        if (((String) ((Map) list7.get(i2)).get("newmsg")).equals("0")) {
                            textView2 = dtVar.f59473b;
                            bitmapDrawable = new BitmapDrawable(FeedbackListActivity.o(this.f59477a));
                        } else {
                            textView2 = dtVar.f59473b;
                            bitmapDrawable = null;
                        }
                        textView2.setBackgroundDrawable(bitmapDrawable);
                        return relativeLayout;
                    }
                    textView = dtVar.f59475d;
                    sb = new StringBuilder("[邀请评价] ");
                }
            }
            list8 = this.f59477a.f59305e;
            sb.append((String) ((Map) list8.get(i2)).get("lastmsg"));
            textView.setText(sb.toString());
            list7 = this.f59477a.f59305e;
            if (((String) ((Map) list7.get(i2)).get("newmsg")).equals("0")) {
            }
            textView2.setBackgroundDrawable(bitmapDrawable);
            return relativeLayout;
        }
        return (View) invokeILL.objValue;
    }
}
