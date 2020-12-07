package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class b extends BaseAdapter {
    private by alu;
    protected Context mContext;
    protected View.OnClickListener lXv = null;
    protected int lXw = 0;
    protected boolean lXx = false;
    protected boolean ipC = false;
    private boolean mIsFromCDN = true;
    private boolean lXy = false;
    private boolean fux = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener bbH = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0837b {
        public TextView hLA;
        public TbRichTextView lGK;
        public LinearLayout lXA;
        public View lXB;
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

    public void setThreadData(by byVar) {
        this.alu = byVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.lXv = onClickListener;
    }

    public void af(int i, boolean z) {
        this.lXw = i;
        this.lXx = z;
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
        C0837b c0837b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.nlK) {
                view = duK();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.nlK) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.nlK) {
            view = duK();
        }
        if ((view.getTag() instanceof SparseArray) && (c0837b = (C0837b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.ipC && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0837b, postData, !z, i == 0, z2);
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
        public View fYd;
        public TextView lXz;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fYd = view.findViewById(R.id.divider_line);
            this.lXz = (TextView) view.findViewById(R.id.center_reply_text);
            this.lXz.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fYd, R.color.CAM_X0109);
                ap.setViewTextColor(this.lXz, R.color.CAM_X0109);
                ap.setBackgroundColor(this.lXz, R.color.CAM_X0201);
                this.lXz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View duK() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0837b c0837b = new C0837b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0837b.rootView = inflate;
        c0837b.lXA = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lXy) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0837b.lXA.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0837b.lXA.setLayoutParams(layoutParams);
        }
        c0837b.hLA = (TextView) inflate.findViewById(R.id.manage_btn);
        c0837b.lGK = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0837b.lXB = inflate.findViewById(R.id.divide_bottom_view);
        c0837b.lGK.getLayoutStrategy().setSupportNoImage();
        if (!this.lXy) {
            c0837b.lGK.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0837b.lGK.getLayoutStrategy().tx(0);
            c0837b.lGK.getLayoutStrategy().tv(l.getDimens(this.mContext, R.dimen.tbds20));
            c0837b.lGK.getLayoutStrategy().tw(l.getDimens(this.mContext, R.dimen.tbds14));
            c0837b.lGK.setMaxLines(4);
            c0837b.lGK.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c0837b.lGK.setSubPbPost(true);
        c0837b.lGK.setTextColor(ap.getColor(R.color.CAM_X0106));
        c0837b.lGK.setTextSize(TbConfig.getContentSizeOfLzl());
        c0837b.lGK.setTextCenter(true);
        c0837b.lGK.setOnClickListener(this.bbH);
        c0837b.hLA.setOnClickListener(this.lXv);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0837b);
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
    public void a(C0837b c0837b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0837b != null && postData != null) {
            if (!postData.nmz && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.boP() != null && aVar.PY(postData.boP().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0837b.rootView, R.color.CAM_X0204);
            } else {
                c0837b.rootView.setBackgroundResource(0);
            }
            if (postData.dPh()) {
                c0837b.lXB.setVisibility(0);
            } else {
                c0837b.lXB.setVisibility(8);
            }
            c0837b.lGK.setPadding(0, 0, 0, 0);
            if (postData.boP() != null) {
                String name_show = postData.boP().getName_show();
                String userId = postData.boP().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0837b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0837b.rootView.setTag(sparseArray3);
                    c0837b.lGK.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0837b.lGK.setLinkTextColor(ap.getColor(R.color.CAM_X0108));
            c0837b.lGK.setTextColor(ap.getColor(R.color.CAM_X0106));
            d(postData, this.lXy);
            TbRichText dPi = postData.dPi();
            if (dPi != null) {
                c0837b.lGK.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0837b.lGK.setIsFromCDN(this.mIsFromCDN);
                if (c0837b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dPi.isChanged = true;
                }
                c0837b.lGK.setText(dPi);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.boP().getUserId();
            if (this.lXw != 0) {
                if (this.lXw != 1002 && this.lXw != 3) {
                    z8 = true;
                }
                if (this.lXw != 3 && !this.alu.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.lXx) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.alu.isBjh() ? true : z5;
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
                    c0837b.hLA.setVisibility(8);
                    sparseArray = (SparseArray) c0837b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0837b.rootView.setTag(sparseArray4);
                        c0837b.lGK.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lXw));
                        if (postData.boP() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.boP().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.boP().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.boP().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.alu != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.boP() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.boP().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.boP().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.boP().getName_show());
                            }
                            if (this.alu.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.alu.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lXw));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.lXy && z2 && this.fux) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0837b.lXA.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0837b.lXA.setLayoutParams(layoutParams);
                    }
                    if (this.lXy && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0837b.lXA.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0837b.lXA.setLayoutParams(layoutParams2);
                    }
                    c0837b.hLA.setTag(sparseArray2);
                    c0837b.lGK.setTag(sparseArray2);
                    c0837b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0837b.lGK.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.lXx) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0837b.hLA.setVisibility(8);
            sparseArray = (SparseArray) c0837b.rootView.getTag();
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
            if (this.lXy) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0837b.lXA.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0837b.lXA.setLayoutParams(layoutParams3);
            }
            if (this.lXy) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0837b.lXA.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0837b.lXA.setLayoutParams(layoutParams22);
            }
            c0837b.hLA.setTag(sparseArray2);
            c0837b.lGK.setTag(sparseArray2);
            c0837b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0837b.lGK.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dPi;
        SpannableStringBuilder bIJ;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bIJ2;
        if (postData != null && (dPi = postData.dPi()) != null) {
            ArrayList<TbRichTextData> bIC = dPi.bIC();
            if (!y.isEmpty(bIC)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bIC.get(bIC.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + au.getFormatTime(postData.getTime());
                        if (bIC.size() > 1) {
                            if ((bIC.get(bIC.size() + (-2)) != null ? bIC.get(bIC.size() - 2).getType() : -1) != type) {
                                str2 = au.getFormatTime(postData.getTime());
                                bIJ2 = tbRichTextData2.bIJ();
                                if (dPi.hasAppendTime && bIJ2 != 0 && dPi.appendLength <= bIJ2.length()) {
                                    bIJ2.delete(bIJ2.length() - dPi.appendLength, bIJ2.length());
                                }
                                String forceLToR = au.forceLToR(str2);
                                if (bIJ2 != null) {
                                    bIJ2.append((CharSequence) forceLToR);
                                }
                                dPi.hasAppendTime = true;
                                dPi.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bIJ2 = tbRichTextData2.bIJ();
                        if (dPi.hasAppendTime) {
                            bIJ2.delete(bIJ2.length() - dPi.appendLength, bIJ2.length());
                        }
                        String forceLToR2 = au.forceLToR(str2);
                        if (bIJ2 != null) {
                        }
                        dPi.hasAppendTime = true;
                        dPi.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dPi.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = au.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = au.forceLToR(formatTime);
                        tbRichTextData.q(str);
                        dPi.hasAppendTime = true;
                        dPi.appendLength = str.length();
                        bIC.add(tbRichTextData);
                    }
                    SpannableStringBuilder bIJ3 = tbRichTextData.bIJ();
                    if (bIJ3 != null && str.length() <= bIJ3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109));
                        bIJ3.setSpan(absoluteSizeSpan, bIJ3.length() - str.length(), bIJ3.length(), 33);
                        bIJ3.setSpan(foregroundColorSpan, bIJ3.length() - str.length(), bIJ3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bIC.get(bIC.size() - 1);
                if (dPi.hasAppendTime && tbRichTextData3 != null && (bIJ = tbRichTextData3.bIJ()) != null && dPi.appendLength <= bIJ.length()) {
                    bIJ.delete(bIJ.length() - dPi.appendLength, bIJ.length());
                }
                dPi.hasAppendTime = false;
                dPi.appendLength = 0;
            }
        }
    }

    public void QI(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }
}
