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
    private bd bkk;
    protected Context mContext;
    protected ArrayList<PostData> adv = null;
    protected View.OnClickListener fvL = null;
    protected int fvM = 0;
    protected boolean fvN = false;
    protected boolean fvO = false;
    protected boolean cyJ = false;
    private boolean mIsFromCDN = true;
    private boolean fvP = false;
    private boolean aDk = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public c(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qH(int i) {
        this.mSelectedPosition = i;
    }

    public int qS(String str) {
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
        this.bkk = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.adv = new ArrayList<>();
        } else {
            this.adv = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.fvL = onClickListener;
    }

    public void B(int i, boolean z) {
        this.fvM = i;
        this.fvN = z;
    }

    public void setHasMoreData(boolean z) {
        this.cyJ = z;
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
            if (postData.getType() == PostData.gxz) {
                view2 = bbM();
            } else {
                view2 = kz();
            }
        }
        if ((view2.getTag() instanceof a) && postData.getType() != PostData.gxz) {
            view2 = kz();
        }
        if ((view2.getTag() instanceof SparseArray) && postData.getType() == PostData.gxz) {
            view2 = bbM();
        }
        if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cyJ && i + 1 >= getCount();
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
        public TextView bYS;
        public TbRichTextView fjR;
        public LinearLayout fvS;
        public View fvT;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public View ban;
        public TextView fvQ;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view2) {
            this.mRootView = view2;
            this.ban = view2.findViewById(d.g.divider_line);
            this.fvQ = (TextView) view2.findViewById(d.g.center_reply_text);
            this.fvQ.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ak.j(this.ban, d.C0126d.cp_cont_d);
                ak.h(this.fvQ, d.C0126d.cp_cont_d);
                ak.j(this.fvQ, d.C0126d.cp_bg_line_d);
                this.fvQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.u(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bbM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kz() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fvS = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fvP) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fvS.getLayoutParams();
            layoutParams.topMargin = l.e(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
            bVar.fvS.setLayoutParams(layoutParams);
        }
        bVar.bYS = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fjR = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fvT = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fjR.getLayoutStrategy().setSupportNoImage();
        if (!this.fvP) {
            bVar.fjR.getLayoutStrategy().setLineSpacing(l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fjR.getLayoutStrategy().fT(0);
            bVar.fjR.getLayoutStrategy().fR(l.e(this.mContext, d.e.tbds20));
            bVar.fjR.getLayoutStrategy().fS(l.e(this.mContext, d.e.tbds3));
        }
        bVar.fjR.setSubPbPost(true);
        bVar.fjR.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        bVar.fjR.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fjR.setTextCenter(true);
        bVar.bYS.setOnClickListener(this.fvL);
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
            if (postData.brY()) {
                bVar.fvT.setVisibility(0);
            } else {
                bVar.fvT.setVisibility(8);
            }
            bVar.fjR.setPadding(0, 0, 0, 0);
            if (postData.rP() != null) {
                String name_show = postData.rP().getName_show();
                String userId = postData.rP().getUserId();
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
            bVar.fjR.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            bVar.fjR.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
            a(postData, this.fvP);
            TbRichText brZ = postData.brZ();
            if (brZ != null) {
                bVar.fjR.setVoiceViewRes(d.i.voice_play_btn_new);
                bVar.fjR.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    brZ.isChanged = true;
                }
                bVar.fjR.setText(brZ);
            }
            String userId2 = postData.rP().getUserId();
            if (this.fvM != 0) {
                boolean z9 = this.fvM != 1002;
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
            if (!this.fvN) {
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
            bVar.bYS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bYS.setText("");
            bVar.bYS.setContentDescription("");
            ak.h(bVar.bYS, d.C0126d.cp_link_tip_c);
            if (z5) {
                bVar.bYS.setVisibility(0);
                bVar.bYS.setText(this.mContext.getString(d.k.manage));
                bVar.bYS.setContentDescription(this.mContext.getString(d.k.manage));
            } else if (z6) {
                bVar.bYS.setVisibility(0);
                bVar.bYS.setText(this.mContext.getString(d.k.mute));
                bVar.bYS.setContentDescription(this.mContext.getString(d.k.mute));
            } else if (z8) {
                bVar.bYS.setVisibility(0);
                if (this.fvM == 1002 && !z7) {
                    bVar.bYS.setText(this.mContext.getString(d.k.report_text));
                } else {
                    bVar.bYS.setText(this.mContext.getString(d.k.delete));
                }
            } else {
                bVar.bYS.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bYS.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bYS.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fvM));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.rP().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bkk != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.rP() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rP().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rP().getUserName());
                    }
                    if (this.bkk.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bkk.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fvM));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fvP && z2 && this.aDk) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fvS.getLayoutParams();
                layoutParams.topMargin = l.e(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fvS.setLayoutParams(layoutParams);
            }
            if (this.fvP && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fvS.getLayoutParams();
                layoutParams2.topMargin = l.e(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fvS.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText brZ;
        SpannableStringBuilder JO;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder JO2;
        if (postData != null && (brZ = postData.brZ()) != null) {
            ArrayList<TbRichTextData> JH = brZ.JH();
            if (!v.w(JH)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = JH.get(JH.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + an.s(postData.getTime());
                        if (JH.size() > 1) {
                            if ((JH.get(JH.size() + (-2)) != null ? JH.get(JH.size() - 2).getType() : -1) != type) {
                                str2 = an.s(postData.getTime());
                                JO2 = tbRichTextData2.JO();
                                if (brZ.hasAppendTime && JO2 != 0 && brZ.appendLength <= JO2.length()) {
                                    JO2.delete(JO2.length() - brZ.appendLength, JO2.length());
                                }
                                String ei = an.ei(str2);
                                if (JO2 != null) {
                                    JO2.append((CharSequence) ei);
                                }
                                brZ.hasAppendTime = true;
                                brZ.appendLength = ei.length();
                                tbRichTextData = tbRichTextData2;
                                str = ei;
                            }
                        }
                        str2 = str3;
                        JO2 = tbRichTextData2.JO();
                        if (brZ.hasAppendTime) {
                            JO2.delete(JO2.length() - brZ.appendLength, JO2.length());
                        }
                        String ei2 = an.ei(str2);
                        if (JO2 != null) {
                        }
                        brZ.hasAppendTime = true;
                        brZ.appendLength = ei2.length();
                        tbRichTextData = tbRichTextData2;
                        str = ei2;
                    } else if (brZ.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String s = an.s(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = an.ei(s);
                        tbRichTextData.append(str);
                        brZ.hasAppendTime = true;
                        brZ.appendLength = str.length();
                        JH.add(tbRichTextData);
                    }
                    SpannableStringBuilder JO3 = tbRichTextData.JO();
                    if (JO3 != null && str.length() <= JO3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_d));
                        JO3.setSpan(absoluteSizeSpan, JO3.length() - str.length(), JO3.length(), 33);
                        JO3.setSpan(foregroundColorSpan, JO3.length() - str.length(), JO3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = JH.get(JH.size() - 1);
                if (brZ.hasAppendTime && tbRichTextData3 != null && (JO = tbRichTextData3.JO()) != null && brZ.appendLength <= JO.length()) {
                    JO.delete(JO.length() - brZ.appendLength, JO.length());
                }
                brZ.hasAppendTime = false;
                brZ.appendLength = 0;
            }
        }
    }

    public void kI(boolean z) {
        this.fvP = z;
    }

    public void kJ(boolean z) {
        this.aDk = z;
    }

    public void qT(String str) {
        this.mPostId = str;
    }
}
