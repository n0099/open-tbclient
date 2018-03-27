package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private bd bZU;
    protected Context mContext;
    protected ArrayList<PostData> aRZ = null;
    protected View.OnClickListener gaA = null;
    protected int gaB = 0;
    protected boolean gaC = false;
    protected boolean gaD = false;
    protected boolean dfO = false;
    private boolean mIsFromCDN = true;
    private boolean gaE = false;
    private boolean bsJ = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void tm(int i) {
        this.mSelectedPosition = i;
    }

    public int qJ(String str) {
        if (this.aRZ == null) {
            return -1;
        }
        int size = this.aRZ.size();
        for (int i = 0; i < size; i++) {
            if (this.aRZ.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void T(bd bdVar) {
        this.bZU = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aRZ = new ArrayList<>();
        } else {
            this.aRZ = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.gaA = onClickListener;
    }

    public void P(int i, boolean z) {
        this.gaB = i;
        this.gaC = z;
    }

    public void setHasMoreData(boolean z) {
        this.dfO = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRZ == null) {
            return 0;
        }
        return this.aRZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRZ == null || i < 0 || i >= this.aRZ.size()) {
            return null;
        }
        return this.aRZ.get(i);
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
            if (postData.getType() == PostData.hbc) {
                view = bgN();
            } else {
                view = st();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.hbc) {
            view = st();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.hbc) {
            view = bgN();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.dfO && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView cHQ;
        public TbRichTextView fJr;
        public LinearLayout gaH;
        public View gaI;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bQq;
        public TextView gaF;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bQq = view.findViewById(d.g.divider_line);
            this.gaF = (TextView) view.findViewById(d.g.center_reply_text);
            this.gaF.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.t(this.bQq, d.C0141d.cp_cont_d);
                aj.r(this.gaF, d.C0141d.cp_cont_d);
                aj.t(this.gaF, d.C0141d.cp_bg_line_d);
                this.gaF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.au(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bgN() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View st() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.gaH = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.gaE) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gaH.getLayoutParams();
            layoutParams.topMargin = l.t(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.t(this.mContext, d.e.ds8);
            bVar.gaH.setLayoutParams(layoutParams);
        }
        bVar.cHQ = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fJr = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.gaI = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fJr.getLayoutStrategy().Rh();
        if (!this.gaE) {
            bVar.fJr.getLayoutStrategy().setLineSpacing(l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fJr.getLayoutStrategy().iS(0);
            bVar.fJr.getLayoutStrategy().iQ(l.t(this.mContext, d.e.tbds20));
            bVar.fJr.getLayoutStrategy().iR(l.t(this.mContext, d.e.tbds3));
        }
        bVar.fJr.setSubPbPost(true);
        bVar.fJr.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
        bVar.fJr.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fJr.setTextCenter(true);
        bVar.cHQ.setOnClickListener(this.gaA);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
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
                aj.t(bVar.rootView, d.C0141d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bwZ()) {
                bVar.gaI.setVisibility(0);
            } else {
                bVar.gaI.setVisibility(8);
            }
            bVar.fJr.setPadding(0, 0, 0, 0);
            if (postData.zn() != null) {
                String name_show = postData.zn().getName_show();
                String userId = postData.zn().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_photo_username, name_show);
                sparseArray.put(d.g.tag_photo_userid, userId);
                sparseArray.put(d.g.tag_clip_board, postData);
                sparseArray.put(d.g.tag_is_subpb, true);
            }
            bVar.fJr.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            bVar.fJr.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
            a(postData, this.gaE);
            TbRichText bxb = postData.bxb();
            if (bxb != null) {
                bVar.fJr.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fJr.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bxb.isChanged = true;
                }
                bVar.fJr.setText(bxb);
            }
            String userId2 = postData.zn().getUserId();
            if (this.gaB != 0) {
                boolean z9 = this.gaB != 1002;
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
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
            if (!this.gaC) {
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
            bVar.cHQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cHQ.setText("");
            bVar.cHQ.setContentDescription("");
            aj.r(bVar.cHQ, d.C0141d.cp_link_tip_c);
            if (z5) {
                bVar.cHQ.setVisibility(0);
                bVar.cHQ.setText(this.mContext.getString(d.j.manage));
                bVar.cHQ.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.cHQ.setVisibility(0);
                bVar.cHQ.setText(this.mContext.getString(d.j.mute));
                bVar.cHQ.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.cHQ.setVisibility(0);
                if (this.gaB == 1002 && !z7) {
                    bVar.cHQ.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.cHQ.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.cHQ.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cHQ.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cHQ.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.gaB));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bZU != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.zn() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                    }
                    if (this.bZU.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bZU.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.gaB));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.gaE && z2 && this.bsJ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gaH.getLayoutParams();
                layoutParams.topMargin = l.t(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.t(this.mContext, d.e.ds8);
                bVar.gaH.setLayoutParams(layoutParams);
            }
            if (this.gaE && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gaH.getLayoutParams();
                layoutParams2.topMargin = l.t(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.t(this.mContext, d.e.ds8);
                bVar.gaH.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bxb;
        SpannableStringBuilder Rp;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Rp2;
        if (postData != null && (bxb = postData.bxb()) != null) {
            ArrayList<TbRichTextData> Ri = bxb.Ri();
            if (!v.E(Ri)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Ri.get(Ri.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.z(postData.getTime());
                        if (Ri.size() > 1) {
                            if ((Ri.get(Ri.size() + (-2)) != null ? Ri.get(Ri.size() - 2).getType() : -1) != type) {
                                str2 = am.z(postData.getTime());
                                Rp2 = tbRichTextData2.Rp();
                                if (bxb.hasAppendTime && Rp2 != 0 && bxb.appendLength <= Rp2.length()) {
                                    Rp2.delete(Rp2.length() - bxb.appendLength, Rp2.length());
                                }
                                String eq = am.eq(str2);
                                if (Rp2 != null) {
                                    Rp2.append((CharSequence) eq);
                                }
                                bxb.hasAppendTime = true;
                                bxb.appendLength = eq.length();
                                tbRichTextData = tbRichTextData2;
                                str = eq;
                            }
                        }
                        str2 = str3;
                        Rp2 = tbRichTextData2.Rp();
                        if (bxb.hasAppendTime) {
                            Rp2.delete(Rp2.length() - bxb.appendLength, Rp2.length());
                        }
                        String eq2 = am.eq(str2);
                        if (Rp2 != null) {
                        }
                        bxb.hasAppendTime = true;
                        bxb.appendLength = eq2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eq2;
                    } else if (bxb.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String z2 = am.z(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.eq(z2);
                        tbRichTextData.append(str);
                        bxb.hasAppendTime = true;
                        bxb.appendLength = str.length();
                        Ri.add(tbRichTextData);
                    }
                    SpannableStringBuilder Rp3 = tbRichTextData.Rp();
                    if (Rp3 != null && str.length() <= Rp3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0141d.cp_cont_d));
                        Rp3.setSpan(absoluteSizeSpan, Rp3.length() - str.length(), Rp3.length(), 33);
                        Rp3.setSpan(foregroundColorSpan, Rp3.length() - str.length(), Rp3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Ri.get(Ri.size() - 1);
                if (bxb.hasAppendTime && tbRichTextData3 != null && (Rp = tbRichTextData3.Rp()) != null && bxb.appendLength <= Rp.length()) {
                    Rp.delete(Rp.length() - bxb.appendLength, Rp.length());
                }
                bxb.hasAppendTime = false;
                bxb.appendLength = 0;
            }
        }
    }

    public void lk(boolean z) {
        this.gaE = z;
    }

    public void ll(boolean z) {
        this.bsJ = z;
    }

    public void qK(String str) {
        this.mPostId = str;
    }
}
