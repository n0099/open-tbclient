package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends BaseAdapter implements com.baidu.tieba.view.an {
    private final Context b;
    private at c;
    private com.baidu.tieba.util.i d;
    private String e = null;
    View.OnClickListener a = new j(this);

    public i(Context context) {
        this.b = context;
        this.d = new com.baidu.tieba.util.i(context);
        int a = com.baidu.adp.lib.h.g.a(context, 45.0f);
        this.d.a(a, a);
    }

    public void a(at atVar) {
        this.c = atVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c.d().size() == 0) {
            return 0;
        }
        ArrayList<as> d = this.c.d();
        if (d == null || d.size() <= 0) {
            return 1;
        }
        return 1 + d.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View findViewById;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
            com.baidu.tieba.util.bu.b(view);
        }
        if (itemViewType == 0) {
            if (this.c != null) {
                ((TextView) view.findViewById(R.id.title)).setText(this.c.e());
            }
        } else if (itemViewType == 2) {
            com.baidu.tieba.util.bu.a(view);
            a(viewGroup, (n) view.getTag(), i, "all");
        } else if (itemViewType == 1) {
            com.baidu.tieba.util.bu.a(view);
            a(viewGroup, (n) view.getTag(), i, "normal");
        }
        int an = TiebaApplication.g().an();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.a().a(an == 1);
        baseFragmentActivity.a().a(view);
        if (itemViewType == 0) {
            View findViewById2 = view.findViewById(R.id.post_recommend_line_up);
            View findViewById3 = view.findViewById(R.id.post_recommend_line_down);
            if (findViewById2 != null && findViewById3 != null) {
                if (an == 1) {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line_1));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line_1));
                } else {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line));
                }
            }
        } else if (itemViewType == 1 && (findViewById = view.findViewById(R.id.bar_folder_item_bottom_line)) != null) {
            if (an == 1) {
                findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line_1));
            } else {
                findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.square_dividing_line));
            }
        }
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i2 == 0) {
            return from.inflate(R.layout.bar_home_header, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = from.inflate(R.layout.bar_home_all_dir_item, (ViewGroup) null);
            as asVar = new as();
            asVar.f = SocialConstants.TRUE;
            n nVar = new n();
            nVar.a = (HeadImageView) inflate.findViewById(R.id.portrait);
            nVar.b = (TextView) inflate.findViewById(R.id.squre_name);
            nVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
            nVar.d = asVar;
            inflate.setOnClickListener(this.a);
            inflate.setTag(nVar);
            return inflate;
        }
        View inflate2 = from.inflate(R.layout.bar_home_first_dir_item, (ViewGroup) null);
        inflate2.setOnClickListener(this.a);
        as asVar2 = new as();
        asVar2.f = SocialConstants.FALSE;
        n nVar2 = new n();
        nVar2.a = (HeadImageView) inflate2.findViewById(R.id.portrait);
        nVar2.b = (TextView) inflate2.findViewById(R.id.squre_name);
        nVar2.c = (BestStringsFitTextView) inflate2.findViewById(R.id.description);
        nVar2.d = asVar2;
        inflate2.setTag(nVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, n nVar, int i, String str) {
        as asVar = this.c.d().get(i - 1);
        asVar.a = i - 1;
        if (asVar.f.equals(SocialConstants.TRUE) && str.equals("all")) {
            a(viewGroup, nVar, asVar);
        } else if (asVar.f.equals(SocialConstants.FALSE) && str.equals("normal")) {
            a(viewGroup, nVar, asVar);
        }
    }

    private void a(ViewGroup viewGroup, n nVar, as asVar) {
        nVar.d = asVar;
        nVar.b.setText(UtilHelper.a(asVar.b, 11));
        if (asVar.c != null) {
            nVar.c.setText(asVar.c);
            nVar.c.setVisibility(0);
        } else {
            nVar.c.setVisibility(8);
        }
        if (asVar.e != null) {
            nVar.a.setTag(asVar.e);
            com.baidu.adp.widget.ImageView.d d = this.d.d(asVar.e);
            if (d != null) {
                nVar.a.setImageBitmap(d.h());
                nVar.a.invalidate();
                return;
            }
            this.d.a(asVar.e, new k(this, viewGroup));
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == getCount() - 1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public Context a() {
        return this.b;
    }

    @Override // com.baidu.tieba.view.an
    public void d() {
        this.d.d();
    }

    @Override // com.baidu.tieba.view.an
    public void a(View view, int i, int i2) {
        while (i <= i2) {
            if (getItemViewType(i) == 1) {
                this.d.a();
                as asVar = this.c.d().get(i - 1);
                if (asVar.e != null && this.d.d(asVar.e) == null) {
                    this.d.a(asVar.e, new m(this, view));
                }
            }
            i++;
        }
    }
}
