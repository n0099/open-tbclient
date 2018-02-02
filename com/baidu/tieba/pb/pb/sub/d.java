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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private bd bXU;
    protected Context mContext;
    protected ArrayList<PostData> aQJ = null;
    protected View.OnClickListener fXn = null;
    protected int fXo = 0;
    protected boolean fXp = false;
    protected boolean fXq = false;
    protected boolean ddk = false;
    private boolean mIsFromCDN = true;
    private boolean fXr = false;
    private boolean bqG = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void th(int i) {
        this.mSelectedPosition = i;
    }

    public int qB(String str) {
        if (this.aQJ == null) {
            return -1;
        }
        int size = this.aQJ.size();
        for (int i = 0; i < size; i++) {
            if (this.aQJ.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void Q(bd bdVar) {
        this.bXU = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aQJ = new ArrayList<>();
        } else {
            this.aQJ = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.fXn = onClickListener;
    }

    public void J(int i, boolean z) {
        this.fXo = i;
        this.fXp = z;
    }

    public void setHasMoreData(boolean z) {
        this.ddk = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQJ == null) {
            return 0;
        }
        return this.aQJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aQJ == null || i < 0 || i >= this.aQJ.size()) {
            return null;
        }
        return this.aQJ.get(i);
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
            if (postData.getType() == PostData.gYF) {
                view = bfn();
            } else {
                view = sv();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gYF) {
            view = sv();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gYF) {
            view = bfn();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.ddk && i + 1 >= getCount();
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
    public class b {
        public TextView cEg;
        public TbRichTextView fFP;
        public LinearLayout fXu;
        public View fXv;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bOs;
        public TextView fXs;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bOs = view.findViewById(d.g.divider_line);
            this.fXs = (TextView) view.findViewById(d.g.center_reply_text);
            this.fXs.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.t(this.bOs, d.C0108d.cp_cont_d);
                aj.r(this.fXs, d.C0108d.cp_cont_d);
                aj.t(this.fXs, d.C0108d.cp_bg_line_d);
                this.fXs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.au(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bfn() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View sv() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fXu = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fXr) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fXu.getLayoutParams();
            layoutParams.topMargin = l.s(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.s(this.mContext, d.e.ds8);
            bVar.fXu.setLayoutParams(layoutParams);
        }
        bVar.cEg = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fFP = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fXv = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fFP.getLayoutStrategy().QC();
        if (!this.fXr) {
            bVar.fFP.getLayoutStrategy().setLineSpacing(l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fFP.getLayoutStrategy().iV(0);
            bVar.fFP.getLayoutStrategy().iT(l.s(this.mContext, d.e.tbds20));
            bVar.fFP.getLayoutStrategy().iU(l.s(this.mContext, d.e.tbds3));
        }
        bVar.fFP.setSubPbPost(true);
        bVar.fFP.setTextColor(aj.getColor(d.C0108d.cp_cont_f));
        bVar.fFP.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fFP.setTextCenter(true);
        bVar.cEg.setOnClickListener(this.fXn);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (bVar != null && postData != null) {
            if (z3) {
                aj.t(bVar.rootView, d.C0108d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bvK()) {
                bVar.fXv.setVisibility(0);
            } else {
                bVar.fXv.setVisibility(8);
            }
            bVar.fFP.setPadding(0, 0, 0, 0);
            if (postData.yT() != null) {
                String name_show = postData.yT().getName_show();
                String userId = postData.yT().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_photo_username, name_show);
                sparseArray.put(d.g.tag_photo_userid, userId);
                sparseArray.put(d.g.tag_clip_board, postData);
                sparseArray.put(d.g.tag_is_subpb, true);
            }
            bVar.fFP.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            bVar.fFP.setTextColor(aj.getColor(d.C0108d.cp_cont_f));
            a(postData, this.fXr);
            TbRichText bvM = postData.bvM();
            if (bvM != null) {
                bVar.fFP.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fFP.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bvM.isChanged = true;
                }
                bVar.fFP.setText(bvM);
            }
            String userId2 = postData.yT().getUserId();
            if (this.fXo != 0) {
                boolean z9 = this.fXo != 1002;
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
            if (!this.fXp) {
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
            bVar.cEg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cEg.setText("");
            bVar.cEg.setContentDescription("");
            aj.r(bVar.cEg, d.C0108d.cp_link_tip_c);
            if (z5) {
                bVar.cEg.setVisibility(0);
                bVar.cEg.setText(this.mContext.getString(d.j.manage));
                bVar.cEg.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.cEg.setVisibility(0);
                bVar.cEg.setText(this.mContext.getString(d.j.mute));
                bVar.cEg.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.cEg.setVisibility(0);
                if (this.fXo == 1002 && !z7) {
                    bVar.cEg.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.cEg.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.cEg.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cEg.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cEg.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fXo));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.yT().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bXU != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yT() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.yT().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.yT().getUserName());
                    }
                    if (this.bXU.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bXU.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fXo));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fXr && z2 && this.bqG) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fXu.getLayoutParams();
                layoutParams.topMargin = l.s(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.s(this.mContext, d.e.ds8);
                bVar.fXu.setLayoutParams(layoutParams);
            }
            if (this.fXr && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fXu.getLayoutParams();
                layoutParams2.topMargin = l.s(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.s(this.mContext, d.e.ds8);
                bVar.fXu.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bvM;
        SpannableStringBuilder QK;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder QK2;
        if (postData != null && (bvM = postData.bvM()) != null) {
            ArrayList<TbRichTextData> QD = bvM.QD();
            if (!v.E(QD)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = QD.get(QD.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.z(postData.getTime());
                        if (QD.size() > 1) {
                            if ((QD.get(QD.size() + (-2)) != null ? QD.get(QD.size() - 2).getType() : -1) != type) {
                                str2 = am.z(postData.getTime());
                                QK2 = tbRichTextData2.QK();
                                if (bvM.hasAppendTime && QK2 != 0 && bvM.appendLength <= QK2.length()) {
                                    QK2.delete(QK2.length() - bvM.appendLength, QK2.length());
                                }
                                String ef = am.ef(str2);
                                if (QK2 != null) {
                                    QK2.append((CharSequence) ef);
                                }
                                bvM.hasAppendTime = true;
                                bvM.appendLength = ef.length();
                                tbRichTextData = tbRichTextData2;
                                str = ef;
                            }
                        }
                        str2 = str3;
                        QK2 = tbRichTextData2.QK();
                        if (bvM.hasAppendTime) {
                            QK2.delete(QK2.length() - bvM.appendLength, QK2.length());
                        }
                        String ef2 = am.ef(str2);
                        if (QK2 != null) {
                        }
                        bvM.hasAppendTime = true;
                        bvM.appendLength = ef2.length();
                        tbRichTextData = tbRichTextData2;
                        str = ef2;
                    } else if (bvM.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String z2 = am.z(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.ef(z2);
                        tbRichTextData.append(str);
                        bvM.hasAppendTime = true;
                        bvM.appendLength = str.length();
                        QD.add(tbRichTextData);
                    }
                    SpannableStringBuilder QK3 = tbRichTextData.QK();
                    if (QK3 != null && str.length() <= QK3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0108d.cp_cont_d));
                        QK3.setSpan(absoluteSizeSpan, QK3.length() - str.length(), QK3.length(), 33);
                        QK3.setSpan(foregroundColorSpan, QK3.length() - str.length(), QK3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = QD.get(QD.size() - 1);
                if (bvM.hasAppendTime && tbRichTextData3 != null && (QK = tbRichTextData3.QK()) != null && bvM.appendLength <= QK.length()) {
                    QK.delete(QK.length() - bvM.appendLength, QK.length());
                }
                bvM.hasAppendTime = false;
                bvM.appendLength = 0;
            }
        }
    }

    public void kX(boolean z) {
        this.fXr = z;
    }

    public void kY(boolean z) {
        this.bqG = z;
    }

    public void qC(String str) {
        this.mPostId = str;
    }
}
