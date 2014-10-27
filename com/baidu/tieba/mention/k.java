package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements View.OnClickListener {
    private ArrayList<FeedData> aew;
    private ListView ayV;
    private final String bnl;
    private o bno;
    private final Context mContext;
    private int mType;
    private boolean[] bnp = new boolean[0];
    private boolean ayM = false;
    private boolean aCu = false;
    private boolean bnm = false;
    private int bnn = 3;

    public k(Context context, ArrayList<FeedData> arrayList) {
        this.mContext = context;
        this.aew = arrayList;
        this.bnl = this.mContext.getText(com.baidu.tieba.y.forum).toString();
    }

    public void a(ArrayList<FeedData> arrayList, boolean z) {
        if (!z) {
            this.bnp = new boolean[Math.min(100, com.baidu.tbadk.coreExtra.messageCenter.a.oB().bZ(this.mType))];
        }
        this.aew = arrayList;
    }

    public void bO(boolean z) {
        this.ayM = z;
    }

    public void cb(boolean z) {
        this.aCu = z;
    }

    public boolean Gl() {
        return this.aCu;
    }

    public void dB(boolean z) {
        this.bnm = z;
    }

    public boolean SO() {
        return this.bnm;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void gv(int i) {
        this.bnn = i;
    }

    public int SP() {
        return this.bnn;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return this.mType == 1 ? 1 : 0;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew != null) {
            int size = this.aew.size();
            if (size > 0) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.aew.size()) {
            return null;
        }
        return this.aew.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == getCount() - 1) {
            i = -2;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.ayV = (ListView) viewGroup;
        switch (itemViewType) {
            case 0:
                return a(view, (FeedData) getItem(i), skinType == 1);
            case 1:
                return a(view, i, skinType == 1);
            case 2:
                return a(view, getItemId(i));
            default:
                return view;
        }
    }

    private View a(View view, FeedData feedData, boolean z) {
        m mVar;
        if (feedData != null) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof m)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.mention_atme_item, null);
                mVar = new m(null);
                mVar.f(this.mContext, view);
                view.setTag(mVar);
            } else {
                mVar = (m) view.getTag();
            }
            if (feedData.getReplyer() != null) {
                mVar.bnr.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    mVar.bns.setVisibility(8);
                } else {
                    mVar.bns.setVisibility(0);
                    mVar.bnu.c(feedData);
                }
                mVar.azk.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                mVar.azk.setTag(null);
                if (portrait != null && portrait.length() > 0) {
                    mVar.azk.c(portrait, 12, false);
                } else {
                    mVar.azk.setImageResource(com.baidu.tieba.u.photo);
                }
                mVar.bnt.setId(feedData.getReplyer().getUserId());
                mVar.bnt.setName(feedData.getReplyer().getUserName());
            }
            mVar.auh.setText(ay.j(feedData.getTime()));
            mVar.bmf.setText(feedData.getContent());
            mVar.azk.setOnClickListener(mVar.bnt);
            aw.h(view, com.baidu.tieba.u.list_selector);
            a(mVar, z);
        }
        return view;
    }

    private void a(m mVar, boolean z) {
        aw.i(mVar.MI, com.baidu.tieba.s.cp_bg_line_b);
        if (z) {
            mVar.auh.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
            mVar.bmf.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_7b8591));
            mVar.bnr.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
        } else {
            mVar.auh.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            mVar.bmf.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_262626));
            mVar.bnr.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
        mVar.bns.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        mVar.auh.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(mVar.bns, com.baidu.tieba.s.cp_link_tip_c, 1);
    }

    private View a(View view, int i, boolean z) {
        q qVar;
        com.baidu.tieba.data.x xVar;
        FeedData feedData = (FeedData) getItem(i);
        if (feedData != null) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof q)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.mention_replyme_item, null);
                q qVar2 = new q(null);
                qVar2.f(this.mContext, view);
                view.setTag(qVar2);
                qVar = qVar2;
            } else {
                qVar = (q) view.getTag();
            }
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                qVar.bnx.setVisibility(8);
                List<com.baidu.tieba.data.x> praiseList = feedData.getPraiseList();
                if (praiseList != null && praiseList.size() > 0 && (xVar = praiseList.get(0)) != null) {
                    qVar.bnr.setText(xVar.zv());
                    if (xVar.getIsMyFriend() == 1) {
                        qVar.bns.setVisibility(8);
                    } else {
                        qVar.bns.setVisibility(0);
                        qVar.bnu.c(feedData);
                    }
                    qVar.auh.setText(ay.j(feedData.getTime()));
                    if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                        qVar.bmf.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_more), xVar.zv(), praiseList.get(1).zv(), praiseList.get(2).zv(), String.valueOf(feedData.getPraiseNum())));
                    } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                        qVar.bmf.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_3), xVar.zv(), praiseList.get(1).zv(), praiseList.get(2).zv()));
                    } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                        qVar.bmf.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_2), xVar.zv(), praiseList.get(1).zv()));
                    } else {
                        qVar.bmf.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_1), xVar.zv()));
                    }
                    qVar.bnw.setText(this.mContext.getString(com.baidu.tieba.y.mention_praiseme_post));
                    qVar.JM.setText(feedData.getTitle());
                    if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                        qVar.axq.setVisibility(0);
                        qVar.axq.setText(ay.h(feedData.getFname(), 12).concat(this.bnl));
                    } else {
                        qVar.axq.setVisibility(8);
                    }
                    qVar.azk.setVisibility(0);
                    qVar.azk.c(xVar.getPortrait(), 12, false);
                    qVar.bnt.setId(xVar.getId());
                    qVar.bnt.setName(xVar.getName());
                }
            } else {
                qVar.bnx.setVisibility(0);
                qVar.bnx.setTag(Integer.valueOf(i));
                qVar.bnx.setOnClickListener(this);
                if (feedData.getReplyer() != null) {
                    qVar.bnr.setText(feedData.getReplyer().getName_show());
                    if (feedData.getReplyer().getIsMyFriend() == 1) {
                        qVar.bns.setVisibility(8);
                    } else {
                        qVar.bns.setVisibility(0);
                        qVar.bnu.c(feedData);
                    }
                    qVar.auh.setText(ay.j(feedData.getTime()));
                    qVar.bmf.setText(feedData.getContent());
                    if (feedData.getType() == 1) {
                        qVar.bnw.setText(this.mContext.getString(com.baidu.tieba.y.mention_replyme_comment));
                        qVar.JM.setText(feedData.getQuote_content());
                    } else {
                        qVar.bnw.setText(this.mContext.getString(com.baidu.tieba.y.mention_replyme_thread));
                        qVar.JM.setText(feedData.getTitle());
                    }
                    if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                        qVar.axq.setVisibility(0);
                        qVar.axq.setText(ay.h(feedData.getFname(), 12).concat(this.bnl));
                    } else {
                        qVar.axq.setVisibility(8);
                    }
                    qVar.azk.setVisibility(0);
                    String portrait = feedData.getReplyer().getPortrait();
                    qVar.azk.setTag(null);
                    qVar.azk.c(portrait, 12, false);
                    qVar.bnt.setId(feedData.getReplyer().getUserId());
                    qVar.bnt.setName(feedData.getReplyer().getUserName());
                }
            }
            aw.h(view, com.baidu.tieba.u.list_selector);
            a(qVar, z);
        }
        return view;
    }

    private void a(q qVar, boolean z) {
        aw.i(qVar.MI, com.baidu.tieba.s.cp_bg_line_b);
        if (z) {
            qVar.JM.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_5f6c7a));
            qVar.axq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
            qVar.auh.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
            qVar.bmf.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_7b8591));
            qVar.bnw.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_5f6c7a));
            qVar.bnr.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
        } else {
            qVar.axq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            qVar.auh.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            qVar.JM.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
            qVar.bmf.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_262626));
            qVar.bnw.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
            qVar.bnr.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
        aw.b(qVar.bnz, com.baidu.tieba.s.cp_cont_c, 1);
        aw.c(qVar.bny, com.baidu.tieba.u.icon_reply_n);
        qVar.bns.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.h(qVar.bnA, com.baidu.tieba.u.search_preycotbj);
        qVar.auh.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(qVar.bns, com.baidu.tieba.s.cp_link_tip_c, 1);
    }

    private View a(View view, long j) {
        n nVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof n)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.new_pb_list_more, null);
            nVar = new n(null);
            nVar.Q(view);
            view.setTag(nVar);
        } else {
            nVar = (n) view.getTag();
        }
        if (j == -1) {
            if (this.aCu) {
                nVar.mProgress.setVisibility(0);
                nVar.bnv.setText(com.baidu.tieba.y.loading);
            } else {
                nVar.mProgress.setVisibility(8);
                nVar.bnv.setText(com.baidu.tieba.y.refresh);
            }
        } else if (j == -2) {
            if (this.bnm) {
                nVar.mProgress.setVisibility(0);
                nVar.bnv.setText(com.baidu.tieba.y.loading);
            } else if (this.ayM) {
                nVar.mProgress.setVisibility(0);
                nVar.bnv.setText(com.baidu.tieba.y.loading);
            } else {
                nVar.mProgress.setVisibility(8);
                nVar.bnv.setText(com.baidu.tieba.y.no_more_msg);
            }
        }
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            nVar.bnv.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
        } else {
            nVar.bnv.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
        }
        return view;
    }

    public void a(o oVar) {
        this.bno = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bno != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.ayV.getChildAt(intValue - (this.ayV.getFirstVisiblePosition() - this.ayV.getHeaderViewsCount()));
            this.bno.a(intValue, view, childAt, (FeedData) getItem(intValue));
        }
    }
}
