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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private bg ccj;
    protected Context mContext;
    protected ArrayList<PostData> aIn = null;
    protected View.OnClickListener iaK = null;
    protected int iaL = 0;
    protected boolean iaM = false;
    protected boolean iaN = false;
    protected boolean eLz = false;
    private boolean mIsFromCDN = true;
    private boolean iaO = false;
    private boolean csr = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener cmy = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView ehG;
        public TbRichTextView hOw;
        public LinearLayout iaQ;
        public View iaR;
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

    public void ai(bg bgVar) {
        this.ccj = bgVar;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.iaK = onClickListener;
    }

    public void O(int i, boolean z) {
        this.iaL = i;
        this.iaM = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIn == null) {
            return 0;
        }
        return this.aIn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn == null || i < 0 || i >= this.aIn.size()) {
            return null;
        }
        return this.aIn.get(i);
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
            if (postData.getType() == PostData.jfb) {
                view = bZk();
            } else {
                view = nZ();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.jfb) {
            view = nZ();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.jfb) {
            view = bZk();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eLz && i + 1 >= getCount();
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
        public View cUw;
        public TextView iaP;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cUw = view.findViewById(R.id.divider_line);
            this.iaP = (TextView) view.findViewById(R.id.center_reply_text);
            this.iaP.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.l(this.cUw, R.color.cp_cont_d);
                am.j(this.iaP, R.color.cp_cont_d);
                am.l(this.iaP, R.color.cp_bg_line_d);
                this.iaP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.V(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bZk() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nZ() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.iaQ = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.iaO) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iaQ.getLayoutParams();
            layoutParams.topMargin = l.g(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
            bVar.iaQ.setLayoutParams(layoutParams);
        }
        bVar.ehG = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hOw = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.iaR = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hOw.getLayoutStrategy().setSupportNoImage();
        if (!this.iaO) {
            bVar.hOw.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hOw.getLayoutStrategy().lC(0);
            bVar.hOw.getLayoutStrategy().lA(l.g(this.mContext, R.dimen.tbds20));
            bVar.hOw.getLayoutStrategy().lB(l.g(this.mContext, R.dimen.tbds14));
        }
        bVar.hOw.setSubPbPost(true);
        bVar.hOw.setTextColor(am.getColor(R.color.cp_cont_f));
        bVar.hOw.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hOw.setTextCenter(true);
        bVar.hOw.setOnClickListener(this.mCommonClickListener);
        bVar.ehG.setOnClickListener(this.iaK);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0302  */
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
            if (!postData.jfP && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aex() != null && aVar.BL(postData.aex().getUserId()));
            }
            if (z3) {
                am.l(bVar.rootView, R.color.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.cpq()) {
                bVar.iaR.setVisibility(0);
            } else {
                bVar.iaR.setVisibility(8);
            }
            bVar.hOw.setPadding(0, 0, 0, 0);
            if (postData.aex() != null) {
                String name_show = postData.aex().getName_show();
                String userId = postData.aex().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hOw.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hOw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hOw.setTextColor(am.getColor(R.color.cp_cont_f));
            a(postData, this.iaO);
            TbRichText cpr = postData.cpr();
            if (cpr != null) {
                bVar.hOw.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hOw.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cpr.isChanged = true;
                }
                bVar.hOw.setText(cpr);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aex().getUserId();
            if (this.iaL != 0) {
                if (this.iaL != 1002 && this.iaL != 3) {
                    z8 = true;
                }
                if (this.iaL != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.iaM) {
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
                    bVar.ehG.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hOw.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iaL));
                        if (postData.aex() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aex().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aex().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aex().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.ccj != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aex() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aex().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aex().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aex().getName_show());
                            }
                            if (this.ccj.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.ccj.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iaL));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.iaO && z2 && this.csr) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iaQ.getLayoutParams();
                        layoutParams.topMargin = l.g(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.iaQ.setLayoutParams(layoutParams);
                    }
                    if (this.iaO && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.iaQ.getLayoutParams();
                        layoutParams2.topMargin = l.g(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.iaQ.setLayoutParams(layoutParams2);
                    }
                    bVar.ehG.setTag(sparseArray2);
                    bVar.hOw.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hOw.setOnLongClickListener(this.cmy);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.iaM) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.ehG.setVisibility(8);
            sparseArray = (SparseArray) bVar.rootView.getTag();
            if (sparseArray != null) {
            }
            sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (!z4) {
            }
            sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray2.put(R.id.tag_clip_board, postData);
            if (!z6) {
            }
            if (!z7) {
            }
            if (this.iaO) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.iaQ.getLayoutParams();
                layoutParams3.topMargin = l.g(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.iaQ.setLayoutParams(layoutParams3);
            }
            if (this.iaO) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.iaQ.getLayoutParams();
                layoutParams22.topMargin = l.g(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.iaQ.setLayoutParams(layoutParams22);
            }
            bVar.ehG.setTag(sparseArray2);
            bVar.hOw.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hOw.setOnLongClickListener(this.cmy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cpr;
        SpannableStringBuilder ayT;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder ayT2;
        if (postData != null && (cpr = postData.cpr()) != null) {
            ArrayList<TbRichTextData> ayL = cpr.ayL();
            if (!v.aa(ayL)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = ayL.get(ayL.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.aD(postData.getTime());
                        if (ayL.size() > 1) {
                            if ((ayL.get(ayL.size() + (-2)) != null ? ayL.get(ayL.size() - 2).getType() : -1) != type) {
                                str2 = aq.aD(postData.getTime());
                                ayT2 = tbRichTextData2.ayT();
                                if (cpr.hasAppendTime && ayT2 != 0 && cpr.appendLength <= ayT2.length()) {
                                    ayT2.delete(ayT2.length() - cpr.appendLength, ayT2.length());
                                }
                                String oa = aq.oa(str2);
                                if (ayT2 != null) {
                                    ayT2.append((CharSequence) oa);
                                }
                                cpr.hasAppendTime = true;
                                cpr.appendLength = oa.length();
                                tbRichTextData = tbRichTextData2;
                                str = oa;
                            }
                        }
                        str2 = str3;
                        ayT2 = tbRichTextData2.ayT();
                        if (cpr.hasAppendTime) {
                            ayT2.delete(ayT2.length() - cpr.appendLength, ayT2.length());
                        }
                        String oa2 = aq.oa(str2);
                        if (ayT2 != null) {
                        }
                        cpr.hasAppendTime = true;
                        cpr.appendLength = oa2.length();
                        tbRichTextData = tbRichTextData2;
                        str = oa2;
                    } else if (cpr.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String aD = aq.aD(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.oa(aD);
                        tbRichTextData.k(str);
                        cpr.hasAppendTime = true;
                        cpr.appendLength = str.length();
                        ayL.add(tbRichTextData);
                    }
                    SpannableStringBuilder ayT3 = tbRichTextData.ayT();
                    if (ayT3 != null && str.length() <= ayT3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        ayT3.setSpan(absoluteSizeSpan, ayT3.length() - str.length(), ayT3.length(), 33);
                        ayT3.setSpan(foregroundColorSpan, ayT3.length() - str.length(), ayT3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = ayL.get(ayL.size() - 1);
                if (cpr.hasAppendTime && tbRichTextData3 != null && (ayT = tbRichTextData3.ayT()) != null && cpr.appendLength <= ayT.length()) {
                    ayT.delete(ayT.length() - cpr.appendLength, ayT.length());
                }
                cpr.hasAppendTime = false;
                cpr.appendLength = 0;
            }
        }
    }

    public void Cp(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
