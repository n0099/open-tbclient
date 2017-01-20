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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bh aLS;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.p> VL = null;
    protected View.OnClickListener eso = null;
    protected int esp = 0;
    protected boolean esq = false;
    protected boolean ejE = false;
    protected boolean btO = false;
    private boolean mIsFromCDN = true;
    private boolean esr = false;
    private boolean erA = false;
    private String mPostId = "";
    private int cjp = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void oK(int i) {
        this.cjp = i;
    }

    public int oC(String str) {
        if (this.VL == null) {
            return -1;
        }
        int size = this.VL.size();
        for (int i = 0; i < size; i++) {
            if (this.VL.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void h(bh bhVar) {
        this.aLS = bhVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        if (arrayList == null) {
            this.VL = new ArrayList<>();
        } else {
            this.VL = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.eso = onClickListener;
    }

    public void B(int i, boolean z) {
        this.esp = i;
        this.esq = z;
    }

    public void setHasMoreData(boolean z) {
        this.btO = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.VL == null) {
            return 0;
        }
        return this.VL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.VL == null || i < 0 || i >= this.VL.size()) {
            return null;
        }
        return this.VL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        com.baidu.tieba.tbadkCore.data.p pVar = null;
        if (getItem(i) instanceof com.baidu.tieba.tbadkCore.data.p) {
            pVar = (com.baidu.tieba.tbadkCore.data.p) getItem(i);
        }
        if (view == null) {
            if (pVar.getType() == com.baidu.tieba.tbadkCore.data.p.fpU) {
                view = aPl();
            } else {
                view = kg();
            }
        }
        if ((view.getTag() instanceof a) && pVar.getType() != com.baidu.tieba.tbadkCore.data.p.fpU) {
            view = kg();
        }
        if ((view.getTag() instanceof SparseArray) && pVar.getType() == com.baidu.tieba.tbadkCore.data.p.fpU) {
            view = aPl();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(r.h.tag_holder)) != null && pVar != null) {
            boolean z = !this.btO && i + 1 >= getCount();
            boolean z2 = i == this.cjp;
            a(bVar, pVar, !z, i == 0, z2);
            if (z2) {
                this.cjp = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TbRichTextView egH;
        public LinearLayout esu;
        public TextView esv;
        public View esw;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aNS;
        public TextView ess;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aNS = view.findViewById(r.h.divider_line);
            this.ess = (TextView) view.findViewById(r.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.ap.k(this.aNS, r.e.cp_cont_d);
                com.baidu.tbadk.core.util.ap.i((View) this.ess, r.e.cp_cont_d);
                com.baidu.tbadk.core.util.ap.k(this.ess, r.e.cp_bg_line_d);
                this.ess.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.r(i, r.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aPl() {
        View inflate = LayoutInflater.from(this.mContext).inflate(r.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kg() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(r.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.esu = (LinearLayout) inflate.findViewById(r.h.sub_pb_item_columnlayout);
        if (this.esr) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.esu.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
            bVar.esu.setLayoutParams(layoutParams);
        }
        bVar.esv = (TextView) inflate.findViewById(r.h.manage_btn);
        bVar.egH = (TbRichTextView) inflate.findViewById(r.h.new_sub_pb_list_richText);
        bVar.esw = inflate.findViewById(r.h.divide_bottom_view);
        bVar.egH.Id();
        bVar.egH.setSubPbPost(true);
        bVar.egH.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_b));
        bVar.egH.setTextCenter(true);
        bVar.esv.setOnClickListener(this.eso);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.h.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, com.baidu.tieba.tbadkCore.data.p pVar, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (bVar != null && pVar != null) {
            if (z3) {
                com.baidu.tbadk.core.util.ap.k(bVar.rootView, r.e.sub_pb_selected);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (pVar.bhR()) {
                bVar.esw.setVisibility(0);
            } else {
                bVar.esw.setVisibility(8);
            }
            bVar.egH.setPadding(0, 0, 0, 0);
            if (pVar.getAuthor() != null) {
                String userName = pVar.getAuthor().getUserName();
                String userId = pVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(r.h.tag_photo_username, userName);
                sparseArray.put(r.h.tag_photo_userid, userId);
                sparseArray.put(r.h.tag_clip_board, pVar);
                sparseArray.put(r.h.tag_is_subpb, true);
            }
            bVar.egH.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
            bVar.egH.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_b));
            a(pVar, this.esr);
            TbRichText awW = pVar.awW();
            if (awW != null) {
                bVar.egH.setVoiceViewRes(r.j.voice_play_btn_new);
                bVar.egH.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    awW.isChanged = true;
                }
                bVar.egH.setText(awW);
            }
            String userId2 = pVar.getAuthor().getUserId();
            if (this.esp != 0) {
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
            if (!this.esq) {
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
            bVar.esv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.esv.setText("");
            bVar.esv.setContentDescription("");
            com.baidu.tbadk.core.util.ap.i((View) bVar.esv, r.e.cp_link_tip_c);
            if (z5) {
                bVar.esv.setVisibility(0);
                bVar.esv.setText(this.mContext.getString(r.l.manage));
                bVar.esv.setContentDescription(this.mContext.getString(r.l.manage));
            } else if (z6) {
                bVar.esv.setVisibility(0);
                bVar.esv.setText(this.mContext.getString(r.l.mute));
                bVar.esv.setContentDescription(this.mContext.getString(r.l.mute));
            } else if (z8) {
                bVar.esv.setVisibility(0);
                bVar.esv.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_pb_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.esv.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.esv.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.esv.setTag(sparseArray2);
            }
            sparseArray2.put(r.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(r.h.tag_should_manage_visible, true);
                sparseArray2.put(r.h.tag_manage_user_identity, Integer.valueOf(this.esp));
                sparseArray2.put(r.h.tag_forbid_user_name, pVar.getAuthor().getUserName());
                sparseArray2.put(r.h.tag_forbid_user_post_id, pVar.getId());
            } else {
                sparseArray2.put(r.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.aLS != null) {
                    sparseArray2.put(r.h.tag_user_mute_visible, true);
                    sparseArray2.put(r.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (pVar.getAuthor() != null) {
                        sparseArray2.put(r.h.tag_user_mute_mute_userid, pVar.getAuthor().getUserId());
                        sparseArray2.put(r.h.tag_user_mute_mute_username, pVar.getAuthor().getUserName());
                    }
                    if (this.aLS.getId() != null) {
                        sparseArray2.put(r.h.tag_user_mute_thread_id, this.aLS.getId());
                    }
                    sparseArray2.put(r.h.tag_user_mute_post_id, pVar.getId());
                }
            } else {
                sparseArray2.put(r.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(r.h.tag_should_delete_visible, true);
                sparseArray2.put(r.h.tag_manage_user_identity, Integer.valueOf(this.esp));
                sparseArray2.put(r.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(r.h.tag_del_post_type, 2);
                sparseArray2.put(r.h.tag_del_post_id, pVar.getId());
            } else {
                sparseArray2.put(r.h.tag_should_delete_visible, false);
            }
            if (this.esr && z2 && this.erA) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.esu.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
                bVar.esu.setLayoutParams(layoutParams);
            }
            if (this.esr && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.esu.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
                bVar.esu.setLayoutParams(layoutParams2);
            }
            bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds12));
            bVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.tieba.tbadkCore.data.p pVar, boolean z) {
        TbRichText awW;
        SpannableStringBuilder Hw;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Hw2;
        if (pVar != null && (awW = pVar.awW()) != null) {
            ArrayList<TbRichTextData> Hq = awW.Hq();
            if (!com.baidu.tbadk.core.util.w.s(Hq)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Hq.get(Hq.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.at.r(pVar.getTime());
                        if (Hq.size() > 1) {
                            if ((Hq.get(Hq.size() + (-2)) != null ? Hq.get(Hq.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.at.r(pVar.getTime());
                                Hw2 = tbRichTextData2.Hw();
                                if (awW.hasAppendTime && Hw2 != 0 && awW.appendLength <= Hw2.length()) {
                                    Hw2.delete(Hw2.length() - awW.appendLength, Hw2.length());
                                }
                                String dA = com.baidu.tbadk.core.util.at.dA(str2);
                                if (Hw2 != null) {
                                    Hw2.append((CharSequence) dA);
                                }
                                awW.hasAppendTime = true;
                                awW.appendLength = dA.length();
                                tbRichTextData = tbRichTextData2;
                                str = dA;
                            }
                        }
                        str2 = str3;
                        Hw2 = tbRichTextData2.Hw();
                        if (awW.hasAppendTime) {
                            Hw2.delete(Hw2.length() - awW.appendLength, Hw2.length());
                        }
                        String dA2 = com.baidu.tbadk.core.util.at.dA(str2);
                        if (Hw2 != null) {
                        }
                        awW.hasAppendTime = true;
                        awW.appendLength = dA2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dA2;
                    } else if (awW.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = com.baidu.tbadk.core.util.at.r(pVar.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = com.baidu.tbadk.core.util.at.dA(r);
                        tbRichTextData.append(str);
                        awW.hasAppendTime = true;
                        awW.appendLength = str.length();
                        Hq.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.m.subtext_entelechy);
                    }
                    SpannableStringBuilder Hw3 = tbRichTextData.Hw();
                    if (Hw3 != null && str.length() <= Hw3.length()) {
                        Hw3.setSpan(textAppearanceSpan, Hw3.length() - str.length(), Hw3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Hq.get(Hq.size() - 1);
                if (awW.hasAppendTime && tbRichTextData3 != null && (Hw = tbRichTextData3.Hw()) != null && awW.appendLength <= Hw.length()) {
                    Hw.delete(Hw.length() - awW.appendLength, Hw.length());
                }
                awW.hasAppendTime = false;
                awW.appendLength = 0;
            }
        }
    }

    public void je(boolean z) {
        this.esr = z;
    }

    public void jf(boolean z) {
        this.erA = z;
    }

    public void oD(String str) {
        this.mPostId = str;
    }
}
