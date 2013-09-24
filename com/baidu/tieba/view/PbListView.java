package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f1961a;
    private TextView b;
    private ProgressBar c;
    private ImageView d;
    private View.OnClickListener e;
    private View f;
    private String g;
    private LinearLayout h;
    private IconType i;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public PbListView(Context context) {
        this.f1961a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = IconType.ICON_DOWN_WARD;
        this.f1961a = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
        this.i = iconType;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.f = LayoutInflater.from(this.f1961a).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.h = (LinearLayout) this.f.findViewById(R.id.pb_more_view);
        this.b = (TextView) this.f.findViewById(R.id.pb_more_text);
        this.d = (ImageView) this.f.findViewById(R.id.image);
        this.c = (ProgressBar) this.f.findViewById(R.id.progress);
        return this.f;
    }

    public void c() {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.b.setText(this.f1961a.getText(R.string.loading));
    }

    public void d() {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (this.g != null) {
            this.b.setText(this.g);
        } else {
            this.b.setText(this.f1961a.getText(R.string.load_more));
        }
    }

    public void a(String str) {
        this.g = str;
        this.b.setText(str);
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }

    public void a(int i) {
        if (this.f != null) {
            if (i == 1) {
                com.baidu.tieba.util.as.e(this.h, (int) R.drawable.bg_list_all_1);
                if (this.i == IconType.ICON_DOWN_WARD) {
                    this.d.setBackgroundResource(R.drawable.ico_downward_1);
                    return;
                } else {
                    this.d.setBackgroundResource(R.drawable.ico_upward_1);
                    return;
                }
            }
            com.baidu.tieba.util.as.e(this.h, (int) R.drawable.bg_list_all);
            if (this.i == IconType.ICON_DOWN_WARD) {
                this.d.setBackgroundResource(R.drawable.ico_downward);
            } else {
                this.d.setBackgroundResource(R.drawable.ico_upward);
            }
        }
    }
}
