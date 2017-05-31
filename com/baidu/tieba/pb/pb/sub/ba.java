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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bl bbF;
    protected Context mContext;
    protected ArrayList<PostData> aaI = null;
    protected View.OnClickListener eyR = null;
    protected int eyS = 0;
    protected boolean eyT = false;
    protected boolean enU = false;
    protected boolean bIW = false;
    private boolean mIsFromCDN = true;
    private boolean eyU = false;
    private boolean eyc = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void oS(int i) {
        this.mSelectedPosition = i;
    }

    public int oj(String str) {
        if (this.aaI == null) {
            return -1;
        }
        int size = this.aaI.size();
        for (int i = 0; i < size; i++) {
            if (this.aaI.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void N(bl blVar) {
        this.bbF = blVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aaI = new ArrayList<>();
        } else {
            this.aaI = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.eyR = onClickListener;
    }

    public void A(int i, boolean z) {
        this.eyS = i;
        this.eyT = z;
    }

    public void setHasMoreData(boolean z) {
        this.bIW = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaI == null) {
            return 0;
        }
        return this.aaI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aaI == null || i < 0 || i >= this.aaI.size()) {
            return null;
        }
        return this.aaI.get(i);
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
            if (postData.getType() == PostData.fCl) {
                view = aOl();
            } else {
                view = le();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.fCl) {
            view = le();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.fCl) {
            view = aOl();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(w.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bIW && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TbRichTextView ekz;
        public LinearLayout eyX;
        public TextView eyY;
        public View eyZ;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aRT;
        public TextView eyV;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aRT = view.findViewById(w.h.divider_line);
            this.eyV = (TextView) view.findViewById(w.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.aq.k(this.aRT, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.i(this.eyV, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.k(this.eyV, w.e.cp_bg_line_d);
                this.eyV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.u(i, w.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aOl() {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View le() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eyX = (LinearLayout) inflate.findViewById(w.h.sub_pb_item_columnlayout);
        if (this.eyU) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eyX.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            bVar.eyX.setLayoutParams(layoutParams);
        }
        bVar.eyY = (TextView) inflate.findViewById(w.h.manage_btn);
        bVar.ekz = (TbRichTextView) inflate.findViewById(w.h.new_sub_pb_list_richText);
        bVar.eyZ = inflate.findViewById(w.h.divide_bottom_view);
        bVar.ekz.Il();
        bVar.ekz.setSubPbPost(true);
        bVar.ekz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
        bVar.ekz.setTextCenter(true);
        bVar.eyY.setOnClickListener(this.eyR);
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
            if (postData.bih()) {
                bVar.eyZ.setVisibility(0);
            } else {
                bVar.eyZ.setVisibility(8);
            }
            bVar.ekz.setPadding(0, 0, 0, 0);
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
            bVar.ekz.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            bVar.ekz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
            a(postData, this.eyU);
            TbRichText avd = postData.avd();
            if (avd != null) {
                bVar.ekz.setVoiceViewRes(w.j.voice_play_btn_new);
                bVar.ekz.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    avd.isChanged = true;
                }
                bVar.ekz.setText(avd);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eyS != 0) {
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
            if (!this.eyT) {
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
            bVar.eyY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.eyY.setText("");
            bVar.eyY.setContentDescription("");
            com.baidu.tbadk.core.util.aq.i(bVar.eyY, w.e.cp_link_tip_c);
            if (z5) {
                bVar.eyY.setVisibility(0);
                bVar.eyY.setText(this.mContext.getString(w.l.manage));
                bVar.eyY.setContentDescription(this.mContext.getString(w.l.manage));
            } else if (z6) {
                bVar.eyY.setVisibility(0);
                bVar.eyY.setText(this.mContext.getString(w.l.mute));
                bVar.eyY.setContentDescription(this.mContext.getString(w.l.mute));
            } else if (z8) {
                bVar.eyY.setVisibility(0);
                bVar.eyY.setText(this.mContext.getString(w.l.delete));
            } else {
                bVar.eyY.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.eyY.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.eyY.setTag(sparseArray2);
            }
            sparseArray2.put(w.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(w.h.tag_should_manage_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eyS));
                sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bbF != null) {
                    sparseArray2.put(w.h.tag_user_mute_visible, true);
                    sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bbF.getId() != null) {
                        sparseArray2.put(w.h.tag_user_mute_thread_id, this.bbF.getId());
                    }
                    sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(w.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(w.h.tag_should_delete_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eyS));
                sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(w.h.tag_del_post_type, 2);
                sparseArray2.put(w.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_delete_visible, false);
            }
            if (this.eyU && z2 && this.eyc) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eyX.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.eyX.setLayoutParams(layoutParams);
            }
            if (this.eyU && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eyX.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.eyX.setLayoutParams(layoutParams2);
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
        TbRichText avd;
        SpannableStringBuilder HE;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder HE2;
        if (postData != null && (avd = postData.avd()) != null) {
            ArrayList<TbRichTextData> Hx = avd.Hx();
            if (!com.baidu.tbadk.core.util.x.r(Hx)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Hx.get(Hx.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.au.q(postData.getTime());
                        if (Hx.size() > 1) {
                            if ((Hx.get(Hx.size() + (-2)) != null ? Hx.get(Hx.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.au.q(postData.getTime());
                                HE2 = tbRichTextData2.HE();
                                if (avd.hasAppendTime && HE2 != 0 && avd.appendLength <= HE2.length()) {
                                    HE2.delete(HE2.length() - avd.appendLength, HE2.length());
                                }
                                String du = com.baidu.tbadk.core.util.au.du(str2);
                                if (HE2 != null) {
                                    HE2.append((CharSequence) du);
                                }
                                avd.hasAppendTime = true;
                                avd.appendLength = du.length();
                                tbRichTextData = tbRichTextData2;
                                str = du;
                            }
                        }
                        str2 = str3;
                        HE2 = tbRichTextData2.HE();
                        if (avd.hasAppendTime) {
                            HE2.delete(HE2.length() - avd.appendLength, HE2.length());
                        }
                        String du2 = com.baidu.tbadk.core.util.au.du(str2);
                        if (HE2 != null) {
                        }
                        avd.hasAppendTime = true;
                        avd.appendLength = du2.length();
                        tbRichTextData = tbRichTextData2;
                        str = du2;
                    } else if (avd.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String q = com.baidu.tbadk.core.util.au.q(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = com.baidu.tbadk.core.util.au.du(q);
                        tbRichTextData.append(str);
                        avd.hasAppendTime = true;
                        avd.appendLength = str.length();
                        Hx.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy);
                    }
                    SpannableStringBuilder HE3 = tbRichTextData.HE();
                    if (HE3 != null && str.length() <= HE3.length()) {
                        HE3.setSpan(textAppearanceSpan, HE3.length() - str.length(), HE3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Hx.get(Hx.size() - 1);
                if (avd.hasAppendTime && tbRichTextData3 != null && (HE = tbRichTextData3.HE()) != null && avd.appendLength <= HE.length()) {
                    HE.delete(HE.length() - avd.appendLength, HE.length());
                }
                avd.hasAppendTime = false;
                avd.appendLength = 0;
            }
        }
    }

    public void jg(boolean z) {
        this.eyU = z;
    }

    public void jh(boolean z) {
        this.eyc = z;
    }

    public void ok(String str) {
        this.mPostId = str;
    }
}
