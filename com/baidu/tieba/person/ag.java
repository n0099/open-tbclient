package com.baidu.tieba.person;

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
public class ag extends BaseAdapter {
    private PersonPostListData a;
    private BaseFragmentActivity b;
    private ah c;
    private int e;
    private com.baidu.tieba.model.av i;
    private LinearLayout j;
    private ImageView k;
    private TextView l;
    private int d = -1;
    private boolean f = false;
    private float g = 0.4f;
    private boolean h = false;

    public void a(PersonPostListData personPostListData, com.baidu.tieba.model.av avVar) {
        a(com.baidu.tbadk.core.util.bb.a().b());
        this.a = personPostListData;
        this.i = avVar;
        if (this.i == null || this.a == null) {
            this.d = 2;
        } else if (this.i.c() == 0) {
            if (this.a == null || this.a.post_list == null || this.a.post_list.size() == 0) {
                this.d = 2;
            } else {
                this.d = 0;
            }
        } else if (this.a == null || this.a.post_list == null || this.a.post_list.size() == 0) {
            this.d = 2;
        } else {
            this.d = 1;
        }
    }

    public ag(BaseFragmentActivity baseFragmentActivity) {
        this.e = Constants.MEDIA_INFO;
        this.b = baseFragmentActivity;
        this.e = com.baidu.adp.lib.util.j.b(baseFragmentActivity);
        a(com.baidu.tbadk.core.util.bb.a().b());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PersonPostListData.PostList> list;
        if (this.d == 2) {
            return 1;
        }
        if (this.d == 0) {
            return this.a.post_list.size() + 1;
        }
        if (this.a == null || (list = this.a.post_list) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.d == 2 || this.a == null || this.a.post_list == null) {
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
        View view2 = null;
        if (this.d == 2) {
            View a = a(TbadkApplication.m252getInst().getSkinType(), this.i);
            a(i, a);
            return a;
        } else if (this.d == 0 && i == getCount() - 1) {
            View a2 = a(TbadkApplication.m252getInst().getSkinType(), this.i);
            a(i, a2);
            return a2;
        } else {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 6) {
                PersonRelationCardData personRelationCardData = (PersonRelationCardData) getItem(i);
                if (personRelationCardData != null) {
                    ba baVar = new ba(this.b, personRelationCardData);
                    baVar.a();
                    if (view == null || view.getTag() == null) {
                        view = baVar.a();
                    }
                    baVar.a(view);
                } else {
                    view = null;
                }
                a(i, view);
                return view;
            } else if (itemViewType == 7) {
                PersonCenterListTopData personCenterListTopData = (PersonCenterListTopData) getItem(i);
                if (personCenterListTopData != null) {
                    personCenterListTopData.getmModel().a(this.i.d());
                    as asVar = new as(this.b, personCenterListTopData);
                    view2 = asVar.a();
                    asVar.a(view2);
                }
                a(i, view2);
                return view2;
            } else {
                if (this.c == null) {
                    this.c = new ah(this.b);
                }
                this.c.a(this.e, this.f, this.g);
                this.c.a(this.h);
                if (view == null || view.getTag() == null) {
                    view = this.c.a();
                }
                view.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.forumfeed_first_item_margin_top) : 0, 0, 0);
                int skinType = TbadkApplication.m252getInst().getSkinType();
                List<PersonPostListData.PostList> list = this.a.post_list;
                if (list != null && (postList = list.get(i)) != null) {
                    this.c.a(view, postList);
                    this.c.a(skinType, view);
                }
                BaseFragmentActivity baseFragmentActivity = this.b;
                baseFragmentActivity.c().a(skinType == 1);
                baseFragmentActivity.c().a(view);
                a(i, view);
                return view;
            }
        }
    }

    private void a(int i, View view) {
        view.setBackgroundResource(com.baidu.tieba.r.transparent);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 8;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        PersonPostListData.PostList postList;
        if (this.d == 2 || this.a == null) {
            return 0;
        }
        List<PersonPostListData.PostList> list = this.a.post_list;
        if (list != null && i < list.size() && (postList = list.get(i)) != null) {
            if (postList instanceof PersonRelationCardData) {
                return 6;
            }
            if (postList instanceof PersonCenterListTopData) {
                return 7;
            }
            PersonPostListData.Media[] mediaArr = postList.media;
            if (mediaArr != null) {
                int length = mediaArr.length;
                if (length >= 3) {
                    return 5;
                }
                if (length == 2) {
                    return 4;
                }
                return length == 1 ? 3 : 2;
            }
        }
        return 2;
    }

    public View a(int i, com.baidu.tieba.model.av avVar) {
        if (this.j == null) {
            this.j = (LinearLayout) View.inflate(this.b, com.baidu.tieba.v.person_center_list_no_data_view, null);
            this.k = (ImageView) this.j.findViewById(com.baidu.tieba.u.person_center_list_no_data_iv);
            this.k.setVisibility(8);
            this.l = (TextView) this.j.findViewById(com.baidu.tieba.u.person_center_list_no_data_txt);
        }
        a(i);
        if (avVar != null && avVar.k() != null) {
            this.k.setVisibility(0);
            if (!avVar.j() && avVar.k().getPersonPrivate() != null && avVar.a() != null) {
                if (avVar.k().getPersonPrivate().d() == 2 && avVar.a().g() != 1) {
                    com.baidu.tbadk.core.util.ay.f(this.k, com.baidu.tieba.t.pic_emotion05);
                    this.l.setText(com.baidu.tieba.x.friend_open_post);
                    return this.j;
                } else if (avVar.k().getPersonPrivate().d() == 3) {
                    com.baidu.tbadk.core.util.ay.f(this.k, com.baidu.tieba.t.pic_emotion05);
                    this.l.setText(com.baidu.tieba.x.hide_post);
                    return this.j;
                }
            }
            if (avVar.b() != null && avVar.b().hide_post != 0) {
                this.l.setText(this.b.getResources().getString(com.baidu.tieba.x.his_post_not_available));
            } else if (this.d != 1) {
                if (avVar.j()) {
                    this.l.setText(this.b.getResources().getString(com.baidu.tieba.x.no_post_info));
                } else if (avVar.k().getSex() == 1) {
                    this.l.setText(this.b.getResources().getString(com.baidu.tieba.x.he_no_post_info));
                } else if (avVar.k().getSex() == 2) {
                    this.l.setText(this.b.getResources().getString(com.baidu.tieba.x.she_no_post_info));
                } else {
                    this.l.setText(this.b.getResources().getString(com.baidu.tieba.x.ta_no_post_info));
                }
            }
        }
        return this.j;
    }

    private void a(int i) {
        if (1 == i && this.j != null) {
            this.k.setBackgroundResource(com.baidu.tieba.t.pic_emotion05_1);
            this.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.person_center_list_no_data_text_color_1));
        } else if (this.j != null) {
            this.k.setBackgroundResource(com.baidu.tieba.t.pic_emotion05);
            this.l.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.person_center_list_no_data_text_color));
        }
    }

    public void a(boolean z) {
        this.f = z;
    }
}
