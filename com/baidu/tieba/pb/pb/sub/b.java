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
    private bj NR;
    protected Context mContext;
    protected View.OnClickListener iXt = null;
    protected int iXu = 0;
    protected boolean iXv = false;
    protected boolean fQn = false;
    private boolean mIsFromCDN = true;
    private boolean iXw = false;
    private boolean dxw = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener akE = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0582b {
        public TextView fty;
        public TbRichTextView iIp;
        public LinearLayout iXy;
        public View iXz;
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
        this.NR = bjVar;
    }

    public void S(View.OnClickListener onClickListener) {
        this.iXt = onClickListener;
    }

    public void O(int i, boolean z) {
        this.iXu = i;
        this.iXv = z;
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
        C0582b c0582b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.kim) {
                view = csi();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.kim) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.kim) {
            view = csi();
        }
        if ((view.getTag() instanceof SparseArray) && (c0582b = (C0582b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.fQn && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0582b, postData, !z, i == 0, z2);
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
        public View cey;
        public TextView iXx;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cey = view.findViewById(R.id.divider_line);
            this.iXx = (TextView) view.findViewById(R.id.center_reply_text);
            this.iXx.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.cey, R.color.cp_cont_d);
                am.setViewTextColor(this.iXx, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.iXx, R.color.cp_bg_line_d);
                this.iXx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View csi() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0582b c0582b = new C0582b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0582b.rootView = inflate;
        c0582b.iXy = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.iXw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0582b.iXy.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0582b.iXy.setLayoutParams(layoutParams);
        }
        c0582b.fty = (TextView) inflate.findViewById(R.id.manage_btn);
        c0582b.iIp = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0582b.iXz = inflate.findViewById(R.id.divide_bottom_view);
        c0582b.iIp.getLayoutStrategy().setSupportNoImage();
        if (!this.iXw) {
            c0582b.iIp.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0582b.iIp.getLayoutStrategy().nt(0);
            c0582b.iIp.getLayoutStrategy().nr(l.getDimens(this.mContext, R.dimen.tbds20));
            c0582b.iIp.getLayoutStrategy().ns(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0582b.iIp.setSubPbPost(true);
        c0582b.iIp.setTextColor(am.getColor(R.color.cp_cont_f));
        c0582b.iIp.setTextSize(TbConfig.getContentSizeOfLzl());
        c0582b.iIp.setTextCenter(true);
        c0582b.iIp.setOnClickListener(this.akE);
        c0582b.fty.setOnClickListener(this.iXt);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0582b);
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
    public void a(C0582b c0582b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0582b != null && postData != null) {
            if (!postData.kjc && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aCr() != null && aVar.FK(postData.aCr().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0582b.rootView, R.color.cp_bg_line_c);
            } else {
                c0582b.rootView.setBackgroundResource(0);
            }
            if (postData.cLw()) {
                c0582b.iXz.setVisibility(0);
            } else {
                c0582b.iXz.setVisibility(8);
            }
            c0582b.iIp.setPadding(0, 0, 0, 0);
            if (postData.aCr() != null) {
                String name_show = postData.aCr().getName_show();
                String userId = postData.aCr().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0582b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0582b.rootView.setTag(sparseArray3);
                    c0582b.iIp.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0582b.iIp.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0582b.iIp.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.iXw);
            TbRichText cLx = postData.cLx();
            if (cLx != null) {
                c0582b.iIp.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0582b.iIp.setIsFromCDN(this.mIsFromCDN);
                if (c0582b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cLx.isChanged = true;
                }
                c0582b.iIp.setText(cLx);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aCr().getUserId();
            if (this.iXu != 0) {
                if (this.iXu != 1002 && this.iXu != 3) {
                    z8 = true;
                }
                if (this.iXu != 3 && !this.NR.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.iXv) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.NR.isBjh() ? true : z5;
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
                    c0582b.fty.setVisibility(8);
                    sparseArray = (SparseArray) c0582b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0582b.rootView.setTag(sparseArray4);
                        c0582b.iIp.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iXu));
                        if (postData.aCr() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aCr().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aCr().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aCr().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.NR != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aCr() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aCr().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aCr().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aCr().getName_show());
                            }
                            if (this.NR.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.NR.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iXu));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.iXw && z2 && this.dxw) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0582b.iXy.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0582b.iXy.setLayoutParams(layoutParams);
                    }
                    if (this.iXw && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0582b.iXy.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0582b.iXy.setLayoutParams(layoutParams2);
                    }
                    c0582b.fty.setTag(sparseArray2);
                    c0582b.iIp.setTag(sparseArray2);
                    c0582b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0582b.iIp.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.iXv) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0582b.fty.setVisibility(8);
            sparseArray = (SparseArray) c0582b.rootView.getTag();
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
            if (this.iXw) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0582b.iXy.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0582b.iXy.setLayoutParams(layoutParams3);
            }
            if (this.iXw) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0582b.iXy.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0582b.iXy.setLayoutParams(layoutParams22);
            }
            c0582b.fty.setTag(sparseArray2);
            c0582b.iIp.setTag(sparseArray2);
            c0582b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0582b.iIp.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText cLx;
        SpannableStringBuilder aUe;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder aUe2;
        if (postData != null && (cLx = postData.cLx()) != null) {
            ArrayList<TbRichTextData> aTX = cLx.aTX();
            if (!v.isEmpty(aTX)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = aTX.get(aTX.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (aTX.size() > 1) {
                            if ((aTX.get(aTX.size() + (-2)) != null ? aTX.get(aTX.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                aUe2 = tbRichTextData2.aUe();
                                if (cLx.hasAppendTime && aUe2 != 0 && cLx.appendLength <= aUe2.length()) {
                                    aUe2.delete(aUe2.length() - cLx.appendLength, aUe2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (aUe2 != null) {
                                    aUe2.append((CharSequence) forceLToR);
                                }
                                cLx.hasAppendTime = true;
                                cLx.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        aUe2 = tbRichTextData2.aUe();
                        if (cLx.hasAppendTime) {
                            aUe2.delete(aUe2.length() - cLx.appendLength, aUe2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (aUe2 != null) {
                        }
                        cLx.hasAppendTime = true;
                        cLx.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cLx.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        cLx.hasAppendTime = true;
                        cLx.appendLength = str.length();
                        aTX.add(tbRichTextData);
                    }
                    SpannableStringBuilder aUe3 = tbRichTextData.aUe();
                    if (aUe3 != null && str.length() <= aUe3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        aUe3.setSpan(absoluteSizeSpan, aUe3.length() - str.length(), aUe3.length(), 33);
                        aUe3.setSpan(foregroundColorSpan, aUe3.length() - str.length(), aUe3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = aTX.get(aTX.size() - 1);
                if (cLx.hasAppendTime && tbRichTextData3 != null && (aUe = tbRichTextData3.aUe()) != null && cLx.appendLength <= aUe.length()) {
                    aUe.delete(aUe.length() - cLx.appendLength, aUe.length());
                }
                cLx.hasAppendTime = false;
                cLx.appendLength = 0;
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
        this.akE = onClickListener;
    }
}
