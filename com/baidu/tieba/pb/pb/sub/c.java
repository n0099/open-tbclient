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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private bg bTk;
    protected Context mContext;
    protected ArrayList<PostData> aFH = null;
    protected View.OnClickListener hCM = null;
    protected int hCN = 0;
    protected boolean hCO = false;
    protected boolean hCP = false;
    protected boolean erm = false;
    private boolean mIsFromCDN = true;
    private boolean hCQ = false;
    private boolean ciS = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener cdd = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView dTu;
        public LinearLayout hCS;
        public View hCT;
        public TbRichTextView hqW;
        public int mSkinType = 3;
        public View rootView;
    }

    public c(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void aj(bg bgVar) {
        this.bTk = bgVar;
    }

    public void M(View.OnClickListener onClickListener) {
        this.hCM = onClickListener;
    }

    public void H(int i, boolean z) {
        this.hCN = i;
        this.hCO = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFH == null) {
            return 0;
        }
        return this.aFH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFH == null || i < 0 || i >= this.aFH.size()) {
            return null;
        }
        return this.aFH.get(i);
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
            if (postData.getType() == PostData.iGn) {
                view = bOC();
            } else {
                view = oM();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.iGn) {
            view = oM();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.iGn) {
            view = bOC();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.erm && i + 1 >= getCount();
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

    /* loaded from: classes4.dex */
    public static class a {
        public View cKN;
        public TextView hCR;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cKN = view.findViewById(d.g.divider_line);
            this.hCR = (TextView) view.findViewById(d.g.center_reply_text);
            this.hCR.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.l(this.cKN, d.C0236d.cp_cont_d);
                al.j(this.hCR, d.C0236d.cp_cont_d);
                al.l(this.hCR, d.C0236d.cp_bg_line_d);
                this.hCR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.T(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bOC() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View oM() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.hCS = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.hCQ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hCS.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, d.e.ds8);
            bVar.hCS.setLayoutParams(layoutParams);
        }
        bVar.dTu = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.hqW = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.hCT = inflate.findViewById(d.g.divide_bottom_view);
        bVar.hqW.getLayoutStrategy().setSupportNoImage();
        if (!this.hCQ) {
            bVar.hqW.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hqW.getLayoutStrategy().kI(0);
            bVar.hqW.getLayoutStrategy().kG(l.h(this.mContext, d.e.tbds20));
            bVar.hqW.getLayoutStrategy().kH(l.h(this.mContext, d.e.tbds14));
        }
        bVar.hqW.setSubPbPost(true);
        bVar.hqW.setTextColor(al.getColor(d.C0236d.cp_cont_f));
        bVar.hqW.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hqW.setTextCenter(true);
        bVar.hqW.setOnClickListener(this.mCommonClickListener);
        bVar.dTu.setOnClickListener(this.hCM);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (bVar != null && postData != null) {
            if (!postData.iHa && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.YR() != null && aVar.zK(postData.YR().getUserId()));
            }
            if (z3) {
                al.l(bVar.rootView, d.C0236d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.ces()) {
                bVar.hCT.setVisibility(0);
            } else {
                bVar.hCT.setVisibility(8);
            }
            bVar.hqW.setPadding(0, 0, 0, 0);
            if (postData.YR() != null) {
                String name_show = postData.YR().getName_show();
                String userId = postData.YR().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hqW.setTag(sparseArray3);
                }
                sparseArray3.put(d.g.tag_photo_username, name_show);
                sparseArray3.put(d.g.tag_photo_userid, userId);
                sparseArray3.put(d.g.tag_clip_board, postData);
                sparseArray3.put(d.g.tag_is_subpb, true);
            }
            bVar.hqW.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
            bVar.hqW.setTextColor(al.getColor(d.C0236d.cp_cont_f));
            a(postData, this.hCQ);
            TbRichText cet = postData.cet();
            if (cet != null) {
                bVar.hqW.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.hqW.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cet.isChanged = true;
                }
                bVar.hqW.setText(cet);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.YR().getUserId();
            if (this.hCN != 0) {
                if (this.hCN != 1002 && this.hCN != 3) {
                    z8 = true;
                }
                if (this.hCN != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.hCO) {
                        z6 = false;
                    } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                        z5 = true;
                    } else {
                        z6 = false;
                        z5 = true;
                    }
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                        z10 = true;
                    } else {
                        z7 = z5;
                    }
                    bVar.dTu.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hqW.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hCN));
                        if (postData.YR() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.YR().getUserName());
                            sparseArray2.put(d.g.tag_forbid_user_name_show, postData.YR().getName_show());
                            sparseArray2.put(d.g.tag_forbid_user_portrait, postData.YR().getPortrait());
                        }
                        sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.g.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(d.g.tag_clip_board, postData);
                    if (!z6) {
                        if (this.bTk != null) {
                            sparseArray2.put(d.g.tag_user_mute_visible, true);
                            sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.YR() != null) {
                                sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.YR().getUserId());
                                sparseArray2.put(d.g.tag_user_mute_mute_username, postData.YR().getUserName());
                                sparseArray2.put(d.g.tag_user_mute_mute_nameshow, postData.YR().getName_show());
                            }
                            if (this.bTk.getId() != null) {
                                sparseArray2.put(d.g.tag_user_mute_thread_id, this.bTk.getId());
                            }
                            sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(d.g.tag_should_delete_visible, true);
                        sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hCN));
                        sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(d.g.tag_del_post_type, 2);
                        sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.g.tag_should_delete_visible, false);
                    }
                    if (this.hCQ && z2 && this.ciS) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hCS.getLayoutParams();
                        layoutParams.topMargin = l.h(this.mContext, d.e.ds32);
                        layoutParams.bottomMargin = l.h(this.mContext, d.e.ds8);
                        bVar.hCS.setLayoutParams(layoutParams);
                    }
                    if (this.hCQ && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hCS.getLayoutParams();
                        layoutParams2.topMargin = l.h(this.mContext, d.e.ds8);
                        layoutParams2.bottomMargin = l.h(this.mContext, d.e.ds8);
                        bVar.hCS.setLayoutParams(layoutParams2);
                    }
                    bVar.dTu.setTag(sparseArray2);
                    bVar.hqW.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hqW.setOnLongClickListener(this.cdd);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.hCO) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.dTu.setVisibility(8);
            sparseArray = (SparseArray) bVar.rootView.getTag();
            if (sparseArray != null) {
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (!z4) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            sparseArray2.put(d.g.tag_clip_board, postData);
            if (!z6) {
            }
            if (!z7) {
            }
            if (this.hCQ) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.hCS.getLayoutParams();
                layoutParams3.topMargin = l.h(this.mContext, d.e.ds32);
                layoutParams3.bottomMargin = l.h(this.mContext, d.e.ds8);
                bVar.hCS.setLayoutParams(layoutParams3);
            }
            if (this.hCQ) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.hCS.getLayoutParams();
                layoutParams22.topMargin = l.h(this.mContext, d.e.ds8);
                layoutParams22.bottomMargin = l.h(this.mContext, d.e.ds8);
                bVar.hCS.setLayoutParams(layoutParams22);
            }
            bVar.dTu.setTag(sparseArray2);
            bVar.hqW.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hqW.setOnLongClickListener(this.cdd);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cet;
        SpannableStringBuilder asF;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder asF2;
        if (postData != null && (cet = postData.cet()) != null) {
            ArrayList<TbRichTextData> asx = cet.asx();
            if (!v.T(asx)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = asx.get(asx.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.ao(postData.getTime());
                        if (asx.size() > 1) {
                            if ((asx.get(asx.size() + (-2)) != null ? asx.get(asx.size() - 2).getType() : -1) != type) {
                                str2 = ap.ao(postData.getTime());
                                asF2 = tbRichTextData2.asF();
                                if (cet.hasAppendTime && asF2 != 0 && cet.appendLength <= asF2.length()) {
                                    asF2.delete(asF2.length() - cet.appendLength, asF2.length());
                                }
                                String mF = ap.mF(str2);
                                if (asF2 != null) {
                                    asF2.append((CharSequence) mF);
                                }
                                cet.hasAppendTime = true;
                                cet.appendLength = mF.length();
                                tbRichTextData = tbRichTextData2;
                                str = mF;
                            }
                        }
                        str2 = str3;
                        asF2 = tbRichTextData2.asF();
                        if (cet.hasAppendTime) {
                            asF2.delete(asF2.length() - cet.appendLength, asF2.length());
                        }
                        String mF2 = ap.mF(str2);
                        if (asF2 != null) {
                        }
                        cet.hasAppendTime = true;
                        cet.appendLength = mF2.length();
                        tbRichTextData = tbRichTextData2;
                        str = mF2;
                    } else if (cet.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String ao = ap.ao(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.mF(ao);
                        tbRichTextData.append(str);
                        cet.hasAppendTime = true;
                        cet.appendLength = str.length();
                        asx.add(tbRichTextData);
                    }
                    SpannableStringBuilder asF3 = tbRichTextData.asF();
                    if (asF3 != null && str.length() <= asF3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0236d.cp_cont_d));
                        asF3.setSpan(absoluteSizeSpan, asF3.length() - str.length(), asF3.length(), 33);
                        asF3.setSpan(foregroundColorSpan, asF3.length() - str.length(), asF3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = asx.get(asx.size() - 1);
                if (cet.hasAppendTime && tbRichTextData3 != null && (asF = tbRichTextData3.asF()) != null && cet.appendLength <= asF.length()) {
                    asF.delete(asF.length() - cet.appendLength, asF.length());
                }
                cet.hasAppendTime = false;
                cet.appendLength = 0;
            }
        }
    }

    public void Ao(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
