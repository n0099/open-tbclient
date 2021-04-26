package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i0.z0.v;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsPraiseView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21582e;

    /* renamed from: f  reason: collision with root package name */
    public View f21583f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21584g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21585h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21586i;
    public PraiseData j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.b(new PraiseListActivityConfig(FrsPraiseView.this.f21582e, FrsPraiseView.this.k, FrsPraiseView.this.l, FrsPraiseView.this.j != null ? FrsPraiseView.this.j.getTitle() : "", FrsPraiseView.this.m));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData = FrsPraiseView.this.j.getUser().get(1);
            if (metaData == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.f21582e).createNormalConfig(d.a.c.e.m.b.f(metaData.getUserId(), 0L), false, metaData.isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData = FrsPraiseView.this.j.getUser().get(0);
            if (metaData == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.f21582e).createNormalConfig(d.a.c.e.m.b.f(metaData.getUserId(), 0L), false, metaData.isBigV())));
        }
    }

    public FrsPraiseView(Context context) {
        super(context, null);
        this.m = false;
        this.n = false;
    }

    public final void f(boolean z) {
        long num = this.j.getNum();
        this.f21586i.setVisibility(8);
        this.f21585h.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.j.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.f21585h.setVisibility(0);
                        this.f21585h.setText(g(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.f21585h.setVisibility(0);
                        this.f21585h.setText(g(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.f21586i.setVisibility(0);
                        TextView textView = this.f21586i;
                        textView.setText("、" + g(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.f21584g.setText(this.f21582e.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                TextView textView2 = this.f21584g;
                textView2.setText(this.f21582e.getString(R.string.etc) + num + this.f21582e.getString(R.string.common_praise_view_text2));
            } else {
                TextView textView3 = this.f21584g;
                textView3.setText(this.f21582e.getString(R.string.etc) + "999999+" + this.f21582e.getString(R.string.common_praise_view_text2));
            }
        }
    }

    public final String g(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 14) ? str : str.substring(0, 14);
    }

    public final void h() {
        View inflate = View.inflate(this.f21582e, R.layout.frs_item_praise, this);
        this.f21583f = inflate;
        this.f21584g = (TextView) inflate.findViewById(R.id.frs_go_praise_list_num);
        this.f21585h = (TextView) this.f21583f.findViewById(R.id.frs_praise_user_name_text1);
        this.f21586i = (TextView) this.f21583f.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new a());
        this.f21586i.setOnClickListener(new b());
        this.f21585h.setOnClickListener(new c());
    }

    public void i(int i2) {
        if (this.m) {
            if (this.n) {
                SkinManager.setBackgroundResource(this.f21583f, R.drawable.praise_video_selector);
                SkinManager.setViewTextColor(this.f21584g, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(this.f21585h, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(this.f21586i, R.color.CAM_X0304, 1);
                return;
            }
            SkinManager.setBackgroundResource(this.f21583f, R.drawable.praise_head_selector);
            SkinManager.setViewTextColor(this.f21584g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.f21585h, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f21586i, R.color.CAM_X0304, 1);
            return;
        }
        SkinManager.setBackgroundResource(this.f21583f, R.drawable.praise_view_btn_color);
        SkinManager.setViewTextColor(this.f21584g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f21585h, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f21586i, R.color.CAM_X0108, 1);
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData == null) {
            return;
        }
        this.k = str;
        this.l = str2;
        this.j = praiseData;
        f(z);
    }

    public void setIsFromPb(boolean z) {
        this.m = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.n = z;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = false;
        this.n = false;
        setOrientation(0);
        this.f21582e = context;
        h();
    }
}
