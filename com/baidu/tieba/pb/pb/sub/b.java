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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class b extends BaseAdapter {
    private bw akq;
    protected Context mContext;
    protected View.OnClickListener lDn = null;
    protected int lDo = 0;
    protected boolean lDp = false;
    protected boolean hXS = false;
    private boolean mIsFromCDN = true;
    private boolean lDq = false;
    private boolean fhR = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aYF = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0804b {
        public TextView hwr;
        public LinearLayout lDs;
        public View lDt;
        public TbRichTextView lmH;
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

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.lDn = onClickListener;
    }

    public void af(int i, boolean z) {
        this.lDo = i;
        this.lDp = z;
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
        C0804b c0804b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.mQQ) {
                view = dnq();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.mQQ) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.mQQ) {
            view = dnq();
        }
        if ((view.getTag() instanceof SparseArray) && (c0804b = (C0804b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.hXS && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0804b, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes22.dex */
    public static class a {
        public View fKv;
        public TextView lDr;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fKv = view.findViewById(R.id.divider_line);
            this.lDr = (TextView) view.findViewById(R.id.center_reply_text);
            this.lDr.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fKv, R.color.cp_cont_d);
                ap.setViewTextColor(this.lDr, R.color.cp_cont_d);
                ap.setBackgroundColor(this.lDr, R.color.cp_bg_line_d);
                this.lDr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dnq() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0804b c0804b = new C0804b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0804b.rootView = inflate;
        c0804b.lDs = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lDq) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0804b.lDs.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0804b.lDs.setLayoutParams(layoutParams);
        }
        c0804b.hwr = (TextView) inflate.findViewById(R.id.manage_btn);
        c0804b.lmH = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0804b.lDt = inflate.findViewById(R.id.divide_bottom_view);
        c0804b.lmH.getLayoutStrategy().setSupportNoImage();
        if (!this.lDq) {
            c0804b.lmH.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0804b.lmH.getLayoutStrategy().sm(0);
            c0804b.lmH.getLayoutStrategy().sk(l.getDimens(this.mContext, R.dimen.tbds20));
            c0804b.lmH.getLayoutStrategy().sl(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0804b.lmH.setSubPbPost(true);
        c0804b.lmH.setTextColor(ap.getColor(R.color.cp_cont_f));
        c0804b.lmH.setTextSize(TbConfig.getContentSizeOfLzl());
        c0804b.lmH.setTextCenter(true);
        c0804b.lmH.setOnClickListener(this.aYF);
        c0804b.hwr.setOnClickListener(this.lDn);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0804b);
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
    public void a(C0804b c0804b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0804b != null && postData != null) {
            if (!postData.mRG && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bka() != null && aVar.Pd(postData.bka().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0804b.rootView, R.color.cp_bg_line_c);
            } else {
                c0804b.rootView.setBackgroundResource(0);
            }
            if (postData.dHy()) {
                c0804b.lDt.setVisibility(0);
            } else {
                c0804b.lDt.setVisibility(8);
            }
            c0804b.lmH.setPadding(0, 0, 0, 0);
            if (postData.bka() != null) {
                String name_show = postData.bka().getName_show();
                String userId = postData.bka().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0804b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0804b.rootView.setTag(sparseArray3);
                    c0804b.lmH.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0804b.lmH.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            c0804b.lmH.setTextColor(ap.getColor(R.color.cp_cont_f));
            d(postData, this.lDq);
            TbRichText dHz = postData.dHz();
            if (dHz != null) {
                c0804b.lmH.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0804b.lmH.setIsFromCDN(this.mIsFromCDN);
                if (c0804b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dHz.isChanged = true;
                }
                c0804b.lmH.setText(dHz);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.bka().getUserId();
            if (this.lDo != 0) {
                if (this.lDo != 1002 && this.lDo != 3) {
                    z8 = true;
                }
                if (this.lDo != 3 && !this.akq.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.lDp) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.akq.isBjh() ? true : z5;
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
                    c0804b.hwr.setVisibility(8);
                    sparseArray = (SparseArray) c0804b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0804b.rootView.setTag(sparseArray4);
                        c0804b.lmH.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lDo));
                        if (postData.bka() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.bka().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.bka().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.bka().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.akq != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.bka() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.bka().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.bka().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.bka().getName_show());
                            }
                            if (this.akq.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.akq.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lDo));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.lDq && z2 && this.fhR) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0804b.lDs.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0804b.lDs.setLayoutParams(layoutParams);
                    }
                    if (this.lDq && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0804b.lDs.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0804b.lDs.setLayoutParams(layoutParams2);
                    }
                    c0804b.hwr.setTag(sparseArray2);
                    c0804b.lmH.setTag(sparseArray2);
                    c0804b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0804b.lmH.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.lDp) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0804b.hwr.setVisibility(8);
            sparseArray = (SparseArray) c0804b.rootView.getTag();
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
            if (this.lDq) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0804b.lDs.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0804b.lDs.setLayoutParams(layoutParams3);
            }
            if (this.lDq) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0804b.lDs.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0804b.lDs.setLayoutParams(layoutParams22);
            }
            c0804b.hwr.setTag(sparseArray2);
            c0804b.lmH.setTag(sparseArray2);
            c0804b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0804b.lmH.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dHz;
        SpannableStringBuilder bDq;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bDq2;
        if (postData != null && (dHz = postData.dHz()) != null) {
            ArrayList<TbRichTextData> bDj = dHz.bDj();
            if (!y.isEmpty(bDj)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bDj.get(bDj.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bDj.size() > 1) {
                            if ((bDj.get(bDj.size() + (-2)) != null ? bDj.get(bDj.size() - 2).getType() : -1) != type) {
                                str2 = at.getFormatTime(postData.getTime());
                                bDq2 = tbRichTextData2.bDq();
                                if (dHz.hasAppendTime && bDq2 != 0 && dHz.appendLength <= bDq2.length()) {
                                    bDq2.delete(bDq2.length() - dHz.appendLength, bDq2.length());
                                }
                                String forceLToR = at.forceLToR(str2);
                                if (bDq2 != null) {
                                    bDq2.append((CharSequence) forceLToR);
                                }
                                dHz.hasAppendTime = true;
                                dHz.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bDq2 = tbRichTextData2.bDq();
                        if (dHz.hasAppendTime) {
                            bDq2.delete(bDq2.length() - dHz.appendLength, bDq2.length());
                        }
                        String forceLToR2 = at.forceLToR(str2);
                        if (bDq2 != null) {
                        }
                        dHz.hasAppendTime = true;
                        dHz.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dHz.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = at.forceLToR(formatTime);
                        tbRichTextData.o(str);
                        dHz.hasAppendTime = true;
                        dHz.appendLength = str.length();
                        bDj.add(tbRichTextData);
                    }
                    SpannableStringBuilder bDq3 = tbRichTextData.bDq();
                    if (bDq3 != null && str.length() <= bDq3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_d));
                        bDq3.setSpan(absoluteSizeSpan, bDq3.length() - str.length(), bDq3.length(), 33);
                        bDq3.setSpan(foregroundColorSpan, bDq3.length() - str.length(), bDq3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bDj.get(bDj.size() - 1);
                if (dHz.hasAppendTime && tbRichTextData3 != null && (bDq = tbRichTextData3.bDq()) != null && dHz.appendLength <= bDq.length()) {
                    bDq.delete(bDq.length() - dHz.appendLength, bDq.length());
                }
                dHz.hasAppendTime = false;
                dHz.appendLength = 0;
            }
        }
    }

    public void PN(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }
}
