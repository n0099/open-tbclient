package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.person.PersonPostListData;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private PersonPostListData a;
    private BaseFragmentActivity b;
    private y c;
    private com.baidu.tbadk.editortool.ab e;
    private int f;
    private com.baidu.tieba.model.av k;
    private LinearLayout l;
    private ImageView m;
    private TextView n;
    private boolean d = false;
    private int g = Constants.MEDIA_INFO;
    private boolean h = false;
    private float i = 0.4f;
    private boolean j = false;

    public void a(PersonPostListData personPostListData, com.baidu.tieba.model.av avVar) {
        a(com.baidu.tbadk.core.util.bh.a().b());
        this.a = personPostListData;
        this.k = avVar;
        if (this.a == null || this.a.post_list == null || this.a.post_list.size() <= 0) {
            this.d = false;
        } else {
            this.d = true;
        }
    }

    public x(BaseFragmentActivity baseFragmentActivity) {
        this.f = Constants.MEDIA_INFO;
        this.b = baseFragmentActivity;
        this.e = new com.baidu.tbadk.editortool.ab(baseFragmentActivity);
        this.f = com.baidu.adp.lib.util.k.b(baseFragmentActivity);
        a(com.baidu.tbadk.core.util.bh.a().b());
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
            return a(TbadkApplication.m252getInst().getSkinType(), this.k);
        }
        if (this.c == null) {
            this.c = new y(this.b);
        }
        this.c.a(this.f, this.h, this.i);
        this.c.a(this.j);
        View a = (view == null || view.getTag() == null) ? this.c.a() : view;
        a.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_first_item_margin_top) : 0, 0, 0);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        List<PersonPostListData.PostList> list = this.a.post_list;
        if (list != null && (postList = list.get(i)) != null) {
            this.c.a(a, postList);
            this.c.a(skinType, a);
        }
        BaseFragmentActivity baseFragmentActivity = this.b;
        baseFragmentActivity.a().a(skinType == 1);
        baseFragmentActivity.a().a(a);
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

    public View a(int i, com.baidu.tieba.model.av avVar) {
        if (this.l == null) {
            this.l = (LinearLayout) View.inflate(this.b, com.baidu.tieba.w.person_center_list_no_data_view, null);
            this.m = (ImageView) this.l.findViewById(com.baidu.tieba.v.person_center_list_no_data_iv);
            this.m.setVisibility(8);
            this.n = (TextView) this.l.findViewById(com.baidu.tieba.v.person_center_list_no_data_txt);
        }
        a(i);
        if (avVar != null && avVar.h() != null) {
            this.m.setVisibility(0);
            if (avVar.a() != null && avVar.a().hide_post != 0) {
                this.n.setText(this.b.getResources().getString(com.baidu.tieba.y.his_post_not_available));
            } else if (avVar.a() == null || avVar.a().post_list.size() == 0) {
                if (avVar.g()) {
                    this.n.setText(this.b.getResources().getString(com.baidu.tieba.y.no_post_info));
                } else if (avVar.h().getSex() == 1) {
                    this.n.setText(this.b.getResources().getString(com.baidu.tieba.y.he_no_post_info));
                } else if (avVar.h().getSex() == 2) {
                    this.n.setText(this.b.getResources().getString(com.baidu.tieba.y.she_no_post_info));
                } else {
                    this.n.setText(this.b.getResources().getString(com.baidu.tieba.y.ta_no_post_info));
                }
            }
        }
        return this.l;
    }

    private void a(int i) {
        if (1 == i && this.l != null) {
            this.l.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.person_center_list_no_data_bg_color_1));
            this.m.setBackgroundResource(com.baidu.tieba.u.pic_blank_page_search_1);
            this.n.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.person_center_list_no_data_text_color_1));
        } else if (this.l != null) {
            this.l.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.person_center_list_no_data_bg_color));
            this.m.setBackgroundResource(com.baidu.tieba.u.pic_blank_page_search);
            this.n.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.person_center_list_no_data_text_color));
        }
    }

    public void a(boolean z) {
        this.h = z;
        this.g = this.f;
        if (this.h) {
            if (this.g > 480) {
                this.g = 480;
            }
            if (this.g > com.baidu.adp.lib.util.k.a((Context) this.b, 320.0f)) {
                this.g = com.baidu.adp.lib.util.k.a((Context) this.b, 320.0f);
            }
            this.e.b("_small");
        } else {
            if (this.g > this.i * 480.0f) {
                this.g = (int) (this.i * 480.0f);
            }
            if (this.g > com.baidu.adp.lib.util.k.a((Context) this.b, 320.0f) * this.i) {
                this.g = (int) (com.baidu.adp.lib.util.k.a((Context) this.b, 320.0f) * this.i);
            }
            this.e.b("_mobile");
        }
        this.e.a(this.g, this.g);
    }

    public com.baidu.tbadk.editortool.ab a() {
        return this.e;
    }
}
