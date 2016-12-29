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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bg aMR;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.q> Wv = null;
    protected View.OnClickListener eje = null;
    protected int ejf = 0;
    protected boolean ejg = false;
    protected boolean eaM = false;
    protected boolean bgN = false;
    private boolean mIsFromCDN = true;
    private boolean ejh = false;
    private boolean eiq = false;
    private String mPostId = "";
    private int ccS = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void nT(int i) {
        this.ccS = i;
    }

    public int om(String str) {
        if (this.Wv == null) {
            return -1;
        }
        int size = this.Wv.size();
        for (int i = 0; i < size; i++) {
            if (this.Wv.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void h(bg bgVar) {
        this.aMR = bgVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (arrayList == null) {
            this.Wv = new ArrayList<>();
        } else {
            this.Wv = arrayList;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        this.eje = onClickListener;
    }

    public void B(int i, boolean z) {
        this.ejf = i;
        this.ejg = z;
    }

    public void setHasMoreData(boolean z) {
        this.bgN = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wv == null) {
            return 0;
        }
        return this.Wv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wv == null || i < 0 || i >= this.Wv.size()) {
            return null;
        }
        return this.Wv.get(i);
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
            if (qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fgF) {
                view = aNp();
            } else {
                view = kk();
            }
        }
        if ((view.getTag() instanceof a) && qVar.getType() != com.baidu.tieba.tbadkCore.data.q.fgF) {
            view = kk();
        }
        if ((view.getTag() instanceof SparseArray) && qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fgF) {
            view = aNp();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(r.g.tag_holder)) != null && qVar != null) {
            boolean z = !this.bgN && i + 1 >= getCount();
            boolean z2 = i == this.ccS;
            a(bVar, qVar, !z, i == 0, z2);
            if (z2) {
                this.ccS = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public View aAK;
        public TbRichTextView dYa;
        public LinearLayout ejk;
        public TextView ejl;
        public View ejm;
        public int mSkinType = 3;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aOP;
        public TextView eji;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aOP = view.findViewById(r.g.divider_line);
            this.eji = (TextView) view.findViewById(r.g.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.l(this.aOP, r.d.cp_cont_d);
                com.baidu.tbadk.core.util.ar.j((View) this.eji, r.d.cp_cont_d);
                com.baidu.tbadk.core.util.ar.l(this.eji, r.d.cp_bg_line_d);
                this.eji.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.q(i, r.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aNp() {
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kk() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.aAK = inflate;
        bVar.ejk = (LinearLayout) inflate.findViewById(r.g.sub_pb_item_columnlayout);
        if (this.ejh) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ejk.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
            bVar.ejk.setLayoutParams(layoutParams);
        }
        bVar.ejl = (TextView) inflate.findViewById(r.g.manage_btn);
        bVar.dYa = (TbRichTextView) inflate.findViewById(r.g.new_sub_pb_list_richText);
        bVar.ejm = inflate.findViewById(r.g.divide_bottom_view);
        bVar.dYa.Im();
        bVar.dYa.setSubPbPost(true);
        bVar.dYa.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_b));
        bVar.dYa.setTextCenter(true);
        bVar.ejl.setOnClickListener(this.eje);
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
                com.baidu.tbadk.core.util.ar.l(bVar.aAK, r.d.sub_pb_selected);
            } else {
                bVar.aAK.setBackgroundResource(0);
            }
            if (qVar.bgb()) {
                bVar.ejm.setVisibility(0);
            } else {
                bVar.ejm.setVisibility(8);
            }
            bVar.dYa.setPadding(0, 0, 0, 0);
            if (qVar.getAuthor() != null) {
                String userName = qVar.getAuthor().getUserName();
                String userId = qVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.aAK.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.aAK.setTag(sparseArray);
                }
                sparseArray.put(r.g.tag_photo_username, userName);
                sparseArray.put(r.g.tag_photo_userid, userId);
                sparseArray.put(r.g.tag_clip_board, qVar);
                sparseArray.put(r.g.tag_is_subpb, true);
            }
            bVar.dYa.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_c));
            bVar.dYa.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_b));
            a(qVar, this.ejh);
            com.baidu.tbadk.widget.richText.a avP = qVar.avP();
            if (avP != null) {
                bVar.dYa.setVoiceViewRes(r.h.voice_play_btn_new);
                bVar.dYa.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    avP.aIf = true;
                }
                bVar.dYa.setText(avP);
            }
            String userId2 = qVar.getAuthor().getUserId();
            if (this.ejf != 0) {
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
            if (!this.ejg) {
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
            bVar.ejl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.ejl.setText("");
            bVar.ejl.setContentDescription("");
            com.baidu.tbadk.core.util.ar.j((View) bVar.ejl, r.d.cp_link_tip_c);
            if (z5) {
                bVar.ejl.setVisibility(0);
                bVar.ejl.setText(this.mContext.getString(r.j.manage));
                bVar.ejl.setContentDescription(this.mContext.getString(r.j.manage));
            } else if (z6) {
                bVar.ejl.setVisibility(0);
                bVar.ejl.setText(this.mContext.getString(r.j.mute));
                bVar.ejl.setContentDescription(this.mContext.getString(r.j.mute));
            } else if (z8) {
                bVar.ejl.setVisibility(0);
                bVar.ejl.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_pb_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.ejl.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.ejl.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.ejl.setTag(sparseArray2);
            }
            sparseArray2.put(r.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(r.g.tag_should_manage_visible, true);
                sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.ejf));
                sparseArray2.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
            } else {
                sparseArray2.put(r.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.aMR != null) {
                    sparseArray2.put(r.g.tag_user_mute_visible, true);
                    sparseArray2.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (qVar.getAuthor() != null) {
                        sparseArray2.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                        sparseArray2.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                    }
                    if (this.aMR.getId() != null) {
                        sparseArray2.put(r.g.tag_user_mute_thread_id, this.aMR.getId());
                    }
                    sparseArray2.put(r.g.tag_user_mute_post_id, qVar.getId());
                }
            } else {
                sparseArray2.put(r.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(r.g.tag_should_delete_visible, true);
                sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.ejf));
                sparseArray2.put(r.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(r.g.tag_del_post_type, 2);
                sparseArray2.put(r.g.tag_del_post_id, qVar.getId());
            } else {
                sparseArray2.put(r.g.tag_should_delete_visible, false);
            }
            if (this.ejh && z2 && this.eiq) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ejk.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                bVar.ejk.setLayoutParams(layoutParams);
            }
            if (this.ejh && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ejk.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                bVar.ejk.setLayoutParams(layoutParams2);
            }
            bVar.aAK.setPadding(bVar.aAK.getPaddingLeft(), bVar.aAK.getPaddingTop(), bVar.aAK.getPaddingRight(), com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds12));
            bVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.tieba.tbadkCore.data.q qVar, boolean z) {
        com.baidu.tbadk.widget.richText.a avP;
        SpannableStringBuilder HE;
        com.baidu.tbadk.widget.richText.c cVar;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder HE2;
        if (qVar != null && (avP = qVar.avP()) != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> Hy = avP.Hy();
            if (!com.baidu.tbadk.core.util.x.t(Hy)) {
                if (z) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Hy.get(Hy.size() - 1);
                    int type = cVar2 != null ? cVar2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.av.s(qVar.getTime());
                        if (Hy.size() > 1) {
                            if ((Hy.get(Hy.size() + (-2)) != null ? Hy.get(Hy.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.av.s(qVar.getTime());
                                HE2 = cVar2.HE();
                                if (avP.aHX && HE2 != 0 && avP.aHY <= HE2.length()) {
                                    HE2.delete(HE2.length() - avP.aHY, HE2.length());
                                }
                                String dC = com.baidu.tbadk.core.util.av.dC(str2);
                                if (HE2 != null) {
                                    HE2.append((CharSequence) dC);
                                }
                                avP.aHX = true;
                                avP.aHY = dC.length();
                                cVar = cVar2;
                                str = dC;
                            }
                        }
                        str2 = str3;
                        HE2 = cVar2.HE();
                        if (avP.aHX) {
                            HE2.delete(HE2.length() - avP.aHY, HE2.length());
                        }
                        String dC2 = com.baidu.tbadk.core.util.av.dC(str2);
                        if (HE2 != null) {
                        }
                        avP.aHX = true;
                        avP.aHY = dC2.length();
                        cVar = cVar2;
                        str = dC2;
                    } else if (avP.aHX) {
                        cVar = cVar2;
                        str = "";
                    } else {
                        String s = com.baidu.tbadk.core.util.av.s(qVar.getTime());
                        cVar = new com.baidu.tbadk.widget.richText.c(1);
                        str = com.baidu.tbadk.core.util.av.dC(s);
                        cVar.append(str);
                        avP.aHX = true;
                        avP.aHY = str.length();
                        Hy.add(cVar);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.k.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.k.subtext_entelechy);
                    }
                    SpannableStringBuilder HE3 = cVar.HE();
                    if (HE3 != null && str.length() <= HE3.length()) {
                        HE3.setSpan(textAppearanceSpan, HE3.length() - str.length(), HE3.length(), 33);
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar3 = Hy.get(Hy.size() - 1);
                if (avP.aHX && cVar3 != null && (HE = cVar3.HE()) != null && avP.aHY <= HE.length()) {
                    HE.delete(HE.length() - avP.aHY, HE.length());
                }
                avP.aHX = false;
                avP.aHY = 0;
            }
        }
    }

    public void iS(boolean z) {
        this.ejh = z;
    }

    public void iT(boolean z) {
        this.eiq = z;
    }

    public void on(String str) {
        this.mPostId = str;
    }
}
