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
    private bd cad;
    protected Context mContext;
    protected ArrayList<PostData> aSi = null;
    protected View.OnClickListener gav = null;
    protected int gaw = 0;
    protected boolean gax = false;
    protected boolean gay = false;
    protected boolean dfX = false;
    private boolean mIsFromCDN = true;
    private boolean gaz = false;
    private boolean bsT = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void tl(int i) {
        this.mSelectedPosition = i;
    }

    public int qJ(String str) {
        if (this.aSi == null) {
            return -1;
        }
        int size = this.aSi.size();
        for (int i = 0; i < size; i++) {
            if (this.aSi.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void T(bd bdVar) {
        this.cad = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aSi = new ArrayList<>();
        } else {
            this.aSi = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.gav = onClickListener;
    }

    public void P(int i, boolean z) {
        this.gaw = i;
        this.gax = z;
    }

    public void setHasMoreData(boolean z) {
        this.dfX = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSi == null) {
            return 0;
        }
        return this.aSi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aSi == null || i < 0 || i >= this.aSi.size()) {
            return null;
        }
        return this.aSi.get(i);
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
            if (postData.getType() == PostData.haT) {
                view = bgN();
            } else {
                view = st();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.haT) {
            view = st();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.haT) {
            view = bgN();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.dfX && i + 1 >= getCount();
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
        public TextView cHZ;
        public TbRichTextView fJm;
        public LinearLayout gaC;
        public View gaD;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bQA;
        public TextView gaA;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bQA = view.findViewById(d.g.divider_line);
            this.gaA = (TextView) view.findViewById(d.g.center_reply_text);
            this.gaA.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.t(this.bQA, d.C0140d.cp_cont_d);
                aj.r(this.gaA, d.C0140d.cp_cont_d);
                aj.t(this.gaA, d.C0140d.cp_bg_line_d);
                this.gaA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.au(i, d.f.icon_floor_arrow_n), (Drawable) null);
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
        bVar.gaC = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.gaz) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gaC.getLayoutParams();
            layoutParams.topMargin = l.t(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.t(this.mContext, d.e.ds8);
            bVar.gaC.setLayoutParams(layoutParams);
        }
        bVar.cHZ = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fJm = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.gaD = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fJm.getLayoutStrategy().Rh();
        if (!this.gaz) {
            bVar.fJm.getLayoutStrategy().setLineSpacing(l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fJm.getLayoutStrategy().iS(0);
            bVar.fJm.getLayoutStrategy().iQ(l.t(this.mContext, d.e.tbds20));
            bVar.fJm.getLayoutStrategy().iR(l.t(this.mContext, d.e.tbds3));
        }
        bVar.fJm.setSubPbPost(true);
        bVar.fJm.setTextColor(aj.getColor(d.C0140d.cp_cont_f));
        bVar.fJm.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fJm.setTextCenter(true);
        bVar.cHZ.setOnClickListener(this.gav);
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
                aj.t(bVar.rootView, d.C0140d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bwV()) {
                bVar.gaD.setVisibility(0);
            } else {
                bVar.gaD.setVisibility(8);
            }
            bVar.fJm.setPadding(0, 0, 0, 0);
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
            bVar.fJm.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
            bVar.fJm.setTextColor(aj.getColor(d.C0140d.cp_cont_f));
            a(postData, this.gaz);
            TbRichText bwX = postData.bwX();
            if (bwX != null) {
                bVar.fJm.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fJm.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bwX.isChanged = true;
                }
                bVar.fJm.setText(bwX);
            }
            String userId2 = postData.zn().getUserId();
            if (this.gaw != 0) {
                boolean z9 = this.gaw != 1002;
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
            if (!this.gax) {
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
            bVar.cHZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cHZ.setText("");
            bVar.cHZ.setContentDescription("");
            aj.r(bVar.cHZ, d.C0140d.cp_link_tip_c);
            if (z5) {
                bVar.cHZ.setVisibility(0);
                bVar.cHZ.setText(this.mContext.getString(d.j.manage));
                bVar.cHZ.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.cHZ.setVisibility(0);
                bVar.cHZ.setText(this.mContext.getString(d.j.mute));
                bVar.cHZ.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.cHZ.setVisibility(0);
                if (this.gaw == 1002 && !z7) {
                    bVar.cHZ.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.cHZ.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.cHZ.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cHZ.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cHZ.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.gaw));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.cad != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.zn() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                    }
                    if (this.cad.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.cad.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.gaw));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.gaz && z2 && this.bsT) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gaC.getLayoutParams();
                layoutParams.topMargin = l.t(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.t(this.mContext, d.e.ds8);
                bVar.gaC.setLayoutParams(layoutParams);
            }
            if (this.gaz && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gaC.getLayoutParams();
                layoutParams2.topMargin = l.t(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.t(this.mContext, d.e.ds8);
                bVar.gaC.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bwX;
        SpannableStringBuilder Rp;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Rp2;
        if (postData != null && (bwX = postData.bwX()) != null) {
            ArrayList<TbRichTextData> Ri = bwX.Ri();
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
                                if (bwX.hasAppendTime && Rp2 != 0 && bwX.appendLength <= Rp2.length()) {
                                    Rp2.delete(Rp2.length() - bwX.appendLength, Rp2.length());
                                }
                                String eq = am.eq(str2);
                                if (Rp2 != null) {
                                    Rp2.append((CharSequence) eq);
                                }
                                bwX.hasAppendTime = true;
                                bwX.appendLength = eq.length();
                                tbRichTextData = tbRichTextData2;
                                str = eq;
                            }
                        }
                        str2 = str3;
                        Rp2 = tbRichTextData2.Rp();
                        if (bwX.hasAppendTime) {
                            Rp2.delete(Rp2.length() - bwX.appendLength, Rp2.length());
                        }
                        String eq2 = am.eq(str2);
                        if (Rp2 != null) {
                        }
                        bwX.hasAppendTime = true;
                        bwX.appendLength = eq2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eq2;
                    } else if (bwX.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String z2 = am.z(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.eq(z2);
                        tbRichTextData.append(str);
                        bwX.hasAppendTime = true;
                        bwX.appendLength = str.length();
                        Ri.add(tbRichTextData);
                    }
                    SpannableStringBuilder Rp3 = tbRichTextData.Rp();
                    if (Rp3 != null && str.length() <= Rp3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0140d.cp_cont_d));
                        Rp3.setSpan(absoluteSizeSpan, Rp3.length() - str.length(), Rp3.length(), 33);
                        Rp3.setSpan(foregroundColorSpan, Rp3.length() - str.length(), Rp3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Ri.get(Ri.size() - 1);
                if (bwX.hasAppendTime && tbRichTextData3 != null && (Rp = tbRichTextData3.Rp()) != null && bwX.appendLength <= Rp.length()) {
                    Rp.delete(Rp.length() - bwX.appendLength, Rp.length());
                }
                bwX.hasAppendTime = false;
                bwX.appendLength = 0;
            }
        }
    }

    public void lf(boolean z) {
        this.gaz = z;
    }

    public void lg(boolean z) {
        this.bsT = z;
    }

    public void qK(String str) {
        this.mPostId = str;
    }
}
