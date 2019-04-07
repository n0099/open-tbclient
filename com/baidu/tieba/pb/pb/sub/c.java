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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private bg bTn;
    protected Context mContext;
    protected ArrayList<PostData> aFL = null;
    protected View.OnClickListener hCs = null;
    protected int hCt = 0;
    protected boolean hCu = false;
    protected boolean hCv = false;
    protected boolean eqU = false;
    private boolean mIsFromCDN = true;
    private boolean hCw = false;
    private boolean ciU = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener cdf = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView dSI;
        public LinearLayout hCy;
        public View hCz;
        public TbRichTextView hqC;
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
        this.bTn = bgVar;
    }

    public void M(View.OnClickListener onClickListener) {
        this.hCs = onClickListener;
    }

    public void H(int i, boolean z) {
        this.hCt = i;
        this.hCu = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFL == null) {
            return 0;
        }
        return this.aFL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL == null || i < 0 || i >= this.aFL.size()) {
            return null;
        }
        return this.aFL.get(i);
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
            if (postData.getType() == PostData.iFP) {
                view = bOz();
            } else {
                view = oM();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.iFP) {
            view = oM();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.iFP) {
            view = bOz();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.eqU && i + 1 >= getCount();
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
        public View cKM;
        public TextView hCx;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cKM = view.findViewById(d.g.divider_line);
            this.hCx = (TextView) view.findViewById(d.g.center_reply_text);
            this.hCx.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.l(this.cKM, d.C0277d.cp_cont_d);
                al.j(this.hCx, d.C0277d.cp_cont_d);
                al.l(this.hCx, d.C0277d.cp_bg_line_d);
                this.hCx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.T(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bOz() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View oM() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.hCy = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.hCw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hCy.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, d.e.ds8);
            bVar.hCy.setLayoutParams(layoutParams);
        }
        bVar.dSI = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.hqC = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.hCz = inflate.findViewById(d.g.divide_bottom_view);
        bVar.hqC.getLayoutStrategy().setSupportNoImage();
        if (!this.hCw) {
            bVar.hqC.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hqC.getLayoutStrategy().kH(0);
            bVar.hqC.getLayoutStrategy().kF(l.h(this.mContext, d.e.tbds20));
            bVar.hqC.getLayoutStrategy().kG(l.h(this.mContext, d.e.tbds14));
        }
        bVar.hqC.setSubPbPost(true);
        bVar.hqC.setTextColor(al.getColor(d.C0277d.cp_cont_f));
        bVar.hqC.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hqC.setTextCenter(true);
        bVar.hqC.setOnClickListener(this.mCommonClickListener);
        bVar.dSI.setOnClickListener(this.hCs);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e1  */
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
            if (!postData.iGC && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.YO() != null && aVar.zH(postData.YO().getUserId()));
            }
            if (z3) {
                al.l(bVar.rootView, d.C0277d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.ceq()) {
                bVar.hCz.setVisibility(0);
            } else {
                bVar.hCz.setVisibility(8);
            }
            bVar.hqC.setPadding(0, 0, 0, 0);
            if (postData.YO() != null) {
                String name_show = postData.YO().getName_show();
                String userId = postData.YO().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hqC.setTag(sparseArray3);
                }
                sparseArray3.put(d.g.tag_photo_username, name_show);
                sparseArray3.put(d.g.tag_photo_userid, userId);
                sparseArray3.put(d.g.tag_clip_board, postData);
                sparseArray3.put(d.g.tag_is_subpb, true);
            }
            bVar.hqC.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            bVar.hqC.setTextColor(al.getColor(d.C0277d.cp_cont_f));
            a(postData, this.hCw);
            TbRichText cer = postData.cer();
            if (cer != null) {
                bVar.hqC.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.hqC.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cer.isChanged = true;
                }
                bVar.hqC.setText(cer);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.YO().getUserId();
            if (this.hCt != 0) {
                if (this.hCt != 1002 && this.hCt != 3) {
                    z8 = true;
                }
                if (this.hCt != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.hCu) {
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
                    bVar.dSI.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hqC.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hCt));
                        if (postData.YO() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.YO().getUserName());
                            sparseArray2.put(d.g.tag_forbid_user_name_show, postData.YO().getName_show());
                            sparseArray2.put(d.g.tag_forbid_user_portrait, postData.YO().getPortrait());
                        }
                        sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.g.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(d.g.tag_clip_board, postData);
                    if (!z6) {
                        if (this.bTn != null) {
                            sparseArray2.put(d.g.tag_user_mute_visible, true);
                            sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.YO() != null) {
                                sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.YO().getUserId());
                                sparseArray2.put(d.g.tag_user_mute_mute_username, postData.YO().getUserName());
                                sparseArray2.put(d.g.tag_user_mute_mute_nameshow, postData.YO().getName_show());
                            }
                            if (this.bTn.getId() != null) {
                                sparseArray2.put(d.g.tag_user_mute_thread_id, this.bTn.getId());
                            }
                            sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(d.g.tag_should_delete_visible, true);
                        sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hCt));
                        sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(d.g.tag_del_post_type, 2);
                        sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.g.tag_should_delete_visible, false);
                    }
                    if (this.hCw && z2 && this.ciU) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hCy.getLayoutParams();
                        layoutParams.topMargin = l.h(this.mContext, d.e.ds32);
                        layoutParams.bottomMargin = l.h(this.mContext, d.e.ds8);
                        bVar.hCy.setLayoutParams(layoutParams);
                    }
                    if (this.hCw && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hCy.getLayoutParams();
                        layoutParams2.topMargin = l.h(this.mContext, d.e.ds8);
                        layoutParams2.bottomMargin = l.h(this.mContext, d.e.ds8);
                        bVar.hCy.setLayoutParams(layoutParams2);
                    }
                    bVar.dSI.setTag(sparseArray2);
                    bVar.hqC.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hqC.setOnLongClickListener(this.cdf);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.hCu) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.dSI.setVisibility(8);
            sparseArray = (SparseArray) bVar.rootView.getTag();
            if (sparseArray != null) {
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (!z4) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            sparseArray2.put(d.g.tag_clip_board, postData);
            if (!z6) {
            }
            if (!z7) {
            }
            if (this.hCw) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.hCy.getLayoutParams();
                layoutParams3.topMargin = l.h(this.mContext, d.e.ds32);
                layoutParams3.bottomMargin = l.h(this.mContext, d.e.ds8);
                bVar.hCy.setLayoutParams(layoutParams3);
            }
            if (this.hCw) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.hCy.getLayoutParams();
                layoutParams22.topMargin = l.h(this.mContext, d.e.ds8);
                layoutParams22.bottomMargin = l.h(this.mContext, d.e.ds8);
                bVar.hCy.setLayoutParams(layoutParams22);
            }
            bVar.dSI.setTag(sparseArray2);
            bVar.hqC.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hqC.setOnLongClickListener(this.cdf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cer;
        SpannableStringBuilder asB;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder asB2;
        if (postData != null && (cer = postData.cer()) != null) {
            ArrayList<TbRichTextData> ast = cer.ast();
            if (!v.T(ast)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = ast.get(ast.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.ao(postData.getTime());
                        if (ast.size() > 1) {
                            if ((ast.get(ast.size() + (-2)) != null ? ast.get(ast.size() - 2).getType() : -1) != type) {
                                str2 = ap.ao(postData.getTime());
                                asB2 = tbRichTextData2.asB();
                                if (cer.hasAppendTime && asB2 != 0 && cer.appendLength <= asB2.length()) {
                                    asB2.delete(asB2.length() - cer.appendLength, asB2.length());
                                }
                                String mG = ap.mG(str2);
                                if (asB2 != null) {
                                    asB2.append((CharSequence) mG);
                                }
                                cer.hasAppendTime = true;
                                cer.appendLength = mG.length();
                                tbRichTextData = tbRichTextData2;
                                str = mG;
                            }
                        }
                        str2 = str3;
                        asB2 = tbRichTextData2.asB();
                        if (cer.hasAppendTime) {
                            asB2.delete(asB2.length() - cer.appendLength, asB2.length());
                        }
                        String mG2 = ap.mG(str2);
                        if (asB2 != null) {
                        }
                        cer.hasAppendTime = true;
                        cer.appendLength = mG2.length();
                        tbRichTextData = tbRichTextData2;
                        str = mG2;
                    } else if (cer.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String ao = ap.ao(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.mG(ao);
                        tbRichTextData.append(str);
                        cer.hasAppendTime = true;
                        cer.appendLength = str.length();
                        ast.add(tbRichTextData);
                    }
                    SpannableStringBuilder asB3 = tbRichTextData.asB();
                    if (asB3 != null && str.length() <= asB3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_d));
                        asB3.setSpan(absoluteSizeSpan, asB3.length() - str.length(), asB3.length(), 33);
                        asB3.setSpan(foregroundColorSpan, asB3.length() - str.length(), asB3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = ast.get(ast.size() - 1);
                if (cer.hasAppendTime && tbRichTextData3 != null && (asB = tbRichTextData3.asB()) != null && cer.appendLength <= asB.length()) {
                    asB.delete(asB.length() - cer.appendLength, asB.length());
                }
                cer.hasAppendTime = false;
                cer.appendLength = 0;
            }
        }
    }

    public void Al(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdf = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
