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
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private bb bIV;
    protected Context mContext;
    protected ArrayList<PostData> mData = null;
    protected View.OnClickListener gau = null;
    protected int gav = 0;
    protected boolean gaw = false;
    protected boolean gax = false;
    protected boolean cVS = false;
    private boolean mIsFromCDN = true;
    private boolean aAJ = false;
    private boolean aUs = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener aOZ = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes6.dex */
    public static class b {
        public TextView czg;
        public TbRichTextView fOs;
        public View gaA;
        public LinearLayout gaz;
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
        this.bIV = bbVar;
    }

    public void K(View.OnClickListener onClickListener) {
        this.gau = onClickListener;
    }

    public void B(int i, boolean z) {
        this.gav = i;
        this.gaw = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
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
            if (postData.getType() == PostData.hcY) {
                view = blx();
            } else {
                view = oG();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.hcY) {
            view = oG();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.hcY) {
            view = blx();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(e.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cVS && i + 1 >= getCount();
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

    /* loaded from: classes6.dex */
    public static class a {
        public View buH;
        public TextView gay;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.buH = view.findViewById(e.g.divider_line);
            this.gay = (TextView) view.findViewById(e.g.center_reply_text);
            this.gay.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.buH, e.d.cp_cont_d);
                al.h(this.gay, e.d.cp_cont_d);
                al.j(this.gay, e.d.cp_bg_line_d);
                this.gay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.x(i, e.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View blx() {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View oG() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.gaz = (LinearLayout) inflate.findViewById(e.g.sub_pb_item_columnlayout);
        if (this.aAJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gaz.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, e.C0175e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0175e.ds8);
            bVar.gaz.setLayoutParams(layoutParams);
        }
        bVar.czg = (TextView) inflate.findViewById(e.g.manage_btn);
        bVar.fOs = (TbRichTextView) inflate.findViewById(e.g.new_sub_pb_list_richText);
        bVar.gaA = inflate.findViewById(e.g.divide_bottom_view);
        bVar.fOs.getLayoutStrategy().setSupportNoImage();
        if (!this.aAJ) {
            bVar.fOs.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds12), 1.0f);
            bVar.fOs.getLayoutStrategy().gq(0);
            bVar.fOs.getLayoutStrategy().go(l.h(this.mContext, e.C0175e.tbds20));
            bVar.fOs.getLayoutStrategy().gp(l.h(this.mContext, e.C0175e.tbds3));
        }
        bVar.fOs.setSubPbPost(true);
        bVar.fOs.setTextColor(al.getColor(e.d.cp_cont_f));
        bVar.fOs.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fOs.setTextCenter(true);
        bVar.fOs.setOnClickListener(this.mCommonClickListener);
        bVar.czg.setOnClickListener(this.gau);
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
            if (!postData.hdK && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.yv() != null && aVar.sj(postData.yv().getUserId()));
            }
            if (z3) {
                al.j(bVar.rootView, e.d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bCc()) {
                bVar.gaA.setVisibility(0);
            } else {
                bVar.gaA.setVisibility(8);
            }
            bVar.fOs.setPadding(0, 0, 0, 0);
            if (postData.yv() != null) {
                String name_show = postData.yv().getName_show();
                String userId = postData.yv().getUserId();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                    bVar.fOs.setTag(sparseArray2);
                }
                sparseArray2.put(e.g.tag_photo_username, name_show);
                sparseArray2.put(e.g.tag_photo_userid, userId);
                sparseArray2.put(e.g.tag_clip_board, postData);
                sparseArray2.put(e.g.tag_is_subpb, true);
            }
            bVar.fOs.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fOs.setTextColor(al.getColor(e.d.cp_cont_f));
            a(postData, this.aAJ);
            TbRichText bCd = postData.bCd();
            if (bCd != null) {
                bVar.fOs.setVoiceViewRes(e.h.voice_play_btn_new);
                bVar.fOs.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bCd.isChanged = true;
                }
                bVar.fOs.setText(bCd);
            }
            String userId2 = postData.yv().getUserId();
            if (this.gav != 0) {
                boolean z9 = this.gav != 1002;
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
            if (!this.gaw) {
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
            bVar.czg.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bVar.rootView.setTag(sparseArray4);
                bVar.fOs.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(e.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.gav));
                if (postData.yv() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.yv().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.yv().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.yv().getPortrait());
                }
                sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(e.g.tag_clip_board, postData);
            if (z6) {
                if (this.bIV != null) {
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yv() != null) {
                        sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yv().getUserId());
                        sparseArray.put(e.g.tag_user_mute_mute_username, postData.yv().getUserName());
                        sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yv().getName_show());
                    }
                    if (this.bIV.getId() != null) {
                        sparseArray.put(e.g.tag_user_mute_thread_id, this.bIV.getId());
                    }
                    sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.gav));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(e.g.tag_del_post_type, 2);
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            if (this.aAJ && z2 && this.aUs) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gaz.getLayoutParams();
                layoutParams.topMargin = l.h(this.mContext, e.C0175e.ds32);
                layoutParams.bottomMargin = l.h(this.mContext, e.C0175e.ds8);
                bVar.gaz.setLayoutParams(layoutParams);
            }
            if (this.aAJ && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gaz.getLayoutParams();
                layoutParams2.topMargin = l.h(this.mContext, e.C0175e.ds8);
                layoutParams2.bottomMargin = l.h(this.mContext, e.C0175e.ds8);
                bVar.gaz.setLayoutParams(layoutParams2);
            }
            bVar.czg.setTag(sparseArray);
            bVar.fOs.setTag(sparseArray);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.fOs.setOnLongClickListener(this.aOZ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bCd;
        SpannableStringBuilder QR;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder QR2;
        if (postData != null && (bCd = postData.bCd()) != null) {
            ArrayList<TbRichTextData> QK = bCd.QK();
            if (!v.J(QK)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = QK.get(QK.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ao.C(postData.getTime());
                        if (QK.size() > 1) {
                            if ((QK.get(QK.size() + (-2)) != null ? QK.get(QK.size() - 2).getType() : -1) != type) {
                                str2 = ao.C(postData.getTime());
                                QR2 = tbRichTextData2.QR();
                                if (bCd.hasAppendTime && QR2 != 0 && bCd.appendLength <= QR2.length()) {
                                    QR2.delete(QR2.length() - bCd.appendLength, QR2.length());
                                }
                                String fo = ao.fo(str2);
                                if (QR2 != null) {
                                    QR2.append((CharSequence) fo);
                                }
                                bCd.hasAppendTime = true;
                                bCd.appendLength = fo.length();
                                tbRichTextData = tbRichTextData2;
                                str = fo;
                            }
                        }
                        str2 = str3;
                        QR2 = tbRichTextData2.QR();
                        if (bCd.hasAppendTime) {
                            QR2.delete(QR2.length() - bCd.appendLength, QR2.length());
                        }
                        String fo2 = ao.fo(str2);
                        if (QR2 != null) {
                        }
                        bCd.hasAppendTime = true;
                        bCd.appendLength = fo2.length();
                        tbRichTextData = tbRichTextData2;
                        str = fo2;
                    } else if (bCd.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String C = ao.C(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ao.fo(C);
                        tbRichTextData.append(str);
                        bCd.hasAppendTime = true;
                        bCd.appendLength = str.length();
                        QK.add(tbRichTextData);
                    }
                    SpannableStringBuilder QR3 = tbRichTextData.QR();
                    if (QR3 != null && str.length() <= QR3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_d));
                        QR3.setSpan(absoluteSizeSpan, QR3.length() - str.length(), QR3.length(), 33);
                        QR3.setSpan(foregroundColorSpan, QR3.length() - str.length(), QR3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = QK.get(QK.size() - 1);
                if (bCd.hasAppendTime && tbRichTextData3 != null && (QR = tbRichTextData3.QR()) != null && bCd.appendLength <= QR.length()) {
                    QR.delete(QR.length() - bCd.appendLength, QR.length());
                }
                bCd.hasAppendTime = false;
                bCd.appendLength = 0;
            }
        }
    }

    public void sM(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
