package com.baidu.ufosdk.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class dq implements AdapterView.OnItemLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f59469a;

    public dq(FeedbackListActivity feedbackListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59469a = feedbackListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        List list;
        List list2;
        View a2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        PopupWindow popupWindow4;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            list = this.f59469a.f59305e;
            list2 = this.f59469a.f59305e;
            FeedbackListActivity feedbackListActivity = this.f59469a;
            a2 = feedbackListActivity.a(feedbackListActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("3"), (String) ((Map) list.get(i2)).get("id"), (String) ((Map) list2.get(i2)).get("appid"));
            this.f59469a.z = new PopupWindow(a2, com.baidu.ufosdk.f.i.a(this.f59469a.getApplicationContext(), 79.0f), com.baidu.ufosdk.f.i.a(this.f59469a.getApplicationContext(), 68.0f));
            popupWindow = this.f59469a.z;
            popupWindow.setFocusable(false);
            popupWindow2 = this.f59469a.z;
            popupWindow2.setOutsideTouchable(true);
            popupWindow3 = this.f59469a.z;
            popupWindow3.setBackgroundDrawable(new BitmapDrawable());
            a2.getLocationOnScreen(new int[2]);
            popupWindow4 = this.f59469a.z;
            relativeLayout = this.f59469a.f59301a;
            popupWindow4.showAtLocation(relativeLayout, 17, 0, 0);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
