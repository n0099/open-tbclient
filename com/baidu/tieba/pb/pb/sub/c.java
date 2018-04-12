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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private bd bjU;
    protected Context mContext;
    protected ArrayList<PostData> adv = null;
    protected View.OnClickListener fuI = null;
    protected int fuJ = 0;
    protected boolean fuK = false;
    protected boolean fuL = false;
    protected boolean cxD = false;
    private boolean mIsFromCDN = true;
    private boolean fuM = false;
    private boolean aDj = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public c(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qJ(int i) {
        this.mSelectedPosition = i;
    }

    public int qP(String str) {
        if (this.adv == null) {
            return -1;
        }
        int size = this.adv.size();
        for (int i = 0; i < size; i++) {
            if (this.adv.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void T(bd bdVar) {
        this.bjU = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.adv = new ArrayList<>();
        } else {
            this.adv = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.fuI = onClickListener;
    }

    public void B(int i, boolean z) {
        this.fuJ = i;
        this.fuK = z;
    }

    public void setHasMoreData(boolean z) {
        this.cxD = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.adv == null) {
            return 0;
        }
        return this.adv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.adv == null || i < 0 || i >= this.adv.size()) {
            return null;
        }
        return this.adv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view2 == null) {
            if (postData.getType() == PostData.gwy) {
                view2 = bbM();
            } else {
                view2 = kA();
            }
        }
        if ((view2.getTag() instanceof a) && postData.getType() != PostData.gwy) {
            view2 = kA();
        }
        if ((view2.getTag() instanceof SparseArray) && postData.getType() == PostData.gwy) {
            view2 = bbM();
        }
        if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cxD && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view2.getTag() instanceof a) {
            ((a) view2.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view2;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView bXW;
        public TbRichTextView fiN;
        public LinearLayout fuP;
        public View fuQ;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View bam;
        public TextView fuN;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view2) {
            this.mRootView = view2;
            this.bam = view2.findViewById(d.g.divider_line);
            this.fuN = (TextView) view2.findViewById(d.g.center_reply_text);
            this.fuN.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ak.j(this.bam, d.C0126d.cp_cont_d);
                ak.h(this.fuN, d.C0126d.cp_cont_d);
                ak.j(this.fuN, d.C0126d.cp_bg_line_d);
                this.fuN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.u(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bbM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kA() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fuP = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fuM) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fuP.getLayoutParams();
            layoutParams.topMargin = l.e(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
            bVar.fuP.setLayoutParams(layoutParams);
        }
        bVar.bXW = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fiN = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fuQ = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fiN.getLayoutStrategy().setSupportNoImage();
        if (!this.fuM) {
            bVar.fiN.getLayoutStrategy().setLineSpacing(l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fiN.getLayoutStrategy().fT(0);
            bVar.fiN.getLayoutStrategy().fR(l.e(this.mContext, d.e.tbds20));
            bVar.fiN.getLayoutStrategy().fS(l.e(this.mContext, d.e.tbds3));
        }
        bVar.fiN.setSubPbPost(true);
        bVar.fiN.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        bVar.fiN.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fiN.setTextCenter(true);
        bVar.bXW.setOnClickListener(this.fuI);
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
                ak.j(bVar.rootView, d.C0126d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bsa()) {
                bVar.fuQ.setVisibility(0);
            } else {
                bVar.fuQ.setVisibility(8);
            }
            bVar.fiN.setPadding(0, 0, 0, 0);
            if (postData.rQ() != null) {
                String name_show = postData.rQ().getName_show();
                String userId = postData.rQ().getUserId();
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
            bVar.fiN.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            bVar.fiN.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
            a(postData, this.fuM);
            TbRichText bsb = postData.bsb();
            if (bsb != null) {
                bVar.fiN.setVoiceViewRes(d.i.voice_play_btn_new);
                bVar.fiN.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bsb.isChanged = true;
                }
                bVar.fiN.setText(bsb);
            }
            String userId2 = postData.rQ().getUserId();
            if (this.fuJ != 0) {
                boolean z9 = this.fuJ != 1002;
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
            if (!this.fuK) {
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
            bVar.bXW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bXW.setText("");
            bVar.bXW.setContentDescription("");
            ak.h(bVar.bXW, d.C0126d.cp_link_tip_c);
            if (z5) {
                bVar.bXW.setVisibility(0);
                bVar.bXW.setText(this.mContext.getString(d.k.manage));
                bVar.bXW.setContentDescription(this.mContext.getString(d.k.manage));
            } else if (z6) {
                bVar.bXW.setVisibility(0);
                bVar.bXW.setText(this.mContext.getString(d.k.mute));
                bVar.bXW.setContentDescription(this.mContext.getString(d.k.mute));
            } else if (z8) {
                bVar.bXW.setVisibility(0);
                if (this.fuJ == 1002 && !z7) {
                    bVar.bXW.setText(this.mContext.getString(d.k.report_text));
                } else {
                    bVar.bXW.setText(this.mContext.getString(d.k.delete));
                }
            } else {
                bVar.bXW.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bXW.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bXW.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fuJ));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.rQ().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bjU != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.rQ() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rQ().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rQ().getUserName());
                    }
                    if (this.bjU.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bjU.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fuJ));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fuM && z2 && this.aDj) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fuP.getLayoutParams();
                layoutParams.topMargin = l.e(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fuP.setLayoutParams(layoutParams);
            }
            if (this.fuM && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fuP.getLayoutParams();
                layoutParams2.topMargin = l.e(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fuP.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bsb;
        SpannableStringBuilder JQ;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder JQ2;
        if (postData != null && (bsb = postData.bsb()) != null) {
            ArrayList<TbRichTextData> JJ = bsb.JJ();
            if (!v.w(JJ)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = JJ.get(JJ.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + an.s(postData.getTime());
                        if (JJ.size() > 1) {
                            if ((JJ.get(JJ.size() + (-2)) != null ? JJ.get(JJ.size() - 2).getType() : -1) != type) {
                                str2 = an.s(postData.getTime());
                                JQ2 = tbRichTextData2.JQ();
                                if (bsb.hasAppendTime && JQ2 != 0 && bsb.appendLength <= JQ2.length()) {
                                    JQ2.delete(JQ2.length() - bsb.appendLength, JQ2.length());
                                }
                                String ei = an.ei(str2);
                                if (JQ2 != null) {
                                    JQ2.append((CharSequence) ei);
                                }
                                bsb.hasAppendTime = true;
                                bsb.appendLength = ei.length();
                                tbRichTextData = tbRichTextData2;
                                str = ei;
                            }
                        }
                        str2 = str3;
                        JQ2 = tbRichTextData2.JQ();
                        if (bsb.hasAppendTime) {
                            JQ2.delete(JQ2.length() - bsb.appendLength, JQ2.length());
                        }
                        String ei2 = an.ei(str2);
                        if (JQ2 != null) {
                        }
                        bsb.hasAppendTime = true;
                        bsb.appendLength = ei2.length();
                        tbRichTextData = tbRichTextData2;
                        str = ei2;
                    } else if (bsb.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String s = an.s(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = an.ei(s);
                        tbRichTextData.append(str);
                        bsb.hasAppendTime = true;
                        bsb.appendLength = str.length();
                        JJ.add(tbRichTextData);
                    }
                    SpannableStringBuilder JQ3 = tbRichTextData.JQ();
                    if (JQ3 != null && str.length() <= JQ3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_d));
                        JQ3.setSpan(absoluteSizeSpan, JQ3.length() - str.length(), JQ3.length(), 33);
                        JQ3.setSpan(foregroundColorSpan, JQ3.length() - str.length(), JQ3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = JJ.get(JJ.size() - 1);
                if (bsb.hasAppendTime && tbRichTextData3 != null && (JQ = tbRichTextData3.JQ()) != null && bsb.appendLength <= JQ.length()) {
                    JQ.delete(JQ.length() - bsb.appendLength, JQ.length());
                }
                bsb.hasAppendTime = false;
                bsb.appendLength = 0;
            }
        }
    }

    public void kH(boolean z) {
        this.fuM = z;
    }

    public void kI(boolean z) {
        this.aDj = z;
    }

    public void qQ(String str) {
        this.mPostId = str;
    }
}
