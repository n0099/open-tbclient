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
    private bw akp;
    protected Context mContext;
    protected View.OnClickListener lqO = null;
    protected int lqP = 0;
    protected boolean lqQ = false;
    protected boolean hLv = false;
    private boolean mIsFromCDN = true;
    private boolean lqR = false;
    private boolean eZv = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aXk = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0789b {
        public TextView hkw;
        public TbRichTextView lai;
        public LinearLayout lqT;
        public View lqU;
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
        this.akp = bwVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.lqO = onClickListener;
    }

    public void af(int i, boolean z) {
        this.lqP = i;
        this.lqQ = z;
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
        C0789b c0789b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.mEk) {
                view = dkj();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.mEk) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.mEk) {
            view = dkj();
        }
        if ((view.getTag() instanceof SparseArray) && (c0789b = (C0789b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.hLv && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0789b, postData, !z, i == 0, z2);
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
        public View fCa;
        public TextView lqS;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.fCa = view.findViewById(R.id.divider_line);
            this.lqS = (TextView) view.findViewById(R.id.center_reply_text);
            this.lqS.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.fCa, R.color.cp_cont_d);
                ap.setViewTextColor(this.lqS, R.color.cp_cont_d);
                ap.setBackgroundColor(this.lqS, R.color.cp_bg_line_d);
                this.lqS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dkj() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0789b c0789b = new C0789b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0789b.rootView = inflate;
        c0789b.lqT = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lqR) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0789b.lqT.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0789b.lqT.setLayoutParams(layoutParams);
        }
        c0789b.hkw = (TextView) inflate.findViewById(R.id.manage_btn);
        c0789b.lai = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0789b.lqU = inflate.findViewById(R.id.divide_bottom_view);
        c0789b.lai.getLayoutStrategy().setSupportNoImage();
        if (!this.lqR) {
            c0789b.lai.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0789b.lai.getLayoutStrategy().sb(0);
            c0789b.lai.getLayoutStrategy().rZ(l.getDimens(this.mContext, R.dimen.tbds20));
            c0789b.lai.getLayoutStrategy().sa(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0789b.lai.setSubPbPost(true);
        c0789b.lai.setTextColor(ap.getColor(R.color.cp_cont_f));
        c0789b.lai.setTextSize(TbConfig.getContentSizeOfLzl());
        c0789b.lai.setTextCenter(true);
        c0789b.lai.setOnClickListener(this.aXk);
        c0789b.hkw.setOnClickListener(this.lqO);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0789b);
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
    public void a(C0789b c0789b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0789b != null && postData != null) {
            if (!postData.mEZ && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bih() != null && aVar.OF(postData.bih().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0789b.rootView, R.color.cp_bg_line_c);
            } else {
                c0789b.rootView.setBackgroundResource(0);
            }
            if (postData.dEq()) {
                c0789b.lqU.setVisibility(0);
            } else {
                c0789b.lqU.setVisibility(8);
            }
            c0789b.lai.setPadding(0, 0, 0, 0);
            if (postData.bih() != null) {
                String name_show = postData.bih().getName_show();
                String userId = postData.bih().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0789b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0789b.rootView.setTag(sparseArray3);
                    c0789b.lai.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0789b.lai.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            c0789b.lai.setTextColor(ap.getColor(R.color.cp_cont_f));
            d(postData, this.lqR);
            TbRichText dEr = postData.dEr();
            if (dEr != null) {
                c0789b.lai.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0789b.lai.setIsFromCDN(this.mIsFromCDN);
                if (c0789b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dEr.isChanged = true;
                }
                c0789b.lai.setText(dEr);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.bih().getUserId();
            if (this.lqP != 0) {
                if (this.lqP != 1002 && this.lqP != 3) {
                    z8 = true;
                }
                if (this.lqP != 3 && !this.akp.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.lqQ) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.akp.isBjh() ? true : z5;
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
                    c0789b.hkw.setVisibility(8);
                    sparseArray = (SparseArray) c0789b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0789b.rootView.setTag(sparseArray4);
                        c0789b.lai.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqP));
                        if (postData.bih() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.bih().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.bih().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.bih().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.akp != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.bih() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.bih().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.bih().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.bih().getName_show());
                            }
                            if (this.akp.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.akp.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqP));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.lqR && z2 && this.eZv) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0789b.lqT.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0789b.lqT.setLayoutParams(layoutParams);
                    }
                    if (this.lqR && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0789b.lqT.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0789b.lqT.setLayoutParams(layoutParams2);
                    }
                    c0789b.hkw.setTag(sparseArray2);
                    c0789b.lai.setTag(sparseArray2);
                    c0789b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0789b.lai.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.lqQ) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0789b.hkw.setVisibility(8);
            sparseArray = (SparseArray) c0789b.rootView.getTag();
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
            if (this.lqR) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0789b.lqT.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0789b.lqT.setLayoutParams(layoutParams3);
            }
            if (this.lqR) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0789b.lqT.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0789b.lqT.setLayoutParams(layoutParams22);
            }
            c0789b.hkw.setTag(sparseArray2);
            c0789b.lai.setTag(sparseArray2);
            c0789b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0789b.lai.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dEr;
        SpannableStringBuilder bBx;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder bBx2;
        if (postData != null && (dEr = postData.dEr()) != null) {
            ArrayList<TbRichTextData> bBq = dEr.bBq();
            if (!y.isEmpty(bBq)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bBq.get(bBq.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bBq.size() > 1) {
                            if ((bBq.get(bBq.size() + (-2)) != null ? bBq.get(bBq.size() - 2).getType() : -1) != type) {
                                str2 = at.getFormatTime(postData.getTime());
                                bBx2 = tbRichTextData2.bBx();
                                if (dEr.hasAppendTime && bBx2 != 0 && dEr.appendLength <= bBx2.length()) {
                                    bBx2.delete(bBx2.length() - dEr.appendLength, bBx2.length());
                                }
                                String forceLToR = at.forceLToR(str2);
                                if (bBx2 != null) {
                                    bBx2.append((CharSequence) forceLToR);
                                }
                                dEr.hasAppendTime = true;
                                dEr.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        bBx2 = tbRichTextData2.bBx();
                        if (dEr.hasAppendTime) {
                            bBx2.delete(bBx2.length() - dEr.appendLength, bBx2.length());
                        }
                        String forceLToR2 = at.forceLToR(str2);
                        if (bBx2 != null) {
                        }
                        dEr.hasAppendTime = true;
                        dEr.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (dEr.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = at.forceLToR(formatTime);
                        tbRichTextData.o(str);
                        dEr.hasAppendTime = true;
                        dEr.appendLength = str.length();
                        bBq.add(tbRichTextData);
                    }
                    SpannableStringBuilder bBx3 = tbRichTextData.bBx();
                    if (bBx3 != null && str.length() <= bBx3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_d));
                        bBx3.setSpan(absoluteSizeSpan, bBx3.length() - str.length(), bBx3.length(), 33);
                        bBx3.setSpan(foregroundColorSpan, bBx3.length() - str.length(), bBx3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bBq.get(bBq.size() - 1);
                if (dEr.hasAppendTime && tbRichTextData3 != null && (bBx = tbRichTextData3.bBx()) != null && dEr.appendLength <= bBx.length()) {
                    bBx.delete(bBx.length() - dEr.appendLength, bBx.length());
                }
                dEr.hasAppendTime = false;
                dEr.appendLength = 0;
            }
        }
    }

    public void Pp(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }
}
