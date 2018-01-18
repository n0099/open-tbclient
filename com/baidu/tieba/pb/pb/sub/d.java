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
    private bd bXM;
    protected Context mContext;
    protected ArrayList<PostData> aQG = null;
    protected View.OnClickListener fWS = null;
    protected int fWT = 0;
    protected boolean fWU = false;
    protected boolean fWV = false;
    protected boolean dcP = false;
    private boolean mIsFromCDN = true;
    private boolean fWW = false;
    private boolean bqx = false;
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

    public int qt(String str) {
        if (this.aQG == null) {
            return -1;
        }
        int size = this.aQG.size();
        for (int i = 0; i < size; i++) {
            if (this.aQG.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void Q(bd bdVar) {
        this.bXM = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aQG = new ArrayList<>();
        } else {
            this.aQG = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.fWS = onClickListener;
    }

    public void J(int i, boolean z) {
        this.fWT = i;
        this.fWU = z;
    }

    public void setHasMoreData(boolean z) {
        this.dcP = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQG == null) {
            return 0;
        }
        return this.aQG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aQG == null || i < 0 || i >= this.aQG.size()) {
            return null;
        }
        return this.aQG.get(i);
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
            if (postData.getType() == PostData.gYl) {
                view = bfi();
            } else {
                view = su();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gYl) {
            view = su();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gYl) {
            view = bfi();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.dcP && i + 1 >= getCount();
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
        public TextView cDT;
        public TbRichTextView fFu;
        public LinearLayout fWZ;
        public View fXa;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bOk;
        public TextView fWX;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bOk = view.findViewById(d.g.divider_line);
            this.fWX = (TextView) view.findViewById(d.g.center_reply_text);
            this.fWX.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.t(this.bOk, d.C0107d.cp_cont_d);
                aj.r(this.fWX, d.C0107d.cp_cont_d);
                aj.t(this.fWX, d.C0107d.cp_bg_line_d);
                this.fWX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.au(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bfi() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View su() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fWZ = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fWW) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fWZ.getLayoutParams();
            layoutParams.topMargin = l.s(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.s(this.mContext, d.e.ds8);
            bVar.fWZ.setLayoutParams(layoutParams);
        }
        bVar.cDT = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fFu = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fXa = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fFu.getLayoutStrategy().QA();
        if (!this.fWW) {
            bVar.fFu.getLayoutStrategy().setLineSpacing(l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fFu.getLayoutStrategy().iV(0);
            bVar.fFu.getLayoutStrategy().iT(l.s(this.mContext, d.e.tbds20));
            bVar.fFu.getLayoutStrategy().iU(l.s(this.mContext, d.e.tbds3));
        }
        bVar.fFu.setSubPbPost(true);
        bVar.fFu.setTextColor(aj.getColor(d.C0107d.cp_cont_f));
        bVar.fFu.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fFu.setTextCenter(true);
        bVar.cDT.setOnClickListener(this.fWS);
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
                aj.t(bVar.rootView, d.C0107d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bvI()) {
                bVar.fXa.setVisibility(0);
            } else {
                bVar.fXa.setVisibility(8);
            }
            bVar.fFu.setPadding(0, 0, 0, 0);
            if (postData.yS() != null) {
                String name_show = postData.yS().getName_show();
                String userId = postData.yS().getUserId();
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
            bVar.fFu.setLinkTextColor(aj.getColor(d.C0107d.cp_link_tip_c));
            bVar.fFu.setTextColor(aj.getColor(d.C0107d.cp_cont_f));
            a(postData, this.fWW);
            TbRichText bvK = postData.bvK();
            if (bvK != null) {
                bVar.fFu.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fFu.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bvK.isChanged = true;
                }
                bVar.fFu.setText(bvK);
            }
            String userId2 = postData.yS().getUserId();
            if (this.fWT != 0) {
                boolean z9 = this.fWT != 1002;
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
            if (!this.fWU) {
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
            bVar.cDT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cDT.setText("");
            bVar.cDT.setContentDescription("");
            aj.r(bVar.cDT, d.C0107d.cp_link_tip_c);
            if (z5) {
                bVar.cDT.setVisibility(0);
                bVar.cDT.setText(this.mContext.getString(d.j.manage));
                bVar.cDT.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.cDT.setVisibility(0);
                bVar.cDT.setText(this.mContext.getString(d.j.mute));
                bVar.cDT.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.cDT.setVisibility(0);
                if (this.fWT == 1002 && !z7) {
                    bVar.cDT.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.cDT.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.cDT.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cDT.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cDT.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fWT));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.yS().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bXM != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yS() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.yS().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.yS().getUserName());
                    }
                    if (this.bXM.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bXM.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fWT));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fWW && z2 && this.bqx) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fWZ.getLayoutParams();
                layoutParams.topMargin = l.s(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.s(this.mContext, d.e.ds8);
                bVar.fWZ.setLayoutParams(layoutParams);
            }
            if (this.fWW && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fWZ.getLayoutParams();
                layoutParams2.topMargin = l.s(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.s(this.mContext, d.e.ds8);
                bVar.fWZ.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bvK;
        SpannableStringBuilder QI;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder QI2;
        if (postData != null && (bvK = postData.bvK()) != null) {
            ArrayList<TbRichTextData> QB = bvK.QB();
            if (!v.E(QB)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = QB.get(QB.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.z(postData.getTime());
                        if (QB.size() > 1) {
                            if ((QB.get(QB.size() + (-2)) != null ? QB.get(QB.size() - 2).getType() : -1) != type) {
                                str2 = am.z(postData.getTime());
                                QI2 = tbRichTextData2.QI();
                                if (bvK.hasAppendTime && QI2 != 0 && bvK.appendLength <= QI2.length()) {
                                    QI2.delete(QI2.length() - bvK.appendLength, QI2.length());
                                }
                                String ea = am.ea(str2);
                                if (QI2 != null) {
                                    QI2.append((CharSequence) ea);
                                }
                                bvK.hasAppendTime = true;
                                bvK.appendLength = ea.length();
                                tbRichTextData = tbRichTextData2;
                                str = ea;
                            }
                        }
                        str2 = str3;
                        QI2 = tbRichTextData2.QI();
                        if (bvK.hasAppendTime) {
                            QI2.delete(QI2.length() - bvK.appendLength, QI2.length());
                        }
                        String ea2 = am.ea(str2);
                        if (QI2 != null) {
                        }
                        bvK.hasAppendTime = true;
                        bvK.appendLength = ea2.length();
                        tbRichTextData = tbRichTextData2;
                        str = ea2;
                    } else if (bvK.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String z2 = am.z(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.ea(z2);
                        tbRichTextData.append(str);
                        bvK.hasAppendTime = true;
                        bvK.appendLength = str.length();
                        QB.add(tbRichTextData);
                    }
                    SpannableStringBuilder QI3 = tbRichTextData.QI();
                    if (QI3 != null && str.length() <= QI3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0107d.cp_cont_d));
                        QI3.setSpan(absoluteSizeSpan, QI3.length() - str.length(), QI3.length(), 33);
                        QI3.setSpan(foregroundColorSpan, QI3.length() - str.length(), QI3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = QB.get(QB.size() - 1);
                if (bvK.hasAppendTime && tbRichTextData3 != null && (QI = tbRichTextData3.QI()) != null && bvK.appendLength <= QI.length()) {
                    QI.delete(QI.length() - bvK.appendLength, QI.length());
                }
                bvK.hasAppendTime = false;
                bvK.appendLength = 0;
            }
        }
    }

    public void kU(boolean z) {
        this.fWW = z;
    }

    public void kV(boolean z) {
        this.bqx = z;
    }

    public void qu(String str) {
        this.mPostId = str;
    }
}
