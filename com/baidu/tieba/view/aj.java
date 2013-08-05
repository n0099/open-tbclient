package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f1816a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.f1816a = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        int i;
        ImageView imageView;
        ImageView imageView2;
        int i2;
        ImageView imageView3;
        ImageView imageView4;
        List list2;
        View b;
        ComputerLLinearLayout computerLLinearLayout;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        ComputerLLinearLayout computerLLinearLayout2;
        Context context;
        PopupWindow popupWindow3;
        int i3;
        ImageView imageView5;
        ImageView imageView6;
        list = this.f1816a.k;
        if (list != null) {
            list2 = this.f1816a.k;
            if (list2.size() != 0) {
                b = this.f1816a.b();
                ai aiVar = this.f1816a;
                computerLLinearLayout = this.f1816a.b;
                aiVar.f = new PopupWindow(b, computerLLinearLayout.getWidth(), -2, true);
                popupWindow = this.f1816a.f;
                popupWindow.setBackgroundDrawable(new ColorDrawable(17170445));
                popupWindow2 = this.f1816a.f;
                computerLLinearLayout2 = this.f1816a.b;
                context = this.f1816a.f1815a;
                popupWindow2.showAsDropDown(computerLLinearLayout2, 0, com.baidu.tieba.util.am.a(context, -5.0f));
                popupWindow3 = this.f1816a.f;
                popupWindow3.setOnDismissListener(new ak(this));
                i3 = this.f1816a.m;
                if (i3 == 1) {
                    imageView6 = this.f1816a.d;
                    imageView6.setBackgroundResource(R.drawable.icon_arrow_down_list_up_1);
                    return;
                }
                imageView5 = this.f1816a.d;
                imageView5.setBackgroundResource(R.drawable.icon_arrow_down_list_up);
                return;
            }
        }
        if (!this.b) {
            i2 = this.f1816a.m;
            if (i2 == 1) {
                imageView4 = this.f1816a.d;
                imageView4.setBackgroundResource(R.drawable.icon_arrow_down_list_up_1);
            } else {
                imageView3 = this.f1816a.d;
                imageView3.setBackgroundResource(R.drawable.icon_arrow_down_list_up);
            }
        } else {
            i = this.f1816a.m;
            if (i == 1) {
                imageView2 = this.f1816a.d;
                imageView2.setBackgroundResource(R.drawable.icon_arrow_down_list_down_1);
            } else {
                imageView = this.f1816a.d;
                imageView.setBackgroundResource(R.drawable.icon_arrow_down_list_down);
            }
        }
        this.b = this.b ? false : true;
    }
}
