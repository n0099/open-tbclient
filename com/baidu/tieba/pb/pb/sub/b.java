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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private bj Nl;
    protected Context mContext;
    protected View.OnClickListener iQG = null;
    protected int iQH = 0;
    protected boolean iQI = false;
    protected boolean fJM = false;
    private boolean mIsFromCDN = true;
    private boolean iQJ = false;
    private boolean dsE = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener ahD = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0569b {
        public TextView fmY;
        public TbRichTextView iBs;
        public LinearLayout iQL;
        public View iQM;
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
        this.Nl = bjVar;
    }

    public void T(View.OnClickListener onClickListener) {
        this.iQG = onClickListener;
    }

    public void P(int i, boolean z) {
        this.iQH = i;
        this.iQI = z;
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
        C0569b c0569b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.kbN) {
                view = cpl();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.kbN) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.kbN) {
            view = cpl();
        }
        if ((view.getTag() instanceof SparseArray) && (c0569b = (C0569b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.fJM && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0569b, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public View bZT;
        public TextView iQK;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bZT = view.findViewById(R.id.divider_line);
            this.iQK = (TextView) view.findViewById(R.id.center_reply_text);
            this.iQK.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.bZT, R.color.cp_cont_d);
                am.setViewTextColor(this.iQK, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.iQK, R.color.cp_bg_line_d);
                this.iQK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cpl() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0569b c0569b = new C0569b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0569b.rootView = inflate;
        c0569b.iQL = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.iQJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0569b.iQL.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0569b.iQL.setLayoutParams(layoutParams);
        }
        c0569b.fmY = (TextView) inflate.findViewById(R.id.manage_btn);
        c0569b.iBs = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0569b.iQM = inflate.findViewById(R.id.divide_bottom_view);
        c0569b.iBs.getLayoutStrategy().setSupportNoImage();
        if (!this.iQJ) {
            c0569b.iBs.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0569b.iBs.getLayoutStrategy().na(0);
            c0569b.iBs.getLayoutStrategy().mY(l.getDimens(this.mContext, R.dimen.tbds20));
            c0569b.iBs.getLayoutStrategy().mZ(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0569b.iBs.setSubPbPost(true);
        c0569b.iBs.setTextColor(am.getColor(R.color.cp_cont_f));
        c0569b.iBs.setTextSize(TbConfig.getContentSizeOfLzl());
        c0569b.iBs.setTextCenter(true);
        c0569b.iBs.setOnClickListener(this.ahD);
        c0569b.fmY.setOnClickListener(this.iQG);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0569b);
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
    public void a(C0569b c0569b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0569b != null && postData != null) {
            if (!postData.kcC && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.azE() != null && aVar.Fl(postData.azE().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0569b.rootView, R.color.cp_bg_line_c);
            } else {
                c0569b.rootView.setBackgroundResource(0);
            }
            if (postData.cIu()) {
                c0569b.iQM.setVisibility(0);
            } else {
                c0569b.iQM.setVisibility(8);
            }
            c0569b.iBs.setPadding(0, 0, 0, 0);
            if (postData.azE() != null) {
                String name_show = postData.azE().getName_show();
                String userId = postData.azE().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0569b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0569b.rootView.setTag(sparseArray3);
                    c0569b.iBs.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0569b.iBs.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0569b.iBs.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.iQJ);
            TbRichText cIv = postData.cIv();
            if (cIv != null) {
                c0569b.iBs.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0569b.iBs.setIsFromCDN(this.mIsFromCDN);
                if (c0569b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cIv.isChanged = true;
                }
                c0569b.iBs.setText(cIv);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.azE().getUserId();
            if (this.iQH != 0) {
                if (this.iQH != 1002 && this.iQH != 3) {
                    z8 = true;
                }
                if (this.iQH != 3 && !this.Nl.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.iQI) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.Nl.isBjh() ? true : z5;
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
                    c0569b.fmY.setVisibility(8);
                    sparseArray = (SparseArray) c0569b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0569b.rootView.setTag(sparseArray4);
                        c0569b.iBs.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iQH));
                        if (postData.azE() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.azE().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.azE().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.azE().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.Nl != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.azE() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.azE().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.azE().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.azE().getName_show());
                            }
                            if (this.Nl.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.Nl.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iQH));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.iQJ && z2 && this.dsE) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0569b.iQL.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0569b.iQL.setLayoutParams(layoutParams);
                    }
                    if (this.iQJ && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0569b.iQL.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0569b.iQL.setLayoutParams(layoutParams2);
                    }
                    c0569b.fmY.setTag(sparseArray2);
                    c0569b.iBs.setTag(sparseArray2);
                    c0569b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0569b.iBs.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.iQI) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0569b.fmY.setVisibility(8);
            sparseArray = (SparseArray) c0569b.rootView.getTag();
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
            if (this.iQJ) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0569b.iQL.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0569b.iQL.setLayoutParams(layoutParams3);
            }
            if (this.iQJ) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0569b.iQL.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0569b.iQL.setLayoutParams(layoutParams22);
            }
            c0569b.fmY.setTag(sparseArray2);
            c0569b.iBs.setTag(sparseArray2);
            c0569b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0569b.iBs.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText cIv;
        SpannableStringBuilder aRm;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder aRm2;
        if (postData != null && (cIv = postData.cIv()) != null) {
            ArrayList<TbRichTextData> aRf = cIv.aRf();
            if (!v.isEmpty(aRf)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = aRf.get(aRf.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (aRf.size() > 1) {
                            if ((aRf.get(aRf.size() + (-2)) != null ? aRf.get(aRf.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                aRm2 = tbRichTextData2.aRm();
                                if (cIv.hasAppendTime && aRm2 != 0 && cIv.appendLength <= aRm2.length()) {
                                    aRm2.delete(aRm2.length() - cIv.appendLength, aRm2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (aRm2 != null) {
                                    aRm2.append((CharSequence) forceLToR);
                                }
                                cIv.hasAppendTime = true;
                                cIv.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        aRm2 = tbRichTextData2.aRm();
                        if (cIv.hasAppendTime) {
                            aRm2.delete(aRm2.length() - cIv.appendLength, aRm2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (aRm2 != null) {
                        }
                        cIv.hasAppendTime = true;
                        cIv.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cIv.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        cIv.hasAppendTime = true;
                        cIv.appendLength = str.length();
                        aRf.add(tbRichTextData);
                    }
                    SpannableStringBuilder aRm3 = tbRichTextData.aRm();
                    if (aRm3 != null && str.length() <= aRm3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        aRm3.setSpan(absoluteSizeSpan, aRm3.length() - str.length(), aRm3.length(), 33);
                        aRm3.setSpan(foregroundColorSpan, aRm3.length() - str.length(), aRm3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = aRf.get(aRf.size() - 1);
                if (cIv.hasAppendTime && tbRichTextData3 != null && (aRm = tbRichTextData3.aRm()) != null && cIv.appendLength <= aRm.length()) {
                    aRm.delete(aRm.length() - cIv.appendLength, aRm.length());
                }
                cIv.hasAppendTime = false;
                cIv.appendLength = 0;
            }
        }
    }

    public void FS(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }
}
