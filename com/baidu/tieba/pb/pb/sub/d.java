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
    private bd bZR;
    protected Context mContext;
    protected ArrayList<PostData> aRX = null;
    protected View.OnClickListener gak = null;
    protected int gal = 0;
    protected boolean gam = false;
    protected boolean gan = false;
    protected boolean dfL = false;
    private boolean mIsFromCDN = true;
    private boolean gao = false;
    private boolean bsG = false;
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
        if (this.aRX == null) {
            return -1;
        }
        int size = this.aRX.size();
        for (int i = 0; i < size; i++) {
            if (this.aRX.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void T(bd bdVar) {
        this.bZR = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aRX = new ArrayList<>();
        } else {
            this.aRX = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.gak = onClickListener;
    }

    public void P(int i, boolean z) {
        this.gal = i;
        this.gam = z;
    }

    public void setHasMoreData(boolean z) {
        this.dfL = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRX == null) {
            return 0;
        }
        return this.aRX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRX == null || i < 0 || i >= this.aRX.size()) {
            return null;
        }
        return this.aRX.get(i);
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
            if (postData.getType() == PostData.haE) {
                view = bgM();
            } else {
                view = st();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.haE) {
            view = st();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.haE) {
            view = bgM();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.dfL && i + 1 >= getCount();
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
        public TextView cHN;
        public TbRichTextView fJb;
        public LinearLayout gar;
        public View gas;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bQn;
        public TextView gap;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bQn = view.findViewById(d.g.divider_line);
            this.gap = (TextView) view.findViewById(d.g.center_reply_text);
            this.gap.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.t(this.bQn, d.C0141d.cp_cont_d);
                aj.r(this.gap, d.C0141d.cp_cont_d);
                aj.t(this.gap, d.C0141d.cp_bg_line_d);
                this.gap.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.au(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bgM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View st() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.gar = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.gao) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gar.getLayoutParams();
            layoutParams.topMargin = l.t(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.t(this.mContext, d.e.ds8);
            bVar.gar.setLayoutParams(layoutParams);
        }
        bVar.cHN = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fJb = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.gas = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fJb.getLayoutStrategy().Rg();
        if (!this.gao) {
            bVar.fJb.getLayoutStrategy().setLineSpacing(l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fJb.getLayoutStrategy().iS(0);
            bVar.fJb.getLayoutStrategy().iQ(l.t(this.mContext, d.e.tbds20));
            bVar.fJb.getLayoutStrategy().iR(l.t(this.mContext, d.e.tbds3));
        }
        bVar.fJb.setSubPbPost(true);
        bVar.fJb.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
        bVar.fJb.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fJb.setTextCenter(true);
        bVar.cHN.setOnClickListener(this.gak);
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
            if (postData.bwU()) {
                bVar.gas.setVisibility(0);
            } else {
                bVar.gas.setVisibility(8);
            }
            bVar.fJb.setPadding(0, 0, 0, 0);
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
            bVar.fJb.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            bVar.fJb.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
            a(postData, this.gao);
            TbRichText bwW = postData.bwW();
            if (bwW != null) {
                bVar.fJb.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fJb.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bwW.isChanged = true;
                }
                bVar.fJb.setText(bwW);
            }
            String userId2 = postData.zn().getUserId();
            if (this.gal != 0) {
                boolean z9 = this.gal != 1002;
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
            if (!this.gam) {
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
            bVar.cHN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cHN.setText("");
            bVar.cHN.setContentDescription("");
            aj.r(bVar.cHN, d.C0141d.cp_link_tip_c);
            if (z5) {
                bVar.cHN.setVisibility(0);
                bVar.cHN.setText(this.mContext.getString(d.j.manage));
                bVar.cHN.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.cHN.setVisibility(0);
                bVar.cHN.setText(this.mContext.getString(d.j.mute));
                bVar.cHN.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.cHN.setVisibility(0);
                if (this.gal == 1002 && !z7) {
                    bVar.cHN.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.cHN.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.cHN.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cHN.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cHN.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.gal));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bZR != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.zn() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                    }
                    if (this.bZR.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bZR.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.gal));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.gao && z2 && this.bsG) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gar.getLayoutParams();
                layoutParams.topMargin = l.t(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.t(this.mContext, d.e.ds8);
                bVar.gar.setLayoutParams(layoutParams);
            }
            if (this.gao && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gar.getLayoutParams();
                layoutParams2.topMargin = l.t(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.t(this.mContext, d.e.ds8);
                bVar.gar.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bwW;
        SpannableStringBuilder Ro;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Ro2;
        if (postData != null && (bwW = postData.bwW()) != null) {
            ArrayList<TbRichTextData> Rh = bwW.Rh();
            if (!v.E(Rh)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Rh.get(Rh.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.z(postData.getTime());
                        if (Rh.size() > 1) {
                            if ((Rh.get(Rh.size() + (-2)) != null ? Rh.get(Rh.size() - 2).getType() : -1) != type) {
                                str2 = am.z(postData.getTime());
                                Ro2 = tbRichTextData2.Ro();
                                if (bwW.hasAppendTime && Ro2 != 0 && bwW.appendLength <= Ro2.length()) {
                                    Ro2.delete(Ro2.length() - bwW.appendLength, Ro2.length());
                                }
                                String eq = am.eq(str2);
                                if (Ro2 != null) {
                                    Ro2.append((CharSequence) eq);
                                }
                                bwW.hasAppendTime = true;
                                bwW.appendLength = eq.length();
                                tbRichTextData = tbRichTextData2;
                                str = eq;
                            }
                        }
                        str2 = str3;
                        Ro2 = tbRichTextData2.Ro();
                        if (bwW.hasAppendTime) {
                            Ro2.delete(Ro2.length() - bwW.appendLength, Ro2.length());
                        }
                        String eq2 = am.eq(str2);
                        if (Ro2 != null) {
                        }
                        bwW.hasAppendTime = true;
                        bwW.appendLength = eq2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eq2;
                    } else if (bwW.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String z2 = am.z(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.eq(z2);
                        tbRichTextData.append(str);
                        bwW.hasAppendTime = true;
                        bwW.appendLength = str.length();
                        Rh.add(tbRichTextData);
                    }
                    SpannableStringBuilder Ro3 = tbRichTextData.Ro();
                    if (Ro3 != null && str.length() <= Ro3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0141d.cp_cont_d));
                        Ro3.setSpan(absoluteSizeSpan, Ro3.length() - str.length(), Ro3.length(), 33);
                        Ro3.setSpan(foregroundColorSpan, Ro3.length() - str.length(), Ro3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Rh.get(Rh.size() - 1);
                if (bwW.hasAppendTime && tbRichTextData3 != null && (Ro = tbRichTextData3.Ro()) != null && bwW.appendLength <= Ro.length()) {
                    Ro.delete(Ro.length() - bwW.appendLength, Ro.length());
                }
                bwW.hasAppendTime = false;
                bwW.appendLength = 0;
            }
        }
    }

    public void lf(boolean z) {
        this.gao = z;
    }

    public void lg(boolean z) {
        this.bsG = z;
    }

    public void qK(String str) {
        this.mPostId = str;
    }
}
