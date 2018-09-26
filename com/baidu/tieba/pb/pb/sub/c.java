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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private bb bAn;
    protected Context mContext;
    protected ArrayList<PostData> anX = null;
    protected View.OnClickListener fSU = null;
    protected int fSV = 0;
    protected boolean fSW = false;
    protected boolean fSX = false;
    protected boolean cNB = false;
    private boolean mIsFromCDN = true;
    private boolean avY = false;
    private boolean aPR = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener aKx = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView cqD;
        public TbRichTextView fGR;
        public LinearLayout fSZ;
        public View fTa;
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

    public void aa(bb bbVar) {
        this.bAn = bbVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fSU = onClickListener;
    }

    public void B(int i, boolean z) {
        this.fSV = i;
        this.fSW = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX == null) {
            return 0;
        }
        return this.anX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX == null || i < 0 || i >= this.anX.size()) {
            return null;
        }
        return this.anX.get(i);
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
            if (postData.getType() == PostData.gVD) {
                view = bil();
            } else {
                view = ov();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gVD) {
            view = ov();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gVD) {
            view = bil();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(e.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cNB && i + 1 >= getCount();
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

    /* loaded from: classes2.dex */
    public static class a {
        public View bqy;
        public TextView fSY;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bqy = view.findViewById(e.g.divider_line);
            this.fSY = (TextView) view.findViewById(e.g.center_reply_text);
            this.fSY.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.bqy, e.d.cp_cont_d);
                al.h(this.fSY, e.d.cp_cont_d);
                al.j(this.fSY, e.d.cp_bg_line_d);
                this.fSY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.x(i, e.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bil() {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View ov() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fSZ = (LinearLayout) inflate.findViewById(e.g.sub_pb_item_columnlayout);
        if (this.avY) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fSZ.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, e.C0141e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0141e.ds8);
            bVar.fSZ.setLayoutParams(layoutParams);
        }
        bVar.cqD = (TextView) inflate.findViewById(e.g.manage_btn);
        bVar.fGR = (TbRichTextView) inflate.findViewById(e.g.new_sub_pb_list_richText);
        bVar.fTa = inflate.findViewById(e.g.divide_bottom_view);
        bVar.fGR.getLayoutStrategy().setSupportNoImage();
        if (!this.avY) {
            bVar.fGR.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds12), 1.0f);
            bVar.fGR.getLayoutStrategy().gi(0);
            bVar.fGR.getLayoutStrategy().gg(l.h(this.mContext, e.C0141e.tbds20));
            bVar.fGR.getLayoutStrategy().gh(l.h(this.mContext, e.C0141e.tbds3));
        }
        bVar.fGR.setSubPbPost(true);
        bVar.fGR.setTextColor(al.getColor(e.d.cp_cont_f));
        bVar.fGR.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fGR.setTextCenter(true);
        bVar.fGR.setOnClickListener(this.mCommonClickListener);
        bVar.cqD.setOnClickListener(this.fSU);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(e.g.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (bVar != null && postData != null) {
            if (!postData.gWp && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.b(aVar.getPageContext(), postData.wm() != null && aVar.rJ(postData.wm().getUserId()));
            }
            if (z3) {
                al.j(bVar.rootView, e.d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.byN()) {
                bVar.fTa.setVisibility(0);
            } else {
                bVar.fTa.setVisibility(8);
            }
            bVar.fGR.setPadding(0, 0, 0, 0);
            if (postData.wm() != null) {
                String name_show = postData.wm().getName_show();
                String userId = postData.wm().getUserId();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                    bVar.fGR.setTag(sparseArray2);
                }
                sparseArray2.put(e.g.tag_photo_username, name_show);
                sparseArray2.put(e.g.tag_photo_userid, userId);
                sparseArray2.put(e.g.tag_clip_board, postData);
                sparseArray2.put(e.g.tag_is_subpb, true);
            }
            bVar.fGR.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fGR.setTextColor(al.getColor(e.d.cp_cont_f));
            a(postData, this.avY);
            TbRichText byO = postData.byO();
            if (byO != null) {
                bVar.fGR.setVoiceViewRes(e.h.voice_play_btn_new);
                bVar.fGR.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    byO.isChanged = true;
                }
                bVar.fGR.setText(byO);
            }
            String userId2 = postData.wm().getUserId();
            if (this.fSV != 0) {
                boolean z9 = this.fSV != 1002;
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = true;
                    z5 = false;
                } else {
                    z5 = z9;
                    z4 = true;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (!this.fSW) {
                z6 = false;
            } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                z4 = true;
            } else {
                z6 = false;
                z4 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z7 = false;
                z8 = z4;
            } else {
                z7 = true;
                z8 = true;
            }
            bVar.cqD.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bVar.rootView.setTag(sparseArray4);
                bVar.fGR.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(e.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fSV));
                if (postData.wm() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.wm().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.wm().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.wm().getPortrait());
                }
                sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(e.g.tag_clip_board, postData);
            if (z6) {
                if (this.bAn != null) {
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.wm() != null) {
                        sparseArray.put(e.g.tag_user_mute_mute_userid, postData.wm().getUserId());
                        sparseArray.put(e.g.tag_user_mute_mute_username, postData.wm().getUserName());
                        sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.wm().getName_show());
                    }
                    if (this.bAn.getId() != null) {
                        sparseArray.put(e.g.tag_user_mute_thread_id, this.bAn.getId());
                    }
                    sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fSV));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(e.g.tag_del_post_type, 2);
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            if (this.avY && z2 && this.aPR) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fSZ.getLayoutParams();
                layoutParams.topMargin = l.h(this.mContext, e.C0141e.ds32);
                layoutParams.bottomMargin = l.h(this.mContext, e.C0141e.ds8);
                bVar.fSZ.setLayoutParams(layoutParams);
            }
            if (this.avY && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fSZ.getLayoutParams();
                layoutParams2.topMargin = l.h(this.mContext, e.C0141e.ds8);
                layoutParams2.bottomMargin = l.h(this.mContext, e.C0141e.ds8);
                bVar.fSZ.setLayoutParams(layoutParams2);
            }
            bVar.cqD.setTag(sparseArray);
            bVar.fGR.setTag(sparseArray);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.fGR.setOnLongClickListener(this.aKx);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText byO;
        SpannableStringBuilder OW;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder OW2;
        if (postData != null && (byO = postData.byO()) != null) {
            ArrayList<TbRichTextData> OP = byO.OP();
            if (!v.z(OP)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = OP.get(OP.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ao.A(postData.getTime());
                        if (OP.size() > 1) {
                            if ((OP.get(OP.size() + (-2)) != null ? OP.get(OP.size() - 2).getType() : -1) != type) {
                                str2 = ao.A(postData.getTime());
                                OW2 = tbRichTextData2.OW();
                                if (byO.hasAppendTime && OW2 != 0 && byO.appendLength <= OW2.length()) {
                                    OW2.delete(OW2.length() - byO.appendLength, OW2.length());
                                }
                                String fa = ao.fa(str2);
                                if (OW2 != null) {
                                    OW2.append((CharSequence) fa);
                                }
                                byO.hasAppendTime = true;
                                byO.appendLength = fa.length();
                                tbRichTextData = tbRichTextData2;
                                str = fa;
                            }
                        }
                        str2 = str3;
                        OW2 = tbRichTextData2.OW();
                        if (byO.hasAppendTime) {
                            OW2.delete(OW2.length() - byO.appendLength, OW2.length());
                        }
                        String fa2 = ao.fa(str2);
                        if (OW2 != null) {
                        }
                        byO.hasAppendTime = true;
                        byO.appendLength = fa2.length();
                        tbRichTextData = tbRichTextData2;
                        str = fa2;
                    } else if (byO.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String A = ao.A(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ao.fa(A);
                        tbRichTextData.append(str);
                        byO.hasAppendTime = true;
                        byO.appendLength = str.length();
                        OP.add(tbRichTextData);
                    }
                    SpannableStringBuilder OW3 = tbRichTextData.OW();
                    if (OW3 != null && str.length() <= OW3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_d));
                        OW3.setSpan(absoluteSizeSpan, OW3.length() - str.length(), OW3.length(), 33);
                        OW3.setSpan(foregroundColorSpan, OW3.length() - str.length(), OW3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = OP.get(OP.size() - 1);
                if (byO.hasAppendTime && tbRichTextData3 != null && (OW = tbRichTextData3.OW()) != null && byO.appendLength <= OW.length()) {
                    OW.delete(OW.length() - byO.appendLength, OW.length());
                }
                byO.hasAppendTime = false;
                byO.appendLength = 0;
            }
        }
    }

    public void sl(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
