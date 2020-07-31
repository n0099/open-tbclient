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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    private bv aii;
    protected Context mContext;
    protected View.OnClickListener kDe = null;
    protected int kDf = 0;
    protected boolean kDg = false;
    protected boolean hcB = false;
    private boolean mIsFromCDN = true;
    private boolean kDh = false;
    private boolean eAv = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aMH = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0723b {
        public TextView gFl;
        public LinearLayout kDj;
        public View kDk;
        public TbRichTextView kmZ;
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

    public void setThreadData(bv bvVar) {
        this.aii = bvVar;
    }

    public void V(View.OnClickListener onClickListener) {
        this.kDe = onClickListener;
    }

    public void aa(int i, boolean z) {
        this.kDf = i;
        this.kDg = z;
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
        C0723b c0723b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.lNe) {
                view = cSf();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.lNe) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.lNe) {
            view = cSf();
        }
        if ((view.getTag() instanceof SparseArray) && (c0723b = (C0723b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.hcB && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0723b, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes16.dex */
    public static class a {
        public View fbk;
        public TextView kDi;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fbk = view.findViewById(R.id.divider_line);
            this.kDi = (TextView) view.findViewById(R.id.center_reply_text);
            this.kDi.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ao.setBackgroundColor(this.fbk, R.color.cp_cont_d);
                ao.setViewTextColor(this.kDi, R.color.cp_cont_d);
                ao.setBackgroundColor(this.kDi, R.color.cp_bg_line_d);
                this.kDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cSf() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0723b c0723b = new C0723b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0723b.rootView = inflate;
        c0723b.kDj = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.kDh) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0723b.kDj.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0723b.kDj.setLayoutParams(layoutParams);
        }
        c0723b.gFl = (TextView) inflate.findViewById(R.id.manage_btn);
        c0723b.kmZ = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0723b.kDk = inflate.findViewById(R.id.divide_bottom_view);
        c0723b.kmZ.getLayoutStrategy().setSupportNoImage();
        if (!this.kDh) {
            c0723b.kmZ.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0723b.kmZ.getLayoutStrategy().pa(0);
            c0723b.kmZ.getLayoutStrategy().oY(l.getDimens(this.mContext, R.dimen.tbds20));
            c0723b.kmZ.getLayoutStrategy().oZ(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0723b.kmZ.setSubPbPost(true);
        c0723b.kmZ.setTextColor(ao.getColor(R.color.cp_cont_f));
        c0723b.kmZ.setTextSize(TbConfig.getContentSizeOfLzl());
        c0723b.kmZ.setTextCenter(true);
        c0723b.kmZ.setOnClickListener(this.aMH);
        c0723b.gFl.setOnClickListener(this.kDe);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0723b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(C0723b c0723b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0723b != null && postData != null) {
            if (!postData.lNT && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aWl() != null && aVar.Kv(postData.aWl().getUserId()));
            }
            if (z3) {
                ao.setBackgroundColor(c0723b.rootView, R.color.cp_bg_line_c);
            } else {
                c0723b.rootView.setBackgroundResource(0);
            }
            if (postData.dli()) {
                c0723b.kDk.setVisibility(0);
            } else {
                c0723b.kDk.setVisibility(8);
            }
            c0723b.kmZ.setPadding(0, 0, 0, 0);
            if (postData.aWl() != null) {
                String name_show = postData.aWl().getName_show();
                String userId = postData.aWl().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0723b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0723b.rootView.setTag(sparseArray3);
                    c0723b.kmZ.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0723b.kmZ.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            c0723b.kmZ.setTextColor(ao.getColor(R.color.cp_cont_f));
            d(postData, this.kDh);
            TbRichText dlj = postData.dlj();
            if (dlj != null) {
                c0723b.kmZ.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0723b.kmZ.setIsFromCDN(this.mIsFromCDN);
                if (c0723b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dlj.isChanged = true;
                }
                c0723b.kmZ.setText(dlj);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aWl().getUserId();
            if (this.kDf != 0) {
                if (this.kDf != 1002 && this.kDf != 3) {
                    z8 = true;
                }
                if (this.kDf != 3 && !this.aii.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.kDg) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.aii.isBjh() ? true : z5;
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
                    c0723b.gFl.setVisibility(8);
                    sparseArray = (SparseArray) c0723b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0723b.rootView.setTag(sparseArray4);
                        c0723b.kmZ.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kDf));
                        if (postData.aWl() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aWl().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aWl().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aWl().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.aii != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aWl() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aWl().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aWl().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aWl().getName_show());
                            }
                            if (this.aii.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.aii.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kDf));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.kDh && z2 && this.eAv) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0723b.kDj.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0723b.kDj.setLayoutParams(layoutParams);
                    }
                    if (this.kDh && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0723b.kDj.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0723b.kDj.setLayoutParams(layoutParams2);
                    }
                    c0723b.gFl.setTag(sparseArray2);
                    c0723b.kmZ.setTag(sparseArray2);
                    c0723b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0723b.kmZ.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.kDg) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0723b.gFl.setVisibility(8);
            sparseArray = (SparseArray) c0723b.rootView.getTag();
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
            if (this.kDh) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0723b.kDj.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0723b.kDj.setLayoutParams(layoutParams3);
            }
            if (this.kDh) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0723b.kDj.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0723b.kDj.setLayoutParams(layoutParams22);
            }
            c0723b.gFl.setTag(sparseArray2);
            c0723b.kmZ.setTag(sparseArray2);
            c0723b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0723b.kmZ.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dlj;
        SpannableStringBuilder boQ;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder boQ2;
        if (postData != null && (dlj = postData.dlj()) != null) {
            ArrayList<TbRichTextData> boJ = dlj.boJ();
            if (!x.isEmpty(boJ)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = boJ.get(boJ.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + as.getFormatTime(postData.getTime());
                        if (boJ.size() > 1) {
                            if ((boJ.get(boJ.size() + (-2)) != null ? boJ.get(boJ.size() - 2).getType() : -1) != type) {
                                str2 = as.getFormatTime(postData.getTime());
                                boQ2 = tbRichTextData2.boQ();
                                if (dlj.hasAppendTime && boQ2 != 0 && dlj.appendLength <= boQ2.length()) {
                                    boQ2.delete(boQ2.length() - dlj.appendLength, boQ2.length());
                                }
                                String forceLToR = as.forceLToR(str2);
                                if (boQ2 != null) {
                                    boQ2.append((CharSequence) forceLToR);
                                }
                                dlj.hasAppendTime = true;
                                dlj.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        boQ2 = tbRichTextData2.boQ();
                        if (dlj.hasAppendTime) {
                            boQ2.delete(boQ2.length() - dlj.appendLength, boQ2.length());
                        }
                        String forceLToR2 = as.forceLToR(str2);
                        if (boQ2 != null) {
                        }
                        dlj.hasAppendTime = true;
                        dlj.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dlj.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = as.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = as.forceLToR(formatTime);
                        tbRichTextData.n(str);
                        dlj.hasAppendTime = true;
                        dlj.appendLength = str.length();
                        boJ.add(tbRichTextData);
                    }
                    SpannableStringBuilder boQ3 = tbRichTextData.boQ();
                    if (boQ3 != null && str.length() <= boQ3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.cp_cont_d));
                        boQ3.setSpan(absoluteSizeSpan, boQ3.length() - str.length(), boQ3.length(), 33);
                        boQ3.setSpan(foregroundColorSpan, boQ3.length() - str.length(), boQ3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = boJ.get(boJ.size() - 1);
                if (dlj.hasAppendTime && tbRichTextData3 != null && (boQ = tbRichTextData3.boQ()) != null && dlj.appendLength <= boQ.length()) {
                    boQ.delete(boQ.length() - dlj.appendLength, boQ.length());
                }
                dlj.hasAppendTime = false;
                dlj.appendLength = 0;
            }
        }
    }

    public void Lf(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }
}
