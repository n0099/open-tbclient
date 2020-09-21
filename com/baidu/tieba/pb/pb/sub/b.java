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
/* loaded from: classes21.dex */
public class b extends BaseAdapter {
    private bw ajX;
    protected Context mContext;
    protected View.OnClickListener lbx = null;
    protected int lby = 0;
    protected boolean lbz = false;
    protected boolean hwA = false;
    private boolean mIsFromCDN = true;
    private boolean lbA = false;
    private boolean eNo = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aTZ = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0771b {
        public TextView gVz;
        public TbRichTextView kKX;
        public LinearLayout lbC;
        public View lbD;
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
        this.ajX = bwVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.lbx = onClickListener;
    }

    public void ad(int i, boolean z) {
        this.lby = i;
        this.lbz = z;
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
        C0771b c0771b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.moE) {
                view = dgA();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.moE) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.moE) {
            view = dgA();
        }
        if ((view.getTag() instanceof SparseArray) && (c0771b = (C0771b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.hwA && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0771b, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes21.dex */
    public static class a {
        public View fpN;
        public TextView lbB;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fpN = view.findViewById(R.id.divider_line);
            this.lbB = (TextView) view.findViewById(R.id.center_reply_text);
            this.lbB.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fpN, R.color.cp_cont_d);
                ap.setViewTextColor(this.lbB, R.color.cp_cont_d);
                ap.setBackgroundColor(this.lbB, R.color.cp_bg_line_d);
                this.lbB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dgA() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0771b c0771b = new C0771b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0771b.rootView = inflate;
        c0771b.lbC = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lbA) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0771b.lbC.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0771b.lbC.setLayoutParams(layoutParams);
        }
        c0771b.gVz = (TextView) inflate.findViewById(R.id.manage_btn);
        c0771b.kKX = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0771b.lbD = inflate.findViewById(R.id.divide_bottom_view);
        c0771b.kKX.getLayoutStrategy().setSupportNoImage();
        if (!this.lbA) {
            c0771b.kKX.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0771b.kKX.getLayoutStrategy().rD(0);
            c0771b.kKX.getLayoutStrategy().rB(l.getDimens(this.mContext, R.dimen.tbds20));
            c0771b.kKX.getLayoutStrategy().rC(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0771b.kKX.setSubPbPost(true);
        c0771b.kKX.setTextColor(ap.getColor(R.color.cp_cont_f));
        c0771b.kKX.setTextSize(TbConfig.getContentSizeOfLzl());
        c0771b.kKX.setTextCenter(true);
        c0771b.kKX.setOnClickListener(this.aTZ);
        c0771b.gVz.setOnClickListener(this.lbx);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0771b);
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
    public void a(C0771b c0771b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0771b != null && postData != null) {
            if (!postData.mpt && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bfy() != null && aVar.NQ(postData.bfy().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0771b.rootView, R.color.cp_bg_line_c);
            } else {
                c0771b.rootView.setBackgroundResource(0);
            }
            if (postData.dAE()) {
                c0771b.lbD.setVisibility(0);
            } else {
                c0771b.lbD.setVisibility(8);
            }
            c0771b.kKX.setPadding(0, 0, 0, 0);
            if (postData.bfy() != null) {
                String name_show = postData.bfy().getName_show();
                String userId = postData.bfy().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0771b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0771b.rootView.setTag(sparseArray3);
                    c0771b.kKX.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0771b.kKX.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            c0771b.kKX.setTextColor(ap.getColor(R.color.cp_cont_f));
            d(postData, this.lbA);
            TbRichText dAF = postData.dAF();
            if (dAF != null) {
                c0771b.kKX.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0771b.kKX.setIsFromCDN(this.mIsFromCDN);
                if (c0771b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dAF.isChanged = true;
                }
                c0771b.kKX.setText(dAF);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.bfy().getUserId();
            if (this.lby != 0) {
                if (this.lby != 1002 && this.lby != 3) {
                    z8 = true;
                }
                if (this.lby != 3 && !this.ajX.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.lbz) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.ajX.isBjh() ? true : z5;
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
                    c0771b.gVz.setVisibility(8);
                    sparseArray = (SparseArray) c0771b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0771b.rootView.setTag(sparseArray4);
                        c0771b.kKX.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lby));
                        if (postData.bfy() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.bfy().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.bfy().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.bfy().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.ajX != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.bfy() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.bfy().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.bfy().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.bfy().getName_show());
                            }
                            if (this.ajX.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.ajX.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lby));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.lbA && z2 && this.eNo) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0771b.lbC.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0771b.lbC.setLayoutParams(layoutParams);
                    }
                    if (this.lbA && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0771b.lbC.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0771b.lbC.setLayoutParams(layoutParams2);
                    }
                    c0771b.gVz.setTag(sparseArray2);
                    c0771b.kKX.setTag(sparseArray2);
                    c0771b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0771b.kKX.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.lbz) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0771b.gVz.setVisibility(8);
            sparseArray = (SparseArray) c0771b.rootView.getTag();
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
            if (this.lbA) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0771b.lbC.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0771b.lbC.setLayoutParams(layoutParams3);
            }
            if (this.lbA) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0771b.lbC.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0771b.lbC.setLayoutParams(layoutParams22);
            }
            c0771b.gVz.setTag(sparseArray2);
            c0771b.kKX.setTag(sparseArray2);
            c0771b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0771b.kKX.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dAF;
        SpannableStringBuilder byN;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder byN2;
        if (postData != null && (dAF = postData.dAF()) != null) {
            ArrayList<TbRichTextData> byG = dAF.byG();
            if (!y.isEmpty(byG)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = byG.get(byG.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (byG.size() > 1) {
                            if ((byG.get(byG.size() + (-2)) != null ? byG.get(byG.size() - 2).getType() : -1) != type) {
                                str2 = at.getFormatTime(postData.getTime());
                                byN2 = tbRichTextData2.byN();
                                if (dAF.hasAppendTime && byN2 != 0 && dAF.appendLength <= byN2.length()) {
                                    byN2.delete(byN2.length() - dAF.appendLength, byN2.length());
                                }
                                String forceLToR = at.forceLToR(str2);
                                if (byN2 != null) {
                                    byN2.append((CharSequence) forceLToR);
                                }
                                dAF.hasAppendTime = true;
                                dAF.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        byN2 = tbRichTextData2.byN();
                        if (dAF.hasAppendTime) {
                            byN2.delete(byN2.length() - dAF.appendLength, byN2.length());
                        }
                        String forceLToR2 = at.forceLToR(str2);
                        if (byN2 != null) {
                        }
                        dAF.hasAppendTime = true;
                        dAF.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dAF.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = at.forceLToR(formatTime);
                        tbRichTextData.n(str);
                        dAF.hasAppendTime = true;
                        dAF.appendLength = str.length();
                        byG.add(tbRichTextData);
                    }
                    SpannableStringBuilder byN3 = tbRichTextData.byN();
                    if (byN3 != null && str.length() <= byN3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_d));
                        byN3.setSpan(absoluteSizeSpan, byN3.length() - str.length(), byN3.length(), 33);
                        byN3.setSpan(foregroundColorSpan, byN3.length() - str.length(), byN3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = byG.get(byG.size() - 1);
                if (dAF.hasAppendTime && tbRichTextData3 != null && (byN = tbRichTextData3.byN()) != null && dAF.appendLength <= byN.length()) {
                    byN.delete(byN.length() - dAF.appendLength, byN.length());
                }
                dAF.hasAppendTime = false;
                dAF.appendLength = 0;
            }
        }
    }

    public void OA(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }
}
