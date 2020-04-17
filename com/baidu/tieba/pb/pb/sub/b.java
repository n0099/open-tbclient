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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private bj agz;
    protected Context mContext;
    protected View.OnClickListener jHB = null;
    protected int jHC = 0;
    protected boolean jHD = false;
    protected boolean guU = false;
    private boolean mIsFromCDN = true;
    private boolean jHE = false;
    private boolean dXd = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aDc = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0620b {
        public TextView fXS;
        public LinearLayout jHG;
        public View jHH;
        public TbRichTextView jsw;
        public int mSkinType = 3;
        public View rootView;
    }

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setThreadData(bj bjVar) {
        this.agz = bjVar;
    }

    public void T(View.OnClickListener onClickListener) {
        this.jHB = onClickListener;
    }

    public void U(int i, boolean z) {
        this.jHC = i;
        this.jHD = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0620b c0620b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.kSs) {
                view = cCO();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.kSs) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.kSs) {
            view = cCO();
        }
        if ((view.getTag() instanceof SparseArray) && (c0620b = (C0620b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.guU && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0620b, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public View cDw;
        public TextView jHF;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cDw = view.findViewById(R.id.divider_line);
            this.jHF = (TextView) view.findViewById(R.id.center_reply_text);
            this.jHF.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.cDw, R.color.cp_cont_d);
                am.setViewTextColor(this.jHF, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.jHF, R.color.cp_bg_line_d);
                this.jHF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cCO() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0620b c0620b = new C0620b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0620b.rootView = inflate;
        c0620b.jHG = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.jHE) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0620b.jHG.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0620b.jHG.setLayoutParams(layoutParams);
        }
        c0620b.fXS = (TextView) inflate.findViewById(R.id.manage_btn);
        c0620b.jsw = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0620b.jHH = inflate.findViewById(R.id.divide_bottom_view);
        c0620b.jsw.getLayoutStrategy().setSupportNoImage();
        if (!this.jHE) {
            c0620b.jsw.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0620b.jsw.getLayoutStrategy().nF(0);
            c0620b.jsw.getLayoutStrategy().nD(l.getDimens(this.mContext, R.dimen.tbds20));
            c0620b.jsw.getLayoutStrategy().nE(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0620b.jsw.setSubPbPost(true);
        c0620b.jsw.setTextColor(am.getColor(R.color.cp_cont_f));
        c0620b.jsw.setTextSize(TbConfig.getContentSizeOfLzl());
        c0620b.jsw.setTextCenter(true);
        c0620b.jsw.setOnClickListener(this.aDc);
        c0620b.fXS.setOnClickListener(this.jHB);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0620b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(C0620b c0620b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0620b != null && postData != null) {
            if (!postData.kTi && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aKE() != null && aVar.Hs(postData.aKE().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0620b.rootView, R.color.cp_bg_line_c);
            } else {
                c0620b.rootView.setBackgroundResource(0);
            }
            if (postData.cWs()) {
                c0620b.jHH.setVisibility(0);
            } else {
                c0620b.jHH.setVisibility(8);
            }
            c0620b.jsw.setPadding(0, 0, 0, 0);
            if (postData.aKE() != null) {
                String name_show = postData.aKE().getName_show();
                String userId = postData.aKE().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0620b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0620b.rootView.setTag(sparseArray3);
                    c0620b.jsw.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0620b.jsw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0620b.jsw.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.jHE);
            TbRichText cWt = postData.cWt();
            if (cWt != null) {
                c0620b.jsw.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0620b.jsw.setIsFromCDN(this.mIsFromCDN);
                if (c0620b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cWt.isChanged = true;
                }
                c0620b.jsw.setText(cWt);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aKE().getUserId();
            if (this.jHC != 0) {
                if (this.jHC != 1002 && this.jHC != 3) {
                    z8 = true;
                }
                if (this.jHC != 3 && !this.agz.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.jHD) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.agz.isBjh() ? true : z5;
                        if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z6 = true;
                            z5 = z12;
                        } else {
                            z6 = false;
                            z5 = z12;
                        }
                    }
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                        z10 = true;
                    } else {
                        z7 = z5;
                    }
                    c0620b.fXS.setVisibility(8);
                    sparseArray = (SparseArray) c0620b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0620b.rootView.setTag(sparseArray4);
                        c0620b.jsw.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHC));
                        if (postData.aKE() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aKE().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aKE().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aKE().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.agz != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aKE() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aKE().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aKE().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aKE().getName_show());
                            }
                            if (this.agz.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.agz.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHC));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.jHE && z2 && this.dXd) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0620b.jHG.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0620b.jHG.setLayoutParams(layoutParams);
                    }
                    if (this.jHE && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0620b.jHG.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0620b.jHG.setLayoutParams(layoutParams2);
                    }
                    c0620b.fXS.setTag(sparseArray2);
                    c0620b.jsw.setTag(sparseArray2);
                    c0620b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0620b.jsw.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.jHD) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0620b.fXS.setVisibility(8);
            sparseArray = (SparseArray) c0620b.rootView.getTag();
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
            if (this.jHE) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0620b.jHG.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0620b.jHG.setLayoutParams(layoutParams3);
            }
            if (this.jHE) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0620b.jHG.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0620b.jHG.setLayoutParams(layoutParams22);
            }
            c0620b.fXS.setTag(sparseArray2);
            c0620b.jsw.setTag(sparseArray2);
            c0620b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0620b.jsw.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText cWt;
        SpannableStringBuilder bco;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bco2;
        if (postData != null && (cWt = postData.cWt()) != null) {
            ArrayList<TbRichTextData> bch = cWt.bch();
            if (!v.isEmpty(bch)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bch.get(bch.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (bch.size() > 1) {
                            if ((bch.get(bch.size() + (-2)) != null ? bch.get(bch.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                bco2 = tbRichTextData2.bco();
                                if (cWt.hasAppendTime && bco2 != 0 && cWt.appendLength <= bco2.length()) {
                                    bco2.delete(bco2.length() - cWt.appendLength, bco2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (bco2 != null) {
                                    bco2.append((CharSequence) forceLToR);
                                }
                                cWt.hasAppendTime = true;
                                cWt.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bco2 = tbRichTextData2.bco();
                        if (cWt.hasAppendTime) {
                            bco2.delete(bco2.length() - cWt.appendLength, bco2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (bco2 != null) {
                        }
                        cWt.hasAppendTime = true;
                        cWt.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cWt.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        cWt.hasAppendTime = true;
                        cWt.appendLength = str.length();
                        bch.add(tbRichTextData);
                    }
                    SpannableStringBuilder bco3 = tbRichTextData.bco();
                    if (bco3 != null && str.length() <= bco3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        bco3.setSpan(absoluteSizeSpan, bco3.length() - str.length(), bco3.length(), 33);
                        bco3.setSpan(foregroundColorSpan, bco3.length() - str.length(), bco3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bch.get(bch.size() - 1);
                if (cWt.hasAppendTime && tbRichTextData3 != null && (bco = tbRichTextData3.bco()) != null && cWt.appendLength <= bco.length()) {
                    bco.delete(bco.length() - cWt.appendLength, bco.length());
                }
                cWt.hasAppendTime = false;
                cWt.appendLength = 0;
            }
        }
    }

    public void HZ(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }
}
