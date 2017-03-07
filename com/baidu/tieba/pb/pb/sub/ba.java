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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bj aRF;
    protected Context mContext;
    protected ArrayList<PostData> aaY = null;
    protected View.OnClickListener evC = null;
    protected int evD = 0;
    protected boolean evE = false;
    protected boolean emx = false;
    protected boolean bAW = false;
    private boolean mIsFromCDN = true;
    private boolean evF = false;
    private boolean euO = false;
    private String mPostId = "";
    private int ckM = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void oA(int i) {
        this.ckM = i;
    }

    public int nK(String str) {
        if (this.aaY == null) {
            return -1;
        }
        int size = this.aaY.size();
        for (int i = 0; i < size; i++) {
            if (this.aaY.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void h(bj bjVar) {
        this.aRF = bjVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aaY = new ArrayList<>();
        } else {
            this.aaY = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.evC = onClickListener;
    }

    public void B(int i, boolean z) {
        this.evD = i;
        this.evE = z;
    }

    public void setHasMoreData(boolean z) {
        this.bAW = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaY == null) {
            return 0;
        }
        return this.aaY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aaY == null || i < 0 || i >= this.aaY.size()) {
            return null;
        }
        return this.aaY.get(i);
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
            if (postData.getType() == PostData.fup) {
                view = aOC();
            } else {
                view = la();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.fup) {
            view = la();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.fup) {
            view = aOC();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(w.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bAW && i + 1 >= getCount();
            boolean z2 = i == this.ckM;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.ckM = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TbRichTextView ejz;
        public LinearLayout evI;
        public TextView evJ;
        public View evK;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aTF;
        public TextView evG;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aTF = view.findViewById(w.h.divider_line);
            this.evG = (TextView) view.findViewById(w.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.aq.k(this.aTF, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.i((View) this.evG, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.k(this.evG, w.e.cp_bg_line_d);
                this.evG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.x(i, w.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aOC() {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View la() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.evI = (LinearLayout) inflate.findViewById(w.h.sub_pb_item_columnlayout);
        if (this.evF) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.evI.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            bVar.evI.setLayoutParams(layoutParams);
        }
        bVar.evJ = (TextView) inflate.findViewById(w.h.manage_btn);
        bVar.ejz = (TbRichTextView) inflate.findViewById(w.h.new_sub_pb_list_richText);
        bVar.evK = inflate.findViewById(w.h.divide_bottom_view);
        bVar.ejz.ID();
        bVar.ejz.setSubPbPost(true);
        bVar.ejz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
        bVar.ejz.setTextCenter(true);
        bVar.evJ.setOnClickListener(this.evC);
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
            if (postData.bhE()) {
                bVar.evK.setVisibility(0);
            } else {
                bVar.evK.setVisibility(8);
            }
            bVar.ejz.setPadding(0, 0, 0, 0);
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
            bVar.ejz.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            bVar.ejz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
            a(postData, this.evF);
            TbRichText aws = postData.aws();
            if (aws != null) {
                bVar.ejz.setVoiceViewRes(w.j.voice_play_btn_new);
                bVar.ejz.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    aws.isChanged = true;
                }
                bVar.ejz.setText(aws);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.evD != 0) {
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
            if (!this.evE) {
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
            bVar.evJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.evJ.setText("");
            bVar.evJ.setContentDescription("");
            com.baidu.tbadk.core.util.aq.i((View) bVar.evJ, w.e.cp_link_tip_c);
            if (z5) {
                bVar.evJ.setVisibility(0);
                bVar.evJ.setText(this.mContext.getString(w.l.manage));
                bVar.evJ.setContentDescription(this.mContext.getString(w.l.manage));
            } else if (z6) {
                bVar.evJ.setVisibility(0);
                bVar.evJ.setText(this.mContext.getString(w.l.mute));
                bVar.evJ.setContentDescription(this.mContext.getString(w.l.mute));
            } else if (z8) {
                bVar.evJ.setVisibility(0);
                bVar.evJ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.evJ.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.evJ.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.evJ.setTag(sparseArray2);
            }
            sparseArray2.put(w.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(w.h.tag_should_manage_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.evD));
                sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.aRF != null) {
                    sparseArray2.put(w.h.tag_user_mute_visible, true);
                    sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.aRF.getId() != null) {
                        sparseArray2.put(w.h.tag_user_mute_thread_id, this.aRF.getId());
                    }
                    sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(w.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(w.h.tag_should_delete_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.evD));
                sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(w.h.tag_del_post_type, 2);
                sparseArray2.put(w.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_delete_visible, false);
            }
            if (this.evF && z2 && this.euO) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.evI.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.evI.setLayoutParams(layoutParams);
            }
            if (this.evF && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.evI.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.evI.setLayoutParams(layoutParams2);
            }
            bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds12));
            bVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aws;
        SpannableStringBuilder HW;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder HW2;
        if (postData != null && (aws = postData.aws()) != null) {
            ArrayList<TbRichTextData> HP = aws.HP();
            if (!com.baidu.tbadk.core.util.x.q(HP)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = HP.get(HP.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.au.q(postData.getTime());
                        if (HP.size() > 1) {
                            if ((HP.get(HP.size() + (-2)) != null ? HP.get(HP.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.au.q(postData.getTime());
                                HW2 = tbRichTextData2.HW();
                                if (aws.hasAppendTime && HW2 != 0 && aws.appendLength <= HW2.length()) {
                                    HW2.delete(HW2.length() - aws.appendLength, HW2.length());
                                }
                                String dt = com.baidu.tbadk.core.util.au.dt(str2);
                                if (HW2 != null) {
                                    HW2.append((CharSequence) dt);
                                }
                                aws.hasAppendTime = true;
                                aws.appendLength = dt.length();
                                tbRichTextData = tbRichTextData2;
                                str = dt;
                            }
                        }
                        str2 = str3;
                        HW2 = tbRichTextData2.HW();
                        if (aws.hasAppendTime) {
                            HW2.delete(HW2.length() - aws.appendLength, HW2.length());
                        }
                        String dt2 = com.baidu.tbadk.core.util.au.dt(str2);
                        if (HW2 != null) {
                        }
                        aws.hasAppendTime = true;
                        aws.appendLength = dt2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dt2;
                    } else if (aws.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String q = com.baidu.tbadk.core.util.au.q(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = com.baidu.tbadk.core.util.au.dt(q);
                        tbRichTextData.append(str);
                        aws.hasAppendTime = true;
                        aws.appendLength = str.length();
                        HP.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy);
                    }
                    SpannableStringBuilder HW3 = tbRichTextData.HW();
                    if (HW3 != null && str.length() <= HW3.length()) {
                        HW3.setSpan(textAppearanceSpan, HW3.length() - str.length(), HW3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = HP.get(HP.size() - 1);
                if (aws.hasAppendTime && tbRichTextData3 != null && (HW = tbRichTextData3.HW()) != null && aws.appendLength <= HW.length()) {
                    HW.delete(HW.length() - aws.appendLength, HW.length());
                }
                aws.hasAppendTime = false;
                aws.appendLength = 0;
            }
        }
    }

    public void ja(boolean z) {
        this.evF = z;
    }

    public void jb(boolean z) {
        this.euO = z;
    }

    public void nL(String str) {
        this.mPostId = str;
    }
}
