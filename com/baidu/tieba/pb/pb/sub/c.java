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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private bg cbh;
    protected Context mContext;
    protected ArrayList<PostData> aHF = null;
    protected View.OnClickListener hUx = null;
    protected int hUy = 0;
    protected boolean hUz = false;
    protected boolean hUA = false;
    protected boolean eGD = false;
    private boolean mIsFromCDN = true;
    private boolean hUB = false;
    private boolean cre = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener cll = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView edj;
        public TbRichTextView hIj;
        public LinearLayout hUD;
        public View hUE;
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

    public void ai(bg bgVar) {
        this.cbh = bgVar;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hUx = onClickListener;
    }

    public void M(int i, boolean z) {
        this.hUy = i;
        this.hUz = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF == null) {
            return 0;
        }
        return this.aHF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF == null || i < 0 || i >= this.aHF.size()) {
            return null;
        }
        return this.aHF.get(i);
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
            if (postData.getType() == PostData.iYK) {
                view = bWw();
            } else {
                view = nG();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.iYK) {
            view = nG();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.iYK) {
            view = bWw();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eGD && i + 1 >= getCount();
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
        public View cTa;
        public TextView hUC;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cTa = view.findViewById(R.id.divider_line);
            this.hUC = (TextView) view.findViewById(R.id.center_reply_text);
            this.hUC.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.l(this.cTa, R.color.cp_cont_d);
                al.j(this.hUC, R.color.cp_cont_d);
                al.l(this.hUC, R.color.cp_bg_line_d);
                this.hUC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.S(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bWw() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nG() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.hUD = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.hUB) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hUD.getLayoutParams();
            layoutParams.topMargin = l.g(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
            bVar.hUD.setLayoutParams(layoutParams);
        }
        bVar.edj = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hIj = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.hUE = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hIj.getLayoutStrategy().setSupportNoImage();
        if (!this.hUB) {
            bVar.hIj.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hIj.getLayoutStrategy().lw(0);
            bVar.hIj.getLayoutStrategy().lu(l.g(this.mContext, R.dimen.tbds20));
            bVar.hIj.getLayoutStrategy().lv(l.g(this.mContext, R.dimen.tbds14));
        }
        bVar.hIj.setSubPbPost(true);
        bVar.hIj.setTextColor(al.getColor(R.color.cp_cont_f));
        bVar.hIj.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hIj.setTextCenter(true);
        bVar.hIj.setOnClickListener(this.mCommonClickListener);
        bVar.edj.setOnClickListener(this.hUx);
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
            if (!postData.iZy && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.adv() != null && aVar.AZ(postData.adv().getUserId()));
            }
            if (z3) {
                al.l(bVar.rootView, R.color.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.cmy()) {
                bVar.hUE.setVisibility(0);
            } else {
                bVar.hUE.setVisibility(8);
            }
            bVar.hIj.setPadding(0, 0, 0, 0);
            if (postData.adv() != null) {
                String name_show = postData.adv().getName_show();
                String userId = postData.adv().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hIj.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hIj.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            bVar.hIj.setTextColor(al.getColor(R.color.cp_cont_f));
            a(postData, this.hUB);
            TbRichText cmz = postData.cmz();
            if (cmz != null) {
                bVar.hIj.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hIj.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cmz.isChanged = true;
                }
                bVar.hIj.setText(cmz);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.adv().getUserId();
            if (this.hUy != 0) {
                if (this.hUy != 1002 && this.hUy != 3) {
                    z8 = true;
                }
                if (this.hUy != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.hUz) {
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
                    bVar.edj.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hIj.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hUy));
                        if (postData.adv() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.adv().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.adv().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.adv().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.cbh != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.adv() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.adv().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.adv().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.adv().getName_show());
                            }
                            if (this.cbh.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.cbh.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hUy));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.hUB && z2 && this.cre) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hUD.getLayoutParams();
                        layoutParams.topMargin = l.g(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.hUD.setLayoutParams(layoutParams);
                    }
                    if (this.hUB && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hUD.getLayoutParams();
                        layoutParams2.topMargin = l.g(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.hUD.setLayoutParams(layoutParams2);
                    }
                    bVar.edj.setTag(sparseArray2);
                    bVar.hIj.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hIj.setOnLongClickListener(this.cll);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.hUz) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.edj.setVisibility(8);
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
            if (this.hUB) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.hUD.getLayoutParams();
                layoutParams3.topMargin = l.g(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.hUD.setLayoutParams(layoutParams3);
            }
            if (this.hUB) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.hUD.getLayoutParams();
                layoutParams22.topMargin = l.g(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.hUD.setLayoutParams(layoutParams22);
            }
            bVar.edj.setTag(sparseArray2);
            bVar.hIj.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hIj.setOnLongClickListener(this.cll);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cmz;
        SpannableStringBuilder axH;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder axH2;
        if (postData != null && (cmz = postData.cmz()) != null) {
            ArrayList<TbRichTextData> axz = cmz.axz();
            if (!v.aa(axz)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = axz.get(axz.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.aC(postData.getTime());
                        if (axz.size() > 1) {
                            if ((axz.get(axz.size() + (-2)) != null ? axz.get(axz.size() - 2).getType() : -1) != type) {
                                str2 = ap.aC(postData.getTime());
                                axH2 = tbRichTextData2.axH();
                                if (cmz.hasAppendTime && axH2 != 0 && cmz.appendLength <= axH2.length()) {
                                    axH2.delete(axH2.length() - cmz.appendLength, axH2.length());
                                }
                                String nN = ap.nN(str2);
                                if (axH2 != null) {
                                    axH2.append((CharSequence) nN);
                                }
                                cmz.hasAppendTime = true;
                                cmz.appendLength = nN.length();
                                tbRichTextData = tbRichTextData2;
                                str = nN;
                            }
                        }
                        str2 = str3;
                        axH2 = tbRichTextData2.axH();
                        if (cmz.hasAppendTime) {
                            axH2.delete(axH2.length() - cmz.appendLength, axH2.length());
                        }
                        String nN2 = ap.nN(str2);
                        if (axH2 != null) {
                        }
                        cmz.hasAppendTime = true;
                        cmz.appendLength = nN2.length();
                        tbRichTextData = tbRichTextData2;
                        str = nN2;
                    } else if (cmz.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String aC = ap.aC(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.nN(aC);
                        tbRichTextData.append(str);
                        cmz.hasAppendTime = true;
                        cmz.appendLength = str.length();
                        axz.add(tbRichTextData);
                    }
                    SpannableStringBuilder axH3 = tbRichTextData.axH();
                    if (axH3 != null && str.length() <= axH3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_cont_d));
                        axH3.setSpan(absoluteSizeSpan, axH3.length() - str.length(), axH3.length(), 33);
                        axH3.setSpan(foregroundColorSpan, axH3.length() - str.length(), axH3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = axz.get(axz.size() - 1);
                if (cmz.hasAppendTime && tbRichTextData3 != null && (axH = tbRichTextData3.axH()) != null && cmz.appendLength <= axH.length()) {
                    axH.delete(axH.length() - cmz.appendLength, axH.length());
                }
                cmz.hasAppendTime = false;
                cmz.appendLength = 0;
            }
        }
    }

    public void BD(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
