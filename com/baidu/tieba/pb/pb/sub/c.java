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
    private bg cbg;
    protected Context mContext;
    protected ArrayList<PostData> aHF = null;
    protected View.OnClickListener hUt = null;
    protected int hUu = 0;
    protected boolean hUv = false;
    protected boolean hUw = false;
    protected boolean eGC = false;
    private boolean mIsFromCDN = true;
    private boolean hUx = false;
    private boolean crd = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener clk = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes4.dex */
    public static class b {
        public TextView edi;
        public TbRichTextView hIf;
        public View hUA;
        public LinearLayout hUz;
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
        this.cbg = bgVar;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hUt = onClickListener;
    }

    public void M(int i, boolean z) {
        this.hUu = i;
        this.hUv = z;
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
            if (postData.getType() == PostData.iYE) {
                view = bWs();
            } else {
                view = nG();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.iYE) {
            view = nG();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.iYE) {
            view = bWs();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.eGC && i + 1 >= getCount();
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
        public View cSY;
        public TextView hUy;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.cSY = view.findViewById(R.id.divider_line);
            this.hUy = (TextView) view.findViewById(R.id.center_reply_text);
            this.hUy.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.l(this.cSY, R.color.cp_cont_d);
                al.j(this.hUy, R.color.cp_cont_d);
                al.l(this.hUy, R.color.cp_bg_line_d);
                this.hUy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.S(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bWs() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nG() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.hUz = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.hUx) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hUz.getLayoutParams();
            layoutParams.topMargin = l.g(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
            bVar.hUz.setLayoutParams(layoutParams);
        }
        bVar.edi = (TextView) inflate.findViewById(R.id.manage_btn);
        bVar.hIf = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        bVar.hUA = inflate.findViewById(R.id.divide_bottom_view);
        bVar.hIf.getLayoutStrategy().setSupportNoImage();
        if (!this.hUx) {
            bVar.hIf.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            bVar.hIf.getLayoutStrategy().lw(0);
            bVar.hIf.getLayoutStrategy().lu(l.g(this.mContext, R.dimen.tbds20));
            bVar.hIf.getLayoutStrategy().lv(l.g(this.mContext, R.dimen.tbds14));
        }
        bVar.hIf.setSubPbPost(true);
        bVar.hIf.setTextColor(al.getColor(R.color.cp_cont_f));
        bVar.hIf.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.hIf.setTextCenter(true);
        bVar.hIf.setOnClickListener(this.mCommonClickListener);
        bVar.edi.setOnClickListener(this.hUt);
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
            if (!postData.iZs && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.adv() != null && aVar.AX(postData.adv().getUserId()));
            }
            if (z3) {
                al.l(bVar.rootView, R.color.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.cmv()) {
                bVar.hUA.setVisibility(0);
            } else {
                bVar.hUA.setVisibility(8);
            }
            bVar.hIf.setPadding(0, 0, 0, 0);
            if (postData.adv() != null) {
                String name_show = postData.adv().getName_show();
                String userId = postData.adv().getUserId();
                SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    bVar.rootView.setTag(sparseArray3);
                    bVar.hIf.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            bVar.hIf.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            bVar.hIf.setTextColor(al.getColor(R.color.cp_cont_f));
            a(postData, this.hUx);
            TbRichText cmw = postData.cmw();
            if (cmw != null) {
                bVar.hIf.setVoiceViewRes(R.layout.voice_play_btn_new);
                bVar.hIf.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cmw.isChanged = true;
                }
                bVar.hIf.setText(cmw);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.adv().getUserId();
            if (this.hUu != 0) {
                if (this.hUu != 1002 && this.hUu != 3) {
                    z8 = true;
                }
                if (this.hUu != 3) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.hUv) {
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
                    bVar.edi.setVisibility(8);
                    sparseArray = (SparseArray) bVar.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        bVar.rootView.setTag(sparseArray4);
                        bVar.hIf.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hUu));
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
                        if (this.cbg != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.adv() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.adv().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.adv().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.adv().getName_show());
                            }
                            if (this.cbg.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.cbg.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hUu));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.hUx && z2 && this.crd) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hUz.getLayoutParams();
                        layoutParams.topMargin = l.g(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.hUz.setLayoutParams(layoutParams);
                    }
                    if (this.hUx && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hUz.getLayoutParams();
                        layoutParams2.topMargin = l.g(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                        bVar.hUz.setLayoutParams(layoutParams2);
                    }
                    bVar.edi.setTag(sparseArray2);
                    bVar.hIf.setTag(sparseArray2);
                    bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    bVar.hIf.setOnLongClickListener(this.clk);
                }
            }
            boolean z12 = z9;
            z4 = z8;
            z5 = z12;
            if (this.hUv) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            bVar.edi.setVisibility(8);
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
            if (this.hUx) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.hUz.getLayoutParams();
                layoutParams3.topMargin = l.g(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.hUz.setLayoutParams(layoutParams3);
            }
            if (this.hUx) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.hUz.getLayoutParams();
                layoutParams22.topMargin = l.g(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.g(this.mContext, R.dimen.ds8);
                bVar.hUz.setLayoutParams(layoutParams22);
            }
            bVar.edi.setTag(sparseArray2);
            bVar.hIf.setTag(sparseArray2);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.hIf.setOnLongClickListener(this.clk);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText cmw;
        SpannableStringBuilder axG;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder axG2;
        if (postData != null && (cmw = postData.cmw()) != null) {
            ArrayList<TbRichTextData> axy = cmw.axy();
            if (!v.aa(axy)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = axy.get(axy.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.aC(postData.getTime());
                        if (axy.size() > 1) {
                            if ((axy.get(axy.size() + (-2)) != null ? axy.get(axy.size() - 2).getType() : -1) != type) {
                                str2 = ap.aC(postData.getTime());
                                axG2 = tbRichTextData2.axG();
                                if (cmw.hasAppendTime && axG2 != 0 && cmw.appendLength <= axG2.length()) {
                                    axG2.delete(axG2.length() - cmw.appendLength, axG2.length());
                                }
                                String nO = ap.nO(str2);
                                if (axG2 != null) {
                                    axG2.append((CharSequence) nO);
                                }
                                cmw.hasAppendTime = true;
                                cmw.appendLength = nO.length();
                                tbRichTextData = tbRichTextData2;
                                str = nO;
                            }
                        }
                        str2 = str3;
                        axG2 = tbRichTextData2.axG();
                        if (cmw.hasAppendTime) {
                            axG2.delete(axG2.length() - cmw.appendLength, axG2.length());
                        }
                        String nO2 = ap.nO(str2);
                        if (axG2 != null) {
                        }
                        cmw.hasAppendTime = true;
                        cmw.appendLength = nO2.length();
                        tbRichTextData = tbRichTextData2;
                        str = nO2;
                    } else if (cmw.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String aC = ap.aC(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.nO(aC);
                        tbRichTextData.append(str);
                        cmw.hasAppendTime = true;
                        cmw.appendLength = str.length();
                        axy.add(tbRichTextData);
                    }
                    SpannableStringBuilder axG3 = tbRichTextData.axG();
                    if (axG3 != null && str.length() <= axG3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_cont_d));
                        axG3.setSpan(absoluteSizeSpan, axG3.length() - str.length(), axG3.length(), 33);
                        axG3.setSpan(foregroundColorSpan, axG3.length() - str.length(), axG3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = axy.get(axy.size() - 1);
                if (cmw.hasAppendTime && tbRichTextData3 != null && (axG = tbRichTextData3.axG()) != null && cmw.appendLength <= axG.length()) {
                    axG.delete(axG.length() - cmw.appendLength, axG.length());
                }
                cmw.hasAppendTime = false;
                cmw.appendLength = 0;
            }
        }
    }

    public void BB(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
