package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1813a;
    private ComputerLLinearLayout b;
    private LinearLayout c;
    private ImageView d;
    private ImageView e;
    private PopupWindow f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private al j;
    private List k;
    private ao l;
    private int m;

    public View getAddButton() {
        return this.c;
    }

    public void setSelectInterestItemClickListener(ao aoVar) {
        this.l = aoVar;
    }

    public void setInterests(List list) {
        this.k = list;
        if (list != null && this.j != null) {
            this.j.notifyDataSetChanged();
        }
    }

    public void setInitSelectTagName(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f1813a.getResources().getString(R.string.interest_all);
        }
        this.g.setText(str);
    }

    public ai(Context context) {
        super(context);
        this.k = new ArrayList();
        this.f1813a = context;
        a();
    }

    public void a(int i) {
        this.m = i;
        if (i == 1) {
            this.b.setBackgroundResource(R.drawable.icon_allinterest_button_bg_night);
            this.g.setTextColor(this.f1813a.getResources().getColor(R.color.c_7b8591));
            this.h.setTextColor(this.f1813a.getResources().getColor(R.color.c_7b8591));
            this.e.setImageResource(R.drawable.ico_jiahao_gray_1);
            this.c.setBackgroundResource(R.drawable.icon_addinterest_button_bg_night);
            this.d.setBackgroundResource(R.drawable.icon_arrow_down_list_down_1);
            return;
        }
        this.b.setBackgroundResource(R.drawable.icon_allinterest_button_bg_day);
        this.g.setTextColor(this.f1813a.getResources().getColor(R.color.c_262626));
        this.h.setTextColor(this.f1813a.getResources().getColor(R.color.c_262626));
        this.e.setImageResource(R.drawable.ico_jiahao_gray);
        this.c.setBackgroundResource(R.drawable.icon_addinterest_button_bg_day);
        this.d.setBackgroundResource(R.drawable.icon_arrow_down_list_down);
    }

    private void a() {
        View inflate = LayoutInflater.from(this.f1813a).inflate(R.layout.interest_handle_view, (ViewGroup) null);
        addView(inflate);
        this.b = (ComputerLLinearLayout) inflate.findViewById(R.id.interest_select);
        this.c = (LinearLayout) inflate.findViewById(R.id.interest_add);
        this.d = (ImageView) inflate.findViewById(R.id.interest_select_sign);
        this.e = (ImageView) inflate.findViewById(R.id.interest_add_sign);
        this.g = (TextView) inflate.findViewById(R.id.interest_select_text);
        this.h = (TextView) inflate.findViewById(R.id.interest_add_text);
        this.b.setOnClickListener(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View b() {
        View inflate = LayoutInflater.from(this.f1813a).inflate(R.layout.allinterest_list, (ViewGroup) null);
        this.i = (ImageView) inflate.findViewById(R.id.list_head);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.leftMargin = this.b.f1787a;
        this.i.setLayoutParams(layoutParams);
        ListView listView = (ListView) inflate.findViewById(R.id.interest_list);
        this.j = new al(this, null);
        listView.setAdapter((ListAdapter) this.j);
        if (this.m == 1) {
            listView.setBackgroundResource(R.drawable.pg_list_down_black_1);
            listView.setDivider(new BitmapDrawable(BitmapFactory.decodeResource(this.f1813a.getResources(), R.drawable.ling_bown_list_1)));
            this.i.setImageResource(R.drawable.pg_list_down_black_arrow_1);
        } else {
            listView.setBackgroundResource(R.drawable.pg_list_down_black);
            listView.setDivider(new BitmapDrawable(BitmapFactory.decodeResource(this.f1813a.getResources(), R.drawable.ling_bown_list)));
            this.i.setImageResource(R.drawable.pg_list_down_black_arrow);
        }
        return inflate;
    }
}
