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
    private bj NQ;
    protected Context mContext;
    protected View.OnClickListener iVG = null;
    protected int iVH = 0;
    protected boolean iVI = false;
    protected boolean fPs = false;
    private boolean mIsFromCDN = true;
    private boolean iVJ = false;
    private boolean dwW = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener akt = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0581b {
        public TextView fsL;
        public TbRichTextView iGC;
        public LinearLayout iVL;
        public View iVM;
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
        this.NQ = bjVar;
    }

    public void S(View.OnClickListener onClickListener) {
        this.iVG = onClickListener;
    }

    public void O(int i, boolean z) {
        this.iVH = i;
        this.iVI = z;
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
        C0581b c0581b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.kgx) {
                view = crM();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.kgx) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.kgx) {
            view = crM();
        }
        if ((view.getTag() instanceof SparseArray) && (c0581b = (C0581b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.fPs && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0581b, postData, !z, i == 0, z2);
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
        public View cem;
        public TextView iVK;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cem = view.findViewById(R.id.divider_line);
            this.iVK = (TextView) view.findViewById(R.id.center_reply_text);
            this.iVK.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.cem, R.color.cp_cont_d);
                am.setViewTextColor(this.iVK, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.iVK, R.color.cp_bg_line_d);
                this.iVK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View crM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0581b c0581b = new C0581b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0581b.rootView = inflate;
        c0581b.iVL = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.iVJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0581b.iVL.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0581b.iVL.setLayoutParams(layoutParams);
        }
        c0581b.fsL = (TextView) inflate.findViewById(R.id.manage_btn);
        c0581b.iGC = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0581b.iVM = inflate.findViewById(R.id.divide_bottom_view);
        c0581b.iGC.getLayoutStrategy().setSupportNoImage();
        if (!this.iVJ) {
            c0581b.iGC.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0581b.iGC.getLayoutStrategy().nr(0);
            c0581b.iGC.getLayoutStrategy().np(l.getDimens(this.mContext, R.dimen.tbds20));
            c0581b.iGC.getLayoutStrategy().nq(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0581b.iGC.setSubPbPost(true);
        c0581b.iGC.setTextColor(am.getColor(R.color.cp_cont_f));
        c0581b.iGC.setTextSize(TbConfig.getContentSizeOfLzl());
        c0581b.iGC.setTextCenter(true);
        c0581b.iGC.setOnClickListener(this.akt);
        c0581b.fsL.setOnClickListener(this.iVG);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0581b);
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
    public void a(C0581b c0581b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0581b != null && postData != null) {
            if (!postData.khn && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aCo() != null && aVar.FK(postData.aCo().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0581b.rootView, R.color.cp_bg_line_c);
            } else {
                c0581b.rootView.setBackgroundResource(0);
            }
            if (postData.cLb()) {
                c0581b.iVM.setVisibility(0);
            } else {
                c0581b.iVM.setVisibility(8);
            }
            c0581b.iGC.setPadding(0, 0, 0, 0);
            if (postData.aCo() != null) {
                String name_show = postData.aCo().getName_show();
                String userId = postData.aCo().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0581b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0581b.rootView.setTag(sparseArray3);
                    c0581b.iGC.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0581b.iGC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0581b.iGC.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.iVJ);
            TbRichText cLc = postData.cLc();
            if (cLc != null) {
                c0581b.iGC.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0581b.iGC.setIsFromCDN(this.mIsFromCDN);
                if (c0581b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cLc.isChanged = true;
                }
                c0581b.iGC.setText(cLc);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aCo().getUserId();
            if (this.iVH != 0) {
                if (this.iVH != 1002 && this.iVH != 3) {
                    z8 = true;
                }
                if (this.iVH != 3 && !this.NQ.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.iVI) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.NQ.isBjh() ? true : z5;
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
                    c0581b.fsL.setVisibility(8);
                    sparseArray = (SparseArray) c0581b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0581b.rootView.setTag(sparseArray4);
                        c0581b.iGC.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iVH));
                        if (postData.aCo() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.NQ != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aCo() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aCo().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aCo().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aCo().getName_show());
                            }
                            if (this.NQ.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.NQ.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iVH));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.iVJ && z2 && this.dwW) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0581b.iVL.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0581b.iVL.setLayoutParams(layoutParams);
                    }
                    if (this.iVJ && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0581b.iVL.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0581b.iVL.setLayoutParams(layoutParams2);
                    }
                    c0581b.fsL.setTag(sparseArray2);
                    c0581b.iGC.setTag(sparseArray2);
                    c0581b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0581b.iGC.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.iVI) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0581b.fsL.setVisibility(8);
            sparseArray = (SparseArray) c0581b.rootView.getTag();
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
            if (this.iVJ) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0581b.iVL.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0581b.iVL.setLayoutParams(layoutParams3);
            }
            if (this.iVJ) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0581b.iVL.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0581b.iVL.setLayoutParams(layoutParams22);
            }
            c0581b.fsL.setTag(sparseArray2);
            c0581b.iGC.setTag(sparseArray2);
            c0581b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0581b.iGC.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText cLc;
        SpannableStringBuilder aTZ;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder aTZ2;
        if (postData != null && (cLc = postData.cLc()) != null) {
            ArrayList<TbRichTextData> aTS = cLc.aTS();
            if (!v.isEmpty(aTS)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = aTS.get(aTS.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (aTS.size() > 1) {
                            if ((aTS.get(aTS.size() + (-2)) != null ? aTS.get(aTS.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                aTZ2 = tbRichTextData2.aTZ();
                                if (cLc.hasAppendTime && aTZ2 != 0 && cLc.appendLength <= aTZ2.length()) {
                                    aTZ2.delete(aTZ2.length() - cLc.appendLength, aTZ2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (aTZ2 != null) {
                                    aTZ2.append((CharSequence) forceLToR);
                                }
                                cLc.hasAppendTime = true;
                                cLc.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        aTZ2 = tbRichTextData2.aTZ();
                        if (cLc.hasAppendTime) {
                            aTZ2.delete(aTZ2.length() - cLc.appendLength, aTZ2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (aTZ2 != null) {
                        }
                        cLc.hasAppendTime = true;
                        cLc.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cLc.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        cLc.hasAppendTime = true;
                        cLc.appendLength = str.length();
                        aTS.add(tbRichTextData);
                    }
                    SpannableStringBuilder aTZ3 = tbRichTextData.aTZ();
                    if (aTZ3 != null && str.length() <= aTZ3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        aTZ3.setSpan(absoluteSizeSpan, aTZ3.length() - str.length(), aTZ3.length(), 33);
                        aTZ3.setSpan(foregroundColorSpan, aTZ3.length() - str.length(), aTZ3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = aTS.get(aTS.size() - 1);
                if (cLc.hasAppendTime && tbRichTextData3 != null && (aTZ = tbRichTextData3.aTZ()) != null && cLc.appendLength <= aTZ.length()) {
                    aTZ.delete(aTZ.length() - cLc.appendLength, aTZ.length());
                }
                cLc.hasAppendTime = false;
                cLc.appendLength = 0;
            }
        }
    }

    public void Gr(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }
}
