package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements View.OnClickListener {
    private ArrayList<FeedData> aeE;
    private ListView aze;
    private o bnC;
    private final String bnz;
    private final Context mContext;
    private int mType;
    private boolean[] bnD = new boolean[0];
    private boolean ayV = false;
    private boolean aCE = false;
    private boolean bnA = false;
    private int bnB = 3;

    public k(Context context, ArrayList<FeedData> arrayList) {
        this.mContext = context;
        this.aeE = arrayList;
        this.bnz = this.mContext.getText(com.baidu.tieba.y.forum).toString();
    }

    public void a(ArrayList<FeedData> arrayList, boolean z) {
        if (!z) {
            this.bnD = new boolean[Math.min(100, com.baidu.tbadk.coreExtra.messageCenter.a.oD().bZ(this.mType))];
        }
        this.aeE = arrayList;
    }

    public void bO(boolean z) {
        this.ayV = z;
    }

    public void cb(boolean z) {
        this.aCE = z;
    }

    public boolean Gn() {
        return this.aCE;
    }

    public void dB(boolean z) {
        this.bnA = z;
    }

    public boolean SR() {
        return this.bnA;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void gv(int i) {
        this.bnB = i;
    }

    public int SS() {
        return this.bnB;
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
        if (this.aeE != null) {
            int size = this.aeE.size();
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
        if (itemId < 0 || itemId >= this.aeE.size()) {
            return null;
        }
        return this.aeE.get(itemId);
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
        this.aze = (ListView) viewGroup;
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
                mVar.bnF.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    mVar.bnG.setVisibility(8);
                } else {
                    mVar.bnG.setVisibility(0);
                    mVar.bnI.c(feedData);
                }
                mVar.azt.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                mVar.azt.setTag(null);
                if (portrait != null && portrait.length() > 0) {
                    mVar.azt.c(portrait, 12, false);
                } else {
                    mVar.azt.setImageResource(com.baidu.tieba.u.photo);
                }
                mVar.bnH.setId(feedData.getReplyer().getUserId());
                mVar.bnH.setName(feedData.getReplyer().getUserName());
            }
            mVar.auq.setText(az.j(feedData.getTime()));
            mVar.bmt.setText(feedData.getContent());
            mVar.azt.setOnClickListener(mVar.bnH);
            aw.h(view, com.baidu.tieba.u.list_selector);
            a(mVar, z);
        }
        return view;
    }

    private void a(m mVar, boolean z) {
        aw.i(mVar.ML, com.baidu.tieba.s.cp_bg_line_b);
        if (z) {
            mVar.auq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
            mVar.bmt.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_7b8591));
            mVar.bnF.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
        } else {
            mVar.auq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            mVar.bmt.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_262626));
            mVar.bnF.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
        mVar.bnG.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        mVar.auq.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(mVar.bnG, com.baidu.tieba.s.cp_link_tip_c, 1);
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
                qVar.bnL.setVisibility(8);
                List<com.baidu.tieba.data.x> praiseList = feedData.getPraiseList();
                if (praiseList != null && praiseList.size() > 0 && (xVar = praiseList.get(0)) != null) {
                    qVar.bnF.setText(xVar.zx());
                    if (xVar.getIsMyFriend() == 1) {
                        qVar.bnG.setVisibility(8);
                    } else {
                        qVar.bnG.setVisibility(0);
                        qVar.bnI.c(feedData);
                    }
                    qVar.auq.setText(az.j(feedData.getTime()));
                    if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                        qVar.bmt.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_more), xVar.zx(), praiseList.get(1).zx(), praiseList.get(2).zx(), String.valueOf(feedData.getPraiseNum())));
                    } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                        qVar.bmt.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_3), xVar.zx(), praiseList.get(1).zx(), praiseList.get(2).zx()));
                    } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                        qVar.bmt.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_2), xVar.zx(), praiseList.get(1).zx()));
                    } else {
                        qVar.bmt.setText(String.format(this.mContext.getString(com.baidu.tieba.y.message_praise_like_list_1), xVar.zx()));
                    }
                    qVar.bnK.setText(this.mContext.getString(com.baidu.tieba.y.mention_praiseme_post));
                    qVar.JN.setText(feedData.getTitle());
                    if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                        qVar.axz.setVisibility(0);
                        qVar.axz.setText(az.h(feedData.getFname(), 12).concat(this.bnz));
                    } else {
                        qVar.axz.setVisibility(8);
                    }
                    qVar.azt.setVisibility(0);
                    qVar.azt.c(xVar.getPortrait(), 12, false);
                    qVar.bnH.setId(xVar.getId());
                    qVar.bnH.setName(xVar.getName());
                }
            } else {
                qVar.bnL.setVisibility(0);
                qVar.bnL.setTag(Integer.valueOf(i));
                qVar.bnL.setOnClickListener(this);
                if (feedData.getReplyer() != null) {
                    qVar.bnF.setText(feedData.getReplyer().getName_show());
                    if (feedData.getReplyer().getIsMyFriend() == 1) {
                        qVar.bnG.setVisibility(8);
                    } else {
                        qVar.bnG.setVisibility(0);
                        qVar.bnI.c(feedData);
                    }
                    qVar.auq.setText(az.j(feedData.getTime()));
                    qVar.bmt.setText(feedData.getContent());
                    if (feedData.getType() == 1) {
                        qVar.bnK.setText(this.mContext.getString(com.baidu.tieba.y.mention_replyme_comment));
                        qVar.JN.setText(feedData.getQuote_content());
                    } else {
                        qVar.bnK.setText(this.mContext.getString(com.baidu.tieba.y.mention_replyme_thread));
                        qVar.JN.setText(feedData.getTitle());
                    }
                    if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                        qVar.axz.setVisibility(0);
                        qVar.axz.setText(az.h(feedData.getFname(), 12).concat(this.bnz));
                    } else {
                        qVar.axz.setVisibility(8);
                    }
                    qVar.azt.setVisibility(0);
                    String portrait = feedData.getReplyer().getPortrait();
                    qVar.azt.setTag(null);
                    qVar.azt.c(portrait, 12, false);
                    qVar.bnH.setId(feedData.getReplyer().getUserId());
                    qVar.bnH.setName(feedData.getReplyer().getUserName());
                }
            }
            aw.h(view, com.baidu.tieba.u.list_selector);
            a(qVar, z);
        }
        return view;
    }

    private void a(q qVar, boolean z) {
        aw.i(qVar.ML, com.baidu.tieba.s.cp_bg_line_b);
        if (z) {
            qVar.JN.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_5f6c7a));
            qVar.axz.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
            qVar.auq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
            qVar.bmt.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_7b8591));
            qVar.bnK.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_5f6c7a));
            qVar.bnF.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_515865));
        } else {
            qVar.axz.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            qVar.auq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            qVar.JN.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
            qVar.bmt.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.c_262626));
            qVar.bnK.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
            qVar.bnF.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
        aw.b(qVar.bnN, com.baidu.tieba.s.cp_cont_c, 1);
        aw.c(qVar.bnM, com.baidu.tieba.u.icon_reply_n);
        qVar.bnG.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.h(qVar.bnO, com.baidu.tieba.u.search_preycotbj);
        qVar.auq.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(qVar.bnG, com.baidu.tieba.s.cp_link_tip_c, 1);
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
            if (this.aCE) {
                nVar.mProgress.setVisibility(0);
                nVar.bnJ.setText(com.baidu.tieba.y.loading);
            } else {
                nVar.mProgress.setVisibility(8);
                nVar.bnJ.setText(com.baidu.tieba.y.refresh);
            }
        } else if (j == -2) {
            if (this.bnA) {
                nVar.mProgress.setVisibility(0);
                nVar.bnJ.setText(com.baidu.tieba.y.loading);
            } else if (this.ayV) {
                nVar.mProgress.setVisibility(0);
                nVar.bnJ.setText(com.baidu.tieba.y.loading);
            } else {
                nVar.mProgress.setVisibility(8);
                nVar.bnJ.setText(com.baidu.tieba.y.no_more_msg);
            }
        }
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            nVar.bnJ.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
        } else {
            nVar.bnJ.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
        }
        return view;
    }

    public void a(o oVar) {
        this.bnC = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bnC != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aze.getChildAt(intValue - (this.aze.getFirstVisiblePosition() - this.aze.getHeaderViewsCount()));
            this.bnC.a(intValue, view, childAt, (FeedData) getItem(intValue));
        }
    }
}
