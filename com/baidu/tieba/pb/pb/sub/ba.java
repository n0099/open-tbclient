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
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bk aSs;
    protected Context mContext;
    protected ArrayList<PostData> aaJ = null;
    protected View.OnClickListener erF = null;
    protected int erG = 0;
    protected boolean erH = false;
    protected boolean eio = false;
    protected boolean bDh = false;
    private boolean mIsFromCDN = true;
    private boolean erI = false;
    private boolean eqS = false;
    private String mPostId = "";
    private int ciA = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void ou(int i) {
        this.ciA = i;
    }

    public int nV(String str) {
        if (this.aaJ == null) {
            return -1;
        }
        int size = this.aaJ.size();
        for (int i = 0; i < size; i++) {
            if (this.aaJ.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void m(bk bkVar) {
        this.aSs = bkVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aaJ = new ArrayList<>();
        } else {
            this.aaJ = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.erF = onClickListener;
    }

    public void A(int i, boolean z) {
        this.erG = i;
        this.erH = z;
    }

    public void setHasMoreData(boolean z) {
        this.bDh = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaJ == null) {
            return 0;
        }
        return this.aaJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aaJ == null || i < 0 || i >= this.aaJ.size()) {
            return null;
        }
        return this.aaJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.fuu) {
                view = aNc();
            } else {
                view = le();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.fuu) {
            view = le();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.fuu) {
            view = aNc();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(w.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bDh && i + 1 >= getCount();
            boolean z2 = i == this.ciA;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.ciA = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TbRichTextView eeZ;
        public LinearLayout erL;
        public TextView erM;
        public View erN;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aUr;
        public TextView erJ;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aUr = view.findViewById(w.h.divider_line);
            this.erJ = (TextView) view.findViewById(w.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.aq.k(this.aUr, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.i(this.erJ, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.k(this.erJ, w.e.cp_bg_line_d);
                this.erJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.v(i, w.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aNc() {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View le() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.erL = (LinearLayout) inflate.findViewById(w.h.sub_pb_item_columnlayout);
        if (this.erI) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.erL.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            bVar.erL.setLayoutParams(layoutParams);
        }
        bVar.erM = (TextView) inflate.findViewById(w.h.manage_btn);
        bVar.eeZ = (TbRichTextView) inflate.findViewById(w.h.new_sub_pb_list_richText);
        bVar.erN = inflate.findViewById(w.h.divide_bottom_view);
        bVar.eeZ.Iq();
        bVar.eeZ.setSubPbPost(true);
        bVar.eeZ.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
        bVar.eeZ.setTextCenter(true);
        bVar.erM.setOnClickListener(this.erF);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (bVar != null && postData != null) {
            if (z3) {
                com.baidu.tbadk.core.util.aq.k(bVar.rootView, w.e.sub_pb_selected);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bgN()) {
                bVar.erN.setVisibility(0);
            } else {
                bVar.erN.setVisibility(8);
            }
            bVar.eeZ.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String userName = postData.getAuthor().getUserName();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_photo_username, userName);
                sparseArray.put(w.h.tag_photo_userid, userId);
                sparseArray.put(w.h.tag_clip_board, postData);
                sparseArray.put(w.h.tag_is_subpb, true);
            }
            bVar.eeZ.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            bVar.eeZ.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
            a(postData, this.erI);
            TbRichText aui = postData.aui();
            if (aui != null) {
                bVar.eeZ.setVoiceViewRes(w.j.voice_play_btn_new);
                bVar.eeZ.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    aui.isChanged = true;
                }
                bVar.eeZ.setText(aui);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.erG != 0) {
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
            if (!this.erH) {
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
            bVar.erM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.erM.setText("");
            bVar.erM.setContentDescription("");
            com.baidu.tbadk.core.util.aq.i(bVar.erM, w.e.cp_link_tip_c);
            if (z5) {
                bVar.erM.setVisibility(0);
                bVar.erM.setText(this.mContext.getString(w.l.manage));
                bVar.erM.setContentDescription(this.mContext.getString(w.l.manage));
            } else if (z6) {
                bVar.erM.setVisibility(0);
                bVar.erM.setText(this.mContext.getString(w.l.mute));
                bVar.erM.setContentDescription(this.mContext.getString(w.l.mute));
            } else if (z8) {
                bVar.erM.setVisibility(0);
                bVar.erM.setText(this.mContext.getString(w.l.delete));
            } else {
                bVar.erM.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.erM.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.erM.setTag(sparseArray2);
            }
            sparseArray2.put(w.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(w.h.tag_should_manage_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.erG));
                sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.aSs != null) {
                    sparseArray2.put(w.h.tag_user_mute_visible, true);
                    sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.aSs.getId() != null) {
                        sparseArray2.put(w.h.tag_user_mute_thread_id, this.aSs.getId());
                    }
                    sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(w.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(w.h.tag_should_delete_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.erG));
                sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(w.h.tag_del_post_type, 2);
                sparseArray2.put(w.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_delete_visible, false);
            }
            if (this.erI && z2 && this.eqS) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.erL.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.erL.setLayoutParams(layoutParams);
            }
            if (this.erI && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.erL.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.erL.setLayoutParams(layoutParams2);
            }
            bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10));
            bVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aui;
        SpannableStringBuilder HJ;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder HJ2;
        if (postData != null && (aui = postData.aui()) != null) {
            ArrayList<TbRichTextData> HC = aui.HC();
            if (!com.baidu.tbadk.core.util.x.r(HC)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = HC.get(HC.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.au.q(postData.getTime());
                        if (HC.size() > 1) {
                            if ((HC.get(HC.size() + (-2)) != null ? HC.get(HC.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.au.q(postData.getTime());
                                HJ2 = tbRichTextData2.HJ();
                                if (aui.hasAppendTime && HJ2 != 0 && aui.appendLength <= HJ2.length()) {
                                    HJ2.delete(HJ2.length() - aui.appendLength, HJ2.length());
                                }
                                String dx = com.baidu.tbadk.core.util.au.dx(str2);
                                if (HJ2 != null) {
                                    HJ2.append((CharSequence) dx);
                                }
                                aui.hasAppendTime = true;
                                aui.appendLength = dx.length();
                                tbRichTextData = tbRichTextData2;
                                str = dx;
                            }
                        }
                        str2 = str3;
                        HJ2 = tbRichTextData2.HJ();
                        if (aui.hasAppendTime) {
                            HJ2.delete(HJ2.length() - aui.appendLength, HJ2.length());
                        }
                        String dx2 = com.baidu.tbadk.core.util.au.dx(str2);
                        if (HJ2 != null) {
                        }
                        aui.hasAppendTime = true;
                        aui.appendLength = dx2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dx2;
                    } else if (aui.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String q = com.baidu.tbadk.core.util.au.q(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = com.baidu.tbadk.core.util.au.dx(q);
                        tbRichTextData.append(str);
                        aui.hasAppendTime = true;
                        aui.appendLength = str.length();
                        HC.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy);
                    }
                    SpannableStringBuilder HJ3 = tbRichTextData.HJ();
                    if (HJ3 != null && str.length() <= HJ3.length()) {
                        HJ3.setSpan(textAppearanceSpan, HJ3.length() - str.length(), HJ3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = HC.get(HC.size() - 1);
                if (aui.hasAppendTime && tbRichTextData3 != null && (HJ = tbRichTextData3.HJ()) != null && aui.appendLength <= HJ.length()) {
                    HJ.delete(HJ.length() - aui.appendLength, HJ.length());
                }
                aui.hasAppendTime = false;
                aui.appendLength = 0;
            }
        }
    }

    public void iO(boolean z) {
        this.erI = z;
    }

    public void iP(boolean z) {
        this.eqS = z;
    }

    public void nW(String str) {
        this.mPostId = str;
    }
}
