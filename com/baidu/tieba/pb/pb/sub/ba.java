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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bm bdI;
    protected Context mContext;
    protected ArrayList<PostData> aaJ = null;
    protected View.OnClickListener eIo = null;
    protected int eIp = 0;
    protected boolean eIq = false;
    protected boolean exa = false;
    protected boolean bJO = false;
    private boolean mIsFromCDN = true;
    private boolean eIr = false;
    private boolean eHA = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pl(int i) {
        this.mSelectedPosition = i;
    }

    public int pd(String str) {
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

    public void O(bm bmVar) {
        this.bdI = bmVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aaJ = new ArrayList<>();
        } else {
            this.aaJ = arrayList;
        }
    }

    public void K(View.OnClickListener onClickListener) {
        this.eIo = onClickListener;
    }

    public void A(int i, boolean z) {
        this.eIp = i;
        this.eIq = z;
    }

    public void setHasMoreData(boolean z) {
        this.bJO = z;
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
            if (postData.getType() == PostData.fMp) {
                view = aSk();
            } else {
                view = lc();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.fMp) {
            view = lc();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.fMp) {
            view = aSk();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(w.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bJO && i + 1 >= getCount();
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
        public TextView bqO;
        public LinearLayout eIu;
        public View eIv;
        public TbRichTextView ety;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aTm;
        public TextView eIs;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aTm = view.findViewById(w.h.divider_line);
            this.eIs = (TextView) view.findViewById(w.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.as.k(this.aTm, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.as.i(this.eIs, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.as.k(this.eIs, w.e.cp_bg_line_d);
                this.eIs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.as.u(i, w.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aSk() {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View lc() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eIu = (LinearLayout) inflate.findViewById(w.h.sub_pb_item_columnlayout);
        if (this.eIr) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eIu.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            bVar.eIu.setLayoutParams(layoutParams);
        }
        bVar.bqO = (TextView) inflate.findViewById(w.h.manage_btn);
        bVar.ety = (TbRichTextView) inflate.findViewById(w.h.new_sub_pb_list_richText);
        bVar.eIv = inflate.findViewById(w.h.divide_bottom_view);
        bVar.ety.IJ();
        bVar.ety.setSubPbPost(true);
        bVar.ety.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_f));
        bVar.ety.setTextCenter(true);
        bVar.bqO.setOnClickListener(this.eIo);
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
                com.baidu.tbadk.core.util.as.k(bVar.rootView, w.e.sub_pb_selected);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bmv()) {
                bVar.eIv.setVisibility(0);
            } else {
                bVar.eIv.setVisibility(8);
            }
            bVar.ety.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_photo_username, name_show);
                sparseArray.put(w.h.tag_photo_userid, userId);
                sparseArray.put(w.h.tag_clip_board, postData);
                sparseArray.put(w.h.tag_is_subpb, true);
            }
            bVar.ety.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
            bVar.ety.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_f));
            a(postData, this.eIr);
            TbRichText azb = postData.azb();
            if (azb != null) {
                bVar.ety.setVoiceViewRes(w.j.voice_play_btn_new);
                bVar.ety.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    azb.isChanged = true;
                }
                bVar.ety.setText(azb);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eIp != 0) {
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
            if (!this.eIq) {
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
            bVar.bqO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bqO.setText("");
            bVar.bqO.setContentDescription("");
            com.baidu.tbadk.core.util.as.i(bVar.bqO, w.e.cp_link_tip_c);
            if (z5) {
                bVar.bqO.setVisibility(0);
                bVar.bqO.setText(this.mContext.getString(w.l.manage));
                bVar.bqO.setContentDescription(this.mContext.getString(w.l.manage));
            } else if (z6) {
                bVar.bqO.setVisibility(0);
                bVar.bqO.setText(this.mContext.getString(w.l.mute));
                bVar.bqO.setContentDescription(this.mContext.getString(w.l.mute));
            } else if (z8) {
                bVar.bqO.setVisibility(0);
                bVar.bqO.setText(this.mContext.getString(w.l.delete));
            } else {
                bVar.bqO.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bqO.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bqO.setTag(sparseArray2);
            }
            sparseArray2.put(w.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(w.h.tag_should_manage_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eIp));
                sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bdI != null) {
                    sparseArray2.put(w.h.tag_user_mute_visible, true);
                    sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bdI.getId() != null) {
                        sparseArray2.put(w.h.tag_user_mute_thread_id, this.bdI.getId());
                    }
                    sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(w.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(w.h.tag_should_delete_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eIp));
                sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(w.h.tag_del_post_type, 2);
                sparseArray2.put(w.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_delete_visible, false);
            }
            if (this.eIr && z2 && this.eHA) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eIu.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.eIu.setLayoutParams(layoutParams);
            }
            if (this.eIr && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eIu.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.eIu.setLayoutParams(layoutParams2);
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
        TbRichText azb;
        SpannableStringBuilder Ib;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Ib2;
        if (postData != null && (azb = postData.azb()) != null) {
            ArrayList<TbRichTextData> HU = azb.HU();
            if (!com.baidu.tbadk.core.util.z.t(HU)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = HU.get(HU.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.aw.q(postData.getTime());
                        if (HU.size() > 1) {
                            if ((HU.get(HU.size() + (-2)) != null ? HU.get(HU.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.aw.q(postData.getTime());
                                Ib2 = tbRichTextData2.Ib();
                                if (azb.hasAppendTime && Ib2 != 0 && azb.appendLength <= Ib2.length()) {
                                    Ib2.delete(Ib2.length() - azb.appendLength, Ib2.length());
                                }
                                String dO = com.baidu.tbadk.core.util.aw.dO(str2);
                                if (Ib2 != null) {
                                    Ib2.append((CharSequence) dO);
                                }
                                azb.hasAppendTime = true;
                                azb.appendLength = dO.length();
                                tbRichTextData = tbRichTextData2;
                                str = dO;
                            }
                        }
                        str2 = str3;
                        Ib2 = tbRichTextData2.Ib();
                        if (azb.hasAppendTime) {
                            Ib2.delete(Ib2.length() - azb.appendLength, Ib2.length());
                        }
                        String dO2 = com.baidu.tbadk.core.util.aw.dO(str2);
                        if (Ib2 != null) {
                        }
                        azb.hasAppendTime = true;
                        azb.appendLength = dO2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dO2;
                    } else if (azb.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String q = com.baidu.tbadk.core.util.aw.q(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = com.baidu.tbadk.core.util.aw.dO(q);
                        tbRichTextData.append(str);
                        azb.hasAppendTime = true;
                        azb.appendLength = str.length();
                        HU.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy);
                    }
                    SpannableStringBuilder Ib3 = tbRichTextData.Ib();
                    if (Ib3 != null && str.length() <= Ib3.length()) {
                        Ib3.setSpan(textAppearanceSpan, Ib3.length() - str.length(), Ib3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = HU.get(HU.size() - 1);
                if (azb.hasAppendTime && tbRichTextData3 != null && (Ib = tbRichTextData3.Ib()) != null && azb.appendLength <= Ib.length()) {
                    Ib.delete(Ib.length() - azb.appendLength, Ib.length());
                }
                azb.hasAppendTime = false;
                azb.appendLength = 0;
            }
        }
    }

    public void jE(boolean z) {
        this.eIr = z;
    }

    public void jF(boolean z) {
        this.eHA = z;
    }

    public void pe(String str) {
        this.mPostId = str;
    }
}
