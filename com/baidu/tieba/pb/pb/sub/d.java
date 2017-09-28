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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private bh bit;
    protected Context mContext;
    protected ArrayList<PostData> abP = null;
    protected View.OnClickListener eRI = null;
    protected int eRJ = 0;
    protected boolean eRK = false;
    protected boolean eDZ = false;
    protected boolean bTo = false;
    private boolean mIsFromCDN = true;
    private boolean eRL = false;
    private boolean eQR = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pK(int i) {
        this.mSelectedPosition = i;
    }

    public int pl(String str) {
        if (this.abP == null) {
            return -1;
        }
        int size = this.abP.size();
        for (int i = 0; i < size; i++) {
            if (this.abP.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void U(bh bhVar) {
        this.bit = bhVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.abP = new ArrayList<>();
        } else {
            this.abP = arrayList;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        this.eRI = onClickListener;
    }

    public void x(int i, boolean z) {
        this.eRJ = i;
        this.eRK = z;
    }

    public void setHasMoreData(boolean z) {
        this.bTo = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abP == null) {
            return 0;
        }
        return this.abP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abP == null || i < 0 || i >= this.abP.size()) {
            return null;
        }
        return this.abP.get(i);
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
            if (postData.getType() == PostData.ggS) {
                view = aTC();
            } else {
                view = ld();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.ggS) {
            view = ld();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.ggS) {
            view = aTC();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bTo && i + 1 >= getCount();
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

    /* loaded from: classes.dex */
    public class b {
        public TextView bAv;
        public TbRichTextView eAA;
        public LinearLayout eRO;
        public View eRP;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aWX;
        public TextView eRM;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aWX = view.findViewById(d.h.divider_line);
            this.eRM = (TextView) view.findViewById(d.h.center_reply_text);
            this.eRM.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.aWX, d.e.cp_cont_d);
                aj.i(this.eRM, d.e.cp_cont_d);
                aj.k(this.eRM, d.e.cp_bg_line_d);
                this.eRM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aTC() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View ld() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eRO = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eRL) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eRO.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.f.ds8);
            bVar.eRO.setLayoutParams(layoutParams);
        }
        bVar.bAv = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eAA = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eRP = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eAA.Jt();
        bVar.eAA.setSubPbPost(true);
        bVar.eAA.setTextColor(aj.getColor(d.e.cp_cont_f));
        bVar.eAA.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eAA.setTextCenter(true);
        bVar.bAv.setOnClickListener(this.eRI);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_holder, bVar);
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
                aj.k(bVar.rootView, d.e.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.brz()) {
                bVar.eRP.setVisibility(0);
            } else {
                bVar.eRP.setVisibility(8);
            }
            bVar.eAA.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_photo_username, name_show);
                sparseArray.put(d.h.tag_photo_userid, userId);
                sparseArray.put(d.h.tag_clip_board, postData);
                sparseArray.put(d.h.tag_is_subpb, true);
            }
            bVar.eAA.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            bVar.eAA.setTextColor(aj.getColor(d.e.cp_cont_f));
            a(postData, this.eRL);
            TbRichText aCd = postData.aCd();
            if (aCd != null) {
                bVar.eAA.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eAA.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aCd.isChanged = true;
                }
                bVar.eAA.setText(aCd);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eRJ != 0) {
                boolean z9 = this.eRJ != 1002;
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
            if (!this.eRK) {
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
            bVar.bAv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bAv.setText("");
            bVar.bAv.setContentDescription("");
            aj.i(bVar.bAv, d.e.cp_link_tip_c);
            if (z5) {
                bVar.bAv.setVisibility(0);
                bVar.bAv.setText(this.mContext.getString(d.l.manage));
                bVar.bAv.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.bAv.setVisibility(0);
                bVar.bAv.setText(this.mContext.getString(d.l.mute));
                bVar.bAv.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.bAv.setVisibility(0);
                if (this.eRJ == 1002 && !z7) {
                    bVar.bAv.setText(this.mContext.getString(d.l.report_text));
                } else {
                    bVar.bAv.setText(this.mContext.getString(d.l.delete));
                }
            } else {
                bVar.bAv.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bAv.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bAv.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eRJ));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bit != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bit.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bit.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eRJ));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eRL && z2 && this.eQR) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eRO.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.f.ds8);
                bVar.eRO.setLayoutParams(layoutParams);
            }
            if (this.eRL && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eRO.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.f.ds8);
                bVar.eRO.setLayoutParams(layoutParams2);
            }
            if (this.eRL) {
                bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), l.f(this.mContext, d.f.ds12));
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aCd;
        SpannableStringBuilder IK;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder IK2;
        if (postData != null && (aCd = postData.aCd()) != null) {
            ArrayList<TbRichTextData> ID = aCd.ID();
            if (!v.u(ID)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = ID.get(ID.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.q(postData.getTime());
                        if (ID.size() > 1) {
                            if ((ID.get(ID.size() + (-2)) != null ? ID.get(ID.size() - 2).getType() : -1) != type) {
                                str2 = am.q(postData.getTime());
                                IK2 = tbRichTextData2.IK();
                                if (aCd.hasAppendTime && IK2 != 0 && aCd.appendLength <= IK2.length()) {
                                    IK2.delete(IK2.length() - aCd.appendLength, IK2.length());
                                }
                                String dM = am.dM(str2);
                                if (IK2 != null) {
                                    IK2.append((CharSequence) dM);
                                }
                                aCd.hasAppendTime = true;
                                aCd.appendLength = dM.length();
                                tbRichTextData = tbRichTextData2;
                                str = dM;
                            }
                        }
                        str2 = str3;
                        IK2 = tbRichTextData2.IK();
                        if (aCd.hasAppendTime) {
                            IK2.delete(IK2.length() - aCd.appendLength, IK2.length());
                        }
                        String dM2 = am.dM(str2);
                        if (IK2 != null) {
                        }
                        aCd.hasAppendTime = true;
                        aCd.appendLength = dM2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dM2;
                    } else if (aCd.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String q = am.q(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dM(q);
                        tbRichTextData.append(str);
                        aCd.hasAppendTime = true;
                        aCd.appendLength = str.length();
                        ID.add(tbRichTextData);
                    }
                    SpannableStringBuilder IK3 = tbRichTextData.IK();
                    if (IK3 != null && str.length() <= IK3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.e.cp_cont_d));
                        IK3.setSpan(absoluteSizeSpan, IK3.length() - str.length(), IK3.length(), 33);
                        IK3.setSpan(foregroundColorSpan, IK3.length() - str.length(), IK3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = ID.get(ID.size() - 1);
                if (aCd.hasAppendTime && tbRichTextData3 != null && (IK = tbRichTextData3.IK()) != null && aCd.appendLength <= IK.length()) {
                    IK.delete(IK.length() - aCd.appendLength, IK.length());
                }
                aCd.hasAppendTime = false;
                aCd.appendLength = 0;
            }
        }
    }

    public void jR(boolean z) {
        this.eRL = z;
    }

    public void jS(boolean z) {
        this.eQR = z;
    }

    public void pm(String str) {
        this.mPostId = str;
    }
}
