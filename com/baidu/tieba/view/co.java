package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class co extends com.baidu.adp.widget.ListView.c {
    private Context a;
    private TextView b = null;
    private ProgressBar c = null;
    private ImageView d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private int g = 0;

    public co(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.f = LayoutInflater.from(this.a).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
        this.b = (TextView) this.f.findViewById(R.id.sub_pb_more_text);
        this.d = (ImageView) this.f.findViewById(R.id.image);
        if (TiebaApplication.g().al() == 1) {
            this.d.setBackgroundResource(R.drawable.icon_downward_1);
        } else {
            this.d.setBackgroundResource(R.drawable.icon_downward);
        }
        this.c = (ProgressBar) this.f.findViewById(R.id.progress);
        return this.f;
    }

    public void c() {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.b.setText(this.a.getText(R.string.loading));
        e();
    }

    public void a(int i) {
        this.g = i;
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (i > 0) {
            com.baidu.tieba.pb.cd.a(this.a, this.b, i);
        } else {
            this.b.setText(this.a.getText(R.string.load_more));
        }
        e();
    }

    public void d() {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (this.g > 0) {
            com.baidu.tieba.pb.cd.a(this.a, this.b, this.g);
        } else {
            this.b.setText(this.a.getText(R.string.load_more));
        }
        e();
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    protected void b(int i) {
        this.b.setTextColor(this.a.getResources().getColor(i));
    }

    public void e() {
        boolean z = TiebaApplication.g().al() == 1;
        String charSequence = this.b.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            if (charSequence.equals(this.a.getString(R.string.loading))) {
                b(z ? R.color.pb_more_txt_1 : R.color.pb_more_txt);
            } else {
                b(z ? R.color.sub_pb_more_text_1 : R.color.sub_pb_more_text);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
