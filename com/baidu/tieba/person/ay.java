package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.PersonPostListData;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class ay extends BaseAdapter {
    private PersonPostListData a;
    private Context b;
    private az c;
    private com.baidu.tieba.util.i e;
    private int f;
    private com.baidu.tieba.model.bp k;
    private LinearLayout l;
    private ImageView m;
    private TextView n;
    private boolean d = false;
    private int g = 200;
    private boolean h = false;
    private float i = 0.4f;
    private boolean j = false;

    public void a(PersonPostListData personPostListData, com.baidu.tieba.model.bp bpVar) {
        a(com.baidu.tieba.util.bv.a().b());
        this.a = personPostListData;
        this.k = bpVar;
        if (this.a == null || this.a.post_list == null || this.a.post_list.size() <= 0) {
            this.d = false;
        } else {
            this.d = true;
        }
    }

    public ay(Context context) {
        this.f = 200;
        this.b = context;
        this.e = new com.baidu.tieba.util.i(context);
        this.f = BdUtilHelper.b(context);
        a(com.baidu.tieba.util.bv.a().b());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PersonPostListData.PostList> list;
        if (!this.d) {
            return 1;
        }
        if (this.a == null || (list = this.a.post_list) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.d || this.a == null || this.a.post_list == null) {
            return null;
        }
        List<PersonPostListData.PostList> list = this.a.post_list;
        if (i < 0 || list == null || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PersonPostListData.PostList postList;
        if (!this.d) {
            return a(TiebaApplication.g().al(), this.k);
        }
        if (this.c == null) {
            this.c = new az(this.b);
        }
        this.c.a(this.f, this.h, this.i);
        this.c.a(this.j);
        View a = (view == null || view.getTag() == null) ? this.c.a() : view;
        a.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(R.dimen.forumfeed_first_item_margin_top) : 0, 0, 0);
        int al = TiebaApplication.g().al();
        List<PersonPostListData.PostList> list = this.a.post_list;
        if (list != null && (postList = list.get(i)) != null) {
            this.c.a(a, postList);
            this.c.a(al, a);
        }
        com.baidu.tieba.k kVar = (com.baidu.tieba.k) this.b;
        kVar.a().a(al == 1);
        kVar.a().a(a);
        return a;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        PersonPostListData.PostList postList;
        PersonPostListData.Media[] mediaArr;
        if (this.d && this.a != null) {
            List<PersonPostListData.PostList> list = this.a.post_list;
            if (list == null || (postList = list.get(i)) == null || (mediaArr = postList.media) == null) {
                return 2;
            }
            int length = mediaArr.length;
            if (length >= 3) {
                return 5;
            }
            if (length == 2) {
                return 4;
            }
            return length == 1 ? 3 : 2;
        }
        return 0;
    }

    public View a(int i, com.baidu.tieba.model.bp bpVar) {
        if (this.l == null) {
            this.l = (LinearLayout) View.inflate(this.b, R.layout.person_center_list_no_data_view, null);
            this.m = (ImageView) this.l.findViewById(R.id.person_center_list_no_data_iv);
            this.m.setVisibility(8);
            this.n = (TextView) this.l.findViewById(R.id.person_center_list_no_data_txt);
        }
        a(i);
        if (bpVar != null && bpVar.f() != null) {
            this.m.setVisibility(0);
            if (bpVar.a() != null && bpVar.a().hide_post != 0) {
                this.n.setText(this.b.getResources().getString(R.string.his_post_not_available));
            } else if (bpVar.a() == null || bpVar.a().post_list.size() == 0) {
                if (bpVar.e()) {
                    this.n.setText(this.b.getResources().getString(R.string.no_post_info));
                } else if (bpVar.f().getSex() == 1) {
                    this.n.setText(this.b.getResources().getString(R.string.he_no_post_info));
                } else if (bpVar.f().getSex() == 2) {
                    this.n.setText(this.b.getResources().getString(R.string.she_no_post_info));
                } else {
                    this.n.setText(this.b.getResources().getString(R.string.ta_no_post_info));
                }
            }
        }
        return this.l;
    }

    private void a(int i) {
        if (1 == i && this.l != null) {
            this.l.setBackgroundColor(this.b.getResources().getColor(R.color.person_center_list_no_data_bg_color_1));
            this.m.setBackgroundResource(R.drawable.pic_blank_page_search_1);
            this.n.setTextColor(this.b.getResources().getColor(R.color.person_center_list_no_data_text_color_1));
        } else if (this.l != null) {
            this.l.setBackgroundColor(this.b.getResources().getColor(R.color.person_center_list_no_data_bg_color));
            this.m.setBackgroundResource(R.drawable.pic_blank_page_search);
            this.n.setTextColor(this.b.getResources().getColor(R.color.person_center_list_no_data_text_color));
        }
    }

    public void a(boolean z) {
        this.h = z;
        this.g = this.f;
        if (this.h) {
            if (this.g > 480) {
                this.g = 480;
            }
            if (this.g > BdUtilHelper.a(this.b, 320.0f)) {
                this.g = BdUtilHelper.a(this.b, 320.0f);
            }
            this.e.b("_small");
        } else {
            if (this.g > this.i * 480.0f) {
                this.g = (int) (this.i * 480.0f);
            }
            if (this.g > BdUtilHelper.a(this.b, 320.0f) * this.i) {
                this.g = (int) (BdUtilHelper.a(this.b, 320.0f) * this.i);
            }
            this.e.b("_mobile");
        }
        this.e.a(this.g, this.g);
    }

    public com.baidu.tieba.util.i a() {
        return this.e;
    }
}
