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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private bh cry;
    protected Context mContext;
    protected ArrayList<PostData> bbZ = null;
    protected View.OnClickListener ico = null;
    protected int icp = 0;
    protected boolean icq = false;
    protected boolean icr = false;
    protected boolean eVW = false;
    private boolean mIsFromCDN = true;
    private boolean ics = false;
    private boolean cFB = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener ZX = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView ewq;
        public TbRichTextView hPS;
        public LinearLayout icu;
        public View icv;
        public int mSkinType = 3;
        public View rootView;
    }

    public c(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void ai(bh bhVar) {
        this.cry = bhVar;
    }

    public void R(View.OnClickListener onClickListener) {
        this.ico = onClickListener;
    }

    public void N(int i, boolean z) {
        this.icp = i;
        this.icq = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i < 0 || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.jis) {
                view = bXs();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.jis) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.jis) {
            view = bXs();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eVW && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View deR;
        public TextView ict;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.deR = view.findViewById(R.id.divider_line);
            this.ict = (TextView) view.findViewById(R.id.center_reply_text);
            this.ict.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.deR, R.color.cp_cont_d);
                am.setViewTextColor(this.ict, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.ict, R.color.cp_bg_line_d);
                this.ict.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bXs() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.icu = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.ics) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.icu.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            bVar.icu.setLayoutParams(layoutParams);
        }
        bVar.ewq = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hPS = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.icv = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hPS.getLayoutStrategy().setSupportNoImage();
        if (!this.ics) {
            bVar.hPS.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hPS.getLayoutStrategy().kM(0);
            bVar.hPS.getLayoutStrategy().kK(l.getDimens(this.mContext, R.dimen.tbds20));
            bVar.hPS.getLayoutStrategy().kL(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        bVar.hPS.setSubPbPost(true);
        bVar.hPS.setTextColor(am.getColor(R.color.cp_cont_f));
        bVar.hPS.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hPS.setTextCenter(true);
        bVar.hPS.setOnClickListener(this.ZX);
        bVar.ewq.setOnClickListener(this.ico);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0302  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (bVar != null && postData != null) {
            if (!postData.jjg && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aiG() != null && aVar.AE(postData.aiG().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(bVar.rootView, R.color.cp_bg_line_c);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.coq()) {
                bVar.icv.setVisibility(0);
            } else {
                bVar.icv.setVisibility(8);
            }
            bVar.hPS.setPadding(0, 0, 0, 0);
            if (postData.aiG() != null) {
                String name_show = postData.aiG().getName_show();
                String userId = postData.aiG().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hPS.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hPS.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hPS.setTextColor(am.getColor(R.color.cp_cont_f));
            a(postData, this.ics);
            TbRichText cor = postData.cor();
            if (cor != null) {
                bVar.hPS.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hPS.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cor.isChanged = true;
                }
                bVar.hPS.setText(cor);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aiG().getUserId();
            if (this.icp != 0) {
                if (this.icp != 1002 && this.icp != 3) {
                    z8 = true;
                }
                if (this.icp != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.icq) {
                        z6 = false;
                    } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                        z5 = true;
                    } else {
                        z6 = false;
                        z5 = true;
                    }
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                        z10 = true;
                    } else {
                        z7 = z5;
                    }
                    bVar.ewq.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hPS.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.icp));
                        if (postData.aiG() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aiG().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aiG().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aiG().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.cry != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aiG() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aiG().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aiG().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aiG().getName_show());
                            }
                            if (this.cry.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.cry.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.icp));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.ics && z2 && this.cFB) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.icu.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        bVar.icu.setLayoutParams(layoutParams);
                    }
                    if (this.ics && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.icu.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        bVar.icu.setLayoutParams(layoutParams2);
                    }
                    bVar.ewq.setTag(sparseArray2);
                    bVar.hPS.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hPS.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.icq) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.ewq.setVisibility(8);
            sparseArray = (SparseArray) bVar.rootView.getTag();
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
            if (this.ics) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.icu.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                bVar.icu.setLayoutParams(layoutParams3);
            }
            if (this.ics) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.icu.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                bVar.icu.setLayoutParams(layoutParams22);
            }
            bVar.ewq.setTag(sparseArray2);
            bVar.hPS.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hPS.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cor;
        SpannableStringBuilder azq;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder azq2;
        if (postData != null && (cor = postData.cor()) != null) {
            ArrayList<TbRichTextData> azh = cor.azh();
            if (!v.isEmpty(azh)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = azh.get(azh.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (azh.size() > 1) {
                            if ((azh.get(azh.size() + (-2)) != null ? azh.get(azh.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                azq2 = tbRichTextData2.azq();
                                if (cor.hasAppendTime && azq2 != 0 && cor.appendLength <= azq2.length()) {
                                    azq2.delete(azq2.length() - cor.appendLength, azq2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (azq2 != null) {
                                    azq2.append((CharSequence) forceLToR);
                                }
                                cor.hasAppendTime = true;
                                cor.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        azq2 = tbRichTextData2.azq();
                        if (cor.hasAppendTime) {
                            azq2.delete(azq2.length() - cor.appendLength, azq2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (azq2 != null) {
                        }
                        cor.hasAppendTime = true;
                        cor.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cor.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.i(str);
                        cor.hasAppendTime = true;
                        cor.appendLength = str.length();
                        azh.add(tbRichTextData);
                    }
                    SpannableStringBuilder azq3 = tbRichTextData.azq();
                    if (azq3 != null && str.length() <= azq3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        azq3.setSpan(absoluteSizeSpan, azq3.length() - str.length(), azq3.length(), 33);
                        azq3.setSpan(foregroundColorSpan, azq3.length() - str.length(), azq3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = azh.get(azh.size() - 1);
                if (cor.hasAppendTime && tbRichTextData3 != null && (azq = tbRichTextData3.azq()) != null && cor.appendLength <= azq.length()) {
                    azq.delete(azq.length() - cor.appendLength, azq.length());
                }
                cor.hasAppendTime = false;
                cor.appendLength = 0;
            }
        }
    }

    public void Bi(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }
}
