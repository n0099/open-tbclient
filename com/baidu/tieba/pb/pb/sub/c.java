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
    private bh cqG;
    protected Context mContext;
    protected ArrayList<PostData> bbH = null;
    protected View.OnClickListener ibx = null;
    protected int iby = 0;
    protected boolean ibz = false;
    protected boolean ibA = false;
    protected boolean eVf = false;
    private boolean mIsFromCDN = true;
    private boolean ibB = false;
    private boolean cEK = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener ZF = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView evz;
        public TbRichTextView hPb;
        public LinearLayout ibD;
        public View ibE;
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
        this.cqG = bhVar;
    }

    public void R(View.OnClickListener onClickListener) {
        this.ibx = onClickListener;
    }

    public void N(int i, boolean z) {
        this.iby = i;
        this.ibz = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i < 0 || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
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
            if (postData.getType() == PostData.jhA) {
                view = bXq();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.jhA) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.jhA) {
            view = bXq();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eVf && i + 1 >= getCount();
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
        public View ddZ;
        public TextView ibC;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.ddZ = view.findViewById(R.id.divider_line);
            this.ibC = (TextView) view.findViewById(R.id.center_reply_text);
            this.ibC.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.ddZ, R.color.cp_cont_d);
                am.setViewTextColor(this.ibC, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.ibC, R.color.cp_bg_line_d);
                this.ibC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bXq() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.ibD = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.ibB) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ibD.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            bVar.ibD.setLayoutParams(layoutParams);
        }
        bVar.evz = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hPb = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.ibE = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hPb.getLayoutStrategy().setSupportNoImage();
        if (!this.ibB) {
            bVar.hPb.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hPb.getLayoutStrategy().kL(0);
            bVar.hPb.getLayoutStrategy().kJ(l.getDimens(this.mContext, R.dimen.tbds20));
            bVar.hPb.getLayoutStrategy().kK(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        bVar.hPb.setSubPbPost(true);
        bVar.hPb.setTextColor(am.getColor(R.color.cp_cont_f));
        bVar.hPb.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hPb.setTextCenter(true);
        bVar.hPb.setOnClickListener(this.ZF);
        bVar.evz.setOnClickListener(this.ibx);
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
            if (!postData.jip && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aiE() != null && aVar.AE(postData.aiE().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(bVar.rootView, R.color.cp_bg_line_c);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.coo()) {
                bVar.ibE.setVisibility(0);
            } else {
                bVar.ibE.setVisibility(8);
            }
            bVar.hPb.setPadding(0, 0, 0, 0);
            if (postData.aiE() != null) {
                String name_show = postData.aiE().getName_show();
                String userId = postData.aiE().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hPb.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hPb.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hPb.setTextColor(am.getColor(R.color.cp_cont_f));
            a(postData, this.ibB);
            TbRichText cop = postData.cop();
            if (cop != null) {
                bVar.hPb.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hPb.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cop.isChanged = true;
                }
                bVar.hPb.setText(cop);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aiE().getUserId();
            if (this.iby != 0) {
                if (this.iby != 1002 && this.iby != 3) {
                    z8 = true;
                }
                if (this.iby != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.ibz) {
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
                    bVar.evz.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hPb.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iby));
                        if (postData.aiE() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aiE().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aiE().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aiE().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.cqG != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aiE() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aiE().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aiE().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aiE().getName_show());
                            }
                            if (this.cqG.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.cqG.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iby));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.ibB && z2 && this.cEK) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ibD.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        bVar.ibD.setLayoutParams(layoutParams);
                    }
                    if (this.ibB && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ibD.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        bVar.ibD.setLayoutParams(layoutParams2);
                    }
                    bVar.evz.setTag(sparseArray2);
                    bVar.hPb.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hPb.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.ibz) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.evz.setVisibility(8);
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
            if (this.ibB) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.ibD.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                bVar.ibD.setLayoutParams(layoutParams3);
            }
            if (this.ibB) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.ibD.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                bVar.ibD.setLayoutParams(layoutParams22);
            }
            bVar.evz.setTag(sparseArray2);
            bVar.hPb.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hPb.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cop;
        SpannableStringBuilder azo;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder azo2;
        if (postData != null && (cop = postData.cop()) != null) {
            ArrayList<TbRichTextData> azf = cop.azf();
            if (!v.isEmpty(azf)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = azf.get(azf.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (azf.size() > 1) {
                            if ((azf.get(azf.size() + (-2)) != null ? azf.get(azf.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                azo2 = tbRichTextData2.azo();
                                if (cop.hasAppendTime && azo2 != 0 && cop.appendLength <= azo2.length()) {
                                    azo2.delete(azo2.length() - cop.appendLength, azo2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (azo2 != null) {
                                    azo2.append((CharSequence) forceLToR);
                                }
                                cop.hasAppendTime = true;
                                cop.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        azo2 = tbRichTextData2.azo();
                        if (cop.hasAppendTime) {
                            azo2.delete(azo2.length() - cop.appendLength, azo2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (azo2 != null) {
                        }
                        cop.hasAppendTime = true;
                        cop.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cop.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.i(str);
                        cop.hasAppendTime = true;
                        cop.appendLength = str.length();
                        azf.add(tbRichTextData);
                    }
                    SpannableStringBuilder azo3 = tbRichTextData.azo();
                    if (azo3 != null && str.length() <= azo3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        azo3.setSpan(absoluteSizeSpan, azo3.length() - str.length(), azo3.length(), 33);
                        azo3.setSpan(foregroundColorSpan, azo3.length() - str.length(), azo3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = azf.get(azf.size() - 1);
                if (cop.hasAppendTime && tbRichTextData3 != null && (azo = tbRichTextData3.azo()) != null && cop.appendLength <= azo.length()) {
                    azo.delete(azo.length() - cop.appendLength, azo.length());
                }
                cop.hasAppendTime = false;
                cop.appendLength = 0;
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
        this.ZF = onClickListener;
    }
}
