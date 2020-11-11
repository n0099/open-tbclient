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
    protected View.OnClickListener lJj = null;
    protected int lJk = 0;
    protected boolean lJl = false;
    protected boolean idT = false;
    private boolean mIsFromCDN = true;
    private boolean lJm = false;
    private boolean fnL = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aZX = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0819b {
        public TextView hCo;
        public LinearLayout lJo;
        public View lJp;
        public TbRichTextView lsI;
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

    public void X(View.OnClickListener onClickListener) {
        this.lJj = onClickListener;
    }

    public void af(int i, boolean z) {
        this.lJk = i;
        this.lJl = z;
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
        C0819b c0819b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.mWU) {
                view = dpT();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.mWU) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.mWU) {
            view = dpT();
        }
        if ((view.getTag() instanceof SparseArray) && (c0819b = (C0819b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.idT && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0819b, postData, !z, i == 0, z2);
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
        public View fQl;
        public TextView lJn;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fQl = view.findViewById(R.id.divider_line);
            this.lJn = (TextView) view.findViewById(R.id.center_reply_text);
            this.lJn.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fQl, R.color.cp_cont_d);
                ap.setViewTextColor(this.lJn, R.color.cp_cont_d);
                ap.setBackgroundColor(this.lJn, R.color.cp_bg_line_d);
                this.lJn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dpT() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0819b c0819b = new C0819b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0819b.rootView = inflate;
        c0819b.lJo = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lJm) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0819b.lJo.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0819b.lJo.setLayoutParams(layoutParams);
        }
        c0819b.hCo = (TextView) inflate.findViewById(R.id.manage_btn);
        c0819b.lsI = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0819b.lJp = inflate.findViewById(R.id.divide_bottom_view);
        c0819b.lsI.getLayoutStrategy().setSupportNoImage();
        if (!this.lJm) {
            c0819b.lsI.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0819b.lsI.getLayoutStrategy().sw(0);
            c0819b.lsI.getLayoutStrategy().su(l.getDimens(this.mContext, R.dimen.tbds20));
            c0819b.lsI.getLayoutStrategy().sv(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0819b.lsI.setSubPbPost(true);
        c0819b.lsI.setTextColor(ap.getColor(R.color.cp_cont_f));
        c0819b.lsI.setTextSize(TbConfig.getContentSizeOfLzl());
        c0819b.lsI.setTextCenter(true);
        c0819b.lsI.setOnClickListener(this.aZX);
        c0819b.hCo.setOnClickListener(this.lJj);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0819b);
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
    public void a(C0819b c0819b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0819b != null && postData != null) {
            if (!postData.mXJ && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bmA() != null && aVar.Pu(postData.bmA().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0819b.rootView, R.color.cp_bg_line_c);
            } else {
                c0819b.rootView.setBackgroundResource(0);
            }
            if (postData.dKa()) {
                c0819b.lJp.setVisibility(0);
            } else {
                c0819b.lJp.setVisibility(8);
            }
            c0819b.lsI.setPadding(0, 0, 0, 0);
            if (postData.bmA() != null) {
                String name_show = postData.bmA().getName_show();
                String userId = postData.bmA().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0819b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0819b.rootView.setTag(sparseArray3);
                    c0819b.lsI.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0819b.lsI.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            c0819b.lsI.setTextColor(ap.getColor(R.color.cp_cont_f));
            d(postData, this.lJm);
            TbRichText dKb = postData.dKb();
            if (dKb != null) {
                c0819b.lsI.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0819b.lsI.setIsFromCDN(this.mIsFromCDN);
                if (c0819b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dKb.isChanged = true;
                }
                c0819b.lsI.setText(dKb);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.bmA().getUserId();
            if (this.lJk != 0) {
                if (this.lJk != 1002 && this.lJk != 3) {
                    z8 = true;
                }
                if (this.lJk != 3 && !this.akq.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.lJl) {
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
                    c0819b.hCo.setVisibility(8);
                    sparseArray = (SparseArray) c0819b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0819b.rootView.setTag(sparseArray4);
                        c0819b.lsI.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJk));
                        if (postData.bmA() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.bmA().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.bmA().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.bmA().getPortrait());
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
                            if (postData.bmA() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.bmA().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.bmA().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.bmA().getName_show());
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
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJk));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.lJm && z2 && this.fnL) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0819b.lJo.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0819b.lJo.setLayoutParams(layoutParams);
                    }
                    if (this.lJm && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0819b.lJo.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0819b.lJo.setLayoutParams(layoutParams2);
                    }
                    c0819b.hCo.setTag(sparseArray2);
                    c0819b.lsI.setTag(sparseArray2);
                    c0819b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0819b.lsI.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.lJl) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0819b.hCo.setVisibility(8);
            sparseArray = (SparseArray) c0819b.rootView.getTag();
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
            if (this.lJm) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0819b.lJo.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0819b.lJo.setLayoutParams(layoutParams3);
            }
            if (this.lJm) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0819b.lJo.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0819b.lJo.setLayoutParams(layoutParams22);
            }
            c0819b.hCo.setTag(sparseArray2);
            c0819b.lsI.setTag(sparseArray2);
            c0819b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0819b.lsI.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dKb;
        SpannableStringBuilder bFP;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bFP2;
        if (postData != null && (dKb = postData.dKb()) != null) {
            ArrayList<TbRichTextData> bFI = dKb.bFI();
            if (!y.isEmpty(bFI)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bFI.get(bFI.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bFI.size() > 1) {
                            if ((bFI.get(bFI.size() + (-2)) != null ? bFI.get(bFI.size() - 2).getType() : -1) != type) {
                                str2 = at.getFormatTime(postData.getTime());
                                bFP2 = tbRichTextData2.bFP();
                                if (dKb.hasAppendTime && bFP2 != 0 && dKb.appendLength <= bFP2.length()) {
                                    bFP2.delete(bFP2.length() - dKb.appendLength, bFP2.length());
                                }
                                String forceLToR = at.forceLToR(str2);
                                if (bFP2 != null) {
                                    bFP2.append((CharSequence) forceLToR);
                                }
                                dKb.hasAppendTime = true;
                                dKb.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bFP2 = tbRichTextData2.bFP();
                        if (dKb.hasAppendTime) {
                            bFP2.delete(bFP2.length() - dKb.appendLength, bFP2.length());
                        }
                        String forceLToR2 = at.forceLToR(str2);
                        if (bFP2 != null) {
                        }
                        dKb.hasAppendTime = true;
                        dKb.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dKb.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = at.forceLToR(formatTime);
                        tbRichTextData.o(str);
                        dKb.hasAppendTime = true;
                        dKb.appendLength = str.length();
                        bFI.add(tbRichTextData);
                    }
                    SpannableStringBuilder bFP3 = tbRichTextData.bFP();
                    if (bFP3 != null && str.length() <= bFP3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_d));
                        bFP3.setSpan(absoluteSizeSpan, bFP3.length() - str.length(), bFP3.length(), 33);
                        bFP3.setSpan(foregroundColorSpan, bFP3.length() - str.length(), bFP3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bFI.get(bFI.size() - 1);
                if (dKb.hasAppendTime && tbRichTextData3 != null && (bFP = tbRichTextData3.bFP()) != null && dKb.appendLength <= bFP.length()) {
                    bFP.delete(bFP.length() - dKb.appendLength, bFP.length());
                }
                dKb.hasAppendTime = false;
                dKb.appendLength = 0;
            }
        }
    }

    public void Qe(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }
}
