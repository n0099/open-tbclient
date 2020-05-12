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
    private bj agC;
    protected Context mContext;
    protected View.OnClickListener jHF = null;
    protected int jHG = 0;
    protected boolean jHH = false;
    protected boolean gva = false;
    private boolean mIsFromCDN = true;
    private boolean jHI = false;
    private boolean dXi = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aDi = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0641b {
        public TextView fXX;
        public LinearLayout jHK;
        public View jHL;
        public TbRichTextView jsA;
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
        this.agC = bjVar;
    }

    public void T(View.OnClickListener onClickListener) {
        this.jHF = onClickListener;
    }

    public void U(int i, boolean z) {
        this.jHG = i;
        this.jHH = z;
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
        C0641b c0641b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.kSw) {
                view = cCM();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.kSw) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.kSw) {
            view = cCM();
        }
        if ((view.getTag() instanceof SparseArray) && (c0641b = (C0641b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.gva && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0641b, postData, !z, i == 0, z2);
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
        public View cDC;
        public TextView jHJ;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cDC = view.findViewById(R.id.divider_line);
            this.jHJ = (TextView) view.findViewById(R.id.center_reply_text);
            this.jHJ.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.cDC, R.color.cp_cont_d);
                am.setViewTextColor(this.jHJ, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.jHJ, R.color.cp_bg_line_d);
                this.jHJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cCM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0641b c0641b = new C0641b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0641b.rootView = inflate;
        c0641b.jHK = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.jHI) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0641b.jHK.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0641b.jHK.setLayoutParams(layoutParams);
        }
        c0641b.fXX = (TextView) inflate.findViewById(R.id.manage_btn);
        c0641b.jsA = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0641b.jHL = inflate.findViewById(R.id.divide_bottom_view);
        c0641b.jsA.getLayoutStrategy().setSupportNoImage();
        if (!this.jHI) {
            c0641b.jsA.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0641b.jsA.getLayoutStrategy().nF(0);
            c0641b.jsA.getLayoutStrategy().nD(l.getDimens(this.mContext, R.dimen.tbds20));
            c0641b.jsA.getLayoutStrategy().nE(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0641b.jsA.setSubPbPost(true);
        c0641b.jsA.setTextColor(am.getColor(R.color.cp_cont_f));
        c0641b.jsA.setTextSize(TbConfig.getContentSizeOfLzl());
        c0641b.jsA.setTextCenter(true);
        c0641b.jsA.setOnClickListener(this.aDi);
        c0641b.fXX.setOnClickListener(this.jHF);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0641b);
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
    public void a(C0641b c0641b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0641b != null && postData != null) {
            if (!postData.kTm && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aKC() != null && aVar.Hv(postData.aKC().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0641b.rootView, R.color.cp_bg_line_c);
            } else {
                c0641b.rootView.setBackgroundResource(0);
            }
            if (postData.cWq()) {
                c0641b.jHL.setVisibility(0);
            } else {
                c0641b.jHL.setVisibility(8);
            }
            c0641b.jsA.setPadding(0, 0, 0, 0);
            if (postData.aKC() != null) {
                String name_show = postData.aKC().getName_show();
                String userId = postData.aKC().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0641b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0641b.rootView.setTag(sparseArray3);
                    c0641b.jsA.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0641b.jsA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0641b.jsA.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.jHI);
            TbRichText cWr = postData.cWr();
            if (cWr != null) {
                c0641b.jsA.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0641b.jsA.setIsFromCDN(this.mIsFromCDN);
                if (c0641b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cWr.isChanged = true;
                }
                c0641b.jsA.setText(cWr);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aKC().getUserId();
            if (this.jHG != 0) {
                if (this.jHG != 1002 && this.jHG != 3) {
                    z8 = true;
                }
                if (this.jHG != 3 && !this.agC.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.jHH) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.agC.isBjh() ? true : z5;
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
                    c0641b.fXX.setVisibility(8);
                    sparseArray = (SparseArray) c0641b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0641b.rootView.setTag(sparseArray4);
                        c0641b.jsA.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHG));
                        if (postData.aKC() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aKC().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aKC().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aKC().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.agC != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aKC() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aKC().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aKC().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aKC().getName_show());
                            }
                            if (this.agC.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.agC.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHG));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.jHI && z2 && this.dXi) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0641b.jHK.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0641b.jHK.setLayoutParams(layoutParams);
                    }
                    if (this.jHI && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0641b.jHK.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0641b.jHK.setLayoutParams(layoutParams2);
                    }
                    c0641b.fXX.setTag(sparseArray2);
                    c0641b.jsA.setTag(sparseArray2);
                    c0641b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0641b.jsA.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.jHH) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0641b.fXX.setVisibility(8);
            sparseArray = (SparseArray) c0641b.rootView.getTag();
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
            if (this.jHI) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0641b.jHK.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0641b.jHK.setLayoutParams(layoutParams3);
            }
            if (this.jHI) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0641b.jHK.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0641b.jHK.setLayoutParams(layoutParams22);
            }
            c0641b.fXX.setTag(sparseArray2);
            c0641b.jsA.setTag(sparseArray2);
            c0641b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0641b.jsA.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText cWr;
        SpannableStringBuilder bcm;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bcm2;
        if (postData != null && (cWr = postData.cWr()) != null) {
            ArrayList<TbRichTextData> bcf = cWr.bcf();
            if (!v.isEmpty(bcf)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bcf.get(bcf.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (bcf.size() > 1) {
                            if ((bcf.get(bcf.size() + (-2)) != null ? bcf.get(bcf.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                bcm2 = tbRichTextData2.bcm();
                                if (cWr.hasAppendTime && bcm2 != 0 && cWr.appendLength <= bcm2.length()) {
                                    bcm2.delete(bcm2.length() - cWr.appendLength, bcm2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (bcm2 != null) {
                                    bcm2.append((CharSequence) forceLToR);
                                }
                                cWr.hasAppendTime = true;
                                cWr.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bcm2 = tbRichTextData2.bcm();
                        if (cWr.hasAppendTime) {
                            bcm2.delete(bcm2.length() - cWr.appendLength, bcm2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (bcm2 != null) {
                        }
                        cWr.hasAppendTime = true;
                        cWr.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cWr.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        cWr.hasAppendTime = true;
                        cWr.appendLength = str.length();
                        bcf.add(tbRichTextData);
                    }
                    SpannableStringBuilder bcm3 = tbRichTextData.bcm();
                    if (bcm3 != null && str.length() <= bcm3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        bcm3.setSpan(absoluteSizeSpan, bcm3.length() - str.length(), bcm3.length(), 33);
                        bcm3.setSpan(foregroundColorSpan, bcm3.length() - str.length(), bcm3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bcf.get(bcf.size() - 1);
                if (cWr.hasAppendTime && tbRichTextData3 != null && (bcm = tbRichTextData3.bcm()) != null && cWr.appendLength <= bcm.length()) {
                    bcm.delete(bcm.length() - cWr.appendLength, bcm.length());
                }
                cWr.hasAppendTime = false;
                cWr.appendLength = 0;
            }
        }
    }

    public void Ic(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }
}
