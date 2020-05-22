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
import com.baidu.tbadk.core.data.bk;
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
    private bk ahg;
    protected Context mContext;
    protected View.OnClickListener jZo = null;
    protected int jZp = 0;
    protected boolean jZq = false;
    protected boolean gJL = false;
    private boolean mIsFromCDN = true;
    private boolean jZr = false;
    private boolean elr = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aIH = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0694b {
        public TextView gmP;
        public TbRichTextView jJw;
        public LinearLayout jZt;
        public View jZu;
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

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public void T(View.OnClickListener onClickListener) {
        this.jZo = onClickListener;
    }

    public void Y(int i, boolean z) {
        this.jZp = i;
        this.jZq = z;
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
        C0694b c0694b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.lkN) {
                view = cJK();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.lkN) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.lkN) {
            view = cJK();
        }
        if ((view.getTag() instanceof SparseArray) && (c0694b = (C0694b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.gJL && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0694b, postData, !z, i == 0, z2);
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
        public View eLg;
        public TextView jZs;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.eLg = view.findViewById(R.id.divider_line);
            this.jZs = (TextView) view.findViewById(R.id.center_reply_text);
            this.jZs.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.eLg, R.color.cp_cont_d);
                am.setViewTextColor(this.jZs, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.jZs, R.color.cp_bg_line_d);
                this.jZs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cJK() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0694b c0694b = new C0694b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0694b.rootView = inflate;
        c0694b.jZt = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.jZr) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0694b.jZt.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0694b.jZt.setLayoutParams(layoutParams);
        }
        c0694b.gmP = (TextView) inflate.findViewById(R.id.manage_btn);
        c0694b.jJw = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0694b.jZu = inflate.findViewById(R.id.divide_bottom_view);
        c0694b.jJw.getLayoutStrategy().setSupportNoImage();
        if (!this.jZr) {
            c0694b.jJw.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0694b.jJw.getLayoutStrategy().oi(0);
            c0694b.jJw.getLayoutStrategy().og(l.getDimens(this.mContext, R.dimen.tbds20));
            c0694b.jJw.getLayoutStrategy().oh(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0694b.jJw.setSubPbPost(true);
        c0694b.jJw.setTextColor(am.getColor(R.color.cp_cont_f));
        c0694b.jJw.setTextSize(TbConfig.getContentSizeOfLzl());
        c0694b.jJw.setTextCenter(true);
        c0694b.jJw.setOnClickListener(this.aIH);
        c0694b.gmP.setOnClickListener(this.jZo);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0694b);
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
    public void a(C0694b c0694b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0694b != null && postData != null) {
            if (!postData.llD && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aQx() != null && aVar.Jg(postData.aQx().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0694b.rootView, R.color.cp_bg_line_c);
            } else {
                c0694b.rootView.setBackgroundResource(0);
            }
            if (postData.ddv()) {
                c0694b.jZu.setVisibility(0);
            } else {
                c0694b.jZu.setVisibility(8);
            }
            c0694b.jJw.setPadding(0, 0, 0, 0);
            if (postData.aQx() != null) {
                String name_show = postData.aQx().getName_show();
                String userId = postData.aQx().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0694b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0694b.rootView.setTag(sparseArray3);
                    c0694b.jJw.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0694b.jJw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0694b.jJw.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.jZr);
            TbRichText ddw = postData.ddw();
            if (ddw != null) {
                c0694b.jJw.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0694b.jJw.setIsFromCDN(this.mIsFromCDN);
                if (c0694b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    ddw.isChanged = true;
                }
                c0694b.jJw.setText(ddw);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aQx().getUserId();
            if (this.jZp != 0) {
                if (this.jZp != 1002 && this.jZp != 3) {
                    z8 = true;
                }
                if (this.jZp != 3 && !this.ahg.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.jZq) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.ahg.isBjh() ? true : z5;
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
                    c0694b.gmP.setVisibility(8);
                    sparseArray = (SparseArray) c0694b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0694b.rootView.setTag(sparseArray4);
                        c0694b.jJw.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jZp));
                        if (postData.aQx() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.ahg != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aQx() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aQx().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aQx().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aQx().getName_show());
                            }
                            if (this.ahg.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.ahg.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jZp));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.jZr && z2 && this.elr) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0694b.jZt.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0694b.jZt.setLayoutParams(layoutParams);
                    }
                    if (this.jZr && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0694b.jZt.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0694b.jZt.setLayoutParams(layoutParams2);
                    }
                    c0694b.gmP.setTag(sparseArray2);
                    c0694b.jJw.setTag(sparseArray2);
                    c0694b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0694b.jJw.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.jZq) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0694b.gmP.setVisibility(8);
            sparseArray = (SparseArray) c0694b.rootView.getTag();
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
            if (this.jZr) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0694b.jZt.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0694b.jZt.setLayoutParams(layoutParams3);
            }
            if (this.jZr) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0694b.jZt.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0694b.jZt.setLayoutParams(layoutParams22);
            }
            c0694b.gmP.setTag(sparseArray2);
            c0694b.jJw.setTag(sparseArray2);
            c0694b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0694b.jJw.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText ddw;
        SpannableStringBuilder bix;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bix2;
        if (postData != null && (ddw = postData.ddw()) != null) {
            ArrayList<TbRichTextData> biq = ddw.biq();
            if (!v.isEmpty(biq)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = biq.get(biq.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (biq.size() > 1) {
                            if ((biq.get(biq.size() + (-2)) != null ? biq.get(biq.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                bix2 = tbRichTextData2.bix();
                                if (ddw.hasAppendTime && bix2 != 0 && ddw.appendLength <= bix2.length()) {
                                    bix2.delete(bix2.length() - ddw.appendLength, bix2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (bix2 != null) {
                                    bix2.append((CharSequence) forceLToR);
                                }
                                ddw.hasAppendTime = true;
                                ddw.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bix2 = tbRichTextData2.bix();
                        if (ddw.hasAppendTime) {
                            bix2.delete(bix2.length() - ddw.appendLength, bix2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (bix2 != null) {
                        }
                        ddw.hasAppendTime = true;
                        ddw.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (ddw.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        ddw.hasAppendTime = true;
                        ddw.appendLength = str.length();
                        biq.add(tbRichTextData);
                    }
                    SpannableStringBuilder bix3 = tbRichTextData.bix();
                    if (bix3 != null && str.length() <= bix3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        bix3.setSpan(absoluteSizeSpan, bix3.length() - str.length(), bix3.length(), 33);
                        bix3.setSpan(foregroundColorSpan, bix3.length() - str.length(), bix3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = biq.get(biq.size() - 1);
                if (ddw.hasAppendTime && tbRichTextData3 != null && (bix = tbRichTextData3.bix()) != null && ddw.appendLength <= bix.length()) {
                    bix.delete(bix.length() - ddw.appendLength, bix.length());
                }
                ddw.hasAppendTime = false;
                ddw.appendLength = 0;
            }
        }
    }

    public void JO(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }
}
