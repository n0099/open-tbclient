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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class b extends BaseAdapter {
    private bx akt;
    protected Context mContext;
    protected View.OnClickListener lJB = null;
    protected int lJC = 0;
    protected boolean lJD = false;
    protected boolean ieI = false;
    private boolean mIsFromCDN = true;
    private boolean lJE = false;
    private boolean fmT = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aYm = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0821b {
        public TextView hBV;
        public LinearLayout lJG;
        public View lJH;
        public TbRichTextView lsY;
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

    public void setThreadData(bx bxVar) {
        this.akt = bxVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.lJB = onClickListener;
    }

    public void af(int i, boolean z) {
        this.lJC = i;
        this.lJD = z;
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
        C0821b c0821b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.mXM) {
                view = dpt();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.mXM) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.mXM) {
            view = dpt();
        }
        if ((view.getTag() instanceof SparseArray) && (c0821b = (C0821b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.ieI && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0821b, postData, !z, i == 0, z2);
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
        public View fPU;
        public TextView lJF;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fPU = view.findViewById(R.id.divider_line);
            this.lJF = (TextView) view.findViewById(R.id.center_reply_text);
            this.lJF.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fPU, R.color.CAM_X0109);
                ap.setViewTextColor(this.lJF, R.color.CAM_X0109);
                ap.setBackgroundColor(this.lJF, R.color.CAM_X0201);
                this.lJF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dpt() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0821b c0821b = new C0821b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0821b.rootView = inflate;
        c0821b.lJG = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lJE) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0821b.lJG.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0821b.lJG.setLayoutParams(layoutParams);
        }
        c0821b.hBV = (TextView) inflate.findViewById(R.id.manage_btn);
        c0821b.lsY = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0821b.lJH = inflate.findViewById(R.id.divide_bottom_view);
        c0821b.lsY.getLayoutStrategy().setSupportNoImage();
        if (!this.lJE) {
            c0821b.lsY.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0821b.lsY.getLayoutStrategy().sU(0);
            c0821b.lsY.getLayoutStrategy().sS(l.getDimens(this.mContext, R.dimen.tbds20));
            c0821b.lsY.getLayoutStrategy().sT(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0821b.lsY.setSubPbPost(true);
        c0821b.lsY.setTextColor(ap.getColor(R.color.CAM_X0106));
        c0821b.lsY.setTextSize(TbConfig.getContentSizeOfLzl());
        c0821b.lsY.setTextCenter(true);
        c0821b.lsY.setOnClickListener(this.aYm);
        c0821b.hBV.setOnClickListener(this.lJB);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0821b);
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
    public void a(C0821b c0821b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0821b != null && postData != null) {
            if (!postData.mYB && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.blC() != null && aVar.OQ(postData.blC().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0821b.rootView, R.color.CAM_X0204);
            } else {
                c0821b.rootView.setBackgroundResource(0);
            }
            if (postData.dJR()) {
                c0821b.lJH.setVisibility(0);
            } else {
                c0821b.lJH.setVisibility(8);
            }
            c0821b.lsY.setPadding(0, 0, 0, 0);
            if (postData.blC() != null) {
                String name_show = postData.blC().getName_show();
                String userId = postData.blC().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0821b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0821b.rootView.setTag(sparseArray3);
                    c0821b.lsY.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0821b.lsY.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            c0821b.lsY.setTextColor(ap.getColor(R.color.CAM_X0106));
            d(postData, this.lJE);
            TbRichText dJS = postData.dJS();
            if (dJS != null) {
                c0821b.lsY.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0821b.lsY.setIsFromCDN(this.mIsFromCDN);
                if (c0821b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dJS.isChanged = true;
                }
                c0821b.lsY.setText(dJS);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.blC().getUserId();
            if (this.lJC != 0) {
                if (this.lJC != 1002 && this.lJC != 3) {
                    z8 = true;
                }
                if (this.lJC != 3 && !this.akt.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.lJD) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.akt.isBjh() ? true : z5;
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
                    c0821b.hBV.setVisibility(8);
                    sparseArray = (SparseArray) c0821b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0821b.rootView.setTag(sparseArray4);
                        c0821b.lsY.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJC));
                        if (postData.blC() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.blC().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.blC().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.blC().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.akt != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.blC() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.blC().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.blC().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.blC().getName_show());
                            }
                            if (this.akt.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.akt.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJC));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.lJE && z2 && this.fmT) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0821b.lJG.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0821b.lJG.setLayoutParams(layoutParams);
                    }
                    if (this.lJE && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0821b.lJG.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0821b.lJG.setLayoutParams(layoutParams2);
                    }
                    c0821b.hBV.setTag(sparseArray2);
                    c0821b.lsY.setTag(sparseArray2);
                    c0821b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0821b.lsY.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.lJD) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0821b.hBV.setVisibility(8);
            sparseArray = (SparseArray) c0821b.rootView.getTag();
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
            if (this.lJE) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0821b.lJG.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0821b.lJG.setLayoutParams(layoutParams3);
            }
            if (this.lJE) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0821b.lJG.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0821b.lJG.setLayoutParams(layoutParams22);
            }
            c0821b.hBV.setTag(sparseArray2);
            c0821b.lsY.setTag(sparseArray2);
            c0821b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0821b.lsY.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dJS;
        SpannableStringBuilder bFi;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bFi2;
        if (postData != null && (dJS = postData.dJS()) != null) {
            ArrayList<TbRichTextData> bFb = dJS.bFb();
            if (!y.isEmpty(bFb)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bFb.get(bFb.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + au.getFormatTime(postData.getTime());
                        if (bFb.size() > 1) {
                            if ((bFb.get(bFb.size() + (-2)) != null ? bFb.get(bFb.size() - 2).getType() : -1) != type) {
                                str2 = au.getFormatTime(postData.getTime());
                                bFi2 = tbRichTextData2.bFi();
                                if (dJS.hasAppendTime && bFi2 != 0 && dJS.appendLength <= bFi2.length()) {
                                    bFi2.delete(bFi2.length() - dJS.appendLength, bFi2.length());
                                }
                                String forceLToR = au.forceLToR(str2);
                                if (bFi2 != null) {
                                    bFi2.append((CharSequence) forceLToR);
                                }
                                dJS.hasAppendTime = true;
                                dJS.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bFi2 = tbRichTextData2.bFi();
                        if (dJS.hasAppendTime) {
                            bFi2.delete(bFi2.length() - dJS.appendLength, bFi2.length());
                        }
                        String forceLToR2 = au.forceLToR(str2);
                        if (bFi2 != null) {
                        }
                        dJS.hasAppendTime = true;
                        dJS.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dJS.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = au.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = au.forceLToR(formatTime);
                        tbRichTextData.p(str);
                        dJS.hasAppendTime = true;
                        dJS.appendLength = str.length();
                        bFb.add(tbRichTextData);
                    }
                    SpannableStringBuilder bFi3 = tbRichTextData.bFi();
                    if (bFi3 != null && str.length() <= bFi3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109));
                        bFi3.setSpan(absoluteSizeSpan, bFi3.length() - str.length(), bFi3.length(), 33);
                        bFi3.setSpan(foregroundColorSpan, bFi3.length() - str.length(), bFi3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bFb.get(bFb.size() - 1);
                if (dJS.hasAppendTime && tbRichTextData3 != null && (bFi = tbRichTextData3.bFi()) != null && dJS.appendLength <= bFi.length()) {
                    bFi.delete(bFi.length() - dJS.appendLength, bFi.length());
                }
                dJS.hasAppendTime = false;
                dJS.appendLength = 0;
            }
        }
    }

    public void PA(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }
}
