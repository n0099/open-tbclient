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
import com.baidu.tbadk.core.data.bh;
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
    private bh ccq;
    protected Context mContext;
    protected ArrayList<PostData> aIn = null;
    protected View.OnClickListener ibH = null;
    protected int ibI = 0;
    protected boolean ibJ = false;
    protected boolean ibK = false;
    protected boolean eLG = false;
    private boolean mIsFromCDN = true;
    private boolean ibL = false;
    private boolean csy = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener cmF = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView ehN;
        public TbRichTextView hPq;
        public LinearLayout ibN;
        public View ibO;
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

    public void aj(bh bhVar) {
        this.ccq = bhVar;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.ibH = onClickListener;
    }

    public void O(int i, boolean z) {
        this.ibI = i;
        this.ibJ = z;
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
            if (postData.getType() == PostData.jgi) {
                view = bZB();
            } else {
                view = nZ();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.jgi) {
            view = nZ();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.jgi) {
            view = bZB();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eLG && i + 1 >= getCount();
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
        public View cUD;
        public TextView ibM;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cUD = view.findViewById(R.id.divider_line);
            this.ibM = (TextView) view.findViewById(R.id.center_reply_text);
            this.ibM.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.l(this.cUD, R.color.cp_cont_d);
                am.j(this.ibM, R.color.cp_cont_d);
                am.l(this.ibM, R.color.cp_bg_line_d);
                this.ibM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.V(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bZB() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nZ() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.ibN = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.ibL) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ibN.getLayoutParams();
            layoutParams.topMargin = l.g(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
            bVar.ibN.setLayoutParams(layoutParams);
        }
        bVar.ehN = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hPq = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.ibO = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hPq.getLayoutStrategy().setSupportNoImage();
        if (!this.ibL) {
            bVar.hPq.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hPq.getLayoutStrategy().lD(0);
            bVar.hPq.getLayoutStrategy().lB(l.g(this.mContext, R.dimen.tbds20));
            bVar.hPq.getLayoutStrategy().lC(l.g(this.mContext, R.dimen.tbds14));
        }
        bVar.hPq.setSubPbPost(true);
        bVar.hPq.setTextColor(am.getColor(R.color.cp_cont_f));
        bVar.hPq.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hPq.setTextCenter(true);
        bVar.hPq.setOnClickListener(this.mCommonClickListener);
        bVar.ehN.setOnClickListener(this.ibH);
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
            if (!postData.jgW && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aey() != null && aVar.BM(postData.aey().getUserId()));
            }
            if (z3) {
                am.l(bVar.rootView, R.color.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.cpM()) {
                bVar.ibO.setVisibility(0);
            } else {
                bVar.ibO.setVisibility(8);
            }
            bVar.hPq.setPadding(0, 0, 0, 0);
            if (postData.aey() != null) {
                String name_show = postData.aey().getName_show();
                String userId = postData.aey().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hPq.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hPq.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hPq.setTextColor(am.getColor(R.color.cp_cont_f));
            a(postData, this.ibL);
            TbRichText cpN = postData.cpN();
            if (cpN != null) {
                bVar.hPq.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hPq.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cpN.isChanged = true;
                }
                bVar.hPq.setText(cpN);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aey().getUserId();
            if (this.ibI != 0) {
                if (this.ibI != 1002 && this.ibI != 3) {
                    z8 = true;
                }
                if (this.ibI != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.ibJ) {
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
                    bVar.ehN.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hPq.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.ibI));
                        if (postData.aey() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aey().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aey().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aey().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.ccq != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aey() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aey().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aey().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aey().getName_show());
                            }
                            if (this.ccq.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.ccq.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.ibI));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.ibL && z2 && this.csy) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ibN.getLayoutParams();
                        layoutParams.topMargin = l.g(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.ibN.setLayoutParams(layoutParams);
                    }
                    if (this.ibL && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ibN.getLayoutParams();
                        layoutParams2.topMargin = l.g(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.ibN.setLayoutParams(layoutParams2);
                    }
                    bVar.ehN.setTag(sparseArray2);
                    bVar.hPq.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hPq.setOnLongClickListener(this.cmF);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.ibJ) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.ehN.setVisibility(8);
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
            if (this.ibL) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.ibN.getLayoutParams();
                layoutParams3.topMargin = l.g(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.ibN.setLayoutParams(layoutParams3);
            }
            if (this.ibL) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.ibN.getLayoutParams();
                layoutParams22.topMargin = l.g(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.ibN.setLayoutParams(layoutParams22);
            }
            bVar.ehN.setTag(sparseArray2);
            bVar.hPq.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hPq.setOnLongClickListener(this.cmF);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cpN;
        SpannableStringBuilder ayV;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder ayV2;
        if (postData != null && (cpN = postData.cpN()) != null) {
            ArrayList<TbRichTextData> ayN = cpN.ayN();
            if (!v.aa(ayN)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = ayN.get(ayN.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.aD(postData.getTime());
                        if (ayN.size() > 1) {
                            if ((ayN.get(ayN.size() + (-2)) != null ? ayN.get(ayN.size() - 2).getType() : -1) != type) {
                                str2 = aq.aD(postData.getTime());
                                ayV2 = tbRichTextData2.ayV();
                                if (cpN.hasAppendTime && ayV2 != 0 && cpN.appendLength <= ayV2.length()) {
                                    ayV2.delete(ayV2.length() - cpN.appendLength, ayV2.length());
                                }
                                String oa = aq.oa(str2);
                                if (ayV2 != null) {
                                    ayV2.append((CharSequence) oa);
                                }
                                cpN.hasAppendTime = true;
                                cpN.appendLength = oa.length();
                                tbRichTextData = tbRichTextData2;
                                str = oa;
                            }
                        }
                        str2 = str3;
                        ayV2 = tbRichTextData2.ayV();
                        if (cpN.hasAppendTime) {
                            ayV2.delete(ayV2.length() - cpN.appendLength, ayV2.length());
                        }
                        String oa2 = aq.oa(str2);
                        if (ayV2 != null) {
                        }
                        cpN.hasAppendTime = true;
                        cpN.appendLength = oa2.length();
                        tbRichTextData = tbRichTextData2;
                        str = oa2;
                    } else if (cpN.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String aD = aq.aD(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.oa(aD);
                        tbRichTextData.k(str);
                        cpN.hasAppendTime = true;
                        cpN.appendLength = str.length();
                        ayN.add(tbRichTextData);
                    }
                    SpannableStringBuilder ayV3 = tbRichTextData.ayV();
                    if (ayV3 != null && str.length() <= ayV3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        ayV3.setSpan(absoluteSizeSpan, ayV3.length() - str.length(), ayV3.length(), 33);
                        ayV3.setSpan(foregroundColorSpan, ayV3.length() - str.length(), ayV3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = ayN.get(ayN.size() - 1);
                if (cpN.hasAppendTime && tbRichTextData3 != null && (ayV = tbRichTextData3.ayV()) != null && cpN.appendLength <= ayV.length()) {
                    ayV.delete(ayV.length() - cpN.appendLength, ayV.length());
                }
                cpN.hasAppendTime = false;
                cpN.appendLength = 0;
            }
        }
    }

    public void Cq(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
