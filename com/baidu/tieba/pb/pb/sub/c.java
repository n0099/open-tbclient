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
    private bh cdk;
    protected Context mContext;
    protected ArrayList<PostData> aIL = null;
    protected View.OnClickListener idJ = null;
    protected int idK = 0;
    protected boolean idL = false;
    protected boolean idM = false;
    protected boolean eNp = false;
    private boolean mIsFromCDN = true;
    private boolean idN = false;
    private boolean cts = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener cnB = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView ejx;
        public TbRichTextView hRn;
        public LinearLayout idP;
        public View idQ;
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

    public void ak(bh bhVar) {
        this.cdk = bhVar;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.idJ = onClickListener;
    }

    public void P(int i, boolean z) {
        this.idK = i;
        this.idL = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL == null) {
            return 0;
        }
        return this.aIL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i < 0 || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
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
            if (postData.getType() == PostData.jiE) {
                view = cap();
            } else {
                view = nZ();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.jiE) {
            view = nZ();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.jiE) {
            view = cap();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eNp && i + 1 >= getCount();
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
        public View cVw;
        public TextView idO;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cVw = view.findViewById(R.id.divider_line);
            this.idO = (TextView) view.findViewById(R.id.center_reply_text);
            this.idO.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.l(this.cVw, R.color.cp_cont_d);
                am.j(this.idO, R.color.cp_cont_d);
                am.l(this.idO, R.color.cp_bg_line_d);
                this.idO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.V(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cap() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nZ() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.idP = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.idN) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.idP.getLayoutParams();
            layoutParams.topMargin = l.g(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
            bVar.idP.setLayoutParams(layoutParams);
        }
        bVar.ejx = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hRn = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.idQ = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hRn.getLayoutStrategy().setSupportNoImage();
        if (!this.idN) {
            bVar.hRn.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hRn.getLayoutStrategy().lH(0);
            bVar.hRn.getLayoutStrategy().lF(l.g(this.mContext, R.dimen.tbds20));
            bVar.hRn.getLayoutStrategy().lG(l.g(this.mContext, R.dimen.tbds14));
        }
        bVar.hRn.setSubPbPost(true);
        bVar.hRn.setTextColor(am.getColor(R.color.cp_cont_f));
        bVar.hRn.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hRn.setTextCenter(true);
        bVar.hRn.setOnClickListener(this.mCommonClickListener);
        bVar.ejx.setOnClickListener(this.idJ);
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
            if (!postData.jjs && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.aeC() != null && aVar.Cl(postData.aeC().getUserId()));
            }
            if (z3) {
                am.l(bVar.rootView, R.color.cp_bg_line_c);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.cqA()) {
                bVar.idQ.setVisibility(0);
            } else {
                bVar.idQ.setVisibility(8);
            }
            bVar.hRn.setPadding(0, 0, 0, 0);
            if (postData.aeC() != null) {
                String name_show = postData.aeC().getName_show();
                String userId = postData.aeC().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hRn.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hRn.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hRn.setTextColor(am.getColor(R.color.cp_cont_f));
            a(postData, this.idN);
            TbRichText cqB = postData.cqB();
            if (cqB != null) {
                bVar.hRn.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hRn.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cqB.isChanged = true;
                }
                bVar.hRn.setText(cqB);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.aeC().getUserId();
            if (this.idK != 0) {
                if (this.idK != 1002 && this.idK != 3) {
                    z8 = true;
                }
                if (this.idK != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.idL) {
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
                    bVar.ejx.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hRn.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.idK));
                        if (postData.aeC() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.aeC().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.aeC().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.aeC().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.cdk != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.aeC() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.aeC().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.aeC().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.aeC().getName_show());
                            }
                            if (this.cdk.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.cdk.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.idK));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.idN && z2 && this.cts) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.idP.getLayoutParams();
                        layoutParams.topMargin = l.g(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.idP.setLayoutParams(layoutParams);
                    }
                    if (this.idN && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.idP.getLayoutParams();
                        layoutParams2.topMargin = l.g(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.idP.setLayoutParams(layoutParams2);
                    }
                    bVar.ejx.setTag(sparseArray2);
                    bVar.hRn.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hRn.setOnLongClickListener(this.cnB);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.idL) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.ejx.setVisibility(8);
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
            if (this.idN) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.idP.getLayoutParams();
                layoutParams3.topMargin = l.g(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.idP.setLayoutParams(layoutParams3);
            }
            if (this.idN) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.idP.getLayoutParams();
                layoutParams22.topMargin = l.g(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.idP.setLayoutParams(layoutParams22);
            }
            bVar.ejx.setTag(sparseArray2);
            bVar.hRn.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hRn.setOnLongClickListener(this.cnB);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cqB;
        SpannableStringBuilder azh;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder azh2;
        if (postData != null && (cqB = postData.cqB()) != null) {
            ArrayList<TbRichTextData> ayZ = cqB.ayZ();
            if (!v.aa(ayZ)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = ayZ.get(ayZ.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.aD(postData.getTime());
                        if (ayZ.size() > 1) {
                            if ((ayZ.get(ayZ.size() + (-2)) != null ? ayZ.get(ayZ.size() - 2).getType() : -1) != type) {
                                str2 = aq.aD(postData.getTime());
                                azh2 = tbRichTextData2.azh();
                                if (cqB.hasAppendTime && azh2 != 0 && cqB.appendLength <= azh2.length()) {
                                    azh2.delete(azh2.length() - cqB.appendLength, azh2.length());
                                }
                                String oc = aq.oc(str2);
                                if (azh2 != null) {
                                    azh2.append((CharSequence) oc);
                                }
                                cqB.hasAppendTime = true;
                                cqB.appendLength = oc.length();
                                tbRichTextData = tbRichTextData2;
                                str = oc;
                            }
                        }
                        str2 = str3;
                        azh2 = tbRichTextData2.azh();
                        if (cqB.hasAppendTime) {
                            azh2.delete(azh2.length() - cqB.appendLength, azh2.length());
                        }
                        String oc2 = aq.oc(str2);
                        if (azh2 != null) {
                        }
                        cqB.hasAppendTime = true;
                        cqB.appendLength = oc2.length();
                        tbRichTextData = tbRichTextData2;
                        str = oc2;
                    } else if (cqB.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String aD = aq.aD(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.oc(aD);
                        tbRichTextData.k(str);
                        cqB.hasAppendTime = true;
                        cqB.appendLength = str.length();
                        ayZ.add(tbRichTextData);
                    }
                    SpannableStringBuilder azh3 = tbRichTextData.azh();
                    if (azh3 != null && str.length() <= azh3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        azh3.setSpan(absoluteSizeSpan, azh3.length() - str.length(), azh3.length(), 33);
                        azh3.setSpan(foregroundColorSpan, azh3.length() - str.length(), azh3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = ayZ.get(ayZ.size() - 1);
                if (cqB.hasAppendTime && tbRichTextData3 != null && (azh = tbRichTextData3.azh()) != null && cqB.appendLength <= azh.length()) {
                    azh.delete(azh.length() - cqB.appendLength, azh.length());
                }
                cqB.hasAppendTime = false;
                cqB.appendLength = 0;
            }
        }
    }

    public void CP(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
