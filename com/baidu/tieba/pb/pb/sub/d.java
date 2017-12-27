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
import com.baidu.tbadk.core.data.be;
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
    private be bXF;
    protected Context mContext;
    protected ArrayList<PostData> aQH = null;
    protected View.OnClickListener fVs = null;
    protected int fVt = 0;
    protected boolean fVu = false;
    protected boolean fVv = false;
    protected boolean cYl = false;
    private boolean mIsFromCDN = true;
    private boolean fVw = false;
    private boolean bqo = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void tp(int i) {
        this.mSelectedPosition = i;
    }

    public int qr(String str) {
        if (this.aQH == null) {
            return -1;
        }
        int size = this.aQH.size();
        for (int i = 0; i < size; i++) {
            if (this.aQH.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void Q(be beVar) {
        this.bXF = beVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.aQH = new ArrayList<>();
        } else {
            this.aQH = arrayList;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        this.fVs = onClickListener;
    }

    public void J(int i, boolean z) {
        this.fVt = i;
        this.fVu = z;
    }

    public void setHasMoreData(boolean z) {
        this.cYl = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQH == null) {
            return 0;
        }
        return this.aQH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aQH == null || i < 0 || i >= this.aQH.size()) {
            return null;
        }
        return this.aQH.get(i);
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
            if (postData.getType() == PostData.hiL) {
                view = bfe();
            } else {
                view = su();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.hiL) {
            view = su();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.hiL) {
            view = bfe();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cYl && i + 1 >= getCount();
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
        public TextView cDJ;
        public TbRichTextView fDU;
        public View fVA;
        public LinearLayout fVz;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bOc;
        public TextView fVx;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bOc = view.findViewById(d.g.divider_line);
            this.fVx = (TextView) view.findViewById(d.g.center_reply_text);
            this.fVx.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.t(this.bOc, d.C0108d.cp_cont_d);
                aj.r(this.fVx, d.C0108d.cp_cont_d);
                aj.t(this.fVx, d.C0108d.cp_bg_line_d);
                this.fVx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.au(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bfe() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View su() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fVz = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fVw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fVz.getLayoutParams();
            layoutParams.topMargin = l.s(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.s(this.mContext, d.e.ds8);
            bVar.fVz.setLayoutParams(layoutParams);
        }
        bVar.cDJ = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fDU = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fVA = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fDU.getLayoutStrategy().QM();
        if (!this.fVw) {
            bVar.fDU.getLayoutStrategy().setLineSpacing(l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fDU.getLayoutStrategy().iZ(0);
            bVar.fDU.getLayoutStrategy().iX(l.s(this.mContext, d.e.tbds20));
            bVar.fDU.getLayoutStrategy().iY(l.s(this.mContext, d.e.tbds3));
        }
        bVar.fDU.setSubPbPost(true);
        bVar.fDU.setTextColor(aj.getColor(d.C0108d.cp_cont_f));
        bVar.fDU.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fDU.setTextCenter(true);
        bVar.cDJ.setOnClickListener(this.fVs);
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
            if (postData.bCm()) {
                bVar.fVA.setVisibility(0);
            } else {
                bVar.fVA.setVisibility(8);
            }
            bVar.fDU.setPadding(0, 0, 0, 0);
            if (postData.yX() != null) {
                String name_show = postData.yX().getName_show();
                String userId = postData.yX().getUserId();
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
            bVar.fDU.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            bVar.fDU.setTextColor(aj.getColor(d.C0108d.cp_cont_f));
            a(postData, this.fVw);
            TbRichText bCo = postData.bCo();
            if (bCo != null) {
                bVar.fDU.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fDU.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bCo.isChanged = true;
                }
                bVar.fDU.setText(bCo);
            }
            String userId2 = postData.yX().getUserId();
            if (this.fVt != 0) {
                boolean z9 = this.fVt != 1002;
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
            if (!this.fVu) {
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
            bVar.cDJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cDJ.setText("");
            bVar.cDJ.setContentDescription("");
            aj.r(bVar.cDJ, d.C0108d.cp_link_tip_c);
            if (z5) {
                bVar.cDJ.setVisibility(0);
                bVar.cDJ.setText(this.mContext.getString(d.j.manage));
                bVar.cDJ.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.cDJ.setVisibility(0);
                bVar.cDJ.setText(this.mContext.getString(d.j.mute));
                bVar.cDJ.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.cDJ.setVisibility(0);
                if (this.fVt == 1002 && !z7) {
                    bVar.cDJ.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.cDJ.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.cDJ.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cDJ.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cDJ.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fVt));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.yX().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bXF != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yX() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.yX().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.yX().getUserName());
                    }
                    if (this.bXF.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bXF.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fVt));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fVw && z2 && this.bqo) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fVz.getLayoutParams();
                layoutParams.topMargin = l.s(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.s(this.mContext, d.e.ds8);
                bVar.fVz.setLayoutParams(layoutParams);
            }
            if (this.fVw && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fVz.getLayoutParams();
                layoutParams2.topMargin = l.s(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.s(this.mContext, d.e.ds8);
                bVar.fVz.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bCo;
        SpannableStringBuilder QU;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder QU2;
        if (postData != null && (bCo = postData.bCo()) != null) {
            ArrayList<TbRichTextData> QN = bCo.QN();
            if (!v.G(QN)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = QN.get(QN.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.z(postData.getTime());
                        if (QN.size() > 1) {
                            if ((QN.get(QN.size() + (-2)) != null ? QN.get(QN.size() - 2).getType() : -1) != type) {
                                str2 = am.z(postData.getTime());
                                QU2 = tbRichTextData2.QU();
                                if (bCo.hasAppendTime && QU2 != 0 && bCo.appendLength <= QU2.length()) {
                                    QU2.delete(QU2.length() - bCo.appendLength, QU2.length());
                                }
                                String ea = am.ea(str2);
                                if (QU2 != null) {
                                    QU2.append((CharSequence) ea);
                                }
                                bCo.hasAppendTime = true;
                                bCo.appendLength = ea.length();
                                tbRichTextData = tbRichTextData2;
                                str = ea;
                            }
                        }
                        str2 = str3;
                        QU2 = tbRichTextData2.QU();
                        if (bCo.hasAppendTime) {
                            QU2.delete(QU2.length() - bCo.appendLength, QU2.length());
                        }
                        String ea2 = am.ea(str2);
                        if (QU2 != null) {
                        }
                        bCo.hasAppendTime = true;
                        bCo.appendLength = ea2.length();
                        tbRichTextData = tbRichTextData2;
                        str = ea2;
                    } else if (bCo.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String z2 = am.z(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.ea(z2);
                        tbRichTextData.append(str);
                        bCo.hasAppendTime = true;
                        bCo.appendLength = str.length();
                        QN.add(tbRichTextData);
                    }
                    SpannableStringBuilder QU3 = tbRichTextData.QU();
                    if (QU3 != null && str.length() <= QU3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0108d.cp_cont_d));
                        QU3.setSpan(absoluteSizeSpan, QU3.length() - str.length(), QU3.length(), 33);
                        QU3.setSpan(foregroundColorSpan, QU3.length() - str.length(), QU3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = QN.get(QN.size() - 1);
                if (bCo.hasAppendTime && tbRichTextData3 != null && (QU = tbRichTextData3.QU()) != null && bCo.appendLength <= QU.length()) {
                    QU.delete(QU.length() - bCo.appendLength, QU.length());
                }
                bCo.hasAppendTime = false;
                bCo.appendLength = 0;
            }
        }
    }

    public void kR(boolean z) {
        this.fVw = z;
    }

    public void kS(boolean z) {
        this.bqo = z;
    }

    public void qs(String str) {
        this.mPostId = str;
    }
}
