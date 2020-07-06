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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private bu aiq;
    protected Context mContext;
    protected View.OnClickListener kum = null;
    protected int kun = 0;
    protected boolean kuo = false;
    protected boolean gWW = false;
    private boolean mIsFromCDN = true;
    private boolean kup = false;
    private boolean eud = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aLl = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0711b {
        public TextView gzO;
        public TbRichTextView kel;
        public LinearLayout kur;
        public View kus;
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

    public void setThreadData(bu buVar) {
        this.aiq = buVar;
    }

    public void U(View.OnClickListener onClickListener) {
        this.kum = onClickListener;
    }

    public void ab(int i, boolean z) {
        this.kun = i;
        this.kuo = z;
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
        C0711b c0711b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.lFP) {
                view = cOs();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.lFP) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.lFP) {
            view = cOs();
        }
        if ((view.getTag() instanceof SparseArray) && (c0711b = (C0711b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.gWW && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0711b, postData, !z, i == 0, z2);
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
        public View eVD;
        public TextView kuq;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.eVD = view.findViewById(R.id.divider_line);
            this.kuq = (TextView) view.findViewById(R.id.center_reply_text);
            this.kuq.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                an.setBackgroundColor(this.eVD, R.color.cp_cont_d);
                an.setViewTextColor(this.kuq, (int) R.color.cp_cont_d);
                an.setBackgroundColor(this.kuq, R.color.cp_bg_line_d);
                this.kuq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cOs() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0711b c0711b = new C0711b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0711b.rootView = inflate;
        c0711b.kur = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.kup) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0711b.kur.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0711b.kur.setLayoutParams(layoutParams);
        }
        c0711b.gzO = (TextView) inflate.findViewById(R.id.manage_btn);
        c0711b.kel = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0711b.kus = inflate.findViewById(R.id.divide_bottom_view);
        c0711b.kel.getLayoutStrategy().setSupportNoImage();
        if (!this.kup) {
            c0711b.kel.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0711b.kel.getLayoutStrategy().oH(0);
            c0711b.kel.getLayoutStrategy().oF(l.getDimens(this.mContext, R.dimen.tbds20));
            c0711b.kel.getLayoutStrategy().oG(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0711b.kel.setSubPbPost(true);
        c0711b.kel.setTextColor(an.getColor(R.color.cp_cont_f));
        c0711b.kel.setTextSize(TbConfig.getContentSizeOfLzl());
        c0711b.kel.setTextCenter(true);
        c0711b.kel.setOnClickListener(this.aLl);
        c0711b.gzO.setOnClickListener(this.kum);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0711b);
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
    public void a(C0711b c0711b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0711b != null && postData != null) {
            if (!postData.lGF && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aSp() != null && aVar.JJ(postData.aSp().getUserId()));
            }
            if (z3) {
                an.setBackgroundColor(c0711b.rootView, R.color.cp_bg_line_c);
            } else {
                c0711b.rootView.setBackgroundResource(0);
            }
            if (postData.dia()) {
                c0711b.kus.setVisibility(0);
            } else {
                c0711b.kus.setVisibility(8);
            }
            c0711b.kel.setPadding(0, 0, 0, 0);
            if (postData.aSp() != null) {
                String name_show = postData.aSp().getName_show();
                String userId = postData.aSp().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0711b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0711b.rootView.setTag(sparseArray3);
                    c0711b.kel.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0711b.kel.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            c0711b.kel.setTextColor(an.getColor(R.color.cp_cont_f));
            b(postData, this.kup);
            TbRichText dib = postData.dib();
            if (dib != null) {
                c0711b.kel.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0711b.kel.setIsFromCDN(this.mIsFromCDN);
                if (c0711b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dib.isChanged = true;
                }
                c0711b.kel.setText(dib);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aSp().getUserId();
            if (this.kun != 0) {
                if (this.kun != 1002 && this.kun != 3) {
                    z8 = true;
                }
                if (this.kun != 3 && !this.aiq.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.kuo) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.aiq.isBjh() ? true : z5;
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
                    c0711b.gzO.setVisibility(8);
                    sparseArray = (SparseArray) c0711b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0711b.rootView.setTag(sparseArray4);
                        c0711b.kel.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kun));
                        if (postData.aSp() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aSp().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aSp().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aSp().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.aiq != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aSp() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aSp().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aSp().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aSp().getName_show());
                            }
                            if (this.aiq.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.aiq.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kun));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.kup && z2 && this.eud) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0711b.kur.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0711b.kur.setLayoutParams(layoutParams);
                    }
                    if (this.kup && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0711b.kur.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0711b.kur.setLayoutParams(layoutParams2);
                    }
                    c0711b.gzO.setTag(sparseArray2);
                    c0711b.kel.setTag(sparseArray2);
                    c0711b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0711b.kel.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.kuo) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0711b.gzO.setVisibility(8);
            sparseArray = (SparseArray) c0711b.rootView.getTag();
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
            if (this.kup) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0711b.kur.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0711b.kur.setLayoutParams(layoutParams3);
            }
            if (this.kup) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0711b.kur.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0711b.kur.setLayoutParams(layoutParams22);
            }
            c0711b.gzO.setTag(sparseArray2);
            c0711b.kel.setTag(sparseArray2);
            c0711b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0711b.kel.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText dib;
        SpannableStringBuilder bkW;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bkW2;
        if (postData != null && (dib = postData.dib()) != null) {
            ArrayList<TbRichTextData> bkP = dib.bkP();
            if (!w.isEmpty(bkP)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bkP.get(bkP.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ar.getFormatTime(postData.getTime());
                        if (bkP.size() > 1) {
                            if ((bkP.get(bkP.size() + (-2)) != null ? bkP.get(bkP.size() - 2).getType() : -1) != type) {
                                str2 = ar.getFormatTime(postData.getTime());
                                bkW2 = tbRichTextData2.bkW();
                                if (dib.hasAppendTime && bkW2 != 0 && dib.appendLength <= bkW2.length()) {
                                    bkW2.delete(bkW2.length() - dib.appendLength, bkW2.length());
                                }
                                String forceLToR = ar.forceLToR(str2);
                                if (bkW2 != null) {
                                    bkW2.append((CharSequence) forceLToR);
                                }
                                dib.hasAppendTime = true;
                                dib.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bkW2 = tbRichTextData2.bkW();
                        if (dib.hasAppendTime) {
                            bkW2.delete(bkW2.length() - dib.appendLength, bkW2.length());
                        }
                        String forceLToR2 = ar.forceLToR(str2);
                        if (bkW2 != null) {
                        }
                        dib.hasAppendTime = true;
                        dib.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dib.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = ar.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ar.forceLToR(formatTime);
                        tbRichTextData.n(str);
                        dib.hasAppendTime = true;
                        dib.appendLength = str.length();
                        bkP.add(tbRichTextData);
                    }
                    SpannableStringBuilder bkW3 = tbRichTextData.bkW();
                    if (bkW3 != null && str.length() <= bkW3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(an.getColor(R.color.cp_cont_d));
                        bkW3.setSpan(absoluteSizeSpan, bkW3.length() - str.length(), bkW3.length(), 33);
                        bkW3.setSpan(foregroundColorSpan, bkW3.length() - str.length(), bkW3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bkP.get(bkP.size() - 1);
                if (dib.hasAppendTime && tbRichTextData3 != null && (bkW = tbRichTextData3.bkW()) != null && dib.appendLength <= bkW.length()) {
                    bkW.delete(bkW.length() - dib.appendLength, bkW.length());
                }
                dib.hasAppendTime = false;
                dib.appendLength = 0;
            }
        }
    }

    public void Kr(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }
}
