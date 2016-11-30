package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bk aNA;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.q> Xb = null;
    protected View.OnClickListener eFe = null;
    protected int eFf = 0;
    protected boolean eFg = false;
    protected boolean ewq = false;
    protected boolean bhu = false;
    private boolean mIsFromCDN = true;
    private boolean eFh = false;
    private boolean eEq = false;
    private String mPostId = "";
    private int cxH = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void oR(int i) {
        this.cxH = i;
    }

    public int pL(String str) {
        if (this.Xb == null) {
            return -1;
        }
        int size = this.Xb.size();
        for (int i = 0; i < size; i++) {
            if (this.Xb.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void c(bk bkVar) {
        this.aNA = bkVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (arrayList == null) {
            this.Xb = new ArrayList<>();
        } else {
            this.Xb = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.eFe = onClickListener;
    }

    public void P(int i, boolean z) {
        this.eFf = i;
        this.eFg = z;
    }

    public void setHasMoreData(boolean z) {
        this.bhu = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xb == null) {
            return 0;
        }
        return this.Xb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xb == null || i < 0 || i >= this.Xb.size()) {
            return null;
        }
        return this.Xb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        com.baidu.tieba.tbadkCore.data.q qVar = null;
        if (getItem(i) instanceof com.baidu.tieba.tbadkCore.data.q) {
            qVar = (com.baidu.tieba.tbadkCore.data.q) getItem(i);
        }
        if (view == null) {
            if (qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fCB) {
                view = aTy();
            } else {
                view = kk();
            }
        }
        if ((view.getTag() instanceof a) && qVar.getType() != com.baidu.tieba.tbadkCore.data.q.fCB) {
            view = kk();
        }
        if ((view.getTag() instanceof SparseArray) && qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fCB) {
            view = aTy();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(r.g.tag_holder)) != null && qVar != null) {
            boolean z = !this.bhu && i + 1 >= getCount();
            boolean z2 = i == this.cxH;
            a(bVar, qVar, !z, i == 0, z2);
            if (z2) {
                this.cxH = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public View aBq;
        public LinearLayout eFk;
        public TextView eFl;
        public View eFm;
        public TbRichTextView etF;
        public int mSkinType = 3;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aPy;
        public TextView eFi;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aPy = view.findViewById(r.g.divider_line);
            this.eFi = (TextView) view.findViewById(r.g.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.at.l(this.aPy, r.d.cp_cont_d);
                com.baidu.tbadk.core.util.at.j((View) this.eFi, r.d.cp_cont_d);
                com.baidu.tbadk.core.util.at.l(this.eFi, r.d.cp_bg_line_d);
                this.eFi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.q(i, r.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aTy() {
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kk() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.aBq = inflate;
        bVar.eFk = (LinearLayout) inflate.findViewById(r.g.sub_pb_item_columnlayout);
        if (this.eFh) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eFk.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
            bVar.eFk.setLayoutParams(layoutParams);
        }
        bVar.eFl = (TextView) inflate.findViewById(r.g.manage_btn);
        bVar.etF = (TbRichTextView) inflate.findViewById(r.g.new_sub_pb_list_richText);
        bVar.eFm = inflate.findViewById(r.g.divide_bottom_view);
        bVar.etF.IR();
        bVar.etF.setSubPbPost(true);
        bVar.etF.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_b));
        bVar.etF.setTextCenter(true);
        bVar.eFl.setOnClickListener(this.eFe);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (bVar != null && qVar != null) {
            if (z3) {
                com.baidu.tbadk.core.util.at.l(bVar.aBq, r.d.sub_pb_selected);
            } else {
                bVar.aBq.setBackgroundResource(0);
            }
            if (qVar.bmm()) {
                bVar.eFm.setVisibility(0);
            } else {
                bVar.eFm.setVisibility(8);
            }
            bVar.etF.setPadding(0, 0, 0, 0);
            if (qVar.getAuthor() != null) {
                String userName = qVar.getAuthor().getUserName();
                String userId = qVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.aBq.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.aBq.setTag(sparseArray);
                }
                sparseArray.put(r.g.tag_photo_username, userName);
                sparseArray.put(r.g.tag_photo_userid, userId);
                sparseArray.put(r.g.tag_clip_board, qVar);
                sparseArray.put(r.g.tag_is_subpb, true);
            }
            bVar.etF.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_c));
            bVar.etF.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_b));
            a(qVar, this.eFh);
            com.baidu.tbadk.widget.richText.a aCE = qVar.aCE();
            if (aCE != null) {
                bVar.etF.setVoiceViewRes(r.h.voice_play_btn_new);
                bVar.etF.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    aCE.aIM = true;
                }
                bVar.etF.setText(aCE);
            }
            String userId2 = qVar.getAuthor().getUserId();
            if (this.eFf != 0) {
                boolean z9 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = true;
                    z5 = false;
                } else {
                    z5 = z9;
                    z4 = true;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (!this.eFg) {
                z6 = false;
            } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                z4 = true;
            } else {
                z6 = false;
                z4 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z7 = false;
                z8 = z4;
            } else {
                z7 = true;
                z8 = true;
            }
            bVar.eFl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.eFl.setText("");
            bVar.eFl.setContentDescription("");
            com.baidu.tbadk.core.util.at.j((View) bVar.eFl, r.d.cp_link_tip_c);
            if (z5) {
                bVar.eFl.setVisibility(0);
                bVar.eFl.setText(this.mContext.getString(r.j.manage));
                bVar.eFl.setContentDescription(this.mContext.getString(r.j.manage));
            } else if (z6) {
                bVar.eFl.setVisibility(0);
                bVar.eFl.setText(this.mContext.getString(r.j.mute));
                bVar.eFl.setContentDescription(this.mContext.getString(r.j.mute));
            } else if (z8) {
                bVar.eFl.setVisibility(0);
                bVar.eFl.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_pb_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.eFl.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.eFl.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.eFl.setTag(sparseArray2);
            }
            sparseArray2.put(r.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(r.g.tag_should_manage_visible, true);
                sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.eFf));
                sparseArray2.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
            } else {
                sparseArray2.put(r.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.aNA != null) {
                    sparseArray2.put(r.g.tag_user_mute_visible, true);
                    sparseArray2.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (qVar.getAuthor() != null) {
                        sparseArray2.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                        sparseArray2.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                    }
                    if (this.aNA.getId() != null) {
                        sparseArray2.put(r.g.tag_user_mute_thread_id, this.aNA.getId());
                    }
                    sparseArray2.put(r.g.tag_user_mute_post_id, qVar.getId());
                }
            } else {
                sparseArray2.put(r.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(r.g.tag_should_delete_visible, true);
                sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.eFf));
                sparseArray2.put(r.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(r.g.tag_del_post_type, 2);
                sparseArray2.put(r.g.tag_del_post_id, qVar.getId());
            } else {
                sparseArray2.put(r.g.tag_should_delete_visible, false);
            }
            if (this.eFh && z2 && this.eEq) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eFk.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                bVar.eFk.setLayoutParams(layoutParams);
            }
            if (this.eFh && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eFk.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                bVar.eFk.setLayoutParams(layoutParams2);
            }
            bVar.aBq.setPadding(bVar.aBq.getPaddingLeft(), bVar.aBq.getPaddingTop(), bVar.aBq.getPaddingRight(), com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds12));
            bVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.tieba.tbadkCore.data.q qVar, boolean z) {
        com.baidu.tbadk.widget.richText.a aCE;
        SpannableStringBuilder Ii;
        com.baidu.tbadk.widget.richText.c cVar;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Ii2;
        if (qVar != null && (aCE = qVar.aCE()) != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> Ic = aCE.Ic();
            if (!com.baidu.tbadk.core.util.x.t(Ic)) {
                if (z) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Ic.get(Ic.size() - 1);
                    int type = cVar2 != null ? cVar2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.ax.s(qVar.getTime());
                        if (Ic.size() > 1) {
                            if ((Ic.get(Ic.size() + (-2)) != null ? Ic.get(Ic.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.ax.s(qVar.getTime());
                                Ii2 = cVar2.Ii();
                                if (aCE.aID && Ii2 != 0 && aCE.aIE <= Ii2.length()) {
                                    Ii2.delete(Ii2.length() - aCE.aIE, Ii2.length());
                                }
                                String dF = com.baidu.tbadk.core.util.ax.dF(str2);
                                if (Ii2 != null) {
                                    Ii2.append((CharSequence) dF);
                                }
                                aCE.aID = true;
                                aCE.aIE = dF.length();
                                cVar = cVar2;
                                str = dF;
                            }
                        }
                        str2 = str3;
                        Ii2 = cVar2.Ii();
                        if (aCE.aID) {
                            Ii2.delete(Ii2.length() - aCE.aIE, Ii2.length());
                        }
                        String dF2 = com.baidu.tbadk.core.util.ax.dF(str2);
                        if (Ii2 != null) {
                        }
                        aCE.aID = true;
                        aCE.aIE = dF2.length();
                        cVar = cVar2;
                        str = dF2;
                    } else if (aCE.aID) {
                        cVar = cVar2;
                        str = "";
                    } else {
                        String s = com.baidu.tbadk.core.util.ax.s(qVar.getTime());
                        cVar = new com.baidu.tbadk.widget.richText.c(1);
                        str = com.baidu.tbadk.core.util.ax.dF(s);
                        cVar.append(str);
                        aCE.aID = true;
                        aCE.aIE = str.length();
                        Ic.add(cVar);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.k.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.k.subtext_entelechy);
                    }
                    SpannableStringBuilder Ii3 = cVar.Ii();
                    if (Ii3 != null && str.length() <= Ii3.length()) {
                        Ii3.setSpan(textAppearanceSpan, Ii3.length() - str.length(), Ii3.length(), 33);
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar3 = Ic.get(Ic.size() - 1);
                if (aCE.aID && cVar3 != null && (Ii = cVar3.Ii()) != null && aCE.aIE <= Ii.length()) {
                    Ii.delete(Ii.length() - aCE.aIE, Ii.length());
                }
                aCE.aID = false;
                aCE.aIE = 0;
            }
        }
    }

    public void jh(boolean z) {
        this.eFh = z;
    }

    public void ji(boolean z) {
        this.eEq = z;
    }

    public void pM(String str) {
        this.mPostId = str;
    }
}
