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
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    private bw ajz;
    protected Context mContext;
    protected View.OnClickListener kST = null;
    protected int kSU = 0;
    protected boolean kSV = false;
    protected boolean hpw = false;
    private boolean mIsFromCDN = true;
    private boolean kSW = false;
    private boolean eKX = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aRW = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0774b {
        public TextView gRR;
        public TbRichTextView kCz;
        public LinearLayout kSY;
        public View kSZ;
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
        this.ajz = bwVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.kST = onClickListener;
    }

    public void ac(int i, boolean z) {
        this.kSU = i;
        this.kSV = z;
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
        C0774b c0774b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.mff) {
                view = dcW();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.mff) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.mff) {
            view = dcW();
        }
        if ((view.getTag() instanceof SparseArray) && (c0774b = (C0774b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.hpw && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0774b, postData, !z, i == 0, z2);
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
        public View fmI;
        public TextView kSX;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fmI = view.findViewById(R.id.divider_line);
            this.kSX = (TextView) view.findViewById(R.id.center_reply_text);
            this.kSX.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fmI, R.color.cp_cont_d);
                ap.setViewTextColor(this.kSX, R.color.cp_cont_d);
                ap.setBackgroundColor(this.kSX, R.color.cp_bg_line_d);
                this.kSX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dcW() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0774b c0774b = new C0774b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0774b.rootView = inflate;
        c0774b.kSY = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.kSW) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0774b.kSY.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0774b.kSY.setLayoutParams(layoutParams);
        }
        c0774b.gRR = (TextView) inflate.findViewById(R.id.manage_btn);
        c0774b.kCz = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0774b.kSZ = inflate.findViewById(R.id.divide_bottom_view);
        c0774b.kCz.getLayoutStrategy().setSupportNoImage();
        if (!this.kSW) {
            c0774b.kCz.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0774b.kCz.getLayoutStrategy().rm(0);
            c0774b.kCz.getLayoutStrategy().rk(l.getDimens(this.mContext, R.dimen.tbds20));
            c0774b.kCz.getLayoutStrategy().rl(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0774b.kCz.setSubPbPost(true);
        c0774b.kCz.setTextColor(ap.getColor(R.color.cp_cont_f));
        c0774b.kCz.setTextSize(TbConfig.getContentSizeOfLzl());
        c0774b.kCz.setTextCenter(true);
        c0774b.kCz.setOnClickListener(this.aRW);
        c0774b.gRR.setOnClickListener(this.kST);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0774b);
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
    public void a(C0774b c0774b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0774b != null && postData != null) {
            if (!postData.mfU && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.beE() != null && aVar.Np(postData.beE().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0774b.rootView, R.color.cp_bg_line_c);
            } else {
                c0774b.rootView.setBackgroundResource(0);
            }
            if (postData.dwL()) {
                c0774b.kSZ.setVisibility(0);
            } else {
                c0774b.kSZ.setVisibility(8);
            }
            c0774b.kCz.setPadding(0, 0, 0, 0);
            if (postData.beE() != null) {
                String name_show = postData.beE().getName_show();
                String userId = postData.beE().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0774b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0774b.rootView.setTag(sparseArray3);
                    c0774b.kCz.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0774b.kCz.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            c0774b.kCz.setTextColor(ap.getColor(R.color.cp_cont_f));
            d(postData, this.kSW);
            TbRichText dwM = postData.dwM();
            if (dwM != null) {
                c0774b.kCz.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0774b.kCz.setIsFromCDN(this.mIsFromCDN);
                if (c0774b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dwM.isChanged = true;
                }
                c0774b.kCz.setText(dwM);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.beE().getUserId();
            if (this.kSU != 0) {
                if (this.kSU != 1002 && this.kSU != 3) {
                    z8 = true;
                }
                if (this.kSU != 3 && !this.ajz.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.kSV) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.ajz.isBjh() ? true : z5;
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
                    c0774b.gRR.setVisibility(8);
                    sparseArray = (SparseArray) c0774b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0774b.rootView.setTag(sparseArray4);
                        c0774b.kCz.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kSU));
                        if (postData.beE() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.ajz != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.beE() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.beE().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.beE().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.beE().getName_show());
                            }
                            if (this.ajz.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.ajz.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kSU));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.kSW && z2 && this.eKX) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0774b.kSY.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0774b.kSY.setLayoutParams(layoutParams);
                    }
                    if (this.kSW && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0774b.kSY.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0774b.kSY.setLayoutParams(layoutParams2);
                    }
                    c0774b.gRR.setTag(sparseArray2);
                    c0774b.kCz.setTag(sparseArray2);
                    c0774b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0774b.kCz.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.kSV) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0774b.gRR.setVisibility(8);
            sparseArray = (SparseArray) c0774b.rootView.getTag();
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
            if (this.kSW) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0774b.kSY.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0774b.kSY.setLayoutParams(layoutParams3);
            }
            if (this.kSW) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0774b.kSY.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0774b.kSY.setLayoutParams(layoutParams22);
            }
            c0774b.gRR.setTag(sparseArray2);
            c0774b.kCz.setTag(sparseArray2);
            c0774b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0774b.kCz.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dwM;
        SpannableStringBuilder bxE;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bxE2;
        if (postData != null && (dwM = postData.dwM()) != null) {
            ArrayList<TbRichTextData> bxx = dwM.bxx();
            if (!y.isEmpty(bxx)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bxx.get(bxx.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bxx.size() > 1) {
                            if ((bxx.get(bxx.size() + (-2)) != null ? bxx.get(bxx.size() - 2).getType() : -1) != type) {
                                str2 = at.getFormatTime(postData.getTime());
                                bxE2 = tbRichTextData2.bxE();
                                if (dwM.hasAppendTime && bxE2 != 0 && dwM.appendLength <= bxE2.length()) {
                                    bxE2.delete(bxE2.length() - dwM.appendLength, bxE2.length());
                                }
                                String forceLToR = at.forceLToR(str2);
                                if (bxE2 != null) {
                                    bxE2.append((CharSequence) forceLToR);
                                }
                                dwM.hasAppendTime = true;
                                dwM.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bxE2 = tbRichTextData2.bxE();
                        if (dwM.hasAppendTime) {
                            bxE2.delete(bxE2.length() - dwM.appendLength, bxE2.length());
                        }
                        String forceLToR2 = at.forceLToR(str2);
                        if (bxE2 != null) {
                        }
                        dwM.hasAppendTime = true;
                        dwM.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dwM.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = at.forceLToR(formatTime);
                        tbRichTextData.n(str);
                        dwM.hasAppendTime = true;
                        dwM.appendLength = str.length();
                        bxx.add(tbRichTextData);
                    }
                    SpannableStringBuilder bxE3 = tbRichTextData.bxE();
                    if (bxE3 != null && str.length() <= bxE3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_d));
                        bxE3.setSpan(absoluteSizeSpan, bxE3.length() - str.length(), bxE3.length(), 33);
                        bxE3.setSpan(foregroundColorSpan, bxE3.length() - str.length(), bxE3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bxx.get(bxx.size() - 1);
                if (dwM.hasAppendTime && tbRichTextData3 != null && (bxE = tbRichTextData3.bxE()) != null && dwM.appendLength <= bxE.length()) {
                    bxE.delete(bxE.length() - dwM.appendLength, bxE.length());
                }
                dwM.hasAppendTime = false;
                dwM.appendLength = 0;
            }
        }
    }

    public void NZ(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }
}
